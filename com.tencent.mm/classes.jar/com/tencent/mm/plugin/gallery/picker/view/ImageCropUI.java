package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/ImageCropUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "backupPath", "", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "cancelCropButton", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getCancelCropButton", "()Landroid/widget/Button;", "cancelCropButton$delegate", "Lkotlin/Lazy;", "confirmCropButton", "getConfirmCropButton", "confirmCropButton$delegate", "cropImgMode", "", "getCropImgMode", "()I", "cropImgMode$delegate", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "cropOperateLayout", "Landroid/widget/LinearLayout;", "getCropOperateLayout", "()Landroid/widget/LinearLayout;", "cropOperateLayout$delegate", "cropping", "", "defaultImageContentCreator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "mediaPath", "Landroid/widget/ImageView;", "imgView", "Lkotlin/Function2;", "width", "height", "", "loadedCallback", "degree", "displayBitmap", "Landroid/graphics/Bitmap;", "getDisplayBitmap", "()Landroid/graphics/Bitmap;", "setDisplayBitmap", "(Landroid/graphics/Bitmap;)V", "emojiBmp", "imageLoaded", "imgPath", "getImgPath", "imgPath$delegate", "isGif", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mattingImageInfo", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "outputPath", "getOutputPath", "outputPath$delegate", "previewMatting", "getPreviewMatting", "()Lkotlin/jvm/functions/Function3;", "previewView", "getPreviewView", "()Landroid/widget/ImageView;", "previewView$delegate", "rotateButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRotateButton", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rotateButton$delegate", "undoButton", "getUndoButton", "undoButton$delegate", "backgroundCrop", "", "compressMattingImage", "source", "cropAvatar", "getCropBackImg", "getCropMatrix", "Landroid/graphics/Matrix;", "imgWidth", "imgHeight", "scrWidth", "scrHeight", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getFullVisibilityRect", "w", "h", "getImageInfo", "imagePath", "getLayoutId", "initMMView", "initMattingCropLayout", "initShowView", "loadBackgroundPreviewImg", "loadPreview", "mattingCrop", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "previewCrop", "compress", "saveImg", "bm", "recycle", "setRequestedOrientation", "requestedOrientation", "showLoadingDialog", "Companion", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImageCropUI
  extends MMActivity
{
  public static final ImageCropUI.a HKl;
  private com.tencent.mm.plugin.gallery.picker.b.b FRJ;
  private final j FRv;
  private int[] HKA;
  private Bitmap HKB;
  private boolean HKC;
  final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> HKD;
  private final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> HKE;
  private final j HKm;
  private final j HKn;
  private final j HKo;
  private final j HKp;
  private final j HKq;
  private final j HKr;
  private final j HKs;
  private final j HKt;
  private String HKu;
  Bitmap HKv;
  private final j HKw;
  private boolean HKx;
  private int HKy;
  private boolean HKz;
  private w lKp;
  
  static
  {
    AppMethodBeat.i(289565);
    HKl = new ImageCropUI.a((byte)0);
    AppMethodBeat.o(289565);
  }
  
  public ImageCropUI()
  {
    AppMethodBeat.i(289408);
    this.FRv = k.cm((kotlin.g.a.a)new g(this));
    this.HKm = k.cm((kotlin.g.a.a)new p(this));
    this.HKn = k.cm((kotlin.g.a.a)new h(this));
    this.HKo = k.cm((kotlin.g.a.a)new c(this));
    this.HKp = k.cm((kotlin.g.a.a)new d(this));
    this.HKq = k.cm((kotlin.g.a.a)new r(this));
    this.HKr = k.cm((kotlin.g.a.a)new q(this));
    this.HKs = k.cm((kotlin.g.a.a)new ImageCropUI.j(this));
    this.HKt = k.cm((kotlin.g.a.a)new ImageCropUI.f(this));
    this.HKu = "";
    this.HKw = k.cm((kotlin.g.a.a)new ImageCropUI.n(this));
    this.HKD = ((q)new ImageCropUI.o(this));
    this.HKE = ((q)new ImageCropUI.i(this));
    AppMethodBeat.o(289408);
  }
  
  private static final void a(View paramView, ImageCropUI paramImageCropUI)
  {
    AppMethodBeat.i(289469);
    s.u(paramImageCropUI, "this$0");
    paramView.setPadding(0, 0, 0, bf.bk((Context)paramImageCropUI.getContext()));
    AppMethodBeat.o(289469);
  }
  
  private static final void a(ImageView paramImageView, ImageCropUI paramImageCropUI)
  {
    AppMethodBeat.i(289463);
    s.u(paramImageCropUI, "this$0");
    if ((paramImageView.getWidth() == 0) || (paramImageView.getHeight() == 0))
    {
      ao.a locala = ao.jkI();
      paramImageCropUI.iZ(locala.width, locala.height);
    }
    for (;;)
    {
      paramImageView.setVisibility(0);
      paramImageCropUI.HKC = true;
      paramImageView = paramImageCropUI.lKp;
      if (paramImageView != null) {
        paramImageView.dismiss();
      }
      AppMethodBeat.o(289463);
      return;
      paramImageCropUI.iZ(paramImageView.getWidth(), paramImageView.getHeight());
    }
  }
  
  private static final void a(ImageCropUI paramImageCropUI, View paramView)
  {
    AppMethodBeat.i(289471);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramImageCropUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramImageCropUI, "this$0");
    paramView = a.HKk;
    a.WC(9);
    paramImageCropUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289471);
  }
  
  private static final boolean a(ImageCropUI paramImageCropUI, final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(289487);
    s.u(paramImageCropUI, "this$0");
    if (!paramImageCropUI.HKC)
    {
      AppMethodBeat.o(289487);
      return true;
    }
    switch (paramImageCropUI.fBe())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(289487);
      return true;
      paramImageCropUI.fBg();
      continue;
      if (TextUtils.isEmpty((CharSequence)paramImageCropUI.fBf())) {}
      Object localObject;
      for (paramMenuItem = paramImageCropUI.aJL();; paramMenuItem = paramImageCropUI.fBf())
      {
        s.s(paramMenuItem, "if (TextUtils.isEmpty(ou…     outputPath\n        }");
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImage_Compress_Img", true);
        ((Intent)localObject).putExtra("CropImage_OutputPath", paramMenuItem);
        ((Intent)localObject).putExtra("from_source", paramImageCropUI.getIntent().getIntExtra("from_source", 0));
        paramMenuItem = a.HKk;
        a.WC(9);
        paramImageCropUI.setResult(-1, (Intent)localObject);
        paramImageCropUI.finish();
        break;
        paramMenuItem = y.bi(paramImageCropUI.aJL(), 0, -1);
        y.f(paramImageCropUI.fBf(), paramMenuItem, paramMenuItem.length);
      }
      if (!paramImageCropUI.HKx)
      {
        paramImageCropUI.HKx = true;
        paramImageCropUI.showLoadingDialog();
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new b(paramImageCropUI));
        continue;
        if (!paramImageCropUI.HKx)
        {
          paramImageCropUI.HKx = true;
          paramImageCropUI.showLoadingDialog();
          paramMenuItem = new Intent();
          localObject = new ah.f();
          ((ah.f)localObject).aqH = "";
          com.tencent.mm.ae.d.B((kotlin.g.a.a)new m(paramImageCropUI, (ah.f)localObject, paramMenuItem));
        }
      }
    }
  }
  
  private static boolean a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(289450);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(289450);
      return false;
    }
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
      Log.i("MicroMsg.AvatarCropUI", "saveBitmapToImage successful ");
      AppMethodBeat.o(289450);
      return true;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AvatarCropUI", (Throwable)paramString, "", new Object[0]);
      Log.e("MicroMsg.AvatarCropUI", s.X("saveBitmapToImage failed: ", paramString));
      AppMethodBeat.o(289450);
    }
    return false;
  }
  
  private final String aJL()
  {
    AppMethodBeat.i(289423);
    String str = (String)this.HKs.getValue();
    AppMethodBeat.o(289423);
    return str;
  }
  
  private static final void b(ImageCropUI paramImageCropUI, View paramView)
  {
    AppMethodBeat.i(289474);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramImageCropUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramImageCropUI, "this$0");
    paramImageCropUI.fBg();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289474);
  }
  
  private static final boolean b(ImageCropUI paramImageCropUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(289490);
    s.u(paramImageCropUI, "this$0");
    paramMenuItem = a.HKk;
    a.WC(9);
    paramImageCropUI.finish();
    AppMethodBeat.o(289490);
    return true;
  }
  
  private static final void c(ImageCropUI paramImageCropUI, View paramView)
  {
    AppMethodBeat.i(289480);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramImageCropUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramImageCropUI, "this$0");
    paramImageCropUI.fbn().getLayout().jHq();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289480);
  }
  
  private static final void d(ImageCropUI paramImageCropUI, View paramView)
  {
    AppMethodBeat.i(289482);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramImageCropUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/ImageCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramImageCropUI, "this$0");
    paramImageCropUI.fbn().getLayout().jHr();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gallery/picker/view/ImageCropUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289482);
  }
  
  private final ImageView fBd()
  {
    AppMethodBeat.i(289417);
    ImageView localImageView = (ImageView)this.HKm.getValue();
    AppMethodBeat.o(289417);
    return localImageView;
  }
  
  private final int fBe()
  {
    AppMethodBeat.i(289431);
    int i = ((Number)this.HKt.getValue()).intValue();
    AppMethodBeat.o(289431);
    return i;
  }
  
  private final String fBf()
  {
    AppMethodBeat.i(289434);
    String str = (String)this.HKw.getValue();
    AppMethodBeat.o(289434);
    return str;
  }
  
  private final void fBg()
  {
    AppMethodBeat.i(289440);
    if ((TextUtils.isEmpty((CharSequence)aJL())) || (this.HKx))
    {
      AppMethodBeat.o(289440);
      return;
    }
    this.HKx = true;
    showLoadingDialog();
    com.tencent.mm.plugin.gallery.picker.b.b.b localb1 = new com.tencent.mm.plugin.gallery.picker.b.b.b();
    localb1.HJF = 100;
    localb1.maxWidth = 960;
    localb1.maxHeight = 960;
    localb1.filePath = fBf();
    Log.i("MicroMsg.AvatarCropUI", "get avatar/cover config");
    WxMediaCropLayout.b localb = fbn().getCurrentCropInfo();
    if (y.ZC(aJL())) {}
    for (Object localObject1 = aJL();; localObject1 = "")
    {
      s.s(localObject1, "if (VFSFileOp.fileExists…  saveImg()\n            }");
      Log.i("MicroMsg.AvatarCropUI", s.X("input path: ", localObject1));
      localObject2 = new com.tencent.mm.plugin.gallery.picker.b.b(localb1);
      com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject2, (String)localObject1, 1, localb.fBj(), localb.Gl, localb.yok, localb.viewRect, 0, (m)new e(this));
      localObject1 = ah.aiuX;
      this.FRJ = ((com.tencent.mm.plugin.gallery.picker.b.b)localObject2);
      AppMethodBeat.o(289440);
      return;
      localObject1 = this.HKv;
      if (localObject1 != null) {
        break;
      }
    }
    Object localObject2 = s.X(com.tencent.mm.loader.i.b.bny(), Long.valueOf(System.currentTimeMillis()));
    if (a((String)localObject2, (Bitmap)localObject1, false))
    {
      s.u(localObject2, "<set-?>");
      this.HKu = ((String)localObject2);
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject2 = "";
    }
  }
  
  private final Bitmap fBh()
  {
    AppMethodBeat.i(289445);
    Object localObject1 = BitmapUtil.createBitmap(fBd().getWidth(), fBd().getHeight(), Bitmap.Config.ARGB_8888);
    if (localObject1 == null)
    {
      localObject1 = a.HKk;
      a.WC(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(289445);
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject1);
    fBd().draw(localCanvas);
    localCanvas.setBitmap(null);
    try
    {
      localObject1 = BitmapUtil.cropBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight() - com.tencent.mm.view.d.e((Context)this, 56.0F), true);
      AppMethodBeat.o(289445);
      return localObject1;
    }
    finally
    {
      a locala = a.HKk;
      a.WC(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(289445);
    }
    return null;
  }
  
  private final RectF fba()
  {
    AppMethodBeat.i(289458);
    Object localObject = ao.jkI();
    float f1 = ((ao.a)localObject).width - getContext().getResources().getDimension(b.c.Edge_6A);
    float f2 = (((ao.a)localObject).height - f1) / 2.0F;
    localObject = new RectF(getContext().getResources().getDimension(b.c.Edge_3A), f2, getContext().getResources().getDimension(b.c.Edge_3A) + f1, f1 + f2);
    AppMethodBeat.o(289458);
    return localObject;
  }
  
  private final WxMediaCropLayout fbn()
  {
    AppMethodBeat.i(289410);
    WxMediaCropLayout localWxMediaCropLayout = (WxMediaCropLayout)this.FRv.getValue();
    AppMethodBeat.o(289410);
    return localWxMediaCropLayout;
  }
  
  private final void iZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(289436);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      localObject1 = a.HKk;
      a.WC(8);
      setResult(-1);
      finish();
      AppMethodBeat.o(289436);
      return;
    }
    this.HKy = BackwardSupportUtil.ExifHelper.getExifOrientation(aJL());
    if ((this.HKy == 90) || (this.HKy == 270))
    {
      i = paramInt2;
      if ((this.HKy == 90) || (this.HKy == 270)) {
        paramInt2 = paramInt1;
      }
      localObject1 = a.HKk;
      a.WC(4);
      localObject1 = a.HKk;
      a.WD(14);
      localObject1 = a.HKk;
      a.WC(13);
      Log.i("MicroMsg.AvatarCropUI", "preview background");
      localObject1 = BitmapUtil.extractThumbNail(aJL(), paramInt2, i, true);
      if (localObject1 != null) {
        break label207;
      }
    }
    label207:
    for (Object localObject1 = null;; localObject1 = BitmapUtil.rotate((Bitmap)localObject1, this.HKy))
    {
      if (localObject1 != null) {
        break label222;
      }
      localObject1 = null;
      if (localObject1 == null)
      {
        Log.i("MicroMsg.AvatarCropUI", "background image decode fail");
        localObject1 = a.HKk;
        a.WC(8);
        setResult(-1);
        finish();
      }
      AppMethodBeat.o(289436);
      return;
      i = paramInt1;
      break;
    }
    label222:
    Log.i("MicroMsg.AvatarCropUI", "background image decode successful");
    Object localObject2 = a.HKk;
    a.WD(20);
    localObject2 = a.HKk;
    a.WC(19);
    localObject2 = fBd();
    paramInt1 = ((Bitmap)localObject1).getWidth();
    paramInt2 = ((Bitmap)localObject1).getHeight();
    int i = ((ImageView)localObject2).getWidth();
    int j = ((ImageView)localObject2).getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    if (f1 < f2)
    {
      label319:
      if (i <= j) {
        break label401;
      }
      f2 = j;
      label331:
      float f3 = f2 / paramInt1;
      f2 /= paramInt2;
      if (f3 <= f2) {
        break label409;
      }
      f2 = f3;
    }
    label401:
    label409:
    for (;;)
    {
      if (f1 < 1.0D) {
        localMatrix.postScale(f2, f2);
      }
      ((ImageView)localObject2).setImageMatrix(localMatrix);
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
      localObject1 = localObject2;
      break;
      f1 = f2;
      break label319;
      f2 = i;
      break label331;
    }
  }
  
  private final void showLoadingDialog()
  {
    AppMethodBeat.i(289453);
    w localw = this.lKp;
    if (localw != null) {
      localw.dismiss();
    }
    this.lKp = w.a((Context)this, (CharSequence)getString(b.i.loading_tips), false, 0, null);
    AppMethodBeat.o(289453);
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.plugin.gallery.b.f.image_crop;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(289605);
    super.onBackPressed();
    Object localObject = this.FRJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.gallery.picker.b.b)localObject).destroy();
    }
    localObject = a.HKk;
    a.WC(9);
    AppMethodBeat.o(289605);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(289593);
    super.onCreate(paramBundle);
    paramBundle = a.HKk;
    a.WC(10);
    setMMTitle("");
    if (fBe() == 1)
    {
      getWindow().setFlags(201327616, 201327616);
      setLightNavigationbarIcon();
      paramBundle = findViewById(b.e.image_crop_root_layout);
      paramBundle.setPadding(0, 0, 0, bf.bk((Context)getContext()));
      paramBundle.post(new ImageCropUI..ExternalSyntheticLambda6(paramBundle, this));
      setActionbarColor(com.tencent.mm.plugin.gallery.b.b.transparent);
      setActionbarColor(-16777216);
      fullScreenNoTitleBar(true, 0L);
      ((LinearLayout)this.HKn.getValue()).setVisibility(0);
      ((Button)this.HKo.getValue()).setOnClickListener(new ImageCropUI..ExternalSyntheticLambda2(this));
      ((Button)this.HKp.getValue()).setOnClickListener(new ImageCropUI..ExternalSyntheticLambda3(this));
      ((WeImageView)this.HKr.getValue()).setOnClickListener(new ImageCropUI..ExternalSyntheticLambda4(this));
      ((WeImageView)this.HKq.getValue()).setOnClickListener(new ImageCropUI..ExternalSyntheticLambda5(this));
      this.HKC = false;
      showLoadingDialog();
      switch (fBe())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(289593);
      return;
      addTextOptionMenu(0, getString(b.i.gallery_cropimage_use), new ImageCropUI..ExternalSyntheticLambda1(this), null, y.b.adEJ);
      setBackBtn(new ImageCropUI..ExternalSyntheticLambda0(this));
      break;
      if (getIntent().getIntExtra("CropImage_from_scene", 0) == 3)
      {
        paramBundle = a.HKk;
        a.WC(0);
        Log.i("MicroMsg.AvatarCropUI", "scene avatar");
      }
      for (;;)
      {
        paramBundle = fbn();
        paramBundle.setVisibility(0);
        paramBundle.setShowBorder(false);
        paramBundle.a(fba(), WxCropOperationLayout.j.NTl);
        s.s(paramBundle, "");
        long l = System.currentTimeMillis();
        String str = aJL();
        s.s(str, "imgPath");
        WxMediaCropLayout.a(paramBundle, l, str, true, null, this.HKE, 8);
        AppMethodBeat.o(289593);
        return;
        paramBundle = a.HKk;
        a.WC(1);
        Log.i("MicroMsg.AvatarCropUI", "scene cover");
      }
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new l(this));
      AppMethodBeat.o(289593);
      return;
      paramBundle = a.HKk;
      a.WC(2);
      Log.i("MicroMsg.AvatarCropUI", "scene background");
      paramBundle = fBd();
      paramBundle.post(new ImageCropUI..ExternalSyntheticLambda7(paramBundle, this));
      AppMethodBeat.o(289593);
      return;
      paramBundle = a.HKk;
      a.WC(3);
      Log.i("MicroMsg.AvatarCropUI", "scene emoji");
      paramBundle = fbn();
      paramBundle.setVisibility(0);
      paramBundle.setShowBorder(false);
      paramBundle.setCropLayoutScaleType(CropLayout.e.agdv);
      paramBundle.fBi();
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new k(this, paramBundle));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(289595);
    super.onDestroy();
    this.HKv = null;
    if ((!TextUtils.isEmpty((CharSequence)this.HKu)) && (y.ZC(this.HKu))) {
      y.deleteFile(this.HKu);
    }
    AppMethodBeat.o(289595);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(289599);
    super.setRequestedOrientation(1);
    AppMethodBeat.o(289599);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Button>
  {
    c(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Button>
  {
    d(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isSuccessful", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<Boolean, com.tencent.mm.plugin.gallery.picker.b.b.f, ah>
  {
    e(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<WxMediaCropLayout>
  {
    g(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    h(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(ImageCropUI paramImageCropUI, WxMediaCropLayout paramWxMediaCropLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<ah>
  {
    l(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<ah>
  {
    m(ImageCropUI paramImageCropUI, ah.f<String> paramf, Intent paramIntent)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    p(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    q(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    r(ImageCropUI paramImageCropUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.ImageCropUI
 * JD-Core Version:    0.7.0.1
 */