package com.tencent.mm.compatible.deviceinfo;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.LocalServerSocket;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q
{
  private static final b gcH;
  private static final b gcI;
  private static final b gcJ;
  private static final b gcK;
  private static final b gcL;
  private static final b gcM;
  private static final b gcN;
  private static final b gcO;
  private static final b gcP;
  
  static
  {
    AppMethodBeat.i(155741);
    gcH = new b(new d("a")
    {
      final void aaR()
      {
        AppMethodBeat.i(155685);
        r.ls(4);
        AppMethodBeat.o(155685);
      }
      
      final void cI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155686);
        if (paramAnonymousBoolean) {
          r.ls(2);
        }
        AppMethodBeat.o(155686);
      }
    })
    {
      final q.a gcQ;
      
      final String aaS()
      {
        AppMethodBeat.i(155693);
        Object localObject = this.gcQ.vD("1234567890ABCDEF");
        if (!"1234567890ABCDEF".equals(localObject))
        {
          r.ls(0);
          AppMethodBeat.o(155693);
          return localObject;
        }
        localObject = (TelephonyManager)ak.getContext().getSystemService("phone");
        try
        {
          ae.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getDeviceId, %s", new Object[] { bu.fpN() });
          localObject = ((TelephonyManager)localObject).getDeviceId();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            r.ls(5);
          }
          AppMethodBeat.o(155693);
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          r.ls(5);
          AppMethodBeat.o(155693);
        }
        return null;
      }
      
      final void aaT()
      {
        AppMethodBeat.i(155694);
        r.ls(3);
        AppMethodBeat.o(155694);
      }
    };
    gcI = new b(new d("c"))
    {
      final String aaS()
      {
        AppMethodBeat.i(155695);
        ae.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSerial, %s", new Object[] { bu.fpN() });
        if (Build.VERSION.SDK_INT < 9)
        {
          AppMethodBeat.o(155695);
          return null;
        }
        String str;
        if (Build.VERSION.SDK_INT < 26)
        {
          str = Build.SERIAL;
          AppMethodBeat.o(155695);
          return str;
        }
        try
        {
          str = Build.getSerial();
          AppMethodBeat.o(155695);
          return str;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(155695);
        }
        return null;
      }
    };
    gcJ = new b(new d("d"))
    {
      final String aaS()
      {
        AppMethodBeat.i(155696);
        Object localObject = (WifiManager)ak.getContext().getSystemService("wifi");
        if (localObject != null) {}
        for (localObject = ((WifiManager)localObject).getConnectionInfo(); localObject != null; localObject = null)
        {
          localObject = ((WifiInfo)localObject).getMacAddress();
          AppMethodBeat.o(155696);
          return localObject;
        }
        AppMethodBeat.o(155696);
        return null;
      }
    };
    gcK = new b(new d("e"))
    {
      final String aaS()
      {
        AppMethodBeat.i(155697);
        Object localObject = BluetoothAdapter.getDefaultAdapter();
        if ((localObject != null) && (((BluetoothAdapter)localObject).isEnabled()))
        {
          localObject = ((BluetoothAdapter)localObject).getAddress();
          AppMethodBeat.o(155697);
          return localObject;
        }
        AppMethodBeat.o(155697);
        return null;
      }
    };
    gcL = new b(new d("f")
    {
      final void aaR()
      {
        AppMethodBeat.i(155698);
        r.ls(14);
        AppMethodBeat.o(155698);
      }
      
      final void cI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155699);
        if (paramAnonymousBoolean) {
          r.ls(12);
        }
        AppMethodBeat.o(155699);
      }
    })
    {
      final q.a gcR;
      
      final String aaS()
      {
        AppMethodBeat.i(155701);
        String str = this.gcR.vD(null);
        if (str != null)
        {
          r.ls(10);
          AppMethodBeat.o(155701);
          return str;
        }
        str = Build.MANUFACTURER + Build.MODEL + n.aas();
        AppMethodBeat.o(155701);
        return str;
      }
      
      final void aaT()
      {
        AppMethodBeat.i(155702);
        r.ls(13);
        AppMethodBeat.o(155702);
      }
    };
    gcM = new b(new d("g"))
    {
      final String aaS()
      {
        AppMethodBeat.i(155703);
        try
        {
          String str = Settings.Secure.getString(ak.getContext().getContentResolver(), "android_id");
          AppMethodBeat.o(155703);
          return str;
        }
        catch (Throwable localThrowable)
        {
          ae.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "[-] Fail to get android id.", new Object[0]);
          AppMethodBeat.o(155703);
        }
        return "";
      }
    };
    gcN = new b(new d("h"))
    {
      final q.c gcS;
      
      final String aaS()
      {
        AppMethodBeat.i(155705);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(q.getAndroidId());
        Object localObject = this.gcS.vD(null);
        if (localObject == null)
        {
          localObject = q.cH(false);
          ae.w("MicroMsg.DeviceInfo", "[!] fail to fetch devId from deprecated cache, using getIMEI instead. value: %s", new Object[] { localObject });
        }
        for (boolean bool = false;; bool = true)
        {
          ae.i("MicroMsg.DeviceInfo", "[+] devId: %s, useDeprecatedDevId: %s", new Object[] { localObject, Boolean.valueOf(bool) });
          if (bool) {
            localStringBuilder.append((String)localObject);
          }
          for (;;)
          {
            localStringBuilder.append(q.aaG());
            localObject = localStringBuilder.toString();
            ae.i("MicroMsg.DeviceInfo", "[+] new mmguid, dev:%s", new Object[] { localObject });
            localObject = "A" + g.getMessageDigest(((String)localObject).getBytes()).substring(0, 15);
            AppMethodBeat.o(155705);
            return localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localStringBuilder.append(("A" + (String)localObject + "123456789ABCDEF").substring(0, 15));
            }
            else
            {
              localObject = new Random();
              ((Random)localObject).setSeed(System.currentTimeMillis());
              localStringBuilder.append("A");
              int i = 0;
              while (i < 15)
              {
                localStringBuilder.append((char)(((Random)localObject).nextInt(25) + 65));
                i += 1;
              }
              if (!this.gcS.gcX.gcq) {
                r.ls(28);
              }
            }
          }
        }
      }
    };
    gcO = new b(new d("i"))
    {
      final String aaS()
      {
        AppMethodBeat.i(155687);
        if (Build.VERSION.SDK_INT < 14)
        {
          str = Build.RADIO;
          AppMethodBeat.o(155687);
          return str;
        }
        String str = Build.getRadioVersion();
        AppMethodBeat.o(155687);
        return str;
      }
    };
    gcP = new b(new d("j")
    {
      final void aaR()
      {
        AppMethodBeat.i(155688);
        r.ls(9);
        AppMethodBeat.o(155688);
      }
      
      final void cI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155689);
        if (paramAnonymousBoolean) {
          r.ls(7);
        }
        AppMethodBeat.o(155689);
      }
    })
    {
      final String aaS()
      {
        AppMethodBeat.i(155690);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(q.getAndroidId()).append('#').append(q.aaG()).append('#').append(System.currentTimeMillis()).append('#').append(SystemClock.elapsedRealtimeNanos());
        localObject = UUID.nameUUIDFromBytes(((StringBuilder)localObject).toString().getBytes(Charset.forName("UTF-8"))).toString();
        AppMethodBeat.o(155690);
        return localObject;
      }
      
      final void aaT()
      {
        AppMethodBeat.i(155691);
        r.ls(8);
        AppMethodBeat.o(155691);
      }
    };
    AppMethodBeat.o(155741);
  }
  
  public static String aaA()
  {
    AppMethodBeat.i(155721);
    String str = cH(true);
    AppMethodBeat.o(155721);
    return str;
  }
  
  public static String aaB()
  {
    AppMethodBeat.i(155722);
    Object localObject = (TelephonyManager)ak.getContext().getSystemService("phone");
    try
    {
      ae.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSubscriberId, %s", new Object[] { bu.fpN() });
      localObject = bu.nullAsNil(((TelephonyManager)localObject).getSubscriberId());
      AppMethodBeat.o(155722);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getIMSI", new Object[0]);
      AppMethodBeat.o(155722);
    }
    return "";
  }
  
  public static String aaC()
  {
    AppMethodBeat.i(155723);
    String str = bu.nullAsNil(gcI.get());
    AppMethodBeat.o(155723);
    return str;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String aaD()
  {
    AppMethodBeat.i(155724);
    Object localObject = (TelephonyManager)ak.getContext().getSystemService("phone");
    if (localObject != null) {}
    try
    {
      ae.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSimSerialNumber", new Object[] { bu.fpN() });
      localObject = bu.nullAsNil(((TelephonyManager)localObject).getSimSerialNumber());
      AppMethodBeat.o(155724);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getICCID", new Object[0]);
      AppMethodBeat.o(155724);
    }
    AppMethodBeat.o(155724);
    return "";
    return "";
  }
  
  public static String aaE()
  {
    AppMethodBeat.i(155727);
    String str = bu.nullAsNil(gcJ.get());
    AppMethodBeat.o(155727);
    return str;
  }
  
  public static String aaF()
  {
    AppMethodBeat.i(155728);
    String str = bu.nullAsNil(gcK.get());
    AppMethodBeat.o(155728);
    return str;
  }
  
  public static String aaG()
  {
    AppMethodBeat.i(155729);
    String str = bu.nullAsNil(gcL.get());
    AppMethodBeat.o(155729);
    return str;
  }
  
  public static String aaH()
  {
    AppMethodBeat.i(155731);
    String str = bu.nullAsNil(gcN.get());
    AppMethodBeat.o(155731);
    return str;
  }
  
  public static void aaI()
  {
    AppMethodBeat.i(155732);
    ae.w("MicroMsg.DeviceInfo", "[!] MMGUID refreshed, old: %s, new: %s", new Object[] { gcN.get(), gcN.aaV() });
    AppMethodBeat.o(155732);
  }
  
  public static boolean aaJ()
  {
    return true;
  }
  
  public static String aaK()
  {
    AppMethodBeat.i(155733);
    String str = bu.nullAsNil(gcP.get());
    AppMethodBeat.o(155733);
    return str;
  }
  
  public static String aaL()
  {
    AppMethodBeat.i(155734);
    String str = bu.nullAsNil(b.wJt.aaL());
    AppMethodBeat.o(155734);
    return str;
  }
  
  public static String aaM()
  {
    AppMethodBeat.i(155735);
    String str = "android-" + Build.MODEL + "-" + Build.VERSION.SDK_INT;
    AppMethodBeat.o(155735);
    return str;
  }
  
  public static String aaN()
  {
    AppMethodBeat.i(155736);
    String str = bu.nullAsNil(gcO.get());
    AppMethodBeat.o(155736);
    return str;
  }
  
  /* Error */
  public static String[] aaO()
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_0
    //   2: ldc_w 258
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 260	java/io/BufferedReader
    //   11: dup
    //   12: new 262	java/io/InputStreamReader
    //   15: dup
    //   16: ldc_w 264
    //   19: invokestatic 270	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: ldc_w 272
    //   25: invokespecial 275	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   28: invokespecial 278	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: new 226	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 283	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: ldc_w 285
    //   51: invokevirtual 291	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   54: astore 4
    //   56: aload_2
    //   57: astore_1
    //   58: iload_0
    //   59: aload 4
    //   61: arraylength
    //   62: if_icmpge +26 -> 88
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: aload 4
    //   70: iload_0
    //   71: aaload
    //   72: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: bipush 32
    //   77: invokevirtual 294	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: iload_0
    //   82: iconst_1
    //   83: iadd
    //   84: istore_0
    //   85: goto -29 -> 56
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: aload_2
    //   98: invokevirtual 283	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: ldc_w 285
    //   104: invokevirtual 291	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   107: iconst_2
    //   108: aaload
    //   109: astore 4
    //   111: aload_2
    //   112: invokestatic 297	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   115: ldc_w 258
    //   118: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_2
    //   122: anewarray 287	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: aload_3
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload 4
    //   133: aastore
    //   134: areturn
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: ldc 144
    //   142: aload_3
    //   143: ldc_w 299
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: invokestatic 297	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   157: ldc_w 258
    //   160: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: iconst_2
    //   164: anewarray 287	java/lang/String
    //   167: dup
    //   168: iconst_0
    //   169: ldc 172
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: ldc_w 301
    //   177: aastore
    //   178: areturn
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: invokestatic 297	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   186: ldc_w 258
    //   189: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_2
    //   193: athrow
    //   194: astore_2
    //   195: goto -13 -> 182
    //   198: astore_3
    //   199: goto -61 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	84	0	i	int
    //   33	150	1	localBufferedReader1	java.io.BufferedReader
    //   31	123	2	localBufferedReader2	java.io.BufferedReader
    //   179	14	2	localObject1	Object
    //   194	1	2	localObject2	Object
    //   41	87	3	localObject3	Object
    //   135	8	3	localThrowable1	Throwable
    //   198	1	3	localThrowable2	Throwable
    //   54	78	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	32	135	java/lang/Throwable
    //   8	32	179	finally
    //   34	42	194	finally
    //   44	56	194	finally
    //   58	65	194	finally
    //   67	81	194	finally
    //   90	95	194	finally
    //   97	111	194	finally
    //   140	153	194	finally
    //   34	42	198	java/lang/Throwable
    //   44	56	198	java/lang/Throwable
    //   58	65	198	java/lang/Throwable
    //   67	81	198	java/lang/Throwable
    //   90	95	198	java/lang/Throwable
    //   97	111	198	java/lang/Throwable
  }
  
  /* Error */
  public static java.util.Map<String, String> aaP()
  {
    // Byte code:
    //   0: ldc_w 304
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 306	java/util/HashMap
    //   9: dup
    //   10: invokespecial 307	java/util/HashMap:<init>	()V
    //   13: astore_3
    //   14: new 260	java/io/BufferedReader
    //   17: dup
    //   18: new 262	java/io/InputStreamReader
    //   21: dup
    //   22: ldc_w 264
    //   25: invokestatic 270	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: ldc_w 272
    //   31: invokespecial 275	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: invokespecial 278	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 283	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +96 -> 142
    //   49: aload_1
    //   50: astore_0
    //   51: aload_2
    //   52: invokevirtual 310	java/lang/String:trim	()Ljava/lang/String;
    //   55: invokevirtual 313	java/lang/String:isEmpty	()Z
    //   58: ifne -20 -> 38
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: ldc_w 315
    //   67: invokevirtual 291	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore_2
    //   71: aload_1
    //   72: astore_0
    //   73: aload_2
    //   74: arraylength
    //   75: iconst_1
    //   76: if_icmple -38 -> 38
    //   79: aload_1
    //   80: astore_0
    //   81: aload_3
    //   82: aload_2
    //   83: iconst_0
    //   84: aaload
    //   85: invokevirtual 310	java/lang/String:trim	()Ljava/lang/String;
    //   88: invokevirtual 318	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   91: aload_2
    //   92: iconst_1
    //   93: aaload
    //   94: invokevirtual 310	java/lang/String:trim	()Ljava/lang/String;
    //   97: invokeinterface 324 3 0
    //   102: pop
    //   103: goto -65 -> 38
    //   106: astore_2
    //   107: aload_1
    //   108: astore_0
    //   109: ldc 144
    //   111: aload_2
    //   112: ldc_w 326
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_1
    //   123: astore_0
    //   124: aload_3
    //   125: invokeinterface 329 1 0
    //   130: aload_1
    //   131: invokestatic 297	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   134: ldc_w 304
    //   137: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_3
    //   141: areturn
    //   142: aload_1
    //   143: invokestatic 297	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   146: goto -12 -> 134
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_0
    //   152: aload_0
    //   153: invokestatic 297	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   156: ldc_w 304
    //   159: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: goto -13 -> 152
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: goto -64 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	114	0	localBufferedReader1	java.io.BufferedReader
    //   37	106	1	localBufferedReader2	java.io.BufferedReader
    //   149	14	1	localObject1	Object
    //   164	1	1	localObject2	Object
    //   170	1	1	localObject3	Object
    //   44	48	2	localObject4	Object
    //   106	6	2	localThrowable1	Throwable
    //   168	1	2	localThrowable2	Throwable
    //   13	128	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   40	45	106	java/lang/Throwable
    //   51	61	106	java/lang/Throwable
    //   63	71	106	java/lang/Throwable
    //   73	79	106	java/lang/Throwable
    //   81	103	106	java/lang/Throwable
    //   14	38	149	finally
    //   40	45	164	finally
    //   51	61	164	finally
    //   63	71	164	finally
    //   73	79	164	finally
    //   81	103	164	finally
    //   109	122	164	finally
    //   124	130	164	finally
    //   14	38	168	java/lang/Throwable
  }
  
  public static int aaQ()
  {
    AppMethodBeat.i(155739);
    try
    {
      Pattern localPattern = Pattern.compile("cpu[0-9]+");
      k[] arrayOfk = new k("/sys/devices/system/cpu").fTj();
      int m = arrayOfk.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        boolean bool = localPattern.matcher(arrayOfk[i].getName()).matches();
        k = j;
        if (bool) {
          k = j + 1;
        }
        i += 1;
      }
      AppMethodBeat.o(155739);
      return j;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(155739);
    }
    return 1;
  }
  
  public static void aaz()
  {
    AppMethodBeat.i(155719);
    gcH.get();
    gcI.get();
    gcP.get();
    AppMethodBeat.o(155719);
  }
  
  public static String bY(Context paramContext)
  {
    AppMethodBeat.i(155725);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = bu.nullAsNil(paramContext.getSimOperatorName());
        AppMethodBeat.o(155725);
        return paramContext;
      }
      AppMethodBeat.o(155725);
      return "";
    }
    catch (Throwable paramContext)
    {
      ae.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "getMobileSPType", new Object[0]);
      AppMethodBeat.o(155725);
    }
    return "";
  }
  
  public static String cH(boolean paramBoolean)
  {
    AppMethodBeat.i(155720);
    String str = gcH.get();
    if (!bu.isNullOrNil(str))
    {
      AppMethodBeat.o(155720);
      return str;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(155720);
      return "1234567890ABCDEF";
    }
    AppMethodBeat.o(155720);
    return "";
  }
  
  public static String getAndroidId()
  {
    AppMethodBeat.i(155730);
    String str = bu.nullAsNil(gcM.get());
    AppMethodBeat.o(155730);
    return str;
  }
  
  public static String getSimCountryIso()
  {
    AppMethodBeat.i(155726);
    try
    {
      Object localObject = (TelephonyManager)ak.getContext().getSystemService("phone");
      if (localObject != null)
      {
        localObject = bu.nullAsNil(((TelephonyManager)localObject).getSimCountryIso());
        AppMethodBeat.o(155726);
        return localObject;
      }
      AppMethodBeat.o(155726);
      return "";
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getSimCountryIso", new Object[0]);
      AppMethodBeat.o(155726);
    }
    return "";
  }
  
  public static boolean is64BitRuntime()
  {
    AppMethodBeat.i(155740);
    String str = Build.CPU_ABI;
    if (("arm64-v8a".equalsIgnoreCase(str)) || ("x86_64".equalsIgnoreCase(str)) || ("mips64".equalsIgnoreCase(str)))
    {
      AppMethodBeat.o(155740);
      return true;
    }
    AppMethodBeat.o(155740);
    return false;
  }
  
  static abstract class a
  {
    private boolean gcT = false;
    private boolean gcU = false;
    private final byte[] gcV = new byte[0];
    private String mValue = null;
    
    protected abstract String aaU();
    
    final String vD(String paramString)
    {
      synchronized (this.gcV)
      {
        if (this.gcT)
        {
          paramString = this.mValue;
          return paramString;
        }
        this.mValue = aaU();
        if (this.mValue != null)
        {
          this.gcT = true;
          paramString = this.mValue;
          return paramString;
        }
      }
      return paramString;
    }
    
    final void vE(String paramString)
    {
      synchronized (this.gcV)
      {
        if ((this.gcT) && (TextUtils.equals(this.mValue, paramString))) {
          return;
        }
        this.mValue = paramString;
        this.gcT = true;
        this.gcU = true;
        vF(paramString);
        return;
      }
    }
    
    protected abstract void vF(String paramString);
  }
  
  static abstract class b
  {
    private final q.a gcW;
    
    b(q.a parama)
    {
      this.gcW = parama;
    }
    
    abstract String aaS();
    
    void aaT() {}
    
    final String aaV()
    {
      String str = aaS();
      if (!TextUtils.isEmpty(str)) {
        this.gcW.vE(str);
      }
      return str;
    }
    
    final String get()
    {
      String str = this.gcW.vD(null);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      aaT();
      return aaV();
    }
  }
  
  static final class c
    extends q.a
  {
    final l gcX;
    private final int mType;
    
    c(int paramInt)
    {
      super();
      AppMethodBeat.i(155706);
      this.gcX = l.aam();
      this.mType = paramInt;
      AppMethodBeat.o(155706);
    }
    
    protected final String aaU()
    {
      AppMethodBeat.i(155707);
      String str = (String)this.gcX.get(this.mType);
      if ((str == null) && (!this.gcX.gcq)) {
        switch (this.mType)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(155707);
        return str;
        r.ls(27);
        continue;
        r.ls(26);
        continue;
        r.ls(25);
      }
    }
    
    protected final void vF(String paramString)
    {
      AppMethodBeat.i(155708);
      this.gcX.set(this.mType, paramString);
      AppMethodBeat.o(155708);
    }
  }
  
  static class d
    extends q.a
  {
    private static final Set<String> gcY;
    private final String gcZ;
    private final int gda;
    private final k gdb;
    private final q.e gdc;
    private final boolean gdd;
    
    static
    {
      AppMethodBeat.i(155714);
      gcY = new HashSet();
      AppMethodBeat.o(155714);
    }
    
    d(String paramString)
    {
      super();
      AppMethodBeat.i(155709);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        paramString = new IllegalArgumentException("id is null or empty.");
        AppMethodBeat.o(155709);
        throw paramString;
      }
      if (gcY.contains(paramString))
      {
        paramString = new IllegalArgumentException("name: " + paramString + " is duplicated.");
        AppMethodBeat.o(155709);
        throw paramString;
      }
      gcY.add(paramString);
      this.gcZ = UUID.nameUUIDFromBytes(paramString.getBytes(Charset.forName("UTF-8"))).toString();
      this.gda = 5;
      this.gdc = new q.e(paramString);
      for (;;)
      {
        try
        {
          this.gdc.lock();
          this.gdb = new k(ak.getContext().getFilesDir().getParentFile(), ".auth_cache/" + this.gcZ);
          if (this.gdb.exists()) {
            this.gdd = false;
          }
        }
        finally
        {
          this.gdc.unlock();
          AppMethodBeat.o(155709);
        }
        try
        {
          this.gdc.unlock();
          return;
        }
        finally
        {
          AppMethodBeat.o(155709);
        }
        this.gdd = true;
        if (!this.gdb.mkdirs()) {
          ae.e("MicroMsg.DeviceInfo", "[-] Fail to make base dir: %s", new Object[] { w.B(this.gdb.fTh()) });
        }
      }
    }
    
    /* Error */
    private static boolean c(k paramk, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 4
      //   5: ldc 176
      //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: aload_1
      //   11: ifnonnull +32 -> 43
      //   14: aload_3
      //   15: astore_2
      //   16: aload_0
      //   17: invokevirtual 141	com/tencent/mm/vfs/k:exists	()Z
      //   20: ifeq +103 -> 123
      //   23: aload_3
      //   24: astore_2
      //   25: new 178	java/io/PrintWriter
      //   28: dup
      //   29: new 180	com/tencent/mm/vfs/r
      //   32: dup
      //   33: aload_0
      //   34: invokespecial 183	com/tencent/mm/vfs/r:<init>	(Lcom/tencent/mm/vfs/k;)V
      //   37: invokespecial 186	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   40: invokevirtual 189	java/io/PrintWriter:close	()V
      //   43: aload_3
      //   44: astore_2
      //   45: new 178	java/io/PrintWriter
      //   48: dup
      //   49: new 180	com/tencent/mm/vfs/r
      //   52: dup
      //   53: aload_0
      //   54: invokespecial 183	com/tencent/mm/vfs/r:<init>	(Lcom/tencent/mm/vfs/k;)V
      //   57: invokespecial 186	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   60: astore_3
      //   61: new 191	java/util/zip/CRC32
      //   64: dup
      //   65: invokespecial 192	java/util/zip/CRC32:<init>	()V
      //   68: astore_2
      //   69: aload_2
      //   70: aload_1
      //   71: ldc 83
      //   73: invokestatic 89	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   76: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   79: invokevirtual 196	java/util/zip/CRC32:update	([B)V
      //   82: aload_3
      //   83: new 65	java/lang/StringBuilder
      //   86: dup
      //   87: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   90: aload_1
      //   91: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   94: ldc 199
      //   96: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: aload_2
      //   100: invokevirtual 203	java/util/zip/CRC32:getValue	()J
      //   103: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   106: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   109: invokevirtual 209	java/io/PrintWriter:print	(Ljava/lang/String;)V
      //   112: aload_3
      //   113: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   116: ldc 176
      //   118: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   121: iconst_1
      //   122: ireturn
      //   123: aconst_null
      //   124: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   127: ldc 176
      //   129: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   132: iconst_1
      //   133: ireturn
      //   134: astore_3
      //   135: aload 4
      //   137: astore_1
      //   138: aload_1
      //   139: astore_2
      //   140: ldc 151
      //   142: aload_3
      //   143: ldc 216
      //   145: iconst_1
      //   146: anewarray 155	java/lang/Object
      //   149: dup
      //   150: iconst_0
      //   151: aload_0
      //   152: invokevirtual 159	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
      //   155: invokestatic 165	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
      //   158: aastore
      //   159: invokestatic 220	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   162: aload_1
      //   163: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   166: ldc 176
      //   168: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   171: iconst_0
      //   172: ireturn
      //   173: astore_0
      //   174: aload_2
      //   175: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   178: ldc 176
      //   180: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   183: aload_0
      //   184: athrow
      //   185: astore_0
      //   186: aload_3
      //   187: astore_2
      //   188: goto -14 -> 174
      //   191: astore_2
      //   192: aload_3
      //   193: astore_1
      //   194: aload_2
      //   195: astore_3
      //   196: goto -58 -> 138
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	199	0	paramk	k
      //   0	199	1	paramString	String
      //   15	173	2	localObject1	Object
      //   191	4	2	localThrowable1	Throwable
      //   1	112	3	localPrintWriter	java.io.PrintWriter
      //   134	59	3	localThrowable2	Throwable
      //   195	1	3	localObject2	Object
      //   3	133	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   16	23	134	java/lang/Throwable
      //   25	43	134	java/lang/Throwable
      //   45	61	134	java/lang/Throwable
      //   16	23	173	finally
      //   25	43	173	finally
      //   45	61	173	finally
      //   140	162	173	finally
      //   61	112	185	finally
      //   61	112	191	java/lang/Throwable
    }
    
    /* Error */
    private static String d(k paramk)
    {
      // Byte code:
      //   0: ldc 222
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 224	com/tencent/mm/vfs/q
      //   8: dup
      //   9: aload_0
      //   10: invokespecial 225	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/k;)V
      //   13: astore_0
      //   14: new 227	java/io/BufferedReader
      //   17: dup
      //   18: aload_0
      //   19: invokespecial 230	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   22: astore 6
      //   24: aload_0
      //   25: astore_3
      //   26: aload 6
      //   28: astore_2
      //   29: aload 6
      //   31: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   34: astore 5
      //   36: aload_0
      //   37: astore_3
      //   38: aload 6
      //   40: astore_2
      //   41: aload 5
      //   43: bipush 44
      //   45: invokevirtual 237	java/lang/String:lastIndexOf	(I)I
      //   48: istore_1
      //   49: iload_1
      //   50: ifge +31 -> 81
      //   53: aload_0
      //   54: astore_3
      //   55: aload 6
      //   57: astore_2
      //   58: ldc 151
      //   60: ldc 239
      //   62: invokestatic 242	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   65: aload 6
      //   67: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   70: aload_0
      //   71: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   74: ldc 222
      //   76: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   79: aconst_null
      //   80: areturn
      //   81: aload_0
      //   82: astore_3
      //   83: aload 6
      //   85: astore_2
      //   86: aload 5
      //   88: iconst_0
      //   89: iload_1
      //   90: invokevirtual 246	java/lang/String:substring	(II)Ljava/lang/String;
      //   93: astore 4
      //   95: aload_0
      //   96: astore_3
      //   97: aload 6
      //   99: astore_2
      //   100: aload 5
      //   102: iload_1
      //   103: iconst_1
      //   104: iadd
      //   105: invokevirtual 249	java/lang/String:substring	(I)Ljava/lang/String;
      //   108: astore 5
      //   110: aload_0
      //   111: astore_3
      //   112: aload 6
      //   114: astore_2
      //   115: new 191	java/util/zip/CRC32
      //   118: dup
      //   119: invokespecial 192	java/util/zip/CRC32:<init>	()V
      //   122: astore 7
      //   124: aload_0
      //   125: astore_3
      //   126: aload 6
      //   128: astore_2
      //   129: aload 7
      //   131: aload 4
      //   133: ldc 83
      //   135: invokestatic 89	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   138: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   141: invokevirtual 196	java/util/zip/CRC32:update	([B)V
      //   144: aload_0
      //   145: astore_3
      //   146: aload 6
      //   148: astore_2
      //   149: aload 7
      //   151: invokevirtual 203	java/util/zip/CRC32:getValue	()J
      //   154: aload 5
      //   156: invokestatic 255	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   159: lcmp
      //   160: ifeq +32 -> 192
      //   163: aload_0
      //   164: astore_3
      //   165: aload 6
      //   167: astore_2
      //   168: ldc 151
      //   170: ldc_w 257
      //   173: invokestatic 242	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   176: aload 6
      //   178: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   181: aload_0
      //   182: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   185: ldc 222
      //   187: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   190: aconst_null
      //   191: areturn
      //   192: aload 6
      //   194: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   197: aload_0
      //   198: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   201: ldc 222
      //   203: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   206: aload 4
      //   208: areturn
      //   209: astore 4
      //   211: aconst_null
      //   212: astore 5
      //   214: aconst_null
      //   215: astore_0
      //   216: aload 5
      //   218: astore_3
      //   219: aload_0
      //   220: astore_2
      //   221: ldc 151
      //   223: aload 4
      //   225: ldc_w 259
      //   228: iconst_0
      //   229: anewarray 155	java/lang/Object
      //   232: invokestatic 220	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   235: aload_0
      //   236: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   239: aload 5
      //   241: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   244: ldc 222
      //   246: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   249: aconst_null
      //   250: areturn
      //   251: astore 4
      //   253: aconst_null
      //   254: astore_0
      //   255: aconst_null
      //   256: astore_2
      //   257: aload_2
      //   258: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   261: aload_0
      //   262: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
      //   265: ldc 222
      //   267: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   270: aload 4
      //   272: athrow
      //   273: astore 4
      //   275: aconst_null
      //   276: astore_2
      //   277: goto -20 -> 257
      //   280: astore 4
      //   282: aload_3
      //   283: astore_0
      //   284: goto -27 -> 257
      //   287: astore 4
      //   289: aconst_null
      //   290: astore_2
      //   291: aload_0
      //   292: astore 5
      //   294: aload_2
      //   295: astore_0
      //   296: goto -80 -> 216
      //   299: astore 4
      //   301: aload_0
      //   302: astore 5
      //   304: aload 6
      //   306: astore_0
      //   307: goto -91 -> 216
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	310	0	paramk	k
      //   48	57	1	i	int
      //   28	267	2	localObject1	Object
      //   25	258	3	localObject2	Object
      //   93	114	4	str	String
      //   209	15	4	localThrowable1	Throwable
      //   251	20	4	localObject3	Object
      //   273	1	4	localObject4	Object
      //   280	1	4	localObject5	Object
      //   287	1	4	localThrowable2	Throwable
      //   299	1	4	localThrowable3	Throwable
      //   34	269	5	localObject6	Object
      //   22	283	6	localBufferedReader	java.io.BufferedReader
      //   122	28	7	localCRC32	java.util.zip.CRC32
      // Exception table:
      //   from	to	target	type
      //   5	14	209	java/lang/Throwable
      //   5	14	251	finally
      //   14	24	273	finally
      //   29	36	280	finally
      //   41	49	280	finally
      //   58	65	280	finally
      //   86	95	280	finally
      //   100	110	280	finally
      //   115	124	280	finally
      //   129	144	280	finally
      //   149	163	280	finally
      //   168	176	280	finally
      //   221	235	280	finally
      //   14	24	287	java/lang/Throwable
      //   29	36	299	java/lang/Throwable
      //   41	49	299	java/lang/Throwable
      //   58	65	299	java/lang/Throwable
      //   86	95	299	java/lang/Throwable
      //   100	110	299	java/lang/Throwable
      //   115	124	299	java/lang/Throwable
      //   129	144	299	java/lang/Throwable
      //   149	163	299	java/lang/Throwable
      //   168	176	299	java/lang/Throwable
    }
    
    void aaR() {}
    
    public final String aaU()
    {
      label54:
      label183:
      try
      {
        AppMethodBeat.i(155710);
        try
        {
          this.gdc.lock();
          if (this.gdb.exists()) {
            break label54;
          }
          ae.e("MicroMsg.DeviceInfo", "[-] Base dir does not exist, base cache will return defValue.");
          this.gdc.unlock();
          AppMethodBeat.o(155710);
          localObject1 = null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject1;
            int k;
            int j;
            ae.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "[-] Exception occurred when fetch value, base cache will return defValue.", new Object[0]);
            this.gdc.unlock();
            AppMethodBeat.o(155710);
            localObject2 = null;
          }
        }
        finally
        {
          this.gdc.unlock();
          AppMethodBeat.o(155710);
        }
        return localObject1;
      }
      finally {}
      k = this.gda;
      int i = 0;
      j = 0;
      for (;;)
      {
        if (i < this.gda)
        {
          localObject1 = new k(this.gdb, String.valueOf(i));
          if (!((k)localObject1).exists())
          {
            k -= 1;
            break label249;
          }
          localObject1 = d((k)localObject1);
          if (localObject1 != null)
          {
            this.gdc.unlock();
            AppMethodBeat.o(155710);
            break;
          }
          j += 1;
          break label249;
        }
        if (j > 0) {
          if (j != k) {
            break label183;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          cI(bool);
          ae.w("MicroMsg.DeviceInfo", "[!] Cache missed, base cache will return defValue.");
          this.gdc.unlock();
          AppMethodBeat.o(155710);
          localObject1 = null;
          break;
        }
        Object localObject2;
        label249:
        i += 1;
      }
    }
    
    void cI(boolean paramBoolean) {}
    
    /* Error */
    public final void vF(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 285
      //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:gdc	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   12: invokevirtual 112	com/tencent/mm/compatible/deviceinfo/q$e:lock	()V
      //   15: aload_0
      //   16: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:gdb	Lcom/tencent/mm/vfs/k;
      //   19: invokevirtual 141	com/tencent/mm/vfs/k:exists	()Z
      //   22: ifne +31 -> 53
      //   25: ldc 151
      //   27: ldc_w 287
      //   30: invokestatic 242	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   33: aload_0
      //   34: invokevirtual 289	com/tencent/mm/compatible/deviceinfo/q$d:aaR	()V
      //   37: aload_0
      //   38: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:gdc	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   41: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   44: ldc_w 285
      //   47: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   50: aload_0
      //   51: monitorexit
      //   52: return
      //   53: iconst_0
      //   54: istore_2
      //   55: iconst_0
      //   56: istore_3
      //   57: iload_2
      //   58: aload_0
      //   59: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:gda	I
      //   62: if_icmpge +62 -> 124
      //   65: new 114	com/tencent/mm/vfs/k
      //   68: dup
      //   69: aload_0
      //   70: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:gdb	Lcom/tencent/mm/vfs/k;
      //   73: iload_2
      //   74: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   77: invokespecial 270	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/k;Ljava/lang/String;)V
      //   80: astore 5
      //   82: aload 5
      //   84: invokevirtual 292	com/tencent/mm/vfs/k:isDirectory	()Z
      //   87: ifeq +17 -> 104
      //   90: ldc 151
      //   92: ldc_w 294
      //   95: invokestatic 281	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   98: aload 5
      //   100: invokevirtual 297	com/tencent/mm/vfs/k:delete	()Z
      //   103: pop
      //   104: iload_3
      //   105: istore 4
      //   107: aload 5
      //   109: aload_1
      //   110: invokestatic 299	com/tencent/mm/compatible/deviceinfo/q$d:c	(Lcom/tencent/mm/vfs/k;Ljava/lang/String;)Z
      //   113: ifne +60 -> 173
      //   116: iload_3
      //   117: iconst_1
      //   118: iadd
      //   119: istore 4
      //   121: goto +52 -> 173
      //   124: iload_3
      //   125: aload_0
      //   126: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:gda	I
      //   129: if_icmpne +7 -> 136
      //   132: aload_0
      //   133: invokevirtual 289	com/tencent/mm/compatible/deviceinfo/q$d:aaR	()V
      //   136: aload_0
      //   137: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:gdc	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   140: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   143: ldc_w 285
      //   146: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: goto -99 -> 50
      //   152: astore_1
      //   153: aload_0
      //   154: monitorexit
      //   155: aload_1
      //   156: athrow
      //   157: astore_1
      //   158: aload_0
      //   159: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:gdc	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   162: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   165: ldc_w 285
      //   168: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   171: aload_1
      //   172: athrow
      //   173: iload_2
      //   174: iconst_1
      //   175: iadd
      //   176: istore_2
      //   177: iload 4
      //   179: istore_3
      //   180: goto -123 -> 57
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	183	0	this	d
      //   0	183	1	paramString	String
      //   54	123	2	i	int
      //   56	124	3	j	int
      //   105	73	4	k	int
      //   80	28	5	localk	k
      // Exception table:
      //   from	to	target	type
      //   2	8	152	finally
      //   37	50	152	finally
      //   136	149	152	finally
      //   158	173	152	finally
      //   8	37	157	finally
      //   57	104	157	finally
      //   107	116	157	finally
      //   124	136	157	finally
    }
  }
  
  static final class e
  {
    private volatile LocalServerSocket gde;
    private volatile int gdf;
    private final String mName;
    
    e(String paramString)
    {
      AppMethodBeat.i(155715);
      this.gde = null;
      this.gdf = 0;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new IllegalArgumentException("lockName is null or empty.");
        AppMethodBeat.o(155715);
        throw paramString;
      }
      try
      {
        this.mName = paramString;
        return;
      }
      finally
      {
        AppMethodBeat.o(155715);
      }
    }
    
    private boolean tryLock()
    {
      boolean bool = true;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(155716);
          LocalServerSocket localLocalServerSocket = this.gde;
          if (localLocalServerSocket == null)
          {
            try
            {
              this.gde = new LocalServerSocket(this.mName);
              this.gdf += 1;
              AppMethodBeat.o(155716);
            }
            catch (Throwable localThrowable)
            {
              this.gde = null;
              bool = false;
              AppMethodBeat.o(155716);
              continue;
            }
            return bool;
          }
        }
        finally {}
        this.gdf += 1;
        AppMethodBeat.o(155716);
      }
    }
    
    final void lock()
    {
      try
      {
        AppMethodBeat.i(155717);
        for (;;)
        {
          boolean bool = tryLock();
          if (bool) {
            break;
          }
          try
          {
            Thread.sleep(10L);
          }
          catch (Throwable localThrowable) {}
        }
        AppMethodBeat.o(155717);
        return;
      }
      finally {}
    }
    
    /* Error */
    final void unlock()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 69
      //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:gdf	I
      //   11: ifle +13 -> 24
      //   14: aload_0
      //   15: aload_0
      //   16: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:gdf	I
      //   19: iconst_1
      //   20: isub
      //   21: putfield 29	com/tencent/mm/compatible/deviceinfo/q$e:gdf	I
      //   24: aload_0
      //   25: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:gdf	I
      //   28: ifne +64 -> 92
      //   31: aload_0
      //   32: getfield 27	com/tencent/mm/compatible/deviceinfo/q$e:gde	Landroid/net/LocalServerSocket;
      //   35: astore_1
      //   36: aload_1
      //   37: ifnull +55 -> 92
      //   40: aload_0
      //   41: getfield 27	com/tencent/mm/compatible/deviceinfo/q$e:gde	Landroid/net/LocalServerSocket;
      //   44: invokevirtual 72	android/net/LocalServerSocket:close	()V
      //   47: aload_0
      //   48: aconst_null
      //   49: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:gde	Landroid/net/LocalServerSocket;
      //   52: ldc 69
      //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_0
      //   58: monitorexit
      //   59: return
      //   60: astore_1
      //   61: aload_0
      //   62: aconst_null
      //   63: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:gde	Landroid/net/LocalServerSocket;
      //   66: ldc 69
      //   68: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   71: goto -14 -> 57
      //   74: astore_1
      //   75: aload_0
      //   76: monitorexit
      //   77: aload_1
      //   78: athrow
      //   79: astore_1
      //   80: aload_0
      //   81: aconst_null
      //   82: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:gde	Landroid/net/LocalServerSocket;
      //   85: ldc 69
      //   87: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   90: aload_1
      //   91: athrow
      //   92: ldc 69
      //   94: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: goto -40 -> 57
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	100	0	this	e
      //   35	2	1	localLocalServerSocket	LocalServerSocket
      //   60	1	1	localThrowable	Throwable
      //   74	4	1	localObject1	Object
      //   79	12	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   40	47	60	java/lang/Throwable
      //   2	24	74	finally
      //   24	36	74	finally
      //   47	57	74	finally
      //   61	71	74	finally
      //   80	92	74	finally
      //   92	97	74	finally
      //   40	47	79	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.q
 * JD-Core Version:    0.7.0.1
 */