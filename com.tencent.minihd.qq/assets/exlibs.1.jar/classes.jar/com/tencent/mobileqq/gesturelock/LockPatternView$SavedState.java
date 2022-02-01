package com.tencent.mobileqq.gesturelock;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View.BaseSavedState;

class LockPatternView$SavedState
  extends View.BaseSavedState
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  private final boolean c;
  
  private LockPatternView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Boolean = ((Boolean)paramParcel.readValue(null)).booleanValue();
    this.b = ((Boolean)paramParcel.readValue(null)).booleanValue();
    this.c = ((Boolean)paramParcel.readValue(null)).booleanValue();
  }
  
  private LockPatternView$SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramParcelable);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeValue(Boolean.valueOf(this.jdField_a_of_type_Boolean));
    paramParcel.writeValue(Boolean.valueOf(this.b));
    paramParcel.writeValue(Boolean.valueOf(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView.SavedState
 * JD-Core Version:    0.7.0.1
 */