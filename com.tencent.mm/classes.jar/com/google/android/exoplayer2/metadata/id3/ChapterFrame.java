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
  public final String aNT;
  public final int aNU;
  public final int aNV;
  public final long aNW;
  public final long aNX;
  private final Id3Frame[] aNY;
  
  static
  {
    AppMethodBeat.i(95291);
    CREATOR = new ChapterFrame.1();
    AppMethodBeat.o(95291);
  }
  
  ChapterFrame(Parcel paramParcel)
  {
    super("CHAP");
    AppMethodBeat.i(95287);
    this.aNT = paramParcel.readString();
    this.aNU = paramParcel.readInt();
    this.aNV = paramParcel.readInt();
    this.aNW = paramParcel.readLong();
    this.aNX = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.aNY = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.aNY[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(95287);
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.aNT = paramString;
    this.aNU = paramInt1;
    this.aNV = paramInt2;
    this.aNW = paramLong1;
    this.aNX = paramLong2;
    this.aNY = paramArrayOfId3Frame;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95288);
    if (this == paramObject)
    {
      AppMethodBeat.o(95288);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95288);
      return false;
    }
    paramObject = (ChapterFrame)paramObject;
    if ((this.aNU == paramObject.aNU) && (this.aNV == paramObject.aNV) && (this.aNW == paramObject.aNW) && (this.aNX == paramObject.aNX) && (x.e(this.aNT, paramObject.aNT)) && (Arrays.equals(this.aNY, paramObject.aNY)))
    {
      AppMethodBeat.o(95288);
      return true;
    }
    AppMethodBeat.o(95288);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95289);
    int j = this.aNU;
    int k = this.aNV;
    int m = (int)this.aNW;
    int n = (int)this.aNX;
    if (this.aNT != null) {}
    for (int i = this.aNT.hashCode();; i = 0)
    {
      AppMethodBeat.o(95289);
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95290);
    paramParcel.writeString(this.aNT);
    paramParcel.writeInt(this.aNU);
    paramParcel.writeInt(this.aNV);
    paramParcel.writeLong(this.aNW);
    paramParcel.writeLong(this.aNX);
    paramParcel.writeInt(this.aNY.length);
    Id3Frame[] arrayOfId3Frame = this.aNY;
    int i = arrayOfId3Frame.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfId3Frame[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(95290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterFrame
 * JD-Core Version:    0.7.0.1
 */