package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class av
  extends c
{
  public static av flM;
  public static final String flN;
  
  static
  {
    AppMethodBeat.i(58094);
    flM = new av(c.eQB);
    flN = com.tencent.mm.compatible.util.e.eQv + "last_avatar_dir";
    AppMethodBeat.o(58094);
  }
  
  private av(c paramc)
  {
    super(paramc.Ul());
    AppMethodBeat.i(58089);
    AppMethodBeat.o(58089);
  }
  
  public final String aar()
  {
    AppMethodBeat.i(58092);
    String str = Y("last_avatar_path", "");
    AppMethodBeat.o(58092);
    return str;
  }
  
  public final void ao(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58090);
    ab.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.sp.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      ah.getContext().getSharedPreferences("notify_key_pref_no_account", h.Mp()).edit().putString("login_weixin_username", paramString2).commit();
    }
    AppMethodBeat.o(58090);
  }
  
  public final void d(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(58091);
    int i = 0;
    if (paramInt != 0)
    {
      i = 1;
      ao("last_login_bind_qq", String.valueOf(paramInt));
    }
    paramInt = i;
    if (!bo.isNullOrNil(paramString2))
    {
      paramInt = i | 0x2;
      ao("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!bo.isNullOrNil(paramString1))
    {
      i = paramInt | 0x4;
      ao("last_login_bind_mobile", paramString1);
    }
    ao("last_bind_info", String.valueOf(i));
    AppMethodBeat.o(58091);
  }
  
  public final void po(String paramString)
  {
    AppMethodBeat.i(58093);
    ab.i("MicroMsg.LastLoginInfo", "Save last avatar: ".concat(String.valueOf(paramString)));
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(58093);
      return;
    }
    String str = paramString.substring(paramString.lastIndexOf('/') + 1);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(58093);
      return;
    }
    str = flN + "/" + str;
    com.tencent.mm.vfs.e.um(flN);
    ab.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str, Boolean.valueOf(com.tencent.mm.vfs.e.deleteFile(str)) });
    com.tencent.mm.vfs.e.C(paramString, str);
    ao("last_avatar_path", str);
    if (g.RG()) {
      g.RL().Ru().set(ac.a.yJT, str);
    }
    AppMethodBeat.o(58093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.av
 * JD-Core Version:    0.7.0.1
 */