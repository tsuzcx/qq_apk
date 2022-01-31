package com.tencent.mm.ak;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$7
  implements Runnable
{
  b$7(b paramb, String paramString, c paramc, d paramd) {}
  
  public final void run()
  {
    int i = 0;
    Object localObject = (com.tencent.mm.j.f)this.eiN.eiI.get(this.BF);
    if (localObject == null)
    {
      y.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { this.BF, Integer.valueOf(this.eiN.hashCode()) });
      h.nFQ.a(594L, 7L, 1L, true);
    }
    long l;
    do
    {
      return;
      if (this.eiQ != null)
      {
        this.eiQ.bUi = this.BF;
        y.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Integer.valueOf(this.eiQ.field_toltalLength), Integer.valueOf(this.eiQ.field_finishedLength), Boolean.valueOf(this.eiQ.field_mtlnotify) });
      }
      if (this.eiR != null) {
        this.eiR.bUi = this.BF;
      }
      if (((com.tencent.mm.j.f)localObject).dlP == null) {
        break;
      }
      l = bk.UY();
    } while ((this.eiR == null) && (this.eiQ != null) && (!this.eiQ.field_mtlnotify) && (aq.getNetWorkType(ae.getContext()) == -1));
    ((com.tencent.mm.j.f)localObject).field_lastProgressCallbackTime = l;
    ((com.tencent.mm.j.f)localObject).dlP.a(this.BF, 0, this.eiQ, this.eiR, ((com.tencent.mm.j.f)localObject).field_onlycheckexist);
    localObject = this.eiQ;
    if ((localObject != null) && (((c)localObject).field_finishedLength != ((c)localObject).field_toltalLength)) {}
    for (;;)
    {
      if (i != 0) {
        this.eiN.eiJ.remove(this.BF);
      }
      if (this.eiR == null) {
        break;
      }
      this.eiN.eiI.remove(this.BF);
      if (this.eiR.field_retCode != -5103011) {
        break;
      }
      y.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
      h.nFQ.a(546L, 4L, 1L, true);
      f.Ne().keep_OnRequestDoGetCdnDnsInfo(999);
      return;
      i = 1;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|callback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ak.b.7
 * JD-Core Version:    0.7.0.1
 */