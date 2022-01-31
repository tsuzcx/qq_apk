package com.tencent.mm.plugin.avatar;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bd;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(79052);
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(79052);
      return false;
    }
    ab.i("MicroMsg.AvatarCommand", "processCommand: %s", new Object[] { TextUtils.join(" ", paramArrayOfString) });
    if (paramArrayOfString[1].equals("pull"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(79052);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramString = ((j)g.E(j.class)).YA().ars(paramContext).field_username;
      paramArrayOfString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/avatar/";
      e.um(paramArrayOfString);
      o.acQ();
      String str1 = d.E(paramString, false);
      String str2 = e.cP(str1);
      e.C(str1, paramArrayOfString + paramContext + "-s." + str2);
      o.acQ();
      paramString = d.E(paramString, true);
      str1 = e.cP(paramString);
      e.C(paramString, paramArrayOfString + paramContext + "-b." + str1);
      Toast.makeText(ah.getContext(), "pull to ".concat(String.valueOf(paramArrayOfString)), 0).show();
      AppMethodBeat.o(79052);
      return true;
    }
    if (paramArrayOfString[1].equals("dump"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(79052);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramContext = ((j)g.E(j.class)).YA().ars(paramContext).field_username;
      paramContext = o.adg().rj(paramContext);
      ab.i("MicroMsg.AvatarCommand", "dump: %s, %s, %s, %s", new Object[] { paramContext.acX(), paramContext.acY(), Integer.valueOf(paramContext.fsj), Integer.valueOf(paramContext.dqB) });
      AppMethodBeat.o(79052);
      return true;
    }
    if (paramArrayOfString[1].equals("clean"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(79052);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramContext = ((j)g.E(j.class)).YA().ars(paramContext).field_username;
      o.acQ();
      d.F(paramContext, false);
      o.acQ();
      d.F(paramContext, true);
      AppMethodBeat.o(79052);
      return true;
    }
    if (paramArrayOfString[1].equals("cleanAll"))
    {
      e.O("wcf://avatar/", true);
      AppMethodBeat.o(79052);
      return true;
    }
    if (paramArrayOfString[1].equals("decrypt"))
    {
      if (paramArrayOfString.length <= 2)
      {
        AppMethodBeat.o(79052);
        return false;
      }
      paramContext = paramArrayOfString[2];
      paramArrayOfString = UtilsJni.DecryptAvatar(e.i(paramContext, 0, -1));
      if (paramArrayOfString == null) {
        Toast.makeText(ah.getContext(), "error", 0).show();
      }
      for (;;)
      {
        AppMethodBeat.o(79052);
        return true;
        e.b(paramContext + ".d", paramArrayOfString, paramArrayOfString.length);
      }
    }
    AppMethodBeat.o(79052);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.a
 * JD-Core Version:    0.7.0.1
 */