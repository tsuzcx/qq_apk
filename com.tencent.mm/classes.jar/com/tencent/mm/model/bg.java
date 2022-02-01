package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.loader.j.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;

public final class bg
  extends d
{
  public static bg ltv;
  public static final String ltw;
  
  static
  {
    AppMethodBeat.i(132238);
    ltv = new bg(d.kRj);
    ltw = b.aSD() + "last_avatar_dir";
    AppMethodBeat.o(132238);
  }
  
  private bg(d paramd)
  {
    super(paramd.aTO());
    AppMethodBeat.i(132233);
    AppMethodBeat.o(132233);
  }
  
  public final void RF(String paramString)
  {
    AppMethodBeat.i(132237);
    Log.i("MicroMsg.LastLoginInfo", "Save last avatar: ".concat(String.valueOf(paramString)));
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132237);
      return;
    }
    String str = paramString.substring(paramString.lastIndexOf('/') + 1);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(132237);
      return;
    }
    str = ltw + "/" + str;
    u.bBD(ltw);
    Log.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str, Boolean.valueOf(u.deleteFile(str)) });
    u.on(paramString, str);
    aS("last_avatar_path", str);
    if (h.aHB()) {
      h.aHG().aHp().set(ar.a.VuH, str);
    }
    AppMethodBeat.o(132237);
  }
  
  public final void aS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132234);
    Log.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.sp.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_no_account", g.avK()).edit().putString("login_weixin_username", paramString2).commit();
    }
    AppMethodBeat.o(132234);
  }
  
  public final String beA()
  {
    AppMethodBeat.i(132236);
    String str = aD("last_avatar_path", "");
    AppMethodBeat.o(132236);
    return str;
  }
  
  public final void j(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(132235);
    int i = 0;
    if (paramInt != 0)
    {
      i = 1;
      aS("last_login_bind_qq", String.valueOf(paramInt));
    }
    paramInt = i;
    if (!Util.isNullOrNil(paramString2))
    {
      paramInt = i | 0x2;
      aS("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!Util.isNullOrNil(paramString1))
    {
      i = paramInt | 0x4;
      aS("last_login_bind_mobile", paramString1);
    }
    aS("last_bind_info", String.valueOf(i));
    AppMethodBeat.o(132235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bg
 * JD-Core Version:    0.7.0.1
 */