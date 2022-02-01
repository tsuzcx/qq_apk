package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class DatingOthersCache
  extends Entity
{
  public String cacheStr;
  @unique
  public int subjectID;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingOthersCache
 * JD-Core Version:    0.7.0.1
 */