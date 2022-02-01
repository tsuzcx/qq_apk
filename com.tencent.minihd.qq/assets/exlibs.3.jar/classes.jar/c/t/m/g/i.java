package c.t.m.g;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.Deflater;

public final class i
{
  public static ao a(String paramString)
  {
    if (paramString == null) {}
    am localam;
    do
    {
      return null;
      localam = am.k();
    } while (localam == null);
    long l = System.currentTimeMillis();
    Object localObject2 = aw.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("A23", c(localam.e()));
    ao localao = new ao();
    localao.c(paramString);
    localao.a(l);
    localao.a((Map)localObject2);
    localao.b(localam.a());
    localao.a((String)localObject1);
    return localao;
  }
  
  public static aq a(bc parambc)
  {
    parambc = new av(parambc);
    try
    {
      parambc.j();
      return parambc;
    }
    catch (Exception localException)
    {
      parambc.b = -2;
      parambc.c = ay.a(localException);
    }
    return parambc;
  }
  
  public static String a(ao paramao)
  {
    localStringBuilder = new StringBuilder();
    Object localObject1 = new StringBuilder();
    long l = System.currentTimeMillis();
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Object localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTimeInMillis(l);
    localStringBuilder.append(((SimpleDateFormat)localObject2).format(((Calendar)localObject3).getTime()) + "|");
    localStringBuilder.append("INFO|");
    localStringBuilder.append(o.b() + "|");
    localObject3 = am.k();
    if (localObject3 != null) {
      localStringBuilder.append(am.k().c() + "|");
    }
    for (;;)
    {
      localStringBuilder.append("beacon|");
      localStringBuilder.append("1.8.1|");
      localObject1 = paramao.e();
      try
      {
        localObject2 = URLEncoder.encode(paramao.e(), "utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          continue;
          localStringBuilder.append("unknow\n");
        }
      }
      localStringBuilder.append((String)localObject1 + "|");
      localStringBuilder.append("qua|");
      localStringBuilder.append("upload_ip|");
      localStringBuilder.append("unknown|");
      localStringBuilder.append(paramao.d() + "|");
      localStringBuilder.append(paramao.g() + "|");
      localStringBuilder.append(paramao.a() + "|");
      localStringBuilder.append(ao.c() + "|");
      localStringBuilder.append(ao.b() + "|");
      localObject1 = a(paramao.h());
      localStringBuilder.append((String)localObject1 + "|");
      localObject1 = new StringBuilder();
      l = paramao.f();
      paramao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(l);
      localStringBuilder.append(paramao.format(((Calendar)localObject2).getTime()) + "|");
      localStringBuilder.append("upload_time|");
      if (localObject3 == null) {
        break;
      }
      localStringBuilder.append(((am)localObject3).b() + "\n");
      return localStringBuilder.toString();
      localStringBuilder.append("unknow|");
    }
  }
  
  private static String a(Map paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuffer.append("&");
      localStringBuffer.append(str);
      localStringBuffer.append("=");
      localStringBuffer.append((String)paramMap.get(str));
    }
    paramMap = localStringBuffer.substring(1);
    localStringBuffer.setLength(0);
    return paramMap;
  }
  
  public static HashMap a(aj paramaj)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("B50", paramaj.d);
    localHashMap.put("B51", b(paramaj.g));
    localHashMap.put("B69", b(paramaj.e));
    localHashMap.put("B52", paramaj.h);
    localHashMap.put("B53", b(paramaj.j));
    localHashMap.put("B54", paramaj.k);
    localHashMap.put("B55", paramaj.l);
    localHashMap.put("B56", paramaj.m);
    if (!TextUtils.isEmpty(paramaj.n)) {
      localHashMap.put("B57", b(paramaj.n));
    }
    if ((!TextUtils.isEmpty(paramaj.o)) && (!paramaj.o.equals("null"))) {
      localHashMap.put("B58", b(paramaj.o));
    }
    localHashMap.put("B59", paramaj.p);
    localHashMap.put("B60", paramaj.q);
    localHashMap.put("B61", paramaj.r);
    localHashMap.put("B62", paramaj.s);
    localHashMap.put("B71", paramaj.v);
    localHashMap.put("B76", paramaj.w);
    return localHashMap;
  }
  
  public static boolean a()
  {
    try
    {
      int i = Runtime.getRuntime().exec("/system/bin/ping -c 1 " + "www.qq.com").waitFor();
      return i == 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return d("www.qq.com");
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte[256];
    while (!localDeflater.finished()) {
      localByteArrayOutputStream.write(paramArrayOfByte, 0, localDeflater.deflate(paramArrayOfByte));
    }
    localDeflater.finish();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static String b(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
    }
    return str;
  }
  
  private static String c(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = URLEncoder.encode(paramString, "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  private static boolean d(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 405	java/net/Socket
    //   5: dup
    //   6: invokespecial 406	java/net/Socket:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: astore_2
    //   12: aload_3
    //   13: new 408	java/net/InetSocketAddress
    //   16: dup
    //   17: aload_0
    //   18: bipush 80
    //   20: invokespecial 411	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   23: sipush 15000
    //   26: invokevirtual 415	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   29: iconst_1
    //   30: istore_1
    //   31: aload_3
    //   32: invokevirtual 418	java/net/Socket:close	()V
    //   35: iload_1
    //   36: ireturn
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 419	java/lang/Throwable:printStackTrace	()V
    //   42: iconst_1
    //   43: ireturn
    //   44: astore 4
    //   46: aconst_null
    //   47: astore_0
    //   48: aload_0
    //   49: astore_2
    //   50: aload 4
    //   52: invokevirtual 419	java/lang/Throwable:printStackTrace	()V
    //   55: aload_0
    //   56: ifnull -21 -> 35
    //   59: aload_0
    //   60: invokevirtual 418	java/net/Socket:close	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 419	java/lang/Throwable:printStackTrace	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 418	java/net/Socket:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_2
    //   86: aload_2
    //   87: invokevirtual 419	java/lang/Throwable:printStackTrace	()V
    //   90: goto -7 -> 83
    //   93: astore_0
    //   94: goto -19 -> 75
    //   97: astore 4
    //   99: aload_3
    //   100: astore_0
    //   101: goto -53 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramString	String
    //   1	35	1	bool	boolean
    //   11	69	2	localObject	Object
    //   85	2	2	localThrowable1	java.lang.Throwable
    //   9	91	3	localSocket	java.net.Socket
    //   44	7	4	localThrowable2	java.lang.Throwable
    //   97	1	4	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   31	35	37	java/lang/Throwable
    //   2	10	44	java/lang/Throwable
    //   59	63	65	java/lang/Throwable
    //   2	10	72	finally
    //   79	83	85	java/lang/Throwable
    //   12	29	93	finally
    //   50	55	93	finally
    //   12	29	97	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.i
 * JD-Core Version:    0.7.0.1
 */