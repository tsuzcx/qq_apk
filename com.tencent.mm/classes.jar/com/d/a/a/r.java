package com.d.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import java.text.DecimalFormat;
import org.json.JSONObject;

final class r
  extends d
{
  private static final DecimalFormat aYB = new DecimalFormat("0000000000");
  private static final DecimalFormat aYC = new DecimalFormat("0000000000000000");
  private static r aYD;
  private String aYE;
  private String aYF;
  private final r.b aYG = new r.b((byte)0);
  private int aYH;
  z aYI;
  private SharedPreferences aYJ;
  private f aYK;
  private final Object aYL = new Object();
  private final r.d aYM = new r.d(this, (byte)0);
  q aYN;
  String aYO;
  private int mRetryCount;
  
  private static String a(Long paramLong)
  {
    if (paramLong == null) {
      throw new Exception("OnlineModule: null source id");
    }
    try
    {
      paramLong = aYB.format(paramLong);
      return paramLong;
    }
    catch (NumberFormatException paramLong)
    {
      throw new Exception("OnlineModule: invalid source id");
    }
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private void aP(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 72	com/d/a/a/r:aYL	Ljava/lang/Object;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: new 122	java/lang/StringBuilder
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 271	com/d/a/a/r:pn	()Landroid/content/SharedPreferences;
    //   22: ldc_w 273
    //   25: ldc_w 275
    //   28: invokeinterface 281 3 0
    //   33: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 139	java/lang/String:length	()I
    //   53: ldc_w 287
    //   56: isub
    //   57: istore_2
    //   58: aload 4
    //   60: astore_1
    //   61: iload_2
    //   62: ifle +25 -> 87
    //   65: aload 4
    //   67: ldc_w 289
    //   70: iload_2
    //   71: invokevirtual 293	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   74: istore_3
    //   75: iload_3
    //   76: iload_2
    //   77: if_icmplt +51 -> 128
    //   80: aload 4
    //   82: iload_3
    //   83: invokevirtual 297	java/lang/String:substring	(I)Ljava/lang/String;
    //   86: astore_1
    //   87: getstatic 302	android/os/Build$VERSION:SDK_INT	I
    //   90: bipush 9
    //   92: if_icmplt +43 -> 135
    //   95: aload_0
    //   96: invokespecial 271	com/d/a/a/r:pn	()Landroid/content/SharedPreferences;
    //   99: invokeinterface 306 1 0
    //   104: ldc_w 273
    //   107: aload_1
    //   108: invokeinterface 312 3 0
    //   113: invokeinterface 315 1 0
    //   118: aload 5
    //   120: monitorexit
    //   121: return
    //   122: astore_1
    //   123: aload 5
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: ldc_w 275
    //   131: astore_1
    //   132: goto -45 -> 87
    //   135: aload_0
    //   136: invokespecial 271	com/d/a/a/r:pn	()Landroid/content/SharedPreferences;
    //   139: invokeinterface 306 1 0
    //   144: ldc_w 273
    //   147: aload_1
    //   148: invokeinterface 312 3 0
    //   153: invokeinterface 318 1 0
    //   158: pop
    //   159: goto -41 -> 118
    //   162: astore_1
    //   163: goto -45 -> 118
    //   166: astore_1
    //   167: getstatic 302	android/os/Build$VERSION:SDK_INT	I
    //   170: bipush 9
    //   172: if_icmplt +31 -> 203
    //   175: aload_0
    //   176: invokespecial 271	com/d/a/a/r:pn	()Landroid/content/SharedPreferences;
    //   179: invokeinterface 306 1 0
    //   184: ldc_w 273
    //   187: ldc_w 275
    //   190: invokeinterface 312 3 0
    //   195: invokeinterface 315 1 0
    //   200: goto -82 -> 118
    //   203: aload_0
    //   204: invokespecial 271	com/d/a/a/r:pn	()Landroid/content/SharedPreferences;
    //   207: invokeinterface 306 1 0
    //   212: ldc_w 273
    //   215: ldc_w 275
    //   218: invokeinterface 312 3 0
    //   223: invokeinterface 318 1 0
    //   228: pop
    //   229: goto -111 -> 118
    //   232: astore_1
    //   233: goto -115 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	r
    //   0	236	1	paramString	String
    //   57	21	2	i	int
    //   74	9	3	j	int
    //   46	35	4	str	String
    // Exception table:
    //   from	to	target	type
    //   14	58	122	finally
    //   65	75	122	finally
    //   80	87	122	finally
    //   87	118	122	finally
    //   118	121	122	finally
    //   123	126	122	finally
    //   135	159	122	finally
    //   167	200	122	finally
    //   203	229	122	finally
    //   14	58	162	java/lang/Exception
    //   65	75	162	java/lang/Exception
    //   80	87	162	java/lang/Exception
    //   87	118	162	java/lang/Exception
    //   135	159	162	java/lang/Exception
    //   14	58	166	java/lang/Error
    //   65	75	166	java/lang/Error
    //   80	87	166	java/lang/Error
    //   87	118	166	java/lang/Error
    //   135	159	166	java/lang/Error
    //   167	200	232	java/lang/Exception
    //   203	229	232	java/lang/Exception
  }
  
  private static String aQ(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      long l2 = System.currentTimeMillis();
      paramString = "T" + aYC.format(l1 + l2);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      throw new Exception("OnlineModule: invalid device id, type: 0");
    }
  }
  
  private static r.f d(String paramString, long paramLong1, long paramLong2)
  {
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("errorcode", -5);
      if (i != 0) {
        return new r.f(i, null, null, (byte)0);
      }
      l = paramString.optLong("hitarea", 0L);
      paramString = new String(Base64.decode(paramString.optString("swdata", null), 0), "UTF-8");
      if (y.bbL) {
        o.m("data_transaction_log_" + y.bbS, paramString);
      }
      if ((paramString.length() <= h.aWj) || (!paramString.startsWith("$UP,"))) {
        throw new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
      }
    }
    catch (Exception paramString)
    {
      if (y.bbL) {
        o.m("data_transaction_log_" + y.bbS, "parse json data error");
      }
      throw new Exception("parse json data error");
    }
    switch (paramString.charAt(h.aWj))
    {
    default: 
    case '1': 
      do
      {
        throw new Exception("OnlineModule: unable to parse data upload reply");
      } while (paramString.length() <= h.aWk);
      paramString = e(paramString.substring(h.aWk), l);
      paramString.bbz = paramLong1;
      paramString.aYW = paramLong2;
      return new r.f(1, paramString, null, (byte)0);
    case '0': 
      if (paramString.length() > h.aWk) {}
      for (paramString = paramString.substring(h.aWk);; paramString = null) {
        return new r.f(0, null, paramString, (byte)0);
      }
    case '2': 
      if (paramString.length() > h.aWk) {}
      for (paramString = paramString.substring(h.aWk);; paramString = null) {
        return new r.f(2, null, paramString, (byte)0);
      }
    case '3': 
      if (paramString.length() > h.aWk) {}
      for (paramString = paramString.substring(h.aWk);; paramString = null) {
        return new r.f(3, null, paramString, (byte)0);
      }
    case '4': 
      if (paramString.length() > h.aWk) {}
      for (paramString = paramString.substring(h.aWk);; paramString = null) {
        return new r.f(4, null, paramString, (byte)0);
      }
    case '5': 
      if (paramString.length() > h.aWk) {}
      for (paramString = paramString.substring(h.aWk);; paramString = null) {
        return new r.f(5, null, paramString, (byte)0);
      }
    }
    if (paramString.length() > h.aWk) {}
    for (paramString = paramString.substring(h.aWk);; paramString = null) {
      return new r.f(6, null, paramString, (byte)0);
    }
  }
  
  private static x e(String paramString, long paramLong)
  {
    int m = 0;
    if (paramString != null)
    {
      paramString = paramString.split(",", -1);
      if (paramString.length == 10) {
        try
        {
          double d1 = Double.parseDouble(paramString[0]);
          double d2 = Double.parseDouble(paramString[1]);
          float f3 = Float.parseFloat(paramString[8]);
          try
          {
            i = Integer.parseInt(paramString[3]);
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            try
            {
              j = Integer.parseInt(paramString[4]);
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              try
              {
                for (;;)
                {
                  k = Integer.parseInt(paramString[5]);
                  try
                  {
                    int n = Integer.parseInt(paramString[7]);
                    m = n;
                  }
                  catch (NumberFormatException localNumberFormatException5)
                  {
                    label84:
                    float f1;
                    break label84;
                  }
                  f1 = 0.0F;
                  try
                  {
                    float f2 = Float.parseFloat(paramString[9]);
                    f1 = f2;
                  }
                  catch (NumberFormatException localNumberFormatException4)
                  {
                    label100:
                    x localx;
                    break label100;
                  }
                  localx = new x();
                  localx.latitude = d1;
                  localx.longitude = d2;
                  localx.bbw = paramString[2];
                  localx.level = i;
                  localx.bby = j;
                  localx.bbB = k;
                  localx.bbx = paramString[6];
                  localx.bbC = m;
                  localx.aXH = f3;
                  if (localx.bbA == null) {
                    localx.bbA = new x.a();
                  }
                  localx.bbA.bbD = f1;
                  localx.aYm = paramLong;
                  return localx;
                  localNumberFormatException1 = localNumberFormatException1;
                  int i = 0;
                  continue;
                  localNumberFormatException2 = localNumberFormatException2;
                  int j = 0;
                }
              }
              catch (NumberFormatException localNumberFormatException3)
              {
                for (;;)
                {
                  int k = 0;
                }
              }
            }
          }
          throw new Exception("OnlineModule: unable to get location from data upload reply");
        }
        catch (NumberFormatException paramString) {}
      }
    }
  }
  
  private void f(String paramString, long paramLong)
  {
    Object localObject = null;
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.startsWith("&OD[]=")) {
        str = paramString;
      }
    }
    else
    {
      aP(str);
      return;
    }
    paramString = v.aS(v.aT(paramString));
    if (paramString == null)
    {
      paramString = null;
      label44:
      if (paramString != null) {
        break label78;
      }
    }
    label78:
    for (paramString = localObject;; paramString = paramString.replace("&WD[]=", "|WD,"))
    {
      str = v.a(paramString, paramLong, "1");
      break;
      paramString = paramString.replace("&MD=", "|MD,");
      break label44;
    }
  }
  
  static r pi()
  {
    if (aYD == null) {
      aYD = new r();
    }
    return aYD;
  }
  
  private String pl()
  {
    try
    {
      String str = pn().getString("1-115-10127", "");
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  @SuppressLint({"NewApi"})
  private void pm()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        pn().edit().remove("1-115-10127").apply();
        return;
      }
      pn().edit().remove("1-115-10127").commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  private SharedPreferences pn()
  {
    if (this.aYJ == null) {
      throw new Exception("OnlineModule: data buffer unavailable");
    }
    return this.aYJ;
  }
  
  private void po()
  {
    String str2;
    r.b localb;
    try
    {
      String str1 = this.aYE;
      str2 = this.aYF;
      localb = this.aYG;
      if ((str1 == null) || (str2 == null) || (localb == null)) {
        throw new Exception("OnlineModule: authenticate: null arg");
      }
    }
    finally {}
    System.arraycopy((localObject + str2).getBytes(), 0, localb.aYQ, 0, 27);
    localb.code = 1;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    this.aYI = z.b(paramHandler);
    pj();
  }
  
  final void aO(String paramString)
  {
    if (this.aYI != null) {
      this.aYI.execute(new r.c(this, paramString, 0L, 1, (byte)0));
    }
  }
  
  final void aa(Context paramContext)
  {
    try
    {
      String str2 = this.aYO;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0000000000";
      }
      this.aYE = aQ(str1);
      this.aYF = a(Long.valueOf(System.currentTimeMillis() / 1000L));
      this.aYK = new f(paramContext);
    }
    catch (Exception localException)
    {
      label54:
      break label54;
    }
    this.aYJ = paramContext.getSharedPreferences("0-474-85242", 0);
  }
  
  final void ab(Context paramContext) {}
  
  final void oX()
  {
    this.aYN = null;
  }
  
  final void pj()
  {
    if (this.aYI != null) {}
    try
    {
      this.aYI.execute(r.d.a(this.aYM));
      return;
    }
    catch (Exception localException) {}
  }
  
  final boolean pk()
  {
    return this.aYG.code == 1;
  }
  
  private static final class e
    extends r.a
  {
    private final String aYS;
    private final long aYT;
    private final long aYW;
    private final boolean aYX;
    private final int aYi;
    
    private e(r paramr, String paramString, long paramLong1, long paramLong2, int paramInt)
    {
      super((byte)0);
      this.aYS = paramString;
      this.aYT = paramLong1;
      this.aYW = paramLong2;
      this.aYi = paramInt;
      this.aYX = true;
    }
    
    public final void run()
    {
      try
      {
        r.a(pp(), this.aYS, this.aYT, this.aYW, this.aYi, this.aYX);
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.r
 * JD-Core Version:    0.7.0.1
 */