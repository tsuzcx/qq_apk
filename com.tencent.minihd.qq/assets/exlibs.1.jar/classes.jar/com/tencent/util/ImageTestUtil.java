package com.tencent.util;

import android.os.Debug;
import com.tencent.mobileqq.app.AppConstants;
import java.io.IOException;

public class ImageTestUtil
{
  private static boolean jdField_a_of_type_Boolean = false;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "35872667", "354653668", "270749863", "279242625", "1849510872" };
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      Object localObject = jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].equals(paramString))
        {
          localObject = AppConstants.aK + "dump_";
          try
          {
            Debug.dumpHprofData((String)localObject + paramString + System.currentTimeMillis());
            jdField_a_of_type_Boolean = true;
            return;
          }
          catch (IOException paramString)
          {
            return;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.ImageTestUtil
 * JD-Core Version:    0.7.0.1
 */