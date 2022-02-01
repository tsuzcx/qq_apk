package com.tencent.mobileqq.profile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfileLabelTypeInfo
  implements Serializable, Cloneable
{
  public List labels = new ArrayList();
  public String typeId;
  public String typeInfo;
  public String typeName;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileLabelTypeInfo
 * JD-Core Version:    0.7.0.1
 */