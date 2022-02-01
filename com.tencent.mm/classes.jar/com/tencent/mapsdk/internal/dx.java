package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dx
  extends ec
{
  @Json(name="detail")
  public a a;
  
  public final int a()
  {
    AppMethodBeat.i(222936);
    if (c())
    {
      int i = this.a.c.a;
      AppMethodBeat.o(222936);
      return i;
    }
    AppMethodBeat.o(222936);
    return 0;
  }
  
  public final int b()
  {
    AppMethodBeat.i(222946);
    if (c())
    {
      int i = this.a.a.c;
      AppMethodBeat.o(222946);
      return i;
    }
    AppMethodBeat.o(222946);
    return 0;
  }
  
  public final boolean c()
  {
    AppMethodBeat.i(222954);
    if ((super.c()) && (this.a != null) && (this.a.a()))
    {
      AppMethodBeat.o(222954);
      return true;
    }
    AppMethodBeat.o(222954);
    return false;
  }
  
  public static final class a
    extends ec.a
  {
    @Json(name="styleTable")
    public a a;
    
    public final boolean a()
    {
      AppMethodBeat.i(222897);
      if ((super.a()) && (dw.c.a(this.b)) && (this.a != null) && (this.a.a()))
      {
        AppMethodBeat.o(222897);
        return true;
      }
      AppMethodBeat.o(222897);
      return false;
    }
    
    public static final class a
      extends ec.c
    {
      @Json(name="theme")
      public b a;
      @Json(name="control")
      public dx.a.a.a b;
      
      public final boolean a()
      {
        AppMethodBeat.i(223566);
        if ((super.a()) && (this.a != null) && (this.b != null))
        {
          AppMethodBeat.o(223566);
          return true;
        }
        AppMethodBeat.o(223566);
        return false;
      }
      
      public static final class b
        extends JsonComposer
      {
        @Json(name="standard")
        public b a;
        
        public static final class b
          extends JsonComposer
        {
          @Json(name="defaultStyle")
          public dx.a.a.b.a a;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dx
 * JD-Core Version:    0.7.0.1
 */