package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

public class MayKnowRecommend
  extends Entity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public short age;
  public String city;
  public String country;
  public int friendStatus;
  public short gender = 255;
  public String nick;
  public String province;
  public String remark;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MayKnowRecommend
 * JD-Core Version:    0.7.0.1
 */