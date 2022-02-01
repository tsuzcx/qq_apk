package com.tencent.device.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dbn;
import java.util.ArrayList;

public class LightAppSettingInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new dbn();
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public long a;
  public String a;
  public ArrayList a;
  public String b;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  
  public int describeContents()
  {
    return 0;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeInt(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.utils.LightAppSettingInfo
 * JD-Core Version:    0.7.0.1
 */