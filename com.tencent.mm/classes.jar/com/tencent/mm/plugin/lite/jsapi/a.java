package com.tencent.mm.plugin.lite.jsapi;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a
  implements com.tencent.mm.ipcinvoker.b<Bundle, IPCCallbackData>
{
  public b vkn = null;
  public a vko = null;
  private Map<String, Integer> vkp = new HashMap() {};
  private Map<String, Integer> vkq = new HashMap() {};
  
  protected final int ay(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("nextAnimIn")) {}
    do
    {
      return 2130772144;
      paramJSONObject = paramJSONObject.getString("nextAnimIn");
    } while (!this.vkp.containsKey(paramJSONObject));
    return ((Integer)this.vkp.get(paramJSONObject)).intValue();
  }
  
  protected final int az(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("currentAnimOut")) {}
    do
    {
      return 2130772141;
      paramJSONObject = paramJSONObject.getString("currentAnimOut");
    } while (!this.vkp.containsKey(paramJSONObject));
    return ((Integer)this.vkq.get(paramJSONObject)).intValue();
  }
  
  public int cZP()
  {
    return 0;
  }
  
  public void e(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract void j(String paramString, JSONObject paramJSONObject);
  
  public static final class a
  {
    public b vkn;
    public d<IPCCallbackData> vks = null;
    
    public final void ZC(String paramString)
    {
      AppMethodBeat.i(212370);
      if (this.vkn != null)
      {
        this.vkn.apy(paramString);
        AppMethodBeat.o(212370);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.vkk = false;
      localIPCCallbackData.vkl = paramString;
      this.vks.be(localIPCCallbackData);
      AppMethodBeat.o(212370);
    }
    
    public final void aA(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(212373);
      if (this.vkn != null)
      {
        this.vkn.aB(paramJSONObject);
        AppMethodBeat.o(212373);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.vkk = true;
      if (paramJSONObject != null) {
        localIPCCallbackData.vkm = paramJSONObject.toString();
      }
      this.vks.be(localIPCCallbackData);
      AppMethodBeat.o(212373);
    }
    
    public final void ao(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(212372);
      aA(new JSONObject(paramMap));
      AppMethodBeat.o(212372);
    }
    
    public final void cZN()
    {
      AppMethodBeat.i(212371);
      aA(new JSONObject());
      AppMethodBeat.o(212371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a
 * JD-Core Version:    0.7.0.1
 */