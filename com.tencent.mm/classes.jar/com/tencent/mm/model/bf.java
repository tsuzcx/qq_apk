package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.loader.j.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;

public final class bf
  extends d
{
  public static bf iDu;
  public static final String iDv;
  
  static
  {
    AppMethodBeat.i(132238);
    iDu = new bf(d.icC);
    iDv = b.aKB() + "last_avatar_dir";
    AppMethodBeat.o(132238);
  }
  
  private bf(d paramd)
  {
    super(paramd.aLJ());
    AppMethodBeat.i(132233);
    AppMethodBeat.o(132233);
  }
  
  public final void Km(String paramString)
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
    str = iDv + "/" + str;
    s.boN(iDv);
    Log.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str, Boolean.valueOf(s.deleteFile(str)) });
    s.nw(paramString, str);
    aO("last_avatar_path", str);
    if (com.tencent.mm.kernel.g.aAc()) {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogr, str);
    }
    AppMethodBeat.o(132237);
  }
  
  public final void aO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132234);
    Log.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.sp.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_no_account", com.tencent.mm.compatible.util.g.aps()).edit().putString("login_weixin_username", paramString2).commit();
    }
    AppMethodBeat.o(132234);
  }
  
  public final String aVx()
  {
    AppMethodBeat.i(132236);
    String str = aA("last_avatar_path", "");
    AppMethodBeat.o(132236);
    return str;
  }
  
  public final void k(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(132235);
    int i = 0;
    if (paramInt != 0)
    {
      i = 1;
      aO("last_login_bind_qq", String.valueOf(paramInt));
    }
    paramInt = i;
    if (!Util.isNullOrNil(paramString2))
    {
      paramInt = i | 0x2;
      aO("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!Util.isNullOrNil(paramString1))
    {
      i = paramInt | 0x4;
      aO("last_login_bind_mobile", paramString1);
    }
    aO("last_bind_info", String.valueOf(i));
    AppMethodBeat.o(132235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bf
 * JD-Core Version:    0.7.0.1
 */