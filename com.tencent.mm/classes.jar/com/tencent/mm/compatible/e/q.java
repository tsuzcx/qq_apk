package com.tencent.mm.compatible.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mm.a.g;
import com.tencent.mm.h.a.ch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileFilter;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public final class q
{
  public static o dyc = new o();
  public static c dyd = new c();
  public static b dye = new b();
  public static v dyf = new v();
  public static z dyg = new z();
  public static s dyh = new s();
  public static u dyi = new u();
  public static x dyj = new x();
  public static t dyk = new t();
  public static a dyl = new a();
  private static int dym = -1;
  public static k dyn = new k();
  public static p dyo = new p();
  private static String dyp = null;
  
  public static String bc(Context paramContext)
  {
    try
    {
      y.i("MicroMsg.DeviceInfo", "lm: getManufacturer CurrentLanguage is %s", new Object[] { com.tencent.mm.sdk.platformtools.x.fB(paramContext) });
      if ((dyi == null) || (dyi.dyF == null) || (dyi.dyF.size() == 0))
      {
        y.i("MicroMsg.DeviceInfo", "lm: getManufacturer return is %s", new Object[] { Build.MANUFACTURER });
        return Build.MANUFACTURER;
      }
      String str = (String)dyi.dyF.get(".manufacturerName." + com.tencent.mm.sdk.platformtools.x.fB(paramContext));
      y.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", new Object[] { str });
      paramContext = str;
      if (bk.bl(str))
      {
        str = (String)dyi.dyF.get(".manufacturerName.en");
        y.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", new Object[] { str });
        paramContext = str;
        if (bk.bl(str))
        {
          paramContext = Build.MANUFACTURER;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext = Build.MANUFACTURER;
    }
    return paramContext;
  }
  
  public static String bd(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperatorName();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "getMobileSPType", new Object[0]);
    }
    return "";
  }
  
  public static String br(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    String str;
    if ((paramBoolean) || (dyp == null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Settings.Secure.getString(ae.getContext().getContentResolver(), "android_id"));
      if (paramBoolean) {
        break label166;
      }
      str = (String)l.yP().get(256);
      if (str == null) {
        break label166;
      }
      localStringBuilder.append(str);
      str = (String)l.yP().get(259);
      if (str == null) {
        break label183;
      }
      y.d("MicroMsg.DeviceInfo", "getHardWareId from file " + str);
    }
    for (;;)
    {
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      dyp = "A" + g.o(str.getBytes()).substring(0, 15);
      y.w("MicroMsg.DeviceInfo", "guid:%s, dev=%s", new Object[] { dyp, str });
      return dyp;
      label166:
      str = zk();
      l.yP().set(256, str);
      break;
      label183:
      str = Build.MANUFACTURER + Build.MODEL + n.yW();
      l.yP().set(259, str);
      y.d("MicroMsg.DeviceInfo", "getHardWareId " + str);
    }
  }
  
  public static void fa(String paramString)
  {
    y.i("MicroMsg.DeviceInfo", "update deviceInfo %s", new Object[] { paramString });
    if ((paramString == null) || (paramString.length() <= 0)) {}
    do
    {
      do
      {
        return;
      } while (paramString.hashCode() == dym);
      dym = paramString.hashCode();
      dyc.reset();
      dyd.reset();
      dye.reset();
      dyn.reset();
      dyf.reset();
      dyg.reset();
      Object localObject = dyh;
      ((s)localObject).dyq = 0;
      ((s)localObject).dyr = 0;
      localObject = dyi;
      ((u)localObject).dyE = "";
      ((u)localObject).dyF = null;
      localObject = dyj;
      ((x)localObject).cbb = false;
      ((x)localObject).dyQ = 0;
      dyk.reset();
      localObject = dyl;
      ((a)localObject).duL = false;
      ((a)localObject).duM = "";
      new r();
    } while (!r.a(paramString, dyc, dyd, dye, dyn, dyf, dyg, dyh, dyi, dyj, dyk, dyl));
    y.i("MicroMsg.DeviceInfo", "steve: mCameraInfo.mSupportVoipBeauty = " + dyd.dwE);
    paramString = new ch();
    com.tencent.mm.sdk.b.a.udP.m(paramString);
  }
  
  public static String getAndroidId()
  {
    String str = Settings.Secure.getString(ae.getContext().getContentResolver(), "android_id");
    y.i("MicroMsg.DeviceInfo", "androidid:[%s]", new Object[] { str });
    return str;
  }
  
  public static String getDeviceID(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getDeviceId();
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.trim();
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      y.e("MicroMsg.DeviceInfo", "getDeviceId failed, security exception");
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static String getSimCountryIso()
  {
    Object localObject = (TelephonyManager)ae.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getSimCountryIso();
      y.i("MicroMsg.DeviceInfo", "get isoCode:[%s]", new Object[] { localObject });
      return localObject;
    }
    return null;
  }
  
  public static String zf()
  {
    Object localObject = (String)l.yP().get(258);
    if (localObject != null) {
      return localObject;
    }
    String str = getDeviceID(ae.getContext());
    localObject = str;
    if (str == null) {
      localObject = "1234567890ABCDEF";
    }
    l.yP().set(258, localObject);
    return localObject;
  }
  
  public static String zg()
  {
    return br(false);
  }
  
  public static boolean zh()
  {
    return dyp != null;
  }
  
  public static String zi()
  {
    Object localObject = (WifiManager)ae.getContext().getSystemService("wifi");
    if (localObject == null) {}
    for (localObject = null; localObject != null; localObject = ((WifiManager)localObject).getConnectionInfo()) {
      return ((WifiInfo)localObject).getMacAddress();
    }
    return null;
  }
  
  public static String zj()
  {
    String str = null;
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter != null) {
      str = localBluetoothAdapter.getAddress();
    }
    return str;
  }
  
  private static String zk()
  {
    int i = 0;
    String str1 = bk.fP(ae.getContext());
    String str2;
    if ((str1 != null) && (str1.length() > 0))
    {
      str2 = ("A" + str1 + "123456789ABCDEF").substring(0, 15);
      y.w("MicroMsg.DeviceInfo", "generated deviceId=" + str2);
      return str2;
    }
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    str1 = "A";
    for (;;)
    {
      str2 = str1;
      if (i >= 15) {
        break;
      }
      str1 = str1 + (char)(localRandom.nextInt(25) + 65);
      i += 1;
    }
  }
  
  public static String zl()
  {
    return Build.MODEL;
  }
  
  /* Error */
  public static String[] zm()
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 161	java/lang/String
    //   4: astore_2
    //   5: aload_2
    //   6: iconst_0
    //   7: ldc 193
    //   9: aastore
    //   10: aload_2
    //   11: iconst_1
    //   12: ldc_w 428
    //   15: aastore
    //   16: new 430	java/io/BufferedReader
    //   19: dup
    //   20: new 432	java/io/FileReader
    //   23: dup
    //   24: ldc_w 434
    //   27: invokespecial 435	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   30: sipush 8192
    //   33: invokespecial 438	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 441	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: invokestatic 445	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   44: ldc_w 447
    //   47: invokevirtual 451	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   50: astore_3
    //   51: iconst_2
    //   52: istore_0
    //   53: iload_0
    //   54: aload_3
    //   55: arraylength
    //   56: if_icmpge +41 -> 97
    //   59: aload_2
    //   60: iconst_0
    //   61: new 142	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   68: aload_2
    //   69: iconst_0
    //   70: aaload
    //   71: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_3
    //   75: iload_0
    //   76: aaload
    //   77: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc_w 453
    //   83: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: aastore
    //   90: iload_0
    //   91: iconst_1
    //   92: iadd
    //   93: istore_0
    //   94: goto -41 -> 53
    //   97: aload_2
    //   98: iconst_1
    //   99: aload_1
    //   100: invokevirtual 441	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   103: invokestatic 445	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
    //   106: ldc_w 447
    //   109: invokevirtual 451	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   112: iconst_2
    //   113: aaload
    //   114: aastore
    //   115: aload_1
    //   116: invokevirtual 456	java/io/BufferedReader:close	()V
    //   119: aload_2
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull -6 -> 119
    //   128: aload_1
    //   129: invokevirtual 456	java/io/BufferedReader:close	()V
    //   132: aload_2
    //   133: areturn
    //   134: astore_1
    //   135: aload_2
    //   136: areturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 456	java/io/BufferedReader:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: aload_2
    //   152: areturn
    //   153: astore_2
    //   154: goto -6 -> 148
    //   157: astore_2
    //   158: aload_1
    //   159: astore_3
    //   160: aload_2
    //   161: astore_1
    //   162: aload_3
    //   163: astore_2
    //   164: goto -24 -> 140
    //   167: astore_3
    //   168: goto -44 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   52	42	0	i	int
    //   36	80	1	localBufferedReader	java.io.BufferedReader
    //   121	1	1	localIOException1	java.io.IOException
    //   123	6	1	localObject1	Object
    //   134	1	1	localException1	Exception
    //   137	12	1	localObject2	Object
    //   150	9	1	localException2	Exception
    //   161	1	1	localObject3	Object
    //   4	148	2	arrayOfString	String[]
    //   153	1	2	localException3	Exception
    //   157	4	2	localObject4	Object
    //   163	1	2	localObject5	Object
    //   50	113	3	localObject6	Object
    //   167	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   16	37	121	java/io/IOException
    //   128	132	134	java/lang/Exception
    //   16	37	137	finally
    //   115	119	150	java/lang/Exception
    //   144	148	153	java/lang/Exception
    //   37	51	157	finally
    //   53	90	157	finally
    //   97	115	157	finally
    //   37	51	167	java/io/IOException
    //   53	90	167	java/io/IOException
    //   97	115	167	java/io/IOException
  }
  
  public static String zn()
  {
    Object localObject2 = null;
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      Object localObject1 = localObject2;
      if (localBluetoothAdapter != null)
      {
        localObject1 = localObject2;
        if (localBluetoothAdapter.isEnabled()) {
          localObject1 = localBluetoothAdapter.getAddress();
        }
      }
      localObject1 = bk.pm((String)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.DeviceInfo", "getBlueToothAddress failed: %s", new Object[] { bk.j(localException) });
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  public static String zo()
  {
    for (Object localObject = null;; localObject = str)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 14) {
          break label21;
        }
        str = Build.getRadioVersion();
        localObject = str;
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        String str;
        y.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
        throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError));
      }
      catch (Throwable localThrowable)
      {
        label16:
        label21:
        break label16;
      }
      return bk.pm(localObject);
      str = Build.RADIO;
    }
  }
  
  public static String zp()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String zq()
  {
    try
    {
      String str = bk.pm(((TelephonyManager)ae.getContext().getSystemService("phone")).getSubscriberId());
      return str;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.DeviceInfo", localException, "getPhoneIMSI", new Object[0]);
    }
    return "";
  }
  
  public static String zr()
  {
    try
    {
      String str = bk.pm(((TelephonyManager)ae.getContext().getSystemService("phone")).getSimSerialNumber());
      return str;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.DeviceInfo", localException, "getPhoneICCID", new Object[0]);
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  public static String zs()
  {
    String str = null;
    if (Build.VERSION.SDK_INT >= 9) {
      str = Build.SERIAL;
    }
    return bk.pm(str);
  }
  
  /* Error */
  public static Map<String, String> zt()
  {
    // Byte code:
    //   0: new 521	java/util/HashMap
    //   3: dup
    //   4: invokespecial 522	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 430	java/io/BufferedReader
    //   11: dup
    //   12: new 524	java/io/InputStreamReader
    //   15: dup
    //   16: new 526	java/io/FileInputStream
    //   19: dup
    //   20: ldc_w 434
    //   23: invokespecial 527	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   26: ldc_w 529
    //   29: invokespecial 532	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   32: invokespecial 535	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 441	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +84 -> 128
    //   47: aload_1
    //   48: astore_0
    //   49: aload_2
    //   50: invokevirtual 348	java/lang/String:trim	()Ljava/lang/String;
    //   53: ldc 193
    //   55: invokevirtual 539	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne -22 -> 36
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: ldc_w 541
    //   67: invokevirtual 451	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore_2
    //   71: aload_1
    //   72: astore_0
    //   73: aload_2
    //   74: arraylength
    //   75: iconst_1
    //   76: if_icmple -40 -> 36
    //   79: aload_1
    //   80: astore_0
    //   81: aload_3
    //   82: aload_2
    //   83: iconst_0
    //   84: aaload
    //   85: invokevirtual 348	java/lang/String:trim	()Ljava/lang/String;
    //   88: invokevirtual 544	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   91: aload_2
    //   92: iconst_1
    //   93: aaload
    //   94: invokevirtual 348	java/lang/String:trim	()Ljava/lang/String;
    //   97: invokeinterface 548 3 0
    //   102: pop
    //   103: goto -67 -> 36
    //   106: astore_2
    //   107: aload_1
    //   108: astore_0
    //   109: ldc 110
    //   111: aload_2
    //   112: ldc_w 550
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 191	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_1
    //   123: invokestatic 554	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   126: aload_3
    //   127: areturn
    //   128: aload_1
    //   129: invokestatic 554	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   132: aload_3
    //   133: areturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_0
    //   137: aload_0
    //   138: invokestatic 554	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: goto -7 -> 137
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -43 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	101	0	localBufferedReader1	java.io.BufferedReader
    //   35	94	1	localBufferedReader2	java.io.BufferedReader
    //   134	8	1	localObject1	Object
    //   143	1	1	localObject2	Object
    //   149	1	1	localObject3	Object
    //   42	50	2	localObject4	Object
    //   106	6	2	localIOException1	java.io.IOException
    //   147	1	2	localIOException2	java.io.IOException
    //   7	126	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   38	43	106	java/io/IOException
    //   49	61	106	java/io/IOException
    //   63	71	106	java/io/IOException
    //   73	79	106	java/io/IOException
    //   81	103	106	java/io/IOException
    //   8	36	134	finally
    //   38	43	143	finally
    //   49	61	143	finally
    //   63	71	143	finally
    //   73	79	143	finally
    //   81	103	143	finally
    //   109	122	143	finally
    //   8	36	147	java/io/IOException
  }
  
  public static int zu()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu").listFiles(new a()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  public static String zv()
  {
    return "android-" + Build.MODEL + "-" + Build.VERSION.SDK_INT;
  }
  
  final class a
    implements FileFilter
  {
    public final boolean accept(File paramFile)
    {
      return Pattern.matches("cpu[0-9]+", paramFile.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.q
 * JD-Core Version:    0.7.0.1
 */