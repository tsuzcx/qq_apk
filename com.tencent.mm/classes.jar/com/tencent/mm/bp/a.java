package com.tencent.mm.bp;

import android.content.Context;
import android.content.Intent;
import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nr;
import com.tencent.mm.autogen.a.nr.b;
import com.tencent.mm.br.c;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Util;
import org.xwalk.core.Log;

public final class a
{
  public static boolean aDN()
  {
    AppMethodBeat.i(231174);
    nr localnr = new nr();
    localnr.hQd.hHC = 7;
    localnr.publish();
    boolean bool = localnr.hQe.hCQ;
    AppMethodBeat.o(231174);
    return bool;
  }
  
  public static void aM(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(231179);
    if (iGm())
    {
      Log.i("NearbyHelper", "gotoNearByUILiveFriends");
      ((e)h.az(e.class)).enterFinderLbsLiveFriendsUI(paramContext, paramIntent);
      AppMethodBeat.o(231179);
      return;
    }
    Log.i("NearbyHelper", "gotoNearBy");
    if (!iGn())
    {
      h.baC().aZJ();
      if (((n)h.ax(n.class)).gaW().dkF() > 0)
      {
        c.ai(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
        AppMethodBeat.o(231179);
        return;
      }
    }
    c.ai(paramContext, "nearby", ".ui.NearbyFriendsUI");
    AppMethodBeat.o(231179);
  }
  
  public static boolean iGm()
  {
    AppMethodBeat.i(231164);
    boolean bool = ((cn)h.az(cn.class)).getFinderUtilApi().fgF();
    AppMethodBeat.o(231164);
    return bool;
  }
  
  public static boolean iGn()
  {
    AppMethodBeat.i(89923);
    String str2 = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("EnableStrangerChat");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = "0";
    }
    boolean bool = "1".equals(str1);
    AppMethodBeat.o(89923);
    return bool;
  }
  
  public static void li(Context paramContext)
  {
    AppMethodBeat.i(89924);
    aM(paramContext, new Intent());
    AppMethodBeat.o(89924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bp.a
 * JD-Core Version:    0.7.0.1
 */