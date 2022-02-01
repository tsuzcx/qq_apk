package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.kl;
import com.tencent.mm.f.a.kl.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication
  extends c
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask oGG = null;
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106588);
    Log.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.oGG = new GetIsSupportSoterTask(parame, paramInt, this);
    this.oGG.bsM();
    AppMethodBeat.o(106588);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int cqA;
    private e nNw;
    private JsApiCheckIsSupportSoterAuthentication oGH;
    private int oGI;
    
    static
    {
      AppMethodBeat.i(106587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106587);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106585);
      this.nNw = null;
      this.cqA = -1;
      this.oGI = 0;
      f(paramParcel);
      AppMethodBeat.o(106585);
    }
    
    public GetIsSupportSoterTask(e parame, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
    {
      this.nNw = null;
      this.cqA = -1;
      this.oGI = 0;
      this.nNw = parame;
      this.cqA = paramInt;
      this.oGH = paramJsApiCheckIsSupportSoterAuthentication;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(106583);
      kl localkl = new kl();
      EventCenter.instance.publish(localkl);
      this.oGI = localkl.fHY.fHZ;
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.oGI) });
      bPt();
      AppMethodBeat.o(106583);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(106582);
      super.bsK();
      Log.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.oGI) });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("supportMode", a.Ad(this.oGI));
      this.nNw.j(this.cqA, this.oGH.m("ok", localHashMap));
      bPk();
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
      this.oGI = paramParcel.readInt();
      AppMethodBeat.o(106586);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106584);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.oGI);
      AppMethodBeat.o(106584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */