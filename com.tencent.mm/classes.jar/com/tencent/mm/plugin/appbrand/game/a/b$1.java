package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class b$1
  implements j.a
{
  b$1(b paramb) {}
  
  public final void a(String paramString, l paraml)
  {
    y.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame storage change: event=%s | eventData=%s", new Object[] { paramString, paraml });
    switch (paraml.gbI)
    {
    }
    do
    {
      do
      {
        return;
        if (!"batch".equals(paramString)) {
          break;
        }
      } while ((paraml.obj == null) || (!(paraml.obj instanceof List)));
      paramString = (List)paraml.obj;
      this.gaB.dBO.a(65601, new b.b(this.gaB, paramString));
      return;
      paramString = new ArrayList();
      paramString.add(paraml.obj.toString());
      this.gaB.dBO.a(65601, new b.b(this.gaB, paramString));
      return;
      if (!"batch".equals(paramString)) {
        break;
      }
    } while ((paraml.obj == null) || (!(paraml.obj instanceof List)));
    paramString = (List)paraml.obj;
    this.gaB.dBO.a(65601, new b.a(this.gaB, paramString));
    return;
    paramString = new ArrayList();
    paramString.add(paraml.obj.toString());
    this.gaB.dBO.a(65601, new b.a(this.gaB, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.b.1
 * JD-Core Version:    0.7.0.1
 */