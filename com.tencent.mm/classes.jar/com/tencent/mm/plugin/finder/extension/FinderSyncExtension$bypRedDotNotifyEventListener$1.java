package com.tencent.mm.plugin.finder.extension;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.bb;
import com.tencent.mm.autogen.a.bb.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/extension/FinderSyncExtension$bypRedDotNotifyEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNotifyActionEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSyncExtension$bypRedDotNotifyEventListener$1
  extends IListener<bb>
{
  FinderSyncExtension$bypRedDotNotifyEventListener$1(c paramc, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(366625);
    AppMethodBeat.o(366625);
  }
  
  private boolean a(bb parambb)
  {
    AppMethodBeat.i(366636);
    s.u(parambb, "event");
    localObject1 = this.APu;
    try
    {
      Object localObject2 = Result.Companion;
      if (parambb.hAZ.hBa == 4L)
      {
        Log.i(c.access$getTAG$cp(), "notify from bypFinder");
        localObject2 = new ts();
        ((ts)localObject2).parseFrom(parambb.hAZ.data);
        int i = ((ts)localObject2).Tps;
        parambb = c.a.APo;
        if (i == c.a.dYX())
        {
          parambb = new tr();
          parambb.parseFrom(((ts)localObject2).YZn.toByteArray());
          ((c)localObject1).a((int)parambb.YyK, 11, null);
        }
      }
      parambb = Result.constructor-impl(ah.aiuX);
    }
    finally
    {
      for (;;)
      {
        localObject1 = Result.Companion;
        parambb = Result.constructor-impl(ResultKt.createFailure(parambb));
      }
    }
    parambb = Result.exceptionOrNull-impl(parambb);
    if (parambb != null) {
      Log.printErrStackTrace(c.access$getTAG$cp(), parambb, "", new Object[0]);
    }
    AppMethodBeat.o(366636);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.FinderSyncExtension.bypRedDotNotifyEventListener.1
 * JD-Core Version:    0.7.0.1
 */