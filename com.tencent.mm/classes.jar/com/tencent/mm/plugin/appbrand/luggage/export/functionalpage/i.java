package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.z;

public final class i
  extends z
  implements m
{
  private volatile l ioA;
  
  i()
  {
    super(a.class);
  }
  
  public final l aBq()
  {
    AppMethodBeat.i(132134);
    l locall = new l(this);
    this.ioA = locall;
    AppMethodBeat.o(132134);
    return locall;
  }
  
  public final void aHI() {}
  
  public final l aHz()
  {
    return this.ioA;
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(132136);
    ((j)super.getRuntime()).ioI.a(this, paramInt, paramString);
    AppMethodBeat.o(132136);
  }
  
  public final void wm()
  {
    AppMethodBeat.i(132138);
    try
    {
      super.wm();
      AppMethodBeat.o(132138);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(132138);
    }
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.page.a<i>
  {
    public a(i parami)
    {
      super();
    }
    
    public final boolean bX(String paramString)
    {
      AppMethodBeat.i(143454);
      ((i)this.bDN).A(new i.a.1(this));
      AppMethodBeat.o(143454);
      return true;
    }
    
    public final ap cX(Context paramContext)
    {
      AppMethodBeat.i(143453);
      paramContext = new com.tencent.luggage.game.page.a();
      AppMethodBeat.o(143453);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i
 * JD-Core Version:    0.7.0.1
 */