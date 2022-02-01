package com.tencent.mm.bq;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static boolean euw()
  {
    AppMethodBeat.i(89923);
    String str2 = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableStrangerChat");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = "0";
    }
    boolean bool = "1".equals(str1);
    AppMethodBeat.o(89923);
    return bool;
  }
  
  public static void gR(Context paramContext)
  {
    AppMethodBeat.i(89924);
    if (!euw())
    {
      g.afz().aeD();
      if (((k)g.ab(k.class)).cOF().bIR() > 0)
      {
        d.O(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
        AppMethodBeat.o(89924);
        return;
      }
    }
    d.O(paramContext, "nearby", ".ui.NearbyFriendsUI");
    AppMethodBeat.o(89924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bq.a
 * JD-Core Version:    0.7.0.1
 */