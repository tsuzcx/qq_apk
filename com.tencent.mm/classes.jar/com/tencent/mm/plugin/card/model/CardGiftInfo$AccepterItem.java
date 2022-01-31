package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardGiftInfo$AccepterItem
  implements Parcelable
{
  public static final Parcelable.Creator<AccepterItem> CREATOR = new CardGiftInfo.AccepterItem.1();
  public String imo;
  public String imp;
  public String imq;
  public String imr;
  
  public CardGiftInfo$AccepterItem() {}
  
  private CardGiftInfo$AccepterItem(Parcel paramParcel)
  {
    this.imo = paramParcel.readString();
    this.imp = paramParcel.readString();
    this.imq = paramParcel.readString();
    this.imr = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.imo);
    paramParcel.writeString(this.imp);
    paramParcel.writeString(this.imq);
    paramParcel.writeString(this.imr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem
 * JD-Core Version:    0.7.0.1
 */