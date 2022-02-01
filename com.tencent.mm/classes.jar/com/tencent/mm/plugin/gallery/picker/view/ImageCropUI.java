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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.af.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.o;
import d.f;
import d.g;
import d.g.a.m;
import d.g.b.y.f;
import d.l;
import d.z;
import java.io.IOException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backupPath", "", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "cancelCropButton", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getCancelCropButton", "()Landroid/widget/Button;", "cancelCropButton$delegate", "Lkotlin/Lazy;", "confirmCropButton", "getConfirmCropButton", "confirmCropButton$delegate", "cropImgMode", "", "getCropImgMode", "()I", "cropImgMode$delegate", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "cropOperateLayout", "Landroid/widget/LinearLayout;", "getCropOperateLayout", "()Landroid/widget/LinearLayout;", "cropOperateLayout$delegate", "cropping", "", "defaultImageContentCreator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "degree", "displayBitmap", "Landroid/graphics/Bitmap;", "getDisplayBitmap", "()Landroid/graphics/Bitmap;", "setDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "emojiBmp", "imageLoaded", "imgPath", "getImgPath", "imgPath$delegate", "isGif", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mattingImageInfo", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "outputPath", "getOutputPath", "outputPath$delegate", "previewMatting", "getPreviewMatting", "()Lkotlin/jvm/functions/Function3;", "previewView", "getPreviewView", "()Landroid/widget/ImageView;", "previewView$delegate", "rotateButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRotateButton", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rotateButton$delegate", "undoButton", "getUndoButton", "undoButton$delegate", "backgroundCrop", "", "compressMattingImage", "source", "cropAvatar", "getCropBackImg", "getCropMatrix", "Landroid/graphics/Matrix;", "imgWidth", "imgHeight", "scrWidth", "scrHeight", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getFullVisibilityRect", "w", "h", "getImageInfo", "imagePath", "getLayoutId", "initMMView", "initMattingCropLayout", "initShowView", "loadBackgroundPreviewImg", "loadPreview", "mattingCrop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "previewCrop", "compress", "saveImg", "bm", "recycle", "setRequestedOrientation", "requestedOrientation", "showLoadingDialog", "Companion", "plugin-gallery_release"})
public final class ImageCropUI
  extends MMActivity
{
  public static final ImageCropUI.a tUL;
  private com.tencent.mm.ui.base.p fSP;
  private final f sOc;
  private com.tencent.mm.plugin.gallery.picker.b.b sOq;
  private String tUA;
  Bitmap tUB;
  private final f tUC;
  private boolean tUD;
  private int tUE;
  private boolean tUF;
  private int[] tUG;
  private Bitmap tUH;
  private boolean tUI;
  final d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> tUJ;
  private final d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> tUK;
  private final f tUs;
  private final f tUt;
  private final f tUu;
  private final f tUv;
  private final f tUw;
  private final f tUx;
  private final f tUy;
  private final f tUz;
  
  static
  {
    AppMethodBeat.i(186270);
    tUL = new ImageCropUI.a((byte)0);
    AppMethodBeat.o(186270);
  }
  
  public ImageCropUI()
  {
    AppMethodBeat.i(186269);
    this.sOc = g.O((d.g.a.a)new g(this));
    this.tUs = g.O((d.g.a.a)new x(this));
    this.tUt = g.O((d.g.a.a)new h(this));
    this.tUu = g.O((d.g.a.a)new c(this));
    this.tUv = g.O((d.g.a.a)new d(this));
    this.tUw = g.O((d.g.a.a)new z(this));
    this.tUx = g.O((d.g.a.a)new y(this));
    this.tUy = g.O((d.g.a.a)new j(this));
    this.tUz = g.O((d.g.a.a)new f(this));
    this.tUA = "";
    this.tUC = g.O((d.g.a.a)new v(this));
    this.tUJ = ((d.g.a.q)new w(this));
    this.tUK = ((d.g.a.q)new i(this));
    AppMethodBeat.o(186269);
  }
  
  private final String Wb()
  {
    AppMethodBeat.i(186257);
    String str = (String)this.tUy.getValue();
    AppMethodBeat.o(186257);
    return str;
  }
  
  private static boolean a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(186265);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(186265);
      return false;
    }
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
      ae.i("MicroMsg.AvatarCropUI", "saveBitmapToImage successful ");
      AppMethodBeat.o(186265);
      return true;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.AvatarCropUI", (Throwable)paramString, "", new Object[0]);
      ae.e("MicroMsg.AvatarCropUI", "saveBitmapToImage failed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(186265);
    }
    return false;
  }
  
  private final void aSw()
  {
    AppMethodBeat.i(186267);
    com.tencent.mm.ui.base.p localp = this.fSP;
    if (localp != null) {
      localp.dismiss();
    }
    this.fSP = com.tencent.mm.ui.base.p.a((Context)this, (CharSequence)getString(2131760709), false, 0, null);
    AppMethodBeat.o(186267);
  }
  
  private final RectF cMl()
  {
    AppMethodBeat.i(186268);
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
    AppMethodBeat.o(186268);
    return localObject;
  }
  
  private final WxMediaCropLayout cMs()
  {
    AppMethodBeat.i(186255);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.sOc.getValue();
    AppMethodBeat.o(186255);
    return localWxMediaCropLayout;
  }
  
  private final ImageView cYm()
  {
    AppMethodBeat.i(186256);
    ImageView localImageView = (ImageView)this.tUs.getValue();
    AppMethodBeat.o(186256);
    return localImageView;
  }
  
  private final int cYn()
  {
    AppMethodBeat.i(186258);
    int i = ((Number)this.tUz.getValue()).intValue();
    AppMethodBeat.o(186258);
    return i;
  }
  
  private final String cYo()
  {
    AppMethodBeat.i(186259);
    String str = (String)this.tUC.getValue();
    AppMethodBeat.o(186259);
    return str;
  }
  
  private final Bitmap cYp()
  {
    AppMethodBeat.i(186264);
    Object localObject = cYm();
    d.g.b.p.g(localObject, "previewView");
    int i = ((ImageView)localObject).getWidth();
    localObject = cYm();
    d.g.b.p.g(localObject, "previewView");
    localObject = h.createBitmap(i, ((ImageView)localObject).getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject == null)
    {
      localObject = a.tUr;
      a.HG(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(186264);
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    cYm().draw(localCanvas);
    localCanvas.setBitmap(null);
    try
    {
      localObject = h.f((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight() - com.tencent.mm.view.b.e((Context)this, 56.0F));
      AppMethodBeat.o(186264);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      a locala = a.tUr;
      a.HG(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(186264);
    }
    return null;
  }
  
  public final int getLayoutId()
  {
    return 2131496153;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(186263);
    super.onBackPressed();
    Object localObject = this.sOq;
    if (localObject != null) {
      ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).destroy();
    }
    localObject = a.tUr;
    a.HG(9);
    AppMethodBeat.o(186263);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186260);
    super.onCreate(paramBundle);
    paramBundle = a.tUr;
    a.HG(10);
    setMMTitle("");
    if (cYn() == 1)
    {
      getWindow().setFlags(201327616, 201327616);
      setLightNavigationbarIcon();
      paramBundle = findViewById(2131307208);
      paramBundle.setPadding(0, 0, 0, ar.en((Context)getContext()));
      paramBundle.post((Runnable)new ImageCropUI.k(this, paramBundle));
      setActionbarColor(2131101053);
      setActionbarColor(-16777216);
      fullScreenNoTitleBar(true, 0L);
      paramBundle = (LinearLayout)this.tUt.getValue();
      d.g.b.p.g(paramBundle, "cropOperateLayout");
      paramBundle.setVisibility(0);
      ((Button)this.tUu.getValue()).setOnClickListener((View.OnClickListener)new ImageCropUI.l(this));
      ((Button)this.tUv.getValue()).setOnClickListener((View.OnClickListener)new ImageCropUI.m(this));
      ((WeImageView)this.tUx.getValue()).setOnClickListener((View.OnClickListener)new n(this));
      ((WeImageView)this.tUw.getValue()).setOnClickListener((View.OnClickListener)new o(this));
      this.tUI = false;
      aSw();
      switch (cYn())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(186260);
      return;
      addTextOptionMenu(0, getString(2131763112), (MenuItem.OnMenuItemClickListener)new p(this), null, s.b.JwA);
      setBackBtn((MenuItem.OnMenuItemClickListener)new ImageCropUI.q(this));
      break;
      if (getIntent().getIntExtra("CropImage_from_scene", 0) == 3)
      {
        paramBundle = a.tUr;
        a.HG(0);
        ae.i("MicroMsg.AvatarCropUI", "scene avatar");
      }
      for (;;)
      {
        paramBundle = cMs();
        paramBundle.setVisibility(0);
        paramBundle.setShowBorder(false);
        paramBundle.a(cMl(), WxCropOperationLayout.j.xYR);
        WxMediaCropLayout.a(paramBundle, System.currentTimeMillis(), Wb(), true, null, this.tUK, 8);
        AppMethodBeat.o(186260);
        return;
        paramBundle = a.tUr;
        a.HG(1);
        ae.i("MicroMsg.AvatarCropUI", "scene cover");
      }
      c.b(null, (d.g.a.a)new t(this));
      AppMethodBeat.o(186260);
      return;
      paramBundle = a.tUr;
      a.HG(2);
      ae.i("MicroMsg.AvatarCropUI", "scene background");
      paramBundle = cYm();
      paramBundle.post((Runnable)new s(paramBundle, this));
      AppMethodBeat.o(186260);
      return;
      paramBundle = a.tUr;
      a.HG(3);
      ae.i("MicroMsg.AvatarCropUI", "scene emoji");
      paramBundle = cMs();
      paramBundle.setVisibility(0);
      paramBundle.setShowBorder(false);
      paramBundle.setCropLayoutScaleType(CropLayout.e.LrN);
      paramBundle.cYq();
      c.b(null, (d.g.a.a)new r(paramBundle, this));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186261);
    super.onDestroy();
    this.tUB = null;
    if ((!TextUtils.isEmpty((CharSequence)this.tUA)) && (o.fB(this.tUA))) {
      o.deleteFile(this.tUA);
    }
    AppMethodBeat.o(186261);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(186262);
    super.setRequestedOrientation(1);
    AppMethodBeat.o(186262);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<Button>
  {
    c(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<Button>
  {
    d(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isSuccessful", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$cropAvatar$1$1$1", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$$special$$inlined$apply$lambda$1"})
  static final class e
    extends d.g.b.q
    implements m<Boolean, b.f, z>
  {
    e(WxMediaCropLayout.b paramb, String paramString, ImageCropUI paramImageCropUI, b.b paramb1)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    f(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<WxMediaCropLayout>
  {
    g(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<LinearLayout>
  {
    h(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mediaPath", "", "imageView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, z>
  {
    i(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    j(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186231);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ImageCropUI.e(this.tUM).getLayout().fQj();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186231);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(ImageCropUI paramImageCropUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186232);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ImageCropUI.e(this.tUM).getLayout().fQk();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMMView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186232);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(ImageCropUI paramImageCropUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(186233);
      if (!ImageCropUI.a(this.tUM))
      {
        AppMethodBeat.o(186233);
        return true;
      }
      switch (ImageCropUI.f(this.tUM))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(186233);
        return true;
        ImageCropUI.d(this.tUM);
        continue;
        ImageCropUI.g(this.tUM);
        continue;
        ImageCropUI.h(this.tUM);
        continue;
        ImageCropUI.i(this.tUM);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initMattingCropLayout$1$1"})
  static final class r
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    r(WxMediaCropLayout paramWxMediaCropLayout, ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI$initShowView$2$1"})
  static final class s
    implements Runnable
  {
    s(ImageView paramImageView, ImageCropUI paramImageCropUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(186238);
      Object localObject;
      if ((this.tVb.getWidth() == 0) || (this.tVb.getHeight() == 0))
      {
        localObject = af.fBI();
        ImageCropUI.a(jdField_this, ((af.a)localObject).width, ((af.a)localObject).height);
      }
      for (;;)
      {
        this.tVb.setVisibility(0);
        ImageCropUI.b(jdField_this);
        localObject = ImageCropUI.c(jdField_this);
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.ui.base.p)localObject).dismiss();
        AppMethodBeat.o(186238);
        return;
        ImageCropUI.a(jdField_this, this.tVb.getWidth(), this.tVb.getHeight());
      }
      AppMethodBeat.o(186238);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    t(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class u
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    u(ImageCropUI paramImageCropUI, y.f paramf, Intent paramIntent)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class v
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    v(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "imgPath", "", "imgView", "Landroid/widget/ImageView;", "loadedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, z>
  {
    w(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class x
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    x(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class y
    extends d.g.b.q
    implements d.g.a.a<WeImageView>
  {
    y(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI
 * JD-Core Version:    0.7.0.1
 */