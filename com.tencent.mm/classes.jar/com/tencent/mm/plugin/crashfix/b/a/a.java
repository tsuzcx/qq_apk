package com.tencent.mm.plugin.crashfix.b.a;

import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Proxy;

public final class a
{
  public static WindowManager a(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(145622);
    paramWindowManager = (WindowManager)Proxy.newProxyInstance(paramWindowManager.getClass().getClassLoader(), paramWindowManager.getClass().getInterfaces(), new b(paramWindowManager));
    Log.i("MicroMsg.SafeWindowManager", "proxy");
    AppMethodBeat.o(145622);
    return paramWindowManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.b.a.a
 * JD-Core Version:    0.7.0.1
 */