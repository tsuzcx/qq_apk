package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements am.a
{
  c$1(c paramc) {}
  
  public final boolean tC()
  {
    boolean bool2 = true;
    boolean bool3 = l.fr(ae.getContext());
    String str = c.bD(ae.getContext());
    if (!bk.bl(str)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), str });
      if ((!bool3) || (!bool1))
      {
        c.b(this.eCm).post(new c.1.1(this));
        bool2 = false;
      }
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.1
 * JD-Core Version:    0.7.0.1
 */