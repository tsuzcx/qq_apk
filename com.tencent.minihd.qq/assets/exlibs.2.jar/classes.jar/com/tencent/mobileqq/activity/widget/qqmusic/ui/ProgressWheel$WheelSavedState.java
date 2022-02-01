package com.tencent.mobileqq.activity.widget.qqmusic.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import hdl;

public class ProgressWheel$WheelSavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new hdl();
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  
  private ProgressWheel$WheelSavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_b_of_type_Float = paramParcel.readFloat();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_c_of_type_Float = paramParcel.readFloat();
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label119;
      }
      bool1 = true;
      label94:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label124;
      }
    }
    label119:
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label94;
    }
  }
  
  ProgressWheel$WheelSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeFloat(this.jdField_c_of_type_Float);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      if (!this.jdField_b_of_type_Boolean) {
        break label123;
      }
      paramInt = 1;
      label96:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label128;
      }
    }
    label128:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      label123:
      paramInt = 0;
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.ui.ProgressWheel.WheelSavedState
 * JD-Core Version:    0.7.0.1
 */