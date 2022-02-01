package com.tencent.mm.live.core.debug;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/debug/LiveDebugViewMonitor;", "", "()V", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "printDebugInfo", "", "debugText", "", "printDebugTagInfo", "tag", "printErrorInfo", "printLiveInfo", "info", "release", "setup", "plugin-core_release"})
public final class a
{
  private static LiveDebugView qOK;
  public static final a qOL;
  
  static
  {
    AppMethodBeat.i(205708);
    qOL = new a();
    AppMethodBeat.o(205708);
  }
  
  public static void aUc(String paramString)
  {
    AppMethodBeat.i(205704);
    k.h(paramString, "debugText");
    ad.i("MicroMsg.LiveCore", paramString);
    LiveDebugView localLiveDebugView = qOK;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.aUc(paramString);
      AppMethodBeat.o(205704);
      return;
    }
    AppMethodBeat.o(205704);
  }
  
  public static void aUd(String paramString)
  {
    AppMethodBeat.i(205706);
    k.h(paramString, "debugText");
    ad.i("MicroMsg.LiveCoreError", paramString);
    LiveDebugView localLiveDebugView = qOK;
    if (localLiveDebugView != null)
    {
      localLiveDebugView.aUc(paramString);
      AppMethodBeat.o(205706);
      return;
    }
    AppMethodBeat.o(205706);
  }
  
  public static void aUe(String paramString)
  {
    AppMethodBeat.i(205707);
    k.h(paramString, "info");
    ad.i("MicroMsg.LiveCoreNet", paramString);
    LiveDebugView localLiveDebugView = qOK;
    if (localLiveDebugView != null)
    {
      k.h(paramString, "liveInfo");
      localLiveDebugView.qOI.setText((CharSequence)paramString);
      AppMethodBeat.o(205707);
      return;
    }
    AppMethodBeat.o(205707);
  }
  
  public static void bZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205705);
    k.h(paramString1, "tag");
    k.h(paramString2, "debugText");
    ad.i(paramString1, paramString2);
    paramString1 = qOK;
    if (paramString1 != null)
    {
      paramString1.aUc(paramString2);
      AppMethodBeat.o(205705);
      return;
    }
    AppMethodBeat.o(205705);
  }
  
  public static void c(LiveDebugView paramLiveDebugView)
  {
    AppMethodBeat.i(205703);
    k.h(paramLiveDebugView, "debugView");
    qOK = paramLiveDebugView;
    AppMethodBeat.o(205703);
  }
  
  public static void release()
  {
    qOK = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.a
 * JD-Core Version:    0.7.0.1
 */