package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.cgi.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.aj.a;
import com.tencent.mm.plugin.finder.live.report.s.ai;
import com.tencent.mm.plugin.finder.live.view.adapter.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "searchAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;", "getSearchAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;", "setSearchAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;)V", "addMusic", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "back", "canAddMusic", "", "canLoadMore", "lastVisiblePosition", "", "hide", "hideView", "loadMoreData", "loadAll", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "incrementSize", "onAttach", "onDetach", "search", "content", "searchInput", "showSearchView", "updateSearchView", "plugin-finder_release"})
public final class f
  implements e.a
{
  private final String TAG;
  final Context context;
  private final com.tencent.mm.live.c.b kCL;
  final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private e.b xZb;
  private g xZc;
  
  public f(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.c.b paramb)
  {
    AppMethodBeat.i(290006);
    this.context = paramContext;
    this.xYp = parama;
    this.kCL = paramb;
    this.TAG = "FinderLiveAnchorSearchMusicPresenter";
    AppMethodBeat.o(290006);
  }
  
  public final boolean Nb(int paramInt)
  {
    AppMethodBeat.i(290005);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydm > 0)
    {
      AppMethodBeat.o(290005);
      return true;
    }
    AppMethodBeat.o(290005);
    return false;
  }
  
  public final void a(aq paramaq)
  {
    AppMethodBeat.i(289996);
    p.k(paramaq, "musicItem");
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
    p.k(paramaq, "item");
    ((com.tencent.mm.plugin.finder.live.model.b)localObject).ydi.add(0, paramaq);
    ((com.tencent.mm.plugin.finder.live.model.b)localObject).ydh.add(0, Integer.valueOf(paramaq.yin.SMT));
    if (((com.tencent.mm.plugin.finder.live.model.b)localObject).fFw >= 0) {
      ((com.tencent.mm.plugin.finder.live.model.b)localObject).fFw += 1;
    }
    Log.i("FinderLiveAnchorMusicData", "addMusicItem " + paramaq + ", songId size:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject).ydh.size() + ", musicList id size:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject).ydi.size() + ", index:0, curPlayPos:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject).fFw);
    localObject = this.kCL;
    b.c localc = b.c.kAr;
    Bundle localBundle = new Bundle();
    localBundle.putInt("PARAM_FINDER_LIVE_MUSIC_ID", paramaq.yin.SMT);
    ((com.tencent.mm.live.c.b)localObject).statusChange(localc, localBundle);
    localObject = com.tencent.mm.plugin.finder.live.ui.a.yOj;
    com.tencent.mm.plugin.finder.live.ui.a.a(((c)this.xYp.business(c.class)).liveInfo.liveId, ((c)this.xYp.business(c.class)).kvN, z.bdh(), ((c)this.xYp.business(c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxQ());
    localObject = x.ych;
    x.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yIH.action, paramaq.yin.SMT);
    AppMethodBeat.o(289996);
  }
  
  public final void a(boolean paramBoolean, final kotlin.g.a.b<? super Integer, kotlin.x> paramb)
  {
    AppMethodBeat.i(290004);
    p.k(paramb, "callback");
    Object localObject = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydk;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramb.invoke(Integer.valueOf(0));
      AppMethodBeat.o(290004);
      return;
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydm = 0;
    paramb = new aj(((c)this.xYp.business(c.class)).liveInfo.liveId, ((c)this.xYp.business(c.class)).kvN, z.bdh(), ((c)this.xYp.business(c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydl, (aj.a)new a(this, paramb)).bhW();
    localObject = this.context;
    if (localObject == null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(290004);
      throw paramb;
    }
    paramb.a((com.tencent.mm.vending.e.b)localObject);
    AppMethodBeat.o(290004);
  }
  
  public final void aBP(final String paramString)
  {
    AppMethodBeat.i(289997);
    p.k(paramString, "content");
    if (p.h(paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydk))
    {
      Log.i(this.TAG, "have search content:" + paramString + '!');
      AppMethodBeat.o(289997);
      return;
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydm = 0;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydl = null;
    paramString = new aj(((c)this.xYp.business(c.class)).liveInfo.liveId, ((c)this.xYp.business(c.class)).kvN, z.bdh(), ((c)this.xYp.business(c.class)).xbk, paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydl, (aj.a)new b(this, paramString)).bhW();
    Context localContext = this.context;
    if (localContext == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(289997);
      throw paramString;
    }
    paramString.a((com.tencent.mm.vending.e.b)localContext);
    AppMethodBeat.o(289997);
  }
  
  public final void ckA()
  {
    AppMethodBeat.i(289998);
    b.b.a(this.kCL, b.c.kAp);
    AppMethodBeat.o(289998);
  }
  
  public final void dwW()
  {
    AppMethodBeat.i(289994);
    e.b localb = this.xZb;
    if (localb != null)
    {
      localb.dwW();
      AppMethodBeat.o(289994);
      return;
    }
    AppMethodBeat.o(289994);
  }
  
  public final void dxc()
  {
    AppMethodBeat.i(289995);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydj;
    Object localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, "updateSearchView, searchData:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(289995);
      return;
    }
    localObject2 = this.xZb;
    if (localObject2 != null) {
      ((e.b)localObject2).ek((List)localObject1);
    }
    localObject2 = this.xZc;
    if (localObject2 != null)
    {
      localObject1 = (List)localObject1;
      p.k(localObject1, "suggests");
      ((g)localObject2).mXB.clear();
      ((g)localObject2).mXB.addAll((Collection)localObject1);
      ((g)localObject2).notifyDataSetChanged();
      AppMethodBeat.o(289995);
      return;
    }
    AppMethodBeat.o(289995);
  }
  
  public final void dxd()
  {
    AppMethodBeat.i(290000);
    b.b.a(this.kCL, b.c.kAt);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydj.clear();
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
    p.k("", "<set-?>");
    ((com.tencent.mm.plugin.finder.live.model.b)localObject).ydk = "";
    localObject = this.xZc;
    if (localObject != null)
    {
      localObject = ((g)localObject).mXB;
      if (localObject != null) {
        ((ArrayList)localObject).clear();
      }
    }
    localObject = this.xZc;
    if (localObject != null)
    {
      ((g)localObject).notifyDataSetChanged();
      AppMethodBeat.o(290000);
      return;
    }
    AppMethodBeat.o(290000);
  }
  
  public final boolean dxe()
  {
    AppMethodBeat.i(290001);
    com.tencent.mm.plugin.finder.live.model.b localb = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
    boolean bool = true;
    if (localb.ydh.size() >= localb.yde) {
      bool = false;
    }
    Log.i("FinderLiveAnchorMusicData", "songId size:" + localb.ydh.size() + ", musicList id size:" + localb.ydi.size() + ", canAddMusic :" + bool);
    AppMethodBeat.o(290001);
    return bool;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(289999);
    b.b.a(this.kCL, b.c.kAq);
    AppMethodBeat.o(289999);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(290003);
    Log.i(this.TAG, "onDetach");
    AppMethodBeat.o(290003);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicPresenter$loadMoreData$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "plugin-finder_release"})
  public static final class a
    implements aj.a
  {
    a(kotlin.g.a.b paramb) {}
    
    public final void a(int paramInt, final bcl parambcl)
    {
      AppMethodBeat.i(273883);
      p.k(parambcl, "resp");
      d.uiThread((kotlin.g.a.a)new a(this, parambcl));
      AppMethodBeat.o(273883);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(f.a parama, bcl parambcl)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicPresenter$search$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "plugin-finder_release"})
  public static final class b
    implements aj.a
  {
    b(String paramString) {}
    
    public final void a(final int paramInt, final bcl parambcl)
    {
      AppMethodBeat.i(280292);
      p.k(parambcl, "resp");
      d.uiThread((kotlin.g.a.a)new a(this, paramInt, parambcl));
      AppMethodBeat.o(280292);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(f.b paramb, int paramInt, bcl parambcl)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.f
 * JD-Core Version:    0.7.0.1
 */