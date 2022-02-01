package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class JsApiWriteCommData
  extends a
{
  public static final int CTRL_INDEX = 445;
  public static final String NAME = "writeCommData";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(139854);
    AppBrandMainProcessService.a(new WriteCommDataTask(this, paramc, paramInt, paramJSONObject));
    AppMethodBeat.o(139854);
  }
  
  static class WriteCommDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<WriteCommDataTask> CREATOR;
    private int cgA;
    private m ksO;
    private boolean ksW;
    private String ksX;
    private c kuU;
    private String mData;
    private String mPackageName;
    
    static
    {
      AppMethodBeat.i(139853);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(139853);
    }
    
    public WriteCommDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(139848);
      e(paramParcel);
      AppMethodBeat.o(139848);
    }
    
    public WriteCommDataTask(m paramm, c paramc, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139847);
      this.ksO = paramm;
      this.kuU = paramc;
      this.cgA = paramInt;
      this.mPackageName = paramJSONObject.optString("packageName");
      this.mData = paramJSONObject.optString("data");
      this.ksW = true;
      AppMethodBeat.o(139847);
    }
    
    public final void aOA()
    {
      boolean bool = false;
      AppMethodBeat.i(139849);
      if (bt.isNullOrNil(this.mPackageName)) {
        ad.e("MicroMsg.JsApiWriteCommData", "packageName nil");
      }
      for (;;)
      {
        bhX();
        AppMethodBeat.o(139849);
        return;
        if (!aj.getContext().getSharedPreferences(aj.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
          bool = true;
        }
        this.ksW = bool;
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(139850);
      if (this.ksW)
      {
        if (bt.isNullOrNil(this.ksX)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ksX }))
        {
          this.kuU.h(this.cgA, this.ksO.e(str, null));
          AppMethodBeat.o(139850);
          return;
        }
      }
      this.kuU.h(this.cgA, this.ksO.e("ok", null));
      AppMethodBeat.o(139850);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(139851);
      this.mPackageName = paramParcel.readString();
      this.mData = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ksW = bool;
        this.ksX = paramParcel.readString();
        AppMethodBeat.o(139851);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(139852);
      paramParcel.writeString(this.mPackageName);
      paramParcel.writeString(this.mData);
      if (this.ksW) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        AppMethodBeat.o(139852);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData
 * JD-Core Version:    0.7.0.1
 */