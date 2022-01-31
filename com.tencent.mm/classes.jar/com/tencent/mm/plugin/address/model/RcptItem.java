package com.tencent.mm.plugin.address.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RcptItem
  implements Parcelable
{
  public static final Parcelable.Creator<RcptItem> CREATOR = new RcptItem.1();
  public String code = "";
  public String ftq = "";
  public boolean ftr = false;
  public String name = "";
  
  public RcptItem() {}
  
  public RcptItem(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.code = paramParcel.readString();
    this.ftq = paramParcel.readString();
  }
  
  public RcptItem(String paramString1, String paramString2, String paramString3)
  {
    this.name = paramString1;
    this.code = paramString2;
    this.ftq = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.code);
    paramParcel.writeString(this.ftq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.RcptItem
 * JD-Core Version:    0.7.0.1
 */