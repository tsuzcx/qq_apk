package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.game.b.a.a;
import com.tencent.mm.plugin.appbrand.game.b.a.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class i$2
  implements k.a
{
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(130094);
    ab.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandUsage storage change: event=%s | eventData=%s", new Object[] { paramString, paramm });
    switch (paramm.htj)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130094);
      return;
      Object localObject;
      if ("batch".equals(paramString))
      {
        if ((paramm.obj != null) && ((paramm.obj instanceof List)))
        {
          paramm = (List)paramm.obj;
          paramString = new ArrayList();
          paramm = paramm.iterator();
          while (paramm.hasNext())
          {
            localObject = i.Bx((String)paramm.next());
            if (localObject != null) {
              paramString.add(i.b((AppBrandRecentTaskInfo)localObject));
            }
          }
          g.auS().b(paramString, true);
          AppMethodBeat.o(130094);
        }
      }
      else
      {
        paramString = i.Bx(paramm.obj.toString());
        if (paramString == null)
        {
          AppMethodBeat.o(130094);
          return;
        }
        paramString = i.b(paramString);
        g.auS().a(paramString, true);
        AppMethodBeat.o(130094);
        return;
        if ("batch".equals(paramString))
        {
          if ((paramm.obj != null) && ((paramm.obj instanceof List)))
          {
            paramm = (List)paramm.obj;
            paramString = new ArrayList();
            paramm = paramm.iterator();
            while (paramm.hasNext())
            {
              localObject = i.Bx((String)paramm.next());
              if (localObject != null)
              {
                localObject = i.b((AppBrandRecentTaskInfo)localObject);
                if (localObject != null) {
                  paramString.add(((a)localObject).ese);
                }
              }
            }
            g.auS().aF(paramString);
            AppMethodBeat.o(130094);
          }
        }
        else {
          g.auS().ag(paramm.obj.toString(), true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.i.2
 * JD-Core Version:    0.7.0.1
 */