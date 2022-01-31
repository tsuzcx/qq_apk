package com.tencent.mm.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BindWordingContent
  implements Parcelable
{
  public static final Parcelable.Creator<BindWordingContent> CREATOR;
  public Integer bOw;
  public String content;
  public String title;
  
  static
  {
    AppMethodBeat.i(123428);
    CREATOR = new BindWordingContent.1();
    AppMethodBeat.o(123428);
  }
  
  public BindWordingContent(Parcel paramParcel)
  {
    AppMethodBeat.i(123426);
    this.title = "";
    this.content = "";
    this.bOw = Integer.valueOf(0);
    String[] arrayOfString = new String[2];
    paramParcel.readStringArray(arrayOfString);
    this.title = arrayOfString[0];
    this.content = arrayOfString[1];
    this.bOw = Integer.valueOf(paramParcel.readInt());
    AppMethodBeat.o(123426);
  }
  
  public BindWordingContent(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123425);
    this.title = "";
    this.content = "";
    this.bOw = Integer.valueOf(0);
    this.title = paramString1;
    this.content = paramString2;
    AppMethodBeat.o(123425);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123427);
    paramParcel.writeStringArray(new String[] { this.title, this.content });
    paramParcel.writeInt(this.bOw.intValue());
    AppMethodBeat.o(123427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.BindWordingContent
 * JD-Core Version:    0.7.0.1
 */