package com.tencent.mm.compatible.deviceinfo;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static final b jsA;
  private static final b jsB;
  private static final b jsC;
  private static final b jsD;
  private static final b jsE;
  private static final b jsF;
  private static final b jsx;
  private static final b jsy;
  private static final b jsz;
  
  static
  {
    AppMethodBeat.i(155741);
    jsx = new b(new d("a")
    {
      final void auW()
      {
        AppMethodBeat.i(155685);
        r.qL(4);
        AppMethodBeat.o(155685);
      }
      
      final void dS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155686);
        if (paramAnonymousBoolean) {
          r.qL(2);
        }
        AppMethodBeat.o(155686);
      }
    })
    {
      final q.a jsG;
      
      final String auX()
      {
        AppMethodBeat.i(155693);
        String str = this.jsG.KM("1234567890ABCDEF");
        if (!"1234567890ABCDEF".equals(str))
        {
          r.qL(0);
          AppMethodBeat.o(155693);
          return str;
        }
        AppMethodBeat.o(155693);
        return null;
      }
      
      final void auY()
      {
        AppMethodBeat.i(155694);
        r.qL(3);
        AppMethodBeat.o(155694);
      }
    };
    jsy = new b(new d("c"))
    {
      final String auX()
      {
        AppMethodBeat.i(155695);
        Log.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSerial, %s", new Object[] { Util.getStack() });
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
    jsz = new b(new d("d"))
    {
      final String auX()
      {
        AppMethodBeat.i(155696);
        AppMethodBeat.o(155696);
        return "02:00:00:00:00:00";
      }
    };
    jsA = new b(new d("e"))
    {
      final String auX()
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
    jsB = new b(new d("f")
    {
      final void auW()
      {
        AppMethodBeat.i(155698);
        r.qL(14);
        AppMethodBeat.o(155698);
      }
      
      final void dS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155699);
        if (paramAnonymousBoolean) {
          r.qL(12);
        }
        AppMethodBeat.o(155699);
      }
    })
    {
      final q.a jsH;
      
      final String auX()
      {
        AppMethodBeat.i(155701);
        String str = this.jsH.KM(null);
        if (str != null)
        {
          r.qL(10);
          AppMethodBeat.o(155701);
          return str;
        }
        str = Build.MANUFACTURER + Build.MODEL + n.auw();
        AppMethodBeat.o(155701);
        return str;
      }
      
      final void auY()
      {
        AppMethodBeat.i(155702);
        r.qL(13);
        AppMethodBeat.o(155702);
      }
    };
    jsC = new b(new d("g"))
    {
      final String auX()
      {
        AppMethodBeat.i(155703);
        try
        {
          String str = Settings.Secure.getString(MMApplicationContext.getContext().getContentResolver(), "android_id");
          AppMethodBeat.o(155703);
          return str;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "[-] Fail to get android id.", new Object[0]);
          AppMethodBeat.o(155703);
        }
        return "";
      }
    };
    jsD = new b(new d("h"))
    {
      final q.c jsI;
      
      final String auX()
      {
        AppMethodBeat.i(155705);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(q.getAndroidId());
        Object localObject = this.jsI.KM(null);
        if (localObject == null)
        {
          localObject = q.dR(false);
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
            localStringBuilder.append(q.auL());
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
              if (!this.jsI.jsN.jsg) {
                r.qL(28);
              }
            }
          }
        }
      }
    };
    jsE = new b(new d("i"))
    {
      final String auX()
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
    jsF = new b(new d("j")
    {
      final void auW()
      {
        AppMethodBeat.i(155688);
        r.qL(9);
        AppMethodBeat.o(155688);
      }
      
      final void dS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155689);
        if (paramAnonymousBoolean) {
          r.qL(7);
        }
        AppMethodBeat.o(155689);
      }
    })
    {
      final String auX()
      {
        AppMethodBeat.i(155690);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(q.getAndroidId()).append('#').append(q.auL()).append('#').append(System.currentTimeMillis()).append('#').append(SystemClock.elapsedRealtimeNanos());
        localObject = UUID.nameUUIDFromBytes(((StringBuilder)localObject).toString().getBytes(Charset.forName("UTF-8"))).toString();
        AppMethodBeat.o(155690);
        return localObject;
      }
      
      final void auY()
      {
        AppMethodBeat.i(155691);
        r.qL(8);
        AppMethodBeat.o(155691);
      }
    };
    AppMethodBeat.o(155741);
  }
  
  public static void auD()
  {
    AppMethodBeat.i(155719);
    jsx.get();
    jsy.get();
    jsF.get();
    AppMethodBeat.o(155719);
  }
  
  public static String auE()
  {
    AppMethodBeat.i(155721);
    String str = dR(true);
    AppMethodBeat.o(155721);
    return str;
  }
  
  public static String auF()
  {
    AppMethodBeat.i(155722);
    Object localObject = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    try
    {
      Log.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSubscriberId, %s", new Object[] { Util.getStack() });
      localObject = Util.nullAsNil(((TelephonyManager)localObject).getSubscriberId());
      AppMethodBeat.o(155722);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getIMSI", new Object[0]);
      AppMethodBeat.o(155722);
    }
    return "";
  }
  
  public static String auG()
  {
    AppMethodBeat.i(155723);
    String str = Util.nullAsNil(jsy.get());
    AppMethodBeat.o(155723);
    return str;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String auH()
  {
    AppMethodBeat.i(155724);
    Object localObject = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    if (localObject != null) {}
    try
    {
      Log.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSimSerialNumber", new Object[] { Util.getStack() });
      localObject = Util.nullAsNil(((TelephonyManager)localObject).getSimSerialNumber());
      AppMethodBeat.o(155724);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getICCID", new Object[0]);
      AppMethodBeat.o(155724);
    }
    AppMethodBeat.o(155724);
    return "";
    return "";
  }
  
  public static String auI()
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
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getSimCountryIso", new Object[0]);
      AppMethodBeat.o(155726);
    }
    return "";
  }
  
  public static String auJ()
  {
    AppMethodBeat.i(155727);
    String str = Util.nullAsNil(jsz.get());
    AppMethodBeat.o(155727);
    return str;
  }
  
  public static String auK()
  {
    AppMethodBeat.i(155728);
    String str = Util.nullAsNil(jsA.get());
    AppMethodBeat.o(155728);
    return str;
  }
  
  public static String auL()
  {
    AppMethodBeat.i(155729);
    String str = Util.nullAsNil(jsB.get());
    AppMethodBeat.o(155729);
    return str;
  }
  
  public static String auM()
  {
    AppMethodBeat.i(155731);
    String str = Util.nullAsNil(jsD.get());
    AppMethodBeat.o(155731);
    return str;
  }
  
  public static void auN()
  {
    AppMethodBeat.i(155732);
    Log.w("MicroMsg.DeviceInfo", "[!] MMGUID refreshed, old: %s, new: %s", new Object[] { jsD.get(), jsD.ava() });
    AppMethodBeat.o(155732);
  }
  
  public static boolean auO()
  {
    return true;
  }
  
  public static String auP()
  {
    AppMethodBeat.i(155733);
    String str = Util.nullAsNil(jsF.get());
    AppMethodBeat.o(155733);
    return str;
  }
  
  public static String auQ()
  {
    AppMethodBeat.i(155734);
    String str = Util.nullAsNil(d.GxJ.auQ());
    AppMethodBeat.o(155734);
    return str;
  }
  
  public static String auR()
  {
    AppMethodBeat.i(155735);
    String str = "android-" + Build.MODEL + "-" + Build.VERSION.SDK_INT;
    AppMethodBeat.o(155735);
    return str;
  }
  
  public static String auS()
  {
    AppMethodBeat.i(155736);
    String str = Util.nullAsNil(jsE.get());
    AppMethodBeat.o(155736);
    return str;
  }
  
  /* Error */
  public static String[] auT()
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_0
    //   2: ldc_w 266
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 268	java/io/BufferedReader
    //   11: dup
    //   12: new 270	java/io/InputStreamReader
    //   15: dup
    //   16: ldc_w 272
    //   19: invokestatic 278	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: ldc_w 280
    //   25: invokespecial 283	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   28: invokespecial 286	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: new 234	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 291	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: ldc_w 293
    //   51: invokevirtual 299	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   72: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: bipush 32
    //   77: invokevirtual 302	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: iload_0
    //   82: iconst_1
    //   83: iadd
    //   84: istore_0
    //   85: goto -29 -> 56
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: aload_2
    //   98: invokevirtual 291	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: ldc_w 293
    //   104: invokevirtual 299	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   107: iconst_2
    //   108: aaload
    //   109: astore 4
    //   111: aload_2
    //   112: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   115: ldc_w 266
    //   118: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_2
    //   122: anewarray 295	java/lang/String
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
    //   140: ldc 149
    //   142: aload_3
    //   143: ldc_w 308
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   157: ldc_w 266
    //   160: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: iconst_2
    //   164: anewarray 295	java/lang/String
    //   167: dup
    //   168: iconst_0
    //   169: ldc 177
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: ldc_w 310
    //   177: aastore
    //   178: areturn
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   186: ldc_w 266
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
  public static java.util.Map<String, String> auU()
  {
    // Byte code:
    //   0: ldc_w 313
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 315	java/util/HashMap
    //   9: dup
    //   10: invokespecial 316	java/util/HashMap:<init>	()V
    //   13: astore_3
    //   14: new 268	java/io/BufferedReader
    //   17: dup
    //   18: new 270	java/io/InputStreamReader
    //   21: dup
    //   22: ldc_w 272
    //   25: invokestatic 278	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: ldc_w 280
    //   31: invokespecial 283	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: invokespecial 286	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 291	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +96 -> 142
    //   49: aload_1
    //   50: astore_0
    //   51: aload_2
    //   52: invokevirtual 319	java/lang/String:trim	()Ljava/lang/String;
    //   55: invokevirtual 322	java/lang/String:isEmpty	()Z
    //   58: ifne -20 -> 38
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: ldc_w 324
    //   67: invokevirtual 299	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   85: invokevirtual 319	java/lang/String:trim	()Ljava/lang/String;
    //   88: invokevirtual 327	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   91: aload_2
    //   92: iconst_1
    //   93: aaload
    //   94: invokevirtual 319	java/lang/String:trim	()Ljava/lang/String;
    //   97: invokeinterface 333 3 0
    //   102: pop
    //   103: goto -65 -> 38
    //   106: astore_2
    //   107: aload_1
    //   108: astore_0
    //   109: ldc 149
    //   111: aload_2
    //   112: ldc_w 335
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_1
    //   123: astore_0
    //   124: aload_3
    //   125: invokeinterface 338 1 0
    //   130: aload_1
    //   131: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   134: ldc_w 313
    //   137: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_3
    //   141: areturn
    //   142: aload_1
    //   143: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   146: goto -12 -> 134
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_0
    //   152: aload_0
    //   153: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   156: ldc_w 313
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
  
  public static int auV()
  {
    AppMethodBeat.i(155739);
    try
    {
      Pattern localPattern = Pattern.compile("cpu[0-9]+");
      com.tencent.mm.vfs.q[] arrayOfq = new com.tencent.mm.vfs.q("/sys/devices/system/cpu").ifJ();
      int m = arrayOfq.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        boolean bool = localPattern.matcher(arrayOfq[i].getName()).matches();
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
  
  public static String cp(Context paramContext)
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
    catch (Throwable paramContext)
    {
      Log.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "getMobileSPType", new Object[0]);
      AppMethodBeat.o(155725);
    }
    return "";
  }
  
  public static String dR(boolean paramBoolean)
  {
    AppMethodBeat.i(155720);
    String str = jsx.get();
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
    String str = Util.nullAsNil(jsC.get());
    AppMethodBeat.o(155730);
    return str;
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
    private boolean jsJ = false;
    private boolean jsK = false;
    private final byte[] jsL = new byte[0];
    private String mValue = null;
    
    final String KM(String paramString)
    {
      synchronized (this.jsL)
      {
        if (this.jsJ)
        {
          paramString = this.mValue;
          return paramString;
        }
        this.mValue = auZ();
        if (this.mValue != null)
        {
          this.jsJ = true;
          paramString = this.mValue;
          return paramString;
        }
      }
      return paramString;
    }
    
    final void KN(String paramString)
    {
      synchronized (this.jsL)
      {
        if ((this.jsJ) && (TextUtils.equals(this.mValue, paramString))) {
          return;
        }
        this.mValue = paramString;
        this.jsJ = true;
        this.jsK = true;
        KO(paramString);
        return;
      }
    }
    
    protected abstract void KO(String paramString);
    
    protected abstract String auZ();
  }
  
  static abstract class b
  {
    private final q.a jsM;
    
    b(q.a parama)
    {
      this.jsM = parama;
    }
    
    abstract String auX();
    
    void auY() {}
    
    final String ava()
    {
      String str = auX();
      if (!TextUtils.isEmpty(str)) {
        this.jsM.KN(str);
      }
      return str;
    }
    
    final String get()
    {
      String str = this.jsM.KM(null);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      auY();
      return ava();
    }
  }
  
  static final class c
    extends q.a
  {
    final l jsN;
    private final int mType;
    
    c(int paramInt)
    {
      super();
      AppMethodBeat.i(155706);
      this.jsN = l.auq();
      this.mType = paramInt;
      AppMethodBeat.o(155706);
    }
    
    protected final void KO(String paramString)
    {
      AppMethodBeat.i(155708);
      this.jsN.i(this.mType, paramString);
      AppMethodBeat.o(155708);
    }
    
    protected final String auZ()
    {
      AppMethodBeat.i(155707);
      String str = (String)this.jsN.get(this.mType);
      if ((str == null) && (!this.jsN.jsg)) {
        switch (this.mType)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(155707);
        return str;
        r.qL(27);
        continue;
        r.qL(26);
        continue;
        r.qL(25);
      }
    }
  }
  
  static class d
    extends q.a
  {
    private static final Set<String> jsO;
    private final String jsP;
    private final int jsQ;
    private final com.tencent.mm.vfs.q jsR;
    private final q.e jsS;
    private final boolean jsT;
    
    static
    {
      AppMethodBeat.i(155714);
      jsO = new HashSet();
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
      if (jsO.contains(paramString))
      {
        paramString = new IllegalArgumentException("name: " + paramString + " is duplicated.");
        AppMethodBeat.o(155709);
        throw paramString;
      }
      jsO.add(paramString);
      this.jsP = UUID.nameUUIDFromBytes(paramString.getBytes(Charset.forName("UTF-8"))).toString();
      this.jsQ = 5;
      this.jsS = new q.e(paramString);
      for (;;)
      {
        try
        {
          this.jsS.lock();
          this.jsR = new com.tencent.mm.vfs.q(MMApplicationContext.getContext().getFilesDir().getParentFile(), ".auth_cache/" + this.jsP);
          if (this.jsR.ifE()) {
            this.jsT = false;
          }
        }
        finally
        {
          this.jsS.unlock();
          AppMethodBeat.o(155709);
        }
        try
        {
          this.jsS.unlock();
          return;
        }
        finally
        {
          AppMethodBeat.o(155709);
        }
        this.jsT = true;
        if (!this.jsR.ifL()) {
          Log.e("MicroMsg.DeviceInfo", "[-] Fail to make base dir: %s", new Object[] { this.jsR.bOF() });
        }
      }
    }
    
    /* Error */
    private static boolean b(com.tencent.mm.vfs.q paramq, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 4
      //   5: ldc 169
      //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: aload_1
      //   11: ifnonnull +32 -> 43
      //   14: aload_3
      //   15: astore_2
      //   16: aload_0
      //   17: invokevirtual 141	com/tencent/mm/vfs/q:ifE	()Z
      //   20: ifeq +103 -> 123
      //   23: aload_3
      //   24: astore_2
      //   25: new 171	java/io/PrintWriter
      //   28: dup
      //   29: new 173	com/tencent/mm/vfs/y
      //   32: dup
      //   33: aload_0
      //   34: invokespecial 176	com/tencent/mm/vfs/y:<init>	(Lcom/tencent/mm/vfs/q;)V
      //   37: invokespecial 179	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   40: invokevirtual 182	java/io/PrintWriter:close	()V
      //   43: aload_3
      //   44: astore_2
      //   45: new 171	java/io/PrintWriter
      //   48: dup
      //   49: new 173	com/tencent/mm/vfs/y
      //   52: dup
      //   53: aload_0
      //   54: invokespecial 176	com/tencent/mm/vfs/y:<init>	(Lcom/tencent/mm/vfs/q;)V
      //   57: invokespecial 179	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   60: astore_3
      //   61: new 184	java/util/zip/CRC32
      //   64: dup
      //   65: invokespecial 185	java/util/zip/CRC32:<init>	()V
      //   68: astore_2
      //   69: aload_2
      //   70: aload_1
      //   71: ldc 83
      //   73: invokestatic 89	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   76: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   79: invokevirtual 189	java/util/zip/CRC32:update	([B)V
      //   82: aload_3
      //   83: new 65	java/lang/StringBuilder
      //   86: dup
      //   87: invokespecial 190	java/lang/StringBuilder:<init>	()V
      //   90: aload_1
      //   91: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   94: ldc 192
      //   96: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: aload_2
      //   100: invokevirtual 196	java/util/zip/CRC32:getValue	()J
      //   103: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   106: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   109: invokevirtual 202	java/io/PrintWriter:print	(Ljava/lang/String;)V
      //   112: aload_3
      //   113: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   116: ldc 169
      //   118: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   121: iconst_1
      //   122: ireturn
      //   123: aconst_null
      //   124: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   127: ldc 169
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
      //   143: ldc 210
      //   145: iconst_1
      //   146: anewarray 155	java/lang/Object
      //   149: dup
      //   150: iconst_0
      //   151: aload_0
      //   152: invokevirtual 158	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
      //   155: aastore
      //   156: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   159: aload_1
      //   160: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   163: ldc 169
      //   165: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: iconst_0
      //   169: ireturn
      //   170: astore_0
      //   171: aload_2
      //   172: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   175: ldc 169
      //   177: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   180: aload_0
      //   181: athrow
      //   182: astore_0
      //   183: aload_3
      //   184: astore_2
      //   185: goto -14 -> 171
      //   188: astore_2
      //   189: aload_3
      //   190: astore_1
      //   191: aload_2
      //   192: astore_3
      //   193: goto -55 -> 138
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	196	0	paramq	com.tencent.mm.vfs.q
      //   0	196	1	paramString	String
      //   15	170	2	localObject1	Object
      //   188	4	2	localThrowable1	Throwable
      //   1	112	3	localPrintWriter	java.io.PrintWriter
      //   134	56	3	localThrowable2	Throwable
      //   192	1	3	localObject2	Object
      //   3	133	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   16	23	134	java/lang/Throwable
      //   25	43	134	java/lang/Throwable
      //   45	61	134	java/lang/Throwable
      //   16	23	170	finally
      //   25	43	170	finally
      //   45	61	170	finally
      //   140	159	170	finally
      //   61	112	182	finally
      //   61	112	188	java/lang/Throwable
    }
    
    /* Error */
    private static String c(com.tencent.mm.vfs.q paramq)
    {
      // Byte code:
      //   0: ldc 217
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 219	com/tencent/mm/vfs/x
      //   8: dup
      //   9: aload_0
      //   10: invokespecial 220	com/tencent/mm/vfs/x:<init>	(Lcom/tencent/mm/vfs/q;)V
      //   13: astore_0
      //   14: new 222	java/io/BufferedReader
      //   17: dup
      //   18: aload_0
      //   19: invokespecial 225	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   22: astore 6
      //   24: aload_0
      //   25: astore_3
      //   26: aload 6
      //   28: astore_2
      //   29: aload 6
      //   31: invokevirtual 228	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   34: astore 5
      //   36: aload_0
      //   37: astore_3
      //   38: aload 6
      //   40: astore_2
      //   41: aload 5
      //   43: bipush 44
      //   45: invokevirtual 232	java/lang/String:lastIndexOf	(I)I
      //   48: istore_1
      //   49: iload_1
      //   50: ifge +31 -> 81
      //   53: aload_0
      //   54: astore_3
      //   55: aload 6
      //   57: astore_2
      //   58: ldc 151
      //   60: ldc 234
      //   62: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   65: aload 6
      //   67: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   70: aload_0
      //   71: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   74: ldc 217
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
      //   90: invokevirtual 241	java/lang/String:substring	(II)Ljava/lang/String;
      //   93: astore 4
      //   95: aload_0
      //   96: astore_3
      //   97: aload 6
      //   99: astore_2
      //   100: aload 5
      //   102: iload_1
      //   103: iconst_1
      //   104: iadd
      //   105: invokevirtual 244	java/lang/String:substring	(I)Ljava/lang/String;
      //   108: astore 5
      //   110: aload_0
      //   111: astore_3
      //   112: aload 6
      //   114: astore_2
      //   115: new 184	java/util/zip/CRC32
      //   118: dup
      //   119: invokespecial 185	java/util/zip/CRC32:<init>	()V
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
      //   141: invokevirtual 189	java/util/zip/CRC32:update	([B)V
      //   144: aload_0
      //   145: astore_3
      //   146: aload 6
      //   148: astore_2
      //   149: aload 7
      //   151: invokevirtual 196	java/util/zip/CRC32:getValue	()J
      //   154: aload 5
      //   156: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   159: lcmp
      //   160: ifeq +31 -> 191
      //   163: aload_0
      //   164: astore_3
      //   165: aload 6
      //   167: astore_2
      //   168: ldc 151
      //   170: ldc 252
      //   172: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   175: aload 6
      //   177: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   180: aload_0
      //   181: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   184: ldc 217
      //   186: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   189: aconst_null
      //   190: areturn
      //   191: aload 6
      //   193: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   196: aload_0
      //   197: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   200: ldc 217
      //   202: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   205: aload 4
      //   207: areturn
      //   208: astore 4
      //   210: aconst_null
      //   211: astore 5
      //   213: aconst_null
      //   214: astore_0
      //   215: aload 5
      //   217: astore_3
      //   218: aload_0
      //   219: astore_2
      //   220: ldc 151
      //   222: aload 4
      //   224: ldc 254
      //   226: iconst_0
      //   227: anewarray 155	java/lang/Object
      //   230: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   233: aload_0
      //   234: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   237: aload 5
      //   239: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   242: ldc 217
      //   244: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   247: aconst_null
      //   248: areturn
      //   249: astore 4
      //   251: aconst_null
      //   252: astore_0
      //   253: aconst_null
      //   254: astore_2
      //   255: aload_2
      //   256: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   259: aload_0
      //   260: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
      //   263: ldc 217
      //   265: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   268: aload 4
      //   270: athrow
      //   271: astore 4
      //   273: aconst_null
      //   274: astore_2
      //   275: goto -20 -> 255
      //   278: astore 4
      //   280: aload_3
      //   281: astore_0
      //   282: goto -27 -> 255
      //   285: astore 4
      //   287: aconst_null
      //   288: astore_2
      //   289: aload_0
      //   290: astore 5
      //   292: aload_2
      //   293: astore_0
      //   294: goto -79 -> 215
      //   297: astore 4
      //   299: aload_0
      //   300: astore 5
      //   302: aload 6
      //   304: astore_0
      //   305: goto -90 -> 215
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	308	0	paramq	com.tencent.mm.vfs.q
      //   48	57	1	i	int
      //   28	265	2	localObject1	Object
      //   25	256	3	localObject2	Object
      //   93	113	4	str	String
      //   208	15	4	localThrowable1	Throwable
      //   249	20	4	localObject3	Object
      //   271	1	4	localObject4	Object
      //   278	1	4	localObject5	Object
      //   285	1	4	localThrowable2	Throwable
      //   297	1	4	localThrowable3	Throwable
      //   34	267	5	localObject6	Object
      //   22	281	6	localBufferedReader	java.io.BufferedReader
      //   122	28	7	localCRC32	java.util.zip.CRC32
      // Exception table:
      //   from	to	target	type
      //   5	14	208	java/lang/Throwable
      //   5	14	249	finally
      //   14	24	271	finally
      //   29	36	278	finally
      //   41	49	278	finally
      //   58	65	278	finally
      //   86	95	278	finally
      //   100	110	278	finally
      //   115	124	278	finally
      //   129	144	278	finally
      //   149	163	278	finally
      //   168	175	278	finally
      //   220	233	278	finally
      //   14	24	285	java/lang/Throwable
      //   29	36	297	java/lang/Throwable
      //   41	49	297	java/lang/Throwable
      //   58	65	297	java/lang/Throwable
      //   86	95	297	java/lang/Throwable
      //   100	110	297	java/lang/Throwable
      //   115	124	297	java/lang/Throwable
      //   129	144	297	java/lang/Throwable
      //   149	163	297	java/lang/Throwable
      //   168	175	297	java/lang/Throwable
    }
    
    /* Error */
    public final void KO(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 256
      //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:jsS	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   12: invokevirtual 112	com/tencent/mm/compatible/deviceinfo/q$e:lock	()V
      //   15: aload_0
      //   16: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:jsR	Lcom/tencent/mm/vfs/q;
      //   19: invokevirtual 141	com/tencent/mm/vfs/q:ifE	()Z
      //   22: ifne +31 -> 53
      //   25: ldc 151
      //   27: ldc_w 258
      //   30: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   33: aload_0
      //   34: invokevirtual 261	com/tencent/mm/compatible/deviceinfo/q$d:auW	()V
      //   37: aload_0
      //   38: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:jsS	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   41: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   44: ldc_w 256
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
      //   59: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:jsQ	I
      //   62: if_icmpge +62 -> 124
      //   65: new 114	com/tencent/mm/vfs/q
      //   68: dup
      //   69: aload_0
      //   70: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:jsR	Lcom/tencent/mm/vfs/q;
      //   73: iload_2
      //   74: invokestatic 264	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   77: invokespecial 267	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
      //   80: astore 5
      //   82: aload 5
      //   84: invokevirtual 270	com/tencent/mm/vfs/q:isDirectory	()Z
      //   87: ifeq +17 -> 104
      //   90: ldc 151
      //   92: ldc_w 272
      //   95: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   98: aload 5
      //   100: invokevirtual 278	com/tencent/mm/vfs/q:cFq	()Z
      //   103: pop
      //   104: iload_3
      //   105: istore 4
      //   107: aload 5
      //   109: aload_1
      //   110: invokestatic 280	com/tencent/mm/compatible/deviceinfo/q$d:b	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)Z
      //   113: ifne +60 -> 173
      //   116: iload_3
      //   117: iconst_1
      //   118: iadd
      //   119: istore 4
      //   121: goto +52 -> 173
      //   124: iload_3
      //   125: aload_0
      //   126: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:jsQ	I
      //   129: if_icmpne +7 -> 136
      //   132: aload_0
      //   133: invokevirtual 261	com/tencent/mm/compatible/deviceinfo/q$d:auW	()V
      //   136: aload_0
      //   137: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:jsS	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   140: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   143: ldc_w 256
      //   146: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: goto -99 -> 50
      //   152: astore_1
      //   153: aload_0
      //   154: monitorexit
      //   155: aload_1
      //   156: athrow
      //   157: astore_1
      //   158: aload_0
      //   159: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:jsS	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   162: invokevirtual 146	com/tencent/mm/compatible/deviceinfo/q$e:unlock	()V
      //   165: ldc_w 256
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
      //   80	28	5	localq	com.tencent.mm.vfs.q
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
    
    void auW() {}
    
    public final String auZ()
    {
      label54:
      label183:
      try
      {
        AppMethodBeat.i(155710);
        try
        {
          this.jsS.lock();
          if (this.jsR.ifE()) {
            break label54;
          }
          Log.e("MicroMsg.DeviceInfo", "[-] Base dir does not exist, base cache will return defValue.");
          this.jsS.unlock();
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
            Log.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "[-] Exception occurred when fetch value, base cache will return defValue.", new Object[0]);
            this.jsS.unlock();
            AppMethodBeat.o(155710);
            localObject2 = null;
          }
        }
        finally
        {
          this.jsS.unlock();
          AppMethodBeat.o(155710);
        }
        return localObject1;
      }
      finally {}
      k = this.jsQ;
      int i = 0;
      j = 0;
      for (;;)
      {
        if (i < this.jsQ)
        {
          localObject1 = new com.tencent.mm.vfs.q(this.jsR, String.valueOf(i));
          if (!((com.tencent.mm.vfs.q)localObject1).ifE())
          {
            k -= 1;
            break label249;
          }
          localObject1 = c((com.tencent.mm.vfs.q)localObject1);
          if (localObject1 != null)
          {
            this.jsS.unlock();
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
          dS(bool);
          Log.w("MicroMsg.DeviceInfo", "[!] Cache missed, base cache will return defValue.");
          this.jsS.unlock();
          AppMethodBeat.o(155710);
          localObject1 = null;
          break;
        }
        Object localObject2;
        label249:
        i += 1;
      }
    }
    
    void dS(boolean paramBoolean) {}
  }
  
  static final class e
  {
    private volatile LocalServerSocket jsU;
    private volatile int jsV;
    private final String mName;
    
    e(String paramString)
    {
      AppMethodBeat.i(155715);
      this.jsU = null;
      this.jsV = 0;
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
          LocalServerSocket localLocalServerSocket = this.jsU;
          if (localLocalServerSocket == null)
          {
            try
            {
              this.jsU = new LocalServerSocket(this.mName);
              this.jsV += 1;
              AppMethodBeat.o(155716);
            }
            catch (Throwable localThrowable)
            {
              this.jsU = null;
              bool = false;
              AppMethodBeat.o(155716);
              continue;
            }
            return bool;
          }
        }
        finally {}
        this.jsV += 1;
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
      //   8: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:jsV	I
      //   11: ifle +13 -> 24
      //   14: aload_0
      //   15: aload_0
      //   16: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:jsV	I
      //   19: iconst_1
      //   20: isub
      //   21: putfield 29	com/tencent/mm/compatible/deviceinfo/q$e:jsV	I
      //   24: aload_0
      //   25: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:jsV	I
      //   28: ifne +64 -> 92
      //   31: aload_0
      //   32: getfield 27	com/tencent/mm/compatible/deviceinfo/q$e:jsU	Landroid/net/LocalServerSocket;
      //   35: astore_1
      //   36: aload_1
      //   37: ifnull +55 -> 92
      //   40: aload_0
      //   41: getfield 27	com/tencent/mm/compatible/deviceinfo/q$e:jsU	Landroid/net/LocalServerSocket;
      //   44: invokevirtual 72	android/net/LocalServerSocket:close	()V
      //   47: aload_0
      //   48: aconst_null
      //   49: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:jsU	Landroid/net/LocalServerSocket;
      //   52: ldc 69
      //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_0
      //   58: monitorexit
      //   59: return
      //   60: astore_1
      //   61: aload_0
      //   62: aconst_null
      //   63: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:jsU	Landroid/net/LocalServerSocket;
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
      //   82: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:jsU	Landroid/net/LocalServerSocket;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.q
 * JD-Core Version:    0.7.0.1
 */