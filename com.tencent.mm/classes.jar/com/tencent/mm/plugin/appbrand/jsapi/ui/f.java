package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 580;
  private static final String NAME = "showVirtualBottomNavigationBar";
  
  private static void D(c paramc)
  {
    AppMethodBeat.i(138282);
    paramc = com.tencent.mm.sdk.f.a.jw(paramc.getContext());
    if (paramc == null)
    {
      ae.i("JsApiShowVirtualBottomNavigationBar", "null == activity");
      AppMethodBeat.o(138282);
      return;
    }
    paramc = paramc.getWindow();
    if (paramc == null)
    {
      ae.i("JsApiShowVirtualBottomNavigationBar", "null == window");
      AppMethodBeat.o(138282);
      return;
    }
    int j = paramc.getDecorView().getSystemUiVisibility();
    int i = j;
    if (Build.VERSION.SDK_INT >= 20) {
      i = j & 0xFFFFFDFF & 0xFFFFFFFD;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i & 0xFFFFEFFF;
    }
    paramc.getDecorView().setSystemUiVisibility(j & 0xFFFFFEFF);
    paramc.getDecorView().setOnSystemUiVisibilityChangeListener(null);
    AppMethodBeat.o(138282);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138280);
    d(paramc, paramInt);
    AppMethodBeat.o(138280);
  }
  
  final void d(final c paramc, final int paramInt)
  {
    AppMethodBeat.i(138281);
    if (!ar.isMainThread())
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138279);
          f.this.d(paramc, paramInt);
          AppMethodBeat.o(138279);
        }
      });
      AppMethodBeat.o(138281);
      return;
    }
    ae.i("JsApiShowVirtualBottomNavigationBar", "show");
    D(paramc);
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(138281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.f
 * JD-Core Version:    0.7.0.1
 */