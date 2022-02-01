package com.tencent.matrix;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.openglleak.hook.OpenGLHook;
import com.tencent.matrix.openglleak.statistics.e.a;
import com.tencent.matrix.openglleak.statistics.resource.ResRecordManager;
import com.tencent.matrix.report.k;
import com.tencent.matrix.report.l;
import com.tencent.matrix.report.l.a;
import com.tencent.matrix.report.l.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.a.c;
import com.tencent.matrix.trace.tracer.b.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Queue<Lcom.tencent.matrix.trace.core.a.c;>;

public enum e
  implements d.a
{
  private static boolean eLK = false;
  private static boolean eLL = false;
  private Application application;
  public volatile boolean baY = false;
  public l eLF = null;
  private volatile boolean eLG = false;
  private final MultiProcessMMKV eLH = MultiProcessMMKV.getMMKV("MatrixDelegate");
  public com.tencent.matrix.strategy.a eLI;
  private final int eLJ = 9;
  com.tencent.threadpool.i.d<?> eLM = null;
  private boolean eLN = false;
  private boolean eLO = false;
  private Runnable eLP = new Runnable()
  {
    public final void run()
    {
      ResRecordManager localResRecordManager;
      if (e.a(e.this) != null)
      {
        e.a(e.this);
        localResRecordManager = ResRecordManager.ayR();
        synchronized (localResRecordManager.eXU)
        {
          localResRecordManager.eXU.clear();
        }
      }
      synchronized (localResRecordManager.eXV)
      {
        localResRecordManager.eXV.clear();
        return;
        localObject1 = finally;
        throw localObject1;
      }
    }
  };
  private Handler eLQ = new Handler(Looper.myLooper());
  private com.tencent.matrix.openglleak.a eLR;
  
  private e() {}
  
  static String a(a.c paramc)
  {
    String str3 = paramc.toString();
    Object localObject = "";
    paramc = "";
    if (str3.contains("("))
    {
      String str1 = str3.substring(str3.indexOf("(") + 1, str3.indexOf(")"));
      String str2 = str3.substring(str3.indexOf("}") + 2);
      paramc = str2;
      localObject = str1;
      if (!str2.equals("null"))
      {
        paramc = str2;
        localObject = str1;
        if (str3.contains("@"))
        {
          paramc = str3.substring(str3.indexOf("}") + 2, str3.lastIndexOf("@"));
          localObject = str1;
        }
      }
    }
    return (String)localObject + " : " + paramc;
  }
  
  private void awd()
  {
    if (this.eLM == null) {
      this.eLM = com.tencent.threadpool.h.ahAA.b(new Runnable()
      {
        public final void run()
        {
          int i = 0;
          try
          {
            l2 = com.tencent.matrix.trace.core.a.azJ();
            l3 = com.tencent.matrix.trace.core.a.azK();
            localObject5 = com.tencent.matrix.trace.core.a.azH();
            if (l2 <= 4000L) {
              break label320;
            }
            e.c((Queue)localObject5);
            localObject6 = new HashMap();
            localObject2 = null;
            Iterator localIterator = ((Queue)localObject5).iterator();
            if (localIterator.hasNext())
            {
              localObject5 = (a.c)localIterator.next();
              String str2 = e.a((a.c)localObject5);
              Integer localInteger = (Integer)((HashMap)localObject6).get(str2);
              if (localInteger == null) {}
              for (int j = 1;; j = localInteger.intValue() + 1)
              {
                ((HashMap)localObject6).put(str2, Integer.valueOf(j));
                if ((localInteger == null) || (localInteger.intValue() + 1 <= i)) {
                  break;
                }
                i = localInteger.intValue() + 1;
                localObject2 = localObject5;
                break;
              }
            }
            if (localObject2 == null) {
              break label545;
            }
            ((a.c)localObject2).d = i;
          }
          finally
          {
            for (;;)
            {
              Object localObject5;
              Object localObject6;
              long l1;
              try
              {
                long l2;
                long l3;
                Object localObject2;
                Object localObject1;
                Log.e("MatrixDelegate", "denseMsgTracerTask, error : " + localObject3.getMessage());
                return;
                String str1 = ((a.c)localObject6).toString();
                break label573;
                localObject5 = e.a((a.c)localObject6);
                break label582;
                l1 = ((a.c)localObject6).d;
              }
              finally
              {
                com.tencent.matrix.trace.core.a.azI();
              }
              if (localObject4 == null)
              {
                localObject5 = "";
                if (localObject4 == null)
                {
                  localObject6 = "";
                  if (localObject4 == null)
                  {
                    l1 = 0L;
                    continue;
                    if (localObject6 == null)
                    {
                      localObject5 = "";
                      if (localObject6 == null) {
                        l1 = 0L;
                      }
                    }
                  }
                }
              }
            }
          }
          Log.i("MatrixDelegate", "happens Dense Message Lag, count exceeds, count=%d, duration=%d, keyMessage = %s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), localObject5 });
          localObject2 = com.tencent.matrix.trace.f.c.aAf();
          com.tencent.mm.plugin.report.f.Ozc.b(24354, new Object[] { AppMethodBeat.getVisibleScene(), localObject2, Integer.valueOf(1), MMApplicationContext.getProcessName(), BuildInfo.REV, Long.valueOf(l3), Long.valueOf(l2), localObject5, Long.valueOf(localObject1), localObject6 });
          for (;;)
          {
            com.tencent.matrix.trace.core.a.azI();
            return;
            localObject5 = ((a.c)localObject2).toString();
            break label554;
            localObject6 = e.a((a.c)localObject2);
            break label563;
            l1 = ((a.c)localObject2).d;
            break;
            label320:
            if (l3 > 4000L)
            {
              e.c((Queue)localObject5);
              localObject6 = e.b((Queue)localObject5);
              if (localObject6 != null) {
                break label505;
              }
              localObject2 = "";
              break label573;
              Log.i("MatrixDelegate", "happens Dense Message Lag, duration exceeds, count=%d, duration=%d, keyMessage = %s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), localObject2 });
              localObject6 = com.tencent.matrix.trace.f.c.aAf();
              com.tencent.mm.plugin.report.f.Ozc.b(24354, new Object[] { AppMethodBeat.getVisibleScene(), localObject6, Integer.valueOf(0), MMApplicationContext.getProcessName(), BuildInfo.REV, Long.valueOf(l3), Long.valueOf(l2), localObject2, Long.valueOf(l1), localObject5 });
            }
          }
        }
      }, 100L, 5000L);
    }
  }
  
  static a.c b(Queue<a.c> paramQueue)
  {
    a.c localc = null;
    long l = 0L;
    Iterator localIterator = paramQueue.iterator();
    paramQueue = localc;
    if (localIterator.hasNext())
    {
      localc = (a.c)localIterator.next();
      if (localc.d <= l) {
        break label56;
      }
      l = localc.d;
      paramQueue = localc;
    }
    label56:
    for (;;)
    {
      break;
      return paramQueue;
    }
  }
  
  static void c(Queue<a.c> paramQueue)
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = paramQueue.iterator();
    int i = 0;
    paramQueue = (Queue<a.c>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (a.c)localIterator.next();
      i += 1;
      paramQueue.append(localObject).append("\n");
      if (i % 10 != 0) {
        break label123;
      }
      Log.i("MatrixDelegate", "DumpDenseMsg, info = \n" + paramQueue.toString());
      paramQueue = new StringBuilder();
    }
    label123:
    for (;;)
    {
      break;
      Log.i("MatrixDelegate", "DumpDenseMsg, info.end = " + paramQueue.toString());
      return;
    }
  }
  
  private void du(boolean paramBoolean)
  {
    if (!this.baY)
    {
      Log.w("MatrixDelegate", "[onAppForeground] but matrix is never initialized, delay to notify!");
      this.eLG = true;
    }
    do
    {
      return;
      if (MMApplicationContext.isMainProcess())
      {
        MrsLogic.onForeground(paramBoolean);
        if (!paramBoolean) {
          com.tencent.threadpool.h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              e.e(e.this);
            }
          }, "MatrixDelegate");
        }
      }
      Iterator localIterator = c.avW().efL.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.matrix.d.b localb = (com.tencent.matrix.d.b)localIterator.next();
        if ((!(localb instanceof com.tencent.matrix.trace.b)) && (!(localb instanceof com.tencent.matrix.a.c))) {
          localb.onForeground(paramBoolean);
        }
      }
      if ((paramBoolean) && (eLL))
      {
        awd();
        return;
      }
    } while ((this.eLM == null) || (this.eLM.isCancelled()));
    this.eLM.cancel(true);
    this.eLM = null;
  }
  
  /* Error */
  public final void a(Application paramApplication, final c.a parama, g paramg)
  {
    // Byte code:
    //   0: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   3: ldc_w 257
    //   6: iconst_0
    //   7: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   10: putstatic 73	com/tencent/matrix/e:eLK	Z
    //   13: getstatic 193	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   16: new 665	com/tencent/matrix/e$3
    //   19: dup
    //   20: invokespecial 666	com/tencent/matrix/e$3:<init>	()V
    //   23: ldc_w 668
    //   26: invokeinterface 439 3 0
    //   31: pop
    //   32: new 670	com/tencent/matrix/MatrixDelegate$12
    //   35: dup
    //   36: getstatic 676	com/tencent/mm/app/f:hfK	Lcom/tencent/mm/app/f;
    //   39: invokespecial 679	com/tencent/matrix/MatrixDelegate$12:<init>	(Landroidx/lifecycle/q;)V
    //   42: invokevirtual 682	com/tencent/matrix/MatrixDelegate$12:alive	()V
    //   45: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   48: ldc_w 262
    //   51: iconst_1
    //   52: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   55: ifeq +1315 -> 1370
    //   58: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   61: ifne +27 -> 88
    //   64: invokestatic 685	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   67: ifne +21 -> 88
    //   70: invokestatic 688	com/tencent/mm/sdk/platformtools/MMApplicationContext:isAppBrandProcess	()Z
    //   73: ifne +15 -> 88
    //   76: invokestatic 691	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   79: ifne +9 -> 88
    //   82: invokestatic 694	com/tencent/mm/sdk/platformtools/MMApplicationContext:isImeProcess	()Z
    //   85: ifeq +1285 -> 1370
    //   88: iconst_1
    //   89: istore 10
    //   91: ldc 87
    //   93: ldc_w 696
    //   96: iconst_1
    //   97: anewarray 398	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: iload 10
    //   104: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   107: aastore
    //   108: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: iload 10
    //   113: ifeq +571 -> 684
    //   116: invokestatic 703	com/tencent/matrix/trace/a/a:azD	()Lcom/tencent/matrix/trace/a/a;
    //   119: iconst_1
    //   120: putfield 706	com/tencent/matrix/trace/a/a:fdA	Z
    //   123: aload_0
    //   124: getfield 95	com/tencent/matrix/e:eLH	Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   127: getstatic 712	com/tencent/b/a/a$a:ahaf	Lcom/tencent/b/a/a$a;
    //   130: invokevirtual 715	com/tencent/b/a/a$a:name	()Ljava/lang/String;
    //   133: iconst_0
    //   134: invokevirtual 719	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getInt	(Ljava/lang/String;I)I
    //   137: istore 9
    //   139: iload 9
    //   141: iconst_1
    //   142: if_icmpne +1234 -> 1376
    //   145: iconst_1
    //   146: istore 10
    //   148: ldc 87
    //   150: ldc_w 721
    //   153: iconst_2
    //   154: anewarray 398	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iload 10
    //   161: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: iload 9
    //   169: invokestatic 621	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: aastore
    //   173: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: new 723	com/tencent/matrix/trace/a/b$a
    //   179: dup
    //   180: invokespecial 724	com/tencent/matrix/trace/a/b$a:<init>	()V
    //   183: astore 15
    //   185: aload 15
    //   187: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   190: aload_3
    //   191: putfield 734	com/tencent/matrix/trace/a/b:fbi	Lcom/tencent/b/a/a;
    //   194: aload_0
    //   195: getfield 95	com/tencent/matrix/e:eLH	Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   198: getstatic 737	com/tencent/b/a/a$a:agZX	Lcom/tencent/b/a/a$a;
    //   201: invokevirtual 715	com/tencent/b/a/a$a:name	()Ljava/lang/String;
    //   204: iconst_0
    //   205: invokevirtual 719	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getInt	(Ljava/lang/String;I)I
    //   208: istore 8
    //   210: iload 8
    //   212: iconst_1
    //   213: if_icmpne +1238 -> 1451
    //   216: iconst_1
    //   217: istore 11
    //   219: ldc 87
    //   221: ldc_w 739
    //   224: iconst_2
    //   225: anewarray 398	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: iload 11
    //   232: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   235: aastore
    //   236: dup
    //   237: iconst_1
    //   238: iload 8
    //   240: invokestatic 621	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: aastore
    //   244: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload 15
    //   249: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   252: iload 11
    //   254: putfield 742	com/tencent/matrix/trace/a/b:fdB	Z
    //   257: aload 15
    //   259: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   262: iload 10
    //   264: putfield 745	com/tencent/matrix/trace/a/b:fdE	Z
    //   267: aload 15
    //   269: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   272: iload 10
    //   274: putfield 748	com/tencent/matrix/trace/a/b:fdC	Z
    //   277: aload_0
    //   278: getfield 95	com/tencent/matrix/e:eLH	Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   281: getstatic 751	com/tencent/b/a/a$a:ahah	Lcom/tencent/b/a/a$a;
    //   284: invokevirtual 715	com/tencent/b/a/a$a:name	()Ljava/lang/String;
    //   287: iconst_0
    //   288: invokevirtual 719	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getInt	(Ljava/lang/String;I)I
    //   291: istore 8
    //   293: iload 8
    //   295: iconst_1
    //   296: if_icmpne +1210 -> 1506
    //   299: iconst_1
    //   300: istore 10
    //   302: ldc 87
    //   304: ldc_w 753
    //   307: iconst_2
    //   308: anewarray 398	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: iload 10
    //   315: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: iload 8
    //   323: invokestatic 621	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   326: aastore
    //   327: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: aload 15
    //   332: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   335: iload 10
    //   337: putfield 756	com/tencent/matrix/trace/a/b:fdD	Z
    //   340: aload_0
    //   341: getfield 95	com/tencent/matrix/e:eLH	Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   344: getstatic 759	com/tencent/b/a/a$a:ahag	Lcom/tencent/b/a/a$a;
    //   347: invokevirtual 715	com/tencent/b/a/a$a:name	()Ljava/lang/String;
    //   350: iconst_0
    //   351: invokevirtual 719	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getInt	(Ljava/lang/String;I)I
    //   354: istore 8
    //   356: iload 8
    //   358: iconst_1
    //   359: if_icmpne +1202 -> 1561
    //   362: iconst_1
    //   363: istore 10
    //   365: ldc 87
    //   367: ldc_w 761
    //   370: iconst_2
    //   371: anewarray 398	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: iload 10
    //   378: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   381: aastore
    //   382: dup
    //   383: iconst_1
    //   384: iload 8
    //   386: invokestatic 621	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   389: aastore
    //   390: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: aload 15
    //   395: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   398: iload 10
    //   400: putfield 764	com/tencent/matrix/trace/a/b:fdF	Z
    //   403: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   406: ldc_w 351
    //   409: iconst_0
    //   410: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   413: ifne +21 -> 434
    //   416: getstatic 526	com/tencent/mm/protocal/d:Yxk	Z
    //   419: ifne +15 -> 434
    //   422: getstatic 767	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   425: ifne +9 -> 434
    //   428: getstatic 770	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   431: ifeq +1185 -> 1616
    //   434: iconst_1
    //   435: istore 10
    //   437: aload 15
    //   439: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   442: iload 10
    //   444: putfield 773	com/tencent/matrix/trace/a/b:fdT	Z
    //   447: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   450: ldc_w 775
    //   453: iconst_0
    //   454: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   457: ifne +21 -> 478
    //   460: getstatic 526	com/tencent/mm/protocal/d:Yxk	Z
    //   463: ifne +15 -> 478
    //   466: getstatic 767	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   469: ifne +9 -> 478
    //   472: getstatic 770	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   475: ifeq +1147 -> 1622
    //   478: iconst_1
    //   479: istore 10
    //   481: aload 15
    //   483: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   486: iload 10
    //   488: putfield 776	com/tencent/matrix/trace/a/b:eLL	Z
    //   491: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   494: ldc_w 356
    //   497: iconst_0
    //   498: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   501: ifne +21 -> 522
    //   504: getstatic 526	com/tencent/mm/protocal/d:Yxk	Z
    //   507: ifne +15 -> 522
    //   510: getstatic 767	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   513: ifne +9 -> 522
    //   516: getstatic 770	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   519: ifeq +1109 -> 1628
    //   522: iconst_1
    //   523: istore 10
    //   525: aload 15
    //   527: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   530: iload 10
    //   532: putfield 779	com/tencent/matrix/trace/a/b:fdJ	Z
    //   535: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   538: ldc_w 361
    //   541: iconst_0
    //   542: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   545: ifne +21 -> 566
    //   548: getstatic 526	com/tencent/mm/protocal/d:Yxk	Z
    //   551: ifne +15 -> 566
    //   554: getstatic 767	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   557: ifne +9 -> 566
    //   560: getstatic 770	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   563: ifeq +1071 -> 1634
    //   566: iconst_1
    //   567: istore 10
    //   569: aload 15
    //   571: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   574: iload 10
    //   576: putfield 782	com/tencent/matrix/trace/a/b:fdG	Z
    //   579: aload 15
    //   581: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   584: iconst_1
    //   585: putfield 785	com/tencent/matrix/trace/a/b:fdM	I
    //   588: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   591: ifeq +1049 -> 1640
    //   594: ldc_w 787
    //   597: astore 14
    //   599: aload 15
    //   601: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   604: aload 14
    //   606: putfield 790	com/tencent/matrix/trace/a/b:fdO	Ljava/lang/String;
    //   609: aload 15
    //   611: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   614: iconst_1
    //   615: putfield 793	com/tencent/matrix/trace/a/b:eYL	Z
    //   618: aload 15
    //   620: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   623: iconst_0
    //   624: putfield 796	com/tencent/matrix/trace/a/b:fdK	Z
    //   627: aload 15
    //   629: getfield 728	com/tencent/matrix/trace/a/b$a:fdU	Lcom/tencent/matrix/trace/a/b;
    //   632: astore 14
    //   634: new 456	com/tencent/matrix/trace/b
    //   637: dup
    //   638: aload 14
    //   640: invokespecial 799	com/tencent/matrix/trace/b:<init>	(Lcom/tencent/matrix/trace/a/b;)V
    //   643: astore 15
    //   645: aload_2
    //   646: aload 15
    //   648: invokevirtual 804	com/tencent/matrix/c$a:a	(Lcom/tencent/matrix/d/b;)Lcom/tencent/matrix/c$a;
    //   651: pop
    //   652: aload_0
    //   653: getfield 81	com/tencent/matrix/e:eLF	Lcom/tencent/matrix/report/l;
    //   656: aload 15
    //   658: new 806	com/tencent/matrix/report/b
    //   661: dup
    //   662: invokespecial 807	com/tencent/matrix/report/b:<init>	()V
    //   665: invokevirtual 812	com/tencent/matrix/report/l:a	(Lcom/tencent/matrix/d/b;Lcom/tencent/matrix/report/l$d;)V
    //   668: aload 14
    //   670: getfield 776	com/tencent/matrix/trace/a/b:eLL	Z
    //   673: ifeq +11 -> 684
    //   676: iconst_1
    //   677: putstatic 75	com/tencent/matrix/e:eLL	Z
    //   680: aload_0
    //   681: invokespecial 461	com/tencent/matrix/e:awd	()V
    //   684: aload_0
    //   685: getfield 95	com/tencent/matrix/e:eLH	Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   688: ldc_w 814
    //   691: iconst_0
    //   692: invokevirtual 719	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getInt	(Ljava/lang/String;I)I
    //   695: istore 8
    //   697: ldc 87
    //   699: ldc_w 816
    //   702: iconst_1
    //   703: anewarray 398	java/lang/Object
    //   706: dup
    //   707: iconst_0
    //   708: iload 8
    //   710: invokestatic 621	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   713: aastore
    //   714: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   717: iload 8
    //   719: iconst_1
    //   720: if_icmpne +927 -> 1647
    //   723: iconst_1
    //   724: istore 10
    //   726: ldc 87
    //   728: ldc_w 818
    //   731: iconst_2
    //   732: anewarray 398	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: iload 10
    //   739: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   742: aastore
    //   743: dup
    //   744: iconst_1
    //   745: iload 8
    //   747: invokestatic 621	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   750: aastore
    //   751: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   754: iload 10
    //   756: ifeq +1424 -> 2180
    //   759: ldc 207
    //   761: invokestatic 213	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   764: checkcast 207	com/tencent/mm/plugin/expt/b/c
    //   767: astore 14
    //   769: aload 14
    //   771: ifnull +1402 -> 2173
    //   774: aload 14
    //   776: getstatic 821	com/tencent/mm/plugin/expt/b/c$a:zlJ	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   779: bipush 127
    //   781: invokeinterface 824 3 0
    //   786: istore 8
    //   788: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   791: ifeq +910 -> 1701
    //   794: iload 8
    //   796: iconst_1
    //   797: iand
    //   798: iconst_1
    //   799: if_icmpne +896 -> 1695
    //   802: iconst_1
    //   803: istore 10
    //   805: ldc 87
    //   807: ldc_w 826
    //   810: iconst_2
    //   811: anewarray 398	java/lang/Object
    //   814: dup
    //   815: iconst_0
    //   816: iload 10
    //   818: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   821: aastore
    //   822: dup
    //   823: iconst_1
    //   824: iload 8
    //   826: invokestatic 829	java/lang/Integer:toBinaryString	(I)Ljava/lang/String;
    //   829: aastore
    //   830: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   833: iload 10
    //   835: ifeq +18 -> 853
    //   838: invokestatic 835	com/tencent/matrix/c/a:axW	()Lcom/tencent/matrix/a/c;
    //   841: astore 14
    //   843: invokestatic 840	com/tencent/matrix/c/b:ayy	()V
    //   846: aload_2
    //   847: aload 14
    //   849: invokevirtual 804	com/tencent/matrix/c$a:a	(Lcom/tencent/matrix/d/b;)Lcom/tencent/matrix/c$a;
    //   852: pop
    //   853: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   856: ifne +21 -> 877
    //   859: invokestatic 685	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   862: ifne +15 -> 877
    //   865: invokestatic 688	com/tencent/mm/sdk/platformtools/MMApplicationContext:isAppBrandProcess	()Z
    //   868: ifne +9 -> 877
    //   871: invokestatic 691	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   874: ifeq +937 -> 1811
    //   877: iconst_1
    //   878: istore 10
    //   880: ldc 87
    //   882: ldc_w 842
    //   885: iconst_1
    //   886: anewarray 398	java/lang/Object
    //   889: dup
    //   890: iconst_0
    //   891: iload 10
    //   893: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   896: aastore
    //   897: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   900: iload 10
    //   902: ifeq +181 -> 1083
    //   905: new 572	android/content/Intent
    //   908: dup
    //   909: invokespecial 573	android/content/Intent:<init>	()V
    //   912: astore 15
    //   914: getstatic 767	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   917: ifne +9 -> 926
    //   920: invokestatic 847	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   923: ifeq +894 -> 1817
    //   926: getstatic 853	com/tencent/matrix/resource/b/a$b:fbl	Lcom/tencent/matrix/resource/b/a$b;
    //   929: astore 14
    //   931: getstatic 856	com/tencent/matrix/resource/b/a$b:fbm	Lcom/tencent/matrix/resource/b/a$b;
    //   934: aload 14
    //   936: if_acmpne +1115 -> 2051
    //   939: aload_0
    //   940: iconst_1
    //   941: putfield 101	com/tencent/matrix/e:eLN	Z
    //   944: ldc 87
    //   946: ldc_w 858
    //   949: iconst_1
    //   950: anewarray 398	java/lang/Object
    //   953: dup
    //   954: iconst_0
    //   955: aload 14
    //   957: aastore
    //   958: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   961: aload 15
    //   963: invokestatic 864	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo:current	()Lcom/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo$WhichApp;
    //   966: invokevirtual 869	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo$WhichApp:getPackageName	()Ljava/lang/String;
    //   969: ldc_w 871
    //   972: invokevirtual 875	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   975: pop
    //   976: new 877	com/tencent/matrix/resource/b/a$a
    //   979: dup
    //   980: invokespecial 878	com/tencent/matrix/resource/b/a$a:<init>	()V
    //   983: astore 15
    //   985: aload 15
    //   987: aload_3
    //   988: putfield 879	com/tencent/matrix/resource/b/a$a:fbi	Lcom/tencent/b/a/a;
    //   991: aload 15
    //   993: aload 14
    //   995: putfield 882	com/tencent/matrix/resource/b/a$a:fbh	Lcom/tencent/matrix/resource/b/a$b;
    //   998: aload 15
    //   1000: getstatic 885	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1003: putfield 888	com/tencent/matrix/resource/b/a$a:fbg	Ljava/lang/String;
    //   1006: aload 15
    //   1008: ldc_w 871
    //   1011: putfield 891	com/tencent/matrix/resource/b/a$a:fbf	Ljava/lang/String;
    //   1014: new 507	com/tencent/matrix/resource/c
    //   1017: dup
    //   1018: new 893	com/tencent/matrix/resource/b/a
    //   1021: dup
    //   1022: aload 15
    //   1024: getfield 879	com/tencent/matrix/resource/b/a$a:fbi	Lcom/tencent/b/a/a;
    //   1027: aload 15
    //   1029: getfield 882	com/tencent/matrix/resource/b/a$a:fbh	Lcom/tencent/matrix/resource/b/a$b;
    //   1032: aload 15
    //   1034: getfield 896	com/tencent/matrix/resource/b/a$a:fbe	Z
    //   1037: aload 15
    //   1039: getfield 891	com/tencent/matrix/resource/b/a$a:fbf	Ljava/lang/String;
    //   1042: aload 15
    //   1044: getfield 888	com/tencent/matrix/resource/b/a$a:fbg	Ljava/lang/String;
    //   1047: iconst_0
    //   1048: invokespecial 899	com/tencent/matrix/resource/b/a:<init>	(Lcom/tencent/b/a/a;Lcom/tencent/matrix/resource/b/a$b;ZLjava/lang/String;Ljava/lang/String;B)V
    //   1051: invokespecial 902	com/tencent/matrix/resource/c:<init>	(Lcom/tencent/matrix/resource/b/a;)V
    //   1054: astore 14
    //   1056: aload_2
    //   1057: aload 14
    //   1059: invokevirtual 804	com/tencent/matrix/c$a:a	(Lcom/tencent/matrix/d/b;)Lcom/tencent/matrix/c$a;
    //   1062: pop
    //   1063: aload_1
    //   1064: invokestatic 905	com/tencent/matrix/resource/c:e	(Landroid/app/Application;)V
    //   1067: aload_0
    //   1068: getfield 81	com/tencent/matrix/e:eLF	Lcom/tencent/matrix/report/l;
    //   1071: aload 14
    //   1073: new 907	com/tencent/matrix/report/n
    //   1076: dup
    //   1077: invokespecial 908	com/tencent/matrix/report/n:<init>	()V
    //   1080: invokevirtual 812	com/tencent/matrix/report/l:a	(Lcom/tencent/matrix/d/b;Lcom/tencent/matrix/report/l$d;)V
    //   1083: invokestatic 913	com/tencent/mm/compatible/util/h:aQh	()Z
    //   1086: ifne +981 -> 2067
    //   1089: iconst_0
    //   1090: istore 10
    //   1092: iload 10
    //   1094: ifeq +40 -> 1134
    //   1097: new 915	com/tencent/matrix/iocanary/a/a$a
    //   1100: dup
    //   1101: invokespecial 916	com/tencent/matrix/iocanary/a/a$a:<init>	()V
    //   1104: astore_1
    //   1105: aload_1
    //   1106: aload_3
    //   1107: putfield 919	com/tencent/matrix/iocanary/a/a$a:eVt	Lcom/tencent/b/a/a;
    //   1110: aload_2
    //   1111: new 921	com/tencent/matrix/iocanary/a
    //   1114: dup
    //   1115: new 923	com/tencent/matrix/iocanary/a/a
    //   1118: dup
    //   1119: aload_1
    //   1120: getfield 919	com/tencent/matrix/iocanary/a/a$a:eVt	Lcom/tencent/b/a/a;
    //   1123: iconst_0
    //   1124: invokespecial 926	com/tencent/matrix/iocanary/a/a:<init>	(Lcom/tencent/b/a/a;B)V
    //   1127: invokespecial 929	com/tencent/matrix/iocanary/a:<init>	(Lcom/tencent/matrix/iocanary/a/a;)V
    //   1130: invokevirtual 804	com/tencent/matrix/c$a:a	(Lcom/tencent/matrix/d/b;)Lcom/tencent/matrix/c$a;
    //   1133: pop
    //   1134: invokestatic 913	com/tencent/mm/compatible/util/h:aQh	()Z
    //   1137: ifne +981 -> 2118
    //   1140: iconst_0
    //   1141: istore 10
    //   1143: iload 10
    //   1145: ifeq +30 -> 1175
    //   1148: invokestatic 934	com/tencent/sqlitelint/SQLiteLint:init	()V
    //   1151: new 936	com/tencent/sqlitelint/config/SQLiteLintConfig
    //   1154: dup
    //   1155: getstatic 942	com/tencent/sqlitelint/SQLiteLint$SqlExecutionCallbackMode:CUSTOM_NOTIFY	Lcom/tencent/sqlitelint/SQLiteLint$SqlExecutionCallbackMode;
    //   1158: invokespecial 945	com/tencent/sqlitelint/config/SQLiteLintConfig:<init>	(Lcom/tencent/sqlitelint/SQLiteLint$SqlExecutionCallbackMode;)V
    //   1161: astore_1
    //   1162: aload_2
    //   1163: new 947	com/tencent/sqlitelint/SQLiteLintPlugin
    //   1166: dup
    //   1167: aload_1
    //   1168: invokespecial 950	com/tencent/sqlitelint/SQLiteLintPlugin:<init>	(Lcom/tencent/sqlitelint/config/SQLiteLintConfig;)V
    //   1171: invokevirtual 804	com/tencent/matrix/c$a:a	(Lcom/tencent/matrix/d/b;)Lcom/tencent/matrix/c$a;
    //   1174: pop
    //   1175: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1178: ifeq +168 -> 1346
    //   1181: iconst_0
    //   1182: istore 11
    //   1184: ldc2_w 951
    //   1187: dstore 4
    //   1189: iload 11
    //   1191: istore 10
    //   1193: invokestatic 958	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   1196: ldc_w 960
    //   1199: ldc_w 962
    //   1202: invokevirtual 966	com/tencent/mm/plugin/expt/e/d:hx	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1205: astore_1
    //   1206: iload 11
    //   1208: istore 10
    //   1210: invokestatic 958	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   1213: ldc_w 968
    //   1216: ldc_w 970
    //   1219: invokevirtual 966	com/tencent/mm/plugin/expt/e/d:hx	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1222: astore_3
    //   1223: iload 11
    //   1225: istore 10
    //   1227: ldc 87
    //   1229: ldc_w 972
    //   1232: aload_1
    //   1233: invokestatic 975	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1236: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1239: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1242: iload 11
    //   1244: istore 10
    //   1246: ldc 87
    //   1248: ldc_w 977
    //   1251: aload_3
    //   1252: invokestatic 975	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1255: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1258: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1261: iload 11
    //   1263: istore 10
    //   1265: aload_1
    //   1266: iconst_0
    //   1267: invokestatic 982	com/tencent/mm/sdk/platformtools/Util:getBoolean	(Ljava/lang/String;Z)Z
    //   1270: istore 11
    //   1272: iload 11
    //   1274: istore 10
    //   1276: aload_3
    //   1277: ldc2_w 951
    //   1280: invokestatic 986	com/tencent/mm/sdk/platformtools/Util:getDouble	(Ljava/lang/String;D)D
    //   1283: dstore 6
    //   1285: dload 6
    //   1287: dstore 4
    //   1289: iload 11
    //   1291: istore 10
    //   1293: ldc 87
    //   1295: ldc_w 988
    //   1298: iload 10
    //   1300: invokestatic 311	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1303: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1306: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1309: ldc 87
    //   1311: ldc_w 990
    //   1314: dload 4
    //   1316: invokestatic 993	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   1319: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1322: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1325: new 11	com/tencent/matrix/e$11
    //   1328: dup
    //   1329: aload_0
    //   1330: iload 10
    //   1332: aload_2
    //   1333: dload 4
    //   1335: invokespecial 996	com/tencent/matrix/e$11:<init>	(Lcom/tencent/matrix/e;ZLcom/tencent/matrix/c$a;D)V
    //   1338: astore_1
    //   1339: getstatic 1002	com/tencent/matrix/dice/a:eUy	Lcom/tencent/matrix/dice/a;
    //   1342: aload_1
    //   1343: invokevirtual 1005	com/tencent/matrix/dice/a:a	(Lcom/tencent/matrix/dice/a$a;)V
    //   1346: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   1349: ldc 252
    //   1351: iconst_0
    //   1352: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   1355: ifeq +14 -> 1369
    //   1358: ldc 87
    //   1360: ldc_w 1007
    //   1363: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1366: invokestatic 1012	com/tencent/matrix/f/a:aAq	()V
    //   1369: return
    //   1370: iconst_0
    //   1371: istore 10
    //   1373: goto -1282 -> 91
    //   1376: iload 9
    //   1378: iconst_m1
    //   1379: if_icmpeq +66 -> 1445
    //   1382: getstatic 73	com/tencent/matrix/e:eLK	Z
    //   1385: ifeq +54 -> 1439
    //   1388: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   1391: ldc_w 267
    //   1394: iconst_0
    //   1395: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   1398: ifeq +41 -> 1439
    //   1401: iconst_1
    //   1402: istore 8
    //   1404: iload 8
    //   1406: ifeq +39 -> 1445
    //   1409: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1412: ifne +21 -> 1433
    //   1415: invokestatic 685	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   1418: ifne +15 -> 1433
    //   1421: invokestatic 688	com/tencent/mm/sdk/platformtools/MMApplicationContext:isAppBrandProcess	()Z
    //   1424: ifne +9 -> 1433
    //   1427: invokestatic 691	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   1430: ifeq +15 -> 1445
    //   1433: iconst_1
    //   1434: istore 10
    //   1436: goto -1288 -> 148
    //   1439: iconst_0
    //   1440: istore 8
    //   1442: goto -38 -> 1404
    //   1445: iconst_0
    //   1446: istore 10
    //   1448: goto -1300 -> 148
    //   1451: iload 8
    //   1453: iconst_m1
    //   1454: if_icmpeq +46 -> 1500
    //   1457: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   1460: ldc_w 277
    //   1463: iconst_0
    //   1464: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   1467: ifeq +33 -> 1500
    //   1470: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1473: ifne +21 -> 1494
    //   1476: invokestatic 685	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   1479: ifne +15 -> 1494
    //   1482: invokestatic 688	com/tencent/mm/sdk/platformtools/MMApplicationContext:isAppBrandProcess	()Z
    //   1485: ifne +9 -> 1494
    //   1488: invokestatic 691	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   1491: ifeq +9 -> 1500
    //   1494: iconst_1
    //   1495: istore 11
    //   1497: goto -1278 -> 219
    //   1500: iconst_0
    //   1501: istore 11
    //   1503: goto -1284 -> 219
    //   1506: iload 8
    //   1508: iconst_m1
    //   1509: if_icmpeq +46 -> 1555
    //   1512: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   1515: ldc_w 282
    //   1518: iconst_0
    //   1519: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   1522: ifeq +33 -> 1555
    //   1525: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1528: ifne +21 -> 1549
    //   1531: invokestatic 685	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   1534: ifne +15 -> 1549
    //   1537: invokestatic 688	com/tencent/mm/sdk/platformtools/MMApplicationContext:isAppBrandProcess	()Z
    //   1540: ifne +9 -> 1549
    //   1543: invokestatic 691	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   1546: ifeq +9 -> 1555
    //   1549: iconst_1
    //   1550: istore 10
    //   1552: goto -1250 -> 302
    //   1555: iconst_0
    //   1556: istore 10
    //   1558: goto -1256 -> 302
    //   1561: iload 8
    //   1563: iconst_m1
    //   1564: if_icmpeq +46 -> 1610
    //   1567: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   1570: ldc_w 287
    //   1573: iconst_1
    //   1574: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   1577: ifeq +33 -> 1610
    //   1580: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1583: ifne +21 -> 1604
    //   1586: invokestatic 685	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   1589: ifne +15 -> 1604
    //   1592: invokestatic 691	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   1595: ifne +9 -> 1604
    //   1598: invokestatic 688	com/tencent/mm/sdk/platformtools/MMApplicationContext:isAppBrandProcess	()Z
    //   1601: ifeq +9 -> 1610
    //   1604: iconst_1
    //   1605: istore 10
    //   1607: goto -1242 -> 365
    //   1610: iconst_0
    //   1611: istore 10
    //   1613: goto -1248 -> 365
    //   1616: iconst_0
    //   1617: istore 10
    //   1619: goto -1182 -> 437
    //   1622: iconst_0
    //   1623: istore 10
    //   1625: goto -1144 -> 481
    //   1628: iconst_0
    //   1629: istore 10
    //   1631: goto -1106 -> 525
    //   1634: iconst_0
    //   1635: istore 10
    //   1637: goto -1068 -> 569
    //   1640: ldc 136
    //   1642: astore 14
    //   1644: goto -1045 -> 599
    //   1647: iload 8
    //   1649: iconst_m1
    //   1650: if_icmpeq +39 -> 1689
    //   1653: invokestatic 429	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1656: ifne +27 -> 1683
    //   1659: invokestatic 685	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   1662: ifne +21 -> 1683
    //   1665: invokestatic 691	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   1668: ifne +15 -> 1683
    //   1671: invokestatic 688	com/tencent/mm/sdk/platformtools/MMApplicationContext:isAppBrandProcess	()Z
    //   1674: ifne +9 -> 1683
    //   1677: invokestatic 1015	com/tencent/mm/sdk/platformtools/MMApplicationContext:isPushProcess	()Z
    //   1680: ifeq +9 -> 1689
    //   1683: iconst_1
    //   1684: istore 10
    //   1686: goto -960 -> 726
    //   1689: iconst_0
    //   1690: istore 10
    //   1692: goto -966 -> 726
    //   1695: iconst_0
    //   1696: istore 10
    //   1698: goto -893 -> 805
    //   1701: invokestatic 685	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   1704: ifne +9 -> 1713
    //   1707: invokestatic 691	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   1710: ifeq +23 -> 1733
    //   1713: iload 8
    //   1715: iconst_2
    //   1716: iand
    //   1717: iconst_2
    //   1718: if_icmpne +9 -> 1727
    //   1721: iconst_1
    //   1722: istore 10
    //   1724: goto -919 -> 805
    //   1727: iconst_0
    //   1728: istore 10
    //   1730: goto -925 -> 805
    //   1733: invokestatic 688	com/tencent/mm/sdk/platformtools/MMApplicationContext:isAppBrandProcess	()Z
    //   1736: ifeq +23 -> 1759
    //   1739: iload 8
    //   1741: iconst_4
    //   1742: iand
    //   1743: iconst_4
    //   1744: if_icmpne +9 -> 1753
    //   1747: iconst_1
    //   1748: istore 10
    //   1750: goto -945 -> 805
    //   1753: iconst_0
    //   1754: istore 10
    //   1756: goto -951 -> 805
    //   1759: invokestatic 1015	com/tencent/mm/sdk/platformtools/MMApplicationContext:isPushProcess	()Z
    //   1762: ifeq +25 -> 1787
    //   1765: iload 8
    //   1767: bipush 8
    //   1769: iand
    //   1770: bipush 8
    //   1772: if_icmpne +9 -> 1781
    //   1775: iconst_1
    //   1776: istore 10
    //   1778: goto -973 -> 805
    //   1781: iconst_0
    //   1782: istore 10
    //   1784: goto -979 -> 805
    //   1787: iload 8
    //   1789: sipush 128
    //   1792: iand
    //   1793: sipush 128
    //   1796: if_icmpne +9 -> 1805
    //   1799: iconst_1
    //   1800: istore 10
    //   1802: goto -997 -> 805
    //   1805: iconst_0
    //   1806: istore 10
    //   1808: goto -1003 -> 805
    //   1811: iconst_0
    //   1812: istore 10
    //   1814: goto -934 -> 880
    //   1817: ldc_w 1017
    //   1820: lconst_0
    //   1821: invokestatic 1023	com/tencent/matrix/b:m	(Ljava/lang/String;J)J
    //   1824: lstore 12
    //   1826: invokestatic 521	java/lang/Math:random	()D
    //   1829: ldc2_w 1024
    //   1832: dmul
    //   1833: d2l
    //   1834: lload 12
    //   1836: lcmp
    //   1837: ifge +24 -> 1861
    //   1840: getstatic 549	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1843: ldc2_w 550
    //   1846: lconst_0
    //   1847: ldc2_w 1026
    //   1850: invokevirtual 555	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   1853: getstatic 1030	com/tencent/matrix/resource/b/a$b:fbp	Lcom/tencent/matrix/resource/b/a$b;
    //   1856: astore 14
    //   1858: goto -927 -> 931
    //   1861: ldc_w 1032
    //   1864: ldc2_w 1033
    //   1867: invokestatic 1023	com/tencent/matrix/b:m	(Ljava/lang/String;J)J
    //   1870: lstore 12
    //   1872: invokestatic 521	java/lang/Math:random	()D
    //   1875: dconst_1
    //   1876: lload 12
    //   1878: l2d
    //   1879: ddiv
    //   1880: dcmpg
    //   1881: ifge +30 -> 1911
    //   1884: ldc 87
    //   1886: ldc_w 1036
    //   1889: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1892: getstatic 549	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1895: ldc2_w 550
    //   1898: lconst_0
    //   1899: lconst_1
    //   1900: invokevirtual 555	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   1903: getstatic 856	com/tencent/matrix/resource/b/a$b:fbm	Lcom/tencent/matrix/resource/b/a$b;
    //   1906: astore 14
    //   1908: goto -977 -> 931
    //   1911: invokestatic 1039	com/tencent/mm/sdk/platformtools/WeChatEnvironment:isMonkeyEnv	()Z
    //   1914: ifeq +19 -> 1933
    //   1917: ldc 87
    //   1919: ldc_w 1041
    //   1922: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1925: getstatic 856	com/tencent/matrix/resource/b/a$b:fbm	Lcom/tencent/matrix/resource/b/a$b;
    //   1928: astore 14
    //   1930: goto -999 -> 931
    //   1933: getstatic 1044	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_PURPLE	Z
    //   1936: ifne +9 -> 1945
    //   1939: getstatic 770	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   1942: ifeq +19 -> 1961
    //   1945: ldc 87
    //   1947: ldc_w 1046
    //   1950: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1953: getstatic 1030	com/tencent/matrix/resource/b/a$b:fbp	Lcom/tencent/matrix/resource/b/a$b;
    //   1956: astore 14
    //   1958: goto -1027 -> 931
    //   1961: getstatic 526	com/tencent/mm/protocal/d:Yxk	Z
    //   1964: ifeq +57 -> 2021
    //   1967: invokestatic 958	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   1970: ldc_w 1048
    //   1973: ldc_w 1050
    //   1976: iconst_0
    //   1977: iconst_1
    //   1978: invokevirtual 1053	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   1981: iconst_0
    //   1982: invokestatic 1054	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1985: iconst_1
    //   1986: if_icmpne +19 -> 2005
    //   1989: ldc 87
    //   1991: ldc_w 1056
    //   1994: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1997: getstatic 856	com/tencent/matrix/resource/b/a$b:fbm	Lcom/tencent/matrix/resource/b/a$b;
    //   2000: astore 14
    //   2002: goto -1071 -> 931
    //   2005: ldc 87
    //   2007: ldc_w 1058
    //   2010: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2013: getstatic 1030	com/tencent/matrix/resource/b/a$b:fbp	Lcom/tencent/matrix/resource/b/a$b;
    //   2016: astore 14
    //   2018: goto -1087 -> 931
    //   2021: getstatic 531	com/tencent/mm/sdk/platformtools/BuildInfo:ENABLE_MATRIX_SILENCE_ANALYSE	Z
    //   2024: ifeq +19 -> 2043
    //   2027: ldc 87
    //   2029: ldc_w 1060
    //   2032: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2035: getstatic 1030	com/tencent/matrix/resource/b/a$b:fbp	Lcom/tencent/matrix/resource/b/a$b;
    //   2038: astore 14
    //   2040: goto -1109 -> 931
    //   2043: getstatic 1063	com/tencent/matrix/resource/b/a$b:fbj	Lcom/tencent/matrix/resource/b/a$b;
    //   2046: astore 14
    //   2048: goto -1117 -> 931
    //   2051: getstatic 1030	com/tencent/matrix/resource/b/a$b:fbp	Lcom/tencent/matrix/resource/b/a$b;
    //   2054: aload 14
    //   2056: if_acmpne -1112 -> 944
    //   2059: aload_0
    //   2060: iconst_1
    //   2061: putfield 103	com/tencent/matrix/e:eLO	Z
    //   2064: goto -1120 -> 944
    //   2067: getstatic 73	com/tencent/matrix/e:eLK	Z
    //   2070: ifeq +42 -> 2112
    //   2073: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   2076: ldc_w 272
    //   2079: iconst_0
    //   2080: invokevirtual 663	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   2083: ifeq +29 -> 2112
    //   2086: iconst_1
    //   2087: istore 10
    //   2089: ldc 87
    //   2091: ldc_w 1065
    //   2094: iconst_1
    //   2095: anewarray 398	java/lang/Object
    //   2098: dup
    //   2099: iconst_0
    //   2100: iload 10
    //   2102: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2105: aastore
    //   2106: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2109: goto -1017 -> 1092
    //   2112: iconst_0
    //   2113: istore 10
    //   2115: goto -26 -> 2089
    //   2118: invokestatic 1039	com/tencent/mm/sdk/platformtools/WeChatEnvironment:isMonkeyEnv	()Z
    //   2121: istore 10
    //   2123: ldc 87
    //   2125: ldc_w 1067
    //   2128: iconst_1
    //   2129: anewarray 398	java/lang/Object
    //   2132: dup
    //   2133: iconst_0
    //   2134: iload 10
    //   2136: invokestatic 495	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2139: aastore
    //   2140: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2143: goto -1000 -> 1143
    //   2146: astore_1
    //   2147: new 936	com/tencent/sqlitelint/config/SQLiteLintConfig
    //   2150: dup
    //   2151: getstatic 942	com/tencent/sqlitelint/SQLiteLint$SqlExecutionCallbackMode:CUSTOM_NOTIFY	Lcom/tencent/sqlitelint/SQLiteLint$SqlExecutionCallbackMode;
    //   2154: invokespecial 945	com/tencent/sqlitelint/config/SQLiteLintConfig:<init>	(Lcom/tencent/sqlitelint/SQLiteLint$SqlExecutionCallbackMode;)V
    //   2157: astore_1
    //   2158: goto -996 -> 1162
    //   2161: astore_1
    //   2162: ldc 87
    //   2164: ldc_w 1069
    //   2167: invokestatic 1071	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2170: goto -877 -> 1293
    //   2173: bipush 127
    //   2175: istore 8
    //   2177: goto -1389 -> 788
    //   2180: goto -1347 -> 833
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2183	0	this	e
    //   0	2183	1	paramApplication	Application
    //   0	2183	2	parama	c.a
    //   0	2183	3	paramg	g
    //   1187	147	4	d1	double
    //   1283	3	6	d2	double
    //   208	1968	8	i	int
    //   137	1243	9	j	int
    //   89	2046	10	bool1	boolean
    //   217	1285	11	bool2	boolean
    //   1824	53	12	l	long
    //   597	1458	14	localObject1	Object
    //   183	860	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1148	1162	2146	finally
    //   1193	1206	2161	java/lang/Exception
    //   1210	1223	2161	java/lang/Exception
    //   1227	1242	2161	java/lang/Exception
    //   1246	1261	2161	java/lang/Exception
    //   1265	1272	2161	java/lang/Exception
    //   1276	1285	2161	java/lang/Exception
  }
  
  public final com.tencent.matrix.e.c.a avX()
  {
    return new e.1(this);
  }
  
  public final l avY()
  {
    long l2 = 5L;
    l.a locala = new l.a(MMApplicationContext.getContext());
    locala.eYJ = Long.valueOf(com.tencent.mm.protocal.d.Yxh);
    locala.eYS = Boolean.valueOf(WeChatEnvironment.isMonkeyEnv());
    locala.eYK = BuildInfo.REV;
    long l1 = l2;
    if (!BuildInfo.IS_FLAVOR_PURPLE)
    {
      l1 = l2;
      if (!BuildInfo.IS_FLAVOR_RED)
      {
        if (!BuildInfo.DEBUG) {
          break label188;
        }
        l1 = l2;
      }
    }
    for (;;)
    {
      locala.eYM = Long.valueOf(l1);
      Objects.requireNonNull(locala.context, "matrix report init, context is null");
      Objects.requireNonNull(locala.eYJ, "matrix report init, clientVersion is null");
      Objects.requireNonNull(locala.eYK, "matrix report init, revision is null");
      Objects.requireNonNull(locala.eYM, "matrix report init, publishType is null");
      this.eLF = new l(locala.context, locala.eYJ, locala.eYK, locala.eYS, locala.eYM);
      Log.i("MatrixDelegate", "init matrix reporter %s", new Object[] { this.eLF });
      return this.eLF;
      label188:
      l1 = l2;
      if (!com.tencent.mm.protocal.d.Yxk) {
        if (com.tencent.mm.protocal.d.Yxi) {
          l1 = 3L;
        } else if (com.tencent.mm.protocal.d.Yxj) {
          l1 = 4L;
        } else {
          l1 = -1L;
        }
      }
    }
  }
  
  public final g avZ()
  {
    return new g();
  }
  
  public final l.c awa()
  {
    return new k();
  }
  
  public final q awb()
  {
    new q()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        e.a(e.this, false);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        e.a(e.this, true);
      }
    };
  }
  
  public final void awc()
  {
    int i = 0;
    Log.i("MatrixDelegate", "onFinalJob");
    int j = this.eLH.getInt("ENABLE_FPS_FLOAT", 0);
    if (j == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MatrixDelegate", "[isEnableFpsFloat] enable=%s, value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if (j == 1) {
        i = 1;
      }
      if ((i != 0) && (f.awl())) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            e.gh("ENABLE_FPS");
            e.gh("ENABLE_FPS_FLOAT");
          }
        });
      }
      com.tencent.threadpool.h.ahAA.g(new e.8(this), "Matrix-Save-AccInfo");
      this.baY = true;
      if (this.eLG) {
        du(AppForegroundDelegate.heY.eLx);
      }
      if (MultiProcessMMKV.getDefault().decodeBool("clicfg_detect_dropframe", true))
      {
        Log.i("MatrixDelegate", "start detecting dropFrame");
        localObject = (com.tencent.matrix.trace.b)c.avW().ai(com.tencent.matrix.trace.b.class);
        if (localObject != null) {
          break;
        }
        Log.i("MatrixDelegate", "tracePlugin is null");
      }
      return;
    }
    Object localObject = ((com.tencent.matrix.trace.b)localObject).fdr;
    if (localObject == null)
    {
      Log.i("MatrixDelegate", "frameTracer is null");
      return;
    }
    ((com.tencent.matrix.trace.tracer.b)localObject).ffy = new b.a()
    {
      public final void a(int paramAnonymousInt, final long paramAnonymousLong1, final String paramAnonymousString, final long paramAnonymousLong2)
      {
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            try
            {
              long l = System.currentTimeMillis() - paramAnonymousLong2;
              if (l > 0L)
              {
                Log.i("MatrixDelegate", "happens dropFrames : dropFrame = %d, jitter = %d, scene = %s, lastResumeTime = %d, timeAfterResume = %d", new Object[] { Integer.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousString), this.eLY, Long.valueOf(paramAnonymousLong2), Long.valueOf(l) });
                if (paramAnonymousLong1 < 15) {}
                for (;;)
                {
                  int j = com.tencent.matrix.e.a.ck(MMApplicationContext.getContext()).value;
                  com.tencent.mm.plugin.report.f.Ozc.b(20502, new Object[] { Integer.valueOf(paramAnonymousLong1), this.eLY, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l), "" });
                  return;
                  if (paramAnonymousLong1 < 30)
                  {
                    i = 2;
                  }
                  else if (paramAnonymousLong1 < 60)
                  {
                    i = 3;
                  }
                  else if (paramAnonymousLong1 < 90)
                  {
                    i = 4;
                  }
                  else
                  {
                    i = paramAnonymousLong1;
                    if (i < 120) {
                      i = 5;
                    } else {
                      i = 6;
                    }
                  }
                }
              }
              return;
            }
            finally
            {
              Log.i("MatrixDelegate", "report dropFrame error = " + localObject.getMessage());
            }
          }
        });
      }
    };
    ((com.tencent.matrix.trace.tracer.b)localObject).ffz = 9;
  }
  
  public final void b(Application paramApplication)
  {
    this.application = paramApplication;
    this.eLI = new com.tencent.matrix.strategy.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.e
 * JD-Core Version:    0.7.0.1
 */