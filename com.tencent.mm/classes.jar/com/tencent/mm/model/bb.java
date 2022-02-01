package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.loader.j.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;

public final class bb
  extends c
{
  public static bb hIK;
  public static final String hIL;
  
  static
  {
    AppMethodBeat.i(132238);
    hIK = new bb(c.hjF);
    hIL = b.asb() + "last_avatar_dir";
    AppMethodBeat.o(132238);
  }
  
  private bb(c paramc)
  {
    super(paramc.atj());
    AppMethodBeat.i(132233);
    AppMethodBeat.o(132233);
  }
  
  public final void BG(String paramString)
  {
    AppMethodBeat.i(132237);
    ae.i("MicroMsg.LastLoginInfo", "Save last avatar: ".concat(String.valueOf(paramString)));
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132237);
      return;
    }
    String str = paramString.substring(paramString.lastIndexOf('/') + 1);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(132237);
      return;
    }
    str = hIL + "/" + str;
    o.aZI(hIL);
    ae.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str, Boolean.valueOf(o.deleteFile(str)) });
    o.mF(paramString, str);
    aM("last_avatar_path", str);
    if (com.tencent.mm.kernel.g.ajM()) {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXU, str);
    }
    AppMethodBeat.o(132237);
  }
  
  public final String aBY()
  {
    AppMethodBeat.i(132236);
    String str = ay("last_avatar_path", "");
    AppMethodBeat.o(132236);
    return str;
  }
  
  public final void aM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132234);
    ae.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.sp.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      ak.getContext().getSharedPreferences("notify_key_pref_no_account", com.tencent.mm.compatible.util.g.abv()).edit().putString("login_weixin_username", paramString2).commit();
    }
    AppMethodBeat.o(132234);
  }
  
  public final void h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(132235);
    int i = 0;
    if (paramInt != 0)
    {
      i = 1;
      aM("last_login_bind_qq", String.valueOf(paramInt));
    }
    paramInt = i;
    if (!bu.isNullOrNil(paramString2))
    {
      paramInt = i | 0x2;
      aM("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!bu.isNullOrNil(paramString1))
    {
      i = paramInt | 0x4;
      aM("last_login_bind_mobile", paramString1);
    }
    aM("last_bind_info", String.valueOf(i));
    AppMethodBeat.o(132235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bb
 * JD-Core Version:    0.7.0.1
 */