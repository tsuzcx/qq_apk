package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import java.util.ArrayList;

final class PluginBrandService$3
  implements g.a
{
  PluginBrandService$3(PluginBrandService paramPluginBrandService) {}
  
  public final void a(g paramg, g.c paramc)
  {
    if ((paramg == null) || (paramc == null)) {}
    for (;;)
    {
      return;
      int i;
      if ((("insert".equals(paramc.mdt)) || ("update".equals(paramc.mdt))) && (paramc.mdu != null))
      {
        i = 0;
        while (i < paramc.mdu.size())
        {
          paramg = (bi)paramc.mdu.get(i);
          if (paramg.field_isSend != 1) {
            s.ag(paramg);
          }
          i += 1;
        }
      }
      else if (("delete".equals(paramc.mdt)) && (paramc.mdu != null))
      {
        i = 0;
        while (i < paramc.mdu.size())
        {
          s.ah((bi)paramc.mdu.get(i));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.3
 * JD-Core Version:    0.7.0.1
 */