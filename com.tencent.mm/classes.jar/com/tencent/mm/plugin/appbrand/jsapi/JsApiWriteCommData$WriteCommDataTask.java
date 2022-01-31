package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

class JsApiWriteCommData$WriteCommDataTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<WriteCommDataTask> CREATOR;
  private int bxX;
  private c hAC;
  private m hyA;
  private boolean hyI;
  private String hyJ;
  private String mData;
  private String mPackageName;
  
  static
  {
    AppMethodBeat.i(114339);
    CREATOR = new JsApiWriteCommData.WriteCommDataTask.1();
    AppMethodBeat.o(114339);
  }
  
  public JsApiWriteCommData$WriteCommDataTask(Parcel paramParcel)
  {
    AppMethodBeat.i(114334);
    f(paramParcel);
    AppMethodBeat.o(114334);
  }
  
  public JsApiWriteCommData$WriteCommDataTask(m paramm, c paramc, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(114333);
    this.hyA = paramm;
    this.hAC = paramc;
    this.bxX = paramInt;
    this.mPackageName = paramJSONObject.optString("packageName");
    this.mData = paramJSONObject.optString("data");
    this.hyI = true;
    AppMethodBeat.o(114333);
  }
  
  public final void ata()
  {
    boolean bool = false;
    AppMethodBeat.i(114335);
    if (bo.isNullOrNil(this.mPackageName)) {
      ab.e("MicroMsg.JsApiWriteCommData", "packageName nil");
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(114335);
      return;
      if (!ah.getContext().getSharedPreferences(ah.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
        bool = true;
      }
      this.hyI = bool;
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(114336);
    if (this.hyI)
    {
      if (bo.isNullOrNil(this.hyJ)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.hyJ }))
      {
        this.hAC.h(this.bxX, this.hyA.j(str, null));
        AppMethodBeat.o(114336);
        return;
      }
    }
    this.hAC.h(this.bxX, this.hyA.j("ok", null));
    AppMethodBeat.o(114336);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(114337);
    this.mPackageName = paramParcel.readString();
    this.mData = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.hyI = bool;
      this.hyJ = paramParcel.readString();
      AppMethodBeat.o(114337);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114338);
    paramParcel.writeString(this.mPackageName);
    paramParcel.writeString(this.mData);
    if (this.hyI) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      AppMethodBeat.o(114338);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData.WriteCommDataTask
 * JD-Core Version:    0.7.0.1
 */