package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class ChapterTocFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new ChapterTocFrame.1();
  private final Id3Frame[] aHd;
  public final String aHe;
  public final boolean aHf;
  public final boolean aHg;
  public final String[] aHh;
  
  ChapterTocFrame(Parcel paramParcel)
  {
    super("CTOC");
    this.aHe = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.aHf = bool1;
      if (paramParcel.readByte() == 0) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aHg = bool1;
      this.aHh = paramParcel.createStringArray();
      int j = paramParcel.readInt();
      this.aHd = new Id3Frame[j];
      while (i < j)
      {
        this.aHd[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
        i += 1;
      }
      bool1 = false;
      break;
    }
  }
  
  public ChapterTocFrame(String paramString, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CTOC");
    this.aHe = paramString;
    this.aHf = paramBoolean1;
    this.aHg = paramBoolean2;
    this.aHh = paramArrayOfString;
    this.aHd = paramArrayOfId3Frame;
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
      paramObject = (ChapterTocFrame)paramObject;
    } while ((this.aHf == paramObject.aHf) && (this.aHg == paramObject.aHg) && (t.e(this.aHe, paramObject.aHe)) && (Arrays.equals(this.aHh, paramObject.aHh)) && (Arrays.equals(this.aHd, paramObject.aHd)));
    return false;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int k = 0;
    int i;
    if (this.aHf)
    {
      i = 1;
      if (!this.aHg) {
        break label56;
      }
    }
    for (;;)
    {
      if (this.aHe != null) {
        k = this.aHe.hashCode();
      }
      return ((i + 527) * 31 + j) * 31 + k;
      i = 0;
      break;
      label56:
      j = 0;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.aHe);
    if (this.aHf)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.aHg) {
        break label91;
      }
    }
    label91:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeStringArray(this.aHh);
      paramParcel.writeInt(this.aHd.length);
      paramInt = 0;
      while (paramInt < this.aHd.length)
      {
        paramParcel.writeParcelable(this.aHd[paramInt], 0);
        paramInt += 1;
      }
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterTocFrame
 * JD-Core Version:    0.7.0.1
 */