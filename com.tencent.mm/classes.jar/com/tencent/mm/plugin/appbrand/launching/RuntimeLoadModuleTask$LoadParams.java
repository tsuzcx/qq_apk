package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RuntimeLoadModuleTask$LoadParams
  implements Parcelable
{
  public static final Parcelable.Creator<LoadParams> CREATOR = new RuntimeLoadModuleTask.LoadParams.1();
  public final String appId;
  public final int bOa;
  public final String fCQ;
  public final int fEN;
  
  RuntimeLoadModuleTask$LoadParams(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.bOa = paramParcel.readInt();
    this.fEN = paramParcel.readInt();
    this.fCQ = paramParcel.readString();
  }
  
  private RuntimeLoadModuleTask$LoadParams(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.appId = paramString1;
    this.bOa = paramInt1;
    this.fEN = paramInt2;
    this.fCQ = paramString2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.bOa + ", pkgVersion=" + this.fEN + ", moduleName='" + this.fCQ + '\'' + '}';
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.bOa);
    paramParcel.writeInt(this.fEN);
    paramParcel.writeString(this.fCQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.LoadParams
 * JD-Core Version:    0.7.0.1
 */