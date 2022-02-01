package com.tencent.mm.compatible.deviceinfo;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
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
  private static String ahVW;
  private static boolean lVM;
  private static final b lVN;
  private static final b lVO;
  private static final b lVP;
  private static final b lVQ;
  private static final b lVR;
  private static final b lVS;
  private static final b lVT;
  private static final b lVU;
  private static final b lVV;
  private static final b lVW;
  
  static
  {
    AppMethodBeat.i(155741);
    lVM = false;
    lVN = new b(new d("a")
    {
      final void aPr()
      {
        AppMethodBeat.i(155685);
        r.qS(4);
        AppMethodBeat.o(155685);
      }
      
      final void eE(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155686);
        if (paramAnonymousBoolean) {
          r.qS(2);
        }
        AppMethodBeat.o(155686);
      }
    })
    {
      final q.a lVX;
      
      final String aPs()
      {
        AppMethodBeat.i(155693);
        String str = this.lVX.Dr("1234567890ABCDEF");
        if (!"1234567890ABCDEF".equals(str))
        {
          r.qS(0);
          AppMethodBeat.o(155693);
          return str;
        }
        AppMethodBeat.o(155693);
        return null;
      }
      
      final void aPt()
      {
        AppMethodBeat.i(155694);
        r.qS(3);
        AppMethodBeat.o(155694);
      }
    };
    lVO = new b(new d("c"))
    {
      final String aPs()
      {
        AppMethodBeat.i(155695);
        Log.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSerial, %s", new Object[] { Util.getStack() });
        if (!q.lVM)
        {
          AppMethodBeat.o(155695);
          return null;
        }
        if (Build.VERSION.SDK_INT < 9)
        {
          AppMethodBeat.o(155695);
          return null;
        }
        if (Build.VERSION.SDK_INT < 26)
        {
          String str = Build.SERIAL;
          AppMethodBeat.o(155695);
          return str;
        }
        AppMethodBeat.o(155695);
        return "unknown";
      }
    };
    lVP = new b(new d("d"))
    {
      final String aPs()
      {
        AppMethodBeat.i(155696);
        AppMethodBeat.o(155696);
        return "02:00:00:00:00:00";
      }
    };
    lVQ = new b(new d("e"))
    {
      final String aPs()
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
    lVR = new b(new d("f")
    {
      final void aPr()
      {
        AppMethodBeat.i(155698);
        r.qS(14);
        AppMethodBeat.o(155698);
      }
      
      final void eE(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155699);
        if (paramAnonymousBoolean) {
          r.qS(12);
        }
        AppMethodBeat.o(155699);
      }
    })
    {
      final q.a lVY;
      
      final String aPs()
      {
        AppMethodBeat.i(155701);
        String str = this.lVY.Dr(null);
        if (str != null)
        {
          r.qS(10);
          AppMethodBeat.o(155701);
          return str;
        }
        str = Build.MANUFACTURER + q.aPo() + n.aOP();
        AppMethodBeat.o(155701);
        return str;
      }
      
      final void aPt()
      {
        AppMethodBeat.i(155702);
        r.qS(13);
        AppMethodBeat.o(155702);
      }
    };
    lVS = new b(new d("g"))
    {
      final String aPs()
      {
        AppMethodBeat.i(155703);
        if (!q.lVM)
        {
          AppMethodBeat.o(155703);
          return null;
        }
        try
        {
          Object localObject = MMApplicationContext.getContext().getContentResolver();
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG("android_id").cG(localObject);
          localObject = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/compatible/deviceinfo/DeviceInfo$8", "newValue", "()Ljava/lang/String;", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
          AppMethodBeat.o(155703);
          return localObject;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "[-] Fail to get android id.", new Object[0]);
          AppMethodBeat.o(155703);
        }
        return "";
      }
    };
    lVT = new b(new d("h"))
    {
      final q.c lVZ;
      
      final String aPs()
      {
        AppMethodBeat.i(155705);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(q.getAndroidId());
        Object localObject = this.lVZ.Dr(null);
        if (localObject == null)
        {
          localObject = q.eD(false);
          Log.w("MicroMsg.DeviceInfo", "[!] fail to fetch devId from deprecated cache, using getIMEI instead. value: %s", new Object[] { localObject });
        }
        for (boolean bool = false;; bool = true)
        {
          Log.i("MicroMsg.DeviceInfo", "[+] devId: %s, useDeprecatedDevId: %s", new Object[] { localObject, Boolean.valueOf(bool) });
          if (bool) {
            localStringBuilder.append((String)localObject);
          }
          for (;;)
          {
            localStringBuilder.append(q.aPf());
            localObject = localStringBuilder.toString();
            Log.i("MicroMsg.DeviceInfo", "[+] new mmguid, dev:%s", new Object[] { localObject });
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
              if (!this.lVZ.lWf.lVv) {
                r.qS(28);
              }
            }
          }
        }
      }
    };
    lVU = new b(new d("i"))
    {
      final String aPs()
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
    lVV = new b(new d("j")
    {
      final void aPr()
      {
        AppMethodBeat.i(155688);
        r.qS(9);
        AppMethodBeat.o(155688);
      }
      
      final void eE(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155689);
        if (paramAnonymousBoolean) {
          r.qS(7);
        }
        AppMethodBeat.o(155689);
      }
    })
    {
      final String aPs()
      {
        AppMethodBeat.i(155690);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(q.getAndroidId()).append('#').append(q.aPf()).append('#').append(System.currentTimeMillis()).append('#').append(SystemClock.elapsedRealtimeNanos());
        localObject = UUID.nameUUIDFromBytes(((StringBuilder)localObject).toString().getBytes(Charset.forName("UTF-8"))).toString();
        AppMethodBeat.o(155690);
        return localObject;
      }
      
      final void aPt()
      {
        AppMethodBeat.i(155691);
        r.qS(8);
        AppMethodBeat.o(155691);
      }
    };
    ahVW = null;
    lVW = new b(new d("k"))
    {
      final String aPs()
      {
        return Build.MODEL;
      }
    };
    AppMethodBeat.o(155741);
  }
  
  public static void aOW()
  {
    AppMethodBeat.i(240861);
    lVM = true;
    Log.i("MicroMsg.DeviceInfo", "allowGetSensitiveDataFromSys");
    AppMethodBeat.o(240861);
  }
  
  public static void aOX()
  {
    AppMethodBeat.i(155719);
    lVN.get();
    lVO.get();
    lVV.get();
    AppMethodBeat.o(155719);
  }
  
  public static String aOY()
  {
    AppMethodBeat.i(155721);
    String str = eD(true);
    AppMethodBeat.o(155721);
    return str;
  }
  
  public static String aOZ()
  {
    AppMethodBeat.i(155722);
    Object localObject = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    try
    {
      Log.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSubscriberId, %s", new Object[] { Util.getStack() });
      localObject = Util.nullAsNil((String)com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/compatible/deviceinfo/DeviceInfo", "getIMSI", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getSubscriberId", "()Ljava/lang/String;"));
      AppMethodBeat.o(155722);
      return localObject;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getIMSI", new Object[0]);
      AppMethodBeat.o(155722);
    }
    return "";
  }
  
  public static String aPa()
  {
    AppMethodBeat.i(155723);
    String str = Util.nullAsNil(lVO.get());
    AppMethodBeat.o(155723);
    return str;
  }
  
  @Deprecated
  public static String aPb()
  {
    AppMethodBeat.i(155724);
    AppMethodBeat.o(155724);
    return "";
  }
  
  public static String aPc()
  {
    AppMethodBeat.i(155726);
    try
    {
      Object localObject = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((TelephonyManager)localObject).getSimCountryIso());
        AppMethodBeat.o(155726);
        return localObject;
      }
      AppMethodBeat.o(155726);
      return "";
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getSimCountryIso", new Object[0]);
      AppMethodBeat.o(155726);
    }
    return "";
  }
  
  public static String aPd()
  {
    AppMethodBeat.i(155727);
    String str = Util.nullAsNil(lVP.get());
    AppMethodBeat.o(155727);
    return str;
  }
  
  public static String aPe()
  {
    AppMethodBeat.i(155728);
    AppMethodBeat.o(155728);
    return "";
  }
  
  public static String aPf()
  {
    AppMethodBeat.i(155729);
    String str = Util.nullAsNil(lVR.get());
    AppMethodBeat.o(155729);
    return str;
  }
  
  public static String aPg()
  {
    AppMethodBeat.i(155731);
    String str = Util.nullAsNil(lVT.get());
    AppMethodBeat.o(155731);
    return str;
  }
  
  public static void aPh()
  {
    AppMethodBeat.i(155732);
    Log.w("MicroMsg.DeviceInfo", "[!] MMGUID refreshed, old: %s, new: %s", new Object[] { lVT.get(), lVT.aPv() });
    AppMethodBeat.o(155732);
  }
  
  public static boolean aPi()
  {
    return true;
  }
  
  public static String aPj()
  {
    AppMethodBeat.i(155733);
    String str = Util.nullAsNil(lVV.get());
    AppMethodBeat.o(155733);
    return str;
  }
  
  public static String aPk()
  {
    AppMethodBeat.i(155734);
    String str = Util.nullAsNil(d.MtP.aPk());
    AppMethodBeat.o(155734);
    return str;
  }
  
  public static String aPl()
  {
    AppMethodBeat.i(155735);
    String str = "android-" + aPo() + "-" + Build.VERSION.SDK_INT;
    AppMethodBeat.o(155735);
    return str;
  }
  
  public static String aPm()
  {
    AppMethodBeat.i(155736);
    String str = Util.nullAsNil(lVU.get());
    AppMethodBeat.o(155736);
    return str;
  }
  
  /* Error */
  public static String[] aPn()
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_0
    //   2: ldc_w 285
    //   5: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 287	java/io/BufferedReader
    //   11: dup
    //   12: new 289	java/io/InputStreamReader
    //   15: dup
    //   16: ldc_w 291
    //   19: invokestatic 297	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: ldc_w 299
    //   25: invokespecial 302	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   28: invokespecial 305	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: new 256	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   39: astore_2
    //   40: aload_1
    //   41: invokevirtual 310	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: ldc_w 312
    //   47: invokevirtual 316	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   50: astore_3
    //   51: iload_0
    //   52: aload_3
    //   53: arraylength
    //   54: if_icmpge +23 -> 77
    //   57: aload_2
    //   58: aload_3
    //   59: iload_0
    //   60: aaload
    //   61: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: bipush 32
    //   66: invokevirtual 319	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: iload_0
    //   71: iconst_1
    //   72: iadd
    //   73: istore_0
    //   74: goto -23 -> 51
    //   77: aload_2
    //   78: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_2
    //   82: aload_1
    //   83: invokevirtual 310	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: ldc_w 312
    //   89: invokevirtual 316	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   92: iconst_2
    //   93: aaload
    //   94: astore_3
    //   95: aload_1
    //   96: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   99: ldc_w 285
    //   102: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: iconst_2
    //   106: anewarray 198	java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: aload_2
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload_3
    //   116: aastore
    //   117: areturn
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: ldc 135
    //   123: aload_2
    //   124: ldc_w 325
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload_1
    //   135: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   138: ldc_w 285
    //   141: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iconst_2
    //   145: anewarray 198	java/lang/String
    //   148: dup
    //   149: iconst_0
    //   150: ldc 208
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: ldc_w 327
    //   158: aastore
    //   159: areturn
    //   160: astore_2
    //   161: aload_1
    //   162: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   165: ldc_w 285
    //   168: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: athrow
    //   173: astore_2
    //   174: goto -53 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	73	0	i	int
    //   31	131	1	localBufferedReader	java.io.BufferedReader
    //   39	73	2	localObject1	Object
    //   118	6	2	localThrowable	Throwable
    //   160	12	2	localObject2	Object
    //   173	1	2	localObject3	Object
    //   50	66	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	32	118	finally
    //   121	134	160	finally
    //   32	51	173	finally
    //   51	70	173	finally
    //   77	95	173	finally
  }
  
  public static final String aPo()
  {
    AppMethodBeat.i(240879);
    if (ahVW == null) {
      ahVW = Build.MODEL;
    }
    String str = ahVW;
    AppMethodBeat.o(240879);
    return str;
  }
  
  /* Error */
  public static java.util.Map<String, String> aPp()
  {
    // Byte code:
    //   0: ldc_w 336
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 338	java/util/HashMap
    //   9: dup
    //   10: invokespecial 339	java/util/HashMap:<init>	()V
    //   13: astore_2
    //   14: new 287	java/io/BufferedReader
    //   17: dup
    //   18: new 289	java/io/InputStreamReader
    //   21: dup
    //   22: ldc_w 291
    //   25: invokestatic 297	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: ldc_w 299
    //   31: invokespecial 302	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: invokespecial 305	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 310	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +84 -> 128
    //   47: aload_1
    //   48: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   51: invokevirtual 345	java/lang/String:isEmpty	()Z
    //   54: ifne -16 -> 38
    //   57: aload_1
    //   58: ldc_w 347
    //   61: invokevirtual 316	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: arraylength
    //   67: iconst_1
    //   68: if_icmple -30 -> 38
    //   71: aload_2
    //   72: aload_1
    //   73: iconst_0
    //   74: aaload
    //   75: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   78: invokevirtual 350	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   81: aload_1
    //   82: iconst_1
    //   83: aaload
    //   84: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   87: invokeinterface 356 3 0
    //   92: pop
    //   93: goto -55 -> 38
    //   96: astore_1
    //   97: ldc 135
    //   99: aload_1
    //   100: ldc_w 358
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_2
    //   111: invokeinterface 361 1 0
    //   116: aload_0
    //   117: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   120: ldc_w 336
    //   123: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_2
    //   127: areturn
    //   128: aload_0
    //   129: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   132: goto -12 -> 120
    //   135: astore_1
    //   136: aload_0
    //   137: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   140: ldc_w 336
    //   143: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: goto -54 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	114	0	localBufferedReader	java.io.BufferedReader
    //   42	40	1	localObject1	Object
    //   96	4	1	localThrowable	Throwable
    //   135	12	1	localObject2	Object
    //   148	1	1	localObject3	Object
    //   13	114	2	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   38	43	96	finally
    //   47	93	96	finally
    //   97	116	135	finally
    //   14	38	148	finally
  }
  
  public static int aPq()
  {
    AppMethodBeat.i(155739);
    try
    {
      Pattern localPattern = Pattern.compile("cpu[0-9]+");
      u[] arrayOfu = new u("/sys/devices/system/cpu").jKX();
      int m = arrayOfu.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        boolean bool = localPattern.matcher(arrayOfu[i].getName()).matches();
        k = j;
        if (bool) {
          k = j + 1;
        }
        i += 1;
      }
      return j;
    }
    finally
    {
      AppMethodBeat.o(155739);
    }
    return 1;
  }
  
  public static boolean awm()
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
  
  public static String dd(Context paramContext)
  {
    AppMethodBeat.i(155725);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = Util.nullAsNil(paramContext.getSimOperatorName());
        AppMethodBeat.o(155725);
        return paramContext;
      }
      AppMethodBeat.o(155725);
      return "";
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "getMobileSPType", new Object[0]);
      AppMethodBeat.o(155725);
    }
    return "";
  }
  
  public static String eD(boolean paramBoolean)
  {
    AppMethodBeat.i(155720);
    String str = lVN.get();
    if (!Util.isNullOrNil(str))
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
    String str = Util.nullAsNil(lVS.get());
    AppMethodBeat.o(155730);
    return str;
  }
  
  static abstract class a
  {
    private boolean lWa = false;
    private boolean lWb = false;
    private String lWc = null;
    private final byte[] lWd = new byte[0];
    
    final String Dr(String paramString)
    {
      synchronized (this.lWd)
      {
        if (this.lWa)
        {
          paramString = this.lWc;
          return paramString;
        }
        this.lWc = aPu();
        if (this.lWc != null)
        {
          this.lWa = true;
          paramString = this.lWc;
          return paramString;
        }
      }
      return paramString;
    }
    
    final void Ds(String paramString)
    {
      synchronized (this.lWd)
      {
        if ((this.lWa) && (TextUtils.equals(this.lWc, paramString))) {
          return;
        }
        this.lWc = paramString;
        this.lWa = true;
        this.lWb = true;
        Dt(paramString);
        return;
      }
    }
    
    protected abstract void Dt(String paramString);
    
    protected abstract String aPu();
  }
  
  static abstract class b
  {
    private final q.a lWe;
    
    b(q.a parama)
    {
      this.lWe = parama;
    }
    
    abstract String aPs();
    
    void aPt() {}
    
    final String aPv()
    {
      String str = aPs();
      if (!TextUtils.isEmpty(str)) {
        this.lWe.Ds(str);
      }
      return str;
    }
    
    final String get()
    {
      String str = this.lWe.Dr(null);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      aPt();
      return aPv();
    }
  }
  
  static final class c
    extends q.a
  {
    final l lWf;
    private final int mType;
    
    c(int paramInt)
    {
      super();
      AppMethodBeat.i(155706);
      this.lWf = l.aOI();
      this.mType = paramInt;
      AppMethodBeat.o(155706);
    }
    
    protected final void Dt(String paramString)
    {
      AppMethodBeat.i(155708);
      this.lWf.B(this.mType, paramString);
      AppMethodBeat.o(155708);
    }
    
    protected final String aPu()
    {
      AppMethodBeat.i(155707);
      String str = (String)this.lWf.get(this.mType);
      if ((str == null) && (!this.lWf.lVv)) {
        switch (this.mType)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(155707);
        return str;
        r.qS(27);
        continue;
        r.qS(26);
        continue;
        r.qS(25);
      }
    }
  }
  
  static class d
    extends q.a
  {
    private static final Set<String> lWg;
    private final String lWh;
    private final int lWi;
    private final u lWj;
    private final q.e lWk;
    private final boolean lWl;
    
    static
    {
      AppMethodBeat.i(155714);
      lWg = new HashSet();
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
      if (lWg.contains(paramString))
      {
        paramString = new IllegalArgumentException("name: " + paramString + " is duplicated.");
        AppMethodBeat.o(155709);
        throw paramString;
      }
      lWg.add(paramString);
      this.lWh = UUID.nameUUIDFromBytes(paramString.getBytes(Charset.forName("UTF-8"))).toString();
      this.lWi = 5;
      this.lWk = new q.e(paramString);
      for (;;)
      {
        try
        {
          this.lWk.lock();
          this.lWj = new u(MMApplicationContext.getContext().getFilesDir().getParentFile(), ".auth_cache/" + this.lWh);
          if (this.lWj.jKS()) {
            this.lWl = false;
          }
        }
        finally
        {
          this.lWk.unlock();
          AppMethodBeat.o(155709);
        }
        try
        {
          this.lWk.unlock();
          return;
        }
        finally
        {
          AppMethodBeat.o(155709);
        }
        this.lWl = true;
        if (!this.lWj.jKY()) {
          Log.e("MicroMsg.DeviceInfo", "[-] Fail to make base dir: %s", new Object[] { ah.v(this.lWj.jKT()) });
        }
      }
    }
    
    /* Error */
    private static boolean b(u paramu, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: ldc 174
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_1
      //   8: ifnonnull +28 -> 36
      //   11: aload_0
      //   12: invokevirtual 141	com/tencent/mm/vfs/u:jKS	()Z
      //   15: ifeq +99 -> 114
      //   18: new 176	java/io/PrintWriter
      //   21: dup
      //   22: new 178	com/tencent/mm/vfs/ac
      //   25: dup
      //   26: aload_0
      //   27: invokespecial 181	com/tencent/mm/vfs/ac:<init>	(Lcom/tencent/mm/vfs/u;)V
      //   30: invokespecial 184	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   33: invokevirtual 187	java/io/PrintWriter:close	()V
      //   36: new 176	java/io/PrintWriter
      //   39: dup
      //   40: new 178	com/tencent/mm/vfs/ac
      //   43: dup
      //   44: aload_0
      //   45: invokespecial 181	com/tencent/mm/vfs/ac:<init>	(Lcom/tencent/mm/vfs/u;)V
      //   48: invokespecial 184	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   51: astore_2
      //   52: new 189	java/util/zip/CRC32
      //   55: dup
      //   56: invokespecial 190	java/util/zip/CRC32:<init>	()V
      //   59: astore_3
      //   60: aload_3
      //   61: aload_1
      //   62: ldc 83
      //   64: invokestatic 89	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   67: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   70: invokevirtual 194	java/util/zip/CRC32:update	([B)V
      //   73: aload_2
      //   74: new 65	java/lang/StringBuilder
      //   77: dup
      //   78: invokespecial 195	java/lang/StringBuilder:<init>	()V
      //   81: aload_1
      //   82: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: ldc 197
      //   87: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: aload_3
      //   91: invokevirtual 201	java/util/zip/CRC32:getValue	()J
      //   94: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   97: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   100: invokevirtual 207	java/io/PrintWriter:print	(Ljava/lang/String;)V
      //   103: aload_2
      //   104: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   107: ldc 174
      //   109: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: iconst_1
      //   113: ireturn
      //   114: aconst_null
      //   115: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   118: ldc 174
      //   120: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   123: iconst_1
      //   124: ireturn
      //   125: astore_2
      //   126: aload_3
      //   127: astore_1
      //   128: ldc 151
      //   130: aload_2
      //   131: ldc 215
      //   133: iconst_1
      //   134: anewarray 155	java/lang/Object
      //   137: dup
      //   138: iconst_0
      //   139: aload_0
      //   140: invokevirtual 159	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
      //   143: invokestatic 165	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
      //   146: aastore
      //   147: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   150: aload_1
      //   151: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   154: ldc 174
      //   156: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: iconst_0
      //   160: ireturn
      //   161: astore_0
      //   162: aload_1
      //   163: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   166: ldc 174
      //   168: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   171: aload_0
      //   172: athrow
      //   173: astore_3
      //   174: aload_2
      //   175: astore_1
      //   176: aload_3
      //   177: astore_2
      //   178: goto -50 -> 128
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	181	0	paramu	u
      //   0	181	1	paramString	String
      //   51	53	2	localPrintWriter	java.io.PrintWriter
      //   125	50	2	localThrowable	Throwable
      //   177	1	2	localObject1	Object
      //   1	126	3	localCRC32	java.util.zip.CRC32
      //   173	4	3	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   11	36	125	finally
      //   36	52	125	finally
      //   128	150	161	finally
      //   52	103	173	finally
    }
    
    /* Error */
    private static String c(u paramu)
    {
      // Byte code:
      //   0: ldc 222
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 224	com/tencent/mm/vfs/ab
      //   8: dup
      //   9: aload_0
      //   10: invokespecial 225	com/tencent/mm/vfs/ab:<init>	(Lcom/tencent/mm/vfs/u;)V
      //   13: astore_3
      //   14: new 227	java/io/BufferedReader
      //   17: dup
      //   18: aload_3
      //   19: invokespecial 230	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   22: astore_2
      //   23: aload_2
      //   24: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   27: astore 4
      //   29: aload 4
      //   31: bipush 44
      //   33: invokevirtual 237	java/lang/String:lastIndexOf	(I)I
      //   36: istore_1
      //   37: iload_1
      //   38: ifge +25 -> 63
      //   41: ldc 151
      //   43: ldc 239
      //   45: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   48: aload_2
      //   49: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   52: aload_3
      //   53: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   56: ldc 222
      //   58: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   61: aconst_null
      //   62: areturn
      //   63: aload 4
      //   65: iconst_0
      //   66: iload_1
      //   67: invokevirtual 246	java/lang/String:substring	(II)Ljava/lang/String;
      //   70: astore_0
      //   71: aload 4
      //   73: iload_1
      //   74: iconst_1
      //   75: iadd
      //   76: invokevirtual 249	java/lang/String:substring	(I)Ljava/lang/String;
      //   79: astore 4
      //   81: new 189	java/util/zip/CRC32
      //   84: dup
      //   85: invokespecial 190	java/util/zip/CRC32:<init>	()V
      //   88: astore 5
      //   90: aload 5
      //   92: aload_0
      //   93: ldc 83
      //   95: invokestatic 89	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   98: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   101: invokevirtual 194	java/util/zip/CRC32:update	([B)V
      //   104: aload 5
      //   106: invokevirtual 201	java/util/zip/CRC32:getValue	()J
      //   109: aload 4
      //   111: invokestatic 255	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   114: lcmp
      //   115: ifeq +26 -> 141
      //   118: ldc 151
      //   120: ldc_w 257
      //   123: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   126: aload_2
      //   127: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   130: aload_3
      //   131: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   134: ldc 222
      //   136: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: aconst_null
      //   140: areturn
      //   141: aload_2
      //   142: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   145: aload_3
      //   146: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   149: ldc 222
      //   151: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   154: aload_0
      //   155: areturn
      //   156: astore_0
      //   157: aconst_null
      //   158: astore_3
      //   159: aconst_null
      //   160: astore_2
      //   161: ldc 151
      //   163: aload_0
      //   164: ldc_w 259
      //   167: iconst_0
      //   168: anewarray 155	java/lang/Object
      //   171: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   174: aload_2
      //   175: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   178: aload_3
      //   179: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   182: ldc 222
      //   184: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   187: aconst_null
      //   188: areturn
      //   189: astore_0
      //   190: aload_2
      //   191: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   194: aload_3
      //   195: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   198: ldc 222
      //   200: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   203: aload_0
      //   204: athrow
      //   205: astore_0
      //   206: aconst_null
      //   207: astore_2
      //   208: goto -47 -> 161
      //   211: astore_0
      //   212: goto -51 -> 161
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	215	0	paramu	u
      //   36	40	1	i	int
      //   22	186	2	localBufferedReader	java.io.BufferedReader
      //   13	182	3	localab	com.tencent.mm.vfs.ab
      //   27	83	4	str	String
      //   88	17	5	localCRC32	java.util.zip.CRC32
      // Exception table:
      //   from	to	target	type
      //   5	14	156	finally
      //   161	174	189	finally
      //   14	23	205	finally
      //   23	37	211	finally
      //   41	48	211	finally
      //   63	126	211	finally
    }
    
    /* Error */
    public final void Dt(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 261
      //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   12: invokevirtual 112	com/tencent/mm/compatible/deviceinfo/q$e:lock	()V
      //   15: aload_0
      //   16: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:lWj	Lcom/tencent/mm/vfs/u;
      //   19: invokevirtual 141	com/tencent/mm/vfs/u:jKS	()Z
      //   22: ifne +31 -> 53
      //   25: ldc 151
      //   27: ldc_w 263
      //   30: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   33: aload_0
      //   34: invokevirtual 266	com/tencent/mm/compatible/deviceinfo/q$d:aPr	()V
      //   37: aload_0
      //   38: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   41: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   44: ldc_w 261
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
      //   59: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:lWi	I
      //   62: if_icmpge +62 -> 124
      //   65: new 114	com/tencent/mm/vfs/u
      //   68: dup
      //   69: aload_0
      //   70: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:lWj	Lcom/tencent/mm/vfs/u;
      //   73: iload_2
      //   74: invokestatic 269	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   77: invokespecial 272	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
      //   80: astore 5
      //   82: aload 5
      //   84: invokevirtual 275	com/tencent/mm/vfs/u:isDirectory	()Z
      //   87: ifeq +17 -> 104
      //   90: ldc 151
      //   92: ldc_w 277
      //   95: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   98: aload 5
      //   100: invokevirtual 283	com/tencent/mm/vfs/u:diJ	()Z
      //   103: pop
      //   104: iload_3
      //   105: istore 4
      //   107: aload 5
      //   109: aload_1
      //   110: invokestatic 285	com/tencent/mm/compatible/deviceinfo/q$d:b	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)Z
      //   113: ifne +60 -> 173
      //   116: iload_3
      //   117: iconst_1
      //   118: iadd
      //   119: istore 4
      //   121: goto +52 -> 173
      //   124: iload_3
      //   125: aload_0
      //   126: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:lWi	I
      //   129: if_icmpne +7 -> 136
      //   132: aload_0
      //   133: invokevirtual 266	com/tencent/mm/compatible/deviceinfo/q$d:aPr	()V
      //   136: aload_0
      //   137: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   140: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   143: ldc_w 261
      //   146: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: goto -99 -> 50
      //   152: astore_1
      //   153: aload_0
      //   154: monitorexit
      //   155: aload_1
      //   156: athrow
      //   157: astore_1
      //   158: aload_0
      //   159: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   162: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   165: ldc_w 261
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
      //   80	28	5	localu	u
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
    
    void aPr() {}
    
    /* Error */
    public final String aPu()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 287
      //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   12: invokevirtual 112	com/tencent/mm/compatible/deviceinfo/q$e:lock	()V
      //   15: aload_0
      //   16: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:lWj	Lcom/tencent/mm/vfs/u;
      //   19: invokevirtual 141	com/tencent/mm/vfs/u:jKS	()Z
      //   22: ifne +32 -> 54
      //   25: ldc 151
      //   27: ldc_w 289
      //   30: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   33: aload_0
      //   34: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   37: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   40: ldc_w 287
      //   43: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   46: aconst_null
      //   47: astore 5
      //   49: aload_0
      //   50: monitorexit
      //   51: aload 5
      //   53: areturn
      //   54: aload_0
      //   55: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:lWi	I
      //   58: istore_3
      //   59: iconst_0
      //   60: istore_1
      //   61: iconst_0
      //   62: istore_2
      //   63: iload_1
      //   64: aload_0
      //   65: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:lWi	I
      //   68: if_icmpge +70 -> 138
      //   71: new 114	com/tencent/mm/vfs/u
      //   74: dup
      //   75: aload_0
      //   76: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:lWj	Lcom/tencent/mm/vfs/u;
      //   79: iload_1
      //   80: invokestatic 269	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   83: invokespecial 272	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
      //   86: astore 5
      //   88: aload 5
      //   90: invokevirtual 141	com/tencent/mm/vfs/u:jKS	()Z
      //   93: ifne +10 -> 103
      //   96: iload_3
      //   97: iconst_1
      //   98: isub
      //   99: istore_3
      //   100: goto +149 -> 249
      //   103: aload 5
      //   105: invokestatic 291	com/tencent/mm/compatible/deviceinfo/q$d:c	(Lcom/tencent/mm/vfs/u;)Ljava/lang/String;
      //   108: astore 5
      //   110: aload 5
      //   112: ifnull +19 -> 131
      //   115: aload_0
      //   116: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   119: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   122: ldc_w 287
      //   125: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   128: goto -79 -> 49
      //   131: iload_2
      //   132: iconst_1
      //   133: iadd
      //   134: istore_2
      //   135: goto +114 -> 249
      //   138: iload_2
      //   139: ifle +17 -> 156
      //   142: iload_2
      //   143: iload_3
      //   144: if_icmpne +39 -> 183
      //   147: iconst_1
      //   148: istore 4
      //   150: aload_0
      //   151: iload 4
      //   153: invokevirtual 295	com/tencent/mm/compatible/deviceinfo/q$d:eE	(Z)V
      //   156: ldc 151
      //   158: ldc_w 297
      //   161: invokestatic 280	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   164: aload_0
      //   165: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   168: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   171: ldc_w 287
      //   174: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: aconst_null
      //   178: astore 5
      //   180: goto -131 -> 49
      //   183: iconst_0
      //   184: istore 4
      //   186: goto -36 -> 150
      //   189: astore 5
      //   191: ldc 151
      //   193: aload 5
      //   195: ldc_w 299
      //   198: iconst_0
      //   199: anewarray 155	java/lang/Object
      //   202: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   205: aload_0
      //   206: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   209: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   212: ldc_w 287
      //   215: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   218: aconst_null
      //   219: astore 5
      //   221: goto -172 -> 49
      //   224: astore 5
      //   226: aload_0
      //   227: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:lWk	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   230: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   233: ldc_w 287
      //   236: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   239: aload 5
      //   241: athrow
      //   242: astore 5
      //   244: aload_0
      //   245: monitorexit
      //   246: aload 5
      //   248: athrow
      //   249: iload_1
      //   250: iconst_1
      //   251: iadd
      //   252: istore_1
      //   253: goto -190 -> 63
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	256	0	this	d
      //   60	193	1	i	int
      //   62	83	2	j	int
      //   58	87	3	k	int
      //   148	37	4	bool	boolean
      //   47	132	5	localObject1	Object
      //   189	5	5	localThrowable	Throwable
      //   219	1	5	localObject2	Object
      //   224	16	5	localObject3	Object
      //   242	5	5	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   8	33	189	finally
      //   54	59	189	finally
      //   63	96	189	finally
      //   103	110	189	finally
      //   150	156	189	finally
      //   156	164	189	finally
      //   191	205	224	finally
      //   2	8	242	finally
      //   33	46	242	finally
      //   115	128	242	finally
      //   164	177	242	finally
      //   205	218	242	finally
      //   226	242	242	finally
    }
    
    void eE(boolean paramBoolean) {}
  }
  
  static final class e
  {
    private volatile LocalServerSocket lWm;
    private volatile int lWn;
    private final String mName;
    
    e(String paramString)
    {
      AppMethodBeat.i(155715);
      this.lWm = null;
      this.lWn = 0;
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
          LocalServerSocket localLocalServerSocket = this.lWm;
          if (localLocalServerSocket == null)
          {
            try
            {
              this.lWm = new LocalServerSocket(this.mName);
              this.lWn += 1;
              AppMethodBeat.o(155716);
            }
            finally
            {
              localObject1 = finally;
              this.lWm = null;
              bool = false;
              AppMethodBeat.o(155716);
              continue;
            }
            return bool;
          }
        }
        finally {}
        this.lWn += 1;
        AppMethodBeat.o(155716);
      }
    }
    
    final void lock()
    {
      try
      {
        AppMethodBeat.i(155717);
        label7:
        boolean bool = tryLock();
        if (bool) {}
      }
      finally
      {
        try
        {
          Thread.sleep(10L);
        }
        finally
        {
          break label7;
          AppMethodBeat.o(155717);
          return;
          localObject2 = finally;
        }
      }
    }
    
    final void unlock()
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(155718);
          if (this.lWn > 0) {
            this.lWn -= 1;
          }
          if (this.lWn == 0)
          {
            LocalServerSocket localLocalServerSocket = this.lWm;
            if (localLocalServerSocket != null)
            {
              try
              {
                this.lWm.close();
                this.lWm = null;
                AppMethodBeat.o(155718);
              }
              finally
              {
                localObject1 = finally;
                this.lWm = null;
                AppMethodBeat.o(155718);
                continue;
              }
              return;
            }
          }
        }
        finally {}
        AppMethodBeat.o(155718);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.q
 * JD-Core Version:    0.7.0.1
 */