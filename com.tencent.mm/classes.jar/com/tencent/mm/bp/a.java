package com.tencent.mm.bp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  public static boolean eJP()
  {
    AppMethodBeat.i(89923);
    String str2 = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableStrangerChat");
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = "0";
    }
    boolean bool = "1".equals(str1);
    AppMethodBeat.o(89923);
    return bool;
  }
  
  public static void hc(Context paramContext)
  {
    AppMethodBeat.i(89924);
    if (!eJP())
    {
      g.agP().afT();
      if (((k)g.ab(k.class)).dco().bQe() > 0)
      {
        d.N(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
        AppMethodBeat.o(89924);
        return;
      }
    }
    d.N(paramContext, "nearby", ".ui.NearbyFriendsUI");
    AppMethodBeat.o(89924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bp.a
 * JD-Core Version:    0.7.0.1
 */