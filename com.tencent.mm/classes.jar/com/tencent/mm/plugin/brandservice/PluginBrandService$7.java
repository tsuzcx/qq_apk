package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;

final class PluginBrandService$7
  implements i.a
{
  PluginBrandService$7(PluginBrandService paramPluginBrandService) {}
  
  public final void onNotifyChange(i parami, final i.c paramc)
  {
    AppMethodBeat.i(301473);
    if (CrashReportFactory.isBackupMerge())
    {
      AppMethodBeat.o(301473);
      return;
    }
    if ((parami == null) || (paramc == null))
    {
      AppMethodBeat.o(301473);
      return;
    }
    b.au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(301467);
        int i;
        if ((("insert".equals(paramc.KRm)) || ("update".equals(paramc.KRm))) && (paramc.mZo != null))
        {
          i = 0;
          while (i < paramc.mZo.size())
          {
            cc localcc = (cc)paramc.mZo.get(i);
            if (localcc.field_isSend != 1) {
              ad.bE(localcc);
            }
            i += 1;
          }
          AppMethodBeat.o(301467);
          return;
        }
        if (("delete".equals(paramc.KRm)) && (paramc.mZo != null))
        {
          i = 0;
          while (i < paramc.mZo.size())
          {
            ad.bF((cc)paramc.mZo.get(i));
            i += 1;
          }
        }
        AppMethodBeat.o(301467);
      }
    });
    AppMethodBeat.o(301473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.7
 * JD-Core Version:    0.7.0.1
 */