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
  public final String bun;
  public final int buo;
  public final int bup;
  public final long buq;
  public final long bur;
  private final Id3Frame[] bus;
  
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
    this.bun = paramParcel.readString();
    this.buo = paramParcel.readInt();
    this.bup = paramParcel.readInt();
    this.buq = paramParcel.readLong();
    this.bur = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.bus = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.bus[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(92409);
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.bun = paramString;
    this.buo = paramInt1;
    this.bup = paramInt2;
    this.buq = paramLong1;
    this.bur = paramLong2;
    this.bus = paramArrayOfId3Frame;
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
    if ((this.buo == paramObject.buo) && (this.bup == paramObject.bup) && (this.buq == paramObject.buq) && (this.bur == paramObject.bur) && (x.j(this.bun, paramObject.bun)) && (Arrays.equals(this.bus, paramObject.bus)))
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
    int j = this.buo;
    int k = this.bup;
    int m = (int)this.buq;
    int n = (int)this.bur;
    if (this.bun != null) {}
    for (int i = this.bun.hashCode();; i = 0)
    {
      AppMethodBeat.o(92411);
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92412);
    paramParcel.writeString(this.bun);
    paramParcel.writeInt(this.buo);
    paramParcel.writeInt(this.bup);
    paramParcel.writeLong(this.buq);
    paramParcel.writeLong(this.bur);
    paramParcel.writeInt(this.bus.length);
    Id3Frame[] arrayOfId3Frame = this.bus;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterFrame
 * JD-Core Version:    0.7.0.1
 */