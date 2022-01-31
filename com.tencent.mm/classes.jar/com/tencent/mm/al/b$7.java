package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class b$7
  implements Runnable
{
  b$7(b paramb, String paramString, c paramc, d paramd) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(78040);
    Object localObject = (g)this.fyR.fyM.get(this.Cq);
    if (localObject == null)
    {
      ab.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { this.Cq, Integer.valueOf(this.fyR.hashCode()) });
      h.qsU.idkeyStat(594L, 7L, 1L, true);
      AppMethodBeat.o(78040);
      return;
    }
    if (this.fyU != null)
    {
      this.fyU.cBO = this.Cq;
      ab.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Integer.valueOf(this.fyU.field_toltalLength), Integer.valueOf(this.fyU.field_finishedLength), Boolean.valueOf(this.fyU.field_mtlnotify) });
    }
    if (this.fyV != null) {
      this.fyV.cBO = this.Cq;
    }
    if (((g)localObject).edp != null)
    {
      long l = bo.aoy();
      if ((this.fyV == null) && (this.fyU != null) && (!this.fyU.field_mtlnotify) && (at.getNetWorkType(ah.getContext()) == -1))
      {
        AppMethodBeat.o(78040);
        return;
      }
      ((g)localObject).field_lastProgressCallbackTime = l;
      ((g)localObject).edp.a(this.Cq, 0, this.fyU, this.fyV, ((g)localObject).field_onlycheckexist);
    }
    if ((localObject instanceof com.tencent.mm.i.f)) {}
    for (localObject = (com.tencent.mm.i.f)localObject;; localObject = null)
    {
      c localc = this.fyU;
      if ((localc != null) && (localc.field_finishedLength != localc.field_toltalLength)) {}
      for (;;)
      {
        if ((i != 0) && ((localObject == null) || (((com.tencent.mm.i.f)localObject).Jo()))) {
          this.fyR.fyN.remove(this.Cq);
        }
        if (this.fyV != null)
        {
          if ((localObject == null) || (((com.tencent.mm.i.f)localObject).Jo())) {
            this.fyR.fyM.remove(this.Cq);
          }
          if (this.fyV.field_retCode == -5103011)
          {
            ab.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
            h.qsU.idkeyStat(546L, 4L, 1L, true);
            f.afP().keep_OnRequestDoGetCdnDnsInfo(999);
          }
        }
        AppMethodBeat.o(78040);
        return;
        i = 1;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78041);
    String str = super.toString() + "|callback";
    AppMethodBeat.o(78041);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.b.7
 * JD-Core Version:    0.7.0.1
 */