package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class i
  implements IBinder.DeathRecipient
{
  private static final int A = 0;
  private static int B = 0;
  private static int C = 3;
  public static final int a = 2;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 3;
  public static final boolean e = true;
  private static final int h = 500;
  private static final String i = "GuardManager";
  private static final String j = "gm_history";
  private static final int k = 1;
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 4;
  private static final int o = 5;
  private static long p = 720000L;
  private static long r = 0L;
  private static final int y = 2;
  private static final int z = 1;
  public boolean f = false;
  public volatile boolean g = false;
  private IBinder q;
  private int s = 1;
  private long t = 0L;
  private a u;
  private a v;
  private a w;
  private MsfCore x;
  
  public i(MsfCore paramMsfCore)
  {
    this.x = paramMsfCore;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i1 = 1;
    paramInt1 = 1;
    Object localObject;
    if (paramInt3 != 0)
    {
      if (paramInt3 == 2) {
        paramInt1 = 2;
      }
      B = paramInt1;
      localObject = Calendar.getInstance(Locale.getDefault());
      ((Calendar)localObject).setTimeInMillis(paramLong - 15000L);
      paramInt1 = ((Calendar)localObject).get(7);
      paramLong = ((Calendar)localObject).get(11) * 60 * 60 * 1000 + paramLong % 3600000L;
      if (B != 2) {
        break label150;
      }
      if (!paramBoolean) {
        break label143;
      }
      localObject = "11";
    }
    for (;;)
    {
      a("GM_StartTime", paramLong, (String)localObject);
      C = paramInt2;
      a(0L, paramLong, paramInt1);
      return;
      if (B != 0) {
        break;
      }
      paramInt1 = i1;
      if (new Random().nextInt(2) == 0) {
        paramInt1 = 2;
      }
      B = paramInt1;
      break;
      label143:
      localObject = "10";
      continue;
      label150:
      if (paramBoolean) {
        localObject = "01";
      } else {
        localObject = "00";
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    if (paramLong1 != 0L)
    {
      localObject = Calendar.getInstance(Locale.getDefault());
      ((Calendar)localObject).setTimeInMillis(paramLong1 - 15000L);
      paramInt = ((Calendar)localObject).get(7);
      paramLong2 = ((Calendar)localObject).get(11) * 60 * 60 * 1000 + paramLong1 % 3600000L;
    }
    if (this.w == null) {
      d();
    }
    Object localObject = this.w;
    if (paramLong1 == 0L)
    {
      bool1 = true;
      ((a)localObject).a(paramLong2, bool1);
      if ((paramInt == 1) || (paramInt == 7)) {
        break label152;
      }
      localObject = this.u;
      if (paramLong1 != 0L) {
        break label146;
      }
    }
    label146:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a)localObject).a(paramLong2, bool1);
      e();
      return;
      bool1 = false;
      break;
    }
    label152:
    localObject = this.v;
    if (paramLong1 == 0L) {}
    for (bool1 = bool3;; bool1 = false)
    {
      ((a)localObject).a(paramLong2, bool1);
      break;
    }
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    HashMap localHashMap = null;
    if (paramString2 != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("Tag", paramString2);
    }
    this.x.getStatReporter().a(paramString1, true, paramLong, 0L, localHashMap, false, false);
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: new 172	java/io/ObjectInputStream
    //   9: dup
    //   10: invokestatic 178	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   13: ldc 31
    //   15: invokevirtual 184	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   18: invokespecial 187	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore 7
    //   23: aload 7
    //   25: astore 6
    //   27: aload 7
    //   29: invokevirtual 191	java/io/ObjectInputStream:readByte	()B
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +85 -> 119
    //   37: bipush 24
    //   39: iload_2
    //   40: irem
    //   41: ifne +78 -> 119
    //   44: aload 7
    //   46: astore 6
    //   48: iload_2
    //   49: newarray long
    //   51: astore 8
    //   53: aload 7
    //   55: astore 6
    //   57: iload_2
    //   58: newarray long
    //   60: astore 9
    //   62: iload_1
    //   63: iload_2
    //   64: if_icmpge +36 -> 100
    //   67: aload 7
    //   69: astore 6
    //   71: aload 9
    //   73: iload_1
    //   74: aload 7
    //   76: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   79: lastore
    //   80: aload 7
    //   82: astore 6
    //   84: aload 8
    //   86: iload_1
    //   87: aload 7
    //   89: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   92: lastore
    //   93: iload_1
    //   94: iconst_1
    //   95: iadd
    //   96: istore_1
    //   97: goto -35 -> 62
    //   100: aload 7
    //   102: astore 6
    //   104: aload_0
    //   105: new 8	com/tencent/mobileqq/msf/service/i$a
    //   108: dup
    //   109: aload 9
    //   111: aload 8
    //   113: invokespecial 197	com/tencent/mobileqq/msf/service/i$a:<init>	([J[J)V
    //   116: putfield 140	com/tencent/mobileqq/msf/service/i:u	Lcom/tencent/mobileqq/msf/service/i$a;
    //   119: aload 7
    //   121: astore 6
    //   123: aload 7
    //   125: invokevirtual 200	java/io/ObjectInputStream:readInt	()I
    //   128: putstatic 69	com/tencent/mobileqq/msf/service/i:C	I
    //   131: aload 7
    //   133: astore 6
    //   135: aload 7
    //   137: invokevirtual 200	java/io/ObjectInputStream:readInt	()I
    //   140: putstatic 67	com/tencent/mobileqq/msf/service/i:B	I
    //   143: aload 7
    //   145: astore 6
    //   147: aload 7
    //   149: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   152: lstore 4
    //   154: lload 4
    //   156: ldc2_w 201
    //   159: lcmp
    //   160: ifgt +492 -> 652
    //   163: lload 4
    //   165: l2i
    //   166: istore_1
    //   167: iload_1
    //   168: ifeq +106 -> 274
    //   171: bipush 24
    //   173: iload_1
    //   174: irem
    //   175: ifne +99 -> 274
    //   178: aload 7
    //   180: astore 6
    //   182: iload_1
    //   183: newarray long
    //   185: astore 8
    //   187: aload 7
    //   189: astore 6
    //   191: iload_1
    //   192: newarray long
    //   194: astore 9
    //   196: aload 9
    //   198: iconst_0
    //   199: lload 4
    //   201: lastore
    //   202: aload 7
    //   204: astore 6
    //   206: aload 8
    //   208: iconst_0
    //   209: aload 7
    //   211: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   214: lastore
    //   215: iconst_1
    //   216: istore_2
    //   217: iload_2
    //   218: iload_1
    //   219: if_icmpge +36 -> 255
    //   222: aload 7
    //   224: astore 6
    //   226: aload 9
    //   228: iload_2
    //   229: aload 7
    //   231: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   234: lastore
    //   235: aload 7
    //   237: astore 6
    //   239: aload 8
    //   241: iload_2
    //   242: aload 7
    //   244: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   247: lastore
    //   248: iload_2
    //   249: iconst_1
    //   250: iadd
    //   251: istore_2
    //   252: goto -35 -> 217
    //   255: aload 7
    //   257: astore 6
    //   259: aload_0
    //   260: new 8	com/tencent/mobileqq/msf/service/i$a
    //   263: dup
    //   264: aload 9
    //   266: aload 8
    //   268: invokespecial 197	com/tencent/mobileqq/msf/service/i$a:<init>	([J[J)V
    //   271: putfield 144	com/tencent/mobileqq/msf/service/i:v	Lcom/tencent/mobileqq/msf/service/i$a;
    //   274: aload 7
    //   276: astore 6
    //   278: aload 7
    //   280: invokevirtual 200	java/io/ObjectInputStream:readInt	()I
    //   283: istore_2
    //   284: iload_2
    //   285: ifeq +106 -> 391
    //   288: bipush 24
    //   290: iload_2
    //   291: irem
    //   292: ifne +99 -> 391
    //   295: aload 7
    //   297: astore 6
    //   299: iload_2
    //   300: newarray long
    //   302: astore 8
    //   304: aload 7
    //   306: astore 6
    //   308: iload_2
    //   309: newarray long
    //   311: astore 9
    //   313: aload 9
    //   315: iconst_0
    //   316: lload 4
    //   318: lastore
    //   319: aload 7
    //   321: astore 6
    //   323: aload 8
    //   325: iconst_0
    //   326: aload 7
    //   328: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   331: lastore
    //   332: iload_3
    //   333: istore_1
    //   334: iload_1
    //   335: iload_2
    //   336: if_icmpge +36 -> 372
    //   339: aload 7
    //   341: astore 6
    //   343: aload 9
    //   345: iload_1
    //   346: aload 7
    //   348: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   351: lastore
    //   352: aload 7
    //   354: astore 6
    //   356: aload 8
    //   358: iload_1
    //   359: aload 7
    //   361: invokevirtual 194	java/io/ObjectInputStream:readLong	()J
    //   364: lastore
    //   365: iload_1
    //   366: iconst_1
    //   367: iadd
    //   368: istore_1
    //   369: goto -35 -> 334
    //   372: aload 7
    //   374: astore 6
    //   376: aload_0
    //   377: new 8	com/tencent/mobileqq/msf/service/i$a
    //   380: dup
    //   381: aload 9
    //   383: aload 8
    //   385: invokespecial 197	com/tencent/mobileqq/msf/service/i$a:<init>	([J[J)V
    //   388: putfield 133	com/tencent/mobileqq/msf/service/i:w	Lcom/tencent/mobileqq/msf/service/i$a;
    //   391: aload 7
    //   393: ifnull +8 -> 401
    //   396: aload 7
    //   398: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   401: aload_0
    //   402: getfield 133	com/tencent/mobileqq/msf/service/i:w	Lcom/tencent/mobileqq/msf/service/i$a;
    //   405: ifnonnull +55 -> 460
    //   408: aload_0
    //   409: getfield 140	com/tencent/mobileqq/msf/service/i:u	Lcom/tencent/mobileqq/msf/service/i$a;
    //   412: ifnull +231 -> 643
    //   415: aload_0
    //   416: getfield 140	com/tencent/mobileqq/msf/service/i:u	Lcom/tencent/mobileqq/msf/service/i$a;
    //   419: getfield 208	com/tencent/mobileqq/msf/service/i$a:a	[J
    //   422: invokevirtual 213	[J:clone	()Ljava/lang/Object;
    //   425: checkcast 209	[J
    //   428: astore 6
    //   430: aload_0
    //   431: getfield 140	com/tencent/mobileqq/msf/service/i:u	Lcom/tencent/mobileqq/msf/service/i$a;
    //   434: getfield 215	com/tencent/mobileqq/msf/service/i$a:b	[J
    //   437: invokevirtual 213	[J:clone	()Ljava/lang/Object;
    //   440: checkcast 209	[J
    //   443: astore 7
    //   445: aload_0
    //   446: new 8	com/tencent/mobileqq/msf/service/i$a
    //   449: dup
    //   450: aload 6
    //   452: aload 7
    //   454: invokespecial 197	com/tencent/mobileqq/msf/service/i$a:<init>	([J[J)V
    //   457: putfield 133	com/tencent/mobileqq/msf/service/i:w	Lcom/tencent/mobileqq/msf/service/i$a;
    //   460: aload_0
    //   461: getfield 140	com/tencent/mobileqq/msf/service/i:u	Lcom/tencent/mobileqq/msf/service/i$a;
    //   464: ifnonnull +16 -> 480
    //   467: aload_0
    //   468: new 8	com/tencent/mobileqq/msf/service/i$a
    //   471: dup
    //   472: aconst_null
    //   473: aconst_null
    //   474: invokespecial 197	com/tencent/mobileqq/msf/service/i$a:<init>	([J[J)V
    //   477: putfield 140	com/tencent/mobileqq/msf/service/i:u	Lcom/tencent/mobileqq/msf/service/i$a;
    //   480: aload_0
    //   481: getfield 144	com/tencent/mobileqq/msf/service/i:v	Lcom/tencent/mobileqq/msf/service/i$a;
    //   484: ifnonnull +16 -> 500
    //   487: aload_0
    //   488: new 8	com/tencent/mobileqq/msf/service/i$a
    //   491: dup
    //   492: aconst_null
    //   493: aconst_null
    //   494: invokespecial 197	com/tencent/mobileqq/msf/service/i$a:<init>	([J[J)V
    //   497: putfield 144	com/tencent/mobileqq/msf/service/i:v	Lcom/tencent/mobileqq/msf/service/i$a;
    //   500: aload_0
    //   501: monitorexit
    //   502: return
    //   503: astore 8
    //   505: aconst_null
    //   506: astore 7
    //   508: aload 7
    //   510: astore 6
    //   512: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   515: ifeq +17 -> 532
    //   518: aload 7
    //   520: astore 6
    //   522: ldc 28
    //   524: iconst_2
    //   525: ldc 223
    //   527: aload 8
    //   529: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   532: aload 7
    //   534: ifnull -133 -> 401
    //   537: aload 7
    //   539: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   542: goto -141 -> 401
    //   545: astore 6
    //   547: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq -149 -> 401
    //   553: ldc 28
    //   555: iconst_2
    //   556: ldc 228
    //   558: aload 6
    //   560: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   563: goto -162 -> 401
    //   566: astore 6
    //   568: aload_0
    //   569: monitorexit
    //   570: aload 6
    //   572: athrow
    //   573: astore 7
    //   575: aconst_null
    //   576: astore 6
    //   578: aload 6
    //   580: ifnull +8 -> 588
    //   583: aload 6
    //   585: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   588: aload 7
    //   590: athrow
    //   591: astore 6
    //   593: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   596: ifeq -8 -> 588
    //   599: ldc 28
    //   601: iconst_2
    //   602: ldc 228
    //   604: aload 6
    //   606: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   609: goto -21 -> 588
    //   612: astore 6
    //   614: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq -216 -> 401
    //   620: ldc 28
    //   622: iconst_2
    //   623: ldc 228
    //   625: aload 6
    //   627: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   630: goto -229 -> 401
    //   633: astore 7
    //   635: goto -57 -> 578
    //   638: astore 8
    //   640: goto -132 -> 508
    //   643: aconst_null
    //   644: astore 7
    //   646: aconst_null
    //   647: astore 6
    //   649: goto -204 -> 445
    //   652: iload_2
    //   653: istore_1
    //   654: goto -487 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	this	i
    //   3	651	1	i1	int
    //   32	621	2	i2	int
    //   1	332	3	i3	int
    //   152	165	4	l1	long
    //   25	496	6	localObject1	Object
    //   545	14	6	localIOException1	java.io.IOException
    //   566	5	6	localObject2	Object
    //   576	8	6	localObject3	Object
    //   591	14	6	localIOException2	java.io.IOException
    //   612	14	6	localIOException3	java.io.IOException
    //   647	1	6	localObject4	Object
    //   21	517	7	localObject5	Object
    //   573	16	7	localObject6	Object
    //   633	1	7	localObject7	Object
    //   644	1	7	localObject8	Object
    //   51	333	8	arrayOfLong1	long[]
    //   503	25	8	localThrowable1	Throwable
    //   638	1	8	localThrowable2	Throwable
    //   60	322	9	arrayOfLong2	long[]
    // Exception table:
    //   from	to	target	type
    //   6	23	503	java/lang/Throwable
    //   537	542	545	java/io/IOException
    //   396	401	566	finally
    //   401	445	566	finally
    //   445	460	566	finally
    //   460	480	566	finally
    //   480	500	566	finally
    //   537	542	566	finally
    //   547	563	566	finally
    //   583	588	566	finally
    //   588	591	566	finally
    //   593	609	566	finally
    //   614	630	566	finally
    //   6	23	573	finally
    //   583	588	591	java/io/IOException
    //   396	401	612	java/io/IOException
    //   27	33	633	finally
    //   48	53	633	finally
    //   57	62	633	finally
    //   71	80	633	finally
    //   84	93	633	finally
    //   104	119	633	finally
    //   123	131	633	finally
    //   135	143	633	finally
    //   147	154	633	finally
    //   182	187	633	finally
    //   191	196	633	finally
    //   206	215	633	finally
    //   226	235	633	finally
    //   239	248	633	finally
    //   259	274	633	finally
    //   278	284	633	finally
    //   299	304	633	finally
    //   308	313	633	finally
    //   323	332	633	finally
    //   343	352	633	finally
    //   356	365	633	finally
    //   376	391	633	finally
    //   512	518	633	finally
    //   522	532	633	finally
    //   27	33	638	java/lang/Throwable
    //   48	53	638	java/lang/Throwable
    //   57	62	638	java/lang/Throwable
    //   71	80	638	java/lang/Throwable
    //   84	93	638	java/lang/Throwable
    //   104	119	638	java/lang/Throwable
    //   123	131	638	java/lang/Throwable
    //   135	143	638	java/lang/Throwable
    //   147	154	638	java/lang/Throwable
    //   182	187	638	java/lang/Throwable
    //   191	196	638	java/lang/Throwable
    //   206	215	638	java/lang/Throwable
    //   226	235	638	java/lang/Throwable
    //   239	248	638	java/lang/Throwable
    //   259	274	638	java/lang/Throwable
    //   278	284	638	java/lang/Throwable
    //   299	304	638	java/lang/Throwable
    //   308	313	638	java/lang/Throwable
    //   323	332	638	java/lang/Throwable
    //   343	352	638	java/lang/Throwable
    //   356	365	638	java/lang/Throwable
    //   376	391	638	java/lang/Throwable
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 230	java/io/ObjectOutputStream
    //   5: dup
    //   6: invokestatic 178	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   9: ldc 31
    //   11: iconst_0
    //   12: invokevirtual 234	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   15: invokespecial 237	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 140	com/tencent/mobileqq/msf/service/i:u	Lcom/tencent/mobileqq/msf/service/i$a;
    //   25: aload_2
    //   26: iconst_0
    //   27: invokevirtual 240	com/tencent/mobileqq/msf/service/i$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: getstatic 69	com/tencent/mobileqq/msf/service/i:C	I
    //   36: invokevirtual 244	java/io/ObjectOutputStream:writeInt	(I)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: getstatic 67	com/tencent/mobileqq/msf/service/i:B	I
    //   45: invokevirtual 244	java/io/ObjectOutputStream:writeInt	(I)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 144	com/tencent/mobileqq/msf/service/i:v	Lcom/tencent/mobileqq/msf/service/i$a;
    //   54: aload_2
    //   55: iconst_1
    //   56: invokevirtual 240	com/tencent/mobileqq/msf/service/i$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 133	com/tencent/mobileqq/msf/service/i:w	Lcom/tencent/mobileqq/msf/service/i$a;
    //   65: aload_2
    //   66: iconst_0
    //   67: invokevirtual 240	com/tencent/mobileqq/msf/service/i$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   70: aload_2
    //   71: ifnull +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 245	java/io/ObjectOutputStream:close	()V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +14 -> 103
    //   92: aload_2
    //   93: astore_1
    //   94: ldc 28
    //   96: iconst_2
    //   97: ldc 228
    //   99: aload_3
    //   100: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull -26 -> 78
    //   107: aload_2
    //   108: invokevirtual 245	java/io/ObjectOutputStream:close	()V
    //   111: goto -33 -> 78
    //   114: astore_1
    //   115: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq -40 -> 78
    //   121: ldc 28
    //   123: iconst_2
    //   124: ldc 228
    //   126: aload_1
    //   127: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: goto -52 -> 78
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_2
    //   139: aconst_null
    //   140: astore_1
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 245	java/io/ObjectOutputStream:close	()V
    //   149: aload_2
    //   150: athrow
    //   151: astore_1
    //   152: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq -6 -> 149
    //   158: ldc 28
    //   160: iconst_2
    //   161: ldc 228
    //   163: aload_1
    //   164: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: goto -18 -> 149
    //   170: astore_1
    //   171: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -96 -> 78
    //   177: ldc 28
    //   179: iconst_2
    //   180: ldc 228
    //   182: aload_1
    //   183: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   186: goto -108 -> 78
    //   189: astore_2
    //   190: goto -49 -> 141
    //   193: astore_3
    //   194: goto -110 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	i
    //   20	74	1	localObjectOutputStream1	ObjectOutputStream
    //   114	13	1	localIOException1	java.io.IOException
    //   133	4	1	localObject1	Object
    //   140	6	1	localObject2	Object
    //   151	13	1	localIOException2	java.io.IOException
    //   170	13	1	localIOException3	java.io.IOException
    //   18	90	2	localObjectOutputStream2	ObjectOutputStream
    //   138	12	2	localObject3	Object
    //   189	1	2	localObject4	Object
    //   81	19	3	localThrowable1	Throwable
    //   193	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	19	81	java/lang/Throwable
    //   107	111	114	java/io/IOException
    //   74	78	133	finally
    //   107	111	133	finally
    //   115	130	133	finally
    //   145	149	133	finally
    //   149	151	133	finally
    //   152	167	133	finally
    //   171	186	133	finally
    //   2	19	138	finally
    //   145	149	151	java/io/IOException
    //   74	78	170	java/io/IOException
    //   21	30	189	finally
    //   32	39	189	finally
    //   41	48	189	finally
    //   50	59	189	finally
    //   61	70	189	finally
    //   86	92	189	finally
    //   94	103	189	finally
    //   21	30	193	java/lang/Throwable
    //   32	39	193	java/lang/Throwable
    //   41	48	193	java/lang/Throwable
    //   50	59	193	java/lang/Throwable
    //   61	70	193	java/lang/Throwable
  }
  
  private boolean f()
  {
    IBinder localIBinder = this.q;
    return (localIBinder != null) && (localIBinder.isBinderAlive());
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "onEvent:" + paramInt + ", " + paramLong1 + ", " + paramLong2);
    }
    long l1 = System.currentTimeMillis();
    this.t = l1;
    this.g = true;
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      paramInt = (int)(paramLong1 >> 8);
      int i1 = (int)(0xFF & paramLong1);
      if ((0xFF & paramLong2) == 1L) {}
      for (boolean bool = true;; bool = false)
      {
        a(l1, paramInt, i1, bool, (int)(paramLong2 >> 8));
        return;
      }
    case 100: 
      r = l1;
      this.s = 1;
      this.g = false;
      return;
    case 1: 
      this.s = 2;
      return;
    case 3: 
      this.s = 4;
      return;
    case 2: 
      this.s = 3;
      p = paramLong1;
      return;
    case 4: 
      this.s = 5;
      p = paramLong1;
      return;
    case 6: 
      MsfService.getCore().pushManager.j();
      MsfService.getCore().pushManager.k();
      return;
    }
    a(l1, 0L, 0);
  }
  
  public void a(IInterface paramIInterface)
  {
    IBinder localIBinder;
    if (paramIInterface != null) {
      localIBinder = paramIInterface.asBinder();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "onAppBind with " + paramIInterface);
      }
      paramIInterface = this.q;
      long l1;
      if (paramIInterface != localIBinder)
      {
        l1 = System.currentTimeMillis();
        if (paramIInterface != null)
        {
          paramIInterface.unlinkToDeath(this, 0);
          this.q = null;
          r = l1;
          this.t = l1;
        }
        if ((localIBinder == null) || (!localIBinder.isBinderAlive())) {}
      }
      try
      {
        localIBinder.linkToDeath(this, 0);
        this.q = localIBinder;
        r = l1;
        return;
        localIBinder = null;
      }
      catch (RemoteException paramIInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("GuardManager", 2, "onAppBind ", paramIInterface);
      }
    }
  }
  
  public boolean a()
  {
    return (this.g) && (f());
  }
  
  public boolean a(int paramInt)
  {
    if (this.f) {}
    long l1;
    int i1;
    do
    {
      return true;
      this.f = true;
      l1 = System.currentTimeMillis();
      l2 = Math.abs(l1 - r);
      if ((this.s == 2) || (this.s == 4)) {}
      for (i1 = 1; ((paramInt == 3) && (l2 > 500L) && (!this.g) && (f())) || ((paramInt == 1) && (l2 > p) && (!f()) && (i1 == 0)) || ((paramInt == 0) && (l2 > 500L) && (!f())); i1 = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "prestart " + paramInt + ", " + l1 + ", " + r + ", " + p);
        }
        localObject = new Intent("com.tencent.mobileqq.broadcast.qq");
        ((Intent)localObject).putExtra("k_start_mode", paramInt);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        r = l1;
        a("GM_LiteStart", 0L, "" + paramInt);
        return true;
      }
    } while ((paramInt != 2) || (l2 <= p) || (f()) || (i1 != 0));
    if (this.w == null) {
      d();
    }
    Object localObject = Calendar.getInstance(Locale.getDefault());
    ((Calendar)localObject).setTimeInMillis(l1);
    long l2 = ((Calendar)localObject).get(11) * 60 * 60 * 1000 + l1 % 3600000L;
    boolean bool;
    if (B == 2)
    {
      paramInt = ((Calendar)localObject).get(7);
      if ((paramInt != 1) && (paramInt != 7))
      {
        bool = this.u.a(l2);
        label367:
        if (!bool) {
          break label457;
        }
        localObject = new Intent("com.tencent.mobileqq.broadcast.qq");
        ((Intent)localObject).putExtra("k_start_mode", 2);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        if (B != 2) {
          break label459;
        }
      }
    }
    label457:
    label459:
    for (localObject = "1";; localObject = "0")
    {
      a("GM_PreStart", l2, (String)localObject);
      r = l1;
      return true;
      bool = this.v.a(l2);
      break label367;
      bool = this.w.a(l2);
      break label367;
      break;
    }
  }
  
  public void binderDied()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "binderDied");
    }
    IBinder localIBinder = this.q;
    if (localIBinder != null)
    {
      localIBinder.unlinkToDeath(this, 0);
      this.q = null;
      r = System.currentTimeMillis();
      this.g = false;
      long l1 = r - this.t;
      if ((l1 > 0L) && (l1 < 86400000L)) {
        a("GM_AliveTime" + this.s, l1, null);
      }
    }
  }
  
  private static class a
  {
    public long[] a = null;
    public long[] b = null;
    
    public a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      this.a = paramArrayOfLong1;
      this.b = paramArrayOfLong2;
    }
    
    public void a(long paramLong, boolean paramBoolean)
    {
      if (this.a == null)
      {
        this.a = new long[1];
        this.a[0] = paramLong;
        this.b = new long[1];
      }
      long l1;
      int j;
      Object localObject;
      int i;
      if (paramBoolean)
      {
        l1 = 2L;
        j = Arrays.binarySearch(this.a, paramLong);
        localObject = new StringBuilder().append(paramLong).append(" is the ");
        if (j >= 0) {
          break label289;
        }
        i = -j - 1;
        label77:
        QLog.d("GuardManager", 2, i + "th of " + Arrays.toString(this.a));
        if (j >= 0) {
          break label845;
        }
        i = -j - 1;
        if (i <= 0) {
          break label929;
        }
      }
      label918:
      label929:
      for (long l2 = paramLong - this.a[(i - 1)];; l2 = 9223372036854775807L)
      {
        if (i < this.a.length) {}
        for (long l3 = this.a[i] - paramLong;; l3 = 9223372036854775807L)
        {
          if ((l2 <= i.b() * 2L) || (l3 <= i.b() * 2L))
          {
            if (l2 >= l3) {
              break label918;
            }
            i -= 1;
          }
          for (;;)
          {
            this.a[i] = (this.a[i] * this.b[i] + paramLong * l1);
            localObject = this.b;
            localObject[i] = (l1 + localObject[i]);
            localObject = this.a;
            localObject[i] /= this.b[i];
            for (;;)
            {
              QLog.d("GuardManager", 2, Arrays.toString(this.a));
              return;
              l1 = 1L;
              break;
              label289:
              i = j;
              break label77;
              int k = this.a.length;
              localObject = new ArrayList(k * 2);
              j = 0;
              while (j < i)
              {
                ((ArrayList)localObject).add(Long.valueOf(this.a[j]));
                ((ArrayList)localObject).add(Long.valueOf(this.b[j]));
                j += 1;
              }
              ((ArrayList)localObject).add(Long.valueOf(paramLong));
              ((ArrayList)localObject).add(Long.valueOf(l1));
              while (i < k)
              {
                ((ArrayList)localObject).add(Long.valueOf(this.a[i]));
                ((ArrayList)localObject).add(Long.valueOf(this.b[i]));
                i += 1;
              }
              if (((ArrayList)localObject).size() > 56)
              {
                l1 = ((Long)((ArrayList)localObject).get(0)).longValue();
                paramLong = ((Long)((ArrayList)localObject).get(1)).longValue();
                k = ((ArrayList)localObject).size() / 2;
                i = 0;
                j = 1;
                if (j < k)
                {
                  l2 = ((Long)((ArrayList)localObject).get(j * 2)).longValue();
                  long l4 = ((Long)((ArrayList)localObject).get(j * 2 + 1)).longValue();
                  if (l2 - l1 < i.b() * 3L)
                  {
                    l3 = l4 + paramLong;
                    paramLong = (l2 * l4 + l1 * paramLong) / l3;
                    l1 = l3;
                  }
                  for (;;)
                  {
                    j += 1;
                    l2 = paramLong;
                    paramLong = l1;
                    l1 = l2;
                    break;
                    ((ArrayList)localObject).set(i * 2, Long.valueOf(l1));
                    ((ArrayList)localObject).set(i * 2 + 1, Long.valueOf(paramLong));
                    i += 1;
                    l1 = l4;
                    paramLong = l2;
                  }
                }
                ((ArrayList)localObject).set(i * 2, Long.valueOf(l1));
                ((ArrayList)localObject).set(i * 2 + 1, Long.valueOf(paramLong));
                j = i + 1;
                this.a = new long[j];
                this.b = new long[j];
                i = 0;
                while (i < j)
                {
                  this.a[i] = ((Long)((ArrayList)localObject).get(i * 2)).longValue();
                  this.b[i] = ((Long)((ArrayList)localObject).get(i * 2 + 1)).longValue();
                  i += 1;
                }
              }
              else
              {
                j = ((ArrayList)localObject).size() / 2;
                this.a = new long[j];
                this.b = new long[j];
                i = 0;
                while (i < j)
                {
                  this.a[i] = ((Long)((ArrayList)localObject).get(i * 2)).longValue();
                  this.b[i] = ((Long)((ArrayList)localObject).get(i * 2 + 1)).longValue();
                  i += 1;
                }
                continue;
                label845:
                this.a[j] = (this.a[j] * this.b[j] + paramLong * l1);
                localObject = this.b;
                localObject[j] = (l1 + localObject[j]);
                localObject = this.a;
                localObject[j] /= this.b[j];
              }
            }
          }
        }
      }
    }
    
    public void a(ObjectOutputStream paramObjectOutputStream, boolean paramBoolean)
      throws Throwable
    {
      int j = 0;
      int i;
      if (this.a != null)
      {
        i = this.a.length;
        if (!paramBoolean) {
          break label68;
        }
        paramObjectOutputStream.writeLong(i);
      }
      for (;;)
      {
        if (j >= i) {
          return;
        }
        paramObjectOutputStream.writeLong(this.a[j]);
        paramObjectOutputStream.writeLong(this.b[j]);
        j += 1;
        continue;
        i = 0;
        break;
        label68:
        paramObjectOutputStream.writeByte(i);
      }
    }
    
    public boolean a(long paramLong)
    {
      if (this.a != null)
      {
        int j = Arrays.binarySearch(this.a, paramLong);
        int i = j;
        if (j < 0)
        {
          j = -j - 1;
          QLog.d("GuardManager", 2, paramLong + " is the " + j + "th of " + Arrays.toString(this.a) + ", range reaches [" + (paramLong - i.b()) + ", " + (i.b() + paramLong) + "]");
          if ((j <= 0) || (paramLong - this.a[(j - 1)] > i.b())) {
            break label197;
          }
          i = j - 1;
        }
        while (i >= 0)
        {
          int m = this.a.length;
          paramLong = this.b[i];
          i = 0;
          j = 0;
          for (;;)
          {
            if (i < m)
            {
              int k = j;
              if (this.b[i] > paramLong) {
                k = j + 1;
              }
              i += 1;
              j = k;
              continue;
              label197:
              if (j < this.a.length)
              {
                i = j;
                if (this.a[j] - paramLong <= i.b()) {
                  break;
                }
              }
              i = -1;
              break;
            }
          }
          QLog.d("GuardManager", 2, "order: " + j + ", limit: " + i.c() + ", in " + Arrays.toString(this.b));
          if (j < i.c()) {
            return true;
          }
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.i
 * JD-Core Version:    0.7.0.1
 */