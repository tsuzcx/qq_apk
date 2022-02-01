package com.tencent.mm.plugin.lite.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a
  implements com.tencent.mm.ipcinvoker.b<Bundle, IPCCallbackData>
{
  private Map<String, Integer> uYA = new HashMap() {};
  private Map<String, Integer> uYB = new HashMap() {};
  public b uYy = null;
  public a uYz = null;
  
  protected final int ay(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("nextAnimIn")) {}
    do
    {
      return 2130772144;
      paramJSONObject = paramJSONObject.getString("nextAnimIn");
    } while (!this.uYA.containsKey(paramJSONObject));
    return ((Integer)this.uYA.get(paramJSONObject)).intValue();
  }
  
  protected final int az(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("currentAnimOut")) {}
    do
    {
      return 2130772141;
      paramJSONObject = paramJSONObject.getString("currentAnimOut");
    } while (!this.uYA.containsKey(paramJSONObject));
    return ((Integer)this.uYB.get(paramJSONObject)).intValue();
  }
  
  public int cXg()
  {
    return 0;
  }
  
  public abstract void j(String paramString, JSONObject paramJSONObject);
  
  public static final class a
  {
    public d<IPCCallbackData> uYD = null;
    public b uYy;
    
    public final void YL(String paramString)
    {
      AppMethodBeat.i(214617);
      if (this.uYy != null)
      {
        this.uYy.aov(paramString);
        AppMethodBeat.o(214617);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.uYv = false;
      localIPCCallbackData.uYw = paramString;
      this.uYD.be(localIPCCallbackData);
      AppMethodBeat.o(214617);
    }
    
    public final void aA(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(214620);
      if (this.uYy != null)
      {
        this.uYy.aB(paramJSONObject);
        AppMethodBeat.o(214620);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.uYv = true;
      if (paramJSONObject != null) {
        localIPCCallbackData.uYx = paramJSONObject.toString();
      }
      this.uYD.be(localIPCCallbackData);
      AppMethodBeat.o(214620);
    }
    
    public final void ai(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(214619);
      aA(new JSONObject(paramMap));
      AppMethodBeat.o(214619);
    }
    
    public final void cXe()
    {
      AppMethodBeat.i(214618);
      aA(new JSONObject());
      AppMethodBeat.o(214618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a
 * JD-Core Version:    0.7.0.1
 */