package com.tencent.mm.plugin.finder.activity.uic;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ie;
import com.tencent.mm.autogen.a.jv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.bi.c;
import com.tencent.mm.plugin.finder.feed.bi.d;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "bypassInfo", "", "emptyView", "Landroid/widget/FrameLayout;", "encryptedEventTopicId", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "feedStickyListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1;", "finderEventTopicId", "", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "retryView", "Landroid/widget/TextView;", "tabType", "", "topicName", "getTopicName", "()Ljava/lang/String;", "setTopicName", "(Ljava/lang/String;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "convertInnerTabType", "convertTopicId", "", "convertTopicType", "getCommentScene", "getLayoutId", "handleStickyEvent", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "initLoader", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onPreDestroyed", "onResume", "setCoveredStyle", "Companion", "FinderHottestFeedLoader", "FinderNewestLoader", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderActivityContentUIC
  extends UIComponent
{
  public static final a Auo;
  private awt AtP;
  private FrameLayout AtS;
  public bi.c Aup;
  private bi.d Auq;
  private FinderTopicFeedLoader Aur;
  private String Aus;
  private long Aut;
  private String Auu;
  private TextView Auv;
  private final finderTopicInfoListener.1 Auw;
  private final feedStickyListener.1 Aux;
  private int hJx;
  private ProgressBar progressBar;
  private String xUk;
  
  static
  {
    AppMethodBeat.i(348090);
    Auo = new a((byte)0);
    AppMethodBeat.o(348090);
  }
  
  public FinderActivityContentUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(348033);
    this.xUk = "";
    this.Auw = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Aux = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(348033);
  }
  
  private static int MS(int paramInt)
  {
    if (paramInt >= 3) {
      return 12;
    }
    return 7;
  }
  
  private static final void a(FinderActivityContentUIC paramFinderActivityContentUIC)
  {
    AppMethodBeat.i(348065);
    s.u(paramFinderActivityContentUIC, "this$0");
    paramFinderActivityContentUIC.dTw();
    AppMethodBeat.o(348065);
  }
  
  private static final void a(FinderActivityContentUIC paramFinderActivityContentUIC, View paramView)
  {
    AppMethodBeat.i(348063);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderActivityContentUIC);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderActivityContentUIC, "this$0");
    Log.i("SimpleUIComponent", "progressBar FinderActivityContentUIC visible");
    paramView = paramFinderActivityContentUIC.AtS;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = paramFinderActivityContentUIC.progressBar;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = paramFinderActivityContentUIC.Auq;
    paramFinderActivityContentUIC = paramView;
    if (paramView == null)
    {
      s.bIx("viewCallback");
      paramFinderActivityContentUIC = null;
    }
    paramFinderActivityContentUIC.ebi();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348063);
  }
  
  private bi.c dTv()
  {
    AppMethodBeat.i(348041);
    bi.c localc = this.Aup;
    if (localc != null)
    {
      AppMethodBeat.o(348041);
      return localc;
    }
    s.bIx("presenter");
    AppMethodBeat.o(348041);
    return null;
  }
  
  private final void dTw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(348055);
    Object localObject1 = this.AtP;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "";
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject3 = this.Auq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = (TextView)((c.b)localObject1).ATx.findViewById(e.e.load_more_footer_tip_tv);
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_3));
        }
        localObject3 = this.Auq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((c.b)localObject1).ATx.findViewById(e.e.left_icon);
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_1));
        }
        localObject3 = this.Auq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((c.b)localObject1).ATx.findViewById(e.e.right_icon);
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_1));
        }
        localObject3 = this.Auq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((c.b)localObject1).ATx.findViewById(e.e.center_icon);
        if (localObject1 != null) {
          ((View)localObject1).setBackgroundResource(e.d.finder_footer_night_center_dot);
        }
        localObject3 = this.Auq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = (TextView)((c.b)localObject1).ATx.findViewById(e.e.empty_tip);
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8));
        }
        localObject1 = this.Auq;
        if (localObject1 != null) {
          break label348;
        }
        s.bIx("viewCallback");
        localObject1 = localObject2;
      }
    }
    label348:
    for (;;)
    {
      localObject1 = (TextView)((c.b)localObject1).ATx.findViewById(e.e.retry_tip);
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8));
      }
      AppMethodBeat.o(348055);
      return;
      localObject3 = ((awt)localObject1).coverImgUrl;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_activity_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(348121);
    super.onCreate(paramBundle);
    this.Auw.alive();
    int i;
    if ((getFragment() instanceof FinderHomeTabFragment))
    {
      paramBundle = getFragment();
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(348121);
        throw paramBundle;
      }
      i = ((FinderHomeTabFragment)paramBundle).hJx;
      Log.i("SimpleUIComponent", s.X("convertInnerTabType : ", Integer.valueOf(i)));
      i += 1;
    }
    for (;;)
    {
      this.hJx = i;
      this.Aut = getIntent().getLongExtra("key_activity_id", 0L);
      if ((this.hJx <= 2) || (!(getFragment() instanceof FinderActivityFragment))) {
        break label167;
      }
      paramBundle = getFragment();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
      AppMethodBeat.o(348121);
      throw paramBundle;
      i = 1;
    }
    this.Aut = ((FinderActivityFragment)paramBundle).AtC;
    label167:
    this.Auu = getIntent().getStringExtra("key_encrypted_topic_id");
    Object localObject2 = getIntent().getStringExtra("key_activity_name");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.xUk = paramBundle;
    this.Aus = getIntent().getStringExtra("key_by_pass_info");
    Log.i("SimpleUIComponent", "topic:" + this.xUk + " finderEventTopicId:" + this.Aut + " encryptedEventTopicId:" + this.Auu);
    paramBundle = k.aeZF;
    paramBundle = getFragment();
    s.checkNotNull(paramBundle);
    paramBundle = ((as)k.y(paramBundle).q(as.class)).fou();
    if (this.hJx == 2)
    {
      paramBundle = new FinderNewestLoader(MS(this.hJx), this.xUk, paramBundle, this.Aus);
      paramBundle.initFromCache(getIntent());
      paramBundle.Bbs = paramBundle.Bbs;
      paramBundle.ocD = this.Aut;
      paramBundle.Bbz = this.Auu;
      paramBundle.Bbt = this.hJx;
      paramBundle.Bjx = Long.valueOf(getIntent().getLongExtra("key_feed_ref_id", 0L));
      localObject2 = ah.aiuX;
      this.Aur = ((FinderTopicFeedLoader)paramBundle);
      Object localObject3 = new StringBuilder("feedLoader : ");
      localObject2 = this.Aur;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedLoader");
        paramBundle = null;
      }
      localObject3 = ((StringBuilder)localObject3).append(paramBundle).append(" this.innerTabType : ");
      localObject2 = this.Aur;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedLoader");
        paramBundle = null;
      }
      Log.i("SimpleUIComponent", paramBundle.Bbt);
      localObject3 = (MMActivity)getActivity();
      localObject2 = this.Aur;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedLoader");
        paramBundle = null;
      }
      paramBundle = new bi.c((MMActivity)localObject3, 59, (BaseFinderFeedLoader)paramBundle);
      paramBundle.avQ(paramBundle.topic);
      paramBundle.type = 7;
      localObject2 = ah.aiuX;
      s.u(paramBundle, "<set-?>");
      this.Aup = paramBundle;
      localObject2 = new bi.d((MMActivity)getActivity(), 59, null, 24);
      ((bi.d)localObject2).avQ(((bi.d)localObject2).topic);
      ((bi.d)localObject2).type = 7;
      paramBundle = getFragment();
      s.checkNotNull(paramBundle);
      paramBundle = paramBundle.getView();
      if (paramBundle != null) {
        break label1144;
      }
      paramBundle = null;
      label631:
      s.s(paramBundle, "fragment!!.rl_layout");
      paramBundle = (RefreshLoadMoreLayout)paramBundle;
      s.u(paramBundle, "<set-?>");
      ((c.b)localObject2).ATx = paramBundle;
      ((c.b)localObject2).ATx.setSuperNestedScroll(true);
      ((bi.d)localObject2).Bbt = this.hJx;
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label1155;
      }
      paramBundle = null;
      label685:
      ((bi.d)localObject2).Bbw = paramBundle;
      paramBundle = ah.aiuX;
      this.Auq = ((bi.d)localObject2);
      localObject2 = getFragment();
      if (localObject2 != null)
      {
        paramBundle = this.Auq;
        if (paramBundle != null) {
          break label1180;
        }
        s.bIx("viewCallback");
        paramBundle = null;
        label728:
        s.u(localObject2, "fragment");
        localObject3 = k.aeZF;
        localObject3 = k.y((Fragment)localObject2).q(as.class);
        s.s(localObject3, "UICProvider.of(fragment)…rReporterUIC::class.java)");
        localObject3 = as.b((as)localObject3);
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject3).o(paramBundle.ATx.getRecyclerView());
        }
        paramBundle.Bbu = ((Fragment)localObject2);
        paramBundle = com.tencent.mm.plugin.finder.topic.a.FNS;
        com.tencent.mm.plugin.finder.topic.a.a((Fragment)localObject2, this.Aut);
      }
      paramBundle = this.Auq;
      if (paramBundle != null) {
        break label1183;
      }
      s.bIx("viewCallback");
      paramBundle = null;
      label823:
      paramBundle.a((c.a)dTv());
      localObject3 = dTv();
      localObject2 = this.Auq;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        paramBundle = null;
      }
      ((bi.c)localObject3).a((c.b)paramBundle);
      this.Auv = ((TextView)getActivity().findViewById(e.e.retry_tip));
      this.AtS = ((FrameLayout)getActivity().findViewById(e.e.empty_view));
      this.progressBar = ((ProgressBar)getActivity().findViewById(e.e.activity_progress));
      paramBundle = this.Auv;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new FinderActivityContentUIC..ExternalSyntheticLambda0(this));
      }
      this.Aux.alive();
      Log.i("SimpleUIComponent", "finderEventTopicId:" + this.Aut + ", encryptedEventTopicId:" + this.Auu);
      paramBundle = k.aeZF;
      paramBundle = ((c)k.d(getActivity()).q(c.class)).AuO;
      if (paramBundle != null) {
        break label1186;
      }
      paramBundle = localObject1;
    }
    for (;;)
    {
      this.AtP = paramBundle;
      getRootView().post(new FinderActivityContentUIC..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(348121);
      return;
      paramBundle = new FinderHottestFeedLoader(MS(this.hJx), this.xUk, paramBundle, this.Aus);
      paramBundle.initFromCache(getIntent());
      paramBundle.Bbs = paramBundle.Bbs;
      paramBundle.ocD = this.Aut;
      paramBundle.Bbz = this.Auu;
      paramBundle.Bbt = this.hJx;
      paramBundle.Bjx = Long.valueOf(getIntent().getLongExtra("key_feed_ref_id", 0L));
      localObject2 = ah.aiuX;
      this.Aur = ((FinderTopicFeedLoader)paramBundle);
      break;
      label1144:
      paramBundle = paramBundle.findViewById(e.e.rl_layout);
      break label631;
      label1155:
      paramBundle = paramBundle.getView();
      if (paramBundle == null)
      {
        paramBundle = null;
        break label685;
      }
      paramBundle = paramBundle.findViewById(e.e.empty_view);
      break label685;
      label1180:
      break label728;
      label1183:
      break label823;
      label1186:
      localObject2 = paramBundle.Ave;
      paramBundle = localObject1;
      if (localObject2 != null) {
        paramBundle = ((bxv)localObject2).aagK;
      }
    }
  }
  
  public final void onPause()
  {
    Object localObject2 = null;
    AppMethodBeat.i(348140);
    super.onPause();
    Object localObject1 = k.aeZF;
    int i = ((h)k.d(getActivity()).q(h.class)).fpi();
    if (this.hJx - 1 == i)
    {
      localObject3 = this.Aur;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedLoader");
        localObject1 = null;
      }
      ((FinderTopicFeedLoader)localObject1).Bjy = this.hJx;
    }
    Log.i("SimpleUIComponent", s.X("onPause activeIndex :", Integer.valueOf(i)));
    StringBuilder localStringBuilder = new StringBuilder("onPause check visible rlLayout:");
    Object localObject3 = this.Auq;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localStringBuilder = localStringBuilder.append(((c.b)localObject1).ATx.getVisibility()).append(" recycleView: ");
    localObject3 = this.Auq;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localStringBuilder = localStringBuilder.append(((c.b)localObject1).ATx.getRecyclerView().getVisibility()).append("  empty View :");
    localObject3 = this.Auq;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((bi.d)localObject1).getEmptyView();
    if (localObject1 == null) {}
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((View)localObject1).getVisibility()))
    {
      Log.i("SimpleUIComponent", localObject1);
      AppMethodBeat.o(348140);
      return;
    }
  }
  
  public final void onPreDestroyed()
  {
    AppMethodBeat.i(348147);
    Fragment localFragment = getFragment();
    if (localFragment != null)
    {
      k localk = k.aeZF;
      ((as)k.y(localFragment).q(as.class)).GSY = false;
      localk = k.aeZF;
      ((as)k.y(localFragment).q(as.class)).onDestroy();
    }
    dTv().onDetach();
    super.onPreDestroyed();
    this.Auw.dead();
    this.Aux.dead();
    AppMethodBeat.o(348147);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(348134);
    super.onResume();
    Log.i("SimpleUIComponent", "onResume");
    FinderTopicFeedLoader localFinderTopicFeedLoader2 = this.Aur;
    FinderTopicFeedLoader localFinderTopicFeedLoader1 = localFinderTopicFeedLoader2;
    if (localFinderTopicFeedLoader2 == null)
    {
      s.bIx("feedLoader");
      localFinderTopicFeedLoader1 = null;
    }
    localFinderTopicFeedLoader1.Bjy = -1;
    AppMethodBeat.o(348134);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$FinderHottestFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "topicType", "", "topicContent", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "bypassInfo", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "getTopicType", "()I", "interceptPostStart", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class FinderHottestFeedLoader
    extends FinderTopicFeedLoader
  {
    private final int Auy;
    private final String Auz;
    
    public FinderHottestFeedLoader(String paramString1, bui parambui, String paramString2)
    {
      super(parambui, paramString2, str);
      AppMethodBeat.i(348056);
      this.Auy = paramString1;
      this.Auz = parambui;
      AppMethodBeat.o(348056);
    }
    
    public final boolean interceptPostStart()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$FinderNewestLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "topicType", "", "topicContent", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "bypassInfo", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "getTopicType", "()I", "onPostStart", "", "localId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class FinderNewestLoader
    extends FinderTopicFeedLoader
  {
    private final int Auy;
    private final String Auz;
    
    public FinderNewestLoader(String paramString1, bui parambui, String paramString2)
    {
      super(parambui, paramString2, str);
      AppMethodBeat.i(348085);
      this.Auy = paramString1;
      this.Auz = parambui;
      AppMethodBeat.o(348085);
    }
    
    public final void onPostStart(long paramLong)
    {
      AppMethodBeat.i(348089);
      super.onPostStart(paramLong);
      Object localObject = k.aeZF;
      localObject = k.d(FinderActivityContentUIC.this.getActivity()).q(h.class);
      s.s(localObject, "UICProvider.of(activity)…tivityTabUIC::class.java)");
      FinderTabUIC.a((FinderTabUIC)localObject, 1);
      AppMethodBeat.o(348089);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$Companion;", "", "()V", "CUSTOM", "", "HOTTEST", "LATEST", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityContentUIC
 * JD-Core Version:    0.7.0.1
 */