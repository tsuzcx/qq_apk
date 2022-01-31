package com.tencent.mm.bo;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static boolean dkM()
  {
    AppMethodBeat.i(55524);
    String str2 = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableStrangerChat");
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = "0";
    }
    boolean bool = "1".equals(str1);
    AppMethodBeat.o(55524);
    return bool;
  }
  
  public static void fF(Context paramContext)
  {
    AppMethodBeat.i(55525);
    if (!dkM())
    {
      g.RJ().QQ();
      if (((j)g.E(j.class)).bPN().bbZ() > 0)
      {
        d.H(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
        AppMethodBeat.o(55525);
        return;
      }
    }
    d.H(paramContext, "nearby", ".ui.NearbyFriendsUI");
    AppMethodBeat.o(55525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bo.a
 * JD-Core Version:    0.7.0.1
 */