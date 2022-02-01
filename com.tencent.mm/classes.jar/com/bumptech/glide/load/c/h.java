package com.bumptech.glide.load.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;

public abstract interface h
{
  @Deprecated
  public static final h aJW = new h()
  {
    public final Map<String, String> getHeaders()
    {
      AppMethodBeat.i(77244);
      Map localMap = Collections.emptyMap();
      AppMethodBeat.o(77244);
      return localMap;
    }
  };
  public static final h aJX;
  
  static
  {
    j.a locala = new j.a();
    locala.aKb = true;
    aJX = new j(locala.headers);
  }
  
  public abstract Map<String, String> getHeaders();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.bumptech.glide.load.c.h
 * JD-Core Version:    0.7.0.1
 */