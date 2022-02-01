package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 70;
  public static final String NAME = "hideKeyboard";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
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
    com.tencent.mm.plugin.appbrand.y.m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136256);
        if (!paramc.isRunning())
        {
          AppMethodBeat.o(136256);
          return;
        }
        Object localObject = paramc;
        if ((localObject instanceof z))
        {
          localObject = (z)localObject;
          if (!o.a((z)localObject, paramJSONObject)) {
            break label121;
          }
        }
        label121:
        for (localObject = "ok";; localObject = "fail:input not exists")
        {
          paramc.h(paramInt, c.this.e((String)localObject, null));
          AppMethodBeat.o(136256);
          return;
          if ((localObject instanceof r))
          {
            localObject = ((r)localObject).getRuntime().aWm().getCurrentPage().getCurrentPageView();
            break;
          }
          ae.e("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
          localObject = null;
          break;
        }
      }
    });
    AppMethodBeat.o(136257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.c
 * JD-Core Version:    0.7.0.1
 */