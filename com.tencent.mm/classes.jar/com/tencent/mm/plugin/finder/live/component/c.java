package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.view.View;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.cgi.r.a;
import com.tencent.mm.plugin.finder.live.report.s.ai;
import com.tencent.mm.plugin.finder.live.view.adapter.e;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloud;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getContext", "()Landroid/content/Context;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "musicAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "getMusicAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "setMusicAdapter", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;)V", "canLoadMore", "", "lastVisiblePosition", "", "changeState", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "pos", "deleteMusic", "hide", "hideEditView", "loadMoreData", "loadAll", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "incrementSize", "onAttach", "onDetach", "pauseMusic", "playComplete", "playMusic", "forcePlay", "playStart", "resumeMusic", "setMusicVolume", "progress", "showMusicView", "showSearchView", "stopMusic", "Companion", "plugin-finder_release"})
public final class c
  implements a.a
{
  public static final a xYr;
  private final Context context;
  private final com.tencent.mm.live.c.b kCL;
  a.b xYn;
  e xYo;
  final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private final com.tencent.mm.plugin.finder.live.plugin.d xYq;
  
  static
  {
    AppMethodBeat.i(277483);
    xYr = new a((byte)0);
    AppMethodBeat.o(277483);
  }
  
  public c(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.c.b paramb, com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(277482);
    this.context = paramContext;
    this.xYp = parama;
    this.kCL = paramb;
    this.xYq = paramd;
    AppMethodBeat.o(277482);
  }
  
  public final void Na(int paramInt)
  {
    AppMethodBeat.i(277472);
    Object localObject = ah.yhC;
    localObject = ah.dzB();
    if (localObject != null)
    {
      Log.i("MicroMsg.LiveCore", "setMusicVolume level:".concat(String.valueOf(paramInt)));
      paramInt = i.ow(i.ov(paramInt, 0), 100);
      ((com.tencent.mm.live.core.core.trtc.a)localObject).knl.getAudioEffectManager().setAllMusicVolume(paramInt);
      AppMethodBeat.o(277472);
      return;
    }
    AppMethodBeat.o(277472);
  }
  
  public final boolean Nb(int paramInt)
  {
    AppMethodBeat.i(277481);
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydi.size();
    if ((i < ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydh.size()) && (paramInt >= 0) && (paramInt >= i - 25))
    {
      AppMethodBeat.o(277481);
      return true;
    }
    AppMethodBeat.o(277481);
    return false;
  }
  
  public final void a(aq paramaq, int paramInt)
  {
    AppMethodBeat.i(277467);
    p.k(paramaq, "musicItem");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxN();
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((aq)localObject1).yin;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((bbg)localObject1).SMT);
        i = paramaq.yin.SMT;
        if ((localObject1 != null) && (i == ((Integer)localObject1).intValue()))
        {
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydi.size() <= 1) {
            break label668;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.d(paramaq, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.fFw);
          localObject3 = (aq)((o)localObject2).Mx;
          if (localObject3 == null) {
            break label645;
          }
          a.a.a.a(this, (aq)localObject3, ((Number)((o)localObject2).My).intValue());
        }
        label177:
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
        p.k(paramaq, "item");
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydi.get(paramInt);
        p.j(localObject3, "musicList[index]");
        localObject3 = (aq)localObject3;
        Object localObject4 = ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydh.get(paramInt);
        p.j(localObject4, "songIdList[index]");
        int j = ((Number)localObject4).intValue();
        if ((paramaq.yin.SMT == ((aq)localObject3).yin.SMT) && (paramaq.yin.SMT == j))
        {
          ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydi.remove(paramInt);
          ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydh.remove(paramInt);
          if (((com.tencent.mm.plugin.finder.live.model.b)localObject2).fFw <= paramInt) {
            continue;
          }
          ((com.tencent.mm.plugin.finder.live.model.b)localObject2).fFw -= 1;
        }
        Log.i("FinderLiveAnchorMusicData", "deleteMusicItem item:" + paramaq + " songId size:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydh.size() + ", musicList id size:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydi.size() + ", locMusicItem:" + localObject3 + " locSongId:" + j + ", curPlayPos:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject2).fFw);
      }
      catch (Exception localException)
      {
        label645:
        label668:
        localObject3 = ak.AGL;
        ak.a(localException, "FinderLiveAnchorMusicData deleteMusicItem");
        continue;
        paramInt = 0;
        continue;
        e locale = this.xYo;
        if (locale == null) {
          continue;
        }
        e.a(locale);
        continue;
      }
      localObject2 = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydi;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        continue;
      }
      paramInt = 1;
      if (paramInt == 0) {
        continue;
      }
      localObject2 = this.xYn;
      if (localObject2 != null) {
        ((a.b)localObject2).nO(false);
      }
      Log.i("FinderLiveAnchorMusicPresenter", "deleteMusic bgMusicId:" + localObject1 + ", songPlayId:" + i);
      localObject1 = com.tencent.mm.plugin.finder.live.ui.a.yOj;
      com.tencent.mm.plugin.finder.live.ui.a.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, z.bdh(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxQ());
      localObject1 = x.ych;
      x.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yIJ.action, paramaq.yin.SMT);
      AppMethodBeat.o(277467);
      return;
      localObject1 = null;
      break;
      localObject2 = ah.yhC;
      localObject2 = ah.dzB();
      if (localObject2 == null) {
        break label177;
      }
      ((com.tencent.mm.live.core.core.a.b)localObject2).aLD();
      break label177;
      localObject2 = ah.yhC;
      localObject2 = ah.dzB();
      if (localObject2 == null) {
        break label177;
      }
      ((com.tencent.mm.live.core.core.a.b)localObject2).aLD();
      break label177;
      if (((com.tencent.mm.plugin.finder.live.model.b)localObject2).fFw == paramInt) {
        ((com.tencent.mm.plugin.finder.live.model.b)localObject2).fFw = -1;
      }
    }
  }
  
  public final void a(aq paramaq, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(277468);
    p.k(paramaq, "musicItem");
    Log.i("FinderLiveAnchorMusicPresenter", "playMusic " + paramaq + ", forcePlay:" + paramBoolean + ", stack:" + Util.getStack());
    ah localah = ah.yhC;
    ah.a(paramaq, paramInt, paramBoolean);
    AppMethodBeat.o(277468);
  }
  
  public final void a(boolean paramBoolean, final kotlin.g.a.b<? super Integer, kotlin.x> paramb)
  {
    AppMethodBeat.i(277480);
    p.k(paramb, "callback");
    LinkedList localLinkedList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.oI(paramBoolean);
    Log.i("FinderLiveAnchorMusicPresenter", "loadMoreData loadAll:" + paramBoolean + " udpateMusicList:" + localLinkedList);
    Object localObject = (Collection)localLinkedList;
    int i;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i == 0) {
        if (this.xYq == null) {
          break label135;
        }
      }
    }
    label135:
    for (localObject = com.tencent.mm.plugin.finder.live.plugin.d.getFinderLiveAssistant();; localObject = null)
    {
      if (localObject != null) {
        break label141;
      }
      paramb.invoke(Integer.valueOf(0));
      AppMethodBeat.o(277480);
      return;
      i = 0;
      break;
    }
    label141:
    if (this.xYq != null)
    {
      localObject = com.tencent.mm.plugin.finder.live.plugin.d.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((an)localObject).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, z.bdh(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, 1, localLinkedList, (r.a)new b(this, paramb));
        AppMethodBeat.o(277480);
        return;
      }
    }
    AppMethodBeat.o(277480);
  }
  
  public final void b(aq paramaq, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(277469);
    p.k(paramaq, "musicItem");
    Object localObject1 = ah.yhC;
    com.tencent.mm.live.core.core.a.b localb = ah.dzB();
    StringBuilder localStringBuilder;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder("pauseBgMusic path:");
      localObject1 = localb.knG;
      if (localObject1 == null) {
        break label341;
      }
      localObject1 = ((TXAudioEffectManager.AudioMusicParam)localObject1).path;
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", publish:");
      localObject1 = localb.knG;
      if (localObject1 == null) {
        break label346;
      }
    }
    label341:
    label346:
    for (localObject1 = Boolean.valueOf(((TXAudioEffectManager.AudioMusicParam)localObject1).publish);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", loopCount:");
      TXAudioEffectManager.AudioMusicParam localAudioMusicParam = localb.knG;
      localObject1 = localObject2;
      if (localAudioMusicParam != null) {
        localObject1 = Integer.valueOf(localAudioMusicParam.loopCount);
      }
      Log.i("MicroMsg.LiveCore", localObject1);
      localObject1 = localb.knG;
      if (localObject1 != null)
      {
        localb.knl.getAudioEffectManager().pausePlayMusic(((TXAudioEffectManager.AudioMusicParam)localObject1).id);
        localb.knH = false;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
      p.k(paramaq, "item");
      if (paramaq.mfx == 1) {
        paramaq.mfx = 2;
      }
      Log.i("FinderLiveAnchorMusicData", "pauseMusicItem " + paramaq + " songId size:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject1).ydh.size() + ", musicList id size:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject1).ydi.size() + ", pos:" + paramInt + ", curPlayPos:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject1).fFw);
      paramaq = x.ych;
      x.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yIO.action, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxO());
      AppMethodBeat.o(277469);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void bnv()
  {
    AppMethodBeat.i(277470);
    Object localObject = ah.yhC;
    localObject = ah.dzB();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.a.b)localObject).aLD();
    }
    com.tencent.mm.plugin.finder.live.model.b.b(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj);
    AppMethodBeat.o(277470);
  }
  
  public final void dwV()
  {
    AppMethodBeat.i(277464);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydi;
    Object localObject2 = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydh;
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    while (i != 0)
    {
      localObject1 = this.xYn;
      if (localObject1 != null)
      {
        ((a.b)localObject1).nO(true);
        AppMethodBeat.o(277464);
        return;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(277464);
        return;
      }
    }
    localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    while (i != 0)
    {
      b.a.a(this, (kotlin.g.a.b)new g(this));
      localObject1 = this.xYn;
      if (localObject1 != null)
      {
        ((a.b)localObject1).dwZ();
        AppMethodBeat.o(277464);
        return;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(277464);
        return;
      }
    }
    localObject2 = this.xYn;
    if (localObject2 != null) {
      ((a.b)localObject2).ej((List)localObject1);
    }
    localObject1 = this.xYo;
    if (localObject1 != null)
    {
      e.a((e)localObject1);
      AppMethodBeat.o(277464);
      return;
    }
    AppMethodBeat.o(277464);
  }
  
  public final void dwW()
  {
    AppMethodBeat.i(277465);
    b.b.a(this.kCL, b.c.kAs);
    AppMethodBeat.o(277465);
  }
  
  public final void dwX()
  {
    AppMethodBeat.i(277466);
    a.b localb = this.xYn;
    if (localb != null)
    {
      localb.dwX();
      AppMethodBeat.o(277466);
      return;
    }
    AppMethodBeat.o(277466);
  }
  
  public final void dwY()
  {
    AppMethodBeat.i(277475);
    Log.i("FinderLiveAnchorMusicPresenter", "playComplete");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(277475);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(277473);
    b.b.a(this.kCL, b.c.kAq);
    AppMethodBeat.o(277473);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(277479);
    Log.i("FinderLiveAnchorMusicPresenter", "onDetach");
    AppMethodBeat.o(277479);
  }
  
  public final void playStart()
  {
    AppMethodBeat.i(277477);
    Log.i("FinderLiveAnchorMusicPresenter", "playStart");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(277477);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicPresenter$loadMoreData$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "plugin-finder_release"})
  public static final class b
    implements r.a
  {
    b(kotlin.g.a.b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final ayq paramayq)
    {
      AppMethodBeat.i(266172);
      p.k(paramayq, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramInt1, paramInt2, paramayq));
      AppMethodBeat.o(266172);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(c.b paramb, int paramInt1, int paramInt2, ayq paramayq)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "newPos", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "invoke", "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicPresenter$onAttach$1$1"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<View, Integer, aq, kotlin.x>
  {
    c(e parame, c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "newPos", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "invoke", "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicPresenter$onAttach$1$2"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.q<View, Integer, aq, kotlin.x>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, kotlin.x>
  {
    g(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.c
 * JD-Core Version:    0.7.0.1
 */