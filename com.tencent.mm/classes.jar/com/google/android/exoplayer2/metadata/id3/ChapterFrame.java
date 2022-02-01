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
  public final String bdP;
  public final int bdQ;
  public final int bdR;
  public final long bdS;
  public final long bdT;
  private final Id3Frame[] bdU;
  
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
    this.bdP = paramParcel.readString();
    this.bdQ = paramParcel.readInt();
    this.bdR = paramParcel.readInt();
    this.bdS = paramParcel.readLong();
    this.bdT = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.bdU = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.bdU[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(92409);
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.bdP = paramString;
    this.bdQ = paramInt1;
    this.bdR = paramInt2;
    this.bdS = paramLong1;
    this.bdT = paramLong2;
    this.bdU = paramArrayOfId3Frame;
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
    if ((this.bdQ == paramObject.bdQ) && (this.bdR == paramObject.bdR) && (this.bdS == paramObject.bdS) && (this.bdT == paramObject.bdT) && (x.h(this.bdP, paramObject.bdP)) && (Arrays.equals(this.bdU, paramObject.bdU)))
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
    int j = this.bdQ;
    int k = this.bdR;
    int m = (int)this.bdS;
    int n = (int)this.bdT;
    if (this.bdP != null) {}
    for (int i = this.bdP.hashCode();; i = 0)
    {
      AppMethodBeat.o(92411);
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92412);
    paramParcel.writeString(this.bdP);
    paramParcel.writeInt(this.bdQ);
    paramParcel.writeInt(this.bdR);
    paramParcel.writeLong(this.bdS);
    paramParcel.writeLong(this.bdT);
    paramParcel.writeInt(this.bdU.length);
    Id3Frame[] arrayOfId3Frame = this.bdU;
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