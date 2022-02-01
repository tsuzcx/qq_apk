package com.tencent.mm.plugin.lite.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
  implements com.tencent.mm.ipcinvoker.b<Bundle, IPCCallbackData>
{
  protected static final String ANIM_IN = "nextAnimIn";
  protected static final String ANIM_OUT = "currentAnimOut";
  protected static final int RUN_IN_LITE_PROCESS = 0;
  protected static final int RUN_IN_MM_PROCESS = 1;
  private static final String TAG = "LiteAppJsApi";
  private Map<String, Integer> inAnimMap = new HashMap() {};
  private b mCallback = null;
  public a mInvokeCallback = null;
  private Map<String, Integer> outAnimMap = new HashMap() {};
  
  protected final int getAnimIn(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("nextAnimIn")) {}
    do
    {
      return 2130772144;
      paramJSONObject = paramJSONObject.getString("nextAnimIn");
    } while (!this.inAnimMap.containsKey(paramJSONObject));
    return ((Integer)this.inAnimMap.get(paramJSONObject)).intValue();
  }
  
  protected final int getAnimOut(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("currentAnimOut")) {}
    do
    {
      return 2130772141;
      paramJSONObject = paramJSONObject.getString("currentAnimOut");
    } while (!this.inAnimMap.containsKey(paramJSONObject));
    return ((Integer)this.outAnimMap.get(paramJSONObject)).intValue();
  }
  
  public void invoke(Bundle paramBundle, d<IPCCallbackData> paramd)
  {
    this.mInvokeCallback = new a();
    this.mInvokeCallback.tVU = paramd;
    try
    {
      invoke(paramBundle.getString("appId"), new JSONObject(paramBundle.getString("data")));
      return;
    }
    catch (JSONException paramBundle)
    {
      ac.printErrStackTrace("LiteAppJsApi", paramBundle, "", new Object[0]);
    }
  }
  
  public abstract void invoke(String paramString, JSONObject paramJSONObject);
  
  public void invokeJsApi(String paramString, JSONObject paramJSONObject)
  {
    if (runModel() == 0)
    {
      this.mInvokeCallback = new a();
      this.mInvokeCallback.mCallback = this.mCallback;
      invoke(paramString, paramJSONObject);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    localBundle.putString("appId", paramString);
    paramString = new d() {};
    h.a(ai.getPackageName(), localBundle, getClass(), paramString);
  }
  
  public int runModel()
  {
    return 0;
  }
  
  public void setCallback(b paramb)
  {
    this.mCallback = paramb;
  }
  
  public static final class a
  {
    public b mCallback;
    public d<IPCCallbackData> tVU = null;
    
    public final void Vc(String paramString)
    {
      AppMethodBeat.i(208153);
      if (this.mCallback != null)
      {
        this.mCallback.Vc(paramString);
        AppMethodBeat.o(208153);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.tVR = false;
      localIPCCallbackData.tVS = paramString;
      this.tVU.bc(localIPCCallbackData);
      AppMethodBeat.o(208153);
    }
    
    public final void af(Bundle paramBundle)
    {
      AppMethodBeat.i(208154);
      if (this.mCallback != null)
      {
        localObject = new JSONObject();
        if (paramBundle != null)
        {
          Iterator localIterator = paramBundle.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            try
            {
              ((JSONObject)localObject).put(str, paramBundle.get(str));
            }
            catch (JSONException localJSONException) {}
          }
        }
        this.mCallback.as((JSONObject)localObject);
        AppMethodBeat.o(208154);
        return;
      }
      Object localObject = new IPCCallbackData();
      ((IPCCallbackData)localObject).tVR = true;
      ((IPCCallbackData)localObject).kBP = paramBundle;
      this.tVU.bc(localObject);
      AppMethodBeat.o(208154);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a
 * JD-Core Version:    0.7.0.1
 */