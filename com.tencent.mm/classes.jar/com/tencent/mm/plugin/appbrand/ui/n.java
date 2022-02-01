package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class n
{
  private static Boolean qYq;
  private static Boolean qYr;
  private static Boolean qYs;
  
  public static boolean cjZ()
  {
    AppMethodBeat.i(271826);
    boolean bool;
    if (qYq != null)
    {
      bool = qYq.booleanValue();
      AppMethodBeat.o(271826);
      return bool;
    }
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV == null)
    {
      Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useManagerV2: mmkv is null");
      AppMethodBeat.o(271826);
      return false;
    }
    int i = localMultiProcessMMKV.getInt("enable_v2_task_manager", 2);
    if (i == 1) {
      bool = true;
    }
    for (;;)
    {
      qYq = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useManagerV2: [%b]", new Object[] { qYq });
      bool = qYq.booleanValue();
      AppMethodBeat.o(271826);
      return bool;
      if (i != 0)
      {
        i = ((b)h.ae(b.class)).a(b.a.vEC, 0);
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
  
  public static boolean cka()
  {
    AppMethodBeat.i(271827);
    if (qYr != null)
    {
      bool = qYr.booleanValue();
      AppMethodBeat.o(271827);
      return bool;
    }
    Object localObject = f.nCi.aal();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: mmkv is null");
      AppMethodBeat.o(271827);
      return false;
    }
    int i = ((MultiProcessMMKV)localObject).getInt("enable_single_task_dispatch", 2);
    if (i == 1) {}
    for (qYr = Boolean.TRUE;; qYr = Boolean.FALSE)
    {
      Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: [%b]", new Object[] { qYr });
      bool = qYr.booleanValue();
      AppMethodBeat.o(271827);
      return bool;
      if (i != 0) {
        break;
      }
    }
    i = ((b)h.ae(b.class)).a(b.a.vED, 0);
    if (BuildInfo.IS_FLAVOR_RED) {
      i = 1;
    }
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = Boolean.valueOf(bool);
      qYr = (Boolean)localObject;
      if ((((Boolean)localObject).booleanValue()) && (!q.is64BitRuntime()))
      {
        Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: test is64BitRuntime fail");
        qYr = Boolean.FALSE;
      }
      if ((!qYr.booleanValue()) || (cjZ())) {
        break;
      }
      qYr = Boolean.FALSE;
      break;
    }
  }
  
  public static boolean ckb()
  {
    AppMethodBeat.i(271828);
    if (qYs != null)
    {
      bool = qYs.booleanValue();
      AppMethodBeat.o(271828);
      return bool;
    }
    Object localObject = f.nCi.aal();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: mmkv is null");
      AppMethodBeat.o(271828);
      return false;
    }
    int i = ((MultiProcessMMKV)localObject).getInt("enable_three_proc_tasks_dispatch", 2);
    if (i == 1) {}
    for (qYs = Boolean.TRUE;; qYs = Boolean.FALSE)
    {
      Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: [%b]", new Object[] { qYs });
      bool = qYs.booleanValue();
      AppMethodBeat.o(271828);
      return bool;
      if (i != 0) {
        break;
      }
    }
    if (((b)h.ae(b.class)).a(b.a.vED, 0) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = Boolean.valueOf(bool);
      qYs = (Boolean)localObject;
      if ((((Boolean)localObject).booleanValue()) && (!q.is64BitRuntime()))
      {
        Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: test is64BitRuntime fail");
        qYs = Boolean.FALSE;
      }
      if ((!qYs.booleanValue()) || (cjZ())) {
        break;
      }
      qYs = Boolean.FALSE;
      break;
    }
  }
  
  public static void jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(271829);
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV != null) {
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      localMultiProcessMMKV.putInt("enable_v2_task_manager", i);
      AppMethodBeat.o(271829);
      return;
    }
  }
  
  public static void jK(boolean paramBoolean)
  {
    AppMethodBeat.i(271830);
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV != null) {
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      localMultiProcessMMKV.putInt("enable_three_proc_tasks_dispatch", i);
      AppMethodBeat.o(271830);
      return;
    }
  }
  
  public static void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(271831);
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.aal();
    if (localMultiProcessMMKV != null) {
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      localMultiProcessMMKV.putInt("enable_single_task_dispatch", i);
      AppMethodBeat.o(271831);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.n
 * JD-Core Version:    0.7.0.1
 */