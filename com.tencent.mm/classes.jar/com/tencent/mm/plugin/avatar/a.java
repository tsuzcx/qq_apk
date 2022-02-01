package com.tencent.mm.plugin.avatar;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bg;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(151425);
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(151425);
      return false;
    }
    ad.i("MicroMsg.AvatarCommand", "processCommand: %s", new Object[] { TextUtils.join(" ", paramArrayOfString) });
    if (paramArrayOfString[1].equals("pull"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(151425);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramString = ((k)g.ab(k.class)).apM().aHU(paramContext).field_username;
      paramArrayOfString = b.aih() + "/tencent/MicroMsg/avatar/";
      com.tencent.mm.vfs.i.aMF(paramArrayOfString);
      p.auq();
      String str1 = e.J(paramString, false);
      String str2 = com.tencent.mm.vfs.i.RK(str1);
      com.tencent.mm.vfs.i.lC(str1, paramArrayOfString + paramContext + "-s." + str2);
      p.auq();
      paramString = e.J(paramString, true);
      str1 = com.tencent.mm.vfs.i.RK(paramString);
      com.tencent.mm.vfs.i.lC(paramString, paramArrayOfString + paramContext + "-b." + str1);
      Toast.makeText(aj.getContext(), "pull to ".concat(String.valueOf(paramArrayOfString)), 0).show();
      AppMethodBeat.o(151425);
      return true;
    }
    if (paramArrayOfString[1].equals("dump"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(151425);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramContext = ((k)g.ab(k.class)).apM().aHU(paramContext).field_username;
      paramContext = p.auF().we(paramContext);
      ad.i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", new Object[] { paramContext.aux(), paramContext.auy(), Integer.valueOf(paramContext.gUe), Integer.valueOf(paramContext.evo) });
      AppMethodBeat.o(151425);
      return true;
    }
    if (paramArrayOfString[1].equals("clean"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(151425);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramContext = ((k)g.ab(k.class)).apM().aHU(paramContext).field_username;
      p.auq();
      e.K(paramContext, false);
      p.auq();
      e.K(paramContext, true);
      AppMethodBeat.o(151425);
      return true;
    }
    if (paramArrayOfString[1].equals("cleanAll"))
    {
      com.tencent.mm.vfs.i.cO("wcf://avatar/", true);
      AppMethodBeat.o(151425);
      return true;
    }
    if (paramArrayOfString[1].equals("decrypt"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(151425);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramArrayOfString = UtilsJni.DecryptAvatar(com.tencent.mm.vfs.i.aR(paramContext, 0, -1));
      if (paramArrayOfString == null) {
        Toast.makeText(aj.getContext(), "error", 0).show();
      }
      for (;;)
      {
        AppMethodBeat.o(151425);
        return true;
        com.tencent.mm.vfs.i.f(paramContext + ".d", paramArrayOfString, paramArrayOfString.length);
      }
    }
    AppMethodBeat.o(151425);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.a
 * JD-Core Version:    0.7.0.1
 */