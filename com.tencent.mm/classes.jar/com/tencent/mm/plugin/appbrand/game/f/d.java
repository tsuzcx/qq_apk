package com.tencent.mm.plugin.appbrand.game.f;

import android.content.Context;
import com.tencent.luggage.game.page.h;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.magicbrush.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.f.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public class d<PAGE extends c>
  extends h<PAGE>
  implements a
{
  private MagicBrushView htI = null;
  
  public d(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  public final MagicBrushView aq(Context paramContext)
  {
    AppMethodBeat.i(143180);
    ab.i("MicroMsg.WAGamePageViewRendererWC", "hy: create magicbrush view in wc");
    this.htI = new MagicBrushView(paramContext, new b(paramContext));
    paramContext = this.htI;
    AppMethodBeat.o(143180);
    return paramContext;
  }
  
  public final void vA()
  {
    AppMethodBeat.i(143181);
    b(a.class, this);
    AppMethodBeat.o(143181);
  }
  
  public final MagicBrushView vI()
  {
    return this.htI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.d
 * JD-Core Version:    0.7.0.1
 */