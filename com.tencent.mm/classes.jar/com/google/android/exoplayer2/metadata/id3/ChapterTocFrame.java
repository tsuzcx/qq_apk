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
  public final boolean bpW;
  private final Id3Frame[] bus;
  public final String but;
  public final boolean buu;
  public final String[] buv;
  
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
    this.but = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.buu = bool1;
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bpW = bool1;
      this.buv = paramParcel.createStringArray();
      int j = paramParcel.readInt();
      this.bus = new Id3Frame[j];
      while (i < j)
      {
        this.bus[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
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
    this.but = paramString;
    this.buu = paramBoolean1;
    this.bpW = paramBoolean2;
    this.buv = paramArrayOfString;
    this.bus = paramArrayOfId3Frame;
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
    if ((this.buu == paramObject.buu) && (this.bpW == paramObject.bpW) && (x.j(this.but, paramObject.but)) && (Arrays.equals(this.buv, paramObject.buv)) && (Arrays.equals(this.bus, paramObject.bus)))
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
    if (this.buu)
    {
      i = 1;
      if (!this.bpW) {
        break label66;
      }
    }
    for (;;)
    {
      if (this.but != null) {
        k = this.but.hashCode();
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
    paramParcel.writeString(this.but);
    if (this.buu)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.bpW) {
        break label96;
      }
    }
    label96:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeStringArray(this.buv);
      paramParcel.writeInt(this.bus.length);
      paramInt = 0;
      while (paramInt < this.bus.length)
      {
        paramParcel.writeParcelable(this.bus[paramInt], 0);
        paramInt += 1;
      }
      paramInt = 0;
      break;
    }
    AppMethodBeat.o(92418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterTocFrame
 * JD-Core Version:    0.7.0.1
 */