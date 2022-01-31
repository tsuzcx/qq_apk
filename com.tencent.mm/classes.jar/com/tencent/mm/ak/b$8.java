package com.tencent.mm.ak;

import com.tencent.mm.j.d;
import com.tencent.mm.j.f;
import com.tencent.mm.j.f.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$8
  implements Runnable
{
  b$8(b paramb, String paramString, d paramd) {}
  
  public final void run()
  {
    f localf = (f)this.eiN.eiI.get(this.BF);
    if (localf == null) {
      y.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { this.BF });
    }
    while (localf.dmc == null) {
      return;
    }
    localf.dmc.a(this.BF, this.eiR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ak.b.8
 * JD-Core Version:    0.7.0.1
 */