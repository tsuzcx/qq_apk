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
      finally {}
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
    //   4: new 190	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 191	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore 6
    //   13: aload_0
    //   14: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   17: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   20: putfield 201	com/pay/http/APBaseHttpParam:begTime	J
    //   23: aload_0
    //   24: invokespecial 203	com/pay/http/APBaseHttpReq:initRequest	()V
    //   27: aload_0
    //   28: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   31: getfield 206	com/pay/http/APBaseHttpParam:sendType	Ljava/lang/String;
    //   34: ldc 208
    //   36: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +39 -> 78
    //   42: new 210	java/io/DataOutputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 48	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   50: invokevirtual 58	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   53: invokespecial 213	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore 4
    //   58: aload 4
    //   60: aload_0
    //   61: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   64: getfield 216	com/pay/http/APBaseHttpParam:urlParams	Ljava/lang/String;
    //   67: invokevirtual 220	java/lang/String:getBytes	()[B
    //   70: invokevirtual 224	java/io/DataOutputStream:write	([B)V
    //   73: aload 4
    //   75: invokevirtual 225	java/io/DataOutputStream:flush	()V
    //   78: aload_0
    //   79: getfield 48	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   82: invokevirtual 229	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_3
    //   90: aload_3
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 48	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   97: invokevirtual 233	java/net/HttpURLConnection:getResponseCode	()I
    //   100: sipush 200
    //   103: if_icmpne +392 -> 495
    //   106: aload_3
    //   107: astore 4
    //   109: sipush 1024
    //   112: newarray byte
    //   114: astore 5
    //   116: aload_3
    //   117: astore 4
    //   119: aload_3
    //   120: aload 5
    //   122: invokevirtual 237	java/io/InputStream:read	([B)I
    //   125: istore_2
    //   126: iload_2
    //   127: ifle +248 -> 375
    //   130: aload_3
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 20	com/pay/http/APBaseHttpReq:isStop	Z
    //   137: ifeq +96 -> 233
    //   140: aload_3
    //   141: astore 4
    //   143: invokestatic 241	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   146: invokevirtual 244	java/lang/Thread:interrupt	()V
    //   149: aload_0
    //   150: aload_3
    //   151: aload 6
    //   153: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   156: aload_0
    //   157: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   160: getfield 249	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   163: ldc 251
    //   165: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +37 -> 205
    //   171: ldc 253
    //   173: ldc 255
    //   175: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: ldc_w 260
    //   181: invokestatic 266	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   184: astore_3
    //   185: aload_3
    //   186: aconst_null
    //   187: aconst_null
    //   188: new 268	java/security/SecureRandom
    //   191: dup
    //   192: invokespecial 269	java/security/SecureRandom:<init>	()V
    //   195: invokevirtual 273	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   198: aload_3
    //   199: invokevirtual 277	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   202: invokestatic 283	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   205: return
    //   206: astore_3
    //   207: ldc 253
    //   209: new 112	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 285
    //   216: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload_3
    //   220: invokevirtual 70	java/lang/Exception:toString	()Ljava/lang/String;
    //   223: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: return
    //   233: aload_3
    //   234: astore 4
    //   236: aload 6
    //   238: aload 5
    //   240: iconst_0
    //   241: iload_2
    //   242: invokevirtual 288	java/io/ByteArrayOutputStream:write	([BII)V
    //   245: iload_1
    //   246: iload_2
    //   247: iadd
    //   248: istore_1
    //   249: aload_3
    //   250: astore 4
    //   252: aload_0
    //   253: getfield 122	com/pay/http/APBaseHttpReq:httpAns	Lcom/pay/http/IAPHttpAns;
    //   256: aload 5
    //   258: iload_2
    //   259: iload_1
    //   260: i2l
    //   261: aload_0
    //   262: invokeinterface 292 6 0
    //   267: goto -151 -> 116
    //   270: astore 4
    //   272: aload_0
    //   273: aload_3
    //   274: aload 6
    //   276: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   279: aload_0
    //   280: bipush 249
    //   282: iconst_m1
    //   283: aload 4
    //   285: ldc_w 294
    //   288: invokespecial 298	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   291: aload_0
    //   292: aload_3
    //   293: aload 6
    //   295: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   298: aload_0
    //   299: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   302: getfield 249	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   305: ldc 251
    //   307: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq -105 -> 205
    //   313: ldc 253
    //   315: ldc 255
    //   317: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: ldc_w 260
    //   323: invokestatic 266	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   326: astore_3
    //   327: aload_3
    //   328: aconst_null
    //   329: aconst_null
    //   330: new 268	java/security/SecureRandom
    //   333: dup
    //   334: invokespecial 269	java/security/SecureRandom:<init>	()V
    //   337: invokevirtual 273	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   340: aload_3
    //   341: invokevirtual 277	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   344: invokestatic 283	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   347: return
    //   348: astore_3
    //   349: ldc 253
    //   351: new 112	java/lang/StringBuilder
    //   354: dup
    //   355: ldc_w 285
    //   358: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: aload_3
    //   362: invokevirtual 70	java/lang/Exception:toString	()Ljava/lang/String;
    //   365: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: return
    //   375: aload_3
    //   376: astore 4
    //   378: aload_0
    //   379: aload 6
    //   381: invokevirtual 301	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   384: putfield 303	com/pay/http/APBaseHttpReq:resultContent	[B
    //   387: aload_3
    //   388: astore 4
    //   390: aload_0
    //   391: getfield 122	com/pay/http/APBaseHttpReq:httpAns	Lcom/pay/http/IAPHttpAns;
    //   394: aload_0
    //   395: invokeinterface 306 2 0
    //   400: aload_3
    //   401: astore 4
    //   403: aload_0
    //   404: iconst_0
    //   405: sipush 200
    //   408: invokespecial 310	com/pay/http/APBaseHttpReq:sendReportData	(II)V
    //   411: aload_0
    //   412: aload_3
    //   413: aload 6
    //   415: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   418: aload_0
    //   419: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   422: getfield 249	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   425: ldc 251
    //   427: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   430: ifeq -225 -> 205
    //   433: ldc 253
    //   435: ldc 255
    //   437: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: ldc_w 260
    //   443: invokestatic 266	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   446: astore_3
    //   447: aload_3
    //   448: aconst_null
    //   449: aconst_null
    //   450: new 268	java/security/SecureRandom
    //   453: dup
    //   454: invokespecial 269	java/security/SecureRandom:<init>	()V
    //   457: invokevirtual 273	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   460: aload_3
    //   461: invokevirtual 277	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   464: invokestatic 283	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   467: return
    //   468: astore_3
    //   469: ldc 253
    //   471: new 112	java/lang/StringBuilder
    //   474: dup
    //   475: ldc_w 285
    //   478: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   481: aload_3
    //   482: invokevirtual 70	java/lang/Exception:toString	()Ljava/lang/String;
    //   485: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: return
    //   495: aload_3
    //   496: astore 4
    //   498: new 112	java/lang/StringBuilder
    //   501: dup
    //   502: ldc_w 312
    //   505: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   508: aload_0
    //   509: getfield 48	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   512: invokevirtual 233	java/net/HttpURLConnection:getResponseCode	()I
    //   515: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: ldc_w 317
    //   521: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: astore 5
    //   529: aload_3
    //   530: astore 4
    //   532: aload_0
    //   533: bipush 246
    //   535: aload_0
    //   536: getfield 48	com/pay/http/APBaseHttpReq:httpURLConnection	Ljava/net/HttpURLConnection;
    //   539: invokevirtual 233	java/net/HttpURLConnection:getResponseCode	()I
    //   542: aconst_null
    //   543: aload 5
    //   545: invokespecial 298	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   548: goto -137 -> 411
    //   551: astore 5
    //   553: aload_3
    //   554: astore 4
    //   556: aload_0
    //   557: aload_3
    //   558: aload 6
    //   560: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   563: aload_3
    //   564: astore 4
    //   566: aload_0
    //   567: bipush 248
    //   569: iconst_m1
    //   570: aload 5
    //   572: ldc_w 319
    //   575: invokespecial 298	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   578: aload_0
    //   579: aload_3
    //   580: aload 6
    //   582: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   585: aload_0
    //   586: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   589: getfield 249	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   592: ldc 251
    //   594: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   597: ifeq -392 -> 205
    //   600: ldc 253
    //   602: ldc 255
    //   604: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: ldc_w 260
    //   610: invokestatic 266	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   613: astore_3
    //   614: aload_3
    //   615: aconst_null
    //   616: aconst_null
    //   617: new 268	java/security/SecureRandom
    //   620: dup
    //   621: invokespecial 269	java/security/SecureRandom:<init>	()V
    //   624: invokevirtual 273	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   627: aload_3
    //   628: invokevirtual 277	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   631: invokestatic 283	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   634: return
    //   635: astore_3
    //   636: ldc 253
    //   638: new 112	java/lang/StringBuilder
    //   641: dup
    //   642: ldc_w 285
    //   645: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   648: aload_3
    //   649: invokevirtual 70	java/lang/Exception:toString	()Ljava/lang/String;
    //   652: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   661: return
    //   662: astore 5
    //   664: aconst_null
    //   665: astore_3
    //   666: aload_3
    //   667: astore 4
    //   669: aload_0
    //   670: aload 5
    //   672: invokestatic 323	com/pay/tool/APMidasTools:getErrorCodeFromException	(Ljava/io/IOException;)I
    //   675: iconst_m1
    //   676: aload 5
    //   678: ldc_w 325
    //   681: invokespecial 298	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   684: aload_0
    //   685: aload_3
    //   686: aload 6
    //   688: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   691: aload_0
    //   692: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   695: getfield 249	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   698: ldc 251
    //   700: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   703: ifeq -498 -> 205
    //   706: ldc 253
    //   708: ldc 255
    //   710: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: ldc_w 260
    //   716: invokestatic 266	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   719: astore_3
    //   720: aload_3
    //   721: aconst_null
    //   722: aconst_null
    //   723: new 268	java/security/SecureRandom
    //   726: dup
    //   727: invokespecial 269	java/security/SecureRandom:<init>	()V
    //   730: invokevirtual 273	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   733: aload_3
    //   734: invokevirtual 277	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   737: invokestatic 283	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   740: return
    //   741: astore_3
    //   742: ldc 253
    //   744: new 112	java/lang/StringBuilder
    //   747: dup
    //   748: ldc_w 285
    //   751: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   754: aload_3
    //   755: invokevirtual 70	java/lang/Exception:toString	()Ljava/lang/String;
    //   758: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: return
    //   768: astore 5
    //   770: aconst_null
    //   771: astore_3
    //   772: aload_3
    //   773: astore 4
    //   775: aload_0
    //   776: aload_3
    //   777: aload 6
    //   779: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   782: aload_3
    //   783: astore 4
    //   785: aload_0
    //   786: bipush 250
    //   788: iconst_m1
    //   789: aload 5
    //   791: ldc_w 327
    //   794: invokespecial 298	com/pay/http/APBaseHttpReq:tryAgain	(IILjava/lang/Exception;Ljava/lang/String;)V
    //   797: aload_0
    //   798: aload_3
    //   799: aload 6
    //   801: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   804: aload_0
    //   805: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   808: getfield 249	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   811: ldc 251
    //   813: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   816: ifeq -611 -> 205
    //   819: ldc 253
    //   821: ldc 255
    //   823: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   826: ldc_w 260
    //   829: invokestatic 266	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   832: astore_3
    //   833: aload_3
    //   834: aconst_null
    //   835: aconst_null
    //   836: new 268	java/security/SecureRandom
    //   839: dup
    //   840: invokespecial 269	java/security/SecureRandom:<init>	()V
    //   843: invokevirtual 273	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   846: aload_3
    //   847: invokevirtual 277	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   850: invokestatic 283	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   853: return
    //   854: astore_3
    //   855: ldc 253
    //   857: new 112	java/lang/StringBuilder
    //   860: dup
    //   861: ldc_w 285
    //   864: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   867: aload_3
    //   868: invokevirtual 70	java/lang/Exception:toString	()Ljava/lang/String;
    //   871: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   880: return
    //   881: astore_3
    //   882: aconst_null
    //   883: astore 4
    //   885: aload_0
    //   886: aload 4
    //   888: aload 6
    //   890: invokespecial 246	com/pay/http/APBaseHttpReq:closeStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   893: aload_0
    //   894: getfield 25	com/pay/http/APBaseHttpReq:httpParam	Lcom/pay/http/APBaseHttpParam;
    //   897: getfield 249	com/pay/http/APBaseHttpParam:reqType	Ljava/lang/String;
    //   900: ldc 251
    //   902: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   905: ifeq +40 -> 945
    //   908: ldc 253
    //   910: ldc 255
    //   912: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   915: ldc_w 260
    //   918: invokestatic 266	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   921: astore 4
    //   923: aload 4
    //   925: aconst_null
    //   926: aconst_null
    //   927: new 268	java/security/SecureRandom
    //   930: dup
    //   931: invokespecial 269	java/security/SecureRandom:<init>	()V
    //   934: invokevirtual 273	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   937: aload 4
    //   939: invokevirtual 277	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   942: invokestatic 283	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   945: aload_3
    //   946: athrow
    //   947: astore 4
    //   949: ldc 253
    //   951: new 112	java/lang/StringBuilder
    //   954: dup
    //   955: ldc_w 285
    //   958: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   961: aload 4
    //   963: invokevirtual 70	java/lang/Exception:toString	()Ljava/lang/String;
    //   966: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokestatic 258	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   975: goto -30 -> 945
    //   978: astore_3
    //   979: goto -94 -> 885
    //   982: astore 5
    //   984: aload_3
    //   985: astore 4
    //   987: aload 5
    //   989: astore_3
    //   990: goto -105 -> 885
    //   993: astore 5
    //   995: goto -223 -> 772
    //   998: astore 5
    //   1000: goto -334 -> 666
    //   1003: astore 5
    //   1005: aconst_null
    //   1006: astore_3
    //   1007: goto -454 -> 553
    //   1010: astore 4
    //   1012: goto -740 -> 272
    //   1015: astore 4
    //   1017: goto -939 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1020	0	this	APBaseHttpReq
    //   1	259	1	i	int
    //   125	134	2	j	int
    //   3	196	3	localObject1	Object
    //   206	87	3	localException1	Exception
    //   326	15	3	localSSLContext1	javax.net.ssl.SSLContext
    //   348	65	3	localException2	Exception
    //   446	15	3	localSSLContext2	javax.net.ssl.SSLContext
    //   468	112	3	localException3	Exception
    //   613	15	3	localSSLContext3	javax.net.ssl.SSLContext
    //   635	14	3	localException4	Exception
    //   665	69	3	localObject2	Object
    //   741	14	3	localException5	Exception
    //   771	76	3	localObject3	Object
    //   854	14	3	localException6	Exception
    //   881	65	3	localObject4	Object
    //   978	7	3	localObject5	Object
    //   989	18	3	localObject6	Object
    //   56	195	4	localObject7	Object
    //   270	14	4	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   376	562	4	localObject8	Object
    //   947	15	4	localException7	Exception
    //   985	1	4	localObject9	Object
    //   1010	1	4	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   1015	1	4	localObject10	Object
    //   114	430	5	localObject11	Object
    //   551	20	5	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   662	15	5	localIOException1	java.io.IOException
    //   768	22	5	localException8	Exception
    //   982	6	5	localObject12	Object
    //   993	1	5	localException9	Exception
    //   998	1	5	localIOException2	java.io.IOException
    //   1003	1	5	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   11	878	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   178	205	206	java/lang/Exception
    //   93	106	270	org/apache/http/conn/ConnectTimeoutException
    //   109	116	270	org/apache/http/conn/ConnectTimeoutException
    //   119	126	270	org/apache/http/conn/ConnectTimeoutException
    //   133	140	270	org/apache/http/conn/ConnectTimeoutException
    //   143	149	270	org/apache/http/conn/ConnectTimeoutException
    //   236	245	270	org/apache/http/conn/ConnectTimeoutException
    //   252	267	270	org/apache/http/conn/ConnectTimeoutException
    //   378	387	270	org/apache/http/conn/ConnectTimeoutException
    //   390	400	270	org/apache/http/conn/ConnectTimeoutException
    //   403	411	270	org/apache/http/conn/ConnectTimeoutException
    //   498	529	270	org/apache/http/conn/ConnectTimeoutException
    //   532	548	270	org/apache/http/conn/ConnectTimeoutException
    //   320	347	348	java/lang/Exception
    //   440	467	468	java/lang/Exception
    //   93	106	551	java/net/SocketTimeoutException
    //   109	116	551	java/net/SocketTimeoutException
    //   119	126	551	java/net/SocketTimeoutException
    //   133	140	551	java/net/SocketTimeoutException
    //   143	149	551	java/net/SocketTimeoutException
    //   236	245	551	java/net/SocketTimeoutException
    //   252	267	551	java/net/SocketTimeoutException
    //   378	387	551	java/net/SocketTimeoutException
    //   390	400	551	java/net/SocketTimeoutException
    //   403	411	551	java/net/SocketTimeoutException
    //   498	529	551	java/net/SocketTimeoutException
    //   532	548	551	java/net/SocketTimeoutException
    //   607	634	635	java/lang/Exception
    //   78	87	662	java/io/IOException
    //   713	740	741	java/lang/Exception
    //   78	87	768	java/lang/Exception
    //   826	853	854	java/lang/Exception
    //   78	87	881	finally
    //   915	945	947	java/lang/Exception
    //   93	106	978	finally
    //   109	116	978	finally
    //   119	126	978	finally
    //   133	140	978	finally
    //   143	149	978	finally
    //   236	245	978	finally
    //   252	267	978	finally
    //   378	387	978	finally
    //   390	400	978	finally
    //   403	411	978	finally
    //   498	529	978	finally
    //   532	548	978	finally
    //   556	563	978	finally
    //   566	578	978	finally
    //   669	684	978	finally
    //   775	782	978	finally
    //   785	797	978	finally
    //   272	291	982	finally
    //   93	106	993	java/lang/Exception
    //   109	116	993	java/lang/Exception
    //   119	126	993	java/lang/Exception
    //   133	140	993	java/lang/Exception
    //   143	149	993	java/lang/Exception
    //   236	245	993	java/lang/Exception
    //   252	267	993	java/lang/Exception
    //   378	387	993	java/lang/Exception
    //   390	400	993	java/lang/Exception
    //   403	411	993	java/lang/Exception
    //   498	529	993	java/lang/Exception
    //   532	548	993	java/lang/Exception
    //   93	106	998	java/io/IOException
    //   109	116	998	java/io/IOException
    //   119	126	998	java/io/IOException
    //   133	140	998	java/io/IOException
    //   143	149	998	java/io/IOException
    //   236	245	998	java/io/IOException
    //   252	267	998	java/io/IOException
    //   378	387	998	java/io/IOException
    //   390	400	998	java/io/IOException
    //   403	411	998	java/io/IOException
    //   498	529	998	java/io/IOException
    //   532	548	998	java/io/IOException
    //   78	87	1003	java/net/SocketTimeoutException
    //   78	87	1010	org/apache/http/conn/ConnectTimeoutException
    //   27	78	1015	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.http.APBaseHttpReq
 * JD-Core Version:    0.7.0.1
 */