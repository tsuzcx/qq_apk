package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements j.a
{
  b$1(b paramb) {}
  
  public final void a(String paramString, l paraml)
  {
    y.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", new Object[] { paramString, paraml });
    switch (paraml.gbI)
    {
    }
    for (;;)
    {
      return;
      if ("batch".equals(paramString))
      {
        if ((paraml.obj != null) && ((paraml.obj instanceof List)))
        {
          paramString = ((List)paraml.obj).iterator();
          while (paramString.hasNext())
          {
            paraml = (String)paramString.next();
            this.fYv.dBO.a(65616, new b.b(this.fYv, paraml));
          }
        }
      }
      else
      {
        this.fYv.dBO.a(65616, new b.b(this.fYv, paraml.obj.toString()));
        return;
        if (!"batch".equals(paramString)) {
          break;
        }
        if ((paraml.obj != null) && ((paraml.obj instanceof List)))
        {
          paramString = ((List)paraml.obj).iterator();
          while (paramString.hasNext())
          {
            paraml = (String)paramString.next();
            this.fYv.dBO.a(65616, new b.a(this.fYv, paraml));
          }
        }
      }
    }
    this.fYv.dBO.a(65616, new b.a(this.fYv, paraml.obj.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.1
 * JD-Core Version:    0.7.0.1
 */