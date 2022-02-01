package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class AioAnimationConfigHelper
{
  private static volatile AioAnimationConfigHelper jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper;
  public static final String a;
  public static final String b = "Item";
  public static final String c = "id";
  public static final String d = "Keywords";
  public static final String e = "FloorLimit";
  public static final String f = "JumpLimit";
  public static final String g = "JumpImage";
  public static final String h = "type";
  public static final String i = "Emoji";
  public static final String j = "Face";
  public static final String k = "Image";
  public static final String l = "count";
  public static final String m = "IsCrazyMode";
  public static final String n = "eggs.xml";
  public static final String o;
  public static final String p = o + "eggs.xml";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_JavaLangString = AioAnimationConfigHelper.class.getSimpleName();
    Context localContext = BaseApplicationImpl.getContext();
    o = localContext.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/";
  }
  
  public static AioAnimationConfigHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper = new AioAnimationConfigHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper;
    }
    finally {}
  }
  
  private ArrayList a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    int i1 = paramXmlPullParser.getEventType();
    Object localObject1 = null;
    Object localObject4 = null;
    String str1;
    Object localObject3;
    Object localObject2;
    label382:
    String str2;
    if (i1 != 1) {
      if (i1 == 2)
      {
        str1 = paramXmlPullParser.getName();
        if (str1.equalsIgnoreCase("Item"))
        {
          localObject3 = paramXmlPullParser.getAttributeValue(null, "id");
          localObject2 = new AioAnimationRule();
          ((AioAnimationRule)localObject2).jdField_a_of_type_Int = Integer.valueOf((String)localObject3).intValue();
          localObject3 = localObject1;
        }
        do
        {
          for (;;)
          {
            i1 = paramXmlPullParser.next();
            localObject4 = localObject2;
            localObject1 = localObject3;
            break;
            if (str1.equalsIgnoreCase("Keywords"))
            {
              str1 = paramXmlPullParser.nextText();
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (localObject4 != null)
              {
                if (localObject4.jdField_a_of_type_JavaUtilArrayList == null) {
                  localObject4.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                }
                localObject4.jdField_a_of_type_JavaUtilArrayList.add(str1);
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
            }
            else if (str1.equalsIgnoreCase("FloorLimit"))
            {
              str1 = paramXmlPullParser.nextText();
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (localObject4 != null)
              {
                localObject4.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
            }
            else if (str1.equalsIgnoreCase("JumpLimit"))
            {
              str1 = paramXmlPullParser.nextText();
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (localObject4 != null)
              {
                localObject4.c = Integer.valueOf(str1).intValue();
                localObject2 = localObject4;
                localObject3 = localObject1;
              }
            }
            else
            {
              if (!str1.equalsIgnoreCase("IsCrazyMode")) {
                break label382;
              }
              str1 = paramXmlPullParser.nextText();
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (localObject4 != null) {
                if (str1.equalsIgnoreCase("true"))
                {
                  localObject4.jdField_a_of_type_Boolean = true;
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                }
                else
                {
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                  if (str1.equalsIgnoreCase("false"))
                  {
                    localObject4.jdField_a_of_type_Boolean = false;
                    localObject2 = localObject4;
                    localObject3 = localObject1;
                  }
                }
              }
            }
          }
          localObject2 = localObject4;
          localObject3 = localObject1;
        } while (!str1.equalsIgnoreCase("JumpImage"));
        str1 = paramXmlPullParser.getAttributeValue(null, "type");
        localObject2 = paramXmlPullParser.getAttributeValue(null, "count");
        str2 = paramXmlPullParser.nextText();
        if (localObject2 == null) {
          break label756;
        }
        i1 = Integer.valueOf((String)localObject2).intValue();
      }
    }
    for (;;)
    {
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (i1 <= 0) {
        break;
      }
      localObject2 = new AioAnimationRule.JumpImage();
      if (str1 != null) {
        ((AioAnimationRule.JumpImage)localObject2).e = AioAnimationRule.JumpImage.a(str1);
      }
      ((AioAnimationRule.JumpImage)localObject2).d = str2;
      if (localObject4.jdField_b_of_type_JavaUtilArrayList == null) {
        localObject4.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      localObject4.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
      i1 -= 1;
      continue;
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (i1 != 3) {
        break;
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (!paramXmlPullParser.getName().equalsIgnoreCase("Item")) {
        break;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ArrayList();
      }
      boolean bool;
      if (localObject4 != null)
      {
        if ((localObject4.jdField_b_of_type_Int != 0) || (localObject4.c != 0)) {
          break label683;
        }
        bool = true;
      }
      for (;;)
      {
        if (bool) {
          ((ArrayList)localObject3).add(localObject4);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "<== Item, id = " + localObject4.jdField_a_of_type_Int + ",isValid = " + bool + "keywords:" + localObject4.jdField_a_of_type_JavaUtilArrayList.toString());
        }
        localObject2 = null;
        break;
        label683:
        if (localObject4.c > localObject4.jdField_b_of_type_Int)
        {
          bool = true;
          continue;
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "doParseRules :  cost time:" + (l2 - l1) + "ms");
          }
          return localObject1;
        }
        else
        {
          bool = false;
        }
      }
      label756:
      i1 = 1;
    }
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload 4
    //   7: astore_2
    //   8: new 78	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 221	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload 4
    //   19: astore_2
    //   20: aload_1
    //   21: invokevirtual 224	java/io/File:exists	()Z
    //   24: ifeq +13 -> 37
    //   27: aload 4
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 227	java/io/File:isFile	()Z
    //   34: ifne +58 -> 92
    //   37: aload 4
    //   39: astore_2
    //   40: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +35 -> 78
    //   46: aload 4
    //   48: astore_2
    //   49: getstatic 59	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   52: iconst_2
    //   53: new 67	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   60: ldc 229
    //   62: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iconst_0
    //   79: ifeq +11 -> 90
    //   82: new 236	java/lang/NullPointerException
    //   85: dup
    //   86: invokespecial 237	java/lang/NullPointerException:<init>	()V
    //   89: athrow
    //   90: iconst_0
    //   91: ireturn
    //   92: aload 4
    //   94: astore_2
    //   95: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +35 -> 133
    //   101: aload 4
    //   103: astore_2
    //   104: getstatic 59	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   107: iconst_2
    //   108: new 67	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   115: ldc 239
    //   117: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 232	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 4
    //   135: astore_2
    //   136: new 241	java/io/FileInputStream
    //   139: dup
    //   140: aload_1
    //   141: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   144: astore_1
    //   145: invokestatic 250	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   148: invokevirtual 254	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   151: astore_2
    //   152: aload_2
    //   153: aload_1
    //   154: ldc_w 256
    //   157: invokeinterface 260 3 0
    //   162: aload_0
    //   163: aload_2
    //   164: invokespecial 262	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   167: astore_2
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 265	java/io/FileInputStream:close	()V
    //   176: aload_2
    //   177: ifnull -87 -> 90
    //   180: aload_0
    //   181: aload_2
    //   182: putfield 266	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   185: iconst_1
    //   186: ireturn
    //   187: astore_2
    //   188: aload_3
    //   189: astore_1
    //   190: aload_2
    //   191: astore_3
    //   192: aload_1
    //   193: astore_2
    //   194: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +16 -> 213
    //   200: aload_1
    //   201: astore_2
    //   202: getstatic 59	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   205: iconst_2
    //   206: ldc_w 268
    //   209: aload_3
    //   210: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: ifnull -124 -> 90
    //   217: aload_1
    //   218: invokevirtual 265	java/io/FileInputStream:close	()V
    //   221: iconst_0
    //   222: ireturn
    //   223: astore_1
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_1
    //   227: aload_2
    //   228: ifnull +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 265	java/io/FileInputStream:close	()V
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: iconst_0
    //   239: ireturn
    //   240: astore_1
    //   241: goto -65 -> 176
    //   244: astore_2
    //   245: goto -10 -> 235
    //   248: astore_3
    //   249: aload_1
    //   250: astore_2
    //   251: aload_3
    //   252: astore_1
    //   253: goto -26 -> 227
    //   256: astore_3
    //   257: goto -65 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	AioAnimationConfigHelper
    //   0	260	1	paramString	String
    //   7	175	2	localObject1	Object
    //   187	4	2	localException1	Exception
    //   193	39	2	str1	String
    //   244	1	2	localIOException	java.io.IOException
    //   250	1	2	str2	String
    //   4	206	3	localObject2	Object
    //   248	4	3	localObject3	Object
    //   256	1	3	localException2	Exception
    //   1	133	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	187	java/lang/Exception
    //   20	27	187	java/lang/Exception
    //   30	37	187	java/lang/Exception
    //   40	46	187	java/lang/Exception
    //   49	78	187	java/lang/Exception
    //   95	101	187	java/lang/Exception
    //   104	133	187	java/lang/Exception
    //   136	145	187	java/lang/Exception
    //   217	221	223	java/io/IOException
    //   8	17	226	finally
    //   20	27	226	finally
    //   30	37	226	finally
    //   40	46	226	finally
    //   49	78	226	finally
    //   95	101	226	finally
    //   104	133	226	finally
    //   136	145	226	finally
    //   194	200	226	finally
    //   202	213	226	finally
    //   82	90	237	java/io/IOException
    //   172	176	240	java/io/IOException
    //   231	235	244	java/io/IOException
    //   145	168	248	finally
    //   145	168	256	java/lang/Exception
  }
  
  private void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseXmlFromRes");
    }
    paramContext = paramContext.getResources().getXml(2131099649);
    Object localObject = null;
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null) {
        this.jdField_a_of_type_JavaUtilArrayList = paramContext;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = localObject;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "parseXmlFromRes doParseRules exception:", localException);
          paramContext = localObject;
        }
      }
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Context paramContext)
  {
    if (FileUtils.b(p))
    {
      boolean bool = a(p);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseXmlFromOutside: success = " + bool);
      }
      if (!bool) {
        b(paramContext);
      }
      return;
    }
    b(paramContext);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    int i1 = 1;
    try
    {
      FileUtils.a(o, false);
      FileUtils.a(paramString, o, false);
      if (i1 != 0)
      {
        boolean bool = a(p);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pareseRulesFromZip : delete and uncompressZip success, parse from outside result = " + bool);
        }
        if (bool)
        {
          paramQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", paramLong).commit();
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        }
        i1 = 0;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "pareseRulesFromZip :  uncompress OOM Error =>", paramString);
        }
        i1 = 0;
      }
      b(paramQQAppInterface.getApplication());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    b(paramQQAppInterface.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper
 * JD-Core Version:    0.7.0.1
 */