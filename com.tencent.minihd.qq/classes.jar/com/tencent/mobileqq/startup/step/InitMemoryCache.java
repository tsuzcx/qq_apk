package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.QLog;
import jvw;

public class InitMemoryCache
  extends Step
{
  protected boolean a()
  {
    if (BaseApplicationImpl.g == 1)
    {
      long l = MemoryManager.a() * 3L / 16L;
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new jvw(Integer.valueOf((int)l));
      BaseApplicationImpl.jdField_a_of_type_Int = (int)l;
    }
    int j;
    do
    {
      do
      {
        return true;
      } while ((!BaseApplicationImpl.processName.endsWith(":peak")) && (!BaseApplicationImpl.processName.endsWith(":dataline")));
      j = (int)(MemoryManager.a() * 3L / 16L);
      int i = 4194304;
      if (j > 4194304) {
        i = j;
      }
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new jvw(Integer.valueOf(i));
      BaseApplicationImpl.jdField_a_of_type_Int = j;
    } while (!QLog.isColorLevel());
    QLog.d("MemoryCache", 2, "memory size:" + j);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache
 * JD-Core Version:    0.7.0.1
 */