package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class DatingSig
  extends Entity
{
  public String datingId;
  @unique
  public long openId;
  public byte[] sig;
  public long timestamp;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingSig
 * JD-Core Version:    0.7.0.1
 */