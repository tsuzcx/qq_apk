package com.pay.http;

import com.pay.tool.APMidasTools;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.HashMap;

public abstract class APBaseHttpReq
  extends Thread
{
  protected IAPHttpAns httpAns;
  public APBaseHttpParam httpParam = new APBaseHttpParam();
  protected HttpURLConnection httpURLConnection;
  private boolean isStop = false;
  private byte[] resultContent;
  
  public APBaseHttpReq()
  {
    this.httpParam.reqParam = new HashMap();
    this.httpParam.domain = APMidasTools.getSysServerDomain();
  }
  
  private void closeOutput()
  {
    try
    {
      boolean bool = this.httpURLConnection.getDoOutput();
      if (bool) {}
      return;
    }
    catch (Exception localException)
    {
      try
      {
        this.httpURLConnection.getOutputStream().flush();
        this.httpURLConnection.getOutputStream().close();
        return;
      }
      catch (Throwable localThrowable) {}
      localException = localException;
      APLog.i("closeOutput", localException.toString());
      return;
    }
  }
  
  private void closeStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      if (paramOutputStream != null)
      {
        paramOutputStream.flush();
        paramOutputStream.close();
      }
      this.httpURLConnection.disconnect();
      return;
    }
    catch (Exception paramInputStream) {}
  }
  
  private void createConnection()
  {
    try
    {
      localURL = new URL(this.httpParam.url);
      if (APMidasPayAPI.env.equals("testing"))
      {
        APLog.i("APHttp Request", "URL = " + this.httpParam.url);
        this.httpAns.onStart(this);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        try
        {
          URL localURL;
          this.httpURLConnection = ((HttpURLConnection)localURL.openConnection());
          this.httpURLConnection.setConnectTimeout(this.httpParam.connectTimeout);
          this.httpURLConnection.setReadTimeout(this.httpParam.readTimeout);
          this.httpURLConnection.setRequestProperty("Host", this.httpParam.defaultDomain);
          this.httpURLConnection.setUseCaches(false);
          return;
        }
        catch (Exception localException)
        {
          Object localObject;
          APLog.i("createConnection", localException.toString());
        }
        localMalformedURLException = localMalformedURLException;
        localObject = null;
        continue;
        APLog.i("APHttp Request", "URL = " + this.httpParam.url + " HOST = " + this.httpParam.defaultDomain);
      }
    }
  }
  
  private void initRequest()
  {
    constructParam();
    this.httpParam.constructUrl();
    preCreateConnection();
    createConnection();
    closeOutput();
    setHeader();
    setBody();
  }
  
  /* Error */
  private void requestProgress()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: new 192	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 193	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore 6
    //   13: aload_0
    //   14: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   17: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   20: putfield 203	com/pay/http/APBaseHttpParam:begTime	J
    //   23: aload_0
    //   24: invokespecial 205	com/pay/http/APBaseHttpReq:initRequest	()V
    //   27: aload_0
    //   28: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   31: getfield 208	com/pay/http/APBaseHttpParam:sendType	Ljava/lang/String;
    //   34: ldc 210
    //   36: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +39 -> 78
    //   42: new 212	java/io/DataOutputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 50	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   50: invokevirtual 60	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   53: invokespecial 215	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore 4
    //   58: aload 4
    //   60: aload_0
    //   61: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   64: getfield 218	com/pay/http/APBaseHttpParam:urlParams	Ljava/lang/String;
    //   67: invokevirtual 222	java/lang/String:getBytes	()[B
    //   70: invokevirtual 226	java/io/DataOutputStream:write	([B)V
    //   73: aload 4
    //   75: invokevirtual 227	java/io/DataOutputStream:flush	()V
    //   78: aload_0
    //   79: getfield 50	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   82: invokevirtual 231	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_3
    //   90: aload_3
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 50	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   97: invokevirtual 235	java/net/HttpURLConnection:getResponseCode	()I
    //   100: sipush 200
    //   103: if_icmpne +395 -> 498
    //   106: aload_3
    //   107: astore 4
    //   109: sipush 1024
    //   112: newarray byte
    //   114: astore 5
    //   116: aload_3
    //   117: astore 4
    //   119: aload_3
    //   120: aload 5
    //   122: invokevirtual 239	java/io/InputStream:read	([B)I
    //   125: istore_2
    //   126: iload_2
    //   127: ifle +250 -> 377
    //   130: aload_3
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 20	com/pay/http/APBaseHttpReq:isStop	Z
    //   137: ifeq +97 -> 234
    //   140: aload_3
    //   141: astore 4
    //   143: invokestatic 243	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   146: invokevirtual 246	java/lang/Thread:interrupt	()V
    //   149: aload_0
    //   150: aload_3
    //   151: aload 6
    //   153: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   156: aload_0
    //   157: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   160: getfield 251	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   163: ldc 253
    //   165: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +38 -> 206
    //   171: ldc 255
    //   173: ldc_w 257
    //   176: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: ldc_w 262
    //   182: invokestatic 268	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   185: astore_3
    //   186: aload_3
    //   187: aconst_null
    //   188: aconst_null
    //   189: new 270	java/security/SecureRandom
    //   192: dup
    //   193: invokespecial 271	java/security/SecureRandom:<init>	()V
    //   196: invokevirtual 275	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   199: aload_3
    //   200: invokevirtual 279	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   203: invokestatic 285	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   206: return
    //   207: astore_3
    //   208: ldc 255
    //   210: new 114	java/lang/StringBuilder
    //   213: dup
    //   214: ldc_w 287
    //   217: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: aload_3
    //   221: invokevirtual 72	java/lang/Exception:toString	()Ljava/lang/String;
    //   224: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: return
    //   234: aload_3
    //   235: astore 4
    //   237: aload 6
    //   239: aload 5
    //   241: iconst_0
    //   242: iload_2
    //   243: invokevirtual 290	java/io/ByteArrayOutputStream:write	([BII)V
    //   246: iload_1
    //   247: iload_2
    //   248: iadd
    //   249: istore_1
    //   250: aload_3
    //   251: astore 4
    //   253: aload_0
    //   254: getfield 124	com/pay/http/APBaseHttpReq:httpAns	Lcom/pay/http/IAPHttpAns;
    //   257: aload 5
    //   259: iload_2
    //   260: iload_1
    //   261: i2l
    //   262: aload_0
    //   263: invokeinterface 294 6 0
    //   268: goto -152 -> 116
    //   271: astore 4
    //   273: aload_0
    //   274: aload_3
    //   275: aload 6
    //   277: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   280: aload_0
    //   281: bipush 249
    //   283: iconst_m1
    //   284: aload 4
    //   286: ldc_w 296
    //   289: invokespecial 300	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   292: aload_0
    //   293: aload_3
    //   294: aload 6
    //   296: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   299: aload_0
    //   300: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   303: getfield 251	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   306: ldc 253
    //   308: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifeq -105 -> 206
    //   314: ldc 255
    //   316: ldc_w 257
    //   319: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: ldc_w 262
    //   325: invokestatic 268	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   328: astore_3
    //   329: aload_3
    //   330: aconst_null
    //   331: aconst_null
    //   332: new 270	java/security/SecureRandom
    //   335: dup
    //   336: invokespecial 271	java/security/SecureRandom:<init>	()V
    //   339: invokevirtual 275	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   342: aload_3
    //   343: invokevirtual 279	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   346: invokestatic 285	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   349: return
    //   350: astore_3
    //   351: ldc 255
    //   353: new 114	java/lang/StringBuilder
    //   356: dup
    //   357: ldc_w 287
    //   360: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload_3
    //   364: invokevirtual 72	java/lang/Exception:toString	()Ljava/lang/String;
    //   367: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: return
    //   377: aload_3
    //   378: astore 4
    //   380: aload_0
    //   381: aload 6
    //   383: invokevirtual 303	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   386: putfield 305	com/pay/http/APBaseHttpReq:resultContent	[B
    //   389: aload_3
    //   390: astore 4
    //   392: aload_0
    //   393: getfield 124	com/pay/http/APBaseHttpReq:httpAns	Lcom/pay/http/IAPHttpAns;
    //   396: aload_0
    //   397: invokeinterface 308 2 0
    //   402: aload_3
    //   403: astore 4
    //   405: aload_0
    //   406: iconst_0
    //   407: sipush 200
    //   410: invokespecial 312	com/pay/http/APBaseHttpReq:sendReportData	(II)V
    //   413: aload_0
    //   414: aload_3
    //   415: aload 6
    //   417: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   420: aload_0
    //   421: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   424: getfield 251	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   427: ldc 253
    //   429: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   432: ifeq -226 -> 206
    //   435: ldc 255
    //   437: ldc_w 257
    //   440: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: ldc_w 262
    //   446: invokestatic 268	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   449: astore_3
    //   450: aload_3
    //   451: aconst_null
    //   452: aconst_null
    //   453: new 270	java/security/SecureRandom
    //   456: dup
    //   457: invokespecial 271	java/security/SecureRandom:<init>	()V
    //   460: invokevirtual 275	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   463: aload_3
    //   464: invokevirtual 279	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   467: invokestatic 285	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   470: return
    //   471: astore_3
    //   472: ldc 255
    //   474: new 114	java/lang/StringBuilder
    //   477: dup
    //   478: ldc_w 287
    //   481: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   484: aload_3
    //   485: invokevirtual 72	java/lang/Exception:toString	()Ljava/lang/String;
    //   488: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: return
    //   498: aload_3
    //   499: astore 4
    //   501: new 114	java/lang/StringBuilder
    //   504: dup
    //   505: ldc_w 314
    //   508: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   511: aload_0
    //   512: getfield 50	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   515: invokevirtual 235	java/net/HttpURLConnection:getResponseCode	()I
    //   518: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: ldc_w 319
    //   524: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: astore 5
    //   532: aload_3
    //   533: astore 4
    //   535: aload_0
    //   536: bipush 246
    //   538: aload_0
    //   539: getfield 50	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   542: invokevirtual 235	java/net/HttpURLConnection:getResponseCode	()I
    //   545: aconst_null
    //   546: aload 5
    //   548: invokespecial 300	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   551: goto -138 -> 413
    //   554: astore 5
    //   556: aload_3
    //   557: astore 4
    //   559: aload_0
    //   560: aload_3
    //   561: aload 6
    //   563: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   566: aload_3
    //   567: astore 4
    //   569: aload_0
    //   570: bipush 248
    //   572: iconst_m1
    //   573: aload 5
    //   575: ldc_w 321
    //   578: invokespecial 300	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   581: aload_0
    //   582: aload_3
    //   583: aload 6
    //   585: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   588: aload_0
    //   589: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   592: getfield 251	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   595: ldc 253
    //   597: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   600: ifeq -394 -> 206
    //   603: ldc 255
    //   605: ldc_w 257
    //   608: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   611: ldc_w 262
    //   614: invokestatic 268	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   617: astore_3
    //   618: aload_3
    //   619: aconst_null
    //   620: aconst_null
    //   621: new 270	java/security/SecureRandom
    //   624: dup
    //   625: invokespecial 271	java/security/SecureRandom:<init>	()V
    //   628: invokevirtual 275	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   631: aload_3
    //   632: invokevirtual 279	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   635: invokestatic 285	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   638: return
    //   639: astore_3
    //   640: ldc 255
    //   642: new 114	java/lang/StringBuilder
    //   645: dup
    //   646: ldc_w 287
    //   649: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   652: aload_3
    //   653: invokevirtual 72	java/lang/Exception:toString	()Ljava/lang/String;
    //   656: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: return
    //   666: astore 5
    //   668: aconst_null
    //   669: astore_3
    //   670: aload_3
    //   671: astore 4
    //   673: aload_0
    //   674: aload 5
    //   676: invokestatic 325	com/pay/tool/APMidasTools:getErrorCodeFromException	(Ljava/io/IOException;)I
    //   679: iconst_m1
    //   680: aload 5
    //   682: ldc_w 327
    //   685: invokespecial 300	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   688: aload_0
    //   689: aload_3
    //   690: aload 6
    //   692: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   695: aload_0
    //   696: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   699: getfield 251	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   702: ldc 253
    //   704: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   707: ifeq -501 -> 206
    //   710: ldc 255
    //   712: ldc_w 257
    //   715: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: ldc_w 262
    //   721: invokestatic 268	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   724: astore_3
    //   725: aload_3
    //   726: aconst_null
    //   727: aconst_null
    //   728: new 270	java/security/SecureRandom
    //   731: dup
    //   732: invokespecial 271	java/security/SecureRandom:<init>	()V
    //   735: invokevirtual 275	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   738: aload_3
    //   739: invokevirtual 279	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   742: invokestatic 285	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   745: return
    //   746: astore_3
    //   747: ldc 255
    //   749: new 114	java/lang/StringBuilder
    //   752: dup
    //   753: ldc_w 287
    //   756: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   759: aload_3
    //   760: invokevirtual 72	java/lang/Exception:toString	()Ljava/lang/String;
    //   763: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   772: return
    //   773: astore 5
    //   775: aconst_null
    //   776: astore_3
    //   777: aload_3
    //   778: astore 4
    //   780: aload_0
    //   781: aload_3
    //   782: aload 6
    //   784: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   787: aload_3
    //   788: astore 4
    //   790: aload_0
    //   791: bipush 250
    //   793: iconst_m1
    //   794: aload 5
    //   796: ldc_w 329
    //   799: invokespecial 300	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   802: aload_0
    //   803: aload_3
    //   804: aload 6
    //   806: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   809: aload_0
    //   810: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   813: getfield 251	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   816: ldc 253
    //   818: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   821: ifeq -615 -> 206
    //   824: ldc 255
    //   826: ldc_w 257
    //   829: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   832: ldc_w 262
    //   835: invokestatic 268	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   838: astore_3
    //   839: aload_3
    //   840: aconst_null
    //   841: aconst_null
    //   842: new 270	java/security/SecureRandom
    //   845: dup
    //   846: invokespecial 271	java/security/SecureRandom:<init>	()V
    //   849: invokevirtual 275	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   852: aload_3
    //   853: invokevirtual 279	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   856: invokestatic 285	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   859: return
    //   860: astore_3
    //   861: ldc 255
    //   863: new 114	java/lang/StringBuilder
    //   866: dup
    //   867: ldc_w 287
    //   870: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   873: aload_3
    //   874: invokevirtual 72	java/lang/Exception:toString	()Ljava/lang/String;
    //   877: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: return
    //   887: astore_3
    //   888: aconst_null
    //   889: astore 4
    //   891: aload_0
    //   892: aload 4
    //   894: aload 6
    //   896: invokespecial 248	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   899: aload_0
    //   900: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   903: getfield 251	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   906: ldc 253
    //   908: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   911: ifeq +41 -> 952
    //   914: ldc 255
    //   916: ldc_w 257
    //   919: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   922: ldc_w 262
    //   925: invokestatic 268	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   928: astore 4
    //   930: aload 4
    //   932: aconst_null
    //   933: aconst_null
    //   934: new 270	java/security/SecureRandom
    //   937: dup
    //   938: invokespecial 271	java/security/SecureRandom:<init>	()V
    //   941: invokevirtual 275	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   944: aload 4
    //   946: invokevirtual 279	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   949: invokestatic 285	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   952: aload_3
    //   953: athrow
    //   954: astore 4
    //   956: ldc 255
    //   958: new 114	java/lang/StringBuilder
    //   961: dup
    //   962: ldc_w 287
    //   965: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   968: aload 4
    //   970: invokevirtual 72	java/lang/Exception:toString	()Ljava/lang/String;
    //   973: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: invokestatic 260	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   982: goto -30 -> 952
    //   985: astore_3
    //   986: goto -95 -> 891
    //   989: astore 5
    //   991: aload_3
    //   992: astore 4
    //   994: aload 5
    //   996: astore_3
    //   997: goto -106 -> 891
    //   1000: astore 5
    //   1002: goto -225 -> 777
    //   1005: astore 5
    //   1007: goto -337 -> 670
    //   1010: astore 5
    //   1012: aconst_null
    //   1013: astore_3
    //   1014: goto -458 -> 556
    //   1017: astore 4
    //   1019: goto -746 -> 273
    //   1022: astore 4
    //   1024: goto -946 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1027	0	this	APBaseHttpReq
    //   1	260	1	i	int
    //   125	135	2	j	int
    //   3	197	3	localObject1	Object
    //   207	87	3	localException1	Exception
    //   328	15	3	localSSLContext1	javax.net.ssl.SSLContext
    //   350	65	3	localException2	Exception
    //   449	15	3	localSSLContext2	javax.net.ssl.SSLContext
    //   471	112	3	localException3	Exception
    //   617	15	3	localSSLContext3	javax.net.ssl.SSLContext
    //   639	14	3	localException4	Exception
    //   669	70	3	localObject2	Object
    //   746	14	3	localException5	Exception
    //   776	77	3	localObject3	Object
    //   860	14	3	localException6	Exception
    //   887	66	3	localObject4	Object
    //   985	7	3	localObject5	Object
    //   996	18	3	localObject6	Object
    //   56	196	4	localObject7	Object
    //   271	14	4	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   378	567	4	localObject8	Object
    //   954	15	4	localException7	Exception
    //   992	1	4	localObject9	Object
    //   1017	1	4	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   1022	1	4	localThrowable	Throwable
    //   114	433	5	localObject10	Object
    //   554	20	5	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   666	15	5	localIOException1	java.io.IOException
    //   773	22	5	localException8	Exception
    //   989	6	5	localObject11	Object
    //   1000	1	5	localException9	Exception
    //   1005	1	5	localIOException2	java.io.IOException
    //   1010	1	5	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   11	884	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   179	206	207	java/lang/Exception
    //   93	106	271	org/apache/http/conn/ConnectTimeoutException
    //   109	116	271	org/apache/http/conn/ConnectTimeoutException
    //   119	126	271	org/apache/http/conn/ConnectTimeoutException
    //   133	140	271	org/apache/http/conn/ConnectTimeoutException
    //   143	149	271	org/apache/http/conn/ConnectTimeoutException
    //   237	246	271	org/apache/http/conn/ConnectTimeoutException
    //   253	268	271	org/apache/http/conn/ConnectTimeoutException
    //   380	389	271	org/apache/http/conn/ConnectTimeoutException
    //   392	402	271	org/apache/http/conn/ConnectTimeoutException
    //   405	413	271	org/apache/http/conn/ConnectTimeoutException
    //   501	532	271	org/apache/http/conn/ConnectTimeoutException
    //   535	551	271	org/apache/http/conn/ConnectTimeoutException
    //   322	349	350	java/lang/Exception
    //   443	470	471	java/lang/Exception
    //   93	106	554	java/net/SocketTimeoutException
    //   109	116	554	java/net/SocketTimeoutException
    //   119	126	554	java/net/SocketTimeoutException
    //   133	140	554	java/net/SocketTimeoutException
    //   143	149	554	java/net/SocketTimeoutException
    //   237	246	554	java/net/SocketTimeoutException
    //   253	268	554	java/net/SocketTimeoutException
    //   380	389	554	java/net/SocketTimeoutException
    //   392	402	554	java/net/SocketTimeoutException
    //   405	413	554	java/net/SocketTimeoutException
    //   501	532	554	java/net/SocketTimeoutException
    //   535	551	554	java/net/SocketTimeoutException
    //   611	638	639	java/lang/Exception
    //   27	78	666	java/io/IOException
    //   78	87	666	java/io/IOException
    //   718	745	746	java/lang/Exception
    //   27	78	773	java/lang/Exception
    //   78	87	773	java/lang/Exception
    //   832	859	860	java/lang/Exception
    //   27	78	887	finally
    //   78	87	887	finally
    //   922	952	954	java/lang/Exception
    //   93	106	985	finally
    //   109	116	985	finally
    //   119	126	985	finally
    //   133	140	985	finally
    //   143	149	985	finally
    //   237	246	985	finally
    //   253	268	985	finally
    //   380	389	985	finally
    //   392	402	985	finally
    //   405	413	985	finally
    //   501	532	985	finally
    //   535	551	985	finally
    //   559	566	985	finally
    //   569	581	985	finally
    //   673	688	985	finally
    //   780	787	985	finally
    //   790	802	985	finally
    //   273	292	989	finally
    //   93	106	1000	java/lang/Exception
    //   109	116	1000	java/lang/Exception
    //   119	126	1000	java/lang/Exception
    //   133	140	1000	java/lang/Exception
    //   143	149	1000	java/lang/Exception
    //   237	246	1000	java/lang/Exception
    //   253	268	1000	java/lang/Exception
    //   380	389	1000	java/lang/Exception
    //   392	402	1000	java/lang/Exception
    //   405	413	1000	java/lang/Exception
    //   501	532	1000	java/lang/Exception
    //   535	551	1000	java/lang/Exception
    //   93	106	1005	java/io/IOException
    //   109	116	1005	java/io/IOException
    //   119	126	1005	java/io/IOException
    //   133	140	1005	java/io/IOException
    //   143	149	1005	java/io/IOException
    //   237	246	1005	java/io/IOException
    //   253	268	1005	java/io/IOException
    //   380	389	1005	java/io/IOException
    //   392	402	1005	java/io/IOException
    //   405	413	1005	java/io/IOException
    //   501	532	1005	java/io/IOException
    //   535	551	1005	java/io/IOException
    //   27	78	1010	java/net/SocketTimeoutException
    //   78	87	1010	java/net/SocketTimeoutException
    //   27	78	1017	org/apache/http/conn/ConnectTimeoutException
    //   78	87	1017	org/apache/http/conn/ConnectTimeoutException
    //   27	78	1022	java/lang/Throwable
  }
  
  private void sendReportData(int paramInt1, int paramInt2)
  {
    if (this.httpParam.urlName.endsWith("log_data")) {}
  }
  
  private void tryAgain(int paramInt1, int paramInt2, Exception paramException, String paramString)
  {
    sendReportData(paramInt1, paramInt2);
    APLog.i("APBaseHttpReq", getClass().getName() + " tryAgain reqTimes = " + this.httpParam.requestTimes + " tryTimes = " + this.httpParam.reTryTimes);
    try
    {
      if (this.httpParam.requestTimes < this.httpParam.reTryTimes)
      {
        this.httpParam.constructReTryUrl();
        requestProgress();
        return;
      }
      return;
    }
    catch (Exception paramException)
    {
      try
      {
        if (this.httpParam.reqType.equals("https://")) {
          while (paramException != null)
          {
            if (((paramException instanceof CertificateExpiredException)) || ((paramException instanceof CertificateNotYetValidException)))
            {
              APLog.e("APBaseHttpReq", "您的设备系统时间不正确，请更改");
              this.httpAns.onError(this, 1100, paramString);
              return;
            }
            paramException = paramException.getCause();
          }
        }
        this.httpAns.onError(this, 1000, paramString);
        APLog.i("APBaseHttpReq", paramString);
        return;
      }
      catch (Exception paramException) {}
      paramException = paramException;
      return;
    }
  }
  
  public void constructParam() {}
  
  public byte[] getContent()
  {
    return this.resultContent;
  }
  
  public IAPHttpAns getHttpAns()
  {
    return this.httpAns;
  }
  
  protected void preCreateConnection() {}
  
  public void requestAgain()
  {
    requestProgress();
  }
  
  public void run()
  {
    requestProgress();
    super.run();
  }
  
  protected void setBody() {}
  
  public void setContent(byte[] paramArrayOfByte)
  {
    this.resultContent = paramArrayOfByte;
  }
  
  protected void setHeader() {}
  
  public void setHttpAns(IAPHttpAns paramIAPHttpAns)
  {
    this.httpAns = paramIAPHttpAns;
  }
  
  protected void setReportUrl(String paramString1, String paramString2, String paramString3)
  {
    this.httpParam.setReportUrl(paramString1, paramString2, paramString3);
  }
  
  protected void setUrl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.httpParam.setUrl(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void startRequest()
  {
    start();
  }
  
  public void stopRequest()
  {
    this.isStop = true;
    this.httpAns.onStop(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.pay.http.APBaseHttpReq
 * JD-Core Version:    0.7.0.1
 */