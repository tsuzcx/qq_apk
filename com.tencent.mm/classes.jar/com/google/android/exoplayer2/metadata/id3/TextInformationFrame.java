package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TextInformationFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<TextInformationFrame> CREATOR;
  public final String description;
  public final String value;
  
  static
  {
    AppMethodBeat.i(92455);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92455);
  }
  
  TextInformationFrame(Parcel paramParcel)
  {
    super(paramParcel.readString());
    AppMethodBeat.i(92451);
    this.description = paramParcel.readString();
    this.value = paramParcel.readString();
    AppMethodBeat.o(92451);
  }
  
  public TextInformationFrame(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.description = paramString2;
    this.value = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92452);
    if (this == paramObject)
    {
      AppMethodBeat.o(92452);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92452);
      return false;
    }
    paramObject = (TextInformationFrame)paramObject;
    if ((this.id.equals(paramObject.id)) && (x.p(this.description, paramObject.description)) && (x.p(this.value, paramObject.value)))
    {
      AppMethodBeat.o(92452);
      return true;
    }
    AppMethodBeat.o(92452);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(92453);
    int k = this.id.hashCode();
    if (this.description != null) {}
    for (int i = this.description.hashCode();; i = 0)
    {
      if (this.value != null) {
        j = this.value.hashCode();
      }
      AppMethodBeat.o(92453);
      return (i + (k + 527) * 31) * 31 + j;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92454);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.value);
    AppMethodBeat.o(92454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.TextInformationFrame
 * JD-Core Version:    0.7.0.1
 */