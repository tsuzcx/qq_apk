package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.v;

@SuppressLint({"ViewConstructor"})
public final class c
  extends v
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
    public final aa a(u paramu)
    {
      AppMethodBeat.i(174729);
      paramu = new d();
      paramu.a(new f.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(45173);
          com.tencent.mm.plugin.ball.f.f.e(true, true, true);
          AppMethodBeat.o(45173);
        }
      });
      paramu.a(new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(45174);
          com.tencent.mm.plugin.ball.f.f.e(false, true, true);
          AppMethodBeat.o(45174);
        }
      });
      AppMethodBeat.o(174729);
      return paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c
 * JD-Core Version:    0.7.0.1
 */