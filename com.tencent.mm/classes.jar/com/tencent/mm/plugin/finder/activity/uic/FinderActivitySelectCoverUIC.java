package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "addCoverBtn", "Landroid/view/View;", "addCoverContainer", "addCoverIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addCoverImage", "addCoverText", "Landroid/widget/TextView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "changeCoverBtn", "Landroid/widget/Button;", "coverImageView", "Landroid/widget/ImageView;", "coverManagerContainer", "coverMaskImageView", "defaultBgImage", "deleteCoverBtn", "isCoverChangedByUser", "", "()Z", "setCoverChangedByUser", "(Z)V", "isCoverSet", "setCoverSet", "progressBar", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "thumbLocalPath", "", "getThumbLocalPath", "()Ljava/lang/String;", "setThumbLocalPath", "(Ljava/lang/String;)V", "addCover", "", "dismissProgress", "getDefaultContent", "Lkotlin/Pair;", "Landroid/graphics/Rect;", "", "input", "initView", "modifyCover", "imgPath", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCoverSet", "onCoverUnset", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCropImageSuccess", "imagePath", "selectCoverFromAlbum", "selectCoverFromOrigin", "selectCoverFromOriginOld", "setCover", "coverUrl", "setCoverMaskMargin", "showProgress", "startCropImgForResult", "context", "Landroid/app/Activity;", "intent", "filePath", "resultFileName", "Companion", "plugin-finder_release"})
public final class FinderActivitySelectCoverUIC
  extends UIComponent
{
  public static final a trR;
  private ImageView cxe;
  private com.tencent.mm.ui.widget.a.e hOv;
  private ImageView tqR;
  boolean trA;
  private com.tencent.mm.ui.base.q trF;
  private WeImageView trG;
  private WeImageView trH;
  private View trI;
  private View trJ;
  private TextView trK;
  private View trL;
  private Button trM;
  private Button trN;
  private WeImageView trO;
  String trP;
  boolean trQ;
  
  static
  {
    AppMethodBeat.i(242138);
    trR = new a((byte)0);
    AppMethodBeat.o(242138);
  }
  
  public FinderActivitySelectCoverUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(242137);
    this.trP = "";
    AppMethodBeat.o(242137);
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2)
  {
    AppMethodBeat.i(242132);
    paramIntent.setClass((Context)paramActivity, FinderCropAvatarUI.class);
    paramIntent.putExtra("key_crop_style", 1);
    paramIntent.putExtra("key_crop_type", 1);
    paramIntent.putExtra("key_crop_source", 2);
    paramIntent.putExtra("key_source_img_path", paramString1);
    paramIntent.putExtra("key_result_file_name", paramString2);
    paramActivity.startActivityForResult(paramIntent, 20001);
    AppMethodBeat.o(242132);
  }
  
  private final void asD(String paramString)
  {
    AppMethodBeat.i(242129);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.s.YS(paramString)))
    {
      u.makeText((Context)getActivity(), 2131759492, 0).show();
      Log.e("Finder.FinderProfileHeaderUIC", "ERROR! filePath=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(242129);
      return;
    }
    Log.d("SimpleUIComponent", "onCropImageSuccess ".concat(String.valueOf(paramString)));
    showProgress();
    this.trQ = true;
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      this.trP = str;
      setCover(paramString);
      cXz();
      AppMethodBeat.o(242129);
      return;
    }
  }
  
  private final void cXA()
  {
    AppMethodBeat.i(242136);
    this.trA = false;
    Object localObject = this.trL;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = getActivity();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242136);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).getController().updataStatusBarIcon(ao.isDarkMode());
    localObject = this.trH;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.cxe;
    if (localObject == null) {
      p.btv("coverImageView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.tqR;
    if (localObject == null) {
      p.btv("coverMaskImageView");
    }
    ((ImageView)localObject).setVisibility(8);
    int i = getResources().getColor(2131099746);
    localObject = this.trK;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(i);
    }
    localObject = this.trO;
    if (localObject == null) {
      p.btv("addCoverIcon");
    }
    ((WeImageView)localObject).setIconColor(i);
    localObject = this.trO;
    if (localObject == null) {
      p.btv("addCoverIcon");
    }
    ((WeImageView)localObject).setImageResource(2131690435);
    localObject = this.trJ;
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2131232460);
    }
    localObject = this.trK;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getResources().getString(2131759488));
    }
    localObject = com.tencent.mm.ui.component.a.PRN;
    ((FinderActivityPostUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderActivityPostUIC.class)).cXo();
    AppMethodBeat.o(242136);
  }
  
  private final void cXz()
  {
    AppMethodBeat.i(242135);
    this.trA = true;
    Object localObject = this.trL;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    int i = getResources().getColor(2131100404);
    localObject = getActivity();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242135);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).getController().updataStatusBarIcon(true);
    localObject = this.trH;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.cxe;
    if (localObject == null) {
      p.btv("coverImageView");
    }
    ((ImageView)localObject).setVisibility(0);
    localObject = this.tqR;
    if (localObject == null) {
      p.btv("coverMaskImageView");
    }
    ((ImageView)localObject).setVisibility(0);
    localObject = this.trK;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getResources().getString(2131759494));
    }
    localObject = this.trK;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(i);
    }
    localObject = this.trO;
    if (localObject == null) {
      p.btv("addCoverIcon");
    }
    ((WeImageView)localObject).setIconColor(i);
    localObject = this.trO;
    if (localObject == null) {
      p.btv("addCoverIcon");
    }
    ((WeImageView)localObject).setImageResource(2131690529);
    localObject = this.trJ;
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2131232461);
    }
    localObject = com.tencent.mm.ui.component.a.PRN;
    ((FinderActivityPostUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderActivityPostUIC.class)).cXx();
    AppMethodBeat.o(242135);
  }
  
  public final void asC(String paramString)
  {
    AppMethodBeat.i(242125);
    p.h(paramString, "<set-?>");
    this.trP = paramString;
    AppMethodBeat.o(242125);
  }
  
  public final void cXy()
  {
    AppMethodBeat.i(242131);
    com.tencent.mm.ui.base.q localq = this.trF;
    if (localq != null)
    {
      if (localq.isShowing()) {
        localq.dismiss();
      }
      AppMethodBeat.o(242131);
      return;
    }
    AppMethodBeat.o(242131);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(242134);
    this.trJ = getActivity().findViewById(2131300750);
    this.trK = ((TextView)getActivity().findViewById(2131300752));
    this.trF = com.tencent.mm.ui.base.q.a((Context)getActivity(), (CharSequence)getString(2131756029), false);
    this.trI = getActivity().findViewById(2131300732);
    Object localObject = this.trG;
    if (localObject != null) {
      ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new g(this));
    }
    localObject = (Button)getActivity().findViewById(2131300734);
    if (localObject != null)
    {
      ((Button)localObject).setOnClickListener((View.OnClickListener)new e(this));
      this.trM = ((Button)localObject);
      localObject = (Button)getActivity().findViewById(2131300736);
      if (localObject == null) {
        break label239;
      }
      ((Button)localObject).setOnClickListener((View.OnClickListener)new f(this));
      label171:
      this.trN = ((Button)localObject);
      localObject = getIntent().getStringExtra("key_activity_local_cover_url");
      if (Util.isNullOrNil((String)localObject)) {
        break label244;
      }
      setCover((String)localObject);
      cXz();
    }
    for (;;)
    {
      localObject = this.trJ;
      if (localObject == null) {
        break label251;
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new h(this));
      AppMethodBeat.o(242134);
      return;
      localObject = null;
      break;
      label239:
      localObject = null;
      break label171;
      label244:
      cXA();
    }
    label251:
    AppMethodBeat.o(242134);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(242128);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      AppMethodBeat.o(242128);
      return;
    }
    switch (paramInt1)
    {
    }
    label105:
    label234:
    do
    {
      AppMethodBeat.o(242128);
      return;
      localObject1 = paramIntent.getData();
      if (localObject1 != null)
      {
        localObject1 = ((Uri)localObject1).getPath();
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label224;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          Log.w("SimpleUIComponent", "filePath is null.try to getResultPhotoPath.");
          localObject1 = (Context)getActivity();
          localObject2 = al.waC;
          localObject1 = com.tencent.mm.pluginsdk.ui.tools.s.h((Context)localObject1, paramIntent, al.dEA());
        }
        Log.i("SimpleUIComponent", "filePath[" + (String)localObject1 + "] " + paramIntent);
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label229;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label234;
        }
        Log.e("SimpleUIComponent", "filePath is null.");
        AppMethodBeat.o(242128);
        return;
        localObject1 = null;
        break;
        paramInt1 = 0;
        break label105;
      }
      Object localObject2 = (Activity)getActivity();
      Object localObject3 = (String)localObject1 + System.currentTimeMillis();
      Charset localCharset = kotlin.n.d.UTF_8;
      if (localObject3 == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(242128);
        throw paramIntent;
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      localObject3 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject3);
      p.g(localObject3, "MD5.getMessageDigest((fi…eMillis()).toByteArray())");
      a((Activity)localObject2, paramIntent, (String)localObject1, (String)localObject3);
      AppMethodBeat.o(242128);
      return;
      Log.d("SimpleUIComponent", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      asD(paramIntent.getStringExtra("key_result_img_path"));
      AppMethodBeat.o(242128);
      return;
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
    } while (paramIntent == null);
    label224:
    label229:
    Object localObject1 = paramIntent.eJI();
    p.g(localObject1, "photo");
    if ((((Boolean)localObject1).booleanValue()) && (!Util.isNullOrNil(paramIntent.aQn()))) {
      asD(paramIntent.aQn());
    }
    AppMethodBeat.o(242128);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242127);
    super.onCreate(paramBundle);
    AppMethodBeat.o(242127);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(242126);
    super.onCreateAfter(paramBundle);
    paramBundle = getActivity().findViewById(2131296463);
    p.g(paramBundle, "activity.findViewById(R.id.activity_post_cover)");
    this.cxe = ((ImageView)paramBundle);
    paramBundle = getActivity().findViewById(2131300751);
    p.g(paramBundle, "activity.findViewById(R.…vity_post_add_cover_icon)");
    this.trO = ((WeImageView)paramBundle);
    paramBundle = getActivity().findViewById(2131296464);
    p.g(paramBundle, "activity.findViewById(R.…activity_post_cover_mask)");
    this.tqR = ((ImageView)paramBundle);
    this.trH = ((WeImageView)getActivity().findViewById(2131296465));
    paramBundle = new DisplayMetrics();
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(242126);
      throw paramBundle;
    }
    localObject = ((Activity)localObject).getWindowManager();
    p.g(localObject, "(activity as Activity).windowManager");
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(paramBundle);
    double d = paramBundle.heightPixels;
    paramBundle = this.tqR;
    if (paramBundle == null) {
      p.btv("coverMaskImageView");
    }
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(242126);
      throw paramBundle;
    }
    paramBundle = (FrameLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = ((int)(0.4D * d));
    localObject = this.tqR;
    if (localObject == null) {
      p.btv("coverMaskImageView");
    }
    ((ImageView)localObject).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    initView();
    AppMethodBeat.o(242126);
  }
  
  public final void setCover(final String paramString)
  {
    AppMethodBeat.i(242133);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      localObject = new com.tencent.mm.plugin.finder.loader.g((String)localObject);
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject = com.tencent.mm.plugin.finder.loader.m.djY().bQ(localObject);
      localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramString = ((com.tencent.mm.loader.a.b)localObject).a(com.tencent.mm.plugin.finder.loader.m.a(m.a.uJl)).a((com.tencent.mm.loader.f.e)new i(this, paramString));
      localObject = this.cxe;
      if (localObject == null) {
        p.btv("coverImageView");
      }
      paramString.c((ImageView)localObject);
      AppMethodBeat.o(242133);
      return;
    }
  }
  
  public final void showProgress()
  {
    AppMethodBeat.i(242130);
    com.tencent.mm.ui.base.q localq = this.trF;
    if (localq != null)
    {
      if (!localq.isShowing()) {
        localq.show();
      }
      AppMethodBeat.o(242130);
      return;
    }
    AppMethodBeat.o(242130);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$Companion;", "", "()V", "MENU_ID_SET_BG", "", "REQUEST_CODE_CROP_FIX_IMAGE", "REQUEST_CODE_IMAGE_BOUND_SEND_SURE", "SELECT_FROM_GALLERY", "SELECT_FROM_VIDEO", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$addCover$1$2"})
  static final class b
    implements o.g
  {
    b(FinderActivitySelectCoverUIC paramFinderActivitySelectCoverUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(242115);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(242115);
        return;
        FinderActivitySelectCoverUIC.e(this.trS);
        AppMethodBeat.o(242115);
        return;
        FinderActivitySelectCoverUIC.c(this.trS);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$addCover$1$3"})
  static final class c
    implements e.b
  {
    c(FinderActivitySelectCoverUIC paramFinderActivitySelectCoverUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(242116);
      FinderActivitySelectCoverUIC.f(this.trS);
      AppMethodBeat.o(242116);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements o.f
  {
    public static final d trT;
    
    static
    {
      AppMethodBeat.i(242118);
      trT = new d();
      AppMethodBeat.o(242118);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(242117);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(10000, 2131759522);
        paramm.kV(10001, 2131759520);
      }
      AppMethodBeat.o(242117);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$2$1"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderActivitySelectCoverUIC paramFinderActivitySelectCoverUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242119);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderActivitySelectCoverUIC.c(this.trS);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242119);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$3$1"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderActivitySelectCoverUIC paramFinderActivitySelectCoverUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242120);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.trS.asC("");
      this.trS.trQ = true;
      this.trS.setCover("");
      FinderActivitySelectCoverUIC.d(this.trS);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242120);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderActivitySelectCoverUIC paramFinderActivitySelectCoverUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242121);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderActivitySelectCoverUIC.b(this.trS);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242121);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderActivitySelectCoverUIC paramFinderActivitySelectCoverUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242122);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.trS.trA)
      {
        this.trS.asC("");
        this.trS.trQ = true;
        this.trS.setCover("");
        FinderActivitySelectCoverUIC.d(this.trS);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242122);
        return;
        FinderActivitySelectCoverUIC.b(this.trS);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class i<T, R>
    implements com.tencent.mm.loader.f.e<o, Bitmap>
  {
    i(FinderActivitySelectCoverUIC paramFinderActivitySelectCoverUIC, String paramString) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySelectCoverUIC$setCover$1$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderActivitySelectCoverUIC.i parami)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivitySelectCoverUIC
 * JD-Core Version:    0.7.0.1
 */