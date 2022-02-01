package com.tencent.mm.plugin.appbrand.keepalive;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.b.c.a;

public enum b
{
  public String lfb = null;
  private boolean lfc = false;
  
  static
  {
    AppMethodBeat.i(47040);
    lfa = new b("INSTANCE");
    lfd = new b[] { lfa };
    AppMethodBeat.o(47040);
  }
  
  private b() {}
  
  public static void b(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(47037);
    if (!TextUtils.isEmpty(paramString)) {
      XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.class, new d() {});
    }
    AppMethodBeat.o(47037);
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
  
  static final class b
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keepalive.b
 * JD-Core Version:    0.7.0.1
 */