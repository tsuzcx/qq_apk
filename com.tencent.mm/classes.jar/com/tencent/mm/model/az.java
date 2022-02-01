package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.loader.j.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;

public final class az
  extends c
{
  public static az hFS;
  public static final String hFT;
  
  static
  {
    AppMethodBeat.i(132238);
    hFS = new az(c.hgR);
    hFT = b.arM() + "last_avatar_dir";
    AppMethodBeat.o(132238);
  }
  
  private az(c paramc)
  {
    super(paramc.asU());
    AppMethodBeat.i(132233);
    AppMethodBeat.o(132233);
  }
  
  public final void Be(String paramString)
  {
    AppMethodBeat.i(132237);
    ad.i("MicroMsg.LastLoginInfo", "Save last avatar: ".concat(String.valueOf(paramString)));
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132237);
      return;
    }
    String str = paramString.substring(paramString.lastIndexOf('/') + 1);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(132237);
      return;
    }
    str = hFT + "/" + str;
    i.aYg(hFT);
    ad.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str, Boolean.valueOf(i.deleteFile(str)) });
    i.mz(paramString, str);
    aM("last_avatar_path", str);
    if (com.tencent.mm.kernel.g.ajx()) {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDu, str);
    }
    AppMethodBeat.o(132237);
  }
  
  public final String aBI()
  {
    AppMethodBeat.i(132236);
    String str = ax("last_avatar_path", "");
    AppMethodBeat.o(132236);
    return str;
  }
  
  public final void aM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132234);
    ad.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.sp.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      aj.getContext().getSharedPreferences("notify_key_pref_no_account", com.tencent.mm.compatible.util.g.abm()).edit().putString("login_weixin_username", paramString2).commit();
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
    if (!bt.isNullOrNil(paramString2))
    {
      paramInt = i | 0x2;
      aM("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!bt.isNullOrNil(paramString1))
    {
      i = paramInt | 0x4;
      aM("last_login_bind_mobile", paramString1);
    }
    aM("last_bind_info", String.valueOf(i));
    AppMethodBeat.o(132235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.az
 * JD-Core Version:    0.7.0.1
 */