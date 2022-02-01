package com.tencent.mm.plugin.account.security.model;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.sdk.a;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;

public final class f
{
  public static String bXQ()
  {
    AppMethodBeat.i(125529);
    String str = Build.MANUFACTURER + "-" + q.aPo();
    AppMethodBeat.o(125529);
    return str;
  }
  
  public static String es(Context paramContext)
  {
    AppMethodBeat.i(125528);
    if (paramContext == null)
    {
      if (ChannelUtil.isNokiaAol)
      {
        paramContext = MMApplicationContext.getContext().getString(a.d.safe_device_android_device_nm);
        AppMethodBeat.o(125528);
        return paramContext;
      }
      paramContext = MMApplicationContext.getContext().getString(a.d.safe_device_android_device);
      AppMethodBeat.o(125528);
      return paramContext;
    }
    if (ChannelUtil.isNokiaAol)
    {
      paramContext = paramContext.getString(a.d.safe_device_android_device_nm);
      AppMethodBeat.o(125528);
      return paramContext;
    }
    paramContext = paramContext.getString(a.d.safe_device_android_device);
    AppMethodBeat.o(125528);
    return paramContext;
  }
  
  public static void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(125527);
    if (!h.baz())
    {
      AppMethodBeat.o(125527);
      return;
    }
    int i = z.bAU();
    cas localcas;
    if (paramBoolean1)
    {
      i |= 0x4000;
      h.baE().ban().B(40, Integer.valueOf(i));
      if (paramBoolean2)
      {
        localcas = new cas();
        localcas.aajJ = 28;
        if (!paramBoolean1) {
          break label126;
        }
      }
    }
    label126:
    for (i = 1;; i = 2)
    {
      localcas.NkL = i;
      ((n)h.ax(n.class)).bzz().d(new k.a(23, localcas));
      a.pFo.aDx();
      AppMethodBeat.o(125527);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.model.f
 * JD-Core Version:    0.7.0.1
 */