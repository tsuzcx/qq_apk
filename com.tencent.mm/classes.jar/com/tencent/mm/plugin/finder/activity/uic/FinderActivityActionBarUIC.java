package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bw;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "activityName", "", "backBtn", "Landroid/widget/LinearLayout;", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "closeActivitySheet", "containerView", "Landroid/view/View;", "emptyView", "Landroid/widget/FrameLayout;", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1;", "headerCoverView", "Landroid/widget/ImageView;", "headerDefaultCoverView", "headerMaskCoverView", "moreBtn", "moreIcon", "progressBar", "Landroid/widget/ProgressBar;", "progressRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "titleContainer", "adjustCoverImageView", "", "closeActivity", "dismissAllViews", "dismissProgress", "fixActionBar", "getIconUrl", "getShareDesc", "initView", "isEnableDeleteActivity", "", "notShare", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTopicInfo", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "optActivityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "report", "setCover", "coverUrl", "setCoverMaskMargin", "setCoverStyle", "setNormalStyle", "showBottomSheet", "showCloseSheet", "showProgress", "Companion", "plugin-finder_release"})
public final class FinderActivityActionBarUIC
  extends UIComponent
  implements com.tencent.mm.ak.i
{
  private static final int pLU = 10003;
  private static final float tqA = 0.45F;
  public static final a tqB;
  private static final int tqu = 10001;
  private static final int tqv = 10002;
  private static final int tqw = 10004;
  private static final int tqx = 10005;
  private static final int tqy = 10006;
  private static final float tqz = 1.333333F;
  private String activityName;
  private com.tencent.mm.ui.widget.a.e hOv;
  private WeImageView hQb;
  private ProgressBar progressBar;
  private View qXq;
  private ImageView tqi;
  private ImageView tqj;
  private ImageView tqk;
  private View tql;
  private LinearLayout tqm;
  private LinearLayout tqn;
  private aqk tqo;
  private com.tencent.f.i.d<?> tqp;
  private FrameLayout tqq;
  private WeImageView tqr;
  private com.tencent.mm.ui.widget.a.e tqs;
  private final d tqt;
  
  static
  {
    AppMethodBeat.i(242033);
    tqB = new a((byte)0);
    tqu = 10001;
    tqv = 10002;
    pLU = 10003;
    tqw = 10004;
    tqx = 10005;
    tqy = 10006;
    tqz = 1.333333F;
    tqA = 0.45F;
    AppMethodBeat.o(242033);
  }
  
  public FinderActivityActionBarUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(242032);
    this.activityName = "";
    this.tqt = new d(this);
    AppMethodBeat.o(242032);
  }
  
  private final void cXo()
  {
    AppMethodBeat.i(242030);
    Object localObject = getActivity();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242030);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).getController().updataStatusBarIcon(ao.isDarkMode());
    int i = getResources().getColor(2131100044);
    localObject = this.hQb;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.tqr;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.tqk;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.tqj;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.tqi;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(4);
      AppMethodBeat.o(242030);
      return;
    }
    AppMethodBeat.o(242030);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(242028);
    super.onCreate(paramBundle);
    this.tqt.alive();
    this.tql = getActivity().findViewById(2131296481);
    int i = au.getStatusBarHeight((Context)getActivity());
    paramBundle = this.tql;
    if (paramBundle != null) {
      paramBundle.setPadding(0, i + paramBundle.getPaddingTop(), 0, 0);
    }
    this.activityName = getIntent().getStringExtra("key_activity_name");
    g.azz().a(5909, (com.tencent.mm.ak.i)this);
    paramBundle = (LinearLayout)getActivity().findViewById(2131300765);
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      this.tqm = paramBundle;
      this.hQb = ((WeImageView)getActivity().findViewById(2131300766));
      this.tqr = ((WeImageView)getActivity().findViewById(2131300768));
      paramBundle = (LinearLayout)getActivity().findViewById(2131300767);
      if (paramBundle == null) {
        break label390;
      }
      paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      label203:
      this.tqn = paramBundle;
      this.tqi = ((ImageView)getActivity().findViewById(2131296468));
      this.tqj = ((ImageView)getActivity().findViewById(2131296469));
      this.tqk = ((ImageView)getActivity().findViewById(2131296470));
      this.progressBar = ((ProgressBar)getActivity().findViewById(2131296482));
      this.tqq = ((FrameLayout)getActivity().findViewById(2131300111));
      paramBundle = getActivity().findViewById(2131296466);
      if (paramBundle == null) {
        break label395;
      }
      paramBundle.setVisibility(4);
    }
    for (;;)
    {
      this.qXq = paramBundle;
      cXo();
      paramBundle = this.tqi;
      if (paramBundle != null) {
        paramBundle.post((Runnable)new b(paramBundle));
      }
      paramBundle = new DisplayMetrics();
      localObject2 = getActivity();
      if (localObject2 != null) {
        break label400;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(242028);
      throw paramBundle;
      paramBundle = null;
      break;
      label390:
      paramBundle = null;
      break label203;
      label395:
      paramBundle = null;
    }
    label400:
    Object localObject2 = ((Activity)localObject2).getWindowManager();
    p.g(localObject2, "(activity as Activity).windowManager");
    ((WindowManager)localObject2).getDefaultDisplay().getMetrics(paramBundle);
    float f1 = paramBundle.heightPixels;
    float f2 = tqA;
    paramBundle = this.tqj;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(242028);
      throw paramBundle;
    }
    paramBundle = (FrameLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = ((int)(f2 * f1));
    localObject2 = this.tqj;
    if (localObject2 != null) {
      ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    }
    localObject2 = new StringBuilder("showProgress: ");
    ProgressBar localProgressBar = this.progressBar;
    paramBundle = (Bundle)localObject1;
    if (localProgressBar != null) {
      paramBundle = Integer.valueOf(localProgressBar.getVisibility());
    }
    Log.i("Finder.ActivityActionBarUIC", paramBundle);
    paramBundle = this.tqp;
    if (paramBundle != null) {
      paramBundle.cancel(false);
    }
    this.tqp = h.RTc.n((Runnable)new p(this), 500L);
    long l = getIntent().getLongExtra("key_activity_id", 0L);
    localObject1 = getIntent().getStringExtra("key_from_user");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    i = getIntent().getIntExtra("key_report_scene", 0);
    if (i != 0)
    {
      localObject1 = k.vfA;
      k.a(getIntent().getLongExtra("key_ref_object_id", 0L), i, 6L, paramBundle, 0, 2, com.tencent.mm.ac.d.zs(l));
    }
    AppMethodBeat.o(242028);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(242029);
    super.onDestroy();
    this.tqt.dead();
    g.azz().b(5909, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(242029);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(242031);
    if (((paramq instanceof bw)) && (((bw)paramq).scene == 1)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!getActivity().isFinishing())
        {
          getActivity().finish();
          AppMethodBeat.o(242031);
        }
      }
      else {
        u.makeText((Context)getActivity(), (CharSequence)getContext().getResources().getString(2131760370), 0).show();
      }
    }
    AppMethodBeat.o(242031);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$Companion;", "", "()V", "FIX_RATIO", "", "MASK_TOP_MARGIN_RATIO", "MENU_ID_CLOSE_ACTIVITY", "", "MENU_ID_COMPLAIN_ACTIVITY", "MENU_ID_CONFIRM_CLOSE_ACTIVITY", "MENU_ID_MORE", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(242011);
      ViewGroup.LayoutParams localLayoutParams = this.tqC.getLayoutParams();
      localLayoutParams.height = ((int)(this.tqC.getWidth() * FinderActivityActionBarUIC.cXp()));
      this.tqC.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(242011);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(FinderActivityActionBarUIC paramFinderActivityActionBarUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<ih>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242014);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!this.tqD.getActivity().isFinishing()) {
        this.tqD.getActivity().finish();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242014);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$2$1"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242015);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderActivityActionBarUIC.a(this.tqD);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242015);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$setCover$1$1"})
  static final class g<T, R>
    implements com.tencent.mm.loader.f.e<o, Bitmap>
  {
    g(ImageView paramImageView, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$1"})
  static final class h
    implements o.f
  {
    h(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(242018);
      p.g(paramm, "menu");
      Object localObject1;
      Object localObject2;
      boolean bool2;
      if (paramm.gKQ())
      {
        localObject1 = this.tqD.getActivity().getString(2131755985);
        p.g(localObject1, "activity.getString(R.string.app_share_to_weixin)");
        localObject2 = this.tqD.getActivity().getString(2131760572);
        p.g(localObject2, "activity.getString(R.string.finder_share_timeline)");
        if (!FinderActivityActionBarUIC.b(this.tqD)) {
          break label153;
        }
        localObject1 = y.vXH;
        localObject1 = y.dP("", 2131760540);
        localObject2 = y.vXH;
        localObject2 = y.dP("", 2131760541);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paramm.a(FinderActivityActionBarUIC.cXq(), (CharSequence)localObject1, 2131690251, this.tqD.getResources().getColor(2131099710), bool1);
        paramm.a(FinderActivityActionBarUIC.cXr(), (CharSequence)localObject2, 2131689830, 0, bool2);
        AppMethodBeat.o(242018);
        return;
        label153:
        bool2 = false;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$2"})
  static final class i
    implements o.g
  {
    i(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(242019);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Object localObject1;
      Object localObject2;
      if (paramInt == FinderActivityActionBarUIC.cXq())
      {
        if (FinderActivityActionBarUIC.b(this.tqD))
        {
          u.makeText((Context)this.tqD.getActivity(), 2131760540, 0).show();
          AppMethodBeat.o(242019);
          return;
        }
        localObject1 = s.vWt;
        paramMenuItem = this.tqD.getActivity();
        if (paramMenuItem == null)
        {
          paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(242019);
          throw paramMenuItem;
        }
        localObject2 = (MMActivity)paramMenuItem;
        paramMenuItem = FinderActivityActionBarUIC.c(this.tqD);
        aqk localaqk;
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.eventName;
          localaqk = FinderActivityActionBarUIC.c(this.tqD);
          if (localaqk == null) {
            break label186;
          }
        }
        label186:
        for (l = localaqk.LCy;; l = 0L)
        {
          ((s.a)localObject1).a((MMActivity)localObject2, paramMenuItem, 7, l, FinderActivityActionBarUIC.d(this.tqD), FinderActivityActionBarUIC.e(this.tqD), null, 9, "", FinderActivityActionBarUIC.f(this.tqD));
          AppMethodBeat.o(242019);
          return;
          paramMenuItem = null;
          break;
        }
      }
      if (paramInt == FinderActivityActionBarUIC.cXr())
      {
        if (FinderActivityActionBarUIC.b(this.tqD))
        {
          u.makeText((Context)this.tqD.getActivity(), 2131760541, 0).show();
          AppMethodBeat.o(242019);
          return;
        }
        paramMenuItem = s.vWt;
        paramMenuItem = this.tqD.getActivity();
        if (paramMenuItem == null)
        {
          paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(242019);
          throw paramMenuItem;
        }
        localObject1 = (MMActivity)paramMenuItem;
        paramMenuItem = FinderActivityActionBarUIC.c(this.tqD);
        if (paramMenuItem == null) {
          break label351;
        }
        paramMenuItem = paramMenuItem.eventName;
        localObject2 = FinderActivityActionBarUIC.c(this.tqD);
        if (localObject2 == null) {
          break label356;
        }
      }
      label351:
      label356:
      for (long l = ((aqk)localObject2).LCy;; l = 0L)
      {
        s.a.b((MMActivity)localObject1, paramMenuItem, 7, l, FinderActivityActionBarUIC.d(this.tqD), FinderActivityActionBarUIC.e(this.tqD), null, 9, "", FinderActivityActionBarUIC.f(this.tqD));
        AppMethodBeat.o(242019);
        return;
        paramMenuItem = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$3"})
  static final class j
    implements o.f
  {
    j(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(242020);
      p.g(paramm, "menu");
      if (paramm.gKQ())
      {
        boolean bool = FinderActivityActionBarUIC.b(this.tqD);
        if (FinderActivityActionBarUIC.g(this.tqD))
        {
          paramm.a(FinderActivityActionBarUIC.cXs(), (CharSequence)this.tqD.getResources().getString(2131759491), 2131690780, bool);
          AppMethodBeat.o(242020);
          return;
        }
        paramm.a(FinderActivityActionBarUIC.cXt(), (CharSequence)this.tqD.getResources().getString(2131760110), 2131690898, bool);
      }
      AppMethodBeat.o(242020);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$4"})
  static final class k
    implements o.g
  {
    k(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(242021);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderActivityActionBarUIC.cXs())
      {
        FinderActivityActionBarUIC.h(this.tqD);
        AppMethodBeat.o(242021);
        return;
      }
      aqk localaqk;
      if (paramInt == FinderActivityActionBarUIC.cXt())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
        paramMenuItem = (Context)this.tqD.getActivity();
        localaqk = FinderActivityActionBarUIC.c(this.tqD);
        if (localaqk == null) {
          break label91;
        }
      }
      label91:
      for (long l = localaqk.twd;; l = 0L)
      {
        com.tencent.mm.plugin.finder.feed.logic.a.i(paramMenuItem, l);
        AppMethodBeat.o(242021);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$5"})
  static final class l
    implements e.b
  {
    l(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(242022);
      FinderActivityActionBarUIC.i(this.tqD);
      AppMethodBeat.o(242022);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showCloseSheet$1$2"})
  static final class m
    implements o.g
  {
    m(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(242023);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderActivityActionBarUIC.cXu()) {
        FinderActivityActionBarUIC.j(this.tqD);
      }
      AppMethodBeat.o(242023);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showCloseSheet$1$3"})
  static final class n
    implements e.b
  {
    n(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(242024);
      FinderActivityActionBarUIC.k(this.tqD);
      AppMethodBeat.o(242024);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class o
    implements o.f
  {
    public static final o tqG;
    
    static
    {
      AppMethodBeat.i(242026);
      tqG = new o();
      AppMethodBeat.o(242026);
    }
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(242025);
      p.g(paramm, "menu");
      if (paramm.gKQ()) {
        paramm.kV(FinderActivityActionBarUIC.cXu(), 2131759491);
      }
      AppMethodBeat.o(242025);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(FinderActivityActionBarUIC paramFinderActivityActionBarUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(242027);
      ProgressBar localProgressBar = FinderActivityActionBarUIC.l(this.tqD);
      if (localProgressBar != null)
      {
        Log.i("Finder.ActivityActionBarUIC", "showProgress visible change");
        if (localProgressBar.getVisibility() != 0) {
          localProgressBar.setVisibility(0);
        }
        AppMethodBeat.o(242027);
        return;
      }
      AppMethodBeat.o(242027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityActionBarUIC
 * JD-Core Version:    0.7.0.1
 */