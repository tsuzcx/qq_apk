package com.google.android.exoplayer2.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class s$f
{
  private final Map<String, String> bpi;
  private Map<String, String> bpj;
  
  public s$f()
  {
    AppMethodBeat.i(93086);
    this.bpi = new HashMap();
    AppMethodBeat.o(93086);
  }
  
  public final void o(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(199882);
      this.bpj = null;
      this.bpi.put(paramString1, paramString2);
      AppMethodBeat.o(199882);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final Map<String, String> uN()
  {
    try
    {
      AppMethodBeat.i(93087);
      if (this.bpj == null) {
        this.bpj = Collections.unmodifiableMap(new HashMap(this.bpi));
      }
      Map localMap = this.bpj;
      AppMethodBeat.o(93087);
      return localMap;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.h.s.f
 * JD-Core Version:    0.7.0.1
 */