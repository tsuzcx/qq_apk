package com.tencent.mm.plugin.lite.api;

import android.os.Bundle;
import com.tencent.liteapp.jsapi.a;
import com.tencent.liteapp.jsapi.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import org.json.JSONObject;

public abstract class e
  extends a
  implements d<Bundle, IPCCallbackData>
{
  public b JZi = null;
  public a JZj = null;
  
  public final void a(b paramb)
  {
    this.JZi = paramb;
  }
  
  public final void b(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (fEx() == 0)
    {
      this.JZj = new a();
      this.JZj.JZi = this.JZi;
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
  
  public int fEx()
  {
    return 0;
  }
  
  public static final class a
  {
    public b JZi;
    public f<IPCCallbackData> JZl = null;
    
    public final void aJV(String paramString)
    {
      AppMethodBeat.i(271462);
      if (this.JZi != null)
      {
        this.JZi.i(paramString, false);
        AppMethodBeat.o(271462);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.efS = false;
      localIPCCallbackData.JZh = false;
      localIPCCallbackData.efT = paramString;
      this.JZl.onCallback(localIPCCallbackData);
      AppMethodBeat.o(271462);
    }
    
    public final void az(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(271474);
      bq(new JSONObject(paramMap));
      AppMethodBeat.o(271474);
    }
    
    public final void bq(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(271481);
      if (this.JZi != null)
      {
        this.JZi.a(paramJSONObject, false);
        AppMethodBeat.o(271481);
        return;
      }
      IPCCallbackData localIPCCallbackData = new IPCCallbackData();
      localIPCCallbackData.efS = true;
      localIPCCallbackData.JZh = false;
      if (paramJSONObject != null) {
        localIPCCallbackData.efU = paramJSONObject.toString();
      }
      this.JZl.onCallback(localIPCCallbackData);
      AppMethodBeat.o(271481);
    }
    
    public final void fTW()
    {
      AppMethodBeat.i(271468);
      bq(new JSONObject());
      AppMethodBeat.o(271468);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.api.e
 * JD-Core Version:    0.7.0.1
 */