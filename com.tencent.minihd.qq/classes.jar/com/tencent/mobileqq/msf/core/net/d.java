package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.b.f;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class d
{
  private static final String a = "LightHttpEngine";
  private String b;
  private URL c;
  private int d = 10000;
  private int e = 30000;
  private int f = 0;
  private HttpURLConnection g;
  private int h;
  private String i;
  
  public d(int paramInt)
  {
    this.f = paramInt;
  }
  
  private String a(String paramString)
  {
    if (NetConnInfoCenterImpl.getSystemNetworkType() == 0) {
      return q.m.toString();
    }
    if (paramString.indexOf("illegal") > -1) {
      return q.g.toString();
    }
    if (paramString.indexOf("route to host") > -1) {
      return q.q.toString();
    }
    if (paramString.indexOf("unreachable") > -1) {
      return q.m.toString();
    }
    if (paramString.indexOf("permission") > -1) {
      return q.i.toString();
    }
    if (paramString.indexOf("refused") > -1) {
      return q.s.toString();
    }
    if (paramString.indexOf("reset") > -1) {
      return q.r.toString();
    }
    if ((paramString.indexOf("timeoutexception") > -1) || (paramString.indexOf(") after") > -1)) {
      return q.t.toString();
    }
    if (paramString.indexOf("unknownhost") > -1) {
      return q.p.toString();
    }
    if (paramString.indexOf("unresolved") > -1) {
      return q.o.toString();
    }
    if (paramString.indexOf("enotsock") > -1) {
      return q.h.toString();
    }
    if (paramString.indexOf("enobufs") > -1) {
      return q.l.toString();
    }
    if (paramString.indexOf("ebadf") > -1) {
      return q.j.toString();
    }
    if (paramString.indexOf("operation") > -1) {
      return q.t.toString();
    }
    if (paramString.indexOf("invalid") > -1) {
      return q.n.toString();
    }
    return q.u.toString();
  }
  
  private String b(String paramString)
  {
    Object localObject = new Random(System.currentTimeMillis());
    localObject = "r=" + String.valueOf(((Random)localObject).nextInt(100000));
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?")) {
        return paramString + (String)localObject;
      }
      return (String)localObject + "&" + (String)localObject;
    }
    return "?" + (String)localObject;
  }
  
  public void a()
  {
    QLog.d("LightHttpEngine", 1, "LightHttpEngine disconn " + this.b + " ssoseq:" + this.f);
    if (this.g != null) {
      this.g.disconnect();
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, f paramf)
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      this.e = a.O();
      l1 = l2;
      paramString1 = "http://" + paramString1 + ":" + paramInt;
      l1 = l2;
      this.b = (paramString1 + b(paramString1));
      l1 = l2;
      this.b = MsfSdkUtils.insertMtype(paramString2, this.b);
      l1 = l2;
      QLog.d("LightHttpEngine", 1, "LightHttpEngine try connect " + this.b + " timeout:" + this.d + " ssoseq:" + this.f);
      l1 = l2;
      l2 = SystemClock.elapsedRealtime();
      l1 = l2;
      this.c = new URL(this.b);
      l1 = l2;
      this.g = ((HttpURLConnection)this.c.openConnection());
      l1 = l2;
      this.g.setDoOutput(true);
      l1 = l2;
      this.g.setDoInput(true);
      l1 = l2;
      this.g.setUseCaches(false);
      l1 = l2;
      this.g.setReadTimeout(this.e);
      l1 = l2;
      this.g.setRequestMethod("POST");
      l1 = l2;
      this.g.setRequestProperty("User-Agent", "aqq");
      l1 = l2;
      this.g.setRequestProperty("content-type", "oct");
      l1 = l2;
      this.g.setConnectTimeout(this.d);
      l1 = l2;
      this.g.setRequestProperty("Connection", "close");
      l1 = l2;
      this.g.setRequestProperty("Accept-Encoding", "");
      l1 = l2;
      this.g.connect();
      l1 = l2;
      long l3 = SystemClock.elapsedRealtime();
      l1 = l2;
      QLog.d("LightHttpEngine", 1, "LightHttpEngine connect " + this.b + " succ costtime:" + (l3 - l2) + " ssoseq:" + this.f + " readTimeout:" + this.e);
      return true;
    }
    catch (Throwable paramString1)
    {
      l2 = SystemClock.elapsedRealtime();
    }
    try
    {
      if (this.g != null) {
        this.g.disconnect();
      }
      paramString1.printStackTrace();
      paramString1 = a(paramString1.toString().toLowerCase());
      paramString2 = new StringBuilder(paramf.l);
      paramString2.append("|").append(paramString1);
      paramf.l = paramString2.toString();
      QLog.d("LightHttpEngine", 1, "LightHttpEngine connect " + this.b + " fail costtime:" + (l2 - l1) + " ssoseq:" + this.f + " reason:" + paramString1);
      return false;
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  /* Error */
  public byte[] a(byte[] paramArrayOfByte, f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: lconst_0
    //   7: lstore 4
    //   9: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   12: lstore 6
    //   14: lload 6
    //   16: lstore 4
    //   18: aload_0
    //   19: getfield 178	com/tencent/mobileqq/msf/core/net/d:g	Ljava/net/HttpURLConnection;
    //   22: invokevirtual 301	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   25: astore 8
    //   27: aload 8
    //   29: aload_1
    //   30: invokevirtual 307	java/io/OutputStream:write	([B)V
    //   33: aload 8
    //   35: invokevirtual 310	java/io/OutputStream:flush	()V
    //   38: ldc 8
    //   40: iconst_1
    //   41: new 133	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 312
    //   51: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 30	com/tencent/mobileqq/msf/core/net/d:f	I
    //   58: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 314
    //   64: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: arraylength
    //   69: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 178	com/tencent/mobileqq/msf/core/net/d:g	Ljava/net/HttpURLConnection;
    //   83: invokevirtual 317	java/net/HttpURLConnection:getResponseCode	()I
    //   86: putfield 319	com/tencent/mobileqq/msf/core/net/d:h	I
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 178	com/tencent/mobileqq/msf/core/net/d:g	Ljava/net/HttpURLConnection;
    //   94: invokevirtual 323	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   97: invokevirtual 326	java/net/URL:getHost	()Ljava/lang/String;
    //   100: putfield 328	com/tencent/mobileqq/msf/core/net/d:i	Ljava/lang/String;
    //   103: aload_0
    //   104: getfield 178	com/tencent/mobileqq/msf/core/net/d:g	Ljava/net/HttpURLConnection;
    //   107: invokevirtual 332	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   110: astore_1
    //   111: aload_1
    //   112: astore 10
    //   114: aload 8
    //   116: astore 9
    //   118: new 334	java/io/BufferedInputStream
    //   121: dup
    //   122: aload_1
    //   123: invokespecial 337	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: astore 11
    //   128: aload_1
    //   129: astore 10
    //   131: aload 8
    //   133: astore 9
    //   135: new 339	org/apache/http/util/ByteArrayBuffer
    //   138: dup
    //   139: sipush 1024
    //   142: invokespecial 341	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   145: astore 14
    //   147: aload_1
    //   148: astore 10
    //   150: aload 8
    //   152: astore 9
    //   154: bipush 50
    //   156: newarray byte
    //   158: astore 15
    //   160: aload_1
    //   161: astore 10
    //   163: aload 8
    //   165: astore 9
    //   167: aload 11
    //   169: aload 15
    //   171: invokevirtual 345	java/io/BufferedInputStream:read	([B)I
    //   174: istore_3
    //   175: iload_3
    //   176: iconst_m1
    //   177: if_icmpne +123 -> 300
    //   180: aload_1
    //   181: astore 10
    //   183: aload 8
    //   185: astore 9
    //   187: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   190: lstore 4
    //   192: aload_1
    //   193: astore 10
    //   195: aload 8
    //   197: astore 9
    //   199: ldc 8
    //   201: iconst_1
    //   202: new 133	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 347
    //   212: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_0
    //   216: getfield 30	com/tencent/mobileqq/msf/core/net/d:f	I
    //   219: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc_w 314
    //   225: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 14
    //   230: invokevirtual 350	org/apache/http/util/ByteArrayBuffer:length	()I
    //   233: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc_w 352
    //   239: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: lload 4
    //   244: lload 6
    //   246: lsub
    //   247: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   250: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload_1
    //   257: astore 10
    //   259: aload 8
    //   261: astore 9
    //   263: aload 14
    //   265: invokevirtual 356	org/apache/http/util/ByteArrayBuffer:toByteArray	()[B
    //   268: astore 11
    //   270: aload 11
    //   272: astore_2
    //   273: aload 8
    //   275: ifnull +8 -> 283
    //   278: aload 8
    //   280: invokevirtual 358	java/io/OutputStream:close	()V
    //   283: aload_2
    //   284: astore 8
    //   286: aload_1
    //   287: ifnull +10 -> 297
    //   290: aload_1
    //   291: invokevirtual 361	java/io/InputStream:close	()V
    //   294: aload_2
    //   295: astore 8
    //   297: aload 8
    //   299: areturn
    //   300: aload_1
    //   301: astore 10
    //   303: aload 8
    //   305: astore 9
    //   307: aload 14
    //   309: aload 15
    //   311: iconst_0
    //   312: iload_3
    //   313: invokevirtual 364	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   316: goto -156 -> 160
    //   319: astore 11
    //   321: lload 6
    //   323: lstore 4
    //   325: aload_1
    //   326: astore 10
    //   328: aload 8
    //   330: astore 9
    //   332: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   335: lstore 6
    //   337: aload_1
    //   338: astore 10
    //   340: aload 8
    //   342: astore 9
    //   344: aload 11
    //   346: invokevirtual 279	java/lang/Throwable:printStackTrace	()V
    //   349: aload_1
    //   350: astore 10
    //   352: aload 8
    //   354: astore 9
    //   356: aload_2
    //   357: aload 11
    //   359: invokevirtual 280	java/lang/Throwable:toString	()Ljava/lang/String;
    //   362: putfield 366	com/tencent/mobileqq/msf/core/b/f:h	Ljava/lang/String;
    //   365: aload_1
    //   366: astore 10
    //   368: aload 8
    //   370: astore 9
    //   372: ldc 8
    //   374: iconst_1
    //   375: new 133	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 368
    //   385: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_0
    //   389: getfield 30	com/tencent/mobileqq/msf/core/net/d:f	I
    //   392: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc_w 352
    //   398: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: lload 6
    //   403: lload 4
    //   405: lsub
    //   406: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   409: ldc_w 296
    //   412: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload 11
    //   417: invokevirtual 280	java/lang/Throwable:toString	()Ljava/lang/String;
    //   420: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 8
    //   431: ifnull +8 -> 439
    //   434: aload 8
    //   436: invokevirtual 358	java/io/OutputStream:close	()V
    //   439: aload 13
    //   441: astore 8
    //   443: aload_1
    //   444: ifnull -147 -> 297
    //   447: aload_1
    //   448: invokevirtual 361	java/io/InputStream:close	()V
    //   451: aconst_null
    //   452: areturn
    //   453: astore_1
    //   454: aload 12
    //   456: astore_2
    //   457: aload_1
    //   458: invokevirtual 279	java/lang/Throwable:printStackTrace	()V
    //   461: aload_2
    //   462: areturn
    //   463: astore_1
    //   464: aconst_null
    //   465: astore 10
    //   467: aconst_null
    //   468: astore 8
    //   470: aload 8
    //   472: ifnull +8 -> 480
    //   475: aload 8
    //   477: invokevirtual 358	java/io/OutputStream:close	()V
    //   480: aload 10
    //   482: ifnull +8 -> 490
    //   485: aload 10
    //   487: invokevirtual 361	java/io/InputStream:close	()V
    //   490: aload_1
    //   491: athrow
    //   492: astore_2
    //   493: aload_2
    //   494: invokevirtual 279	java/lang/Throwable:printStackTrace	()V
    //   497: goto -7 -> 490
    //   500: astore_1
    //   501: goto -44 -> 457
    //   504: astore_1
    //   505: goto -48 -> 457
    //   508: astore_1
    //   509: aconst_null
    //   510: astore 10
    //   512: goto -42 -> 470
    //   515: astore_1
    //   516: aload 9
    //   518: astore 8
    //   520: goto -50 -> 470
    //   523: astore 11
    //   525: aconst_null
    //   526: astore_1
    //   527: aconst_null
    //   528: astore 8
    //   530: goto -205 -> 325
    //   533: astore 11
    //   535: aconst_null
    //   536: astore_1
    //   537: lload 6
    //   539: lstore 4
    //   541: goto -216 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	d
    //   0	544	1	paramArrayOfByte	byte[]
    //   0	544	2	paramf	f
    //   174	139	3	j	int
    //   7	533	4	l1	long
    //   12	526	6	l2	long
    //   25	504	8	localObject1	Object
    //   116	401	9	localObject2	Object
    //   112	399	10	arrayOfByte1	byte[]
    //   126	145	11	localObject3	Object
    //   319	97	11	localThrowable1	Throwable
    //   523	1	11	localThrowable2	Throwable
    //   533	1	11	localThrowable3	Throwable
    //   1	454	12	localObject4	Object
    //   4	436	13	localObject5	Object
    //   145	163	14	localByteArrayBuffer	org.apache.http.util.ByteArrayBuffer
    //   158	152	15	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   118	128	319	java/lang/Throwable
    //   135	147	319	java/lang/Throwable
    //   154	160	319	java/lang/Throwable
    //   167	175	319	java/lang/Throwable
    //   187	192	319	java/lang/Throwable
    //   199	256	319	java/lang/Throwable
    //   263	270	319	java/lang/Throwable
    //   307	316	319	java/lang/Throwable
    //   434	439	453	java/lang/Throwable
    //   447	451	453	java/lang/Throwable
    //   9	14	463	finally
    //   18	27	463	finally
    //   475	480	492	java/lang/Throwable
    //   485	490	492	java/lang/Throwable
    //   278	283	500	java/lang/Throwable
    //   290	294	504	java/lang/Throwable
    //   27	111	508	finally
    //   118	128	515	finally
    //   135	147	515	finally
    //   154	160	515	finally
    //   167	175	515	finally
    //   187	192	515	finally
    //   199	256	515	finally
    //   263	270	515	finally
    //   307	316	515	finally
    //   332	337	515	finally
    //   344	349	515	finally
    //   356	365	515	finally
    //   372	429	515	finally
    //   9	14	523	java/lang/Throwable
    //   18	27	523	java/lang/Throwable
    //   27	111	533	java/lang/Throwable
  }
  
  public void b()
  {
    this.b = null;
    this.c = null;
    this.d = 10000;
    this.g = null;
    this.h = 0;
    this.i = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d
 * JD-Core Version:    0.7.0.1
 */