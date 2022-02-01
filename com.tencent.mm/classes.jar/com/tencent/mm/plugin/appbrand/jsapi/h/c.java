package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 70;
  public static final String NAME = "hideKeyboard";
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136257);
    localObject = null;
    try
    {
      int i = paramJSONObject.getInt("inputId");
      paramJSONObject = Integer.valueOf(i);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject = localObject;
      }
    }
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136256);
        if (!paramf.isRunning())
        {
          AppMethodBeat.o(136256);
          return;
        }
        Object localObject = paramf;
        if ((localObject instanceof ac))
        {
          localObject = (ac)localObject;
          if (!o.a((ac)localObject, paramJSONObject)) {
            break label121;
          }
        }
        label121:
        for (localObject = "ok";; localObject = "fail:input not exists")
        {
          paramf.i(paramInt, c.this.h((String)localObject, null));
          AppMethodBeat.o(136256);
          return;
          if ((localObject instanceof s))
          {
            localObject = ((s)localObject).getRuntime().brh().getCurrentPage().getCurrentPageView();
            break;
          }
          Log.e("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
          localObject = null;
          break;
        }
      }
    });
    AppMethodBeat.o(136257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.c
 * JD-Core Version:    0.7.0.1
 */