package com.tencent.mobileqq.utils.httputils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCMTimer.SSCMTimerObserver;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kup;
import kuq;

public class HttpCommunicator
  implements SSCMTimer.SSCMTimerObserver
{
  public static final int a = 5;
  private static long jdField_a_of_type_Long = 0L;
  public static final boolean a = true;
  public static final int b = 500;
  private static long jdField_b_of_type_Long = 1L;
  private static final String jdField_b_of_type_JavaLangString = "Q.richmedia.HttpCommunicator";
  public static final int c = 5;
  private static final String jdField_c_of_type_JavaLangString = "content-length zero";
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private HttpCommunicator.PriorityQueue jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue = new HttpCommunicator.PriorityQueue();
  private IHttpCommunicatorFlowCount jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount;
  private Object jdField_a_of_type_JavaLangObject = new ReentrantLock();
  String jdField_a_of_type_JavaLangString = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private kuq[] jdField_a_of_type_ArrayOfKuq;
  boolean jdField_b_of_type_Boolean = true;
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile boolean d = false;
  private boolean e;
  private int k = 0;
  private final int l = 3;
  private final int m;
  private int n;
  private int o;
  
  public HttpCommunicator(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount, int paramInt)
  {
    this.c = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount = paramIHttpCommunicatorFlowCount;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "construct HTTPcomm");
    }
    this.m = paramInt;
    this.n = 3;
    this.o = 0;
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    System.setProperty("http.maxConnections", "2");
  }
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  private HttpURLConnection a(HttpMsg paramHttpMsg)
  {
    Object localObject1 = paramHttpMsg.a();
    String str1 = (String)paramHttpMsg.jdField_a_of_type_JavaUtilHashMap.remove("mType");
    String str2;
    int i5;
    int i2;
    int i1;
    label51:
    Object localObject2;
    int i4;
    if (str1 != null)
    {
      str1 = MsfSdkUtils.insertMtype(str1, (String)localObject1);
      localObject1 = null;
      str2 = android.net.Proxy.getDefaultHost();
      i5 = android.net.Proxy.getDefaultPort();
      i2 = 0;
      i1 = 0;
      if ((i1 != 0) || (i2 >= 2)) {
        break label808;
      }
      localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      localObject1 = null;
      if (localObject2 == null) {
        break label816;
      }
      i4 = ((NetworkInfo)localObject2).getType();
      localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
    }
    for (;;)
    {
      String str3 = PkgTools.f((String)localObject1);
      if (!str3.equals(this.jdField_a_of_type_JavaLangString))
      {
        if ((i4 == 1) || (str3.equals(PkgTools.d))) {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      else
      {
        label139:
        if ((i4 == 1) && (("10.0.0.172".equals(str2)) || ("10.0.0.200".equals(str2)))) {
          this.jdField_b_of_type_Boolean = true;
        }
        if ((str2 == null) || (i5 <= 0)) {
          break label811;
        }
      }
      label808:
      label811:
      for (i1 = 1;; i1 = 0)
      {
        label237:
        int i3;
        label240:
        int i6;
        Object localObject3;
        int i7;
        if ((!this.jdField_b_of_type_Boolean) && (i1 != 0)) {
          if ((str3.equals(PkgTools.d)) || (str3.equals(PkgTools.f)) || (str3.equals(PkgTools.h)))
          {
            localObject1 = PkgTools.b(str1, str2, i5);
            i3 = 1;
            paramHttpMsg.f = i4;
            i6 = NetworkCenter.a().a();
            localObject3 = RichMediaStrategy.a(i6);
            i7 = ((RichMediaStrategy.NetPolicy)localObject3).d();
            ((HttpURLConnection)localObject1).setConnectTimeout(i7);
            if (!"POST".equals(paramHttpMsg.e())) {
              break label563;
            }
          }
        }
        label563:
        for (i4 = 89500;; i4 = ((RichMediaStrategy.NetPolicy)localObject3).e())
        {
          ((HttpURLConnection)localObject1).setReadTimeout(i4);
          a(paramHttpMsg, "gettingConn", "getConnection type:" + i6 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i5 + " last apnType:" + this.jdField_a_of_type_JavaLangString + " forceDirect:" + this.jdField_b_of_type_Boolean + ",connectTimeOut:" + i7 + ",readTimeout:" + i4);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          localObject2 = paramHttpMsg.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
          str1 = MsfSdkUtils.insertMtype("Other", (String)localObject1);
          break;
          this.jdField_b_of_type_Boolean = true;
          break label139;
          if (str3.equals(PkgTools.b))
          {
            localObject1 = PkgTools.a(str1, str2, i5);
            break label237;
          }
          localObject1 = PkgTools.a(str1, str2, i5);
          break label237;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
          i3 = 0;
          break label240;
        }
        if (paramHttpMsg.e().equals("POST"))
        {
          ((HttpURLConnection)localObject1).setDoOutput(true);
          if (paramHttpMsg.b() != null) {
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(paramHttpMsg.b().length);
          }
        }
        paramHttpMsg.ag = ((HttpURLConnection)localObject1).getRequestProperties().toString();
        try
        {
          ((HttpURLConnection)localObject1).connect();
          i1 = 1;
        }
        catch (Exception localException)
        {
          while (i1 != 0) {
            if ((i3 != 0) && (i1 != 0))
            {
              i1 = 0;
              this.jdField_b_of_type_Boolean = true;
            }
            else if ((i1 != 0) && (i3 == 0))
            {
              i1 = 0;
              this.jdField_b_of_type_Boolean = false;
            }
            else
            {
              throw localException;
            }
          }
          throw localException;
        }
        catch (AssertionError localAssertionError)
        {
          String str4;
          for (;;)
          {
            str4 = localAssertionError.getMessage();
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.HttpCommunicator", 2, "assertion:" + str4);
            }
            if (i1 == 0) {
              break;
            }
            if ((i3 != 0) && (i1 != 0))
            {
              i1 = 0;
              this.jdField_b_of_type_Boolean = true;
            }
            else if ((i1 != 0) && (i3 == 0))
            {
              i1 = 0;
              this.jdField_b_of_type_Boolean = false;
            }
            else
            {
              i1 = 1;
            }
          }
          throw new SocketException("AssertionError : " + str4);
        }
        this.jdField_a_of_type_JavaLangString = str3;
        i2 += 1;
        break label51;
        return localObject1;
      }
      label816:
      i4 = -1;
    }
  }
  
  private void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
      }
      paramHttpMsg1.a().a(paramHttpMsg1, paramHttpMsg2, paramInt);
    }
  }
  
  public static long b()
  {
    return jdField_b_of_type_Long;
  }
  
  public int a()
  {
    return this.m;
  }
  
  int a(int paramInt)
  {
    switch (paramInt % 5)
    {
    case 0: 
    default: 
      return 404;
    case 1: 
      return 416;
    case 2: 
      return 302;
    case 3: 
      return 501;
    }
    return 400;
  }
  
  public int a(HttpMsg paramHttpMsg)
  {
    int i1 = -1;
    int i3 = this.m;
    int i2 = 1;
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((paramHttpMsg != null) && (paramHttpMsg.a() != null))
      {
        paramHttpMsg.a(9366, -1, "close");
        paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
        i3 = i1;
        return i3;
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() < i3)
        {
          i1 = this.k + 1;
          this.k = i1;
          paramHttpMsg.a(i1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
          paramHttpMsg.a().a(paramHttpMsg, null, 0);
          i1 = this.k;
          i3 = i1;
          if (i2 == 0) {
            break;
          }
          a("sendMsg");
          return i1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        }
        if ((paramHttpMsg != null) && (paramHttpMsg.a() != null))
        {
          paramHttpMsg.a(9367, -1, "queen full");
          paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
        }
      }
      i2 = 0;
    }
  }
  
  Exception a(int paramInt)
  {
    switch (paramInt % 10)
    {
    default: 
      return new Exception("inject Exception");
    case 0: 
      return new SocketTimeoutException("inject sockettimeout");
    case 1: 
      return new PortUnreachableException("inject PortUnreachableException");
    case 2: 
      return new ConnectException("inject ConnectException");
    case 3: 
      return new NoRouteToHostException("inject NoRouteToHostException");
    case 4: 
      return new IllegalArgumentException("inject IllegalArgumentException");
    case 5: 
      return new IllegalStateException("inject IllegalStateException");
    case 6: 
      return new IOException("inject IOException");
    case 7: 
      return new IOException("preempted by higher msg");
    case 8: 
      return new IOException("HttpCommunicator closed or msg caceled!");
    }
    return new IOException("content-length zero");
  }
  
  public void a()
  {
    int i1 = 0;
    if ((this.d) || (this.c)) {
      throw new IllegalStateException("HttpCommunicator already in using or disposed!");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.c = true;
      this.o = 0;
      this.jdField_a_of_type_AndroidOsHandler = ThreadManager.b();
      this.jdField_a_of_type_ArrayOfKuq = new kuq[3];
      while (i1 < 3)
      {
        HandlerThread localHandlerThread = new HandlerThread("httpcommunicator_norm_" + i1, 5);
        localHandlerThread.start();
        this.jdField_a_of_type_ArrayOfKuq[i1] = new kuq(this, localHandlerThread.getLooper());
        this.jdField_a_of_type_ArrayOfKuq[i1].jdField_a_of_type_Int = i1;
        i1 += 1;
      }
      i1 = NetworkCenter.a().a();
      if ((i1 == 2) || (i1 == 3))
      {
        this.n = 2;
        return;
      }
      this.n = 3;
    }
  }
  
  public void a(int paramInt)
  {
    localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.n = 3;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.HttpCommunicator", 2, "netType:" + paramInt + " concurrent:" + this.n);
        }
        a("netChange");
        return;
      }
      finally {}
      this.n = 2;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  void a(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    if ((paramHttpURLConnection == null) || (paramHttpMsg == null)) {
      return;
    }
    paramHttpMsg.c(paramInt);
    paramHttpMsg.b("Content-Type", paramHttpURLConnection.getContentType());
    paramHttpMsg.ah = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      paramHttpMsg.b("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      paramHttpMsg.b("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      paramHttpMsg.b("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      paramHttpMsg.b("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      paramHttpMsg.b("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      paramHttpMsg.b("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      paramHttpMsg.b("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      paramHttpMsg.b("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      paramHttpMsg.b("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    paramHttpMsg.jdField_a_of_type_Long = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i1;
    if (str != null) {
      i1 = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        paramHttpMsg.jdField_a_of_type_Long = Long.valueOf(str.substring(i1 + 1)).longValue();
        paramHttpMsg.jdField_b_of_type_Long = paramHttpURLConnection.getContentLength();
        a(paramHttpMsg, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + paramHttpMsg.jdField_a_of_type_Long + ",totalBlockLen:" + paramHttpMsg.jdField_b_of_type_Long);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      paramHttpMsg.jdField_a_of_type_Long = paramHttpURLConnection.getContentLength();
      paramHttpMsg.jdField_b_of_type_Long = paramHttpMsg.jdField_a_of_type_Long;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    int i1 = 4;
    int i2 = (int)(2L * paramLong / 90000L);
    if (i2 > 4) {}
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i1 + 9400));
      localHashMap.put("param_PostSize", String.valueOf(paramInt));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i1 = i2;
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
      paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg, String paramString1, String paramString2)
  {
    RichMediaUtil.a(RichMediaUtil.b(paramHttpMsg.jdField_e_of_type_Int), paramHttpMsg.e().equals("POST"), RichMediaUtil.c(paramHttpMsg.jdField_d_of_type_Int), paramHttpMsg.ae, paramString1, paramString2);
  }
  
  public void a(HttpMsg paramHttpMsg, kuq paramkuq)
  {
    int i1 = 0;
    if ((paramHttpMsg != null) && (paramkuq != null)) {
      try
      {
        a(paramHttpMsg, "responseTimeout", "");
        if (paramHttpMsg.b() == null) {}
        for (;;)
        {
          a(90000L, i1);
          a(paramkuq);
          paramHttpMsg.a(9014, 0, "response timeout");
          paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
          return;
          i1 = paramHttpMsg.b().length;
        }
        return;
      }
      catch (Exception paramHttpMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", paramHttpMsg);
        }
      }
    }
  }
  
  /* Error */
  public void a(HttpMsg paramHttpMsg, kuq paramkuq, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 388	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   4: astore 35
    //   6: aconst_null
    //   7: astore 30
    //   9: aconst_null
    //   10: astore 33
    //   12: aconst_null
    //   13: astore 32
    //   15: aconst_null
    //   16: astore 34
    //   18: aconst_null
    //   19: astore 31
    //   21: iconst_0
    //   22: istore 10
    //   24: lconst_0
    //   25: lstore 14
    //   27: iconst_0
    //   28: istore 22
    //   30: iconst_0
    //   31: istore 9
    //   33: iconst_0
    //   34: istore 8
    //   36: aload_0
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_1
    //   40: iload_3
    //   41: invokespecial 647	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   44: iconst_0
    //   45: istore 7
    //   47: iconst_0
    //   48: istore 22
    //   50: aconst_null
    //   51: astore 26
    //   53: iconst_m1
    //   54: istore 4
    //   56: aconst_null
    //   57: astore 25
    //   59: aconst_null
    //   60: astore 24
    //   62: lconst_0
    //   63: lstore 12
    //   65: aload_0
    //   66: aload_1
    //   67: ldc_w 649
    //   70: ldc_w 604
    //   73: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: aload_2
    //   78: aload_1
    //   79: invokevirtual 652	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lkuq;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   82: aload_0
    //   83: aload_1
    //   84: invokespecial 654	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)Ljava/net/HttpURLConnection;
    //   87: astore 27
    //   89: aload 27
    //   91: astore 25
    //   93: aload_1
    //   94: aload 25
    //   96: putfield 657	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   99: aload_1
    //   100: invokestatic 662	android/os/SystemClock:uptimeMillis	()J
    //   103: putfield 664	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   106: aload_0
    //   107: aload_1
    //   108: ldc_w 666
    //   111: ldc_w 604
    //   114: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore 22
    //   120: invokestatic 669	java/lang/System:currentTimeMillis	()J
    //   123: pop2
    //   124: aload_1
    //   125: invokevirtual 249	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   128: ldc 247
    //   130: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifeq +4556 -> 4689
    //   136: new 671	kuo
    //   139: dup
    //   140: aload_0
    //   141: aload_1
    //   142: aload_2
    //   143: invokespecial 674	kuo:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lkuq;)V
    //   146: astore 28
    //   148: aload_0
    //   149: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   152: aload 28
    //   154: ldc2_w 583
    //   157: invokevirtual 680	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   160: pop
    //   161: aload_1
    //   162: invokevirtual 356	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()[B
    //   165: astore 27
    //   167: aload 25
    //   169: invokevirtual 684	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   172: astore 26
    //   174: aload_0
    //   175: aload_1
    //   176: ldc_w 686
    //   179: new 257	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 688
    //   189: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 27
    //   194: arraylength
    //   195: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   204: iconst_0
    //   205: istore 5
    //   207: iload 5
    //   209: aload 27
    //   211: arraylength
    //   212: if_icmpge +46 -> 258
    //   215: aload_0
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual 652	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lkuq;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   221: aload 26
    //   223: aload 27
    //   225: iload 5
    //   227: sipush 10240
    //   230: aload 27
    //   232: arraylength
    //   233: iload 5
    //   235: isub
    //   236: invokestatic 694	java/lang/Math:min	(II)I
    //   239: invokevirtual 700	java/io/OutputStream:write	([BII)V
    //   242: aload 26
    //   244: invokevirtual 703	java/io/OutputStream:flush	()V
    //   247: iload 5
    //   249: sipush 10240
    //   252: iadd
    //   253: istore 5
    //   255: goto -48 -> 207
    //   258: aload_2
    //   259: ifnull +13 -> 272
    //   262: aload_2
    //   263: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   266: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   269: ifne +14 -> 283
    //   272: aload_0
    //   273: aload_1
    //   274: ldc_w 710
    //   277: ldc_w 604
    //   280: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 25
    //   285: invokevirtual 714	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   288: invokevirtual 715	java/net/URL:toString	()Ljava/lang/String;
    //   291: invokevirtual 718	java/lang/String:length	()I
    //   294: i2l
    //   295: lstore 16
    //   297: aload 27
    //   299: arraylength
    //   300: istore 5
    //   302: lload 12
    //   304: iload 5
    //   306: i2l
    //   307: ldc2_w 719
    //   310: lload 16
    //   312: ladd
    //   313: ladd
    //   314: ladd
    //   315: lstore 12
    //   317: aload 26
    //   319: astore 27
    //   321: aload 28
    //   323: astore 24
    //   325: iload 4
    //   327: istore 6
    //   329: lload 14
    //   331: lstore 18
    //   333: iload 4
    //   335: istore 5
    //   337: lload 14
    //   339: lstore 16
    //   341: aload 32
    //   343: astore 29
    //   345: aload_0
    //   346: aload_2
    //   347: aload_1
    //   348: invokevirtual 652	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lkuq;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   351: iload 4
    //   353: istore 6
    //   355: lload 14
    //   357: lstore 18
    //   359: iload 4
    //   361: istore 5
    //   363: lload 14
    //   365: lstore 16
    //   367: aload 32
    //   369: astore 29
    //   371: aload 25
    //   373: invokevirtual 723	java/net/HttpURLConnection:getResponseCode	()I
    //   376: istore 4
    //   378: iload 4
    //   380: istore 6
    //   382: lload 14
    //   384: lstore 18
    //   386: iload 4
    //   388: istore 5
    //   390: lload 14
    //   392: lstore 16
    //   394: aload 32
    //   396: astore 29
    //   398: aload_0
    //   399: iload 4
    //   401: aload 25
    //   403: aload_1
    //   404: invokevirtual 725	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   407: aload_2
    //   408: ifnull +251 -> 659
    //   411: iload 4
    //   413: istore 6
    //   415: lload 14
    //   417: lstore 18
    //   419: iload 4
    //   421: istore 5
    //   423: lload 14
    //   425: lstore 16
    //   427: aload 32
    //   429: astore 29
    //   431: aload_2
    //   432: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   435: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   438: istore 23
    //   440: iload 23
    //   442: ifeq +217 -> 659
    //   445: iload 4
    //   447: sipush 200
    //   450: if_icmpeq +11 -> 461
    //   453: iload 4
    //   455: sipush 206
    //   458: if_icmpne +31 -> 489
    //   461: aload_0
    //   462: aload_1
    //   463: ldc_w 727
    //   466: new 257	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 729
    //   476: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iconst_0
    //   480: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_2
    //   490: ifnull +13 -> 503
    //   493: aload_2
    //   494: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   497: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   500: ifne +47 -> 547
    //   503: aload_0
    //   504: aload_1
    //   505: ldc_w 731
    //   508: new 257	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 733
    //   518: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_1
    //   522: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   525: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 737
    //   531: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_1
    //   535: invokevirtual 739	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   538: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   547: aload_0
    //   548: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   551: ifnull +17 -> 568
    //   554: aload 24
    //   556: ifnull +12 -> 568
    //   559: aload_0
    //   560: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   563: aload 24
    //   565: invokevirtual 743	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   568: lload 12
    //   570: lconst_0
    //   571: ladd
    //   572: lstore 12
    //   574: lload 12
    //   576: lconst_0
    //   577: lcmp
    //   578: ifeq +25 -> 603
    //   581: aload_1
    //   582: invokevirtual 249	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   585: ldc 247
    //   587: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   590: ifeq +58 -> 648
    //   593: iconst_1
    //   594: istore_3
    //   595: aload_0
    //   596: aload_1
    //   597: iload_3
    //   598: lload 12
    //   600: invokevirtual 746	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   603: iconst_0
    //   604: ifeq +11 -> 615
    //   607: new 748	java/lang/NullPointerException
    //   610: dup
    //   611: invokespecial 749	java/lang/NullPointerException:<init>	()V
    //   614: athrow
    //   615: iconst_0
    //   616: ifeq +11 -> 627
    //   619: new 748	java/lang/NullPointerException
    //   622: dup
    //   623: invokespecial 749	java/lang/NullPointerException:<init>	()V
    //   626: athrow
    //   627: aload 27
    //   629: ifnull +8 -> 637
    //   632: aload 27
    //   634: invokevirtual 751	java/io/OutputStream:close	()V
    //   637: aload 25
    //   639: ifnull +8 -> 647
    //   642: aload 25
    //   644: invokevirtual 754	java/net/HttpURLConnection:disconnect	()V
    //   647: return
    //   648: iconst_0
    //   649: istore_3
    //   650: goto -55 -> 595
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   658: return
    //   659: iload 4
    //   661: istore 6
    //   663: lload 14
    //   665: lstore 18
    //   667: iload 4
    //   669: istore 5
    //   671: lload 14
    //   673: lstore 16
    //   675: aload 32
    //   677: astore 29
    //   679: aload_0
    //   680: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   683: ifnull +37 -> 720
    //   686: aload 24
    //   688: ifnull +32 -> 720
    //   691: iload 4
    //   693: istore 6
    //   695: lload 14
    //   697: lstore 18
    //   699: iload 4
    //   701: istore 5
    //   703: lload 14
    //   705: lstore 16
    //   707: aload 32
    //   709: astore 29
    //   711: aload_0
    //   712: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   715: aload 24
    //   717: invokevirtual 743	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   720: iload 4
    //   722: istore 6
    //   724: lload 14
    //   726: lstore 18
    //   728: iload 4
    //   730: istore 5
    //   732: lload 14
    //   734: lstore 16
    //   736: aload 32
    //   738: astore 29
    //   740: aload_0
    //   741: aload_1
    //   742: ldc_w 756
    //   745: new 257	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   752: ldc_w 758
    //   755: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: iload 4
    //   760: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   763: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   769: iload 4
    //   771: sipush 302
    //   774: if_icmpeq +11 -> 785
    //   777: iload 4
    //   779: sipush 301
    //   782: if_icmpne +1252 -> 2034
    //   785: iload 7
    //   787: iconst_5
    //   788: if_icmpge +917 -> 1705
    //   791: iload 4
    //   793: istore 6
    //   795: lload 14
    //   797: lstore 18
    //   799: iload 4
    //   801: istore 5
    //   803: lload 14
    //   805: lstore 16
    //   807: aload 32
    //   809: astore 29
    //   811: aload_0
    //   812: aload_1
    //   813: ldc_w 760
    //   816: new 257	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   823: ldc_w 762
    //   826: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload_1
    //   830: getfield 367	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   833: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: ldc_w 764
    //   839: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload_1
    //   843: getfield 519	com/tencent/mobileqq/utils/httputils/HttpMsg:ah	Ljava/lang/String;
    //   846: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   855: iload 4
    //   857: istore 6
    //   859: lload 14
    //   861: lstore 18
    //   863: iload 4
    //   865: istore 5
    //   867: lload 14
    //   869: lstore 16
    //   871: aload 32
    //   873: astore 29
    //   875: aload 25
    //   877: ldc_w 766
    //   880: invokevirtual 524	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   883: astore 26
    //   885: aload 26
    //   887: ifnull +416 -> 1303
    //   890: aload 27
    //   892: ifnull +20 -> 912
    //   895: iload 4
    //   897: istore 5
    //   899: lload 14
    //   901: lstore 16
    //   903: aload 32
    //   905: astore 29
    //   907: aload 27
    //   909: invokevirtual 751	java/io/OutputStream:close	()V
    //   912: iload 4
    //   914: istore 5
    //   916: lload 14
    //   918: lstore 16
    //   920: aload 32
    //   922: astore 29
    //   924: aload 25
    //   926: invokevirtual 754	java/net/HttpURLConnection:disconnect	()V
    //   929: iload 4
    //   931: istore 6
    //   933: lload 14
    //   935: lstore 18
    //   937: iload 4
    //   939: istore 5
    //   941: lload 14
    //   943: lstore 16
    //   945: aload 32
    //   947: astore 29
    //   949: aload_1
    //   950: invokevirtual 768	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Z
    //   953: ifne +246 -> 1199
    //   956: iload 4
    //   958: istore 6
    //   960: lload 14
    //   962: lstore 18
    //   964: iload 4
    //   966: istore 5
    //   968: lload 14
    //   970: lstore 16
    //   972: aload 32
    //   974: astore 29
    //   976: aload 35
    //   978: aload 26
    //   980: invokeinterface 769 2 0
    //   985: iload 4
    //   987: sipush 200
    //   990: if_icmpeq +11 -> 1001
    //   993: iload 4
    //   995: sipush 206
    //   998: if_icmpne +31 -> 1029
    //   1001: aload_0
    //   1002: aload_1
    //   1003: ldc_w 727
    //   1006: new 257	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1013: ldc_w 729
    //   1016: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: iconst_0
    //   1020: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1023: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1029: aload_2
    //   1030: ifnull +13 -> 1043
    //   1033: aload_2
    //   1034: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1037: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1040: ifne +47 -> 1087
    //   1043: aload_0
    //   1044: aload_1
    //   1045: ldc_w 731
    //   1048: new 257	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1055: ldc_w 733
    //   1058: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload_1
    //   1062: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1065: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: ldc_w 737
    //   1071: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_1
    //   1075: invokevirtual 739	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1078: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1087: aload_0
    //   1088: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1091: ifnull +17 -> 1108
    //   1094: aload 24
    //   1096: ifnull +12 -> 1108
    //   1099: aload_0
    //   1100: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1103: aload 24
    //   1105: invokevirtual 743	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1108: lload 12
    //   1110: lconst_0
    //   1111: ladd
    //   1112: lstore 12
    //   1114: lload 12
    //   1116: lconst_0
    //   1117: lcmp
    //   1118: ifeq +25 -> 1143
    //   1121: aload_1
    //   1122: invokevirtual 249	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   1125: ldc 247
    //   1127: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1130: ifeq +64 -> 1194
    //   1133: iconst_1
    //   1134: istore_3
    //   1135: aload_0
    //   1136: aload_1
    //   1137: iload_3
    //   1138: lload 12
    //   1140: invokevirtual 746	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1143: iconst_0
    //   1144: ifeq +11 -> 1155
    //   1147: new 748	java/lang/NullPointerException
    //   1150: dup
    //   1151: invokespecial 749	java/lang/NullPointerException:<init>	()V
    //   1154: athrow
    //   1155: iconst_0
    //   1156: ifeq +11 -> 1167
    //   1159: new 748	java/lang/NullPointerException
    //   1162: dup
    //   1163: invokespecial 749	java/lang/NullPointerException:<init>	()V
    //   1166: athrow
    //   1167: aload 27
    //   1169: ifnull +8 -> 1177
    //   1172: aload 27
    //   1174: invokevirtual 751	java/io/OutputStream:close	()V
    //   1177: aload 25
    //   1179: ifnull -532 -> 647
    //   1182: aload 25
    //   1184: invokevirtual 754	java/net/HttpURLConnection:disconnect	()V
    //   1187: return
    //   1188: astore_1
    //   1189: aload_1
    //   1190: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   1193: return
    //   1194: iconst_0
    //   1195: istore_3
    //   1196: goto -61 -> 1135
    //   1199: iload 4
    //   1201: istore 6
    //   1203: lload 14
    //   1205: lstore 18
    //   1207: iload 4
    //   1209: istore 5
    //   1211: lload 14
    //   1213: lstore 16
    //   1215: aload 32
    //   1217: astore 29
    //   1219: aload_1
    //   1220: ldc_w 771
    //   1223: aload_1
    //   1224: invokevirtual 144	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1227: invokevirtual 773	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1230: iload 4
    //   1232: istore 6
    //   1234: lload 14
    //   1236: lstore 18
    //   1238: iload 4
    //   1240: istore 5
    //   1242: lload 14
    //   1244: lstore 16
    //   1246: aload 32
    //   1248: astore 29
    //   1250: aload_1
    //   1251: aload 26
    //   1253: invokevirtual 774	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)V
    //   1256: iload 4
    //   1258: istore 6
    //   1260: lload 14
    //   1262: lstore 18
    //   1264: iload 4
    //   1266: istore 5
    //   1268: lload 14
    //   1270: lstore 16
    //   1272: aload 32
    //   1274: astore 29
    //   1276: aload_1
    //   1277: ldc_w 776
    //   1280: invokevirtual 778	com/tencent/mobileqq/utils/httputils/HttpMsg:c	(Ljava/lang/String;)V
    //   1283: iload 7
    //   1285: iconst_1
    //   1286: iadd
    //   1287: istore 7
    //   1289: iconst_1
    //   1290: istore 22
    //   1292: aload 24
    //   1294: astore 26
    //   1296: aload 27
    //   1298: astore 24
    //   1300: goto -1235 -> 65
    //   1303: iload 4
    //   1305: istore 6
    //   1307: lload 14
    //   1309: lstore 18
    //   1311: iload 4
    //   1313: istore 5
    //   1315: lload 14
    //   1317: lstore 16
    //   1319: aload 32
    //   1321: astore 29
    //   1323: new 457	java/io/IOException
    //   1326: dup
    //   1327: ldc_w 780
    //   1330: invokespecial 460	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1333: athrow
    //   1334: astore 29
    //   1336: iconst_1
    //   1337: istore_3
    //   1338: aload 25
    //   1340: astore 30
    //   1342: aconst_null
    //   1343: astore 28
    //   1345: aconst_null
    //   1346: astore 26
    //   1348: iconst_0
    //   1349: istore 5
    //   1351: iload 6
    //   1353: istore 4
    //   1355: lload 12
    //   1357: lstore 14
    //   1359: lload 18
    //   1361: lstore 12
    //   1363: aload 24
    //   1365: astore 25
    //   1367: aload 30
    //   1369: astore 24
    //   1371: iconst_1
    //   1372: istore 6
    //   1374: aload_0
    //   1375: iload_3
    //   1376: iload 4
    //   1378: aload 24
    //   1380: aload_1
    //   1381: aload 29
    //   1383: invokevirtual 783	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ZILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/Throwable;)V
    //   1386: iload_3
    //   1387: ifeq +48 -> 1435
    //   1390: iload 4
    //   1392: sipush 200
    //   1395: if_icmpeq +11 -> 1406
    //   1398: iload 4
    //   1400: sipush 206
    //   1403: if_icmpne +32 -> 1435
    //   1406: aload_0
    //   1407: aload_1
    //   1408: ldc_w 727
    //   1411: new 257	java/lang/StringBuilder
    //   1414: dup
    //   1415: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1418: ldc_w 729
    //   1421: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: iload 5
    //   1426: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1429: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1432: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1435: aload_2
    //   1436: ifnull +13 -> 1449
    //   1439: aload_2
    //   1440: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1443: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1446: ifne +101 -> 1547
    //   1449: aload_0
    //   1450: aload_1
    //   1451: ldc_w 731
    //   1454: new 257	java/lang/StringBuilder
    //   1457: dup
    //   1458: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1461: ldc_w 733
    //   1464: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload_1
    //   1468: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1471: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: ldc_w 737
    //   1477: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: aload_1
    //   1481: invokevirtual 739	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1484: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1490: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1493: aload_1
    //   1494: getfield 785	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   1497: sipush -9527
    //   1500: if_icmpne +47 -> 1547
    //   1503: aload_0
    //   1504: aload_1
    //   1505: ldc_w 787
    //   1508: new 257	java/lang/StringBuilder
    //   1511: dup
    //   1512: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1515: ldc_w 762
    //   1518: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: aload_1
    //   1522: getfield 367	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   1525: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: ldc_w 764
    //   1531: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: aload_1
    //   1535: getfield 519	com/tencent/mobileqq/utils/httputils/HttpMsg:ah	Ljava/lang/String;
    //   1538: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1544: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1547: aload_0
    //   1548: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1551: ifnull +17 -> 1568
    //   1554: aload 25
    //   1556: ifnull +12 -> 1568
    //   1559: aload_0
    //   1560: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1563: aload 25
    //   1565: invokevirtual 743	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1568: lload 14
    //   1570: lload 12
    //   1572: ladd
    //   1573: lstore 12
    //   1575: lload 12
    //   1577: lconst_0
    //   1578: lcmp
    //   1579: ifeq +25 -> 1604
    //   1582: aload_1
    //   1583: invokevirtual 249	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   1586: ldc 247
    //   1588: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1591: ifeq +2148 -> 3739
    //   1594: iconst_1
    //   1595: istore_3
    //   1596: aload_0
    //   1597: aload_1
    //   1598: iload_3
    //   1599: lload 12
    //   1601: invokevirtual 746	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1604: aload 26
    //   1606: ifnull +8 -> 1614
    //   1609: aload 26
    //   1611: invokevirtual 790	java/io/ByteArrayOutputStream:close	()V
    //   1614: aload 28
    //   1616: ifnull +8 -> 1624
    //   1619: aload 28
    //   1621: invokevirtual 793	java/io/InputStream:close	()V
    //   1624: aload 27
    //   1626: ifnull +8 -> 1634
    //   1629: aload 27
    //   1631: invokevirtual 751	java/io/OutputStream:close	()V
    //   1634: iload 6
    //   1636: istore 4
    //   1638: aload 24
    //   1640: ifnull +12 -> 1652
    //   1643: aload 24
    //   1645: invokevirtual 754	java/net/HttpURLConnection:disconnect	()V
    //   1648: iload 6
    //   1650: istore 4
    //   1652: aload_2
    //   1653: ifnull +13 -> 1666
    //   1656: aload_2
    //   1657: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1660: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1663: ifne -1016 -> 647
    //   1666: aload_1
    //   1667: getfield 611	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1670: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1673: ifne -1026 -> 647
    //   1676: iload 4
    //   1678: ifeq +2093 -> 3771
    //   1681: aload 35
    //   1683: aload_1
    //   1684: aload_1
    //   1685: invokeinterface 407 3 0
    //   1690: return
    //   1691: astore_2
    //   1692: aload_0
    //   1693: aload_1
    //   1694: ldc_w 795
    //   1697: aload_2
    //   1698: invokestatic 801	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1701: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1704: return
    //   1705: iload 4
    //   1707: istore 6
    //   1709: lload 14
    //   1711: lstore 18
    //   1713: iload 4
    //   1715: istore 5
    //   1717: lload 14
    //   1719: lstore 16
    //   1721: aload 32
    //   1723: astore 29
    //   1725: new 137	java/lang/Exception
    //   1728: dup
    //   1729: ldc_w 803
    //   1732: invokespecial 425	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1735: athrow
    //   1736: astore 30
    //   1738: iconst_0
    //   1739: istore 4
    //   1741: aload 29
    //   1743: astore 28
    //   1745: aload 31
    //   1747: astore 29
    //   1749: lload 16
    //   1751: lstore 14
    //   1753: iload 22
    //   1755: istore_3
    //   1756: iload 8
    //   1758: istore 6
    //   1760: aload 24
    //   1762: astore 26
    //   1764: aload 30
    //   1766: astore 24
    //   1768: iload_3
    //   1769: ifeq +48 -> 1817
    //   1772: iload 5
    //   1774: sipush 200
    //   1777: if_icmpeq +11 -> 1788
    //   1780: iload 5
    //   1782: sipush 206
    //   1785: if_icmpne +32 -> 1817
    //   1788: aload_0
    //   1789: aload_1
    //   1790: ldc_w 727
    //   1793: new 257	java/lang/StringBuilder
    //   1796: dup
    //   1797: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1800: ldc_w 729
    //   1803: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: iload 6
    //   1808: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1811: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1814: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1817: aload_2
    //   1818: ifnull +13 -> 1831
    //   1821: aload_2
    //   1822: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1825: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1828: ifne +106 -> 1934
    //   1831: aload_0
    //   1832: aload_1
    //   1833: ldc_w 731
    //   1836: new 257	java/lang/StringBuilder
    //   1839: dup
    //   1840: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1843: ldc_w 733
    //   1846: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: aload_1
    //   1850: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1853: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: ldc_w 737
    //   1859: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: aload_1
    //   1863: invokevirtual 739	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1866: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1872: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1875: iload 4
    //   1877: ifeq +57 -> 1934
    //   1880: aload_1
    //   1881: getfield 785	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   1884: sipush -9527
    //   1887: if_icmpne +47 -> 1934
    //   1890: aload_0
    //   1891: aload_1
    //   1892: ldc_w 787
    //   1895: new 257	java/lang/StringBuilder
    //   1898: dup
    //   1899: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1902: ldc_w 762
    //   1905: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: aload_1
    //   1909: getfield 367	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   1912: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: ldc_w 764
    //   1918: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: aload_1
    //   1922: getfield 519	com/tencent/mobileqq/utils/httputils/HttpMsg:ah	Ljava/lang/String;
    //   1925: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1928: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1931: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1934: aload_0
    //   1935: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1938: ifnull +17 -> 1955
    //   1941: aload 26
    //   1943: ifnull +12 -> 1955
    //   1946: aload_0
    //   1947: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1950: aload 26
    //   1952: invokevirtual 743	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1955: lload 12
    //   1957: lload 14
    //   1959: ladd
    //   1960: lstore 12
    //   1962: lload 12
    //   1964: lconst_0
    //   1965: lcmp
    //   1966: ifeq +25 -> 1991
    //   1969: aload_1
    //   1970: invokevirtual 249	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   1973: ldc 247
    //   1975: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1978: ifeq +1780 -> 3758
    //   1981: iconst_1
    //   1982: istore_3
    //   1983: aload_0
    //   1984: aload_1
    //   1985: iload_3
    //   1986: lload 12
    //   1988: invokevirtual 746	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1991: aload 29
    //   1993: ifnull +8 -> 2001
    //   1996: aload 29
    //   1998: invokevirtual 790	java/io/ByteArrayOutputStream:close	()V
    //   2001: aload 28
    //   2003: ifnull +8 -> 2011
    //   2006: aload 28
    //   2008: invokevirtual 793	java/io/InputStream:close	()V
    //   2011: aload 27
    //   2013: ifnull +8 -> 2021
    //   2016: aload 27
    //   2018: invokevirtual 751	java/io/OutputStream:close	()V
    //   2021: aload 25
    //   2023: ifnull +8 -> 2031
    //   2026: aload 25
    //   2028: invokevirtual 754	java/net/HttpURLConnection:disconnect	()V
    //   2031: aload 24
    //   2033: athrow
    //   2034: iload 4
    //   2036: istore 6
    //   2038: lload 14
    //   2040: lstore 18
    //   2042: iload 4
    //   2044: istore 5
    //   2046: lload 14
    //   2048: lstore 16
    //   2050: aload 32
    //   2052: astore 29
    //   2054: aload_0
    //   2055: aload_1
    //   2056: aconst_null
    //   2057: iconst_2
    //   2058: iload_3
    //   2059: invokespecial 647	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   2062: iload 4
    //   2064: sipush 200
    //   2067: if_icmpeq +11 -> 2078
    //   2070: iload 4
    //   2072: sipush 206
    //   2075: if_icmpne +1621 -> 3696
    //   2078: iload 4
    //   2080: istore 6
    //   2082: lload 14
    //   2084: lstore 18
    //   2086: iload 4
    //   2088: istore 5
    //   2090: lload 14
    //   2092: lstore 16
    //   2094: aload 32
    //   2096: astore 29
    //   2098: aload 25
    //   2100: invokevirtual 511	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2103: astore 26
    //   2105: aload 26
    //   2107: ifnonnull +420 -> 2527
    //   2110: ldc_w 604
    //   2113: astore 26
    //   2115: iload_3
    //   2116: ifne +441 -> 2557
    //   2119: iload 4
    //   2121: istore 6
    //   2123: lload 14
    //   2125: lstore 18
    //   2127: iload 4
    //   2129: istore 5
    //   2131: lload 14
    //   2133: lstore 16
    //   2135: aload 32
    //   2137: astore 29
    //   2139: aload_1
    //   2140: getfield 804	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_b_of_type_Boolean	Z
    //   2143: ifeq +414 -> 2557
    //   2146: iload 4
    //   2148: istore 6
    //   2150: lload 14
    //   2152: lstore 18
    //   2154: iload 4
    //   2156: istore 5
    //   2158: lload 14
    //   2160: lstore 16
    //   2162: aload 32
    //   2164: astore 29
    //   2166: aload 26
    //   2168: ldc_w 806
    //   2171: invokevirtual 809	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2174: iconst_m1
    //   2175: if_icmpne +35 -> 2210
    //   2178: iload 4
    //   2180: istore 6
    //   2182: lload 14
    //   2184: lstore 18
    //   2186: iload 4
    //   2188: istore 5
    //   2190: lload 14
    //   2192: lstore 16
    //   2194: aload 32
    //   2196: astore 29
    //   2198: aload 26
    //   2200: ldc_w 811
    //   2203: invokevirtual 809	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2206: iconst_m1
    //   2207: if_icmpeq +350 -> 2557
    //   2210: iload 4
    //   2212: istore 6
    //   2214: lload 14
    //   2216: lstore 18
    //   2218: iload 4
    //   2220: istore 5
    //   2222: lload 14
    //   2224: lstore 16
    //   2226: aload 32
    //   2228: astore 29
    //   2230: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2233: ifeq +58 -> 2291
    //   2236: iload 4
    //   2238: istore 6
    //   2240: lload 14
    //   2242: lstore 18
    //   2244: iload 4
    //   2246: istore 5
    //   2248: lload 14
    //   2250: lstore 16
    //   2252: aload 32
    //   2254: astore 29
    //   2256: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2259: ifeq +32 -> 2291
    //   2262: iload 4
    //   2264: istore 6
    //   2266: lload 14
    //   2268: lstore 18
    //   2270: iload 4
    //   2272: istore 5
    //   2274: lload 14
    //   2276: lstore 16
    //   2278: aload 32
    //   2280: astore 29
    //   2282: ldc 19
    //   2284: iconst_2
    //   2285: ldc_w 813
    //   2288: invokestatic 399	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2291: iload 4
    //   2293: istore 6
    //   2295: lload 14
    //   2297: lstore 18
    //   2299: iload 4
    //   2301: istore 5
    //   2303: lload 14
    //   2305: lstore 16
    //   2307: aload 32
    //   2309: astore 29
    //   2311: aload_0
    //   2312: aload_1
    //   2313: aload_2
    //   2314: iconst_1
    //   2315: invokevirtual 815	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lkuq;Z)V
    //   2318: iload 4
    //   2320: sipush 200
    //   2323: if_icmpeq +11 -> 2334
    //   2326: iload 4
    //   2328: sipush 206
    //   2331: if_icmpne +31 -> 2362
    //   2334: aload_0
    //   2335: aload_1
    //   2336: ldc_w 727
    //   2339: new 257	java/lang/StringBuilder
    //   2342: dup
    //   2343: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   2346: ldc_w 729
    //   2349: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2352: iconst_0
    //   2353: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2356: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2359: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2362: aload_2
    //   2363: ifnull +13 -> 2376
    //   2366: aload_2
    //   2367: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2370: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2373: ifne +47 -> 2420
    //   2376: aload_0
    //   2377: aload_1
    //   2378: ldc_w 731
    //   2381: new 257	java/lang/StringBuilder
    //   2384: dup
    //   2385: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   2388: ldc_w 733
    //   2391: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2394: aload_1
    //   2395: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   2398: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2401: ldc_w 737
    //   2404: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2407: aload_1
    //   2408: invokevirtual 739	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   2411: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2414: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2417: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2420: aload_0
    //   2421: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2424: ifnull +17 -> 2441
    //   2427: aload 24
    //   2429: ifnull +12 -> 2441
    //   2432: aload_0
    //   2433: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2436: aload 24
    //   2438: invokevirtual 743	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2441: lload 12
    //   2443: lconst_0
    //   2444: ladd
    //   2445: lstore 12
    //   2447: lload 12
    //   2449: lconst_0
    //   2450: lcmp
    //   2451: ifeq +25 -> 2476
    //   2454: aload_1
    //   2455: invokevirtual 249	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   2458: ldc 247
    //   2460: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2463: ifeq +2237 -> 4700
    //   2466: iconst_1
    //   2467: istore_3
    //   2468: aload_0
    //   2469: aload_1
    //   2470: iload_3
    //   2471: lload 12
    //   2473: invokevirtual 746	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   2476: iconst_0
    //   2477: ifeq +11 -> 2488
    //   2480: new 748	java/lang/NullPointerException
    //   2483: dup
    //   2484: invokespecial 749	java/lang/NullPointerException:<init>	()V
    //   2487: athrow
    //   2488: iconst_0
    //   2489: ifeq +11 -> 2500
    //   2492: new 748	java/lang/NullPointerException
    //   2495: dup
    //   2496: invokespecial 749	java/lang/NullPointerException:<init>	()V
    //   2499: athrow
    //   2500: aload 27
    //   2502: ifnull +8 -> 2510
    //   2505: aload 27
    //   2507: invokevirtual 751	java/io/OutputStream:close	()V
    //   2510: aload 25
    //   2512: ifnull -1865 -> 647
    //   2515: aload 25
    //   2517: invokevirtual 754	java/net/HttpURLConnection:disconnect	()V
    //   2520: return
    //   2521: astore_1
    //   2522: aload_1
    //   2523: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   2526: return
    //   2527: iload 4
    //   2529: istore 6
    //   2531: lload 14
    //   2533: lstore 18
    //   2535: iload 4
    //   2537: istore 5
    //   2539: lload 14
    //   2541: lstore 16
    //   2543: aload 32
    //   2545: astore 29
    //   2547: aload 26
    //   2549: invokevirtual 818	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2552: astore 26
    //   2554: goto -439 -> 2115
    //   2557: iload 4
    //   2559: istore 6
    //   2561: lload 14
    //   2563: lstore 18
    //   2565: iload 4
    //   2567: istore 5
    //   2569: lload 14
    //   2571: lstore 16
    //   2573: aload 32
    //   2575: astore 29
    //   2577: aload_1
    //   2578: getfield 543	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2581: lconst_0
    //   2582: lcmp
    //   2583: ifne +65 -> 2648
    //   2586: iload 4
    //   2588: istore 6
    //   2590: lload 14
    //   2592: lstore 18
    //   2594: iload 4
    //   2596: istore 5
    //   2598: lload 14
    //   2600: lstore 16
    //   2602: aload 32
    //   2604: astore 29
    //   2606: aload_1
    //   2607: invokevirtual 249	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   2610: ldc 247
    //   2612: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2615: ifne +33 -> 2648
    //   2618: iload 4
    //   2620: istore 6
    //   2622: lload 14
    //   2624: lstore 18
    //   2626: iload 4
    //   2628: istore 5
    //   2630: lload 14
    //   2632: lstore 16
    //   2634: aload 32
    //   2636: astore 29
    //   2638: new 457	java/io/IOException
    //   2641: dup
    //   2642: ldc 22
    //   2644: invokespecial 460	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2647: athrow
    //   2648: iload 4
    //   2650: istore 6
    //   2652: lload 14
    //   2654: lstore 18
    //   2656: iload 4
    //   2658: istore 5
    //   2660: lload 14
    //   2662: lstore 16
    //   2664: aload 32
    //   2666: astore 29
    //   2668: aload_0
    //   2669: aload_1
    //   2670: ldc_w 820
    //   2673: new 257	java/lang/StringBuilder
    //   2676: dup
    //   2677: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   2680: ldc_w 822
    //   2683: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2686: aload_1
    //   2687: getfield 543	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2690: invokevirtual 574	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2693: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2696: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2699: iload 4
    //   2701: istore 6
    //   2703: lload 14
    //   2705: lstore 18
    //   2707: iload 4
    //   2709: istore 5
    //   2711: lload 14
    //   2713: lstore 16
    //   2715: aload 32
    //   2717: astore 29
    //   2719: aload_1
    //   2720: getfield 664	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2723: lconst_0
    //   2724: lcmp
    //   2725: ifeq +35 -> 2760
    //   2728: iload 4
    //   2730: istore 6
    //   2732: lload 14
    //   2734: lstore 18
    //   2736: iload 4
    //   2738: istore 5
    //   2740: lload 14
    //   2742: lstore 16
    //   2744: aload 32
    //   2746: astore 29
    //   2748: aload_1
    //   2749: invokestatic 662	android/os/SystemClock:uptimeMillis	()J
    //   2752: aload_1
    //   2753: getfield 664	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2756: lsub
    //   2757: putfield 824	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Long	J
    //   2760: iload 4
    //   2762: istore 6
    //   2764: lload 14
    //   2766: lstore 18
    //   2768: iload 4
    //   2770: istore 5
    //   2772: lload 14
    //   2774: lstore 16
    //   2776: aload 32
    //   2778: astore 29
    //   2780: aload 35
    //   2782: aload_1
    //   2783: aload_1
    //   2784: iconst_3
    //   2785: invokeinterface 393 4 0
    //   2790: ifeq +1887 -> 4677
    //   2793: lconst_0
    //   2794: ldc2_w 719
    //   2797: ladd
    //   2798: lstore 14
    //   2800: iload 4
    //   2802: istore 6
    //   2804: lload 14
    //   2806: lstore 18
    //   2808: iload 4
    //   2810: istore 5
    //   2812: lload 14
    //   2814: lstore 16
    //   2816: aload 32
    //   2818: astore 29
    //   2820: aload 25
    //   2822: invokevirtual 828	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2825: astore 28
    //   2827: iload 4
    //   2829: istore 5
    //   2831: lload 14
    //   2833: lstore 16
    //   2835: aload 28
    //   2837: astore 29
    //   2839: new 789	java/io/ByteArrayOutputStream
    //   2842: dup
    //   2843: invokespecial 829	java/io/ByteArrayOutputStream:<init>	()V
    //   2846: astore 26
    //   2848: sipush 10240
    //   2851: newarray byte
    //   2853: astore 30
    //   2855: iconst_0
    //   2856: istore 5
    //   2858: iconst_0
    //   2859: istore 6
    //   2861: iload 5
    //   2863: istore 7
    //   2865: lload 14
    //   2867: lstore 16
    //   2869: iload 5
    //   2871: istore 8
    //   2873: lload 14
    //   2875: lstore 20
    //   2877: aload 28
    //   2879: aload 30
    //   2881: iload 6
    //   2883: aload 30
    //   2885: arraylength
    //   2886: iload 6
    //   2888: isub
    //   2889: invokevirtual 833	java/io/InputStream:read	([BII)I
    //   2892: istore 9
    //   2894: iload 9
    //   2896: ifle +204 -> 3100
    //   2899: iload 5
    //   2901: istore 7
    //   2903: lload 14
    //   2905: lstore 16
    //   2907: iload 5
    //   2909: istore 8
    //   2911: lload 14
    //   2913: lstore 20
    //   2915: aload_0
    //   2916: aload_2
    //   2917: aload_1
    //   2918: invokevirtual 652	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lkuq;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2921: lload 14
    //   2923: iload 9
    //   2925: i2l
    //   2926: ladd
    //   2927: lstore 18
    //   2929: iload 6
    //   2931: iload 9
    //   2933: iadd
    //   2934: istore 11
    //   2936: iload 5
    //   2938: iload 9
    //   2940: iadd
    //   2941: istore 9
    //   2943: iload 9
    //   2945: istore 5
    //   2947: iload 11
    //   2949: istore 6
    //   2951: lload 18
    //   2953: lstore 14
    //   2955: iload 9
    //   2957: istore 7
    //   2959: lload 18
    //   2961: lstore 16
    //   2963: iload 9
    //   2965: istore 8
    //   2967: lload 18
    //   2969: lstore 20
    //   2971: iload 11
    //   2973: aload 30
    //   2975: arraylength
    //   2976: if_icmplt -115 -> 2861
    //   2979: iload 9
    //   2981: istore 7
    //   2983: lload 18
    //   2985: lstore 16
    //   2987: iload 9
    //   2989: istore 8
    //   2991: lload 18
    //   2993: lstore 20
    //   2995: aload_1
    //   2996: invokevirtual 835	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   2999: ifeq +64 -> 3063
    //   3002: iload 9
    //   3004: istore 7
    //   3006: lload 18
    //   3008: lstore 16
    //   3010: iload 9
    //   3012: istore 8
    //   3014: lload 18
    //   3016: lstore 20
    //   3018: aload_1
    //   3019: aload 30
    //   3021: invokevirtual 838	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3024: iload 9
    //   3026: istore 7
    //   3028: lload 18
    //   3030: lstore 16
    //   3032: iload 9
    //   3034: istore 8
    //   3036: lload 18
    //   3038: lstore 20
    //   3040: aload 35
    //   3042: aload_1
    //   3043: aload_1
    //   3044: invokeinterface 840 3 0
    //   3049: iconst_0
    //   3050: istore 6
    //   3052: iload 9
    //   3054: istore 5
    //   3056: lload 18
    //   3058: lstore 14
    //   3060: goto -199 -> 2861
    //   3063: iload 9
    //   3065: istore 7
    //   3067: lload 18
    //   3069: lstore 16
    //   3071: iload 9
    //   3073: istore 8
    //   3075: lload 18
    //   3077: lstore 20
    //   3079: aload 26
    //   3081: aload 30
    //   3083: invokevirtual 842	java/io/ByteArrayOutputStream:write	([B)V
    //   3086: iconst_0
    //   3087: istore 6
    //   3089: iload 9
    //   3091: istore 5
    //   3093: lload 18
    //   3095: lstore 14
    //   3097: goto -236 -> 2861
    //   3100: iload 5
    //   3102: istore 7
    //   3104: lload 14
    //   3106: lstore 16
    //   3108: iload 5
    //   3110: istore 8
    //   3112: lload 14
    //   3114: lstore 20
    //   3116: aload_1
    //   3117: invokevirtual 835	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   3120: ifeq +440 -> 3560
    //   3123: iload 6
    //   3125: ifle +99 -> 3224
    //   3128: iload 5
    //   3130: istore 7
    //   3132: lload 14
    //   3134: lstore 16
    //   3136: iload 5
    //   3138: istore 8
    //   3140: lload 14
    //   3142: lstore 20
    //   3144: iload 6
    //   3146: newarray byte
    //   3148: astore 29
    //   3150: iload 5
    //   3152: istore 7
    //   3154: lload 14
    //   3156: lstore 16
    //   3158: iload 5
    //   3160: istore 8
    //   3162: lload 14
    //   3164: lstore 20
    //   3166: aload 30
    //   3168: iconst_0
    //   3169: aload 29
    //   3171: iconst_0
    //   3172: iload 6
    //   3174: invokestatic 846	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3177: iload 5
    //   3179: istore 7
    //   3181: lload 14
    //   3183: lstore 16
    //   3185: iload 5
    //   3187: istore 8
    //   3189: lload 14
    //   3191: lstore 20
    //   3193: aload_1
    //   3194: aload 29
    //   3196: invokevirtual 838	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3199: iload 5
    //   3201: istore 7
    //   3203: lload 14
    //   3205: lstore 16
    //   3207: iload 5
    //   3209: istore 8
    //   3211: lload 14
    //   3213: lstore 20
    //   3215: aload 35
    //   3217: aload_1
    //   3218: aload_1
    //   3219: invokeinterface 840 3 0
    //   3224: iload 5
    //   3226: istore 7
    //   3228: lload 14
    //   3230: lstore 16
    //   3232: iload 5
    //   3234: istore 8
    //   3236: lload 14
    //   3238: lstore 20
    //   3240: aload 26
    //   3242: invokevirtual 790	java/io/ByteArrayOutputStream:close	()V
    //   3245: aload 26
    //   3247: astore 29
    //   3249: aload 28
    //   3251: astore 26
    //   3253: aload 29
    //   3255: astore 28
    //   3257: aload 35
    //   3259: aload_1
    //   3260: aload_1
    //   3261: iconst_4
    //   3262: invokeinterface 393 4 0
    //   3267: pop
    //   3268: iload 5
    //   3270: istore 6
    //   3272: iload 10
    //   3274: istore 5
    //   3276: iload 4
    //   3278: sipush 200
    //   3281: if_icmpeq +11 -> 3292
    //   3284: iload 4
    //   3286: sipush 206
    //   3289: if_icmpne +32 -> 3321
    //   3292: aload_0
    //   3293: aload_1
    //   3294: ldc_w 727
    //   3297: new 257	java/lang/StringBuilder
    //   3300: dup
    //   3301: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   3304: ldc_w 729
    //   3307: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3310: iload 6
    //   3312: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3315: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3318: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3321: aload_2
    //   3322: ifnull +13 -> 3335
    //   3325: aload_2
    //   3326: getfield 705	kuq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3329: invokevirtual 708	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3332: ifne +106 -> 3438
    //   3335: aload_0
    //   3336: aload_1
    //   3337: ldc_w 731
    //   3340: new 257	java/lang/StringBuilder
    //   3343: dup
    //   3344: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   3347: ldc_w 733
    //   3350: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3353: aload_1
    //   3354: invokevirtual 735	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   3357: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3360: ldc_w 737
    //   3363: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3366: aload_1
    //   3367: invokevirtual 739	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   3370: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3373: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3376: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3379: iload 5
    //   3381: ifeq +57 -> 3438
    //   3384: aload_1
    //   3385: getfield 785	com/tencent/mobileqq/utils/httputils/HttpMsg:h	I
    //   3388: sipush -9527
    //   3391: if_icmpne +47 -> 3438
    //   3394: aload_0
    //   3395: aload_1
    //   3396: ldc_w 787
    //   3399: new 257	java/lang/StringBuilder
    //   3402: dup
    //   3403: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   3406: ldc_w 762
    //   3409: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: aload_1
    //   3413: getfield 367	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   3416: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3419: ldc_w 764
    //   3422: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: aload_1
    //   3426: getfield 519	com/tencent/mobileqq/utils/httputils/HttpMsg:ah	Ljava/lang/String;
    //   3429: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3432: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3435: invokevirtual 293	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3438: aload_0
    //   3439: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3442: ifnull +17 -> 3459
    //   3445: aload 24
    //   3447: ifnull +12 -> 3459
    //   3450: aload_0
    //   3451: getfield 65	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3454: aload 24
    //   3456: invokevirtual 743	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3459: lload 12
    //   3461: lload 14
    //   3463: ladd
    //   3464: lstore 12
    //   3466: lload 12
    //   3468: lconst_0
    //   3469: lcmp
    //   3470: ifeq +25 -> 3495
    //   3473: aload_1
    //   3474: invokevirtual 249	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   3477: ldc 247
    //   3479: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3482: ifeq +252 -> 3734
    //   3485: iconst_1
    //   3486: istore_3
    //   3487: aload_0
    //   3488: aload_1
    //   3489: iload_3
    //   3490: lload 12
    //   3492: invokevirtual 746	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   3495: aload 28
    //   3497: ifnull +8 -> 3505
    //   3500: aload 28
    //   3502: invokevirtual 790	java/io/ByteArrayOutputStream:close	()V
    //   3505: aload 26
    //   3507: ifnull +8 -> 3515
    //   3510: aload 26
    //   3512: invokevirtual 793	java/io/InputStream:close	()V
    //   3515: aload 27
    //   3517: ifnull +8 -> 3525
    //   3520: aload 27
    //   3522: invokevirtual 751	java/io/OutputStream:close	()V
    //   3525: iload 5
    //   3527: istore 4
    //   3529: aload 25
    //   3531: ifnull -1879 -> 1652
    //   3534: aload 25
    //   3536: invokevirtual 754	java/net/HttpURLConnection:disconnect	()V
    //   3539: iload 5
    //   3541: istore 4
    //   3543: goto -1891 -> 1652
    //   3546: astore 24
    //   3548: aload 24
    //   3550: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   3553: iload 5
    //   3555: istore 4
    //   3557: goto -1905 -> 1652
    //   3560: iload 6
    //   3562: ifle +29 -> 3591
    //   3565: iload 5
    //   3567: istore 7
    //   3569: lload 14
    //   3571: lstore 16
    //   3573: iload 5
    //   3575: istore 8
    //   3577: lload 14
    //   3579: lstore 20
    //   3581: aload 26
    //   3583: aload 30
    //   3585: iconst_0
    //   3586: iload 6
    //   3588: invokevirtual 847	java/io/ByteArrayOutputStream:write	([BII)V
    //   3591: iload 5
    //   3593: istore 7
    //   3595: lload 14
    //   3597: lstore 16
    //   3599: iload 5
    //   3601: istore 8
    //   3603: lload 14
    //   3605: lstore 20
    //   3607: aload 26
    //   3609: invokevirtual 848	java/io/ByteArrayOutputStream:flush	()V
    //   3612: iload 5
    //   3614: istore 7
    //   3616: lload 14
    //   3618: lstore 16
    //   3620: iload 5
    //   3622: istore 8
    //   3624: lload 14
    //   3626: lstore 20
    //   3628: aload_1
    //   3629: aload 26
    //   3631: invokevirtual 851	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3634: invokevirtual 838	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3637: iload 5
    //   3639: istore 7
    //   3641: lload 14
    //   3643: lstore 16
    //   3645: iload 5
    //   3647: istore 8
    //   3649: lload 14
    //   3651: lstore 20
    //   3653: aload 35
    //   3655: aload_1
    //   3656: aload_1
    //   3657: invokeinterface 840 3 0
    //   3662: goto -438 -> 3224
    //   3665: astore 29
    //   3667: iconst_1
    //   3668: istore_3
    //   3669: lload 12
    //   3671: lstore 14
    //   3673: lload 16
    //   3675: lstore 12
    //   3677: aload 24
    //   3679: astore 30
    //   3681: iload 7
    //   3683: istore 5
    //   3685: aload 25
    //   3687: astore 24
    //   3689: aload 30
    //   3691: astore 25
    //   3693: goto -2322 -> 1371
    //   3696: iconst_1
    //   3697: istore 7
    //   3699: iload 4
    //   3701: istore 6
    //   3703: lload 14
    //   3705: lstore 18
    //   3707: aload_0
    //   3708: iload 4
    //   3710: aload 25
    //   3712: aload_1
    //   3713: invokevirtual 853	com/tencent/mobileqq/utils/httputils/HttpCommunicator:b	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   3716: iconst_1
    //   3717: istore 5
    //   3719: iload 9
    //   3721: istore 6
    //   3723: aload 34
    //   3725: astore 28
    //   3727: aload 33
    //   3729: astore 26
    //   3731: goto -455 -> 3276
    //   3734: iconst_0
    //   3735: istore_3
    //   3736: goto -249 -> 3487
    //   3739: iconst_0
    //   3740: istore_3
    //   3741: goto -2145 -> 1596
    //   3744: astore 24
    //   3746: aload 24
    //   3748: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   3751: iload 6
    //   3753: istore 4
    //   3755: goto -2103 -> 1652
    //   3758: iconst_0
    //   3759: istore_3
    //   3760: goto -1777 -> 1983
    //   3763: astore_1
    //   3764: aload_1
    //   3765: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   3768: goto -1737 -> 2031
    //   3771: aload 35
    //   3773: aload_1
    //   3774: aload_1
    //   3775: iconst_5
    //   3776: invokeinterface 393 4 0
    //   3781: pop
    //   3782: return
    //   3783: astore_1
    //   3784: goto -3169 -> 615
    //   3787: astore_1
    //   3788: goto -3161 -> 627
    //   3791: astore_1
    //   3792: goto -3155 -> 637
    //   3795: astore_1
    //   3796: goto -2641 -> 1155
    //   3799: astore_1
    //   3800: goto -2633 -> 1167
    //   3803: astore_1
    //   3804: goto -2627 -> 1177
    //   3807: astore_1
    //   3808: goto -1320 -> 2488
    //   3811: astore_1
    //   3812: goto -1312 -> 2500
    //   3815: astore_1
    //   3816: goto -1306 -> 2510
    //   3819: astore 24
    //   3821: goto -316 -> 3505
    //   3824: astore 24
    //   3826: goto -311 -> 3515
    //   3829: astore 24
    //   3831: goto -306 -> 3525
    //   3834: astore 25
    //   3836: goto -2222 -> 1614
    //   3839: astore 25
    //   3841: goto -2217 -> 1624
    //   3844: astore 25
    //   3846: goto -2212 -> 1634
    //   3849: astore_1
    //   3850: goto -1849 -> 2001
    //   3853: astore_1
    //   3854: goto -1843 -> 2011
    //   3857: astore_1
    //   3858: goto -1837 -> 2021
    //   3861: astore 24
    //   3863: aconst_null
    //   3864: astore 27
    //   3866: aconst_null
    //   3867: astore 25
    //   3869: aconst_null
    //   3870: astore 26
    //   3872: iconst_0
    //   3873: istore 4
    //   3875: lconst_0
    //   3876: lstore 12
    //   3878: iconst_m1
    //   3879: istore 5
    //   3881: iconst_0
    //   3882: istore_3
    //   3883: iload 8
    //   3885: istore 6
    //   3887: aload 31
    //   3889: astore 29
    //   3891: aload 30
    //   3893: astore 28
    //   3895: goto -2127 -> 1768
    //   3898: astore 24
    //   3900: aload 26
    //   3902: astore 27
    //   3904: aload 28
    //   3906: astore 26
    //   3908: iconst_0
    //   3909: istore 7
    //   3911: iload 8
    //   3913: istore 6
    //   3915: iload 22
    //   3917: istore_3
    //   3918: iload 4
    //   3920: istore 5
    //   3922: iload 7
    //   3924: istore 4
    //   3926: aload 31
    //   3928: astore 29
    //   3930: aload 30
    //   3932: astore 28
    //   3934: goto -2166 -> 1768
    //   3937: astore 28
    //   3939: aload 24
    //   3941: astore 27
    //   3943: iload 22
    //   3945: istore_3
    //   3946: aload 28
    //   3948: astore 24
    //   3950: iconst_0
    //   3951: istore 7
    //   3953: iload 8
    //   3955: istore 6
    //   3957: iload 4
    //   3959: istore 5
    //   3961: iload 7
    //   3963: istore 4
    //   3965: aload 31
    //   3967: astore 29
    //   3969: aload 30
    //   3971: astore 28
    //   3973: goto -2205 -> 1768
    //   3976: astore 28
    //   3978: iconst_0
    //   3979: istore 7
    //   3981: aload 24
    //   3983: astore 27
    //   3985: iload 22
    //   3987: istore_3
    //   3988: aload 28
    //   3990: astore 24
    //   3992: iload 8
    //   3994: istore 6
    //   3996: iload 4
    //   3998: istore 5
    //   4000: iload 7
    //   4002: istore 4
    //   4004: aload 31
    //   4006: astore 29
    //   4008: aload 30
    //   4010: astore 28
    //   4012: goto -2244 -> 1768
    //   4015: astore 28
    //   4017: iconst_0
    //   4018: istore 7
    //   4020: aload 24
    //   4022: astore 27
    //   4024: aload 28
    //   4026: astore 24
    //   4028: iload 8
    //   4030: istore 6
    //   4032: iload 22
    //   4034: istore_3
    //   4035: iload 4
    //   4037: istore 5
    //   4039: iload 7
    //   4041: istore 4
    //   4043: aload 31
    //   4045: astore 29
    //   4047: aload 30
    //   4049: astore 28
    //   4051: goto -2283 -> 1768
    //   4054: astore 29
    //   4056: iconst_0
    //   4057: istore 7
    //   4059: aload 24
    //   4061: astore 27
    //   4063: aload 28
    //   4065: astore 26
    //   4067: aload 29
    //   4069: astore 24
    //   4071: iload 8
    //   4073: istore 6
    //   4075: iload 22
    //   4077: istore_3
    //   4078: iload 4
    //   4080: istore 5
    //   4082: iload 7
    //   4084: istore 4
    //   4086: aload 31
    //   4088: astore 29
    //   4090: aload 30
    //   4092: astore 28
    //   4094: goto -2326 -> 1768
    //   4097: astore 30
    //   4099: iconst_0
    //   4100: istore 7
    //   4102: aload 26
    //   4104: astore 29
    //   4106: aload 24
    //   4108: astore 26
    //   4110: aload 30
    //   4112: astore 24
    //   4114: iload 8
    //   4116: istore 6
    //   4118: iload 22
    //   4120: istore_3
    //   4121: iload 4
    //   4123: istore 5
    //   4125: iload 7
    //   4127: istore 4
    //   4129: goto -2361 -> 1768
    //   4132: astore 30
    //   4134: iconst_0
    //   4135: istore 7
    //   4137: aload 26
    //   4139: astore 29
    //   4141: aload 24
    //   4143: astore 26
    //   4145: aload 30
    //   4147: astore 24
    //   4149: iload 8
    //   4151: istore 6
    //   4153: iload 22
    //   4155: istore_3
    //   4156: iload 4
    //   4158: istore 5
    //   4160: iload 7
    //   4162: istore 4
    //   4164: lload 20
    //   4166: lstore 14
    //   4168: goto -2400 -> 1768
    //   4171: astore 29
    //   4173: aload 26
    //   4175: astore 30
    //   4177: aload 24
    //   4179: astore 26
    //   4181: aload 29
    //   4183: astore 24
    //   4185: iconst_0
    //   4186: istore 7
    //   4188: iload 5
    //   4190: istore 6
    //   4192: iload 22
    //   4194: istore_3
    //   4195: iload 4
    //   4197: istore 5
    //   4199: iload 7
    //   4201: istore 4
    //   4203: aload 28
    //   4205: astore 29
    //   4207: aload 30
    //   4209: astore 28
    //   4211: goto -2443 -> 1768
    //   4214: astore 28
    //   4216: aload 24
    //   4218: astore 26
    //   4220: aload 28
    //   4222: astore 24
    //   4224: iload 8
    //   4226: istore 6
    //   4228: iload 22
    //   4230: istore_3
    //   4231: iload 4
    //   4233: istore 5
    //   4235: iload 7
    //   4237: istore 4
    //   4239: aload 31
    //   4241: astore 29
    //   4243: aload 30
    //   4245: astore 28
    //   4247: goto -2479 -> 1768
    //   4250: astore 31
    //   4252: iconst_1
    //   4253: istore 7
    //   4255: lload 14
    //   4257: lstore 16
    //   4259: aload 26
    //   4261: astore 29
    //   4263: aload 24
    //   4265: astore 30
    //   4267: aload 31
    //   4269: astore 24
    //   4271: aload 25
    //   4273: astore 26
    //   4275: iload 5
    //   4277: istore 6
    //   4279: iload 4
    //   4281: istore 5
    //   4283: iload 7
    //   4285: istore 4
    //   4287: lload 12
    //   4289: lstore 14
    //   4291: lload 16
    //   4293: lstore 12
    //   4295: aload 30
    //   4297: astore 25
    //   4299: goto -2531 -> 1768
    //   4302: astore 29
    //   4304: aconst_null
    //   4305: astore 26
    //   4307: aconst_null
    //   4308: astore 28
    //   4310: aconst_null
    //   4311: astore 27
    //   4313: aconst_null
    //   4314: astore 24
    //   4316: lconst_0
    //   4317: lstore 14
    //   4319: aconst_null
    //   4320: astore 25
    //   4322: iconst_0
    //   4323: istore 5
    //   4325: iconst_m1
    //   4326: istore 4
    //   4328: lconst_0
    //   4329: lstore 12
    //   4331: iload 22
    //   4333: istore_3
    //   4334: goto -2963 -> 1371
    //   4337: astore 29
    //   4339: aconst_null
    //   4340: astore 30
    //   4342: lload 12
    //   4344: lstore 14
    //   4346: lconst_0
    //   4347: lstore 12
    //   4349: iconst_0
    //   4350: istore 5
    //   4352: aload 25
    //   4354: astore 24
    //   4356: aconst_null
    //   4357: astore 31
    //   4359: aload 26
    //   4361: astore 27
    //   4363: iconst_1
    //   4364: istore_3
    //   4365: aload 28
    //   4367: astore 25
    //   4369: aload 30
    //   4371: astore 26
    //   4373: aload 31
    //   4375: astore 28
    //   4377: goto -3006 -> 1371
    //   4380: astore 29
    //   4382: aconst_null
    //   4383: astore 30
    //   4385: aconst_null
    //   4386: astore 28
    //   4388: aload 24
    //   4390: astore 27
    //   4392: lload 12
    //   4394: lstore 14
    //   4396: lconst_0
    //   4397: lstore 12
    //   4399: iconst_0
    //   4400: istore 5
    //   4402: iload 22
    //   4404: istore_3
    //   4405: aload 25
    //   4407: astore 24
    //   4409: aload 26
    //   4411: astore 25
    //   4413: aload 30
    //   4415: astore 26
    //   4417: goto -3046 -> 1371
    //   4420: astore 29
    //   4422: aconst_null
    //   4423: astore 31
    //   4425: aload 25
    //   4427: astore 28
    //   4429: aconst_null
    //   4430: astore 30
    //   4432: aload 24
    //   4434: astore 27
    //   4436: lload 12
    //   4438: lstore 14
    //   4440: lconst_0
    //   4441: lstore 12
    //   4443: aload 26
    //   4445: astore 25
    //   4447: iconst_0
    //   4448: istore 5
    //   4450: iload 22
    //   4452: istore_3
    //   4453: aload 28
    //   4455: astore 24
    //   4457: aload 31
    //   4459: astore 26
    //   4461: aload 30
    //   4463: astore 28
    //   4465: goto -3094 -> 1371
    //   4468: astore 29
    //   4470: aconst_null
    //   4471: astore 31
    //   4473: aload 25
    //   4475: astore 28
    //   4477: aconst_null
    //   4478: astore 30
    //   4480: aload 24
    //   4482: astore 27
    //   4484: lload 12
    //   4486: lstore 14
    //   4488: lconst_0
    //   4489: lstore 12
    //   4491: iconst_0
    //   4492: istore 5
    //   4494: aload 26
    //   4496: astore 25
    //   4498: iconst_1
    //   4499: istore_3
    //   4500: aload 28
    //   4502: astore 24
    //   4504: aload 31
    //   4506: astore 26
    //   4508: aload 30
    //   4510: astore 28
    //   4512: goto -3141 -> 1371
    //   4515: astore 29
    //   4517: iconst_1
    //   4518: istore_3
    //   4519: aconst_null
    //   4520: astore 26
    //   4522: aconst_null
    //   4523: astore 30
    //   4525: aload 24
    //   4527: astore 27
    //   4529: lload 12
    //   4531: lstore 14
    //   4533: lconst_0
    //   4534: lstore 12
    //   4536: iconst_0
    //   4537: istore 5
    //   4539: aload 25
    //   4541: astore 24
    //   4543: aload 28
    //   4545: astore 25
    //   4547: aload 30
    //   4549: astore 28
    //   4551: goto -3180 -> 1371
    //   4554: astore 29
    //   4556: iconst_1
    //   4557: istore_3
    //   4558: aconst_null
    //   4559: astore 30
    //   4561: lload 12
    //   4563: lstore 16
    //   4565: lload 14
    //   4567: lstore 12
    //   4569: aload 24
    //   4571: astore 26
    //   4573: iconst_0
    //   4574: istore 5
    //   4576: aload 25
    //   4578: astore 24
    //   4580: aload 26
    //   4582: astore 25
    //   4584: lload 16
    //   4586: lstore 14
    //   4588: aload 30
    //   4590: astore 26
    //   4592: goto -3221 -> 1371
    //   4595: astore 29
    //   4597: iconst_1
    //   4598: istore_3
    //   4599: lload 12
    //   4601: lstore 16
    //   4603: lload 14
    //   4605: lstore 12
    //   4607: aload 24
    //   4609: astore 30
    //   4611: iconst_0
    //   4612: istore 5
    //   4614: aload 25
    //   4616: astore 24
    //   4618: aload 30
    //   4620: astore 25
    //   4622: lload 16
    //   4624: lstore 14
    //   4626: goto -3255 -> 1371
    //   4629: astore 29
    //   4631: aload 24
    //   4633: astore 31
    //   4635: iconst_1
    //   4636: istore_3
    //   4637: aload 25
    //   4639: astore 24
    //   4641: aload 26
    //   4643: astore 30
    //   4645: lload 12
    //   4647: lstore 16
    //   4649: lload 14
    //   4651: lstore 12
    //   4653: aload 31
    //   4655: astore 25
    //   4657: lload 16
    //   4659: lstore 14
    //   4661: aload 28
    //   4663: astore 26
    //   4665: aload 30
    //   4667: astore 28
    //   4669: goto -3298 -> 1371
    //   4672: astore 28
    //   4674: goto -3745 -> 929
    //   4677: iconst_0
    //   4678: istore 5
    //   4680: aconst_null
    //   4681: astore 28
    //   4683: aconst_null
    //   4684: astore 26
    //   4686: goto -1429 -> 3257
    //   4689: aload 24
    //   4691: astore 27
    //   4693: aload 26
    //   4695: astore 24
    //   4697: goto -4372 -> 325
    //   4700: iconst_0
    //   4701: istore_3
    //   4702: goto -2234 -> 2468
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4705	0	this	HttpCommunicator
    //   0	4705	1	paramHttpMsg	HttpMsg
    //   0	4705	2	paramkuq	kuq
    //   0	4705	3	paramBoolean	boolean
    //   54	4273	4	i1	int
    //   205	4474	5	i2	int
    //   327	3951	6	i3	int
    //   45	4239	7	i4	int
    //   34	4191	8	i5	int
    //   31	3689	9	i6	int
    //   22	3251	10	i7	int
    //   2934	43	11	i8	int
    //   63	4589	12	l1	long
    //   25	4635	14	l2	long
    //   295	4363	16	l3	long
    //   331	3375	18	l4	long
    //   2875	1290	20	l5	long
    //   28	4423	22	bool1	boolean
    //   438	3	23	bool2	boolean
    //   60	3395	24	localObject1	Object
    //   3546	132	24	localException1	Exception
    //   3687	1	24	localObject2	Object
    //   3744	3	24	localException2	Exception
    //   3819	1	24	localIOException1	IOException
    //   3824	1	24	localIOException2	IOException
    //   3829	1	24	localIOException3	IOException
    //   3861	1	24	localObject3	Object
    //   3898	42	24	localObject4	Object
    //   3948	748	24	localObject5	Object
    //   57	3654	25	localObject6	Object
    //   3834	1	25	localIOException4	IOException
    //   3839	1	25	localIOException5	IOException
    //   3844	1	25	localIOException6	IOException
    //   3867	789	25	localObject7	Object
    //   51	4643	26	localObject8	Object
    //   87	4605	27	localObject9	Object
    //   146	3787	28	localObject10	Object
    //   3937	10	28	localObject11	Object
    //   3971	1	28	localObject12	Object
    //   3976	13	28	localObject13	Object
    //   4010	1	28	localObject14	Object
    //   4015	10	28	localObject15	Object
    //   4049	161	28	localObject16	Object
    //   4214	7	28	localObject17	Object
    //   4245	423	28	localObject18	Object
    //   4672	1	28	localThrowable1	Throwable
    //   4681	1	28	localObject19	Object
    //   343	979	29	localObject20	Object
    //   1334	48	29	localThrowable2	Throwable
    //   1723	1531	29	localObject21	Object
    //   3665	1	29	localThrowable3	Throwable
    //   3889	157	29	localObject22	Object
    //   4054	14	29	localObject23	Object
    //   4088	52	29	localObject24	Object
    //   4171	11	29	localObject25	Object
    //   4205	57	29	localObject26	Object
    //   4302	1	29	localThrowable4	Throwable
    //   4337	1	29	localThrowable5	Throwable
    //   4380	1	29	localThrowable6	Throwable
    //   4420	1	29	localThrowable7	Throwable
    //   4468	1	29	localThrowable8	Throwable
    //   4515	1	29	localThrowable9	Throwable
    //   4554	1	29	localThrowable10	Throwable
    //   4595	1	29	localThrowable11	Throwable
    //   4629	1	29	localThrowable12	Throwable
    //   7	1361	30	localObject27	Object
    //   1736	29	30	localObject28	Object
    //   2853	1238	30	localObject29	Object
    //   4097	14	30	localObject30	Object
    //   4132	14	30	localObject31	Object
    //   4175	491	30	localObject32	Object
    //   19	4221	31	localObject33	Object
    //   4250	18	31	localObject34	Object
    //   4357	297	31	localObject35	Object
    //   13	2804	32	localObject36	Object
    //   10	3718	33	localObject37	Object
    //   16	3708	34	localObject38	Object
    //   4	3768	35	localIHttpCommunicatorListener	IHttpCommunicatorListener
    // Exception table:
    //   from	to	target	type
    //   547	554	653	java/lang/Exception
    //   559	568	653	java/lang/Exception
    //   581	593	653	java/lang/Exception
    //   595	603	653	java/lang/Exception
    //   607	615	653	java/lang/Exception
    //   619	627	653	java/lang/Exception
    //   632	637	653	java/lang/Exception
    //   642	647	653	java/lang/Exception
    //   1087	1094	1188	java/lang/Exception
    //   1099	1108	1188	java/lang/Exception
    //   1121	1133	1188	java/lang/Exception
    //   1135	1143	1188	java/lang/Exception
    //   1147	1155	1188	java/lang/Exception
    //   1159	1167	1188	java/lang/Exception
    //   1172	1177	1188	java/lang/Exception
    //   1182	1187	1188	java/lang/Exception
    //   345	351	1334	java/lang/Throwable
    //   371	378	1334	java/lang/Throwable
    //   398	407	1334	java/lang/Throwable
    //   431	440	1334	java/lang/Throwable
    //   679	686	1334	java/lang/Throwable
    //   711	720	1334	java/lang/Throwable
    //   740	769	1334	java/lang/Throwable
    //   811	855	1334	java/lang/Throwable
    //   875	885	1334	java/lang/Throwable
    //   949	956	1334	java/lang/Throwable
    //   976	985	1334	java/lang/Throwable
    //   1219	1230	1334	java/lang/Throwable
    //   1250	1256	1334	java/lang/Throwable
    //   1276	1283	1334	java/lang/Throwable
    //   1323	1334	1334	java/lang/Throwable
    //   1725	1736	1334	java/lang/Throwable
    //   2054	2062	1334	java/lang/Throwable
    //   2098	2105	1334	java/lang/Throwable
    //   2139	2146	1334	java/lang/Throwable
    //   2166	2178	1334	java/lang/Throwable
    //   2198	2210	1334	java/lang/Throwable
    //   2230	2236	1334	java/lang/Throwable
    //   2256	2262	1334	java/lang/Throwable
    //   2282	2291	1334	java/lang/Throwable
    //   2311	2318	1334	java/lang/Throwable
    //   2547	2554	1334	java/lang/Throwable
    //   2577	2586	1334	java/lang/Throwable
    //   2606	2618	1334	java/lang/Throwable
    //   2638	2648	1334	java/lang/Throwable
    //   2668	2699	1334	java/lang/Throwable
    //   2719	2728	1334	java/lang/Throwable
    //   2748	2760	1334	java/lang/Throwable
    //   2780	2793	1334	java/lang/Throwable
    //   2820	2827	1334	java/lang/Throwable
    //   3707	3716	1334	java/lang/Throwable
    //   1681	1690	1691	java/lang/Exception
    //   3771	3782	1691	java/lang/Exception
    //   345	351	1736	finally
    //   371	378	1736	finally
    //   398	407	1736	finally
    //   431	440	1736	finally
    //   679	686	1736	finally
    //   711	720	1736	finally
    //   740	769	1736	finally
    //   811	855	1736	finally
    //   875	885	1736	finally
    //   907	912	1736	finally
    //   924	929	1736	finally
    //   949	956	1736	finally
    //   976	985	1736	finally
    //   1219	1230	1736	finally
    //   1250	1256	1736	finally
    //   1276	1283	1736	finally
    //   1323	1334	1736	finally
    //   1725	1736	1736	finally
    //   2054	2062	1736	finally
    //   2098	2105	1736	finally
    //   2139	2146	1736	finally
    //   2166	2178	1736	finally
    //   2198	2210	1736	finally
    //   2230	2236	1736	finally
    //   2256	2262	1736	finally
    //   2282	2291	1736	finally
    //   2311	2318	1736	finally
    //   2547	2554	1736	finally
    //   2577	2586	1736	finally
    //   2606	2618	1736	finally
    //   2638	2648	1736	finally
    //   2668	2699	1736	finally
    //   2719	2728	1736	finally
    //   2748	2760	1736	finally
    //   2780	2793	1736	finally
    //   2820	2827	1736	finally
    //   2839	2848	1736	finally
    //   2420	2427	2521	java/lang/Exception
    //   2432	2441	2521	java/lang/Exception
    //   2454	2466	2521	java/lang/Exception
    //   2468	2476	2521	java/lang/Exception
    //   2480	2488	2521	java/lang/Exception
    //   2492	2500	2521	java/lang/Exception
    //   2505	2510	2521	java/lang/Exception
    //   2515	2520	2521	java/lang/Exception
    //   3438	3445	3546	java/lang/Exception
    //   3450	3459	3546	java/lang/Exception
    //   3473	3485	3546	java/lang/Exception
    //   3487	3495	3546	java/lang/Exception
    //   3500	3505	3546	java/lang/Exception
    //   3510	3515	3546	java/lang/Exception
    //   3520	3525	3546	java/lang/Exception
    //   3534	3539	3546	java/lang/Exception
    //   2877	2894	3665	java/lang/Throwable
    //   2915	2921	3665	java/lang/Throwable
    //   2971	2979	3665	java/lang/Throwable
    //   2995	3002	3665	java/lang/Throwable
    //   3018	3024	3665	java/lang/Throwable
    //   3040	3049	3665	java/lang/Throwable
    //   3079	3086	3665	java/lang/Throwable
    //   3116	3123	3665	java/lang/Throwable
    //   3144	3150	3665	java/lang/Throwable
    //   3166	3177	3665	java/lang/Throwable
    //   3193	3199	3665	java/lang/Throwable
    //   3215	3224	3665	java/lang/Throwable
    //   3240	3245	3665	java/lang/Throwable
    //   3581	3591	3665	java/lang/Throwable
    //   3607	3612	3665	java/lang/Throwable
    //   3628	3637	3665	java/lang/Throwable
    //   3653	3662	3665	java/lang/Throwable
    //   1547	1554	3744	java/lang/Exception
    //   1559	1568	3744	java/lang/Exception
    //   1582	1594	3744	java/lang/Exception
    //   1596	1604	3744	java/lang/Exception
    //   1609	1614	3744	java/lang/Exception
    //   1619	1624	3744	java/lang/Exception
    //   1629	1634	3744	java/lang/Exception
    //   1643	1648	3744	java/lang/Exception
    //   1934	1941	3763	java/lang/Exception
    //   1946	1955	3763	java/lang/Exception
    //   1969	1981	3763	java/lang/Exception
    //   1983	1991	3763	java/lang/Exception
    //   1996	2001	3763	java/lang/Exception
    //   2006	2011	3763	java/lang/Exception
    //   2016	2021	3763	java/lang/Exception
    //   2026	2031	3763	java/lang/Exception
    //   607	615	3783	java/io/IOException
    //   619	627	3787	java/io/IOException
    //   632	637	3791	java/io/IOException
    //   1147	1155	3795	java/io/IOException
    //   1159	1167	3799	java/io/IOException
    //   1172	1177	3803	java/io/IOException
    //   2480	2488	3807	java/io/IOException
    //   2492	2500	3811	java/io/IOException
    //   2505	2510	3815	java/io/IOException
    //   3500	3505	3819	java/io/IOException
    //   3510	3515	3824	java/io/IOException
    //   3520	3525	3829	java/io/IOException
    //   1609	1614	3834	java/io/IOException
    //   1619	1624	3839	java/io/IOException
    //   1629	1634	3844	java/io/IOException
    //   1996	2001	3849	java/io/IOException
    //   2006	2011	3853	java/io/IOException
    //   2016	2021	3857	java/io/IOException
    //   36	44	3861	finally
    //   174	204	3898	finally
    //   207	247	3898	finally
    //   262	272	3898	finally
    //   272	283	3898	finally
    //   283	302	3898	finally
    //   65	89	3937	finally
    //   93	117	3976	finally
    //   120	148	4015	finally
    //   148	174	4054	finally
    //   2848	2855	4097	finally
    //   2877	2894	4132	finally
    //   2915	2921	4132	finally
    //   2971	2979	4132	finally
    //   2995	3002	4132	finally
    //   3018	3024	4132	finally
    //   3040	3049	4132	finally
    //   3079	3086	4132	finally
    //   3116	3123	4132	finally
    //   3144	3150	4132	finally
    //   3166	3177	4132	finally
    //   3193	3199	4132	finally
    //   3215	3224	4132	finally
    //   3240	3245	4132	finally
    //   3581	3591	4132	finally
    //   3607	3612	4132	finally
    //   3628	3637	4132	finally
    //   3653	3662	4132	finally
    //   3257	3268	4171	finally
    //   3707	3716	4214	finally
    //   1374	1386	4250	finally
    //   36	44	4302	java/lang/Throwable
    //   174	204	4337	java/lang/Throwable
    //   207	247	4337	java/lang/Throwable
    //   262	272	4337	java/lang/Throwable
    //   272	283	4337	java/lang/Throwable
    //   283	302	4337	java/lang/Throwable
    //   65	89	4380	java/lang/Throwable
    //   93	117	4420	java/lang/Throwable
    //   120	148	4468	java/lang/Throwable
    //   148	174	4515	java/lang/Throwable
    //   2839	2848	4554	java/lang/Throwable
    //   2848	2855	4595	java/lang/Throwable
    //   3257	3268	4629	java/lang/Throwable
    //   907	912	4672	java/lang/Throwable
    //   924	929	4672	java/lang/Throwable
  }
  
  protected void a(HttpMsg paramHttpMsg, boolean paramBoolean, long paramLong)
  {
    paramHttpMsg.i = ((int)paramLong);
    int i1 = paramHttpMsg.jdField_d_of_type_Int;
    int i2 = paramHttpMsg.jdField_e_of_type_Int;
    int i3 = paramHttpMsg.f;
    if (((i1 == -1) || (i2 == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i1 + ",busiType:" + i2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount.a(paramBoolean, i3, i1, i2, paramLong);
    }
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    if (this.d) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() + " mConcurrentRunningMsgs:" + this.o + " mConcurrentLimit:" + this.n + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() == 0) {
        return;
      }
    }
    kuq[] arrayOfkuq;
    int i2;
    if (this.o < this.n)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(false);
      if (paramString != null)
      {
        arrayOfkuq = this.jdField_a_of_type_ArrayOfKuq;
        i2 = arrayOfkuq.length;
      }
    }
    for (;;)
    {
      kuq localkuq;
      HttpMsg localHttpMsg;
      if (i1 < i2)
      {
        localkuq = arrayOfkuq[i1];
        localHttpMsg = localkuq.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
        if (localkuq.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label256;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramString);
        paramString.b();
        localkuq.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localkuq.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramString;
        localkuq.a(paramString);
        this.o += 1;
        if (QLog.isColorLevel()) {
          a(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label256:
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!localkuq.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localHttpMsg == null) || (localHttpMsg.b() <= paramString.b())) {
          break;
        }
        localkuq.a();
      }
      i1 += 1;
    }
  }
  
  public void a(kuq paramkuq)
  {
    if (this.d) {}
    int i1;
    do
    {
      do
      {
        return;
      } while (paramkuq == null);
      paramkuq.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i1 = paramkuq.jdField_a_of_type_Int;
      if ((i1 >= 0) && (i1 < 3))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i1, 5);
        ((HandlerThread)???).start();
        kuq localkuq = new kuq(this, ((HandlerThread)???).getLooper());
        localkuq.jdField_a_of_type_Int = i1;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ArrayOfKuq[i1] = localkuq;
          if (paramkuq.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            this.o -= 1;
          }
          a("replaceNewThread index:" + i1);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i1);
  }
  
  void a(kuq paramkuq, HttpMsg paramHttpMsg)
  {
    if (!this.c) {
      throw new IOException("httpcommunicator closed");
    }
    if (paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("request cancelled");
    }
    if ((paramkuq != null) && (paramkuq.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      throw new RuntimeException("thread should close");
    }
    if (paramHttpMsg.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(paramHttpMsg, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  void a(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      paramHttpMsg.a(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      paramHttpMsg.a(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = BaseTransProcessor.a("Q", -9531L);
        paramHttpMsg.b(HttpMsg.ai, paramHttpURLConnection);
        paramHttpMsg.a(-9527, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        paramHttpMsg.a(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            paramHttpMsg.a(9014, paramInt, paramThrowable.toString());
            return;
          }
          paramHttpMsg.a(9050, paramInt, paramThrowable.toString());
          return;
        }
        paramHttpMsg.a(9049, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof SocketException))
      {
        if ((paramThrowable instanceof ConnectException))
        {
          paramHttpMsg.a(9052, paramInt, paramThrowable.toString());
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          paramHttpMsg.a(9053, paramInt, paramThrowable.toString());
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          paramHttpMsg.a(9054, paramInt, paramThrowable.toString());
          return;
        }
        paramHttpMsg.a(9051, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        paramHttpMsg.a(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        paramHttpMsg.a(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramHttpMsg.a(9047, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof SecurityException))
    {
      paramHttpMsg.a(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpMsg.a(9322, paramInt, Log.getStackTraceString(paramThrowable));
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public int b()
  {
    return 3;
  }
  
  public int b(HttpMsg paramHttpMsg)
  {
    int i1 = this.m;
    int i2 = -1;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((!this.d) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() < i1))
        {
          i1 = this.k + 1;
          this.k = i1;
          paramHttpMsg.a(i1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
          paramHttpMsg.a().a(paramHttpMsg, null, 0);
          i1 = this.k;
          ??? = new Object();
          paramHttpMsg.jdField_a_of_type_JavaLangObject = ???;
          paramHttpMsg.c = new AtomicBoolean(false);
          a("sendMsgSync");
          if (paramHttpMsg.c.get()) {}
        }
      }
      try
      {
        ???.wait();
        return i1;
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        i1 = i2;
        continue;
        paramHttpMsg = finally;
        throw paramHttpMsg;
      }
      catch (InterruptedException paramHttpMsg)
      {
        for (;;)
        {
          paramHttpMsg.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close.async doclose");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new kup(this));
  }
  
  void b(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    new StringBuilder().append("Response code: ").append(paramInt).toString();
    long l2 = 0L;
    String str = paramHttpURLConnection.getHeaderField("X-ErrNo");
    if ((str != null) && (!str.equals(""))) {}
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        paramHttpURLConnection = BaseTransProcessor.b(paramInt, l1);
        paramHttpMsg.b(HttpMsg.ai, paramHttpURLConnection);
        paramHttpMsg.a(-9527, paramInt, paramHttpURLConnection);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        l1 = l2;
        continue;
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("User-ReturnCode");
      long l1 = l2;
      if (paramHttpURLConnection != null)
      {
        l1 = l2;
        if (!paramHttpURLConnection.equals("")) {
          try
          {
            l1 = Long.parseLong(paramHttpURLConnection);
          }
          catch (Exception paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void b(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg != null)
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = paramHttpMsg.a();
      if ((localIHttpCommunicatorListener instanceof BaseTransProcessor)) {
        ((BaseTransProcessor)localIHttpCommunicatorListener).a(2, 9014, "sscm http timeout");
      }
      paramHttpMsg.a().b(paramHttpMsg, null);
    }
  }
  
  public void c()
  {
    int i1 = 0;
    long l1;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l1 = System.currentTimeMillis();
      HttpMsg localHttpMsg;
      do
      {
        localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(true);
        if (localHttpMsg == null) {
          break;
        }
      } while ((localHttpMsg == null) || (localHttpMsg.a() == null));
      localHttpMsg.a(9366, -1, "httpcommunicator_close");
      localHttpMsg.a().b(localHttpMsg, localHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a();
    kuq[] arrayOfkuq = this.jdField_a_of_type_ArrayOfKuq;
    int i2 = arrayOfkuq.length;
    while (i1 < i2)
    {
      arrayOfkuq[i1].sendEmptyMessage(1);
      i1 += 1;
    }
    this.jdField_a_of_type_ArrayOfKuq = null;
    this.o = 0;
    this.n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close_inter.elapse:" + (System.currentTimeMillis() - l1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator
 * JD-Core Version:    0.7.0.1
 */