package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements k.a
{
  b$1(b paramb) {}
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(129956);
    ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", new Object[] { paramString, paramm });
    switch (paramm.htj)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129956);
      return;
      if ("batch".equals(paramString))
      {
        if ((paramm.obj != null) && ((paramm.obj instanceof List)))
        {
          paramString = ((List)paramm.obj).iterator();
          while (paramString.hasNext())
          {
            paramm = (String)paramString.next();
            this.hrJ.ezf.a(65616, new b.b(this.hrJ, paramm));
          }
          AppMethodBeat.o(129956);
        }
      }
      else
      {
        this.hrJ.ezf.a(65616, new b.b(this.hrJ, paramm.obj.toString()));
        AppMethodBeat.o(129956);
        return;
        if ("batch".equals(paramString))
        {
          if ((paramm.obj != null) && ((paramm.obj instanceof List)))
          {
            paramString = ((List)paramm.obj).iterator();
            while (paramString.hasNext())
            {
              paramm = (String)paramString.next();
              this.hrJ.ezf.a(65616, new b.a(this.hrJ, paramm));
            }
            AppMethodBeat.o(129956);
          }
        }
        else {
          this.hrJ.ezf.a(65616, new b.a(this.hrJ, paramm.obj.toString()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.1
 * JD-Core Version:    0.7.0.1
 */