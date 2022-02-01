package com.tencent.mm.plugin.expt.kvdebug;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.a.nk.a;
import com.tencent.mm.booter.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.edge.d.a.1;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Map;
import org.apache.commons.c.i;

class ExptReportService$2
  extends IListener<nk>
{
  ExptReportService$2(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(299455);
    this.__eventId = nk.class.getName().hashCode();
    AppMethodBeat.o(299455);
  }
  
  private boolean a(nk paramnk)
  {
    AppMethodBeat.i(299464);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(299464);
      return false;
    }
    if ((paramnk == null) || (paramnk.hPM == null))
    {
      AppMethodBeat.o(299464);
      return false;
    }
    com.tencent.mm.plugin.expt.edge.d.a locala = com.tencent.mm.plugin.expt.edge.a.dHT().zxY;
    String str = paramnk.hPM.content;
    int i = (int)paramnk.hPM.hPN;
    if ((com.tencent.mm.plugin.expt.edge.b.dHV()) && (com.tencent.mm.plugin.expt.edge.config.b.dIg().zyC.containsKey(String.valueOf(i))))
    {
      if ((i > 0) && (!i.hm(str))) {
        break label241;
      }
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendKV data or reportID isEmpty!");
    }
    for (;;)
    {
      try
      {
        if (a.dMN() == null)
        {
          a.q(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).lsS.Ck(".com.tencent.mm.auto.test.ilogs.http.report"));
          if (a.dMN() == null) {
            a.q(Boolean.FALSE);
          }
        }
        bool = com.tencent.mm.plugin.expt.model.a.dMQ().a(c.a.zqk, false);
        if (a.dMN() == null) {
          continue;
        }
        if (a.dMN().booleanValue()) {}
      }
      catch (Exception localException)
      {
        boolean bool;
        label241:
        long l;
        continue;
        if (!bool) {
          continue;
        }
        continue;
      }
      com.tencent.mm.plugin.expt.c.a.bm((int)paramnk.hPM.hPN, paramnk.hPM.content);
      a.a(this.zLS, paramnk.hPM.hPN, paramnk.hPM.content);
      a.b(this.zLS, paramnk.hPM.hPN, paramnk.hPM.content);
      AppMethodBeat.o(299464);
      return false;
      com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendKV reportID : " + i + ", data : " + str);
      l = System.currentTimeMillis();
      locala.zzP.post(new a.1(locala, i, l, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.kvdebug.ExptReportService.2
 * JD-Core Version:    0.7.0.1
 */