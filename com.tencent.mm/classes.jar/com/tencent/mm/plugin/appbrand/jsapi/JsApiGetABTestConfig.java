package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;

public final class JsApiGetABTestConfig
  extends y<r>
{
  public static final int CTRL_INDEX = 527;
  public static final String NAME = "getABTestConfig";
  
  public static class GetABTestConfigTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetABTestConfigTask> CREATOR;
    private String kvy;
    private Map<String, String> kvz;
    
    static
    {
      AppMethodBeat.i(45479);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45479);
    }
    
    GetABTestConfigTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45475);
      this.kvz = new HashMap();
      e(paramParcel);
      AppMethodBeat.o(45475);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45476);
      ae.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
      c localc = com.tencent.mm.model.c.d.aDI().xi(this.kvy);
      if (localc.isValid()) {
        this.kvz.putAll(localc.fsy());
      }
      biG();
      AppMethodBeat.o(45476);
    }
    
    public final void aOY() {}
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45477);
      this.kvz.clear();
      this.kvz.putAll(paramParcel.readHashMap(HashMap.class.getClassLoader()));
      this.kvy = paramParcel.readString();
      AppMethodBeat.o(45477);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45478);
      paramParcel.writeMap(this.kvz);
      paramParcel.writeString(this.kvy);
      AppMethodBeat.o(45478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig
 * JD-Core Version:    0.7.0.1
 */