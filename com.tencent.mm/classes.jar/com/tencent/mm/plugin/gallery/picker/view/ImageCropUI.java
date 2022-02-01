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
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.af.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.i;
import d.f;
import d.g.a.m;
import d.g.b.y.f;
import d.l;
import d.z;
import java.io.IOException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backupPath", "", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "cancelCropButton", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getCancelCropButton", "()Landroid/widget/Button;", "cancelCropButton$delegate", "Lkotlin/Lazy;", "confirmCropButton", "getConfirmCropButton", "confirmCropButton$delegate", "cropImgMode", "", "getCropImgMode", "()I", "cropImgMode$delegate", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "cropOperateLayout", "Landroid/widget/LinearLayout;", "getCropOperateLayout", "()Landroid/widget/LinearLayout;", "cropOperateLayout$delegate", "cropping", "", "defaultImageContentCreator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "degree", "displayBitmap", "Landroid/graphics/Bitmap;", "getDisplayBitmap", "()Landroid/graphics/Bitmap;", "setDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "emojiBmp", "imageLoaded", "imgPath", "getImgPath", "imgPath$delegate", "isGif", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mattingImageInfo", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "outputPath", "getOutputPath", "outputPath$delegate", "previewMatting", "getPreviewMatting", "()Lkotlin/jvm/functions/Function3;", "previewView", "getPreviewView", "()Landroid/widget/ImageView;", "previewView$delegate", "rotateButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRotateButton", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rotateButton$delegate", "undoButton", "getUndoButton", "undoButton$delegate", "backgroundCrop", "", "compressMattingImage", "source", "cropAvatar", "getCropBackImg", "getCropMatrix", "Landroid/graphics/Matrix;", "imgWidth", "imgHeight", "scrWidth", "scrHeight", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getFullVisibilityRect", "w", "h", "getImageInfo", "imagePath", "getLayoutId", "initMMView", "initMattingCropLayout", "initShowView", "loadBackgroundPreviewImg", "loadPreview", "mattingCrop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "previewCrop", "compress", "saveImg", "bm", "recycle", "setRequestedOrientation", "requestedOrientation", "showLoadingDialog", "Companion", "plugin-gallery_release"})
public final class ImageCropUI
  extends MMActivity
{
  public static final ImageCropUI.a tJU;
  private com.tencent.mm.ui.base.p fQJ;
  private final f sDd;
  private com.tencent.mm.plugin.gallery.picker.b.b sDr;
  private final f tJB;
  private final f tJC;
  private final f tJD;
  private final f tJE;
  private final f tJF;
  private final f tJG;
  private final f tJH;
  private final f tJI;
  private String tJJ;
  Bitmap tJK;
  private final f tJL;
  private boolean tJM;
  private int tJN;
  private boolean tJO;
  private int[] tJP;
  private Bitmap tJQ;
  private boolean tJR;
  final d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> tJS;
  private final d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> tJT;
  
  static
  {
    AppMethodBeat.i(198860);
    tJU = new ImageCropUI.a((byte)0);
    AppMethodBeat.o(198860);
  }
  
  public ImageCropUI()
  {
    AppMethodBeat.i(198859);
    this.sDd = d.g.O((d.g.a.a)new g(this));
    this.tJB = d.g.O((d.g.a.a)new x(this));
    this.tJC = d.g.O((d.g.a.a)new h(this));
    this.tJD = d.g.O((d.g.a.a)new c(this));
    this.tJE = d.g.O((d.g.a.a)new d(this));
    this.tJF = d.g.O((d.g.a.a)new z(this));
    this.tJG = d.g.O((d.g.a.a)new y(this));
    this.tJH = d.g.O((d.g.a.a)new j(this));
    this.tJI = d.g.O((d.g.a.a)new f(this));
    this.tJJ = "";
    this.tJL = d.g.O((d.g.a.a)new v(this));
    this.tJS = ((d.g.a.q)new w(this));
    this.tJT = ((d.g.a.q)new i(this));
    AppMethodBeat.o(198859);
  }
  
  private final String VT()
  {
    AppMethodBeat.i(198847);
    String str = (String)this.tJH.getValue();
    AppMethodBeat.o(198847);
    return str;
  }
  
  private static boolean a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(198855);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(198855);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
      ad.i("MicroMsg.AvatarCropUI", "saveBitmapToImage successful ");
      AppMethodBeat.o(198855);
      return true;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.AvatarCropUI", (Throwable)paramString, "", new Object[0]);
      ad.e("MicroMsg.AvatarCropUI", "saveBitmapToImage failed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(198855);
    }
    return false;
  }
  
  private final void aRX()
  {
    AppMethodBeat.i(198857);
    com.tencent.mm.ui.base.p localp = this.fQJ;
    if (localp != null) {
      localp.dismiss();
    }
    this.fQJ = com.tencent.mm.ui.base.p.a((Context)this, (CharSequence)getString(2131760709), false, 0, null);
    AppMethodBeat.o(198857);
  }
  
  private final RectF cJI()
  {
    AppMethodBeat.i(198858);
    Object localObject = getContext();
    d.g.b.p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    d.g.b.p.g(localObject, "context.resources");
    float f1 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    f1 -= ((AppCompatActivity)localObject).getResources().getDimension(2131165298);
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    d.g.b.p.g(localObject, "context.resources");
    float f2 = (((Resources)localObject).getDisplayMetrics().heightPixels - f1) / 2.0F;
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165292);
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    localObject = new RectF(f3, f2, ((AppCompatActivity)localObject).getResources().getDimension(2131165292) + f1, f1 + f2);
    AppMethodBeat.o(198858);
    return localObject;
  }
  
  private final WxMediaCropLayout cJP()
  {
    AppMethodBeat.i(198845);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.sDd.getValue();
    AppMethodBeat.o(198845);
    return localWxMediaCropLayout;
  }
  
  private final ImageView cVH()
  {
    AppMethodBeat.i(198846);
    ImageView localImageView = (ImageView)this.tJB.getValue();
    AppMethodBeat.o(198846);
    return localImageView;
  }
  
  private final int cVI()
  {
    AppMethodBeat.i(198848);
    int i = ((Number)this.tJI.getValue()).intValue();
    AppMethodBeat.o(198848);
    return i;
  }
  
  private final String cVJ()
  {
    AppMethodBeat.i(198849);
    String str = (String)this.tJL.getValue();
    AppMethodBeat.o(198849);
    return str;
  }
  
  private final Bitmap cVK()
  {
    AppMethodBeat.i(198854);
    Object localObject = cVH();
    d.g.b.p.g(localObject, "previewView");
    int i = ((ImageView)localObject).getWidth();
    localObject = cVH();
    d.g.b.p.g(localObject, "previewView");
    localObject = com.tencent.mm.sdk.platformtools.g.createBitmap(i, ((ImageView)localObject).getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject == null)
    {
      localObject = a.tJA;
      a.Hj(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(198854);
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    cVH().draw(localCanvas);
    localCanvas.setBitmap(null);
    try
    {
      localObject = com.tencent.mm.sdk.platformtools.g.f((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight() - com.tencent.mm.view.b.e((Context)this, 56.0F));
      AppMethodBeat.o(198854);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      a locala = a.tJA;
      a.Hj(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(198854);
    }
    return null;
  }
  
  public final int getLayoutId()
  {
    return 2131496153;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(198853);
    super.onBackPressed();
    Object localObject = this.sDr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).destroy();
    }
    localObject = a.tJA;
    a.Hj(9);
    AppMethodBeat.o(198853);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(198850);
    super.onCreate(paramBundle);
    paramBundle = a.tJA;
    a.Hj(10);
    setMMTitle("");
    if (cVI() == 1)
    {
      getWindow().setFlags(201327616, 201327616);
      setLightNavigationbarIcon();
      paramBundle = findViewById(2131307208);
      paramBundle.setPadding(0, 0, 0, ar.ej((Context)getContext()));
      paramBundle.post((Runnable)new k(this, paramBundle));
      setActionbarColor(2131101053);
      setActionbarColor(-16777216);
      fullScreenNoTitleBar(true, 0L);
      paramBundle = (LinearLayout)this.tJC.getValue();
      d.g.b.p.g(paramBundle, "cropOperateLayout");
      paramBundle.setVisibility(0);
      ((Button)this.tJD.getValue()).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)this.tJE.getValue()).setOnClickListener((View.OnClickListener)new m(this));
      ((WeImageView)this.tJG.getValue()).setOnClickListener((View.OnClickListener)new n(this));
      ((WeImageView)this.tJF.getValue()).setOnClickListener((View.OnClickListener)new o(this));
      this.tJR = false;
      aRX();
      switch (cVI())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(198850);
      return;
      addTextOptionMenu(0, getString(2131763112), (MenuItem.OnMenuItemClickListener)new p(this), null, s.b.JbS);
      setBackBtn((MenuItem.OnMenuItemClickListener)new q(this));
      break;
      if (getIntent().getIntExtra("CropImage_from_scene", 0) == 3)
      {
        paramBundle = a.tJA;
        a.Hj(0);
        ad.i("MicroMsg.AvatarCropUI", "scene avatar");
      }
      for (;;)
      {
        paramBundle = cJP();
        paramBundle.setVisibility(0);
        paramBundle.setShowBorder(false);
        paramBundle.a(cJI(), WxCropOperationLayout.j.xIW);
        WxMediaCropLayout.a(paramBundle, System.currentTimeMillis(), VT(), true, null, this.tJT, 8);
        AppMethodBeat.o(198850);
        return;
        paramBundle = a.tJA;
        a.Hj(1);
        ad.i("MicroMsg.AvatarCropUI", "scene cover");
      }
      c.b(null, (d.g.a.a)new t(this));
      AppMethodBeat.o(198850);
      return;
      paramBundle = a.tJA;
      a.Hj(2);
      ad.i("MicroMsg.AvatarCropUI", "scene background");
      paramBundle = cVH();
      paramBundle.post((Runnable)new s(paramBundle, this));
      AppMethodBeat.o(198850);
      return;
      paramBundle = a.tJA;
      a.Hj(3);
      ad.i("MicroMsg.AvatarCropUI", "scene emoji");
      paramBundle = cJP();
      paramBundle.setVisibility(0);
      paramBundle.setShowBorder(false);
      paramBundle.setCropLayoutScaleType(CropLayout.e.KVp);
      paramBundle.cVL();
      c.b(null, (d.g.a.a)new r(paramBundle, this));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198851);
    super.onDestroy();
    this.tJK = null;
    if ((!TextUtils.isEmpty((CharSequence)this.tJJ)) && (i.fv(this.tJJ))) {
      i.deleteFile(this.tJJ);
    }
    AppMethodBeat.o(198851);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(198852);
    super.setRequestedOrientation(1);
    AppMethodBeat.o(198852);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<Button>
  {
    c(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<Button>
  {
    d(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isSuccessful", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$cropAvatar$1$1$1", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$$special$$inlined$apply$lambda$1"})
  static final class e
    extends d.g.b.q
    implements m<Boolean, b.f, z>
  {
    e(WxMediaCropLayout.b paramb, String paramString, ImageCropUI paramImageCropUI, b.b paramb1)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    f(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<WxMediaCropLayout>
  {
    g(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<LinearLayout>
  {
    h(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, z>
  {
    i(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    j(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(ImageCropUI paramImageCropUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(198818);
      paramBundle.setPadding(0, 0, 0, ar.ej((Context)this.tJV.getContext()));
      AppMethodBeat.o(198818);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198819);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = a.tJA;
      a.Hj(9);
      this.tJV.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(198819);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198820);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ImageCropUI.d(this.tJV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(198820);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198821);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ImageCropUI.e(this.tJV).getLayout().fLP();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(198821);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198822);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ImageCropUI.e(this.tJV).getLayout().fLQ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(198822);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198823);
      if (!ImageCropUI.a(this.tJV))
      {
        AppMethodBeat.o(198823);
        return true;
      }
      switch (ImageCropUI.f(this.tJV))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(198823);
        return true;
        ImageCropUI.d(this.tJV);
        continue;
        ImageCropUI.g(this.tJV);
        continue;
        ImageCropUI.h(this.tJV);
        continue;
        ImageCropUI.i(this.tJV);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198824);
      paramMenuItem = a.tJA;
      a.Hj(9);
      this.tJV.finish();
      AppMethodBeat.o(198824);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMattingCropLayout$1$1"})
  static final class r
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    r(WxMediaCropLayout paramWxMediaCropLayout, ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initShowView$2$1"})
  static final class s
    implements Runnable
  {
    s(ImageView paramImageView, ImageCropUI paramImageCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(198828);
      Object localObject;
      if ((this.tKk.getWidth() == 0) || (this.tKk.getHeight() == 0))
      {
        localObject = af.fxG();
        ImageCropUI.a(jdField_this, ((af.a)localObject).width, ((af.a)localObject).height);
      }
      for (;;)
      {
        this.tKk.setVisibility(0);
        ImageCropUI.b(jdField_this);
        localObject = ImageCropUI.c(jdField_this);
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.ui.base.p)localObject).dismiss();
        AppMethodBeat.o(198828);
        return;
        ImageCropUI.a(jdField_this, this.tKk.getWidth(), this.tKk.getHeight());
      }
      AppMethodBeat.o(198828);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    t(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class u
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    u(ImageCropUI paramImageCropUI, y.f paramf, Intent paramIntent)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class v
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    v(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "imgPath", "", "imgView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, z>
  {
    w(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    x(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends d.g.b.q
    implements d.g.a.a<WeImageView>
  {
    y(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends d.g.b.q
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