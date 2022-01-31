package com.tencent.luggage.bridge;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.luggage.j.c;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class n
{
  private o bhF;
  private Handler bhG;
  
  n(o paramo)
  {
    this.bhF = paramo;
    paramo = new HandlerThread("AsyncJSThread");
    paramo.start();
    this.bhG = new Handler(paramo.getLooper());
  }
  
  private static m aU(String paramString)
  {
    try
    {
      paramString = new m(new JSONObject(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      c.e("Js2JavaMessageQueue", "Message parse failed, ex = %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  final String g(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return h(paramString, true);
    }
    this.bhG.post(new n.1(this, paramString));
    return "";
  }
  
  final String h(String paramString, boolean paramBoolean)
  {
    paramString = aU(paramString);
    if (paramString == null) {
      return "";
    }
    c.v("Js2JavaMessageQueue", "processImpl, jsMsg.type = %s", new Object[] { paramString.pN().name() });
    switch (n.2.bhJ[paramString.pN().ordinal()])
    {
    default: 
      paramString = null;
      label78:
      if (paramString != null) {
        break;
      }
    }
    for (Object localObject = "null";; localObject = paramString.pN().name())
    {
      for (;;)
      {
        for (;;)
        {
          c.v("Js2JavaMessageQueue", "processImpl, javaMsg.type = %s", new Object[] { localObject });
          if (paramString != null) {
            break label345;
          }
          return "";
          this.bhF.bhM.pP();
          paramString = null;
          break;
          paramString = this.bhF.a(paramString, paramBoolean);
          break;
          localObject = this.bhF;
          try
          {
            paramString = new i(paramString);
            c.i("LuggageBridge", "processEventFromJs, EventName = %s", new Object[] { paramString.bhz });
            if ((j)((o)localObject).bhP.get(paramString.bhz) == null) {
              c.e("LuggageBridge", "no listener for event: %s", new Object[] { paramString.bhz });
            }
            paramString = null;
          }
          catch (JSONException paramString)
          {
            c.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", new Object[] { paramString });
            paramString = null;
          }
        }
        break;
        localObject = this.bhF;
        try
        {
          paramString = new g(paramString);
          if ((h)((o)localObject).bhQ.get(Integer.valueOf(paramString.bhx)) != null) {
            break label309;
          }
          c.e("LuggageBridge", "no listener for callback: %d", new Object[] { Integer.valueOf(paramString.bhx) });
          paramString = null;
        }
        catch (JSONException paramString)
        {
          c.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", new Object[] { paramString });
          paramString = null;
        }
      }
      break label78;
      label309:
      if (paramString.bhy) {
        break;
      }
      ((o)localObject).bhQ.remove(Integer.valueOf(paramString.bhx));
      break;
    }
    label345:
    return paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.bridge.n
 * JD-Core Version:    0.7.0.1
 */