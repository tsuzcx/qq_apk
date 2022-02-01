package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.jv.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication
  extends d
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask lKq = null;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106588);
    Log.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.lKq = new GetIsSupportSoterTask(paramf, paramInt, this);
    this.lKq.bDJ();
    AppBrandMainProcessService.a(this.lKq);
    AppMethodBeat.o(106588);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int csv;
    private f kSY;
    private JsApiCheckIsSupportSoterAuthentication lKr;
    private int lKs;
    
    static
    {
      AppMethodBeat.i(106587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106587);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106585);
      this.kSY = null;
      this.csv = -1;
      this.lKs = 0;
      f(paramParcel);
      AppMethodBeat.o(106585);
    }
    
    public GetIsSupportSoterTask(f paramf, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
    {
      this.kSY = null;
      this.csv = -1;
      this.lKs = 0;
      this.kSY = paramf;
      this.csv = paramInt;
      this.lKr = paramJsApiCheckIsSupportSoterAuthentication;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(106583);
      jv localjv = new jv();
      EventCenter.instance.publish(localjv);
      this.lKs = localjv.dON.dOO;
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.lKs) });
      bDU();
      AppMethodBeat.o(106583);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(106582);
      super.bjk();
      Log.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.lKs) });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("supportMode", a.wO(this.lKs));
      this.kSY.i(this.csv, this.lKr.n("ok", localHashMap));
      bDK();
      AppMethodBeat.o(106582);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(106586);
      super.f(paramParcel);
      this.lKs = paramParcel.readInt();
      AppMethodBeat.o(106586);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106584);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.lKs);
      AppMethodBeat.o(106584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */