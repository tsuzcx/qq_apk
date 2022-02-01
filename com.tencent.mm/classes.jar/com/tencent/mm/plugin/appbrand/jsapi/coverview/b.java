package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static int action = 0;
  private static int dtK = 0;
  private static long gLY = 0L;
  private static long kLa = 0L;
  
  public static void a(e parame, int paramInt, MotionEvent paramMotionEvent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(194999);
    int i = paramMotionEvent.getActionIndex();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((action == paramMotionEvent.getAction()) && (dtK == j) && (kLa == paramMotionEvent.getEventTime()) && (gLY == paramMotionEvent.getDownTime()))
    {
      ad.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d, don't send Duplicate event", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Integer.valueOf(j), Long.valueOf(paramMotionEvent.getEventTime()), Long.valueOf(paramMotionEvent.getDownTime()) });
      AppMethodBeat.o(194999);
      return;
    }
    action = paramMotionEvent.getAction();
    dtK = j;
    kLa = paramMotionEvent.getEventTime();
    gLY = paramMotionEvent.getDownTime();
    e.f localf = new e.f();
    localf.b(j, f1, f2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      localJSONObject.put("viewId", paramInt);
      label203:
      ad.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Integer.valueOf(j), Long.valueOf(kLa), Long.valueOf(gLY) });
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
          paramMotionEvent.Pi(localJSONObject.toString());
          parame.a(paramMotionEvent);
          AppMethodBeat.o(194999);
          return;
        }
        try
        {
          localJSONObject.put("touch", localf.toJSONObject());
          label335:
          paramMotionEvent = new e.c();
          continue;
          paramString = new JSONArray();
          try
          {
            localJSONObject.put("touches", paramString);
            label363:
            paramMotionEvent = v(paramMotionEvent);
            if (paramMotionEvent.length > 0)
            {
              paramInt = 0;
              while (paramInt < paramMotionEvent.length)
              {
                paramString.put(paramMotionEvent[paramInt].toJSONObject());
                paramInt += 1;
              }
            }
            paramMotionEvent = new e.d();
            continue;
            try
            {
              localJSONObject.put("touch", localf.toJSONObject());
              label423:
              paramMotionEvent = new e.e();
              continue;
              paramString = new JSONArray();
              try
              {
                localJSONObject.put("touches", paramString);
                label451:
                paramMotionEvent = v(paramMotionEvent);
                if (paramMotionEvent.length > 0)
                {
                  paramInt = 0;
                  while (paramInt < paramMotionEvent.length)
                  {
                    paramString.put(paramMotionEvent[paramInt].toJSONObject());
                    paramInt += 1;
                  }
                }
                paramMotionEvent = new e.b();
                continue;
                if (paramMotionEvent != null)
                {
                  paramMotionEvent.Pi(localJSONObject.toString());
                  parame.b(paramMotionEvent);
                }
                AppMethodBeat.o(194999);
                return;
              }
              catch (JSONException localJSONException1)
              {
                break label451;
              }
            }
            catch (JSONException paramMotionEvent)
            {
              break label423;
            }
          }
          catch (JSONException localJSONException2)
          {
            break label363;
          }
        }
        catch (JSONException paramMotionEvent)
        {
          break label335;
        }
      }
    }
    catch (JSONException paramString)
    {
      break label203;
    }
  }
  
  private static e.f[] v(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(137517);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      e.f localf = new e.f();
      localf.id = paramMotionEvent.getPointerId(i);
      localf.x = paramMotionEvent.getX(i);
      localf.y = paramMotionEvent.getY(i);
      localArrayList.add(localf);
      i += 1;
    }
    paramMotionEvent = new e.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((e.f)localArrayList.get(i));
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