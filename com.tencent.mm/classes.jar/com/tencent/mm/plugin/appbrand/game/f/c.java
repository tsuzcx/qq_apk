package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.u;

@SuppressLint({"ViewConstructor"})
public final class c
  extends u
{
  public c(Context paramContext, o paramo)
  {
    super(paramContext, paramo, new a((byte)0));
    AppMethodBeat.i(45176);
    AppMethodBeat.o(45176);
  }
  
  static final class a
    extends com.tencent.luggage.game.page.f
  {
    public final aa a(t paramt)
    {
      AppMethodBeat.i(174729);
      paramt = new d();
      paramt.a(new f.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(45173);
          com.tencent.mm.plugin.ball.f.f.d(true, true, true);
          AppMethodBeat.o(45173);
        }
      });
      paramt.a(new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(45174);
          com.tencent.mm.plugin.ball.f.f.d(false, true, true);
          AppMethodBeat.o(45174);
        }
      });
      AppMethodBeat.o(174729);
      return paramt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c
 * JD-Core Version:    0.7.0.1
 */