package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class PhoneContact
  extends Entity
  implements Cloneable
{
  public int ability;
  public long bindingDate;
  public int contactID;
  public String faceUrl;
  public boolean hasSendAddReq = false;
  public int isRecommend;
  @notColumn
  public boolean isUpdated;
  public boolean isUploaded = false;
  public String label;
  public long lastScanTime;
  public String md5;
  public String mobileCode;
  @unique
  public String mobileNo;
  public String name;
  @Deprecated
  public String nationCode;
  public String nickName;
  public long originBinder;
  public String pinyinAll;
  @notColumn
  public String pinyinFirst;
  public String pinyinInitial;
  public String remark;
  public int sortWeight = 0;
  public int type;
  public String uin;
  public String unifiedCode;
  
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
      QLog.d("PhoneContactManager", 2, "PhoneContact clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
  
  public void initMobileCode()
  {
    if (!TextUtils.isEmpty(this.unifiedCode)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.PhoneContact
 * JD-Core Version:    0.7.0.1
 */