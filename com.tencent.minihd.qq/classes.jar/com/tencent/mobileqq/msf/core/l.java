package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class l
{
  public static final String a = "MSF.C.Util";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static int g = 0;
  private static final int h = 60000;
  private static final int i = 1000000;
  private static final AtomicInteger j = new AtomicInteger(60000 + new Random().nextInt(100000));
  private static final String k = "sp_imei";
  private static String l = "";
  private static String m = "";
  private static int n;
  private static int o = 0;
  private static String p = "";
  private static String q = "";
  private static String r = "";
  private static String s = "";
  private static String t = "";
  
  public static int a()
  {
    try
    {
      int i1 = j.incrementAndGet();
      if (i1 > 1000000) {
        j.set(60000 + new Random().nextInt(100000));
      }
      return i1;
    }
    finally {}
  }
  
  public static FromServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
    localFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    localFromServiceMsg.setRequestSsoSeq(paramToServiceMsg.getRequestSsoSeq());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    localFromServiceMsg.addAttribute("to_SenderProcessName", paramToServiceMsg.getAttribute("to_SenderProcessName"));
    localFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
    return localFromServiceMsg;
  }
  
  /* Error */
  private static void a(File paramFile, List paramList)
  {
    // Byte code:
    //   0: new 158	java/util/Properties
    //   3: dup
    //   4: invokespecial 159	java/util/Properties:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 165	java/io/File:exists	()Z
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 168	java/io/File:createNewFile	()Z
    //   19: pop
    //   20: aload_1
    //   21: invokeinterface 174 1 0
    //   26: astore_1
    //   27: aload_1
    //   28: invokeinterface 179 1 0
    //   33: ifeq +101 -> 134
    //   36: aload_1
    //   37: invokeinterface 183 1 0
    //   42: checkcast 185	com/tencent/qphone/base/remote/SimpleAccount
    //   45: astore_2
    //   46: aload_3
    //   47: aload_2
    //   48: invokevirtual 186	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   51: aload_2
    //   52: invokevirtual 189	com/tencent/qphone/base/remote/SimpleAccount:toStoreString	()Ljava/lang/String;
    //   55: invokevirtual 193	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: goto -32 -> 27
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +43 -> 113
    //   73: aload_2
    //   74: astore_1
    //   75: ldc 8
    //   77: iconst_2
    //   78: new 200	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   85: ldc 203
    //   87: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 210	java/io/File:getName	()Ljava/lang/String;
    //   94: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 212
    //   99: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_3
    //   103: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: aload_3
    //   110: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: ifeq +11 -> 125
    //   117: new 223	java/lang/NullPointerException
    //   120: dup
    //   121: invokespecial 224	java/lang/NullPointerException:<init>	()V
    //   124: athrow
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   133: return
    //   134: new 226	java/io/FileOutputStream
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 232	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: astore_2
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: aload_2
    //   147: ldc 61
    //   149: invokevirtual 236	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   152: aload_2
    //   153: astore_1
    //   154: aload_2
    //   155: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   158: aload_2
    //   159: astore_1
    //   160: ldc 8
    //   162: iconst_1
    //   163: new 200	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   170: ldc 238
    //   172: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: invokevirtual 210	java/io/File:getName	()Ljava/lang/String;
    //   179: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iconst_0
    //   189: ifeq +11 -> 200
    //   192: new 223	java/lang/NullPointerException
    //   195: dup
    //   196: invokespecial 224	java/lang/NullPointerException:<init>	()V
    //   199: athrow
    //   200: aload_2
    //   201: ifnull -68 -> 133
    //   204: aload_2
    //   205: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   208: return
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual 244	java/io/IOException:printStackTrace	()V
    //   214: return
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_1
    //   218: iconst_0
    //   219: ifeq +11 -> 230
    //   222: new 223	java/lang/NullPointerException
    //   225: dup
    //   226: invokespecial 224	java/lang/NullPointerException:<init>	()V
    //   229: athrow
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore_2
    //   241: aload_2
    //   242: invokevirtual 244	java/io/IOException:printStackTrace	()V
    //   245: goto -15 -> 230
    //   248: astore_1
    //   249: aload_1
    //   250: invokevirtual 244	java/io/IOException:printStackTrace	()V
    //   253: goto -15 -> 238
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 244	java/io/IOException:printStackTrace	()V
    //   261: goto -136 -> 125
    //   264: astore_0
    //   265: goto -55 -> 210
    //   268: astore_0
    //   269: aload_0
    //   270: invokevirtual 244	java/io/IOException:printStackTrace	()V
    //   273: goto -73 -> 200
    //   276: astore_0
    //   277: goto -59 -> 218
    //   280: astore_3
    //   281: goto -216 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramFile	File
    //   0	284	1	paramList	List
    //   45	160	2	localObject	Object
    //   240	2	2	localIOException	IOException
    //   7	40	3	localProperties	Properties
    //   62	84	3	localException1	Exception
    //   280	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	20	62	java/lang/Exception
    //   20	27	62	java/lang/Exception
    //   27	59	62	java/lang/Exception
    //   134	143	62	java/lang/Exception
    //   204	208	209	java/io/IOException
    //   8	20	215	finally
    //   20	27	215	finally
    //   27	59	215	finally
    //   134	143	215	finally
    //   222	230	240	java/io/IOException
    //   234	238	248	java/io/IOException
    //   117	125	256	java/io/IOException
    //   129	133	264	java/io/IOException
    //   192	200	268	java/io/IOException
    //   67	73	276	finally
    //   75	113	276	finally
    //   145	152	276	finally
    //   154	158	276	finally
    //   160	188	276	finally
    //   145	152	280	java/lang/Exception
    //   154	158	280	java/lang/Exception
    //   160	188	280	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    Object localObject = new File(MsfCore.SAVEPATH_IMEI);
    try
    {
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      if (((File)localObject).exists())
      {
        localObject = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI);
        ((Properties)localObject).put("imei", paramString);
        MsfSdkUtils.saveConfig(MsfCore.SAVEPATH_IMEI, (Properties)localObject);
        return;
      }
      QLog.d("MSF.C.Util", 1, "can not create imei file");
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.Util", 1, "save sys imei error", paramString);
    }
  }
  
  private static void a(String paramString, List paramList)
  {
    int i1 = 1;
    for (;;)
    {
      if (i1 != 0)
      {
        Iterator localIterator = paramList.iterator();
        i1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label64;
          }
          if (((SimpleAccount)localIterator.next()).getUin().equals(paramString))
          {
            paramList.remove(i1);
            i1 = 1;
            break;
          }
          i1 += 1;
        }
      }
      return;
      label64:
      i1 = 0;
    }
  }
  
  public static String b()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i1 = 0;
    while (i1 < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i1 += 1;
    }
    return str;
  }
  
  public static String b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getAttributes().get("to_SenderProcessName") != null) {
      return (String)paramToServiceMsg.getAttributes().get("to_SenderProcessName");
    }
    return "";
  }
  
  public static void c()
  {
    Object localObject1 = BaseApplication.getContext();
    TelephonyManager localTelephonyManager;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (((Context)localObject1).checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
        localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      }
      try
      {
        localObject1 = localTelephonyManager.getSubscriberId();
        if (localObject1 != null)
        {
          q = (String)localObject1;
          r = (String)localObject1;
        }
        localObject1 = localTelephonyManager.getNetworkOperatorName();
        if (localObject1 != null) {
          t = (String)localObject1;
        }
        l = localTelephonyManager.getNetworkCountryIso();
        m = localTelephonyManager.getSimCountryIso();
        localObject1 = localTelephonyManager.getCellLocation();
        if (!(localObject1 instanceof CdmaCellLocation)) {
          break label535;
        }
        localObject1 = (CdmaCellLocation)localTelephonyManager.getCellLocation();
        if (localObject1 != null) {
          n = ((CdmaCellLocation)localObject1).getBaseStationId();
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            localObject1 = BaseApplication.getContext().getAssets().open("revision.txt");
            try
            {
              localObject4 = new byte[64];
              i1 = ((InputStream)localObject1).read((byte[])localObject4, 0, 64);
              if (i1 != -1)
              {
                s = new String((byte[])localObject4, 0, i1);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.C.Util", 2, "revision:" + s);
                }
              }
              return;
            }
            catch (IOException localIOException)
            {
              QLog.d("MSF.C.Util", 1, "get revision IOException " + localIOException.getMessage());
              return;
            }
            if (!(localObject1 instanceof GsmCellLocation)) {
              continue;
            }
            localObject1 = (GsmCellLocation)localTelephonyManager.getCellLocation();
            if (localObject1 == null) {
              continue;
            }
            n = ((GsmCellLocation)localObject1).getCid();
          }
          catch (Exception localException5)
          {
            QLog.d("MSF.C.Util", 1, "get revision error " + localException5.getMessage());
            return;
          }
          localException1 = localException1;
          QLog.d("MSF.C.Util", 1, "get imsi error " + localException1, localException1);
          continue;
          if (q.length() > 5)
          {
            q = q.substring(0, 5);
            continue;
            str1 = m();
            g = 4;
            QLog.d("MSF.C.Util", 2, "load imei:" + str1);
          }
        }
      }
      if (q == null)
      {
        q = "";
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.Util", 2, "imsi:" + q + " networkOperatorName:" + t);
        }
      }
    }
    for (;;)
    {
      try
      {
        g = 0;
        if (!new File(MsfCore.SAVEPATH_IMEI).exists()) {
          break label1364;
        }
        localObject4 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei");
        if (localObject4 != null)
        {
          localObject1 = localObject4;
          if (((String)localObject4).length() != 0) {}
        }
        else
        {
          Thread.sleep(200L);
          localObject1 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei", null);
        }
        g = 1;
        QLog.d("MSF.C.Util", 2, "read imei from file " + MsfCore.SAVEPATH_IMEI + ", imei:" + (String)localObject1);
        localObject4 = BaseApplication.getContext().getSharedPreferences("MSF.C.Util", 0);
        if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
          continue;
        }
        localObject1 = ((SharedPreferences)localObject4).getString("sp_imei", null);
        QLog.d("MSF.C.Util", 2, "read imei from sharepreference:" + (String)localObject1);
        if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
          continue;
        }
        localObject1 = localTelephonyManager.getDeviceId();
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          continue;
        }
        g = 3;
        QLog.d("MSF.C.Util", 2, "read sys imei:" + (String)localObject1);
      }
      catch (Exception localException2)
      {
        int i1;
        label535:
        String str1;
        QLog.d("MSF.C.Util", 1, "read sys imei error " + localException2, localException2);
        continue;
        g = 2;
        continue;
        g = 1;
        continue;
      }
      a((String)localObject1);
      Object localObject4 = ((SharedPreferences)localObject4).edit();
      ((SharedPreferences.Editor)localObject4).putString("sp_imei", (String)localObject1);
      ((SharedPreferences.Editor)localObject4).commit();
      p = (String)localObject1;
      QLog.d("MSF.C.Util", 2, "save imei:" + p);
      s = "testrevision";
      localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      try
      {
        localObject2 = localTelephonyManager.getSubscriberId();
        if (localObject2 != null)
        {
          q = (String)localObject2;
          r = (String)localObject2;
        }
        localObject2 = localTelephonyManager.getNetworkOperatorName();
        if (localObject2 != null) {
          t = (String)localObject2;
        }
        l = localTelephonyManager.getNetworkCountryIso();
        m = localTelephonyManager.getSimCountryIso();
        localObject2 = localTelephonyManager.getCellLocation();
        if (!(localObject2 instanceof CdmaCellLocation)) {
          break label1162;
        }
        localObject2 = (CdmaCellLocation)localTelephonyManager.getCellLocation();
        if (localObject2 != null) {
          n = ((CdmaCellLocation)localObject2).getBaseStationId();
        }
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          Object localObject2;
          label789:
          QLog.d("MSF.C.Util", 1, "get imsi error " + localException4, localException4);
          label1162:
          continue;
          if (q.length() > 5)
          {
            q = q.substring(0, 5);
            continue;
            label1246:
            str2 = m();
            g = 4;
            QLog.d("MSF.C.Util", 2, "load imei:" + str2);
            continue;
            label1283:
            g = 2;
            continue;
            label1290:
            g = 1;
          }
        }
      }
      if (q == null)
      {
        q = "";
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.Util", 2, "imsi:" + q + " networkOperatorName:" + t);
        }
      }
      for (;;)
      {
        try
        {
          g = 0;
          if (!new File(MsfCore.SAVEPATH_IMEI).exists()) {
            break label1359;
          }
          localObject4 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei");
          if (localObject4 != null)
          {
            localObject2 = localObject4;
            if (((String)localObject4).length() != 0) {}
          }
          else
          {
            Thread.sleep(200L);
            localObject2 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei", null);
          }
          g = 1;
          QLog.d("MSF.C.Util", 2, "read imei from file " + MsfCore.SAVEPATH_IMEI + ", imei:" + (String)localObject2);
          localObject4 = BaseApplication.getContext().getSharedPreferences("MSF.C.Util", 0);
          if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
            break label1290;
          }
          localObject2 = ((SharedPreferences)localObject4).getString("sp_imei", null);
          QLog.d("MSF.C.Util", 2, "read imei from sharepreference:" + (String)localObject2);
          if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
            break label1283;
          }
          localObject2 = localTelephonyManager.getDeviceId();
          if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
            break label1246;
          }
          g = 3;
          QLog.d("MSF.C.Util", 2, "read sys imei:" + (String)localObject2);
          a((String)localObject2);
          localObject4 = ((SharedPreferences)localObject4).edit();
          ((SharedPreferences.Editor)localObject4).putString("sp_imei", (String)localObject2);
          ((SharedPreferences.Editor)localObject4).commit();
          p = (String)localObject2;
          QLog.d("MSF.C.Util", 2, "save imei:" + p);
        }
        catch (Exception localException3)
        {
          QLog.d("MSF.C.Util", 1, "read sys imei error " + localException3, localException3);
        }
        break;
        if (!(localException3 instanceof GsmCellLocation)) {
          break label789;
        }
        GsmCellLocation localGsmCellLocation = (GsmCellLocation)localTelephonyManager.getCellLocation();
        if (localGsmCellLocation == null) {
          break label789;
        }
        n = localGsmCellLocation.getCid();
        break label789;
        String str2;
        label1359:
        localObject3 = null;
      }
      label1364:
      Object localObject3 = null;
    }
  }
  
  public static String d()
  {
    return p;
  }
  
  public static String e()
  {
    return q;
  }
  
  public static String f()
  {
    return r;
  }
  
  public static String g()
  {
    return s;
  }
  
  public static int h()
  {
    return o;
  }
  
  public static String i()
  {
    return l;
  }
  
  public static String j()
  {
    return m;
  }
  
  public static int k()
  {
    return n;
  }
  
  public static String l()
  {
    return t;
  }
  
  public static String m()
  {
    String str1 = null;
    Object localObject = new File(MsfCore.SAVEPATH_IMEI);
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      if (((File)localObject).exists()) {
        str1 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei");
      }
      if (str1 != null)
      {
        i1 = str1.length();
        if (i1 > 0) {
          return str1;
        }
      }
    }
    catch (Exception localException1)
    {
      QLog.d("MSF.C.Util", 1, "load sys imei error", localException1);
      localStringBuffer = new StringBuffer();
      int i1 = 0;
      while (i1 < 15)
      {
        localStringBuffer.append(new Random().nextInt(10));
        i1 += 1;
      }
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        if (!((File)localObject).exists()) {
          continue;
        }
        localObject = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI);
        ((Properties)localObject).put("imei", str2);
        MsfSdkUtils.saveConfig(MsfCore.SAVEPATH_IMEI, (Properties)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.Util", 2, "write imei " + str2);
        }
      }
      catch (Exception localException2)
      {
        QLog.d("MSF.C.Util", 1, "load imei error", localException2);
        continue;
      }
      return localStringBuffer.toString();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.Util", 2, "can not create imei file");
      }
    }
  }
  
  public static String n()
  {
    try
    {
      NetworkInterface localNetworkInterface;
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          do
          {
            if ((localObject == null) || (!((Enumeration)localObject).hasMoreElements())) {
              break;
            }
            localNetworkInterface = (NetworkInterface)((Enumeration)localObject).nextElement();
          } while (localNetworkInterface == null);
          localEnumeration = localNetworkInterface.getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (localInetAddress.isAnyLocalAddress()) || (localInetAddress.isLinkLocalAddress()));
      Object localObject = localNetworkInterface.getName() + ":" + localInetAddress.getHostAddress();
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.C.Util", 2, "getDeviceIp error " + localException.toString(), localException);
      }
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.l
 * JD-Core Version:    0.7.0.1
 */