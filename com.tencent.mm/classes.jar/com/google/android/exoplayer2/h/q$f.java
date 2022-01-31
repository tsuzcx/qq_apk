package com.google.android.exoplayer2.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class q$f
{
  private final Map<String, String> aRP = new HashMap();
  private Map<String, String> aRQ;
  
  public final Map<String, String> nY()
  {
    try
    {
      if (this.aRQ == null) {
        this.aRQ = Collections.unmodifiableMap(new HashMap(this.aRP));
      }
      Map localMap = this.aRQ;
      return localMap;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.q.f
 * JD-Core Version:    0.7.0.1
 */