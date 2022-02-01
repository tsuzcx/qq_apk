package com.tencent.mm.plugin.avatar;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bp;

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
      paramString = ((l)g.ab(l.class)).azp().aTh(paramContext).field_username;
      paramArrayOfString = b.arU() + "/tencent/MicroMsg/avatar/";
      com.tencent.mm.vfs.i.aYg(paramArrayOfString);
      p.aEk();
      String str1 = e.K(paramString, false);
      String str2 = com.tencent.mm.vfs.i.ZF(str1);
      com.tencent.mm.vfs.i.mz(str1, paramArrayOfString + paramContext + "-s." + str2);
      p.aEk();
      paramString = e.K(paramString, true);
      str1 = com.tencent.mm.vfs.i.ZF(paramString);
      com.tencent.mm.vfs.i.mz(paramString, paramArrayOfString + paramContext + "-b." + str1);
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
      paramContext = ((l)g.ab(l.class)).azp().aTh(paramContext).field_username;
      paramContext = p.aEx().Dj(paramContext);
      ad.i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", new Object[] { paramContext.aEq(), paramContext.aEr(), Integer.valueOf(paramContext.hMV), Integer.valueOf(paramContext.ePj) });
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
      paramContext = ((l)g.ab(l.class)).azp().aTh(paramContext).field_username;
      p.aEk();
      e.L(paramContext, false);
      p.aEk();
      e.L(paramContext, true);
      AppMethodBeat.o(151425);
      return true;
    }
    if (paramArrayOfString[1].equals("cleanAll"))
    {
      com.tencent.mm.vfs.i.cZ("wcf://avatar/", true);
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
      paramArrayOfString = UtilsJni.DecryptAvatar(com.tencent.mm.vfs.i.aY(paramContext, 0, -1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.a
 * JD-Core Version:    0.7.0.1
 */