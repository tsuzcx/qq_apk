package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class JsApiUpdateApp$SyncResult
  implements Parcelable
{
  public static final Parcelable.Creator<SyncResult> CREATOR = new JsApiUpdateApp.SyncResult.1();
  private int cau;
  private boolean gCA;
  
  JsApiUpdateApp$SyncResult(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.gCA = bool;
      this.cau = paramParcel.readInt();
      return;
    }
  }
  
  JsApiUpdateApp$SyncResult(boolean paramBoolean, int paramInt)
  {
    this.gCA = paramBoolean;
    this.cau = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.gCA) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.cau);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.SyncResult
 * JD-Core Version:    0.7.0.1
 */