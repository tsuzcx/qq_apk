package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardGiftInfo$AcceptedCardItem
  implements Parcelable
{
  public static final Parcelable.Creator<AcceptedCardItem> CREATOR = new CardGiftInfo.AcceptedCardItem.1();
  public String imo;
  public String imp;
  
  public CardGiftInfo$AcceptedCardItem() {}
  
  private CardGiftInfo$AcceptedCardItem(Parcel paramParcel)
  {
    this.imo = paramParcel.readString();
    this.imp = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.imo);
    paramParcel.writeString(this.imp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem
 * JD-Core Version:    0.7.0.1
 */