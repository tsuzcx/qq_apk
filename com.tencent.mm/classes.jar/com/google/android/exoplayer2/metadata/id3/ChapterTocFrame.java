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
  public final boolean aZy;
  private final Id3Frame[] bdU;
  public final String bdV;
  public final boolean bdW;
  public final String[] bdX;
  
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
    this.bdV = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.bdW = bool1;
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aZy = bool1;
      this.bdX = paramParcel.createStringArray();
      int j = paramParcel.readInt();
      this.bdU = new Id3Frame[j];
      while (i < j)
      {
        this.bdU[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
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
    this.bdV = paramString;
    this.bdW = paramBoolean1;
    this.aZy = paramBoolean2;
    this.bdX = paramArrayOfString;
    this.bdU = paramArrayOfId3Frame;
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
    if ((this.bdW == paramObject.bdW) && (this.aZy == paramObject.aZy) && (x.h(this.bdV, paramObject.bdV)) && (Arrays.equals(this.bdX, paramObject.bdX)) && (Arrays.equals(this.bdU, paramObject.bdU)))
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
    if (this.bdW)
    {
      i = 1;
      if (!this.aZy) {
        break label66;
      }
    }
    for (;;)
    {
      if (this.bdV != null) {
        k = this.bdV.hashCode();
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
    paramParcel.writeString(this.bdV);
    if (this.bdW)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.aZy) {
        break label96;
      }
    }
    label96:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeStringArray(this.bdX);
      paramParcel.writeInt(this.bdU.length);
      paramInt = 0;
      while (paramInt < this.bdU.length)
      {
        paramParcel.writeParcelable(this.bdU[paramInt], 0);
        paramInt += 1;
      }
      paramInt = 0;
      break;
    }
    AppMethodBeat.o(92418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterTocFrame
 * JD-Core Version:    0.7.0.1
 */