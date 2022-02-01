package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class g$b
  implements Runnable
{
  g$b(z paramz, int paramInt1, List paramList, f.c paramc, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(264656);
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new a(this));
    AppMethodBeat.o(264656);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
  public static final class a
    implements MessageQueue.IdleHandler
  {
    public a(g.b paramb) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(260629);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      int i = af.bjB().Uz(this.sBW.sAV.field_orderFlag);
      Object localObject;
      if (i < 0)
      {
        Log.d("MicroMsg.BizTimeLineResortHelper", "onClick maxWeight < 0");
        localObject = ad.Vfe;
        ad.asu(47);
      }
      for (;;)
      {
        AppMethodBeat.o(260629);
        return false;
        localObject = ad.Vfe;
        ad.asu(36);
        localObject = g.sBS;
        localObject = g.a(this.sBW.sAW, this.sBW.khi, this.sBW.sBU, this.sBW.sBV, 5);
        ((or)localObject).RWP = i;
        ad localad = ad.Vfe;
        ad.a(5, (or)localObject, this.sBW.sAV.field_orderFlag);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g.b
 * JD-Core Version:    0.7.0.1
 */