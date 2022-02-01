package com.tencent.mm.plugin.lite.logic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelableLiteAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableLiteAppInfo> CREATOR;
  public String field_appId;
  public String field_patchId;
  public String field_pkgPath;
  public String field_pkgType;
  public String field_signatureKey;
  public long field_updateTime;
  
  static
  {
    AppMethodBeat.i(217816);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(217816);
  }
  
  public ParcelableLiteAppInfo() {}
  
  public ParcelableLiteAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    this.field_appId = paramString1;
    this.field_signatureKey = paramString2;
    this.field_pkgPath = paramString3;
    this.field_pkgType = paramString4;
    this.field_updateTime = paramLong;
    this.field_patchId = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(217815);
    paramParcel.writeString(this.field_appId);
    paramParcel.writeString(this.field_signatureKey);
    paramParcel.writeString(this.field_pkgPath);
    paramParcel.writeString(this.field_pkgType);
    paramParcel.writeString(this.field_patchId);
    paramParcel.writeLong(this.field_updateTime);
    AppMethodBeat.o(217815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.ParcelableLiteAppInfo
 * JD-Core Version:    0.7.0.1
 */