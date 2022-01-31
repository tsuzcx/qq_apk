package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends s
{
  public static final int CTRL_INDEX = 436;
  public static final String NAME = "measureText";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    j = -1;
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiMeasureText", "measureText, data is null");
      return h("fail:data is null", null);
    }
    paramc = paramJSONObject.optString("text");
    float f1 = (float)paramJSONObject.optDouble("fontSize", 16.0D);
    y.i("MicroMsg.JsApiMeasureText", "measureText data:%s", new Object[] { paramJSONObject.toString() });
    if ((TextUtils.isEmpty(paramc)) || (f1 <= 0.0F))
    {
      y.e("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
      return h("fail:param is illegal", null);
    }
    locala = new a();
    locala.setTextSize(h.am(f1));
    try
    {
      locala.rN(paramJSONObject.getString("fontFamily"));
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
          label268:
          float f2;
          y.i("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
          continue;
          locala.kC(2);
          continue;
          locala.kC(0);
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
        y.i("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
        break label268;
        locala.setFakeBoldText(false);
        break label268;
      }
      f2 = locala.measureText(paramc);
      paramc = locala.getFontMetrics();
      f1 = Math.abs(paramc.bottom - paramc.top);
      y.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", new Object[] { Float.valueOf(paramc.bottom), Float.valueOf(paramc.top), Float.valueOf(f2), Float.valueOf(f1) });
      f2 = h.al(f2);
      f1 = h.al(f1);
      paramc = new HashMap();
      paramc.put("width", Float.valueOf(f2));
      paramc.put("height", Float.valueOf(f1));
      y.i("MicroMsg.JsApiMeasureText", "map:%s", new Object[] { paramc.toString() });
      return h("ok", paramc);
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        y.i("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
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
              locala.kC(2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.g
 * JD-Core Version:    0.7.0.1
 */