package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import java.util.Map;

public class PluginABTest
  extends f
  implements a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(153143);
    ToolsProcessIPCService.a(new ToolsProcessIPCService.a()
    {
      public final boolean ayt()
      {
        int j = 1;
        AppMethodBeat.i(153142);
        Object localObject = a.a.hnM;
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fu("100488");
        if (localObject == null)
        {
          AppMethodBeat.o(153142);
          return false;
        }
        int i;
        if ((((com.tencent.mm.storage.c)localObject).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject).gzz().get("SAFEFLAG"))))
        {
          i = 1;
          if ((!((com.tencent.mm.storage.c)localObject).isValid()) || (!"1".equals(((com.tencent.mm.storage.c)localObject).gzz().get("TURNOFFTOOLMP")))) {
            break label96;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(153142);
          return i & j;
          i = 0;
          break;
          label96:
          j = 0;
        }
      }
    });
    if (paramg.aBb())
    {
      pin(b.bmZ());
      pin(c.bna());
      pin(com.tencent.mm.model.c.c.iHj);
    }
    AppMethodBeat.o(153143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.PluginABTest
 * JD-Core Version:    0.7.0.1
 */