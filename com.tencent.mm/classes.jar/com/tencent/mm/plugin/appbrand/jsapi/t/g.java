package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;

public final class g
  extends m.a
{
  public static final g ifo;
  
  static
  {
    AppMethodBeat.i(145925);
    ifo = new g("ok", new Object[0]);
    AppMethodBeat.o(145925);
  }
  
  public g(String paramString, Object... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public final boolean isSuccess()
  {
    AppMethodBeat.i(145923);
    boolean bool = "ok".equals(this.errMsg);
    AppMethodBeat.o(145923);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(145924);
    String str = "VoiceCallResult{errMsg='" + this.errMsg + '\'' + '}';
    AppMethodBeat.o(145924);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.g
 * JD-Core Version:    0.7.0.1
 */