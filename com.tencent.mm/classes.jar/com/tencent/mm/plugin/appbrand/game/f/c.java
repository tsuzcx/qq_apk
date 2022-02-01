package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.t;

@SuppressLint({"ViewConstructor"})
public final class c
  extends y
{
  public c(Context paramContext, t paramt)
  {
    super(paramContext, paramt, new a((byte)0));
    AppMethodBeat.i(45176);
    AppMethodBeat.o(45176);
  }
  
  static final class a
    extends com.tencent.luggage.game.page.f
  {
    public final ad a(x paramx)
    {
      AppMethodBeat.i(174729);
      paramx = new d();
      paramx.a(new h.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(45173);
          com.tencent.mm.plugin.ball.f.f.d(true, true, true);
          AppMethodBeat.o(45173);
        }
      });
      paramx.a(new h.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(45174);
          com.tencent.mm.plugin.ball.f.f.d(false, true, true);
          AppMethodBeat.o(45174);
        }
      });
      AppMethodBeat.o(174729);
      return paramx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c
 * JD-Core Version:    0.7.0.1
 */