package com.tencent.mm.live.core.debug;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/debug/LiveDebugViewMonitor;", "", "()V", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "printDebugInfo", "", "debugText", "", "printDebugTagInfo", "tag", "printErrorInfo", "printLiveInfo", "info", "release", "setup", "plugin-core_release"})
public final class a
{
  private static LiveDebugView kqA;
  public static final a kqB;
  
  static
  {
    AppMethodBeat.i(198345);
    kqB = new a();
    AppMethodBeat.o(198345);
  }
  
  public static void NN(String paramString)
  {
    AppMethodBeat.i(198333);
    p.k(paramString, "debugText");
    Log.i("MicroMsg.LiveCore", paramString);
    LiveDebugView localLiveDebugView = kqA;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.NN(paramString);
      AppMethodBeat.o(198333);
      return;
    }
    AppMethodBeat.o(198333);
  }
  
  public static void NO(String paramString)
  {
    AppMethodBeat.i(198338);
    p.k(paramString, "debugText");
    Log.i("MicroMsg.LiveCoreError", paramString);
    LiveDebugView localLiveDebugView = kqA;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.NN(paramString);
      AppMethodBeat.o(198338);
      return;
    }
    AppMethodBeat.o(198338);
  }
  
  public static void NP(String paramString)
  {
    AppMethodBeat.i(198342);
    p.k(paramString, "info");
    Log.i("MicroMsg.LiveCoreNet", paramString);
    LiveDebugView localLiveDebugView = kqA;
    if (localLiveDebugView != null)
    {
      p.k(paramString, "liveInfo");
      localLiveDebugView.kqy.setText((CharSequence)paramString);
      AppMethodBeat.o(198342);
      return;
    }
    AppMethodBeat.o(198342);
  }
  
  public static void ay(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198336);
    p.k(paramString1, "tag");
    p.k(paramString2, "debugText");
    Log.i(paramString1, paramString2);
    paramString1 = kqA;
    if (paramString1 != null)
    {
      paramString1.NN(paramString2);
      AppMethodBeat.o(198336);
      return;
    }
    AppMethodBeat.o(198336);
  }
  
  public static void c(LiveDebugView paramLiveDebugView)
  {
    AppMethodBeat.i(198329);
    p.k(paramLiveDebugView, "debugView");
    kqA = paramLiveDebugView;
    AppMethodBeat.o(198329);
  }
  
  public static void release()
  {
    kqA = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.a
 * JD-Core Version:    0.7.0.1
 */