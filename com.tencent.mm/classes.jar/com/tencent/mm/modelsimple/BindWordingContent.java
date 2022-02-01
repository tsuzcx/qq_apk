package com.tencent.mm.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BindWordingContent
  implements Parcelable
{
  public static final Parcelable.Creator<BindWordingContent> CREATOR;
  public String content;
  public String title;
  public Integer type;
  
  static
  {
    AppMethodBeat.i(134147);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134147);
  }
  
  public BindWordingContent(Parcel paramParcel)
  {
    AppMethodBeat.i(134145);
    this.title = "";
    this.content = "";
    this.type = Integer.valueOf(0);
    String[] arrayOfString = new String[2];
    paramParcel.readStringArray(arrayOfString);
    this.title = arrayOfString[0];
    this.content = arrayOfString[1];
    this.type = Integer.valueOf(paramParcel.readInt());
    AppMethodBeat.o(134145);
  }
  
  public BindWordingContent(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134144);
    this.title = "";
    this.content = "";
    this.type = Integer.valueOf(0);
    this.title = paramString1;
    this.content = paramString2;
    AppMethodBeat.o(134144);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134146);
    paramParcel.writeStringArray(new String[] { this.title, this.content });
    paramParcel.writeInt(this.type.intValue());
    AppMethodBeat.o(134146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.BindWordingContent
 * JD-Core Version:    0.7.0.1
 */