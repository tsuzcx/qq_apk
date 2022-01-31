package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 580;
  private static final String NAME = "showVirtualBottomNavigationBar";
  
  private static void y(c paramc)
  {
    AppMethodBeat.i(74817);
    paramc = com.tencent.mm.sdk.f.a.hr(paramc.getContext());
    if (paramc == null)
    {
      ab.i("JsApiShowVirtualBottomNavigationBar", "null == activity");
      AppMethodBeat.o(74817);
      return;
    }
    paramc = paramc.getWindow();
    if (paramc == null)
    {
      ab.i("JsApiShowVirtualBottomNavigationBar", "null == window");
      AppMethodBeat.o(74817);
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
    AppMethodBeat.o(74817);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(74815);
    c(paramc, paramInt);
    AppMethodBeat.o(74815);
  }
  
  final void c(c paramc, int paramInt)
  {
    AppMethodBeat.i(74816);
    if (!al.isMainThread())
    {
      al.d(new e.1(this, paramc, paramInt));
      AppMethodBeat.o(74816);
      return;
    }
    ab.i("JsApiShowVirtualBottomNavigationBar", "show");
    y(paramc);
    paramc.h(paramInt, j("ok", null));
    AppMethodBeat.o(74816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.e
 * JD-Core Version:    0.7.0.1
 */