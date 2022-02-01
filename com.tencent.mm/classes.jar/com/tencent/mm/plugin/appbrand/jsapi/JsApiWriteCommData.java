package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiWriteCommData
  extends d
{
  public static final int CTRL_INDEX = 445;
  public static final String NAME = "writeCommData";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(139854);
    AppBrandMainProcessService.a(new WriteCommDataTask(this, paramf, paramInt, paramJSONObject));
    AppMethodBeat.o(139854);
  }
  
  static class WriteCommDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<WriteCommDataTask> CREATOR;
    private int csv;
    private f kSY;
    private p lAi;
    private boolean lAq;
    private String lAr;
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
      f(paramParcel);
      AppMethodBeat.o(139848);
    }
    
    public WriteCommDataTask(p paramp, f paramf, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139847);
      this.lAi = paramp;
      this.kSY = paramf;
      this.csv = paramInt;
      this.mPackageName = paramJSONObject.optString("packageName");
      this.mData = paramJSONObject.optString("data");
      this.lAq = true;
      AppMethodBeat.o(139847);
    }
    
    public final void bjj()
    {
      boolean bool = false;
      AppMethodBeat.i(139849);
      if (Util.isNullOrNil(this.mPackageName)) {
        Log.e("MicroMsg.JsApiWriteCommData", "packageName nil");
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(139849);
        return;
        if (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
          bool = true;
        }
        this.lAq = bool;
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(139850);
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kSY.i(this.csv, this.lAi.h(str, null));
          AppMethodBeat.o(139850);
          return;
        }
      }
      this.kSY.i(this.csv, this.lAi.h("ok", null));
      AppMethodBeat.o(139850);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(139851);
      this.mPackageName = paramParcel.readString();
      this.mData = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lAq = bool;
        this.lAr = paramParcel.readString();
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
      if (this.lAq) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
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