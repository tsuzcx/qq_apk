package com.tencent.mm.hardcoder;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public final class a
{
  public static boolean dEc = false;
  private static final int[] dEd = { 0, 1, 2, 3 };
  private static final int[] dEe = { 0, 1, 2, 3 };
  b dEf;
  private Thread dEg;
  HardCoderJNI.HCPerfManagerThread dEh;
  LinkedBlockingQueue<Object> dEi = new LinkedBlockingQueue();
  
  public a(HardCoderJNI.HCPerfManagerThread paramHCPerfManagerThread, Context paramContext)
  {
    this.dEf = new b(paramContext);
    this.dEf.start();
    this.dEh = paramHCPerfManagerThread;
    this.dEg = this.dEh.newThread(new a((byte)0), "HCPerfManager", 10);
    this.dEg.start();
    c.i("HardCoder.HCPerfManager", String.format("hardcoder HCPerfManager new thread[%s]", new Object[] { this.dEg }));
  }
  
  private final class a
    implements Runnable
  {
    private boolean bDX = false;
    
    private a() {}
    
    private void restart()
    {
      this.bDX = false;
      a.b(a.this).interrupt();
      a.a(a.this, a.this.dEh.newThread(new a(a.this), "HCPerfManager", 10));
      a.b(a.this).start();
      c.i("HardCoder.HCPerfManager", String.format("hardcoder HCPerfManager restart new thread[%s]", new Object[] { a.b(a.this) }));
    }
    
    public final void run()
    {
      c.i("HardCoder.HCPerfManager", String.format("HCPerfManager thread run start[%d, %s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName() }));
      this.bDX = true;
      Object localObject6 = new HashSet();
      long l1 = 30000L;
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = HardCoderJNI.getMyProcCpuTime();
      Object localObject1;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (localObject3.length >= 2) {}
      }
      else
      {
        localObject1 = new long[2];
        Object tmp91_89 = localObject1;
        tmp91_89[0] = 0L;
        Object tmp95_91 = tmp91_89;
        tmp95_91[1] = 0L;
        tmp95_91;
        c.i("HardCoder.HardCoderReporter", "process jiffes info is invalid");
      }
      c.i("HardCoder.HardCoderReporter", "process:[" + localObject1[0] + "," + localObject1[1] + "]");
      HashMap localHashMap = new HashMap();
      HashSet localHashSet2 = new HashSet();
      Object localObject5 = null;
      Object localObject4 = null;
      for (;;)
      {
        int k;
        int i;
        int j;
        Object localObject2;
        HashSet localHashSet1;
        long l3;
        Object localObject8;
        long l2;
        Object localObject9;
        label740:
        Object localObject7;
        long l5;
        label1202:
        label1227:
        label1264:
        int n;
        label1418:
        label1430:
        label1442:
        label1454:
        label1466:
        int m;
        if (this.bDX)
        {
          long l4 = System.currentTimeMillis();
          k = a.a(a.this).size();
          if (HardCoderJNI.hcDebug) {
            c.d("HardCoder.HCPerfManager", "StartLoop queue:" + k + " startTask:" + tmp91_89.size() + " nextWakeInterval:" + l1);
          }
          i = 0;
          for (;;)
          {
            if (k == 0)
            {
              j = 1;
              if (i >= j) {}
            }
            else
            {
              try
              {
                localObject1 = a.a(a.this).poll(l1, TimeUnit.MILLISECONDS);
                if (localObject1 != null) {
                  if ((localObject1 instanceof a.b))
                  {
                    tmp91_89.add((a.b)localObject1);
                    localHashSet2.add(Integer.valueOf(((a.b)localObject1).hashCode()));
                    i += 1;
                    continue;
                    j = k;
                  }
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  c.e("HardCoder.HCPerfManager", "queueTask poll: " + localException.getMessage());
                  localObject2 = null;
                  continue;
                  if ((localObject2 instanceof a.c))
                  {
                    j = ((a.c)localObject2).auK;
                    if (localHashSet2.contains(Integer.valueOf(j))) {
                      localHashMap.put(Integer.valueOf(j), (a.c)localObject2);
                    }
                  }
                  else
                  {
                    if (!HardCoderJNI.checkEnv) {
                      break;
                    }
                    Assert.fail("queueTask poll invalid object");
                  }
                }
                this.bDX = false;
              }
            }
          }
          l1 = 30000L;
          localObject2 = null;
          localObject3 = null;
          localHashSet1 = new HashSet();
          l3 = System.currentTimeMillis();
          if (HardCoderJNI.hcDebug) {
            c.d("HardCoder.HCPerfManager", "InLoop startSize:" + tmp91_89.size());
          }
          i = 0;
          if (i < tmp91_89.size())
          {
            localObject8 = (a.b)tmp91_89.get(i);
            j = i;
            l2 = l1;
            localObject9 = localObject3;
            Object localObject10 = localObject2;
            if (localObject8 != null)
            {
              if (localHashMap.containsKey(Integer.valueOf(localObject8.hashCode())))
              {
                ((a.b)localObject8).dEq = l3;
                ((a.b)localObject8).dEF = ((a.c)localHashMap.get(Integer.valueOf(localObject8.hashCode()))).dEF;
                localHashMap.remove(Integer.valueOf(localObject8.hashCode()));
                a.a(a.this, l3, tmp91_89, -2, -2, null);
                a.a(a.this, (a.b)localObject8);
              }
              l2 = ((a.b)localObject8).dEq - l3;
              if (l2 > 0L) {
                break label740;
              }
              if (HardCoderJNI.hcDebug) {
                c.d("HardCoder.HCPerfManager", "InLoop STOP:" + i + "/" + tmp91_89.size() + " task:" + ((a.b)localObject8).toString(l3));
              }
              tmp91_89.remove(localObject8);
              localHashSet2.remove(Integer.valueOf(localObject8.hashCode()));
              j = i - 1;
              localObject10 = localObject2;
              localObject9 = localObject3;
              l2 = l1;
            }
            for (;;)
            {
              i = j + 1;
              l1 = l2;
              localObject3 = localObject9;
              localObject2 = localObject10;
              break;
              l1 = Math.min(l1, l2);
              l2 = ((a.b)localObject8).startTime - l3;
              if (l2 > 0L)
              {
                if (HardCoderJNI.hcDebug) {
                  c.d("HardCoder.HCPerfManager", "InLoop WAIT:" + i + "/" + tmp91_89.size() + " task:" + ((a.b)localObject8).toString(l3));
                }
                l2 = Math.min(l1, l2);
                j = i;
                localObject9 = localObject3;
                localObject10 = localObject2;
              }
              else
              {
                if (HardCoderJNI.hcDebug) {
                  c.d("HardCoder.HCPerfManager", "InLoop  RUN:" + i + "/" + tmp91_89.size() + " task:" + ((a.b)localObject8).toString(l3));
                }
                localObject7 = localObject2;
                if (((a.b)localObject8).dEl > 0) {
                  if ((localObject2 != null) && (localObject2.dEl <= ((a.b)localObject8).dEl))
                  {
                    localObject7 = localObject2;
                    if (localObject2.dEl == ((a.b)localObject8).dEl)
                    {
                      localObject7 = localObject2;
                      if (localObject2.dEq >= ((a.b)localObject8).dEq) {}
                    }
                  }
                  else
                  {
                    localObject7 = localObject8;
                  }
                }
                localObject2 = localObject3;
                if (((a.b)localObject8).dEm > 0) {
                  if ((localObject3 != null) && (((a.b)localObject3).dEm <= ((a.b)localObject8).dEm))
                  {
                    localObject2 = localObject3;
                    if (((a.b)localObject3).dEm == ((a.b)localObject8).dEm)
                    {
                      localObject2 = localObject3;
                      if (((a.b)localObject3).dEq >= ((a.b)localObject8).dEq) {}
                    }
                  }
                  else
                  {
                    localObject2 = localObject8;
                  }
                }
                j = i;
                l2 = l1;
                localObject9 = localObject2;
                localObject10 = localObject7;
                if (((a.b)localObject8).dEn > 0)
                {
                  localHashSet1.add(localObject8);
                  j = i;
                  l2 = l1;
                  localObject9 = localObject2;
                  localObject10 = localObject7;
                }
              }
            }
          }
          l5 = System.currentTimeMillis();
          if (HardCoderJNI.hcDebug)
          {
            c.d("HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[] { Long.valueOf(l5 - l3), Long.valueOf(l5 - l4), Integer.valueOf(tmp91_89.size()), Integer.valueOf(localHashMap.size()), Integer.valueOf(((HashSet)localObject6).size()), Integer.valueOf(localHashSet1.size()) }));
            localObject8 = new StringBuilder("EndLoop CurrCpu:");
            if (localObject4 != null) {
              break label1418;
            }
            localObject7 = "null";
            localObject8 = ((StringBuilder)localObject8).append((String)localObject7).append(" -> MaxCpu:");
            if (localObject2 != null) {
              break label1430;
            }
            localObject7 = "null";
            c.d("HardCoder.HCPerfManager", (String)localObject7);
            localObject8 = new StringBuilder("EndLoop CurrIO:");
            if (localObject5 != null) {
              break label1442;
            }
            localObject7 = "null";
            localObject8 = ((StringBuilder)localObject8).append((String)localObject7).append(" -> MaxIO:");
            if (localObject3 != null) {
              break label1454;
            }
          }
          for (localObject7 = "null";; localObject7 = ((a.b)localObject3).toString(l3))
          {
            c.d("HardCoder.HCPerfManager", (String)localObject7);
            c.d("HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[] { Integer.valueOf(((HashSet)localObject6).size()), Integer.valueOf(localHashSet1.size()) }));
            localObject8 = new HashSet();
            ((HashSet)localObject8).addAll((Collection)localObject6);
            ((HashSet)localObject8).removeAll(localHashSet1);
            if ((localObject2 != localObject4) || (localObject3 != localObject5) || (((HashSet)localObject6).size() != localHashSet1.size()) || (!((HashSet)localObject8).isEmpty())) {
              break label1466;
            }
            if (!HardCoderJNI.hcDebug) {
              break label3815;
            }
            c.i("HardCoder.HCPerfManager", "EndLoop Nothing Changed , Continue.");
            break;
            localObject7 = ((a.b)localObject4).toString(l3);
            break label1202;
            localObject7 = localObject2.toString(l3);
            break label1227;
            localObject7 = ((a.b)localObject5).toString(l3);
            break label1264;
          }
          l2 = 0L;
          j = 0;
          k = 2147483647;
          i = ((HashSet)localObject8).size();
          if (i > 0)
          {
            localObject6 = new int[i];
            localObject7 = ((HashSet)localObject8).iterator();
            i = 0;
            for (;;)
            {
              if (!((Iterator)localObject7).hasNext()) {
                break label1664;
              }
              localObject9 = (a.b)((Iterator)localObject7).next();
              c.i("HardCoder.HCPerfManager", "!cancelBindCore task:" + ((a.b)localObject9).toString(l3));
              if (((a.b)localObject9).dEq > l3)
              {
                if (!HardCoderJNI.checkEnv) {
                  break;
                }
                c.e("HardCoder.HCPerfManager", "stopTime:" + (((a.b)localObject9).dEq - l3) + ". Restart now !");
                restart();
              }
              if (((a.b)localObject9).dEn == 0)
              {
                if (!HardCoderJNI.checkEnv) {
                  break label1927;
                }
                Assert.fail("bindTid:" + ((a.b)localObject9).dEn);
              }
              localObject6[i] = ((a.b)localObject9).dEn;
              i += 1;
            }
          }
          label1664:
          label1927:
          for (this.bDX = false;; this.bDX = false)
          {
            if ((!a.dEc) && (HardCoderJNI.checkEnv)) {
              HardCoderJNI.cancelCpuCoreForThread((int[])localObject6, Process.myTid(), SystemClock.elapsedRealtimeNanos());
            }
            a.a(a.this, l3, tmp91_89, -2, -2, null);
            localObject9 = new int[localHashSet1.size()];
            localObject6 = localHashSet1.iterator();
            n = 0;
            m = 0;
            i = k;
            k = n;
            for (;;)
            {
              if (!((Iterator)localObject6).hasNext()) {
                break label1940;
              }
              localObject7 = (a.b)((Iterator)localObject6).next();
              c.i("HardCoder.HCPerfManager", "requestBindCore task:" + ((a.b)localObject7).toString(l3));
              if (((a.b)localObject7).dEq <= l3)
              {
                if (!HardCoderJNI.checkEnv) {
                  break;
                }
                c.e("HardCoder.HCPerfManager", "stopTime:" + (((a.b)localObject7).dEq - l3) + ". Restart now !");
                restart();
              }
              if (((a.b)localObject7).dEn == 0)
              {
                if (!HardCoderJNI.checkEnv) {
                  break label3047;
                }
                Assert.fail("bindTid:" + ((a.b)localObject7).dEn);
              }
              localObject9[m] = ((a.b)localObject7).dEn;
              k = ((a.b)localObject7).scene;
              l2 = ((a.b)localObject7).dEo;
              j = ((a.b)localObject7).dEr;
              i = Math.min((int)(((a.b)localObject7).dEq - l3), i);
              m += 1;
            }
          }
          this.bDX = false;
          label1940:
          if (localObject3 == null)
          {
            if (localObject5 != null)
            {
              c.i("HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + ((a.b)localObject5).toString(l3));
              if ((!a.dEc) && (HardCoderJNI.checkEnv)) {
                HardCoderJNI.cancelHighIOFreq(((a.b)localObject5).dEr, SystemClock.elapsedRealtimeNanos());
              }
              a.a(a.this, l3, tmp91_89, -2, -1, null);
            }
            label2017:
            if (localObject3 == null) {
              break label3809;
            }
            m = ((a.b)localObject3).dEm;
            k = ((a.b)localObject3).scene;
            l2 = ((a.b)localObject3).dEo;
            j = ((a.b)localObject3).dEr;
            i = Math.min((int)(((a.b)localObject3).dEq - l3), i);
          }
        }
        for (;;)
        {
          label2139:
          int i1;
          if (localObject2 == null)
          {
            if (localObject4 != null)
            {
              c.i("HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + ((a.b)localObject4).toString(l3));
              if ((!a.dEc) && (HardCoderJNI.checkEnv)) {
                HardCoderJNI.cancelCpuHighFreq(((a.b)localObject4).dEr, SystemClock.elapsedRealtimeNanos());
              }
              a.a(a.this, l3, tmp91_89, -1, -2, null);
            }
            if (localObject2 == null) {
              break label3787;
            }
            i1 = localObject2.dEl;
            k = localObject2.scene;
            l2 = localObject2.dEo;
            n = localObject2.dEr;
            j = Math.min((int)(localObject2.dEq - l3), i);
            i = i1;
          }
          for (;;)
          {
            if (j < 2147483647)
            {
              i1 = localObject9.length;
              if (localObject2 == null)
              {
                localObject4 = "null";
                label2210:
                if (localObject3 != null) {
                  break label3263;
                }
                localObject5 = "null";
                label2220:
                if (localObject2 != null) {
                  break label3275;
                }
                localObject6 = "null";
                label2230:
                if (localObject3 != null) {
                  break label3287;
                }
                localObject7 = "null";
                label2240:
                c.i("HardCoder.HCPerfManager", String.format("!UnifyRequest [%d,%d,%d] [%d,%d,%d] TO:%d max CPU:%s IO:%s cur CPU:%s IO:%s", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(j), localObject4, localObject5, localObject6, localObject7 }));
                if (j <= 0) {
                  break label3299;
                }
                bool1 = true;
                label2341:
                Assert.assertTrue(bool1);
                if ((k <= 0) && (l2 <= 0L)) {
                  break label3305;
                }
                bool1 = true;
                label2360:
                Assert.assertTrue(bool1);
                if (n <= 0) {
                  break label3311;
                }
                bool1 = true;
                label2373:
                Assert.assertTrue(bool1);
                if ((i <= 0) && (m <= 0) && (localObject9.length <= 0)) {
                  break label3317;
                }
                bool1 = true;
                label2396:
                Assert.assertTrue(bool1);
                if ((!a.dEc) && (HardCoderJNI.checkEnv))
                {
                  HardCoderJNI.requestUnifyCpuIOThreadCore(k, l2, i, m, (int[])localObject9, j, n, SystemClock.elapsedRealtimeNanos());
                  boolean bool2 = HardCoderJNI.hcEnable;
                  if ((!HardCoderJNI.checkEnv) || (HardCoderJNI.isRunning() <= 0)) {
                    break label3323;
                  }
                  bool1 = true;
                  label2451:
                  c.i("HardCoder.HCPerfManager", String.format("hardcoder requestUnifyCpuIOThreadCore reqScene[%d, %d] running[j %b, c %b]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
                  if (HardCoderJNI.sceneReportCallback != null) {
                    HardCoderJNI.sceneReportCallback.sceneReport(k, l2);
                  }
                }
                a.a(a.this, l3, tmp91_89, i, m, (int[])localObject9);
              }
            }
            else
            {
              if (!a.dEc) {
                break label3818;
              }
              if (localObject2 != localObject2) {
                break label3329;
              }
              bool1 = true;
              label2546:
              Assert.assertTrue(bool1);
              if (localObject3 != localObject3) {
                break label3335;
              }
              bool1 = true;
              label2561:
              Assert.assertTrue(bool1);
              if (tmp91_89.isEmpty())
              {
                if (l1 != 30000L) {
                  break label3341;
                }
                bool1 = true;
                label2586:
                Assert.assertTrue(bool1);
                if (j != 2147483647) {
                  break label3347;
                }
                bool1 = true;
                label2601:
                Assert.assertTrue(bool1);
                Assert.assertTrue(localHashSet1.isEmpty());
                if (localObject2 != null) {
                  break label3353;
                }
                bool1 = true;
                label2622:
                Assert.assertTrue(bool1);
                if (localObject3 != null) {
                  break label3359;
                }
                bool1 = true;
                label2635:
                Assert.assertTrue(bool1);
              }
              k = 0;
              label2642:
              if (k >= tmp91_89.size()) {
                break label3763;
              }
              localObject4 = (a.b)tmp91_89.get(k);
              if (HardCoderJNI.hcDebug) {
                c.d("HardCoder.HCPerfManager", "CheckTask:" + k + "/" + tmp91_89.size() + " task:" + ((a.b)localObject4).toString(l3));
              }
              if ((((a.b)localObject4).dEl <= 0) && (((a.b)localObject4).dEm <= 0) && (((a.b)localObject4).dEn <= 0)) {
                break label3365;
              }
              bool1 = true;
              label2746:
              Assert.assertTrue(bool1);
              if ((((a.b)localObject4).dEo <= 0L) && (((a.b)localObject4).scene <= 0)) {
                break label3371;
              }
              bool1 = true;
              label2772:
              Assert.assertTrue(bool1);
              localObject5 = "taskInintTime:" + (((a.b)localObject4).dEp - l3);
              if (((a.b)localObject4).dEp > l3) {
                break label3377;
              }
              bool1 = true;
              label2817:
              Assert.assertTrue((String)localObject5, bool1);
              localObject5 = "taskStopTime:" + (((a.b)localObject4).dEq - l3);
              if (((a.b)localObject4).dEq < l3) {
                break label3383;
              }
              bool1 = true;
              label2864:
              Assert.assertTrue((String)localObject5, bool1);
              localObject5 = "taskHash:" + localObject4.hashCode();
              if (localHashMap.containsKey(Integer.valueOf(localObject4.hashCode()))) {
                break label3389;
              }
              bool1 = true;
              label2913:
              Assert.assertTrue((String)localObject5, bool1);
              if (((a.b)localObject4).startTime <= l3) {
                break label3419;
              }
              if (localObject4 == localObject2) {
                break label3395;
              }
              bool1 = true;
              label2941:
              Assert.assertTrue(bool1);
              if (localObject4 == localObject3) {
                break label3401;
              }
              bool1 = true;
              label2956:
              Assert.assertTrue(bool1);
              if (localHashSet1.contains(localObject4)) {
                break label3407;
              }
              bool1 = true;
              label2974:
              Assert.assertTrue(bool1);
              localObject5 = "next:" + l1 + " start:" + (((a.b)localObject4).startTime - l3);
              if (l1 > ((a.b)localObject4).startTime - l3) {
                break label3413;
              }
              bool1 = true;
              label3033:
              Assert.assertTrue((String)localObject5, bool1);
            }
            label3047:
            label3305:
            label3311:
            label3317:
            label3323:
            do
            {
              k += 1;
              break label2642;
              this.bDX = false;
              break;
              if ((localObject5 == localObject3) || (!HardCoderJNI.hcDebug)) {
                break label2017;
              }
              localObject6 = new StringBuilder("IOReq:");
              if (localObject5 == null) {}
              for (localObject5 = "null";; localObject5 = ((a.b)localObject5).toString(l3))
              {
                c.d("HardCoder.HCPerfManager", (String)localObject5 + " -> " + ((a.b)localObject3).toString(l3) + " delay:" + (l5 - ((a.b)localObject3).startTime));
                break;
              }
              if ((localObject4 == localObject2) || (!HardCoderJNI.hcDebug)) {
                break label2139;
              }
              localObject5 = new StringBuilder("CPUReq:");
              if (localObject4 == null) {}
              for (localObject4 = "null";; localObject4 = ((a.b)localObject4).toString(l3))
              {
                c.d("HardCoder.HCPerfManager", (String)localObject4 + " -> " + localObject2.toString(l3) + " delay:" + (l5 - localObject2.startTime));
                break;
              }
              localObject4 = localObject2.toString(l3);
              break label2210;
              localObject5 = ((a.b)localObject3).toString(l3);
              break label2220;
              localObject6 = localObject2.toString(l3);
              break label2230;
              localObject7 = ((a.b)localObject3).toString(l3);
              break label2240;
              bool1 = false;
              break label2341;
              bool1 = false;
              break label2360;
              bool1 = false;
              break label2373;
              bool1 = false;
              break label2396;
              bool1 = false;
              break label2451;
              bool1 = false;
              break label2546;
              bool1 = false;
              break label2561;
              bool1 = false;
              break label2586;
              bool1 = false;
              break label2601;
              bool1 = false;
              break label2622;
              bool1 = false;
              break label2635;
              bool1 = false;
              break label2746;
              bool1 = false;
              break label2772;
              bool1 = false;
              break label2817;
              bool1 = false;
              break label2864;
              bool1 = false;
              break label2913;
              bool1 = false;
              break label2941;
              bool1 = false;
              break label2956;
              bool1 = false;
              break label2974;
              bool1 = false;
              break label3033;
              localObject5 = "nextWake:" + l1 + " stop:" + (((a.b)localObject4).dEq - l3);
              if (l1 > ((a.b)localObject4).dEq - l3) {
                break label3727;
              }
              bool1 = true;
              Assert.assertTrue((String)localObject5, bool1);
              localObject5 = "reqTimeStamp:" + j;
              if ((j <= 0) || (j >= 9223372036854775807L)) {
                break label3733;
              }
              bool1 = true;
              Assert.assertTrue((String)localObject5, bool1);
              localObject5 = "reqTimeStamp:" + j + " stop:" + (((a.b)localObject4).dEq - l3);
              if (j > ((a.b)localObject4).dEq - l3) {
                break label3739;
              }
              bool1 = true;
              Assert.assertTrue((String)localObject5, bool1);
              localObject5 = "reqCpu:" + i + " task:" + ((a.b)localObject4).dEl;
              if (i > ((a.b)localObject4).dEl) {
                break label3745;
              }
              bool1 = true;
              Assert.assertTrue((String)localObject5, bool1);
              localObject5 = "reqIO:" + m + " task:" + ((a.b)localObject4).dEm;
              if (m > ((a.b)localObject4).dEm) {
                break label3751;
              }
              bool1 = true;
              Assert.assertTrue((String)localObject5, bool1);
            } while (((a.b)localObject4).dEn <= 0);
            label3263:
            label3275:
            label3287:
            label3299:
            label3575:
            Assert.assertTrue(localHashSet1.contains(localObject4));
            label3329:
            label3335:
            label3341:
            label3347:
            label3353:
            label3359:
            label3365:
            label3371:
            label3377:
            label3383:
            label3389:
            label3395:
            label3401:
            label3407:
            label3413:
            label3419:
            label3681:
            if (!((HashSet)localObject8).contains(localObject4)) {}
            label3473:
            label3515:
            for (boolean bool1 = true;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              break;
              bool1 = false;
              break label3473;
              bool1 = false;
              break label3515;
              bool1 = false;
              break label3575;
              bool1 = false;
              break label3627;
              bool1 = false;
              break label3681;
            }
            label3627:
            label3763:
            localObject6 = localHashSet1;
            label3727:
            label3733:
            label3739:
            label3745:
            label3751:
            localObject5 = localObject3;
            localObject4 = localObject2;
            break;
            c.i("HardCoder.HCPerfManager", "HCPerfManager thread run end");
            return;
            label3787:
            int i2 = 0;
            n = i;
            i1 = j;
            i = i2;
            j = n;
            n = i1;
          }
          label3809:
          m = 0;
        }
        label3815:
        continue;
        label3818:
        localObject6 = localHashSet1;
        localObject5 = localObject3;
        localObject4 = localObject2;
      }
    }
  }
  
  public static final class b
  {
    public int dEA = 0;
    public long dEB = 0L;
    public j.a dEC = null;
    public j.a dED = null;
    public long dEE = 0L;
    public long dEF = 0L;
    public int dEk = 0;
    public int dEl = 0;
    public int dEm = 0;
    public int dEn = 0;
    public long dEo = 0L;
    public long dEp = 0L;
    public long dEq = 0L;
    public int dEr = 0;
    public int dEs = 0;
    public int dEt = 0;
    public int[] dEu = new int[a.BO().length];
    public int[] dEv = new int[a.dEe.length];
    public int[] dEw = null;
    public long[] dEx = null;
    public long[] dEy = null;
    public long dEz = 0L;
    public int delay = 0;
    public long lastUpdateTime = 0L;
    public int scene = 0;
    public long startTime = 0L;
    public String tag;
    
    public final String toString(long paramLong)
    {
      return String.format("h:%x[%d,%d,%d][%d,%d][%d,%d,%d][%d,%d,%d][%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.dEp - paramLong), Long.valueOf(this.startTime - paramLong), Long.valueOf(this.dEq - paramLong), Integer.valueOf(this.delay), Integer.valueOf(this.dEk), Integer.valueOf(this.scene), Long.valueOf(this.dEo), Integer.valueOf(this.dEr), Integer.valueOf(this.dEl), Integer.valueOf(this.dEm), Integer.valueOf(this.dEn), this.tag });
    }
  }
  
  static final class c
  {
    public int auK = 0;
    public long dEF = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.a
 * JD-Core Version:    0.7.0.1
 */