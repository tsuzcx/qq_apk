package com.tencent.mm.plugin.expansions;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

@Keep
public final class ExpansionsClassLoaderInitializer
{
  private static final String TAG = "MicroMsg.ExpansionsClassLoaderInitializer";
  
  @Keep
  public final void initializeClassLoader(Application paramApplication, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(152965);
    c.gj("MicroMsg.ExpansionsClassLoaderInitializer", "[+] Enter initializeClassLoader.");
    if (paramApplication != null)
    {
      int i = Process.myPid();
      paramApplication = ((ActivityManager)paramApplication.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramApplication.hasNext())
      {
        paramClassLoader = (ActivityManager.RunningAppProcessInfo)paramApplication.next();
        if ((paramClassLoader.pid == i) && (paramClassLoader.processName != null) && (!paramClassLoader.processName.equals("")))
        {
          paramApplication = paramClassLoader.processName;
          if (!paramApplication.endsWith(":push")) {
            break label123;
          }
          c.gj("MicroMsg.ExpansionsClassLoaderInitializer", "[!] push process needn't initialize Expansions.");
        }
      }
    }
    for (;;)
    {
      c.gj("MicroMsg.ExpansionsClassLoaderInitializer", "[+] Exit initializeClassLoader.");
      AppMethodBeat.o(152965);
      return;
      paramApplication = null;
      break;
      label123:
      if (paramApplication.endsWith(":isolated_process0"))
      {
        c.gj("MicroMsg.ExpansionsClassLoaderInitializer", "[!] tbs isolated process cannot initialize Expansions.");
      }
      else
      {
        a.cMn();
        a.cMm();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsClassLoaderInitializer
 * JD-Core Version:    0.7.0.1
 */