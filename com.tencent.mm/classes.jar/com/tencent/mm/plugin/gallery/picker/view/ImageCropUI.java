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
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ah.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backupPath", "", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "cancelCropButton", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getCancelCropButton", "()Landroid/widget/Button;", "cancelCropButton$delegate", "Lkotlin/Lazy;", "confirmCropButton", "getConfirmCropButton", "confirmCropButton$delegate", "cropImgMode", "", "getCropImgMode", "()I", "cropImgMode$delegate", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "cropOperateLayout", "Landroid/widget/LinearLayout;", "getCropOperateLayout", "()Landroid/widget/LinearLayout;", "cropOperateLayout$delegate", "cropping", "", "defaultImageContentCreator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "degree", "displayBitmap", "Landroid/graphics/Bitmap;", "getDisplayBitmap", "()Landroid/graphics/Bitmap;", "setDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "emojiBmp", "imageLoaded", "imgPath", "getImgPath", "imgPath$delegate", "isGif", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mattingImageInfo", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "outputPath", "getOutputPath", "outputPath$delegate", "previewMatting", "getPreviewMatting", "()Lkotlin/jvm/functions/Function3;", "previewView", "getPreviewView", "()Landroid/widget/ImageView;", "previewView$delegate", "rotateButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRotateButton", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rotateButton$delegate", "undoButton", "getUndoButton", "undoButton$delegate", "backgroundCrop", "", "compressMattingImage", "source", "cropAvatar", "getCropBackImg", "getCropMatrix", "Landroid/graphics/Matrix;", "imgWidth", "imgHeight", "scrWidth", "scrHeight", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getFullVisibilityRect", "w", "h", "getImageInfo", "imagePath", "getLayoutId", "initMMView", "initMattingCropLayout", "initShowView", "loadBackgroundPreviewImg", "loadPreview", "mattingCrop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "previewCrop", "compress", "saveImg", "bm", "recycle", "setRequestedOrientation", "requestedOrientation", "showLoadingDialog", "Companion", "plugin-gallery_release"})
public final class ImageCropUI
  extends MMActivity
{
  public static final ImageCropUI.a xlX;
  private com.tencent.mm.ui.base.q gxX;
  private final f vLg;
  private com.tencent.mm.plugin.gallery.picker.b.b vLu;
  private final f xlE;
  private final f xlF;
  private final f xlG;
  private final f xlH;
  private final f xlI;
  private final f xlJ;
  private final f xlK;
  private final f xlL;
  private String xlM;
  Bitmap xlN;
  private final f xlO;
  private boolean xlP;
  private int xlQ;
  private boolean xlR;
  private int[] xlS;
  private Bitmap xlT;
  private boolean xlU;
  final kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> xlV;
  private final kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> xlW;
  
  static
  {
    AppMethodBeat.i(257836);
    xlX = new ImageCropUI.a((byte)0);
    AppMethodBeat.o(257836);
  }
  
  public ImageCropUI()
  {
    AppMethodBeat.i(257835);
    this.vLg = g.ah((kotlin.g.a.a)new g(this));
    this.xlE = g.ah((kotlin.g.a.a)new x(this));
    this.xlF = g.ah((kotlin.g.a.a)new h(this));
    this.xlG = g.ah((kotlin.g.a.a)new c(this));
    this.xlH = g.ah((kotlin.g.a.a)new d(this));
    this.xlI = g.ah((kotlin.g.a.a)new z(this));
    this.xlJ = g.ah((kotlin.g.a.a)new y(this));
    this.xlK = g.ah((kotlin.g.a.a)new j(this));
    this.xlL = g.ah((kotlin.g.a.a)new f(this));
    this.xlM = "";
    this.xlO = g.ah((kotlin.g.a.a)new v(this));
    this.xlV = ((kotlin.g.a.q)new w(this));
    this.xlW = ((kotlin.g.a.q)new i(this));
    AppMethodBeat.o(257835);
  }
  
  private static boolean a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(257831);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(257831);
      return false;
    }
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
      Log.i("MicroMsg.AvatarCropUI", "saveBitmapToImage successful ");
      AppMethodBeat.o(257831);
      return true;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AvatarCropUI", (Throwable)paramString, "", new Object[0]);
      Log.e("MicroMsg.AvatarCropUI", "saveBitmapToImage failed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(257831);
    }
    return false;
  }
  
  private final String ajP()
  {
    AppMethodBeat.i(257823);
    String str = (String)this.xlK.getValue();
    AppMethodBeat.o(257823);
    return str;
  }
  
  private final void bnj()
  {
    AppMethodBeat.i(257833);
    com.tencent.mm.ui.base.q localq = this.gxX;
    if (localq != null) {
      localq.dismiss();
    }
    this.gxX = com.tencent.mm.ui.base.q.a((Context)this, (CharSequence)getString(2131762446), false, 0, null);
    AppMethodBeat.o(257833);
  }
  
  private final ImageView dRF()
  {
    AppMethodBeat.i(257822);
    ImageView localImageView = (ImageView)this.xlE.getValue();
    AppMethodBeat.o(257822);
    return localImageView;
  }
  
  private final int dRG()
  {
    AppMethodBeat.i(257824);
    int i = ((Number)this.xlL.getValue()).intValue();
    AppMethodBeat.o(257824);
    return i;
  }
  
  private final String dRH()
  {
    AppMethodBeat.i(257825);
    String str = (String)this.xlO.getValue();
    AppMethodBeat.o(257825);
    return str;
  }
  
  private final Bitmap dRI()
  {
    AppMethodBeat.i(257830);
    Object localObject = dRF();
    p.g(localObject, "previewView");
    int i = ((ImageView)localObject).getWidth();
    localObject = dRF();
    p.g(localObject, "previewView");
    localObject = BitmapUtil.createBitmap(i, ((ImageView)localObject).getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject == null)
    {
      localObject = a.xlD;
      a.NH(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(257830);
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    dRF().draw(localCanvas);
    localCanvas.setBitmap(null);
    try
    {
      localObject = BitmapUtil.cropBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight() - com.tencent.mm.view.d.e((Context)this, 56.0F), true);
      AppMethodBeat.o(257830);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      a locala = a.xlD;
      a.NH(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(257830);
    }
    return null;
  }
  
  private final WxMediaCropLayout dzH()
  {
    AppMethodBeat.i(257821);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.vLg.getValue();
    AppMethodBeat.o(257821);
    return localWxMediaCropLayout;
  }
  
  private final RectF dzt()
  {
    AppMethodBeat.i(257834);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    p.g(localObject, "context.resources");
    float f1 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = getContext();
    p.g(localObject, "context");
    f1 -= ((AppCompatActivity)localObject).getResources().getDimension(2131165308);
    localObject = getContext();
    p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    p.g(localObject, "context.resources");
    float f2 = (((Resources)localObject).getDisplayMetrics().heightPixels - f1) / 2.0F;
    localObject = getContext();
    p.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165299);
    localObject = getContext();
    p.g(localObject, "context");
    localObject = new RectF(f3, f2, ((AppCompatActivity)localObject).getResources().getDimension(2131165299) + f1, f1 + f2);
    AppMethodBeat.o(257834);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return 2131495038;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(257829);
    super.onBackPressed();
    Object localObject = this.vLu;
    if (localObject != null) {
      ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).destroy();
    }
    localObject = a.xlD;
    a.NH(9);
    AppMethodBeat.o(257829);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257826);
    super.onCreate(paramBundle);
    paramBundle = a.xlD;
    a.NH(10);
    setMMTitle("");
    if (dRG() == 1)
    {
      getWindow().setFlags(201327616, 201327616);
      setLightNavigationbarIcon();
      paramBundle = findViewById(2131302550);
      paramBundle.setPadding(0, 0, 0, au.aD((Context)getContext()));
      paramBundle.post((Runnable)new ImageCropUI.k(this, paramBundle));
      setActionbarColor(2131101287);
      setActionbarColor(-16777216);
      fullScreenNoTitleBar(true, 0L);
      paramBundle = (LinearLayout)this.xlF.getValue();
      p.g(paramBundle, "cropOperateLayout");
      paramBundle.setVisibility(0);
      ((Button)this.xlG.getValue()).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)this.xlH.getValue()).setOnClickListener((View.OnClickListener)new ImageCropUI.m(this));
      ((WeImageView)this.xlJ.getValue()).setOnClickListener((View.OnClickListener)new ImageCropUI.n(this));
      ((WeImageView)this.xlI.getValue()).setOnClickListener((View.OnClickListener)new ImageCropUI.o(this));
      this.xlU = false;
      bnj();
      switch (dRG())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(257826);
      return;
      addTextOptionMenu(0, getString(2131761087), (MenuItem.OnMenuItemClickListener)new p(this), null, t.b.OGU);
      setBackBtn((MenuItem.OnMenuItemClickListener)new q(this));
      break;
      if (getIntent().getIntExtra("CropImage_from_scene", 0) == 3)
      {
        paramBundle = a.xlD;
        a.NH(0);
        Log.i("MicroMsg.AvatarCropUI", "scene avatar");
      }
      for (;;)
      {
        paramBundle = dzH();
        paramBundle.setVisibility(0);
        paramBundle.setShowBorder(false);
        paramBundle.a(dzt(), WxCropOperationLayout.j.BZJ);
        WxMediaCropLayout.a(paramBundle, System.currentTimeMillis(), ajP(), true, null, this.xlW, 8);
        AppMethodBeat.o(257826);
        return;
        paramBundle = a.xlD;
        a.NH(1);
        Log.i("MicroMsg.AvatarCropUI", "scene cover");
      }
      com.tencent.mm.ac.d.i((kotlin.g.a.a)new t(this));
      AppMethodBeat.o(257826);
      return;
      paramBundle = a.xlD;
      a.NH(2);
      Log.i("MicroMsg.AvatarCropUI", "scene background");
      paramBundle = dRF();
      paramBundle.post((Runnable)new s(paramBundle, this));
      AppMethodBeat.o(257826);
      return;
      paramBundle = a.xlD;
      a.NH(3);
      Log.i("MicroMsg.AvatarCropUI", "scene emoji");
      paramBundle = dzH();
      paramBundle.setVisibility(0);
      paramBundle.setShowBorder(false);
      paramBundle.setCropLayoutScaleType(CropLayout.e.QMF);
      paramBundle.dRJ();
      com.tencent.mm.ac.d.i((kotlin.g.a.a)new r(paramBundle, this));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257827);
    super.onDestroy();
    this.xlN = null;
    if ((!TextUtils.isEmpty((CharSequence)this.xlM)) && (s.YS(this.xlM))) {
      s.deleteFile(this.xlM);
    }
    AppMethodBeat.o(257827);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(257828);
    super.setRequestedOrientation(1);
    AppMethodBeat.o(257828);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Button>
  {
    c(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Button>
  {
    d(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isSuccessful", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$cropAvatar$1$1$1", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$$special$$inlined$apply$lambda$1"})
  static final class e
    extends kotlin.g.b.q
    implements m<Boolean, b.f, x>
  {
    e(WxMediaCropLayout.b paramb, String paramString, ImageCropUI paramImageCropUI, b.b paramb1)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    f(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WxMediaCropLayout>
  {
    g(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    h(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, x>
  {
    i(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    j(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257795);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = a.xlD;
      a.NH(9);
      this.xlY.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257795);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(257799);
      if (!ImageCropUI.a(this.xlY))
      {
        AppMethodBeat.o(257799);
        return true;
      }
      switch (ImageCropUI.f(this.xlY))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(257799);
        return true;
        ImageCropUI.d(this.xlY);
        continue;
        ImageCropUI.g(this.xlY);
        continue;
        ImageCropUI.h(this.xlY);
        continue;
        ImageCropUI.i(this.xlY);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(257800);
      paramMenuItem = a.xlD;
      a.NH(9);
      this.xlY.finish();
      AppMethodBeat.o(257800);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMattingCropLayout$1$1"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    r(WxMediaCropLayout paramWxMediaCropLayout, ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initShowView$2$1"})
  static final class s
    implements Runnable
  {
    s(ImageView paramImageView, ImageCropUI paramImageCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(257804);
      Object localObject;
      if ((this.tqC.getWidth() == 0) || (this.tqC.getHeight() == 0))
      {
        localObject = ah.gJB();
        ImageCropUI.a(jdField_this, ((ah.a)localObject).width, ((ah.a)localObject).height);
      }
      for (;;)
      {
        this.tqC.setVisibility(0);
        ImageCropUI.b(jdField_this);
        localObject = ImageCropUI.c(jdField_this);
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.ui.base.q)localObject).dismiss();
        AppMethodBeat.o(257804);
        return;
        ImageCropUI.a(jdField_this, this.tqC.getWidth(), this.tqC.getHeight());
      }
      AppMethodBeat.o(257804);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    t(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    u(ImageCropUI paramImageCropUI, z.f paramf, Intent paramIntent)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    v(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "imgPath", "", "imgView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, x>
  {
    w(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    x(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    y(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    z(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI
 * JD-Core Version:    0.7.0.1
 */