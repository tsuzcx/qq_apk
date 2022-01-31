package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class ChapterFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ChapterFrame> CREATOR = new ChapterFrame.1();
  public final String aGY;
  public final int aGZ;
  public final int aHa;
  public final long aHb;
  public final long aHc;
  private final Id3Frame[] aHd;
  
  ChapterFrame(Parcel paramParcel)
  {
    super("CHAP");
    this.aGY = paramParcel.readString();
    this.aGZ = paramParcel.readInt();
    this.aHa = paramParcel.readInt();
    this.aHb = paramParcel.readLong();
    this.aHc = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.aHd = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.aHd[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.aGY = paramString;
    this.aGZ = paramInt1;
    this.aHa = paramInt2;
    this.aHb = paramLong1;
    this.aHc = paramLong2;
    this.aHd = paramArrayOfId3Frame;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ChapterFrame)paramObject;
    } while ((this.aGZ == paramObject.aGZ) && (this.aHa == paramObject.aHa) && (this.aHb == paramObject.aHb) && (this.aHc == paramObject.aHc) && (t.e(this.aGY, paramObject.aGY)) && (Arrays.equals(this.aHd, paramObject.aHd)));
    return false;
  }
  
  public final int hashCode()
  {
    int j = this.aGZ;
    int k = this.aHa;
    int m = (int)this.aHb;
    int n = (int)this.aHc;
    if (this.aGY != null) {}
    for (int i = this.aGY.hashCode();; i = 0) {
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.aGY);
    paramParcel.writeInt(this.aGZ);
    paramParcel.writeInt(this.aHa);
    paramParcel.writeLong(this.aHb);
    paramParcel.writeLong(this.aHc);
    paramParcel.writeInt(this.aHd.length);
    Id3Frame[] arrayOfId3Frame = this.aHd;
    int i = arrayOfId3Frame.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfId3Frame[paramInt], 0);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterFrame
 * JD-Core Version:    0.7.0.1
 */