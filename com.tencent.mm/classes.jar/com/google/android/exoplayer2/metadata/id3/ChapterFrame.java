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
  public final String bjt;
  public final int bju;
  public final int bjv;
  public final long bjw;
  public final long bjx;
  private final Id3Frame[] bjy;
  
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
    this.bjt = paramParcel.readString();
    this.bju = paramParcel.readInt();
    this.bjv = paramParcel.readInt();
    this.bjw = paramParcel.readLong();
    this.bjx = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.bjy = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.bjy[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(92409);
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.bjt = paramString;
    this.bju = paramInt1;
    this.bjv = paramInt2;
    this.bjw = paramLong1;
    this.bjx = paramLong2;
    this.bjy = paramArrayOfId3Frame;
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
    if ((this.bju == paramObject.bju) && (this.bjv == paramObject.bjv) && (this.bjw == paramObject.bjw) && (this.bjx == paramObject.bjx) && (x.g(this.bjt, paramObject.bjt)) && (Arrays.equals(this.bjy, paramObject.bjy)))
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
    int j = this.bju;
    int k = this.bjv;
    int m = (int)this.bjw;
    int n = (int)this.bjx;
    if (this.bjt != null) {}
    for (int i = this.bjt.hashCode();; i = 0)
    {
      AppMethodBeat.o(92411);
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92412);
    paramParcel.writeString(this.bjt);
    paramParcel.writeInt(this.bju);
    paramParcel.writeInt(this.bjv);
    paramParcel.writeLong(this.bjw);
    paramParcel.writeLong(this.bjx);
    paramParcel.writeInt(this.bjy.length);
    Id3Frame[] arrayOfId3Frame = this.bjy;
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