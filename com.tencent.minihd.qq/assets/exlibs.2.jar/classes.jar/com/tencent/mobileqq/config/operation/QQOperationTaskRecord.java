package com.tencent.mobileqq.config.operation;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class QQOperationTaskRecord
  extends Entity
{
  public int aioCount;
  public String hasShowedUins = "";
  public long recordTime;
  public String showCount = "";
  @unique
  public int taskid;
  
  public void addUinShowCount(String paramString)
  {
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = "+" + paramString + "_";
      if ((TextUtils.isEmpty(this.showCount)) || (!this.showCount.contains(str1))) {
        break label247;
      }
      i = this.showCount.indexOf(str1);
      if (i != -1) {
        break label111;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQOperateVoIP", 2, "addUinShowCount  showCount = " + this.showCount + " uin = " + paramString);
      }
    }
    label111:
    String str2;
    do
    {
      return;
      str2 = this.showCount.substring(i + str1.length());
      i = str2.indexOf("|");
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQOperateVoIP", 2, "addUinShowCount  showCount = " + this.showCount + " uin = " + paramString);
    return;
    int i = Integer.valueOf(str2.substring(0, i)).intValue();
    this.showCount = this.showCount.replace(str1 + i, str1 + (i + 1));
    return;
    label247:
    this.showCount = (this.showCount + str1 + "1|");
  }
  
  public int getUinTotalShowCount(String paramString)
  {
    String str;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      str = "+" + paramString + "_";
      if ((!TextUtils.isEmpty(this.showCount)) && (this.showCount.contains(str)))
      {
        i = this.showCount.indexOf(str);
        if (i != -1) {
          break label112;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQOperateVoIP", 2, "getUinTotalShowCount  showCount = " + this.showCount + " uin = " + paramString);
        }
      }
    }
    label112:
    do
    {
      do
      {
        return 0;
        str = this.showCount.substring(str.length() + i);
        i = str.indexOf("|");
        if (i != -1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQOperateVoIP", 2, "getUinTotalShowCount  showCount = " + this.showCount + " uin = " + paramString);
      return 0;
      try
      {
        i = Integer.valueOf(str.substring(0, i)).intValue();
        return i;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQOperateVoIP", 2, "getUinTotalShowCount  showCount = " + this.showCount + " uin = " + paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperationTaskRecord
 * JD-Core Version:    0.7.0.1
 */