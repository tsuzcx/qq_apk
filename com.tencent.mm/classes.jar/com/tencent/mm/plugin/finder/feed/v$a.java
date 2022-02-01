package com.tencent.mm.plugin.finder.feed;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderHotWordFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderHotWordFeedLoader.c;
import com.tencent.mm.plugin.finder.feed.model.FinderHotWordFeedLoader.d;
import com.tencent.mm.plugin.finder.feed.model.FinderHotWordFeedLoader.e;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.k;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderHotWordFeedUIContract$HotWordFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "TAG", "", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "onRequestFinished", "Lkotlin/Function0;", "", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "setOnRequestFinished", "(Lkotlin/jvm/functions/Function0;)V", "topic", "getTopic", "setTopic", "topicRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTopicRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setTopicRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "type", "getType", "()I", "setType", "(I)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "distinctResponseList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "incrementList", "", "getIViewActionCallback", "initViewCallback", "loadMoreData", "requestRefresh", "scrollToTop", "endCallBack", "showNoMoreView", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v$a
  extends c.a
{
  private k AWa;
  private final String TAG;
  private String iconUrl;
  public String topic;
  public int type;
  
  public v$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, 115, paramBaseFinderFeedLoader);
    AppMethodBeat.i(362519);
    this.TAG = "Finder.FinderHotWordFeedUIContract.HotWordFeedPresenter";
    this.topic = "";
    this.iconUrl = "";
    this.AWa = ((k)new k()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(363983);
        Object localObject = this.AWb.ATE;
        if (localObject != null)
        {
          localObject = (k)((c.b)localObject).ATx;
          if (localObject != null) {
            ((k)localObject).onChanged();
          }
        }
        AppMethodBeat.o(363983);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 0;
        AppMethodBeat.i(363988);
        Object localObject1 = this.AWb.ATE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (k)((c.b)localObject1).ATx;
          if (localObject1 != null)
          {
            localObject2 = this.AWb.ATE;
            if (localObject2 != null) {
              break label67;
            }
          }
        }
        for (;;)
        {
          ((k)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(363988);
          return;
          label67:
          localObject2 = ((c.b)localObject2).getAdapter();
          if (localObject2 != null) {
            i = ((i)localObject2).agOb.size();
          }
        }
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        int i = 0;
        AppMethodBeat.i(363994);
        Object localObject1 = this.AWb.ATE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (k)((c.b)localObject1).ATx;
          if (localObject1 != null)
          {
            localObject2 = this.AWb.ATE;
            if (localObject2 != null) {
              break label70;
            }
          }
        }
        for (;;)
        {
          ((k)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          AppMethodBeat.o(363994);
          return;
          label70:
          localObject2 = ((c.b)localObject2).getAdapter();
          if (localObject2 != null) {
            i = ((i)localObject2).agOb.size();
          }
        }
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 0;
        AppMethodBeat.i(364000);
        Object localObject1 = this.AWb.ATE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (k)((c.b)localObject1).ATx;
          if (localObject1 != null)
          {
            localObject2 = this.AWb.ATE;
            if (localObject2 != null) {
              break label67;
            }
          }
        }
        for (;;)
        {
          ((k)localObject1).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(364000);
          return;
          label67:
          localObject2 = ((c.b)localObject2).getAdapter();
          if (localObject2 != null) {
            i = ((i)localObject2).agOb.size();
          }
        }
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 0;
        AppMethodBeat.i(364006);
        Object localObject1 = this.AWb.ATE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (k)((c.b)localObject1).ATx;
          if (localObject1 != null)
          {
            localObject2 = this.AWb.ATE;
            if (localObject2 != null) {
              break label86;
            }
          }
        }
        for (;;)
        {
          ((k)localObject1).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.AWb.ATE;
          if (localObject1 != null) {
            ((c.b)localObject1).dUO();
          }
          AppMethodBeat.o(364006);
          return;
          label86:
          localObject2 = ((c.b)localObject2).getAdapter();
          if (localObject2 != null) {
            i = ((i)localObject2).agOb.size();
          }
        }
      }
      
      public final void onPreFinishLoadMore(final RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363972);
        s.u(paramAnonymousd, "reason");
        Object localObject = this.AWb.ATE;
        if (localObject != null)
        {
          localObject = (k)((c.b)localObject).ATx;
          if (localObject != null) {
            ((k)localObject).onPreFinishLoadMore(paramAnonymousd);
          }
        }
        com.tencent.mm.ae.d.uiThread((a)new a(this.AWb, paramAnonymousd));
        AppMethodBeat.o(363972);
      }
      
      public final void onPreFinishLoadMoreSmooth(final RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363981);
        s.u(paramAnonymousd, "reason");
        Object localObject = this.AWb.ATE;
        if (localObject != null)
        {
          localObject = (k)((c.b)localObject).ATx;
          if (localObject != null) {
            ((k)localObject).onPreFinishLoadMoreSmooth(paramAnonymousd);
          }
        }
        com.tencent.mm.ae.d.uiThread((a)new b(this.AWb, paramAnonymousd));
        AppMethodBeat.o(363981);
      }
      
      public final void onPreFinishRefresh(final RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363965);
        s.u(paramAnonymousd, "reason");
        com.tencent.mm.ae.d.uiThread((a)new c(this.AWb, paramAnonymousd));
        AppMethodBeat.o(363965);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements a<ah>
      {
        a(v.a parama, RefreshLoadMoreLayout.d<Object> paramd)
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends u
        implements a<ah>
      {
        b(v.a parama, RefreshLoadMoreLayout.d<Object> paramd)
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class c
        extends u
        implements a<ah>
      {
        c(v.a parama, RefreshLoadMoreLayout.d<Object> paramd)
        {
          super();
        }
      }
    });
    AppMethodBeat.o(362519);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(362550);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(362550);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(362527);
    Object localObject = this.ATE;
    s.checkNotNull(localObject);
    localObject = ((c.b)localObject).dUN().ech();
    AppMethodBeat.o(362527);
    return localObject;
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(362535);
    c.b localb = this.ATE;
    if (localb != null) {
      localb.ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    AppMethodBeat.o(362535);
  }
  
  public final k ebJ()
  {
    return this.AWa;
  }
  
  public final void i(RefreshLoadMoreLayout.d<Object> paramd)
  {
    Object localObject = null;
    AppMethodBeat.i(362561);
    s.u(paramd, "reason");
    paramd = paramd.extraData;
    if (paramd == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderHotWordFeedLoader.HotWordResponse");
      AppMethodBeat.o(362561);
      throw paramd;
    }
    if (!((FinderHotWordFeedLoader.e)paramd).getHasMore())
    {
      paramd = this.ATE;
      if (paramd == null)
      {
        paramd = localObject;
        if (paramd != null) {
          if (this.ALH.getSize() <= 10) {
            break label205;
          }
        }
      }
      label205:
      for (boolean bool = true;; bool = false)
      {
        paramd.setEnableLoadMore(bool);
        paramd = this.ATE;
        if (paramd != null)
        {
          paramd = paramd.ATx;
          if (paramd != null)
          {
            paramd = paramd.getLoadMoreFooter();
            if (paramd != null)
            {
              paramd = (TextView)paramd.findViewById(e.e.load_more_footer_tip_tv);
              if (paramd != null) {
                paramd.setText(e.h.finder_load_more_no_result_tip);
              }
            }
          }
        }
        paramd = this.ATE;
        if (paramd == null) {
          break label230;
        }
        paramd = paramd.ATx;
        if (paramd == null) {
          break label230;
        }
        paramd = paramd.getLoadMoreFooter();
        if (paramd == null) {
          break label230;
        }
        paramd = (TextView)paramd.findViewById(e.e.load_more_footer_tip_tv);
        if (paramd == null) {
          break label230;
        }
        paramd.setTextColor(this.lzt.getResources().getColor(e.b.FG_2));
        AppMethodBeat.o(362561);
        return;
        paramd = paramd.ATx;
        break;
      }
    }
    paramd = this.ATE;
    if (paramd == null) {}
    for (paramd = null;; paramd = paramd.ATx)
    {
      if (paramd != null) {
        paramd.setEnableLoadMore(true);
      }
      label230:
      AppMethodBeat.o(362561);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(362546);
    FinderHotWordFeedLoader localFinderHotWordFeedLoader = (FinderHotWordFeedLoader)this.ALH;
    Log.i(localFinderHotWordFeedLoader.getTAG(), "requestRefresh");
    Object localObject = (CharSequence)localFinderHotWordFeedLoader.BgC;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label141;
      }
      localObject = localFinderHotWordFeedLoader.BgC;
      if (localObject != null) {
        break label123;
      }
      localObject = null;
    }
    label62:
    for (localObject = new b((byte[])localObject);; localObject = null)
    {
      localObject = new FinderHotWordFeedLoader.c(localFinderHotWordFeedLoader.sceneType, (b)localObject, localFinderHotWordFeedLoader.getContextObj());
      ((FinderHotWordFeedLoader.c)localObject).edT();
      BaseFeedLoader.request$default((BaseFeedLoader)localFinderHotWordFeedLoader, localObject, null, 2, null);
      localFinderHotWordFeedLoader.BgA = ((FinderHotWordFeedLoader.d)localObject);
      AppMethodBeat.o(362546);
      return;
      i = 0;
      break;
      label123:
      localObject = ((String)localObject).getBytes(kotlin.n.d.UTF_8);
      s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.v.a
 * JD-Core Version:    0.7.0.1
 */