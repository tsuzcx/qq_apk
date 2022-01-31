package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.d;
import java.util.HashMap;
import java.util.Map;

public class JsApiGetABTestConfig$GetABTestConfigTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetABTestConfigTask> CREATOR;
  private String hxH;
  private Map<String, String> hxI;
  
  static
  {
    AppMethodBeat.i(130421);
    CREATOR = new JsApiGetABTestConfig.GetABTestConfigTask.1();
    AppMethodBeat.o(130421);
  }
  
  JsApiGetABTestConfig$GetABTestConfigTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130416);
    this.hxI = new HashMap();
    f(paramParcel);
    AppMethodBeat.o(130416);
  }
  
  JsApiGetABTestConfig$GetABTestConfigTask(String paramString)
  {
    AppMethodBeat.i(138127);
    this.hxI = new HashMap();
    this.hxH = paramString;
    AppMethodBeat.o(138127);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130417);
    ab.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me(this.hxH);
    if (localc.isValid()) {
      this.hxI.putAll(localc.dvN());
    }
    aBp();
    AppMethodBeat.o(130417);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130418);
    AppMethodBeat.o(130418);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130419);
    this.hxI.clear();
    this.hxI.putAll(paramParcel.readHashMap(HashMap.class.getClassLoader()));
    this.hxH = paramParcel.readString();
    AppMethodBeat.o(130419);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130420);
    paramParcel.writeMap(this.hxI);
    paramParcel.writeString(this.hxH);
    AppMethodBeat.o(130420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig.GetABTestConfigTask
 * JD-Core Version:    0.7.0.1
 */