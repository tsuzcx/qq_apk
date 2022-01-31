package com.tencent.mm.plugin.honey_pay.model;

import android.graphics.Color;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.bmi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.LinkedList;

final class c$2$1
  implements n.c
{
  c$2$1(c.2 param2) {}
  
  public final void a(l paraml)
  {
    Iterator localIterator = this.lka.ljW.tFJ.iterator();
    int i = 0;
    awm localawm;
    if (localIterator.hasNext())
    {
      localawm = (awm)localIterator.next();
      if (bk.bl(localawm.iet)) {
        break label99;
      }
      if (!bk.bl(localawm.color))
      {
        paraml.a(i, Color.parseColor(localawm.color), localawm.iet);
        label77:
        i += 1;
      }
    }
    label99:
    for (;;)
    {
      break;
      paraml.e(i, localawm.iet);
      break label77;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c.2.1
 * JD-Core Version:    0.7.0.1
 */