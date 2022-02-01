package com.tencent.mobileqq.msf.core.net;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class h
{
  public static String F = "";
  private static long G = 0L;
  private static String H;
  public static final String a = "MSF.C.NetConnTag";
  public static final int b = -10008;
  public static final int c = 300000;
  public static final int e = 302;
  static CopyOnWriteArraySet f = new CopyOnWriteArraySet();
  public static byte r = -1;
  AtomicBoolean A = new AtomicBoolean(false);
  int B = 0;
  boolean C = false;
  boolean D = false;
  long E = 0L;
  Runnable d = null;
  MsfCore g;
  public com.tencent.mobileqq.msf.core.net.a.m h;
  protected g i = null;
  String j = "";
  String[] k = null;
  String[] l = null;
  long m = 0L;
  ArrayList n = new ArrayList();
  long o = 0L;
  long p = 0L;
  long q = 0L;
  public int s = 2;
  ArrayList t = new ArrayList();
  ArrayList u = new ArrayList();
  Thread v = null;
  long w = 0L;
  boolean x = false;
  Thread y = null;
  long z = 0L;
  
  static
  {
    G = -1L;
    H = "UTF-8";
  }
  
  public h(MsfCore paramMsfCore)
  {
    this.g = paramMsfCore;
    this.i = new g(paramMsfCore, true);
    this.h = new com.tencent.mobileqq.msf.core.net.a.i(paramMsfCore);
  }
  
  private a a(ArrayList paramArrayList, boolean paramBoolean, com.tencent.mobileqq.msf.core.d paramd)
  {
    a locala = new a();
    locala.i = System.currentTimeMillis();
    locala.b = paramd.a();
    locala.g = NetConnInfoCenterImpl.getSystemNetworkType();
    locala.j = 0;
    locala.k = 0;
    locala.l = 0;
    locala.m = 0;
    a(paramd, paramBoolean, locala);
    paramArrayList.add(locala);
    return locala;
  }
  
  static void a()
  {
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.setUseSimpleHead((String)localIterator.next(), false);
    }
    f.clear();
  }
  
  private void a(com.tencent.mobileqq.msf.core.d paramd, boolean paramBoolean, a parama)
  {
    if (paramd.b().equalsIgnoreCase("http")) {
      this.i.a(paramd, 2048, 10000, new b(this.g), paramBoolean, parama);
    }
    for (;;)
    {
      F = parama.f;
      return;
      this.i.a(paramd, 2048, 10000, new p(this.g), paramBoolean, parama);
    }
  }
  
  static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      f.add(paramString);
    }
    for (;;)
    {
      CodecWarpper.setUseSimpleHead(paramString, paramBoolean);
      return;
      f.remove(paramString);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    long l1 = SystemClock.elapsedRealtime();
    StringBuffer localStringBuffer;
    if ((this.m == 0L) || (l1 - this.m > Long.parseLong(com.tencent.mobileqq.msf.core.a.a.h())))
    {
      this.m = l1;
      localStringBuffer = new StringBuffer();
      com.tencent.mobileqq.msf.core.d locald;
      if (NetConnInfoCenterImpl.isWifiConn())
      {
        localIterator = this.g.getSsoListManager().h().iterator();
        while (localIterator.hasNext())
        {
          locald = (com.tencent.mobileqq.msf.core.d)localIterator.next();
          localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.d() + ",");
        }
      }
      Iterator localIterator = this.g.getSsoListManager().i().iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mobileqq.msf.core.d)localIterator.next();
        localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.d() + ",");
      }
    }
    try
    {
      this.g.configManager.a(this.g.sender.i(), this.g.sender.h(), 60000L, NetConnInfoCenterImpl.isWifiConn(), localStringBuffer.toString(), paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.NetConnTag", 2, localException.toString(), localException);
    }
  }
  
  private boolean a(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "NetChanged selectAndConnect...");
    }
    int i1 = 1;
    int i6;
    int i5;
    int i2;
    int i3;
    label64:
    long l1;
    label297:
    int i4;
    label376:
    Object localObject2;
    for (;;)
    {
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "NetChanged start connect...");
        }
        i6 = 0;
        int i7 = 0;
        i5 = 0;
        i2 = i6;
        for (;;)
        {
          try
          {
            if (v())
            {
              i1 = 0;
              i3 = 0;
              i2 = i6;
              if (i3 >= paramCopyOnWriteArrayList1.size()) {
                break label1490;
              }
              i2 = i6;
              localObject1 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList1.get(i3);
              if (i3 == 0)
              {
                i2 = i6;
                l1 = SystemClock.elapsedRealtime();
                i2 = i6;
                r = com.tencent.mobileqq.msf.core.c.m.a(false, G, l1);
              }
              i2 = i6;
              localObject1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject1);
              i2 = i6;
              if (((a)localObject1).e == q.c)
              {
                i2 = i6;
                if (!this.A.get()) {
                  break label1496;
                }
                i2 = i6;
                this.A.set(false);
                break label1496;
              }
              i2 = i6;
              if (((a)localObject1).e == q.m)
              {
                i3 -= 1;
                i2 = i1 + 1;
                i1 = i2;
                if (i2 > 3)
                {
                  i2 = i6;
                  this.A.set(false);
                  return false;
                }
              }
              else
              {
                i2 = i6;
                if (((a)localObject1).e != q.t)
                {
                  i2 = i6;
                  if (((a)localObject1).e != q.q) {
                    break label1498;
                  }
                }
                if (i3 != 0) {
                  break label1498;
                }
                i2 = i6;
                if (this.A.get()) {
                  break label1498;
                }
                i2 = i6;
                b(((a)localObject1).b);
                break label1498;
              }
              i2 = i6;
              if (((a)localObject1).h <= 0) {
                break label1507;
              }
              i2 = i6;
              Thread.sleep(((a)localObject1).h);
              i2 = i6;
              if (v()) {
                break label1507;
              }
              i2 = i6;
              if (!QLog.isColorLevel()) {
                break label1501;
              }
              i2 = i6;
              QLog.d("MSF.C.NetConnTag", 2, "NetChanged from wifi to mobile connect again");
              break label1501;
            }
            i2 = i6;
            if (u() == null) {
              break label1066;
            }
            i1 = 0;
            i4 = 0;
            i2 = i6;
            i3 = i7;
            if (i4 >= paramCopyOnWriteArrayList2.size()) {
              break label1518;
            }
            i2 = i6;
            Object localObject1 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4);
            if (i4 == 0)
            {
              i2 = i6;
              l1 = SystemClock.elapsedRealtime();
              i2 = i6;
              r = com.tencent.mobileqq.msf.core.c.m.a(false, G, l1);
            }
            i2 = i6;
            if (((com.tencent.mobileqq.msf.core.d)localObject1).g != 1) {
              break label1535;
            }
            i2 = i6;
            localObject1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject1);
            i2 = i6;
            if (((a)localObject1).e == q.c)
            {
              i2 = i6;
              if (!this.A.get()) {
                break label1516;
              }
              i2 = i6;
              this.A.set(false);
              break label1516;
            }
            i2 = i6;
            if (((a)localObject1).e == q.m)
            {
              i5 = i4 - 1;
              i1 += 1;
              i3 = i1;
              if (i1 <= 3) {
                continue;
              }
              i3 = i7;
              break label1518;
              i1 = i3;
              i2 = i3;
              if (i4 >= paramCopyOnWriteArrayList2.size()) {
                break;
              }
              i2 = i3;
              localObject1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4));
              i2 = i3;
              if (((a)localObject1).e != q.c) {
                continue;
              }
              i2 = i3;
              if (!this.A.get()) {
                break label1527;
              }
              i2 = i3;
              this.A.set(false);
              break label1527;
            }
            i2 = i6;
            if (((a)localObject1).e != q.t)
            {
              i5 = i4;
              i3 = i1;
              i2 = i6;
              if (((a)localObject1).e != q.q) {}
            }
            else
            {
              i5 = i4;
              i3 = i1;
              if (i4 == 0)
              {
                i5 = i4;
                i3 = i1;
                i2 = i6;
                if (!this.A.get())
                {
                  i2 = i6;
                  b(((a)localObject1).b);
                  i3 = i1;
                  i5 = i4;
                }
              }
            }
            i4 = i3;
            i2 = i6;
            i3 = i5;
            i1 = i4;
            if (((a)localObject1).h <= 0) {
              break label1539;
            }
            i2 = i6;
            Thread.sleep(((a)localObject1).h);
            i2 = i6;
            i3 = i5;
            i1 = i4;
            if (!v()) {
              break label1539;
            }
            i2 = i6;
            if (!QLog.isColorLevel()) {
              break label1529;
            }
            i2 = i6;
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
            break label1529;
            i2 = i3;
            if (((a)localObject1).e == q.m)
            {
              i4 -= 1;
              i2 = i5 + 1;
              i1 = i2;
              if (i2 > 3)
              {
                i2 = i3;
                this.A.set(false);
                return false;
              }
            }
            else
            {
              i2 = i3;
              if (((a)localObject1).e != q.t)
              {
                i2 = i3;
                if (((a)localObject1).e != q.q) {
                  break label1548;
                }
              }
              if (i4 != 0) {
                break label1548;
              }
              i2 = i3;
              if (this.A.get()) {
                break label1548;
              }
              i2 = i3;
              b(((a)localObject1).b);
              break label1548;
            }
            label929:
            i2 = i3;
            if (((a)localObject1).h <= 0) {
              break label1053;
            }
            i2 = i3;
            Thread.sleep(((a)localObject1).h);
            i2 = i3;
            if (!v()) {
              break label1053;
            }
            i4 = 1;
            i3 = 1;
            i1 = i3;
            i2 = i4;
            if (!QLog.isColorLevel()) {
              break;
            }
            i2 = i4;
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
            i1 = i3;
          }
          catch (Exception localException)
          {
            i1 = i2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.C.NetConnTag", 2, "selectAndConnect error " + localException, localException);
          i1 = i2;
          break;
          label1053:
          i4 += 1;
          i5 = i1;
        }
        label1066:
        i3 = 0;
        i4 = 0;
        label1072:
        i1 = i5;
        i2 = i6;
        if (i4 < paramCopyOnWriteArrayList2.size())
        {
          i2 = i6;
          localObject2 = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4);
          if (i4 == 0)
          {
            i2 = i6;
            l1 = SystemClock.elapsedRealtime();
            i2 = i6;
            r = com.tencent.mobileqq.msf.core.c.m.a(false, G, l1);
          }
          i2 = i6;
          localObject2 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject2);
          i2 = i6;
          if (((a)localObject2).e == q.c)
          {
            i2 = i6;
            if (!this.A.get()) {
              break label1555;
            }
            i2 = i6;
            this.A.set(false);
            break label1555;
          }
          i2 = i6;
          if (((a)localObject2).e == q.m)
          {
            i1 = i4 - 1;
            i2 = i3 + 1;
            i3 = i1;
            i1 = i2;
            if (i2 > 3)
            {
              i2 = i6;
              this.A.set(false);
              return false;
            }
          }
          else
          {
            i2 = i6;
            if (((a)localObject2).e != q.t)
            {
              i2 = i6;
              if (((a)localObject2).e != q.q) {
                break label1557;
              }
            }
            if (i4 != 0) {
              break label1557;
            }
            i2 = i6;
            if (this.A.get()) {
              break label1557;
            }
            i2 = i6;
            b(((a)localObject2).b);
            break label1557;
          }
        }
      }
    }
    for (;;)
    {
      i2 = i6;
      if (((a)localObject2).h > 0)
      {
        i2 = i6;
        Thread.sleep(((a)localObject2).h);
        i2 = i6;
        if (v())
        {
          i2 = i6;
          if (QLog.isColorLevel())
          {
            i2 = i6;
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
          }
          i1 = 1;
          break;
        }
      }
      i4 = i3 + 1;
      i3 = i1;
      break label1072;
      if ((this.A.get()) && (this.C) && (!this.D) && (this.u.size() > 0))
      {
        this.A.set(false);
        this.C = false;
        this.D = false;
        l1 = System.currentTimeMillis();
        long l2 = this.E;
        this.g.getStatReporter().a(b(), this.B, l1 - l2, this.u);
        this.u.clear();
      }
      return false;
      label1490:
      i1 = 0;
      break label1504;
      label1496:
      return true;
      label1498:
      break label297;
      label1501:
      i1 = 1;
      label1504:
      break;
      label1507:
      i3 += 1;
      break label64;
      label1516:
      return true;
      for (;;)
      {
        label1518:
        i5 = 0;
        i4 = 0;
        break;
        label1527:
        return true;
        label1529:
        i3 = 1;
      }
      label1535:
      i3 = i4;
      label1539:
      i4 = i3 + 1;
      break label376;
      label1548:
      i1 = i5;
      break label929;
      label1555:
      return true;
      label1557:
      i1 = i3;
      i3 = i4;
    }
  }
  
  /* Error */
  private static void b(Context paramContext)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 16
    //   12: iconst_2
    //   13: ldc_w 421
    //   16: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 427	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc_w 429
    //   26: invokevirtual 435	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_2
    //   34: new 437	java/io/FileOutputStream
    //   37: dup
    //   38: new 288	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 441	android/content/Context:getFilesDir	()Ljava/io/File;
    //   49: invokevirtual 446	java/io/File:getParent	()Ljava/lang/String;
    //   52: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 448
    //   58: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 450	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: astore_0
    //   68: sipush 1024
    //   71: newarray byte
    //   73: astore_3
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual 456	java/io/InputStream:read	([B)I
    //   79: istore_1
    //   80: iload_1
    //   81: ifle +85 -> 166
    //   84: aload_0
    //   85: aload_3
    //   86: iconst_0
    //   87: iload_1
    //   88: invokevirtual 462	java/io/OutputStream:write	([BII)V
    //   91: goto -17 -> 74
    //   94: astore_3
    //   95: invokestatic 338	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +30 -> 128
    //   101: ldc 16
    //   103: iconst_2
    //   104: new 288	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 464
    //   114: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_3
    //   118: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_3
    //   125: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 467	java/io/InputStream:close	()V
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 468	java/io/OutputStream:close	()V
    //   144: return
    //   145: astore_0
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 467	java/io/InputStream:close	()V
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 468	java/io/OutputStream:close	()V
    //   164: aload_0
    //   165: athrow
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 467	java/io/InputStream:close	()V
    //   174: aload_0
    //   175: ifnull -31 -> 144
    //   178: goto -38 -> 140
    //   181: astore_0
    //   182: goto -34 -> 148
    //   185: astore 4
    //   187: aload_0
    //   188: astore_3
    //   189: aload 4
    //   191: astore_0
    //   192: goto -44 -> 148
    //   195: astore 4
    //   197: aload_0
    //   198: astore_3
    //   199: aload 4
    //   201: astore_0
    //   202: goto -54 -> 148
    //   205: astore_3
    //   206: aconst_null
    //   207: astore_0
    //   208: goto -113 -> 95
    //   211: astore_3
    //   212: aconst_null
    //   213: astore_0
    //   214: goto -119 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramContext	Context
    //   79	9	1	i1	int
    //   3	168	2	localObject1	Object
    //   1	85	3	arrayOfByte	byte[]
    //   94	67	3	localException1	Exception
    //   188	11	3	localContext	Context
    //   205	1	3	localException2	Exception
    //   211	1	3	localException3	Exception
    //   29	3	4	localInputStream	java.io.InputStream
    //   185	5	4	localObject2	Object
    //   195	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   68	74	94	java/lang/Exception
    //   74	80	94	java/lang/Exception
    //   84	91	94	java/lang/Exception
    //   19	31	145	finally
    //   34	68	181	finally
    //   68	74	185	finally
    //   74	80	185	finally
    //   84	91	185	finally
    //   95	128	195	finally
    //   19	31	205	java/lang/Exception
    //   34	68	211	java/lang/Exception
  }
  
  public static boolean h()
  {
    return i() != null;
  }
  
  public static String i()
  {
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream()));
      localObject = localBufferedReader.readLine().split("\\s+");
      i4 = localObject.length;
      i2 = 0;
      i3 = 1;
      i1 = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        BufferedReader localBufferedReader;
        Object localObject;
        int i4;
        int i2;
        int i3;
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetConnTag", 2, "Error killing tcpdump, msg=" + localIOException.getMessage());
          continue;
          i2 += 1;
          i1 += 1;
        }
      }
    }
    if (i2 < i4)
    {
      if (localObject[i2].equalsIgnoreCase("PID")) {
        i3 = i1;
      }
    }
    else
    {
      do
      {
        localObject = localBufferedReader.readLine();
        if (localObject == null) {
          break;
        }
      } while ((!((String)localObject).contains(BaseApplication.getContext().getFilesDir().getParent() + "/txlib/tcpdump")) || (((String)localObject).contains("sh -c")));
      localObject = ((String)localObject).split("\\s+");
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump uid:" + localObject[i3]);
      }
      localBufferedReader.close();
      return localObject[i3];
      localBufferedReader.close();
      return null;
    }
  }
  
  public static void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump begin");
    }
    try
    {
      Object localObject = i();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump pid not find");
        }
      }
      else
      {
        localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "su", "-c", "kill " + (String)localObject }).getErrorStream()));
        for (;;)
        {
          String str = ((BufferedReader)localObject).readLine();
          if (str == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "tcpdump kill error=" + str);
          }
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump Error killing tcpdump, msg=" + localIOException.getMessage());
        return;
        localIOException.close();
      }
    }
  }
  
  private String u()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getDefaultHost();
  }
  
  private boolean v()
  {
    return (NetConnInfoCenterImpl.isWifiConn()) || ((!NetConnInfoCenterImpl.isWifiOrMobileConn()) && (NetConnInfoCenterImpl.getCurrentAPN() == null));
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.i.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    long l3 = 0L;
    long l1;
    if (this.o != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "firstResponseGetted getted Report now");
      }
      l1 = -1L;
      if (this.p >= this.o) {
        l1 = this.p - this.o;
      }
      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "from msg TIMESTAMP_NET2MSF not find return");
        }
        c();
      }
    }
    else
    {
      return;
    }
    long l5 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue();
    long l6 = this.p;
    long l2;
    if (paramToServiceMsg.getAttribute("__timestamp_msf2net") == null)
    {
      l2 = l3;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, "to msg TIMESTAMP_MSF2NET not find set nFirstPacketTimeElapse to 0");
        l2 = l3;
      }
    }
    for (;;)
    {
      boolean bool = false;
      if (paramFromServiceMsg.getServiceCmd().equals("login.auth")) {
        bool = true;
      }
      if (this.n.size() > 0)
      {
        paramFromServiceMsg = (a)this.n.get(this.n.size() - 1);
        paramFromServiceMsg.m = 1;
        paramFromServiceMsg.l = 1;
        this.g.getStatReporter().a(true, l1, l5 - l6, l2, bool, this.n, this.s);
      }
      c();
      NetConnInfoCenter.onRecvFirstResp();
      return;
      l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
      long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - l2;
      if ((l4 < 0L) || (l2 == 0L))
      {
        l2 = l3;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetConnTag", 2, "nFirstPacketTimeElapse:" + l4 + " reset 0 now TIMESTAMP_NET2MSF:" + this.g.timeFormatter.format(paramFromServiceMsg.getAttribute("__timestamp_net2msf")) + " TIMESTAMP_MSF2NET:" + this.g.timeFormatter.format(paramToServiceMsg.getAttribute("__timestamp_msf2net")));
          l2 = l3;
        }
      }
      else
      {
        l2 = l4;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      this.j = paramString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = true;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new i(this, paramString, paramInt);
    paramString.setName("checkNetConnectBySocketThread");
    paramString.start();
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.k = paramArrayOfString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = false;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, MsfCommand paramMsfCommand, String paramString3, int paramInt3, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
    throws Exception
  {
    byte[] arrayOfByte;
    if (!this.i.s.get())
    {
      G = SystemClock.elapsedRealtime();
      f();
      arrayOfByte = this.g.sender.e(paramToServiceMsg);
      QLog.d("MSF.C.NetConnTag", 1, "p ok re1: " + paramToServiceMsg.getRequestSsoSeq());
    }
    for (;;)
    {
      paramArrayOfByte = null;
      if (paramToServiceMsg.getAttributes().containsKey("infoLoginMsg")) {
        paramArrayOfByte = (ToServiceMsg)paramToServiceMsg.getAttributes().get("infoLoginMsg");
      }
      int i1;
      for (;;)
      {
        i1 = this.i.a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte);
        if (i1 != -100) {
          break label288;
        }
        f();
        arrayOfByte = this.g.sender.e(paramToServiceMsg);
        QLog.d("MSF.C.NetConnTag", 1, "p ok re2: " + paramToServiceMsg.getRequestSsoSeq());
        if (this.i.a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, arrayOfByte, paramArrayOfByte) != -100) {
          break;
        }
        return false;
        if ("RegPrxySvc.infoLogin".equals(paramToServiceMsg.getServiceCmd())) {
          paramArrayOfByte = paramToServiceMsg;
        } else if ("RegPrxySvc.getOffMsg".equals(paramToServiceMsg.getServiceCmd())) {
          paramArrayOfByte = paramToServiceMsg;
        }
      }
      if ((this.q == 0L) && (this.o != 0L) && (this.p != 0L)) {
        this.q = System.currentTimeMillis();
      }
      return true;
      label288:
      if (i1 == -200) {
        return true;
      }
      if ((this.q == 0L) && (this.o != 0L) && (this.p != 0L)) {
        this.q = System.currentTimeMillis();
      }
      return true;
      arrayOfByte = paramArrayOfByte;
    }
  }
  
  public void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.w > 180000L)
    {
      this.w = l1;
      m();
      a("3gimg.qq.com", 80);
      a("120.33.50.146", 80);
      g();
      c(paramString.split(":")[0].trim());
    }
  }
  
  public void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      this.l = paramArrayOfString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = false;
    }
  }
  
  public boolean b()
  {
    return this.i.s.get();
  }
  
  public void c()
  {
    this.q = 0L;
    this.o = 0L;
    this.p = 0L;
    this.n.clear();
    this.s = 2;
    if (this.d != null)
    {
      this.g.getMsfAlarmer().a(this.d);
      this.d = null;
    }
  }
  
  public void c(String paramString)
  {
    paramString = new n(this, paramString);
    paramString.setName("pingServerThread");
    paramString.start();
  }
  
  public void d()
  {
    long l1;
    if (this.o != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut Report now");
      }
      if (this.p < this.o) {
        break label169;
      }
      if (this.q == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut. m_firstPacketSendTimeAfterConnect == 0");
        }
        c();
        return;
      }
      l1 = this.p - this.o;
      this.g.sender.a.h.c();
    }
    for (;;)
    {
      this.g.getStatReporter().a(false, l1, -1L, -1L, false, this.n, this.s);
      c();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut m_startConnectTime : " + this.o + "no need Report");
      }
      c();
      return;
      label169:
      l1 = -1L;
    }
  }
  
  public void e()
  {
    if (this.n.size() > 0)
    {
      a locala = (a)this.n.get(this.n.size() - 1);
      if (locala != null)
      {
        locala.e = q.y;
        locala.d = false;
        locala.l = 0;
        locala.m = 1;
      }
    }
  }
  
  protected boolean f()
    throws Exception
  {
    if (((this.k != null) && (this.k.length > 0)) || ((this.l != null) && (this.l.length > 0))) {}
    Object localObject3;
    long l1;
    boolean bool1;
    label744:
    do
    {
      do
      {
        int i1;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "start to connect lmassigned server " + Arrays.toString(this.k) + " " + Arrays.toString(this.l));
          }
          this.o = System.currentTimeMillis();
          this.p = this.o;
          CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
          localObject2 = new CopyOnWriteArrayList();
          int i2;
          if (this.k != null)
          {
            localObject3 = this.k;
            i2 = localObject3.length;
            i1 = 0;
            while (i1 < i2)
            {
              ((CopyOnWriteArrayList)localObject2).add(com.tencent.mobileqq.msf.core.d.a(localObject3[i1]));
              i1 += 1;
            }
          }
          if (this.l != null)
          {
            localObject3 = this.l;
            i2 = localObject3.length;
            i1 = 0;
            while (i1 < i2)
            {
              localCopyOnWriteArrayList.add(com.tencent.mobileqq.msf.core.d.a(localObject3[i1]));
              i1 += 1;
            }
          }
          bool2 = a(localCopyOnWriteArrayList, (CopyOnWriteArrayList)localObject2, new ArrayList(), false);
          if (bool2) {
            return bool2;
          }
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + Arrays.toString(this.k) + " " + Arrays.toString(this.l) + " error " + localException1, localException1);
          }
        }
        if (this.j.length() > 0) {
          try
          {
            this.o = System.currentTimeMillis();
            this.p = this.o;
            a locala = new a();
            locala.b = this.j;
            locala.g = NetConnInfoCenterImpl.getSystemNetworkType();
            locala.j = 0;
            locala.k = 0;
            locala.l = 0;
            locala.m = 0;
            a(com.tencent.mobileqq.msf.core.d.a(this.j), true, locala);
            return true;
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + this.j + " error " + localException2, localException2);
            }
            return false;
          }
        }
        long l2 = SystemClock.elapsedRealtime();
        l1 = 0L;
        localObject1 = new ArrayList();
        this.o = System.currentTimeMillis();
        this.p = this.o;
        if ((this.g.getSsoListManager().h().size() > 0) || (this.g.getSsoListManager().i().size() > 0))
        {
          bool1 = a(this.g.getSsoListManager().h(), this.g.getSsoListManager().i(), (ArrayList)localObject1, false);
          l1 = SystemClock.elapsedRealtime() - l2;
          i1 = 1;
          localObject2 = ((ArrayList)localObject1).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label744;
          }
          localObject3 = (a)((Iterator)localObject2).next();
          if ((((a)localObject3).e == q.m) || (((a)localObject3).e == q.s) || (((a)localObject3).e == q.i) || (((a)localObject3).e == q.o) || (((a)localObject3).e == q.p) || (((a)localObject3).e == q.q) || (((a)localObject3).e == q.y))
          {
            c();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "sso list is null.");
            }
            bool1 = false;
            i1 = 0;
            break;
          }
          if (this.o == 0L)
          {
            this.o = ((a)localObject3).i;
            this.p = this.o;
          }
          if (this.d == null) {
            this.d = this.g.getMsfAlarmer().a(this, 300000L);
          }
          this.n.add(localObject3);
        }
        if (bool1) {
          break label1078;
        }
        l1 = SystemClock.elapsedRealtime();
        if ((NetConnInfoCenterImpl.isWifiOrMobileConn()) && (i1 != 0))
        {
          a(true);
          this.g.getStatReporter().a(false, false, false, l1 - l2, (ArrayList)localObject1);
        }
        NetConnInfoCenter.onOepnConnAllFailed();
        l1 = System.currentTimeMillis();
        if ((!NetConnInfoCenterImpl.isWifiConn()) && ((NetConnInfoCenterImpl.isWifiOrMobileConn()) || (NetConnInfoCenterImpl.getCurrentAPN() != null))) {
          break;
        }
        bool2 = bool1;
      } while (l1 - com.tencent.mobileqq.msf.core.a.a.F >= 60000L);
      localObject1 = new StringBuffer();
      localObject2 = this.g.getSsoListManager().h().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
        }
      }
      localObject1 = ((StringBuffer)localObject1).toString();
      this.g.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.a.F, (String)localObject1);
      com.tencent.mobileqq.msf.core.a.a.F = 0L;
      return bool1;
      boolean bool2 = bool1;
    } while (l1 - com.tencent.mobileqq.msf.core.a.a.G >= 60000L);
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.g.getSsoListManager().i().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next();
      if (localObject3 != null) {
        ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject3).toString() + ";");
      }
    }
    localObject1 = ((StringBuffer)localObject1).toString();
    this.g.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.a.G, (String)localObject1);
    com.tencent.mobileqq.msf.core.a.a.G = 0L;
    return bool1;
    label1078:
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    if (!NetConnInfoCenterImpl.isWifiOrMobileConn()) {
      NetConnInfoCenterImpl.setLastConnSuccWithoutNet();
    }
    if (NetConnInfoCenterImpl.isWifiOrMobileConn()) {
      this.g.getStatReporter().a(false, false, bool1, l1, (ArrayList)localObject1);
    }
    return true;
  }
  
  public void g()
  {
    if (this.v != null) {}
    do
    {
      do
      {
        return;
      } while (com.tencent.mobileqq.msf.core.a.a.G() == 0);
      localObject1 = com.tencent.mobileqq.msf.core.a.a.F();
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.NetConnTag", 2, "TcpdumpSSOVip is empty");
    return;
    this.t.clear();
    Object localObject1 = ((String)localObject1).split(";");
    int i2 = localObject1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = localObject1[i1];
      a locala = new a();
      locala.a = localObject2;
      locala.b = 1;
      locala.c = "";
      this.t.add(locala);
      i1 += 1;
    }
    this.v = new j(this);
    this.v.setName("checkNetConnectByConnectSSOThread");
    this.v.start();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report begin");
    }
    if (this.y != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump tcpDumpReportThread started return");
      }
      return;
    }
    this.y = new k(this);
    this.y.setName("tcpDumpReportThread");
    this.y.start();
  }
  
  public void l()
  {
    if (h())
    {
      if (System.currentTimeMillis() - this.z > 120000L) {
        j();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump is running return");
      }
      return;
    }
    m localm = new m(this);
    localm.setName("tcpDumpThread");
    localm.start();
  }
  
  public void m()
  {
    o localo = new o(this);
    localo.setName("checkNetConnectByHttpThread");
    localo.start();
    this.A.set(true);
  }
  
  public g n()
  {
    return this.i;
  }
  
  public String o()
  {
    return this.j;
  }
  
  public String[] p()
  {
    return this.k;
  }
  
  public String[] q()
  {
    return this.l;
  }
  
  public InetSocketAddress r()
  {
    return this.i.c;
  }
  
  public boolean s()
  {
    return (b()) && (this.o == 0L);
  }
  
  public class a
  {
    public String a = "";
    public byte b = 1;
    public String c = "";
    
    public a() {}
    
    public void a()
    {
      this.b = 1;
      this.c = "";
      Object localObject = this.a;
      if (localObject == null) {}
      for (;;)
      {
        return;
        String str = localObject.split(":")[0].trim();
        int i = Integer.parseInt(localObject.split(":")[1].trim());
        this.b = 2;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "start send checkNetConnectByConnectSSO server:" + str + " port:" + i);
          }
          localObject = new Socket();
          InetSocketAddress localInetSocketAddress = new InetSocketAddress(str, i);
          ((Socket)localObject).setSoTimeout(10000);
          ((Socket)localObject).setTcpNoDelay(true);
          ((Socket)localObject).setKeepAlive(true);
          ((Socket)localObject).connect(localInetSocketAddress, 10000);
          this.b = 3;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO connect server:" + str + " port:" + i + " success");
          }
          ((Socket)localObject).close();
          return;
        }
        catch (Throwable localThrowable)
        {
          if (localThrowable != null) {
            this.c = localThrowable.toString().toLowerCase();
          }
          if (this.c.indexOf("timeoutexception") > -1) {
            break label235;
          }
        }
        if (this.c.indexOf(") after") > -1) {}
        label235:
        for (this.b = 5; QLog.isColorLevel(); this.b = 4)
        {
          QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO Throwable connect server:" + str + " port:" + i + " failed" + localThrowable, localThrowable);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.h
 * JD-Core Version:    0.7.0.1
 */