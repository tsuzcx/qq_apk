package com.tencent.mobileqq.unifiedname;

import android.text.TextUtils;
import java.util.List;

public class MQQProfileNameTranslator
{
  public static final int a = 0;
  public static final int b = 6;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 0;
  public static final int k = 11;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 4;
  public static final int q = 5;
  public static final int r = 6;
  public static final int s = 7;
  public static final int t = 8;
  public static final int u = 9;
  public static final int v = 10;
  public static final int w = 11;
  public static final int x = 1;
  public static final int y = 2;
  
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    switch (paramInt1)
    {
    default: 
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 2: 
      a(paramArrayOfString, paramMQQProfileName);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    }
    h(paramInt2, paramArrayOfString, paramMQQProfileName);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 1;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[0]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 0;
          if (!TextUtils.isEmpty(paramArrayOfString[4]))
          {
            localMQQName.jdField_a_of_type_JavaLangString = (paramArrayOfString[0] + "(" + paramArrayOfString[4] + ")");
            paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
            label119:
            if (!TextUtils.isEmpty(paramArrayOfString[3]))
            {
              localMQQName = new MQQName();
              localMQQName.jdField_a_of_type_Int = 3;
              localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
              paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
            }
          }
        }
      }
    }
    label321:
    label453:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
              break;
              if (TextUtils.isEmpty(paramArrayOfString[4])) {
                break label119;
              }
              localMQQName = new MQQName();
              localMQQName.jdField_a_of_type_Int = 4;
              localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
              paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
              break label119;
              if (TextUtils.isEmpty(paramArrayOfString[4])) {
                break label321;
              }
              paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
              paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
              if (!TextUtils.isEmpty(paramArrayOfString[0]))
              {
                localMQQName = new MQQName();
                localMQQName.jdField_a_of_type_Int = 0;
                localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
                paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
              }
            } while (TextUtils.isEmpty(paramArrayOfString[3]));
            localMQQName = new MQQName();
            localMQQName.jdField_a_of_type_Int = 3;
            localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
            paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
            return;
            paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
            paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
          } while (TextUtils.isEmpty(paramArrayOfString[3]));
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
          return;
        } while (paramInt != 1);
        if (TextUtils.isEmpty(paramArrayOfString[1])) {
          break label453;
        }
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 1;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
      } while (TextUtils.isEmpty(paramArrayOfString[0]));
      localMQQName = new MQQName();
      localMQQName.jdField_a_of_type_Int = 0;
      localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      return;
      if (TextUtils.isEmpty(paramArrayOfString[6])) {
        break label524;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 6;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
    } while (TextUtils.isEmpty(paramArrayOfString[0]));
    MQQName localMQQName = new MQQName();
    localMQQName.jdField_a_of_type_Int = 0;
    localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
    return;
    label524:
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[0]))
      {
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 0;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      }
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 3;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      }
    }
    do
    {
      return;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    MQQName localMQQName = new MQQName();
    localMQQName.jdField_a_of_type_Int = 3;
    localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
  }
  
  public static String[] a(MQQName[] paramArrayOfMQQName)
  {
    int i2 = 0;
    String[] arrayOfString = new String[7];
    int i1;
    if (paramArrayOfMQQName == null) {
      i1 = 0;
    }
    while (i2 < i1)
    {
      MQQName localMQQName = paramArrayOfMQQName[i2];
      if ((localMQQName != null) && (localMQQName.jdField_a_of_type_Int >= 0) && (localMQQName.jdField_a_of_type_Int <= 6)) {
        arrayOfString[localMQQName.jdField_a_of_type_Int] = localMQQName.jdField_a_of_type_JavaLangString;
      }
      i2 += 1;
      continue;
      i1 = paramArrayOfMQQName.length;
    }
    return arrayOfString;
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      if (TextUtils.isEmpty(paramArrayOfString[6])) {
        break;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 6;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
    } while (TextUtils.isEmpty(paramArrayOfString[0]));
    MQQName localMQQName = new MQQName();
    localMQQName.jdField_a_of_type_Int = 0;
    localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
    return;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[0]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 0;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        } while (TextUtils.isEmpty(paramArrayOfString[2]));
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 2;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        return;
      } while (paramInt != 1);
      if (TextUtils.isEmpty(paramArrayOfString[2])) {
        break;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 2;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
    } while (TextUtils.isEmpty(paramArrayOfString[0]));
    MQQName localMQQName = new MQQName();
    localMQQName.jdField_a_of_type_Int = 0;
    localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
    return;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[0]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 0;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 3;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        return;
      } while (paramInt != 1);
      if (TextUtils.isEmpty(paramArrayOfString[3])) {
        break;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 3;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    } while (TextUtils.isEmpty(paramArrayOfString[0]));
    MQQName localMQQName = new MQQName();
    localMQQName.jdField_a_of_type_Int = 0;
    localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
    return;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    while (paramInt != 1) {
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      if (TextUtils.isEmpty(paramArrayOfString[5])) {
        break;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 5;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
    } while (TextUtils.isEmpty(paramArrayOfString[0]));
    MQQName localMQQName = new MQQName();
    localMQQName.jdField_a_of_type_Int = 0;
    localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
    return;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      if (TextUtils.isEmpty(paramArrayOfString[3])) {
        break;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 3;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
    } while (TextUtils.isEmpty(paramArrayOfString[0]));
    MQQName localMQQName = new MQQName();
    localMQQName.jdField_a_of_type_Int = 0;
    localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
    return;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramMQQProfileName);
    }
    while (paramInt != 1) {
      return;
    }
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
    paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator
 * JD-Core Version:    0.7.0.1
 */