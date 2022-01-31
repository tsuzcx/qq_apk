package com.tencent.mm.plugin.ext.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ext.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.LinkedList;

final class c$1
  implements com.tencent.mm.ai.f
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20298);
    aw.Rc().b(106, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
      paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bPI();
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramString.xaS) });
      if (paramString.xaS > 0)
      {
        if (paramString.xaT.isEmpty())
        {
          ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
          c.a(this.mdP, paramString);
        }
        if (paramString.xaT.size() > 1) {
          try
          {
            paramm = new Intent();
            paramm.putExtra("add_more_friend_search_scene", 3);
            paramm.putExtra("result", paramString.toByteArray());
            ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
            a.gmO.t(paramm, c.a(this.mdP));
            AppMethodBeat.o(20298);
            return;
          }
          catch (IOException paramString)
          {
            ab.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", paramString, "", new Object[0]);
            AppMethodBeat.o(20298);
            return;
          }
        }
        c.a(this.mdP, (bxf)paramString.xaT.getFirst());
        AppMethodBeat.o(20298);
        return;
      }
      ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
      c.b(this.mdP, paramString);
      AppMethodBeat.o(20298);
      return;
    }
    ab.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.a(this.mdP, null);
    AppMethodBeat.o(20298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.c.1
 * JD-Core Version:    0.7.0.1
 */