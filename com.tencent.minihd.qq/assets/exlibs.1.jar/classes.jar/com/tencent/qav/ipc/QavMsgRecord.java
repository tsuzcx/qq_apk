package com.tencent.qav.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ljh;

public class QavMsgRecord
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ljh();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public boolean c;
  
  public QavMsgRecord() {}
  
  public QavMsgRecord(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readInt() == 0) {
        break label86;
      }
      bool1 = true;
      label37:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readInt() == 0) {
        break label91;
      }
    }
    label86:
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.c = bool1;
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label37;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label82;
      }
      paramInt = 1;
      label33:
      paramParcel.writeInt(paramInt);
      if (!this.c) {
        break label87;
      }
    }
    label82:
    label87:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.QavMsgRecord
 * JD-Core Version:    0.7.0.1
 */