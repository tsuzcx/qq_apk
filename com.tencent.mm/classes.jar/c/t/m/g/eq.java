package c.t.m.g;

import android.content.Context;
import android.telephony.TelephonyManager;

public final class eq
{
  private static eq a = null;
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_m1
    //   5: ireturn
    //   6: aload_0
    //   7: invokestatic 26	c/t/m/g/eq:b	(Landroid/content/Context;)Z
    //   10: istore 9
    //   12: aload_0
    //   13: ldc 28
    //   15: invokevirtual 34	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   18: checkcast 36	android/net/wifi/WifiManager
    //   21: astore 10
    //   23: aload 10
    //   25: ifnull +296 -> 321
    //   28: aload 10
    //   30: invokevirtual 40	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   33: istore 7
    //   35: iload 7
    //   37: ifeq +160 -> 197
    //   40: iconst_1
    //   41: istore_1
    //   42: getstatic 46	android/os/Build$VERSION:SDK_INT	I
    //   45: bipush 18
    //   47: if_icmplt +145 -> 192
    //   50: aload 10
    //   52: invokevirtual 49	android/net/wifi/WifiManager:isScanAlwaysAvailable	()Z
    //   55: istore 7
    //   57: iload 7
    //   59: ifeq +133 -> 192
    //   62: iconst_1
    //   63: istore_3
    //   64: iconst_1
    //   65: istore_2
    //   66: iload_1
    //   67: istore 4
    //   69: aload_0
    //   70: ldc 51
    //   72: invokevirtual 34	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: checkcast 53	android/location/LocationManager
    //   78: astore 10
    //   80: aload 10
    //   82: ifnull +51 -> 133
    //   85: aload_0
    //   86: invokevirtual 57	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   89: ldc 59
    //   91: invokestatic 65	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   94: istore_1
    //   95: aload 10
    //   97: ldc 67
    //   99: invokevirtual 71	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   102: istore 8
    //   104: aload 10
    //   106: invokevirtual 75	android/location/LocationManager:getAllProviders	()Ljava/util/List;
    //   109: astore_0
    //   110: aload_0
    //   111: ifnonnull +9 -> 120
    //   114: iconst_0
    //   115: istore 7
    //   117: goto +85 -> 202
    //   120: aload_0
    //   121: ldc 67
    //   123: invokeinterface 81 2 0
    //   128: istore 7
    //   130: goto +72 -> 202
    //   133: iconst_0
    //   134: istore 7
    //   136: iconst_0
    //   137: istore_1
    //   138: iconst_0
    //   139: istore 8
    //   141: goto +61 -> 202
    //   144: astore_0
    //   145: iconst_0
    //   146: istore_1
    //   147: iconst_0
    //   148: istore 7
    //   150: iconst_0
    //   151: istore 8
    //   153: goto +49 -> 202
    //   156: iload 4
    //   158: sipush 128
    //   161: iadd
    //   162: ireturn
    //   163: iload 4
    //   165: sipush 256
    //   168: iadd
    //   169: ireturn
    //   170: iload 4
    //   172: sipush 512
    //   175: iadd
    //   176: ireturn
    //   177: astore_0
    //   178: goto -31 -> 147
    //   181: astore 10
    //   183: goto +160 -> 343
    //   186: iconst_0
    //   187: istore 6
    //   189: goto +21 -> 210
    //   192: iconst_1
    //   193: istore_2
    //   194: goto +131 -> 325
    //   197: iconst_0
    //   198: istore_1
    //   199: goto -157 -> 42
    //   202: iload 9
    //   204: ifne -18 -> 186
    //   207: iconst_1
    //   208: istore 6
    //   210: iload 6
    //   212: istore 5
    //   214: iload 4
    //   216: ifne +9 -> 225
    //   219: iload 6
    //   221: iconst_2
    //   222: iadd
    //   223: istore 5
    //   225: iload 5
    //   227: istore 4
    //   229: iload 8
    //   231: ifne +9 -> 240
    //   234: iload 5
    //   236: iconst_4
    //   237: iadd
    //   238: istore 4
    //   240: iload 4
    //   242: istore 5
    //   244: iload_3
    //   245: ifne +10 -> 255
    //   248: iload 4
    //   250: bipush 8
    //   252: iadd
    //   253: istore 5
    //   255: iload 5
    //   257: istore_3
    //   258: iload 7
    //   260: ifne +9 -> 269
    //   263: iload 5
    //   265: bipush 16
    //   267: iadd
    //   268: istore_3
    //   269: iload_3
    //   270: istore 4
    //   272: iload_2
    //   273: ifne +9 -> 282
    //   276: iload_3
    //   277: bipush 32
    //   279: iadd
    //   280: istore 4
    //   282: iload_1
    //   283: tableswitch	default:+29 -> 312, 0:+32->315, 1:+-127->156, 2:+-120->163, 3:+-113->170
    //   313: iconst_1
    //   314: ireturn
    //   315: iload 4
    //   317: bipush 64
    //   319: iadd
    //   320: ireturn
    //   321: iconst_0
    //   322: istore_2
    //   323: iconst_0
    //   324: istore_1
    //   325: iconst_0
    //   326: istore 4
    //   328: iload_2
    //   329: istore_3
    //   330: iload 4
    //   332: istore_2
    //   333: iload_1
    //   334: istore 4
    //   336: goto -267 -> 69
    //   339: astore 10
    //   341: iconst_0
    //   342: istore_1
    //   343: iconst_0
    //   344: istore_3
    //   345: iconst_0
    //   346: istore_2
    //   347: iload_1
    //   348: istore 4
    //   350: goto -281 -> 69
    //   353: astore_0
    //   354: iconst_0
    //   355: istore_1
    //   356: goto -261 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramContext	Context
    //   41	315	1	i	int
    //   65	282	2	j	int
    //   63	282	3	k	int
    //   67	282	4	m	int
    //   212	56	5	n	int
    //   187	36	6	i1	int
    //   33	226	7	bool1	boolean
    //   102	128	8	bool2	boolean
    //   10	193	9	bool3	boolean
    //   21	84	10	localObject	Object
    //   181	1	10	localThrowable1	java.lang.Throwable
    //   339	1	10	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   69	80	144	java/lang/Exception
    //   85	95	144	java/lang/Exception
    //   95	110	177	java/lang/Exception
    //   120	130	177	java/lang/Exception
    //   42	57	181	java/lang/Throwable
    //   12	23	339	java/lang/Throwable
    //   28	35	339	java/lang/Throwable
    //   85	95	353	java/lang/Throwable
  }
  
  public static eq a()
  {
    if (a == null) {
      a = new eq();
    }
    return a;
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.getSimState();
      return i == 5;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.eq
 * JD-Core Version:    0.7.0.1
 */