package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CardGiftInfo$AcceptedCardItem
  implements Parcelable
{
  public static final Parcelable.Creator<AcceptedCardItem> CREATOR;
  public String knk;
  public String knl;
  
  static
  {
    AppMethodBeat.i(87779);
    CREATOR = new CardGiftInfo.AcceptedCardItem.1();
    AppMethodBeat.o(87779);
  }
  
  public CardGiftInfo$AcceptedCardItem() {}
  
  private CardGiftInfo$AcceptedCardItem(Parcel paramParcel)
  {
    AppMethodBeat.i(87777);
    this.knk = paramParcel.readString();
    this.knl = paramParcel.readString();
    AppMethodBeat.o(87777);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(87778);
    paramParcel.writeString(this.knk);
    paramParcel.writeString(this.knl);
    AppMethodBeat.o(87778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem
 * JD-Core Version:    0.7.0.1
 */