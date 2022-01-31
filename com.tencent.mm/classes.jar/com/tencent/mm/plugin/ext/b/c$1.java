package com.tencent.mm.plugin.ext.b;

import android.content.Intent;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ext.a;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.LinkedList;

final class c$1
  implements com.tencent.mm.ah.f
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    au.Dk().b(106, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
      paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bhH();
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramString.tcA) });
      if (paramString.tcA > 0)
      {
        if (paramString.tcB.isEmpty())
        {
          y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
          c.a(this.jJL, paramString);
        }
        if (paramString.tcB.size() > 1) {
          try
          {
            paramm = new Intent();
            paramm.putExtra("add_more_friend_search_scene", 3);
            paramm.putExtra("result", paramString.toByteArray());
            y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
            a.eUR.u(paramm, c.a(this.jJL));
            return;
          }
          catch (IOException paramString)
          {
            y.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", paramString, "", new Object[0]);
            return;
          }
        }
        c.a(this.jJL, (bnk)paramString.tcB.getFirst());
        return;
      }
      y.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
      c.b(this.jJL, paramString);
      return;
    }
    y.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.a(this.jJL, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c.1
 * JD-Core Version:    0.7.0.1
 */