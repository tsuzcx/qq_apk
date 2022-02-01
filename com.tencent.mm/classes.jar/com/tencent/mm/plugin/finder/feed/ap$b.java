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
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.ah.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPR_LOADING_HEADER", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "loadingHeader", "Landroid/view/View;", "needRefreshWhenEnter", "getNeedRefreshWhenEnter", "()Z", "setNeedRefreshWhenEnter", "(Z)V", "topic", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "topicHeader", "type", "getType", "()I", "setType", "(I)V", "addLoadingHeader", "", "addTagsHeader", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "dimissLoadingHeader", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onDetach", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "otherFullSpan", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "refreshHeaderContent", "subTitle", "count", "", "refreshSubTile", "refreshWhenEnter", "showProgressHeader", "ifShow", "plugin-finder_release"})
public final class ap$b
  extends b.b
{
  private final String TAG;
  public String dzZ;
  i rYX;
  View saB;
  private View saC;
  private final int saD;
  public boolean saE;
  public int type;
  
  private ap$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, 2, paramInt, false);
    AppMethodBeat.i(202299);
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedViewCallback";
    this.saD = -2;
    this.dzZ = "";
    this.rYX = new i(new cta());
    this.saE = true;
    AppMethodBeat.o(202299);
  }
  
  /* Error */
  private void cBQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 145
    //   4: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:saC	Landroid/view/View;
    //   11: ifnonnull +23 -> 34
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 150	com/tencent/mm/plugin/finder/feed/b$b:fLP	Lcom/tencent/mm/ui/MMActivity;
    //   19: checkcast 152	android/content/Context
    //   22: invokestatic 158	com/tencent/mm/ui/z:jO	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   25: ldc 159
    //   27: aconst_null
    //   28: invokevirtual 165	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   31: putfield 147	com/tencent/mm/plugin/finder/feed/ap$b:saC	Landroid/view/View;
    //   34: aload_0
    //   35: getfield 117	com/tencent/mm/plugin/finder/feed/ap$b:TAG	Ljava/lang/String;
    //   38: astore_2
    //   39: new 167	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 169
    //   45: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_0
    //   50: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:saC	Landroid/view/View;
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
    //   72: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:saC	Landroid/view/View;
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
    //   112: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:saC	Landroid/view/View;
    //   115: ifnull +31 -> 146
    //   118: aload_0
    //   119: invokevirtual 194	com/tencent/mm/plugin/finder/feed/ap$b:getAdapter	()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 147	com/tencent/mm/plugin/finder/feed/ap$b:saC	Landroid/view/View;
    //   127: astore_2
    //   128: aload_2
    //   129: ifnonnull +6 -> 135
    //   132: invokestatic 197	d/g/b/p:gfZ	()V
    //   135: aload_1
    //   136: aload_2
    //   137: aload_0
    //   138: getfield 119	com/tencent/mm/plugin/finder/feed/ap$b:saD	I
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
    AppMethodBeat.i(202289);
    d.g.b.p.h(parama, "adapter");
    d.g.b.p.h(paramView, "view");
    paramInt -= ((d)parama).Lvi.size();
    if (paramInt >= 0)
    {
      parama = cAP();
      label108:
      FinderItem localFinderItem;
      Object localObject2;
      if (parama != null)
      {
        parama = parama.rTS;
        if (parama != null)
        {
          parama = Integer.valueOf(parama.getSize());
          if (paramInt >= parama.intValue()) {
            break label838;
          }
          parama = cAP();
          if (parama == null) {
            break label287;
          }
          parama = parama.rTS;
          if (parama == null) {
            break label287;
          }
          parama = parama.getListOfType(BaseFinderFeed.class);
          if (parama == null) {
            break label287;
          }
          parama = (BaseFinderFeed)parama.get(paramInt);
          localFinderItem = parama.feedObject;
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("onClick ").append(paramInt).append(" id:");
          if (localFinderItem == null) {
            break label292;
          }
          parama = Long.valueOf(localFinderItem.getId());
          label156:
          ad.i((String)localObject1, parama.longValue() + ", pos:" + paramInt);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_topic_type", this.type);
          ((Intent)localObject2).putExtra("key_topic_title", this.dzZ);
          if (localFinderItem == null) {
            break label297;
          }
        }
      }
      label287:
      label292:
      label297:
      for (parama = Long.valueOf(localFinderItem.getId());; parama = null)
      {
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_ID", parama.longValue());
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", paramInt);
        parama = cAP();
        if (parama != null) {
          break label302;
        }
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
        AppMethodBeat.o(202289);
        throw parama;
        parama = null;
        break;
        parama = null;
        break label108;
        parama = null;
        break label156;
      }
      label302:
      Object localObject1 = (ap.a)parama;
      if (ap.a.b(((ap.a)localObject1).rYW)) {
        parama = null;
      }
      for (;;)
      {
        localObject1 = cAP().rTS;
        if (localObject1 != null) {
          break;
        }
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202289);
        throw parama;
        parama = new cta();
        parama.Hlo = new LinkedList();
        parama.Hlo.add(((ap.a)localObject1).rYW);
      }
      FinderTopicFeedLoader localFinderTopicFeedLoader = (FinderTopicFeedLoader)localObject1;
      if (parama != null)
      {
        localObject1 = parama.Hlo;
        if (localObject1 != null)
        {
          localObject1 = (asg)((LinkedList)localObject1).get(0);
          if (localObject1 != null)
          {
            localObject1 = ((asg)localObject1).dzZ;
            localObject1 = localFinderTopicFeedLoader.ahs((String)localObject1);
            cAP().rTS.saveCache((Intent)localObject2, paramInt, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.b(parama, (com.tencent.mm.bx.b)localObject1));
            ((Intent)localObject2).putExtra("key_ref_object_id", this.fLP.getIntent().getLongExtra("key_ref_object_id", 0L));
            parama = cAP();
            if (parama == null) {
              break label533;
            }
          }
        }
      }
      label533:
      for (parama = parama.rTS;; parama = null)
      {
        if (parama != null) {
          break label538;
        }
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202289);
        throw parama;
        localObject1 = null;
        break;
      }
      label538:
      parama = ((FinderTopicFeedLoader)parama).sck;
      if (parama != null)
      {
        parama = parama.toByteArray();
        ((Intent)localObject2).putExtra("KEY_FINDER_LOCATION", parama);
        parama = cAP();
        if (parama == null) {
          break label606;
        }
      }
      label606:
      for (parama = parama.rTS;; parama = null)
      {
        if (parama != null) {
          break label611;
        }
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
        AppMethodBeat.o(202289);
        throw parama;
        parama = null;
        break;
      }
      label611:
      if (((FinderTopicFeedLoader)parama).rJv != null)
      {
        parama = cAP();
        if (parama != null) {}
        for (parama = parama.rTS; parama == null; parama = null)
        {
          parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(202289);
          throw parama;
        }
        parama = ((FinderTopicFeedLoader)parama).rJv;
        if (parama == null) {
          break label833;
        }
      }
      label833:
      for (parama = parama.toByteArray();; parama = null)
      {
        ((Intent)localObject2).putExtra("KEY_SECTION_INFO", parama);
        ad.i(this.TAG, "enterTopicTimelineUI, fixPos:".concat(String.valueOf(paramInt)));
        parama = FinderReporterUIC.tcM;
        parama = paramView.getContext();
        d.g.b.p.g(parama, "view.context");
        FinderReporterUIC.a.a(parama, (Intent)localObject2, 0L, 0, false, 124);
        parama = com.tencent.mm.plugin.finder.utils.a.sKD;
        parama = paramView.getContext();
        d.g.b.p.g(parama, "view.context");
        com.tencent.mm.plugin.finder.utils.a.K(parama, (Intent)localObject2);
        if (localFinderItem == null) {
          break;
        }
        parama = h.soM;
        h.K(localFinderItem.getId(), 2);
        parama = FinderReporterUIC.tcM;
        parama = paramView.getContext();
        d.g.b.p.g(parama, "view.context");
        parama = FinderReporterUIC.a.eY(parama);
        if (parama == null) {
          break;
        }
        parama = parama.cOu();
        if (parama == null) {
          break;
        }
        paramView = h.soM;
        h.a(parama, localFinderItem.getId(), this.rTF.getRecyclerView());
        AppMethodBeat.o(202289);
        return;
      }
    }
    label838:
    AppMethodBeat.o(202289);
  }
  
  public final boolean cAS()
  {
    return this.saE;
  }
  
  public final void cAT() {}
  
  public final void cBR()
  {
    AppMethodBeat.i(202298);
    if (this.saC != null)
    {
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      View localView = this.saC;
      if (localView == null) {
        d.g.b.p.gfZ();
      }
      localWxRecyclerAdapter.M(localView.hashCode(), true);
    }
    AppMethodBeat.o(202298);
  }
  
  public final boolean d(e parame)
  {
    AppMethodBeat.i(202288);
    d.g.b.p.h(parame, "holder");
    if (parame.lQ() != this.saD)
    {
      if (parame.getTag() != null)
      {
        parame = parame.getTag();
        ah.a locala = ah.rPf;
        if (!d.g.b.p.i(parame, Integer.valueOf(ah.czc()))) {}
      }
    }
    else
    {
      AppMethodBeat.o(202288);
      return true;
    }
    AppMethodBeat.o(202288);
    return false;
  }
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202294);
    d.g.b.p.h(paramc, "reason");
    AppMethodBeat.o(202294);
    return null;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(202290);
    d.g.b.p.h(paramContext, "context");
    paramContext = cAR().eL(paramContext);
    AppMethodBeat.o(202290);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202295);
    d.g.b.p.h(paramc, "reason");
    AppMethodBeat.o(202295);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202292);
    View localView = this.fLP.findViewById(2131299478);
    AppMethodBeat.o(202292);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(202293);
    View localView = View.inflate((Context)this.fLP, 2131494118, null);
    d.g.b.p.g(localView, "View.inflate(context, R.…_topic_feed_header, null)");
    this.saB = localView;
    localView = this.saB;
    if (localView == null) {
      d.g.b.p.bcb("topicHeader");
    }
    localView = localView.findViewById(2131306038);
    d.g.b.p.g(localView, "topicHeader.findViewById<TextView>(R.id.topic_tv)");
    ((TextView)localView).setText((CharSequence)k.c((Context)this.fLP, (CharSequence)this.dzZ));
    switch (this.type)
    {
    }
    for (;;)
    {
      localView = this.saB;
      if (localView == null) {
        d.g.b.p.bcb("topicHeader");
      }
      AppMethodBeat.o(202293);
      return localView;
      localView = this.saB;
      if (localView == null) {
        d.g.b.p.bcb("topicHeader");
      }
      ((ImageView)localView.findViewById(2131306026)).setImageResource(2131690589);
      localView = this.saB;
      if (localView == null) {
        d.g.b.p.bcb("topicHeader");
      }
      localView = localView.findViewById(2131306027);
      d.g.b.p.g(localView, "topicHeader.findViewById…w>(R.id.topic_icon_right)");
      ((ImageView)localView).setVisibility(8);
    }
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202291);
    RecyclerView.h localh = cAR().getItemDecoration();
    AppMethodBeat.o(202291);
    return localh;
  }
  
  /* Error */
  public final void lU(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 580
    //   5: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 117	com/tencent/mm/plugin/finder/feed/ap$b:TAG	Ljava/lang/String;
    //   12: ldc_w 582
    //   15: iload_1
    //   16: invokestatic 585	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   19: invokevirtual 408	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iload_1
    //   26: ifeq +16 -> 42
    //   29: aload_0
    //   30: invokespecial 587	com/tencent/mm/plugin/finder/feed/ap$b:cBQ	()V
    //   33: ldc_w 580
    //   36: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: invokevirtual 589	com/tencent/mm/plugin/finder/feed/ap$b:cBR	()V
    //   46: ldc_w 580
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshSubTile$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$1"})
  static final class a
    implements View.OnClickListener
  {
    a(aoy paramaoy, byte[] paramArrayOfByte, ap.b paramb, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202287);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshSubTile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      com.tencent.mm.plugin.finder.utils.p.a((Context)this.saH.fLP, this.saF);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshSubTile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ap.b
 * JD-Core Version:    0.7.0.1
 */