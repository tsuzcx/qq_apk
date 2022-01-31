package com.tencent.mm.al;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class f$2
  extends ak
{
  f$2(f paramf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(78075);
    if (paramMessage.what != 1)
    {
      AppMethodBeat.o(78075);
      return;
    }
    if (f.a(this.fzD) == 0L)
    {
      AppMethodBeat.o(78075);
      return;
    }
    int i = paramMessage.arg1;
    ab.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(f.a(this.fzD)), Long.valueOf(bo.hl(f.a(this.fzD))) });
    g.Rc().a(new d(i), 0);
    AppMethodBeat.o(78075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.f.2
 * JD-Core Version:    0.7.0.1
 */