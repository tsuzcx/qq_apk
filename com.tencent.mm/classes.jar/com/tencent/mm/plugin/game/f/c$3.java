package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.h.a.gw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;

final class c$3
  implements g
{
  c$3(gw paramgw) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    this.lgj.bOG.uC = 2;
    this.lgj.bOG.url = paramString;
    a.udP.m(this.lgj);
    if (paramb == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramb.from;
        if ((paramb.status != 0) || (paramb.bitmap == null)) {
          break;
        }
      } while (i != 2);
      h.nFQ.a(858L, 13L, 1L, false);
      return;
    } while (i != 2);
    h.nFQ.a(858L, 14L, 1L, false);
  }
  
  public final void mv(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c.3
 * JD-Core Version:    0.7.0.1
 */