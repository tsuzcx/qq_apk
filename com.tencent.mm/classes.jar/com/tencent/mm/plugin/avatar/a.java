package com.tencent.mm.plugin.avatar;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.o;

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
    ae.i("MicroMsg.AvatarCommand", "processCommand: %s", new Object[] { TextUtils.join(" ", paramArrayOfString) });
    if (paramArrayOfString[1].equals("pull"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(151425);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramString = ((l)g.ab(l.class)).azF().aUI(paramContext).field_username;
      paramArrayOfString = b.asj() + "/tencent/MicroMsg/avatar/";
      o.aZI(paramArrayOfString);
      p.aEA();
      String str1 = e.K(paramString, false);
      String str2 = o.aaw(str1);
      o.mF(str1, paramArrayOfString + paramContext + "-s." + str2);
      p.aEA();
      paramString = e.K(paramString, true);
      str1 = o.aaw(paramString);
      o.mF(paramString, paramArrayOfString + paramContext + "-b." + str1);
      Toast.makeText(ak.getContext(), "pull to ".concat(String.valueOf(paramArrayOfString)), 0).show();
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
      paramContext = ((l)g.ab(l.class)).azF().aUI(paramContext).field_username;
      paramContext = p.aEN().DL(paramContext);
      ae.i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", new Object[] { paramContext.aEG(), paramContext.aEH(), Integer.valueOf(paramContext.hPO), Integer.valueOf(paramContext.eQU) });
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
      paramContext = ((l)g.ab(l.class)).azF().aUI(paramContext).field_username;
      p.aEA();
      e.L(paramContext, false);
      p.aEA();
      e.L(paramContext, true);
      AppMethodBeat.o(151425);
      return true;
    }
    if (paramArrayOfString[1].equals("cleanAll"))
    {
      o.dd("wcf://avatar/", true);
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
      paramArrayOfString = UtilsJni.DecryptAvatar(o.bb(paramContext, 0, -1));
      if (paramArrayOfString == null) {
        Toast.makeText(ak.getContext(), "error", 0).show();
      }
      for (;;)
      {
        AppMethodBeat.o(151425);
        return true;
        o.f(paramContext + ".d", paramArrayOfString, paramArrayOfString.length);
      }
    }
    AppMethodBeat.o(151425);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.a
 * JD-Core Version:    0.7.0.1
 */