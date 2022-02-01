package com.tencent.mm.plugin.gallery.picker.view;

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
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.i;
import d.g;
import d.g.a.m;
import d.g.a.q;
import d.g.b.u;
import d.g.b.v.e;
import d.g.b.w;
import d.y;
import java.io.IOException;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backupPath", "", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "cancelCropButton", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getCancelCropButton", "()Landroid/widget/Button;", "cancelCropButton$delegate", "Lkotlin/Lazy;", "confirmCropButton", "getConfirmCropButton", "confirmCropButton$delegate", "cropImgMode", "", "getCropImgMode", "()I", "cropImgMode$delegate", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "cropOperateLayout", "Landroid/widget/LinearLayout;", "getCropOperateLayout", "()Landroid/widget/LinearLayout;", "cropOperateLayout$delegate", "cropping", "", "defaultImageContentCreator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "degree", "displayBitmap", "Landroid/graphics/Bitmap;", "getDisplayBitmap", "()Landroid/graphics/Bitmap;", "setDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "emojiBmp", "imageLoaded", "imgPath", "getImgPath", "imgPath$delegate", "isGif", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mattingImageInfo", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "outputPath", "getOutputPath", "outputPath$delegate", "previewMatting", "getPreviewMatting", "()Lkotlin/jvm/functions/Function3;", "previewView", "getPreviewView", "()Landroid/widget/ImageView;", "previewView$delegate", "rotateButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRotateButton", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rotateButton$delegate", "undoButton", "getUndoButton", "undoButton$delegate", "backgroundCrop", "", "compressMattingImage", "source", "cropAvatar", "getCropBackImg", "getCropMatrix", "Landroid/graphics/Matrix;", "imgWidth", "imgHeight", "scrWidth", "scrHeight", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getFullVisibilityRect", "w", "h", "getImageInfo", "imagePath", "getLayoutId", "initMMView", "initMattingCropLayout", "initShowView", "loadBackgroundPreviewImg", "loadPreview", "mattingCrop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "previewCrop", "compress", "saveImg", "bm", "recycle", "showLoadingDialog", "Companion", "plugin-gallery_release"})
public final class ImageCropUI
  extends MMActivity
{
  public static final a rEu;
  private p ftP;
  private final d.f qMM;
  private com.tencent.mm.plugin.gallery.picker.b.b qMW;
  private final d.f rEb;
  private final d.f rEc;
  private final d.f rEd;
  private final d.f rEe;
  private final d.f rEf;
  private final d.f rEg;
  private final d.f rEh;
  private final d.f rEi;
  private String rEj;
  Bitmap rEk;
  private final d.f rEl;
  private boolean rEm;
  private int rEn;
  private boolean rEo;
  private int[] rEp;
  private Bitmap rEq;
  private boolean rEr;
  final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> rEs;
  private final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> rEt;
  
  static
  {
    AppMethodBeat.i(186782);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "cropLayout", "getCropLayout()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "previewView", "getPreviewView()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "cropOperateLayout", "getCropOperateLayout()Landroid/widget/LinearLayout;")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "cancelCropButton", "getCancelCropButton()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "confirmCropButton", "getConfirmCropButton()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "undoButton", "getUndoButton()Lcom/tencent/mm/ui/widget/imageview/WeImageView;")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "rotateButton", "getRotateButton()Lcom/tencent/mm/ui/widget/imageview/WeImageView;")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "imgPath", "getImgPath()Ljava/lang/String;")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "cropImgMode", "getCropImgMode()I")), (d.l.k)w.a(new u(w.bk(ImageCropUI.class), "outputPath", "getOutputPath()Ljava/lang/String;")) };
    rEu = new a((byte)0);
    AppMethodBeat.o(186782);
  }
  
  public ImageCropUI()
  {
    AppMethodBeat.i(186796);
    this.qMM = g.E((d.g.a.a)new g(this));
    this.rEb = g.E((d.g.a.a)new x(this));
    this.rEc = g.E((d.g.a.a)new h(this));
    this.rEd = g.E((d.g.a.a)new c(this));
    this.rEe = g.E((d.g.a.a)new d(this));
    this.rEf = g.E((d.g.a.a)new z(this));
    this.rEg = g.E((d.g.a.a)new y(this));
    this.rEh = g.E((d.g.a.a)new j(this));
    this.rEi = g.E((d.g.a.a)new f(this));
    this.rEj = "";
    this.rEl = g.E((d.g.a.a)new v(this));
    this.rEs = ((q)new w(this));
    this.rEt = ((q)new i(this));
    AppMethodBeat.o(186796);
  }
  
  private final String SJ()
  {
    AppMethodBeat.i(186785);
    String str = (String)this.rEh.getValue();
    AppMethodBeat.o(186785);
    return str;
  }
  
  private static boolean a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(186792);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(186792);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
      ad.i("MicroMsg.AvatarCropUI", "saveBitmapToImage successful ");
      AppMethodBeat.o(186792);
      return true;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.AvatarCropUI", (Throwable)paramString, "", new Object[0]);
      ad.e("MicroMsg.AvatarCropUI", "saveBitmapToImage failed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(186792);
    }
    return false;
  }
  
  private final void aHU()
  {
    AppMethodBeat.i(186794);
    p localp = this.ftP;
    if (localp != null) {
      localp.dismiss();
    }
    this.ftP = p.a((Context)this, (CharSequence)getString(2131760709), false, 0, null);
    AppMethodBeat.o(186794);
  }
  
  private final ImageView cAd()
  {
    AppMethodBeat.i(186784);
    ImageView localImageView = (ImageView)this.rEb.getValue();
    AppMethodBeat.o(186784);
    return localImageView;
  }
  
  private final int cAe()
  {
    AppMethodBeat.i(186786);
    int i = ((Number)this.rEi.getValue()).intValue();
    AppMethodBeat.o(186786);
    return i;
  }
  
  private final String cAf()
  {
    AppMethodBeat.i(186787);
    String str = (String)this.rEl.getValue();
    AppMethodBeat.o(186787);
    return str;
  }
  
  private final Bitmap cAg()
  {
    AppMethodBeat.i(186791);
    Object localObject = cAd();
    d.g.b.k.g(localObject, "previewView");
    int i = ((ImageView)localObject).getWidth();
    localObject = cAd();
    d.g.b.k.g(localObject, "previewView");
    localObject = com.tencent.mm.sdk.platformtools.f.createBitmap(i, ((ImageView)localObject).getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject == null)
    {
      localObject = a.rEa;
      a.DY(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(186791);
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    cAd().draw(localCanvas);
    localCanvas.setBitmap(null);
    try
    {
      localObject = com.tencent.mm.sdk.platformtools.f.f((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight() - com.tencent.mm.view.b.e((Context)this, 56.0F));
      AppMethodBeat.o(186791);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      a locala = a.rEa;
      a.DY(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(186791);
    }
    return null;
  }
  
  private final RectF cqX()
  {
    AppMethodBeat.i(186795);
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
    AppMethodBeat.o(186795);
    return localObject;
  }
  
  private final WxMediaCropLayout crd()
  {
    AppMethodBeat.i(186783);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.qMM.getValue();
    AppMethodBeat.o(186783);
    return localWxMediaCropLayout;
  }
  
  public final int getLayoutId()
  {
    return 2131496153;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(186790);
    super.onBackPressed();
    Object localObject = this.qMW;
    if (localObject != null) {
      ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).destroy();
    }
    localObject = a.rEa;
    a.DY(9);
    AppMethodBeat.o(186790);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(186788);
    super.onCreate(paramBundle);
    paramBundle = a.rEa;
    a.DY(10);
    setMMTitle("");
    if (cAe() == 1)
    {
      getWindow().setFlags(201327616, 201327616);
      setLightNavigationbarIcon();
      paramBundle = findViewById(2131307208);
      paramBundle.setPadding(0, 0, 0, ap.eb((Context)getContext()));
      paramBundle.post((Runnable)new k(this, paramBundle));
      setActionbarColor(2131101053);
      setActionbarColor(-16777216);
      fullScreenNoTitleBar(true, 0L);
      paramBundle = (LinearLayout)this.rEc.getValue();
      d.g.b.k.g(paramBundle, "cropOperateLayout");
      paramBundle.setVisibility(0);
      ((Button)this.rEd.getValue()).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)this.rEe.getValue()).setOnClickListener((View.OnClickListener)new m(this));
      ((WeImageView)this.rEg.getValue()).setOnClickListener((View.OnClickListener)new n(this));
      ((WeImageView)this.rEf.getValue()).setOnClickListener((View.OnClickListener)new o(this));
      this.rEr = false;
      aHU();
      switch (cAe())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(186788);
      return;
      addTextOptionMenu(0, getString(2131763112), (MenuItem.OnMenuItemClickListener)new p(this), null, r.b.FOB);
      setBackBtn((MenuItem.OnMenuItemClickListener)new q(this));
      break;
      if (getIntent().getIntExtra("CropImage_from_scene", 0) == 3)
      {
        paramBundle = a.rEa;
        a.DY(0);
        ad.i("MicroMsg.AvatarCropUI", "scene avatar");
      }
      for (;;)
      {
        paramBundle = crd();
        paramBundle.setVisibility(0);
        paramBundle.setShowBorder(false);
        paramBundle.a(cqX(), WxCropOperationLayout.j.LpL);
        WxMediaCropLayout.a(paramBundle, System.currentTimeMillis(), SJ(), true, null, this.rEt, 8);
        AppMethodBeat.o(186788);
        return;
        paramBundle = a.rEa;
        a.DY(1);
        ad.i("MicroMsg.AvatarCropUI", "scene cover");
      }
      c.b(null, (d.g.a.a)new t(this));
      AppMethodBeat.o(186788);
      return;
      paramBundle = a.rEa;
      a.DY(2);
      ad.i("MicroMsg.AvatarCropUI", "scene background");
      paramBundle = cAd();
      paramBundle.post((Runnable)new ImageCropUI.s(paramBundle, this));
      AppMethodBeat.o(186788);
      return;
      paramBundle = a.rEa;
      a.DY(3);
      ad.i("MicroMsg.AvatarCropUI", "scene emoji");
      paramBundle = crd();
      paramBundle.setVisibility(0);
      paramBundle.setShowBorder(false);
      paramBundle.setCropLayoutScaleType(CropLayout.c.HDK);
      paramBundle.cAk();
      c.b(null, (d.g.a.a)new r(paramBundle, this));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186789);
    super.onDestroy();
    this.rEk = null;
    if ((!TextUtils.isEmpty((CharSequence)this.rEj)) && (i.eK(this.rEj))) {
      i.deleteFile(this.rEj);
    }
    AppMethodBeat.o(186789);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI$Companion;", "", "()V", "BMP_HEIGHT", "", "BMP_WIDTH", "CHATTING_FOOT_HEIGHT_DP", "", "COMPRESS_QUALITY", "CUSTOM_EMOJI_TYPE_GIF", "CUSTOM_EMOJI_TYPE_PNG", "LONG_IMAGE_LIMIT", "LONG_IMAGE_MAX_MULTIPLE", "MAT_BMP_HEIGHT", "MAT_BMP_WIDTH", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Button>
  {
    c(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<Button>
  {
    d(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "isSuccessful", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$cropAvatar$1$1$1", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$$special$$inlined$apply$lambda$1"})
  static final class e
    extends d.g.b.l
    implements m<Boolean, b.f, y>
  {
    e(WxMediaCropLayout.b paramb, String paramString, ImageCropUI paramImageCropUI, b.b paramb1)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    f(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<WxMediaCropLayout>
  {
    g(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<LinearLayout>
  {
    h(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, y>
  {
    i(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    j(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(ImageCropUI paramImageCropUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(186756);
      paramBundle.setPadding(0, 0, 0, ap.eb((Context)this.rEv.getContext()));
      AppMethodBeat.o(186756);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186757);
      paramView = a.rEa;
      a.DY(9);
      this.rEv.finish();
      AppMethodBeat.o(186757);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186758);
      ImageCropUI.d(this.rEv);
      AppMethodBeat.o(186758);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186759);
      ImageCropUI.e(this.rEv).getLayout().ffi();
      AppMethodBeat.o(186759);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186760);
      ImageCropUI.e(this.rEv).getLayout().ffj();
      AppMethodBeat.o(186760);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(186761);
      if (!ImageCropUI.a(this.rEv))
      {
        AppMethodBeat.o(186761);
        return true;
      }
      switch (ImageCropUI.f(this.rEv))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(186761);
        return true;
        ImageCropUI.d(this.rEv);
        continue;
        ImageCropUI.g(this.rEv);
        continue;
        ImageCropUI.h(this.rEv);
        continue;
        ImageCropUI.i(this.rEv);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(186762);
      paramMenuItem = a.rEa;
      a.DY(9);
      this.rEv.finish();
      AppMethodBeat.o(186762);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMattingCropLayout$1$1"})
  static final class r
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    r(WxMediaCropLayout paramWxMediaCropLayout, ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    t(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    u(ImageCropUI paramImageCropUI, v.e parame, Intent paramIntent)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    v(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "imgPath", "", "imgView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, y>
  {
    w(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    x(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.a<WeImageView>
  {
    y(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI
 * JD-Core Version:    0.7.0.1
 */