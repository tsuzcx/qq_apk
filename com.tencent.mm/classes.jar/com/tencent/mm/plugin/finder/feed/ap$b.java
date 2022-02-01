package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.ai.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPR_LOADING_HEADER", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "loadingHeader", "Landroid/view/View;", "needRefreshWhenEnter", "getNeedRefreshWhenEnter", "()Z", "setNeedRefreshWhenEnter", "(Z)V", "topic", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "topicHeader", "type", "getType", "()I", "setType", "(I)V", "addLoadingHeader", "", "addTagsHeader", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "dimissLoadingHeader", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onDetach", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "otherFullSpan", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "refreshHeaderContent", "subTitle", "count", "", "refreshSubTile", "refreshWhenEnter", "showProgressHeader", "ifShow", "plugin-finder_release"})
public final class ap$b
  extends b.b
{
  private final String TAG;
  public String dBe;
  com.tencent.mm.plugin.finder.model.i shJ;
  View sjq;
  private View sjr;
  private final int sjs;
  public boolean sjt;
  public int type;
  
  private ap$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, 2, paramInt, false);
    AppMethodBeat.i(202764);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedViewCallback";
    this.sjs = -2;
    this.dBe = "";
    this.shJ = new com.tencent.mm.plugin.finder.model.i(new ctu());
    this.sjt = true;
    AppMethodBeat.o(202764);
  }
  
  /* Error */
  private void cDC()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 145
    //   4: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:sjr	Landroid/view/View;
    //   11: ifnonnull +23 -> 34
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 150	com/tencent/mm/plugin/finder/feed/b$b:fNT	Lcom/tencent/mm/ui/MMActivity;
    //   19: checkcast 152	android/content/Context
    //   22: invokestatic 158	com/tencent/mm/ui/z:jV	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   25: ldc 159
    //   27: aconst_null
    //   28: invokevirtual 165	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   31: putfield 147	com/tencent/mm/plugin/finder/feed/ap$b:sjr	Landroid/view/View;
    //   34: aload_0
    //   35: getfield 117	com/tencent/mm/plugin/finder/feed/ap$b:TAG	Ljava/lang/String;
    //   38: astore_2
    //   39: new 167	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 169
    //   45: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_0
    //   50: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:sjr	Landroid/view/View;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +46 -> 101
    //   58: aload_1
    //   59: invokevirtual 177	android/view/View:getParent	()Landroid/view/ViewParent;
    //   62: astore_1
    //   63: aload_2
    //   64: aload_3
    //   65: aload_1
    //   66: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:sjr	Landroid/view/View;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +25 -> 106
    //   84: aload_1
    //   85: invokevirtual 177	android/view/View:getParent	()Landroid/view/ViewParent;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +21 -> 111
    //   93: ldc 145
    //   95: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   112: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:sjr	Landroid/view/View;
    //   115: ifnull +31 -> 146
    //   118: aload_0
    //   119: invokevirtual 194	com/tencent/mm/plugin/finder/feed/ap$b:getAdapter	()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:sjr	Landroid/view/View;
    //   127: astore_2
    //   128: aload_2
    //   129: ifnonnull +6 -> 135
    //   132: invokestatic 197	d/g/b/p:gkB	()V
    //   135: aload_1
    //   136: aload_2
    //   137: aload_0
    //   138: getfield 119	com/tencent/mm/plugin/finder/feed/ap$b:sjs	I
    //   141: iconst_1
    //   142: invokevirtual 203	com/tencent/mm/view/recyclerview/WxRecyclerAdapter:f	(Landroid/view/View;IZ)Lcom/tencent/mm/view/recyclerview/d$b;
    //   145: pop
    //   146: ldc 145
    //   148: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(202754);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    d.g.b.p.h(parama, "adapter");
    d.g.b.p.h(paramView, "view");
    paramInt -= ((d)parama).LRV.size();
    label153:
    FinderItem localFinderItem;
    Object localObject2;
    if (paramInt >= 0)
    {
      parama = cCB();
      if (parama != null)
      {
        parama = parama.scw;
        if (parama != null)
        {
          parama = Integer.valueOf(parama.getSize());
          if (paramInt >= parama.intValue()) {
            break label872;
          }
          parama = cCB();
          if (parama == null) {
            break label332;
          }
          parama = parama.scw;
          if (parama == null) {
            break label332;
          }
          parama = parama.getListOfType(BaseFinderFeed.class);
          if (parama == null) {
            break label332;
          }
          parama = (BaseFinderFeed)parama.get(paramInt);
          localFinderItem = parama.feedObject;
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("onClick ").append(paramInt).append(" id:");
          if (localFinderItem == null) {
            break label337;
          }
          parama = Long.valueOf(localFinderItem.getId());
          label201:
          ae.i((String)localObject1, parama.longValue() + ", pos:" + paramInt);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_topic_type", this.type);
          ((Intent)localObject2).putExtra("key_topic_title", this.dBe);
          if (localFinderItem == null) {
            break label342;
          }
        }
      }
      label332:
      label337:
      label342:
      for (parama = Long.valueOf(localFinderItem.getId());; parama = null)
      {
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_ID", parama.longValue());
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", paramInt);
        parama = cCB();
        if (parama != null) {
          break label347;
        }
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
        AppMethodBeat.o(202754);
        throw parama;
        parama = null;
        break;
        parama = null;
        break label153;
        parama = null;
        break label201;
      }
      label347:
      localObject1 = (ap.a)parama;
      if (ap.a.b(((ap.a)localObject1).shI)) {
        parama = null;
      }
      for (;;)
      {
        localObject1 = cCB().scw;
        if (localObject1 != null) {
          break;
        }
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202754);
        throw parama;
        parama = new ctu();
        parama.HEO = new LinkedList();
        parama.HEO.add(((ap.a)localObject1).shI);
      }
      FinderTopicFeedLoader localFinderTopicFeedLoader = (FinderTopicFeedLoader)localObject1;
      if (parama != null)
      {
        localObject1 = parama.HEO;
        if (localObject1 != null)
        {
          localObject1 = (asv)((LinkedList)localObject1).get(0);
          if (localObject1 != null)
          {
            localObject1 = ((asv)localObject1).dBe;
            localObject1 = localFinderTopicFeedLoader.aip((String)localObject1);
            cCB().scw.saveCache((Intent)localObject2, paramInt, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.b(parama, (com.tencent.mm.bw.b)localObject1));
            ((Intent)localObject2).putExtra("key_ref_object_id", this.fNT.getIntent().getLongExtra("key_ref_object_id", 0L));
            parama = cCB();
            if (parama == null) {
              break label578;
            }
          }
        }
      }
      label578:
      for (parama = parama.scw;; parama = null)
      {
        if (parama != null) {
          break label583;
        }
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202754);
        throw parama;
        localObject1 = null;
        break;
      }
      label583:
      parama = ((FinderTopicFeedLoader)parama).slb;
      if (parama != null)
      {
        parama = parama.toByteArray();
        ((Intent)localObject2).putExtra("KEY_FINDER_LOCATION", parama);
        parama = cCB();
        if (parama == null) {
          break label651;
        }
      }
      label651:
      for (parama = parama.scw;; parama = null)
      {
        if (parama != null) {
          break label656;
        }
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202754);
        throw parama;
        parama = null;
        break;
      }
      label656:
      if (((FinderTopicFeedLoader)parama).rRJ != null)
      {
        parama = cCB();
        if (parama != null) {}
        for (parama = parama.scw; parama == null; parama = null)
        {
          parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(202754);
          throw parama;
        }
        parama = ((FinderTopicFeedLoader)parama).rRJ;
        if (parama == null) {
          break label890;
        }
      }
    }
    label872:
    label890:
    for (parama = parama.toByteArray();; parama = null)
    {
      ((Intent)localObject2).putExtra("KEY_SECTION_INFO", parama);
      ae.i(this.TAG, "enterTopicTimelineUI, fixPos:".concat(String.valueOf(paramInt)));
      parama = FinderReporterUIC.tnG;
      parama = paramView.getContext();
      d.g.b.p.g(parama, "view.context");
      FinderReporterUIC.a.a(parama, (Intent)localObject2, 0L, 0, false, 124);
      parama = com.tencent.mm.plugin.finder.utils.a.sVQ;
      parama = paramView.getContext();
      d.g.b.p.g(parama, "view.context");
      com.tencent.mm.plugin.finder.utils.a.K(parama, (Intent)localObject2);
      if (localFinderItem != null)
      {
        parama = com.tencent.mm.plugin.finder.report.i.syT;
        com.tencent.mm.plugin.finder.report.i.K(localFinderItem.getId(), 2);
        parama = FinderReporterUIC.tnG;
        parama = paramView.getContext();
        d.g.b.p.g(parama, "view.context");
        parama = FinderReporterUIC.a.fc(parama);
        if (parama != null)
        {
          parama = parama.cQZ();
          if (parama != null)
          {
            paramView = com.tencent.mm.plugin.finder.report.i.syT;
            com.tencent.mm.plugin.finder.report.i.a(parama, localFinderItem.getId(), this.scj.getRecyclerView());
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
      AppMethodBeat.o(202754);
      return;
    }
  }
  
  public final boolean cCE()
  {
    return this.sjt;
  }
  
  public final void cCF() {}
  
  public final void cDD()
  {
    AppMethodBeat.i(202763);
    if (this.sjr != null)
    {
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      View localView = this.sjr;
      if (localView == null) {
        d.g.b.p.gkB();
      }
      localWxRecyclerAdapter.O(localView.hashCode(), true);
    }
    AppMethodBeat.o(202763);
  }
  
  public final boolean d(e parame)
  {
    AppMethodBeat.i(202753);
    d.g.b.p.h(parame, "holder");
    if (parame.lQ() != this.sjs)
    {
      if (parame.getTag() != null)
      {
        parame = parame.getTag();
        ai.a locala = ai.rXG;
        if (!d.g.b.p.i(parame, Integer.valueOf(ai.cAG()))) {}
      }
    }
    else
    {
      AppMethodBeat.o(202753);
      return true;
    }
    AppMethodBeat.o(202753);
    return false;
  }
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202759);
    d.g.b.p.h(paramc, "reason");
    AppMethodBeat.o(202759);
    return null;
  }
  
  public final RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(202755);
    d.g.b.p.h(paramContext, "context");
    paramContext = cCD().eP(paramContext);
    AppMethodBeat.o(202755);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202760);
    d.g.b.p.h(paramc, "reason");
    AppMethodBeat.o(202760);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202757);
    View localView = this.fNT.findViewById(2131299478);
    AppMethodBeat.o(202757);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(202758);
    View localView = View.inflate((Context)this.fNT, 2131494118, null);
    d.g.b.p.g(localView, "View.inflate(context, R.…_topic_feed_header, null)");
    this.sjq = localView;
    localView = this.sjq;
    if (localView == null) {
      d.g.b.p.bdF("topicHeader");
    }
    localView = localView.findViewById(2131306038);
    d.g.b.p.g(localView, "topicHeader.findViewById<TextView>(R.id.topic_tv)");
    ((TextView)localView).setText((CharSequence)k.c((Context)this.fNT, (CharSequence)this.dBe));
    switch (this.type)
    {
    }
    for (;;)
    {
      localView = this.sjq;
      if (localView == null) {
        d.g.b.p.bdF("topicHeader");
      }
      AppMethodBeat.o(202758);
      return localView;
      localView = this.sjq;
      if (localView == null) {
        d.g.b.p.bdF("topicHeader");
      }
      ((ImageView)localView.findViewById(2131306026)).setImageResource(2131690589);
      localView = this.sjq;
      if (localView == null) {
        d.g.b.p.bdF("topicHeader");
      }
      localView = localView.findViewById(2131306027);
      d.g.b.p.g(localView, "topicHeader.findViewById…w>(R.id.topic_icon_right)");
      ((ImageView)localView).setVisibility(8);
    }
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202756);
    RecyclerView.h localh = cCD().getItemDecoration();
    AppMethodBeat.o(202756);
    return localh;
  }
  
  /* Error */
  public final void lU(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 609
    //   5: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 117	com/tencent/mm/plugin/finder/feed/ap$b:TAG	Ljava/lang/String;
    //   12: ldc_w 611
    //   15: iload_1
    //   16: invokestatic 614	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   19: invokevirtual 434	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iload_1
    //   26: ifeq +16 -> 42
    //   29: aload_0
    //   30: invokespecial 616	com/tencent/mm/plugin/finder/feed/ap$b:cDC	()V
    //   33: ldc_w 609
    //   36: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: invokevirtual 618	com/tencent/mm/plugin/finder/feed/ap$b:cDD	()V
    //   46: ldc_w 609
    //   49: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshSubTile$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$1"})
  static final class a
    implements View.OnClickListener
  {
    a(apl paramapl, byte[] paramArrayOfByte, ap.b paramb, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202752);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshSubTile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
      com.tencent.mm.plugin.finder.utils.p.a((Context)this.sjw.fNT, this.sju);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshSubTile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202752);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ap.b
 * JD-Core Version:    0.7.0.1
 */