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
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@c(0)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backupPath", "", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "cancelCropButton", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getCancelCropButton", "()Landroid/widget/Button;", "cancelCropButton$delegate", "Lkotlin/Lazy;", "confirmCropButton", "getConfirmCropButton", "confirmCropButton$delegate", "cropImgMode", "", "getCropImgMode", "()I", "cropImgMode$delegate", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "cropOperateLayout", "Landroid/widget/LinearLayout;", "getCropOperateLayout", "()Landroid/widget/LinearLayout;", "cropOperateLayout$delegate", "cropping", "", "defaultImageContentCreator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "degree", "displayBitmap", "Landroid/graphics/Bitmap;", "getDisplayBitmap", "()Landroid/graphics/Bitmap;", "setDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "emojiBmp", "imageLoaded", "imgPath", "getImgPath", "imgPath$delegate", "isGif", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mattingImageInfo", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "outputPath", "getOutputPath", "outputPath$delegate", "previewMatting", "getPreviewMatting", "()Lkotlin/jvm/functions/Function3;", "previewView", "getPreviewView", "()Landroid/widget/ImageView;", "previewView$delegate", "rotateButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRotateButton", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rotateButton$delegate", "undoButton", "getUndoButton", "undoButton$delegate", "backgroundCrop", "", "compressMattingImage", "source", "cropAvatar", "getCropBackImg", "getCropMatrix", "Landroid/graphics/Matrix;", "imgWidth", "imgHeight", "scrWidth", "scrHeight", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getFullVisibilityRect", "w", "h", "getImageInfo", "imagePath", "getLayoutId", "initMMView", "initMattingCropLayout", "initShowView", "loadBackgroundPreviewImg", "loadPreview", "mattingCrop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "previewCrop", "compress", "saveImg", "bm", "recycle", "setRequestedOrientation", "requestedOrientation", "showLoadingDialog", "Companion", "plugin-gallery_release"})
public final class ImageCropUI
  extends MMActivity
{
  public static final a BYr;
  private final f ArT;
  private com.tencent.mm.plugin.gallery.picker.b.b Ash;
  private final f BXY;
  private final f BXZ;
  private final f BYa;
  private final f BYb;
  private final f BYc;
  private final f BYd;
  private final f BYe;
  private final f BYf;
  private String BYg;
  Bitmap BYh;
  private final f BYi;
  private boolean BYj;
  private int BYk;
  private boolean BYl;
  private int[] BYm;
  private Bitmap BYn;
  private boolean BYo;
  final kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> BYp;
  private final kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> BYq;
  private s jhZ;
  
  static
  {
    AppMethodBeat.i(244893);
    BYr = new a((byte)0);
    AppMethodBeat.o(244893);
  }
  
  public ImageCropUI()
  {
    AppMethodBeat.i(244891);
    this.ArT = g.ar((kotlin.g.a.a)new g(this));
    this.BXY = g.ar((kotlin.g.a.a)new x(this));
    this.BXZ = g.ar((kotlin.g.a.a)new h(this));
    this.BYa = g.ar((kotlin.g.a.a)new c(this));
    this.BYb = g.ar((kotlin.g.a.a)new d(this));
    this.BYc = g.ar((kotlin.g.a.a)new z(this));
    this.BYd = g.ar((kotlin.g.a.a)new y(this));
    this.BYe = g.ar((kotlin.g.a.a)new j(this));
    this.BYf = g.ar((kotlin.g.a.a)new f(this));
    this.BYg = "";
    this.BYi = g.ar((kotlin.g.a.a)new v(this));
    this.BYp = ((kotlin.g.a.q)new w(this));
    this.BYq = ((kotlin.g.a.q)new i(this));
    AppMethodBeat.o(244891);
  }
  
  private static boolean a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(244882);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(244882);
      return false;
    }
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
      Log.i("MicroMsg.AvatarCropUI", "saveBitmapToImage successful ");
      AppMethodBeat.o(244882);
      return true;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AvatarCropUI", (Throwable)paramString, "", new Object[0]);
      Log.e("MicroMsg.AvatarCropUI", "saveBitmapToImage failed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(244882);
    }
    return false;
  }
  
  private final String apK()
  {
    AppMethodBeat.i(244867);
    String str = (String)this.BYe.getValue();
    AppMethodBeat.o(244867);
    return str;
  }
  
  private final void bxs()
  {
    AppMethodBeat.i(244887);
    s locals = this.jhZ;
    if (locals != null) {
      locals.dismiss();
    }
    this.jhZ = s.a((Context)this, (CharSequence)getString(b.i.loading_tips), false, 0, null);
    AppMethodBeat.o(244887);
  }
  
  private final RectF ean()
  {
    AppMethodBeat.i(244889);
    Object localObject = ak.hIy();
    float f1 = ((ak.a)localObject).width;
    AppCompatActivity localAppCompatActivity = getContext();
    p.j(localAppCompatActivity, "context");
    f1 -= localAppCompatActivity.getResources().getDimension(b.c.Edge_6A);
    float f2 = (((ak.a)localObject).height - f1) / 2.0F;
    localObject = getContext();
    p.j(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(b.c.Edge_3A);
    localObject = getContext();
    p.j(localObject, "context");
    localObject = new RectF(f3, f2, ((AppCompatActivity)localObject).getResources().getDimension(b.c.Edge_3A) + f1, f1 + f2);
    AppMethodBeat.o(244889);
    return localObject;
  }
  
  private final WxMediaCropLayout eax()
  {
    AppMethodBeat.i(244862);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.ArT.getValue();
    AppMethodBeat.o(244862);
    return localWxMediaCropLayout;
  }
  
  private final ImageView euh()
  {
    AppMethodBeat.i(244864);
    ImageView localImageView = (ImageView)this.BXY.getValue();
    AppMethodBeat.o(244864);
    return localImageView;
  }
  
  private final int eui()
  {
    AppMethodBeat.i(244868);
    int i = ((Number)this.BYf.getValue()).intValue();
    AppMethodBeat.o(244868);
    return i;
  }
  
  private final String euj()
  {
    AppMethodBeat.i(244870);
    String str = (String)this.BYi.getValue();
    AppMethodBeat.o(244870);
    return str;
  }
  
  private final Bitmap euk()
  {
    AppMethodBeat.i(244880);
    Object localObject = euh();
    p.j(localObject, "previewView");
    int i = ((ImageView)localObject).getWidth();
    localObject = euh();
    p.j(localObject, "previewView");
    localObject = BitmapUtil.createBitmap(i, ((ImageView)localObject).getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject == null)
    {
      localObject = a.BXX;
      a.SV(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(244880);
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    euh().draw(localCanvas);
    localCanvas.setBitmap(null);
    try
    {
      localObject = BitmapUtil.cropBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight() - com.tencent.mm.view.d.e((Context)this, 56.0F), true);
      AppMethodBeat.o(244880);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      a locala = a.BXX;
      a.SV(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(244880);
    }
    return null;
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.plugin.gallery.b.f.image_crop;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(244876);
    super.onBackPressed();
    Object localObject = this.Ash;
    if (localObject != null) {
      ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).destroy();
    }
    localObject = a.BXX;
    a.SV(9);
    AppMethodBeat.o(244876);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(244872);
    super.onCreate(paramBundle);
    paramBundle = a.BXX;
    a.SV(10);
    setMMTitle("");
    if (eui() == 1)
    {
      getWindow().setFlags(201327616, 201327616);
      setLightNavigationbarIcon();
      paramBundle = findViewById(b.e.image_crop_root_layout);
      paramBundle.setPadding(0, 0, 0, ax.aB((Context)getContext()));
      paramBundle.post((Runnable)new k(this, paramBundle));
      setActionbarColor(com.tencent.mm.plugin.gallery.b.b.transparent);
      setActionbarColor(-16777216);
      fullScreenNoTitleBar(true, 0L);
      paramBundle = (LinearLayout)this.BXZ.getValue();
      p.j(paramBundle, "cropOperateLayout");
      paramBundle.setVisibility(0);
      ((Button)this.BYa.getValue()).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)this.BYb.getValue()).setOnClickListener((View.OnClickListener)new m(this));
      ((WeImageView)this.BYd.getValue()).setOnClickListener((View.OnClickListener)new n(this));
      ((WeImageView)this.BYc.getValue()).setOnClickListener((View.OnClickListener)new o(this));
      this.BYo = false;
      bxs();
      switch (eui())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(244872);
      return;
      addTextOptionMenu(0, getString(b.i.gallery_cropimage_use), (MenuItem.OnMenuItemClickListener)new p(this), null, w.b.Wao);
      setBackBtn((MenuItem.OnMenuItemClickListener)new q(this));
      break;
      if (getIntent().getIntExtra("CropImage_from_scene", 0) == 3)
      {
        paramBundle = a.BXX;
        a.SV(0);
        Log.i("MicroMsg.AvatarCropUI", "scene avatar");
      }
      for (;;)
      {
        paramBundle = eax();
        paramBundle.setVisibility(0);
        paramBundle.setShowBorder(false);
        paramBundle.a(ean(), WxCropOperationLayout.j.HWy);
        WxMediaCropLayout.a(paramBundle, System.currentTimeMillis(), apK(), true, null, this.BYq, 8);
        AppMethodBeat.o(244872);
        return;
        paramBundle = a.BXX;
        a.SV(1);
        Log.i("MicroMsg.AvatarCropUI", "scene cover");
      }
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new t(this));
      AppMethodBeat.o(244872);
      return;
      paramBundle = a.BXX;
      a.SV(2);
      Log.i("MicroMsg.AvatarCropUI", "scene background");
      paramBundle = euh();
      paramBundle.post((Runnable)new s(paramBundle, this));
      AppMethodBeat.o(244872);
      return;
      paramBundle = a.BXX;
      a.SV(3);
      Log.i("MicroMsg.AvatarCropUI", "scene emoji");
      paramBundle = eax();
      paramBundle.setVisibility(0);
      paramBundle.setShowBorder(false);
      paramBundle.setCropLayoutScaleType(CropLayout.e.Ylx);
      paramBundle.eul();
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new r(paramBundle, this));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(244873);
    super.onDestroy();
    this.BYh = null;
    if ((!TextUtils.isEmpty((CharSequence)this.BYg)) && (u.agG(this.BYg))) {
      u.deleteFile(this.BYg);
    }
    AppMethodBeat.o(244873);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(244875);
    super.setRequestedOrientation(1);
    AppMethodBeat.o(244875);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI$Companion;", "", "()V", "BMP_HEIGHT", "", "BMP_WIDTH", "CHATTING_FOOT_HEIGHT_DP", "", "COMPRESS_QUALITY", "CUSTOM_EMOJI_TYPE_GIF", "CUSTOM_EMOJI_TYPE_PNG", "LONG_IMAGE_LIMIT", "LONG_IMAGE_MAX_MULTIPLE", "MAT_BMP_HEIGHT", "MAT_BMP_WIDTH", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Button>
  {
    c(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Button>
  {
    d(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isSuccessful", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$cropAvatar$1$1$1", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$$special$$inlined$apply$lambda$1"})
  static final class e
    extends kotlin.g.b.q
    implements m<Boolean, com.tencent.mm.plugin.gallery.picker.b.b.f, x>
  {
    e(WxMediaCropLayout.b paramb, String paramString, ImageCropUI paramImageCropUI, com.tencent.mm.plugin.gallery.picker.b.b.b paramb1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    f(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WxMediaCropLayout>
  {
    g(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    h(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, x>
  {
    i(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    j(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(ImageCropUI paramImageCropUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(244475);
      paramBundle.setPadding(0, 0, 0, ax.aB((Context)this.BYs.getContext()));
      AppMethodBeat.o(244475);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244298);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = a.BXX;
      a.SV(9);
      this.BYs.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(244298);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244339);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ImageCropUI.d(this.BYs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(244339);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243539);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ImageCropUI.e(this.BYs).getLayout().icc();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243539);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240830);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ImageCropUI.e(this.BYs).getLayout().icd();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240830);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(244058);
      if (!ImageCropUI.a(this.BYs))
      {
        AppMethodBeat.o(244058);
        return true;
      }
      switch (ImageCropUI.f(this.BYs))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(244058);
        return true;
        ImageCropUI.d(this.BYs);
        continue;
        ImageCropUI.g(this.BYs);
        continue;
        ImageCropUI.h(this.BYs);
        continue;
        ImageCropUI.i(this.BYs);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(241185);
      paramMenuItem = a.BXX;
      a.SV(9);
      this.BYs.finish();
      AppMethodBeat.o(241185);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMattingCropLayout$1$1"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    r(WxMediaCropLayout paramWxMediaCropLayout, ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initShowView$2$1"})
  static final class s
    implements Runnable
  {
    s(ImageView paramImageView, ImageCropUI paramImageCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(241726);
      Object localObject;
      if ((this.wXn.getWidth() == 0) || (this.wXn.getHeight() == 0))
      {
        localObject = ak.hIy();
        ImageCropUI.a(jdField_this, ((ak.a)localObject).width, ((ak.a)localObject).height);
      }
      for (;;)
      {
        this.wXn.setVisibility(0);
        ImageCropUI.b(jdField_this);
        localObject = ImageCropUI.c(jdField_this);
        if (localObject == null) {
          break;
        }
        ((s)localObject).dismiss();
        AppMethodBeat.o(241726);
        return;
        ImageCropUI.a(jdField_this, this.wXn.getWidth(), this.wXn.getHeight());
      }
      AppMethodBeat.o(241726);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    t(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    u(ImageCropUI paramImageCropUI, aa.f paramf, Intent paramIntent)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    v(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "imgPath", "", "imgView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, x>
  {
    w(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    x(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WeImageView>
  {
    y(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI
 * JD-Core Version:    0.7.0.1
 */