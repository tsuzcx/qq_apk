package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import java.util.ArrayList;

final class PluginBrandService$3$1
  implements Runnable
{
  PluginBrandService$3$1(PluginBrandService.3 param3, h.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(152625);
    int i;
    if ((("insert".equals(this.jSF.oDP)) || ("update".equals(this.jSF.oDP))) && (this.jSF.oDQ != null))
    {
      i = 0;
      while (i < this.jSF.oDQ.size())
      {
        bi localbi = (bi)this.jSF.oDQ.get(i);
        if (localbi.field_isSend != 1) {
          s.an(localbi);
        }
        i += 1;
      }
      AppMethodBeat.o(152625);
      return;
    }
    if (("delete".equals(this.jSF.oDP)) && (this.jSF.oDQ != null))
    {
      i = 0;
      while (i < this.jSF.oDQ.size())
      {
        s.ao((bi)this.jSF.oDQ.get(i));
        i += 1;
      }
    }
    AppMethodBeat.o(152625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.3.1
 * JD-Core Version:    0.7.0.1
 */