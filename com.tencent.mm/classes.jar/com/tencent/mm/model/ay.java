package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.loader.j.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;

public final class ay
  extends c
{
  public static ay hnA;
  public static final String hnB;
  
  static
  {
    AppMethodBeat.i(132238);
    hnA = new ay(c.gMU);
    hnB = b.aoZ() + "last_avatar_dir";
    AppMethodBeat.o(132238);
  }
  
  private ay(c paramc)
  {
    super(paramc.aqf());
    AppMethodBeat.i(132233);
    AppMethodBeat.o(132233);
  }
  
  public final void aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132234);
    ac.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.sp.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      ai.getContext().getSharedPreferences("notify_key_pref_no_account", com.tencent.mm.compatible.util.g.YK()).edit().putString("login_weixin_username", paramString2).commit();
    }
    AppMethodBeat.o(132234);
  }
  
  public final String ayE()
  {
    AppMethodBeat.i(132236);
    String str = aw("last_avatar_path", "");
    AppMethodBeat.o(132236);
    return str;
  }
  
  public final void g(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(132235);
    int i = 0;
    if (paramInt != 0)
    {
      i = 1;
      aL("last_login_bind_qq", String.valueOf(paramInt));
    }
    paramInt = i;
    if (!bs.isNullOrNil(paramString2))
    {
      paramInt = i | 0x2;
      aL("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!bs.isNullOrNil(paramString1))
    {
      i = paramInt | 0x4;
      aL("last_login_bind_mobile", paramString1);
    }
    aL("last_bind_info", String.valueOf(i));
    AppMethodBeat.o(132235);
  }
  
  public final void yg(String paramString)
  {
    AppMethodBeat.i(132237);
    ac.i("MicroMsg.LastLoginInfo", "Save last avatar: ".concat(String.valueOf(paramString)));
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132237);
      return;
    }
    String str = paramString.substring(paramString.lastIndexOf('/') + 1);
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(132237);
      return;
    }
    str = hnB + "/" + str;
    i.aSh(hnB);
    ac.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str, Boolean.valueOf(i.deleteFile(str)) });
    i.lZ(paramString, str);
    aL("last_avatar_path", str);
    if (com.tencent.mm.kernel.g.agM()) {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQX, str);
    }
    AppMethodBeat.o(132237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ay
 * JD-Core Version:    0.7.0.1
 */