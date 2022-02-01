package com.tencent.mm.plugin.avatar;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.s;

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
    Log.i("MicroMsg.AvatarCommand", "processCommand: %s", new Object[] { TextUtils.join(" ", paramArrayOfString) });
    if (paramArrayOfString[1].equals("pull"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(151425);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramString = ((l)g.af(l.class)).aSN().bjH(paramContext).field_username;
      paramArrayOfString = b.aKJ() + "/tencent/MicroMsg/avatar/";
      s.boN(paramArrayOfString);
      p.aYn();
      String str1 = e.M(paramString, false);
      String str2 = s.akC(str1);
      s.nw(str1, paramArrayOfString + paramContext + "-s." + str2);
      p.aYn();
      paramString = e.M(paramString, true);
      str1 = s.akC(paramString);
      s.nw(paramString, paramArrayOfString + paramContext + "-b." + str1);
      Toast.makeText(MMApplicationContext.getContext(), "pull to ".concat(String.valueOf(paramArrayOfString)), 0).show();
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
      paramContext = ((l)g.af(l.class)).aSN().bjH(paramContext).field_username;
      paramContext = p.aYB().Mx(paramContext);
      Log.i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", new Object[] { paramContext.aYt(), paramContext.aYu(), Integer.valueOf(paramContext.iKV), Integer.valueOf(paramContext.fuz) });
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
      paramContext = ((l)g.af(l.class)).aSN().bjH(paramContext).field_username;
      p.aYn();
      e.N(paramContext, false);
      p.aYn();
      e.N(paramContext, true);
      AppMethodBeat.o(151425);
      return true;
    }
    if (paramArrayOfString[1].equals("cleanAll"))
    {
      s.dy("wcf://avatar/", true);
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
      paramArrayOfString = UtilsJni.DecryptAvatar(s.aW(paramContext, 0, -1));
      if (paramArrayOfString == null) {
        Toast.makeText(MMApplicationContext.getContext(), "error", 0).show();
      }
      for (;;)
      {
        AppMethodBeat.o(151425);
        return true;
        s.f(paramContext + ".d", paramArrayOfString, paramArrayOfString.length);
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