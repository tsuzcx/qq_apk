package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.q;

@SuppressLint({"ViewConstructor"})
public final class c
  extends x
{
  public c(Context paramContext, q paramq)
  {
    super(paramContext, paramq, new a((byte)0));
    AppMethodBeat.i(45176);
    AppMethodBeat.o(45176);
  }
  
  static final class a
    extends com.tencent.luggage.game.page.f
  {
    public final ac a(w paramw)
    {
      AppMethodBeat.i(174729);
      paramw = new d();
      paramw.a(new i.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(45173);
          com.tencent.mm.plugin.ball.f.f.e(true, true, true);
          AppMethodBeat.o(45173);
        }
      });
      paramw.a(new i.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(45174);
          com.tencent.mm.plugin.ball.f.f.e(false, true, true);
          AppMethodBeat.o(45174);
        }
      });
      AppMethodBeat.o(174729);
      return paramw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c
 * JD-Core Version:    0.7.0.1
 */