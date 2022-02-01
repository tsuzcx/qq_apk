package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class BmqqUserSimpleInfo
  extends Entity
  implements Parcelable, Cloneable
{
  private static final String TAG = BmqqUserSimpleInfo.class.getSimpleName();
  public String mBmqqCompany;
  public String mBmqqEmail;
  public String mBmqqJobTitle;
  public String mBmqqMasterUin;
  public String mBmqqMobileNum;
  public String mBmqqNickName;
  public String mBmqqRemarkName;
  public String mBmqqTelphone;
  @unique
  public String mBmqqUin;
  public int mFlag;
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "BmqqUser clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
  
  public void copyValue(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    if (paramBmqqUserSimpleInfo != null)
    {
      this.mBmqqUin = paramBmqqUserSimpleInfo.mBmqqUin;
      this.mBmqqMasterUin = paramBmqqUserSimpleInfo.mBmqqMasterUin;
      this.mBmqqNickName = paramBmqqUserSimpleInfo.mBmqqNickName;
      this.mBmqqRemarkName = paramBmqqUserSimpleInfo.mBmqqRemarkName;
      this.mBmqqJobTitle = paramBmqqUserSimpleInfo.mBmqqJobTitle;
      this.mBmqqMobileNum = paramBmqqUserSimpleInfo.mBmqqMobileNum;
      this.mBmqqTelphone = paramBmqqUserSimpleInfo.mBmqqTelphone;
      this.mBmqqEmail = paramBmqqUserSimpleInfo.mBmqqEmail;
      this.mBmqqCompany = paramBmqqUserSimpleInfo.mBmqqCompany;
      this.mFlag = paramBmqqUserSimpleInfo.mFlag;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof BmqqUserSimpleInfo)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqUin.equals(this.mBmqqUin)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqMasterUin.equals(this.mBmqqMasterUin)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqNickName.equals(this.mBmqqNickName)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqRemarkName.equals(this.mBmqqRemarkName)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqJobTitle.equals(this.mBmqqJobTitle)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqMobileNum.equals(this.mBmqqMobileNum)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqTelphone.equals(this.mBmqqTelphone)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqEmail.equals(this.mBmqqEmail)) {
      return false;
    }
    if (!((BmqqUserSimpleInfo)paramObject).mBmqqCompany.equals(this.mBmqqCompany)) {
      return false;
    }
    return ((BmqqUserSimpleInfo)paramObject).mFlag == this.mFlag;
  }
  
  public boolean isCertified()
  {
    return (this.mFlag & 0x1) == 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.BmqqUserSimpleInfo
 * JD-Core Version:    0.7.0.1
 */