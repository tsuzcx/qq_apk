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
  public final String cXJ;
  public final int cXK;
  public final int cXL;
  public final long cXM;
  public final long cXN;
  private final Id3Frame[] cXO;
  
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
    this.cXJ = paramParcel.readString();
    this.cXK = paramParcel.readInt();
    this.cXL = paramParcel.readInt();
    this.cXM = paramParcel.readLong();
    this.cXN = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.cXO = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.cXO[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(92409);
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.cXJ = paramString;
    this.cXK = paramInt1;
    this.cXL = paramInt2;
    this.cXM = paramLong1;
    this.cXN = paramLong2;
    this.cXO = paramArrayOfId3Frame;
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
    if ((this.cXK == paramObject.cXK) && (this.cXL == paramObject.cXL) && (this.cXM == paramObject.cXM) && (this.cXN == paramObject.cXN) && (x.p(this.cXJ, paramObject.cXJ)) && (Arrays.equals(this.cXO, paramObject.cXO)))
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
    int j = this.cXK;
    int k = this.cXL;
    int m = (int)this.cXM;
    int n = (int)this.cXN;
    if (this.cXJ != null) {}
    for (int i = this.cXJ.hashCode();; i = 0)
    {
      AppMethodBeat.o(92411);
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92412);
    paramParcel.writeString(this.cXJ);
    paramParcel.writeInt(this.cXK);
    paramParcel.writeInt(this.cXL);
    paramParcel.writeLong(this.cXM);
    paramParcel.writeLong(this.cXN);
    paramParcel.writeInt(this.cXO.length);
    Id3Frame[] arrayOfId3Frame = this.cXO;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterFrame
 * JD-Core Version:    0.7.0.1
 */