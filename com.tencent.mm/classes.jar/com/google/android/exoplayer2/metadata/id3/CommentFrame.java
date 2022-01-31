package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CommentFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<CommentFrame> CREATOR;
  public final String axa;
  public final String description;
  public final String text;
  
  static
  {
    AppMethodBeat.i(95303);
    CREATOR = new CommentFrame.1();
    AppMethodBeat.o(95303);
  }
  
  CommentFrame(Parcel paramParcel)
  {
    super("COMM");
    AppMethodBeat.i(95299);
    this.axa = paramParcel.readString();
    this.description = paramParcel.readString();
    this.text = paramParcel.readString();
    AppMethodBeat.o(95299);
  }
  
  public CommentFrame(String paramString1, String paramString2, String paramString3)
  {
    super("COMM");
    this.axa = paramString1;
    this.description = paramString2;
    this.text = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95300);
    if (this == paramObject)
    {
      AppMethodBeat.o(95300);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95300);
      return false;
    }
    paramObject = (CommentFrame)paramObject;
    if ((x.e(this.description, paramObject.description)) && (x.e(this.axa, paramObject.axa)) && (x.e(this.text, paramObject.text)))
    {
      AppMethodBeat.o(95300);
      return true;
    }
    AppMethodBeat.o(95300);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(95301);
    int i;
    if (this.axa != null)
    {
      i = this.axa.hashCode();
      if (this.description == null) {
        break label78;
      }
    }
    label78:
    for (int j = this.description.hashCode();; j = 0)
    {
      if (this.text != null) {
        k = this.text.hashCode();
      }
      AppMethodBeat.o(95301);
      return (j + (i + 527) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95302);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.axa);
    paramParcel.writeString(this.text);
    AppMethodBeat.o(95302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.CommentFrame
 * JD-Core Version:    0.7.0.1
 */