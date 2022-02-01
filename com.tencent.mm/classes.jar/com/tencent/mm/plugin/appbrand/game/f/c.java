package com.tencent.mm.plugin.appbrand.game.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.w;

public final class c
  extends y
{
  public c(Context paramContext, w paramw)
  {
    super(paramContext, paramw, new a((byte)0));
    AppMethodBeat.i(45176);
    AppMethodBeat.o(45176);
  }
  
  static final class a
    extends com.tencent.luggage.game.page.f
  {
    public final ad a(x paramx, String paramString)
    {
      AppMethodBeat.i(318440);
      paramx = new d();
      paramx.a(new i.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(45173);
          com.tencent.mm.plugin.ball.f.f.d(true, true, true);
          AppMethodBeat.o(45173);
        }
      });
      paramx.a(new i.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(45174);
          com.tencent.mm.plugin.ball.f.f.d(false, true, true);
          AppMethodBeat.o(45174);
        }
      });
      AppMethodBeat.o(318440);
      return paramx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c
 * JD-Core Version:    0.7.0.1
 */