package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.x.d.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static int action = 0;
  private static long jPn = 0L;
  private static long jPo = 0L;
  private static int jqR = 0;
  
  public static void a(e parame, MotionEvent paramMotionEvent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137516);
    int i = paramMotionEvent.getActionIndex();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((action == paramMotionEvent.getAction()) && (jqR == j) && (jPn == paramMotionEvent.getEventTime()) && (jPo == paramMotionEvent.getDownTime()))
    {
      ad.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d, don't send Duplicate event", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Integer.valueOf(j), Long.valueOf(paramMotionEvent.getEventTime()), Long.valueOf(paramMotionEvent.getDownTime()) });
      AppMethodBeat.o(137516);
      return;
    }
    action = paramMotionEvent.getAction();
    jqR = j;
    jPn = paramMotionEvent.getEventTime();
    jPo = paramMotionEvent.getDownTime();
    d.f localf = new d.f();
    localf.b(j, f1, f2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      label194:
      ad.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Integer.valueOf(j), Long.valueOf(jPn), Long.valueOf(jPo) });
      paramString = null;
      switch (paramMotionEvent.getAction())
      {
      default: 
        paramMotionEvent = paramString;
      }
      for (;;)
      {
        if ((paramMotionEvent != null) && (paramBoolean))
        {
          paramMotionEvent.HK(localJSONObject.toString());
          parame.a(paramMotionEvent);
          AppMethodBeat.o(137516);
          return;
        }
        try
        {
          localJSONObject.put("touch", localf.toJSONObject());
          label322:
          paramMotionEvent = new d.c();
          continue;
          paramString = new JSONArray();
          try
          {
            localJSONObject.put("touches", paramString);
            label350:
            paramMotionEvent = z(paramMotionEvent);
            if (paramMotionEvent.length > 0)
            {
              i = 0;
              while (i < paramMotionEvent.length)
              {
                paramString.put(paramMotionEvent[i].toJSONObject());
                i += 1;
              }
            }
            paramMotionEvent = new d.d();
            continue;
            try
            {
              localJSONObject.put("touch", localf.toJSONObject());
              label415:
              paramMotionEvent = new d.e();
              continue;
              paramString = new JSONArray();
              try
              {
                localJSONObject.put("touches", paramString);
                label443:
                paramMotionEvent = z(paramMotionEvent);
                if (paramMotionEvent.length > 0)
                {
                  i = 0;
                  while (i < paramMotionEvent.length)
                  {
                    paramString.put(paramMotionEvent[i].toJSONObject());
                    i += 1;
                  }
                }
                paramMotionEvent = new d.b();
                continue;
                if (paramMotionEvent != null)
                {
                  paramMotionEvent.HK(localJSONObject.toString());
                  parame.b(paramMotionEvent);
                }
                AppMethodBeat.o(137516);
                return;
              }
              catch (JSONException localJSONException1)
              {
                break label443;
              }
            }
            catch (JSONException paramMotionEvent)
            {
              break label415;
            }
          }
          catch (JSONException localJSONException2)
          {
            break label350;
          }
        }
        catch (JSONException paramMotionEvent)
        {
          break label322;
        }
      }
    }
    catch (JSONException paramString)
    {
      break label194;
    }
  }
  
  private static d.f[] z(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(137517);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      d.f localf = new d.f();
      localf.id = paramMotionEvent.getPointerId(i);
      localf.x = paramMotionEvent.getX(i);
      localf.y = paramMotionEvent.getY(i);
      localArrayList.add(localf);
      i += 1;
    }
    paramMotionEvent = new d.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((d.f)localArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(137517);
    return paramMotionEvent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.b
 * JD-Core Version:    0.7.0.1
 */