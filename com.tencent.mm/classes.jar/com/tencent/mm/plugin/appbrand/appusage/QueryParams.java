package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;

final class QueryParams
  implements Parcelable
{
  public static final QueryParams.a CREATOR = new QueryParams.a((byte)0);
  final int count;
  final af.a fKb;
  
  public QueryParams(int paramInt, af.a parama)
  {
    this.count = paramInt;
    this.fKb = parama;
  }
  
  public QueryParams(Parcel paramParcel) {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel != null) {
      paramParcel.writeInt(this.count);
    }
    af.a locala;
    if (paramParcel != null)
    {
      locala = this.fKb;
      if (locala == null) {
        break label36;
      }
    }
    label36:
    for (paramInt = locala.ordinal();; paramInt = -1)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.QueryParams
 * JD-Core Version:    0.7.0.1
 */