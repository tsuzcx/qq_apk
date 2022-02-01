package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.earlydownload.xmldata.saveInSP;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class EarlyDataFactory
{
  public static XmlData a(Class paramClass)
  {
    i = 0;
    if (paramClass == null) {
      paramClass = null;
    }
    for (;;)
    {
      return paramClass;
      for (;;)
      {
        try
        {
          localXmlData = (XmlData)paramClass.newInstance();
        }
        catch (IllegalAccessException paramClass)
        {
          Object localObject1;
          Field[] arrayOfField;
          int j;
          Object localObject2;
          Class localClass;
          localXmlData = null;
          continue;
        }
        catch (InstantiationException paramClass)
        {
          XmlData localXmlData = null;
          continue;
          i += 1;
          continue;
        }
        try
        {
          localObject1 = localXmlData.getSharedPreferencesName();
          localObject1 = BaseApplication.getContext().getSharedPreferences((String)localObject1, 0);
          arrayOfField = a(paramClass);
          paramClass = localXmlData;
          if (arrayOfField == null) {
            break;
          }
          j = arrayOfField.length;
          paramClass = localXmlData;
          if (i >= j) {
            break;
          }
          paramClass = arrayOfField[i];
          if (!paramClass.isAnnotationPresent(saveInSP.class)) {
            continue;
          }
          if (!paramClass.isAccessible()) {
            paramClass.setAccessible(true);
          }
          localObject2 = (saveInSP)paramClass.getAnnotation(saveInSP.class);
          localObject2 = paramClass.getName();
          localClass = paramClass.getType();
          if (localClass == String.class) {
            paramClass.set(localXmlData, ((SharedPreferences)localObject1).getString((String)localObject2, ""));
          } else if (localClass == Long.TYPE) {
            paramClass.setLong(localXmlData, ((SharedPreferences)localObject1).getLong((String)localObject2, 0L));
          }
        }
        catch (InstantiationException paramClass)
        {
          paramClass.printStackTrace();
          return localXmlData;
          if (localClass == Integer.TYPE) {
            paramClass.setInt(localXmlData, ((SharedPreferences)localObject1).getInt((String)localObject2, 0));
          }
        }
        catch (IllegalAccessException paramClass)
        {
          paramClass.printStackTrace();
          return localXmlData;
        }
      }
    }
    if (localClass == Float.TYPE) {
      paramClass.setFloat(localXmlData, ((SharedPreferences)localObject1).getFloat((String)localObject2, 0.0F));
    } else if (localClass == Boolean.TYPE) {
      paramClass.setBoolean(localXmlData, ((SharedPreferences)localObject1).getBoolean((String)localObject2, false));
    } else {
      throw new RuntimeException("Member name:" + (String)localObject2 + "->Type:" + localClass.toString() + " is NOT SUPPORT!");
    }
  }
  
  public static XmlData a(Class paramClass, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    if ((paramClass == null) || (paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0) || (paramString3 == null) || (paramString3.length() == 0) || (paramString4 == null) || (paramString4.length() == 0)) {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuffer();
        StringBuilder localStringBuilder = new StringBuilder().append("class=");
        if (paramClass == null)
        {
          paramClass = "null";
          paramString2.append(paramClass);
          paramString2.append(" resName=" + paramString1);
          paramString2.append(" resConf=" + paramString3);
          paramString2.append(" uiNewVer=" + paramLong);
          paramString2.append(" urlBig=" + paramString4);
          paramString2.append(" urlSmall=" + paramString5);
          QLog.d("EarlyDown", 2, "parse() return." + paramString2.toString());
        }
      }
      else
      {
        paramString3 = null;
      }
    }
    for (;;)
    {
      return paramString3;
      paramClass = paramClass.getCanonicalName();
      break;
      try
      {
        paramClass = new EarlyXmlParser(paramClass);
        SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(paramString3.getBytes()), paramClass);
        paramClass = paramClass.a();
        paramString3 = paramClass;
        if (paramClass == null) {
          continue;
        }
        paramClass.strResName = paramString1;
        paramClass.strPkgName = paramString2;
        paramClass.strResURL_big = paramString4;
        paramClass.strResURL_small = paramString5;
        paramClass.Version = ((int)paramLong);
        return paramClass;
      }
      catch (ParserConfigurationException paramClass)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EarlyDown", 2, "parse() throw Exception:" + paramClass.getMessage());
          }
          paramClass = null;
        }
      }
      catch (SAXException paramClass)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EarlyDown", 2, "parse() throw Exception:" + paramClass.getMessage());
          }
          paramClass = null;
        }
      }
      catch (IOException paramClass)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EarlyDown", 2, "parse() throw Exception:" + paramClass.getMessage());
          }
          paramClass = null;
        }
      }
    }
  }
  
  /* Error */
  public static Field a(Class paramClass, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload 4
    //   7: astore_2
    //   8: aload_0
    //   9: ifnull +20 -> 29
    //   12: aload 4
    //   14: astore_2
    //   15: aload_1
    //   16: ifnull +13 -> 29
    //   19: aload_1
    //   20: invokevirtual 167	java/lang/String:length	()I
    //   23: ifne +20 -> 43
    //   26: aload 4
    //   28: astore_2
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: ifnonnull -6 -> 29
    //   38: aload_0
    //   39: invokevirtual 272	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   42: astore_0
    //   43: aload_3
    //   44: astore_2
    //   45: aload_0
    //   46: ldc_w 274
    //   49: if_acmpeq -20 -> 29
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 278	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   57: astore_2
    //   58: aload_2
    //   59: astore_3
    //   60: goto -28 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramClass	Class
    //   0	63	1	paramString	String
    //   7	23	2	localObject1	Object
    //   31	1	2	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   33	26	2	localObject2	Object
    //   1	59	3	localObject3	Object
    //   3	24	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	58	31	java/lang/NoSuchFieldException
  }
  
  public static void a(XmlData paramXmlData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("freeSP() data=");
      if (paramXmlData != null) {
        break label46;
      }
    }
    label46:
    for (String str = "null";; str = paramXmlData.getSharedPreferencesName())
    {
      QLog.d("EarlyDown", 2, str);
      if (paramXmlData != null) {
        break;
      }
      return;
    }
    paramXmlData = paramXmlData.getSharedPreferencesName();
    paramXmlData = BaseApplication.getContext().getSharedPreferences(paramXmlData, 0).edit();
    paramXmlData.clear();
    paramXmlData.commit();
  }
  
  public static void a(XmlData paramXmlData, String... paramVarArgs)
  {
    if (paramXmlData == null) {
      return;
    }
    Object localObject1;
    SharedPreferences.Editor localEditor;
    Object localObject2;
    label54:
    int i;
    Object localObject3;
    for (;;)
    {
      label153:
      try
      {
        localObject1 = paramXmlData.getSharedPreferencesName();
        localEditor = BaseApplication.getContext().getSharedPreferences((String)localObject1, 0).edit();
        localObject2 = paramXmlData.getClass();
        if ((paramVarArgs == null) || (paramVarArgs.length == 0))
        {
          paramVarArgs = a((Class)localObject2);
          if (paramVarArgs == null) {
            break label425;
          }
          int j = paramVarArgs.length;
          i = 0;
          if (i >= j) {
            break label425;
          }
          localObject2 = paramVarArgs[i];
        }
      }
      finally {}
      try
      {
        if ((((Field)localObject2).isAnnotationPresent(saveInSP.class)) && (((saveInSP)((Field)localObject2).getAnnotation(saveInSP.class)).b()))
        {
          if (!((Field)localObject2).isAccessible()) {
            ((Field)localObject2).setAccessible(true);
          }
          localObject1 = ((Field)localObject2).getName();
          localObject3 = ((Field)localObject2).get(paramXmlData);
          if (!(localObject3 instanceof String)) {
            break;
          }
          localEditor.putString((String)localObject1, String.valueOf(localObject3));
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        continue;
        if (!(localObject3 instanceof Integer)) {
          break label294;
        }
        localEditor.putInt(localIllegalArgumentException, ((Integer)localObject3).intValue());
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        continue;
        if (!(localObject3 instanceof Float)) {
          break label323;
        }
        localEditor.putFloat(localIllegalAccessException, ((Float)localObject3).floatValue());
        continue;
        if (!(localObject3 instanceof Boolean)) {
          break label352;
        }
        localEditor.putBoolean(localIllegalAccessException, ((Boolean)localObject3).booleanValue());
        continue;
        localObject2 = new StringBuilder().append("Member name:").append(localIllegalAccessException).append("->Type:");
        if (localObject3 != null) {
          break label409;
        }
      }
      i += 1;
      continue;
      localObject1 = new Field[paramVarArgs.length];
      i = 0;
    }
    for (;;)
    {
      label294:
      label323:
      label352:
      String str;
      if (i < paramVarArgs.length)
      {
        localObject3 = paramVarArgs[i];
        if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
          break label442;
        }
        localObject1[i] = a((Class)localObject2, (String)localObject3);
        break label442;
        if ((localObject3 instanceof Long))
        {
          localEditor.putLong((String)localObject1, ((Long)localObject3).longValue());
          break label153;
        }
        label409:
        for (str = "NULL";; str = localObject3.getClass().getSimpleName().toString()) {
          throw new RuntimeException(str + " is NOT SUPPORT!");
        }
        label425:
        localEditor.commit();
        break;
      }
      paramVarArgs = str;
      break label54;
      label442:
      i += 1;
    }
  }
  
  public static Field[] a(Class paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != Entity.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      if (arrayOfField != null)
      {
        j = arrayOfField.length;
        i = 0;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          if ((localField != null) && (!Modifier.isStatic(localField.getModifiers()))) {
            localArrayList.add(localField);
          }
          i += 1;
        }
      }
      paramClass = paramClass.getSuperclass();
    }
    int j = localArrayList.size();
    paramClass = new Field[j];
    int i = 0;
    while (i < j)
    {
      paramClass[i] = ((Field)localArrayList.get(i));
      i += 1;
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDataFactory
 * JD-Core Version:    0.7.0.1
 */