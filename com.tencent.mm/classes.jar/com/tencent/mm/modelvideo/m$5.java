package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class m$5
  implements Runnable
{
  public m$5(m paramm, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(50741);
    synchronized (m.a(this.fWE))
    {
      Object localObject2 = (String)m.b(this.fWE).get(Long.valueOf(this.fWD));
      ab.i("MicroMsg.SightMassSendService", "cancel item, massSendId %d, cdnClientId %s", new Object[] { Long.valueOf(this.fWD), localObject2 });
      if ("done_upload_cdn_client_id".equals(localObject2))
      {
        ab.w("MicroMsg.SightMassSendService", "doing mass send cgi, ignore cancel!");
        AppMethodBeat.o(50741);
        return;
      }
      if (!bo.isNullOrNil((String)localObject2))
      {
        m.b(this.fWE).put(Long.valueOf(this.fWD), "");
        f.afO().sI((String)localObject2);
        this.fWE.d(this.fWD, 0, 0);
      }
      localObject2 = o.alE();
      long l = this.fWD;
      if (((t)localObject2).fnw.delete("videoinfo2", "masssendid= ?", new String[] { String.valueOf(l) }) > 0)
      {
        t.a.a locala = new t.a.a("DELETE_".concat(String.valueOf(l)), t.a.b.fXQ, t.a.c.fXT, 3, l);
        ((t)localObject2).frK.cy(locala);
        ((t)localObject2).frK.doNotify();
      }
      AppMethodBeat.o(50741);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.5
 * JD-Core Version:    0.7.0.1
 */