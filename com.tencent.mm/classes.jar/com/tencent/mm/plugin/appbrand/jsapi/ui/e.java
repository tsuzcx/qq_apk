package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class e
  extends d<f>
{
  private static final int CTRL_INDEX = 580;
  private static final String NAME = "showVirtualBottomNavigationBar";
  
  private static void E(f paramf)
  {
    AppMethodBeat.i(138282);
    paramf = AndroidContextUtil.castActivityOrNull(paramf.getContext());
    if (paramf == null)
    {
      Log.i("JsApiShowVirtualBottomNavigationBar", "null == activity");
      AppMethodBeat.o(138282);
      return;
    }
    paramf = paramf.getWindow();
    if (paramf == null)
    {
      Log.i("JsApiShowVirtualBottomNavigationBar", "null == window");
      AppMethodBeat.o(138282);
      return;
    }
    int j = paramf.getDecorView().getSystemUiVisibility();
    int i = j;
    if (Build.VERSION.SDK_INT >= 20) {
      i = j & 0xFFFFFDFF & 0xFFFFFFFD;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i & 0xFFFFEFFF;
    }
    paramf.getDecorView().setSystemUiVisibility(j & 0xFFFFFEFF);
    paramf.getDecorView().setOnSystemUiVisibilityChangeListener(null);
    AppMethodBeat.o(138282);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138280);
    d(paramf, paramInt);
    AppMethodBeat.o(138280);
  }
  
  final void d(final f paramf, final int paramInt)
  {
    AppMethodBeat.i(138281);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138279);
          e.this.d(paramf, paramInt);
          AppMethodBeat.o(138279);
        }
      });
      AppMethodBeat.o(138281);
      return;
    }
    Log.i("JsApiShowVirtualBottomNavigationBar", "show");
    E(paramf);
    paramf.i(paramInt, h("ok", null));
    AppMethodBeat.o(138281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.e
 * JD-Core Version:    0.7.0.1
 */