package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ctz;

public final class DownloadResult$Content
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ctz();
  public long a;
  public Object a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  
  DownloadResult$Content() {}
  
  public DownloadResult$Content(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.d = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.d = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeString(this.d);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult.Content
 * JD-Core Version:    0.7.0.1
 */