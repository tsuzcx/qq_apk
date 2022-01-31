package com.tencent.mm.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BindWordingContent
  implements Parcelable
{
  public static final Parcelable.Creator<BindWordingContent> CREATOR = new BindWordingContent.1();
  public Integer boJ = Integer.valueOf(0);
  public String content = "";
  public String title = "";
  
  public BindWordingContent(Parcel paramParcel)
  {
    String[] arrayOfString = new String[2];
    paramParcel.readStringArray(arrayOfString);
    this.title = arrayOfString[0];
    this.content = arrayOfString[1];
    this.boJ = Integer.valueOf(paramParcel.readInt());
  }
  
  public BindWordingContent(String paramString1, String paramString2)
  {
    this.title = paramString1;
    this.content = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(new String[] { this.title, this.content });
    paramParcel.writeInt(this.boJ.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.BindWordingContent
 * JD-Core Version:    0.7.0.1
 */