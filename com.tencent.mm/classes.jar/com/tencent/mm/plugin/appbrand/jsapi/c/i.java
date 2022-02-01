package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends ab
{
  public static final int CTRL_INDEX = 436;
  public static final String NAME = "measureText";
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    j = -1;
    AppMethodBeat.i(145541);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiMeasureText", "measureText, data is null");
      paramf = ZP("fail:data is null");
      AppMethodBeat.o(145541);
      return paramf;
    }
    paramf = paramJSONObject.optString("text");
    float f1 = (float)paramJSONObject.optDouble("fontSize", 16.0D);
    Log.i("MicroMsg.JsApiMeasureText", "measureText data:%s", new Object[] { paramJSONObject.toString() });
    if ((TextUtils.isEmpty(paramf)) || (f1 <= 0.0F))
    {
      Log.e("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
      paramf = ZP("fail:param is illegal");
      AppMethodBeat.o(145541);
      return paramf;
    }
    locala = new a();
    locala.setTextSize(com.tencent.mm.plugin.appbrand.af.i.bW(f1));
    try
    {
      locala.WT(paramJSONObject.getString("fontFamily"));
      try
      {
        String str = paramJSONObject.getString("fontStyle");
        i = str.hashCode();
        switch (i)
        {
        default: 
          i = -1;
          switch (i)
          {
          }
          break;
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          label284:
          float f2;
          Log.i("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
          continue;
          locala.zC(2);
          continue;
          locala.zC(0);
          continue;
          int i = j;
          if (paramJSONObject.equals("bold"))
          {
            i = 0;
            continue;
            i = j;
            if (paramJSONObject.equals("normal"))
            {
              i = 1;
              continue;
              locala.setFakeBoldText(true);
            }
          }
        }
      }
      try
      {
        paramJSONObject = paramJSONObject.getString("fontWeight");
        i = paramJSONObject.hashCode();
        switch (i)
        {
        default: 
          i = j;
          switch (i)
          {
          }
          break;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.i("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
        break label284;
        locala.setFakeBoldText(false);
        break label284;
      }
      f2 = locala.measureText(paramf);
      paramf = locala.getFontMetrics();
      f1 = Math.abs(paramf.bottom - paramf.top);
      Log.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", new Object[] { Float.valueOf(paramf.bottom), Float.valueOf(paramf.top), Float.valueOf(f2), Float.valueOf(f1) });
      f2 = com.tencent.mm.plugin.appbrand.af.i.bV(f2);
      f1 = com.tencent.mm.plugin.appbrand.af.i.bV(f1);
      paramf = new HashMap();
      paramf.put("width", Float.valueOf(f2));
      paramf.put("height", Float.valueOf(f1));
      Log.i("MicroMsg.JsApiMeasureText", "map:%s", new Object[] { paramf.toString() });
      paramf = m("ok", paramf);
      AppMethodBeat.o(145541);
      return paramf;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        Log.i("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
        continue;
        if (localJSONException1.equals("oblique"))
        {
          i = 0;
          continue;
          if (localJSONException1.equals("italic"))
          {
            i = 1;
            continue;
            if (localJSONException1.equals("normal"))
            {
              i = 2;
              continue;
              locala.zC(2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.i
 * JD-Core Version:    0.7.0.1
 */