package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class r
{
  private static Boolean ueo;
  private static Boolean uep;
  static Boolean ueq;
  
  public static boolean cLr()
  {
    AppMethodBeat.i(322197);
    boolean bool;
    if (ueo != null)
    {
      bool = ueo.booleanValue();
      AppMethodBeat.o(322197);
      return bool;
    }
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useManagerV2: mmkv is null");
      AppMethodBeat.o(322197);
      return false;
    }
    int i = ((MultiProcessMMKV)localObject).getInt("enable_v2_task_manager", 2);
    if (i == 1) {
      bool = true;
    }
    for (;;)
    {
      ueo = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useManagerV2: [%b]", new Object[] { ueo });
      bool = ueo.booleanValue();
      AppMethodBeat.o(322197);
      return bool;
      if (i != 0)
      {
        i = ((c)h.ax(c.class)).a(c.a.yTR, 0);
        if (BuildInfo.IS_FLAVOR_RED) {
          i = 1;
        }
        if (i > 0)
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  public static boolean cLs()
  {
    AppMethodBeat.i(322204);
    if (uep != null)
    {
      bool = uep.booleanValue();
      AppMethodBeat.o(322204);
      return bool;
    }
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: mmkv is null");
      AppMethodBeat.o(322204);
      return false;
    }
    int i = ((MultiProcessMMKV)localObject).getInt("enable_single_task_dispatch", 2);
    if (i == 1) {}
    for (uep = Boolean.TRUE;; uep = Boolean.FALSE)
    {
      Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: [%b]", new Object[] { uep });
      bool = uep.booleanValue();
      AppMethodBeat.o(322204);
      return bool;
      if (i != 0) {
        break;
      }
    }
    i = ((c)h.ax(c.class)).a(c.a.yTS, 0);
    if (BuildInfo.IS_FLAVOR_RED) {
      i = 1;
    }
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = Boolean.valueOf(bool);
      uep = (Boolean)localObject;
      if ((((Boolean)localObject).booleanValue()) && (!q.awm()))
      {
        Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: test is64BitRuntime fail");
        uep = Boolean.FALSE;
      }
      if ((!uep.booleanValue()) || (cLr())) {
        break;
      }
      uep = Boolean.FALSE;
      break;
    }
  }
  
  public static void kX(boolean paramBoolean)
  {
    AppMethodBeat.i(322210);
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject != null) {
      if (!paramBoolean) {
        break label37;
      }
    }
    label37:
    for (int i = 1;; i = 0)
    {
      ((MultiProcessMMKV)localObject).putInt("enable_three_proc_tasks_dispatch", i);
      AppMethodBeat.o(322210);
      return;
    }
  }
  
  public static void kY(boolean paramBoolean)
  {
    AppMethodBeat.i(322216);
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject != null) {
      if (!paramBoolean) {
        break label37;
      }
    }
    label37:
    for (int i = 1;; i = 0)
    {
      ((MultiProcessMMKV)localObject).putInt("enable_single_task_dispatch", i);
      AppMethodBeat.o(322216);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.r
 * JD-Core Version:    0.7.0.1
 */