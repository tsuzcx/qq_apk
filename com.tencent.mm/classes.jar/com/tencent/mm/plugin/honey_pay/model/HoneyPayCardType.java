package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public class HoneyPayCardType
  implements Parcelable
{
  public static final Parcelable.Creator<HoneyPayCardType> CREATOR = new HoneyPayCardType.1();
  public byte[] oY;
  
  protected HoneyPayCardType(Parcel paramParcel)
  {
    this.oY = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.oY);
  }
  
  public HoneyPayCardType(aoi paramaoi)
  {
    try
    {
      this.oY = paramaoi.toByteArray();
      return;
    }
    catch (IOException paramaoi)
    {
      y.printErrStackTrace("MicroMsg.HoneyPayCardType", paramaoi, "", new Object[0]);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.oY.length);
    paramParcel.writeByteArray(this.oY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType
 * JD-Core Version:    0.7.0.1
 */