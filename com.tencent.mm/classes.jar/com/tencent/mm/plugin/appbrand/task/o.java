package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.performance.watchdogs.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskABTests;", "", "()V", "IS_TEST_VERSION", "", "getIS_TEST_VERSION", "()Z", "disallowPreloadAppBrandProcessWhenWXInBackground", "enablePreloadForChatting", "enablePreloadForScanCode", "enabledKillSpareProcessOnBackgroundModerate", "enabledRecycleRuntimeOnLowMemoryModerate", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o tWD;
  
  static
  {
    AppMethodBeat.i(318572);
    tWD = new o();
    AppMethodBeat.o(318572);
  }
  
  private static boolean cJZ()
  {
    boolean bool2 = false;
    int i = BuildInfo.CLIENT_VERSION_INT;
    boolean bool1 = bool2;
    if (671092576 <= i)
    {
      bool1 = bool2;
      if (i <= 671092735) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean cKa()
  {
    AppMethodBeat.i(318551);
    int i;
    if (BuildInfo.IS_FLAVOR_RED) {
      i = 1;
    }
    while ((((c)h.ax(c.class)).a(c.a.yOP, i) == 1) && (a.gzn()))
    {
      AppMethodBeat.o(318551);
      return true;
      if (cJZ()) {
        i = 1;
      } else {
        i = 0;
      }
    }
    AppMethodBeat.o(318551);
    return false;
  }
  
  public static final boolean cKb()
  {
    AppMethodBeat.i(318556);
    if ((((c)h.ax(c.class)).a(c.a.yOQ, 1) == 1) && (a.gzn()))
    {
      AppMethodBeat.o(318556);
      return true;
    }
    AppMethodBeat.o(318556);
    return false;
  }
  
  public static final boolean cKc()
  {
    AppMethodBeat.i(318562);
    int i;
    if (BuildInfo.IS_FLAVOR_RED) {
      i = 1;
    }
    while ((((c)h.ax(c.class)).a(c.a.yOO, i) == 1) && (a.gzn()))
    {
      AppMethodBeat.o(318562);
      return true;
      if (cJZ()) {
        i = 1;
      } else {
        i = 0;
      }
    }
    AppMethodBeat.o(318562);
    return false;
  }
  
  public static final boolean cKd()
  {
    return false;
  }
  
  public static final boolean cKe()
  {
    AppMethodBeat.i(318569);
    if (((c)h.ax(c.class)).a(c.a.yOS, 0) == 1)
    {
      AppMethodBeat.o(318569);
      return true;
    }
    AppMethodBeat.o(318569);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.o
 * JD-Core Version:    0.7.0.1
 */