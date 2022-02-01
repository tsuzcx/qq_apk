package com.tencent.mm.live.core.debug;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/debug/LiveDebugViewMonitor;", "", "()V", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "printDebugInfo", "", "debugText", "", "printDebugTagInfo", "tag", "printErrorInfo", "printLiveInfo", "info", "release", "setup", "plugin-core_release"})
public final class a
{
  public static final a hCA;
  private static LiveDebugView hCz;
  
  static
  {
    AppMethodBeat.i(196569);
    hCA = new a();
    AppMethodBeat.o(196569);
  }
  
  public static void GA(String paramString)
  {
    AppMethodBeat.i(196565);
    p.h(paramString, "debugText");
    Log.i("MicroMsg.LiveCore", paramString);
    LiveDebugView localLiveDebugView = hCz;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.GA(paramString);
      AppMethodBeat.o(196565);
      return;
    }
    AppMethodBeat.o(196565);
  }
  
  public static void GB(String paramString)
  {
    AppMethodBeat.i(196567);
    p.h(paramString, "debugText");
    Log.i("MicroMsg.LiveCoreError", paramString);
    LiveDebugView localLiveDebugView = hCz;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.GA(paramString);
      AppMethodBeat.o(196567);
      return;
    }
    AppMethodBeat.o(196567);
  }
  
  public static void GC(String paramString)
  {
    AppMethodBeat.i(196568);
    p.h(paramString, "info");
    Log.i("MicroMsg.LiveCoreNet", paramString);
    LiveDebugView localLiveDebugView = hCz;
    if (localLiveDebugView != null)
    {
      p.h(paramString, "liveInfo");
      localLiveDebugView.hCx.setText((CharSequence)paramString);
      AppMethodBeat.o(196568);
      return;
    }
    AppMethodBeat.o(196568);
  }
  
  public static void au(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196566);
    p.h(paramString1, "tag");
    p.h(paramString2, "debugText");
    Log.i(paramString1, paramString2);
    paramString1 = hCz;
    if (paramString1 != null)
    {
      paramString1.GA(paramString2);
      AppMethodBeat.o(196566);
      return;
    }
    AppMethodBeat.o(196566);
  }
  
  public static void c(LiveDebugView paramLiveDebugView)
  {
    AppMethodBeat.i(196564);
    p.h(paramLiveDebugView, "debugView");
    hCz = paramLiveDebugView;
    AppMethodBeat.o(196564);
  }
  
  public static void release()
  {
    hCz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.a
 * JD-Core Version:    0.7.0.1
 */