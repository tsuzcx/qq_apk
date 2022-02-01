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
public final class g$d
  implements Runnable
{
  public g$d(z paramz, List paramList, f.c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(265357);
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new a(this));
    AppMethodBeat.o(265357);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
  public static final class a
    implements MessageQueue.IdleHandler
  {
    public a(g.d paramd) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(262408);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      int i = af.bjB().Uz(this.sBY.sAV.field_orderFlag);
      Object localObject;
      if (i < 0)
      {
        Log.d("MicroMsg.BizTimeLineResortHelper", "onOftenReadClick maxWeight < 0");
        localObject = ad.Vfe;
        ad.asu(48);
      }
      for (;;)
      {
        AppMethodBeat.o(262408);
        return false;
        localObject = ad.Vfe;
        ad.asu(37);
        localObject = g.sBS;
        localObject = g.a(0, this.sBY.khi, this.sBY.sBU, -1, 4);
        ((or)localObject).RWO = this.sBY.mtC;
        ((or)localObject).RWP = i;
        ad localad = ad.Vfe;
        ad.a(4, (or)localObject, this.sBY.sAV.field_orderFlag);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g.d
 * JD-Core Version:    0.7.0.1
 */