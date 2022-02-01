package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dy
  extends ec
{
  @Json(name="detail")
  public a a;
  
  public final int a()
  {
    AppMethodBeat.i(222930);
    if (c())
    {
      int i = this.a.c.a;
      AppMethodBeat.o(222930);
      return i;
    }
    AppMethodBeat.o(222930);
    return 0;
  }
  
  public final int b()
  {
    AppMethodBeat.i(222940);
    if (c())
    {
      int i = this.a.a.c;
      AppMethodBeat.o(222940);
      return i;
    }
    AppMethodBeat.o(222940);
    return 0;
  }
  
  public final boolean c()
  {
    AppMethodBeat.i(222947);
    if ((super.c()) && (this.a != null) && (this.a.a()))
    {
      AppMethodBeat.o(222947);
      return true;
    }
    AppMethodBeat.o(222947);
    return false;
  }
  
  public static final class a
    extends ec.a
  {
    @Json(name="styleTable")
    public a a;
    
    public final boolean a()
    {
      AppMethodBeat.i(226130);
      if ((super.a()) && (dw.d.a(this.b)) && (this.a != null) && (this.a.a()))
      {
        AppMethodBeat.o(226130);
        return true;
      }
      AppMethodBeat.o(226130);
      return false;
    }
    
    public static final class a
      extends ec.c
    {
      @Json(name="theme")
      public b a;
      @Json(name="control")
      public dy.a.a.a b;
      
      public static final class b
        extends JsonComposer
      {
        @Json(name="standard")
        public b a;
        
        public static final class b
          extends JsonComposer
        {
          @Json(name="defaultStyle")
          public dy.a.a.b.a a;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dy
 * JD-Core Version:    0.7.0.1
 */