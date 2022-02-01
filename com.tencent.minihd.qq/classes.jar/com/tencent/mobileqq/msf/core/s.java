package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.a.a.a;
import com.tencent.mobileqq.msf.core.c.i;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.net.f.b;
import com.tencent.mobileqq.msf.core.net.g;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.o;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class s
{
  public static long F = 0L;
  static int G = -1;
  static AtomicBoolean H = new AtomicBoolean();
  public static final String J = "GrayUinPro.Check";
  public static final String K = "res";
  public static final int N = -10008;
  public static final int O = -302;
  public static final int P = 302;
  static CopyOnWriteArraySet Q = new CopyOnWriteArraySet();
  private static final AtomicInteger aa = new AtomicInteger();
  private static int ad = 0;
  private static String ae;
  private static String[] af;
  private static AtomicBoolean an = new AtomicBoolean();
  public static final String b = "__extraTimeoutSeq";
  public static final String m = "MSF.C.NetConnTag";
  public static ConcurrentHashMap n = new ConcurrentHashMap();
  public static AtomicInteger o = new AtomicInteger(0);
  public static String r = ":";
  public static String s = "0";
  public static int t = 0;
  public static long u;
  public static int x;
  public com.tencent.mobileqq.msf.core.net.a.c A;
  AtomicBoolean B = new AtomicBoolean();
  int C = 0;
  long D = 0L;
  long E = 0L;
  HashSet I = new HashSet();
  public int L = -1;
  public AtomicBoolean M = new AtomicBoolean();
  ArrayList R = new ArrayList();
  boolean S = false;
  private ConcurrentHashMap T = new ConcurrentHashMap();
  private ConcurrentHashMap U = new ConcurrentHashMap();
  private ConcurrentHashMap V = new ConcurrentHashMap();
  private com.tencent.mobileqq.msf.sdk.k W = new com.tencent.mobileqq.msf.sdk.k(1000);
  private com.tencent.mobileqq.msf.sdk.k X = new com.tencent.mobileqq.msf.sdk.k();
  private ToServiceMsg Y;
  private Handler Z;
  public h a;
  private int ab = 0;
  private String ac = "0";
  private HashSet ag = new HashSet();
  private volatile boolean ah = false;
  private Object ai = new Object();
  private long aj = 0L;
  private byte[] ak = null;
  private long al = 0L;
  private Random am = new Random(System.currentTimeMillis());
  b c = new b();
  public int d = 10;
  public int e = 3072;
  public int f = 0;
  public int g = 500;
  public int h = 0;
  public int i = 300;
  public long j = 0L;
  public boolean k = false;
  public volatile boolean l = false;
  public a p = new a();
  MsfCore q;
  c v = new c();
  long w;
  public AtomicLong y = new AtomicLong(0L);
  public AtomicLong z = new AtomicLong(0L);
  
  static
  {
    ad = 0;
    ae = "";
    af = new String[] { "StreamSvr.UploadStreamMsg" };
    u = -1L;
    x = 0;
  }
  
  public s(MsfCore paramMsfCore)
  {
    this.q = paramMsfCore;
    Object localObject = new HandlerThread("mergehandle", 5);
    ((HandlerThread)localObject).start();
    this.Z = new Handler(((HandlerThread)localObject).getLooper());
    this.ab = paramMsfCore.getMsfAppid();
    this.a = new h(paramMsfCore);
    this.v.setName("MsfCoreMsgSender");
    try
    {
      localObject = com.tencent.mobileqq.msf.core.a.a.c();
      if (localObject != null)
      {
        this.d = Integer.parseInt(localObject[0]);
        this.e = Integer.parseInt(localObject[1]);
        this.i = Integer.parseInt(localObject[2]);
        this.g = Integer.parseInt(localObject[3]);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "maxDelaySize: " + this.e + " noMergeSize: " + this.i + " globaldelayTime: " + this.g + " delayWaitSendCount: " + this.d);
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          a(com.tencent.mobileqq.msf.core.a.a.d());
          try
          {
            this.h = Integer.parseInt(com.tencent.mobileqq.msf.core.a.a.e());
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "mergeDuration: " + this.h);
            }
            this.A = new com.tencent.mobileqq.msf.core.net.a.c(paramMsfCore);
            return;
          }
          catch (Exception paramMsfCore)
          {
            QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
          }
          localException1 = localException1;
          QLog.d("MSF.C.NetConnTag", 1, " " + localException1, localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, " " + localException2, localException2);
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Q.add(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use simple head for uin:" + MsfSdkUtils.getShortUin(paramString));
    }
    for (;;)
    {
      CodecWarpper.setUseSimpleHead(paramString, paramBoolean);
      return;
      Q.remove(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use full head for uin:" + MsfSdkUtils.getShortUin(paramString));
      if (n.containsKey(paramString))
      {
        n.remove(paramString);
        QLog.d("MSF.C.NetConnTag", 1, "clear storeSendSsoSeq tag for uin:" + MsfSdkUtils.getShortUin(paramString));
      }
    }
  }
  
  /* Error */
  private void b(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 431	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   3: ifnull +58 -> 61
    //   6: getstatic 431	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   9: arraylength
    //   10: ifle +51 -> 61
    //   13: aload_0
    //   14: getfield 317	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   17: getstatic 431	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   20: invokevirtual 432	com/tencent/mobileqq/msf/core/net/h:a	([Ljava/lang/String;)V
    //   23: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +34 -> 60
    //   29: ldc 48
    //   31: iconst_2
    //   32: new 342	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 434
    //   42: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 431	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   48: invokestatic 439	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: return
    //   61: getstatic 442	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   64: ifnull +58 -> 122
    //   67: getstatic 442	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   70: arraylength
    //   71: ifle +51 -> 122
    //   74: aload_0
    //   75: getfield 317	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   78: getstatic 442	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   81: invokevirtual 444	com/tencent/mobileqq/msf/core/net/h:b	([Ljava/lang/String;)V
    //   84: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -27 -> 60
    //   90: ldc 48
    //   92: iconst_2
    //   93: new 342	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 434
    //   103: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: getstatic 431	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   109: invokestatic 439	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   112: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: return
    //   122: aload_1
    //   123: invokevirtual 449	android/content/Context:getPackageName	()Ljava/lang/String;
    //   126: astore_1
    //   127: new 451	java/io/File
    //   130: dup
    //   131: new 342	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 457	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: invokevirtual 460	java/io/File:getPath	()Ljava/lang/String;
    //   144: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 462
    //   150: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: ldc_w 464
    //   157: ldc_w 466
    //   160: invokevirtual 470	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   163: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 472
    //   169: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 474	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore_1
    //   179: new 476	java/util/Properties
    //   182: dup
    //   183: invokespecial 477	java/util/Properties:<init>	()V
    //   186: astore_3
    //   187: new 479	java/io/FileInputStream
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 482	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   195: astore_2
    //   196: aload_2
    //   197: astore_1
    //   198: aload_3
    //   199: aload_2
    //   200: invokevirtual 486	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   203: aload_2
    //   204: astore_1
    //   205: aload_3
    //   206: ldc_w 488
    //   209: invokevirtual 491	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 4
    //   214: aload_2
    //   215: astore_1
    //   216: aload_3
    //   217: ldc_w 493
    //   220: invokevirtual 491	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_3
    //   224: aload_2
    //   225: astore_1
    //   226: aload 4
    //   228: ldc_w 495
    //   231: invokevirtual 499	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   234: putstatic 431	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   237: aload_2
    //   238: astore_1
    //   239: aload_3
    //   240: ldc_w 495
    //   243: invokevirtual 499	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   246: putstatic 442	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   249: aload_2
    //   250: astore_1
    //   251: aload_0
    //   252: getfield 317	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   255: getstatic 431	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   258: invokevirtual 432	com/tencent/mobileqq/msf/core/net/h:a	([Ljava/lang/String;)V
    //   261: aload_2
    //   262: astore_1
    //   263: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +36 -> 302
    //   269: aload_2
    //   270: astore_1
    //   271: ldc 48
    //   273: iconst_2
    //   274: new 342	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 501
    //   284: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 431	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   290: invokestatic 439	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   293: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_2
    //   303: astore_1
    //   304: aload_0
    //   305: getfield 317	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   308: getstatic 442	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   311: invokevirtual 444	com/tencent/mobileqq/msf/core/net/h:b	([Ljava/lang/String;)V
    //   314: aload_2
    //   315: astore_1
    //   316: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +36 -> 355
    //   322: aload_2
    //   323: astore_1
    //   324: ldc 48
    //   326: iconst_2
    //   327: new 342	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   334: ldc_w 501
    //   337: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: getstatic 442	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   343: invokestatic 439	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   346: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_2
    //   356: ifnull -296 -> 60
    //   359: aload_2
    //   360: invokevirtual 504	java/io/FileInputStream:close	()V
    //   363: return
    //   364: astore_1
    //   365: aload_1
    //   366: invokevirtual 507	java/lang/Exception:printStackTrace	()V
    //   369: return
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_2
    //   373: aload_2
    //   374: astore_1
    //   375: aload_3
    //   376: invokevirtual 507	java/lang/Exception:printStackTrace	()V
    //   379: aload_2
    //   380: ifnull -320 -> 60
    //   383: aload_2
    //   384: invokevirtual 504	java/io/FileInputStream:close	()V
    //   387: return
    //   388: astore_1
    //   389: goto -24 -> 365
    //   392: astore_2
    //   393: aconst_null
    //   394: astore_1
    //   395: aload_1
    //   396: ifnull +7 -> 403
    //   399: aload_1
    //   400: invokevirtual 504	java/io/FileInputStream:close	()V
    //   403: aload_2
    //   404: athrow
    //   405: astore_1
    //   406: aload_1
    //   407: invokevirtual 507	java/lang/Exception:printStackTrace	()V
    //   410: goto -7 -> 403
    //   413: astore_2
    //   414: goto -19 -> 395
    //   417: astore_3
    //   418: goto -45 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	s
    //   0	421	1	paramContext	android.content.Context
    //   195	189	2	localFileInputStream	java.io.FileInputStream
    //   392	12	2	localObject1	Object
    //   413	1	2	localObject2	Object
    //   186	54	3	localObject3	Object
    //   370	6	3	localException1	Exception
    //   417	1	3	localException2	Exception
    //   212	15	4	str	String
    // Exception table:
    //   from	to	target	type
    //   359	363	364	java/lang/Exception
    //   187	196	370	java/lang/Exception
    //   383	387	388	java/lang/Exception
    //   187	196	392	finally
    //   399	403	405	java/lang/Exception
    //   198	203	413	finally
    //   205	214	413	finally
    //   216	224	413	finally
    //   226	237	413	finally
    //   239	249	413	finally
    //   251	261	413	finally
    //   263	269	413	finally
    //   271	302	413	finally
    //   304	314	413	finally
    //   316	322	413	finally
    //   324	355	413	finally
    //   375	379	413	finally
    //   198	203	417	java/lang/Exception
    //   205	214	417	java/lang/Exception
    //   216	224	417	java/lang/Exception
    //   226	237	417	java/lang/Exception
    //   239	249	417	java/lang/Exception
    //   251	261	417	java/lang/Exception
    //   263	269	417	java/lang/Exception
    //   271	302	417	java/lang/Exception
    //   304	314	417	java/lang/Exception
    //   316	322	417	java/lang/Exception
    //   324	355	417	java/lang/Exception
  }
  
  public static boolean b(String paramString)
  {
    return Q.contains(paramString);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 + 4);
    localByteBuffer.putInt(i1 + 4).put(paramArrayOfByte).flip();
    return localByteBuffer.array();
  }
  
  /* Error */
  private void c(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 543	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   3: ifnull +81 -> 84
    //   6: getstatic 543	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   9: ldc 144
    //   11: invokevirtual 546	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifne +70 -> 84
    //   17: getstatic 543	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   20: invokestatic 551	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 553	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   28: ifnull +10 -> 38
    //   31: aload_1
    //   32: invokevirtual 555	com/tencent/mobileqq/msf/core/d:d	()I
    //   35: ifgt +4 -> 39
    //   38: return
    //   39: aload_0
    //   40: getfield 317	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   43: getstatic 543	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   46: invokevirtual 557	com/tencent/mobileqq/msf/core/net/h:a	(Ljava/lang/String;)V
    //   49: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -14 -> 38
    //   55: ldc 48
    //   57: iconst_2
    //   58: new 342	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 559
    //   68: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: getstatic 543	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   74: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 449	android/content/Context:getPackageName	()Ljava/lang/String;
    //   88: astore_1
    //   89: new 451	java/io/File
    //   92: dup
    //   93: new 342	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   100: invokestatic 457	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   103: invokevirtual 460	java/io/File:getPath	()Ljava/lang/String;
    //   106: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 462
    //   112: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: ldc_w 464
    //   119: ldc_w 466
    //   122: invokevirtual 470	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   125: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 561
    //   131: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 474	java/io/File:<init>	(Ljava/lang/String;)V
    //   140: astore_1
    //   141: new 476	java/util/Properties
    //   144: dup
    //   145: invokespecial 477	java/util/Properties:<init>	()V
    //   148: astore 4
    //   150: aload_1
    //   151: invokevirtual 564	java/io/File:exists	()Z
    //   154: ifeq +248 -> 402
    //   157: new 479	java/io/FileInputStream
    //   160: dup
    //   161: aload_1
    //   162: invokespecial 482	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   165: astore_2
    //   166: aload_2
    //   167: astore_1
    //   168: aload 4
    //   170: aload_2
    //   171: invokevirtual 486	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   174: aload_2
    //   175: astore_1
    //   176: aload_2
    //   177: invokevirtual 504	java/io/FileInputStream:close	()V
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 504	java/io/FileInputStream:close	()V
    //   188: iconst_0
    //   189: ifeq +11 -> 200
    //   192: new 566	java/lang/NullPointerException
    //   195: dup
    //   196: invokespecial 567	java/lang/NullPointerException:<init>	()V
    //   199: athrow
    //   200: aload 4
    //   202: ldc_w 569
    //   205: invokevirtual 491	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_2
    //   209: aload_2
    //   210: ifnull -172 -> 38
    //   213: aload_2
    //   214: invokevirtual 572	java/lang/String:trim	()Ljava/lang/String;
    //   217: invokevirtual 575	java/lang/String:length	()I
    //   220: ifle -182 -> 38
    //   223: aload_2
    //   224: invokestatic 551	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 553	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   232: ifnull -194 -> 38
    //   235: aload_1
    //   236: invokevirtual 555	com/tencent/mobileqq/msf/core/d:d	()I
    //   239: ifle -201 -> 38
    //   242: aload_2
    //   243: invokevirtual 572	java/lang/String:trim	()Ljava/lang/String;
    //   246: ldc_w 381
    //   249: ldc 144
    //   251: invokevirtual 470	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 317	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   259: aload_1
    //   260: invokevirtual 557	com/tencent/mobileqq/msf/core/net/h:a	(Ljava/lang/String;)V
    //   263: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq -228 -> 38
    //   269: ldc 48
    //   271: iconst_2
    //   272: new 342	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 577
    //   282: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: return
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_2
    //   299: aload_2
    //   300: astore_1
    //   301: aload_3
    //   302: invokevirtual 507	java/lang/Exception:printStackTrace	()V
    //   305: aload_2
    //   306: ifnull +7 -> 313
    //   309: aload_2
    //   310: invokevirtual 504	java/io/FileInputStream:close	()V
    //   313: iconst_0
    //   314: ifeq -114 -> 200
    //   317: new 566	java/lang/NullPointerException
    //   320: dup
    //   321: invokespecial 567	java/lang/NullPointerException:<init>	()V
    //   324: athrow
    //   325: astore_1
    //   326: aload_1
    //   327: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   330: goto -130 -> 200
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 504	java/io/FileInputStream:close	()V
    //   344: iconst_0
    //   345: ifeq +11 -> 356
    //   348: new 566	java/lang/NullPointerException
    //   351: dup
    //   352: invokespecial 567	java/lang/NullPointerException:<init>	()V
    //   355: athrow
    //   356: aload_2
    //   357: athrow
    //   358: astore_1
    //   359: aload_1
    //   360: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   363: goto -19 -> 344
    //   366: astore_1
    //   367: aload_1
    //   368: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   371: goto -15 -> 356
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   379: goto -66 -> 313
    //   382: astore_1
    //   383: aload_1
    //   384: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   387: goto -199 -> 188
    //   390: astore_1
    //   391: goto -65 -> 326
    //   394: astore_2
    //   395: goto -59 -> 336
    //   398: astore_3
    //   399: goto -100 -> 299
    //   402: aconst_null
    //   403: astore_2
    //   404: goto -224 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	s
    //   0	407	1	paramContext	android.content.Context
    //   165	145	2	localObject1	Object
    //   333	24	2	localObject2	Object
    //   394	1	2	localObject3	Object
    //   403	1	2	localObject4	Object
    //   296	6	3	localException1	Exception
    //   398	1	3	localException2	Exception
    //   148	53	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   150	166	296	java/lang/Exception
    //   317	325	325	java/io/IOException
    //   150	166	333	finally
    //   340	344	358	java/io/IOException
    //   348	356	366	java/io/IOException
    //   309	313	374	java/io/IOException
    //   184	188	382	java/io/IOException
    //   192	200	390	java/io/IOException
    //   168	174	394	finally
    //   176	180	394	finally
    //   301	305	394	finally
    //   168	174	398	java/lang/Exception
    //   176	180	398	java/lang/Exception
  }
  
  public static void c(String paramString)
  {
    ae = paramString;
  }
  
  public static void d(int paramInt)
  {
    ad = paramInt;
  }
  
  private void d(String paramString)
  {
    o.b(Integer.parseInt(paramString));
  }
  
  private int f(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1;
    if (paramToServiceMsg.isNeedCallback())
    {
      this.T.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(aa.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject1 = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
        if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
          QLog.d("MSF.C.NetConnTag", 1, "Sender PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + paramToServiceMsg.getTimeout());
        }
        paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject1);
        if ((com.tencent.mobileqq.msf.core.a.a.N()) && (this.q.quicksender != null) && (this.q.quicksender.b(paramToServiceMsg)))
        {
          QLog.d("MSF.C.NetConnTag", 1, "add quick send timeout check " + paramToServiceMsg.getRequestSsoSeq());
          this.q.quicksender.c(paramToServiceMsg);
        }
      }
    }
    for (;;)
    {
      try
      {
        this.q.quicksender.d.a(paramToServiceMsg);
        if (this.W.offer(paramToServiceMsg)) {
          break label515;
        }
        QLog.d("MSF.C.NetConnTag", 1, "error, add " + paramToServiceMsg + " to send queue is full! size: " + this.W.size());
        if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge")) {
          break label430;
        }
        localObject1 = l.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setBusinessFail(1008, "send queue is full!");
        this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
        if ((!H.get()) && (f.b))
        {
          H.set(true);
          G = paramToServiceMsg.getRequestSsoSeq();
        }
        return paramToServiceMsg.getRequestSsoSeq();
        localObject1 = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
      }
      if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge"))
      {
        this.q.msfAlarmer.a(paramToServiceMsg.getRequestSsoSeq(), 30000L);
        continue;
        label430:
        Object localObject2 = (ArrayList)this.V.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject2).next();
            FromServiceMsg localFromServiceMsg = l.a(localToServiceMsg);
            localFromServiceMsg.setBusinessFail(1008, "send queue is full!");
            this.q.addRespToQuque(localToServiceMsg, localFromServiceMsg);
          }
          continue;
          label515:
          if (this.V.contains(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
            this.V.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "add " + paramToServiceMsg + " to sendQueue");
          }
          long l1 = SystemClock.elapsedRealtime();
          if (l1 - this.aj >= 300000L)
          {
            this.aj = l1;
            s();
          }
          if (this.A != null) {
            this.A.a(paramToServiceMsg);
          }
        }
      }
    }
  }
  
  public static void g()
  {
    Iterator localIterator = Q.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.setUseSimpleHead((String)localIterator.next(), false);
    }
    Q.clear();
  }
  
  private void g(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getUin().equals("0")) {}
    int i1;
    do
    {
      return;
      int i2 = 0;
      i1 = i2;
      if (!this.I.contains(paramToServiceMsg.getUin()))
      {
        this.al += 1L;
        if (this.al >= 2L)
        {
          i1 = i2;
          if (this.am.nextInt(20) >= 2) {}
        }
        else
        {
          i1 = 1;
        }
      }
    } while (i1 == 0);
    a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin());
  }
  
  public static int l()
  {
    return ad;
  }
  
  public static String m()
  {
    return ae;
  }
  
  private void p()
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.q.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.r());
      a(localToServiceMsg);
      this.C += 1;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send Heartbeat msg ok");
      }
      this.D = System.currentTimeMillis();
      this.B.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    r();
  }
  
  private void q()
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.q.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(10000L);
      a(localToServiceMsg);
      this.C = com.tencent.mobileqq.msf.core.a.a.x();
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok");
      }
      this.D = System.currentTimeMillis();
      this.B.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    r();
  }
  
  private void r()
  {
    this.C = 0;
    this.B.set(false);
  }
  
  private void s()
  {
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = Thread.currentThread().getThreadGroup();
        if (((ThreadGroup)localObject).getParent() != null)
        {
          localObject = ((ThreadGroup)localObject).getParent();
          continue;
        }
        Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject).activeCount()];
        ((ThreadGroup)localObject).enumerate(arrayOfThread);
        i1 = this.W.size();
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("waitSendSize:").append(i1).append(" currentThreadsSize:").append(arrayOfThread.length).append("\n");
        int i2 = arrayOfThread.length;
        i1 = 0;
        if (i1 < i2)
        {
          Thread localThread = arrayOfThread[i1];
          if (localThread != null) {
            ((StringBuffer)localObject).append("    threadInfo:").append(localThread.getId()).append("|").append(localThread.getName()).append("|").append(localThread.getPriority()).append("|").append(localThread.isAlive()).append("|").append(localThread.isDaemon()).append("|").append(localThread.getState()).append("\n");
          }
        }
        else
        {
          QLog.d("MSF.C.NetConnTag", 1, ((StringBuffer)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "printCurrentThreads error", localException);
        return;
      }
      i1 += 1;
    }
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    }
    paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
    Runnable localRunnable;
    if (paramToServiceMsg.isNeedCallback())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg + " to send");
      }
      this.T.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(aa.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() != -1L) {
        break label165;
      }
      paramToServiceMsg.setTimeout(30000L);
      localRunnable = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    for (;;)
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      try
      {
        this.W.a(paramToServiceMsg);
        return paramToServiceMsg.getRequestSsoSeq();
        label165:
        localRunnable = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, "inset heartbeatMsg error. " + localException, localException);
        }
      }
    }
  }
  
  public Runnable a(int paramInt)
  {
    return this.q.msfAlarmer.b(paramInt, com.tencent.mobileqq.msf.core.a.a.s());
  }
  
  public void a(int paramInt, String paramString)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setRequestId(MsfCore.getNextSeq());
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReq");
    Object localObject = new com.tencent.msf.service.protocol.e.c();
    ((com.tencent.msf.service.protocol.e.c)localObject).a = paramInt;
    ((com.tencent.msf.service.protocol.e.c)localObject).b = paramString;
    localUniPacket.put("req", localObject);
    localObject = new ToServiceMsg("", paramString, "GrayUinPro.Check");
    ((ToServiceMsg)localObject).setAppId(paramInt);
    ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject).putWupBuffer(localUniPacket.encode());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.checkRole);
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "role send gray check for " + paramString + " use " + paramInt + " to:" + localObject);
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.a.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {
      this.I.add(paramFromServiceMsg.getUin());
    }
    label331:
    for (;;)
    {
      try
      {
        Object localObject1 = paramFromServiceMsg.getWupBuffer();
        if ((localObject1.length <= 4) || (localObject1[0] != 0) || (localObject1[1] != 0) || (localObject1[2] != 0) || (localObject1[3] != 4)) {
          break label331;
        }
        Object localObject2 = new byte[localObject1.length - 4];
        System.arraycopy(localObject1, 4, localObject2, 0, localObject2.length);
        localObject1 = localObject2;
        QLog.d("MSF.C.NetConnTag", 1, "recv buf:" + HexUtil.bytes2HexStr((byte[])localObject1));
        localObject2 = new UniPacket();
        ((UniPacket)localObject2).decode((byte[])localObject1);
        localObject1 = (com.tencent.msf.service.protocol.e.d)((UniPacket)localObject2).getByClass("res", new com.tencent.msf.service.protocol.e.d());
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "role received gray resp uin:" + paramFromServiceMsg.getUin() + " appid:" + paramFromServiceMsg.getAppId() + " status:" + ((com.tencent.msf.service.protocol.e.d)localObject1).a + " yyb:" + ((com.tencent.msf.service.protocol.e.d)localObject1).b + " msg:" + HexUtil.bytes2HexStr(((com.tencent.msf.service.protocol.e.d)localObject1).c));
        }
        if (((com.tencent.msf.service.protocol.e.d)localObject1).a == 1)
        {
          this.q.getSsoRespHandler();
          u.a.put(paramFromServiceMsg.getUin(), localObject1);
          this.q.getAccountCenter().m(paramFromServiceMsg.getUin());
          return;
        }
        u.a.remove(paramFromServiceMsg.getUin());
        return;
      }
      catch (ObjectCreateException paramFromServiceMsg)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check error", paramFromServiceMsg);
      return;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check fail " + paramFromServiceMsg);
      return;
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "handleHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (!this.a.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn is also closed.");
        }
        r();
      }
      do
      {
        return;
        if (this.C < com.tencent.mobileqq.msf.core.a.a.x()) {
          break;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "Heartbeat continueTimeoutCount is " + this.C + ",try close conn");
          }
          this.q.sender.a.a(com.tencent.qphone.base.a.p);
          r();
          return;
        }
        catch (Exception paramFromServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString(), paramFromServiceMsg);
      return;
      long l1 = System.currentTimeMillis();
      if (l1 - this.D > com.tencent.mobileqq.msf.core.a.a.x() * com.tencent.mobileqq.msf.core.a.a.r())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "timenow - firstSendHeartBeatTime is " + (l1 - this.D) + ",try close conn");
        }
        this.q.sender.a.a(com.tencent.qphone.base.a.e);
        r();
        return;
      }
      p();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
    }
    r();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg.getAttributes().put("_attr_regprxy_socket_hashcode", new Integer(paramInt));
    this.Y = paramToServiceMsg;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.q.msfAlarmer.b(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    CodecWarpper.nateiveRemoveAccountKey(paramString);
  }
  
  public void a(HashMap paramHashMap)
  {
    this.R.add(paramHashMap);
    this.S = true;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "add waitReportData " + this.R.size());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.ak = paramArrayOfByte;
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        this.ag.add(str);
        i1 += 1;
      }
    }
    this.ag.add("GrayUinPro.Check");
    this.ag.add("StatSvc.register");
    this.ag.add("StatSvc.get");
    this.ag.add("RegPrxySvc.infoLogin");
    this.ag.add("wtlogin.login");
    this.ag.add("RegPrxySvc.getOffMsg");
    this.ag.add("login.auth");
    this.ag.add("wtlogin.exchange");
    this.ag.add("wtlogin.trans_emp");
    this.ag.add("MessageSvc.PbSendMsg");
    this.ag.add("LongConn.OffPicUp");
    this.ag.add("LongConn.OffPicDown");
    this.ag.add("ImgStore.GroupPicUp");
    this.ag.add("ImgStore.GroupPicDown");
    this.ag.add("StreamSvr.UploadStreamMsg");
    this.ag.add("StreamSvr.RespUploadStreamMsg");
    this.ag.add("StreamSvr.PushStreamMsg");
    this.ag.add("StreamSvr.RespPushStreamMsg");
    this.ag.add("OidbSvc.0x787_1");
    this.ag.add("OidbSvc.0x49d_107");
    this.ag.add("MultiMsg.ApplyUp");
    this.ag.add("MultiMsg.ApplyDown");
    this.ag.add("PttCenterSvr.ShortVideoUpReq");
    this.ag.add("PttCenterSvr.ShortVideoDownReq");
    this.ag.add("ImgStore.GroupPicUp#pttGu");
    this.ag.add("ImgStore.GroupPicDown#pttGd");
    this.ag.add("PttStore.GroupPttUp");
    this.ag.add("PttStore.GroupPttDown");
    this.ag.add("Heartbeat.Alive");
    this.ag.add("friendlist.getFriendGroupList");
    this.ag.add("VideoSvc.Send");
    this.ag.add("VideoSvc.Ack");
    this.ag.add("SharpSvr.c2s");
    this.ag.add("SharpSvr.c2sack");
    this.ag.add("SharpSvr.s2c");
    this.ag.add("SharpSvr.s2cack");
    this.ag.add("MultiVideo.c2s");
    this.ag.add("MultiVideo.c2sack");
    this.ag.add("MultiVideo.s2c");
    this.ag.add("MultiVideo.s2cack");
    this.ag.add("MessageSvc.PbGetMsg");
    this.ag.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.ag.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500");
    this.ag.add("OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.ag.add("cmd_openConn");
    this.ag.add("wtlogin.exchange_emp");
    this.ag.add("wtlogin.name2uin");
  }
  
  public boolean a()
  {
    return this.T.isEmpty();
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1169	com/tencent/mobileqq/msf/core/s:c	(Landroid/content/Context;)V
    //   5: aload_0
    //   6: getfield 219	com/tencent/mobileqq/msf/core/s:p	Lcom/tencent/mobileqq/msf/core/s$a;
    //   9: aload_1
    //   10: iconst_0
    //   11: invokevirtual 1173	com/tencent/mobileqq/msf/core/s$a:init	(Landroid/content/Context;Z)V
    //   14: aload_0
    //   15: getfield 284	com/tencent/mobileqq/msf/core/s:q	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   18: invokevirtual 1022	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   21: invokevirtual 1175	com/tencent/mobileqq/msf/core/auth/b:f	()[B
    //   24: invokestatic 1178	com/tencent/qphone/base/util/CodecWarpper:setKsid	([B)V
    //   27: aload_0
    //   28: getfield 226	com/tencent/mobileqq/msf/core/s:v	Lcom/tencent/mobileqq/msf/core/s$c;
    //   31: invokevirtual 1179	com/tencent/mobileqq/msf/core/s$c:start	()V
    //   34: invokestatic 1185	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   37: ldc_w 1187
    //   40: invokevirtual 1192	com/tencent/msf/boot/config/NativeConfigStore:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +72 -> 117
    //   48: aload_1
    //   49: invokevirtual 575	java/lang/String:length	()I
    //   52: ifle +65 -> 117
    //   55: invokestatic 1185	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   58: ldc_w 1194
    //   61: invokevirtual 1192	com/tencent/msf/boot/config/NativeConfigStore:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +125 -> 193
    //   71: aload 4
    //   73: invokevirtual 575	java/lang/String:length	()I
    //   76: ifle +117 -> 193
    //   79: aload 4
    //   81: invokestatic 1198	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   84: lstore_2
    //   85: invokestatic 268	java/lang/System:currentTimeMillis	()J
    //   88: lload_2
    //   89: lsub
    //   90: ldc2_w 1199
    //   93: lcmp
    //   94: ifle +63 -> 157
    //   97: new 1202	com/tencent/mobileqq/msf/core/t
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 1203	com/tencent/mobileqq/msf/core/t:<init>	(Lcom/tencent/mobileqq/msf/core/s;)V
    //   105: astore_1
    //   106: aload_1
    //   107: ldc_w 1205
    //   110: invokevirtual 1206	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   113: aload_1
    //   114: invokevirtual 1207	java/lang/Thread:start	()V
    //   117: iconst_1
    //   118: ireturn
    //   119: astore 4
    //   121: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq -119 -> 5
    //   127: ldc 48
    //   129: iconst_2
    //   130: new 342	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 1209
    //   140: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 4
    //   145: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto -149 -> 5
    //   157: aload_0
    //   158: aload_1
    //   159: invokespecial 1211	com/tencent/mobileqq/msf/core/s:d	(Ljava/lang/String;)V
    //   162: iconst_1
    //   163: ireturn
    //   164: astore_1
    //   165: ldc 48
    //   167: iconst_1
    //   168: new 342	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 1213
    //   178: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iconst_1
    //   192: ireturn
    //   193: invokestatic 1185	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   196: ldc_w 1194
    //   199: invokestatic 268	java/lang/System:currentTimeMillis	()J
    //   202: invokestatic 1216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   205: invokevirtual 1220	com/tencent/msf/boot/config/NativeConfigStore:setConfig	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_0
    //   209: aload_1
    //   210: invokespecial 1211	com/tencent/mobileqq/msf/core/s:d	(Ljava/lang/String;)V
    //   213: iconst_1
    //   214: ireturn
    //   215: astore_1
    //   216: goto -202 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	s
    //   0	219	1	paramContext	android.content.Context
    //   84	5	2	l1	long
    //   64	16	4	str	String
    //   119	25	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	119	java/lang/Exception
    //   34	44	164	java/lang/Exception
    //   48	66	164	java/lang/Exception
    //   71	117	164	java/lang/Exception
    //   157	162	164	java/lang/Exception
    //   193	213	164	java/lang/Exception
    //   5	14	215	java/lang/Exception
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping)
    {
      this.q.sender.a.n().e();
      this.q.sender.a.a(com.tencent.qphone.base.a.B);
      return false;
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedRemindSlowNetwork())) {
      com.tencent.mobileqq.msf.core.net.f.a(f.b.a);
    }
    paramToServiceMsg.addAttribute("_tag_socket_connerror", h.F);
    paramFromServiceMsg.addAttribute("_tag_socket_connerror", h.F);
    if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
      paramFromServiceMsg.addAttribute("_tag_socket", paramToServiceMsg.getAttribute("_tag_socket"));
    }
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {}
    for (long l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();; l1 = 0L)
    {
      long l3 = System.currentTimeMillis();
      long l2 = 0L;
      if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
        l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
      }
      if ((l2 != 0L) && (l3 - l2 > paramToServiceMsg.getTimeout()) && (l3 - l2 > this.q.pushManager.e()) && (paramToServiceMsg.getTimeout() < this.q.pushManager.e()))
      {
        if (l2 >= this.a.n().c())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "xiaomi 2s: " + paramToServiceMsg.getRequestSsoSeq() + " msg timeout , addtoqueueTime is " + (l3 - l2) + ",try close conn");
          }
          this.q.sender.a.a(com.tencent.qphone.base.a.q);
          r();
          return true;
        }
        return true;
      }
      if ((l1 == 0L) || (l1 > this.a.n().c()))
      {
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
        {
          QLog.d("MSF.C.NetConnTag", 1, "found timeout heartalive msg " + paramToServiceMsg.getRequestSsoSeq());
          a(paramFromServiceMsg, paramToServiceMsg);
          return false;
        }
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
        {
          QLog.d("MSF.C.NetConnTag", 1, "found timeout quickheartbeat msg " + paramToServiceMsg.getRequestSsoSeq());
          this.q.quicksender.c(paramToServiceMsg, paramFromServiceMsg);
          return false;
        }
        try
        {
          if ((this.B.get()) && (System.currentTimeMillis() - this.D < com.tencent.mobileqq.msf.core.a.a.D() + 120000)) {
            break label651;
          }
          l1 = System.currentTimeMillis();
          if (l1 - this.D <= com.tencent.mobileqq.msf.core.a.a.D()) {
            break label596;
          }
          if (paramToServiceMsg.getRequestSsoSeq() == G)
          {
            G = -1;
            QLog.d("MSF.C.NetConnTag", 1, "found first msg screen on timeout try close conn " + paramToServiceMsg);
            this.q.sender.a.a(com.tencent.qphone.base.a.t);
            r();
            return true;
          }
        }
        finally {}
        p();
      }
      for (;;)
      {
        if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
          break label730;
        }
        return false;
        label596:
        QLog.d("MSF.C.NetConnTag", 1, "found timeout msg check time: timenow = " + l1 + " firstSendHeartBeatTime = " + this.D + " ConfigManager.getHeartBeatTimeInterval() = " + com.tencent.mobileqq.msf.core.a.a.D());
        break;
        label651:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MSF.C.NetConnTag", 2, "sendingHeartBeat: " + this.B + "net detect has started, no need sendHeartbeat");
        break;
        QLog.d("MSF.C.NetConnTag", 1, "found timeout msg " + paramToServiceMsg + " before connSucc.");
      }
      label730:
      if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat) {
        return false;
      }
      for (;;)
      {
        try
        {
          if (this.a.b())
          {
            int i3 = 1;
            paramFromServiceMsg = af;
            int i4 = paramFromServiceMsg.length;
            i1 = 0;
            int i2 = i3;
            if (i1 < i4)
            {
              CharSequence localCharSequence = paramFromServiceMsg[i1];
              if ((TextUtils.isEmpty(localCharSequence)) || (paramToServiceMsg == null) || (!localCharSequence.equals(paramToServiceMsg.getServiceCmd()))) {
                continue;
              }
              i2 = 0;
            }
            if ((i2 != 0) && (o.incrementAndGet() >= com.tencent.mobileqq.msf.core.a.a.y()))
            {
              QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
              o.set(0);
              this.q.sender.a.a(com.tencent.qphone.base.a.e);
              r();
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          int i1;
          QLog.d("MSF.C.NetConnTag", 1, " Continue wait resp for bus packets ,try close conn failed: " + paramToServiceMsg);
          continue;
        }
        return true;
        i1 += 1;
      }
    }
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (this.q.isSuspended())
    {
      ??? = l.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2009, "MSF is suspeded.");
      this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    String str1;
    Object localObject2;
    String str2;
    int i1;
    if (this.q.configManager.J != null)
    {
      Iterator localIterator = this.q.configManager.J.keySet().iterator();
      ??? = null;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          localObject2 = (a.a)this.q.configManager.J.get(str1);
          if (((a.a)localObject2).a + ((a.a)localObject2).b.b < System.currentTimeMillis() / 1000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item expired sCmd = " + str1);
            }
            this.q.configManager.J.remove(str1);
            ??? = localObject2;
          }
          else
          {
            str2 = paramToServiceMsg.getServiceCmd();
            if (str1.charAt(str1.length() - 1) == '*')
            {
              ??? = localObject2;
              if (!str2.startsWith(str1.substring(0, str1.length() - 1))) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label1925;
              }
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str2 + " sCmd:" + str1);
              i1 = 1;
              ??? = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (??? != null))
      {
        localObject2 = l.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(((a.a)???).b.c, new String(((a.a)???).b.d));
        this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify server overload block tomsg: " + paramToServiceMsg + " frommsg: " + localObject2);
        }
        return paramToServiceMsg.getRequestSsoSeq();
        ??? = localObject2;
        if (!str1.equals(str2)) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1925;
        }
        QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str2 + " sCmd:" + str1);
        i1 = 1;
        ??? = localObject2;
        continue;
      }
      if ((paramToServiceMsg.getAppId() <= 0) && (paramToServiceMsg.getMsfCommand() != MsfCommand.openConn))
      {
        ??? = l.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(1007, "msg appid is " + paramToServiceMsg.getAppId());
        this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      if (an.get())
      {
        ??? = l.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(2014, "error");
        this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      localObject2 = (com.tencent.msf.service.protocol.e.d)u.a.get(paramToServiceMsg.getUin());
      ??? = localObject2;
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (paramToServiceMsg.getServiceCmd().equals("wtlogin.login"))
        {
          this.I.remove(paramToServiceMsg.getUin());
          u.a.remove(paramToServiceMsg.getUin());
          ??? = null;
        }
      }
      if ((??? != null) && (!paramToServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "error, " + paramToServiceMsg.getUin() + " not in gray list");
        }
        localObject2 = l.a(paramToServiceMsg);
        try
        {
          ((FromServiceMsg)localObject2).setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)???).c, "UTF-8"));
          ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)???).b));
          this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
          if (this.q.getAccountCenter().i(((FromServiceMsg)localObject2).getUin())) {
            this.q.getAccountCenter().m(((FromServiceMsg)localObject2).getUin());
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((FromServiceMsg)localObject2).setBusinessFail(2008, paramToServiceMsg.getUin() + " not in gray list");
          }
        }
      }
      if ((this.q.standbyModeManager != null) && (this.q.standbyModeManager.d()))
      {
        if (!this.q.standbyModeManager.a(paramToServiceMsg.getServiceCmd()))
        {
          QLog.d("MSF.C.NetConnTag", 1, "refuse to send request cmd: " + paramToServiceMsg.getServiceCmd() + " ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by standbyMode");
          this.q.getStandyModeManager().a(paramToServiceMsg);
          ??? = l.a(paramToServiceMsg);
          ((FromServiceMsg)???).setBusinessFail(2018, "standby mode force stop request");
          this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
          if (!this.a.b())
          {
            ??? = MsfMsgUtil.getConnOpenMsg("");
            MsfSdkUtils.addToMsgProcessName("", (ToServiceMsg)???);
            this.q.sendSsoMsg((ToServiceMsg)???);
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        this.q.getStandyModeManager().b(paramToServiceMsg);
      }
      CodecWarpper.getFileStoreKey();
      ??? = this.q.getAccountCenter().k(paramToServiceMsg.getUin());
      if (??? != null) {
        paramToServiceMsg.setUin((String)???);
      }
      if ((!paramToServiceMsg.getUin().equals("0")) && (!this.ac.equals(paramToServiceMsg.getUin())))
      {
        this.ac = paramToServiceMsg.getUin();
        this.q.statReporter.a(this.ac);
        if (this.ab != paramToServiceMsg.getAppId()) {
          this.ab = paramToServiceMsg.getAppId();
        }
        if (paramToServiceMsg.getRequestSsoSeq() == -1) {
          paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        }
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
          paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
        }
        paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
        if ((!this.k) && (this.l))
        {
          this.j = SystemClock.elapsedRealtime();
          this.k = true;
        }
        if (((paramToServiceMsg.getServiceCmd().equals("StatSvc.register")) || (paramToServiceMsg.getServiceCmd().equals("StatSvc.get"))) && (paramToServiceMsg.getMsfCommand().equals(MsfCommand._msf_RegPush)) && (this.l))
        {
          this.j = SystemClock.elapsedRealtime();
          this.k = true;
          ??? = com.tencent.mobileqq.msf.core.a.a.d();
          if ((??? == null) || (this.ag.size() == ???.length)) {
            break label1532;
          }
          a((String[])???);
        }
        label1273:
        if ((!this.l) || (SystemClock.elapsedRealtime() - this.j >= this.h)) {
          break label1914;
        }
        if (this.ag.size() == 0) {
          a(null);
        }
        if (!this.ag.contains(paramToServiceMsg.getServiceCmd())) {
          break label1654;
        }
        if (!paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoLogin")) {
          break label1648;
        }
        this.X.add(paramToServiceMsg);
        i1 = paramToServiceMsg.getWupBuffer().length;
      }
      for (;;)
      {
        synchronized (this.ai)
        {
          this.f = (i1 + this.f);
          if (!this.ah)
          {
            this.Z.post(this.c);
            this.ah = true;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd() + " uin: " + paramToServiceMsg.getUin() + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to SSO.LoginMerge delayWaitSendList");
            return paramToServiceMsg.getRequestSsoSeq();
            if ((!paramToServiceMsg.getUin().equals("0")) || (paramToServiceMsg.getAttributes().containsKey("__base_tag_isAppMsg")) || (paramToServiceMsg.getServiceCmd().equals("PhSigLcId.Check"))) {
              break;
            }
            paramToServiceMsg.setUin(h());
            break;
            label1532:
            if (??? != null) {
              break label1273;
            }
            a(null);
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd().hashCode() + " uin: " + MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()) + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to " + "SSO.LoginMerge".hashCode() + " delayWaitSendList");
      }
      label1648:
      return f(paramToServiceMsg);
      label1654:
      this.w = SystemClock.elapsedRealtime();
      this.X.add(paramToServiceMsg);
      i1 = paramToServiceMsg.getWupBuffer().length;
      for (;;)
      {
        synchronized (this.ai)
        {
          this.f = (i1 + this.f);
          if (!this.ah)
          {
            this.Z.postDelayed(this.c, this.g);
            this.ah = true;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd() + " uin: " + paramToServiceMsg.getUin() + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to SSO.LoginMerge delayWaitSendList");
            return paramToServiceMsg.getRequestSsoSeq();
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd().hashCode() + " uin: " + MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()) + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to " + "SSO.LoginMerge".hashCode() + " delayWaitSendList");
      }
      label1914:
      return f(paramToServiceMsg);
      i1 = 0;
      continue;
      label1925:
      i1 = 1;
      ??? = localObject2;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      if ((this.a.b()) && (this.a.n() != null) && (this.a.n().g != null) && (this.a.n().g.hashCode() == paramInt)) {
        q();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if ((this.Y == null) || (!this.Y.getAttributes().containsKey("_attr_regprxy_socket_hashcode")) || (!this.Y.getAttributes().containsKey("_attr_regprxy_random_code")))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by infoLogin error");
      return;
    }
    if ((!this.a.b()) || (this.a.n().g == null))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by disconn");
      return;
    }
    if (this.a.n().g.hashCode() == ((Integer)this.Y.getAttributes().get("_attr_regprxy_socket_hashcode")).intValue())
    {
      paramFromServiceMsg.getAttributes().put("_attr_regprxy_random_code", this.Y.getAttributes().get("_attr_regprxy_random_code"));
      return;
    }
    QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by socket changed");
  }
  
  public byte[] b()
  {
    return this.ak;
  }
  
  public ToServiceMsg c(int paramInt)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)this.T.remove(Integer.valueOf(paramInt));
    if (localToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      this.q.msfAlarmer.b().removeCallbacks(localRunnable);
    }
    return localToServiceMsg;
  }
  
  public void c()
  {
    if (this.ac != "0") {
      this.q.getAccountCenter().a(false);
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    this.T.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(aa.incrementAndGet()));
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    for (Runnable localRunnable = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());; localRunnable = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout()))
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.p.onReceData(paramArrayOfByte);
  }
  
  public ToServiceMsg d()
  {
    return null;
  }
  
  public void d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = (Runnable)paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (paramToServiceMsg != null) {
        this.q.msfAlarmer.b().removeCallbacks(paramToServiceMsg);
      }
    }
  }
  
  public ConcurrentHashMap e()
  {
    return this.T;
  }
  
  public byte[] e(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = null;
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      int i1;
      try
      {
        String str = paramToServiceMsg.getServiceCmd();
        i1 = str.indexOf("#");
        localObject = str;
        if (i1 != -1) {
          localObject = str.substring(0, i1);
        }
        if (paramToServiceMsg.getWupBuffer() != null)
        {
          b1 = 0;
          if (NetConnInfoCenterImpl.isWifiConn())
          {
            b1 = 1;
            g();
            return CodecWarpper.encodeRequest(paramToServiceMsg.getRequestSsoSeq(), l.d(), l.f(), l.g(), "", (String)localObject, b(), paramToServiceMsg.getAppId(), this.q.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), false);
          }
          if (!NetConnInfoCenterImpl.isMobileConn()) {
            continue;
          }
          int i2 = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
          i1 = i2;
          if (i2 <= 254) {
            break label207;
          }
          i2 = 254;
          i1 = i2;
          if (!QLog.isColorLevel()) {
            break label207;
          }
          QLog.d("MSF.C.NetConnTag", 2, "error,netWorkType is " + 254);
          i1 = i2;
          break label207;
        }
        return new byte[0];
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        QLog.d("MSF.C.NetConnTag", 1, "encode packet failed", paramToServiceMsg);
        localObject = new byte[0];
      }
      return localObject;
      label207:
      byte b1 = (byte)i1;
    }
  }
  
  public ConcurrentHashMap f()
  {
    return this.U;
  }
  
  public String h()
  {
    return this.ac;
  }
  
  public int i()
  {
    return this.ab;
  }
  
  public void j()
  {
    try
    {
      if (this.S)
      {
        Iterator localIterator = this.R.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          try
          {
            this.q.configManager.a(localHashMap, "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "report waitReportData error " + localException1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "report waitReportData succ " + this.R.size());
    }
    this.R.clear();
    this.S = false;
  }
  
  public void k()
  {
    Iterator localIterator = this.T.entrySet().iterator();
    label217:
    for (;;)
    {
      Object localObject1;
      int i1;
      if (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = (ToServiceMsg)((Map.Entry)localObject1).getValue();
        if ((localObject1 == null) || (this.W.contains(localObject1))) {
          continue;
        }
        if (((ToServiceMsg)localObject1).isFastResendEnabled()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label217;
        }
        Object localObject2 = MsfSdkUtils.constructResponse((ToServiceMsg)localObject1, 2901, "", null);
        ((FromServiceMsg)localObject2).setBusinessFail(2901);
        if ((localObject1 != null) && (this.q.quicksender != null) && (this.q.quicksender.b((ToServiceMsg)localObject1))) {
          this.q.quicksender.a((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
        }
        this.q.addRespToQuque((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
        localIterator.remove();
        break;
        localObject2 = BaseConstants.CMD_NeedResendCmds;
        int i2 = localObject2.length;
        i1 = 0;
        for (;;)
        {
          if (i1 < i2)
          {
            Object localObject3 = localObject2[i1];
            if (((ToServiceMsg)localObject1).getServiceCmd().equals(localObject3))
            {
              i1 = 1;
              break;
            }
            i1 += 1;
            continue;
            return;
          }
        }
        i1 = 0;
      }
    }
  }
  
  class a
    extends CodecWarpper
  {
    a() {}
    
    private com.tencent.qphone.base.a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return com.tencent.qphone.base.a.u;
      case -2: 
        return com.tencent.qphone.base.a.v;
      case -3: 
        return com.tencent.qphone.base.a.w;
      case -4: 
        return com.tencent.qphone.base.a.x;
      case -5: 
        return com.tencent.qphone.base.a.j;
      case -6: 
        return com.tencent.qphone.base.a.r;
      case -7: 
        return com.tencent.qphone.base.a.s;
      }
      return com.tencent.qphone.base.a.y;
    }
    
    private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
    {
      paramFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
      paramFromServiceMsg.addAttribute("__timestamp_net2msf_boot", Long.valueOf(SystemClock.elapsedRealtime()));
      Object localObject1 = paramFromServiceMsg.getMsgCookie();
      if ((localObject1 != null) && (localObject1.length > 0)) {
        s.this.q.sender.a((byte[])localObject1);
      }
      paramFromServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getAppSeq());
      ToServiceMsg localToServiceMsg;
      label132:
      int i;
      Object localObject2;
      if ((!paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getBusinessFailCode() == -10008))
      {
        s.a(paramFromServiceMsg.getUin(), false);
        if (NetConnInfoCenterImpl.isNeedWifiAuth()) {
          NetConnInfoCenterImpl.setNeedWifiAuth(false);
        }
        localToServiceMsg = s.this.q.sender.c(paramFromServiceMsg.getRequestSsoSeq());
        if (localToServiceMsg == null) {
          break label1004;
        }
        localObject1 = localToServiceMsg.getServiceCmd();
        i = ((String)localObject1).indexOf("#");
        if (i == -1) {
          break label1013;
        }
        localObject2 = ((String)localObject1).substring(i + 1, ((String)localObject1).length()) + "_new";
        ((String)localObject1).substring(0, i);
        i.a(true, paramFromServiceMsg.getUin(), paramInt, (String)localObject2, 1, s.this.a.n().l, s.this.a.n().m);
        label224:
        if ((localToServiceMsg == null) || (localToServiceMsg.getAttribute("__timestamp_msf2net") == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getAttribute("__timestamp_net2msf") == null)) {
          break label1614;
        }
        l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)localToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        long l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        l2 = l1;
        if (l1 <= 2147483647L) {}
      }
      label445:
      label1614:
      for (long l2 = 0L;; l2 = 0L)
      {
        for (;;)
        {
          localObject2 = new StringBuilder();
          if (QLog.isDevelopLevel()) {
            if (l2 == 0L)
            {
              localObject1 = String.valueOf(l2);
              label342:
              if (paramFromServiceMsg.getResultCode() == 1000) {
                break label1080;
              }
              QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd() + " len:" + paramInt + " costTime:" + (String)localObject1 + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg());
              paramFromServiceMsg.addAttribute("_tag_LOGSTR", s.r + "|" + paramFromServiceMsg.getRequestSsoSeq() + "|" + paramFromServiceMsg.getServiceCmd() + "|");
              paramFromServiceMsg.addAttribute("_tag_socket", s.r);
              paramFromServiceMsg.addAttribute("_tag_localsocket", s.s);
              if (localToServiceMsg == null) {}
            }
          }
          try
          {
            s.this.a.a(paramFromServiceMsg, localToServiceMsg);
            if ((s.this.q.isReconnectSso.get()) && (s.this.q.sender.a()))
            {
              s.this.a.n().a(com.tencent.qphone.base.a.h);
              s.this.q.isReconnectSso.set(false);
            }
            if (localToServiceMsg != null)
            {
              paramFromServiceMsg.setAppSeq(localToServiceMsg.getAppSeq());
              paramFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
              paramFromServiceMsg.setAppId(localToServiceMsg.getAppId());
              if (!paramFromServiceMsg.isSuccess())
              {
                i = paramFromServiceMsg.getBusinessFailCode();
                paramInt = i;
                if (i == 302)
                {
                  paramFromServiceMsg.setBusinessFail(-302);
                  paramInt = -302;
                }
                if (paramInt == -302)
                {
                  s.this.a.n().a(com.tencent.qphone.base.a.i);
                  s.this.q.reSendMsg(localToServiceMsg);
                  return;
                  if ((paramFromServiceMsg.getUin() == null) || (paramFromServiceMsg.getUin().length() <= 4) || (s.Q.contains(paramFromServiceMsg.getUin())) || (!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestReBindMblWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestVerifyWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_app_info_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.sdk_auth_api_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_auth_api_list_emp"))) {
                    break;
                  }
                  localObject1 = (ConcurrentLinkedQueue)s.n.get(paramFromServiceMsg.getUin());
                  if ((localObject1 != null) && (((ConcurrentLinkedQueue)localObject1).contains(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
                  {
                    s.n.remove(paramFromServiceMsg.getUin());
                    s.a(paramFromServiceMsg.getUin(), true);
                    QLog.d(tag, 1, "recv Packet removeItem setV9, ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
                    break;
                  }
                  QLog.d(tag, 1, "recv Packet ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
                  break;
                  label1004:
                  localObject1 = paramFromServiceMsg.getServiceCmd();
                  break label132;
                  label1013:
                  i.a(true, paramFromServiceMsg.getUin(), paramInt, (String)localObject1, 1, s.this.a.n().l, s.this.a.n().m);
                  break label224;
                  localObject1 = l2 + NetConnInfoCenter.getSignalStrengthsLog();
                  break label342;
                  QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd() + " len:" + paramInt + " costTime:" + (String)localObject1);
                  break label445;
                  if (paramFromServiceMsg.getResultCode() != 1000)
                  {
                    QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd().hashCode() + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg());
                    break label445;
                  }
                  QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd().hashCode() + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString());
                }
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              s.this.a.c();
              QLog.d(tag, 1, "call firstResponseGetted error " + localException, localException);
            }
            if (paramInt == -10008)
            {
              if (!MsfMsgUtil.hasResendBy10008(localToServiceMsg))
              {
                localToServiceMsg.getAttributes().put("_attr_msg_has_resend_by_10008", Boolean.valueOf(true));
                s.this.q.reSendMsg(localToServiceMsg);
                return;
              }
              QLog.d(tag, 1, "This msg has already resend by -10008, won't resend again!");
            }
          }
        }
        if (s.o().get()) {
          QLog.e(tag, 1, "invalidSign, " + paramFromServiceMsg + " is droped.");
        }
        for (;;)
        {
          s.this.q.getAccountCenter().g.a();
          paramFromServiceMsg = s.this.q.netConnICenter;
          NetConnInfoCenter.impl.checkRecordTime();
          s.this.j();
          return;
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
          {
            s.this.a(paramFromServiceMsg, localToServiceMsg);
          }
          else if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
          {
            s.this.q.quicksender.c(localToServiceMsg, paramFromServiceMsg);
          }
          else
          {
            s.o.set(0);
            s.this.q.getSsoRespHandler().c(localToServiceMsg, paramFromServiceMsg);
          }
        }
      }
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper loginMerge onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      s.this.a.n().a(a(paramInt1));
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(s.e(s.this)).append("|").append(MsfCore.mobileQQAppid).append("|").append(paramInt3).append("|").append(paramInt1).append("|").append(s.this.a.n().l + ":" + s.this.a.n().m);
      if (QLog.isDevelopLevel()) {
        QLog.d(tag, 4, "CodecStatHelper Report loginMerge_error " + localStringBuffer.toString());
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("loginMerge_failDetail", localStringBuffer.toString());
      MsfService.getCore().getStatReporter().a("loginMerge_error", true, 0L, 0L, localHashMap, false, false);
    }
    
    public void onInvalidData(int paramInt1, int paramInt2)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      s.this.a.n().a(a(paramInt1));
      try
      {
        s.this.a.e();
        return;
      }
      catch (Exception localException)
      {
        QLog.d(tag, 1, "call findResponseDataError error " + localException);
      }
    }
    
    public void onInvalidSign()
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidSign");
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(s.this.q.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_InvalidSign");
      localFromServiceMsg.setBusinessFail(2014, "onInvalidSign");
      localFromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      s.this.q.addRespToQuque(null, localFromServiceMsg);
      s.o().set(true);
    }
    
    public void onResponse(int paramInt1, Object paramObject, int paramInt2)
    {
      Object localObject4 = null;
      try
      {
        s.this.y.incrementAndGet();
        if (paramObject == null) {
          break label396;
        }
        if (s.G != -1) {
          s.G = -1;
        }
        s.this.E = System.currentTimeMillis();
        s.F = s.this.E;
        localObject1 = (FromServiceMsg)paramObject;
        try
        {
          paramInt1 = ((FromServiceMsg)localObject1).getWupBuffer().length;
          if (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge")) {
            break label397;
          }
          ((FromServiceMsg)localObject1).setRequestSsoSeq(((FromServiceMsg)localObject1).getAppSeq());
          if (((FromServiceMsg)localObject1).isSuccess()) {
            break label397;
          }
          QLog.d("MSF.C.NetConnTag", 1, "failed merge netRecv ssoSeq:" + ((FromServiceMsg)localObject1).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject1).getServiceCmd() + " len: " + ((FromServiceMsg)localObject1).getWupBuffer().length);
          Object localObject2 = (ArrayList)s.g(s.this).remove(Integer.valueOf(((FromServiceMsg)localObject1).getRequestSsoSeq()));
          if (((FromServiceMsg)localObject1).getBusinessFailCode() == -10107)
          {
            if (s.this.l) {
              s.this.l = false;
            }
            QLog.d("MSF.C.NetConnTag", 1, "merge not support, " + Arrays.toString(((ArrayList)localObject2).toArray()) + "resend, close merge.");
          }
          if (localObject2 == null) {
            break label397;
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramInt1 = ((Integer)((Iterator)localObject2).next()).intValue();
            localObject4 = s.this.q.sender.c(paramInt1);
            if (localObject4 != null) {
              s.a(s.this, (ToServiceMsg)localObject4);
            }
          }
          if (!localThrowable1.toString().contains("InvalidProtocol")) {
            break label347;
          }
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject3;
          Object localObject1 = localException;
        }
      }
      if (localObject1 != null) {
        a(-8, paramInt2, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      }
      label347:
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "handleSsoResp " + paramObject + " error " + localThrowable1.toString(), localThrowable1);
      }
      for (;;)
      {
        label396:
        return;
        label397:
        int i;
        if ((((FromServiceMsg)localObject1).getFlag() & 0x1) != 0)
        {
          localObject3 = ((FromServiceMsg)localObject1).getWupBuffer();
          i = localObject3.length;
          if (i > 4) {
            i = (localObject3[0] & 0xFF) << 24 | 0x0 | (localObject3[1] & 0xFF) << 16 | (localObject3[2] & 0xFF) << 8 | localObject3[3] & 0xFF;
          }
        }
        else
        {
          try
          {
            localObject4 = new byte[i];
            System.arraycopy(localObject3, 4, localObject4, 0, i - 4);
            localObject4 = com.tencent.qphone.base.util.f.b((byte[])localObject4);
            Object localObject5 = new byte[localObject4.length + 4];
            localObject5[0] = ((byte)(localObject4.length + 4 >> 24 & 0xFF));
            localObject5[1] = ((byte)(localObject4.length + 4 >> 16 & 0xFF));
            localObject5[2] = ((byte)(localObject4.length + 4 >> 8 & 0xFF));
            localObject5[3] = ((byte)(localObject4.length + 4 & 0xFF));
            System.arraycopy(localObject4, 0, localObject5, 4, localObject4.length);
            ((FromServiceMsg)localObject1).putWupBuffer((byte[])localObject5);
            if ((!((FromServiceMsg)localObject1).isSuccess()) || (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge"))) {
              break label982;
            }
            QLog.d("MSF.C.NetConnTag", 1, "netRecv Delay FromServiceMsg ssoSeq:" + ((FromServiceMsg)localObject1).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject1).getServiceCmd() + " len: " + paramInt1 + " uncompressed len: " + ((FromServiceMsg)localObject1).getWupBuffer().length);
            localObject3 = new SSOLoginMerge.BusiBuffData();
            localObject4 = new byte[((FromServiceMsg)localObject1).getWupBuffer().length - 4];
            System.arraycopy(((FromServiceMsg)localObject1).getWupBuffer(), 4, localObject4, 0, localObject4.length);
            localObject3 = ((SSOLoginMerge.BusiBuffData)((SSOLoginMerge.BusiBuffData)localObject3).mergeFrom((byte[])localObject4)).BusiBuffVec.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (SSOLoginMerge.BusiBuffItem)((Iterator)localObject3).next();
              localObject5 = new FromServiceMsg();
              ((FromServiceMsg)localObject5).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject4).ServiceCmd.get());
              ((FromServiceMsg)localObject5).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject4).SeqNo.get());
              ((FromServiceMsg)localObject5).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject4).BusiBuff.get().toByteArray());
              ((FromServiceMsg)localObject5).setAppSeq(((FromServiceMsg)localObject5).getRequestSsoSeq());
              ((FromServiceMsg)localObject5).setMsgSuccess();
              ((FromServiceMsg)localObject5).setUin(((FromServiceMsg)localObject1).getUin());
              ((FromServiceMsg)localObject5).putWupBuffer(s.b(((FromServiceMsg)localObject5).getWupBuffer()));
              a((FromServiceMsg)localObject5, ((FromServiceMsg)localObject5).getWupBuffer().length);
            }
            if (((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge")) {
              break label967;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d(tag, 2, "uncompress data failed " + localException);
            }
            if (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge"))
            {
              onInvalidData(-7, localObject3.length);
              return;
            }
            a(-7, localObject3.length, ((FromServiceMsg)localObject1).getRequestSsoSeq());
            return;
          }
        }
      }
      onInvalidData(-6, localObject3.length);
      return;
      label967:
      a(-6, localObject3.length, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      return;
      label982:
      a((FromServiceMsg)localObject1, paramInt2);
    }
    
    public void onSSOPingResponse(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null)
      {
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, data null");
        return;
      }
      if (paramArrayOfByte.length <= 4)
      {
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, length: " + paramArrayOfByte.length);
        return;
      }
      int i = paramArrayOfByte.length;
      for (;;)
      {
        Object localObject;
        long l1;
        try
        {
          paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
          paramArrayOfByte.getInt();
          paramArrayOfByte.getInt();
          paramArrayOfByte.getInt();
          int j = paramArrayOfByte.get();
          localObject = new byte[j];
          paramArrayOfByte.get((byte[])localObject, 0, j);
          new String((byte[])localObject);
          paramArrayOfByte.position(paramArrayOfByte.get() + paramArrayOfByte.position());
          j = paramArrayOfByte.getInt();
          new StringBuilder().append(j >> 24 & 0xFF).append('.').append(j >> 16 & 0xFF).append('.').append(j >> 8 & 0xFF).append('.').append(j & 0xFF).toString();
          localObject = s.this.a.n().e();
          if ((localObject == null) || (((ToServiceMsg)localObject).getAttribute("__timestamp_msf2net") == null)) {
            break label485;
          }
          l2 = SystemClock.elapsedRealtime() - ((Long)((ToServiceMsg)localObject).getAttribute("__timestamp_msf2net")).longValue();
          l1 = l2;
          if (l2 >= 0L) {
            break label491;
          }
          l1 = 0L;
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, exception : ", paramArrayOfByte);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (QLog.isDevelopLevel())
        {
          if (l2 == 0L)
          {
            paramArrayOfByte = String.valueOf(l2);
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject).getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(((ToServiceMsg)localObject).getUin()) + " cmd:" + ((ToServiceMsg)localObject).getServiceCmd() + " len:" + i + " costTime:" + paramArrayOfByte);
            return;
          }
          paramArrayOfByte = l2 + NetConnInfoCenter.getSignalStrengthsLog();
          continue;
        }
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject).getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(((ToServiceMsg)localObject).getUin()) + " cmd:" + ((ToServiceMsg)localObject).getServiceCmd().hashCode() + new StringBuilder().append(" ").append(i + ((ToServiceMsg)localObject).getRequestSsoSeq()).toString());
        return;
        label485:
        long l2 = 0L;
        continue;
        label491:
        l2 = l1;
        if (l1 > 2147483647L) {
          l2 = 0L;
        }
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      int j;
      synchronized (s.a(s.this))
      {
        j = s.b(s.this).size();
        i = j;
        if (j > s.this.d) {
          i = s.this.d;
        }
        long l = SystemClock.elapsedRealtime();
        if (s.this.w >= l)
        {
          s.c(s.this).postDelayed(s.this.c, s.this.g);
          if ((!s.d(s.this)) && (s.b(s.this).size() - s.this.e > 0))
          {
            s.c(s.this).postDelayed(s.this.c, s.this.g);
            s.a(s.this, true);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "delayWaitSendList size is " + s.b(s.this).size() + ", " + i + " sso package should be merged.");
          }
          if (i <= 0) {
            break label1508;
          }
          j = i;
        }
        try
        {
          if (i > s.b(s.this).size()) {
            j = s.b(s.this).size();
          }
          if (j != 1) {
            break label348;
          }
          ??? = (ToServiceMsg)s.b(s.this).peek();
          if ((??? == null) || (((ToServiceMsg)???).getWupBuffer().length >= s.this.i)) {
            break label348;
          }
          s locals = s.this;
          locals.f -= ((ToServiceMsg)???).getWupBuffer().length;
          s.a(s.this, (ToServiceMsg)s.b(s.this).poll());
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            synchronized (s.a(s.this))
            {
              if ((s.this.f >= s.this.e) && (!s.d(s.this)))
              {
                s.a(s.this, true);
                s.c(s.this).post(s.this.c);
                if (m > 0)
                {
                  s.g(s.this).put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localArrayList);
                  s.h(s.this).put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localObject6);
                  localObject5 = ((SSOLoginMerge.BusiBuffData)localObject5).toByteArray();
                  localObject6 = new ByteArrayOutputStream();
                  com.tencent.qphone.base.util.f.a((byte[])localObject5, (OutputStream)localObject6);
                  localObject6 = s.b(((ByteArrayOutputStream)localObject6).toByteArray());
                  ((ToServiceMsg)???).putWupBuffer((byte[])localObject6);
                  if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.NetConnTag", 4, "Delay ToServiceMsg ssoseq: " + ((ToServiceMsg)???).getRequestSsoSeq() + " delayWaitSendList buffer size is " + localObject5.length + ", zip size is " + localObject6.length);
                  }
                }
                if (??? == null) {
                  continue;
                }
                ((ToServiceMsg)???).addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
                s.a(s.this, (ToServiceMsg)???);
                return;
                localException = localException;
                QLog.d("MSF.C.NetConnTag", 1, "add delayMsg to send error, close LoginMerge. " + localException, localException);
                s.this.l = false;
                if (s.b(s.this).size() <= 0) {
                  continue;
                }
                localToServiceMsg1 = (ToServiceMsg)s.b(s.this).poll();
                if (localToServiceMsg1 == null) {
                  continue;
                }
                s.a(s.this, localToServiceMsg1);
                continue;
                if (!"RegPrxySvc.getOffMsg".equals(localToServiceMsg2.getServiceCmd())) {
                  continue;
                }
                localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
                continue;
                ??? = s.this;
                ((s)???).f -= localToServiceMsg2.getWupBuffer().length;
                if (j == 0)
                {
                  localToServiceMsg1.setUin(localToServiceMsg2.getUin());
                  localBusiBuffItem = new SSOLoginMerge.BusiBuffItem();
                  localBusiBuffItem.SeqNo.set(localToServiceMsg2.getRequestSsoSeq());
                  localBusiBuffItem.ServiceCmd.set(localToServiceMsg2.getServiceCmd());
                  if (localToServiceMsg2.getWupBuffer().length < 4)
                  {
                    localBusiBuffItem.BusiBuffLen.set(s.b(localToServiceMsg2.getWupBuffer()).length);
                    if (localToServiceMsg2.getWupBuffer().length < 4) {
                      continue;
                    }
                    ??? = new byte[localToServiceMsg2.getWupBuffer().length - 4];
                    System.arraycopy(localToServiceMsg2.getWupBuffer(), 4, ???, 0, ???.length);
                    localBusiBuffItem.BusiBuff.set(ByteStringMicro.copyFrom((byte[])???));
                    localBusiBuffItem.NeedResp.set(localToServiceMsg2.isNeedCallback());
                    ((SSOLoginMerge.BusiBuffData)localObject5).BusiBuffVec.add(localBusiBuffItem);
                    localArrayList.add(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()));
                    ((ArrayList)localObject6).add(localToServiceMsg2);
                    s.f(s.this).put(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()), localToServiceMsg2);
                    localToServiceMsg2.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(s.n().incrementAndGet()));
                    if (localToServiceMsg2.getTimeout() != -1L) {
                      continue;
                    }
                    localToServiceMsg2.setTimeout(30000L);
                    ??? = s.this.q.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                    localToServiceMsg2.addAttribute("to_timeoutCallbacker", ???);
                    i.a(true, s.e(s.this), localToServiceMsg2.getWupBuffer().length, localToServiceMsg2.getServiceCmd(), 0, s.this.a.n().l, s.this.a.n().m);
                    break;
                  }
                }
                else
                {
                  if (localToServiceMsg1.getUin().equals(localToServiceMsg2.getUin())) {
                    continue;
                  }
                  s.b(s.this).a(localToServiceMsg2);
                  ??? = s.this;
                  ((s)???).f += localToServiceMsg2.getWupBuffer().length;
                  m = i;
                  continue;
                }
                localBusiBuffItem.BusiBuffLen.set(localToServiceMsg2.getWupBuffer().length);
                continue;
                ??? = localToServiceMsg2.getWupBuffer();
                continue;
                ??? = s.this.q.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                continue;
              }
              if ((!s.d(s.this)) && (s.b(s.this).size() >= s.this.d))
              {
                s.a(s.this, true);
                s.c(s.this).post(s.this.c);
              }
            }
            if ((!s.d(s.this)) && (!s.b(s.this).isEmpty()))
            {
              s.c(s.this).postDelayed(s.this.c, s.this.g);
              s.a(s.this, true);
            }
          }
        }
        s.a(s.this, false);
      }
      label348:
      ??? = new ToServiceMsg("MSF SSOPackageMerge", s.e(s.this), "SSO.LoginMerge");
      ((ToServiceMsg)???).setAppId(MsfCore.mobileQQAppid);
      ((ToServiceMsg)???).setMsfCommand(MsfCommand.unknown);
      if (((ToServiceMsg)???).getRequestSsoSeq() == -1) {
        ((ToServiceMsg)???).setRequestSsoSeq(MsfCore.getNextSeq());
      }
      ((ToServiceMsg)???).setTimeout(30000L);
      ((ToServiceMsg)???).setNeedCallback(false);
      ArrayList localArrayList = new ArrayList();
      Object localObject6 = new ArrayList();
      Object localObject5 = new SSOLoginMerge.BusiBuffData();
      int i = j;
      if (i > s.b(s.this).size()) {
        i = s.b(s.this).size();
      }
      for (;;)
      {
        int m = i;
        ToServiceMsg localToServiceMsg2;
        if (j < i)
        {
          localToServiceMsg2 = (ToServiceMsg)s.b(s.this).poll();
          if (localToServiceMsg2 == null) {
            break label1502;
          }
          if (!"RegPrxySvc.infoLogin".equals(localToServiceMsg2.getServiceCmd())) {
            break label893;
          }
          ((ToServiceMsg)???).getAttributes().put("infoLoginMsg", localToServiceMsg2);
          k += localToServiceMsg2.getWupBuffer().length;
          if ((k < s.this.e) || (j == 0)) {
            break label923;
          }
          s.b(s.this).a(localToServiceMsg2);
          m = j;
        }
        ToServiceMsg localToServiceMsg1;
        label893:
        SSOLoginMerge.BusiBuffItem localBusiBuffItem;
        label923:
        label1502:
        break label1530;
        break label1523;
        label1508:
        localObject5 = null;
        localObject6 = null;
        localArrayList = null;
        Object localObject3 = null;
        break;
        label1523:
        int k = 0;
        j = 0;
        continue;
        label1530:
        j += 1;
      }
    }
  }
  
  class c
    extends Thread
  {
    long a = 0L;
    
    c() {}
    
    private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2)
    {
      s.this.c(paramToServiceMsg.getRequestSsoSeq());
    }
    
    public void run()
    {
      ToServiceMsg localToServiceMsg;
      int m;
      Object localObject2;
      long l1;
      long l2;
      label141:
      label425:
      boolean bool1;
      for (;;)
      {
        int k;
        int i;
        try
        {
          localToServiceMsg = (ToServiceMsg)s.i(s.this).k();
          if (localToServiceMsg != null)
          {
            try
            {
              String str = localToServiceMsg.getServiceCmd();
              m = str.indexOf("#");
              if (m == -1) {
                break label1747;
              }
              localObject2 = str.substring(m + 1, str.length()) + "_new";
              str = str.substring(0, m);
              l1 = ((Long)localToServiceMsg.getAttribute("__timestamp_addSendQueue", Long.valueOf(0L))).longValue();
              l2 = System.currentTimeMillis();
              s.this.q.configManager.a(localToServiceMsg, l2);
              if (localToServiceMsg.getWupBuffer() == null) {
                break label748;
              }
              k = 0;
              if (!NetConnInfoCenterImpl.isWifiConn()) {
                break label598;
              }
              i = 1;
              if (i != s.x)
              {
                s.x = i;
                s.g();
                QLog.d("MSF.C.NetConnTag", 1, "resetUserSimpleHead network type changed");
              }
              if (com.tencent.mobileqq.msf.core.auth.d.f.containsKey(localToServiceMsg.getUin()))
              {
                s.this.q.getAccountCenter().q(localToServiceMsg.getUin());
                com.tencent.mobileqq.msf.core.auth.d.f.remove(localToServiceMsg.getUin());
                QLog.d("MSF.C.NetConnTag", 1, "ReloadKey for uin:" + MsfSdkUtils.getShortUin(localToServiceMsg.getUin()) + " while ssoSeq=" + localToServiceMsg.getRequestSsoSeq());
              }
              if (!s.this.a.b())
              {
                s.g();
                QLog.d("MSF.C.NetConnTag", 1, "resetUserSimpleHead not connect network");
              }
              byte[] arrayOfByte1 = CodecWarpper.encodeRequest(localToServiceMsg.getRequestSsoSeq(), l.d(), l.f(), l.g(), "", str, s.this.b(), localToServiceMsg.getAppId(), s.this.q.getMsfAppid(), localToServiceMsg.getUin(), (byte)0, i, localToServiceMsg.getWupBuffer(), false);
              QLog.d("MSF.C.NetConnTag", 1, "pa ok: " + localToServiceMsg.getRequestSsoSeq());
              if (arrayOfByte1 != null) {
                break;
              }
              s.this.c(localToServiceMsg.getRequestSsoSeq());
            }
            catch (Throwable localThrowable1)
            {
              QLog.d("MSF.C.NetConnTag", 1, localThrowable1.toString(), localThrowable1);
              a(localToServiceMsg, "发送错误", localThrowable1.toString());
              s.i(s.this).remove(localToServiceMsg);
            }
            localObject1 = localToServiceMsg.getMsfCommand();
            localObject2 = MsfCommand._msf_kickedAndCleanTokenResp;
            if (localObject1 != localObject2) {}
          }
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          QLog.d("MSF.C.NetConnTag", 1, localThrowable2.toString(), localThrowable2);
        }
        try
        {
          localObject1 = (FromServiceMsg)localToServiceMsg.getAttribute(localToServiceMsg.getServiceCmd());
          s.this.q.getAccountCenter().m(((FromServiceMsg)localObject1).getUin());
          ((FromServiceMsg)localObject1).setBusinessFail(2012, ((FromServiceMsg)localObject1).getBusinessFailMsg());
          bool1 = false;
          if (localToServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {
            bool1 = ((Boolean)localToServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();
          }
          ((FromServiceMsg)localObject1).addAttribute("_attr_sameDevice", Boolean.valueOf(bool1));
          MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject1);
          s.this.q.addRespToQuque(null, (FromServiceMsg)localObject1);
          s.this.a.a(com.tencent.qphone.base.a.a);
        }
        catch (Exception localException1)
        {
          int n;
          byte[] arrayOfByte2;
          QLog.e("MSF.C.NetConnTag", 1, "send offlineMsg to app error " + localException1.toString());
          continue;
        }
        Thread.sleep(10L);
        continue;
        continue;
        label598:
        if (NetConnInfoCenterImpl.isMobileConn())
        {
          n = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
          m = n;
          if (n <= 254) {
            break label1753;
          }
          n = 254;
          m = n;
          if (!QLog.isColorLevel()) {
            break label1753;
          }
          QLog.d("MSF.C.NetConnTag", 2, "error,netWorkType is " + 254);
          m = n;
          break label1753;
        }
        if (this.a != 0L)
        {
          i = k;
          if (l2 - this.a <= 60000L) {}
        }
        else
        {
          this.a = l2;
          try
          {
            NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
            i = k;
          }
          catch (Exception localException2)
          {
            QLog.d("MSF.C.NetConnTag", 1, "checkConnInfo " + localException2);
            i = k;
          }
          continue;
          label748:
          arrayOfByte2 = new byte[0];
        }
      }
      if ((!localToServiceMsg.getUin().equals("0")) && (!((Boolean)localToServiceMsg.getAttribute("grayCheck", Boolean.valueOf(false))).booleanValue()) && (localToServiceMsg.getAppId() != -1) && (localToServiceMsg.getAppId() != 100)) {
        s.b(s.this, localToServiceMsg);
      }
      for (;;)
      {
        if (bool1) {
          break label425;
        }
        l2 = System.currentTimeMillis();
        if (l2 - l1 > localToServiceMsg.getTimeout())
        {
          if (!QLog.isColorLevel()) {
            break label425;
          }
          QLog.d("MSF.C.NetConnTag", 2, localToServiceMsg + " is already sendTimeout,break.");
          break label425;
        }
        if ((s.F != 0L) && (l2 - s.F > com.tencent.mobileqq.msf.core.a.a.E()) && (s.this.a.b()))
        {
          if (s.F < s.this.a.n().c()) {
            break label1284;
          }
          s.F = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "lastMessageTimeTooLong Close socket now. System.currentTimeMillis() - lastRecvSsoRespTime :" + (System.currentTimeMillis() - s.F) + " getNetIdleTimeInterval()" + com.tencent.mobileqq.msf.core.a.a.E());
          }
          s.this.a(com.tencent.qphone.base.a.o);
        }
        for (;;)
        {
          for (;;)
          {
            if ((s.F != 0L) && (l2 - s.F > 360000L) && (s.this.a.b()) && (s.F >= s.this.a.n().c()) && (!s.this.B.get()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "no receive data for 5 minutes, start fast net detect now.");
              }
              s.j(s.this);
            }
            try
            {
              localToServiceMsg.addAttribute("__timestamp_msf2net_boot", Long.valueOf(SystemClock.elapsedRealtime()));
              localToServiceMsg.addAttribute("__timestamp_msf2net", Long.valueOf(0L));
              localToServiceMsg.addAttribute("_tag_socket", s.r);
              localToServiceMsg.addAttribute("_tag_localsocket", s.s);
              boolean bool2 = s.this.a.a(localToServiceMsg.getAppId(), localToServiceMsg.getAppSeq(), localThrowable2, (String)localObject2, localToServiceMsg.getMsfCommand(), localToServiceMsg.getUin(), localToServiceMsg.getRequestSsoSeq(), arrayOfByte2, localToServiceMsg);
              bool1 = bool2;
            }
            catch (Throwable localThrowable3)
            {
              for (;;)
              {
                QLog.d("MSF.C.NetConnTag", 1, "send msg error " + localThrowable3, localThrowable3);
              }
              if ((localToServiceMsg.getUin() == null) || (localToServiceMsg.getUin().length() <= 4) || (localToServiceMsg.getServiceCmd().startsWith("login.")) || (localToServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (localToServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (localToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) || (localToServiceMsg.getServiceCmd().equals("account.RequestReBindMblWTLogin_emp")) || (localToServiceMsg.getServiceCmd().equals("account.RequestVerifyWTLogin_emp")) || (localToServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_app_info_emp")) || (localToServiceMsg.getServiceCmd().equals("ConnAuthSvr.sdk_auth_api_emp")) || (localToServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_auth_api_list_emp")) || (s.Q.contains(localToServiceMsg.getUin()))) {
                break label1595;
              }
              if (s.n.get(localToServiceMsg.getUin()) != null) {
                break label1522;
              }
              ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
              s.n.put(localToServiceMsg.getUin(), localConcurrentLinkedQueue);
              ((ConcurrentLinkedQueue)s.n.get(localToServiceMsg.getUin())).offer(Integer.valueOf(localToServiceMsg.getRequestSsoSeq()));
              QLog.d("MSF.C.NetConnTag", 1, "send Packet addQueue, ssoSeq=" + localToServiceMsg.getRequestSsoSeq() + ", uin=" + MsfSdkUtils.getShortUin(localToServiceMsg.getUin()));
              localToServiceMsg.addAttribute("__timestamp_msf2net", Long.valueOf(System.currentTimeMillis()));
              if (!localToServiceMsg.getServiceCmd().startsWith("SharpSvr.c2s")) {
                break label1630;
              }
              s.u = SystemClock.elapsedRealtime();
              if ((!s.this.M.get()) || (s.this.L != -1)) {
                break label1698;
              }
              s.this.L = localToServiceMsg.getRequestSsoSeq();
              QLog.d("MSF.C.NetConnTag", 1, "set afterReloadD2SendSeq " + s.this.L);
              s.this.z.incrementAndGet();
            }
            if (bool1) {
              break label1325;
            }
            localToServiceMsg.getAttributes().remove("__timestamp_msf2net_boot");
            localToServiceMsg.getAttributes().remove("__timestamp_msf2net");
            localToServiceMsg.getAttributes().remove("_tag_socket");
            localToServiceMsg.getAttributes().remove("_tag_localsocket");
            s.this.a.a(com.tencent.qphone.base.a.d);
            try
            {
              Thread.sleep(BaseConstants.reSendIntrevTime);
            }
            catch (Exception localException3)
            {
              QLog.d("MSF.C.NetConnTag", 1, localException3.toString(), localException3);
            }
          }
          break;
          label1284:
          s.F = 0L;
        }
        label1325:
        label1522:
        continue;
        label1595:
        label1630:
        localObject2 = null;
        label1698:
        label1747:
        break;
        label1753:
        int j = (byte)m;
        break label141;
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.s
 * JD-Core Version:    0.7.0.1
 */