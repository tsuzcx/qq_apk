package com.tencent.mm.live.core.debug;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/debug/LiveDebugViewMonitor;", "", "()V", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "printDebugInfo", "", "debugText", "", "printDebugTagInfo", "tag", "printErrorInfo", "printLiveInfo", "info", "release", "setup", "plugin-core_release"})
public final class a
{
  private static LiveDebugView gMX;
  public static final a gMY;
  
  static
  {
    AppMethodBeat.i(196914);
    gMY = new a();
    AppMethodBeat.o(196914);
  }
  
  public static void as(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196911);
    p.h(paramString1, "tag");
    p.h(paramString2, "debugText");
    ae.i(paramString1, paramString2);
    paramString1 = gMX;
    if (paramString1 != null)
    {
      paramString1.yg(paramString2);
      AppMethodBeat.o(196911);
      return;
    }
    AppMethodBeat.o(196911);
  }
  
  public static void c(LiveDebugView paramLiveDebugView)
  {
    AppMethodBeat.i(196909);
    p.h(paramLiveDebugView, "debugView");
    gMX = paramLiveDebugView;
    AppMethodBeat.o(196909);
  }
  
  public static void release()
  {
    gMX = null;
  }
  
  public static void yg(String paramString)
  {
    AppMethodBeat.i(196910);
    p.h(paramString, "debugText");
    ae.i("MicroMsg.LiveCore", paramString);
    LiveDebugView localLiveDebugView = gMX;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.yg(paramString);
      AppMethodBeat.o(196910);
      return;
    }
    AppMethodBeat.o(196910);
  }
  
  public static void yh(String paramString)
  {
    AppMethodBeat.i(196912);
    p.h(paramString, "debugText");
    ae.i("MicroMsg.LiveCoreError", paramString);
    LiveDebugView localLiveDebugView = gMX;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.yg(paramString);
      AppMethodBeat.o(196912);
      return;
    }
    AppMethodBeat.o(196912);
  }
  
  public static void yi(String paramString)
  {
    AppMethodBeat.i(196913);
    p.h(paramString, "info");
    ae.i("MicroMsg.LiveCoreNet", paramString);
    LiveDebugView localLiveDebugView = gMX;
    if (localLiveDebugView != null)
    {
      p.h(paramString, "liveInfo");
      localLiveDebugView.gMV.setText((CharSequence)paramString);
      AppMethodBeat.o(196913);
      return;
    }
    AppMethodBeat.o(196913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.a
 * JD-Core Version:    0.7.0.1
 */