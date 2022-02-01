package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.gamelive.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class m
  implements c
{
  public static void ab(w paramw)
  {
    AppMethodBeat.i(317308);
    paramw.a(a.uqH);
    AppMethodBeat.o(317308);
  }
  
  public final String cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(317320);
    if (((d)h.az(d.class)).isGameLiving(paramString, paramInt).booleanValue())
    {
      Log.i("MicroMsg.AppBrandVOIPStrategy", "canJoinVOIP: is game living");
      paramString = MMApplicationContext.getContext().getString(ba.i.in_live_tip);
      AppMethodBeat.o(317320);
      return paramString;
    }
    paramString = (IPCString)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, m.b.class);
    if (paramString != null)
    {
      paramString = paramString.value;
      AppMethodBeat.o(317320);
      return paramString;
    }
    AppMethodBeat.o(317320);
    return null;
  }
  
  static final class a
  {
    static m uqH;
    
    static
    {
      AppMethodBeat.i(317431);
      uqH = new m((byte)0);
      AppMethodBeat.o(317431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.m
 * JD-Core Version:    0.7.0.1
 */