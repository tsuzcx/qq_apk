package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface s
  extends g
{
  public static final o<String> bxm = new o() {};
  
  public static abstract class a
    implements s.b
  {
    private final s.f bxg = new s.f();
    
    protected abstract s a(s.f paramf);
    
    @Deprecated
    public final void setDefaultRequestProperty(String paramString1, String paramString2)
    {
      this.bxg.set(paramString1, paramString2);
    }
  }
  
  public static abstract interface b
    extends g.a
  {
    @Deprecated
    public abstract void setDefaultRequestProperty(String paramString1, String paramString2);
  }
  
  public static class c
    extends IOException
  {
    public final j bml;
    public final int type;
    
    public c(IOException paramIOException, j paramj, int paramInt)
    {
      super();
      this.bml = paramj;
      this.type = paramInt;
    }
    
    public c(String paramString, j paramj)
    {
      super();
      this.bml = paramj;
      this.type = 1;
    }
    
    public c(String paramString, IOException paramIOException, j paramj)
    {
      super(paramIOException);
      this.bml = paramj;
      this.type = 1;
    }
  }
  
  public static final class d
    extends s.c
  {
    public final String bxn;
    
    public d(String paramString, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(93084);
      this.bxn = paramString;
      AppMethodBeat.o(93084);
    }
  }
  
  public static final class e
    extends s.c
  {
    public final Map<String, List<String>> bxo;
    public final int responseCode;
    
    public e(int paramInt, Map<String, List<String>> paramMap, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(93085);
      this.responseCode = paramInt;
      this.bxo = paramMap;
      AppMethodBeat.o(93085);
    }
  }
  
  public static final class f
  {
    private final Map<String, String> bxp;
    private Map<String, String> bxq;
    
    public f()
    {
      AppMethodBeat.i(93086);
      this.bxp = new HashMap();
      AppMethodBeat.o(93086);
    }
    
    public final void set(String paramString1, String paramString2)
    {
      try
      {
        AppMethodBeat.i(189789);
        this.bxq = null;
        this.bxp.put(paramString1, paramString2);
        AppMethodBeat.o(189789);
        return;
      }
      finally
      {
        paramString1 = finally;
        throw paramString1;
      }
    }
    
    public final Map<String, String> vq()
    {
      try
      {
        AppMethodBeat.i(93087);
        if (this.bxq == null) {
          this.bxq = Collections.unmodifiableMap(new HashMap(this.bxp));
        }
        Map localMap = this.bxq;
        AppMethodBeat.o(93087);
        return localMap;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.s
 * JD-Core Version:    0.7.0.1
 */