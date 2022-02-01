package com.tencent.mobileqq.utils.httputils;

import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class HttpMsg
{
  public static final String A = "application/xhtml+xml";
  public static final String B = "image";
  public static final String C = "the package is over max limit";
  public static final String D = "HttpCommunicator closed or msg caceled!";
  public static final String E = "preempted by higher msg";
  public static final String F = "httpcommunicator closed";
  public static final String G = "request cancelled";
  public static final String H = "jad";
  public static final String I = "jar";
  public static final String J = "wtai://wp/mc;";
  public static final String K = "unknown";
  public static final String L = "charset";
  public static final String M = "utf-8";
  public static final String N = "GET";
  public static final String O = "POST";
  public static final String P = "Range";
  public static final String Q = "X-Range";
  public static final String R = "If-Modified-Since";
  public static final String S = "User-ReturnCode";
  public static final String T = "X-User-ReturnCode";
  public static final String U = "User-Range";
  public static final String V = "2";
  public static final String W = "Connection";
  public static final String X = "multipart/form-data";
  public static final String Y = "content-range";
  public static final String Z = "host";
  public static final int a = 2048;
  public static final String a = "cache-control";
  public static final String aa = "Content-Encoding";
  public static final String ab = "X-RtFlag";
  public static final String ac = "X-httime";
  public static final String ad = "X-piccachetime";
  public static String ai = "param_reason";
  public static final String b = "last-modified";
  public static final String c = "max-age";
  public static final String d = "no-cache";
  public static final String e = "Pragma";
  public static final String f = "Expires";
  public static final String g = "0";
  public static final String h = "text/vnd.wap.wml,image/*,audio/*,text/vnd.sun.j2me.app-descriptor,application/*";
  public static final String i = "Location";
  public static final String j = "Referer";
  public static final String k = "X-ErrNo";
  public static final String l = "Content-Type";
  public static final String m = "Set-Q-Cookie";
  public static final String n = "Q-Cookie";
  public static final String o = "Set-Cookie";
  public static final String p = "Cookie";
  public static final String q = "Accept-Encoding";
  public static final String r = "mType";
  public static final String s = "text/vnd.wap.wml";
  public static final String t = "application/vnd.wap.wmlc";
  public static final String u = "application/vnd.wap.wbxml";
  public static final String v = "text/vnd.sun.j2me.app-descriptor";
  public static final String w = "application/java-archive";
  public static final String x = "text/html";
  public static final String y = "text/plain";
  public static final String z = "application/vnd.wap.xhtml+xml";
  public long a;
  private final IHttpCommunicatorListener jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener;
  public Object a;
  public HttpURLConnection a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public String ae;
  public String af = null;
  public String ag;
  public String ah;
  private String aj;
  private String ak;
  private String al = "GET";
  public int b;
  public long b;
  public HashMap b;
  public AtomicBoolean b;
  final boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  public int c;
  public long c;
  public AtomicBoolean c;
  public boolean c;
  public int d;
  public long d;
  public boolean d;
  public int e;
  public long e;
  private boolean e;
  public int f;
  public int g = -1;
  public int h;
  public int i;
  private int j = 0;
  
  public HttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    this(paramString, paramArrayOfByte, paramIHttpCommunicatorListener, false);
  }
  
  public HttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener, boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = 201;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_JavaNetHttpURLConnection = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = true;
    this.aj = paramString;
    if (paramString != null)
    {
      this.ak = paramString.substring(0, paramString.length());
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener = paramIHttpCommunicatorListener;
      if (paramArrayOfByte != null) {
        break label189;
      }
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
      this.ak = null;
      break;
      label189:
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
    }
  }
  
  public int a()
  {
    return this.j;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public IHttpCommunicatorListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener;
  }
  
  public String a()
  {
    return this.aj;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    this.jdField_a_of_type_JavaNetHttpURLConnection = null;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.h = paramInt1;
    this.g = paramInt2;
    this.af = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener instanceof BaseTransProcessor)) {
      ((BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener).b(paramInt1, paramInt2, 0L, paramString);
    }
  }
  
  public void a(String paramString)
  {
    this.aj = paramString;
    this.ak = this.aj.substring(0, this.aj.length());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.ak;
  }
  
  public void b()
  {
    a();
    this.h = 0;
    this.g = 0;
    this.af = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 5)
    {
      this.jdField_b_of_type_Int = 201;
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_b_of_type_Int = 202;
      return;
    }
    if (paramInt == 10)
    {
      this.jdField_b_of_type_Int = 200;
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.ak = paramString;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public byte[] b()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public String c()
  {
    String str2 = a();
    String str1 = str2;
    if (!this.jdField_d_of_type_Boolean) {
      str1 = RichMediaUtil.a(str2);
    }
    return str1;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void c(String paramString)
  {
    this.al = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String d()
  {
    return this.af;
  }
  
  public void d(String paramString)
  {
    this.aj = paramString;
  }
  
  public boolean d()
  {
    if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey("X-RtFlag")) && ("0".equals(this.jdField_b_of_type_JavaUtilHashMap.get("X-RtFlag")))) {
      return false;
    }
    if ((this.h == -9527) && (this.g == 404))
    {
      String str = (String)this.jdField_b_of_type_JavaUtilHashMap.get(ai);
      return (!"H_404_-6101".equals(str)) && (!"H_404_-5062".equals(str));
    }
    return (this.h != 9048) && (this.h != 9057) && (this.h != 9020) && (this.h != 9022) && (this.h != 9366);
  }
  
  public String e()
  {
    return this.al;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpMsg
 * JD-Core Version:    0.7.0.1
 */