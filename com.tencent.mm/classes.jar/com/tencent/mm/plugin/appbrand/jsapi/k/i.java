package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;

public final class i
  extends p
{
  public static final int CTRL_INDEX = 520;
  public static final String NAME = "onVoIPChatInterrupted";
  
  public i()
  {
    AppMethodBeat.i(180259);
    c.Me("onVoIPChatInterrupted");
    AppMethodBeat.o(180259);
  }
  
  final class a
  {
    String cyH;
    int errCode;
    
    public a(String paramString, int paramInt)
    {
      this.cyH = paramString;
      this.errCode = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.i
 * JD-Core Version:    0.7.0.1
 */