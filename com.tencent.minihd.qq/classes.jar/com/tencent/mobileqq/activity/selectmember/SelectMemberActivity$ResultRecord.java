package com.tencent.mobileqq.activity.selectmember;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gyb;

public class SelectMemberActivity$ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new gyb();
  public int a;
  public String a;
  public String b;
  public String c;
  
  public SelectMemberActivity$ResultRecord() {}
  
  private SelectMemberActivity$ResultRecord(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.ResultRecord
 * JD-Core Version:    0.7.0.1
 */