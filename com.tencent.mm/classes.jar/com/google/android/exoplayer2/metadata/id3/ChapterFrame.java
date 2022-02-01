package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class ChapterFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ChapterFrame> CREATOR;
  public final String bjY;
  public final int bjZ;
  public final int bka;
  public final long bkb;
  public final long bkc;
  private final Id3Frame[] bkd;
  
  static
  {
    AppMethodBeat.i(92413);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92413);
  }
  
  ChapterFrame(Parcel paramParcel)
  {
    super("CHAP");
    AppMethodBeat.i(92409);
    this.bjY = paramParcel.readString();
    this.bjZ = paramParcel.readInt();
    this.bka = paramParcel.readInt();
    this.bkb = paramParcel.readLong();
    this.bkc = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.bkd = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.bkd[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(92409);
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.bjY = paramString;
    this.bjZ = paramInt1;
    this.bka = paramInt2;
    this.bkb = paramLong1;
    this.bkc = paramLong2;
    this.bkd = paramArrayOfId3Frame;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92410);
    if (this == paramObject)
    {
      AppMethodBeat.o(92410);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92410);
      return false;
    }
    paramObject = (ChapterFrame)paramObject;
    if ((this.bjZ == paramObject.bjZ) && (this.bka == paramObject.bka) && (this.bkb == paramObject.bkb) && (this.bkc == paramObject.bkc) && (x.g(this.bjY, paramObject.bjY)) && (Arrays.equals(this.bkd, paramObject.bkd)))
    {
      AppMethodBeat.o(92410);
      return true;
    }
    AppMethodBeat.o(92410);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92411);
    int j = this.bjZ;
    int k = this.bka;
    int m = (int)this.bkb;
    int n = (int)this.bkc;
    if (this.bjY != null) {}
    for (int i = this.bjY.hashCode();; i = 0)
    {
      AppMethodBeat.o(92411);
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92412);
    paramParcel.writeString(this.bjY);
    paramParcel.writeInt(this.bjZ);
    paramParcel.writeInt(this.bka);
    paramParcel.writeLong(this.bkb);
    paramParcel.writeLong(this.bkc);
    paramParcel.writeInt(this.bkd.length);
    Id3Frame[] arrayOfId3Frame = this.bkd;
    int i = arrayOfId3Frame.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfId3Frame[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(92412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterFrame
 * JD-Core Version:    0.7.0.1
 */