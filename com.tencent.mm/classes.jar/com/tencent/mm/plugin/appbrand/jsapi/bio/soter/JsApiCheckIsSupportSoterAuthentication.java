package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lp;
import com.tencent.mm.autogen.a.lp.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication
  extends c
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask rJF = null;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106588);
    Log.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.rJF = new GetIsSupportSoterTask(paramf, paramInt, this);
    this.rJF.bQt();
    AppMethodBeat.o(106588);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int eit;
    private f qNp;
    private JsApiCheckIsSupportSoterAuthentication rJG;
    private int rJH;
    
    static
    {
      AppMethodBeat.i(106587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106587);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106585);
      this.qNp = null;
      this.eit = -1;
      this.rJH = 0;
      h(paramParcel);
      AppMethodBeat.o(106585);
    }
    
    public GetIsSupportSoterTask(f paramf, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
    {
      this.qNp = null;
      this.eit = -1;
      this.rJH = 0;
      this.qNp = paramf;
      this.eit = paramInt;
      this.rJG = paramJsApiCheckIsSupportSoterAuthentication;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(106583);
      lp locallp = new lp();
      locallp.publish();
      this.rJH = locallp.hNy.hNz;
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.rJH) });
      cpA();
      AppMethodBeat.o(106583);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(106582);
      super.bQr();
      Log.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.rJH) });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("supportMode", a.Au(this.rJH));
      this.qNp.callback(this.eit, this.rJG.m("ok", localHashMap));
      cpx();
      AppMethodBeat.o(106582);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(106586);
      super.h(paramParcel);
      this.rJH = paramParcel.readInt();
      AppMethodBeat.o(106586);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106584);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.rJH);
      AppMethodBeat.o(106584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */