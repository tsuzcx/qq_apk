package com.tencent.mm.live.core.debug;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/debug/LiveDebugViewMonitor;", "", "()V", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "printDebugInfo", "", "debugText", "", "printDebugTagInfo", "tag", "printErrorInfo", "printLiveInfo", "info", "release", "setup", "plugin-core_release"})
public final class a
{
  private static LiveDebugView gqE;
  public static final a gqF;
  
  static
  {
    AppMethodBeat.i(209244);
    gqF = new a();
    AppMethodBeat.o(209244);
  }
  
  public static void aq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209241);
    k.h(paramString1, "tag");
    k.h(paramString2, "debugText");
    ac.i(paramString1, paramString2);
    paramString1 = gqE;
    if (paramString1 != null)
    {
      paramString1.uG(paramString2);
      AppMethodBeat.o(209241);
      return;
    }
    AppMethodBeat.o(209241);
  }
  
  public static void c(LiveDebugView paramLiveDebugView)
  {
    AppMethodBeat.i(209239);
    k.h(paramLiveDebugView, "debugView");
    gqE = paramLiveDebugView;
    AppMethodBeat.o(209239);
  }
  
  public static void release()
  {
    gqE = null;
  }
  
  public static void uG(String paramString)
  {
    AppMethodBeat.i(209240);
    k.h(paramString, "debugText");
    ac.i("MicroMsg.LiveCore", paramString);
    LiveDebugView localLiveDebugView = gqE;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.uG(paramString);
      AppMethodBeat.o(209240);
      return;
    }
    AppMethodBeat.o(209240);
  }
  
  public static void uH(String paramString)
  {
    AppMethodBeat.i(209242);
    k.h(paramString, "debugText");
    ac.i("MicroMsg.LiveCoreError", paramString);
    LiveDebugView localLiveDebugView = gqE;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.uG(paramString);
      AppMethodBeat.o(209242);
      return;
    }
    AppMethodBeat.o(209242);
  }
  
  public static void uI(String paramString)
  {
    AppMethodBeat.i(209243);
    k.h(paramString, "info");
    ac.i("MicroMsg.LiveCoreNet", paramString);
    LiveDebugView localLiveDebugView = gqE;
    if (localLiveDebugView != null)
    {
      k.h(paramString, "liveInfo");
      localLiveDebugView.gqC.setText((CharSequence)paramString);
      AppMethodBeat.o(209243);
      return;
    }
    AppMethodBeat.o(209243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.a
 * JD-Core Version:    0.7.0.1
 */