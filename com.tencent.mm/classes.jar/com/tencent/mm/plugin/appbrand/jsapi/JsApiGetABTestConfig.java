package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetABTestConfig
  extends aa<e>
{
  public static final int CTRL_INDEX = 527;
  public static final String NAME = "getABTestConfig";
  
  public final String a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45480);
    Log.i("MicroMsg.JsApiGetABTestConfig", "JSONObject = ".concat(String.valueOf(paramJSONObject)));
    parame = paramJSONObject.optString("experimentId");
    boolean bool = "Expt".equals(paramJSONObject.optString("experimentType"));
    if (TextUtils.isEmpty(parame))
    {
      parame = h("fail:experimentId is empty", null);
      AppMethodBeat.o(45480);
      return parame;
    }
    if (bool)
    {
      paramJSONObject = new HashMap();
      paramJSONObject.put("testConfig", com.tencent.mm.plugin.expt.h.d.dgX().a(parame, "", true, true));
      parame = m("ok", paramJSONObject);
      AppMethodBeat.o(45480);
      return parame;
    }
    paramJSONObject = a.a.jZD;
    parame = a.Mu(parame);
    paramJSONObject = new HashMap();
    if ((parame != null) && (parame.isValid())) {
      paramJSONObject.put("testConfig", parame.hvz());
    }
    for (;;)
    {
      parame = m("ok", paramJSONObject);
      AppMethodBeat.o(45480);
      return parame;
      paramJSONObject.put("testConfig", new HashMap(0));
    }
  }
  
  public static class GetABTestConfigTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetABTestConfigTask> CREATOR;
    private String ouQ;
    private Map<String, String> ouR;
    
    static
    {
      AppMethodBeat.i(45479);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45479);
    }
    
    GetABTestConfigTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45475);
      this.ouR = new HashMap();
      f(paramParcel);
      AppMethodBeat.o(45475);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45476);
      Log.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
      c localc = com.tencent.mm.model.c.d.bgB().Mu(this.ouQ);
      if (localc.isValid()) {
        this.ouR.putAll(localc.hvz());
      }
      bPt();
      AppMethodBeat.o(45476);
    }
    
    public final void bsK() {}
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45477);
      this.ouR.clear();
      this.ouR.putAll(paramParcel.readHashMap(HashMap.class.getClassLoader()));
      this.ouQ = paramParcel.readString();
      AppMethodBeat.o(45477);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45478);
      paramParcel.writeMap(this.ouR);
      paramParcel.writeString(this.ouQ);
      AppMethodBeat.o(45478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig
 * JD-Core Version:    0.7.0.1
 */