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
  public final String but;
  public final int buu;
  public final int buv;
  public final long buw;
  public final long bux;
  private final Id3Frame[] buy;
  
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
    this.but = paramParcel.readString();
    this.buu = paramParcel.readInt();
    this.buv = paramParcel.readInt();
    this.buw = paramParcel.readLong();
    this.bux = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.buy = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.buy[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(92409);
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.but = paramString;
    this.buu = paramInt1;
    this.buv = paramInt2;
    this.buw = paramLong1;
    this.bux = paramLong2;
    this.buy = paramArrayOfId3Frame;
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
    if ((this.buu == paramObject.buu) && (this.buv == paramObject.buv) && (this.buw == paramObject.buw) && (this.bux == paramObject.bux) && (x.i(this.but, paramObject.but)) && (Arrays.equals(this.buy, paramObject.buy)))
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
    int j = this.buu;
    int k = this.buv;
    int m = (int)this.buw;
    int n = (int)this.bux;
    if (this.but != null) {}
    for (int i = this.but.hashCode();; i = 0)
    {
      AppMethodBeat.o(92411);
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92412);
    paramParcel.writeString(this.but);
    paramParcel.writeInt(this.buu);
    paramParcel.writeInt(this.buv);
    paramParcel.writeLong(this.buw);
    paramParcel.writeLong(this.bux);
    paramParcel.writeInt(this.buy.length);
    Id3Frame[] arrayOfId3Frame = this.buy;
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