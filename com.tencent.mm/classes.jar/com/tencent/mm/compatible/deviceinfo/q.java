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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
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
  private static final b fDA;
  private static final b fDs;
  private static final b fDt;
  private static final b fDu;
  private static final b fDv;
  private static final b fDw;
  private static final b fDx;
  private static final b fDy;
  private static final b fDz;
  
  static
  {
    AppMethodBeat.i(155741);
    fDs = new b(new d("a")
    {
      final void Xj()
      {
        AppMethodBeat.i(155685);
        r.kX(4);
        AppMethodBeat.o(155685);
      }
      
      final void cH(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155686);
        if (paramAnonymousBoolean) {
          r.kX(2);
        }
        AppMethodBeat.o(155686);
      }
    })
    {
      final q.a fDB;
      
      final String Xk()
      {
        AppMethodBeat.i(155693);
        Object localObject = this.fDB.pg("1234567890ABCDEF");
        if (!"1234567890ABCDEF".equals(localObject))
        {
          r.kX(0);
          AppMethodBeat.o(155693);
          return localObject;
        }
        localObject = (TelephonyManager)aj.getContext().getSystemService("phone");
        try
        {
          ad.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getDeviceId, %s", new Object[] { bt.eGN() });
          localObject = ((TelephonyManager)localObject).getDeviceId();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            r.kX(5);
          }
          AppMethodBeat.o(155693);
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          r.kX(5);
          AppMethodBeat.o(155693);
        }
        return null;
      }
      
      final void Xl()
      {
        AppMethodBeat.i(155694);
        r.kX(3);
        AppMethodBeat.o(155694);
      }
    };
    fDt = new b(new d("c"))
    {
      final String Xk()
      {
        AppMethodBeat.i(155695);
        ad.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSerial, %s", new Object[] { bt.eGN() });
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
    fDu = new b(new d("d"))
    {
      final String Xk()
      {
        AppMethodBeat.i(155696);
        Object localObject = (WifiManager)aj.getContext().getSystemService("wifi");
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
    fDv = new b(new d("e"))
    {
      final String Xk()
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
    fDw = new b(new d("f")
    {
      final void Xj()
      {
        AppMethodBeat.i(155698);
        r.kX(14);
        AppMethodBeat.o(155698);
      }
      
      final void cH(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155699);
        if (paramAnonymousBoolean) {
          r.kX(12);
        }
        AppMethodBeat.o(155699);
      }
    })
    {
      final q.a fDC;
      
      final String Xk()
      {
        AppMethodBeat.i(155701);
        String str = this.fDC.pg(null);
        if (str != null)
        {
          r.kX(10);
          AppMethodBeat.o(155701);
          return str;
        }
        str = Build.MANUFACTURER + Build.MODEL + n.WK();
        AppMethodBeat.o(155701);
        return str;
      }
      
      final void Xl()
      {
        AppMethodBeat.i(155702);
        r.kX(13);
        AppMethodBeat.o(155702);
      }
    };
    fDx = new b(new d("g"))
    {
      final String Xk()
      {
        AppMethodBeat.i(155703);
        String str = Settings.Secure.getString(aj.getContext().getContentResolver(), "android_id");
        AppMethodBeat.o(155703);
        return str;
      }
    };
    fDy = new b(new d("h"))
    {
      final q.c fDD;
      
      final String Xk()
      {
        AppMethodBeat.i(155705);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(q.getAndroidId());
        Object localObject = this.fDD.pg(null);
        if (localObject == null)
        {
          localObject = q.cG(false);
          ad.w("MicroMsg.DeviceInfo", "[!] fail to fetch devId from deprecated cache, using getIMEI instead. value: %s", new Object[] { localObject });
        }
        for (boolean bool = false;; bool = true)
        {
          ad.i("MicroMsg.DeviceInfo", "[+] devId: %s, useDeprecatedDevId: %s", new Object[] { localObject, Boolean.valueOf(bool) });
          if (bool) {
            localStringBuilder.append((String)localObject);
          }
          for (;;)
          {
            localStringBuilder.append(q.WZ());
            localObject = localStringBuilder.toString();
            ad.i("MicroMsg.DeviceInfo", "[+] new mmguid, dev:%s", new Object[] { localObject });
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
              if (!this.fDD.fDI.fDb) {
                r.kX(28);
              }
            }
          }
        }
      }
    };
    fDz = new b(new d("i"))
    {
      final String Xk()
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
    fDA = new b(new d("j")
    {
      final void Xj()
      {
        AppMethodBeat.i(155688);
        r.kX(9);
        AppMethodBeat.o(155688);
      }
      
      final void cH(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(155689);
        if (paramAnonymousBoolean) {
          r.kX(7);
        }
        AppMethodBeat.o(155689);
      }
    })
    {
      final String Xk()
      {
        AppMethodBeat.i(155690);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(q.getAndroidId()).append('#').append(q.WZ()).append('#').append(System.currentTimeMillis()).append('#').append(SystemClock.elapsedRealtimeNanos());
        localObject = UUID.nameUUIDFromBytes(((StringBuilder)localObject).toString().getBytes(Charset.forName("UTF-8"))).toString();
        AppMethodBeat.o(155690);
        return localObject;
      }
      
      final void Xl()
      {
        AppMethodBeat.i(155691);
        r.kX(8);
        AppMethodBeat.o(155691);
      }
    };
    AppMethodBeat.o(155741);
  }
  
  public static void WS()
  {
    AppMethodBeat.i(155719);
    fDs.get();
    fDt.get();
    fDA.get();
    AppMethodBeat.o(155719);
  }
  
  public static String WT()
  {
    AppMethodBeat.i(155721);
    String str = cG(true);
    AppMethodBeat.o(155721);
    return str;
  }
  
  public static String WU()
  {
    AppMethodBeat.i(155722);
    Object localObject = (TelephonyManager)aj.getContext().getSystemService("phone");
    try
    {
      ad.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSubscriberId, %s", new Object[] { bt.eGN() });
      localObject = bt.nullAsNil(((TelephonyManager)localObject).getSubscriberId());
      AppMethodBeat.o(155722);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getIMSI", new Object[0]);
      AppMethodBeat.o(155722);
    }
    return "";
  }
  
  public static String WV()
  {
    AppMethodBeat.i(155723);
    String str = bt.nullAsNil(fDt.get());
    AppMethodBeat.o(155723);
    return str;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String WW()
  {
    AppMethodBeat.i(155724);
    Object localObject = (TelephonyManager)aj.getContext().getSystemService("phone");
    if (localObject != null) {}
    try
    {
      ad.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSimSerialNumber", new Object[] { bt.eGN() });
      localObject = bt.nullAsNil(((TelephonyManager)localObject).getSimSerialNumber());
      AppMethodBeat.o(155724);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getICCID", new Object[0]);
      AppMethodBeat.o(155724);
    }
    AppMethodBeat.o(155724);
    return "";
    return "";
  }
  
  public static String WX()
  {
    AppMethodBeat.i(155727);
    String str = bt.nullAsNil(fDu.get());
    AppMethodBeat.o(155727);
    return str;
  }
  
  public static String WY()
  {
    AppMethodBeat.i(155728);
    String str = bt.nullAsNil(fDv.get());
    AppMethodBeat.o(155728);
    return str;
  }
  
  public static String WZ()
  {
    AppMethodBeat.i(155729);
    String str = bt.nullAsNil(fDw.get());
    AppMethodBeat.o(155729);
    return str;
  }
  
  public static String Xa()
  {
    AppMethodBeat.i(155731);
    String str = bt.nullAsNil(fDy.get());
    AppMethodBeat.o(155731);
    return str;
  }
  
  public static void Xb()
  {
    AppMethodBeat.i(155732);
    ad.w("MicroMsg.DeviceInfo", "[!] MMGUID refreshed, old: %s, new: %s", new Object[] { fDy.get(), fDy.Xn() });
    AppMethodBeat.o(155732);
  }
  
  public static boolean Xc()
  {
    return true;
  }
  
  public static String Xd()
  {
    AppMethodBeat.i(155733);
    String str = bt.nullAsNil(fDA.get());
    AppMethodBeat.o(155733);
    return str;
  }
  
  public static String Xe()
  {
    AppMethodBeat.i(155735);
    String str = "android-" + Build.MODEL + "-" + Build.VERSION.SDK_INT;
    AppMethodBeat.o(155735);
    return str;
  }
  
  public static String Xf()
  {
    AppMethodBeat.i(155736);
    String str = bt.nullAsNil(fDz.get());
    AppMethodBeat.o(155736);
    return str;
  }
  
  /* Error */
  public static String[] Xg()
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_0
    //   2: ldc 250
    //   4: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 252	java/io/BufferedReader
    //   10: dup
    //   11: new 254	java/io/InputStreamReader
    //   14: dup
    //   15: ldc_w 256
    //   18: invokestatic 262	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: ldc_w 264
    //   24: invokespecial 267	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   27: invokespecial 270	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: new 218	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 275	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: ldc_w 277
    //   50: invokevirtual 283	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   53: astore 4
    //   55: aload_2
    //   56: astore_1
    //   57: iload_0
    //   58: aload 4
    //   60: arraylength
    //   61: if_icmpge +26 -> 87
    //   64: aload_2
    //   65: astore_1
    //   66: aload_3
    //   67: aload 4
    //   69: iload_0
    //   70: aaload
    //   71: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: bipush 32
    //   76: invokevirtual 286	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: iload_0
    //   81: iconst_1
    //   82: iadd
    //   83: istore_0
    //   84: goto -29 -> 55
    //   87: aload_2
    //   88: astore_1
    //   89: aload_3
    //   90: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 275	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   100: ldc_w 277
    //   103: invokevirtual 283	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   106: iconst_2
    //   107: aaload
    //   108: astore 4
    //   110: aload_2
    //   111: invokestatic 289	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   114: ldc 250
    //   116: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: iconst_2
    //   120: anewarray 279	java/lang/String
    //   123: dup
    //   124: iconst_0
    //   125: aload_3
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload 4
    //   131: aastore
    //   132: areturn
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: astore_1
    //   138: ldc 149
    //   140: aload_3
    //   141: ldc_w 291
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 175	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_2
    //   152: invokestatic 289	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   155: ldc 250
    //   157: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_2
    //   161: anewarray 279	java/lang/String
    //   164: dup
    //   165: iconst_0
    //   166: ldc 177
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: ldc_w 293
    //   174: aastore
    //   175: areturn
    //   176: astore_2
    //   177: aconst_null
    //   178: astore_1
    //   179: aload_1
    //   180: invokestatic 289	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   183: ldc 250
    //   185: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_2
    //   189: athrow
    //   190: astore_2
    //   191: goto -12 -> 179
    //   194: astore_3
    //   195: goto -59 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	83	0	i	int
    //   32	148	1	localBufferedReader1	java.io.BufferedReader
    //   30	122	2	localBufferedReader2	java.io.BufferedReader
    //   176	13	2	localObject1	Object
    //   190	1	2	localObject2	Object
    //   40	86	3	localObject3	Object
    //   133	8	3	localThrowable1	Throwable
    //   194	1	3	localThrowable2	Throwable
    //   53	77	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   7	31	133	java/lang/Throwable
    //   7	31	176	finally
    //   33	41	190	finally
    //   43	55	190	finally
    //   57	64	190	finally
    //   66	80	190	finally
    //   89	94	190	finally
    //   96	110	190	finally
    //   138	151	190	finally
    //   33	41	194	java/lang/Throwable
    //   43	55	194	java/lang/Throwable
    //   57	64	194	java/lang/Throwable
    //   66	80	194	java/lang/Throwable
    //   89	94	194	java/lang/Throwable
    //   96	110	194	java/lang/Throwable
  }
  
  /* Error */
  public static java.util.Map<String, String> Xh()
  {
    // Byte code:
    //   0: ldc_w 296
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 298	java/util/HashMap
    //   9: dup
    //   10: invokespecial 299	java/util/HashMap:<init>	()V
    //   13: astore_3
    //   14: new 252	java/io/BufferedReader
    //   17: dup
    //   18: new 254	java/io/InputStreamReader
    //   21: dup
    //   22: ldc_w 256
    //   25: invokestatic 262	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: ldc_w 264
    //   31: invokespecial 267	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: invokespecial 270	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 275	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +96 -> 142
    //   49: aload_1
    //   50: astore_0
    //   51: aload_2
    //   52: invokevirtual 302	java/lang/String:trim	()Ljava/lang/String;
    //   55: invokevirtual 305	java/lang/String:isEmpty	()Z
    //   58: ifne -20 -> 38
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: ldc_w 307
    //   67: invokevirtual 283	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   85: invokevirtual 302	java/lang/String:trim	()Ljava/lang/String;
    //   88: invokevirtual 310	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   91: aload_2
    //   92: iconst_1
    //   93: aaload
    //   94: invokevirtual 302	java/lang/String:trim	()Ljava/lang/String;
    //   97: invokeinterface 316 3 0
    //   102: pop
    //   103: goto -65 -> 38
    //   106: astore_2
    //   107: aload_1
    //   108: astore_0
    //   109: ldc 149
    //   111: aload_2
    //   112: ldc_w 318
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 175	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_1
    //   123: astore_0
    //   124: aload_3
    //   125: invokeinterface 321 1 0
    //   130: aload_1
    //   131: invokestatic 289	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   134: ldc_w 296
    //   137: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_3
    //   141: areturn
    //   142: aload_1
    //   143: invokestatic 289	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   146: goto -12 -> 134
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_0
    //   152: aload_0
    //   153: invokestatic 289	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   156: ldc_w 296
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
  
  public static int Xi()
  {
    AppMethodBeat.i(155739);
    try
    {
      Pattern localPattern = Pattern.compile("cpu[0-9]+");
      e[] arrayOfe = new e("/sys/devices/system/cpu").fhW();
      int m = arrayOfe.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        boolean bool = localPattern.matcher(arrayOfe[i].getName()).matches();
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
  
  public static String bV(Context paramContext)
  {
    AppMethodBeat.i(155725);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = bt.nullAsNil(paramContext.getSimOperatorName());
        AppMethodBeat.o(155725);
        return paramContext;
      }
      AppMethodBeat.o(155725);
      return "";
    }
    catch (Throwable paramContext)
    {
      ad.printErrStackTrace("MicroMsg.DeviceInfo", paramContext, "getMobileSPType", new Object[0]);
      AppMethodBeat.o(155725);
    }
    return "";
  }
  
  public static String cG(boolean paramBoolean)
  {
    AppMethodBeat.i(155720);
    String str = fDs.get();
    if (!bt.isNullOrNil(str))
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
    String str = bt.nullAsNil(fDx.get());
    AppMethodBeat.o(155730);
    return str;
  }
  
  public static String getOAID()
  {
    AppMethodBeat.i(155734);
    String str = bt.nullAsNil(b.ufs.getOAID());
    AppMethodBeat.o(155734);
    return str;
  }
  
  public static String getSimCountryIso()
  {
    AppMethodBeat.i(155726);
    try
    {
      Object localObject = (TelephonyManager)aj.getContext().getSystemService("phone");
      if (localObject != null)
      {
        localObject = bt.nullAsNil(((TelephonyManager)localObject).getSimCountryIso());
        AppMethodBeat.o(155726);
        return localObject;
      }
      AppMethodBeat.o(155726);
      return "";
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "getSimCountryIso", new Object[0]);
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
    private boolean fDE = false;
    private boolean fDF = false;
    private final byte[] fDG = new byte[0];
    private String mValue = null;
    
    protected abstract String Xm();
    
    final String pg(String paramString)
    {
      synchronized (this.fDG)
      {
        if (this.fDE)
        {
          paramString = this.mValue;
          return paramString;
        }
        this.mValue = Xm();
        if (this.mValue != null)
        {
          this.fDE = true;
          paramString = this.mValue;
          return paramString;
        }
      }
      return paramString;
    }
    
    final void ph(String paramString)
    {
      synchronized (this.fDG)
      {
        if ((this.fDE) && (TextUtils.equals(this.mValue, paramString))) {
          return;
        }
        this.mValue = paramString;
        this.fDE = true;
        this.fDF = true;
        pi(paramString);
        return;
      }
    }
    
    protected abstract void pi(String paramString);
  }
  
  static abstract class b
  {
    private final q.a fDH;
    
    b(q.a parama)
    {
      this.fDH = parama;
    }
    
    abstract String Xk();
    
    void Xl() {}
    
    final String Xn()
    {
      String str = Xk();
      if (!TextUtils.isEmpty(str)) {
        this.fDH.ph(str);
      }
      return str;
    }
    
    final String get()
    {
      String str = this.fDH.pg(null);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      Xl();
      return Xn();
    }
  }
  
  static final class c
    extends q.a
  {
    final l fDI;
    private final int mType;
    
    c(int paramInt)
    {
      super();
      AppMethodBeat.i(155706);
      this.fDI = l.WE();
      this.mType = paramInt;
      AppMethodBeat.o(155706);
    }
    
    protected final String Xm()
    {
      AppMethodBeat.i(155707);
      String str = (String)this.fDI.get(this.mType);
      if ((str == null) && (!this.fDI.fDb)) {
        switch (this.mType)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(155707);
        return str;
        r.kX(27);
        continue;
        r.kX(26);
        continue;
        r.kX(25);
      }
    }
    
    protected final void pi(String paramString)
    {
      AppMethodBeat.i(155708);
      this.fDI.set(this.mType, paramString);
      AppMethodBeat.o(155708);
    }
  }
  
  static class d
    extends q.a
  {
    private static final Set<String> fDJ;
    private final String fDK;
    private final int fDL;
    private final e fDM;
    private final q.e fDN;
    private final boolean fDO;
    
    static
    {
      AppMethodBeat.i(155714);
      fDJ = new HashSet();
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
      if (fDJ.contains(paramString))
      {
        paramString = new IllegalArgumentException("name: " + paramString + " is duplicated.");
        AppMethodBeat.o(155709);
        throw paramString;
      }
      fDJ.add(paramString);
      this.fDK = UUID.nameUUIDFromBytes(paramString.getBytes(Charset.forName("UTF-8"))).toString();
      this.fDL = 5;
      this.fDN = new q.e(paramString);
      for (;;)
      {
        try
        {
          this.fDN.lock();
          this.fDM = new e(aj.getContext().getFilesDir().getParentFile(), ".auth_cache/" + this.fDK);
          if (this.fDM.exists()) {
            this.fDO = false;
          }
        }
        finally
        {
          this.fDN.unlock();
          AppMethodBeat.o(155709);
        }
        try
        {
          this.fDN.unlock();
          return;
        }
        finally
        {
          AppMethodBeat.o(155709);
        }
        this.fDO = true;
        if (!this.fDM.mkdirs()) {
          ad.e("MicroMsg.DeviceInfo", "[-] Fail to make base dir: %s", new Object[] { com.tencent.mm.vfs.q.B(this.fDM.fhU()) });
        }
      }
    }
    
    /* Error */
    private static boolean c(e parame, String paramString)
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
      //   17: invokevirtual 141	com/tencent/mm/vfs/e:exists	()Z
      //   20: ifeq +103 -> 123
      //   23: aload_3
      //   24: astore_2
      //   25: new 178	java/io/PrintWriter
      //   28: dup
      //   29: new 180	com/tencent/mm/vfs/l
      //   32: dup
      //   33: aload_0
      //   34: invokespecial 183	com/tencent/mm/vfs/l:<init>	(Lcom/tencent/mm/vfs/e;)V
      //   37: invokespecial 186	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   40: invokevirtual 189	java/io/PrintWriter:close	()V
      //   43: aload_3
      //   44: astore_2
      //   45: new 178	java/io/PrintWriter
      //   48: dup
      //   49: new 180	com/tencent/mm/vfs/l
      //   52: dup
      //   53: aload_0
      //   54: invokespecial 183	com/tencent/mm/vfs/l:<init>	(Lcom/tencent/mm/vfs/e;)V
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
      //   113: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
      //   116: ldc 176
      //   118: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   121: iconst_1
      //   122: ireturn
      //   123: aconst_null
      //   124: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
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
      //   152: invokevirtual 159	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
      //   155: invokestatic 165	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
      //   158: aastore
      //   159: invokestatic 220	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   162: aload_1
      //   163: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
      //   166: ldc 176
      //   168: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   171: iconst_0
      //   172: ireturn
      //   173: astore_0
      //   174: aload_2
      //   175: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
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
      //   0	199	0	parame	e
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
    private static String d(e parame)
    {
      // Byte code:
      //   0: ldc 222
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 224	com/tencent/mm/vfs/k
      //   8: dup
      //   9: aload_0
      //   10: invokespecial 225	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/e;)V
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
      //   62: invokestatic 242	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   65: aload 6
      //   67: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
      //   70: aload_0
      //   71: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
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
      //   173: invokestatic 242	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   176: aload 6
      //   178: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
      //   181: aload_0
      //   182: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
      //   185: ldc 222
      //   187: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   190: aconst_null
      //   191: areturn
      //   192: aload 6
      //   194: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
      //   197: aload_0
      //   198: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
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
      //   232: invokestatic 220	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   235: aload_0
      //   236: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
      //   239: aload 5
      //   241: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
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
      //   258: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
      //   261: aload_0
      //   262: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
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
      //   0	310	0	parame	e
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
    
    void Xj() {}
    
    public final String Xm()
    {
      label54:
      label183:
      try
      {
        AppMethodBeat.i(155710);
        try
        {
          this.fDN.lock();
          if (this.fDM.exists()) {
            break label54;
          }
          ad.e("MicroMsg.DeviceInfo", "[-] Base dir does not exist, base cache will return defValue.");
          this.fDN.unlock();
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
            ad.printErrStackTrace("MicroMsg.DeviceInfo", localThrowable, "[-] Exception occurred when fetch value, base cache will return defValue.", new Object[0]);
            this.fDN.unlock();
            AppMethodBeat.o(155710);
            localObject2 = null;
          }
        }
        finally
        {
          this.fDN.unlock();
          AppMethodBeat.o(155710);
        }
        return localObject1;
      }
      finally {}
      k = this.fDL;
      int i = 0;
      j = 0;
      for (;;)
      {
        if (i < this.fDL)
        {
          localObject1 = new e(this.fDM, String.valueOf(i));
          if (!((e)localObject1).exists())
          {
            k -= 1;
            break label249;
          }
          localObject1 = d((e)localObject1);
          if (localObject1 != null)
          {
            this.fDN.unlock();
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
          cH(bool);
          ad.w("MicroMsg.DeviceInfo", "[!] Cache missed, base cache will return defValue.");
          this.fDN.unlock();
          AppMethodBeat.o(155710);
          localObject1 = null;
          break;
        }
        Object localObject2;
        label249:
        i += 1;
      }
    }
    
    void cH(boolean paramBoolean) {}
    
    /* Error */
    public final void pi(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 285
      //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:fDN	Lcom/tencent/mm/compatible/deviceinfo/q$e;
      //   12: invokevirtual 112	com/tencent/mm/compatible/deviceinfo/q$e:lock	()V
      //   15: aload_0
      //   16: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:fDM	Lcom/tencent/mm/vfs/e;
      //   19: invokevirtual 141	com/tencent/mm/vfs/e:exists	()Z
      //   22: ifne +31 -> 53
      //   25: ldc 151
      //   27: ldc_w 287
      //   30: invokestatic 242	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   33: aload_0
      //   34: invokevirtual 289	com/tencent/mm/compatible/deviceinfo/q$d:Xj	()V
      //   37: aload_0
      //   38: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:fDN	Lcom/tencent/mm/compatible/deviceinfo/q$e;
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
      //   59: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:fDL	I
      //   62: if_icmpge +62 -> 124
      //   65: new 114	com/tencent/mm/vfs/e
      //   68: dup
      //   69: aload_0
      //   70: getfield 138	com/tencent/mm/compatible/deviceinfo/q$d:fDM	Lcom/tencent/mm/vfs/e;
      //   73: iload_2
      //   74: invokestatic 267	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   77: invokespecial 270	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
      //   80: astore 5
      //   82: aload 5
      //   84: invokevirtual 292	com/tencent/mm/vfs/e:isDirectory	()Z
      //   87: ifeq +17 -> 104
      //   90: ldc 151
      //   92: ldc_w 294
      //   95: invokestatic 281	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   98: aload 5
      //   100: invokevirtual 297	com/tencent/mm/vfs/e:delete	()Z
      //   103: pop
      //   104: iload_3
      //   105: istore 4
      //   107: aload 5
      //   109: aload_1
      //   110: invokestatic 299	com/tencent/mm/compatible/deviceinfo/q$d:c	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)Z
      //   113: ifne +60 -> 173
      //   116: iload_3
      //   117: iconst_1
      //   118: iadd
      //   119: istore 4
      //   121: goto +52 -> 173
      //   124: iload_3
      //   125: aload_0
      //   126: getfield 104	com/tencent/mm/compatible/deviceinfo/q$d:fDL	I
      //   129: if_icmpne +7 -> 136
      //   132: aload_0
      //   133: invokevirtual 289	com/tencent/mm/compatible/deviceinfo/q$d:Xj	()V
      //   136: aload_0
      //   137: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:fDN	Lcom/tencent/mm/compatible/deviceinfo/q$e;
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
      //   159: getfield 109	com/tencent/mm/compatible/deviceinfo/q$d:fDN	Lcom/tencent/mm/compatible/deviceinfo/q$e;
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
      //   80	28	5	locale	e
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
    private volatile LocalServerSocket fDP;
    private volatile int fDQ;
    private final String mName;
    
    e(String paramString)
    {
      AppMethodBeat.i(155715);
      this.fDP = null;
      this.fDQ = 0;
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
          LocalServerSocket localLocalServerSocket = this.fDP;
          if (localLocalServerSocket == null)
          {
            try
            {
              this.fDP = new LocalServerSocket(this.mName);
              this.fDQ += 1;
              AppMethodBeat.o(155716);
            }
            catch (Throwable localThrowable)
            {
              this.fDP = null;
              bool = false;
              AppMethodBeat.o(155716);
              continue;
            }
            return bool;
          }
        }
        finally {}
        this.fDQ += 1;
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
      //   8: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:fDQ	I
      //   11: ifle +13 -> 24
      //   14: aload_0
      //   15: aload_0
      //   16: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:fDQ	I
      //   19: iconst_1
      //   20: isub
      //   21: putfield 29	com/tencent/mm/compatible/deviceinfo/q$e:fDQ	I
      //   24: aload_0
      //   25: getfield 29	com/tencent/mm/compatible/deviceinfo/q$e:fDQ	I
      //   28: ifne +64 -> 92
      //   31: aload_0
      //   32: getfield 27	com/tencent/mm/compatible/deviceinfo/q$e:fDP	Landroid/net/LocalServerSocket;
      //   35: astore_1
      //   36: aload_1
      //   37: ifnull +55 -> 92
      //   40: aload_0
      //   41: getfield 27	com/tencent/mm/compatible/deviceinfo/q$e:fDP	Landroid/net/LocalServerSocket;
      //   44: invokevirtual 72	android/net/LocalServerSocket:close	()V
      //   47: aload_0
      //   48: aconst_null
      //   49: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:fDP	Landroid/net/LocalServerSocket;
      //   52: ldc 69
      //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_0
      //   58: monitorexit
      //   59: return
      //   60: astore_1
      //   61: aload_0
      //   62: aconst_null
      //   63: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:fDP	Landroid/net/LocalServerSocket;
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
      //   82: putfield 27	com/tencent/mm/compatible/deviceinfo/q$e:fDP	Landroid/net/LocalServerSocket;
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