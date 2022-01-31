package com.tencent.mm.compatible.e;

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
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static final b eqc;
  private static final b eqd;
  private static final b eqe;
  private static final b eqf;
  private static final b eqg;
  private static final b eqh;
  private static final b eqi;
  private static final b eqj;
  private static final b eqk;
  
  static
  {
    AppMethodBeat.i(92990);
    eqc = new b(new d("a")
    {
      final void LT()
      {
        AppMethodBeat.i(155866);
        r.iO(4);
        AppMethodBeat.o(155866);
      }
      
      final void bQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155867);
        if (paramAnonymousBoolean) {
          r.iO(2);
        }
        AppMethodBeat.o(155867);
      }
    })
    {
      final q.a eql;
      
      final String LU()
      {
        AppMethodBeat.i(139684);
        Object localObject = this.eql.lk("1234567890ABCDEF");
        if (!"1234567890ABCDEF".equals(localObject))
        {
          r.iO(0);
          AppMethodBeat.o(139684);
          return localObject;
        }
        localObject = (TelephonyManager)ah.getContext().getSystemService("phone");
        try
        {
          localObject = ((TelephonyManager)localObject).getDeviceId();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            r.iO(5);
          }
          AppMethodBeat.o(139684);
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          r.iO(5);
          AppMethodBeat.o(139684);
        }
        return null;
      }
      
      final void LV()
      {
        AppMethodBeat.i(155875);
        r.iO(3);
        AppMethodBeat.o(155875);
      }
    };
    eqd = new b(new d("c"))
    {
      final String LU()
      {
        AppMethodBeat.i(139685);
        if (Build.VERSION.SDK_INT < 9)
        {
          AppMethodBeat.o(139685);
          return null;
        }
        String str;
        if (Build.VERSION.SDK_INT < 26)
        {
          str = Build.SERIAL;
          AppMethodBeat.o(139685);
          return str;
        }
        try
        {
          str = Build.getSerial();
          AppMethodBeat.o(139685);
          return str;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(139685);
        }
        return null;
      }
    };
    eqe = new b(new d("d"))
    {
      final String LU()
      {
        AppMethodBeat.i(139686);
        Object localObject = (WifiManager)ah.getContext().getSystemService("wifi");
        if (localObject != null) {}
        for (localObject = ((WifiManager)localObject).getConnectionInfo(); localObject != null; localObject = null)
        {
          localObject = ((WifiInfo)localObject).getMacAddress();
          AppMethodBeat.o(139686);
          return localObject;
        }
        AppMethodBeat.o(139686);
        return null;
      }
    };
    eqf = new b(new d("e"))
    {
      final String LU()
      {
        AppMethodBeat.i(139687);
        Object localObject = BluetoothAdapter.getDefaultAdapter();
        if ((localObject != null) && (((BluetoothAdapter)localObject).isEnabled()))
        {
          localObject = ((BluetoothAdapter)localObject).getAddress();
          AppMethodBeat.o(139687);
          return localObject;
        }
        AppMethodBeat.o(139687);
        return null;
      }
    };
    eqg = new b(new d("f")
    {
      final void LT()
      {
        AppMethodBeat.i(156264);
        r.iO(14);
        AppMethodBeat.o(156264);
      }
      
      final void bQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(156265);
        if (paramAnonymousBoolean) {
          r.iO(12);
        }
        AppMethodBeat.o(156265);
      }
    })
    {
      final q.a eqm;
      
      final String LU()
      {
        AppMethodBeat.i(139690);
        String str = this.eqm.lk(null);
        if (str != null)
        {
          r.iO(10);
          AppMethodBeat.o(139690);
          return str;
        }
        str = Build.MANUFACTURER + Build.MODEL + n.Lt();
        AppMethodBeat.o(139690);
        return str;
      }
      
      final void LV()
      {
        AppMethodBeat.i(156267);
        r.iO(13);
        AppMethodBeat.o(156267);
      }
    };
    eqh = new b(new d("g"))
    {
      final String LU()
      {
        AppMethodBeat.i(139692);
        String str = Settings.Secure.getString(ah.getContext().getContentResolver(), "android_id");
        AppMethodBeat.o(139692);
        return str;
      }
    };
    eqi = new b(new d("h"))
    {
      final q.c eqn;
      
      final String LU()
      {
        AppMethodBeat.i(139693);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(q.getAndroidId());
        Object localObject = this.eqn.lk(null);
        if (localObject == null)
        {
          localObject = q.bP(false);
          ab.w("MicroMsg.DeviceInfo", "[!] fail to fetch devId from deprecated cache, using getIMEI instead. value: %s", new Object[] { localObject });
        }
        for (boolean bool = false;; bool = true)
        {
          ab.i("MicroMsg.DeviceInfo", "[+] devId: %s, useDeprecatedDevId: %s", new Object[] { localObject, Boolean.valueOf(bool) });
          if (bool) {
            localStringBuilder.append((String)localObject);
          }
          for (;;)
          {
            localStringBuilder.append(q.LJ());
            localObject = localStringBuilder.toString();
            ab.i("MicroMsg.DeviceInfo", "[+] new mmguid, dev:%s", new Object[] { localObject });
            localObject = "A" + g.w(((String)localObject).getBytes()).substring(0, 15);
            AppMethodBeat.o(139693);
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
              if (!this.eqn.eqs.epK) {
                r.iO(28);
              }
            }
          }
        }
      }
    };
    eqj = new b(new d("i"))
    {
      final String LU()
      {
        AppMethodBeat.i(139683);
        if (Build.VERSION.SDK_INT < 14)
        {
          str = Build.RADIO;
          AppMethodBeat.o(139683);
          return str;
        }
        String str = Build.getRadioVersion();
        AppMethodBeat.o(139683);
        return str;
      }
    };
    eqk = new b(new d("j")
    {
      final void LT()
      {
        AppMethodBeat.i(156260);
        r.iO(9);
        AppMethodBeat.o(156260);
      }
      
      final void bQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(156261);
        if (paramAnonymousBoolean) {
          r.iO(7);
        }
        AppMethodBeat.o(156261);
      }
    })
    {
      final String LU()
      {
        AppMethodBeat.i(156262);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(q.getAndroidId()).append('#').append(q.LJ()).append('#').append(System.currentTimeMillis()).append('#').append(SystemClock.elapsedRealtimeNanos());
        localObject = UUID.nameUUIDFromBytes(((StringBuilder)localObject).toString().getBytes(Charset.forName("UTF-8"))).toString();
        AppMethodBeat.o(156262);
        return localObject;
      }
      
      final void LV()
      {
        AppMethodBeat.i(156263);
        r.iO(8);
        AppMethodBeat.o(156263);
      }
    };
    AppMethodBeat.o(92990);
  }
  
  public static void LC()
  {
    AppMethodBeat.i(156669);
    eqc.get();
    eqd.get();
    eqk.get();
    AppMethodBeat.o(156669);
  }
  
  public static String LD()
  {
    AppMethodBeat.i(92966);
    String str = bP(true);
    AppMethodBeat.o(92966);
    return str;
  }
  
  public static String LE()
  {
    AppMethodBeat.i(139706);
    Object localObject = (TelephonyManager)ah.getContext().getSystemService("phone");
    try
    {
      localObject = bo.nullAsNil(((TelephonyManager)localObject).getSubscriberId());
      AppMethodBeat.o(139706);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getIMSI", new Object[0]);
      AppMethodBeat.o(139706);
    }
    return "";
  }
  
  public static String LF()
  {
    AppMethodBeat.i(92986);
    String str = bo.nullAsNil(eqd.get());
    AppMethodBeat.o(92986);
    return str;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String LG()
  {
    AppMethodBeat.i(139707);
    Object localObject = (TelephonyManager)ah.getContext().getSystemService("phone");
    if (localObject != null) {}
    try
    {
      localObject = bo.nullAsNil(((TelephonyManager)localObject).getSimSerialNumber());
      AppMethodBeat.o(139707);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getICCID", new Object[0]);
      AppMethodBeat.o(139707);
    }
    AppMethodBeat.o(139707);
    return "";
    return "";
  }
  
  public static String LH()
  {
    AppMethodBeat.i(139708);
    String str = bo.nullAsNil(eqe.get());
    AppMethodBeat.o(139708);
    return str;
  }
  
  public static String LI()
  {
    AppMethodBeat.i(139709);
    String str = bo.nullAsNil(eqf.get());
    AppMethodBeat.o(139709);
    return str;
  }
  
  public static String LJ()
  {
    AppMethodBeat.i(139710);
    String str = bo.nullAsNil(eqg.get());
    AppMethodBeat.o(139710);
    return str;
  }
  
  public static String LK()
  {
    AppMethodBeat.i(92969);
    String str = bo.nullAsNil(eqi.get());
    AppMethodBeat.o(92969);
    return str;
  }
  
  public static void LL()
  {
    AppMethodBeat.i(139711);
    ab.w("MicroMsg.DeviceInfo", "[!] MMGUID refreshed, old: %s, new: %s", new Object[] { eqi.get(), eqi.LX() });
    AppMethodBeat.o(139711);
  }
  
  public static boolean LM()
  {
    return true;
  }
  
  public static String LN()
  {
    AppMethodBeat.i(139712);
    String str = bo.nullAsNil(eqk.get());
    AppMethodBeat.o(139712);
    return str;
  }
  
  public static String LO()
  {
    AppMethodBeat.i(92989);
    String str = "android-" + Build.MODEL + "-" + Build.VERSION.SDK_INT;
    AppMethodBeat.o(92989);
    return str;
  }
  
  public static String LP()
  {
    AppMethodBeat.i(92983);
    String str = bo.nullAsNil(eqj.get());
    AppMethodBeat.o(92983);
    return str;
  }
  
  /* Error */
  public static String[] LQ()
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_0
    //   2: ldc 240
    //   4: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 242	java/io/BufferedReader
    //   10: dup
    //   11: new 244	java/io/InputStreamReader
    //   14: dup
    //   15: new 246	java/io/FileInputStream
    //   18: dup
    //   19: ldc 248
    //   21: invokespecial 249	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: ldc 251
    //   26: invokespecial 254	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   29: invokespecial 257	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: new 208	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   42: astore_3
    //   43: aload_2
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 262	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: ldc_w 264
    //   52: invokevirtual 270	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: astore 4
    //   57: aload_2
    //   58: astore_1
    //   59: iload_0
    //   60: aload 4
    //   62: arraylength
    //   63: if_icmpge +26 -> 89
    //   66: aload_2
    //   67: astore_1
    //   68: aload_3
    //   69: aload 4
    //   71: iload_0
    //   72: aaload
    //   73: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: bipush 32
    //   78: invokevirtual 273	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: iload_0
    //   83: iconst_1
    //   84: iadd
    //   85: istore_0
    //   86: goto -29 -> 57
    //   89: aload_2
    //   90: astore_1
    //   91: aload_3
    //   92: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore_3
    //   96: aload_2
    //   97: astore_1
    //   98: aload_2
    //   99: invokevirtual 262	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   102: ldc_w 264
    //   105: invokevirtual 270	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   108: iconst_2
    //   109: aaload
    //   110: astore 4
    //   112: aload_2
    //   113: invokestatic 276	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   116: ldc 240
    //   118: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_2
    //   122: anewarray 266	java/lang/String
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
    //   140: ldc 158
    //   142: aload_3
    //   143: ldc_w 278
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 166	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: invokestatic 276	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   157: ldc 240
    //   159: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: iconst_2
    //   163: anewarray 266	java/lang/String
    //   166: dup
    //   167: iconst_0
    //   168: ldc 168
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: ldc_w 280
    //   176: aastore
    //   177: areturn
    //   178: astore_2
    //   179: aconst_null
    //   180: astore_1
    //   181: aload_1
    //   182: invokestatic 276	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   185: ldc 240
    //   187: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_2
    //   191: athrow
    //   192: astore_2
    //   193: goto -12 -> 181
    //   196: astore_3
    //   197: goto -59 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	85	0	i	int
    //   34	148	1	localBufferedReader1	java.io.BufferedReader
    //   32	122	2	localBufferedReader2	java.io.BufferedReader
    //   178	13	2	localObject1	Object
    //   192	1	2	localObject2	Object
    //   42	86	3	localObject3	Object
    //   135	8	3	localThrowable1	Throwable
    //   196	1	3	localThrowable2	Throwable
    //   55	77	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   7	33	135	java/lang/Throwable
    //   7	33	178	finally
    //   35	43	192	finally
    //   45	57	192	finally
    //   59	66	192	finally
    //   68	82	192	finally
    //   91	96	192	finally
    //   98	112	192	finally
    //   140	153	192	finally
    //   35	43	196	java/lang/Throwable
    //   45	57	196	java/lang/Throwable
    //   59	66	196	java/lang/Throwable
    //   68	82	196	java/lang/Throwable
    //   91	96	196	java/lang/Throwable
    //   98	112	196	java/lang/Throwable
  }
  
  /* Error */
  public static java.util.Map<String, String> LR()
  {
    // Byte code:
    //   0: ldc_w 283
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 285	java/util/HashMap
    //   9: dup
    //   10: invokespecial 286	java/util/HashMap:<init>	()V
    //   13: astore_3
    //   14: new 242	java/io/BufferedReader
    //   17: dup
    //   18: new 244	java/io/InputStreamReader
    //   21: dup
    //   22: new 246	java/io/FileInputStream
    //   25: dup
    //   26: ldc 248
    //   28: invokespecial 249	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: ldc 251
    //   33: invokespecial 254	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   36: invokespecial 257	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: invokevirtual 262	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +96 -> 144
    //   51: aload_1
    //   52: astore_0
    //   53: aload_2
    //   54: invokevirtual 289	java/lang/String:trim	()Ljava/lang/String;
    //   57: invokevirtual 292	java/lang/String:isEmpty	()Z
    //   60: ifne -20 -> 40
    //   63: aload_1
    //   64: astore_0
    //   65: aload_2
    //   66: ldc_w 294
    //   69: invokevirtual 270	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   72: astore_2
    //   73: aload_1
    //   74: astore_0
    //   75: aload_2
    //   76: arraylength
    //   77: iconst_1
    //   78: if_icmple -38 -> 40
    //   81: aload_1
    //   82: astore_0
    //   83: aload_3
    //   84: aload_2
    //   85: iconst_0
    //   86: aaload
    //   87: invokevirtual 289	java/lang/String:trim	()Ljava/lang/String;
    //   90: invokevirtual 297	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   93: aload_2
    //   94: iconst_1
    //   95: aaload
    //   96: invokevirtual 289	java/lang/String:trim	()Ljava/lang/String;
    //   99: invokeinterface 303 3 0
    //   104: pop
    //   105: goto -65 -> 40
    //   108: astore_2
    //   109: aload_1
    //   110: astore_0
    //   111: ldc 158
    //   113: aload_2
    //   114: ldc_w 305
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 166	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_1
    //   125: astore_0
    //   126: aload_3
    //   127: invokeinterface 308 1 0
    //   132: aload_1
    //   133: invokestatic 276	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   136: ldc_w 283
    //   139: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_3
    //   143: areturn
    //   144: aload_1
    //   145: invokestatic 276	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   148: goto -12 -> 136
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_0
    //   154: aload_0
    //   155: invokestatic 276	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   158: ldc_w 283
    //   161: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: goto -13 -> 154
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: goto -64 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	114	0	localBufferedReader1	java.io.BufferedReader
    //   39	106	1	localBufferedReader2	java.io.BufferedReader
    //   151	14	1	localObject1	Object
    //   166	1	1	localObject2	Object
    //   172	1	1	localObject3	Object
    //   46	48	2	localObject4	Object
    //   108	6	2	localThrowable1	Throwable
    //   170	1	2	localThrowable2	Throwable
    //   13	130	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   42	47	108	java/lang/Throwable
    //   53	63	108	java/lang/Throwable
    //   65	73	108	java/lang/Throwable
    //   75	81	108	java/lang/Throwable
    //   83	105	108	java/lang/Throwable
    //   14	40	151	finally
    //   42	47	166	finally
    //   53	63	166	finally
    //   65	73	166	finally
    //   75	81	166	finally
    //   83	105	166	finally
    //   111	124	166	finally
    //   126	132	166	finally
    //   14	40	170	java/lang/Throwable
  }
  
  public static int LS()
  {
    AppMethodBeat.i(139715);
    try
    {
      Pattern localPattern = Pattern.compile("cpu[0-9]+");
      File[] arrayOfFile = new File("/sys/devices/system/cpu").listFiles();
      int m = arrayOfFile.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        boolean bool = localPattern.matcher(arrayOfFile[i].getName()).matches();
        k = j;
        if (bool) {
          k = j + 1;
        }
        i += 1;
      }
      AppMethodBeat.o(139715);
      return j;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139715);
    }
    return 1;
  }
  
  public static String bG(Context paramContext)
  {
    AppMethodBeat.i(92978);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = bo.nullAsNil(paramContext.getSimOperatorName());
        AppMethodBeat.o(92978);
        return paramContext;
      }
      AppMethodBeat.o(92978);
      return "";
    }
    catch (Throwable paramContext)
    {
      ab.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "getMobileSPType", new Object[0]);
      AppMethodBeat.o(92978);
    }
    return "";
  }
  
  public static String bP(boolean paramBoolean)
  {
    AppMethodBeat.i(139705);
    String str = eqc.get();
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(139705);
      return str;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(139705);
      return "1234567890ABCDEF";
    }
    AppMethodBeat.o(139705);
    return "";
  }
  
  public static String getAndroidId()
  {
    AppMethodBeat.i(92981);
    String str = bo.nullAsNil(eqh.get());
    AppMethodBeat.o(92981);
    return str;
  }
  
  public static String getSimCountryIso()
  {
    AppMethodBeat.i(92979);
    try
    {
      Object localObject = (TelephonyManager)ah.getContext().getSystemService("phone");
      if (localObject != null)
      {
        localObject = bo.nullAsNil(((TelephonyManager)localObject).getSimCountryIso());
        AppMethodBeat.o(92979);
        return localObject;
      }
      AppMethodBeat.o(92979);
      return "";
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getSimCountryIso", new Object[0]);
      AppMethodBeat.o(92979);
    }
    return "";
  }
  
  static abstract class a
  {
    private boolean eqo = false;
    private boolean eqp = false;
    private final byte[] eqq = new byte[0];
    private String mValue = null;
    
    protected abstract String LW();
    
    final String lk(String paramString)
    {
      synchronized (this.eqq)
      {
        if (this.eqo)
        {
          paramString = this.mValue;
          return paramString;
        }
        this.mValue = LW();
        if (this.mValue != null)
        {
          this.eqo = true;
          paramString = this.mValue;
          return paramString;
        }
      }
      return paramString;
    }
    
    final void ll(String paramString)
    {
      synchronized (this.eqq)
      {
        if ((this.eqo) && (TextUtils.equals(this.mValue, paramString))) {
          return;
        }
        this.mValue = paramString;
        this.eqo = true;
        this.eqp = true;
        lm(paramString);
        return;
      }
    }
    
    protected abstract void lm(String paramString);
  }
  
  static abstract class b
  {
    private final q.a eqr;
    
    b(q.a parama)
    {
      this.eqr = parama;
    }
    
    abstract String LU();
    
    void LV() {}
    
    final String LX()
    {
      String str = LU();
      if (!TextUtils.isEmpty(str)) {
        this.eqr.ll(str);
      }
      return str;
    }
    
    final String get()
    {
      String str = this.eqr.lk(null);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      LV();
      return LX();
    }
  }
  
  static final class c
    extends q.a
  {
    final l eqs;
    private final int mType;
    
    c(int paramInt)
    {
      super();
      AppMethodBeat.i(156668);
      this.eqs = l.Lm();
      this.mType = paramInt;
      AppMethodBeat.o(156668);
    }
    
    protected final String LW()
    {
      AppMethodBeat.i(139694);
      String str = (String)this.eqs.get(this.mType);
      if ((str == null) && (!this.eqs.epK)) {
        switch (this.mType)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(139694);
        return str;
        r.iO(27);
        continue;
        r.iO(26);
        continue;
        r.iO(25);
      }
    }
    
    protected final void lm(String paramString)
    {
      AppMethodBeat.i(139695);
      this.eqs.set(this.mType, paramString);
      AppMethodBeat.o(139695);
    }
  }
  
  static class d
    extends q.a
  {
    private static final Set<String> eqt;
    private final String equ;
    private final int eqv;
    private final File eqw;
    private final q.e eqx;
    private final boolean eqy;
    
    static
    {
      AppMethodBeat.i(139700);
      eqt = new HashSet();
      AppMethodBeat.o(139700);
    }
    
    /* Error */
    d(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_0
      //   2: invokespecial 44	com/tencent/mm/compatible/e/q$a:<init>	(B)V
      //   5: ldc 45
      //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: aload_1
      //   11: ifnull +10 -> 21
      //   14: aload_1
      //   15: invokevirtual 51	java/lang/String:isEmpty	()Z
      //   18: ifeq +20 -> 38
      //   21: new 53	java/lang/IllegalArgumentException
      //   24: dup
      //   25: ldc 55
      //   27: invokespecial 57	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   30: astore_1
      //   31: ldc 45
      //   33: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_1
      //   37: athrow
      //   38: getstatic 36	com/tencent/mm/compatible/e/q$d:eqt	Ljava/util/Set;
      //   41: aload_1
      //   42: invokeinterface 63 2 0
      //   47: ifeq +39 -> 86
      //   50: new 53	java/lang/IllegalArgumentException
      //   53: dup
      //   54: new 65	java/lang/StringBuilder
      //   57: dup
      //   58: ldc 67
      //   60: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   63: aload_1
      //   64: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   67: ldc 74
      //   69: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   75: invokespecial 57	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   78: astore_1
      //   79: ldc 45
      //   81: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   84: aload_1
      //   85: athrow
      //   86: getstatic 36	com/tencent/mm/compatible/e/q$d:eqt	Ljava/util/Set;
      //   89: aload_1
      //   90: invokeinterface 81 2 0
      //   95: pop
      //   96: aload_0
      //   97: aload_1
      //   98: ldc 83
      //   100: invokestatic 89	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   103: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   106: invokestatic 99	java/util/UUID:nameUUIDFromBytes	([B)Ljava/util/UUID;
      //   109: invokevirtual 100	java/util/UUID:toString	()Ljava/lang/String;
      //   112: putfield 102	com/tencent/mm/compatible/e/q$d:equ	Ljava/lang/String;
      //   115: aload_0
      //   116: iconst_5
      //   117: putfield 104	com/tencent/mm/compatible/e/q$d:eqv	I
      //   120: aload_0
      //   121: new 106	com/tencent/mm/compatible/e/q$e
      //   124: dup
      //   125: aload_1
      //   126: invokespecial 107	com/tencent/mm/compatible/e/q$e:<init>	(Ljava/lang/String;)V
      //   129: putfield 109	com/tencent/mm/compatible/e/q$d:eqx	Lcom/tencent/mm/compatible/e/q$e;
      //   132: aload_0
      //   133: getfield 109	com/tencent/mm/compatible/e/q$d:eqx	Lcom/tencent/mm/compatible/e/q$e;
      //   136: invokevirtual 112	com/tencent/mm/compatible/e/q$e:lock	()V
      //   139: aload_0
      //   140: new 114	java/io/File
      //   143: dup
      //   144: invokestatic 120	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
      //   147: invokevirtual 126	android/content/Context:getFilesDir	()Ljava/io/File;
      //   150: invokevirtual 129	java/io/File:getParentFile	()Ljava/io/File;
      //   153: new 65	java/lang/StringBuilder
      //   156: dup
      //   157: ldc 131
      //   159: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   162: aload_0
      //   163: getfield 102	com/tencent/mm/compatible/e/q$d:equ	Ljava/lang/String;
      //   166: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   169: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   172: invokespecial 134	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   175: putfield 136	com/tencent/mm/compatible/e/q$d:eqw	Ljava/io/File;
      //   178: aload_0
      //   179: getfield 136	com/tencent/mm/compatible/e/q$d:eqw	Ljava/io/File;
      //   182: invokevirtual 139	java/io/File:exists	()Z
      //   185: ifeq +21 -> 206
      //   188: aload_0
      //   189: iconst_0
      //   190: putfield 141	com/tencent/mm/compatible/e/q$d:eqy	Z
      //   193: aload_0
      //   194: getfield 109	com/tencent/mm/compatible/e/q$d:eqx	Lcom/tencent/mm/compatible/e/q$e;
      //   197: invokevirtual 144	com/tencent/mm/compatible/e/q$e:unlock	()V
      //   200: ldc 45
      //   202: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   205: return
      //   206: aload_0
      //   207: iconst_1
      //   208: putfield 141	com/tencent/mm/compatible/e/q$d:eqy	Z
      //   211: aload_0
      //   212: getfield 136	com/tencent/mm/compatible/e/q$d:eqw	Ljava/io/File;
      //   215: invokevirtual 147	java/io/File:mkdirs	()Z
      //   218: ifne -25 -> 193
      //   221: ldc 149
      //   223: ldc 151
      //   225: iconst_1
      //   226: anewarray 153	java/lang/Object
      //   229: dup
      //   230: iconst_0
      //   231: aload_0
      //   232: getfield 136	com/tencent/mm/compatible/e/q$d:eqw	Ljava/io/File;
      //   235: invokevirtual 156	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   238: aastore
      //   239: invokestatic 162	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   242: goto -49 -> 193
      //   245: astore_1
      //   246: aload_0
      //   247: getfield 109	com/tencent/mm/compatible/e/q$d:eqx	Lcom/tencent/mm/compatible/e/q$e;
      //   250: invokevirtual 144	com/tencent/mm/compatible/e/q$e:unlock	()V
      //   253: ldc 45
      //   255: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   258: aload_1
      //   259: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	260	0	this	d
      //   0	260	1	paramString	String
      // Exception table:
      //   from	to	target	type
      //   132	193	245	finally
      //   206	242	245	finally
    }
    
    /* Error */
    private static boolean d(File paramFile, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: ldc 166
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_1
      //   8: ifnonnull +21 -> 29
      //   11: aload_0
      //   12: invokevirtual 139	java/io/File:exists	()Z
      //   15: ifeq +92 -> 107
      //   18: new 168	java/io/PrintWriter
      //   21: dup
      //   22: aload_0
      //   23: invokespecial 171	java/io/PrintWriter:<init>	(Ljava/io/File;)V
      //   26: invokevirtual 174	java/io/PrintWriter:close	()V
      //   29: new 168	java/io/PrintWriter
      //   32: dup
      //   33: new 176	java/io/FileWriter
      //   36: dup
      //   37: aload_0
      //   38: invokespecial 177	java/io/FileWriter:<init>	(Ljava/io/File;)V
      //   41: invokespecial 180	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   44: astore_2
      //   45: new 182	java/util/zip/CRC32
      //   48: dup
      //   49: invokespecial 183	java/util/zip/CRC32:<init>	()V
      //   52: astore_3
      //   53: aload_3
      //   54: aload_1
      //   55: ldc 83
      //   57: invokestatic 89	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   60: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   63: invokevirtual 187	java/util/zip/CRC32:update	([B)V
      //   66: aload_2
      //   67: new 65	java/lang/StringBuilder
      //   70: dup
      //   71: invokespecial 188	java/lang/StringBuilder:<init>	()V
      //   74: aload_1
      //   75: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   78: ldc 190
      //   80: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: aload_3
      //   84: invokevirtual 194	java/util/zip/CRC32:getValue	()J
      //   87: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   90: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   93: invokevirtual 200	java/io/PrintWriter:print	(Ljava/lang/String;)V
      //   96: aload_2
      //   97: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   100: ldc 166
      //   102: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   105: iconst_1
      //   106: ireturn
      //   107: aconst_null
      //   108: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   111: ldc 166
      //   113: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: iconst_1
      //   117: ireturn
      //   118: astore_2
      //   119: aload_3
      //   120: astore_1
      //   121: ldc 149
      //   123: aload_2
      //   124: ldc 208
      //   126: iconst_1
      //   127: anewarray 153	java/lang/Object
      //   130: dup
      //   131: iconst_0
      //   132: aload_0
      //   133: invokevirtual 156	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   136: aastore
      //   137: invokestatic 212	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   140: aload_1
      //   141: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   144: ldc 166
      //   146: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   149: iconst_0
      //   150: ireturn
      //   151: astore_0
      //   152: aconst_null
      //   153: astore_1
      //   154: aload_1
      //   155: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   158: ldc 166
      //   160: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: aload_0
      //   164: athrow
      //   165: astore_0
      //   166: aload_2
      //   167: astore_1
      //   168: goto -14 -> 154
      //   171: astore_0
      //   172: goto -18 -> 154
      //   175: astore_3
      //   176: aload_2
      //   177: astore_1
      //   178: aload_3
      //   179: astore_2
      //   180: goto -59 -> 121
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	183	0	paramFile	File
      //   0	183	1	paramString	String
      //   44	53	2	localPrintWriter	java.io.PrintWriter
      //   118	59	2	localThrowable1	Throwable
      //   179	1	2	localThrowable2	Throwable
      //   1	119	3	localCRC32	java.util.zip.CRC32
      //   175	4	3	localThrowable3	Throwable
      // Exception table:
      //   from	to	target	type
      //   11	29	118	java/lang/Throwable
      //   29	45	118	java/lang/Throwable
      //   11	29	151	finally
      //   29	45	151	finally
      //   45	96	165	finally
      //   121	140	171	finally
      //   45	96	175	java/lang/Throwable
    }
    
    /* Error */
    private static String v(File paramFile)
    {
      // Byte code:
      //   0: ldc 215
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 217	java/io/BufferedReader
      //   8: dup
      //   9: new 219	java/io/FileReader
      //   12: dup
      //   13: aload_0
      //   14: invokespecial 220	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   17: invokespecial 223	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   20: astore_2
      //   21: aload_2
      //   22: astore_0
      //   23: aload_2
      //   24: invokevirtual 226	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   27: astore 4
      //   29: aload_2
      //   30: astore_0
      //   31: aload 4
      //   33: bipush 44
      //   35: invokevirtual 230	java/lang/String:lastIndexOf	(I)I
      //   38: istore_1
      //   39: iload_1
      //   40: ifge +23 -> 63
      //   43: aload_2
      //   44: astore_0
      //   45: ldc 149
      //   47: ldc 232
      //   49: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   52: aload_2
      //   53: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   56: ldc 215
      //   58: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   61: aconst_null
      //   62: areturn
      //   63: aload_2
      //   64: astore_0
      //   65: aload 4
      //   67: iconst_0
      //   68: iload_1
      //   69: invokevirtual 239	java/lang/String:substring	(II)Ljava/lang/String;
      //   72: astore_3
      //   73: aload_2
      //   74: astore_0
      //   75: aload 4
      //   77: iload_1
      //   78: iconst_1
      //   79: iadd
      //   80: invokevirtual 242	java/lang/String:substring	(I)Ljava/lang/String;
      //   83: astore 4
      //   85: aload_2
      //   86: astore_0
      //   87: new 182	java/util/zip/CRC32
      //   90: dup
      //   91: invokespecial 183	java/util/zip/CRC32:<init>	()V
      //   94: astore 5
      //   96: aload_2
      //   97: astore_0
      //   98: aload 5
      //   100: aload_3
      //   101: ldc 83
      //   103: invokestatic 89	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   106: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   109: invokevirtual 187	java/util/zip/CRC32:update	([B)V
      //   112: aload_2
      //   113: astore_0
      //   114: aload 5
      //   116: invokevirtual 194	java/util/zip/CRC32:getValue	()J
      //   119: aload 4
      //   121: invokestatic 248	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   124: lcmp
      //   125: ifeq +23 -> 148
      //   128: aload_2
      //   129: astore_0
      //   130: ldc 149
      //   132: ldc 250
      //   134: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   137: aload_2
      //   138: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   141: ldc 215
      //   143: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   146: aconst_null
      //   147: areturn
      //   148: aload_2
      //   149: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   152: ldc 215
      //   154: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   157: aload_3
      //   158: areturn
      //   159: astore_3
      //   160: aconst_null
      //   161: astore_2
      //   162: aload_2
      //   163: astore_0
      //   164: ldc 149
      //   166: aload_3
      //   167: ldc 252
      //   169: iconst_0
      //   170: anewarray 153	java/lang/Object
      //   173: invokestatic 212	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   176: aload_2
      //   177: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   180: ldc 215
      //   182: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   185: aconst_null
      //   186: areturn
      //   187: astore_2
      //   188: aconst_null
      //   189: astore_0
      //   190: aload_0
      //   191: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
      //   194: ldc 215
      //   196: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   199: aload_2
      //   200: athrow
      //   201: astore_2
      //   202: goto -12 -> 190
      //   205: astore_3
      //   206: goto -44 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	209	0	paramFile	File
      //   38	42	1	i	int
      //   20	157	2	localBufferedReader	java.io.BufferedReader
      //   187	13	2	localObject1	Object
      //   201	1	2	localObject2	Object
      //   72	86	3	str1	String
      //   159	8	3	localThrowable1	Throwable
      //   205	1	3	localThrowable2	Throwable
      //   27	93	4	str2	String
      //   94	21	5	localCRC32	java.util.zip.CRC32
      // Exception table:
      //   from	to	target	type
      //   5	21	159	java/lang/Throwable
      //   5	21	187	finally
      //   23	29	201	finally
      //   31	39	201	finally
      //   45	52	201	finally
      //   65	73	201	finally
      //   75	85	201	finally
      //   87	96	201	finally
      //   98	112	201	finally
      //   114	128	201	finally
      //   130	137	201	finally
      //   164	176	201	finally
      //   23	29	205	java/lang/Throwable
      //   31	39	205	java/lang/Throwable
      //   45	52	205	java/lang/Throwable
      //   65	73	205	java/lang/Throwable
      //   75	85	205	java/lang/Throwable
      //   87	96	205	java/lang/Throwable
      //   98	112	205	java/lang/Throwable
      //   114	128	205	java/lang/Throwable
      //   130	137	205	java/lang/Throwable
    }
    
    void LT() {}
    
    public final String LW()
    {
      AppMethodBeat.i(139697);
      for (;;)
      {
        try
        {
          this.eqx.lock();
          if (!this.eqw.exists())
          {
            ab.e("MicroMsg.DeviceInfo", "[-] Base dir does not exist, base cache will return defValue.");
            return null;
          }
          int k = this.eqv;
          int i = 0;
          int j = 0;
          if (i < this.eqv)
          {
            Object localObject1 = new File(this.eqw, String.valueOf(i));
            if (!((File)localObject1).exists())
            {
              k -= 1;
            }
            else
            {
              localObject1 = v((File)localObject1);
              if (localObject1 != null) {
                return localObject1;
              }
              j += 1;
            }
          }
          else
          {
            if (j > 0)
            {
              if (j == k)
              {
                bool = true;
                bQ(bool);
              }
            }
            else
            {
              ab.w("MicroMsg.DeviceInfo", "[!] Cache missed, base cache will return defValue.");
              return null;
            }
            boolean bool = false;
            continue;
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          ab.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "[-] Exception occurred when fetch value, base cache will return defValue.", new Object[0]);
          return null;
        }
        finally
        {
          this.eqx.unlock();
          AppMethodBeat.o(139697);
        }
      }
    }
    
    void bQ(boolean paramBoolean) {}
    
    public final void lm(String paramString)
    {
      AppMethodBeat.i(139698);
      for (;;)
      {
        int i;
        int k;
        try
        {
          this.eqx.lock();
          if (!this.eqw.exists())
          {
            ab.e("MicroMsg.DeviceInfo", "[-] Base dir does not exist, skip rest logic.");
            LT();
            return;
          }
          i = 0;
          j = 0;
          if (i < this.eqv)
          {
            File localFile = new File(this.eqw, String.valueOf(i));
            if (localFile.isDirectory())
            {
              ab.w("MicroMsg.DeviceInfo", "[!] Cache file %s is occupied by a directory, try to delete it first.");
              localFile.delete();
            }
            k = j;
            if (!d(localFile, paramString)) {
              k = j + 1;
            }
          }
          else
          {
            if (j == this.eqv) {
              LT();
            }
            return;
          }
        }
        finally
        {
          this.eqx.unlock();
          AppMethodBeat.o(139698);
        }
        i += 1;
        int j = k;
      }
    }
  }
  
  static final class e
  {
    private volatile int eqA;
    private volatile LocalServerSocket eqz;
    private final String mName;
    
    e(String paramString)
    {
      AppMethodBeat.i(139701);
      this.eqz = null;
      this.eqA = 0;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new IllegalArgumentException("lockName is null or empty.");
        AppMethodBeat.o(139701);
        throw paramString;
      }
      try
      {
        this.mName = paramString;
        return;
      }
      finally
      {
        AppMethodBeat.o(139701);
      }
    }
    
    private boolean tryLock()
    {
      boolean bool = true;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(139702);
          LocalServerSocket localLocalServerSocket = this.eqz;
          if (localLocalServerSocket == null)
          {
            try
            {
              this.eqz = new LocalServerSocket(this.mName);
              this.eqA += 1;
              AppMethodBeat.o(139702);
            }
            catch (Throwable localThrowable)
            {
              this.eqz = null;
              bool = false;
              AppMethodBeat.o(139702);
              continue;
            }
            return bool;
          }
        }
        finally {}
        this.eqA += 1;
        AppMethodBeat.o(139702);
      }
    }
    
    final void lock()
    {
      try
      {
        AppMethodBeat.i(139703);
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
        AppMethodBeat.o(139703);
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
      //   8: getfield 29	com/tencent/mm/compatible/e/q$e:eqA	I
      //   11: ifle +13 -> 24
      //   14: aload_0
      //   15: aload_0
      //   16: getfield 29	com/tencent/mm/compatible/e/q$e:eqA	I
      //   19: iconst_1
      //   20: isub
      //   21: putfield 29	com/tencent/mm/compatible/e/q$e:eqA	I
      //   24: aload_0
      //   25: getfield 29	com/tencent/mm/compatible/e/q$e:eqA	I
      //   28: ifne +64 -> 92
      //   31: aload_0
      //   32: getfield 27	com/tencent/mm/compatible/e/q$e:eqz	Landroid/net/LocalServerSocket;
      //   35: astore_1
      //   36: aload_1
      //   37: ifnull +55 -> 92
      //   40: aload_0
      //   41: getfield 27	com/tencent/mm/compatible/e/q$e:eqz	Landroid/net/LocalServerSocket;
      //   44: invokevirtual 72	android/net/LocalServerSocket:close	()V
      //   47: aload_0
      //   48: aconst_null
      //   49: putfield 27	com/tencent/mm/compatible/e/q$e:eqz	Landroid/net/LocalServerSocket;
      //   52: ldc 69
      //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_0
      //   58: monitorexit
      //   59: return
      //   60: astore_1
      //   61: aload_0
      //   62: aconst_null
      //   63: putfield 27	com/tencent/mm/compatible/e/q$e:eqz	Landroid/net/LocalServerSocket;
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
      //   82: putfield 27	com/tencent/mm/compatible/e/q$e:eqz	Landroid/net/LocalServerSocket;
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
 * Qualified Name:     com.tencent.mm.compatible.e.q
 * JD-Core Version:    0.7.0.1
 */