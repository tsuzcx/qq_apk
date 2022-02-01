package com.tencent.mobileqq.customviews;

import android.util.SparseArray;
import android.util.SparseIntArray;

public class CircleMenuManager
{
  public static final int a = 241;
  private static SparseArray a;
  public static SparseIntArray a;
  public static final int b = 242;
  public static final int c = 243;
  public static final int d = 244;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static CircleMenu a()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      CircleMenu localCircleMenu = (CircleMenu)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localCircleMenu.a()) {
        return localCircleMenu;
      }
      i += 1;
    }
    return null;
  }
  
  public static CircleMenu a(int paramInt)
  {
    if (jdField_a_of_type_AndroidUtilSparseIntArray == null)
    {
      jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray(5);
      jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 241);
      jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 242);
      jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 243);
      jdField_a_of_type_AndroidUtilSparseIntArray.put(4, 244);
    }
    return b(jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt));
  }
  
  public static void a()
  {
    b();
    jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public static void a(int paramInt)
  {
    CircleMenu localCircleMenu = (CircleMenu)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localCircleMenu != null) {
      localCircleMenu.a();
    }
  }
  
  public static void a(int paramInt, CircleMenu.Builder paramBuilder)
  {
    c(paramInt);
    if (jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      paramBuilder = paramBuilder.a();
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramBuilder);
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    CircleMenu localCircleMenu = b(paramInt);
    if (localCircleMenu != null) {
      localCircleMenu.b(paramBoolean);
    }
  }
  
  public static CircleMenu b(int paramInt)
  {
    return (CircleMenu)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public static void b()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((CircleMenu)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).d(false);
      i += 1;
    }
  }
  
  public static void b(int paramInt)
  {
    CircleMenu localCircleMenu = (CircleMenu)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localCircleMenu != null) {
      localCircleMenu.b();
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean)
  {
    CircleMenu localCircleMenu = b(paramInt);
    if (localCircleMenu != null) {
      localCircleMenu.a(paramBoolean);
    }
  }
  
  public static void c(int paramInt)
  {
    CircleMenu localCircleMenu = b(paramInt);
    if (localCircleMenu != null)
    {
      localCircleMenu.e();
      jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.CircleMenuManager
 * JD-Core Version:    0.7.0.1
 */