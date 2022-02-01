package com.tencent.mm.plugin.avatar;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.av;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bj;

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
    ac.i("MicroMsg.AvatarCommand", "processCommand: %s", new Object[] { TextUtils.join(" ", paramArrayOfString) });
    if (paramArrayOfString[1].equals("pull"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(151425);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramString = ((k)g.ab(k.class)).awB().aNp(paramContext).field_username;
      paramArrayOfString = b.aph() + "/tencent/MicroMsg/avatar/";
      com.tencent.mm.vfs.i.aSh(paramArrayOfString);
      p.aBh();
      String str1 = e.K(paramString, false);
      String str2 = com.tencent.mm.vfs.i.VW(str1);
      com.tencent.mm.vfs.i.lZ(str1, paramArrayOfString + paramContext + "-s." + str2);
      p.aBh();
      paramString = e.K(paramString, true);
      str1 = com.tencent.mm.vfs.i.VW(paramString);
      com.tencent.mm.vfs.i.lZ(paramString, paramArrayOfString + paramContext + "-b." + str1);
      Toast.makeText(ai.getContext(), "pull to ".concat(String.valueOf(paramArrayOfString)), 0).show();
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
      paramContext = ((k)g.ab(k.class)).awB().aNp(paramContext).field_username;
      paramContext = p.aBw().Ak(paramContext);
      ac.i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", new Object[] { paramContext.aBo(), paramContext.aBp(), Integer.valueOf(paramContext.huD), Integer.valueOf(paramContext.exK) });
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
      paramContext = ((k)g.ab(k.class)).awB().aNp(paramContext).field_username;
      p.aBh();
      e.L(paramContext, false);
      p.aBh();
      e.L(paramContext, true);
      AppMethodBeat.o(151425);
      return true;
    }
    if (paramArrayOfString[1].equals("cleanAll"))
    {
      com.tencent.mm.vfs.i.cU("wcf://avatar/", true);
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
      paramArrayOfString = UtilsJni.DecryptAvatar(com.tencent.mm.vfs.i.aU(paramContext, 0, -1));
      if (paramArrayOfString == null) {
        Toast.makeText(ai.getContext(), "error", 0).show();
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