package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kqr;
import kqt;
import kqu;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class AntiFraudConfigFileUtil
{
  public static final String A = "normal";
  public static final String B = "confirmed";
  public static final String C = "type";
  public static final String D = "url";
  public static final String E = "phone";
  public static final String F = "status";
  public static final String G = "sens_msg_uniseq";
  public static final String H = "openURL";
  public static final String I = "makePhoneCall";
  public static final String J = "showAlert";
  public static final String K = "0";
  public static final String L = "1";
  private static final String M = "UinSafety.WordingConfigFileUtil";
  public static final int a = 1;
  public static final String a = "SecWarningCfg";
  private static final int jdField_b_of_type_Int = 0;
  public static final String b = "SensMsgTipsCfg";
  private static final int c = 0;
  public static final String c = "SecurityConfig";
  private static final int d = 1;
  public static final String d = "SubConfig";
  private static final int e = 2;
  public static final String e = "PublicElement";
  private static final int f = 3;
  public static final String f = "Element";
  public static final String g = "BannerTTL";
  public static final String h = "BannerURL";
  public static final String i = "BannerWording";
  public static final String j = "AlertTitle";
  public static final String k = "AlertText";
  public static final String l = "AlertLeftBtnText";
  public static final String m = "AlertRightBtnText";
  public static final String n = "AlertOtherBtnText";
  public static final String o = "AlertCancelBtnText";
  public static final String p = "TailWording";
  public static final String q = "Action";
  public static final String r = "Version";
  public static final String s = "Type";
  public static final String t = "Value";
  public static final String u = "Status";
  public static final String v = "PlaceHolder";
  public static final String w = "Name";
  public static final String x = "LastModifiedTime";
  public static final String y = "EffectTime";
  public static final String z = "MD5";
  private Bundle jdField_a_of_type_AndroidOsBundle = null;
  private SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new kqr(this);
  private Bundle jdField_b_of_type_AndroidOsBundle;
  
  private AntiFraudConfigFileUtil()
  {
    this.b = new Bundle();
  }
  
  public static AntiFraudConfigFileUtil a()
  {
    return kqu.a;
  }
  
  private void a(Bundle paramBundle, String paramString, Element paramElement)
  {
    if (paramString.equalsIgnoreCase("1"))
    {
      Object localObject1 = paramElement.getElementsByTagName("TailWording");
      Object localObject2;
      int i1;
      Object localObject3;
      String str;
      if (((NodeList)localObject1).getLength() > 0)
      {
        localObject2 = new Bundle();
        i1 = 0;
        while (i1 < ((NodeList)localObject1).getLength())
        {
          localObject3 = (Element)((NodeList)localObject1).item(i1);
          str = ((Element)localObject3).getAttribute("Status");
          paramString = str;
          if (TextUtils.isEmpty(str)) {
            paramString = "0";
          }
          ((Bundle)localObject2).putString(paramString, ((Element)localObject3).getTextContent());
          i1 += 1;
        }
        paramBundle.putBundle("TailWording", (Bundle)localObject2);
      }
      paramString = paramElement.getElementsByTagName("Action");
      if (paramString.getLength() > 0)
      {
        paramElement = new Bundle();
        i1 = 0;
        while (i1 < paramString.getLength())
        {
          localObject2 = (Element)paramString.item(i1);
          str = ((Element)localObject2).getAttribute("PlaceHolder");
          if (TextUtils.isEmpty(str))
          {
            i1 += 1;
          }
          else
          {
            localObject1 = new Bundle();
            localObject3 = ((Element)localObject2).getAttribute("Type");
            ((Bundle)localObject1).putString("Type", (String)localObject3);
            ((Bundle)localObject1).putString("Name", ((Element)localObject2).getAttribute("Name"));
            if (((String)localObject3).equalsIgnoreCase("openURL")) {
              a((Bundle)localObject1, (Element)localObject2);
            }
            for (;;)
            {
              paramElement.putBundle(str, (Bundle)localObject1);
              break;
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertTitle");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertOtherBtnText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject2 = ((Element)localObject2).getElementsByTagName("AlertCancelBtnText");
              if (((NodeList)localObject2).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject2).item(0));
              }
            }
          }
        }
        paramBundle.putBundle("Action", paramElement);
      }
    }
    for (;;)
    {
      return;
      for (paramString = paramElement.getFirstChild(); paramString != null; paramString = paramString.getNextSibling()) {
        if ((paramString instanceof Element))
        {
          paramElement = new Bundle();
          a(paramElement, (Element)paramString);
          paramBundle.putBundle(paramString.getNodeName(), paramElement);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle, Element paramElement)
  {
    String str = paramElement.getNodeName();
    paramElement = paramElement.getFirstChild();
    Object localObject2;
    for (Object localObject1 = ""; paramElement != null; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if ((paramElement instanceof Text)) {
        localObject2 = (String)localObject1 + paramElement.getNodeValue();
      }
      paramElement = paramElement.getNextSibling();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramBundle.putString(str, (String)localObject1);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSafety.WordingConfigFileUtil", 2, "parse config file:" + paramString);
    }
    paramString = a(paramString);
    if (paramString != null) {
      b(paramString);
    }
  }
  
  private void b(String paramString)
  {
    Object localObject2 = DocumentBuilderFactory.newInstance();
    try
    {
      Object localObject1 = new File(paramString);
      localObject2 = ((DocumentBuilderFactory)localObject2).newDocumentBuilder().parse((File)localObject1).getDocumentElement();
      paramString = new Bundle();
      String str = ((Element)localObject2).getAttribute("Version");
      int i1;
      if (TextUtils.isEmpty(str))
      {
        i1 = 0;
        paramString.putInt("Version", i1);
        localObject2 = ((Element)localObject2).getElementsByTagName("SubConfig");
        i1 = 0;
      }
      for (;;)
      {
        if (i1 >= ((NodeList)localObject2).getLength()) {
          break label290;
        }
        Object localObject3 = (Element)((NodeList)localObject2).item(i1);
        str = ((Element)localObject3).getAttribute("Type");
        Bundle localBundle1 = new Bundle();
        Object localObject4 = ((Element)localObject3).getElementsByTagName("Element");
        int i2 = 0;
        for (;;)
        {
          if (i2 < ((NodeList)localObject4).getLength())
          {
            Element localElement = (Element)((NodeList)localObject4).item(i2);
            Bundle localBundle2 = new Bundle();
            a(localBundle2, str, localElement);
            localBundle1.putBundle(localElement.getAttribute("Value"), localBundle2);
            i2 += 1;
            continue;
            i1 = Integer.parseInt(str);
            break;
          }
        }
        localObject3 = ((Element)localObject3).getElementsByTagName("PublicElement");
        if (((NodeList)localObject3).getLength() > 0)
        {
          localObject3 = (Element)((NodeList)localObject3).item(0);
          localObject4 = new Bundle();
          a((Bundle)localObject4, str, (Element)localObject3);
          localBundle1.putBundle("PublicElement", (Bundle)localObject4);
        }
        paramString.putBundle(str, localBundle1);
        i1 += 1;
      }
      label290:
      localObject1 = ((File)localObject1).getName();
      localObject1 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("."));
      this.jdField_a_of_type_AndroidOsBundle.putBundle((String)localObject1, paramString);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UinSafety.WordingConfigFileUtil", 2, "exception occurred." + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  private void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 252	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 4
    //   13: invokestatic 320	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   16: invokevirtual 326	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   19: aload_2
    //   20: invokevirtual 332	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore_1
    //   24: new 334	java/io/FileOutputStream
    //   27: dup
    //   28: aload 4
    //   30: iconst_1
    //   31: invokespecial 337	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   34: astore 4
    //   36: sipush 4096
    //   39: newarray byte
    //   41: astore_2
    //   42: aload_1
    //   43: aload_2
    //   44: invokevirtual 343	java/io/InputStream:read	([B)I
    //   47: istore_3
    //   48: iload_3
    //   49: ifle +47 -> 96
    //   52: aload 4
    //   54: aload_2
    //   55: iconst_0
    //   56: iload_3
    //   57: invokevirtual 349	java/io/OutputStream:write	([BII)V
    //   60: goto -18 -> 42
    //   63: astore 5
    //   65: aload_1
    //   66: astore_2
    //   67: aload 4
    //   69: astore_1
    //   70: aload 5
    //   72: astore 4
    //   74: aload 4
    //   76: invokevirtual 312	java/lang/Exception:printStackTrace	()V
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_2
    //   84: invokevirtual 352	java/io/InputStream:close	()V
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 353	java/io/OutputStream:close	()V
    //   95: return
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 352	java/io/InputStream:close	()V
    //   104: aload 4
    //   106: ifnull -11 -> 95
    //   109: aload 4
    //   111: invokevirtual 353	java/io/OutputStream:close	()V
    //   114: return
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   120: return
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   126: return
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_1
    //   130: aload 5
    //   132: astore 4
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 352	java/io/InputStream:close	()V
    //   142: aload 4
    //   144: ifnull +8 -> 152
    //   147: aload 4
    //   149: invokevirtual 353	java/io/OutputStream:close	()V
    //   152: aload_2
    //   153: athrow
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   159: goto -7 -> 152
    //   162: astore_2
    //   163: aload 5
    //   165: astore 4
    //   167: goto -33 -> 134
    //   170: astore_2
    //   171: goto -37 -> 134
    //   174: astore 4
    //   176: aload_2
    //   177: astore 5
    //   179: aload 4
    //   181: astore_2
    //   182: aload_1
    //   183: astore 4
    //   185: aload 5
    //   187: astore_1
    //   188: goto -54 -> 134
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_1
    //   195: aload 6
    //   197: astore_2
    //   198: goto -124 -> 74
    //   201: astore 4
    //   203: aconst_null
    //   204: astore 5
    //   206: aload_1
    //   207: astore_2
    //   208: aload 5
    //   210: astore_1
    //   211: goto -137 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	AntiFraudConfigFileUtil
    //   0	214	1	paramString1	String
    //   0	214	2	paramString2	String
    //   47	10	3	i1	int
    //   11	155	4	localObject1	Object
    //   174	6	4	localObject2	Object
    //   183	1	4	str1	String
    //   191	1	4	localException1	Exception
    //   201	1	4	localException2	Exception
    //   1	1	5	localObject3	Object
    //   63	101	5	localException3	Exception
    //   177	32	5	str2	String
    //   4	192	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	42	63	java/lang/Exception
    //   42	48	63	java/lang/Exception
    //   52	60	63	java/lang/Exception
    //   100	104	115	java/io/IOException
    //   109	114	115	java/io/IOException
    //   83	87	121	java/io/IOException
    //   91	95	121	java/io/IOException
    //   13	24	127	finally
    //   138	142	154	java/io/IOException
    //   147	152	154	java/io/IOException
    //   24	36	162	finally
    //   36	42	170	finally
    //   42	48	170	finally
    //   52	60	170	finally
    //   74	79	174	finally
    //   13	24	191	java/lang/Exception
    //   24	36	201	java/lang/Exception
  }
  
  public long a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "LastModifiedTime", 0L);
  }
  
  public Object a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_AndroidOsBundle.containsKey(paramString1)) {
      a(paramString1);
    }
    Bundle localBundle1 = null;
    Bundle localBundle2 = this.jdField_a_of_type_AndroidOsBundle.getBundle(paramString1);
    paramString1 = localBundle1;
    if (localBundle2 != null)
    {
      localBundle2 = localBundle2.getBundle(Integer.toString(paramInt1));
      paramString1 = localBundle1;
      if (localBundle2 != null)
      {
        Bundle localBundle3 = localBundle2.getBundle(Integer.toString(paramInt2));
        paramString1 = localBundle1;
        if (localBundle3 != null)
        {
          localBundle1 = localBundle3.getBundle(paramString2);
          paramString1 = localBundle1;
          if (localBundle1 == null)
          {
            localBundle2 = localBundle2.getBundle("PublicElement");
            paramString1 = localBundle1;
            if (localBundle2 != null) {
              paramString1 = localBundle2.getBundle(paramString2);
            }
          }
        }
      }
    }
    return paramString1;
  }
  
  public String a(String paramString)
  {
    return BaseApplication.getContext().getFilesDir().getPath() + "/" + paramString + ".xml";
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_AndroidOsBundle.containsKey(paramString1)) {
      a(paramString1);
    }
    Object localObject = null;
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle.getBundle(paramString1);
    paramString1 = localObject;
    if (localBundle != null) {
      paramString1 = localBundle.getString(paramString2);
    }
    return paramString1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    long l1;
    long l2;
    do
    {
      return;
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
      l1 = a(paramString);
      l2 = b(paramString);
    } while (System.currentTimeMillis() - l1 < l2 * 1000L);
    ((SecSvcHandler)paramQQAppInterface.a(36)).a(paramString);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        long l1;
        long l2;
        do
        {
          return;
          if (!paramString1.equalsIgnoreCase("SecWarningCfg")) {
            break;
          }
          l1 = a(paramString1);
          l2 = b(paramString1);
        } while ((paramQQAppInterface == null) || (System.currentTimeMillis() - l1 < l2 * 1000L));
        ((SecSvcHandler)paramQQAppInterface.a(36)).a(paramString1);
        return;
      } while (!paramString1.equalsIgnoreCase("SensMsgTipsCfg"));
      paramString1 = b(paramString1);
      paramQQAppInterface = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        String str = a("SensMsgTipsCfg");
        if (!FileUtil.a(str)) {
          b("SensMsgTipsCfg", "qq_security_sensmsgtipscfg.xml");
        }
        paramQQAppInterface = paramString1;
        if (FileUtil.a(str))
        {
          paramQQAppInterface = SecUtil.a(str);
          a("SensMsgTipsCfg", paramQQAppInterface);
        }
      }
    } while ((TextUtils.equals(paramQQAppInterface, paramString3)) || (TextUtils.isEmpty(paramString2)));
    a("SensMsgTipsCfg", paramString3, paramString2);
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "LastModifiedTime", paramLong);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString(paramString1 + "_" + "MD5", paramString2);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i1 = this.b.getInt(paramString2, 0);
    if ((i1 == 1) || (i1 == 3)) {
      return;
    }
    this.b.putInt(paramString2, 1);
    ThreadManager.a(new kqt(this, paramString1, paramString3, paramString2));
  }
  
  public long b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "EffectTime", 0L);
  }
  
  public String b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(paramString + "_" + "MD5", null);
  }
  
  public void b(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "EffectTime", paramLong);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil
 * JD-Core Version:    0.7.0.1
 */