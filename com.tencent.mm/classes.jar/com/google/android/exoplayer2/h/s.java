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
  public static final o<String> diM = new o() {};
  
  public static abstract class a
    implements s.b
  {
    private final s.f diK = new s.f();
    
    protected abstract s a(s.f paramf);
    
    @Deprecated
    public final void setDefaultRequestProperty(String paramString1, String paramString2)
    {
      this.diK.set(paramString1, paramString2);
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
    public final j daF;
    public final int type;
    
    public c(IOException paramIOException, j paramj, int paramInt)
    {
      super();
      this.daF = paramj;
      this.type = paramInt;
    }
    
    public c(String paramString, j paramj)
    {
      super();
      this.daF = paramj;
      this.type = 1;
    }
    
    public c(String paramString, IOException paramIOException, j paramj)
    {
      super(paramIOException);
      this.daF = paramj;
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
    public final Map<String, List<String>> headerFields;
    public final int responseCode;
    
    public e(int paramInt, Map<String, List<String>> paramMap, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(93085);
      this.responseCode = paramInt;
      this.headerFields = paramMap;
      AppMethodBeat.o(93085);
    }
  }
  
  public static final class f
  {
    private final Map<String, String> requestProperties;
    private Map<String, String> requestPropertiesSnapshot;
    
    public f()
    {
      AppMethodBeat.i(93086);
      this.requestProperties = new HashMap();
      AppMethodBeat.o(93086);
    }
    
    public final Map<String, String> getSnapshot()
    {
      try
      {
        AppMethodBeat.i(93087);
        if (this.requestPropertiesSnapshot == null) {
          this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
        }
        Map localMap = this.requestPropertiesSnapshot;
        AppMethodBeat.o(93087);
        return localMap;
      }
      finally {}
    }
    
    public final void set(String paramString1, String paramString2)
    {
      try
      {
        AppMethodBeat.i(210325);
        this.requestPropertiesSnapshot = null;
        this.requestProperties.put(paramString1, paramString2);
        AppMethodBeat.o(210325);
        return;
      }
      finally
      {
        paramString1 = finally;
        throw paramString1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.s
 * JD-Core Version:    0.7.0.1
 */