package com.tencent.mm.ak;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  extends ah
{
  f$2(f paramf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {}
    while (f.a(this.ejz) == 0L) {
      return;
    }
    int i = paramMessage.arg1;
    y.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(f.a(this.ejz)), Long.valueOf(bk.co(f.a(this.ejz))) });
    g.Dk().a(new d(i), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ak.f.2
 * JD-Core Version:    0.7.0.1
 */