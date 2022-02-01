package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iw;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bz;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.profile.uic.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "activityName", "", "backBtn", "Landroid/widget/LinearLayout;", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "closeActivitySheet", "coordinatorLayout", "Landroid/view/View;", "emptyView", "Landroid/widget/FrameLayout;", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1;", "forceVisibleRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "headerBgLayout", "headerContainer", "headerCoverView", "Landroid/widget/ImageView;", "headerDefaultCoverView", "headerMaskContainer", "Landroid/view/ViewGroup;", "headerMaskCoverView", "isReceivedTopic", "", "moreBtn", "moreIcon", "progressBar", "Landroid/widget/ProgressBar;", "progressRunnable", "screenHeight", "", "screenWidth", "titleContainer", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "adjustCoverImageView", "", "closeActivity", "createShareHeader", "dismissProgress", "fixActionBar", "forceCampaignVisible", "getIconUrl", "getShareDesc", "initScreenWidth", "initView", "isEnableDeleteActivity", "notShare", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTopicInfo", "ignoreCover", "optActivityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "report", "setCover", "coverUrl", "setCoverMaskMargin", "setCoverStyle", "setInvalidView", "setLoadingStatus", "setNormalStyle", "showBottomSheet", "showCloseSheet", "showProgress", "Companion", "plugin-finder_release"})
public final class a
  extends UIComponent
  implements com.tencent.mm.an.i
{
  private static final int wXe = 10001;
  private static final int wXf = 10002;
  private static final int wXg = 10003;
  private static final int wXh = 10004;
  private static final int wXi = 10005;
  private static final int wXj = 10006;
  private static final float wXk = 1.333333F;
  private static final float wXl = 0.45F;
  public static final a wXm;
  private String activityName;
  private bkr fGc;
  private com.tencent.mm.ui.widget.a.e kCR;
  private WeImageView kEy;
  private int pEj;
  private int pEk;
  private ProgressBar progressBar;
  private ImageView wWM;
  private ImageView wWN;
  private ViewGroup wWO;
  private ImageView wWP;
  private View wWQ;
  private View wWR;
  private FrameLayout wWS;
  private LinearLayout wWT;
  private LinearLayout wWU;
  private asg wWV;
  private com.tencent.e.i.d<?> wWW;
  private View wWX;
  private FrameLayout wWY;
  private WeImageView wWZ;
  private com.tencent.mm.ui.widget.a.e wXa;
  private boolean wXb;
  private com.tencent.e.i.d<?> wXc;
  private final e wXd;
  
  static
  {
    AppMethodBeat.i(291682);
    wXm = new a((byte)0);
    wXe = 10001;
    wXf = 10002;
    wXg = 10003;
    wXh = 10004;
    wXi = 10005;
    wXj = 10006;
    wXk = 1.333333F;
    wXl = 0.45F;
    AppMethodBeat.o(291682);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291681);
    this.activityName = "";
    this.wXd = new e(this);
    AppMethodBeat.o(291681);
  }
  
  private final void a(bkr parambkr, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(291677);
    Log.i("Finder.ActivityActionBarUIC", "onTopicInfo : ignoreCover ".concat(String.valueOf(paramBoolean)));
    Object localObject = this.wWY;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.progressBar;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(8);
    }
    if (parambkr != null)
    {
      parambkr = parambkr.SVJ;
      this.wWV = parambkr;
      parambkr = this.wWV;
      if (parambkr == null) {
        break label231;
      }
    }
    label231:
    for (parambkr = parambkr.eventName;; parambkr = null)
    {
      this.activityName = parambkr;
      parambkr = this.wWX;
      if (parambkr != null) {
        parambkr.setVisibility(0);
      }
      parambkr = this.wWQ;
      if (parambkr != null) {
        parambkr.setVisibility(0);
      }
      parambkr = this.wWO;
      if (parambkr != null) {
        parambkr.setVisibility(0);
      }
      localObject = this.wWV;
      parambkr = str;
      if (localObject != null) {
        parambkr = ((asg)localObject).coverImgUrl;
      }
      if (Util.isNullOrNil(parambkr)) {
        break label343;
      }
      if (!paramBoolean)
      {
        parambkr = this.wWV;
        if (parambkr != null)
        {
          str = parambkr.coverImgUrl;
          parambkr = str;
          if (str != null) {}
        }
        else
        {
          parambkr = "";
        }
        setCover(parambkr);
      }
      parambkr = getActivity();
      if (parambkr != null) {
        break label236;
      }
      parambkr = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(291677);
      throw parambkr;
      parambkr = null;
      break;
    }
    label236:
    ((MMActivity)parambkr).getController().updataStatusBarIcon(true);
    int i = getResources().getColor(b.c.finder_activity_covered_white);
    parambkr = this.kEy;
    if (parambkr != null) {
      parambkr.setIconColor(i);
    }
    parambkr = this.wWZ;
    if (parambkr != null) {
      parambkr.setIconColor(i);
    }
    parambkr = this.wWP;
    if (parambkr != null) {
      parambkr.setVisibility(8);
    }
    parambkr = this.wWN;
    if (parambkr != null) {
      parambkr.setVisibility(0);
    }
    parambkr = this.wWM;
    if (parambkr != null)
    {
      parambkr.setVisibility(0);
      AppMethodBeat.o(291677);
      return;
    }
    AppMethodBeat.o(291677);
    return;
    label343:
    dmy();
    AppMethodBeat.o(291677);
  }
  
  private final void dmy()
  {
    AppMethodBeat.i(291676);
    Object localObject = getActivity();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(291676);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).getController().updataStatusBarIcon(ar.isDarkMode());
    int i = getResources().getColor(b.c.black_color);
    localObject = this.kEy;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.wWZ;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(i);
    }
    localObject = this.wWP;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.wWN;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.wWM;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(4);
    }
    localObject = this.wWO;
    if (localObject != null)
    {
      ((ViewGroup)localObject).setVisibility(8);
      AppMethodBeat.o(291676);
      return;
    }
    AppMethodBeat.o(291676);
  }
  
  private final void setCover(final String paramString)
  {
    AppMethodBeat.i(291675);
    ImageView localImageView = this.wWM;
    if (localImageView != null)
    {
      Object localObject = new m(paramString);
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject = com.tencent.mm.plugin.finder.loader.t.dJe().bQ(localObject);
      localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.a.b)localObject).a(com.tencent.mm.plugin.finder.loader.t.a(t.a.zuf)).a((com.tencent.mm.loader.f.e)new i(localImageView, this, paramString)).c(localImageView);
    }
    Log.i("Finder.ActivityActionBarUIC", "forceCampaignVisible: ");
    paramString = this.wXc;
    if (paramString != null) {
      paramString.cancel(false);
    }
    this.wXc = com.tencent.e.h.ZvG.n((Runnable)new f(this), 2000L);
    AppMethodBeat.o(291675);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(291673);
    super.onCreate(paramBundle);
    this.wXd.alive();
    this.wWQ = getActivity().findViewById(b.f.activity_profile_title_container);
    this.wWR = getActivity().findViewById(b.f.activity_profile_header);
    this.wWS = ((FrameLayout)getActivity().findViewById(b.f.finder_profile_activity_header_bg_layout));
    this.wWX = getActivity().findViewById(b.f.coordinatorLayout);
    paramBundle = this.wWS;
    if (paramBundle != null)
    {
      localObject2 = paramBundle.getLayoutParams();
      i = ax.getStatusBarHeight((Context)getActivity());
      f1 = getActivity().getResources().getDimension(b.d.DefaultActionbarHeightPort);
      ((ViewGroup.LayoutParams)localObject2).height = kotlin.h.a.dm(i + f1);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramBundle = this.wWR;
      if (paramBundle != null) {
        paramBundle.setMinimumHeight(kotlin.h.a.dm(i + f1));
      }
    }
    this.activityName = getIntent().getStringExtra("key_activity_name");
    com.tencent.mm.kernel.h.aGY().a(5909, (com.tencent.mm.an.i)this);
    paramBundle = (LinearLayout)getActivity().findViewById(b.f.finder_activity_profile_cancel_btn);
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
      this.wWT = paramBundle;
      this.kEy = ((WeImageView)getActivity().findViewById(b.f.finder_activity_profile_cancel_icon));
      this.wWZ = ((WeImageView)getActivity().findViewById(b.f.finder_activity_profile_more_icon));
      paramBundle = (LinearLayout)getActivity().findViewById(b.f.finder_activity_profile_more_btn);
      if (paramBundle == null) {
        break label466;
      }
      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
    }
    for (;;)
    {
      this.wWU = paramBundle;
      this.wWM = ((ImageView)getActivity().findViewById(b.f.activity_profile_cover));
      this.wWN = ((ImageView)getActivity().findViewById(b.f.activity_profile_cover_mask));
      this.wWO = ((ViewGroup)getActivity().findViewById(b.f.activity_profile_cover_container));
      this.progressBar = ((ProgressBar)getActivity().findViewById(b.f.activity_progress));
      this.wWY = ((FrameLayout)getActivity().findViewById(b.f.empty_view));
      if (!Util.isNullOrNil(getIntent().getStringExtra("key_cover_url")))
      {
        paramBundle = this.wWY;
        if (paramBundle != null) {
          paramBundle.setBackground(getResources().getDrawable(b.e.recycler_view_dark_gradient_bg));
        }
      }
      paramBundle = new DisplayMetrics();
      localObject2 = getActivity();
      if (localObject2 != null) {
        break label471;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(291673);
      throw paramBundle;
      paramBundle = null;
      break;
      label466:
      paramBundle = null;
    }
    label471:
    Object localObject2 = ((Activity)localObject2).getWindowManager();
    p.j(localObject2, "(activity as Activity).windowManager");
    ((WindowManager)localObject2).getDefaultDisplay().getMetrics(paramBundle);
    this.pEj = paramBundle.widthPixels;
    this.pEk = paramBundle.heightPixels;
    dmy();
    paramBundle = this.wWM;
    if (paramBundle != null) {
      paramBundle.post((Runnable)new b(paramBundle));
    }
    float f1 = this.pEj;
    float f2 = wXk;
    paramBundle = this.wWN;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(291673);
      throw paramBundle;
    }
    paramBundle.height = ((int)(f2 * f1));
    localObject2 = this.wWN;
    if (localObject2 != null) {
      ((ImageView)localObject2).setLayoutParams(paramBundle);
    }
    localObject2 = new StringBuilder("showProgress: ");
    ProgressBar localProgressBar = this.progressBar;
    paramBundle = (Bundle)localObject1;
    if (localProgressBar != null) {
      paramBundle = Integer.valueOf(localProgressBar.getVisibility());
    }
    Log.i("Finder.ActivityActionBarUIC", paramBundle);
    paramBundle = this.wWW;
    if (paramBundle != null) {
      paramBundle.cancel(false);
    }
    this.wWW = com.tencent.e.h.ZvG.n((Runnable)new r(this), 500L);
    long l = getIntent().getLongExtra("key_activity_id", 0L);
    localObject1 = getIntent().getStringExtra("key_from_user");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    int i = getIntent().getIntExtra("key_report_scene", 0);
    if (i != 0)
    {
      localObject1 = n.zWF;
      n.a(getIntent().getLongExtra("key_ref_object_id", 0L), i, 6L, paramBundle, 0, 2, com.tencent.mm.ae.d.Fw(l));
    }
    paramBundle = this.wWM;
    if (paramBundle != null) {
      paramBundle.setVisibility(4);
    }
    paramBundle = this.wWO;
    if (paramBundle != null) {
      paramBundle.setVisibility(4);
    }
    paramBundle = this.wWX;
    if (paramBundle != null) {
      paramBundle.setVisibility(4);
    }
    paramBundle = this.wWP;
    if (paramBundle != null) {
      paramBundle.setVisibility(4);
    }
    paramBundle = this.wWY;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.progressBar;
    if (paramBundle != null)
    {
      paramBundle.setVisibility(0);
      AppMethodBeat.o(291673);
      return;
    }
    AppMethodBeat.o(291673);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291674);
    super.onDestroy();
    this.wXd.dead();
    com.tencent.mm.kernel.h.aGY().b(5909, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(291674);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(291679);
    if (((paramq instanceof bz)) && (((bz)paramq).scene == 1)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = j.zSy;
        com.tencent.mm.b.h localh = j.access$getUserExtInfoCache$cp();
        paramString = this.wWV;
        if (paramString != null)
        {
          paramString = paramString.contact;
          if (paramString != null)
          {
            paramq = paramString.username;
            paramString = paramq;
            if (paramq != null) {
              break label78;
            }
          }
        }
        paramString = "";
        label78:
        localh.remove(paramString);
        if (!getActivity().isFinishing())
        {
          getActivity().finish();
          AppMethodBeat.o(291679);
        }
      }
      else if (paramInt2 == -4059)
      {
        paramString = g.Xox;
        paramString = ((c)g.b(getActivity()).i(c.class)).wXQ;
        if (paramString != null)
        {
          paramq = paramString.wZr;
          if (paramq != null) {
            paramq.setVisibility(8);
          }
          paramq = paramString.wZs;
          if (paramq != null) {
            paramq.setText((CharSequence)paramString.iXq.getResources().getString(b.j.finder_activity_finished));
          }
          if (!Util.isNullOrNil(paramString.coverUrl))
          {
            paramq = paramString.wZq;
            if (paramq != null) {
              paramq.setBackgroundResource(b.e.finder_activity_covered_finished_btn_bg);
            }
            paramq = paramString.wZs;
            if (paramq != null)
            {
              paramq.setTextColor(paramString.iXq.getResources().getColor(b.c.BW_100_Alpha_0_3));
              AppMethodBeat.o(291679);
              return;
            }
            AppMethodBeat.o(291679);
            return;
          }
          paramq = paramString.wZq;
          if (paramq != null) {
            paramq.setBackgroundResource(b.e.finder_activity_normal_finished_btn_bg);
          }
          paramq = paramString.wZs;
          if (paramq != null)
          {
            paramq.setTextColor(paramString.iXq.getResources().getColor(b.c.FG_2));
            AppMethodBeat.o(291679);
            return;
          }
          AppMethodBeat.o(291679);
          return;
        }
      }
    }
    AppMethodBeat.o(291679);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$Companion;", "", "()V", "FIX_RATIO", "", "MASK_TOP_MARGIN_RATIO", "MENU_ID_CLOSE_ACTIVITY", "", "MENU_ID_COMPLAIN_ACTIVITY", "MENU_ID_CONFIRM_CLOSE_ACTIVITY", "MENU_ID_MORE", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(272295);
      ViewGroup.LayoutParams localLayoutParams = this.wXn.getLayoutParams();
      localLayoutParams.height = ((int)(this.wXn.getWidth() * a.dmz()));
      this.wXn.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(272295);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<iw>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(285444);
      Log.i("Finder.ActivityActionBarUIC", "forceCampaignVisible execute!");
      a.b(this.wXo, a.c(this.wXo));
      AppMethodBeat.o(285444);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$1$1"})
  static final class g
    implements View.OnClickListener
  {
    g(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234194);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!this.wXo.getActivity().isFinishing()) {
        this.wXo.getActivity().finish();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234194);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$2$1"})
  static final class h
    implements View.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290541);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.wXo);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290541);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$setCover$1$1"})
  static final class i<T, R>
    implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.w, Bitmap>
  {
    i(ImageView paramImageView, a parama, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$1"})
  static final class j
    implements q.f
  {
    j(a parama) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(276077);
      p.j(paramo, "menu");
      Object localObject1;
      Object localObject2;
      boolean bool2;
      if (paramo.hJO())
      {
        localObject1 = this.wXo.getActivity().getString(b.j.app_share_to_weixin);
        p.j(localObject1, "activity.getString(R.string.app_share_to_weixin)");
        localObject2 = this.wXo.getActivity().getString(b.j.finder_share_timeline);
        p.j(localObject2, "activity.getString(R.string.finder_share_timeline)");
        if (!a.d(this.wXo)) {
          break label160;
        }
        localObject1 = aj.AGc;
        localObject1 = aj.el("", b.j.finder_self_see_tips_forward);
        localObject2 = aj.AGc;
        localObject2 = aj.el("", b.j.finder_self_see_tips_sns);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paramo.a(a.dmA(), (CharSequence)localObject1, b.i.finder_icons_filled_share, this.wXo.getResources().getColor(b.c.Brand), bool1);
        paramo.a(a.dmB(), (CharSequence)localObject2, b.i.bottomsheet_icon_moment, 0, bool2);
        AppMethodBeat.o(276077);
        return;
        label160:
        bool2 = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$2"})
  static final class k
    implements q.g
  {
    k(a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(220939);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Object localObject1;
      Object localObject2;
      if (paramInt == a.dmA())
      {
        if (a.d(this.wXo))
        {
          com.tencent.mm.ui.base.w.makeText((Context)this.wXo.getActivity(), b.j.finder_self_see_tips_forward, 0).show();
          AppMethodBeat.o(220939);
          return;
        }
        localObject1 = ac.AEJ;
        paramMenuItem = this.wXo.getActivity();
        if (paramMenuItem == null)
        {
          paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(220939);
          throw paramMenuItem;
        }
        localObject2 = (MMActivity)paramMenuItem;
        paramMenuItem = a.e(this.wXo);
        asg localasg;
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.eventName;
          localasg = a.e(this.wXo);
          if (localasg == null) {
            break label187;
          }
        }
        label187:
        for (l = localasg.SFG;; l = 0L)
        {
          ((ac.a)localObject1).a((MMActivity)localObject2, paramMenuItem, 7, l, a.f(this.wXo), a.g(this.wXo), null, 9, "", a.h(this.wXo));
          AppMethodBeat.o(220939);
          return;
          paramMenuItem = null;
          break;
        }
      }
      if (paramInt == a.dmB())
      {
        if (a.d(this.wXo))
        {
          com.tencent.mm.ui.base.w.makeText((Context)this.wXo.getActivity(), b.j.finder_self_see_tips_sns, 0).show();
          AppMethodBeat.o(220939);
          return;
        }
        paramMenuItem = ac.AEJ;
        paramMenuItem = this.wXo.getActivity();
        if (paramMenuItem == null)
        {
          paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(220939);
          throw paramMenuItem;
        }
        localObject1 = (MMActivity)paramMenuItem;
        paramMenuItem = a.e(this.wXo);
        if (paramMenuItem == null) {
          break label353;
        }
        paramMenuItem = paramMenuItem.eventName;
        localObject2 = a.e(this.wXo);
        if (localObject2 == null) {
          break label358;
        }
      }
      label353:
      label358:
      for (long l = ((asg)localObject2).SFG;; l = 0L)
      {
        ac.a.b((MMActivity)localObject1, paramMenuItem, 7, l, a.f(this.wXo), a.g(this.wXo), null, 9, "", a.h(this.wXo));
        AppMethodBeat.o(220939);
        return;
        paramMenuItem = null;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$3"})
  static final class l
    implements q.f
  {
    l(a parama) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(290432);
      p.j(paramo, "menu");
      boolean bool;
      if (paramo.hJO())
      {
        bool = a.d(this.wXo);
        if (a.i(this.wXo))
        {
          paramo.a(a.dmC(), (CharSequence)this.wXo.getResources().getString(b.j.finder_activity_close_text), b.i.finder_outlined_turnoff, bool);
          AppMethodBeat.o(290432);
          return;
        }
        localObject = a.e(this.wXo);
        if (localObject == null) {
          break label142;
        }
        localObject = ((asg)localObject).contact;
        if (localObject == null) {
          break label142;
        }
      }
      label142:
      for (Object localObject = ((FinderContact)localObject).username;; localObject = null)
      {
        if ((p.h(localObject, z.bdh()) ^ true)) {
          paramo.a(a.dmD(), (CharSequence)this.wXo.getResources().getString(b.j.finder_live_more_action_report), b.i.icons_outlined_report_problem, bool);
        }
        AppMethodBeat.o(290432);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$4"})
  static final class m
    implements q.g
  {
    m(a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(271825);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == a.dmC())
      {
        a.j(this.wXo);
        AppMethodBeat.o(271825);
        return;
      }
      asg localasg;
      if (paramInt == a.dmD())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.xFq;
        paramMenuItem = (Context)this.wXo.getActivity();
        localasg = a.e(this.wXo);
        if (localasg == null) {
          break label91;
        }
      }
      label91:
      for (long l = localasg.xdR;; l = 0L)
      {
        com.tencent.mm.plugin.finder.feed.logic.a.i(paramMenuItem, l);
        AppMethodBeat.o(271825);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$5"})
  static final class n
    implements e.b
  {
    n(a parama) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(271915);
      a.k(this.wXo);
      AppMethodBeat.o(271915);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showCloseSheet$1$1"})
  static final class o
    implements q.f
  {
    o(a parama) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(271556);
      p.j(paramo, "menu");
      if (paramo.hJO()) {
        paramo.a(a.dmE(), this.wXo.getResources().getColor(b.c.Red), (CharSequence)this.wXo.getResources().getString(b.j.finder_activity_close_text));
      }
      AppMethodBeat.o(271556);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showCloseSheet$1$2"})
  static final class p
    implements q.g
  {
    p(a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(288370);
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == a.dmE()) {
        a.l(this.wXo);
      }
      AppMethodBeat.o(288370);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showCloseSheet$1$3"})
  static final class q
    implements e.b
  {
    q(a parama) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(265363);
      a.m(this.wXo);
      AppMethodBeat.o(265363);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(292109);
      ProgressBar localProgressBar = a.n(this.wXo);
      if (localProgressBar != null)
      {
        Log.i("Finder.ActivityActionBarUIC", "showProgress visible change");
        if (localProgressBar.getVisibility() != 0) {
          localProgressBar.setVisibility(0);
        }
        AppMethodBeat.o(292109);
        return;
      }
      AppMethodBeat.o(292109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.a
 * JD-Core Version:    0.7.0.1
 */