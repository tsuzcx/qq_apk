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
  public final boolean aJB;
  private final Id3Frame[] aNY;
  public final String aNZ;
  public final boolean aOa;
  public final String[] aOb;
  
  static
  {
    AppMethodBeat.i(95297);
    CREATOR = new ChapterTocFrame.1();
    AppMethodBeat.o(95297);
  }
  
  ChapterTocFrame(Parcel paramParcel)
  {
    super("CTOC");
    AppMethodBeat.i(95293);
    this.aNZ = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.aOa = bool1;
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aJB = bool1;
      this.aOb = paramParcel.createStringArray();
      int j = paramParcel.readInt();
      this.aNY = new Id3Frame[j];
      while (i < j)
      {
        this.aNY[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
        i += 1;
      }
      bool1 = false;
      break;
    }
    AppMethodBeat.o(95293);
  }
  
  public ChapterTocFrame(String paramString, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CTOC");
    this.aNZ = paramString;
    this.aOa = paramBoolean1;
    this.aJB = paramBoolean2;
    this.aOb = paramArrayOfString;
    this.aNY = paramArrayOfId3Frame;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95294);
    if (this == paramObject)
    {
      AppMethodBeat.o(95294);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95294);
      return false;
    }
    paramObject = (ChapterTocFrame)paramObject;
    if ((this.aOa == paramObject.aOa) && (this.aJB == paramObject.aJB) && (x.e(this.aNZ, paramObject.aNZ)) && (Arrays.equals(this.aOb, paramObject.aOb)) && (Arrays.equals(this.aNY, paramObject.aNY)))
    {
      AppMethodBeat.o(95294);
      return true;
    }
    AppMethodBeat.o(95294);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(95295);
    int i;
    if (this.aOa)
    {
      i = 1;
      if (!this.aJB) {
        break label66;
      }
    }
    for (;;)
    {
      if (this.aNZ != null) {
        k = this.aNZ.hashCode();
      }
      AppMethodBeat.o(95295);
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
    AppMethodBeat.i(95296);
    paramParcel.writeString(this.aNZ);
    if (this.aOa)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.aJB) {
        break label96;
      }
    }
    label96:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeStringArray(this.aOb);
      paramParcel.writeInt(this.aNY.length);
      paramInt = 0;
      while (paramInt < this.aNY.length)
      {
        paramParcel.writeParcelable(this.aNY[paramInt], 0);
        paramInt += 1;
      }
      paramInt = 0;
      break;
    }
    AppMethodBeat.o(95296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterTocFrame
 * JD-Core Version:    0.7.0.1
 */