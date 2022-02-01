package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CommentFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<CommentFrame> CREATOR;
  public final String description;
  public final String language;
  public final String text;
  
  static
  {
    AppMethodBeat.i(92425);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92425);
  }
  
  CommentFrame(Parcel paramParcel)
  {
    super("COMM");
    AppMethodBeat.i(92421);
    this.language = paramParcel.readString();
    this.description = paramParcel.readString();
    this.text = paramParcel.readString();
    AppMethodBeat.o(92421);
  }
  
  public CommentFrame(String paramString1, String paramString2, String paramString3)
  {
    super("COMM");
    this.language = paramString1;
    this.description = paramString2;
    this.text = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92422);
    if (this == paramObject)
    {
      AppMethodBeat.o(92422);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92422);
      return false;
    }
    paramObject = (CommentFrame)paramObject;
    if ((x.j(this.description, paramObject.description)) && (x.j(this.language, paramObject.language)) && (x.j(this.text, paramObject.text)))
    {
      AppMethodBeat.o(92422);
      return true;
    }
    AppMethodBeat.o(92422);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(92423);
    int i;
    if (this.language != null)
    {
      i = this.language.hashCode();
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
      AppMethodBeat.o(92423);
      return (j + (i + 527) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92424);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.language);
    paramParcel.writeString(this.text);
    AppMethodBeat.o(92424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.CommentFrame
 * JD-Core Version:    0.7.0.1
 */