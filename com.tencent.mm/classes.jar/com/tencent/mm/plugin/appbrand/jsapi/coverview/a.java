package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.c.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(e parame, MotionEvent paramMotionEvent, String paramString, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    int k = paramMotionEvent.getActionIndex();
    int m = paramMotionEvent.getPointerId(k);
    float f1 = paramMotionEvent.getX(k);
    float f2 = paramMotionEvent.getY(k);
    c.f localf = new c.f();
    localf.a(m, f1, f2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      label74:
      y.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
      switch (paramMotionEvent.getAction())
      {
      default: 
        paramMotionEvent = null;
      }
      for (;;)
      {
        if ((paramMotionEvent != null) && (paramBoolean))
        {
          paramMotionEvent.tM(localJSONObject.toString());
          parame.a(paramMotionEvent);
          label155:
          return;
        }
        try
        {
          localJSONObject.put("touch", localf.rB());
          label169:
          paramMotionEvent = new c.c();
          continue;
          paramString = new JSONArray();
          try
          {
            localJSONObject.put("touches", paramString);
            label197:
            paramMotionEvent = u(paramMotionEvent);
            if (paramMotionEvent.length > 0) {
              while (i < paramMotionEvent.length)
              {
                paramString.put(paramMotionEvent[i].rB());
                i += 1;
              }
            }
            paramMotionEvent = new c.d();
            continue;
            try
            {
              localJSONObject.put("touch", localf.rB());
              label259:
              paramMotionEvent = new c.e();
              continue;
              paramString = new JSONArray();
              try
              {
                localJSONObject.put("touches", paramString);
                label287:
                paramMotionEvent = u(paramMotionEvent);
                if (paramMotionEvent.length > 0)
                {
                  i = j;
                  while (i < paramMotionEvent.length)
                  {
                    paramString.put(paramMotionEvent[i].rB());
                    i += 1;
                  }
                }
                paramMotionEvent = new c.b();
                continue;
                if (paramMotionEvent == null) {
                  break label155;
                }
                paramMotionEvent.tM(localJSONObject.toString());
                parame.b(paramMotionEvent);
                return;
              }
              catch (JSONException localJSONException1)
              {
                break label287;
              }
            }
            catch (JSONException paramMotionEvent)
            {
              break label259;
            }
          }
          catch (JSONException localJSONException2)
          {
            break label197;
          }
        }
        catch (JSONException paramMotionEvent)
        {
          break label169;
        }
      }
    }
    catch (JSONException paramString)
    {
      break label74;
    }
  }
  
  private static c.f[] u(MotionEvent paramMotionEvent)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      c.f localf = new c.f();
      localf.id = paramMotionEvent.getPointerId(i);
      localf.x = paramMotionEvent.getX(i);
      localf.y = paramMotionEvent.getY(i);
      localArrayList.add(localf);
      i += 1;
    }
    paramMotionEvent = new c.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((c.f)localArrayList.get(i));
      i += 1;
    }
    return paramMotionEvent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.a
 * JD-Core Version:    0.7.0.1
 */