package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.sdk.a;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;

public final class f
{
  public static String bza()
  {
    AppMethodBeat.i(125529);
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    AppMethodBeat.o(125529);
    return str;
  }
  
  public static String dB(Context paramContext)
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
  
  public static void t(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(125527);
    if (!h.aHB())
    {
      AppMethodBeat.o(125527);
      return;
    }
    int i = z.bdf();
    bmy localbmy;
    if (paramBoolean1)
    {
      i |= 0x4000;
      h.aHG().aHp().i(40, Integer.valueOf(i));
      if (paramBoolean2)
      {
        localbmy = new bmy();
        localbmy.SXP = 28;
        if (!paramBoolean1) {
          break label126;
        }
      }
    }
    label126:
    for (i = 1;; i = 2)
    {
      localbmy.HmX = i;
      ((n)h.ae(n.class)).bbK().d(new k.a(23, localbmy));
      a.mIH.abC();
      AppMethodBeat.o(125527);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.f
 * JD-Core Version:    0.7.0.1
 */