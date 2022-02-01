package com.tencent.mm.plugin.expansions;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class ExpansionsClassLoaderInitializer
{
  private static final String TAG = "MicroMsg.ExpansionsClassLoaderInitializer";
  
  public final void initializeClassLoader(Application paramApplication, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(152965);
    d.hb("MicroMsg.ExpansionsClassLoaderInitializer", "[+] Enter initializeClassLoader.");
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
          d.hb("MicroMsg.ExpansionsClassLoaderInitializer", "[!] push process needn't initialize Expansions.");
        }
      }
    }
    for (;;)
    {
      d.hb("MicroMsg.ExpansionsClassLoaderInitializer", "[+] Exit initializeClassLoader.");
      AppMethodBeat.o(152965);
      return;
      paramApplication = null;
      break;
      label123:
      if (paramApplication.endsWith(":isolated_process0"))
      {
        d.hb("MicroMsg.ExpansionsClassLoaderInitializer", "[!] tbs isolated process cannot initialize Expansions.");
      }
      else
      {
        e.dHA();
        e.dHz();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsClassLoaderInitializer
 * JD-Core Version:    0.7.0.1
 */