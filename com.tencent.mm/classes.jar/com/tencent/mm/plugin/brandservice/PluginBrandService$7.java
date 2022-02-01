package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;

final class PluginBrandService$7
  implements i.a
{
  PluginBrandService$7(PluginBrandService paramPluginBrandService) {}
  
  public final void onNotifyChange(i parami, final i.c paramc)
  {
    AppMethodBeat.i(258324);
    if (CrashReportFactory.isBackupMerge())
    {
      AppMethodBeat.o(258324);
      return;
    }
    if ((parami == null) || (paramc == null))
    {
      AppMethodBeat.o(258324);
      return;
    }
    b.am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257693);
        int i;
        if ((("insert".equals(paramc.EVM)) || ("update".equals(paramc.EVM))) && (paramc.kvM != null))
        {
          i = 0;
          while (i < paramc.kvM.size())
          {
            ca localca = (ca)paramc.kvM.get(i);
            if (localca.field_isSend != 1) {
              ab.bo(localca);
            }
            i += 1;
          }
          AppMethodBeat.o(257693);
          return;
        }
        if (("delete".equals(paramc.EVM)) && (paramc.kvM != null))
        {
          i = 0;
          while (i < paramc.kvM.size())
          {
            ab.bp((ca)paramc.kvM.get(i));
            i += 1;
          }
        }
        AppMethodBeat.o(257693);
      }
    });
    AppMethodBeat.o(258324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.7
 * JD-Core Version:    0.7.0.1
 */