package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.view.View;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.model.cgi.t.a;
import com.tencent.mm.plugin.finder.live.report.q.at;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloud;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getContext", "()Landroid/content/Context;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "musicAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "getMusicAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "setMusicAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;)V", "canLoadMore", "", "lastVisiblePosition", "", "changeState", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "pos", "deleteMusic", "hide", "hideEditView", "loadMoreData", "loadAll", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "incrementSize", "onAttach", "onDetach", "pauseMusic", "playComplete", "playError", "songId", "playMusic", "forcePlay", "playStart", "resumeMusic", "setMusicVolume", "progress", "showMusicView", "showSearchView", "stopMusic", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements j.a
{
  public static final l.a CwF;
  final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  j.b CwH;
  com.tencent.mm.plugin.finder.live.view.adapter.e CwI;
  private final Context context;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(352974);
    CwF = new l.a((byte)0);
    AppMethodBeat.o(352974);
  }
  
  public l(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(352937);
    this.context = paramContext;
    this.CvU = parama;
    this.nfT = paramb;
    this.CwG = paramb1;
    AppMethodBeat.o(352937);
  }
  
  public final void OA(int paramInt)
  {
    AppMethodBeat.i(353053);
    Object localObject = aj.CGT;
    localObject = aj.elM();
    if (localObject != null)
    {
      Log.i("MicroMsg.LiveCore", s.X("setMusicVolume level:", Integer.valueOf(paramInt)));
      paramInt = kotlin.k.k.qv(kotlin.k.k.qu(paramInt, 0), 100);
      ((com.tencent.mm.live.core.core.trtc.a)localObject).beO().getAudioEffectManager().setAllMusicVolume(paramInt);
    }
    AppMethodBeat.o(353053);
  }
  
  public final void OB(int paramInt)
  {
    AppMethodBeat.i(353087);
    Log.i("FinderLiveAnchorMusicPresenter", s.X("playError songId:", Integer.valueOf(paramInt)));
    r localr = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.OL(paramInt);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.d((at)localr.bsC, ((Number)localr.bsD).intValue());
    d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(353087);
  }
  
  public final boolean OC(int paramInt)
  {
    AppMethodBeat.i(353121);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.CDH.size();
    if ((i < ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.CDG.size()) && (paramInt >= 0) && (paramInt >= i - 25))
    {
      AppMethodBeat.o(353121);
      return true;
    }
    AppMethodBeat.o(353121);
    return false;
  }
  
  public final void a(at paramat, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(353023);
    s.u(paramat, "musicItem");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.ekc();
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      i = paramat.CIu.ZTv;
      if ((localObject1 != null) && (i == ((Integer)localObject1).intValue()))
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.CDH.size() <= 1) {
          break label695;
        }
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.e(paramat, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.hKr);
        if (localObject3 != null) {
          break label652;
        }
        label134:
        if (localObject2 == null)
        {
          localObject2 = aj.CGT;
          localObject2 = aj.elM();
          if (localObject2 != null) {
            ((com.tencent.mm.live.core.core.a.b)localObject2).bfd();
          }
        }
      }
      label159:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee;
      s.u(paramat, "item");
    }
    for (;;)
    {
      try
      {
        localObject3 = ((c)localObject2).CDH.get(paramInt);
        s.s(localObject3, "musicList[index]");
        localObject3 = (at)localObject3;
        localObject4 = ((c)localObject2).CDG.get(paramInt);
        s.s(localObject4, "songIdList[index]");
        int j = ((Number)localObject4).intValue();
        if ((paramat.CIu.ZTv == ((at)localObject3).CIu.ZTv) && (paramat.CIu.ZTv == j))
        {
          ((c)localObject2).CDH.remove(paramInt);
          ((c)localObject2).CDG.remove(paramInt);
          if (((c)localObject2).hKr <= paramInt) {
            continue;
          }
          ((c)localObject2).hKr -= 1;
        }
        Log.i("FinderLiveAnchorMusicData", "deleteMusicItem item:" + paramat + " songId size:" + ((c)localObject2).CDG.size() + ", musicList id size:" + ((c)localObject2).CDH.size() + ", locMusicItem:" + localObject3 + " locSongId:" + j + ", curPlayPos:" + ((c)localObject2).hKr);
      }
      catch (Exception localException)
      {
        Object localObject4;
        label652:
        label695:
        localObject3 = aw.Gjk;
        aw.a(localException, "FinderLiveAnchorMusicData deleteMusicItem");
        continue;
        paramInt = 0;
        continue;
        com.tencent.mm.plugin.finder.live.view.adapter.e locale = this.CwI;
        if (locale == null) {
          continue;
        }
        com.tencent.mm.plugin.finder.live.view.adapter.e.a(locale);
        continue;
      }
      localObject2 = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.CDH;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        continue;
      }
      paramInt = 1;
      if (paramInt == 0) {
        continue;
      }
      localObject2 = this.CwH;
      if (localObject2 != null) {
        ((j.b)localObject2).po(false);
      }
      Log.i("FinderLiveAnchorMusicPresenter", "deleteMusic bgMusicId:" + localObject1 + ", songPlayId:" + i);
      localObject1 = com.tencent.mm.plugin.finder.live.ui.a.DHB;
      com.tencent.mm.plugin.finder.live.ui.a.a(((f)this.CvU.business(f.class)).liveInfo.liveId, ((f)this.CvU.business(f.class)).mZp, z.bAW(), ((f)this.CvU.business(f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.ekf());
      localObject1 = al.CAw;
      al.j(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted(), q.at.DzB.action, paramat.CIu.ZTv);
      AppMethodBeat.o(353023);
      return;
      localObject1 = ((at)localObject1).CIu;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((bkh)localObject1).ZTv);
      break;
      localObject4 = (at)((r)localObject3).bsC;
      if (localObject4 == null) {
        break label134;
      }
      j.a.a.a((j.a)this, (at)localObject4, ((Number)((r)localObject3).bsD).intValue());
      localObject2 = ah.aiuX;
      break label134;
      localObject2 = aj.CGT;
      localObject2 = aj.elM();
      if (localObject2 == null) {
        break label159;
      }
      ((com.tencent.mm.live.core.core.a.b)localObject2).bfd();
      break label159;
      if (((c)localObject2).hKr == paramInt) {
        ((c)localObject2).hKr = -1;
      }
    }
  }
  
  public final void a(at paramat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(353032);
    s.u(paramat, "musicItem");
    Log.i("FinderLiveAnchorMusicPresenter", "playMusic " + paramat + ", forcePlay:" + paramBoolean + ", stack:" + Util.getStack());
    aj.CGT.a(paramat, paramInt, paramBoolean);
    AppMethodBeat.o(353032);
  }
  
  public final void a(boolean paramBoolean, final kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(353111);
    s.u(paramb, "callback");
    LinkedList localLinkedList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.qy(paramBoolean);
    Log.i("FinderLiveAnchorMusicPresenter", "loadMoreData loadAll:" + paramBoolean + " udpateMusicList:" + localLinkedList);
    Object localObject = (Collection)localLinkedList;
    int i;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i == 0) {
        if (this.CwG != null) {
          break label133;
        }
      }
    }
    label133:
    for (localObject = null;; localObject = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant())
    {
      if (localObject != null) {
        break label141;
      }
      paramb.invoke(Integer.valueOf(0));
      AppMethodBeat.o(353111);
      return;
      i = 0;
      break;
    }
    label141:
    if (this.CwG != null)
    {
      localObject = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (localObject != null) {
        ((ap)localObject).a(((f)this.CvU.business(f.class)).liveInfo.liveId, ((f)this.CvU.business(f.class)).mZp, z.bAW(), ((f)this.CvU.business(f.class)).hKN, 1, localLinkedList, (t.a)new b(this, paramb));
      }
    }
    AppMethodBeat.o(353111);
  }
  
  public final void b(at paramat, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(353040);
    s.u(paramat, "musicItem");
    Object localObject1 = aj.CGT;
    com.tencent.mm.live.core.core.a.b localb = aj.elM();
    StringBuilder localStringBuilder;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder("pauseBgMusic path:");
      localObject1 = localb.mRH;
      if (localObject1 != null) {
        break label321;
      }
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", publish:");
      localObject1 = localb.mRH;
      if (localObject1 != null) {
        break label329;
      }
      localObject1 = null;
      label79:
      localStringBuilder = localStringBuilder.append(localObject1).append(", loopCount:");
      localObject1 = localb.mRH;
      if (localObject1 != null) {
        break label340;
      }
    }
    label321:
    label329:
    label340:
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((TXAudioEffectManager.AudioMusicParam)localObject1).loopCount))
    {
      Log.i("MicroMsg.LiveCore", localObject1);
      localObject1 = localb.mRH;
      if (localObject1 != null)
      {
        localb.beO().getAudioEffectManager().pausePlayMusic(((TXAudioEffectManager.AudioMusicParam)localObject1).id);
        localb.mRI = false;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee;
      s.u(paramat, "item");
      if (paramat.oYt == 1) {
        paramat.oYt = 2;
      }
      Log.i("FinderLiveAnchorMusicData", "pauseMusicItem " + paramat + " songId size:" + ((c)localObject1).CDG.size() + ", musicList id size:" + ((c)localObject1).CDH.size() + ", pos:" + paramInt + ", curPlayPos:" + ((c)localObject1).hKr);
      paramat = al.CAw;
      al.j(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted(), q.at.DzG.action, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.ekd());
      AppMethodBeat.o(353040);
      return;
      localObject1 = ((TXAudioEffectManager.AudioMusicParam)localObject1).path;
      break;
      localObject1 = Boolean.valueOf(((TXAudioEffectManager.AudioMusicParam)localObject1).publish);
      break label79;
    }
  }
  
  public final void bLi()
  {
    AppMethodBeat.i(353046);
    Object localObject = aj.CGT;
    localObject = aj.elM();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.a.b)localObject).bfd();
    }
    c.b(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee);
    AppMethodBeat.o(353046);
  }
  
  public final void ehC()
  {
    AppMethodBeat.i(352985);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.CDH;
    Object localObject2 = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.CDG;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = this.CwH;
      if (localObject1 == null) {
        break label195;
      }
      ((j.b)localObject1).po(true);
      AppMethodBeat.o(352985);
      return;
    }
    localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (i = 1; i != 0; i = 0)
    {
      k.a.a((k)this, (kotlin.g.a.b)new h(this));
      localObject1 = this.CwH;
      if (localObject1 == null) {
        break label195;
      }
      ((j.b)localObject1).ehG();
      AppMethodBeat.o(352985);
      return;
    }
    localObject2 = this.CwH;
    if (localObject2 != null) {
      ((j.b)localObject2).gl((List)localObject1);
    }
    localObject1 = this.CwI;
    if (localObject1 != null) {
      com.tencent.mm.plugin.finder.live.view.adapter.e.a((com.tencent.mm.plugin.finder.live.view.adapter.e)localObject1);
    }
    label195:
    AppMethodBeat.o(352985);
  }
  
  public final void ehD()
  {
    AppMethodBeat.i(352993);
    b.b.a(this.nfT, b.c.ndM);
    AppMethodBeat.o(352993);
  }
  
  public final void ehE()
  {
    AppMethodBeat.i(353000);
    j.b localb = this.CwH;
    if (localb != null) {
      localb.ehE();
    }
    AppMethodBeat.o(353000);
  }
  
  public final void ehF()
  {
    AppMethodBeat.i(353066);
    Log.i("FinderLiveAnchorMusicPresenter", "playComplete");
    d.uiThread((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(353066);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(353059);
    b.b.a(this.nfT, b.c.ndI);
    AppMethodBeat.o(353059);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(353095);
    Log.i("FinderLiveAnchorMusicPresenter", "onDetach");
    AppMethodBeat.o(353095);
  }
  
  public final void playStart()
  {
    AppMethodBeat.i(353074);
    Log.i("FinderLiveAnchorMusicPresenter", "playStart");
    d.uiThread((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(353074);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicPresenter$loadMoreData$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements t.a
  {
    b(l paraml, kotlin.g.a.b<? super Integer, ah> paramb) {}
    
    public final void a(int paramInt1, final int paramInt2, final bfr parambfr)
    {
      AppMethodBeat.i(352573);
      s.u(parambfr, "resp");
      d.uiThread((kotlin.g.a.a)new a(paramInt1, paramInt2, this.CwJ, parambfr, paramb));
      AppMethodBeat.o(352573);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(int paramInt1, int paramInt2, l paraml, bfr parambfr, kotlin.g.a.b<? super Integer, ah> paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "newPos", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements q<View, Integer, at, ah>
  {
    c(l paraml, com.tencent.mm.plugin.finder.live.view.adapter.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "newPos", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements q<View, Integer, at, ah>
  {
    d(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    h(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.l
 * JD-Core Version:    0.7.0.1
 */