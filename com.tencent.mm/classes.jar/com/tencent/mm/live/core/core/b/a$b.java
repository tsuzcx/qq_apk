package com.tencent.mm.live.core.core.b;

import com.qcloud.qvb.LoggerCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/p2p/MMXp2pWrapper$initWith$1", "Lcom/qcloud/qvb/LoggerCallback;", "d", "", "tag", "", "msg", "e", "i", "v", "w", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  extends LoggerCallback
{
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247866);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(247866);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247883);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(247883);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247875);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(247875);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247861);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(247861);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247879);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(247879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */