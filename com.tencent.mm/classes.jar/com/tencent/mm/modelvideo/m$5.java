package com.tencent.mm.modelvideo;

import com.tencent.mm.ak.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m$5
  implements Runnable
{
  public m$5(m paramm, long paramLong) {}
  
  public final void run()
  {
    synchronized (m.a(this.eGO))
    {
      Object localObject2 = (String)m.b(this.eGO).get(Long.valueOf(this.eGN));
      y.i("MicroMsg.SightMassSendService", "cancel item, massSendId %d, cdnClientId %s", new Object[] { Long.valueOf(this.eGN), localObject2 });
      if ("done_upload_cdn_client_id".equals(localObject2))
      {
        y.w("MicroMsg.SightMassSendService", "doing mass send cgi, ignore cancel!");
        return;
      }
      if (!bk.bl((String)localObject2))
      {
        m.b(this.eGO).put(Long.valueOf(this.eGN), "");
        f.Nd().lL((String)localObject2);
        this.eGO.d(this.eGN, 0, 0);
      }
      localObject2 = o.Sr();
      long l = this.eGN;
      if (((t)localObject2).dXo.delete("videoinfo2", "masssendid= ?", new String[] { String.valueOf(l) }) > 0)
      {
        t.a.a locala = new t.a.a("DELETE_" + l, t.a.b.eIa, t.a.c.eId, 3, l);
        ((t)localObject2).ebu.bV(locala);
        ((t)localObject2).ebu.doNotify();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.5
 * JD-Core Version:    0.7.0.1
 */