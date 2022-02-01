package com.tencent.mm.live.core.debug;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/debug/LiveDebugViewMonitor;", "", "()V", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "printDebugInfo", "", "debugText", "", "printDebugTagInfo", "tag", "printErrorInfo", "printLiveInfo", "info", "release", "setup", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a mUy;
  private static LiveDebugView mUz;
  
  static
  {
    AppMethodBeat.i(247565);
    mUy = new a();
    AppMethodBeat.o(247565);
  }
  
  public static void Ga(String paramString)
  {
    AppMethodBeat.i(247519);
    s.u(paramString, "debugText");
    Log.i("MicroMsg.LiveCore", paramString);
    LiveDebugView localLiveDebugView = mUz;
    if (localLiveDebugView != null) {
      localLiveDebugView.Ga(paramString);
    }
    AppMethodBeat.o(247519);
  }
  
  public static void Gb(String paramString)
  {
    AppMethodBeat.i(247536);
    s.u(paramString, "debugText");
    Log.i("MicroMsg.LiveCoreError", paramString);
    LiveDebugView localLiveDebugView = mUz;
    if (localLiveDebugView != null) {
      localLiveDebugView.Ga(paramString);
    }
    AppMethodBeat.o(247536);
  }
  
  public static void Gc(String paramString)
  {
    AppMethodBeat.i(247545);
    s.u(paramString, "info");
    Log.i("MicroMsg.LiveCoreNet", paramString);
    LiveDebugView localLiveDebugView = mUz;
    if (localLiveDebugView != null)
    {
      s.u(paramString, "liveInfo");
      localLiveDebugView.mUx.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(247545);
  }
  
  public static void a(LiveDebugView paramLiveDebugView)
  {
    AppMethodBeat.i(247512);
    s.u(paramLiveDebugView, "debugView");
    mUz = paramLiveDebugView;
    AppMethodBeat.o(247512);
  }
  
  public static void aH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247528);
    s.u(paramString1, "tag");
    s.u(paramString2, "debugText");
    Log.i(paramString1, paramString2);
    paramString1 = mUz;
    if (paramString1 != null) {
      paramString1.Ga(paramString2);
    }
    AppMethodBeat.o(247528);
  }
  
  public static void release()
  {
    mUz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.a
 * JD-Core Version:    0.7.0.1
 */