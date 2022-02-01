package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.loader.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;

public final class bg
  extends c
{
  public static bg okT;
  public static final String okU;
  
  static
  {
    AppMethodBeat.i(132238);
    okT = new bg(c.nsL);
    okU = b.bmr() + "last_avatar_dir";
    AppMethodBeat.o(132238);
  }
  
  private bg(c paramc)
  {
    super(paramc.bnD());
    AppMethodBeat.i(132233);
    AppMethodBeat.o(132233);
  }
  
  public final void JD(String paramString)
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
    str = okU + "/" + str;
    y.bDX(okU);
    Log.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str, Boolean.valueOf(y.deleteFile(str)) });
    y.O(paramString, str, false);
    bc("last_avatar_path", str);
    if (h.baz()) {
      h.baE().ban().set(at.a.acWq, str);
    }
    AppMethodBeat.o(132237);
  }
  
  public final String bCr()
  {
    AppMethodBeat.i(132236);
    String str = aM("last_avatar_path", "");
    AppMethodBeat.o(132236);
    return str;
  }
  
  public final void bc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132234);
    Log.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.sp.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_no_account", g.aQe()).edit().putString("login_weixin_username", paramString2).commit();
    }
    AppMethodBeat.o(132234);
  }
  
  public final void k(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(132235);
    int i = 0;
    if (paramInt != 0)
    {
      i = 1;
      bc("last_login_bind_qq", String.valueOf(paramInt));
    }
    paramInt = i;
    if (!Util.isNullOrNil(paramString2))
    {
      paramInt = i | 0x2;
      bc("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!Util.isNullOrNil(paramString1))
    {
      i = paramInt | 0x4;
      bc("last_login_bind_mobile", paramString1);
    }
    bc("last_bind_info", String.valueOf(i));
    AppMethodBeat.o(132235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bg
 * JD-Core Version:    0.7.0.1
 */