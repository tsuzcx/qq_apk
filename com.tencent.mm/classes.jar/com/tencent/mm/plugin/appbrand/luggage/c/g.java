package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.c.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.b;
import com.tencent.mm.plugin.appbrand.service.c;

public class g
  extends c
{
  public g()
  {
    super(a.cpb);
  }
  
  static final class a
    extends b
  {
    static final b.a cpb;
    
    static
    {
      AppMethodBeat.i(47575);
      cpb = new a((byte)0);
      com.tencent.luggage.sdk.b.a.c.d.EW().a(cpb, a.class);
      AppMethodBeat.o(47575);
    }
    
    public a(c paramc)
    {
      super();
    }
    
    public final b.b EI()
    {
      AppMethodBeat.i(47574);
      b.b localb = new b.b();
      localb.name = "WAService.js";
      localb.source = com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/native/WAService.js");
      localb.coR = ("WANativeRender_" + localb.name);
      AppMethodBeat.o(47574);
      return localb;
    }
    
    static final class a
      implements b.a
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.g
 * JD-Core Version:    0.7.0.1
 */