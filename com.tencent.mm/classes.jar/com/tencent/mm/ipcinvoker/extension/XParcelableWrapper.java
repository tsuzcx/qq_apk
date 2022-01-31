package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class XParcelableWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<XParcelableWrapper> CREATOR = new Parcelable.Creator() {};
  public f dHj;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.dHj != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.dHj.getClass().getName());
      this.dHj.d(paramParcel);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XParcelableWrapper
 * JD-Core Version:    0.7.0.1
 */