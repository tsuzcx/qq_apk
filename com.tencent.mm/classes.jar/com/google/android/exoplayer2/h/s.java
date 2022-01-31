package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public abstract interface s
  extends g
{
  public static final o<String> aZm = new s.1();
  
  public static final class e
    extends s.c
  {
    public final Map<String, List<String>> aZo;
    public final int responseCode;
    
    public e(int paramInt, Map<String, List<String>> paramMap, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(95841);
      this.responseCode = paramInt;
      this.aZo = paramMap;
      AppMethodBeat.o(95841);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.s
 * JD-Core Version:    0.7.0.1
 */