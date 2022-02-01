package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
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
    com.tencent.mm.plugin.appbrand.af.o.runOnUiThread(new Runnable()
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
        if ((localObject instanceof ad))
        {
          localObject = (ad)localObject;
          if (!com.tencent.mm.plugin.appbrand.widget.input.o.a((ad)localObject, paramJSONObject)) {
            break label120;
          }
        }
        label120:
        for (localObject = "ok";; localObject = "fail:input not exists")
        {
          paramf.callback(paramInt, c.this.ZP((String)localObject));
          AppMethodBeat.o(136256);
          return;
          if ((localObject instanceof y))
          {
            localObject = ((y)localObject).getRuntime().getPageContainer().getCurrentPage().getCurrentPageView();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.c
 * JD-Core Version:    0.7.0.1
 */