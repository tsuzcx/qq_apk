package com.tencent.mm.plugin.lite.jsapi;

import android.os.Bundle;
import com.tencent.liteapp.jsapi.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class b
  extends a
  implements com.tencent.mm.ipcinvoker.b<Bundle, IPCCallbackData>
{
  private com.tencent.liteapp.jsapi.b yEm = null;
  public a yEn = null;
  private Map<String, Integer> yEo = new HashMap() {};
  private Map<String, Integer> yEp = new HashMap() {};
  
  public final void a(com.tencent.liteapp.jsapi.b paramb)
  {
    this.yEm = paramb;
  }
  
  protected final int aU(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("nextAnimIn")) {}
    do
    {
      return 2130772169;
      paramJSONObject = paramJSONObject.getString("nextAnimIn");
    } while (!this.yEo.containsKey(paramJSONObject));
    return ((Integer)this.yEo.get(paramJSONObject)).intValue();
  }
  
  protected final int aV(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("currentAnimOut")) {}
    do
    {
      return 2130772166;
      paramJSONObject = paramJSONObject.getString("currentAnimOut");
    } while (!this.yEo.containsKey(paramJSONObject));
    return ((Integer)this.yEp.get(paramJSONObject)).intValue();
  }
  
  public final void b(String paramString, JSONObject paramJSONObject)
  {
    if (dTw() == 0)
    {
      this.yEn = new a();
      this.yEn.yEm = this.yEm;
      a(paramString, paramJSONObject);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    localBundle.putString("appId", paramString);
    paramString = new d() {};
    h.a(MMApplicationContext.getPackageName(), localBundle, getClass(), paramString);
  }
  
  public int dTw()
  {
    return 0;
  }
  
  public static final class a
  {
    public com.tencent.liteapp.jsapi.b yEm;
    public d<IPCCallbackData> yEr = null;
    
    public final void aCS(String paramString)
    {
      AppMethodBeat.i(198832);
      if (this.yEm != null)
      {
        this.yEm.h(paramString, false);
        AppMethodBeat.o(198832);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.cqT = false;
      localIPCCallbackData.yEe = false;
      localIPCCallbackData.cqU = paramString;
      this.yEr.bn(localIPCCallbackData);
      AppMethodBeat.o(198832);
    }
    
    public final void aW(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(198835);
      if (this.yEm != null)
      {
        this.yEm.a(paramJSONObject, false);
        AppMethodBeat.o(198835);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.cqT = true;
      localIPCCallbackData.yEe = false;
      if (paramJSONObject != null) {
        localIPCCallbackData.cqV = paramJSONObject.toString();
      }
      this.yEr.bn(localIPCCallbackData);
      AppMethodBeat.o(198835);
    }
    
    public final void aq(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(198834);
      aW(new JSONObject(paramMap));
      AppMethodBeat.o(198834);
    }
    
    public final void ecz()
    {
      AppMethodBeat.i(198833);
      aW(new JSONObject());
      AppMethodBeat.o(198833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.b
 * JD-Core Version:    0.7.0.1
 */