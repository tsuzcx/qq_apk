package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface s
  extends g
{
  public static final o<String> bpf = new o() {};
  
  public static class c
    extends IOException
  {
    public final j bgL;
    public final int type;
    
    public c(IOException paramIOException, j paramj, int paramInt)
    {
      super();
      this.bgL = paramj;
      this.type = paramInt;
    }
    
    public c(String paramString, j paramj)
    {
      super();
      this.bgL = paramj;
      this.type = 1;
    }
    
    public c(String paramString, IOException paramIOException, j paramj)
    {
      super(paramIOException);
      this.bgL = paramj;
      this.type = 1;
    }
  }
  
  public static final class d
    extends s.c
  {
    public final String contentType;
    
    public d(String paramString, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(93084);
      this.contentType = paramString;
      AppMethodBeat.o(93084);
    }
  }
  
  public static final class e
    extends s.c
  {
    public final int bpg;
    public final Map<String, List<String>> bph;
    
    public e(int paramInt, Map<String, List<String>> paramMap, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(93085);
      this.bpg = paramInt;
      this.bph = paramMap;
      AppMethodBeat.o(93085);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.s
 * JD-Core Version:    0.7.0.1
 */