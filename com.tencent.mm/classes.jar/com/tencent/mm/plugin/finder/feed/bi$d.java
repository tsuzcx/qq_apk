package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.convert.bc;
import com.tencent.mm.plugin.finder.convert.bc.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.f;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.music.FinderQQMusicFollowHeaderView;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderTagFlowLayout;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "refreshCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$RefreshCallback;", "(Lcom/tencent/mm/ui/MMActivity;IIZLcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$RefreshCallback;)V", "TAG", "", "VIEW_TYPR_LOADING_HEADER", "actionBarTitle", "Landroid/widget/TextView;", "getActionBarTitle", "()Landroid/widget/TextView;", "actionBarTitle$delegate", "Lkotlin/Lazy;", "activityHeaderManager", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "getActivityHeaderManager", "()Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "setActivityHeaderManager", "(Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;)V", "campaignEmptyView", "Landroid/view/View;", "getCampaignEmptyView", "()Landroid/view/View;", "setCampaignEmptyView", "(Landroid/view/View;)V", "extraType", "getExtraType", "()I", "setExtraType", "(I)V", "followId", "getFollowId", "()Ljava/lang/String;", "setFollowId", "(Ljava/lang/String;)V", "followTopicFloatHeader", "getFollowTopicFloatHeader", "setFollowTopicFloatHeader", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "innerTabType", "getInnerTabType", "setInnerTabType", "isEnableActivityHeader", "loadingHeader", "mReportFragment", "Landroidx/fragment/app/Fragment;", "getMReportFragment", "()Landroidx/fragment/app/Fragment;", "setMReportFragment", "(Landroidx/fragment/app/Fragment;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "needRefreshWhenEnter", "getNeedRefreshWhenEnter", "()Z", "setNeedRefreshWhenEnter", "(Z)V", "getRefreshCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$RefreshCallback;", "topic", "getTopic", "setTopic", "topicHeader", "getTopicHeader", "setTopicHeader", "topicHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "topicId", "", "getTopicId", "()J", "setTopicId", "(J)V", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "topicNonceId", "getTopicNonceId", "setTopicNonceId", "type", "getType", "setType", "addLoadingHeader", "", "addTagsHeader", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "bindFeedFlowEventSubscriber", "fragment", "dimissLoadingHeader", "getActivity", "getCurReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "holder", "", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isHeaderWithFollow", "onDetach", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "onTopicOnRefreshEnd", "otherFullSpan", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "refreshHeader", "subTitle", "refreshHeaderContent", "count", "errCode", "errMsg", "refreshWhenEnter", "setTitleExposedListener", "title", "showHeaderOnDataEmpty", "showProgressHeader", "ifShow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi$d
  extends c.b
{
  public long ADo;
  public String ADp;
  public boolean AWd;
  View AXg;
  com.tencent.mm.plugin.finder.model.j AZH;
  public int BaZ;
  final bi.b Bbl;
  private final boolean Bbm;
  ah Bbn;
  public View Bbo;
  private final kotlin.j Bbp;
  private View Bbq;
  private final int Bbr;
  public String Bbs;
  public int Bbt;
  public Fragment Bbu;
  private com.tencent.mm.plugin.finder.activity.view.a Bbv;
  public View Bbw;
  final String TAG;
  bxv hLt;
  bqj musicInfo;
  public String topic;
  public int type;
  
  private bi$d(MMActivity paramMMActivity, int paramInt, bi.b paramb)
  {
    super(paramMMActivity, 2, paramInt, false);
    AppMethodBeat.i(364128);
    this.Bbl = paramb;
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedViewCallback";
    this.Bbp = kotlin.k.cm((kotlin.g.a.a)new a(paramMMActivity));
    this.Bbr = -2;
    this.topic = "";
    this.Bbs = "";
    this.ADp = "";
    this.Bbt = 1;
    this.AZH = new com.tencent.mm.plugin.finder.model.j(new epc());
    this.AWd = true;
    AppMethodBeat.o(364128);
  }
  
  private static final void a(View paramView1, boi paramboi, View paramView2)
  {
    AppMethodBeat.i(364161);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramboi);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$this_apply");
    s.u(paramboi, "$location");
    paramView2 = av.GiL;
    paramView1 = paramView1.getContext();
    s.s(paramView1, "context");
    av.a(paramView1, paramboi);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364161);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(364156);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    if (paramd.BaZ == 9)
    {
      paramd = paramd.AXg;
      if (paramd == null)
      {
        paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderQQMusicFollowHeaderView");
        AppMethodBeat.o(364156);
        throw paramd;
      }
      ((FinderQQMusicFollowHeaderView)paramd).eDV();
    }
    for (;;)
    {
      paramd = v.FrN;
      v.T(false, 6);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364156);
      return;
      paramd = paramd.AXg;
      if (paramd == null)
      {
        paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.IFinderFollowTopicHeaderView");
        AppMethodBeat.o(364156);
        throw paramd;
      }
      ((com.tencent.mm.plugin.finder.music.d)paramd).eDL();
    }
  }
  
  private static final void b(d paramd, View paramView)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(364173);
    s.u(paramd, "this$0");
    s.u(paramView, "$this_apply");
    Object localObject1;
    bxt localbxt;
    if (paramd.BaZ == 9)
    {
      paramView = ((bi.c)paramd.ebL()).musicInfo;
      if (paramView != null)
      {
        localObject1 = paramd.AXg;
        if (localObject1 == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderQQMusicFollowHeaderView");
          AppMethodBeat.o(364173);
          throw paramd;
        }
        ((FinderQQMusicFollowHeaderView)localObject1).a(paramView, ((bi.c)paramd.ebL()).eQp);
        AppMethodBeat.o(364173);
      }
    }
    else
    {
      localbxt = ((bi.c)paramd.ebL()).bgmInfo;
      if (localbxt == null) {
        break label472;
      }
      Object localObject4;
      if (localbxt.musicInfo == null)
      {
        localObject4 = ((Iterable)paramd.ebL().ALH.getDataList()).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject1 = ((Iterator)localObject4).next();
          if (s.p(com.tencent.mm.ae.d.hF(((BaseFinderFeed)localObject1).feedObject.getFeedObject().id), localbxt.groupId))
          {
            localObject1 = (cc)localObject1;
            label201:
            if (localObject1 != null) {
              break label266;
            }
          }
        }
      }
      label266:
      for (localObject1 = null;; localObject1 = ((BaseFinderFeed)localObject1).feedObject)
      {
        localObject4 = paramd.AXg;
        if (localObject4 != null) {
          break label277;
        }
        paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.IFinderFollowTopicHeaderView");
        AppMethodBeat.o(364173);
        throw paramd;
        localObject1 = null;
        break;
        localObject1 = (cc)kotlin.a.p.ae((List)paramd.ebL().ALH.getDataList(), 0);
        break label201;
      }
      label277:
      ((com.tencent.mm.plugin.finder.music.d)localObject4).a((FinderItem)localObject1, localbxt, ((bi.c)paramd.ebL()).Bba, ((bi.c)paramd.ebL()).eQp);
      if (localbxt.musicInfo == null) {
        break label371;
      }
      paramView = localbxt.musicInfo;
      if (paramView != null) {
        break label363;
      }
      paramView = localObject3;
      paramView = String.valueOf(paramView);
    }
    for (;;)
    {
      ((TextView)paramd.eda().findViewById(e.e.finder_topic_header_text)).setText((CharSequence)paramView);
      AppMethodBeat.o(364173);
      return;
      label363:
      paramView = paramView.name;
      break;
      label371:
      if (localbxt.contact != null)
      {
        localObject1 = paramView.getContext();
        int i = e.h.finder_follow_header_title;
        paramView = localbxt.contact;
        if (paramView == null) {}
        for (paramView = localObject2;; paramView = paramView.nickname)
        {
          paramView = ((Context)localObject1).getString(i, new Object[] { paramView });
          s.s(paramView, "context.getString(R.stri…gmInfo.contact?.nickname)");
          break;
        }
      }
      if (localObject1 != null)
      {
        paramView = paramView.getContext().getString(e.h.finder_follow_header_title, new Object[] { ((FinderItem)localObject1).getFinderObject().nickname });
        s.s(paramView, "context.getString(R.stri…tFinderObject().nickname)");
      }
      else
      {
        label472:
        paramView = "";
      }
    }
  }
  
  /* Error */
  private void edb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 539
    //   5: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 541	com/tencent/mm/plugin/finder/feed/bi$d:Bbq	Landroid/view/View;
    //   12: ifnonnull +24 -> 36
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 544	com/tencent/mm/plugin/finder/feed/c$b:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   20: checkcast 520	android/content/Context
    //   23: invokestatic 550	com/tencent/mm/ui/af:mU	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   26: getstatic 555	com/tencent/mm/plugin/finder/e$f:finder_loading_header	I
    //   29: aconst_null
    //   30: invokevirtual 561	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   33: putfield 541	com/tencent/mm/plugin/finder/feed/bi$d:Bbq	Landroid/view/View;
    //   36: aload_0
    //   37: getfield 244	com/tencent/mm/plugin/finder/feed/bi$d:TAG	Ljava/lang/String;
    //   40: astore_2
    //   41: aload_0
    //   42: getfield 541	com/tencent/mm/plugin/finder/feed/bi$d:Bbq	Landroid/view/View;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnonnull +40 -> 87
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_2
    //   53: ldc_w 563
    //   56: aload_1
    //   57: invokestatic 567	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   60: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 541	com/tencent/mm/plugin/finder/feed/bi$d:Bbq	Landroid/view/View;
    //   67: astore_1
    //   68: aload_1
    //   69: ifnonnull +26 -> 95
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +28 -> 103
    //   78: ldc_w 539
    //   81: invokestatic 214	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: aload_1
    //   88: invokevirtual 576	android/view/View:getParent	()Landroid/view/ViewParent;
    //   91: astore_1
    //   92: goto -40 -> 52
    //   95: aload_1
    //   96: invokevirtual 576	android/view/View:getParent	()Landroid/view/ViewParent;
    //   99: astore_1
    //   100: goto -26 -> 74
    //   103: aload_0
    //   104: getfield 541	com/tencent/mm/plugin/finder/feed/bi$d:Bbq	Landroid/view/View;
    //   107: ifnull +28 -> 135
    //   110: aload_0
    //   111: invokevirtual 580	com/tencent/mm/plugin/finder/feed/bi$d:getAdapter	()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 541	com/tencent/mm/plugin/finder/feed/bi$d:Bbq	Landroid/view/View;
    //   119: astore_2
    //   120: aload_2
    //   121: invokestatic 583	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   124: aload_1
    //   125: aload_2
    //   126: aload_0
    //   127: getfield 259	com/tencent/mm/plugin/finder/feed/bi$d:Bbr	I
    //   130: iconst_1
    //   131: invokevirtual 588	com/tencent/mm/view/recyclerview/WxRecyclerAdapter:i	(Landroid/view/View;IZ)Lcom/tencent/mm/view/recyclerview/i$b;
    //   134: pop
    //   135: ldc_w 539
    //   138: invokestatic 214	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: goto -57 -> 84
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	d
    //   45	80	1	localObject1	Object
    //   144	4	1	localObject2	Object
    //   40	86	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	144	finally
    //   36	46	144	finally
    //   52	68	144	finally
    //   78	84	144	finally
    //   87	92	144	finally
    //   95	100	144	finally
    //   103	135	144	finally
    //   135	141	144	finally
  }
  
  private void fC(View paramView)
  {
    AppMethodBeat.i(364148);
    if (paramView != null) {
      com.tencent.mm.view.f.a(paramView, (e.b)new b(this));
    }
    AppMethodBeat.o(364148);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(364286);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    s.u(parama, "adapter");
    s.u(paramView, "view");
    int j = paramInt - ((com.tencent.mm.view.recyclerview.i)parama).agOb.size();
    label117:
    FinderItem localFinderItem;
    if (j >= 0)
    {
      parama = ebL();
      int i;
      if (parama == null)
      {
        i = 0;
        if (j >= i) {
          break label1682;
        }
        parama = ebL();
        if (parama != null) {
          break label356;
        }
        parama = null;
        if (parama != null) {
          break label402;
        }
        localFinderItem = null;
        label124:
        localObject2 = this.TAG;
        localObject3 = new StringBuilder("onClick ").append(j).append(" id:");
        if (localFinderItem != null) {
          break label411;
        }
      }
      label402:
      label411:
      for (localObject1 = null;; localObject1 = Long.valueOf(localFinderItem.getId()))
      {
        Log.i((String)localObject2, localObject1 + ", pos:" + j);
        if ((localFinderItem == null) || (localFinderItem.getMediaType() != 9)) {
          break label571;
        }
        if (!Util.isEqual(localFinderItem.getUserName(), com.tencent.mm.model.z.bAW())) {
          break label424;
        }
        parama = h.ax(com.tencent.mm.plugin.f.class);
        s.s(parama, "service(IActivityRouter::class.java)");
        localObject1 = (com.tencent.mm.plugin.f)parama;
        localObject2 = (Context)this.lzt;
        long l = localFinderItem.getId();
        localObject3 = localFinderItem.getObjectNonceId();
        paramView = localFinderItem.getLiveInfo();
        parama = paramView;
        if (paramView == null) {
          parama = new bip();
        }
        f.a.a((com.tencent.mm.plugin.f)localObject1, (Context)localObject2, l, (String)localObject3, parama, null, null, null, null, null, localFinderItem.getFinderObject().sessionBuffer, null, null, 7152);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(364286);
        return;
        parama = parama.ALH;
        if (parama == null)
        {
          i = 0;
          break;
        }
        i = parama.getSize();
        break;
        label356:
        parama = parama.ALH;
        if (parama == null)
        {
          parama = null;
          break label117;
        }
        parama = parama.getListOfType(BaseFinderFeed.class);
        if (parama == null)
        {
          parama = null;
          break label117;
        }
        parama = (BaseFinderFeed)parama.get(j);
        break label117;
        localFinderItem = parama.feedObject;
        break label124;
      }
      label424:
      ((ce)h.ax(ce.class)).a(parama, paramInt, q.w.DwU, "26");
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      paramView = as.a.hu(paramView);
      if (paramView == null) {
        paramInt = 0;
      }
      for (;;)
      {
        paramView = h.ax(com.tencent.mm.plugin.f.class);
        s.s(paramView, "service(IActivityRouter::class.java)");
        f.a.a((com.tencent.mm.plugin.f)paramView, (Context)this.lzt, ((com.tencent.mm.plugin.g)h.ax(com.tencent.mm.plugin.g.class)).a((ArrayList)ebL().ALH.getDataList(), (cc)parama, this.type, paramInt), null, null, null, false, 60);
        break;
        paramView = paramView.fou();
        if (paramView == null) {
          paramInt = 0;
        } else {
          paramInt = paramView.AJo;
        }
      }
      label571:
      Object localObject3 = new Intent();
      ((Intent)localObject3).putExtra("key_topic_type", this.type);
      label673:
      label694:
      label742:
      Object localObject4;
      if (this.type == 4)
      {
        localObject2 = ((bi.c)ebL()).bgmInfo;
        if (localObject2 != null)
        {
          if (((bxt)localObject2).musicInfo == null) {
            break label870;
          }
          localObject1 = ((bxt)localObject2).musicInfo;
          if (localObject1 == null)
          {
            localObject1 = null;
            localObject1 = String.valueOf(localObject1);
            ((Intent)localObject3).putExtra("key_topic_title", (String)localObject1);
            ((Intent)localObject3).putExtra("KEY_FOLLOW_ID", ((bxt)localObject2).groupId);
          }
        }
        else
        {
          ((Intent)localObject3).putExtra("KEY_TOPIC_ID", this.ADo);
          if (localFinderItem != null) {
            break label1091;
          }
          localObject1 = null;
          ((Intent)localObject3).putExtra("KEY_CLICK_FEED_ID", ((Long)localObject1).longValue());
          ((Intent)localObject3).putExtra("KEY_CLICK_FEED_POSITION", j);
          localObject1 = (bi.c)ebL();
          if (!bi.c.f(((bi.c)localObject1).AZG)) {
            break label1104;
          }
          localObject2 = null;
          localObject4 = (FinderTopicFeedLoader)ebL().ALH;
          if (localObject2 != null) {
            break label1142;
          }
          localObject1 = null;
          label762:
          localObject1 = ((FinderTopicFeedLoader)localObject4).avY((String)localObject1);
          ebL().ALH.saveCache((Intent)localObject3, j, (com.tencent.mm.plugin.finder.feed.model.c)new bl((epc)localObject2, (com.tencent.mm.bx.b)localObject1));
          ((Intent)localObject3).putExtra("key_ref_object_id", this.lzt.getIntent().getLongExtra("key_ref_object_id", 0L));
          localObject1 = ebL();
          if (localObject1 != null) {
            break label1192;
          }
        }
      }
      label1192:
      for (localObject1 = null;; localObject1 = ((c.a)localObject1).ALH)
      {
        if (localObject1 != null) {
          break label1202;
        }
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(364286);
        throw parama;
        localObject1 = ((bqj)localObject1).name;
        break;
        label870:
        localObject4 = this.lzt;
        paramInt = e.h.finder_follow_header_title;
        localObject1 = ((bxt)localObject2).contact;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((FinderContact)localObject1).nickname)
        {
          localObject1 = ((MMActivity)localObject4).getString(paramInt, new Object[] { localObject1 });
          s.s(localObject1, "{\n                      …                        }");
          break;
        }
        if (this.type == 7)
        {
          localObject1 = this.hLt;
          if (localObject1 == null) {
            break label673;
          }
          localObject4 = ((bxv)localObject1).aagK;
          if (localObject4 == null) {
            break label673;
          }
          ((Intent)localObject3).putExtra("key_activity_name", ((awt)localObject4).eventName);
          localObject1 = ((awt)localObject4).contact;
          if (localObject1 == null) {
            localObject1 = "";
          }
          for (;;)
          {
            ((Intent)localObject3).putExtra("key_creator_finder_name", (String)localObject1);
            ((Intent)localObject3).putExtra("key_activity_id", ((awt)localObject4).ocD);
            ((Intent)localObject3).putExtra("key_activity_inner_tab_type", this.Bbt);
            ((Intent)localObject3).putExtra("key_activity_max_top_count", ((awt)localObject4).BbV);
            break;
            localObject2 = ((FinderContact)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
        }
        ((Intent)localObject3).putExtra("key_topic_title", this.topic);
        break label673;
        label1091:
        localObject1 = Long.valueOf(localFinderItem.getId());
        break label694;
        label1104:
        localObject2 = new epc();
        ((epc)localObject2).abtn = new LinkedList();
        ((epc)localObject2).abtn.add(((bi.c)localObject1).AZG);
        break label742;
        label1142:
        localObject1 = ((epc)localObject2).abtn;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label762;
        }
        localObject1 = (bxv)((LinkedList)localObject1).get(0);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label762;
        }
        localObject1 = ((bxv)localObject1).topic;
        break label762;
      }
      label1202:
      localObject1 = ((FinderTopicFeedLoader)localObject1).Bjw;
      if (localObject1 == null)
      {
        localObject1 = null;
        ((Intent)localObject3).putExtra("KEY_FINDER_LOCATION", (byte[])localObject1);
        localObject1 = ebL();
        if (localObject1 != null) {
          break label1279;
        }
      }
      label1279:
      for (localObject1 = null;; localObject1 = ((c.a)localObject1).ALH)
      {
        if (localObject1 != null) {
          break label1289;
        }
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(364286);
        throw parama;
        localObject1 = ((boi)localObject1).toByteArray();
        break;
      }
      label1289:
      localObject1 = ((FinderTopicFeedLoader)localObject1).ACr;
      if (localObject1 != null) {
        ((Intent)localObject3).putExtra("KEY_SECTION_INFO", ((bve)localObject1).toByteArray());
      }
      localObject1 = ebL();
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ((c.a)localObject1).ALH)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(364286);
        throw parama;
      }
      ((FinderTopicFeedLoader)localObject1).Bjt = null;
      Log.i(this.TAG, s.X("enterTopicTimelineUI, fixPos:", Integer.valueOf(j)));
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = paramView.getContext();
      s.s(localObject1, "view.context");
      as.a.a((Context)localObject1, (Intent)localObject3, 0L, 0, false, 124);
      localObject1 = (com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class);
      Object localObject2 = paramView.getContext();
      s.s(localObject2, "view.context");
      ((com.tencent.mm.plugin.f)localObject1).n((Context)localObject2, (Intent)localObject3);
      if (localFinderItem != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        if (localFinderItem != null) {
          break label1705;
        }
        localObject1 = null;
        com.tencent.mm.plugin.finder.report.z.ab(((Long)localObject1).longValue(), 2);
        if (this.type != 7) {
          break label1718;
        }
        localObject2 = this.Bbu;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = null;
        }
        if (localObject1 == null) {
          break label1718;
        }
        label1519:
        s.s(localObject1, "context");
        if (!(localObject1 instanceof AppCompatActivity)) {
          break label1727;
        }
        paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramView = as.a.hu((Context)localObject1);
        if (paramView == null) {
          break label1763;
        }
        paramView = paramView.fou();
        label1556:
        if (paramView != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          if (localFinderItem != null) {
            break label1768;
          }
        }
      }
    }
    label1682:
    label1705:
    label1718:
    label1727:
    label1763:
    label1768:
    for (localObject1 = null;; localObject1 = Long.valueOf(localFinderItem.getId()))
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, ((Long)localObject1).longValue(), this.ATx.getRecyclerView(), this.Bbt, null, 16);
      paramView = com.tencent.mm.plugin.finder.topic.a.FNS;
      com.tencent.mm.plugin.finder.topic.a.a((Context)this.lzt, "video_card", 1, localFinderItem.getId(), this.ADo, this.topic);
      paramView = com.tencent.mm.plugin.finder.report.k.Fpu;
      paramView = (Context)this.lzt;
      parama = (cc)parama;
      s.u(paramView, "context");
      s.u(parama, "feed");
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      com.tencent.mm.plugin.finder.report.k.a(((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.nq(paramView).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), parama);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
      AppMethodBeat.o(364286);
      return;
      localObject1 = Long.valueOf(localFinderItem.getId());
      break;
      localObject1 = paramView.getContext();
      break label1519;
      if ((localObject1 instanceof Fragment))
      {
        paramView = com.tencent.mm.ui.component.k.aeZF;
        paramView = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
        break label1556;
      }
      paramView = null;
      break label1556;
    }
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(364218);
    s.u(paramArrayList, "data");
    if ((this.Bbm) && (this.type == 7)) {
      this.Bbv = new com.tencent.mm.plugin.finder.activity.view.a(this.lzt);
    }
    if (edd()) {
      this.Bbn = new ah(this.lzt, this.ATx);
    }
    super.ae(paramArrayList);
    AppMethodBeat.o(364218);
  }
  
  public final void avQ(String paramString)
  {
    AppMethodBeat.i(364210);
    s.u(paramString, "<set-?>");
    this.topic = paramString;
    AppMethodBeat.o(364210);
  }
  
  public final void avR(String paramString)
  {
    AppMethodBeat.i(364371);
    View localView = this.AXg;
    if (localView != null) {
      switch (this.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(364371);
      return;
      if (paramString != null)
      {
        if (((CharSequence)paramString).length() > 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          ((TextView)localView.findViewById(e.e.topic_location_sec_title)).setText((CharSequence)paramString);
          localView.findViewById(e.e.topic_location_jump).setVisibility(0);
          paramString = this.lzt.getIntent().getByteArrayExtra("key_topic_poi_location");
          if (paramString == null) {
            break label212;
          }
          boi localboi = new boi();
          localboi.parseFrom(paramString);
          if ((Util.isNullOrNil(localboi.poiName)) && (!Util.isNullOrNil(localboi.city))) {
            break;
          }
          localView.findViewById(e.e.topic_location_jump).setVisibility(0);
          localView.findViewById(e.e.topic_location_jump).setOnClickListener(new bi.d..ExternalSyntheticLambda0(localView, localboi));
          AppMethodBeat.o(364371);
          return;
        }
        localView.findViewById(e.e.topic_location_jump).setVisibility(8);
        label212:
        AppMethodBeat.o(364371);
        return;
        localView.post(new bi.d..ExternalSyntheticLambda2(this, localView));
      }
    }
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(364334);
    s.u(paramd, "reason");
    AppMethodBeat.o(364334);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(364340);
    s.u(paramd, "reason");
    AppMethodBeat.o(364340);
    return null;
  }
  
  public final void dUO() {}
  
  public final void e(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(364380);
    s.u(paramd, "reason");
    Object localObject;
    if (this.type == 7)
    {
      localObject = paramd.extraData;
      if (!(localObject instanceof FinderTopicFeedLoader.f)) {
        break label136;
      }
      localObject = (FinderTopicFeedLoader.f)localObject;
      if (localObject != null) {
        break label141;
      }
    }
    label136:
    label141:
    for (boolean bool = true;; bool = ((FinderTopicFeedLoader.f)localObject).getHasMore())
    {
      if ((!bool) && (paramd.agJv != 0))
      {
        paramd = this.ATx.getLoadMoreFooter();
        if (paramd != null)
        {
          paramd.setVisibility(0);
          localObject = paramd.findViewById(e.e.load_more_footer_tip_tv);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          paramd = paramd.findViewById(e.e.load_more_footer_end_layout);
          if (paramd != null) {
            paramd.setVisibility(0);
          }
        }
      }
      paramd = ((bi.c)ebL()).AXh;
      if (paramd != null) {
        paramd.eES();
      }
      AppMethodBeat.o(364380);
      return;
      localObject = null;
      break;
    }
  }
  
  public final boolean ebM()
  {
    return this.AWd;
  }
  
  public final boolean ebN()
  {
    return this.type != 7;
  }
  
  public final View eda()
  {
    AppMethodBeat.i(364203);
    View localView = this.Bbo;
    if (localView != null)
    {
      AppMethodBeat.o(364203);
      return localView;
    }
    s.bIx("followTopicFloatHeader");
    AppMethodBeat.o(364203);
    return null;
  }
  
  public final void edc()
  {
    AppMethodBeat.i(364351);
    if (this.Bbq != null)
    {
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      View localView = this.Bbq;
      s.checkNotNull(localView);
      localWxRecyclerAdapter.ae(localView.hashCode(), true);
    }
    AppMethodBeat.o(364351);
  }
  
  final boolean edd()
  {
    return this.type == 5;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(364293);
    s.u(paramContext, "context");
    paramContext = dUN().fT(paramContext);
    AppMethodBeat.o(364293);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(364309);
    if (this.type == 7)
    {
      localView = this.Bbw;
      AppMethodBeat.o(364309);
      return localView;
    }
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(364309);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(364329);
    Object localObject1;
    if (this.AXg != null)
    {
      localObject1 = this.AXg;
      AppMethodBeat.o(364329);
      return localObject1;
    }
    Object localObject2;
    Object localObject3;
    switch (this.type)
    {
    case 3: 
    case 6: 
    default: 
      localObject1 = this.AXg;
      AppMethodBeat.o(364329);
      return localObject1;
    case 1: 
    case 5: 
      if (this.Bbn != null)
      {
        ah localah = this.Bbn;
        s.checkNotNull(localah);
        Log.i("Finder.FinderNewsTopicHelper", s.X("getTopicHeaderView : ", null));
        localObject2 = af.mU((Context)localah.lzt).inflate(e.f.finder_topic_news_layout, null, false);
        localObject3 = localah.lzt.getIntent().getStringExtra("key_topic_title");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = (TextView)((View)localObject2).findViewById(e.e.topic_news_title);
        if (localObject3 != null)
        {
          if (!n.U((String)localObject1, "#", false))
          {
            ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(((TextView)localObject3).getContext(), (CharSequence)s.X("#", localObject1)));
            label211:
            aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
          }
        }
        else
        {
          localObject1 = (TextView)((View)localObject2).findViewById(e.e.feed_item_news_tag_text);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localah.b(null);
          s.s(localObject2, "header");
          localObject1 = localObject2;
        }
      }
      break;
    }
    for (;;)
    {
      this.AXg = ((View)localObject1);
      break;
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(((TextView)localObject3).getContext(), (CharSequence)localObject1));
      break label211;
      this.AXg = View.inflate((Context)this.lzt, e.f.finder_topic_feed_header, null);
      localObject1 = this.AXg;
      if (localObject1 == null) {
        break;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.topic_tv);
      if (localObject1 == null) {
        break;
      }
      com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject1);
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(((TextView)localObject1).getContext(), (CharSequence)this.topic));
      fC((View)localObject1);
      break;
      localObject1 = View.inflate((Context)this.lzt, e.f.finder_topic_feed_header, null);
      localObject2 = (TextView)((View)localObject1).findViewById(e.e.topic_tv);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(((TextView)localObject2).getContext(), (CharSequence)this.topic));
        fC((View)localObject2);
      }
      ((ImageView)((View)localObject1).findViewById(e.e.topic_icon_left)).setImageResource(e.g.icons_outlined_location);
      localObject2 = kotlin.ah.aiuX;
      continue;
      if (this.BaZ == 9)
      {
        localObject1 = (View)new FinderQQMusicFollowHeaderView((Context)this.lzt);
        label476:
        this.AXg = ((View)localObject1);
        localObject1 = af.mU((Context)this.lzt).inflate(e.f.finder_follow_topic_header_on_scroll_layout, null);
        s.s(localObject1, "getInflater(context).inf…er_on_scroll_layout,null)");
        s.u(localObject1, "<set-?>");
        this.Bbo = ((View)localObject1);
        eda().setAlpha(0.0F);
        eda().setVisibility(4);
        localObject1 = av.GiL;
        if (av.fgg() != 1) {
          break label662;
        }
        eda().findViewById(e.e.follow_btn_float).setVisibility(8);
      }
      for (;;)
      {
        localObject1 = new FrameLayout.LayoutParams(-1, this.lzt.getResources().getDimensionPixelSize(e.c.Edge_6A));
        ((FrameLayout.LayoutParams)localObject1).gravity = 48;
        ((FrameLayout.LayoutParams)localObject1).setMargins(0, bf.be((Context)this.lzt), 0, 0);
        ((FrameLayout)this.lzt.getWindow().getDecorView()).addView(eda(), (ViewGroup.LayoutParams)localObject1);
        break;
        localObject1 = ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishVlogApi().gL((Context)this.lzt);
        break label476;
        label662:
        eda().findViewById(e.e.follow_btn_float).setOnClickListener(new bi.d..ExternalSyntheticLambda1(this));
      }
      localObject2 = this.Bbv;
      if (localObject2 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = af.mU((Context)((com.tencent.mm.plugin.finder.activity.view.a)localObject2).lzt).inflate(e.f.finder_activity_profile_header, null, false);
        ((com.tencent.mm.plugin.finder.activity.view.a)localObject2).fn((View)localObject1);
        s.s(localObject1, "headerView");
      }
    }
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(364301);
    RecyclerView.h localh = dUN().getItemDecoration();
    AppMethodBeat.o(364301);
    return localh;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(364397);
    Object localObject1 = this.lzt;
    Object localObject2 = FinderTagView.GCE;
    localObject2 = (FinderTagView)((MMActivity)localObject1).findViewById(FinderTagView.flo());
    if (localObject2 == null)
    {
      localObject1 = this.ATx.getRecyclerView();
      localObject2 = FinderTagView.GCE;
      localObject2 = (FinderTagView)((RecyclerView)localObject1).findViewById(FinderTagView.flo());
    }
    for (;;)
    {
      if ((this.AXg instanceof com.tencent.mm.plugin.finder.music.d))
      {
        localObject1 = this.AXg;
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.IFinderFollowTopicHeaderView");
          AppMethodBeat.o(364397);
          throw ((Throwable)localObject1);
        }
        ((com.tencent.mm.plugin.finder.music.d)localObject1).eDM();
      }
      localObject1 = this.Bbv;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.activity.view.a)localObject1).destroy();
      }
      if (localObject2 == null) {
        localObject1 = null;
      }
      Object localObject3;
      bui localbui;
      for (;;)
      {
        if (localObject1 == null)
        {
          localObject1 = (d)this;
          localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
          localObject2 = as.a.hu((Context)((c.b)localObject1).lzt);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject2).fou();
            if (localObject2 != null)
            {
              localObject3 = com.tencent.mm.plugin.finder.report.z.FrZ;
              com.tencent.mm.plugin.finder.report.z.a((bui)localObject2, ((d)localObject1).topic, "", 0, 0);
            }
          }
        }
        AppMethodBeat.o(364397);
        return;
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject1 = as.a.hu((Context)this.lzt);
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localbui = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).fou();
          if (localbui != null) {
            break;
          }
          localObject1 = null;
        }
      }
      int k;
      int i;
      if (((FinderTagView)localObject2).GCQ == 1)
      {
        k = ((FinderTagView)localObject2).getTagData().abtn.size();
        if (k <= 0) {
          break label590;
        }
        i = 0;
        localObject1 = "";
      }
      for (;;)
      {
        int j = i + 1;
        localObject3 = (bxv)((FinderTagView)localObject2).getTagData().abtn.get(i);
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject1).append(((bxv)localObject3).topic).append(";1;");
        localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((bxv)localObject3).ADo));
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = Integer.valueOf(0);
        }
        localObject1 = ((Integer)localObject1).intValue() + '#';
        if (j >= k) {
          for (;;)
          {
            localObject3 = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.a(localbui, this.topic, (String)localObject1, ((FinderTagView)localObject2).getHasExpandBtn(), ((FinderTagView)localObject2).GCQ);
            localObject1 = kotlin.ah.aiuX;
            break;
            k = ((List)((FinderTagView)localObject2).getTagLayout().GCA.get(0)).size();
            if (k > 0)
            {
              i = 0;
              for (localObject1 = "";; localObject1 = localObject3)
              {
                j = i + 1;
                localObject3 = (bxv)((FinderTagView)localObject2).getTagData().abtn.get(i);
                localStringBuilder = new StringBuilder().append((String)localObject1).append(((bxv)localObject3).topic).append(";1;");
                localObject3 = (Integer)((FinderTagView)localObject2).getTagClickMap().get(Long.valueOf(((bxv)localObject3).ADo));
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = Integer.valueOf(0);
                }
                localObject3 = ((Integer)localObject1).intValue() + '#';
                localObject1 = localObject3;
                if (j >= k) {
                  break;
                }
                i = j;
              }
            }
            label590:
            localObject1 = "";
          }
        }
        i = j;
      }
    }
  }
  
  /* Error */
  public final void qa(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1404
    //   5: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 244	com/tencent/mm/plugin/finder/feed/bi$d:TAG	Ljava/lang/String;
    //   12: ldc_w 1406
    //   15: iload_1
    //   16: invokestatic 1411	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   19: invokestatic 567	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   22: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iload_1
    //   26: ifeq +16 -> 42
    //   29: aload_0
    //   30: invokespecial 1413	com/tencent/mm/plugin/finder/feed/bi$d:edb	()V
    //   33: ldc_w 1404
    //   36: invokestatic 214	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: invokevirtual 1415	com/tencent/mm/plugin/finder/feed/bi$d:edc	()V
    //   46: ldc_w 1404
    //   49: invokestatic 214	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -13 -> 39
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	d
    //   0	60	1	paramBoolean	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	55	finally
    //   29	39	55	finally
    //   42	52	55	finally
  }
  
  public final boolean t(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(364235);
    s.u(paramj, "holder");
    if (paramj.caO != this.Bbr)
    {
      if (paramj.tag != null)
      {
        paramj = paramj.tag;
        bc.a locala = bc.ALi;
        if (!s.p(paramj, Integer.valueOf(bc.dXL()))) {}
      }
    }
    else
    {
      AppMethodBeat.o(364235);
      return true;
    }
    AppMethodBeat.o(364235);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(MMActivity paramMMActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$setTitleExposedListener$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e.b
  {
    b(bi.d paramd) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(363802);
      s.u(paramView, "view");
      if (this.Bbx.ATL == null)
      {
        AppMethodBeat.o(363802);
        return;
      }
      if (paramBoolean)
      {
        bi.d.a(this.Bbx).setVisibility(8);
        AppMethodBeat.o(363802);
        return;
      }
      bi.d.a(this.Bbx).setVisibility(0);
      TextView localTextView = bi.d.a(this.Bbx);
      if (!n.U(this.Bbx.topic, "#", false)) {}
      for (paramView = (CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.Bbx.lzt, (CharSequence)s.X("#", this.Bbx.topic));; paramView = (CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.Bbx.lzt, (CharSequence)this.Bbx.topic))
      {
        localTextView.setText(paramView);
        AppMethodBeat.o(363802);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bi.d
 * JD-Core Version:    0.7.0.1
 */