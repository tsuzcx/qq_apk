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

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 580;
  private static final String NAME = "hideVirtualBottomNavigationBar";
  
  private void y(c paramc)
  {
    AppMethodBeat.i(74810);
    paramc = com.tencent.mm.sdk.f.a.hr(paramc.getContext());
    if (paramc == null)
    {
      ab.i("JsApiHideVirtualBottomNavigationBar", "null == activity");
      AppMethodBeat.o(74810);
      return;
    }
    paramc = paramc.getWindow();
    if (paramc == null)
    {
      ab.i("JsApiHideVirtualBottomNavigationBar", "null == window");
      AppMethodBeat.o(74810);
      return;
    }
    int j = paramc.getDecorView().getSystemUiVisibility();
    int i = j;
    if (Build.VERSION.SDK_INT >= 20) {
      i = j | 0x200 | 0x2;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i | 0x1000;
    }
    i = j | 0x100;
    paramc.getDecorView().setSystemUiVisibility(i);
    paramc.getDecorView().setOnSystemUiVisibilityChangeListener(new b.2(this, paramc, i));
    AppMethodBeat.o(74810);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(74808);
    c(paramc, paramInt);
    AppMethodBeat.o(74808);
  }
  
  final void c(c paramc, int paramInt)
  {
    AppMethodBeat.i(74809);
    if (!al.isMainThread())
    {
      al.d(new b.1(this, paramc, paramInt));
      AppMethodBeat.o(74809);
      return;
    }
    ab.i("JsApiHideVirtualBottomNavigationBar", "hide");
    y(paramc);
    paramc.h(paramInt, j("ok", null));
    AppMethodBeat.o(74809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.b
 * JD-Core Version:    0.7.0.1
 */