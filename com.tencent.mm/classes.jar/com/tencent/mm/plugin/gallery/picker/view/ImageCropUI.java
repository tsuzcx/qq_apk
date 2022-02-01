package com.tencent.mm.plugin.gallery.picker.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.af.a;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.i;
import d.g;
import d.g.a.m;
import d.g.a.q;
import d.g.b.u;
import d.g.b.v.f;
import d.g.b.w;
import d.y;
import java.io.IOException;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backupPath", "", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "cancelCropButton", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getCancelCropButton", "()Landroid/widget/Button;", "cancelCropButton$delegate", "Lkotlin/Lazy;", "confirmCropButton", "getConfirmCropButton", "confirmCropButton$delegate", "cropImgMode", "", "getCropImgMode", "()I", "cropImgMode$delegate", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "cropOperateLayout", "Landroid/widget/LinearLayout;", "getCropOperateLayout", "()Landroid/widget/LinearLayout;", "cropOperateLayout$delegate", "cropping", "", "defaultImageContentCreator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "degree", "displayBitmap", "Landroid/graphics/Bitmap;", "getDisplayBitmap", "()Landroid/graphics/Bitmap;", "setDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "emojiBmp", "imageLoaded", "imgPath", "getImgPath", "imgPath$delegate", "isGif", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mattingImageInfo", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "outputPath", "getOutputPath", "outputPath$delegate", "previewMatting", "getPreviewMatting", "()Lkotlin/jvm/functions/Function3;", "previewView", "getPreviewView", "()Landroid/widget/ImageView;", "previewView$delegate", "rotateButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRotateButton", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rotateButton$delegate", "undoButton", "getUndoButton", "undoButton$delegate", "backgroundCrop", "", "compressMattingImage", "source", "cropAvatar", "getCropBackImg", "getCropMatrix", "Landroid/graphics/Matrix;", "imgWidth", "imgHeight", "scrWidth", "scrHeight", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getFullVisibilityRect", "w", "h", "getImageInfo", "imagePath", "getLayoutId", "initMMView", "initMattingCropLayout", "initShowView", "loadBackgroundPreviewImg", "loadPreview", "mattingCrop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "previewCrop", "compress", "saveImg", "bm", "recycle", "setRequestedOrientation", "requestedOrientation", "showLoadingDialog", "Companion", "plugin-gallery_release"})
public final class ImageCropUI
  extends MMActivity
{
  public static final ImageCropUI.a sNm;
  private p fxw;
  private final d.f rIf;
  private com.tencent.mm.plugin.gallery.picker.b.b rIu;
  private final d.f sMT;
  private final d.f sMU;
  private final d.f sMV;
  private final d.f sMW;
  private final d.f sMX;
  private final d.f sMY;
  private final d.f sMZ;
  private final d.f sNa;
  private String sNb;
  Bitmap sNc;
  private final d.f sNd;
  private boolean sNe;
  private int sNf;
  private boolean sNg;
  private int[] sNh;
  private Bitmap sNi;
  private boolean sNj;
  final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> sNk;
  private final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> sNl;
  
  static
  {
    AppMethodBeat.i(198484);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "cropLayout", "getCropLayout()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "previewView", "getPreviewView()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "cropOperateLayout", "getCropOperateLayout()Landroid/widget/LinearLayout;")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "cancelCropButton", "getCancelCropButton()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "confirmCropButton", "getConfirmCropButton()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "undoButton", "getUndoButton()Lcom/tencent/mm/ui/widget/imageview/WeImageView;")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "rotateButton", "getRotateButton()Lcom/tencent/mm/ui/widget/imageview/WeImageView;")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "imgPath", "getImgPath()Ljava/lang/String;")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "cropImgMode", "getCropImgMode()I")), (d.l.k)w.a(new u(w.bn(ImageCropUI.class), "outputPath", "getOutputPath()Ljava/lang/String;")) };
    sNm = new ImageCropUI.a((byte)0);
    AppMethodBeat.o(198484);
  }
  
  public ImageCropUI()
  {
    AppMethodBeat.i(198498);
    this.rIf = g.K((d.g.a.a)new g(this));
    this.sMT = g.K((d.g.a.a)new x(this));
    this.sMU = g.K((d.g.a.a)new h(this));
    this.sMV = g.K((d.g.a.a)new c(this));
    this.sMW = g.K((d.g.a.a)new d(this));
    this.sMX = g.K((d.g.a.a)new z(this));
    this.sMY = g.K((d.g.a.a)new y(this));
    this.sMZ = g.K((d.g.a.a)new j(this));
    this.sNa = g.K((d.g.a.a)new f(this));
    this.sNb = "";
    this.sNd = g.K((d.g.a.a)new v(this));
    this.sNk = ((q)new w(this));
    this.sNl = ((q)new i(this));
    AppMethodBeat.o(198498);
  }
  
  private final String TD()
  {
    AppMethodBeat.i(198487);
    String str = (String)this.sMZ.getValue();
    AppMethodBeat.o(198487);
    return str;
  }
  
  private static boolean a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(198494);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(198494);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
      ac.i("MicroMsg.AvatarCropUI", "saveBitmapToImage successful ");
      AppMethodBeat.o(198494);
      return true;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.AvatarCropUI", (Throwable)paramString, "", new Object[0]);
      ac.e("MicroMsg.AvatarCropUI", "saveBitmapToImage failed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(198494);
    }
    return false;
  }
  
  private final void aOL()
  {
    AppMethodBeat.i(198496);
    p localp = this.fxw;
    if (localp != null) {
      localp.dismiss();
    }
    this.fxw = p.a((Context)this, (CharSequence)getString(2131760709), false, 0, null);
    AppMethodBeat.o(198496);
  }
  
  private final RectF cBF()
  {
    AppMethodBeat.i(198497);
    Object localObject = getContext();
    d.g.b.k.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    d.g.b.k.g(localObject, "context.resources");
    float f1 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    f1 -= ((AppCompatActivity)localObject).getResources().getDimension(2131165298);
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    d.g.b.k.g(localObject, "context.resources");
    float f2 = (((Resources)localObject).getDisplayMetrics().heightPixels - f1) / 2.0F;
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165292);
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    localObject = new RectF(f3, f2, ((AppCompatActivity)localObject).getResources().getDimension(2131165292) + f1, f1 + f2);
    AppMethodBeat.o(198497);
    return localObject;
  }
  
  private final WxMediaCropLayout cBP()
  {
    AppMethodBeat.i(198485);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.rIf.getValue();
    AppMethodBeat.o(198485);
    return localWxMediaCropLayout;
  }
  
  private final ImageView cNp()
  {
    AppMethodBeat.i(198486);
    ImageView localImageView = (ImageView)this.sMT.getValue();
    AppMethodBeat.o(198486);
    return localImageView;
  }
  
  private final int cNq()
  {
    AppMethodBeat.i(198488);
    int i = ((Number)this.sNa.getValue()).intValue();
    AppMethodBeat.o(198488);
    return i;
  }
  
  private final String cNr()
  {
    AppMethodBeat.i(198489);
    String str = (String)this.sNd.getValue();
    AppMethodBeat.o(198489);
    return str;
  }
  
  private final Bitmap cNs()
  {
    AppMethodBeat.i(198493);
    Object localObject = cNp();
    d.g.b.k.g(localObject, "previewView");
    int i = ((ImageView)localObject).getWidth();
    localObject = cNp();
    d.g.b.k.g(localObject, "previewView");
    localObject = com.tencent.mm.sdk.platformtools.f.createBitmap(i, ((ImageView)localObject).getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject == null)
    {
      localObject = a.sMS;
      a.FU(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(198493);
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    cNp().draw(localCanvas);
    localCanvas.setBitmap(null);
    try
    {
      localObject = com.tencent.mm.sdk.platformtools.f.f((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight() - com.tencent.mm.view.b.e((Context)this, 56.0F));
      AppMethodBeat.o(198493);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      a locala = a.sMS;
      a.FU(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(198493);
    }
    return null;
  }
  
  public final int getLayoutId()
  {
    return 2131496153;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(198492);
    super.onBackPressed();
    Object localObject = this.rIu;
    if (localObject != null) {
      ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).destroy();
    }
    localObject = a.sMS;
    a.FU(9);
    AppMethodBeat.o(198492);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(198490);
    super.onCreate(paramBundle);
    paramBundle = a.sMS;
    a.FU(10);
    setMMTitle("");
    if (cNq() == 1)
    {
      getWindow().setFlags(201327616, 201327616);
      setLightNavigationbarIcon();
      paramBundle = findViewById(2131307208);
      paramBundle.setPadding(0, 0, 0, ap.ej((Context)getContext()));
      paramBundle.post((Runnable)new k(this, paramBundle));
      setActionbarColor(2131101053);
      setActionbarColor(-16777216);
      fullScreenNoTitleBar(true, 0L);
      paramBundle = (LinearLayout)this.sMU.getValue();
      d.g.b.k.g(paramBundle, "cropOperateLayout");
      paramBundle.setVisibility(0);
      ((Button)this.sMV.getValue()).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)this.sMW.getValue()).setOnClickListener((View.OnClickListener)new m(this));
      ((WeImageView)this.sMY.getValue()).setOnClickListener((View.OnClickListener)new n(this));
      ((WeImageView)this.sMX.getValue()).setOnClickListener((View.OnClickListener)new o(this));
      this.sNj = false;
      aOL();
      switch (cNq())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(198490);
      return;
      addTextOptionMenu(0, getString(2131763112), (MenuItem.OnMenuItemClickListener)new p(this), null, s.b.Hom);
      setBackBtn((MenuItem.OnMenuItemClickListener)new q(this));
      break;
      if (getIntent().getIntExtra("CropImage_from_scene", 0) == 3)
      {
        paramBundle = a.sMS;
        a.FU(0);
        ac.i("MicroMsg.AvatarCropUI", "scene avatar");
      }
      for (;;)
      {
        paramBundle = cBP();
        paramBundle.setVisibility(0);
        paramBundle.setShowBorder(false);
        paramBundle.a(cBF(), WxCropOperationLayout.j.wzI);
        WxMediaCropLayout.a(paramBundle, System.currentTimeMillis(), TD(), true, null, this.sNl, 8);
        AppMethodBeat.o(198490);
        return;
        paramBundle = a.sMS;
        a.FU(1);
        ac.i("MicroMsg.AvatarCropUI", "scene cover");
      }
      c.b(null, (d.g.a.a)new t(this));
      AppMethodBeat.o(198490);
      return;
      paramBundle = a.sMS;
      a.FU(2);
      ac.i("MicroMsg.AvatarCropUI", "scene background");
      paramBundle = cNp();
      paramBundle.post((Runnable)new s(paramBundle, this));
      AppMethodBeat.o(198490);
      return;
      paramBundle = a.sMS;
      a.FU(3);
      ac.i("MicroMsg.AvatarCropUI", "scene emoji");
      paramBundle = cBP();
      paramBundle.setVisibility(0);
      paramBundle.setShowBorder(false);
      paramBundle.setCropLayoutScaleType(CropLayout.e.Jeh);
      paramBundle.cNt();
      c.b(null, (d.g.a.a)new r(paramBundle, this));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198491);
    super.onDestroy();
    this.sNc = null;
    if ((!TextUtils.isEmpty((CharSequence)this.sNb)) && (i.eA(this.sNb))) {
      i.deleteFile(this.sNb);
    }
    AppMethodBeat.o(198491);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(210017);
    super.setRequestedOrientation(1);
    AppMethodBeat.o(210017);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Button>
  {
    c(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<Button>
  {
    d(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isSuccessful", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$cropAvatar$1$1$1", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$$special$$inlined$apply$lambda$1"})
  static final class e
    extends d.g.b.l
    implements m<Boolean, b.f, y>
  {
    e(WxMediaCropLayout.b paramb, String paramString, ImageCropUI paramImageCropUI, b.b paramb1)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    f(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<WxMediaCropLayout>
  {
    g(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<LinearLayout>
  {
    h(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, y>
  {
    i(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    j(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(ImageCropUI paramImageCropUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(198457);
      paramBundle.setPadding(0, 0, 0, ap.ej((Context)this.sNn.getContext()));
      AppMethodBeat.o(198457);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198458);
      paramView = a.sMS;
      a.FU(9);
      this.sNn.finish();
      AppMethodBeat.o(198458);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198459);
      ImageCropUI.d(this.sNn);
      AppMethodBeat.o(198459);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198460);
      ImageCropUI.e(this.sNn).getLayout().fve();
      AppMethodBeat.o(198460);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198461);
      ImageCropUI.e(this.sNn).getLayout().fvf();
      AppMethodBeat.o(198461);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198462);
      if (!ImageCropUI.a(this.sNn))
      {
        AppMethodBeat.o(198462);
        return true;
      }
      switch (ImageCropUI.f(this.sNn))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(198462);
        return true;
        ImageCropUI.d(this.sNn);
        continue;
        ImageCropUI.g(this.sNn);
        continue;
        ImageCropUI.h(this.sNn);
        continue;
        ImageCropUI.i(this.sNn);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198463);
      paramMenuItem = a.sMS;
      a.FU(9);
      this.sNn.finish();
      AppMethodBeat.o(198463);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMattingCropLayout$1$1"})
  static final class r
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    r(WxMediaCropLayout paramWxMediaCropLayout, ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initShowView$2$1"})
  static final class s
    implements Runnable
  {
    s(ImageView paramImageView, ImageCropUI paramImageCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(198467);
      Object localObject;
      if ((this.sNC.getWidth() == 0) || (this.sNC.getHeight() == 0))
      {
        localObject = af.fht();
        ImageCropUI.a(jdField_this, ((af.a)localObject).width, ((af.a)localObject).height);
      }
      for (;;)
      {
        this.sNC.setVisibility(0);
        ImageCropUI.b(jdField_this);
        localObject = ImageCropUI.c(jdField_this);
        if (localObject == null) {
          break;
        }
        ((p)localObject).dismiss();
        AppMethodBeat.o(198467);
        return;
        ImageCropUI.a(jdField_this, this.sNC.getWidth(), this.sNC.getHeight());
      }
      AppMethodBeat.o(198467);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    t(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    u(ImageCropUI paramImageCropUI, v.f paramf, Intent paramIntent)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    v(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "imgPath", "", "imgView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, y>
  {
    w(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    x(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.a<WeImageView>
  {
    y(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends d.g.b.l
    implements d.g.a.a<WeImageView>
  {
    z(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI
 * JD-Core Version:    0.7.0.1
 */