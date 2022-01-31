package com.google.android.exoplayer2.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class s$f
{
  private final Map<String, String> aZp;
  private Map<String, String> aZq;
  
  public s$f()
  {
    AppMethodBeat.i(95842);
    this.aZp = new HashMap();
    AppMethodBeat.o(95842);
  }
  
  public final Map<String, String> qv()
  {
    try
    {
      AppMethodBeat.i(95843);
      if (this.aZq == null) {
        this.aZq = Collections.unmodifiableMap(new HashMap(this.aZp));
      }
      Map localMap = this.aZq;
      AppMethodBeat.o(95843);
      return localMap;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.s.f
 * JD-Core Version:    0.7.0.1
 */