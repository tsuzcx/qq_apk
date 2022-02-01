package com.danikula.videocache.headers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class EmptyHeadersInjector
  implements HeaderInjector
{
  public Map<String, String> addHeaders(String paramString)
  {
    AppMethodBeat.i(215904);
    paramString = new HashMap();
    AppMethodBeat.o(215904);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.danikula.videocache.headers.EmptyHeadersInjector
 * JD-Core Version:    0.7.0.1
 */