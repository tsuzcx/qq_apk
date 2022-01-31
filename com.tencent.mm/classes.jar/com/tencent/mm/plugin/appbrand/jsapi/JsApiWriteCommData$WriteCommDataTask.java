package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

class JsApiWriteCommData$WriteCommDataTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<WriteCommDataTask> CREATOR = new JsApiWriteCommData.WriteCommDataTask.1();
  private int bhx;
  private c gfZ;
  private i gho;
  private boolean ghr;
  private String ghs;
  private String mData;
  private String mPackageName;
  
  public JsApiWriteCommData$WriteCommDataTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiWriteCommData$WriteCommDataTask(i parami, c paramc, int paramInt, JSONObject paramJSONObject)
  {
    this.gho = parami;
    this.gfZ = paramc;
    this.bhx = paramInt;
    this.mPackageName = paramJSONObject.optString("packageName");
    this.mData = paramJSONObject.optString("data");
    this.ghr = true;
  }
  
  public final void Zu()
  {
    boolean bool = false;
    if (bk.bl(this.mPackageName)) {
      y.e("MicroMsg.JsApiWriteCommData", "packageName nil");
    }
    for (;;)
    {
      ahI();
      return;
      if (!ae.getContext().getSharedPreferences(ae.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
        bool = true;
      }
      this.ghr = bool;
    }
  }
  
  public final void Zv()
  {
    if (this.ghr)
    {
      if (bk.bl(this.ghs)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ghs }))
      {
        this.gfZ.C(this.bhx, this.gho.h(str, null));
        return;
      }
    }
    this.gfZ.C(this.bhx, this.gho.h("ok", null));
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.mPackageName = paramParcel.readString();
    this.mData = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.ghr = bool;
      this.ghs = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mPackageName);
    paramParcel.writeString(this.mData);
    if (this.ghr) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ghs);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData.WriteCommDataTask
 * JD-Core Version:    0.7.0.1
 */