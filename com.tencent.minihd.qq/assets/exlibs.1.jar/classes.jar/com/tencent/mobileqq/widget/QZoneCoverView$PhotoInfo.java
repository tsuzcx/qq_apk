package com.tencent.mobileqq.widget;

import android.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.MD5;
import java.util.Map;

public class QZoneCoverView$PhotoInfo
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public String a;
  public Map a;
  public int d = 0;
  public int e;
  public int f;
  
  public QZoneCoverView$PhotoInfo(QZoneCoverView paramQZoneCoverView, int paramInt, Map paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      paramQZoneCoverView = new StringBuilder();
      paramQZoneCoverView.append(paramInt);
      paramInt = 0;
      while (paramInt <= 4)
      {
        paramMap = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        if (paramMap != null) {
          paramQZoneCoverView.append(paramMap);
        }
        paramInt += 1;
      }
      this.jdField_a_of_type_JavaLangString = paramQZoneCoverView.toString();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = MD5.toMD5(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private String b(int paramInt)
  {
    Object localObject = null;
    int i = 1;
    while ((TextUtils.isEmpty((CharSequence)localObject)) && (i < 5))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf((paramInt + i) % 5));
      i += 1;
    }
    return localObject;
  }
  
  public String a()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = b(1);
      }
    }
    return localObject;
  }
  
  public String a(int paramInt)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      if (paramInt > 100) {
        break label51;
      }
    }
    label51:
    for (paramInt = 3;; paramInt = 2)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = b(paramInt);
      }
      return localObject;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof PhotoInfo)) {
      bool = Utils.a(((PhotoInfo)paramObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QZoneCoverView.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */