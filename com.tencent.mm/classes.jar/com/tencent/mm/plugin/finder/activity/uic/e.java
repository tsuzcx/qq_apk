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
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "addCoverBtn", "Landroid/view/View;", "addCoverContainer", "addCoverIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addCoverImage", "addCoverText", "Landroid/widget/TextView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "changeCoverBtn", "Landroid/widget/Button;", "coverImageView", "Landroid/widget/ImageView;", "coverManagerContainer", "coverMaskContainer", "coverMaskImageView", "deleteCoverBtn", "isCoverChangedByUser", "", "()Z", "setCoverChangedByUser", "(Z)V", "isCoverSet", "setCoverSet", "progressBar", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "thumbLocalPath", "", "getThumbLocalPath", "()Ljava/lang/String;", "setThumbLocalPath", "(Ljava/lang/String;)V", "addCover", "", "dismissProgress", "getDefaultContent", "Lkotlin/Pair;", "Landroid/graphics/Rect;", "", "input", "initView", "modifyCover", "imgPath", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCoverSet", "onCoverUnset", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCropImageSuccess", "imagePath", "selectCoverFromAlbum", "selectCoverFromOrigin", "selectCoverFromOriginOld", "setCover", "coverUrl", "setCoverMaskMargin", "showProgress", "startCropImgForResult", "context", "Landroid/app/Activity;", "intent", "filePath", "resultFileName", "Companion", "plugin-finder_release"})
public final class e
  extends UIComponent
{
  public static final a wYI;
  private ImageView cvK;
  private ImageView wXE;
  private View wYA;
  private TextView wYB;
  private View wYC;
  private View wYD;
  private View wYE;
  private WeImageView wYF;
  String wYG;
  boolean wYH;
  boolean wYg;
  private s wYx;
  private WeImageView wYy;
  private View wYz;
  
  static
  {
    AppMethodBeat.i(238266);
    wYI = new a((byte)0);
    AppMethodBeat.o(238266);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(238264);
    this.wYG = "";
    AppMethodBeat.o(238264);
  }
  
  private final void aAG(String paramString)
  {
    AppMethodBeat.i(238251);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.u.agG(paramString)))
    {
      com.tencent.mm.ui.base.w.makeText((Context)getActivity(), b.j.finder_activity_crop_cover_fail, 0).show();
      Log.e("SimpleUIComponent", "ERROR! filePath=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(238251);
      return;
    }
    Log.d("SimpleUIComponent", "onCropImageSuccess ".concat(String.valueOf(paramString)));
    showProgress();
    this.wYH = true;
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      this.wYG = str;
      setCover(paramString);
      dmM();
      AppMethodBeat.o(238251);
      return;
    }
  }
  
  private final void dmM()
  {
    AppMethodBeat.i(238260);
    this.wYg = true;
    Object localObject = this.wYC;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    int i = getResources().getColor(b.c.finder_activity_covered_icon_cover);
    localObject = getActivity();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(238260);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).getController().updataStatusBarIcon(true);
    localObject = this.cvK;
    if (localObject == null) {
      p.bGy("coverImageView");
    }
    ((ImageView)localObject).setVisibility(0);
    localObject = this.wXE;
    if (localObject == null) {
      p.bGy("coverMaskImageView");
    }
    ((ImageView)localObject).setVisibility(0);
    localObject = this.wYE;
    if (localObject == null) {
      p.bGy("coverMaskContainer");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.wYB;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getResources().getString(b.j.finder_activity_delete_cover_text));
    }
    localObject = this.wYB;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(i);
    }
    localObject = this.wYF;
    if (localObject == null) {
      p.bGy("addCoverIcon");
    }
    ((WeImageView)localObject).setIconColor(i);
    localObject = this.wYF;
    if (localObject == null) {
      p.bGy("addCoverIcon");
    }
    ((WeImageView)localObject).setImageResource(com.tencent.mm.plugin.finder.b.i.icons_filled_delete);
    localObject = this.wYA;
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(b.e.finder_activity_add_cover_covered_bg);
    }
    localObject = g.Xox;
    ((d)g.b(getActivity()).i(d.class)).dmI();
    AppMethodBeat.o(238260);
  }
  
  private final void dmN()
  {
    AppMethodBeat.i(238262);
    this.wYg = false;
    Object localObject = this.wYC;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = getActivity();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(238262);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).getController().updataStatusBarIcon(ar.isDarkMode());
    localObject = this.cvK;
    if (localObject == null) {
      p.bGy("coverImageView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.wXE;
    if (localObject == null) {
      p.bGy("coverMaskImageView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.wYE;
    if (localObject == null) {
      p.bGy("coverMaskContainer");
    }
    ((View)localObject).setVisibility(8);
    int i = getResources().getColor(b.c.FG_0);
    localObject = this.wYB;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(i);
    }
    localObject = this.wYF;
    if (localObject == null) {
      p.bGy("addCoverIcon");
    }
    ((WeImageView)localObject).setIconColor(i);
    localObject = this.wYF;
    if (localObject == null) {
      p.bGy("addCoverIcon");
    }
    ((WeImageView)localObject).setImageResource(com.tencent.mm.plugin.finder.b.i.icon_filled_add);
    localObject = this.wYA;
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(b.e.finder_activity_add_cover_bg);
    }
    localObject = this.wYB;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getResources().getString(b.j.finder_activity_add_cover_text));
    }
    localObject = g.Xox;
    ((d)g.b(getActivity()).i(d.class)).dmy();
    AppMethodBeat.o(238262);
  }
  
  public final void aAF(String paramString)
  {
    AppMethodBeat.i(238239);
    p.k(paramString, "<set-?>");
    this.wYG = paramString;
    AppMethodBeat.o(238239);
  }
  
  public final void dmL()
  {
    AppMethodBeat.i(238255);
    s locals = this.wYx;
    if (locals != null)
    {
      if (locals.isShowing()) {
        locals.dismiss();
      }
      AppMethodBeat.o(238255);
      return;
    }
    AppMethodBeat.o(238255);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(238248);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      AppMethodBeat.o(238248);
      return;
    }
    switch (paramInt1)
    {
    }
    label232:
    label237:
    do
    {
      AppMethodBeat.o(238248);
      return;
      Object localObject3 = paramIntent.getData();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Uri)localObject3).getPath();
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          Log.w("SimpleUIComponent", "filePath is null.try to getResultPhotoPath.");
          localObject1 = (Context)getActivity();
          localObject2 = av.AJz;
          localObject1 = com.tencent.mm.pluginsdk.ui.tools.u.g((Context)localObject1, paramIntent, av.egn());
        }
        Log.i("SimpleUIComponent", "filePath[" + (String)localObject1 + "] " + paramIntent);
        paramIntent = (CharSequence)localObject1;
        if ((paramIntent != null) && (paramIntent.length() != 0)) {
          break label232;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label237;
        }
        Log.e("SimpleUIComponent", "filePath is null.");
        AppMethodBeat.o(238248);
        return;
        paramInt1 = 0;
        break;
      }
      paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.d((Activity)getActivity(), (String)localObject1, "");
      AppMethodBeat.o(238248);
      return;
      Log.d("SimpleUIComponent", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      aAG(paramIntent.getStringExtra("key_result_img_path"));
      AppMethodBeat.o(238248);
      return;
      localObject2 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      localObject3 = new StringBuilder("REQUEST_CODE_CROP_FIX_IMAGE model: ");
      paramIntent = (Intent)localObject1;
      if (localObject2 != null) {
        paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).aZe();
      }
      Log.i("SimpleUIComponent", paramIntent);
    } while (localObject2 == null);
    paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).fvT();
    p.j(paramIntent, "photo");
    if ((paramIntent.booleanValue()) && (!Util.isNullOrNil(((CaptureDataManager.CaptureVideoNormalModel)localObject2).aZe())))
    {
      aAG(((CaptureDataManager.CaptureVideoNormalModel)localObject2).aZe());
      AppMethodBeat.o(238248);
      return;
    }
    com.tencent.mm.ui.base.w.makeText((Context)getActivity(), b.j.finder_activity_crop_cover_fail, 0).show();
    AppMethodBeat.o(238248);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(238246);
    super.onCreate(paramBundle);
    AppMethodBeat.o(238246);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(238244);
    super.onCreateAfter(paramBundle);
    paramBundle = getActivity().findViewById(b.f.activity_post_cover);
    p.j(paramBundle, "activity.findViewById(R.id.activity_post_cover)");
    this.cvK = ((ImageView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_activity_post_add_cover_icon);
    p.j(paramBundle, "activity.findViewById(R.…vity_post_add_cover_icon)");
    this.wYF = ((WeImageView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.activity_post_cover_mask);
    p.j(paramBundle, "activity.findViewById(R.…activity_post_cover_mask)");
    this.wXE = ((ImageView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.activity_post_cover_container);
    p.j(paramBundle, "activity.findViewById(R.…ity_post_cover_container)");
    this.wYE = paramBundle;
    paramBundle = new DisplayMetrics();
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(238244);
      throw paramBundle;
    }
    localObject = ((Activity)localObject).getWindowManager();
    p.j(localObject, "(activity as Activity).windowManager");
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(paramBundle);
    float f = paramBundle.widthPixels / 0.75F;
    paramBundle = this.wXE;
    if (paramBundle == null) {
      p.bGy("coverMaskImageView");
    }
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(238244);
      throw paramBundle;
    }
    paramBundle.height = ((int)f);
    localObject = this.wXE;
    if (localObject == null) {
      p.bGy("coverMaskImageView");
    }
    if (localObject != null) {
      ((ImageView)localObject).setLayoutParams(paramBundle);
    }
    this.wYA = getActivity().findViewById(b.f.finder_activity_post_add_cover_container);
    this.wYB = ((TextView)getActivity().findViewById(b.f.finder_activity_post_add_cover_text));
    this.wYx = s.a((Context)getActivity(), (CharSequence)getString(com.tencent.mm.plugin.gallery.b.i.app_waiting), false);
    this.wYz = getActivity().findViewById(b.f.finder_activity_add_cover_btn);
    paramBundle = this.wYy;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    paramBundle = getActivity().findViewById(b.f.finder_activity_delete_cover_btn);
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      this.wYD = paramBundle;
      paramBundle = getIntent().getStringExtra("key_activity_local_cover_url");
      if (Util.isNullOrNil(paramBundle)) {
        break label457;
      }
      setCover(paramBundle);
      dmM();
    }
    for (;;)
    {
      paramBundle = this.wYA;
      if (paramBundle == null) {
        break label464;
      }
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(238244);
      return;
      paramBundle = null;
      break;
      label457:
      dmN();
    }
    label464:
    AppMethodBeat.o(238244);
  }
  
  public final void setCover(final String paramString)
  {
    AppMethodBeat.i(238258);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      localObject = new m((String)localObject);
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject = com.tencent.mm.plugin.finder.loader.t.dJe().bQ(localObject);
      localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramString = ((com.tencent.mm.loader.a.b)localObject).a(com.tencent.mm.plugin.finder.loader.t.a(t.a.zuf)).a((com.tencent.mm.loader.f.e)new e(this, paramString));
      localObject = this.cvK;
      if (localObject == null) {
        p.bGy("coverImageView");
      }
      paramString.c((ImageView)localObject);
      AppMethodBeat.o(238258);
      return;
    }
  }
  
  public final void showProgress()
  {
    AppMethodBeat.i(238253);
    s locals = this.wYx;
    if (locals != null)
    {
      if (!locals.isShowing()) {
        locals.show();
      }
      AppMethodBeat.o(238253);
      return;
    }
    AppMethodBeat.o(238253);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$Companion;", "", "()V", "MENU_ID_SET_BG", "", "RATIO", "", "REQUEST_CODE_CROP_FIX_IMAGE", "REQUEST_CODE_IMAGE_BOUND_SEND_SURE", "SELECT_FROM_GALLERY", "SELECT_FROM_VIDEO", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$2$1"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(283007);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.wYJ.aAF("");
      this.wYJ.wYH = true;
      this.wYJ.setCover("");
      e.c(this.wYJ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283007);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277792);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      e.b(this.wYJ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277792);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289951);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.wYJ.wYg)
      {
        this.wYJ.aAF("");
        this.wYJ.wYH = true;
        this.wYJ.setCover("");
        e.c(this.wYJ);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289951);
        return;
        e.b(this.wYJ);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class e<T, R>
    implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.w, Bitmap>
  {
    e(e parame, String paramString) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$setCover$1$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(e.e parame)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.e
 * JD-Core Version:    0.7.0.1
 */