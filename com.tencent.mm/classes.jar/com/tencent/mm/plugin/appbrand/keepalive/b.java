package com.tencent.mm.plugin.appbrand.keepalive;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum b
{
  private final Set<AppBrandRuntime> pPe;
  
  static
  {
    AppMethodBeat.i(47040);
    pPd = new b("INSTANCE");
    pPf = new b[] { pPd };
    AppMethodBeat.o(47040);
  }
  
  private b()
  {
    AppMethodBeat.i(271893);
    this.pPe = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(271893);
  }
  
  public static void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(271894);
    String str = MMApplicationContext.getProcessName();
    if (!TextUtils.isEmpty(str)) {
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(str), b.a.class, new b.2(paramRunnable));
    }
    AppMethodBeat.o(271894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keepalive.b
 * JD-Core Version:    0.7.0.1
 */