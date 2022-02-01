package com.tencent.mobileqq.structmsg;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class StructMsgFactory
{
  public static AbsStructMsg a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    switch (paramBundle.getInt("req_type", 1))
    {
    case 4: 
    default: 
      return new StructMsgForGeneralShare(paramBundle);
    case 2: 
      return new StructMsgForAudioShare(paramBundle);
    case 3: 
      return new StructMsgForHypertext(paramBundle);
    }
    return new StructMsgForImageShare(paramBundle);
  }
  
  public static AbsStructMsg a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt2);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof AbsShareMsg)))
    {
      long l1 = paramArrayOfByte.mMsgServiceID;
      long l2 = ((AbsShareMsg)paramArrayOfByte).mSourceAppid;
      if ((l1 == 23L) && ((paramInt1 == 82) || (paramInt1 == 43))) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", paramQQAppInterface.a(), "AIOchat", "appear_obj", 0, 0, String.valueOf(paramLong), String.valueOf(l1), String.valueOf(l2), "");
      }
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aload_2
    //   12: areturn
    //   13: new 85	java/io/ObjectInputStream
    //   16: dup
    //   17: new 87	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 90	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: invokespecial 93	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore 4
    //   30: aload 4
    //   32: astore_2
    //   33: aload 5
    //   35: astore_3
    //   36: aload 4
    //   38: invokevirtual 97	java/io/ObjectInputStream:readInt	()I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_2
    //   44: if_icmpne +77 -> 121
    //   47: aload 4
    //   49: astore_2
    //   50: aload 5
    //   52: astore_3
    //   53: new 26	com/tencent/mobileqq/structmsg/StructMsgForAudioShare
    //   56: dup
    //   57: invokespecial 98	com/tencent/mobileqq/structmsg/StructMsgForAudioShare:<init>	()V
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +24 -> 86
    //   65: aload 4
    //   67: astore_2
    //   68: aload_0
    //   69: astore_3
    //   70: aload_0
    //   71: iload_1
    //   72: putfield 45	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   75: aload 4
    //   77: astore_2
    //   78: aload_0
    //   79: astore_3
    //   80: aload_0
    //   81: aload 4
    //   83: invokevirtual 102	com/tencent/mobileqq/structmsg/AbsStructMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   86: aload_0
    //   87: astore_2
    //   88: aload 4
    //   90: ifnull -79 -> 11
    //   93: aload 4
    //   95: invokevirtual 105	java/io/ObjectInputStream:close	()V
    //   98: aload_0
    //   99: areturn
    //   100: astore_3
    //   101: aload_0
    //   102: astore_2
    //   103: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -95 -> 11
    //   109: ldc 113
    //   111: iconst_2
    //   112: aload_3
    //   113: invokevirtual 116	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: areturn
    //   121: iload_1
    //   122: iconst_3
    //   123: if_icmpne +20 -> 143
    //   126: aload 4
    //   128: astore_2
    //   129: aload 5
    //   131: astore_3
    //   132: new 29	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   135: dup
    //   136: invokespecial 121	com/tencent/mobileqq/structmsg/StructMsgForHypertext:<init>	()V
    //   139: astore_0
    //   140: goto -79 -> 61
    //   143: iload_1
    //   144: iconst_5
    //   145: if_icmpne +20 -> 165
    //   148: aload 4
    //   150: astore_2
    //   151: aload 5
    //   153: astore_3
    //   154: new 32	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   157: dup
    //   158: invokespecial 122	com/tencent/mobileqq/structmsg/StructMsgForImageShare:<init>	()V
    //   161: astore_0
    //   162: goto -101 -> 61
    //   165: aload 4
    //   167: astore_2
    //   168: aload 5
    //   170: astore_3
    //   171: new 21	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   174: dup
    //   175: invokespecial 123	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:<init>	()V
    //   178: astore_0
    //   179: goto -118 -> 61
    //   182: astore 5
    //   184: aconst_null
    //   185: astore_0
    //   186: aload_0
    //   187: astore_2
    //   188: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +16 -> 207
    //   194: aload_0
    //   195: astore_2
    //   196: ldc 113
    //   198: iconst_2
    //   199: aload 5
    //   201: invokevirtual 124	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_3
    //   208: astore_2
    //   209: aload_0
    //   210: ifnull -199 -> 11
    //   213: aload_0
    //   214: invokevirtual 105	java/io/ObjectInputStream:close	()V
    //   217: aload_3
    //   218: areturn
    //   219: astore_0
    //   220: aload_3
    //   221: astore_2
    //   222: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq -214 -> 11
    //   228: ldc 113
    //   230: iconst_2
    //   231: aload_0
    //   232: invokevirtual 116	java/io/IOException:getMessage	()Ljava/lang/String;
    //   235: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_3
    //   239: areturn
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_2
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 105	java/io/ObjectInputStream:close	()V
    //   251: aload_0
    //   252: athrow
    //   253: astore_2
    //   254: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -6 -> 251
    //   260: ldc 113
    //   262: iconst_2
    //   263: aload_2
    //   264: invokevirtual 116	java/io/IOException:getMessage	()Ljava/lang/String;
    //   267: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: goto -19 -> 251
    //   273: astore_0
    //   274: goto -31 -> 243
    //   277: astore 5
    //   279: aload 4
    //   281: astore_0
    //   282: goto -96 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramArrayOfByte	byte[]
    //   41	105	1	i	int
    //   6	242	2	localObject1	Object
    //   253	11	2	localIOException1	java.io.IOException
    //   1	79	3	localObject2	Object
    //   100	13	3	localIOException2	java.io.IOException
    //   131	108	3	localObject3	Object
    //   28	252	4	localObjectInputStream	java.io.ObjectInputStream
    //   3	166	5	localObject4	Object
    //   182	18	5	localException1	Exception
    //   277	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   93	98	100	java/io/IOException
    //   13	30	182	java/lang/Exception
    //   213	217	219	java/io/IOException
    //   13	30	240	finally
    //   247	251	253	java/io/IOException
    //   36	42	273	finally
    //   53	61	273	finally
    //   70	75	273	finally
    //   80	86	273	finally
    //   132	140	273	finally
    //   154	162	273	finally
    //   171	179	273	finally
    //   188	194	273	finally
    //   196	207	273	finally
    //   36	42	277	java/lang/Exception
    //   53	61	277	java/lang/Exception
    //   70	75	277	java/lang/Exception
    //   80	86	277	java/lang/Exception
    //   132	140	277	java/lang/Exception
    //   154	162	277	java/lang/Exception
    //   171	179	277	java/lang/Exception
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +9 -> 10
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_2
    //   7: if_icmpge +19 -> 26
    //   10: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +11 -> 24
    //   16: ldc 113
    //   18: iconst_2
    //   19: ldc 132
    //   21: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: iload_1
    //   28: invokestatic 137	com/tencent/mobileqq/structmsg/StructMsgUtils:a	([BI)[B
    //   31: astore_0
    //   32: new 66	java/lang/String
    //   35: dup
    //   36: aload_0
    //   37: ldc 139
    //   39: invokespecial 142	java/lang/String:<init>	([BLjava/lang/String;)V
    //   42: invokestatic 145	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Ljava/lang/String;)Z
    //   45: istore_2
    //   46: iload_2
    //   47: ifne -23 -> 24
    //   50: new 87	java/io/ByteArrayInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 90	java/io/ByteArrayInputStream:<init>	([B)V
    //   58: astore_0
    //   59: new 147	com/tencent/mobileqq/structmsg/StructMsgParserHandler
    //   62: dup
    //   63: invokespecial 148	com/tencent/mobileqq/structmsg/StructMsgParserHandler:<init>	()V
    //   66: astore_3
    //   67: invokestatic 154	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   70: astore 4
    //   72: aload 4
    //   74: invokevirtual 158	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual 164	javax/xml/parsers/SAXParser:parse	(Ljava/io/InputStream;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   82: aload_0
    //   83: invokevirtual 167	java/io/InputStream:close	()V
    //   86: aload_3
    //   87: invokevirtual 170	com/tencent/mobileqq/structmsg/StructMsgParserHandler:a	()Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +17 -> 109
    //   95: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +11 -> 109
    //   101: ldc 113
    //   103: iconst_2
    //   104: ldc 172
    //   106: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 175	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -98 -> 24
    //   125: ldc 113
    //   127: iconst_2
    //   128: ldc 177
    //   130: aload_0
    //   131: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq -116 -> 24
    //   143: ldc 113
    //   145: iconst_2
    //   146: ldc 177
    //   148: aload_0
    //   149: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -134 -> 24
    //   161: ldc 113
    //   163: iconst_2
    //   164: ldc 177
    //   166: aload_0
    //   167: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_0
    //   173: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq -152 -> 24
    //   179: ldc 113
    //   181: iconst_2
    //   182: ldc 183
    //   184: aload_0
    //   185: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: aconst_null
    //   189: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramArrayOfByte	byte[]
    //   0	190	1	paramInt	int
    //   45	2	2	bool	boolean
    //   66	21	3	localStructMsgParserHandler	StructMsgParserHandler
    //   70	3	4	localSAXParserFactory	javax.xml.parsers.SAXParserFactory
    // Exception table:
    //   from	to	target	type
    //   32	46	111	java/io/UnsupportedEncodingException
    //   72	91	118	javax/xml/parsers/ParserConfigurationException
    //   95	109	118	javax/xml/parsers/ParserConfigurationException
    //   72	91	136	org/xml/sax/SAXException
    //   95	109	136	org/xml/sax/SAXException
    //   72	91	154	java/io/IOException
    //   95	109	154	java/io/IOException
    //   72	91	172	java/lang/Exception
    //   95	109	172	java/lang/Exception
  }
  
  public static StructMsgNode a(StructMsgNode paramStructMsgNode)
  {
    for (paramStructMsgNode = paramStructMsgNode.a(); (paramStructMsgNode != null) && (paramStructMsgNode.jdField_a_of_type_Int != 1); paramStructMsgNode = paramStructMsgNode.a()) {}
    return paramStructMsgNode;
  }
  
  public static String a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode.jdField_a_of_type_Int == 3) {}
    Object localObject;
    for (paramStructMsgNode = paramStructMsgNode.jdField_a_of_type_JavaLangString;; paramStructMsgNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramStructMsgNode;
      if (paramStructMsgNode == null) {
        localObject = "";
      }
      return localObject;
      localObject = new StringBuilder();
      int j = paramStructMsgNode.a();
      int i = 0;
      if (i < j)
      {
        StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
        if (localStructMsgNode == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localStructMsgNode.jdField_a_of_type_Int == 3) {
            ((StringBuilder)localObject).append(localStructMsgNode.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public static final boolean a(String paramString)
  {
    boolean bool3 = false;
    String str = System.getProperty("java.vm.version");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        bool1 = a(str, "2.0.0", ".");
        if (QLog.isDevelopLevel()) {
          QLog.d("StructMsg", 4, "java vm version  = " + str + " isART = " + bool1);
        }
        i = 0;
        boolean bool2 = bool3;
        if (i < paramString.length())
        {
          k = paramString.charAt(i);
          j = i;
        }
        switch (k)
        {
        default: 
          if (((k >= 32) && (k <= 55295)) || ((k >= 57344) && (k <= 65533)))
          {
            k = 1;
            if (!bool1) {
              continue;
            }
            j = i;
            if (k != 0) {
              continue;
            }
            bool2 = true;
            return bool2;
          }
          break;
        }
      }
      catch (Exception localException)
      {
        bool1 = false;
        continue;
        int k = 0;
        continue;
        int j = i;
        if (k == 0)
        {
          k = paramString.codePointAt(i);
          if (EmotcationConstants.a.get(k, -1) < 0) {
            continue;
          }
          j = i;
          if (k > 65535) {
            j = i + 1;
          }
        }
        int i = j + 1;
        continue;
        return true;
      }
      boolean bool1 = false;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = Pattern.compile(paramString3, 16).split(paramString1);
        paramString2 = Pattern.compile(paramString3, 16).split(paramString2);
        int m = Math.max(paramString1.length, paramString2.length);
        int i = 0;
        label49:
        if (i < m)
        {
          int j;
          if (paramString1.length > i)
          {
            j = Integer.parseInt(paramString1[i]);
            label69:
            if (paramString2.length <= i) {
              break label103;
            }
          }
          label103:
          for (int k = Integer.parseInt(paramString2[i]); j >= k; k = 0)
          {
            i += 1;
            break label49;
            j = 0;
            break label69;
          }
        }
        return true;
      }
      catch (Exception paramString1) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgFactory
 * JD-Core Version:    0.7.0.1
 */