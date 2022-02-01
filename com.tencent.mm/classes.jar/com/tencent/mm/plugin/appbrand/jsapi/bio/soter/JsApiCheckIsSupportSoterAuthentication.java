package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.ix.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask khH = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106588);
    ac.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.khH = new GetIsSupportSoterTask(paramc, paramInt, this);
    this.khH.bej();
    AppBrandMainProcessService.a(this.khH);
    AppMethodBeat.o(106588);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int bWl;
    private c kay;
    private JsApiCheckIsSupportSoterAuthentication khI;
    private int khJ;
    
    static
    {
      AppMethodBeat.i(106587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106587);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106585);
      this.kay = null;
      this.bWl = -1;
      this.khJ = 0;
      e(paramParcel);
      AppMethodBeat.o(106585);
    }
    
    public GetIsSupportSoterTask(c paramc, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
    {
      this.kay = null;
      this.bWl = -1;
      this.khJ = 0;
      this.kay = paramc;
      this.bWl = paramInt;
      this.khI = paramJsApiCheckIsSupportSoterAuthentication;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(106583);
      ix localix = new ix();
      com.tencent.mm.sdk.b.a.GpY.l(localix);
      this.khJ = localix.dko.dkp;
      ac.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.khJ) });
      bet();
      AppMethodBeat.o(106583);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(106582);
      super.aLr();
      ac.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.khJ) });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("supportMode", a.sn(this.khJ));
      this.kay.h(this.bWl, this.khI.k("ok", localHashMap));
      bek();
      AppMethodBeat.o(106582);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(106586);
      super.e(paramParcel);
      this.khJ = paramParcel.readInt();
      AppMethodBeat.o(106586);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106584);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.khJ);
      AppMethodBeat.o(106584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */