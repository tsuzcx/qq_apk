package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class UrlLinkFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<UrlLinkFrame> CREATOR;
  public final String description;
  public final String url;
  
  static
  {
    AppMethodBeat.i(95339);
    CREATOR = new UrlLinkFrame.1();
    AppMethodBeat.o(95339);
  }
  
  UrlLinkFrame(Parcel paramParcel)
  {
    super(paramParcel.readString());
    AppMethodBeat.i(95335);
    this.description = paramParcel.readString();
    this.url = paramParcel.readString();
    AppMethodBeat.o(95335);
  }
  
  public UrlLinkFrame(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.description = paramString2;
    this.url = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95336);
    if (this == paramObject)
    {
      AppMethodBeat.o(95336);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95336);
      return false;
    }
    paramObject = (UrlLinkFrame)paramObject;
    if ((this.id.equals(paramObject.id)) && (x.e(this.description, paramObject.description)) && (x.e(this.url, paramObject.url)))
    {
      AppMethodBeat.o(95336);
      return true;
    }
    AppMethodBeat.o(95336);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(95337);
    int k = this.id.hashCode();
    if (this.description != null) {}
    for (int i = this.description.hashCode();; i = 0)
    {
      if (this.url != null) {
        j = this.url.hashCode();
      }
      AppMethodBeat.o(95337);
      return (i + (k + 527) * 31) * 31 + j;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95338);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.url);
    AppMethodBeat.o(95338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.UrlLinkFrame
 * JD-Core Version:    0.7.0.1
 */