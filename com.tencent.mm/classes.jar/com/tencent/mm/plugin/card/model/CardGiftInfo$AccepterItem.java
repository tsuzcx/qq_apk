package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CardGiftInfo$AccepterItem
  implements Parcelable
{
  public static final Parcelable.Creator<AccepterItem> CREATOR;
  public String knk;
  public String knl;
  public String knm;
  public String knn;
  
  static
  {
    AppMethodBeat.i(87783);
    CREATOR = new CardGiftInfo.AccepterItem.1();
    AppMethodBeat.o(87783);
  }
  
  public CardGiftInfo$AccepterItem() {}
  
  private CardGiftInfo$AccepterItem(Parcel paramParcel)
  {
    AppMethodBeat.i(87781);
    this.knk = paramParcel.readString();
    this.knl = paramParcel.readString();
    this.knm = paramParcel.readString();
    this.knn = paramParcel.readString();
    AppMethodBeat.o(87781);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(87782);
    paramParcel.writeString(this.knk);
    paramParcel.writeString(this.knl);
    paramParcel.writeString(this.knm);
    paramParcel.writeString(this.knn);
    AppMethodBeat.o(87782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem
 * JD-Core Version:    0.7.0.1
 */