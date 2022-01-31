package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

final class b$1
  implements k.a
{
  b$1(b paramb) {}
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(130065);
    ab.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame storage change: event=%s | eventData=%s", new Object[] { paramString, paramm });
    switch (paramm.htj)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130065);
      return;
      if ("batch".equals(paramString))
      {
        if ((paramm.obj != null) && ((paramm.obj instanceof List)))
        {
          paramString = (List)paramm.obj;
          this.hsB.ezf.a(65601, new b.b(this.hsB, paramString));
          AppMethodBeat.o(130065);
        }
      }
      else
      {
        paramString = new ArrayList();
        paramString.add(paramm.obj.toString());
        this.hsB.ezf.a(65601, new b.b(this.hsB, paramString));
        AppMethodBeat.o(130065);
        return;
        if ("batch".equals(paramString))
        {
          if ((paramm.obj != null) && ((paramm.obj instanceof List)))
          {
            paramString = (List)paramm.obj;
            this.hsB.ezf.a(65601, new b.a(this.hsB, paramString));
            AppMethodBeat.o(130065);
          }
        }
        else
        {
          paramString = new ArrayList();
          paramString.add(paramm.obj.toString());
          this.hsB.ezf.a(65601, new b.a(this.hsB, paramString));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b.1
 * JD-Core Version:    0.7.0.1
 */