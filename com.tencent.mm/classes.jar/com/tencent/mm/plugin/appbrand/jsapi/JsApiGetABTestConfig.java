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
  extends ab<f>
{
  public static final int CTRL_INDEX = 527;
  public static final String NAME = "getABTestConfig";
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45480);
    Log.i("MicroMsg.JsApiGetABTestConfig", "JSONObject = ".concat(String.valueOf(paramJSONObject)));
    paramf = paramJSONObject.optString("experimentId");
    boolean bool = "Expt".equals(paramJSONObject.optString("experimentType"));
    if (TextUtils.isEmpty(paramf))
    {
      paramf = h("fail:experimentId is empty", null);
      AppMethodBeat.o(45480);
      return paramf;
    }
    if (bool)
    {
      paramJSONObject = new HashMap();
      paramJSONObject.put("testConfig", com.tencent.mm.plugin.expt.h.d.cRY().b(paramf, "", true, true));
      paramf = n("ok", paramJSONObject);
      AppMethodBeat.o(45480);
      return paramf;
    }
    paramJSONObject = a.a.hnM;
    paramf = a.Fu(paramf);
    paramJSONObject = new HashMap();
    if ((paramf != null) && (paramf.isValid())) {
      paramJSONObject.put("testConfig", paramf.gzz());
    }
    for (;;)
    {
      paramf = n("ok", paramJSONObject);
      AppMethodBeat.o(45480);
      return paramf;
      paramJSONObject.put("testConfig", new HashMap(0));
    }
  }
  
  public static class GetABTestConfigTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetABTestConfigTask> CREATOR;
    private String lzA;
    private Map<String, String> lzB;
    
    static
    {
      AppMethodBeat.i(45479);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45479);
    }
    
    GetABTestConfigTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45475);
      this.lzB = new HashMap();
      f(paramParcel);
      AppMethodBeat.o(45475);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45476);
      Log.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
      c localc = com.tencent.mm.model.c.d.aXu().Fu(this.lzA);
      if (localc.isValid()) {
        this.lzB.putAll(localc.gzz());
      }
      bDU();
      AppMethodBeat.o(45476);
    }
    
    public final void bjk() {}
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45477);
      this.lzB.clear();
      this.lzB.putAll(paramParcel.readHashMap(HashMap.class.getClassLoader()));
      this.lzA = paramParcel.readString();
      AppMethodBeat.o(45477);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45478);
      paramParcel.writeMap(this.lzB);
      paramParcel.writeString(this.lzA);
      AppMethodBeat.o(45478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig
 * JD-Core Version:    0.7.0.1
 */