package com.tencent.mm.plugin.calcwx;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cn;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.calcwx.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

class CalcWxService$13
  extends IListener<cn>
{
  CalcWxService$13(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(277799);
    this.__eventId = cn.class.getName().hashCode();
    AppMethodBeat.o(277799);
  }
  
  private boolean diI()
  {
    AppMethodBeat.i(22692);
    Log.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { this.wbs.bNL() });
    a.d(this.wbs, true);
    try
    {
      h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22691);
          h.baE().ban().set(at.a.acTp, Long.valueOf(-1L));
          h.baE().ban().set(at.a.acTo, Long.valueOf(0L));
          h.baE().ban().iZy();
          a.diz().diA().diJ();
          a.d(CalcWxService.13.this.wbs, false);
          AppMethodBeat.o(22691);
        }
      });
      AppMethodBeat.o(22692);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { this.wbs.bNL() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.CalcWxService.13
 * JD-Core Version:    0.7.0.1
 */