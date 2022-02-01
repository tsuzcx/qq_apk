package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.i;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class g
{
  public static final int a = -100;
  public static final int b = -200;
  public static ArrayList n = new ArrayList();
  private AtomicInteger A = new AtomicInteger();
  private long B = 0L;
  protected InetSocketAddress c;
  d d;
  int e;
  int f = 30000;
  public Socket g;
  OutputStream h = null;
  c i;
  a j;
  MsfSocketInputBuffer k = null;
  public String l = "";
  public int m = 0;
  AtomicLong o = new AtomicLong();
  AtomicLong p = new AtomicLong();
  long q = 0L;
  boolean r = false;
  AtomicBoolean s = new AtomicBoolean();
  AtomicBoolean t = new AtomicBoolean();
  ReentrantLock u = new ReentrantLock();
  boolean v;
  ToServiceMsg w;
  Runnable x;
  MsfCore y;
  public d z;
  
  public g(MsfCore paramMsfCore, boolean paramBoolean)
  {
    this.y = paramMsfCore;
    this.v = paramBoolean;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, MsfCommand paramMsfCommand, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
    throws IOException
  {
    if ((this.t.get()) || (!this.s.get()) || (this.i == null)) {
      return -100;
    }
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      paramMsfCommand = this.i.a(this.d, paramString1, paramString2, paramArrayOfByte);
      if (paramString2.equals("SSO.LoginMerge"))
      {
        if (!this.y.sender.l)
        {
          paramString1 = (ArrayList)this.y.sender.f().remove(Integer.valueOf(paramInt3));
          QLog.d("MSF.C.NetConnTag", 1, "NetChanged devide merge package, " + Arrays.toString(paramString1.toArray()) + " resend.");
          if (paramString1 != null)
          {
            paramString1 = paramString1.iterator();
            while (paramString1.hasNext())
            {
              paramString2 = (Integer)paramString1.next();
              paramString2 = this.y.sender.c(paramString2.intValue());
              this.y.sender.b(paramString2);
            }
          }
          return -200;
        }
        if (paramToServiceMsg != null) {
          this.y.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        this.h.write(paramMsfCommand);
        this.h.flush();
        this.o.addAndGet(paramMsfCommand.length);
        paramToServiceMsg = new StringBuilder();
        if (!QLog.isDevelopLevel()) {
          break label441;
        }
        QLog.d("MSF.C.NetConnTag", 1, "netSend appid:" + paramInt1 + " appSeq:" + paramInt2 + " ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2 + " len:" + paramArrayOfByte.length);
      }
      for (;;)
      {
        if (!paramString2.equals("SSO.LoginMerge")) {
          break label520;
        }
        return paramArrayOfByte.length;
        if (paramString2.equals("RegPrxySvc.infoLogin"))
        {
          this.y.sender.a(paramToServiceMsg, this.g.hashCode());
          break;
        }
        if (!paramString2.equals("RegPrxySvc.getOffMsg")) {
          break;
        }
        this.y.sender.a(paramToServiceMsg, this.g.hashCode());
        break;
        label441:
        QLog.d("MSF.C.NetConnTag", 1, "netSend ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2.hashCode() + new StringBuilder().append(" ").append(paramArrayOfByte.length + paramInt3).toString());
      }
      label520:
      if (paramString3 == null) {
        i.a(true, paramString1, paramMsfCommand.length, paramString2, 0, this.l, this.m);
      } else {
        i.a(true, paramString1, paramMsfCommand.length, paramString3, 0, this.l, this.m);
      }
    }
  }
  
  /* Error */
  public void a(d paramd, int paramInt1, int paramInt2, c paramc, boolean paramBoolean, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/tencent/mobileqq/msf/core/net/g:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifne +13 -> 20
    //   10: aload_0
    //   11: getfield 100	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   17: ifne +28 -> 45
    //   20: aload_0
    //   21: getfield 102	com/tencent/mobileqq/msf/core/net/g:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   27: ifeq +18 -> 45
    //   30: aload_0
    //   31: getfield 102	com/tencent/mobileqq/msf/core/net/g:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: iconst_0
    //   35: invokevirtual 314	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   38: aload_0
    //   39: getstatic 319	com/tencent/qphone/base/a:f	Lcom/tencent/qphone/base/a;
    //   42: invokevirtual 322	com/tencent/mobileqq/msf/core/net/g:a	(Lcom/tencent/qphone/base/a;)V
    //   45: aload_0
    //   46: getfield 324	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   49: ifnull +22 -> 71
    //   52: aload_0
    //   53: invokevirtual 327	com/tencent/mobileqq/msf/core/net/g:e	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   56: pop
    //   57: aload_0
    //   58: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   61: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   64: aload_0
    //   65: getfield 329	com/tencent/mobileqq/msf/core/net/g:x	Ljava/lang/Runnable;
    //   68: invokevirtual 332	com/tencent/mobileqq/msf/core/s:a	(Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield 158	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   76: aload_0
    //   77: aload 4
    //   79: putfield 150	com/tencent/mobileqq/msf/core/net/g:i	Lcom/tencent/mobileqq/msf/core/net/c;
    //   82: aload_0
    //   83: iload 5
    //   85: putfield 95	com/tencent/mobileqq/msf/core/net/g:r	Z
    //   88: aload_0
    //   89: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   92: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   95: aload_1
    //   96: invokevirtual 336	com/tencent/mobileqq/msf/core/d:h	()Z
    //   99: putfield 181	com/tencent/mobileqq/msf/core/s:l	Z
    //   102: getstatic 341	com/tencent/mobileqq/msf/core/net/q:b	Lcom/tencent/mobileqq/msf/core/net/q;
    //   105: astore 20
    //   107: ldc 75
    //   109: astore 21
    //   111: aload_0
    //   112: lconst_0
    //   113: putfield 93	com/tencent/mobileqq/msf/core/net/g:q	J
    //   116: aload_0
    //   117: getfield 107	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   120: ldc2_w 342
    //   123: getstatic 349	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   126: invokevirtual 353	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   129: ifeq +1749 -> 1878
    //   132: invokestatic 359	android/os/SystemClock:elapsedRealtime	()J
    //   135: lstore 15
    //   137: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   140: lstore 7
    //   142: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   145: pop2
    //   146: lload 7
    //   148: lstore 9
    //   150: aload 21
    //   152: astore 18
    //   154: aload 20
    //   156: astore 17
    //   158: aload 21
    //   160: astore 19
    //   162: aload 20
    //   164: astore 4
    //   166: aload_0
    //   167: new 366	java/net/InetSocketAddress
    //   170: dup
    //   171: aload_1
    //   172: invokevirtual 368	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   175: aload_1
    //   176: invokevirtual 370	com/tencent/mobileqq/msf/core/d:d	()I
    //   179: invokespecial 373	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   182: putfield 375	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   185: lload 7
    //   187: lstore 9
    //   189: aload 21
    //   191: astore 18
    //   193: aload 20
    //   195: astore 17
    //   197: aload 21
    //   199: astore 19
    //   201: aload 20
    //   203: astore 4
    //   205: new 200	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   212: astore 23
    //   214: lload 7
    //   216: lstore 9
    //   218: aload 21
    //   220: astore 18
    //   222: aload 20
    //   224: astore 17
    //   226: aload 21
    //   228: astore 19
    //   230: aload 20
    //   232: astore 4
    //   234: new 200	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   241: aload 23
    //   243: ldc_w 377
    //   246: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: getfield 375	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   253: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: astore 24
    //   264: lload 7
    //   266: lstore 9
    //   268: aload 21
    //   270: astore 18
    //   272: aload 20
    //   274: astore 17
    //   276: aload 21
    //   278: astore 19
    //   280: aload 20
    //   282: astore 4
    //   284: aload_1
    //   285: getfield 382	com/tencent/mobileqq/msf/core/d:h	Z
    //   288: ifeq +1591 -> 1879
    //   291: ldc_w 384
    //   294: astore 22
    //   296: lload 7
    //   298: lstore 9
    //   300: aload 21
    //   302: astore 18
    //   304: aload 20
    //   306: astore 17
    //   308: aload 21
    //   310: astore 19
    //   312: aload 20
    //   314: astore 4
    //   316: ldc 198
    //   318: iconst_1
    //   319: aload 24
    //   321: aload 22
    //   323: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: lload 7
    //   334: lstore 9
    //   336: aload 21
    //   338: astore 18
    //   340: aload 20
    //   342: astore 17
    //   344: aload 21
    //   346: astore 19
    //   348: aload 20
    //   350: astore 4
    //   352: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   355: lstore 11
    //   357: lload 11
    //   359: lstore 9
    //   361: aload 21
    //   363: astore 18
    //   365: aload 20
    //   367: astore 17
    //   369: aload 21
    //   371: astore 19
    //   373: aload 20
    //   375: astore 4
    //   377: aload_0
    //   378: lload 11
    //   380: putfield 109	com/tencent/mobileqq/msf/core/net/g:B	J
    //   383: lload 11
    //   385: lstore 9
    //   387: aload 21
    //   389: astore 18
    //   391: aload 20
    //   393: astore 17
    //   395: aload 21
    //   397: astore 19
    //   399: aload 20
    //   401: astore 4
    //   403: aload_0
    //   404: new 386	java/net/Socket
    //   407: dup
    //   408: invokespecial 387	java/net/Socket:<init>	()V
    //   411: putfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   414: lload 11
    //   416: lstore 9
    //   418: aload 21
    //   420: astore 18
    //   422: aload 20
    //   424: astore 17
    //   426: aload 21
    //   428: astore 19
    //   430: aload 20
    //   432: astore 4
    //   434: aload_0
    //   435: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   438: iload_3
    //   439: invokevirtual 391	java/net/Socket:setSoTimeout	(I)V
    //   442: lload 11
    //   444: lstore 9
    //   446: aload 21
    //   448: astore 18
    //   450: aload 20
    //   452: astore 17
    //   454: aload 21
    //   456: astore 19
    //   458: aload 20
    //   460: astore 4
    //   462: aload_0
    //   463: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   466: iconst_1
    //   467: invokevirtual 394	java/net/Socket:setTcpNoDelay	(Z)V
    //   470: lload 11
    //   472: lstore 9
    //   474: aload 21
    //   476: astore 18
    //   478: aload 20
    //   480: astore 17
    //   482: aload 21
    //   484: astore 19
    //   486: aload 20
    //   488: astore 4
    //   490: aload_0
    //   491: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   494: iconst_1
    //   495: invokevirtual 397	java/net/Socket:setKeepAlive	(Z)V
    //   498: lload 11
    //   500: lstore 9
    //   502: aload 21
    //   504: astore 18
    //   506: aload 20
    //   508: astore 17
    //   510: aload 21
    //   512: astore 19
    //   514: aload 20
    //   516: astore 4
    //   518: aload_0
    //   519: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   522: aload_0
    //   523: getfield 375	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   526: aload_1
    //   527: invokevirtual 399	com/tencent/mobileqq/msf/core/d:e	()I
    //   530: invokevirtual 403	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   533: lload 11
    //   535: lstore 9
    //   537: aload 21
    //   539: astore 18
    //   541: aload 20
    //   543: astore 17
    //   545: aload 21
    //   547: astore 19
    //   549: aload 20
    //   551: astore 4
    //   553: aload 6
    //   555: iconst_1
    //   556: putfield 407	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   559: lload 11
    //   561: lstore 9
    //   563: aload 21
    //   565: astore 18
    //   567: aload 20
    //   569: astore 17
    //   571: aload 21
    //   573: astore 19
    //   575: aload 20
    //   577: astore 4
    //   579: aload 6
    //   581: aload 6
    //   583: getfield 409	com/tencent/mobileqq/msf/core/net/a:j	I
    //   586: iconst_1
    //   587: iadd
    //   588: putfield 409	com/tencent/mobileqq/msf/core/net/a:j	I
    //   591: lload 11
    //   593: lstore 9
    //   595: aload 21
    //   597: astore 18
    //   599: aload 20
    //   601: astore 17
    //   603: aload 21
    //   605: astore 19
    //   607: aload 20
    //   609: astore 4
    //   611: aload_0
    //   612: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   615: putfield 93	com/tencent/mobileqq/msf/core/net/g:q	J
    //   618: lload 11
    //   620: lstore 9
    //   622: aload 21
    //   624: astore 18
    //   626: aload 20
    //   628: astore 17
    //   630: aload 21
    //   632: astore 19
    //   634: aload 20
    //   636: astore 4
    //   638: aload_0
    //   639: getfield 93	com/tencent/mobileqq/msf/core/net/g:q	J
    //   642: lload 11
    //   644: lsub
    //   645: lstore 13
    //   647: lload 11
    //   649: lstore 9
    //   651: aload 21
    //   653: astore 18
    //   655: aload 20
    //   657: astore 17
    //   659: aload 21
    //   661: astore 19
    //   663: aload 20
    //   665: astore 4
    //   667: aload_0
    //   668: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   671: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   674: getfield 412	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   677: astore 22
    //   679: lload 11
    //   681: lstore 9
    //   683: aload 21
    //   685: astore 18
    //   687: aload 20
    //   689: astore 17
    //   691: aload 21
    //   693: astore 19
    //   695: aload 20
    //   697: astore 4
    //   699: aload 22
    //   701: aload 22
    //   703: getfield 416	com/tencent/mobileqq/msf/core/net/h:p	J
    //   706: lload 13
    //   708: ladd
    //   709: putfield 416	com/tencent/mobileqq/msf/core/net/h:p	J
    //   712: lload 13
    //   714: lstore 7
    //   716: lload 13
    //   718: lconst_0
    //   719: lcmp
    //   720: ifge +6 -> 726
    //   723: lconst_0
    //   724: lstore 7
    //   726: lload 11
    //   728: lstore 9
    //   730: aload 21
    //   732: astore 18
    //   734: aload 20
    //   736: astore 17
    //   738: aload 21
    //   740: astore 19
    //   742: aload 20
    //   744: astore 4
    //   746: aload_0
    //   747: getfield 93	com/tencent/mobileqq/msf/core/net/g:q	J
    //   750: putstatic 419	com/tencent/mobileqq/msf/core/s:F	J
    //   753: lload 11
    //   755: lstore 9
    //   757: aload 21
    //   759: astore 18
    //   761: aload 20
    //   763: astore 17
    //   765: aload 21
    //   767: astore 19
    //   769: aload 20
    //   771: astore 4
    //   773: aload_0
    //   774: getfield 89	com/tencent/mobileqq/msf/core/net/g:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   777: lconst_0
    //   778: invokevirtual 422	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   781: lload 11
    //   783: lstore 9
    //   785: aload 21
    //   787: astore 18
    //   789: aload 20
    //   791: astore 17
    //   793: aload 21
    //   795: astore 19
    //   797: aload 20
    //   799: astore 4
    //   801: aload_0
    //   802: getfield 91	com/tencent/mobileqq/msf/core/net/g:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   805: lconst_0
    //   806: invokevirtual 422	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   809: lload 11
    //   811: lstore 9
    //   813: aload 21
    //   815: astore 18
    //   817: aload 20
    //   819: astore 17
    //   821: aload 21
    //   823: astore 19
    //   825: aload 20
    //   827: astore 4
    //   829: aload_0
    //   830: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   833: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   836: getfield 424	com/tencent/mobileqq/msf/core/s:y	Ljava/util/concurrent/atomic/AtomicLong;
    //   839: lconst_0
    //   840: invokevirtual 422	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   843: lload 11
    //   845: lstore 9
    //   847: aload 21
    //   849: astore 18
    //   851: aload 20
    //   853: astore 17
    //   855: aload 21
    //   857: astore 19
    //   859: aload 20
    //   861: astore 4
    //   863: aload_0
    //   864: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   867: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   870: getfield 426	com/tencent/mobileqq/msf/core/s:z	Ljava/util/concurrent/atomic/AtomicLong;
    //   873: lconst_0
    //   874: invokevirtual 422	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   877: lload 11
    //   879: lstore 9
    //   881: aload 21
    //   883: astore 18
    //   885: aload 20
    //   887: astore 17
    //   889: aload 21
    //   891: astore 19
    //   893: aload 20
    //   895: astore 4
    //   897: aload_0
    //   898: aload_0
    //   899: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   902: invokevirtual 430	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   905: putfield 71	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   908: lload 11
    //   910: lstore 9
    //   912: aload 21
    //   914: astore 18
    //   916: aload 20
    //   918: astore 17
    //   920: aload 21
    //   922: astore 19
    //   924: aload 20
    //   926: astore 4
    //   928: getstatic 64	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   931: aload_0
    //   932: getfield 71	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   935: invokevirtual 431	java/lang/Object:toString	()Ljava/lang/String;
    //   938: invokevirtual 434	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   941: ifne +37 -> 978
    //   944: lload 11
    //   946: lstore 9
    //   948: aload 21
    //   950: astore 18
    //   952: aload 20
    //   954: astore 17
    //   956: aload 21
    //   958: astore 19
    //   960: aload 20
    //   962: astore 4
    //   964: getstatic 64	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   967: aload_0
    //   968: getfield 71	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   971: invokevirtual 431	java/lang/Object:toString	()Ljava/lang/String;
    //   974: invokevirtual 437	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   977: pop
    //   978: lload 11
    //   980: lstore 9
    //   982: aload 21
    //   984: astore 18
    //   986: aload 20
    //   988: astore 17
    //   990: aload 21
    //   992: astore 19
    //   994: aload 20
    //   996: astore 4
    //   998: aload_0
    //   999: new 439	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   1002: dup
    //   1003: aload_0
    //   1004: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1007: iload_2
    //   1008: ldc_w 441
    //   1011: iconst_m1
    //   1012: invokespecial 444	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   1015: putfield 73	com/tencent/mobileqq/msf/core/net/g:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   1018: lload 11
    //   1020: lstore 9
    //   1022: aload 21
    //   1024: astore 18
    //   1026: aload 20
    //   1028: astore 17
    //   1030: aload 21
    //   1032: astore 19
    //   1034: aload 20
    //   1036: astore 4
    //   1038: aload_0
    //   1039: new 6	com/tencent/mobileqq/msf/core/net/g$a
    //   1042: dup
    //   1043: aload_0
    //   1044: invokespecial 447	com/tencent/mobileqq/msf/core/net/g$a:<init>	(Lcom/tencent/mobileqq/msf/core/net/g;)V
    //   1047: putfield 449	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   1050: lload 11
    //   1052: lstore 9
    //   1054: aload 21
    //   1056: astore 18
    //   1058: aload 20
    //   1060: astore 17
    //   1062: aload 21
    //   1064: astore 19
    //   1066: aload 20
    //   1068: astore 4
    //   1070: aload_0
    //   1071: getfield 449	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   1074: ldc_w 451
    //   1077: invokevirtual 455	com/tencent/mobileqq/msf/core/net/g$a:setName	(Ljava/lang/String;)V
    //   1080: lload 11
    //   1082: lstore 9
    //   1084: aload 21
    //   1086: astore 18
    //   1088: aload 20
    //   1090: astore 17
    //   1092: aload 21
    //   1094: astore 19
    //   1096: aload 20
    //   1098: astore 4
    //   1100: aload_0
    //   1101: getfield 449	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   1104: invokevirtual 458	com/tencent/mobileqq/msf/core/net/g$a:start	()V
    //   1107: lload 11
    //   1109: lstore 9
    //   1111: aload 21
    //   1113: astore 18
    //   1115: aload 20
    //   1117: astore 17
    //   1119: aload 21
    //   1121: astore 19
    //   1123: aload 20
    //   1125: astore 4
    //   1127: aload_0
    //   1128: getfield 100	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1131: iconst_1
    //   1132: invokevirtual 314	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1135: lload 11
    //   1137: lstore 9
    //   1139: aload 21
    //   1141: astore 18
    //   1143: aload 20
    //   1145: astore 17
    //   1147: aload 21
    //   1149: astore 19
    //   1151: aload 20
    //   1153: astore 4
    //   1155: getstatic 460	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   1158: astore 20
    //   1160: ldc_w 462
    //   1163: astore 21
    //   1165: lload 11
    //   1167: lstore 9
    //   1169: aload 21
    //   1171: astore 18
    //   1173: aload 20
    //   1175: astore 17
    //   1177: aload 21
    //   1179: astore 19
    //   1181: aload 20
    //   1183: astore 4
    //   1185: aload_0
    //   1186: aload_1
    //   1187: putfield 464	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/d;
    //   1190: lload 11
    //   1192: lstore 9
    //   1194: aload 21
    //   1196: astore 18
    //   1198: aload 20
    //   1200: astore 17
    //   1202: aload 21
    //   1204: astore 19
    //   1206: aload 20
    //   1208: astore 4
    //   1210: invokestatic 466	com/tencent/mobileqq/msf/core/s:g	()V
    //   1213: lload 11
    //   1215: lstore 9
    //   1217: aload 21
    //   1219: astore 18
    //   1221: aload 20
    //   1223: astore 17
    //   1225: aload 21
    //   1227: astore 19
    //   1229: aload 20
    //   1231: astore 4
    //   1233: new 200	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1240: aload_0
    //   1241: getfield 464	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/d;
    //   1244: invokevirtual 368	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   1247: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: ldc_w 468
    //   1253: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: aload_0
    //   1257: getfield 464	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/d;
    //   1260: invokevirtual 370	com/tencent/mobileqq/msf/core/d:d	()I
    //   1263: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: putstatic 470	com/tencent/mobileqq/msf/core/s:r	Ljava/lang/String;
    //   1272: lload 11
    //   1274: lstore 9
    //   1276: aload 21
    //   1278: astore 18
    //   1280: aload 20
    //   1282: astore 17
    //   1284: aload 21
    //   1286: astore 19
    //   1288: aload 20
    //   1290: astore 4
    //   1292: new 200	java/lang/StringBuilder
    //   1295: dup
    //   1296: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1299: aload_0
    //   1300: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1303: invokevirtual 474	java/net/Socket:getLocalSocketAddress	()Ljava/net/SocketAddress;
    //   1306: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1309: ldc_w 476
    //   1312: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: aload_0
    //   1316: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1319: invokevirtual 479	java/net/Socket:getLocalPort	()I
    //   1322: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1325: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1328: putstatic 481	com/tencent/mobileqq/msf/core/s:s	Ljava/lang/String;
    //   1331: lload 11
    //   1333: lstore 9
    //   1335: aload 21
    //   1337: astore 18
    //   1339: aload 20
    //   1341: astore 17
    //   1343: aload 21
    //   1345: astore 19
    //   1347: aload 20
    //   1349: astore 4
    //   1351: invokestatic 486	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isWifiConn	()Z
    //   1354: ifeq +533 -> 1887
    //   1357: lload 11
    //   1359: lstore 9
    //   1361: aload 21
    //   1363: astore 18
    //   1365: aload 20
    //   1367: astore 17
    //   1369: aload 21
    //   1371: astore 19
    //   1373: aload 20
    //   1375: astore 4
    //   1377: iconst_1
    //   1378: putstatic 488	com/tencent/mobileqq/msf/core/s:t	I
    //   1381: lload 11
    //   1383: lstore 9
    //   1385: aload 21
    //   1387: astore 18
    //   1389: aload 20
    //   1391: astore 17
    //   1393: aload 21
    //   1395: astore 19
    //   1397: aload 20
    //   1399: astore 4
    //   1401: aload_0
    //   1402: getfield 464	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/d;
    //   1405: invokevirtual 490	com/tencent/mobileqq/msf/core/d:f	()V
    //   1408: lload 11
    //   1410: lstore 9
    //   1412: aload 21
    //   1414: astore 18
    //   1416: aload 20
    //   1418: astore 17
    //   1420: aload 21
    //   1422: astore 19
    //   1424: aload 20
    //   1426: astore 4
    //   1428: aload 23
    //   1430: iconst_0
    //   1431: aload 23
    //   1433: invokevirtual 493	java/lang/StringBuilder:length	()I
    //   1436: invokevirtual 497	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: lload 11
    //   1442: lstore 9
    //   1444: aload 21
    //   1446: astore 18
    //   1448: aload 20
    //   1450: astore 17
    //   1452: aload 21
    //   1454: astore 19
    //   1456: aload 20
    //   1458: astore 4
    //   1460: new 200	java/lang/StringBuilder
    //   1463: dup
    //   1464: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1467: aload 23
    //   1469: ldc_w 499
    //   1472: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: aload_0
    //   1476: getfield 375	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   1479: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1482: ldc_w 501
    //   1485: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: lload 7
    //   1490: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1493: ldc_w 506
    //   1496: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: aload_1
    //   1500: invokevirtual 399	com/tencent/mobileqq/msf/core/d:e	()I
    //   1503: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1506: ldc_w 508
    //   1509: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: aload_0
    //   1513: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1516: invokevirtual 512	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   1519: invokevirtual 517	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1522: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: ldc_w 468
    //   1528: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: aload_0
    //   1532: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1535: invokevirtual 479	java/net/Socket:getLocalPort	()I
    //   1538: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1541: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1544: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: astore 23
    //   1549: lload 11
    //   1551: lstore 9
    //   1553: aload 21
    //   1555: astore 18
    //   1557: aload 20
    //   1559: astore 17
    //   1561: aload 21
    //   1563: astore 19
    //   1565: aload 20
    //   1567: astore 4
    //   1569: aload_1
    //   1570: getfield 382	com/tencent/mobileqq/msf/core/d:h	Z
    //   1573: ifeq +568 -> 2141
    //   1576: ldc_w 384
    //   1579: astore 22
    //   1581: lload 11
    //   1583: lstore 9
    //   1585: aload 21
    //   1587: astore 18
    //   1589: aload 20
    //   1591: astore 17
    //   1593: aload 21
    //   1595: astore 19
    //   1597: aload 20
    //   1599: astore 4
    //   1601: ldc 198
    //   1603: iconst_1
    //   1604: aload 23
    //   1606: aload 22
    //   1608: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1614: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1617: lload 11
    //   1619: lstore 9
    //   1621: aload 21
    //   1623: astore 18
    //   1625: aload 20
    //   1627: astore 17
    //   1629: aload 21
    //   1631: astore 19
    //   1633: aload 20
    //   1635: astore 4
    //   1637: aload_0
    //   1638: getfield 84	com/tencent/mobileqq/msf/core/net/g:A	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1641: iconst_0
    //   1642: invokevirtual 519	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   1645: aload_0
    //   1646: getfield 107	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   1649: invokevirtual 522	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1652: aload 20
    //   1654: getstatic 460	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   1657: if_acmpeq +21 -> 1678
    //   1660: aload 6
    //   1662: iconst_0
    //   1663: putfield 407	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   1666: aload 6
    //   1668: aload 6
    //   1670: getfield 524	com/tencent/mobileqq/msf/core/net/a:k	I
    //   1673: iconst_1
    //   1674: iadd
    //   1675: putfield 524	com/tencent/mobileqq/msf/core/net/a:k	I
    //   1678: aload 6
    //   1680: aload 20
    //   1682: putfield 526	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/q;
    //   1685: aload 6
    //   1687: ldc_w 462
    //   1690: putfield 528	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   1693: aload 6
    //   1695: invokestatic 359	android/os/SystemClock:elapsedRealtime	()J
    //   1698: lload 15
    //   1700: lsub
    //   1701: putfield 530	com/tencent/mobileqq/msf/core/net/a:a	J
    //   1704: aload 20
    //   1706: astore 18
    //   1708: aload 18
    //   1710: getstatic 460	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   1713: if_acmpne +1413 -> 3126
    //   1716: aload_0
    //   1717: getfield 113	com/tencent/mobileqq/msf/core/net/g:v	Z
    //   1720: ifeq +1406 -> 3126
    //   1723: invokestatic 533	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNetSupport	()Z
    //   1726: ifne +7 -> 1733
    //   1729: iconst_1
    //   1730: invokestatic 536	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   1733: aload_0
    //   1734: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1737: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   1740: aconst_null
    //   1741: invokevirtual 538	com/tencent/mobileqq/msf/core/s:a	([B)V
    //   1744: aload_0
    //   1745: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1748: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   1751: invokevirtual 540	com/tencent/mobileqq/msf/core/s:c	()V
    //   1754: getstatic 542	com/tencent/mobileqq/msf/core/s:o	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1757: iconst_0
    //   1758: invokevirtual 519	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   1761: aload_0
    //   1762: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1765: ifnull +113 -> 1878
    //   1768: aload_0
    //   1769: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1772: new 200	java/lang/StringBuilder
    //   1775: dup
    //   1776: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1779: aload_0
    //   1780: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1783: invokevirtual 512	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   1786: invokevirtual 517	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1789: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: ldc_w 468
    //   1795: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: aload_0
    //   1799: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1802: invokevirtual 479	java/net/Socket:getLocalPort	()I
    //   1805: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1808: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1811: putfield 545	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   1814: invokestatic 549	com/tencent/mobileqq/msf/core/a/a:p	()Z
    //   1817: ifeq +1267 -> 3084
    //   1820: aload_0
    //   1821: invokevirtual 551	com/tencent/mobileqq/msf/core/net/g:d	()V
    //   1824: invokestatic 553	com/tencent/mobileqq/msf/core/a/a:q	()Z
    //   1827: ifeq +1287 -> 3114
    //   1830: aload_0
    //   1831: aload_0
    //   1832: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1835: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   1838: aload_0
    //   1839: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   1842: invokevirtual 252	java/lang/Object:hashCode	()I
    //   1845: invokevirtual 556	com/tencent/mobileqq/msf/core/s:a	(I)Ljava/lang/Runnable;
    //   1848: putfield 329	com/tencent/mobileqq/msf/core/net/g:x	Ljava/lang/Runnable;
    //   1851: aload_0
    //   1852: getfield 375	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   1855: invokevirtual 557	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1858: aload_0
    //   1859: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1862: getfield 545	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   1865: invokestatic 563	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnOpened	(Ljava/lang/String;Ljava/lang/String;)V
    //   1868: aload_0
    //   1869: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1872: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   1875: invokevirtual 565	com/tencent/mobileqq/msf/core/s:k	()V
    //   1878: return
    //   1879: ldc_w 567
    //   1882: astore 22
    //   1884: goto -1588 -> 296
    //   1887: lload 11
    //   1889: lstore 9
    //   1891: aload 21
    //   1893: astore 18
    //   1895: aload 20
    //   1897: astore 17
    //   1899: aload 21
    //   1901: astore 19
    //   1903: aload 20
    //   1905: astore 4
    //   1907: invokestatic 570	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isMobileConn	()Z
    //   1910: ifeq -529 -> 1381
    //   1913: lload 11
    //   1915: lstore 9
    //   1917: aload 21
    //   1919: astore 18
    //   1921: aload 20
    //   1923: astore 17
    //   1925: aload 21
    //   1927: astore 19
    //   1929: aload 20
    //   1931: astore 4
    //   1933: invokestatic 573	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getMobileNetworkType	()I
    //   1936: bipush 100
    //   1938: iadd
    //   1939: putstatic 488	com/tencent/mobileqq/msf/core/s:t	I
    //   1942: goto -561 -> 1381
    //   1945: astore 22
    //   1947: aload 18
    //   1949: astore 19
    //   1951: aload 17
    //   1953: astore 4
    //   1955: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   1958: lload 9
    //   1960: lsub
    //   1961: lstore 7
    //   1963: aload 18
    //   1965: astore 19
    //   1967: aload 17
    //   1969: astore 4
    //   1971: aload_0
    //   1972: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1975: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   1978: getfield 412	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1981: astore 20
    //   1983: aload 18
    //   1985: astore 19
    //   1987: aload 17
    //   1989: astore 4
    //   1991: aload 20
    //   1993: aload 20
    //   1995: getfield 416	com/tencent/mobileqq/msf/core/net/h:p	J
    //   1998: lload 7
    //   2000: ladd
    //   2001: putfield 416	com/tencent/mobileqq/msf/core/net/h:p	J
    //   2004: aload 18
    //   2006: astore 19
    //   2008: aload 17
    //   2010: astore 4
    //   2012: aload 22
    //   2014: invokevirtual 574	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2017: invokevirtual 577	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2020: astore 21
    //   2022: aload 21
    //   2024: astore 19
    //   2026: aload 17
    //   2028: astore 4
    //   2030: invokestatic 580	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getSystemNetworkType	()I
    //   2033: ifne +116 -> 2149
    //   2036: aload 21
    //   2038: astore 19
    //   2040: aload 17
    //   2042: astore 4
    //   2044: getstatic 582	com/tencent/mobileqq/msf/core/net/q:m	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2047: astore 18
    //   2049: aload 21
    //   2051: astore 19
    //   2053: aload 18
    //   2055: astore 4
    //   2057: aload 18
    //   2059: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2062: astore 17
    //   2064: aload 17
    //   2066: astore 19
    //   2068: aload 18
    //   2070: astore 4
    //   2072: aload 6
    //   2074: sipush 5000
    //   2077: putfield 585	com/tencent/mobileqq/msf/core/net/a:h	I
    //   2080: aload_0
    //   2081: getfield 107	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   2084: invokevirtual 522	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2087: aload 18
    //   2089: getstatic 460	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2092: if_acmpeq +21 -> 2113
    //   2095: aload 6
    //   2097: iconst_0
    //   2098: putfield 407	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2101: aload 6
    //   2103: aload 6
    //   2105: getfield 524	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2108: iconst_1
    //   2109: iadd
    //   2110: putfield 524	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2113: aload 6
    //   2115: aload 18
    //   2117: putfield 526	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2120: aload 6
    //   2122: aload 17
    //   2124: putfield 528	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2127: aload 6
    //   2129: invokestatic 359	android/os/SystemClock:elapsedRealtime	()J
    //   2132: lload 15
    //   2134: lsub
    //   2135: putfield 530	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2138: goto -430 -> 1708
    //   2141: ldc_w 567
    //   2144: astore 22
    //   2146: goto -565 -> 1581
    //   2149: aload 21
    //   2151: astore 19
    //   2153: aload 17
    //   2155: astore 4
    //   2157: aload 21
    //   2159: ldc_w 587
    //   2162: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2165: iconst_m1
    //   2166: if_icmple +34 -> 2200
    //   2169: aload 21
    //   2171: astore 19
    //   2173: aload 17
    //   2175: astore 4
    //   2177: getstatic 593	com/tencent/mobileqq/msf/core/net/q:g	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2180: astore 18
    //   2182: aload 21
    //   2184: astore 19
    //   2186: aload 18
    //   2188: astore 4
    //   2190: aload 18
    //   2192: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2195: astore 17
    //   2197: goto -117 -> 2080
    //   2200: aload 21
    //   2202: astore 19
    //   2204: aload 17
    //   2206: astore 4
    //   2208: aload 21
    //   2210: ldc_w 595
    //   2213: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2216: iconst_m1
    //   2217: if_icmple +34 -> 2251
    //   2220: aload 21
    //   2222: astore 19
    //   2224: aload 17
    //   2226: astore 4
    //   2228: getstatic 597	com/tencent/mobileqq/msf/core/net/q:q	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2231: astore 18
    //   2233: aload 21
    //   2235: astore 19
    //   2237: aload 18
    //   2239: astore 4
    //   2241: aload 18
    //   2243: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2246: astore 17
    //   2248: goto -168 -> 2080
    //   2251: aload 21
    //   2253: astore 19
    //   2255: aload 17
    //   2257: astore 4
    //   2259: aload 21
    //   2261: ldc_w 599
    //   2264: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2267: iconst_m1
    //   2268: if_icmple +154 -> 2422
    //   2271: aload 21
    //   2273: astore 19
    //   2275: aload 17
    //   2277: astore 4
    //   2279: getstatic 582	com/tencent/mobileqq/msf/core/net/q:m	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2282: astore 18
    //   2284: aload 21
    //   2286: astore 19
    //   2288: aload 18
    //   2290: astore 4
    //   2292: aload 18
    //   2294: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2297: astore 17
    //   2299: aload 17
    //   2301: astore 19
    //   2303: aload 18
    //   2305: astore 4
    //   2307: aload 6
    //   2309: sipush 5000
    //   2312: putfield 585	com/tencent/mobileqq/msf/core/net/a:h	I
    //   2315: goto -235 -> 2080
    //   2318: astore_1
    //   2319: aload_0
    //   2320: getfield 107	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   2323: invokevirtual 522	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2326: aload 4
    //   2328: getstatic 460	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2331: if_acmpeq +21 -> 2352
    //   2334: aload 6
    //   2336: iconst_0
    //   2337: putfield 407	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2340: aload 6
    //   2342: aload 6
    //   2344: getfield 524	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2347: iconst_1
    //   2348: iadd
    //   2349: putfield 524	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2352: aload 6
    //   2354: aload 4
    //   2356: putfield 526	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2359: aload 6
    //   2361: aload 19
    //   2363: putfield 528	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2366: aload 6
    //   2368: invokestatic 359	android/os/SystemClock:elapsedRealtime	()J
    //   2371: lload 15
    //   2373: lsub
    //   2374: putfield 530	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2377: aload_1
    //   2378: athrow
    //   2379: astore_1
    //   2380: aload 6
    //   2382: iconst_0
    //   2383: putfield 407	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2386: aload 6
    //   2388: aload 6
    //   2390: getfield 524	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2393: iconst_1
    //   2394: iadd
    //   2395: putfield 524	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2398: aload 6
    //   2400: getstatic 601	com/tencent/mobileqq/msf/core/net/q:f	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2403: putfield 526	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2406: aload 6
    //   2408: aload_1
    //   2409: invokevirtual 602	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   2412: putfield 528	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2415: aload 6
    //   2417: lconst_0
    //   2418: putfield 530	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2421: return
    //   2422: aload 21
    //   2424: astore 19
    //   2426: aload 17
    //   2428: astore 4
    //   2430: aload 21
    //   2432: ldc_w 604
    //   2435: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2438: iconst_m1
    //   2439: if_icmple +34 -> 2473
    //   2442: aload 21
    //   2444: astore 19
    //   2446: aload 17
    //   2448: astore 4
    //   2450: getstatic 606	com/tencent/mobileqq/msf/core/net/q:i	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2453: astore 18
    //   2455: aload 21
    //   2457: astore 19
    //   2459: aload 18
    //   2461: astore 4
    //   2463: aload 18
    //   2465: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2468: astore 17
    //   2470: goto -390 -> 2080
    //   2473: aload 21
    //   2475: astore 19
    //   2477: aload 17
    //   2479: astore 4
    //   2481: aload 21
    //   2483: ldc_w 608
    //   2486: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2489: iconst_m1
    //   2490: if_icmple +34 -> 2524
    //   2493: aload 21
    //   2495: astore 19
    //   2497: aload 17
    //   2499: astore 4
    //   2501: getstatic 610	com/tencent/mobileqq/msf/core/net/q:s	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2504: astore 18
    //   2506: aload 21
    //   2508: astore 19
    //   2510: aload 18
    //   2512: astore 4
    //   2514: aload 18
    //   2516: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2519: astore 17
    //   2521: goto -441 -> 2080
    //   2524: aload 21
    //   2526: astore 19
    //   2528: aload 17
    //   2530: astore 4
    //   2532: aload 21
    //   2534: ldc_w 612
    //   2537: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2540: iconst_m1
    //   2541: if_icmple +34 -> 2575
    //   2544: aload 21
    //   2546: astore 19
    //   2548: aload 17
    //   2550: astore 4
    //   2552: getstatic 614	com/tencent/mobileqq/msf/core/net/q:r	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2555: astore 18
    //   2557: aload 21
    //   2559: astore 19
    //   2561: aload 18
    //   2563: astore 4
    //   2565: aload 18
    //   2567: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2570: astore 17
    //   2572: goto -492 -> 2080
    //   2575: aload 21
    //   2577: astore 19
    //   2579: aload 17
    //   2581: astore 4
    //   2583: aload 21
    //   2585: ldc_w 616
    //   2588: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2591: iconst_m1
    //   2592: if_icmpgt +23 -> 2615
    //   2595: aload 21
    //   2597: astore 19
    //   2599: aload 17
    //   2601: astore 4
    //   2603: aload 21
    //   2605: ldc_w 618
    //   2608: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2611: iconst_m1
    //   2612: if_icmple +34 -> 2646
    //   2615: aload 21
    //   2617: astore 19
    //   2619: aload 17
    //   2621: astore 4
    //   2623: getstatic 620	com/tencent/mobileqq/msf/core/net/q:t	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2626: astore 18
    //   2628: aload 21
    //   2630: astore 19
    //   2632: aload 18
    //   2634: astore 4
    //   2636: aload 18
    //   2638: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2641: astore 17
    //   2643: goto -563 -> 2080
    //   2646: aload 21
    //   2648: astore 19
    //   2650: aload 17
    //   2652: astore 4
    //   2654: aload 21
    //   2656: ldc_w 622
    //   2659: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2662: iconst_m1
    //   2663: if_icmple +34 -> 2697
    //   2666: aload 21
    //   2668: astore 19
    //   2670: aload 17
    //   2672: astore 4
    //   2674: getstatic 624	com/tencent/mobileqq/msf/core/net/q:p	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2677: astore 18
    //   2679: aload 21
    //   2681: astore 19
    //   2683: aload 18
    //   2685: astore 4
    //   2687: aload 18
    //   2689: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2692: astore 17
    //   2694: goto -614 -> 2080
    //   2697: aload 21
    //   2699: astore 19
    //   2701: aload 17
    //   2703: astore 4
    //   2705: aload 21
    //   2707: ldc_w 626
    //   2710: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2713: iconst_m1
    //   2714: if_icmple +34 -> 2748
    //   2717: aload 21
    //   2719: astore 19
    //   2721: aload 17
    //   2723: astore 4
    //   2725: getstatic 628	com/tencent/mobileqq/msf/core/net/q:o	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2728: astore 18
    //   2730: aload 21
    //   2732: astore 19
    //   2734: aload 18
    //   2736: astore 4
    //   2738: aload 18
    //   2740: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2743: astore 17
    //   2745: goto -665 -> 2080
    //   2748: aload 21
    //   2750: astore 19
    //   2752: aload 17
    //   2754: astore 4
    //   2756: aload 21
    //   2758: ldc_w 630
    //   2761: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2764: iconst_m1
    //   2765: if_icmple +34 -> 2799
    //   2768: aload 21
    //   2770: astore 19
    //   2772: aload 17
    //   2774: astore 4
    //   2776: getstatic 632	com/tencent/mobileqq/msf/core/net/q:h	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2779: astore 18
    //   2781: aload 21
    //   2783: astore 19
    //   2785: aload 18
    //   2787: astore 4
    //   2789: aload 18
    //   2791: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2794: astore 17
    //   2796: goto -716 -> 2080
    //   2799: aload 21
    //   2801: astore 19
    //   2803: aload 17
    //   2805: astore 4
    //   2807: aload 21
    //   2809: ldc_w 634
    //   2812: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2815: iconst_m1
    //   2816: if_icmple +34 -> 2850
    //   2819: aload 21
    //   2821: astore 19
    //   2823: aload 17
    //   2825: astore 4
    //   2827: getstatic 636	com/tencent/mobileqq/msf/core/net/q:l	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2830: astore 18
    //   2832: aload 21
    //   2834: astore 19
    //   2836: aload 18
    //   2838: astore 4
    //   2840: aload 18
    //   2842: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2845: astore 17
    //   2847: goto -767 -> 2080
    //   2850: aload 21
    //   2852: astore 19
    //   2854: aload 17
    //   2856: astore 4
    //   2858: aload 21
    //   2860: ldc_w 638
    //   2863: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2866: iconst_m1
    //   2867: if_icmple +34 -> 2901
    //   2870: aload 21
    //   2872: astore 19
    //   2874: aload 17
    //   2876: astore 4
    //   2878: getstatic 640	com/tencent/mobileqq/msf/core/net/q:j	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2881: astore 18
    //   2883: aload 21
    //   2885: astore 19
    //   2887: aload 18
    //   2889: astore 4
    //   2891: aload 18
    //   2893: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2896: astore 17
    //   2898: goto -818 -> 2080
    //   2901: aload 21
    //   2903: astore 19
    //   2905: aload 17
    //   2907: astore 4
    //   2909: aload 21
    //   2911: ldc_w 642
    //   2914: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2917: iconst_m1
    //   2918: if_icmple +34 -> 2952
    //   2921: aload 21
    //   2923: astore 19
    //   2925: aload 17
    //   2927: astore 4
    //   2929: getstatic 620	com/tencent/mobileqq/msf/core/net/q:t	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2932: astore 18
    //   2934: aload 21
    //   2936: astore 19
    //   2938: aload 18
    //   2940: astore 4
    //   2942: aload 18
    //   2944: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2947: astore 17
    //   2949: goto -869 -> 2080
    //   2952: aload 21
    //   2954: astore 19
    //   2956: aload 17
    //   2958: astore 4
    //   2960: aload 21
    //   2962: ldc_w 644
    //   2965: invokevirtual 591	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2968: iconst_m1
    //   2969: if_icmple +34 -> 3003
    //   2972: aload 21
    //   2974: astore 19
    //   2976: aload 17
    //   2978: astore 4
    //   2980: getstatic 646	com/tencent/mobileqq/msf/core/net/q:n	Lcom/tencent/mobileqq/msf/core/net/q;
    //   2983: astore 18
    //   2985: aload 21
    //   2987: astore 19
    //   2989: aload 18
    //   2991: astore 4
    //   2993: aload 18
    //   2995: invokevirtual 583	com/tencent/mobileqq/msf/core/net/q:toString	()Ljava/lang/String;
    //   2998: astore 17
    //   3000: goto -920 -> 2080
    //   3003: aload 21
    //   3005: astore 19
    //   3007: aload 17
    //   3009: astore 4
    //   3011: getstatic 648	com/tencent/mobileqq/msf/core/net/q:u	Lcom/tencent/mobileqq/msf/core/net/q;
    //   3014: astore 20
    //   3016: aload 21
    //   3018: astore 19
    //   3020: aload 20
    //   3022: astore 4
    //   3024: aload 22
    //   3026: invokestatic 650	com/tencent/mobileqq/msf/core/net/g:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3029: astore 21
    //   3031: aload 21
    //   3033: astore 17
    //   3035: aload 20
    //   3037: astore 18
    //   3039: aload 21
    //   3041: astore 19
    //   3043: aload 20
    //   3045: astore 4
    //   3047: aload 21
    //   3049: invokevirtual 651	java/lang/String:length	()I
    //   3052: sipush 200
    //   3055: if_icmple -975 -> 2080
    //   3058: aload 21
    //   3060: astore 19
    //   3062: aload 20
    //   3064: astore 4
    //   3066: aload 21
    //   3068: iconst_0
    //   3069: sipush 200
    //   3072: invokevirtual 655	java/lang/String:substring	(II)Ljava/lang/String;
    //   3075: astore 17
    //   3077: aload 20
    //   3079: astore 18
    //   3081: goto -1001 -> 2080
    //   3084: ldc 198
    //   3086: iconst_1
    //   3087: ldc_w 657
    //   3090: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3093: goto -1269 -> 1824
    //   3096: astore_1
    //   3097: aload_1
    //   3098: invokevirtual 659	java/lang/Exception:printStackTrace	()V
    //   3101: ldc 198
    //   3103: iconst_1
    //   3104: ldc_w 661
    //   3107: aload_1
    //   3108: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3111: goto -1260 -> 1851
    //   3114: ldc 198
    //   3116: iconst_1
    //   3117: ldc_w 666
    //   3120: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3123: goto -1272 -> 1851
    //   3126: aload 18
    //   3128: getstatic 460	com/tencent/mobileqq/msf/core/net/q:c	Lcom/tencent/mobileqq/msf/core/net/q;
    //   3131: if_acmpeq -1253 -> 1878
    //   3134: new 200	java/lang/StringBuilder
    //   3137: dup
    //   3138: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3141: astore 4
    //   3143: new 200	java/lang/StringBuilder
    //   3146: dup
    //   3147: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3150: aload 4
    //   3152: ldc_w 668
    //   3155: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3158: aload_0
    //   3159: getfield 375	com/tencent/mobileqq/msf/core/net/g:c	Ljava/net/InetSocketAddress;
    //   3162: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3165: ldc_w 670
    //   3168: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3171: aload 6
    //   3173: getfield 528	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3176: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3179: ldc_w 672
    //   3182: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3185: lload 7
    //   3187: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3190: ldc_w 506
    //   3193: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3196: aload_1
    //   3197: invokevirtual 399	com/tencent/mobileqq/msf/core/d:e	()I
    //   3200: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3203: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3206: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3209: astore 4
    //   3211: aload_1
    //   3212: getfield 382	com/tencent/mobileqq/msf/core/d:h	Z
    //   3215: ifeq +23 -> 3238
    //   3218: ldc_w 384
    //   3221: astore_1
    //   3222: ldc 198
    //   3224: iconst_1
    //   3225: aload 4
    //   3227: aload_1
    //   3228: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3231: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3234: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3237: return
    //   3238: ldc_w 567
    //   3241: astore_1
    //   3242: goto -20 -> 3222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3245	0	this	g
    //   0	3245	1	paramd	d
    //   0	3245	2	paramInt1	int
    //   0	3245	3	paramInt2	int
    //   0	3245	4	paramc	c
    //   0	3245	5	paramBoolean	boolean
    //   0	3245	6	parama	a
    //   140	3046	7	l1	long
    //   148	1811	9	l2	long
    //   355	1559	11	l3	long
    //   645	72	13	l4	long
    //   135	2237	15	l5	long
    //   156	2920	17	localObject1	Object
    //   152	2975	18	localObject2	Object
    //   160	2901	19	localObject3	Object
    //   105	2973	20	localObject4	Object
    //   109	2958	21	str1	String
    //   294	1589	22	localObject5	Object
    //   1945	68	22	localThrowable	Throwable
    //   2144	881	22	str2	String
    //   212	1393	23	localStringBuilder1	StringBuilder
    //   262	58	24	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   166	185	1945	java/lang/Throwable
    //   205	214	1945	java/lang/Throwable
    //   234	264	1945	java/lang/Throwable
    //   284	291	1945	java/lang/Throwable
    //   316	332	1945	java/lang/Throwable
    //   352	357	1945	java/lang/Throwable
    //   377	383	1945	java/lang/Throwable
    //   403	414	1945	java/lang/Throwable
    //   434	442	1945	java/lang/Throwable
    //   462	470	1945	java/lang/Throwable
    //   490	498	1945	java/lang/Throwable
    //   518	533	1945	java/lang/Throwable
    //   553	559	1945	java/lang/Throwable
    //   579	591	1945	java/lang/Throwable
    //   611	618	1945	java/lang/Throwable
    //   638	647	1945	java/lang/Throwable
    //   667	679	1945	java/lang/Throwable
    //   699	712	1945	java/lang/Throwable
    //   746	753	1945	java/lang/Throwable
    //   773	781	1945	java/lang/Throwable
    //   801	809	1945	java/lang/Throwable
    //   829	843	1945	java/lang/Throwable
    //   863	877	1945	java/lang/Throwable
    //   897	908	1945	java/lang/Throwable
    //   928	944	1945	java/lang/Throwable
    //   964	978	1945	java/lang/Throwable
    //   998	1018	1945	java/lang/Throwable
    //   1038	1050	1945	java/lang/Throwable
    //   1070	1080	1945	java/lang/Throwable
    //   1100	1107	1945	java/lang/Throwable
    //   1127	1135	1945	java/lang/Throwable
    //   1155	1160	1945	java/lang/Throwable
    //   1185	1190	1945	java/lang/Throwable
    //   1210	1213	1945	java/lang/Throwable
    //   1233	1272	1945	java/lang/Throwable
    //   1292	1331	1945	java/lang/Throwable
    //   1351	1357	1945	java/lang/Throwable
    //   1377	1381	1945	java/lang/Throwable
    //   1401	1408	1945	java/lang/Throwable
    //   1428	1440	1945	java/lang/Throwable
    //   1460	1549	1945	java/lang/Throwable
    //   1569	1576	1945	java/lang/Throwable
    //   1601	1617	1945	java/lang/Throwable
    //   1637	1645	1945	java/lang/Throwable
    //   1907	1913	1945	java/lang/Throwable
    //   1933	1942	1945	java/lang/Throwable
    //   166	185	2318	finally
    //   205	214	2318	finally
    //   234	264	2318	finally
    //   284	291	2318	finally
    //   316	332	2318	finally
    //   352	357	2318	finally
    //   377	383	2318	finally
    //   403	414	2318	finally
    //   434	442	2318	finally
    //   462	470	2318	finally
    //   490	498	2318	finally
    //   518	533	2318	finally
    //   553	559	2318	finally
    //   579	591	2318	finally
    //   611	618	2318	finally
    //   638	647	2318	finally
    //   667	679	2318	finally
    //   699	712	2318	finally
    //   746	753	2318	finally
    //   773	781	2318	finally
    //   801	809	2318	finally
    //   829	843	2318	finally
    //   863	877	2318	finally
    //   897	908	2318	finally
    //   928	944	2318	finally
    //   964	978	2318	finally
    //   998	1018	2318	finally
    //   1038	1050	2318	finally
    //   1070	1080	2318	finally
    //   1100	1107	2318	finally
    //   1127	1135	2318	finally
    //   1155	1160	2318	finally
    //   1185	1190	2318	finally
    //   1210	1213	2318	finally
    //   1233	1272	2318	finally
    //   1292	1331	2318	finally
    //   1351	1357	2318	finally
    //   1377	1381	2318	finally
    //   1401	1408	2318	finally
    //   1428	1440	2318	finally
    //   1460	1549	2318	finally
    //   1569	1576	2318	finally
    //   1601	1617	2318	finally
    //   1637	1645	2318	finally
    //   1907	1913	2318	finally
    //   1933	1942	2318	finally
    //   1955	1963	2318	finally
    //   1971	1983	2318	finally
    //   1991	2004	2318	finally
    //   2012	2022	2318	finally
    //   2030	2036	2318	finally
    //   2044	2049	2318	finally
    //   2057	2064	2318	finally
    //   2072	2080	2318	finally
    //   2157	2169	2318	finally
    //   2177	2182	2318	finally
    //   2190	2197	2318	finally
    //   2208	2220	2318	finally
    //   2228	2233	2318	finally
    //   2241	2248	2318	finally
    //   2259	2271	2318	finally
    //   2279	2284	2318	finally
    //   2292	2299	2318	finally
    //   2307	2315	2318	finally
    //   2430	2442	2318	finally
    //   2450	2455	2318	finally
    //   2463	2470	2318	finally
    //   2481	2493	2318	finally
    //   2501	2506	2318	finally
    //   2514	2521	2318	finally
    //   2532	2544	2318	finally
    //   2552	2557	2318	finally
    //   2565	2572	2318	finally
    //   2583	2595	2318	finally
    //   2603	2615	2318	finally
    //   2623	2628	2318	finally
    //   2636	2643	2318	finally
    //   2654	2666	2318	finally
    //   2674	2679	2318	finally
    //   2687	2694	2318	finally
    //   2705	2717	2318	finally
    //   2725	2730	2318	finally
    //   2738	2745	2318	finally
    //   2756	2768	2318	finally
    //   2776	2781	2318	finally
    //   2789	2796	2318	finally
    //   2807	2819	2318	finally
    //   2827	2832	2318	finally
    //   2840	2847	2318	finally
    //   2858	2870	2318	finally
    //   2878	2883	2318	finally
    //   2891	2898	2318	finally
    //   2909	2921	2318	finally
    //   2929	2934	2318	finally
    //   2942	2949	2318	finally
    //   2960	2972	2318	finally
    //   2980	2985	2318	finally
    //   2993	3000	2318	finally
    //   3011	3016	2318	finally
    //   3024	3031	2318	finally
    //   3047	3058	2318	finally
    //   3066	3077	2318	finally
    //   116	146	2379	java/lang/InterruptedException
    //   1645	1678	2379	java/lang/InterruptedException
    //   1678	1704	2379	java/lang/InterruptedException
    //   1708	1733	2379	java/lang/InterruptedException
    //   1733	1814	2379	java/lang/InterruptedException
    //   1814	1824	2379	java/lang/InterruptedException
    //   1824	1851	2379	java/lang/InterruptedException
    //   1851	1878	2379	java/lang/InterruptedException
    //   2080	2113	2379	java/lang/InterruptedException
    //   2113	2138	2379	java/lang/InterruptedException
    //   2319	2352	2379	java/lang/InterruptedException
    //   2352	2379	2379	java/lang/InterruptedException
    //   3084	3093	2379	java/lang/InterruptedException
    //   3097	3111	2379	java/lang/InterruptedException
    //   3114	3123	2379	java/lang/InterruptedException
    //   3126	3218	2379	java/lang/InterruptedException
    //   3222	3237	2379	java/lang/InterruptedException
    //   1814	1824	3096	java/lang/Exception
    //   1824	1851	3096	java/lang/Exception
    //   3084	3093	3096	java/lang/Exception
    //   3114	3123	3096	java/lang/Exception
  }
  
  /* Error */
  public void a(com.tencent.qphone.base.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   7: iconst_0
    //   8: putfield 674	com/tencent/mobileqq/msf/core/s:k	Z
    //   11: aload_0
    //   12: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   15: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   18: iconst_0
    //   19: putfield 181	com/tencent/mobileqq/msf/core/s:l	Z
    //   22: aload_0
    //   23: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   26: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   29: lconst_0
    //   30: putfield 676	com/tencent/mobileqq/msf/core/s:j	J
    //   33: aload_0
    //   34: getfield 100	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   37: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   40: ifeq +248 -> 288
    //   43: aload_0
    //   44: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   47: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   50: getfield 426	com/tencent/mobileqq/msf/core/s:z	Ljava/util/concurrent/atomic/AtomicLong;
    //   53: invokevirtual 678	java/util/concurrent/atomic/AtomicLong:get	()J
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +202 -> 260
    //   61: aload_0
    //   62: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   65: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   68: getfield 424	com/tencent/mobileqq/msf/core/s:y	Ljava/util/concurrent/atomic/AtomicLong;
    //   71: invokevirtual 678	java/util/concurrent/atomic/AtomicLong:get	()J
    //   74: lconst_0
    //   75: lcmp
    //   76: ifgt +184 -> 260
    //   79: new 680	java/util/HashMap
    //   82: dup
    //   83: invokespecial 681	java/util/HashMap:<init>	()V
    //   86: astore 8
    //   88: aload_0
    //   89: getfield 158	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   92: ifnull +901 -> 993
    //   95: aload_0
    //   96: getfield 158	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   99: invokevirtual 368	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   102: astore 7
    //   104: aload_0
    //   105: getfield 158	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   108: invokevirtual 370	com/tencent/mobileqq/msf/core/d:d	()I
    //   111: istore_2
    //   112: aload 8
    //   114: ldc_w 683
    //   117: aload 7
    //   119: invokevirtual 687	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: aload 8
    //   125: ldc_w 689
    //   128: iload_2
    //   129: invokestatic 692	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   132: invokevirtual 687	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload 8
    //   138: ldc_w 694
    //   141: aload_1
    //   142: invokestatic 697	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokevirtual 687	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: aload 8
    //   151: ldc_w 699
    //   154: aload_0
    //   155: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   158: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   161: getfield 426	com/tencent/mobileqq/msf/core/s:z	Ljava/util/concurrent/atomic/AtomicLong;
    //   164: invokevirtual 678	java/util/concurrent/atomic/AtomicLong:get	()J
    //   167: invokestatic 702	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   170: invokevirtual 687	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: aload 8
    //   176: ldc_w 704
    //   179: aload_0
    //   180: getfield 109	com/tencent/mobileqq/msf/core/net/g:B	J
    //   183: invokestatic 702	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   186: invokevirtual 687	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: pop
    //   190: aload_0
    //   191: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   194: invokevirtual 708	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/m;
    //   197: ldc_w 710
    //   200: iconst_0
    //   201: lconst_0
    //   202: lconst_0
    //   203: aload 8
    //   205: iconst_1
    //   206: iconst_0
    //   207: invokevirtual 715	com/tencent/mobileqq/msf/core/c/m:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   210: aload_0
    //   211: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   214: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   217: getfield 718	com/tencent/mobileqq/msf/core/s:A	Lcom/tencent/mobileqq/msf/core/net/a/c;
    //   220: ifnull +40 -> 260
    //   223: aload_0
    //   224: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   227: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   230: getfield 718	com/tencent/mobileqq/msf/core/s:A	Lcom/tencent/mobileqq/msf/core/net/a/c;
    //   233: aload_0
    //   234: getfield 109	com/tencent/mobileqq/msf/core/net/g:B	J
    //   237: aload 7
    //   239: iload_2
    //   240: aload_1
    //   241: invokestatic 697	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   244: aload_0
    //   245: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   248: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   251: getfield 426	com/tencent/mobileqq/msf/core/s:z	Ljava/util/concurrent/atomic/AtomicLong;
    //   254: invokevirtual 678	java/util/concurrent/atomic/AtomicLong:get	()J
    //   257: invokevirtual 723	com/tencent/mobileqq/msf/core/net/a/c:a	(JLjava/lang/String;ILjava/lang/String;J)V
    //   260: aload_0
    //   261: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   264: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   267: getfield 424	com/tencent/mobileqq/msf/core/s:y	Ljava/util/concurrent/atomic/AtomicLong;
    //   270: lconst_0
    //   271: invokevirtual 422	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   274: aload_0
    //   275: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   278: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   281: getfield 426	com/tencent/mobileqq/msf/core/s:z	Ljava/util/concurrent/atomic/AtomicLong;
    //   284: lconst_0
    //   285: invokevirtual 422	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   288: aload_0
    //   289: getfield 324	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   292: ifnull +22 -> 314
    //   295: aload_0
    //   296: invokevirtual 327	com/tencent/mobileqq/msf/core/net/g:e	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   299: pop
    //   300: aload_0
    //   301: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   304: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   307: aload_0
    //   308: getfield 329	com/tencent/mobileqq/msf/core/net/g:x	Ljava/lang/Runnable;
    //   311: invokevirtual 332	com/tencent/mobileqq/msf/core/s:a	(Ljava/lang/Runnable;)V
    //   314: aload_0
    //   315: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   318: ifnonnull +30 -> 348
    //   321: ldc 198
    //   323: iconst_1
    //   324: new 200	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 725
    //   334: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_1
    //   338: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: return
    //   348: iconst_1
    //   349: istore 4
    //   351: aload_0
    //   352: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   355: invokevirtual 726	java/net/Socket:toString	()Ljava/lang/String;
    //   358: astore 7
    //   360: aload_0
    //   361: getfield 107	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   364: ldc2_w 342
    //   367: getstatic 349	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   370: invokevirtual 353	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   373: istore_3
    //   374: iload_3
    //   375: ifeq +483 -> 858
    //   378: aload_0
    //   379: getfield 84	com/tencent/mobileqq/msf/core/net/g:A	Ljava/util/concurrent/atomic/AtomicInteger;
    //   382: iconst_0
    //   383: invokevirtual 519	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   386: aload_0
    //   387: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   390: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   393: aconst_null
    //   394: invokevirtual 538	com/tencent/mobileqq/msf/core/s:a	([B)V
    //   397: aload_0
    //   398: getfield 100	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   401: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   404: istore_3
    //   405: aload_0
    //   406: getfield 449	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   409: ifnull +14 -> 423
    //   412: aload_0
    //   413: getfield 449	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   416: getfield 728	com/tencent/mobileqq/msf/core/net/g$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   419: iconst_0
    //   420: invokevirtual 314	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   423: aload_0
    //   424: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   427: invokevirtual 732	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   430: ifnull +13 -> 443
    //   433: aload_0
    //   434: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   437: invokevirtual 732	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   440: invokevirtual 737	java/io/InputStream:close	()V
    //   443: aload_0
    //   444: getfield 71	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   447: astore 8
    //   449: aload 8
    //   451: ifnull +24 -> 475
    //   454: getstatic 64	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   457: aload_0
    //   458: getfield 71	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   461: invokevirtual 431	java/lang/Object:toString	()Ljava/lang/String;
    //   464: invokevirtual 739	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   467: pop
    //   468: aload_0
    //   469: getfield 71	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   472: invokevirtual 740	java/io/OutputStream:close	()V
    //   475: aload_0
    //   476: aconst_null
    //   477: putfield 449	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   480: aload_0
    //   481: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   484: astore 8
    //   486: aload 8
    //   488: ifnull +30 -> 518
    //   491: aload_0
    //   492: getfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   495: invokevirtual 741	java/net/Socket:close	()V
    //   498: aload_1
    //   499: invokestatic 744	com/tencent/mobileqq/msf/core/x:a	(Lcom/tencent/qphone/base/a;)V
    //   502: aload_0
    //   503: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   506: invokevirtual 748	com/tencent/mobileqq/msf/core/MsfCore:getStandyModeManager	()Lcom/tencent/mobileqq/msf/core/d/a;
    //   509: invokevirtual 752	com/tencent/mobileqq/msf/core/d/a:h	()V
    //   512: getstatic 64	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   515: invokevirtual 755	java/util/ArrayList:clear	()V
    //   518: aload_0
    //   519: aconst_null
    //   520: putfield 249	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   523: aload_0
    //   524: getfield 100	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   527: iconst_0
    //   528: invokevirtual 314	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   531: aload_0
    //   532: aconst_null
    //   533: putfield 150	com/tencent/mobileqq/msf/core/net/g:i	Lcom/tencent/mobileqq/msf/core/net/c;
    //   536: aload_0
    //   537: getfield 107	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   540: invokevirtual 522	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   543: aload_0
    //   544: getfield 102	com/tencent/mobileqq/msf/core/net/g:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   547: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   550: ifne +189 -> 739
    //   553: iload_3
    //   554: ifeq +185 -> 739
    //   557: aload_0
    //   558: getfield 113	com/tencent/mobileqq/msf/core/net/g:v	Z
    //   561: ifeq +178 -> 739
    //   564: aload_0
    //   565: getfield 93	com/tencent/mobileqq/msf/core/net/g:q	J
    //   568: lconst_0
    //   569: lcmp
    //   570: ifle +96 -> 666
    //   573: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   576: aload_0
    //   577: getfield 93	com/tencent/mobileqq/msf/core/net/g:q	J
    //   580: lsub
    //   581: lstore 5
    //   583: aload_0
    //   584: lconst_0
    //   585: putfield 93	com/tencent/mobileqq/msf/core/net/g:q	J
    //   588: aload_0
    //   589: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   592: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   595: invokevirtual 758	com/tencent/mobileqq/msf/core/s:b	()[B
    //   598: invokestatic 764	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   601: astore 8
    //   603: invokestatic 767	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getCurrentAPN	()Ljava/lang/String;
    //   606: astore 9
    //   608: aload_0
    //   609: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   612: getfield 177	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/s;
    //   615: getfield 412	com/tencent/mobileqq/msf/core/s:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   618: invokevirtual 768	com/tencent/mobileqq/msf/core/net/h:c	()V
    //   621: aload_0
    //   622: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   625: invokevirtual 708	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/m;
    //   628: iconst_0
    //   629: lload 5
    //   631: ldc2_w 769
    //   634: ldiv
    //   635: aload_0
    //   636: getfield 158	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   639: aload_1
    //   640: getstatic 488	com/tencent/mobileqq/msf/core/s:t	I
    //   643: lload 5
    //   645: aload_0
    //   646: getfield 89	com/tencent/mobileqq/msf/core/net/g:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   649: invokevirtual 678	java/util/concurrent/atomic/AtomicLong:get	()J
    //   652: aload_0
    //   653: getfield 91	com/tencent/mobileqq/msf/core/net/g:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   656: invokevirtual 678	java/util/concurrent/atomic/AtomicLong:get	()J
    //   659: aload 8
    //   661: aload 9
    //   663: invokevirtual 773	com/tencent/mobileqq/msf/core/c/m:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   666: ldc 198
    //   668: iconst_1
    //   669: new 200	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 775
    //   679: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 7
    //   684: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 777
    //   690: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_1
    //   694: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_0
    //   704: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   707: aconst_null
    //   708: putfield 545	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   711: aload_0
    //   712: aconst_null
    //   713: putfield 158	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   716: aload_0
    //   717: getfield 89	com/tencent/mobileqq/msf/core/net/g:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   720: lconst_0
    //   721: invokevirtual 422	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   724: aload_0
    //   725: getfield 91	com/tencent/mobileqq/msf/core/net/g:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   728: lconst_0
    //   729: invokevirtual 422	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   732: invokestatic 782	com/tencent/qphone/base/util/CodecWarpper:onConnClose	()V
    //   735: aload_1
    //   736: invokestatic 785	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   739: aload_0
    //   740: getfield 464	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/d;
    //   743: ifnull +28 -> 771
    //   746: aload_0
    //   747: getfield 464	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/d;
    //   750: aload_1
    //   751: invokevirtual 788	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   754: ifeq +17 -> 771
    //   757: aload_0
    //   758: getfield 111	com/tencent/mobileqq/msf/core/net/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   761: invokevirtual 792	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/d;
    //   764: aload_0
    //   765: getfield 464	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/d;
    //   768: invokevirtual 797	com/tencent/mobileqq/msf/core/a/d:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   771: aload_0
    //   772: aconst_null
    //   773: putfield 464	com/tencent/mobileqq/msf/core/net/g:z	Lcom/tencent/mobileqq/msf/core/d;
    //   776: ldc_w 468
    //   779: putstatic 470	com/tencent/mobileqq/msf/core/s:r	Ljava/lang/String;
    //   782: ldc_w 799
    //   785: putstatic 481	com/tencent/mobileqq/msf/core/s:s	Ljava/lang/String;
    //   788: return
    //   789: astore_1
    //   790: aload_1
    //   791: invokevirtual 659	java/lang/Exception:printStackTrace	()V
    //   794: return
    //   795: astore 8
    //   797: aload 8
    //   799: invokevirtual 800	java/lang/Throwable:printStackTrace	()V
    //   802: goto -290 -> 512
    //   805: astore 8
    //   807: goto -289 -> 518
    //   810: astore 8
    //   812: iconst_1
    //   813: istore_3
    //   814: aload_0
    //   815: getfield 107	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   818: invokevirtual 522	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   821: aload 8
    //   823: athrow
    //   824: astore 8
    //   826: ldc 198
    //   828: iconst_1
    //   829: new 200	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   836: ldc_w 802
    //   839: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload 8
    //   844: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   847: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: aload 8
    //   852: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   855: goto -312 -> 543
    //   858: aload_0
    //   859: getfield 449	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   862: ifnull +14 -> 876
    //   865: aload_0
    //   866: getfield 449	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   869: getfield 728	com/tencent/mobileqq/msf/core/net/g$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   872: iconst_0
    //   873: invokevirtual 314	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   876: ldc 198
    //   878: iconst_1
    //   879: ldc_w 804
    //   882: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   885: aload_0
    //   886: getfield 102	com/tencent/mobileqq/msf/core/net/g:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   889: iconst_1
    //   890: invokevirtual 314	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   893: iload 4
    //   895: istore_3
    //   896: aload_0
    //   897: getfield 84	com/tencent/mobileqq/msf/core/net/g:A	Ljava/util/concurrent/atomic/AtomicInteger;
    //   900: iconst_1
    //   901: invokevirtual 807	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   904: bipush 10
    //   906: if_icmpne -363 -> 543
    //   909: invokestatic 812	android/os/Process:myPid	()I
    //   912: invokestatic 815	android/os/Process:killProcess	(I)V
    //   915: iload 4
    //   917: istore_3
    //   918: goto -375 -> 543
    //   921: astore 8
    //   923: iconst_1
    //   924: istore_3
    //   925: goto -99 -> 826
    //   928: astore 7
    //   930: ldc 198
    //   932: iconst_1
    //   933: new 200	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   940: ldc_w 817
    //   943: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload 7
    //   948: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   951: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: aload 7
    //   956: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   959: goto -224 -> 735
    //   962: astore 8
    //   964: iconst_1
    //   965: istore_3
    //   966: ldc 75
    //   968: astore 7
    //   970: goto -144 -> 826
    //   973: astore 8
    //   975: goto -149 -> 826
    //   978: astore 8
    //   980: goto -166 -> 814
    //   983: astore 8
    //   985: goto -510 -> 475
    //   988: astore 8
    //   990: goto -547 -> 443
    //   993: iconst_0
    //   994: istore_2
    //   995: ldc 75
    //   997: astore 7
    //   999: goto -887 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1002	0	this	g
    //   0	1002	1	parama	com.tencent.qphone.base.a
    //   111	884	2	i1	int
    //   373	593	3	bool1	boolean
    //   349	567	4	bool2	boolean
    //   581	63	5	l1	long
    //   102	581	7	str1	String
    //   928	27	7	localException1	Exception
    //   968	30	7	str2	String
    //   86	574	8	localObject1	Object
    //   795	3	8	localThrowable1	Throwable
    //   805	1	8	localThrowable2	Throwable
    //   810	12	8	localObject2	Object
    //   824	27	8	localThrowable3	Throwable
    //   921	1	8	localThrowable4	Throwable
    //   962	1	8	localThrowable5	Throwable
    //   973	1	8	localThrowable6	Throwable
    //   978	1	8	localObject3	Object
    //   983	1	8	localException2	Exception
    //   988	1	8	localThrowable7	Throwable
    //   606	56	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   739	771	789	java/lang/Exception
    //   771	788	789	java/lang/Exception
    //   498	512	795	java/lang/Throwable
    //   491	498	805	java/lang/Throwable
    //   512	518	805	java/lang/Throwable
    //   797	802	805	java/lang/Throwable
    //   378	405	810	finally
    //   814	824	824	java/lang/Throwable
    //   360	374	921	java/lang/Throwable
    //   858	876	921	java/lang/Throwable
    //   876	893	921	java/lang/Throwable
    //   896	915	921	java/lang/Throwable
    //   732	735	928	java/lang/Exception
    //   351	360	962	java/lang/Throwable
    //   536	543	973	java/lang/Throwable
    //   405	423	978	finally
    //   423	443	978	finally
    //   443	449	978	finally
    //   454	475	978	finally
    //   475	486	978	finally
    //   491	498	978	finally
    //   498	512	978	finally
    //   512	518	978	finally
    //   518	536	978	finally
    //   797	802	978	finally
    //   454	475	983	java/lang/Exception
    //   423	443	988	java/lang/Throwable
  }
  
  public boolean a()
  {
    return this.r;
  }
  
  public boolean b()
  {
    return this.s.get();
  }
  
  public long c()
  {
    return this.q;
  }
  
  public void d()
  {
    try
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "MSF");
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setMsfCommand(MsfCommand.msf_ssoping);
      long l1 = com.tencent.mobileqq.msf.core.a.a.o();
      if (l1 > 10000L) {
        localToServiceMsg.setTimeout(l1);
      }
      for (;;)
      {
        QLog.d("MSF.C.NetConnTag", 1, "ssoping seq: " + localToServiceMsg.getRequestSsoSeq() + " timeout: " + localToServiceMsg.getTimeout());
        int i1 = "MSF".getBytes().length + 13 + 1 + 0 + 4;
        byte b1 = (byte)"MSF".getBytes().length;
        ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
        localByteBuffer.putInt(i1).putInt(20140601).putInt(0).put(b1).put("MSF".getBytes()).put((byte)0).putInt(0);
        localToServiceMsg.putWupBuffer(localByteBuffer.array());
        this.w = localToServiceMsg;
        this.y.sender.c(localToServiceMsg);
        localToServiceMsg.getAttributes().put("__timestamp_msf2net", Long.valueOf(SystemClock.elapsedRealtime()));
        if (a(this.y.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null) <= 0) {
          break;
        }
        return;
        localToServiceMsg.setTimeout(10000L);
      }
      this.y.sender.c(localException.getRequestSsoSeq());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail, exception ", localException);
      return;
    }
    this.y.sender.d(localException);
    QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail");
  }
  
  public ToServiceMsg e()
  {
    if (this.w != null)
    {
      this.y.sender.c(this.w.getRequestSsoSeq());
      this.y.sender.d(this.w);
    }
    return this.w;
  }
  
  class a
    extends Thread
  {
    AtomicBoolean a = new AtomicBoolean(true);
    long b = SystemClock.elapsedRealtime();
    
    a() {}
    
    public void run()
    {
      while (this.a.get()) {
        try
        {
          while (!g.this.k.isDataAvailable(g.this.f)) {
            if (!this.a.get()) {
              return;
            }
          }
          if (!this.a.get()) {
            break;
          }
          g.this.i.a(g.this.k);
          g.this.p.addAndGet(g.this.k.getBufferlen());
          g.this.k.reset();
        }
        catch (Throwable localThrowable)
        {
          this.a.set(false);
          QLog.d("MSF.C.NetConnTag", 1, "read DataError " + localThrowable);
          g.this.a(com.tencent.qphone.base.a.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.g
 * JD-Core Version:    0.7.0.1
 */