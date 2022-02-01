package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 580;
  private static final String NAME = "hideVirtualBottomNavigationBar";
  
  private void H(final e parame)
  {
    AppMethodBeat.i(138278);
    parame = AndroidContextUtil.castActivityOrNull(parame.getContext());
    if (parame == null)
    {
      Log.i("JsApiHideVirtualBottomNavigationBar", "null == activity");
      AppMethodBeat.o(138278);
      return;
    }
    parame = parame.getWindow();
    if (parame == null)
    {
      Log.i("JsApiHideVirtualBottomNavigationBar", "null == window");
      AppMethodBeat.o(138278);
      return;
    }
    int j = parame.getDecorView().getSystemUiVisibility();
    final int i = j;
    if (Build.VERSION.SDK_INT >= 20) {
      i = j | 0x200 | 0x2;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i | 0x1000;
    }
    i = j | 0x100;
    parame.getDecorView().setSystemUiVisibility(i);
    parame.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public final void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(138275);
        if ((paramAnonymousInt & 0x4) == 0) {
          parame.getDecorView().setSystemUiVisibility(i);
        }
        AppMethodBeat.o(138275);
      }
    });
    AppMethodBeat.o(138278);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138276);
    d(parame, paramInt);
    AppMethodBeat.o(138276);
  }
  
  final void d(final e parame, final int paramInt)
  {
    AppMethodBeat.i(138277);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138274);
          c.this.d(parame, paramInt);
          AppMethodBeat.o(138274);
        }
      });
      AppMethodBeat.o(138277);
      return;
    }
    Log.i("JsApiHideVirtualBottomNavigationBar", "hide");
    H(parame);
    parame.j(paramInt, h("ok", null));
    AppMethodBeat.o(138277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.c
 * JD-Core Version:    0.7.0.1
 */