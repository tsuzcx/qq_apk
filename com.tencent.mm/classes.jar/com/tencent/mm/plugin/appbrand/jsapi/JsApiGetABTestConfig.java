package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;

public final class JsApiGetABTestConfig
  extends y<q>
{
  public static final int CTRL_INDEX = 527;
  public static final String NAME = "getABTestConfig";
  
  public static class GetABTestConfigTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetABTestConfigTask> CREATOR;
    private String jXN;
    private Map<String, String> jXO;
    
    static
    {
      AppMethodBeat.i(45479);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45479);
    }
    
    GetABTestConfigTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45475);
      this.jXO = new HashMap();
      e(paramParcel);
      AppMethodBeat.o(45475);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45476);
      ac.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
      c localc = com.tencent.mm.model.c.d.aAp().tJ(this.jXN);
      if (localc.isValid()) {
        this.jXO.putAll(localc.eYV());
      }
      bet();
      AppMethodBeat.o(45476);
    }
    
    public final void aLr() {}
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45477);
      this.jXO.clear();
      this.jXO.putAll(paramParcel.readHashMap(HashMap.class.getClassLoader()));
      this.jXN = paramParcel.readString();
      AppMethodBeat.o(45477);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45478);
      paramParcel.writeMap(this.jXO);
      paramParcel.writeString(this.jXN);
      AppMethodBeat.o(45478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig
 * JD-Core Version:    0.7.0.1
 */