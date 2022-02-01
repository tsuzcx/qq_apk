package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ContactCard
  extends Entity
{
  public byte bAge;
  public byte bSex = -1;
  public String mobileCode;
  @unique
  public String mobileNo;
  public String nationCode;
  public String nickName;
  public String strCity;
  public String strContactName;
  public String strCountry;
  public String strProvince;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ContactCard
 * JD-Core Version:    0.7.0.1
 */