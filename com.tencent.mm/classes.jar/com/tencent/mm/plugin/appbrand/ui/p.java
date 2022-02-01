package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class p
{
  private static Boolean nWO;
  private static Boolean nWP;
  private static Boolean nWQ;
  
  public static boolean bXu()
  {
    AppMethodBeat.i(227670);
    boolean bool;
    if (nWO != null)
    {
      bool = nWO.booleanValue();
      AppMethodBeat.o(227670);
      return bool;
    }
    MultiProcessMMKV localMultiProcessMMKV = f.kIs.VQ();
    if (localMultiProcessMMKV == null)
    {
      Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useManagerV2: mmkv is null");
      AppMethodBeat.o(227670);
      return false;
    }
    int i = localMultiProcessMMKV.getInt("enable_v2_task_manager", 2);
    if (i == 1) {
      bool = true;
    }
    for (;;)
    {
      nWO = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useManagerV2: [%b]", new Object[] { nWO });
      bool = nWO.booleanValue();
      AppMethodBeat.o(227670);
      return bool;
      if (i != 0)
      {
        i = ((b)g.af(b.class)).a(b.a.rXJ, 0);
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
  
  public static boolean bXv()
  {
    AppMethodBeat.i(227671);
    if (nWP != null)
    {
      bool = nWP.booleanValue();
      AppMethodBeat.o(227671);
      return bool;
    }
    Object localObject = f.kIs.VQ();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: mmkv is null");
      AppMethodBeat.o(227671);
      return false;
    }
    int i = ((MultiProcessMMKV)localObject).getInt("enable_single_task_dispatch", 2);
    if (i == 1) {}
    for (nWP = Boolean.TRUE;; nWP = Boolean.FALSE)
    {
      Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: [%b]", new Object[] { nWP });
      bool = nWP.booleanValue();
      AppMethodBeat.o(227671);
      return bool;
      if (i != 0) {
        break;
      }
    }
    i = ((b)g.af(b.class)).a(b.a.rXK, 0);
    if (BuildInfo.IS_FLAVOR_RED) {
      i = 1;
    }
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = Boolean.valueOf(bool);
      nWP = (Boolean)localObject;
      if ((((Boolean)localObject).booleanValue()) && (!q.is64BitRuntime()))
      {
        Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: test is64BitRuntime fail");
        nWP = Boolean.FALSE;
      }
      if ((!nWP.booleanValue()) || (bXu())) {
        break;
      }
      nWP = Boolean.FALSE;
      break;
    }
  }
  
  public static boolean bXw()
  {
    AppMethodBeat.i(227672);
    if (nWQ != null)
    {
      bool = nWQ.booleanValue();
      AppMethodBeat.o(227672);
      return bool;
    }
    Object localObject = f.kIs.VQ();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: mmkv is null");
      AppMethodBeat.o(227672);
      return false;
    }
    int i = ((MultiProcessMMKV)localObject).getInt("enable_three_proc_tasks_dispatch", 2);
    if (i == 1) {}
    for (nWQ = Boolean.TRUE;; nWQ = Boolean.FALSE)
    {
      Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: [%b]", new Object[] { nWQ });
      bool = nWQ.booleanValue();
      AppMethodBeat.o(227672);
      return bool;
      if (i != 0) {
        break;
      }
    }
    if (((b)g.af(b.class)).a(b.a.rXK, 0) == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = Boolean.valueOf(bool);
      nWQ = (Boolean)localObject;
      if ((((Boolean)localObject).booleanValue()) && (!q.is64BitRuntime()))
      {
        Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: test is64BitRuntime fail");
        nWQ = Boolean.FALSE;
      }
      if ((!nWQ.booleanValue()) || (bXu())) {
        break;
      }
      nWQ = Boolean.FALSE;
      break;
    }
  }
  
  public static void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(227673);
    MultiProcessMMKV localMultiProcessMMKV = f.kIs.VQ();
    if (localMultiProcessMMKV != null) {
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      localMultiProcessMMKV.putInt("enable_v2_task_manager", i);
      AppMethodBeat.o(227673);
      return;
    }
  }
  
  public static void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(227674);
    MultiProcessMMKV localMultiProcessMMKV = f.kIs.VQ();
    if (localMultiProcessMMKV != null) {
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      localMultiProcessMMKV.putInt("enable_three_proc_tasks_dispatch", i);
      AppMethodBeat.o(227674);
      return;
    }
  }
  
  public static void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(227675);
    MultiProcessMMKV localMultiProcessMMKV = f.kIs.VQ();
    if (localMultiProcessMMKV != null) {
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      localMultiProcessMMKV.putInt("enable_single_task_dispatch", i);
      AppMethodBeat.o(227675);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p
 * JD-Core Version:    0.7.0.1
 */