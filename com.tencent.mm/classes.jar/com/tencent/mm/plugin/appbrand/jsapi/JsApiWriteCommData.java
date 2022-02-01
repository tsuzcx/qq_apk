package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiWriteCommData
  extends c
{
  public static final int CTRL_INDEX = 445;
  public static final String NAME = "writeCommData";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(139854);
    new WriteCommDataTask(this, paramf, paramInt, paramJSONObject).bQt();
    AppMethodBeat.o(139854);
  }
  
  static class WriteCommDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<WriteCommDataTask> CREATOR;
    private int eit;
    private String mData;
    private String mPackageName;
    private f qNp;
    private p ryT;
    private boolean rzb;
    private String rzc;
    
    static
    {
      AppMethodBeat.i(139853);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(139853);
    }
    
    public WriteCommDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(139848);
      h(paramParcel);
      AppMethodBeat.o(139848);
    }
    
    public WriteCommDataTask(p paramp, f paramf, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(139847);
      this.ryT = paramp;
      this.qNp = paramf;
      this.eit = paramInt;
      this.mPackageName = paramJSONObject.optString("packageName");
      this.mData = paramJSONObject.optString("data");
      this.rzb = true;
      AppMethodBeat.o(139847);
    }
    
    public final void asn()
    {
      boolean bool = false;
      AppMethodBeat.i(139849);
      if (Util.isNullOrNil(this.mPackageName)) {
        Log.e("MicroMsg.JsApiWriteCommData", "packageName nil");
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(139849);
        return;
        if (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
          bool = true;
        }
        this.rzb = bool;
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(139850);
      if (this.rzb)
      {
        if (Util.isNullOrNil(this.rzc)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.rzc }))
        {
          this.qNp.callback(this.eit, this.ryT.ZP(str));
          AppMethodBeat.o(139850);
          return;
        }
      }
      this.qNp.callback(this.eit, this.ryT.ZP("ok"));
      AppMethodBeat.o(139850);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(139851);
      this.mPackageName = paramParcel.readString();
      this.mData = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.rzb = bool;
        this.rzc = paramParcel.readString();
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
      if (this.rzb) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
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