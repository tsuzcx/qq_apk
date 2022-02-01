package com.tencent.mm.plugin.finder.live.preloader;

import android.content.Context;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.f.c.a;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.finder.report.av;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.d<-Lcom.tencent.mm.live.core.core.f.a;>;
import kotlin.g.b.s;
import kotlinx.coroutines.al;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/preloader/LiveVisitorCoreFutureTask;", "Lcom/tencent/mm/plugin/datapreloader/FutureTask;", "", "Lcom/tencent/mm/live/core/core/visitor/FinderLiveVisitorPlayCore;", "Lcom/tencent/mm/plugin/finder/live/preloader/LiveVisitorCoreFuture;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "preload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.datapreloader.a<String, com.tencent.mm.live.core.core.f.a, a>
{
  public static final b.a DmV;
  final g mJH;
  
  static
  {
    AppMethodBeat.i(350965);
    DmV = new b.a((byte)0);
    AppMethodBeat.o(350965);
  }
  
  public b(g paramg, al paramal)
  {
    super((kotlin.g.a.a)new b.1(paramg), null, null, paramal, 6);
    AppMethodBeat.i(350949);
    this.mJH = paramg;
    AppMethodBeat.o(350949);
  }
  
  public final Object X(d<? super com.tencent.mm.live.core.core.f.a> paramd)
  {
    AppMethodBeat.i(350978);
    if ((paramd instanceof b.b))
    {
      localObject1 = (b.b)paramd;
      if ((((b.b)localObject1).label & 0x80000000) != 0) {
        ((b.b)localObject1).label += -2147483648;
      }
    }
    Object localObject3;
    for (paramd = (d<? super com.tencent.mm.live.core.core.f.a>)localObject1;; paramd = new b.b(this, paramd))
    {
      localObject1 = paramd.result;
      localObject3 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(350978);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject2 = super.X(paramd);
    Object localObject1 = localObject2;
    paramd = this;
    if (localObject2 == localObject3)
    {
      AppMethodBeat.o(350978);
      return localObject3;
      paramd = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (com.tencent.mm.live.core.core.f.a)localObject1;
    int i;
    if (localObject1 != null)
    {
      localObject2 = (com.tencent.mm.live.core.core.f.c)localObject1;
      localObject3 = MMApplicationContext.getContext();
      s.s(localObject3, "getContext()");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject2 = c.a.a((com.tencent.mm.live.core.core.f.c)localObject2, (Context)localObject3, com.tencent.mm.plugin.finder.live.utils.a.euG());
      if ((localObject2 == null) || (((com.tencent.mm.live.core.core.c.b)localObject2).isPlaying() != true)) {
        break label246;
      }
      i = 1;
      if (i == 0) {
        break label251;
      }
      h.he("has been start before preload");
    }
    for (;;)
    {
      paramd.dtf().nx(false);
      AppMethodBeat.o(350978);
      return localObject1;
      label246:
      i = 0;
      break;
      label251:
      localObject3 = e.h.mKY;
      ((com.tencent.mm.live.core.core.f.a)localObject1).setScene(e.h.bdj());
      ((com.tencent.mm.live.core.core.f.a)localObject1).b(paramd.mJH);
      if (localObject2 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject2).setRenderMode(0);
      }
      if (localObject2 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject2).setMute(true);
      }
      ((com.tencent.mm.live.core.core.f.a)localObject1).d((com.tencent.mm.live.core.core.c)new b.c(paramd));
      localObject2 = av.Fui;
      av.eNT();
      localObject2 = r.Fqi;
      r.tM(true);
      ((com.tencent.mm.live.core.core.f.a)localObject1).a(1, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.preloader.b
 * JD-Core Version:    0.7.0.1
 */