package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class at
  extends c
{
  public static at dVC = new at(c.dOS);
  public static final String dVD = com.tencent.mm.compatible.util.e.dOP + "last_avatar_dir";
  
  private at(c paramc)
  {
    super(paramc.dnD);
  }
  
  public final String Ho()
  {
    return L("last_avatar_path", "");
  }
  
  public final void Y(String paramString1, String paramString2)
  {
    y.i("MicroMsg.LastLoginInfo", "save key : %s value : %s", new Object[] { paramString1, paramString2 });
    this.dnD.edit().putString(paramString1, paramString2).commit();
    if (paramString1.equals("login_weixin_username")) {
      ae.getContext().getSharedPreferences("notify_key_pref_no_account", 4).edit().putString("login_weixin_username", paramString2).commit();
    }
  }
  
  public final void c(String paramString1, int paramInt, String paramString2)
  {
    int i = 0;
    if (paramInt != 0)
    {
      i = 1;
      Y("last_login_bind_qq", String.valueOf(paramInt));
    }
    paramInt = i;
    if (!bk.bl(paramString2))
    {
      paramInt = i | 0x2;
      Y("last_login_bind_email", String.valueOf(paramString2));
    }
    i = paramInt;
    if (!bk.bl(paramString1))
    {
      i = paramInt | 0x4;
      Y("last_login_bind_mobile", paramString1);
    }
    Y("last_bind_info", String.valueOf(i));
  }
  
  public final void iF(String paramString)
  {
    y.i("MicroMsg.LastLoginInfo", "Save last avatar: " + paramString);
    if (bk.bl(paramString)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramString.substring(paramString.lastIndexOf('/') + 1);
      } while (bk.bl(str));
      str = dVD + "/" + str;
      com.tencent.mm.vfs.e.nb(dVD);
      y.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", new Object[] { str, Boolean.valueOf(com.tencent.mm.vfs.e.deleteFile(str)) });
      com.tencent.mm.vfs.e.r(paramString, str);
      Y("last_avatar_path", str);
    } while (!g.DK());
    g.DP().Dz().c(ac.a.uzf, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.at
 * JD-Core Version:    0.7.0.1
 */