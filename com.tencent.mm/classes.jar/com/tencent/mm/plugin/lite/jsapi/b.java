package com.tencent.mm.plugin.lite.jsapi;

import android.os.Bundle;
import com.tencent.liteapp.jsapi.a;
import com.tencent.luggage.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import org.json.JSONObject;

public abstract class b
  extends a
  implements d<Bundle, IPCCallbackData>
{
  private com.tencent.liteapp.jsapi.b EfZ = null;
  public a Ega = null;
  private Map<String, Integer> Egb = new b.1(this);
  private Map<String, Integer> Egc = new b.2(this);
  
  public final void a(com.tencent.liteapp.jsapi.b paramb)
  {
    this.EfZ = paramb;
  }
  
  public final void b(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (ewF() == 0)
    {
      this.Ega = new a();
      this.Ega.EfZ = this.EfZ;
      a(paramString, paramJSONObject, paramBoolean);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    localBundle.putString("appId", paramString);
    localBundle.putBoolean("isFromView", paramBoolean);
    paramString = new f() {};
    j.a(MMApplicationContext.getPackageName(), localBundle, getClass(), paramString);
  }
  
  protected final int bb(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("nextAnimIn")) {
      return a.a.slide_right_in;
    }
    paramJSONObject = paramJSONObject.getString("nextAnimIn");
    if (!this.Egb.containsKey(paramJSONObject)) {
      return a.a.slide_right_in;
    }
    return ((Integer)this.Egb.get(paramJSONObject)).intValue();
  }
  
  protected final int bc(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("currentAnimOut")) {
      return a.a.slide_left_out;
    }
    paramJSONObject = paramJSONObject.getString("currentAnimOut");
    if (!this.Egb.containsKey(paramJSONObject)) {
      return a.a.slide_left_out;
    }
    return ((Integer)this.Egc.get(paramJSONObject)).intValue();
  }
  
  public int ewF()
  {
    return 0;
  }
  
  public static final class a
  {
    public com.tencent.liteapp.jsapi.b EfZ;
    public f<IPCCallbackData> Ege = null;
    
    public final void aNa(String paramString)
    {
      AppMethodBeat.i(233567);
      if (this.EfZ != null)
      {
        this.EfZ.i(paramString, false);
        AppMethodBeat.o(233567);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.coH = false;
      localIPCCallbackData.EfR = false;
      localIPCCallbackData.coI = paramString;
      this.Ege.aH(localIPCCallbackData);
      AppMethodBeat.o(233567);
    }
    
    public final void aj(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(233569);
      bd(new JSONObject(paramMap));
      AppMethodBeat.o(233569);
    }
    
    public final void bd(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(233571);
      if (this.EfZ != null)
      {
        this.EfZ.a(paramJSONObject, false);
        AppMethodBeat.o(233571);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.coH = true;
      localIPCCallbackData.EfR = false;
      if (paramJSONObject != null) {
        localIPCCallbackData.coJ = paramJSONObject.toString();
      }
      this.Ege.aH(localIPCCallbackData);
      AppMethodBeat.o(233571);
    }
    
    public final void eLC()
    {
      AppMethodBeat.i(233568);
      bd(new JSONObject());
      AppMethodBeat.o(233568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.b
 * JD-Core Version:    0.7.0.1
 */