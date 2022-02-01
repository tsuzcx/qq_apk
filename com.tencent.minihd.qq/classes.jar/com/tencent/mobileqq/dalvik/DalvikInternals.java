package com.tencent.mobileqq.dalvik;

import android.content.Context;
import com.tencent.mobileqq.utils.SoLoadUtil;

public class DalvikInternals
{
  private static String a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DalvikInternals.class.getSimpleName();
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_Boolean = SoLoadUtil.a(paramContext, "qq_la", 0, false);
  }
  
  public static native long find(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, int paramInt7, int paramInt8, int paramInt9, long paramLong3);
  
  public static native long replace(long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.DalvikInternals
 * JD-Core Version:    0.7.0.1
 */