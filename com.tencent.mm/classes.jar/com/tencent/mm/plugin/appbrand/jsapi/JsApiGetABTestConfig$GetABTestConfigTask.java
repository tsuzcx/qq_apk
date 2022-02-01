package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;

public class JsApiGetABTestConfig$GetABTestConfigTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetABTestConfigTask> CREATOR;
  private String ryg;
  private Map<String, String> ryh;
  
  static
  {
    AppMethodBeat.i(45479);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45479);
  }
  
  JsApiGetABTestConfig$GetABTestConfigTask(Parcel paramParcel)
  {
    AppMethodBeat.i(45475);
    this.ryh = new HashMap();
    h(paramParcel);
    AppMethodBeat.o(45475);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(45476);
    Log.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
    c localc = com.tencent.mm.model.newabtest.d.bEt().Fd(this.ryg);
    if ((localc != null) && (localc.isValid())) {
      this.ryh.putAll(localc.iWZ());
    }
    cpA();
    AppMethodBeat.o(45476);
  }
  
  public final void bQr() {}
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(45477);
    this.ryh.clear();
    this.ryh.putAll(paramParcel.readHashMap(HashMap.class.getClassLoader()));
    this.ryg = paramParcel.readString();
    AppMethodBeat.o(45477);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(45478);
    paramParcel.writeMap(this.ryh);
    paramParcel.writeString(this.ryg);
    AppMethodBeat.o(45478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig.GetABTestConfigTask
 * JD-Core Version:    0.7.0.1
 */