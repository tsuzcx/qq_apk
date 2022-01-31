package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.z;

public final class f
{
  public static String Xz()
  {
    return Build.MANUFACTURER + "-" + Build.MODEL;
  }
  
  public static String bZ(Context paramContext)
  {
    if (paramContext == null)
    {
      if (com.tencent.mm.sdk.platformtools.e.uen) {
        return ae.getContext().getString(a.d.safe_device_android_device_nm);
      }
      return ae.getContext().getString(a.d.safe_device_android_device);
    }
    if (com.tencent.mm.sdk.platformtools.e.uen) {
      return paramContext.getString(a.d.safe_device_android_device_nm);
    }
    return paramContext.getString(a.d.safe_device_android_device);
  }
  
  public static void m(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!g.DK()) {}
    do
    {
      return;
      i = q.Gp();
      if (!paramBoolean1) {
        break;
      }
      i |= 0x4000;
      g.DP().Dz().o(40, Integer.valueOf(i));
    } while (!paramBoolean2);
    zr localzr = new zr();
    localzr.sYS = 28;
    if (paramBoolean1) {}
    for (int i = 1;; i = 2)
    {
      localzr.nfn = i;
      ((j)g.r(j.class)).Fv().b(new i.a(23, localzr));
      a.eUS.tk();
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.f
 * JD-Core Version:    0.7.0.1
 */