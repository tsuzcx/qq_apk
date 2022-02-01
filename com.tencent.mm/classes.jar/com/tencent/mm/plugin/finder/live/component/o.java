package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.model.cgi.as;
import com.tencent.mm.plugin.finder.live.model.cgi.as.a;
import com.tencent.mm.plugin.finder.live.report.q.at;
import com.tencent.mm.plugin.finder.live.view.adapter.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "searchAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;", "getSearchAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;", "setSearchAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;)V", "addMusic", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "back", "canAddMusic", "", "canLoadMore", "lastVisiblePosition", "", "hide", "hideView", "loadMoreData", "loadAll", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "incrementSize", "onAttach", "onDetach", "search", "content", "searchInput", "showSearchView", "updateSearchView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements n.a
{
  final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private n.b Cxn;
  private g Cxo;
  private final String TAG;
  final Context context;
  private final com.tencent.mm.live.b.b nfT;
  
  public o(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(352881);
    this.context = paramContext;
    this.CvU = parama;
    this.nfT = paramb;
    this.TAG = "FinderLiveAnchorSearchMusicPresenter";
    AppMethodBeat.o(352881);
  }
  
  public final boolean OC(int paramInt)
  {
    AppMethodBeat.i(353008);
    if (((e)this.CvU.business(e.class)).Eee.CDL > 0)
    {
      AppMethodBeat.o(353008);
      return true;
    }
    AppMethodBeat.o(353008);
    return false;
  }
  
  public final void a(at paramat)
  {
    AppMethodBeat.i(352924);
    s.u(paramat, "musicItem");
    Object localObject = ((e)this.CvU.business(e.class)).Eee;
    s.u(paramat, "item");
    ((c)localObject).CDH.add(paramat);
    ((c)localObject).CDG.add(Integer.valueOf(paramat.CIu.ZTv));
    Log.i("FinderLiveAnchorMusicData", "addMusicItem " + paramat + ", songId size:" + ((c)localObject).CDG.size() + ", musicList id size:" + ((c)localObject).CDH.size() + ", curPlayPos:" + ((c)localObject).hKr);
    localObject = this.nfT;
    b.c localc = b.c.ndL;
    Bundle localBundle = new Bundle();
    localBundle.putInt("PARAM_FINDER_LIVE_MUSIC_ID", paramat.CIu.ZTv);
    ah localah = ah.aiuX;
    ((com.tencent.mm.live.b.b)localObject).statusChange(localc, localBundle);
    localObject = com.tencent.mm.plugin.finder.live.ui.a.DHB;
    com.tencent.mm.plugin.finder.live.ui.a.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, z.bAW(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)this.CvU.business(e.class)).Eee.ekf());
    localObject = al.CAw;
    al.j(((e)this.CvU.business(e.class)).isLiveStarted(), q.at.Dzz.action, paramat.CIu.ZTv);
    AppMethodBeat.o(352924);
  }
  
  public final void a(boolean paramBoolean, final kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(352999);
    s.u(paramb, "callback");
    CharSequence localCharSequence = (CharSequence)((e)this.CvU.business(e.class)).Eee.CDJ;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramb.invoke(Integer.valueOf(0));
      AppMethodBeat.o(352999);
      return;
    }
    ((e)this.CvU.business(e.class)).Eee.CDL = 0;
    new as(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, z.bAW(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)this.CvU.business(e.class)).Eee.CDJ, ((e)this.CvU.business(e.class)).Eee.CDK, (as.a)new a(this, paramb)).bFJ().a((com.tencent.mm.vending.e.b)this.context);
    AppMethodBeat.o(352999);
  }
  
  public final void awm(final String paramString)
  {
    AppMethodBeat.i(352934);
    s.u(paramString, "content");
    if (s.p(paramString, ((e)this.CvU.business(e.class)).Eee.CDJ))
    {
      Log.i(this.TAG, "have search content:" + paramString + '!');
      AppMethodBeat.o(352934);
      return;
    }
    ((e)this.CvU.business(e.class)).Eee.CDL = 0;
    ((e)this.CvU.business(e.class)).Eee.CDK = null;
    new as(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, z.bAW(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, paramString, ((e)this.CvU.business(e.class)).Eee.CDK, (as.a)new b(this, paramString)).bFJ().a((com.tencent.mm.vending.e.b)this.context);
    AppMethodBeat.o(352934);
  }
  
  public final void cLO()
  {
    AppMethodBeat.i(352942);
    b.b.a(this.nfT, b.c.ndH);
    AppMethodBeat.o(352942);
  }
  
  public final void ehD()
  {
    AppMethodBeat.i(352891);
    n.b localb = this.Cxn;
    if (localb != null) {
      localb.ehD();
    }
    AppMethodBeat.o(352891);
  }
  
  public final void ehJ()
  {
    AppMethodBeat.i(352906);
    Object localObject1 = ((e)this.CvU.business(e.class)).Eee.CDI;
    Object localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, s.X("updateSearchView, searchData:", localObject1));
      AppMethodBeat.o(352906);
      return;
    }
    localObject2 = this.Cxn;
    if (localObject2 != null) {
      ((n.b)localObject2).gm((List)localObject1);
    }
    localObject2 = this.Cxo;
    if (localObject2 != null)
    {
      localObject1 = (List)localObject1;
      s.u(localObject1, "suggests");
      ((g)localObject2).pUj.clear();
      ((g)localObject2).pUj.addAll((Collection)localObject1);
      ((RecyclerView.a)localObject2).bZE.notifyChanged();
    }
    AppMethodBeat.o(352906);
  }
  
  public final void ehK()
  {
    AppMethodBeat.i(352964);
    b.b.a(this.nfT, b.c.ndN);
    ((e)this.CvU.business(e.class)).Eee.CDI.clear();
    Object localObject = ((e)this.CvU.business(e.class)).Eee;
    s.u("", "<set-?>");
    ((c)localObject).CDJ = "";
    localObject = this.Cxo;
    if (localObject != null)
    {
      localObject = ((g)localObject).pUj;
      if (localObject != null) {
        ((ArrayList)localObject).clear();
      }
    }
    localObject = this.Cxo;
    if (localObject != null) {
      ((RecyclerView.a)localObject).bZE.notifyChanged();
    }
    AppMethodBeat.o(352964);
  }
  
  public final boolean ehL()
  {
    AppMethodBeat.i(352976);
    c localc = ((e)this.CvU.business(e.class)).Eee;
    boolean bool = true;
    if (localc.CDG.size() >= localc.CDD) {
      bool = false;
    }
    Log.i("FinderLiveAnchorMusicData", "songId size:" + localc.CDG.size() + ", musicList id size:" + localc.CDH.size() + ", canAddMusic :" + bool);
    AppMethodBeat.o(352976);
    return bool;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(352953);
    b.b.a(this.nfT, b.c.ndI);
    AppMethodBeat.o(352953);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(352986);
    Log.i(this.TAG, "onDetach");
    AppMethodBeat.o(352986);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicPresenter$loadMoreData$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements as.a
  {
    a(o paramo, kotlin.g.a.b<? super Integer, ah> paramb) {}
    
    public final void a(int paramInt, final bmm parambmm)
    {
      AppMethodBeat.i(352845);
      s.u(parambmm, "resp");
      d.uiThread((kotlin.g.a.a)new a(this.Cxp, parambmm, paramb));
      AppMethodBeat.o(352845);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(o paramo, bmm parambmm, kotlin.g.a.b<? super Integer, ah> paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicPresenter$search$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements as.a
  {
    b(o paramo, String paramString) {}
    
    public final void a(int paramInt, final bmm parambmm)
    {
      AppMethodBeat.i(352833);
      s.u(parambmm, "resp");
      d.uiThread((kotlin.g.a.a)new a(paramInt, this.Cxp, paramString, parambmm));
      AppMethodBeat.o(352833);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(int paramInt, o paramo, String paramString, bmm parambmm)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.o
 * JD-Core Version:    0.7.0.1
 */