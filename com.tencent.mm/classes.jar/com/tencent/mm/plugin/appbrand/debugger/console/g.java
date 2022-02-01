package com.tencent.mm.plugin.appbrand.debugger.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/FloatConsolePrinter;", "", "()V", "TAG", "", "controlFloatWindow", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintControlFloatWindow;", "isEnable", "", "printFloatWindow", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintPanelFloatWindow;", "disable", "", "enable", "logD", "msg", "logE", "logI", "logV", "logW", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static boolean egk;
  public static final g rfT;
  private static final a rfU;
  private static final d rfV;
  
  static
  {
    AppMethodBeat.i(319853);
    rfT = new g();
    rfU = new a((byte)0);
    rfV = new d((byte)0);
    rfU.meC = ((kotlin.g.a.a)1.rfW);
    rfV.rfw = ((kotlin.g.a.a)2.rfX);
    rfV.rfx = ((kotlin.g.a.a)3.rfY);
    AppMethodBeat.o(319853);
  }
  
  public static void Np(String paramString)
  {
    AppMethodBeat.i(319810);
    s.u(paramString, "msg");
    if (egk) {
      rfV.getPrinter().Yq(paramString);
    }
    AppMethodBeat.o(319810);
  }
  
  public static void Yt(String paramString)
  {
    AppMethodBeat.i(319795);
    s.u(paramString, "msg");
    if (egk) {
      rfV.getPrinter().Yo(paramString);
    }
    AppMethodBeat.o(319795);
  }
  
  public static void Yu(String paramString)
  {
    AppMethodBeat.i(319801);
    s.u(paramString, "msg");
    if (egk) {
      rfV.getPrinter().Yp(paramString);
    }
    AppMethodBeat.o(319801);
  }
  
  public static void Yv(String paramString)
  {
    AppMethodBeat.i(319821);
    s.u(paramString, "msg");
    if (egk) {
      rfV.getPrinter().Yr(paramString);
    }
    AppMethodBeat.o(319821);
  }
  
  public static void Yw(String paramString)
  {
    AppMethodBeat.i(319828);
    s.u(paramString, "msg");
    if (egk) {
      rfV.getPrinter().Ys(paramString);
    }
    AppMethodBeat.o(319828);
  }
  
  public static void disable()
  {
    AppMethodBeat.i(319788);
    boolean bool = egk;
    Log.i("MicroMsg.AppBrand.FloatConsolePrinter", s.X("disable, curIsEnable: ", Boolean.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(319788);
      return;
    }
    egk = false;
    rfU.hide();
    rfV.hide();
    AppMethodBeat.o(319788);
  }
  
  public static void enable()
  {
    AppMethodBeat.i(319782);
    boolean bool = egk;
    Log.i("MicroMsg.AppBrand.FloatConsolePrinter", s.X("enable, curIsEnable: ", Boolean.valueOf(bool)));
    if (bool)
    {
      AppMethodBeat.o(319782);
      return;
    }
    egk = true;
    rfU.show();
    AppMethodBeat.o(319782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.g
 * JD-Core Version:    0.7.0.1
 */