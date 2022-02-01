package com.tencent.mm.bp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  public static boolean fcr()
  {
    AppMethodBeat.i(89923);
    String str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("EnableStrangerChat");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = "0";
    }
    boolean bool = "1".equals(str1);
    AppMethodBeat.o(89923);
    return bool;
  }
  
  public static void hn(Context paramContext)
  {
    AppMethodBeat.i(89924);
    if (!fcr())
    {
      com.tencent.mm.kernel.g.ajP().aiU();
      if (((l)com.tencent.mm.kernel.g.ab(l.class)).doG().bVY() > 0)
      {
        d.Q(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
        AppMethodBeat.o(89924);
        return;
      }
    }
    d.Q(paramContext, "nearby", ".ui.NearbyFriendsUI");
    AppMethodBeat.o(89924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bp.a
 * JD-Core Version:    0.7.0.1
 */