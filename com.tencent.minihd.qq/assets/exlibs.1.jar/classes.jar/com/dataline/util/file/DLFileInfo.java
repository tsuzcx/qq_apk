package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ed;

public class DLFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ed();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  
  public DLFileInfo()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private DLFileInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.file.DLFileInfo
 * JD-Core Version:    0.7.0.1
 */