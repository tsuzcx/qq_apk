package com.tencent.mm.live.core.debug;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/debug/LiveDebugViewMonitor;", "", "()V", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "printDebugInfo", "", "debugText", "", "printDebugTagInfo", "tag", "printErrorInfo", "printLiveInfo", "info", "release", "setup", "plugin-core_release"})
public final class a
{
  private static LiveDebugView gKo;
  public static final a gKp;
  
  static
  {
    AppMethodBeat.i(216902);
    gKp = new a();
    AppMethodBeat.o(216902);
  }
  
  public static void ar(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216899);
    p.h(paramString1, "tag");
    p.h(paramString2, "debugText");
    ad.i(paramString1, paramString2);
    paramString1 = gKo;
    if (paramString1 != null)
    {
      paramString1.xx(paramString2);
      AppMethodBeat.o(216899);
      return;
    }
    AppMethodBeat.o(216899);
  }
  
  public static void c(LiveDebugView paramLiveDebugView)
  {
    AppMethodBeat.i(216897);
    p.h(paramLiveDebugView, "debugView");
    gKo = paramLiveDebugView;
    AppMethodBeat.o(216897);
  }
  
  public static void release()
  {
    gKo = null;
  }
  
  public static void xx(String paramString)
  {
    AppMethodBeat.i(216898);
    p.h(paramString, "debugText");
    ad.i("MicroMsg.LiveCore", paramString);
    LiveDebugView localLiveDebugView = gKo;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.xx(paramString);
      AppMethodBeat.o(216898);
      return;
    }
    AppMethodBeat.o(216898);
  }
  
  public static void xy(String paramString)
  {
    AppMethodBeat.i(216900);
    p.h(paramString, "debugText");
    ad.i("MicroMsg.LiveCoreError", paramString);
    LiveDebugView localLiveDebugView = gKo;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.xx(paramString);
      AppMethodBeat.o(216900);
      return;
    }
    AppMethodBeat.o(216900);
  }
  
  public static void xz(String paramString)
  {
    AppMethodBeat.i(216901);
    p.h(paramString, "info");
    ad.i("MicroMsg.LiveCoreNet", paramString);
    LiveDebugView localLiveDebugView = gKo;
    if (localLiveDebugView != null)
    {
      p.h(paramString, "liveInfo");
      localLiveDebugView.gKm.setText((CharSequence)paramString);
      AppMethodBeat.o(216901);
      return;
    }
    AppMethodBeat.o(216901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.a
 * JD-Core Version:    0.7.0.1
 */