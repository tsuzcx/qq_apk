package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.xmlpull.v1.XmlPullParser;

public abstract class BaseConfigFileParser
{
  public static final String a = BaseConfigFileParser.class.getSimpleName();
  public static String b;
  public static String c;
  
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
    //   8: new 29	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload 4
    //   19: astore_2
    //   20: aload_1
    //   21: invokevirtual 36	java/io/File:exists	()Z
    //   24: ifeq +13 -> 37
    //   27: aload 4
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 39	java/io/File:isFile	()Z
    //   34: ifne +58 -> 92
    //   37: aload 4
    //   39: astore_2
    //   40: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +35 -> 78
    //   46: aload 4
    //   48: astore_2
    //   49: getstatic 18	com/tencent/mobileqq/utils/BaseConfigFileParser:a	Ljava/lang/String;
    //   52: iconst_2
    //   53: new 46	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   60: ldc 49
    //   62: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 56	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 63	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iconst_0
    //   79: ifeq +11 -> 90
    //   82: new 65	java/lang/NullPointerException
    //   85: dup
    //   86: invokespecial 66	java/lang/NullPointerException:<init>	()V
    //   89: athrow
    //   90: iconst_0
    //   91: ireturn
    //   92: aload 4
    //   94: astore_2
    //   95: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +35 -> 133
    //   101: aload 4
    //   103: astore_2
    //   104: getstatic 18	com/tencent/mobileqq/utils/BaseConfigFileParser:a	Ljava/lang/String;
    //   107: iconst_2
    //   108: new 46	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   115: ldc 68
    //   117: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 56	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 4
    //   135: astore_2
    //   136: new 73	java/io/FileInputStream
    //   139: dup
    //   140: aload_1
    //   141: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   144: astore_1
    //   145: invokestatic 82	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   148: invokevirtual 86	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   151: astore_2
    //   152: aload_2
    //   153: aload_1
    //   154: ldc 88
    //   156: invokeinterface 94 3 0
    //   161: aload_0
    //   162: aload_2
    //   163: invokevirtual 97	com/tencent/mobileqq/utils/BaseConfigFileParser:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/Object;
    //   166: astore_2
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 100	java/io/FileInputStream:close	()V
    //   175: aload_2
    //   176: ifnull -86 -> 90
    //   179: aload_0
    //   180: aload_2
    //   181: invokevirtual 103	com/tencent/mobileqq/utils/BaseConfigFileParser:a	(Ljava/lang/Object;)V
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_2
    //   187: aload_3
    //   188: astore_1
    //   189: aload_2
    //   190: astore_3
    //   191: aload_1
    //   192: astore_2
    //   193: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +15 -> 211
    //   199: aload_1
    //   200: astore_2
    //   201: getstatic 18	com/tencent/mobileqq/utils/BaseConfigFileParser:a	Ljava/lang/String;
    //   204: iconst_2
    //   205: ldc 105
    //   207: aload_3
    //   208: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload_1
    //   212: ifnull -122 -> 90
    //   215: aload_1
    //   216: invokevirtual 100	java/io/FileInputStream:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_1
    //   225: aload_2
    //   226: ifnull +7 -> 233
    //   229: aload_2
    //   230: invokevirtual 100	java/io/FileInputStream:close	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: iconst_0
    //   237: ireturn
    //   238: astore_1
    //   239: goto -64 -> 175
    //   242: astore_2
    //   243: goto -10 -> 233
    //   246: astore_3
    //   247: aload_1
    //   248: astore_2
    //   249: aload_3
    //   250: astore_1
    //   251: goto -26 -> 225
    //   254: astore_3
    //   255: goto -64 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	BaseConfigFileParser
    //   0	258	1	paramString	String
    //   7	174	2	localObject1	Object
    //   186	4	2	localException1	Exception
    //   192	38	2	str1	String
    //   242	1	2	localIOException	java.io.IOException
    //   248	1	2	str2	String
    //   4	204	3	localObject2	Object
    //   246	4	3	localObject3	Object
    //   254	1	3	localException2	Exception
    //   1	133	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	186	java/lang/Exception
    //   20	27	186	java/lang/Exception
    //   30	37	186	java/lang/Exception
    //   40	46	186	java/lang/Exception
    //   49	78	186	java/lang/Exception
    //   95	101	186	java/lang/Exception
    //   104	133	186	java/lang/Exception
    //   136	145	186	java/lang/Exception
    //   215	219	221	java/io/IOException
    //   8	17	224	finally
    //   20	27	224	finally
    //   30	37	224	finally
    //   40	46	224	finally
    //   49	78	224	finally
    //   95	101	224	finally
    //   104	133	224	finally
    //   136	145	224	finally
    //   193	199	224	finally
    //   201	211	224	finally
    //   82	90	235	java/io/IOException
    //   171	175	238	java/io/IOException
    //   229	233	242	java/io/IOException
    //   145	167	246	finally
    //   145	167	254	java/lang/Exception
  }
  
  private void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "parseXmlFromRes");
    }
    int i = a();
    paramContext = paramContext.getResources().getXml(i);
    Object localObject = null;
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null) {
        a(paramContext);
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
          QLog.e(a, 2, "parseXmlFromRes doParseRules exception:", localException);
          paramContext = localObject;
        }
      }
    }
  }
  
  protected abstract int a();
  
  protected abstract Object a(XmlPullParser paramXmlPullParser);
  
  public void a(Context paramContext)
  {
    if (FileUtils.b(c))
    {
      boolean bool = a(c);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "parseXmlFromOutside: success = " + bool);
      }
      if (!bool) {
        b(paramContext);
      }
      return;
    }
    b(paramContext);
  }
  
  protected abstract void a(QQAppInterface paramQQAppInterface, long paramLong);
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    int i = 1;
    try
    {
      FileUtils.a(b, false);
      FileUtils.a(paramString, b, false);
      if (i != 0)
      {
        boolean bool = a(c);
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "pareseRulesFromZip : delete and uncompressZip success, parse from outside result = " + bool);
        }
        if (bool)
        {
          a(paramQQAppInterface, paramLong);
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
          QLog.e(a, 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        }
        i = 0;
      }
      b(paramQQAppInterface.getApplication());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    b(paramQQAppInterface.getApplication());
  }
  
  protected abstract void a(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseConfigFileParser
 * JD-Core Version:    0.7.0.1
 */