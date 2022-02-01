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
  public String kDI = null;
  private boolean kDJ = false;
  
  static
  {
    AppMethodBeat.i(47040);
    kDH = new b("INSTANCE");
    kDK = new b[] { kDH };
    AppMethodBeat.o(47040);
  }
  
  private b() {}
  
  public static void b(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(47037);
    if (!TextUtils.isEmpty(paramString)) {
      XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), b.a.class, new d() {});
    }
    AppMethodBeat.o(47037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keepalive.b
 * JD-Core Version:    0.7.0.1
 */