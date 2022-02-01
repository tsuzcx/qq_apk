package com.tencent.mm.bp;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lu.b;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import org.xwalk.core.Log;

public final class a
{
  public static boolean Xm()
  {
    AppMethodBeat.i(237142);
    lu locallu = new lu();
    locallu.dRh.dJY = 7;
    EventCenter.instance.publish(locallu);
    boolean bool = locallu.dRi.dFE;
    AppMethodBeat.o(237142);
    return bool;
  }
  
  public static void au(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(237143);
    if (glB())
    {
      Log.i("NearbyHelper", "gotoNearByUILiveFriends");
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderLbsLiveFriendsUI(paramContext, paramIntent);
      AppMethodBeat.o(237143);
      return;
    }
    Log.i("NearbyHelper", "gotoNearBy");
    if (!glC())
    {
      com.tencent.mm.kernel.g.aAf().azk();
      if (((l)com.tencent.mm.kernel.g.af(l.class)).eiv().ctM() > 0)
      {
        c.V(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
        AppMethodBeat.o(237143);
        return;
      }
    }
    c.V(paramContext, "nearby", ".ui.NearbyFriendsUI");
    AppMethodBeat.o(237143);
  }
  
  public static boolean glB()
  {
    AppMethodBeat.i(237141);
    boolean bool = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getFinderUtilApi().dDf();
    AppMethodBeat.o(237141);
    return bool;
  }
  
  public static boolean glC()
  {
    AppMethodBeat.i(89923);
    String str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableStrangerChat");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = "0";
    }
    boolean bool = "1".equals(str1);
    AppMethodBeat.o(89923);
    return bool;
  }
  
  public static void ih(Context paramContext)
  {
    AppMethodBeat.i(89924);
    au(paramContext, new Intent());
    AppMethodBeat.o(89924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bp.a
 * JD-Core Version:    0.7.0.1
 */