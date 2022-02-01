package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "addCoverBtn", "Landroid/view/View;", "addCoverContainer", "addCoverIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addCoverImage", "addCoverText", "Landroid/widget/TextView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "changeCoverBtn", "Landroid/widget/Button;", "coverImageView", "Landroid/widget/ImageView;", "coverManagerContainer", "coverMaskContainer", "coverMaskImageView", "deleteCoverBtn", "isCoverChangedByUser", "", "()Z", "setCoverChangedByUser", "(Z)V", "isCoverSet", "setCoverSet", "progressBar", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "thumbLocalPath", "", "getThumbLocalPath", "()Ljava/lang/String;", "setThumbLocalPath", "(Ljava/lang/String;)V", "addCover", "", "dismissProgress", "getDefaultContent", "Lkotlin/Pair;", "Landroid/graphics/Rect;", "", "input", "initView", "modifyCover", "imgPath", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCoverSet", "onCoverUnset", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCropImageSuccess", "imagePath", "selectCoverFromAlbum", "setCover", "coverUrl", "setCoverMaskMargin", "showProgress", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  public static final f.a AvG;
  private ImageView AuD;
  private w AvH;
  private WeImageView AvI;
  private View AvJ;
  private View AvK;
  private TextView AvL;
  private View AvM;
  private View AvN;
  private View AvO;
  private WeImageView AvP;
  String AvQ;
  boolean AvR;
  private boolean Avv;
  private ImageView enI;
  
  static
  {
    AppMethodBeat.i(348261);
    AvG = new f.a((byte)0);
    AppMethodBeat.o(348261);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348159);
    this.AvQ = "";
    AppMethodBeat.o(348159);
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(348232);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramf.dTI();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348232);
  }
  
  private static final void a(String paramString, f paramf, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(348221);
    s.u(paramf, "this$0");
    if (paramBitmap != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramf));
      Log.i("SimpleUIComponent", "[handleActivityProfileCover] [" + paramBitmap.getWidth() + ':' + paramBitmap.getHeight() + "] allocationByteCount=" + Util.getSizeKB(paramBitmap.getAllocationByteCount()) + " coverUrl=" + paramString);
    }
    AppMethodBeat.o(348221);
  }
  
  private void auO(String paramString)
  {
    AppMethodBeat.i(348162);
    s.u(paramString, "<set-?>");
    this.AvQ = paramString;
    AppMethodBeat.o(348162);
  }
  
  private final void auP(String paramString)
  {
    AppMethodBeat.i(348174);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.y.ZC(paramString)))
    {
      aa.makeText((Context)getActivity(), e.h.finder_activity_crop_cover_fail, 0).show();
      Log.e("SimpleUIComponent", s.X("ERROR! filePath=", paramString));
      AppMethodBeat.o(348174);
      return;
    }
    Log.d("SimpleUIComponent", s.X("onCropImageSuccess ", paramString));
    showProgress();
    this.AvR = true;
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      this.AvQ = str;
      setCover(paramString);
      dTG();
      AppMethodBeat.o(348174);
      return;
    }
  }
  
  private static final void b(f paramf, View paramView)
  {
    AppMethodBeat.i(348242);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramf.auO("");
    paramf.AvR = true;
    paramf.setCover("");
    paramf.dTH();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348242);
  }
  
  private static final void c(f paramf, View paramView)
  {
    AppMethodBeat.i(348248);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    if (paramf.Avv)
    {
      paramf.auO("");
      paramf.AvR = true;
      paramf.setCover("");
      paramf.dTH();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348248);
      return;
      paramf.dTI();
    }
  }
  
  private final void dTG()
  {
    Object localObject2 = null;
    AppMethodBeat.i(348191);
    this.Avv = true;
    Object localObject1 = this.AvM;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    int i = getResources().getColor(e.b.finder_activity_covered_icon_cover);
    ((MMActivity)getActivity()).getController().updataStatusBarIcon(true);
    Object localObject3 = this.enI;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("coverImageView");
      localObject1 = null;
    }
    ((ImageView)localObject1).setVisibility(0);
    localObject3 = this.AuD;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("coverMaskImageView");
      localObject1 = null;
    }
    ((ImageView)localObject1).setVisibility(0);
    localObject3 = this.AvO;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("coverMaskContainer");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject1 = this.AvL;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)getResources().getString(e.h.finder_activity_delete_cover_text));
    }
    localObject1 = this.AvL;
    if (localObject1 != null) {
      ((TextView)localObject1).setTextColor(i);
    }
    localObject3 = this.AvP;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("addCoverIcon");
      localObject1 = null;
    }
    ((WeImageView)localObject1).setIconColor(i);
    localObject1 = this.AvP;
    if (localObject1 == null)
    {
      s.bIx("addCoverIcon");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((WeImageView)localObject1).setImageResource(e.g.icons_filled_delete);
      localObject1 = this.AvK;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundResource(e.d.finder_activity_add_cover_covered_bg);
      }
      localObject1 = k.aeZF;
      ((e)k.d(getActivity()).q(e.class)).dTq();
      AppMethodBeat.o(348191);
      return;
    }
  }
  
  private final void dTH()
  {
    Object localObject2 = null;
    AppMethodBeat.i(348202);
    this.Avv = false;
    Object localObject1 = this.AvM;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    ((MMActivity)getActivity()).getController().updataStatusBarIcon(aw.isDarkMode());
    Object localObject3 = this.enI;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("coverImageView");
      localObject1 = null;
    }
    ((ImageView)localObject1).setVisibility(8);
    localObject3 = this.AuD;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("coverMaskImageView");
      localObject1 = null;
    }
    ((ImageView)localObject1).setVisibility(8);
    localObject3 = this.AvO;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("coverMaskContainer");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    int i = getResources().getColor(e.b.FG_0);
    localObject1 = this.AvL;
    if (localObject1 != null) {
      ((TextView)localObject1).setTextColor(i);
    }
    localObject3 = this.AvP;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("addCoverIcon");
      localObject1 = null;
    }
    ((WeImageView)localObject1).setIconColor(i);
    localObject1 = this.AvP;
    if (localObject1 == null)
    {
      s.bIx("addCoverIcon");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((WeImageView)localObject1).setImageResource(e.g.icon_filled_add);
      localObject1 = this.AvK;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundResource(e.d.finder_activity_add_cover_bg);
      }
      localObject1 = this.AvL;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)getResources().getString(e.h.finder_activity_add_cover_text));
      }
      localObject1 = k.aeZF;
      ((e)k.d(getActivity()).q(e.class)).dTr();
      AppMethodBeat.o(348202);
      return;
    }
  }
  
  private final void dTI()
  {
    AppMethodBeat.i(348212);
    if (!h.baE().isSDCardAvailable())
    {
      aa.nh((Context)getActivity());
      AppMethodBeat.o(348212);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("album_min_ratio_limit", 0.3333333F);
    localIntent.putExtra("album_max_ratio_limit", 3.0F);
    t.d((Activity)getActivity(), 20000, localIntent);
    AppMethodBeat.o(348212);
  }
  
  public final void dTF()
  {
    AppMethodBeat.i(348364);
    w localw = this.AvH;
    if ((localw != null) && (localw.isShowing())) {
      localw.dismiss();
    }
    AppMethodBeat.o(348364);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(348348);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      AppMethodBeat.o(348348);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(348348);
      return;
      localObject2 = paramIntent.getData();
      if (localObject2 == null)
      {
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label226;
        }
        paramInt1 = 1;
        label106:
        if (paramInt1 != 0)
        {
          Log.w("SimpleUIComponent", "filePath is null.try to getResultPhotoPath.");
          localObject1 = (Context)getActivity();
          localObject2 = bm.GlZ;
          localObject1 = t.g((Context)localObject1, paramIntent, bm.fil());
        }
        Log.i("SimpleUIComponent", "filePath[" + localObject1 + "] " + paramIntent);
        paramIntent = (CharSequence)localObject1;
        if ((paramIntent != null) && (paramIntent.length() != 0)) {
          break label231;
        }
      }
      label226:
      label231:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label236;
        }
        Log.e("SimpleUIComponent", "filePath is null.");
        AppMethodBeat.o(348348);
        return;
        localObject1 = ((Uri)localObject2).getPath();
        break;
        paramInt1 = 0;
        break label106;
      }
      label236:
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.d((Activity)getActivity(), (String)localObject1, "");
      AppMethodBeat.o(348348);
      return;
      Log.d("SimpleUIComponent", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      auP(paramIntent.getStringExtra("key_result_img_path"));
      AppMethodBeat.o(348348);
      return;
      localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (localObject1 == null) {}
      for (paramIntent = (Intent)localObject2;; paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath)
      {
        Log.i("SimpleUIComponent", s.X("REQUEST_CODE_CROP_FIX_IMAGE model: ", paramIntent));
        if (localObject1 == null) {
          break;
        }
        paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).NHK;
        s.s(paramIntent, "photo");
        if ((!paramIntent.booleanValue()) || (Util.isNullOrNil(((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath))) {
          break label380;
        }
        auP(((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
        AppMethodBeat.o(348348);
        return;
      }
      label380:
      aa.makeText((Context)getActivity(), e.h.finder_activity_crop_cover_fail, 0).show();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348332);
    super.onCreate(paramBundle);
    AppMethodBeat.o(348332);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    ah localah = null;
    AppMethodBeat.i(348321);
    super.onCreateAfter(paramBundle);
    paramBundle = getActivity().findViewById(e.e.activity_post_cover);
    s.s(paramBundle, "activity.findViewById(R.id.activity_post_cover)");
    this.enI = ((ImageView)paramBundle);
    paramBundle = getActivity().findViewById(e.e.finder_activity_post_add_cover_icon);
    s.s(paramBundle, "activity.findViewById(R.…vity_post_add_cover_icon)");
    this.AvP = ((WeImageView)paramBundle);
    paramBundle = getActivity().findViewById(e.e.activity_post_cover_mask);
    s.s(paramBundle, "activity.findViewById(R.…activity_post_cover_mask)");
    this.AuD = ((ImageView)paramBundle);
    paramBundle = getActivity().findViewById(e.e.activity_post_cover_container);
    s.s(paramBundle, "activity.findViewById(R.…ity_post_cover_container)");
    this.AvO = paramBundle;
    paramBundle = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    float f = paramBundle.widthPixels / 0.75F;
    ImageView localImageView = this.AuD;
    paramBundle = localImageView;
    if (localImageView == null)
    {
      s.bIx("coverMaskImageView");
      paramBundle = null;
    }
    ViewGroup.LayoutParams localLayoutParams = paramBundle.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(348321);
      throw paramBundle;
    }
    localLayoutParams.height = ((int)f);
    localImageView = this.AuD;
    paramBundle = localImageView;
    if (localImageView == null)
    {
      s.bIx("coverMaskImageView");
      paramBundle = null;
    }
    paramBundle.setLayoutParams(localLayoutParams);
    this.AvK = getActivity().findViewById(e.e.finder_activity_post_add_cover_container);
    this.AvL = ((TextView)getActivity().findViewById(e.e.finder_activity_post_add_cover_text));
    this.AvH = w.a((Context)getActivity(), (CharSequence)getString(b.i.app_waiting), false);
    this.AvJ = getActivity().findViewById(e.e.finder_activity_add_cover_btn);
    paramBundle = this.AvI;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new f..ExternalSyntheticLambda1(this));
    }
    paramBundle = getActivity().findViewById(e.e.finder_activity_delete_cover_btn);
    if (paramBundle == null)
    {
      paramBundle = localah;
      this.AvN = paramBundle;
      paramBundle = getIntent().getStringExtra("key_activity_local_cover_url");
      if (Util.isNullOrNil(paramBundle)) {
        break label422;
      }
      setCover(paramBundle);
      dTG();
    }
    for (;;)
    {
      paramBundle = this.AvK;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new f..ExternalSyntheticLambda2(this));
      }
      AppMethodBeat.o(348321);
      return;
      paramBundle.setOnClickListener(new f..ExternalSyntheticLambda0(this));
      localah = ah.aiuX;
      break;
      label422:
      dTH();
    }
  }
  
  public final void setCover(String paramString)
  {
    AppMethodBeat.i(348373);
    if (paramString == null) {}
    for (Object localObject1 = "";; localObject1 = paramString)
    {
      localObject1 = new i((String)localObject1);
      Object localObject2 = p.ExI;
      localObject1 = p.eCl().dk(localObject1);
      localObject2 = p.ExI;
      localObject2 = ((com.tencent.mm.loader.a.b)localObject1).a(p.a(p.a.ExU)).a(new f..ExternalSyntheticLambda3(paramString, this));
      localObject1 = this.enI;
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        s.bIx("coverImageView");
        paramString = null;
      }
      ((com.tencent.mm.loader.b)localObject2).d(paramString);
      AppMethodBeat.o(348373);
      return;
    }
  }
  
  public final void showProgress()
  {
    AppMethodBeat.i(348356);
    w localw = this.AvH;
    if ((localw != null) && (!localw.isShowing())) {
      localw.show();
    }
    AppMethodBeat.o(348356);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.f
 * JD-Core Version:    0.7.0.1
 */