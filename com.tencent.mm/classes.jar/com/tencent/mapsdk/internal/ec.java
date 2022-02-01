package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract class ec
  extends JsonComposer
{
  @Json(name="info")
  public b b;
  
  public abstract int a();
  
  public abstract int b();
  
  public boolean c()
  {
    return (this.b != null) && (this.b.a == 0);
  }
  
  public static class a
    extends JsonComposer
  {
    @Json(name="layerType")
    public String b;
    @Json(name="data")
    public a c;
    
    public boolean a()
    {
      AppMethodBeat.i(221771);
      if (this.c != null)
      {
        a locala = this.c;
        if ((locala.b != null) && (locala.b.size() > 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(221771);
          return true;
        }
      }
      AppMethodBeat.o(221771);
      return false;
    }
    
    public static final class a
      extends JsonComposer
    {
      @Json(name="version")
      public int a;
      @Json(name="default")
      public List<ec.a.a.a> b;
      
      private boolean a()
      {
        AppMethodBeat.i(221455);
        if ((this.b != null) && (this.b.size() > 0))
        {
          AppMethodBeat.o(221455);
          return true;
        }
        AppMethodBeat.o(221455);
        return false;
      }
    }
  }
  
  public static final class b
    extends JsonComposer
  {
    @Json(name="error")
    public int a;
    @Json(name="msg")
    public String b;
  }
  
  public static abstract class c
    extends JsonComposer
  {
    @Json(name="version")
    public int c;
    @Json(name="mapping")
    public b d;
    
    public boolean a()
    {
      return true;
    }
    
    public static final class b
      extends JsonComposer
    {
      @Json(name="rule")
      public a a;
      
      public static final class a
        extends JsonComposer
      {
        @Json(name="default")
        public String a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ec
 * JD-Core Version:    0.7.0.1
 */