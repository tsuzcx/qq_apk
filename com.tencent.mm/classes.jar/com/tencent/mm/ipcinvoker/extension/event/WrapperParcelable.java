package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<WrapperParcelable> CREATOR = new WrapperParcelable.1();
  Object dHf;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.dHf != null)
    {
      a locala = c.Y(this.dHf);
      if (locala != null)
      {
        paramParcel.writeInt(1);
        paramParcel.writeString(locala.getClass().getName());
        locala.a(this.dHf, paramParcel);
        return;
      }
    }
    paramParcel.writeInt(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.event.WrapperParcelable
 * JD-Core Version:    0.7.0.1
 */