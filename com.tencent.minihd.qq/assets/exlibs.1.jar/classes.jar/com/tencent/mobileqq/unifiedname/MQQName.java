package com.tencent.mobileqq.unifiedname;

import com.tencent.mobileqq.util.Utils;

public class MQQName
{
  public int a;
  public String a;
  
  public MQQName() {}
  
  public MQQName(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(MQQName paramMQQName)
  {
    if (paramMQQName != null)
    {
      this.jdField_a_of_type_Int = paramMQQName.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = paramMQQName.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new MQQName(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MQQName))
    {
      paramObject = (MQQName)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (Utils.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedname.MQQName
 * JD-Core Version:    0.7.0.1
 */