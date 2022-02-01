package com.tencent.mm.bw;

import android.content.Context;
import android.content.Intent;
import com.tencent.c.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.ml;
import com.tencent.mm.f.a.ml.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import org.xwalk.core.Log;

public final class a
{
  public static void aD(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(231891);
    if (hfs())
    {
      Log.i("NearbyHelper", "gotoNearByUILiveFriends");
      ((e)h.ag(e.class)).enterFinderLbsLiveFriendsUI(paramContext, paramIntent);
      AppMethodBeat.o(231891);
      return;
    }
    Log.i("NearbyHelper", "gotoNearBy");
    if (!hft())
    {
      h.aHE().aGH();
      if (((n)h.ae(n.class)).eSb().cHo() > 0)
      {
        c.ad(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
        AppMethodBeat.o(231891);
        return;
      }
    }
    c.ad(paramContext, "nearby", ".ui.NearbyFriendsUI");
    AppMethodBeat.o(231891);
  }
  
  public static boolean abO()
  {
    AppMethodBeat.i(231889);
    ml localml = new ml();
    localml.fKx.fCN = 7;
    EventCenter.instance.publish(localml);
    boolean bool = localml.fKy.fyl;
    AppMethodBeat.o(231889);
    return bool;
  }
  
  public static boolean hfs()
  {
    AppMethodBeat.i(231887);
    boolean bool = ((ak)h.ag(ak.class)).getFinderUtilApi().eeI();
    AppMethodBeat.o(231887);
    return bool;
  }
  
  public static boolean hft()
  {
    AppMethodBeat.i(89923);
    String str2 = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("EnableStrangerChat");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = "0";
    }
    boolean bool = "1".equals(str1);
    AppMethodBeat.o(89923);
    return bool;
  }
  
  public static void jk(Context paramContext)
  {
    AppMethodBeat.i(89924);
    aD(paramContext, new Intent());
    AppMethodBeat.o(89924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bw.a
 * JD-Core Version:    0.7.0.1
 */