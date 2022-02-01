package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class ChapterTocFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ChapterTocFrame> CREATOR;
  public final boolean bqb;
  public final boolean buA;
  public final String[] buB;
  private final Id3Frame[] buy;
  public final String buz;
  
  static
  {
    AppMethodBeat.i(92419);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92419);
  }
  
  ChapterTocFrame(Parcel paramParcel)
  {
    super("CTOC");
    AppMethodBeat.i(92415);
    this.buz = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.buA = bool1;
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bqb = bool1;
      this.buB = paramParcel.createStringArray();
      int j = paramParcel.readInt();
      this.buy = new Id3Frame[j];
      while (i < j)
      {
        this.buy[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
        i += 1;
      }
      bool1 = false;
      break;
    }
    AppMethodBeat.o(92415);
  }
  
  public ChapterTocFrame(String paramString, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CTOC");
    this.buz = paramString;
    this.buA = paramBoolean1;
    this.bqb = paramBoolean2;
    this.buB = paramArrayOfString;
    this.buy = paramArrayOfId3Frame;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92416);
    if (this == paramObject)
    {
      AppMethodBeat.o(92416);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92416);
      return false;
    }
    paramObject = (ChapterTocFrame)paramObject;
    if ((this.buA == paramObject.buA) && (this.bqb == paramObject.bqb) && (x.i(this.buz, paramObject.buz)) && (Arrays.equals(this.buB, paramObject.buB)) && (Arrays.equals(this.buy, paramObject.buy)))
    {
      AppMethodBeat.o(92416);
      return true;
    }
    AppMethodBeat.o(92416);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(92417);
    int i;
    if (this.buA)
    {
      i = 1;
      if (!this.bqb) {
        break label66;
      }
    }
    for (;;)
    {
      if (this.buz != null) {
        k = this.buz.hashCode();
      }
      AppMethodBeat.o(92417);
      return ((i + 527) * 31 + j) * 31 + k;
      i = 0;
      break;
      label66:
      j = 0;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(92418);
    paramParcel.writeString(this.buz);
    if (this.buA)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.bqb) {
        break label96;
      }
    }
    label96:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeStringArray(this.buB);
      paramParcel.writeInt(this.buy.length);
      paramInt = 0;
      while (paramInt < this.buy.length)
      {
        paramParcel.writeParcelable(this.buy[paramInt], 0);
        paramInt += 1;
      }
      paramInt = 0;
      break;
    }
    AppMethodBeat.o(92418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterTocFrame
 * JD-Core Version:    0.7.0.1
 */