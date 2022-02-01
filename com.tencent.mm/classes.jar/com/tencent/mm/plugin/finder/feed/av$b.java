package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.be;
import com.tencent.mm.plugin.finder.convert.be.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.b;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.c;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.d;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.e;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView.f;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPR_LOADING_HEADER", "activityHeaderManager", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "getActivityHeaderManager", "()Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "setActivityHeaderManager", "(Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;)V", "followId", "getFollowId", "()Ljava/lang/String;", "setFollowId", "(Ljava/lang/String;)V", "followTopicFloatHeader", "Landroid/view/View;", "getFollowTopicFloatHeader", "()Landroid/view/View;", "setFollowTopicFloatHeader", "(Landroid/view/View;)V", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "innerTabType", "getInnerTabType", "()I", "setInnerTabType", "(I)V", "loadingHeader", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "needRefreshWhenEnter", "getNeedRefreshWhenEnter", "()Z", "setNeedRefreshWhenEnter", "(Z)V", "topic", "getTopic", "setTopic", "topicHeader", "topicHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "topicId", "", "getTopicId", "()J", "setTopicId", "(J)V", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "topicNonceId", "getTopicNonceId", "setTopicNonceId", "type", "getType", "setType", "addLoadingHeader", "", "addTagsHeader", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "dimissLoadingHeader", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isHeaderWithFollow", "onDetach", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "otherFullSpan", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "refreshHeader", "subTitle", "refreshHeaderContent", "count", "errCode", "errMsg", "refreshWhenEnter", "showHeaderOnDataEmpty", "showProgressHeader", "ifShow", "plugin-finder_release"})
public final class av$b
  extends c.b
{
  final String TAG;
  bds dMU;
  public String dST;
  azk musicInfo;
  View tOT;
  com.tencent.mm.plugin.finder.model.j tRK;
  y tTC;
  public View tTD;
  private View tTE;
  private final int tTF;
  public String tTG;
  public int tTH;
  com.tencent.mm.plugin.finder.activity.view.a tTI;
  public boolean tTJ;
  public long twp;
  public String twq;
  public int type;
  
  private av$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, 2, paramInt, false);
    AppMethodBeat.i(244486);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedViewCallback";
    this.tTF = -2;
    this.dST = "";
    this.tTG = "";
    this.twq = "";
    this.tTH = 1;
    this.tRK = new com.tencent.mm.plugin.finder.model.j(new dmk());
    this.tTJ = true;
    AppMethodBeat.o(244486);
  }
  
  /* Error */
  private void ddt()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 216
    //   4: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 218	com/tencent/mm/plugin/finder/feed/av$b:tTE	Landroid/view/View;
    //   11: ifnonnull +23 -> 34
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 221	com/tencent/mm/plugin/finder/feed/c$b:gte	Lcom/tencent/mm/ui/MMActivity;
    //   19: checkcast 223	android/content/Context
    //   22: invokestatic 229	com/tencent/mm/ui/aa:jQ	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   25: ldc 230
    //   27: aconst_null
    //   28: invokevirtual 236	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   31: putfield 218	com/tencent/mm/plugin/finder/feed/av$b:tTE	Landroid/view/View;
    //   34: aload_0
    //   35: getfield 182	com/tencent/mm/plugin/finder/feed/av$b:TAG	Ljava/lang/String;
    //   38: astore_2
    //   39: new 238	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 240
    //   45: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_0
    //   50: getfield 218	com/tencent/mm/plugin/finder/feed/av$b:tTE	Landroid/view/View;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +46 -> 101
    //   58: aload_1
    //   59: invokevirtual 248	android/view/View:getParent	()Landroid/view/ViewParent;
    //   62: astore_1
    //   63: aload_2
    //   64: aload_3
    //   65: aload_1
    //   66: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 261	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 218	com/tencent/mm/plugin/finder/feed/av$b:tTE	Landroid/view/View;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +25 -> 106
    //   84: aload_1
    //   85: invokevirtual 248	android/view/View:getParent	()Landroid/view/ViewParent;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +21 -> 111
    //   93: ldc 216
    //   95: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: aconst_null
    //   102: astore_1
    //   103: goto -40 -> 63
    //   106: aconst_null
    //   107: astore_1
    //   108: goto -19 -> 89
    //   111: aload_0
    //   112: getfield 218	com/tencent/mm/plugin/finder/feed/av$b:tTE	Landroid/view/View;
    //   115: ifnull +31 -> 146
    //   118: aload_0
    //   119: invokevirtual 265	com/tencent/mm/plugin/finder/feed/av$b:getAdapter	()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 218	com/tencent/mm/plugin/finder/feed/av$b:tTE	Landroid/view/View;
    //   127: astore_2
    //   128: aload_2
    //   129: ifnonnull +6 -> 135
    //   132: invokestatic 268	kotlin/g/b/p:hyc	()V
    //   135: aload_1
    //   136: aload_2
    //   137: aload_0
    //   138: getfield 184	com/tencent/mm/plugin/finder/feed/av$b:tTF	I
    //   141: iconst_1
    //   142: invokevirtual 274	com/tencent/mm/view/recyclerview/WxRecyclerAdapter:f	(Landroid/view/View;IZ)Lcom/tencent/mm/view/recyclerview/g$b;
    //   145: pop
    //   146: ldc 216
    //   148: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: goto -53 -> 98
    //   154: astore_1
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	b
    //   53	83	1	localObject1	Object
    //   154	4	1	localObject2	Object
    //   38	99	2	localObject3	Object
    //   48	17	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	34	154	finally
    //   34	54	154	finally
    //   58	63	154	finally
    //   63	80	154	finally
    //   84	89	154	finally
    //   93	98	154	finally
    //   111	128	154	finally
    //   132	135	154	finally
    //   135	146	154	finally
    //   146	151	154	finally
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(244476);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    p.h(parama, "adapter");
    p.h(paramView, "view");
    int i = paramInt - ((g)parama).RqM.size();
    if (i >= 0)
    {
      parama = dcq();
      if (parama != null)
      {
        parama = parama.tFM;
        if (parama != null)
        {
          parama = Integer.valueOf(parama.getSize());
          if (i >= parama.intValue()) {
            break label1518;
          }
          parama = dcq();
          if (parama == null) {
            break label375;
          }
          parama = parama.tFM;
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
          break label506;
        }
        if (!Util.isEqual(parama.getUserName(), z.aUg())) {
          break label392;
        }
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject2 = (Context)this.gte;
        long l = parama.getId();
        localObject3 = parama.getObjectNonceId();
        localObject1 = parama.getLiveInfo();
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = new awe();
        }
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, l, (String)localObject3, paramView, false, null, null, null, null, null, parama.getFinderObject().sessionBuffer, null, 6128);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(244476);
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
      com.tencent.mm.plugin.finder.report.live.k.vkd.a((BaseFinderFeed)localObject1, paramInt, s.p.voF, "26");
      parama = FinderReporterUIC.wzC;
      parama = paramView.getContext();
      p.g(parama, "view.context");
      parama = FinderReporterUIC.a.fH(parama);
      if (parama != null)
      {
        parama = parama.dIx();
        if (parama == null) {}
      }
      for (paramInt = parama.tCE;; paramInt = 0)
      {
        parama = com.tencent.mm.plugin.finder.utils.a.vUU;
        parama = (Context)this.gte;
        paramView = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.a.a(parama, com.tencent.mm.plugin.finder.utils.m.a((ArrayList)dcq().tFM.getDataList(), (bo)localObject1, this.type, paramInt), null, null, null, 28);
        break;
      }
      label506:
      Object localObject3 = new Intent();
      ((Intent)localObject3).putExtra("key_topic_type", this.type);
      if (this.type == 4)
      {
        localObject1 = dcr();
        if (localObject1 == null)
        {
          parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
          AppMethodBeat.o(244476);
          throw parama;
        }
        localObject2 = ((av.a)localObject1).bgmInfo;
        if (localObject2 != null)
        {
          if (((bdr)localObject2).musicInfo == null) {
            break label714;
          }
          localObject1 = ((bdr)localObject2).musicInfo;
          if (localObject1 != null)
          {
            localObject1 = ((azk)localObject1).name;
            localObject1 = String.valueOf(localObject1);
            ((Intent)localObject3).putExtra("key_topic_title", (String)localObject1);
            ((Intent)localObject3).putExtra("KEY_FOLLOW_ID", ((bdr)localObject2).groupId);
          }
        }
        else
        {
          label640:
          if (parama == null) {
            break label924;
          }
        }
      }
      label924:
      for (localObject1 = Long.valueOf(parama.getId());; localObject1 = null)
      {
        ((Intent)localObject3).putExtra("KEY_CLICK_FEED_ID", ((Long)localObject1).longValue());
        ((Intent)localObject3).putExtra("KEY_CLICK_FEED_POSITION", i);
        localObject1 = dcq();
        if (localObject1 != null) {
          break label930;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
        AppMethodBeat.o(244476);
        throw parama;
        localObject1 = null;
        break;
        label714:
        localObject4 = this.gte;
        localObject1 = ((bdr)localObject2).contact;
        if (localObject1 != null) {}
        for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
        {
          localObject1 = ((MMActivity)localObject4).getString(2131759788, new Object[] { localObject1 });
          p.g(localObject1, "context.getString(R.stri…tle,it.contact?.nickname)");
          break;
        }
        if (this.type == 7)
        {
          localObject1 = this.dMU;
          if (localObject1 == null) {
            break label640;
          }
          localObject4 = ((bds)localObject1).LNz;
          if (localObject4 == null) {
            break label640;
          }
          ((Intent)localObject3).putExtra("key_activity_name", ((aqk)localObject4).eventName);
          localObject1 = ((aqk)localObject4).contact;
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
          ((Intent)localObject3).putExtra("key_activity_id", ((aqk)localObject4).twd);
          ((Intent)localObject3).putExtra("key_activity_inner_tab_type", this.tTH);
          ((Intent)localObject3).putExtra("key_activity_max_top_count", ((aqk)localObject4).tUe);
          break label640;
        }
        ((Intent)localObject3).putExtra("key_topic_title", this.dST);
        break label640;
      }
      label930:
      localObject2 = (av.a)localObject1;
      if (av.a.d(((av.a)localObject2).tRJ)) {
        localObject1 = null;
      }
      for (;;)
      {
        localObject2 = dcq().tFM;
        if (localObject2 != null) {
          break;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(244476);
        throw parama;
        localObject1 = new dmk();
        ((dmk)localObject1).MPW = new LinkedList();
        ((dmk)localObject1).MPW.add(((av.a)localObject2).tRJ);
      }
      Object localObject4 = (FinderTopicFeedLoader)localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((dmk)localObject1).MPW;
        if (localObject2 != null)
        {
          localObject2 = (bds)((LinkedList)localObject2).get(0);
          if (localObject2 != null)
          {
            localObject2 = ((bds)localObject2).dST;
            localObject2 = ((FinderTopicFeedLoader)localObject4).atr((String)localObject2);
            dcq().tFM.saveCache((Intent)localObject3, i, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.c((dmk)localObject1, (com.tencent.mm.bw.b)localObject2));
            ((Intent)localObject3).putExtra("key_ref_object_id", this.gte.getIntent().getLongExtra("key_ref_object_id", 0L));
            localObject1 = dcq();
            if (localObject1 == null) {
              break label1177;
            }
          }
        }
      }
      label1177:
      for (localObject1 = ((c.a)localObject1).tFM;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label1183;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(244476);
        throw parama;
        localObject2 = null;
        break;
      }
      label1183:
      localObject1 = ((FinderTopicFeedLoader)localObject1).tXM;
      if (localObject1 != null)
      {
        localObject1 = ((axt)localObject1).toByteArray();
        ((Intent)localObject3).putExtra("KEY_FINDER_LOCATION", (byte[])localObject1);
        localObject1 = dcq();
        if (localObject1 == null) {
          break label1264;
        }
      }
      label1264:
      for (localObject1 = ((c.a)localObject1).tFM;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label1270;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(244476);
        throw parama;
        localObject1 = null;
        break;
      }
      label1270:
      localObject1 = ((FinderTopicFeedLoader)localObject1).tvs;
      if (localObject1 != null)
      {
        if (localObject1 != null)
        {
          localObject1 = ((bcc)localObject1).toByteArray();
          ((Intent)localObject3).putExtra("KEY_SECTION_INFO", (byte[])localObject1);
        }
      }
      else
      {
        localObject1 = dcq();
        if (localObject1 == null) {
          break label1356;
        }
      }
      label1356:
      for (localObject1 = ((c.a)localObject1).tFM;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label1362;
        }
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(244476);
        throw parama;
        localObject1 = null;
        break;
      }
      label1362:
      ((FinderTopicFeedLoader)localObject1).tXJ = null;
      Log.i(this.TAG, "enterTopicTimelineUI, fixPos:".concat(String.valueOf(i)));
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = paramView.getContext();
      p.g(localObject1, "view.context");
      FinderReporterUIC.a.a((Context)localObject1, (Intent)localObject3, 0L, 0, false, 124);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject1 = paramView.getContext();
      p.g(localObject1, "view.context");
      com.tencent.mm.plugin.finder.utils.a.P((Context)localObject1, (Intent)localObject3);
      if (parama != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.J(parama.getId(), 2);
        localObject1 = FinderReporterUIC.wzC;
        paramView = paramView.getContext();
        p.g(paramView, "view.context");
        paramView = FinderReporterUIC.a.fH(paramView);
        if (paramView != null)
        {
          paramView = paramView.dIx();
          if (paramView != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(paramView, parama.getId(), this.tLS.getRecyclerView());
          }
        }
      }
    }
    label1518:
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
    AppMethodBeat.o(244476);
  }
  
  public final void ab(ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(244474);
    p.h(paramArrayList, "data");
    switch (this.type)
    {
    }
    for (;;)
    {
      if (ddv()) {
        this.tTC = new y(this.gte, this.tLS);
      }
      super.ab(paramArrayList);
      AppMethodBeat.o(244474);
      return;
      this.tTI = new com.tencent.mm.plugin.finder.activity.view.a(this.gte);
    }
  }
  
  public final void atn(String paramString)
  {
    AppMethodBeat.i(244473);
    p.h(paramString, "<set-?>");
    this.dST = paramString;
    AppMethodBeat.o(244473);
  }
  
  public final String b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244481);
    p.h(paramc, "reason");
    AppMethodBeat.o(244481);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244482);
    p.h(paramc, "reason");
    AppMethodBeat.o(244482);
    return null;
  }
  
  public final boolean dct()
  {
    return this.tTJ;
  }
  
  public final boolean dcu()
  {
    return true;
  }
  
  public final void dcv() {}
  
  public final View dds()
  {
    AppMethodBeat.i(244472);
    View localView = this.tTD;
    if (localView == null) {
      p.btv("followTopicFloatHeader");
    }
    AppMethodBeat.o(244472);
    return localView;
  }
  
  public final void ddu()
  {
    AppMethodBeat.i(244485);
    if (this.tTE != null)
    {
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      View localView = this.tTE;
      if (localView == null) {
        p.hyc();
      }
      localWxRecyclerAdapter.T(localView.hashCode(), true);
    }
    AppMethodBeat.o(244485);
  }
  
  public final boolean ddv()
  {
    return this.type == 5;
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(244477);
    p.h(paramContext, "context");
    paramContext = dcs().eS(paramContext);
    AppMethodBeat.o(244477);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(244479);
    View localView = this.gte.findViewById(2131300111);
    AppMethodBeat.o(244479);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(244480);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    switch (this.type)
    {
    case 3: 
    case 6: 
    default: 
      localObject1 = this.tOT;
      AppMethodBeat.o(244480);
      return localObject1;
    case 1: 
    case 5: 
      if (this.tTC != null)
      {
        y localy = this.tTC;
        if (localy == null) {
          p.hyc();
        }
        Log.i("Finder.FinderNewsTopicHelper", "getTopicHeaderView : " + null);
        localObject2 = aa.jQ((Context)localy.gte).inflate(2131494659, null, false);
        localObject3 = localy.gte.getIntent().getStringExtra("key_topic_title");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = (TextView)((View)localObject2).findViewById(2131309349);
        if (localObject3 != null)
        {
          if (!n.J((String)localObject1, "#", false))
          {
            ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((TextView)localObject3).getContext(), (CharSequence)"#".concat(String.valueOf(localObject1))));
            label206:
            ao.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
          }
        }
        else
        {
          localObject1 = (TextView)((View)localObject2).findViewById(2131300573);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localy.a(null);
          p.g(localObject2, "header");
          localObject1 = localObject2;
        }
      }
      break;
    }
    for (;;)
    {
      this.tOT = ((View)localObject1);
      break;
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((TextView)localObject3).getContext(), (CharSequence)localObject1));
      break label206;
      this.tOT = View.inflate((Context)this.gte, 2131494656, null);
      localObject1 = this.tOT;
      if (localObject1 == null) {
        break;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131309359);
      if (localObject1 == null) {
        break;
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this.gte, (CharSequence)this.dST));
      break;
      localObject1 = View.inflate((Context)this.gte, 2131494656, null);
      localObject2 = ((View)localObject1).findViewById(2131309359);
      p.g(localObject2, "findViewById<TextView>(R.id.topic_tv)");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((View)localObject1).getContext(), (CharSequence)this.dST));
      ((ImageView)((View)localObject1).findViewById(2131309343)).setImageResource(2131690826);
      continue;
      this.tOT = ((View)new FinderFollowTopicHeaderView((Context)this.gte));
      localObject1 = aa.jQ((Context)this.gte).inflate(2131494323, null);
      p.g(localObject1, "MMLayoutInflater.getInfl…er_on_scroll_layout,null)");
      this.tTD = ((View)localObject1);
      localObject1 = this.tTD;
      if (localObject1 == null) {
        p.btv("followTopicFloatHeader");
      }
      ((View)localObject1).setAlpha(0.0F);
      localObject1 = this.tTD;
      if (localObject1 == null) {
        p.btv("followTopicFloatHeader");
      }
      ((View)localObject1).setVisibility(4);
      localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
      if (com.tencent.mm.plugin.finder.utils.y.dCL() == 1)
      {
        localObject1 = this.tTD;
        if (localObject1 == null) {
          p.btv("followTopicFloatHeader");
        }
        localObject1 = ((View)localObject1).findViewById(2131301648);
        p.g(localObject1, "followTopicFloatHeader.f…w>(R.id.follow_btn_float)");
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        localObject1 = new FrameLayout.LayoutParams(-1, this.gte.getResources().getDimensionPixelSize(2131165308));
        ((FrameLayout.LayoutParams)localObject1).gravity = 48;
        ((FrameLayout.LayoutParams)localObject1).setMargins(0, au.ay((Context)this.gte), 0, 0);
        localObject2 = this.gte.getWindow();
        p.g(localObject2, "context.window");
        localObject2 = ((Window)localObject2).getDecorView();
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(244480);
        throw ((Throwable)localObject1);
        localObject1 = this.tTD;
        if (localObject1 == null) {
          p.btv("followTopicFloatHeader");
        }
        ((View)localObject1).findViewById(2131301648).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject2 = (FrameLayout)localObject2;
      localObject3 = this.tTD;
      if (localObject3 == null) {
        p.btv("followTopicFloatHeader");
      }
      ((FrameLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      break;
      localObject2 = this.tTI;
      if (localObject2 != null)
      {
        localObject1 = aa.jQ((Context)((com.tencent.mm.plugin.finder.activity.view.a)localObject2).gte).inflate(2131494197, null, false);
        ((com.tencent.mm.plugin.finder.activity.view.a)localObject2).dR((View)localObject1);
        p.g(localObject1, "headerView");
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(244478);
    RecyclerView.h localh = dcs().getItemDecoration();
    AppMethodBeat.o(244478);
    return localh;
  }
  
  public final boolean l(h paramh)
  {
    AppMethodBeat.i(244475);
    p.h(paramh, "holder");
    if (paramh.lU() != this.tTF)
    {
      if (paramh.getTag() != null)
      {
        paramh = paramh.getTag();
        be.a locala = be.tER;
        if (!p.j(paramh, Integer.valueOf(be.cZK()))) {}
      }
    }
    else
    {
      AppMethodBeat.o(244475);
      return true;
    }
    AppMethodBeat.o(244475);
    return false;
  }
  
  /* Error */
  public final void nb(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 994
    //   5: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 182	com/tencent/mm/plugin/finder/feed/av$b:TAG	Ljava/lang/String;
    //   12: ldc_w 996
    //   15: iload_1
    //   16: invokestatic 999	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   19: invokevirtual 692	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 261	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iload_1
    //   26: ifeq +16 -> 42
    //   29: aload_0
    //   30: invokespecial 1001	com/tencent/mm/plugin/finder/feed/av$b:ddt	()V
    //   33: ldc_w 994
    //   36: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: invokevirtual 1003	com/tencent/mm/plugin/finder/feed/av$b:ddu	()V
    //   46: ldc_w 994
    //   49: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -13 -> 39
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	b
    //   0	60	1	paramBoolean	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	55	finally
    //   29	39	55	finally
    //   42	52	55	finally
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(av.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244469);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$getHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.tTK.tOT;
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView");
        AppMethodBeat.o(244469);
        throw paramView;
      }
      ((FinderFollowTopicHeaderView)paramView).dla();
      paramView = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.H(false, 6);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$getHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(244469);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$1$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$2"})
  static final class b
    implements View.OnClickListener
  {
    b(axt paramaxt, byte[] paramArrayOfByte, View paramView, av.b paramb, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244470);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.utils.y.vXH;
      paramView = this.tTN.getContext();
      p.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.y.a(paramView, this.tTL);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(244470);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$1$2"})
  static final class c
    implements Runnable
  {
    c(View paramView, av.b paramb, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(244471);
      Object localObject1 = this.tTK.dcr();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
        AppMethodBeat.o(244471);
        throw ((Throwable)localObject1);
      }
      bdr localbdr = ((av.a)localObject1).bgmInfo;
      if (localbdr != null)
      {
        Object localObject3;
        if (localbdr.musicInfo == null)
        {
          localObject2 = ((Iterable)this.tTK.dcr().tFM.getDataList()).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (bo)localObject1;
            if (localObject3 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
              AppMethodBeat.o(244471);
              throw ((Throwable)localObject1);
            }
            if (p.j(d.zs(((BaseFinderFeed)localObject3).feedObject.getFeedObject().id), localbdr.groupId))
            {
              localObject1 = (bo)localObject1;
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
          localObject1 = this.tTK.tOT;
          if (localObject1 != null) {
            break label238;
          }
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView");
          AppMethodBeat.o(244471);
          throw ((Throwable)localObject1);
          localObject1 = null;
          break;
          localObject1 = (bo)kotlin.a.j.L((List)this.tTK.dcr().tFM.getDataList(), 0);
          break label158;
        }
        label238:
        FinderFollowTopicHeaderView localFinderFollowTopicHeaderView = (FinderFollowTopicHeaderView)localObject1;
        localObject1 = this.tTK.dcr();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
          AppMethodBeat.o(244471);
          throw ((Throwable)localObject1);
        }
        int i = ((av.a)localObject1).tTm;
        localObject1 = this.tTK.dcr();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
          AppMethodBeat.o(244471);
          throw ((Throwable)localObject1);
        }
        int j = ((av.a)localObject1).cSx;
        localFinderFollowTopicHeaderView.uPd = ((FinderItem)localObject2);
        localFinderFollowTopicHeaderView.uPe = localbdr;
        localFinderFollowTopicHeaderView.dLS = i;
        if (localbdr != null)
        {
          localObject1 = localbdr.musicInfo;
          if (localObject1 == null) {
            break label973;
          }
          localFinderFollowTopicHeaderView.type = 2;
          localObject1 = localbdr.musicInfo;
          if (localObject1 == null) {
            break label649;
          }
          localObject1 = ((azk)localObject1).artist;
          if ((localObject1 == null) || (n.a((CharSequence)localObject1, (CharSequence)" · ", false) != true)) {
            break label649;
          }
          localObject1 = localbdr.musicInfo;
          if (localObject1 == null) {
            break label644;
          }
          localObject1 = ((azk)localObject1).artist;
          if (localObject1 == null) {
            break label644;
          }
          localObject1 = n.a((CharSequence)localObject1, new String[] { " · " });
          if (localObject1 == null) {
            break label644;
          }
          localObject1 = (String)((List)localObject1).get(0);
          label446:
          localObject3 = (TextView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131300771);
          p.g(localObject3, "finder_artist_name");
          ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
          localObject3 = (TextView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301370);
          p.g(localObject3, "finder_music_name");
          localObject1 = localbdr.musicInfo;
          if (localObject1 == null) {
            break label672;
          }
          localObject1 = ((azk)localObject1).name;
          label511:
          ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
          if (!FinderFollowTopicHeaderView.Jv(j)) {
            break label677;
          }
          ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301373)).setOnClickListener(localFinderFollowTopicHeaderView.uPp);
          ((LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301647)).setOnClickListener(localFinderFollowTopicHeaderView.uPp);
          label566:
          if (localbdr == null) {
            break label2036;
          }
          localObject1 = localbdr.musicInfo;
          label577:
          if (localObject1 == null) {
            break label2046;
          }
          localObject1 = this.tTK.dds().findViewById(2131301500);
          p.g(localObject1, "followTopicFloatHeader.f…finder_topic_header_text)");
          localObject2 = (TextView)localObject1;
          localObject1 = localbdr.musicInfo;
          if (localObject1 == null) {
            break label2041;
          }
        }
        label644:
        label649:
        label672:
        label677:
        label715:
        label973:
        label2036:
        label2041:
        for (localObject1 = ((azk)localObject1).name;; localObject1 = null)
        {
          ((TextView)localObject2).setText((CharSequence)String.valueOf(localObject1));
          AppMethodBeat.o(244471);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label446;
          localObject1 = localbdr.musicInfo;
          if (localObject1 != null)
          {
            localObject1 = ((azk)localObject1).artist;
            break label446;
          }
          localObject1 = null;
          break label446;
          localObject1 = null;
          break label511;
          localFinderFollowTopicHeaderView.uPi = ((FinderImgFeedMusicTag)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301372));
          localObject3 = localFinderFollowTopicHeaderView.uPi;
          Object localObject4;
          if (localObject3 != null)
          {
            if (localbdr != null)
            {
              localObject1 = localbdr.musicInfo;
              ((FinderImgFeedMusicTag)localObject3).a((azk)localObject1);
            }
          }
          else
          {
            ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301373)).setOnClickListener(localFinderFollowTopicHeaderView.uPn);
            localObject4 = new AudioCacheInfo();
            ((AudioCacheInfo)localObject4).BOX = ((int)System.currentTimeMillis());
            if (localbdr == null) {
              break label963;
            }
            localObject1 = localbdr.musicInfo;
            if (localObject1 == null) {
              break label963;
            }
            localObject1 = ((azk)localObject1).LJi;
            ((AudioCacheInfo)localObject4).musicUrl = ((String)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.utils.al.waC;
            if (localbdr == null) {
              break label968;
            }
            localObject1 = localbdr.musicInfo;
            if (localObject1 == null) {
              p.hyc();
            }
            p.g(localObject1, "bgmInfo?.musicInfo!!");
            ((AudioCacheInfo)localObject4).cachePath = com.tencent.mm.plugin.finder.utils.al.b((azk)localObject1);
            localObject3 = ((AudioCacheInfo)localObject4).cachePath;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            localFinderFollowTopicHeaderView.filePath = ((String)localObject1);
            localFinderFollowTopicHeaderView.uPh = ((AudioCacheInfo)localObject4);
            localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL;
            localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.i.eKl();
            localObject3 = localFinderFollowTopicHeaderView.getContext();
            p.g(localObject3, "context");
            localObject4 = localFinderFollowTopicHeaderView.uPh;
            if (localObject4 == null) {
              p.hyc();
            }
            ((com.tencent.mm.plugin.recordvideo.model.audio.i)localObject1).a((Context)localObject3, (AudioCacheInfo)localObject4, (kotlin.g.a.m)new FinderFollowTopicHeaderView.d(localFinderFollowTopicHeaderView));
          }
          for (;;)
          {
            localObject1 = (FinderImgFeedMusicTag)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301372);
            p.g(localObject1, "view");
            localObject3 = ((FinderImgFeedMusicTag)localObject1).getParent();
            if (localObject3 != null) {
              break label1852;
            }
            localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(244471);
            throw ((Throwable)localObject1);
            localObject1 = null;
            break label715;
            localObject1 = null;
            break label777;
            localObject1 = null;
            break label798;
            localFinderFollowTopicHeaderView.type = 1;
            if ((localbdr != null) && (localbdr.contact != null))
            {
              localObject3 = (TextView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131300771);
              p.g(localObject3, "finder_artist_name");
              localObject1 = localbdr.contact;
              if (localObject1 == null) {
                break label1179;
              }
              localObject1 = ((FinderContact)localObject1).nickname;
              ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
              localObject3 = (TextView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301370);
              p.g(localObject3, "finder_music_name");
              localObject4 = localFinderFollowTopicHeaderView.getContext();
              localObject1 = localbdr.contact;
              if (localObject1 == null) {
                break label1184;
              }
            }
            for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
            {
              ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getString(2131759788, new Object[] { localObject1 }));
              localFinderFollowTopicHeaderView.findViewById(2131300771).setOnClickListener((View.OnClickListener)new FinderFollowTopicHeaderView.b(localFinderFollowTopicHeaderView, localbdr));
              localObject1 = (WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131300844);
              p.g(localObject1, "finder_follow_arrow");
              ((WeImageView)localObject1).setVisibility(0);
              if (!FinderFollowTopicHeaderView.Jv(j)) {
                break label1189;
              }
              ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301373)).setOnClickListener(localFinderFollowTopicHeaderView.uPp);
              break;
              localObject1 = null;
              break label1026;
            }
            if (localbdr != null)
            {
              localObject1 = localbdr.audioTrackUrl;
              localObject1 = (CharSequence)localObject1;
              if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                break label1354;
              }
              i = 1;
            }
            for (;;)
            {
              if (i != 0)
              {
                localFinderFollowTopicHeaderView.uPi = ((FinderImgFeedMusicTag)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301372));
                ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301373)).setOnClickListener(localFinderFollowTopicHeaderView.uPl);
                localFinderFollowTopicHeaderView.uPl = localFinderFollowTopicHeaderView.uPl;
                if (localObject2 == null)
                {
                  localObject1 = (LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301647);
                  p.g(localObject1, "follow_btn");
                  ((LinearLayout)localObject1).setVisibility(8);
                  localObject1 = (WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301373);
                  p.g(localObject1, "finder_music_play_btn_ui");
                  ((WeImageView)localObject1).setAlpha(0.5F);
                  ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301373)).setOnClickListener((View.OnClickListener)new FinderFollowTopicHeaderView.e(localFinderFollowTopicHeaderView));
                  break;
                  localObject1 = null;
                  break label1200;
                  i = 0;
                  continue;
                }
                localObject4 = localFinderFollowTopicHeaderView.uPc;
                if (localObject4 == null) {
                  break;
                }
                localObject1 = ((FinderItem)localObject2).getMediaList().get(0);
                p.g(localObject1, "feed.mediaList[0]");
                localFinderFollowTopicHeaderView.uPf = new s((cjl)localObject1, com.tencent.mm.plugin.finder.storage.x.vEz, 0, null, 12);
                localObject1 = localFinderFollowTopicHeaderView.uPf;
                if (localObject1 == null) {
                  p.hyc();
                }
                localFinderFollowTopicHeaderView.filePath = ((s)localObject1).getPath();
                localObject1 = localFinderFollowTopicHeaderView.uPf;
                if (localObject1 != null)
                {
                  localObject3 = ((s)localObject1).getPath();
                  localObject1 = localObject3;
                  if (localObject3 != null) {}
                }
                else
                {
                  localObject1 = "";
                }
                localFinderFollowTopicHeaderView.dvV = FinderFollowTopicHeaderView.auj((String)localObject1);
                if (localFinderFollowTopicHeaderView.dvV)
                {
                  localObject1 = localFinderFollowTopicHeaderView.uPf;
                  if (localObject1 == null) {
                    p.hyc();
                  }
                  localFinderFollowTopicHeaderView.a((s)localObject1);
                }
                Log.i("FinderFollowTopicHeaderView", "file downloadFinish = " + localFinderFollowTopicHeaderView.dvV);
                localObject1 = localFinderFollowTopicHeaderView.uPf;
                if (localObject1 == null) {
                  p.hyc();
                }
                localObject3 = FeedData.Companion;
                ((FinderVideoViewForTopic)localObject4).b((s)localObject1, false, FeedData.a.i((FinderItem)localObject2));
                ((FinderVideoViewForTopic)localObject4).setScaleType(i.e.Kcc);
                localObject1 = new r();
                localObject3 = localFinderFollowTopicHeaderView.uPf;
                if (localObject3 == null) {
                  p.hyc();
                }
                ((FinderVideoViewForTopic)localObject4).setIOnlineVideoProxy(((r)localObject1).a((s)localObject3, (com.tencent.mm.plugin.finder.video.x)localFinderFollowTopicHeaderView));
                ((FinderVideoViewForTopic)localObject4).setIsShowBasicControls(false);
                ((FinderVideoViewForTopic)localObject4).setLoop(true);
                ((FinderVideoViewForTopic)localObject4).setMute(true);
                ((FinderVideoViewForTopic)localObject4).dFj();
                break;
              }
            }
            if (localbdr != null)
            {
              localFinderFollowTopicHeaderView.uPi = ((FinderImgFeedMusicTag)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301372));
              localObject1 = new azk();
              ((azk)localObject1).LJi = localbdr.audioTrackUrl;
              ((azk)localObject1).name = "fake music info";
              ((azk)localObject1).wWb = String.valueOf(System.currentTimeMillis());
              localObject3 = localFinderFollowTopicHeaderView.uPi;
              if (localObject3 != null) {
                ((FinderImgFeedMusicTag)localObject3).a((azk)localObject1);
              }
              ((WeImageView)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301373)).setOnClickListener(localFinderFollowTopicHeaderView.uPn);
              localObject4 = new AudioCacheInfo();
              ((AudioCacheInfo)localObject4).BOX = ((int)System.currentTimeMillis());
              ((AudioCacheInfo)localObject4).musicUrl = ((azk)localObject1).LJi;
              localObject3 = com.tencent.mm.plugin.finder.utils.al.waC;
              ((AudioCacheInfo)localObject4).cachePath = com.tencent.mm.plugin.finder.utils.al.b((azk)localObject1);
              localObject3 = ((AudioCacheInfo)localObject4).cachePath;
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = "";
              }
              localFinderFollowTopicHeaderView.filePath = ((String)localObject1);
              localFinderFollowTopicHeaderView.uPh = ((AudioCacheInfo)localObject4);
              localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL;
              localObject1 = com.tencent.mm.plugin.recordvideo.model.audio.i.eKl();
              localObject3 = localFinderFollowTopicHeaderView.getContext();
              p.g(localObject3, "context");
              localObject4 = localFinderFollowTopicHeaderView.uPh;
              if (localObject4 == null) {
                p.hyc();
              }
              ((com.tencent.mm.plugin.recordvideo.model.audio.i)localObject1).a((Context)localObject3, (AudioCacheInfo)localObject4, (kotlin.g.a.m)new FinderFollowTopicHeaderView.c(localFinderFollowTopicHeaderView));
            }
          }
          ((ViewGroup)localObject3).removeView((View)localObject1);
          localObject3 = AndroidContextUtil.castActivityOrNull(localFinderFollowTopicHeaderView.getContext());
          if (localObject3 != null)
          {
            localObject3 = ((Activity)localObject3).getWindow();
            p.g(localObject3, "it.window");
            localObject3 = ((Window)localObject3).getDecorView();
            if (localObject3 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
              AppMethodBeat.o(244471);
              throw ((Throwable)localObject1);
            }
            ((FrameLayout)localObject3).addView((View)localObject1);
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
          if (com.tencent.mm.plugin.finder.utils.y.dCL() == 1)
          {
            localObject1 = (LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301647);
            p.g(localObject1, "follow_btn");
            ((LinearLayout)localObject1).setVisibility(8);
            break label566;
          }
          localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.H(true, 6);
          localObject1 = (LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301647);
          p.g(localObject1, "follow_btn");
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localFinderFollowTopicHeaderView._$_findCachedViewById(2131301647)).setOnClickListener((View.OnClickListener)new FinderFollowTopicHeaderView.f(localFinderFollowTopicHeaderView, j));
          break label566;
          localObject1 = null;
          break label577;
        }
        label777:
        label798:
        label963:
        label968:
        label1354:
        label2046:
        if (localbdr != null)
        {
          localObject1 = localbdr.contact;
          if (localObject1 == null) {
            break label2150;
          }
          localObject1 = this.tTK.dds().findViewById(2131301500);
          p.g(localObject1, "followTopicFloatHeader.f…finder_topic_header_text)");
          localObject2 = (TextView)localObject1;
          localObject3 = this.tCl.getContext();
          localObject1 = localbdr.contact;
          if (localObject1 == null) {
            break label2145;
          }
        }
        label1026:
        label1179:
        label1184:
        label1189:
        label1200:
        label1852:
        label2145:
        for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
        {
          ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(2131759788, new Object[] { localObject1 }));
          AppMethodBeat.o(244471);
          return;
          localObject1 = null;
          break;
        }
        label2150:
        if (localObject2 != null)
        {
          localObject1 = this.tTK.dds().findViewById(2131301500);
          p.g(localObject1, "followTopicFloatHeader.f…finder_topic_header_text)");
          ((TextView)localObject1).setText((CharSequence)this.tCl.getContext().getString(2131759788, new Object[] { ((FinderItem)localObject2).getFinderObject().nickname }));
        }
        AppMethodBeat.o(244471);
        return;
      }
      AppMethodBeat.o(244471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.av.b
 * JD-Core Version:    0.7.0.1
 */