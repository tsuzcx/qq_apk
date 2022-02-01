package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 580;
  private static final String NAME = "hideVirtualBottomNavigationBar";
  
  private void D(final c paramc)
  {
    AppMethodBeat.i(138278);
    paramc = com.tencent.mm.sdk.f.a.jg(paramc.getContext());
    if (paramc == null)
    {
      ac.i("JsApiHideVirtualBottomNavigationBar", "null == activity");
      AppMethodBeat.o(138278);
      return;
    }
    paramc = paramc.getWindow();
    if (paramc == null)
    {
      ac.i("JsApiHideVirtualBottomNavigationBar", "null == window");
      AppMethodBeat.o(138278);
      return;
    }
    int j = paramc.getDecorView().getSystemUiVisibility();
    final int i = j;
    if (Build.VERSION.SDK_INT >= 20) {
      i = j | 0x200 | 0x2;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i | 0x1000;
    }
    i = j | 0x100;
    paramc.getDecorView().setSystemUiVisibility(i);
    paramc.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(138275);
        if ((paramAnonymousInt & 0x4) == 0) {
          paramc.getDecorView().setSystemUiVisibility(i);
        }
        AppMethodBeat.o(138275);
      }
    });
    AppMethodBeat.o(138278);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138276);
    d(paramc, paramInt);
    AppMethodBeat.o(138276);
  }
  
  final void d(final c paramc, final int paramInt)
  {
    AppMethodBeat.i(138277);
    if (!ap.isMainThread())
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138274);
          d.this.d(paramc, paramInt);
          AppMethodBeat.o(138274);
        }
      });
      AppMethodBeat.o(138277);
      return;
    }
    ac.i("JsApiHideVirtualBottomNavigationBar", "hide");
    D(paramc);
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(138277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.d
 * JD-Core Version:    0.7.0.1
 */