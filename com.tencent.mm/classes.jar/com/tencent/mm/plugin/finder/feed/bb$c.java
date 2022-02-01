package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.convert.bg;
import com.tencent.mm.plugin.finder.convert.bg.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.b;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.c;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.d;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.e;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.f;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic;
import com.tencent.mm.plugin.finder.video.y;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPR_LOADING_HEADER", "activityHeaderManager", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "getActivityHeaderManager", "()Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "setActivityHeaderManager", "(Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;)V", "campaignEmptyView", "Landroid/view/View;", "getCampaignEmptyView", "()Landroid/view/View;", "setCampaignEmptyView", "(Landroid/view/View;)V", "followId", "getFollowId", "()Ljava/lang/String;", "setFollowId", "(Ljava/lang/String;)V", "followTopicFloatHeader", "getFollowTopicFloatHeader", "setFollowTopicFloatHeader", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "innerTabType", "getInnerTabType", "()I", "setInnerTabType", "(I)V", "isEnableActivityHeader", "loadingHeader", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "needRefreshWhenEnter", "getNeedRefreshWhenEnter", "()Z", "setNeedRefreshWhenEnter", "(Z)V", "topic", "getTopic", "setTopic", "topicHeader", "getTopicHeader", "setTopicHeader", "topicHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "topicId", "", "getTopicId", "()J", "setTopicId", "(J)V", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "topicNonceId", "getTopicNonceId", "setTopicNonceId", "type", "getType", "setType", "addLoadingHeader", "", "addTagsHeader", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "bindFeedFlowEventSubscriber", "fragment", "Landroidx/fragment/app/Fragment;", "dimissLoadingHeader", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isHeaderWithFollow", "onDetach", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "onTopicOnRefreshEnd", "otherFullSpan", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "refreshHeader", "subTitle", "refreshHeaderContent", "count", "errCode", "errMsg", "refreshWhenEnter", "showHeaderOnDataEmpty", "showProgressHeader", "ifShow", "plugin-finder_release"})
public final class bb$c
  extends c.b
{
  final String TAG;
  bkr fGc;
  bfg musicInfo;
  public String topic;
  public int type;
  com.tencent.mm.plugin.finder.model.j xCC;
  private final boolean xEq;
  ad xEr;
  public View xEs;
  private View xEt;
  private final int xEu;
  public String xEv;
  public int xEw;
  com.tencent.mm.plugin.finder.activity.view.a xEx;
  public View xEy;
  public boolean xEz;
  public long xee;
  public String xef;
  View xzF;
  
  private bb$c(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, 2, paramInt, false);
    AppMethodBeat.i(242560);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedViewCallback";
    this.xEu = -2;
    this.topic = "";
    this.xEv = "";
    this.xef = "";
    this.xEw = 1;
    this.xCC = new com.tencent.mm.plugin.finder.model.j(new dwb());
    this.xEz = true;
    AppMethodBeat.o(242560);
  }
  
  /* Error */
  private void dub()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 227
    //   4: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 229	com/tencent/mm/plugin/finder/feed/bb$c:xEt	Landroid/view/View;
    //   11: ifnonnull +24 -> 35
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 232	com/tencent/mm/plugin/finder/feed/c$b:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   19: checkcast 234	android/content/Context
    //   22: invokestatic 240	com/tencent/mm/ui/ad:kS	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   25: getstatic 245	com/tencent/mm/plugin/finder/b$g:finder_loading_header	I
    //   28: aconst_null
    //   29: invokevirtual 251	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   32: putfield 229	com/tencent/mm/plugin/finder/feed/bb$c:xEt	Landroid/view/View;
    //   35: aload_0
    //   36: getfield 193	com/tencent/mm/plugin/finder/feed/bb$c:TAG	Ljava/lang/String;
    //   39: astore_2
    //   40: new 253	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 255
    //   46: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: astore_3
    //   50: aload_0
    //   51: getfield 229	com/tencent/mm/plugin/finder/feed/bb$c:xEt	Landroid/view/View;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +46 -> 102
    //   59: aload_1
    //   60: invokevirtual 263	android/view/View:getParent	()Landroid/view/ViewParent;
    //   63: astore_1
    //   64: aload_2
    //   65: aload_3
    //   66: aload_1
    //   67: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 276	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: getfield 229	com/tencent/mm/plugin/finder/feed/bb$c:xEt	Landroid/view/View;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +25 -> 107
    //   85: aload_1
    //   86: invokevirtual 263	android/view/View:getParent	()Landroid/view/ViewParent;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +21 -> 112
    //   94: ldc 227
    //   96: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: monitorexit
    //   101: return
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -40 -> 64
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -19 -> 90
    //   112: aload_0
    //   113: getfield 229	com/tencent/mm/plugin/finder/feed/bb$c:xEt	Landroid/view/View;
    //   116: ifnull +31 -> 147
    //   119: aload_0
    //   120: invokevirtual 280	com/tencent/mm/plugin/finder/feed/bb$c:getAdapter	()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 229	com/tencent/mm/plugin/finder/feed/bb$c:xEt	Landroid/view/View;
    //   128: astore_2
    //   129: aload_2
    //   130: ifnonnull +6 -> 136
    //   133: invokestatic 283	kotlin/g/b/p:iCn	()V
    //   136: aload_1
    //   137: aload_2
    //   138: aload_0
    //   139: getfield 195	com/tencent/mm/plugin/finder/feed/bb$c:xEu	I
    //   142: iconst_1
    //   143: invokevirtual 289	com/tencent/mm/view/recyclerview/WxRecyclerAdapter:g	(Landroid/view/View;IZ)Lcom/tencent/mm/view/recyclerview/h$b;
    //   146: pop
    //   147: ldc 227
    //   149: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: goto -53 -> 99
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	c
    //   54	83	1	localObject1	Object
    //   155	4	1	localObject2	Object
    //   39	99	2	localObject3	Object
    //   49	17	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	35	155	finally
    //   35	55	155	finally
    //   59	64	155	finally
    //   64	81	155	finally
    //   85	90	155	finally
    //   94	99	155	finally
    //   112	129	155	finally
    //   133	136	155	finally
    //   136	147	155	finally
    //   147	152	155	finally
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(242522);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    p.k(parama, "adapter");
    p.k(paramView, "view");
    int i = paramInt - ((h)parama).YSk.size();
    if (i >= 0)
    {
      parama = dsG();
      if (parama != null)
      {
        parama = parama.xnX;
        if (parama != null)
        {
          parama = Integer.valueOf(parama.getSize());
          if (i >= parama.intValue()) {
            break label1525;
          }
          parama = dsG();
          if (parama == null) {
            break label375;
          }
          parama = parama.xnX;
          if (parama == null) {
            break label375;
          }
          parama = parama.getListOfType(BaseFinderFeed.class);
          if (parama == null) {
            break label375;
          }
          localObject1 = (BaseFinderFeed)parama.get(i);
          label165:
          if (localObject1 == null) {
            break label381;
          }
          parama = ((BaseFinderFeed)localObject1).feedObject;
          label176:
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("onClick ").append(i).append(" id:");
          if (parama == null) {
            break label386;
          }
        }
      }
      label386:
      for (Object localObject2 = Long.valueOf(parama.getId());; localObject2 = null)
      {
        Log.i((String)localObject3, ((Long)localObject2).longValue() + ", pos:" + i);
        if ((parama == null) || (parama.getMediaType() != 9)) {
          break label507;
        }
        if (!Util.isEqual(parama.getUserName(), com.tencent.mm.model.z.bdh())) {
          break label392;
        }
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject2 = (Context)this.iXq;
        long l = parama.getId();
        localObject3 = parama.getObjectNonceId();
        localObject1 = parama.getLiveInfo();
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = new bac();
        }
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, l, (String)localObject3, paramView, null, null, null, null, null, parama.getFinderObject().sessionBuffer, null, null, 7152);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(242522);
        return;
        parama = null;
        break;
        label375:
        localObject1 = null;
        break label165;
        label381:
        parama = null;
        break label176;
      }
      label392:
      com.tencent.mm.plugin.finder.live.report.k.yBj.a((BaseFinderFeed)localObject1, paramInt, s.t.yGS, "26");
      parama = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      parama = paramView.getContext();
      p.j(parama, "view.context");
      parama = aj.a.fZ(parama);
      if (parama != null)
      {
        parama = parama.ekY();
        if (parama == null) {}
      }
      for (paramInt = parama.xkX;; paramInt = 0)
      {
        parama = com.tencent.mm.plugin.finder.utils.a.ACH;
        parama = (Context)this.iXq;
        paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.utils.a.a(parama, com.tencent.mm.plugin.finder.live.utils.a.a((ArrayList)dsG().xnX.getDataList(), (bu)localObject1, this.type, paramInt), null, null, null, 28);
        break;
      }
      label507:
      Object localObject3 = new Intent();
      ((Intent)localObject3).putExtra("key_topic_type", this.type);
      if (this.type == 4)
      {
        localObject1 = dsH();
        if (localObject1 == null)
        {
          parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
          AppMethodBeat.o(242522);
          throw parama;
        }
        localObject2 = ((bb.b)localObject1).bgmInfo;
        if (localObject2 != null)
        {
          if (((bkq)localObject2).musicInfo == null) {
            break label715;
          }
          localObject1 = ((bkq)localObject2).musicInfo;
          if (localObject1 != null)
          {
            localObject1 = ((bfg)localObject1).name;
            localObject1 = String.valueOf(localObject1);
            ((Intent)localObject3).putExtra("key_topic_title", (String)localObject1);
            ((Intent)localObject3).putExtra("KEY_FOLLOW_ID", ((bkq)localObject2).groupId);
          }
        }
        else
        {
          label641:
          if (parama == null) {
            break label927;
          }
        }
      }
      label927:
      for (localObject1 = Long.valueOf(parama.getId());; localObject1 = null)
      {
        ((Intent)localObject3).putExtra("KEY_CLICK_FEED_ID", ((Long)localObject1).longValue());
        ((Intent)localObject3).putExtra("KEY_CLICK_FEED_POSITION", i);
        localObject1 = dsG();
        if (localObject1 != null) {
          break label933;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
        AppMethodBeat.o(242522);
        throw parama;
        localObject1 = null;
        break;
        label715:
        localObject4 = this.iXq;
        paramInt = b.j.finder_follow_header_title;
        localObject1 = ((bkq)localObject2).contact;
        if (localObject1 != null) {}
        for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
        {
          localObject1 = ((MMActivity)localObject4).getString(paramInt, new Object[] { localObject1 });
          p.j(localObject1, "context.getString(R.stri…tle,it.contact?.nickname)");
          break;
        }
        if (this.type == 7)
        {
          localObject1 = this.fGc;
          if (localObject1 == null) {
            break label641;
          }
          localObject4 = ((bkr)localObject1).SVJ;
          if (localObject4 == null) {
            break label641;
          }
          ((Intent)localObject3).putExtra("key_activity_name", ((asg)localObject4).eventName);
          localObject1 = ((asg)localObject4).contact;
          if (localObject1 != null)
          {
            localObject2 = ((FinderContact)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          ((Intent)localObject3).putExtra("key_creator_finder_name", (String)localObject1);
          ((Intent)localObject3).putExtra("key_activity_id", ((asg)localObject4).xdR);
          ((Intent)localObject3).putExtra("key_activity_inner_tab_type", this.xEw);
          ((Intent)localObject3).putExtra("key_activity_max_top_count", ((asg)localObject4).xEZ);
          break label641;
        }
        ((Intent)localObject3).putExtra("key_topic_title", this.topic);
        break label641;
      }
      label933:
      localObject2 = (bb.b)localObject1;
      if (bb.b.d(((bb.b)localObject2).xCB)) {
        localObject1 = null;
      }
      for (;;)
      {
        localObject2 = dsG().xnX;
        if (localObject2 != null) {
          break;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(242522);
        throw parama;
        localObject1 = new dwb();
        ((dwb)localObject1).Uca = new LinkedList();
        ((dwb)localObject1).Uca.add(((bb.b)localObject2).xCB);
      }
      Object localObject4 = (FinderTopicFeedLoader)localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((dwb)localObject1).Uca;
        if (localObject2 != null)
        {
          localObject2 = (bkr)((LinkedList)localObject2).get(0);
          if (localObject2 != null)
          {
            localObject2 = ((bkr)localObject2).topic;
            localObject2 = ((FinderTopicFeedLoader)localObject4).aBI((String)localObject2);
            dsG().xnX.saveCache((Intent)localObject3, i, (c)new bd((dwb)localObject1, (com.tencent.mm.cd.b)localObject2));
            ((Intent)localObject3).putExtra("key_ref_object_id", this.iXq.getIntent().getLongExtra("key_ref_object_id", 0L));
            localObject1 = dsG();
            if (localObject1 == null) {
              break label1180;
            }
          }
        }
      }
      label1180:
      for (localObject1 = ((c.a)localObject1).xnX;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label1186;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(242522);
        throw parama;
        localObject2 = null;
        break;
      }
      label1186:
      localObject1 = ((FinderTopicFeedLoader)localObject1).xJG;
      if (localObject1 != null)
      {
        localObject1 = ((bdm)localObject1).toByteArray();
        ((Intent)localObject3).putExtra("KEY_FINDER_LOCATION", (byte[])localObject1);
        localObject1 = dsG();
        if (localObject1 == null) {
          break label1267;
        }
      }
      label1267:
      for (localObject1 = ((c.a)localObject1).xnX;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label1273;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(242522);
        throw parama;
        localObject1 = null;
        break;
      }
      label1273:
      localObject1 = ((FinderTopicFeedLoader)localObject1).xcZ;
      if (localObject1 != null)
      {
        if (localObject1 != null)
        {
          localObject1 = ((biv)localObject1).toByteArray();
          ((Intent)localObject3).putExtra("KEY_SECTION_INFO", (byte[])localObject1);
        }
      }
      else
      {
        localObject1 = dsG();
        if (localObject1 == null) {
          break label1359;
        }
      }
      label1359:
      for (localObject1 = ((c.a)localObject1).xnX;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label1365;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(242522);
        throw parama;
        localObject1 = null;
        break;
      }
      label1365:
      ((FinderTopicFeedLoader)localObject1).xJD = null;
      Log.i(this.TAG, "enterTopicTimelineUI, fixPos:".concat(String.valueOf(i)));
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = paramView.getContext();
      p.j(localObject1, "view.context");
      aj.a.a((Context)localObject1, (Intent)localObject3, 0L, 0, false, 124);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = paramView.getContext();
      p.j(localObject1, "view.context");
      com.tencent.mm.plugin.finder.utils.a.P((Context)localObject1, (Intent)localObject3);
      if (parama != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        com.tencent.mm.plugin.finder.report.n.P(parama.getId(), 2);
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramView = paramView.getContext();
        p.j(paramView, "view.context");
        paramView = aj.a.fZ(paramView);
        if (paramView != null)
        {
          paramView = paramView.ekY();
          if (paramView != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
            com.tencent.mm.plugin.finder.report.n.a(paramView, parama.getId(), this.xvJ.getRecyclerView(), this.xEw);
          }
        }
      }
    }
    label1525:
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
    AppMethodBeat.o(242522);
  }
  
  public final void aBE(String paramString)
  {
    AppMethodBeat.i(242519);
    p.k(paramString, "<set-?>");
    this.topic = paramString;
    AppMethodBeat.o(242519);
  }
  
  public final void ab(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(242520);
    p.k(paramArrayList, "data");
    if (this.xEq) {
      switch (this.type)
      {
      }
    }
    for (;;)
    {
      if (dud()) {
        this.xEr = new ad(this.iXq, this.xvJ);
      }
      super.ab(paramArrayList);
      AppMethodBeat.o(242520);
      return;
      this.xEx = new com.tencent.mm.plugin.finder.activity.view.a(this.iXq);
    }
  }
  
  public final void b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(242558);
    p.k(paramc, "reason");
    if (this.type == 7)
    {
      Object localObject2 = paramc.xJA;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof FinderTopicFeedLoader.e)) {
        localObject1 = null;
      }
      localObject1 = (FinderTopicFeedLoader.e)localObject1;
      if (localObject1 != null) {}
      for (boolean bool = ((FinderTopicFeedLoader.e)localObject1).getHasMore(); (!bool) && (paramc.YNG != 0); bool = true)
      {
        paramc = this.xvJ.getLoadMoreFooter();
        if (paramc == null) {
          break;
        }
        paramc.setVisibility(0);
        localObject1 = paramc.findViewById(b.f.load_more_footer_tip_tv);
        p.j(localObject1, "findViewById<View>(R.id.load_more_footer_tip_tv)");
        ((View)localObject1).setVisibility(8);
        paramc = paramc.findViewById(b.f.load_more_footer_end_layout);
        p.j(paramc, "findViewById<View>(R.id.…d_more_footer_end_layout)");
        paramc.setVisibility(0);
        AppMethodBeat.o(242558);
        return;
      }
    }
    AppMethodBeat.o(242558);
  }
  
  public final boolean dsJ()
  {
    return this.xEz;
  }
  
  public final boolean dsK()
  {
    return this.type != 7;
  }
  
  public final void dsL() {}
  
  public final View dua()
  {
    AppMethodBeat.i(242518);
    View localView = this.xEs;
    if (localView == null) {
      p.bGy("followTopicFloatHeader");
    }
    AppMethodBeat.o(242518);
    return localView;
  }
  
  public final void duc()
  {
    AppMethodBeat.i(242552);
    if (this.xEt != null)
    {
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      View localView = this.xEt;
      if (localView == null) {
        p.iCn();
      }
      localWxRecyclerAdapter.T(localView.hashCode(), true);
    }
    AppMethodBeat.o(242552);
  }
  
  public final boolean dud()
  {
    return this.type == 5;
  }
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(242524);
    p.k(paramContext, "context");
    paramContext = dsI().eW(paramContext);
    AppMethodBeat.o(242524);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(242542);
    p.k(paramc, "reason");
    AppMethodBeat.o(242542);
    return null;
  }
  
  public final String g(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(242545);
    p.k(paramc, "reason");
    AppMethodBeat.o(242545);
    return null;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(242532);
    View localView = this.iXq.findViewById(b.f.empty_view);
    AppMethodBeat.o(242532);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(242540);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    switch (this.type)
    {
    case 3: 
    case 6: 
    default: 
      localObject1 = this.xzF;
      AppMethodBeat.o(242540);
      return localObject1;
    case 1: 
    case 5: 
      if (this.xEr != null)
      {
        ad localad = this.xEr;
        if (localad == null) {
          p.iCn();
        }
        Log.i("Finder.FinderNewsTopicHelper", "getTopicHeaderView : " + null);
        localObject2 = com.tencent.mm.ui.ad.kS((Context)localad.iXq).inflate(b.g.finder_topic_news_layout, null, false);
        localObject3 = localad.iXq.getIntent().getStringExtra("key_topic_title");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = (TextView)((View)localObject2).findViewById(b.f.topic_news_title);
        if (localObject3 != null)
        {
          if (!kotlin.n.n.M((String)localObject1, "#", false))
          {
            ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((TextView)localObject3).getContext(), (CharSequence)"#".concat(String.valueOf(localObject1))));
            label206:
            ar.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
          }
        }
        else
        {
          localObject1 = (TextView)((View)localObject2).findViewById(b.f.feed_item_news_tag_text);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localad.a(null);
          p.j(localObject2, "header");
          localObject1 = localObject2;
        }
      }
      break;
    }
    for (;;)
    {
      this.xzF = ((View)localObject1);
      break;
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((TextView)localObject3).getContext(), (CharSequence)localObject1));
      break label206;
      this.xzF = View.inflate((Context)this.iXq, b.g.finder_topic_feed_header, null);
      localObject1 = this.xzF;
      if (localObject1 == null) {
        break;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.topic_tv);
      if (localObject1 == null) {
        break;
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this.iXq, (CharSequence)this.topic));
      break;
      localObject1 = View.inflate((Context)this.iXq, b.g.finder_topic_feed_header, null);
      localObject2 = ((View)localObject1).findViewById(b.f.topic_tv);
      p.j(localObject2, "findViewById<TextView>(R.id.topic_tv)");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((View)localObject1).getContext(), (CharSequence)this.topic));
      ((ImageView)((View)localObject1).findViewById(b.f.topic_icon_left)).setImageResource(b.i.icons_outlined_location);
      continue;
      this.xzF = ((View)new FinderFollowTopicHeaderView((Context)this.iXq));
      localObject1 = com.tencent.mm.ui.ad.kS((Context)this.iXq).inflate(b.g.finder_follow_topic_header_on_scroll_layout, null);
      p.j(localObject1, "MMLayoutInflater.getInfl…er_on_scroll_layout,null)");
      this.xEs = ((View)localObject1);
      localObject1 = this.xEs;
      if (localObject1 == null) {
        p.bGy("followTopicFloatHeader");
      }
      ((View)localObject1).setAlpha(0.0F);
      localObject1 = this.xEs;
      if (localObject1 == null) {
        p.bGy("followTopicFloatHeader");
      }
      ((View)localObject1).setVisibility(4);
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.eei() == 1)
      {
        localObject1 = this.xEs;
        if (localObject1 == null) {
          p.bGy("followTopicFloatHeader");
        }
        localObject1 = ((View)localObject1).findViewById(b.f.follow_btn_float);
        p.j(localObject1, "followTopicFloatHeader.f…w>(R.id.follow_btn_float)");
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        localObject1 = new FrameLayout.LayoutParams(-1, this.iXq.getResources().getDimensionPixelSize(b.d.Edge_6A));
        ((FrameLayout.LayoutParams)localObject1).gravity = 48;
        ((FrameLayout.LayoutParams)localObject1).setMargins(0, ax.at((Context)this.iXq), 0, 0);
        localObject2 = this.iXq.getWindow();
        p.j(localObject2, "context.window");
        localObject2 = ((Window)localObject2).getDecorView();
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(242540);
        throw ((Throwable)localObject1);
        localObject1 = this.xEs;
        if (localObject1 == null) {
          p.bGy("followTopicFloatHeader");
        }
        ((View)localObject1).findViewById(b.f.follow_btn_float).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject2 = (FrameLayout)localObject2;
      localObject3 = this.xEs;
      if (localObject3 == null) {
        p.bGy("followTopicFloatHeader");
      }
      ((FrameLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      break;
      localObject2 = this.xEx;
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.ui.ad.kS((Context)((com.tencent.mm.plugin.finder.activity.view.a)localObject2).iXq).inflate(b.g.finder_activity_profile_header, null, false);
        ((com.tencent.mm.plugin.finder.activity.view.a)localObject2).ep((View)localObject1);
        p.j(localObject1, "headerView");
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(242527);
    RecyclerView.h localh = dsI().getItemDecoration();
    AppMethodBeat.o(242527);
    return localh;
  }
  
  public final boolean n(i parami)
  {
    AppMethodBeat.i(242521);
    p.k(parami, "holder");
    if (parami.mg() != this.xEu)
    {
      if (parami.getTag() != null)
      {
        parami = parami.getTag();
        bg.a locala = bg.xnt;
        if (!p.h(parami, Integer.valueOf(bg.dpG()))) {}
      }
    }
    else
    {
      AppMethodBeat.o(242521);
      return true;
    }
    AppMethodBeat.o(242521);
    return false;
  }
  
  /* Error */
  public final void ov(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1077
    //   5: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 193	com/tencent/mm/plugin/finder/feed/bb$c:TAG	Ljava/lang/String;
    //   12: ldc_w 1079
    //   15: iload_1
    //   16: invokestatic 1082	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   19: invokevirtual 711	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 276	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iload_1
    //   26: ifeq +16 -> 42
    //   29: aload_0
    //   30: invokespecial 1084	com/tencent/mm/plugin/finder/feed/bb$c:dub	()V
    //   33: ldc_w 1077
    //   36: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: invokevirtual 1086	com/tencent/mm/plugin/finder/feed/bb$c:duc	()V
    //   46: ldc_w 1077
    //   49: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -13 -> 39
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	c
    //   0	60	1	paramBoolean	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	55	finally
    //   29	39	55	finally
    //   42	52	55	finally
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(bb.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237970);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$getHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.xEA.xzF;
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView");
        AppMethodBeat.o(237970);
        throw paramView;
      }
      ((FinderFollowTopicHeaderView)paramView).dLa();
      paramView = com.tencent.mm.plugin.finder.report.k.zWs;
      com.tencent.mm.plugin.finder.report.k.R(false, 6);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$getHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237970);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$1$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$2"})
  static final class b
    implements View.OnClickListener
  {
    b(bdm parambdm, byte[] paramArrayOfByte, View paramView, bb.c paramc, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(270312);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      paramView = this.xED.getContext();
      p.j(paramView, "context");
      com.tencent.mm.plugin.finder.utils.aj.a(paramView, this.xEB);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(270312);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$1$2"})
  static final class c
    implements Runnable
  {
    c(View paramView, bb.c paramc, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(269095);
      Object localObject1 = this.xEA.dsH();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
        AppMethodBeat.o(269095);
        throw ((Throwable)localObject1);
      }
      bkq localbkq = ((bb.b)localObject1).bgmInfo;
      if (localbkq != null)
      {
        Object localObject3;
        if (localbkq.musicInfo == null)
        {
          localObject2 = ((Iterable)this.xEA.dsH().xnX.getDataList()).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (bu)localObject1;
            if (localObject3 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
              AppMethodBeat.o(269095);
              throw ((Throwable)localObject1);
            }
            if (p.h(d.Fw(((BaseFinderFeed)localObject3).feedObject.getFeedObject().id), localbkq.groupId))
            {
              localObject1 = (bu)localObject1;
              label158:
              if (localObject1 != null) {
                break label226;
              }
            }
          }
        }
        label226:
        for (Object localObject2 = null;; localObject2 = ((BaseFinderFeed)localObject1).feedObject)
        {
          localObject1 = this.xEA.xzF;
          if (localObject1 != null) {
            break label238;
          }
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView");
          AppMethodBeat.o(269095);
          throw ((Throwable)localObject1);
          localObject1 = null;
          break;
          localObject1 = (bu)kotlin.a.j.M((List)this.xEA.dsH().xnX.getDataList(), 0);
          break label158;
        }
        label238:
        FinderFollowTopicHeaderView localFinderFollowTopicHeaderView = (FinderFollowTopicHeaderView)localObject1;
        localObject1 = this.xEA.dsH();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
          AppMethodBeat.o(269095);
          throw ((Throwable)localObject1);
        }
        int i = ((bb.b)localObject1).xEb;
        localObject1 = this.xEA.dsH();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
          AppMethodBeat.o(269095);
          throw ((Throwable)localObject1);
        }
        int j = ((bb.b)localObject1).cUP;
        localFinderFollowTopicHeaderView.zBz = ((FinderItem)localObject2);
        localFinderFollowTopicHeaderView.zBA = localbkq;
        localFinderFollowTopicHeaderView.fEH = i;
        if (localbkq != null)
        {
          localObject1 = localbkq.musicInfo;
          if (localObject1 == null) {
            break label982;
          }
          localFinderFollowTopicHeaderView.type = 2;
          localObject1 = localbkq.musicInfo;
          if (localObject1 == null) {
            break label655;
          }
          localObject1 = ((bfg)localObject1).artist;
          if ((localObject1 == null) || (kotlin.n.n.a((CharSequence)localObject1, (CharSequence)" · ", false) != true)) {
            break label655;
          }
          localObject1 = localbkq.musicInfo;
          if (localObject1 == null) {
            break label650;
          }
          localObject1 = ((bfg)localObject1).artist;
          if (localObject1 == null) {
            break label650;
          }
          localObject1 = kotlin.n.n.a((CharSequence)localObject1, new String[] { " · " });
          if (localObject1 == null) {
            break label650;
          }
          localObject1 = (String)((List)localObject1).get(0);
          label446:
          localObject3 = (TextView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_artist_name);
          p.j(localObject3, "finder_artist_name");
          ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
          localObject3 = (TextView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_name);
          p.j(localObject3, "finder_music_name");
          localObject1 = localbkq.musicInfo;
          if (localObject1 == null) {
            break label678;
          }
          localObject1 = ((bfg)localObject1).name;
          label513:
          ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
          if (!FinderFollowTopicHeaderView.Oi(j)) {
            break label683;
          }
          ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(localFinderFollowTopicHeaderView.zBL);
          ((LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.follow_btn)).setOnClickListener(localFinderFollowTopicHeaderView.zBL);
          label570:
          if (localbkq == null) {
            break label2069;
          }
          localObject1 = localbkq.musicInfo;
          label581:
          if (localObject1 == null) {
            break label2079;
          }
          localObject1 = this.xEA.dua().findViewById(b.f.finder_topic_header_text);
          p.j(localObject1, "followTopicFloatHeader.f…finder_topic_header_text)");
          localObject2 = (TextView)localObject1;
          localObject1 = localbkq.musicInfo;
          if (localObject1 == null) {
            break label2074;
          }
        }
        label650:
        label655:
        label785:
        label2069:
        label2074:
        for (localObject1 = ((bfg)localObject1).name;; localObject1 = null)
        {
          ((TextView)localObject2).setText((CharSequence)String.valueOf(localObject1));
          AppMethodBeat.o(269095);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label446;
          localObject1 = localbkq.musicInfo;
          if (localObject1 != null)
          {
            localObject1 = ((bfg)localObject1).artist;
            break label446;
          }
          localObject1 = null;
          break label446;
          label678:
          localObject1 = null;
          break label513;
          label683:
          localFinderFollowTopicHeaderView.zBE = ((FinderImgFeedMusicTag)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn));
          localObject3 = localFinderFollowTopicHeaderView.zBE;
          label722:
          Object localObject4;
          if (localObject3 != null)
          {
            if (localbkq != null)
            {
              localObject1 = localbkq.musicInfo;
              ((FinderImgFeedMusicTag)localObject3).a((bfg)localObject1);
            }
          }
          else
          {
            ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(localFinderFollowTopicHeaderView.zBJ);
            localObject4 = new AudioCacheInfo();
            ((AudioCacheInfo)localObject4).HLC = ((int)System.currentTimeMillis());
            if (localbkq == null) {
              break label972;
            }
            localObject1 = localbkq.musicInfo;
            if (localObject1 == null) {
              break label972;
            }
            localObject1 = ((bfg)localObject1).SPV;
            ((AudioCacheInfo)localObject4).musicUrl = ((String)localObject1);
            localObject1 = av.AJz;
            if (localbkq == null) {
              break label977;
            }
            localObject1 = localbkq.musicInfo;
            label806:
            if (localObject1 == null) {
              p.iCn();
            }
            p.j(localObject1, "bgmInfo?.musicInfo!!");
            ((AudioCacheInfo)localObject4).cachePath = av.b((bfg)localObject1);
            localObject3 = ((AudioCacheInfo)localObject4).cachePath;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            localFinderFollowTopicHeaderView.filePath = ((String)localObject1);
            localFinderFollowTopicHeaderView.zBD = ((AudioCacheInfo)localObject4);
            localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.k.HMx;
            localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.k.fwB();
            localObject3 = localFinderFollowTopicHeaderView.getContext();
            p.j(localObject3, "context");
            localObject4 = localFinderFollowTopicHeaderView.zBD;
            if (localObject4 == null) {
              p.iCn();
            }
            ((com.tencent.mm.plugin.recordvideo.model.audio.k)localObject1).a((Context)localObject3, (AudioCacheInfo)localObject4, (m)new FinderFollowTopicHeaderView.d(localFinderFollowTopicHeaderView));
          }
          for (;;)
          {
            localObject1 = (FinderImgFeedMusicTag)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn);
            p.j(localObject1, "view");
            localObject3 = ((FinderImgFeedMusicTag)localObject1).getParent();
            if (localObject3 != null) {
              break label1882;
            }
            localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(269095);
            throw ((Throwable)localObject1);
            localObject1 = null;
            break label722;
            label972:
            localObject1 = null;
            break label785;
            label977:
            localObject1 = null;
            break label806;
            label982:
            localFinderFollowTopicHeaderView.type = 1;
            if ((localbkq != null) && (localbkq.contact != null))
            {
              localObject3 = (TextView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_artist_name);
              p.j(localObject3, "finder_artist_name");
              localObject1 = localbkq.contact;
              if (localObject1 == null) {
                break label1194;
              }
              localObject1 = ((FinderContact)localObject1).nickname;
              ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
              localObject3 = (TextView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_name);
              p.j(localObject3, "finder_music_name");
              localObject4 = localFinderFollowTopicHeaderView.getContext();
              i = b.j.finder_follow_header_title;
              localObject1 = localbkq.contact;
              if (localObject1 == null) {
                break label1199;
              }
            }
            label1194:
            label1199:
            for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
            {
              ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getString(i, new Object[] { localObject1 }));
              localFinderFollowTopicHeaderView.findViewById(b.f.finder_artist_name).setOnClickListener((View.OnClickListener)new FinderFollowTopicHeaderView.b(localFinderFollowTopicHeaderView, localbkq));
              localObject1 = (WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_follow_arrow);
              p.j(localObject1, "finder_follow_arrow");
              ((WeImageView)localObject1).setVisibility(0);
              if (!FinderFollowTopicHeaderView.Oi(j)) {
                break label1204;
              }
              ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(localFinderFollowTopicHeaderView.zBL);
              break;
              localObject1 = null;
              break label1036;
            }
            label1204:
            if (localbkq != null)
            {
              localObject1 = localbkq.audioTrackUrl;
              label1215:
              localObject1 = (CharSequence)localObject1;
              if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                break label1374;
              }
              i = 1;
            }
            for (;;)
            {
              if (i != 0)
              {
                localFinderFollowTopicHeaderView.zBE = ((FinderImgFeedMusicTag)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn));
                ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(localFinderFollowTopicHeaderView.zBH);
                localFinderFollowTopicHeaderView.zBH = localFinderFollowTopicHeaderView.zBH;
                if (localObject2 == null)
                {
                  localObject1 = (LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.follow_btn);
                  p.j(localObject1, "follow_btn");
                  ((LinearLayout)localObject1).setVisibility(8);
                  localObject1 = (WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn_ui);
                  p.j(localObject1, "finder_music_play_btn_ui");
                  ((WeImageView)localObject1).setAlpha(0.5F);
                  ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener((View.OnClickListener)new FinderFollowTopicHeaderView.e(localFinderFollowTopicHeaderView));
                  break;
                  localObject1 = null;
                  break label1215;
                  label1374:
                  i = 0;
                  continue;
                }
                localObject4 = localFinderFollowTopicHeaderView.zBy;
                if (localObject4 == null) {
                  break;
                }
                localObject1 = ((FinderItem)localObject2).getMediaList().get(0);
                p.j(localObject1, "feed.mediaList[0]");
                localFinderFollowTopicHeaderView.zBB = new aa((csg)localObject1, u.AlK, 0, null, 12);
                localObject1 = localFinderFollowTopicHeaderView.zBB;
                if (localObject1 == null) {
                  p.iCn();
                }
                localFinderFollowTopicHeaderView.filePath = ((aa)localObject1).getPath();
                localObject1 = localFinderFollowTopicHeaderView.zBB;
                if (localObject1 != null)
                {
                  localObject3 = ((aa)localObject1).getPath();
                  localObject1 = localObject3;
                  if (localObject3 != null) {}
                }
                else
                {
                  localObject1 = "";
                }
                localFinderFollowTopicHeaderView.foE = FinderFollowTopicHeaderView.aDw((String)localObject1);
                if (localFinderFollowTopicHeaderView.foE)
                {
                  localObject1 = localFinderFollowTopicHeaderView.zBB;
                  if (localObject1 == null) {
                    p.iCn();
                  }
                  localFinderFollowTopicHeaderView.a((ac)localObject1);
                }
                Log.i("FinderFollowTopicHeaderView", "file downloadFinish = " + localFinderFollowTopicHeaderView.foE);
                localObject1 = localFinderFollowTopicHeaderView.zBB;
                if (localObject1 == null) {
                  p.iCn();
                }
                localObject1 = (ac)localObject1;
                localObject3 = FeedData.Companion;
                ((FinderVideoViewForTopic)localObject4).b((ac)localObject1, false, FeedData.a.j((FinderItem)localObject2));
                ((FinderVideoViewForTopic)localObject4).setScaleType(i.e.RcH);
                localObject1 = new com.tencent.mm.plugin.finder.loader.z();
                localObject3 = localFinderFollowTopicHeaderView.zBB;
                if (localObject3 == null) {
                  p.iCn();
                }
                ((FinderVideoViewForTopic)localObject4).setIOnlineVideoProxy(((com.tencent.mm.plugin.finder.loader.z)localObject1).a((aa)localObject3, (y)localFinderFollowTopicHeaderView));
                ((FinderVideoViewForTopic)localObject4).setIsShowBasicControls(false);
                ((FinderVideoViewForTopic)localObject4).setLoop(true);
                ((FinderVideoViewForTopic)localObject4).setMute(true);
                ((FinderVideoViewForTopic)localObject4).egV();
                break;
              }
            }
            if (localbkq != null)
            {
              localFinderFollowTopicHeaderView.zBE = ((FinderImgFeedMusicTag)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn));
              localObject1 = new bfg();
              ((bfg)localObject1).SPV = localbkq.audioTrackUrl;
              ((bfg)localObject1).name = "fake music info";
              ((bfg)localObject1).BHW = String.valueOf(System.currentTimeMillis());
              localObject3 = localFinderFollowTopicHeaderView.zBE;
              if (localObject3 != null) {
                ((FinderImgFeedMusicTag)localObject3).a((bfg)localObject1);
              }
              ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(localFinderFollowTopicHeaderView.zBJ);
              localObject4 = new AudioCacheInfo();
              ((AudioCacheInfo)localObject4).HLC = ((int)System.currentTimeMillis());
              ((AudioCacheInfo)localObject4).musicUrl = ((bfg)localObject1).SPV;
              localObject3 = av.AJz;
              ((AudioCacheInfo)localObject4).cachePath = av.b((bfg)localObject1);
              localObject3 = ((AudioCacheInfo)localObject4).cachePath;
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = "";
              }
              localFinderFollowTopicHeaderView.filePath = ((String)localObject1);
              localFinderFollowTopicHeaderView.zBD = ((AudioCacheInfo)localObject4);
              localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.k.HMx;
              localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.k.fwB();
              localObject3 = localFinderFollowTopicHeaderView.getContext();
              p.j(localObject3, "context");
              localObject4 = localFinderFollowTopicHeaderView.zBD;
              if (localObject4 == null) {
                p.iCn();
              }
              ((com.tencent.mm.plugin.recordvideo.model.audio.k)localObject1).a((Context)localObject3, (AudioCacheInfo)localObject4, (m)new FinderFollowTopicHeaderView.c(localFinderFollowTopicHeaderView));
            }
          }
          label1882:
          ((ViewGroup)localObject3).removeView((View)localObject1);
          localObject3 = AndroidContextUtil.castActivityOrNull(localFinderFollowTopicHeaderView.getContext());
          if (localObject3 != null)
          {
            localObject3 = ((Activity)localObject3).getWindow();
            p.j(localObject3, "it.window");
            localObject3 = ((Window)localObject3).getDecorView();
            if (localObject3 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
              AppMethodBeat.o(269095);
              throw ((Throwable)localObject1);
            }
            ((FrameLayout)localObject3).addView((View)localObject1);
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.eei() == 1)
          {
            localObject1 = (LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.follow_btn);
            p.j(localObject1, "follow_btn");
            ((LinearLayout)localObject1).setVisibility(8);
            break label570;
          }
          localObject1 = com.tencent.mm.plugin.finder.report.k.zWs;
          com.tencent.mm.plugin.finder.report.k.R(true, 6);
          localObject1 = (LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.follow_btn);
          p.j(localObject1, "follow_btn");
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(b.f.follow_btn)).setOnClickListener((View.OnClickListener)new FinderFollowTopicHeaderView.f(localFinderFollowTopicHeaderView, j));
          break label570;
          localObject1 = null;
          break label581;
        }
        label1036:
        label2079:
        if (localbkq != null)
        {
          localObject1 = localbkq.contact;
          if (localObject1 == null) {
            break label2187;
          }
          localObject1 = this.xEA.dua().findViewById(b.f.finder_topic_header_text);
          p.j(localObject1, "followTopicFloatHeader.f…finder_topic_header_text)");
          localObject2 = (TextView)localObject1;
          localObject3 = this.xkv.getContext();
          i = b.j.finder_follow_header_title;
          localObject1 = localbkq.contact;
          if (localObject1 == null) {
            break label2182;
          }
        }
        label2182:
        for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
        {
          ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(i, new Object[] { localObject1 }));
          AppMethodBeat.o(269095);
          return;
          localObject1 = null;
          break;
        }
        label2187:
        if (localObject2 != null)
        {
          localObject1 = this.xEA.dua().findViewById(b.f.finder_topic_header_text);
          p.j(localObject1, "followTopicFloatHeader.f…finder_topic_header_text)");
          ((TextView)localObject1).setText((CharSequence)this.xkv.getContext().getString(b.j.finder_follow_header_title, new Object[] { ((FinderItem)localObject2).getFinderObject().nickname }));
        }
        AppMethodBeat.o(269095);
        return;
      }
      AppMethodBeat.o(269095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bb.c
 * JD-Core Version:    0.7.0.1
 */