package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements j.a
{
  b$1(b paramb) {}
  
  public final void a(String paramString, l paraml)
  {
    if (paraml == null) {}
    int i;
    long l;
    do
    {
      do
      {
        return;
        i = paraml.gbI;
      } while (paraml.obj == null);
      l = ((Long)paraml.obj).longValue();
    } while (l < 0L);
    y.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "EventData: %s", new Object[] { paraml });
    switch (i)
    {
    case 4: 
    default: 
      return;
    case 2: 
    case 3: 
      this.kap.dBO.a(65576, new b.d(this.kap, l, (byte)0));
      return;
    }
    this.kap.dBO.a(65576, new b.b(this.kap, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.1
 * JD-Core Version:    0.7.0.1
 */