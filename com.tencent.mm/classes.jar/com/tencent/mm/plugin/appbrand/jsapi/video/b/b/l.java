package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface l
  extends t
{
  public abstract i<String> bcY();
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  public static class a
    extends IOException
  {
    public final g kou;
    
    public a(IOException paramIOException, g paramg)
    {
      super();
      this.kou = paramg;
    }
    
    public a(String paramString, g paramg)
    {
      super();
      this.kou = paramg;
    }
    
    public a(String paramString, IOException paramIOException, g paramg)
    {
      super(paramIOException);
      this.kou = paramg;
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
    public final String bxn;
    public final Map<String, List<String>> bxo;
    
    public e(String paramString, Map<String, List<String>> paramMap, g paramg)
    {
      super(paramg);
      AppMethodBeat.i(193902);
      this.bxn = paramString;
      this.bxo = paramMap;
      AppMethodBeat.o(193902);
    }
  }
  
  public static final class f
    extends l.a
  {
    public final Map<String, List<String>> bxo;
    public final int responseCode;
    
    public f(int paramInt, Map<String, List<String>> paramMap, g paramg)
    {
      super(paramg);
      AppMethodBeat.i(193903);
      this.responseCode = paramInt;
      this.bxo = paramMap;
      AppMethodBeat.o(193903);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l
 * JD-Core Version:    0.7.0.1
 */