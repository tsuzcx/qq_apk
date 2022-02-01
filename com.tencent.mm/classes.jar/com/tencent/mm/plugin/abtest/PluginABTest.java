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
      public final boolean adM()
      {
        int j = 1;
        AppMethodBeat.i(153142);
        Object localObject = a.a.gaa;
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.qu("100488");
        if (localObject == null)
        {
          AppMethodBeat.o(153142);
          return false;
        }
        int i;
        if ((((com.tencent.mm.storage.c)localObject).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject).eJy().get("SAFEFLAG"))))
        {
          i = 1;
          if ((!((com.tencent.mm.storage.c)localObject).isValid()) || (!"1".equals(((com.tencent.mm.storage.c)localObject).eJy().get("TURNOFFTOOLMP")))) {
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
    if (paramg.agu())
    {
      pin(b.aHK());
      pin(c.aHL());
      pin(com.tencent.mm.model.c.c.gQv);
    }
    AppMethodBeat.o(153143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.PluginABTest
 * JD-Core Version:    0.7.0.1
 */