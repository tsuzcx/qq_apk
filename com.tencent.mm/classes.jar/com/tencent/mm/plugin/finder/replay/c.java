package com.tencent.mm.plugin.finder.replay;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.plugin.finder.replay.model.d;
import com.tencent.mm.plugin.finder.replay.model.f;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcessGenerator;", "", "replayInstance", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayService;", "config", "Lcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetProcessConfig;", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayService;Lcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetProcessConfig;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getConfig", "()Lcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetProcessConfig;", "defaultLiveMsgOffsetProcess", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcess;", "getDefaultLiveMsgOffsetProcess", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcess;", "defaultLiveMsgOffsetProcess$delegate", "Lkotlin/Lazy;", "msgCallback", "com/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcessGenerator$msgCallback$2$1", "getMsgCallback", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcessGenerator$msgCallback$2$1;", "msgCallback$delegate", "msgProcessCallback", "com/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcessGenerator$msgProcessCallback$2$1", "getMsgProcessCallback", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcessGenerator$msgProcessCallback$2$1;", "msgProcessCallback$delegate", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final f FjP;
  private final j FjQ;
  final j FjR;
  final j FjS;
  final String TAG;
  
  public c(final k paramk, f paramf)
  {
    AppMethodBeat.i(332651);
    this.FjP = paramf;
    this.TAG = "FinderLiveMsgOffsetProcessGenerator";
    this.FjQ = kotlin.k.cm((a)new a(this, paramk));
    this.FjR = kotlin.k.cm((a)new c(paramk));
    this.FjS = kotlin.k.cm((a)new b(paramk, this));
    AppMethodBeat.o(332651);
  }
  
  public final b eLt()
  {
    AppMethodBeat.i(332660);
    b localb = (b)this.FjQ.getValue();
    AppMethodBeat.o(332660);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcess;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<b>
  {
    a(c paramc, k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcessGenerator$msgCallback$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<1>
  {
    b(k paramk, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcessGenerator$msgProcessCallback$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<1>
  {
    c(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.c
 * JD-Core Version:    0.7.0.1
 */