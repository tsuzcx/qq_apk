package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class NameProcess
  extends Step
{
  private static final int jdField_a_of_type_Int = 3;
  private static final String jdField_a_of_type_JavaLangString = "unknown";
  
  protected boolean a()
  {
    int i = 0;
    String str;
    do
    {
      str = MsfSdkUtils.getProcessName(BaseApplicationImpl.a);
      i += 1;
    } while ((i < 3) && ("unknown".equals(str)));
    if ("unknown".equals(str))
    {
      str = "com.tencent.minihd.qq";
      BaseApplicationImpl.g = 1;
    }
    for (;;)
    {
      BaseApplicationImpl.processName = str;
      return true;
      if ("com.tencent.minihd.qq".equals(str)) {
        BaseApplicationImpl.g = 1;
      } else if (str.endsWith("MSF")) {
        BaseApplicationImpl.g = 4;
      } else if (str.endsWith("qzone")) {
        BaseApplicationImpl.g = 2;
      } else if (str.endsWith("web")) {
        BaseApplicationImpl.g = 3;
      } else {
        BaseApplicationImpl.g = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NameProcess
 * JD-Core Version:    0.7.0.1
 */