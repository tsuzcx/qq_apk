package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends u
{
  public static final int CTRL_INDEX = 436;
  public static final String NAME = "measureText";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    j = -1;
    AppMethodBeat.i(103855);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiMeasureText", "measureText, data is null");
      paramc = j("fail:data is null", null);
      AppMethodBeat.o(103855);
      return paramc;
    }
    paramc = paramJSONObject.optString("text");
    float f1 = (float)paramJSONObject.optDouble("fontSize", 16.0D);
    ab.i("MicroMsg.JsApiMeasureText", "measureText data:%s", new Object[] { paramJSONObject.toString() });
    if ((TextUtils.isEmpty(paramc)) || (f1 <= 0.0F))
    {
      ab.e("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
      paramc = j("fail:param is illegal", null);
      AppMethodBeat.o(103855);
      return paramc;
    }
    locala = new a();
    locala.setTextSize(g.aA(f1));
    try
    {
      locala.zD(paramJSONObject.getString("fontFamily"));
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
          ab.i("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
          continue;
          locala.ny(2);
          continue;
          locala.ny(0);
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
        ab.i("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
        break label284;
        locala.setFakeBoldText(false);
        break label284;
      }
      f2 = locala.measureText(paramc);
      paramc = locala.getFontMetrics();
      f1 = Math.abs(paramc.bottom - paramc.top);
      ab.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", new Object[] { Float.valueOf(paramc.bottom), Float.valueOf(paramc.top), Float.valueOf(f2), Float.valueOf(f1) });
      f2 = g.az(f2);
      f1 = g.az(f1);
      paramc = new HashMap();
      paramc.put("width", Float.valueOf(f2));
      paramc.put("height", Float.valueOf(f1));
      ab.i("MicroMsg.JsApiMeasureText", "map:%s", new Object[] { paramc.toString() });
      paramc = j("ok", paramc);
      AppMethodBeat.o(103855);
      return paramc;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        ab.i("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
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
              locala.ny(2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.h
 * JD-Core Version:    0.7.0.1
 */