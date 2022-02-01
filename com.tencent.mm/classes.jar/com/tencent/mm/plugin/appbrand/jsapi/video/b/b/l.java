package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface l
  extends t
{
  public abstract i<String> bVB();
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  public static class a
    extends IOException
  {
    public final g pvN;
    
    public a(IOException paramIOException, g paramg)
    {
      super();
      this.pvN = paramg;
    }
    
    public a(String paramString, g paramg)
    {
      super();
      this.pvN = paramg;
    }
    
    public a(String paramString, IOException paramIOException, g paramg)
    {
      super(paramIOException);
      this.pvN = paramg;
    }
  }
  
  public static final class b
    extends l.a
  {
    public b(String paramString, g paramg)
    {
      super(paramg);
    }
    
    public b(String paramString, IOException paramIOException, g paramg)
    {
      super(paramIOException, paramg);
    }
  }
  
  public static final class c
    extends l.a
  {
    public c(String paramString, g paramg)
    {
      super(paramg);
    }
  }
  
  public static final class d
    extends l.a
  {
    public d(String paramString, g paramg)
    {
      super(paramg);
    }
  }
  
  public static final class e
    extends l.a
  {
    public final Map<String, List<String>> bph;
    public final String contentType;
    
    public e(String paramString, Map<String, List<String>> paramMap, g paramg)
    {
      super(paramg);
      AppMethodBeat.i(230605);
      this.contentType = paramString;
      this.bph = paramMap;
      AppMethodBeat.o(230605);
    }
  }
  
  public static final class f
    extends l.a
  {
    public final int bpg;
    public final Map<String, List<String>> bph;
    
    public f(int paramInt, Map<String, List<String>> paramMap, g paramg)
    {
      super(paramg);
      AppMethodBeat.i(228933);
      this.bpg = paramInt;
      this.bph = paramMap;
      AppMethodBeat.o(228933);
    }
  }
  
  public static final class g
    extends l.a
  {
    public g(String paramString, g paramg)
    {
      super(paramg);
    }
  }
  
  public static final class h
    extends l.a
  {
    public h(String paramString, IOException paramIOException, g paramg)
    {
      super(paramIOException, paramg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l
 * JD-Core Version:    0.7.0.1
 */