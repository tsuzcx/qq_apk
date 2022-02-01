package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lm
  implements RequestProcessor
{
  private final boolean a;
  
  private lm(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public static lm a(boolean paramBoolean)
  {
    AppMethodBeat.i(222533);
    lm locallm = new lm(paramBoolean);
    AppMethodBeat.o(222533);
    return locallm;
  }
  
  public final void onRequest(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222541);
    if (this.a)
    {
      String str2 = paramNetRequest.url;
      String str1 = str2;
      if (str2.startsWith("http://")) {
        str1 = str2.replaceFirst("http://", "https://");
      }
      paramNetRequest.url = str1;
    }
    AppMethodBeat.o(222541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lm
 * JD-Core Version:    0.7.0.1
 */