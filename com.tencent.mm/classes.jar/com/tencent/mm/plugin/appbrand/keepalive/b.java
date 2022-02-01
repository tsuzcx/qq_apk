package com.tencent.mm.plugin.appbrand.keepalive;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum b
{
  private final Set<AppBrandRuntime> sTE;
  
  static
  {
    AppMethodBeat.i(47040);
    sTD = new b("INSTANCE");
    sTF = new b[] { sTD };
    AppMethodBeat.o(47040);
  }
  
  private b()
  {
    AppMethodBeat.i(321253);
    this.sTE = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(321253);
  }
  
  public static void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(321255);
    String str = MMApplicationContext.getProcessName();
    if (!TextUtils.isEmpty(str)) {
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(str), a.class, new f() {});
    }
    AppMethodBeat.o(321255);
  }
  
  static final class a
    implements d<IPCString, IPCVoid>
  {}
  
  static final class b
    implements d<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keepalive.b
 * JD-Core Version:    0.7.0.1
 */