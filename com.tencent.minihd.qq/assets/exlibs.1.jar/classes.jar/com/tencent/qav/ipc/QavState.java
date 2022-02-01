package com.tencent.qav.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qav.session.QavSession;
import com.tencent.qav.session.QavSession.SessionStatus;
import ljk;

public class QavState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ljk();
  public int a;
  public long a;
  public QavSession.SessionStatus a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public boolean c;
  
  public QavState(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.values()[paramParcel.readInt()];
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readInt() == 0) {
        break label106;
      }
      bool1 = true;
      label73:
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_b_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() == 0) {
        break label111;
      }
    }
    label106:
    label111:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label73;
    }
  }
  
  public QavState(QavSession paramQavSession)
  {
    this.jdField_a_of_type_Int = paramQavSession.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramQavSession.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = paramQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus;
    this.jdField_b_of_type_Int = paramQavSession.jdField_c_of_type_Int;
    this.jdField_a_of_type_Long = paramQavSession.jdField_a_of_type_Long;
    this.jdField_a_of_type_Boolean = paramQavSession.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramQavSession.jdField_c_of_type_Boolean;
    this.jdField_b_of_type_Long = paramQavSession.jdField_b_of_type_Long;
    this.jdField_c_of_type_Boolean = paramQavSession.j;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof QavState))
    {
      paramObject = (QavState)paramObject;
      bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString);
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QavState = [ mSessionType = ").append(this.jdField_a_of_type_Int).append(", mSessionId = ").append(this.jdField_a_of_type_JavaLangString).append(", mSessionStatus = ").append(this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus).append(", mRelationType = ").append(this.jdField_b_of_type_Int).append(", mRelationId = ").append(this.jdField_a_of_type_Long).append(", mIsReceiver = ").append(this.jdField_a_of_type_Boolean).append(", mIsAudioOnly = ").append(this.jdField_b_of_type_Boolean).append(", mConnectedDuration = ").append(this.jdField_b_of_type_Long).append(", isFloatWindowOpAllowed = ").append(this.jdField_c_of_type_Boolean).append("]. ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus.ordinal());
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label101;
      }
      paramInt = 1;
      label68:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      if (!this.jdField_c_of_type_Boolean) {
        break label106;
      }
    }
    label101:
    label106:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label68;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.QavState
 * JD-Core Version:    0.7.0.1
 */