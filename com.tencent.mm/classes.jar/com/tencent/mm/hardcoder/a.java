package com.tencent.mm.hardcoder;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public static boolean eBD = false;
  private static final int[] eBE = { 0, 1, 2, 3 };
  private static final int[] eBF = { 0, 1, 2, 3 };
  private b eBG;
  private Thread eBH;
  HardCoderJNI.HCPerfManagerThread eBI;
  LinkedBlockingQueue<Object> eBJ;
  
  public a(HardCoderJNI.HCPerfManagerThread paramHCPerfManagerThread, Context paramContext)
  {
    AppMethodBeat.i(93954);
    this.eBJ = new LinkedBlockingQueue();
    this.eBG = new b(paramContext);
    this.eBG.start();
    this.eBI = paramHCPerfManagerThread;
    this.eBH = this.eBI.newThread(new a((byte)0), "HCPerfManager", 10);
    this.eBH.start();
    c.i("HardCoder.HCPerfManager", String.format("hardcoder HCPerfManager new thread[%s]", new Object[] { this.eBH }));
    AppMethodBeat.o(93954);
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    AppMethodBeat.i(93955);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt4 < 0) || (paramInt3 < 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length <= 0) || (paramInt5 <= 0) || ((paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0) && (paramArrayOfInt.length == 1) && (paramArrayOfInt[0] == 0)))
    {
      if (paramArrayOfInt == null) {}
      for (paramInt6 = 0;; paramInt6 = paramArrayOfInt.length)
      {
        c.e("HardCoder.HCPerfManager", String.format("start error params, ignore this task! delay:%d, [cpu:%d, io:%d, gpu:%d], bindTids:%d, timeout:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt6), Integer.valueOf(paramInt5) }));
        AppMethodBeat.o(93955);
        return 0;
      }
    }
    b localb = new b();
    localb.delay = paramInt1;
    localb.eBN = paramInt2;
    localb.eBP = paramInt3;
    localb.eBQ = ((int[])paramArrayOfInt.clone());
    localb.eBO = paramInt4;
    localb.eBM = paramInt5;
    localb.scene = paramInt6;
    localb.eBR = paramLong;
    localb.eBU = paramInt7;
    localb.eBS = System.currentTimeMillis();
    localb.startTime = (localb.eBS + paramInt1);
    localb.eBT = (localb.eBS + paramInt1 + paramInt5);
    localb.tag = paramString;
    localb.lastUpdateTime = localb.startTime;
    boolean bool = this.eBJ.offer(localb);
    c.d("HardCoder.HCPerfManager", String.format("start ret:%b ,task:%s", new Object[] { Boolean.valueOf(bool), localb.toString(localb.eBS) }));
    if (bool)
    {
      paramInt1 = localb.hashCode();
      AppMethodBeat.o(93955);
      return paramInt1;
    }
    AppMethodBeat.o(93955);
    return 0;
  }
  
  final class a
    implements Runnable
  {
    private boolean running = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(93950);
      c.i("HardCoder.HCPerfManager", String.format("HCPerfManager thread run start, id:%d, name:%s", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName() }));
      this.running = true;
      Object localObject8 = new HashSet();
      long l1 = 30000L;
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = g.PE();
      Object localObject1;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (localObject3.length >= 2) {}
      }
      else
      {
        localObject1 = new long[2];
        Object tmp96_94 = localObject1;
        tmp96_94[0] = 0L;
        Object tmp100_96 = tmp96_94;
        tmp100_96[1] = 0L;
        tmp100_96;
        c.i("HardCoder.HardCoderReporter", "process jiffes info is invalid");
      }
      c.i("HardCoder.HardCoderReporter", "process:[" + localObject1[0] + "," + localObject1[1] + "]");
      HashMap localHashMap = new HashMap();
      HashSet localHashSet2 = new HashSet();
      Object localObject7 = null;
      Object localObject6 = null;
      Object localObject5 = null;
      for (;;)
      {
        long l5;
        int k;
        int i;
        int j;
        Object localObject2;
        Object localObject4;
        HashSet localHashSet1;
        long l3;
        Object localObject9;
        long l4;
        long l2;
        Object localObject11;
        Object localObject12;
        label751:
        Object localObject10;
        label852:
        int m;
        if (this.running)
        {
          l5 = System.currentTimeMillis();
          k = a.a(a.this).size();
          c.d("HardCoder.HCPerfManager", "startLoop queue:" + k + " startTask:" + tmp96_94.size() + " nextWakeInterval:" + l1);
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
                    tmp96_94.add((a.b)localObject1);
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
                  c.e("HardCoder.HCPerfManager", "taskQueue poll: " + localException.getMessage());
                  localObject2 = null;
                  continue;
                  if ((localObject2 instanceof a.c))
                  {
                    j = ((a.c)localObject2).axc;
                    if (localHashSet2.contains(Integer.valueOf(j))) {
                      localHashMap.put(Integer.valueOf(j), (a.c)localObject2);
                    }
                  }
                  else
                  {
                    if (!HardCoderJNI.isCheckEnv()) {
                      break;
                    }
                    Assert.fail("taskQueue poll invalid object");
                  }
                }
                this.running = false;
              }
            }
          }
          l1 = 30000L;
          localObject2 = null;
          localObject3 = null;
          localObject4 = null;
          localHashSet1 = new HashSet();
          l3 = System.currentTimeMillis();
          c.d("HardCoder.HCPerfManager", "InLoop startSize:" + tmp96_94.size());
          i = 0;
          if (i < tmp96_94.size())
          {
            localObject9 = (a.b)tmp96_94.get(i);
            l4 = System.currentTimeMillis();
            j = i;
            l2 = l1;
            localObject11 = localObject4;
            localObject12 = localObject3;
            Object localObject13 = localObject2;
            if (localObject9 != null)
            {
              if (localHashMap.containsKey(Integer.valueOf(localObject9.hashCode())))
              {
                ((a.b)localObject9).eBT = l4;
                ((a.b)localObject9).eBL = ((a.c)localHashMap.get(Integer.valueOf(localObject9.hashCode()))).eBL;
                localHashMap.remove(Integer.valueOf(localObject9.hashCode()));
                a.a(a.this, l4, tmp96_94, -2, -2, -2, null);
                a.a(a.this, (a.b)localObject9);
              }
              l2 = ((a.b)localObject9).eBT - l4;
              if (l2 > 0L) {
                break label751;
              }
              c.d("HardCoder.HCPerfManager", "InLoop STOP:" + i + "/" + tmp96_94.size() + " task:" + ((a.b)localObject9).toString(l4));
              tmp96_94.remove(localObject9);
              localHashSet2.remove(Integer.valueOf(localObject9.hashCode()));
              j = i - 1;
              localObject13 = localObject2;
              localObject12 = localObject3;
              localObject11 = localObject4;
              l2 = l1;
            }
            for (;;)
            {
              i = j + 1;
              l1 = l2;
              localObject4 = localObject11;
              localObject3 = localObject12;
              localObject2 = localObject13;
              break;
              l1 = Math.min(l1, l2);
              l2 = ((a.b)localObject9).startTime - l4;
              if (l2 <= 0L) {
                break label852;
              }
              c.d("HardCoder.HCPerfManager", "InLoop WAIT:" + i + "/" + tmp96_94.size() + " task:" + ((a.b)localObject9).toString(l4));
              l2 = Math.min(l1, l2);
              j = i;
              localObject11 = localObject4;
              localObject12 = localObject3;
              localObject13 = localObject2;
            }
            c.d("HardCoder.HCPerfManager", "InLoop RUN:" + i + "/" + tmp96_94.size() + " task:" + ((a.b)localObject9).toString(l4));
            localObject10 = localObject2;
            if (((a.b)localObject9).eBN > 0) {
              if ((localObject2 != null) && (localObject2.eBN <= ((a.b)localObject9).eBN))
              {
                localObject10 = localObject2;
                if (localObject2.eBN == ((a.b)localObject9).eBN)
                {
                  localObject10 = localObject2;
                  if (localObject2.eBT >= ((a.b)localObject9).eBT) {}
                }
              }
              else
              {
                localObject10 = localObject9;
              }
            }
            localObject2 = localObject3;
            if (((a.b)localObject9).eBO > 0) {
              if ((localObject3 != null) && (((a.b)localObject3).eBO <= ((a.b)localObject9).eBO))
              {
                localObject2 = localObject3;
                if (((a.b)localObject3).eBO == ((a.b)localObject9).eBO)
                {
                  localObject2 = localObject3;
                  if (((a.b)localObject3).eBT >= ((a.b)localObject9).eBT) {}
                }
              }
              else
              {
                localObject2 = localObject9;
              }
            }
            localObject3 = localObject4;
            if (((a.b)localObject9).eBP > 0) {
              if ((localObject4 != null) && (((a.b)localObject4).eBP <= ((a.b)localObject9).eBP))
              {
                localObject3 = localObject4;
                if (((a.b)localObject4).eBP == ((a.b)localObject9).eBP)
                {
                  localObject3 = localObject4;
                  if (((a.b)localObject4).eBT >= ((a.b)localObject9).eBT) {}
                }
              }
              else
              {
                localObject3 = localObject9;
              }
            }
            localObject4 = ((a.b)localObject9).eBQ;
            m = localObject4.length;
            k = 0;
            for (;;)
            {
              j = i;
              l2 = l1;
              localObject11 = localObject3;
              localObject12 = localObject2;
              localObject13 = localObject10;
              if (k >= m) {
                break;
              }
              if (localObject4[k] > 0)
              {
                localHashSet1.add(localObject9);
                j = i;
                l2 = l1;
                localObject11 = localObject3;
                localObject12 = localObject2;
                localObject13 = localObject10;
                break;
              }
              k += 1;
            }
          }
          l4 = System.currentTimeMillis();
          c.d("HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[] { Long.valueOf(l4 - l3), Long.valueOf(l4 - l5), Integer.valueOf(tmp96_94.size()), Integer.valueOf(localHashMap.size()), Integer.valueOf(((HashSet)localObject8).size()), Integer.valueOf(localHashSet1.size()) }));
          localObject10 = new StringBuilder("EndLoop CurrCpu:");
          if (localObject5 == null)
          {
            localObject9 = "null";
            label1298:
            localObject10 = ((StringBuilder)localObject10).append((String)localObject9).append(" -> MaxCpu:");
            if (localObject2 != null) {
              break label1589;
            }
            localObject9 = "null";
            label1323:
            c.d("HardCoder.HCPerfManager", (String)localObject9);
            localObject10 = new StringBuilder("EndLoop CurrGpu:");
            if (localObject6 != null) {
              break label1601;
            }
            localObject9 = "null";
            label1360:
            localObject10 = ((StringBuilder)localObject10).append((String)localObject9).append(" -> MaxGpu:");
            if (localObject6 != null) {
              break label1613;
            }
            localObject9 = "null";
            label1385:
            c.d("HardCoder.HCPerfManager", (String)localObject9);
            localObject10 = new StringBuilder("EndLoop CurrIO:");
            if (localObject7 != null) {
              break label1625;
            }
            localObject9 = "null";
            label1422:
            localObject10 = ((StringBuilder)localObject10).append((String)localObject9).append(" -> MaxIO:");
            if (localObject4 != null) {
              break label1637;
            }
          }
          label1589:
          label1601:
          label1613:
          label1625:
          label1637:
          for (localObject9 = "null";; localObject9 = ((a.b)localObject4).toString(l3))
          {
            c.d("HardCoder.HCPerfManager", (String)localObject9);
            c.d("HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[] { Integer.valueOf(((HashSet)localObject8).size()), Integer.valueOf(localHashSet1.size()) }));
            localObject11 = new HashSet();
            ((HashSet)localObject11).addAll((Collection)localObject8);
            ((HashSet)localObject11).removeAll(localHashSet1);
            if ((localObject2 != localObject5) || (localObject3 != localObject6) || (localObject4 != localObject7) || (((HashSet)localObject8).size() != localHashSet1.size()) || (!((HashSet)localObject11).isEmpty())) {
              break label1649;
            }
            c.d("HardCoder.HCPerfManager", "EndLoop Nothing Changed, Continue.");
            break;
            localObject9 = ((a.b)localObject5).toString(l3);
            break label1298;
            localObject9 = localObject2.toString(l3);
            break label1323;
            localObject9 = ((a.b)localObject6).toString(l3);
            break label1360;
            localObject9 = ((a.b)localObject6).toString(l3);
            break label1385;
            localObject9 = ((a.b)localObject7).toString(l3);
            break label1422;
          }
          label1649:
          localObject8 = ((HashSet)localObject11).iterator();
          i = 0;
          label1658:
          if (((Iterator)localObject8).hasNext())
          {
            localObject9 = (a.b)((Iterator)localObject8).next();
            if (((a.b)localObject9).eBQ == null) {
              break label4489;
            }
            i = ((a.b)localObject9).eBQ.length + i;
          }
        }
        label3080:
        label4489:
        for (;;)
        {
          break label1658;
          if (i > 0)
          {
            localObject8 = new int[i];
            localObject9 = ((HashSet)localObject11).iterator();
            i = 0;
            label1718:
            while (((Iterator)localObject9).hasNext())
            {
              localObject10 = (a.b)((Iterator)localObject9).next();
              l2 = System.currentTimeMillis();
              c.i("HardCoder.HCPerfManager", "!cancelBindCore task:" + ((a.b)localObject10).toString(l2));
              if (((a.b)localObject10).eBT > l2)
              {
                c.e("HardCoder.HCPerfManager", "stopTime:" + (((a.b)localObject10).eBT - l2) + ". Error !");
              }
              else
              {
                if (!((a.b)localObject10).PC())
                {
                  if (HardCoderJNI.isCheckEnv()) {
                    Assert.fail("bindTids:" + ((a.b)localObject10).PD());
                  }
                }
                else
                {
                  localObject10 = ((a.b)localObject10).eBQ;
                  k = localObject10.length;
                  j = 0;
                  while (j < k)
                  {
                    localObject8[i] = localObject10[j];
                    i += 1;
                    j += 1;
                  }
                }
                this.running = false;
              }
            }
            if ((!a.eBD) && (HardCoderJNI.isCheckEnv())) {
              HardCoderJNI.cancelCpuCoreForThread((int[])localObject8, Process.myTid(), SystemClock.elapsedRealtimeNanos());
            }
            a.a(a.this, l3, tmp96_94, -2, -2, -2, null);
          }
          localObject8 = localHashSet1.iterator();
          i = 0;
          label1953:
          if (((Iterator)localObject8).hasNext())
          {
            localObject9 = (a.b)((Iterator)localObject8).next();
            if (((a.b)localObject9).eBQ == null) {
              break label4486;
            }
            i = ((a.b)localObject9).eBQ.length + i;
          }
          for (;;)
          {
            break label1953;
            break label1718;
            localObject12 = new int[i];
            localObject8 = localHashSet1.iterator();
            m = 0;
            l2 = 0L;
            k = 0;
            i = 2147483647;
            j = 0;
            while (((Iterator)localObject8).hasNext())
            {
              localObject9 = (a.b)((Iterator)localObject8).next();
              c.i("HardCoder.HCPerfManager", "requestBindCore task:" + ((a.b)localObject9).toString(l3));
              l5 = System.currentTimeMillis();
              if (((a.b)localObject9).eBT <= l5)
              {
                c.e("HardCoder.HCPerfManager", "stopTime:" + (((a.b)localObject9).eBT - l5) + ". Error !");
              }
              else
              {
                if (!((a.b)localObject9).PC())
                {
                  if (HardCoderJNI.isCheckEnv()) {
                    Assert.fail("bindTids:" + ((a.b)localObject9).PD());
                  }
                }
                else
                {
                  localObject10 = ((a.b)localObject9).eBQ;
                  k = localObject10.length;
                  j = 0;
                  while (j < k)
                  {
                    localObject12[m] = localObject10[j];
                    m += 1;
                    j += 1;
                  }
                }
                this.running = false;
              }
            }
            if (localObject4 == null)
            {
              if (localObject7 != null)
              {
                c.i("HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + ((a.b)localObject7).toString(l3));
                if ((!a.eBD) && (HardCoderJNI.isCheckEnv())) {
                  HardCoderJNI.cancelHighIOFreq(((a.b)localObject7).eBU, SystemClock.elapsedRealtimeNanos());
                }
                a.a(a.this, l3, tmp96_94, -2, -2, -1, null);
              }
              label2290:
              if (localObject4 == null) {
                break label4480;
              }
              m = ((a.b)localObject4).eBP;
              k = ((a.b)localObject4).scene;
              l2 = ((a.b)localObject4).eBR;
              j = ((a.b)localObject4).eBU;
              i = Math.min((int)(((a.b)localObject4).eBT - l3), i);
            }
            for (;;)
            {
              label2414:
              int n;
              if (localObject3 == null)
              {
                if (localObject6 != null)
                {
                  c.i("HardCoder.HCPerfManager", "!cancelGpuHighFreq task:" + ((a.b)localObject6).toString(l3));
                  if ((!a.eBD) && (HardCoderJNI.isCheckEnv())) {
                    HardCoderJNI.cancelGpuHighFreq(((a.b)localObject6).eBU, SystemClock.elapsedRealtimeNanos());
                  }
                  a.a(a.this, l3, tmp96_94, -2, -1, -2, null);
                }
                if (localObject3 == null) {
                  break label4474;
                }
                n = ((a.b)localObject3).eBO;
                k = ((a.b)localObject3).scene;
                l2 = ((a.b)localObject3).eBR;
                j = ((a.b)localObject3).eBU;
                i = Math.min((int)(((a.b)localObject3).eBT - l3), i);
              }
              for (;;)
              {
                label2538:
                int i1;
                if (localObject2 == null)
                {
                  if (localObject5 != null)
                  {
                    c.i("HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + ((a.b)localObject5).toString(l3));
                    if ((!a.eBD) && (HardCoderJNI.isCheckEnv())) {
                      HardCoderJNI.cancelCpuHighFreq(((a.b)localObject5).eBU, SystemClock.elapsedRealtimeNanos());
                    }
                    a.a(a.this, l3, tmp96_94, -1, -2, -2, null);
                  }
                  if (localObject2 == null) {
                    break label4462;
                  }
                  j = localObject2.eBN;
                  k = localObject2.scene;
                  l2 = localObject2.eBR;
                  i1 = localObject2.eBU;
                  i = Math.min((int)(localObject2.eBT - l3), i);
                }
                for (;;)
                {
                  if (i < 2147483647)
                  {
                    i2 = localObject12.length;
                    if (localObject2 == null)
                    {
                      localObject5 = "null";
                      label2605:
                      if (localObject3 != null) {
                        break label3845;
                      }
                      localObject6 = "null";
                      label2615:
                      if (localObject4 != null) {
                        break label3857;
                      }
                      localObject7 = "null";
                      label2625:
                      if (localObject2 != null) {
                        break label3869;
                      }
                      localObject8 = "null";
                      label2635:
                      if (localObject3 != null) {
                        break label3881;
                      }
                      localObject9 = "null";
                      label2645:
                      if (localObject4 != null) {
                        break label3893;
                      }
                      localObject10 = "null";
                      label2655:
                      c.i("HardCoder.HCPerfManager", String.format("!UnifyRequest [%d,%d,%d] [%d,%d,%d,%d] TO:%d max CPU:%s GPU:%s IO:%s cur CPU:%s GPU:%s IO:%s", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(i1), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i2), Integer.valueOf(i), localObject5, localObject6, localObject7, localObject8, localObject9, localObject10 }));
                      if (i <= 0) {
                        break label3905;
                      }
                      bool1 = true;
                      label2777:
                      Assert.assertTrue(bool1);
                      if ((k <= 0) && (l2 <= 0L)) {
                        break label3911;
                      }
                      bool1 = true;
                      label2796:
                      Assert.assertTrue(bool1);
                      if (i1 <= 0) {
                        break label3917;
                      }
                      bool1 = true;
                      label2809:
                      Assert.assertTrue(bool1);
                      if ((j <= 0) && (n <= 0) && (m <= 0) && (localObject12.length <= 0)) {
                        break label3923;
                      }
                      bool1 = true;
                      label2837:
                      Assert.assertTrue(bool1);
                      if ((!a.eBD) && (HardCoderJNI.isCheckEnv()))
                      {
                        HardCoderJNI.requestUnifyCpuIOThreadCoreGpu(k, l2, j, n, m, (int[])localObject12, i, i1, SystemClock.elapsedRealtimeNanos());
                        boolean bool2 = HardCoderJNI.isHcEnable();
                        if ((!HardCoderJNI.isCheckEnv()) || (HardCoderJNI.isRunning() <= 0)) {
                          break label3929;
                        }
                        bool1 = true;
                        label2894:
                        c.i("HardCoder.HCPerfManager", String.format("hardcoder requestUnifyCpuIOThreadCoreGpu reqScene[%d, %d] running[j %b, c %b]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
                        if (HardCoderJNI.sceneReportCallback != null) {
                          HardCoderJNI.sceneReportCallback.sceneReport(k, l2);
                        }
                      }
                      a.a(a.this, l3, tmp96_94, j, n, m, (int[])localObject12);
                    }
                  }
                  else
                  {
                    if (!a.eBD) {
                      break label4492;
                    }
                    if (localObject2 != localObject2) {
                      break label3935;
                    }
                    bool1 = true;
                    label2991:
                    Assert.assertTrue(bool1);
                    if (localObject4 != localObject4) {
                      break label3941;
                    }
                    bool1 = true;
                    label3006:
                    Assert.assertTrue(bool1);
                    if (tmp96_94.isEmpty())
                    {
                      if (l1 != 30000L) {
                        break label3947;
                      }
                      bool1 = true;
                      label3031:
                      Assert.assertTrue(bool1);
                      if (i != 2147483647) {
                        break label3953;
                      }
                      bool1 = true;
                      label3046:
                      Assert.assertTrue(bool1);
                      Assert.assertTrue(localHashSet1.isEmpty());
                      if (localObject2 != null) {
                        break label3959;
                      }
                      bool1 = true;
                      label3067:
                      Assert.assertTrue(bool1);
                      if (localObject3 != null) {
                        break label3965;
                      }
                      bool1 = true;
                      Assert.assertTrue(bool1);
                      if (localObject4 != null) {
                        break label3971;
                      }
                      bool1 = true;
                      label3093:
                      Assert.assertTrue(bool1);
                    }
                    k = 0;
                    label3100:
                    if (k >= tmp96_94.size()) {
                      break label4429;
                    }
                    localObject5 = (a.b)tmp96_94.get(k);
                    c.d("HardCoder.HCPerfManager", "CheckTask:" + k + "/" + tmp96_94.size() + " task:" + ((a.b)localObject5).toString(l3));
                    if ((((a.b)localObject5).eBN <= 0) && (((a.b)localObject5).eBO <= 0) && (((a.b)localObject5).eBP <= 0) && (!((a.b)localObject5).PC())) {
                      break label3977;
                    }
                    bool1 = true;
                    Assert.assertTrue(bool1);
                    if ((((a.b)localObject5).eBR <= 0L) && (((a.b)localObject5).scene <= 0)) {
                      break label3983;
                    }
                    bool1 = true;
                    label3231:
                    Assert.assertTrue(bool1);
                    localObject6 = "taskInintTime:" + (((a.b)localObject5).eBS - l3);
                    if (((a.b)localObject5).eBS > l3) {
                      break label3989;
                    }
                    bool1 = true;
                    label3276:
                    Assert.assertTrue((String)localObject6, bool1);
                    localObject6 = "taskStopTime:" + (((a.b)localObject5).eBT - l3);
                    if (((a.b)localObject5).eBT < l3) {
                      break label3995;
                    }
                    bool1 = true;
                    label3323:
                    Assert.assertTrue((String)localObject6, bool1);
                    localObject6 = "taskHash:" + localObject5.hashCode();
                    if (localHashMap.containsKey(Integer.valueOf(localObject5.hashCode()))) {
                      break label4001;
                    }
                    bool1 = true;
                    label3372:
                    Assert.assertTrue((String)localObject6, bool1);
                    if (((a.b)localObject5).startTime <= l3) {
                      break label4037;
                    }
                    if (localObject5 == localObject2) {
                      break label4007;
                    }
                    bool1 = true;
                    label3400:
                    Assert.assertTrue(bool1);
                    if (localObject5 == localObject3) {
                      break label4013;
                    }
                    bool1 = true;
                    label3415:
                    Assert.assertTrue(bool1);
                    if (localObject5 == localObject4) {
                      break label4019;
                    }
                    bool1 = true;
                    label3430:
                    Assert.assertTrue(bool1);
                    if (localHashSet1.contains(localObject5)) {
                      break label4025;
                    }
                    bool1 = true;
                    label3448:
                    Assert.assertTrue(bool1);
                    localObject6 = "next:" + l1 + " start:" + (((a.b)localObject5).startTime - l3);
                    if (l1 > ((a.b)localObject5).startTime - l3) {
                      break label4031;
                    }
                    bool1 = true;
                    label3507:
                    Assert.assertTrue((String)localObject6, bool1);
                  }
                  label3857:
                  label3869:
                  label3881:
                  label3893:
                  label3905:
                  label3911:
                  label3917:
                  label3923:
                  label3929:
                  label3935:
                  label3941:
                  label3947:
                  label3953:
                  label3959:
                  label3965:
                  do
                  {
                    k += 1;
                    break label3100;
                    k = ((a.b)localObject9).scene;
                    l2 = ((a.b)localObject9).eBR;
                    j = ((a.b)localObject9).eBU;
                    i = Math.min((int)(((a.b)localObject9).eBT - l3), i);
                    break;
                    if (localObject7 == localObject4) {
                      break label2290;
                    }
                    localObject8 = new StringBuilder("IOReq:");
                    if (localObject7 == null) {}
                    for (localObject7 = "null";; localObject7 = ((a.b)localObject7).toString(l3))
                    {
                      c.d("HardCoder.HCPerfManager", (String)localObject7 + " -> " + ((a.b)localObject4).toString(l3) + " delay:" + (l4 - ((a.b)localObject4).startTime));
                      break;
                    }
                    if (localObject6 == localObject3) {
                      break label2414;
                    }
                    localObject7 = new StringBuilder("GPUReq:");
                    if (localObject6 == null) {}
                    for (localObject6 = "null";; localObject6 = ((a.b)localObject6).toString(l3))
                    {
                      c.d("HardCoder.HCPerfManager", (String)localObject6 + " -> " + ((a.b)localObject3).toString(l3) + " delay:" + (l4 - ((a.b)localObject3).startTime));
                      break;
                    }
                    if (localObject5 == localObject2) {
                      break label2538;
                    }
                    localObject6 = new StringBuilder("CPUReq:");
                    if (localObject5 == null) {}
                    for (localObject5 = "null";; localObject5 = ((a.b)localObject5).toString(l3))
                    {
                      c.d("HardCoder.HCPerfManager", (String)localObject5 + " -> " + localObject2.toString(l3) + " delay:" + (l4 - localObject2.startTime));
                      break;
                    }
                    localObject5 = localObject2.toString(l3);
                    break label2605;
                    localObject6 = ((a.b)localObject3).toString(l3);
                    break label2615;
                    localObject7 = ((a.b)localObject4).toString(l3);
                    break label2625;
                    localObject8 = localObject2.toString(l3);
                    break label2635;
                    localObject9 = ((a.b)localObject3).toString(l3);
                    break label2645;
                    localObject10 = ((a.b)localObject4).toString(l3);
                    break label2655;
                    bool1 = false;
                    break label2777;
                    bool1 = false;
                    break label2796;
                    bool1 = false;
                    break label2809;
                    bool1 = false;
                    break label2837;
                    bool1 = false;
                    break label2894;
                    bool1 = false;
                    break label2991;
                    bool1 = false;
                    break label3006;
                    bool1 = false;
                    break label3031;
                    bool1 = false;
                    break label3046;
                    bool1 = false;
                    break label3067;
                    bool1 = false;
                    break label3080;
                    bool1 = false;
                    break label3093;
                    bool1 = false;
                    break label3205;
                    bool1 = false;
                    break label3231;
                    bool1 = false;
                    break label3276;
                    bool1 = false;
                    break label3323;
                    bool1 = false;
                    break label3372;
                    bool1 = false;
                    break label3400;
                    bool1 = false;
                    break label3415;
                    bool1 = false;
                    break label3430;
                    bool1 = false;
                    break label3448;
                    bool1 = false;
                    break label3507;
                    localObject6 = "nextWake:" + l1 + " stop:" + (((a.b)localObject5).eBT - l3);
                    if (l1 > ((a.b)localObject5).eBT - l3) {
                      break label4387;
                    }
                    bool1 = true;
                    Assert.assertTrue((String)localObject6, bool1);
                    localObject6 = "reqTimeStamp:".concat(String.valueOf(i));
                    if ((i <= 0) || (i >= 2147483647)) {
                      break label4393;
                    }
                    bool1 = true;
                    Assert.assertTrue((String)localObject6, bool1);
                    localObject6 = "reqTimeStamp:" + i + " stop:" + (((a.b)localObject5).eBT - l3);
                    if (i > ((a.b)localObject5).eBT - l3) {
                      break label4399;
                    }
                    bool1 = true;
                    Assert.assertTrue((String)localObject6, bool1);
                    localObject6 = "reqCpu:" + j + " task:" + ((a.b)localObject5).eBN;
                    if (j > ((a.b)localObject5).eBN) {
                      break label4405;
                    }
                    bool1 = true;
                    Assert.assertTrue((String)localObject6, bool1);
                    localObject6 = "reqCpu:" + n + " task:" + ((a.b)localObject5).eBO;
                    if (n > ((a.b)localObject5).eBO) {
                      break label4411;
                    }
                    bool1 = true;
                    Assert.assertTrue((String)localObject6, bool1);
                    localObject6 = "reqIO:" + m + " task:" + ((a.b)localObject5).eBP;
                    if (m > ((a.b)localObject5).eBP) {
                      break label4417;
                    }
                    bool1 = true;
                    Assert.assertTrue((String)localObject6, bool1);
                  } while (!((a.b)localObject5).PC());
                  label3977:
                  label3983:
                  label3989:
                  label3995:
                  label4001:
                  label4007:
                  label4013:
                  label4019:
                  label4025:
                  label4031:
                  label4037:
                  label4091:
                  Assert.assertTrue(localHashSet1.contains(localObject5));
                  label4124:
                  label4184:
                  label4341:
                  if (!((HashSet)localObject11).contains(localObject5)) {}
                  label4235:
                  label4288:
                  for (boolean bool1 = true;; bool1 = false)
                  {
                    Assert.assertTrue(bool1);
                    break;
                    bool1 = false;
                    break label4091;
                    bool1 = false;
                    break label4124;
                    bool1 = false;
                    break label4184;
                    bool1 = false;
                    break label4235;
                    bool1 = false;
                    break label4288;
                    label4417:
                    bool1 = false;
                    break label4341;
                  }
                  label4387:
                  label4393:
                  label4399:
                  label4405:
                  label4411:
                  label4429:
                  localObject8 = localHashSet1;
                  localObject7 = localObject4;
                  localObject6 = localObject3;
                  localObject5 = localObject2;
                  break;
                  c.i("HardCoder.HCPerfManager", "HCPerfManager thread run end");
                  AppMethodBeat.o(93950);
                  return;
                  label4462:
                  int i2 = 0;
                  i1 = j;
                  j = i2;
                }
                label4474:
                n = 0;
              }
              m = 0;
            }
          }
        }
        label3205:
        label4486:
        label4492:
        localObject8 = localHashSet1;
        label3845:
        localObject7 = localObject4;
        label3971:
        localObject6 = localObject3;
        label4480:
        localObject5 = localObject2;
      }
    }
  }
  
  public static final class b
  {
    public int delay;
    public long eBL;
    public int eBM;
    public int eBN;
    public int eBO;
    public int eBP;
    public int[] eBQ;
    public long eBR;
    public long eBS;
    public long eBT;
    public int eBU;
    public int eBV;
    public int eBW;
    public int[] eBX;
    public int[] eBY;
    public int[] eBZ;
    public long[] eCa;
    public long[] eCb;
    public long eCc;
    public int eCd;
    public long eCe;
    public f.a eCf;
    public f.a eCg;
    public long lastUpdateTime;
    public int scene;
    public long startTime;
    public String tag;
    
    public b()
    {
      AppMethodBeat.i(93951);
      this.eBL = 0L;
      this.delay = 0;
      this.eBM = 0;
      this.eBN = 0;
      this.eBO = 0;
      this.eBP = 0;
      this.eBQ = null;
      this.scene = 0;
      this.eBR = 0L;
      this.startTime = 0L;
      this.eBS = 0L;
      this.eBT = 0L;
      this.eBU = 0;
      this.eBV = 0;
      this.eBW = 0;
      this.lastUpdateTime = 0L;
      this.eBX = new int[a.PB().length];
      this.eBY = new int[a.eBF.length];
      this.eBZ = null;
      this.eCa = null;
      this.eCb = null;
      this.eCc = 0L;
      this.eCd = 0;
      this.eCe = 0L;
      this.eCf = null;
      this.eCg = null;
      AppMethodBeat.o(93951);
    }
    
    public final boolean PC()
    {
      boolean bool2 = true;
      boolean bool1;
      if ((this.eBQ != null) && (this.eBQ.length > 0))
      {
        bool1 = bool2;
        if (this.eBQ.length == 1)
        {
          bool1 = bool2;
          if (this.eBQ[0] > 0) {}
        }
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    
    public final String PD()
    {
      AppMethodBeat.i(93953);
      if (PC())
      {
        Object localObject = new StringBuilder("[");
        int[] arrayOfInt = this.eBQ;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          ((StringBuilder)localObject).append(k + " ");
          i += 1;
        }
        ((StringBuilder)localObject).append("]");
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(93953);
        return localObject;
      }
      AppMethodBeat.o(93953);
      return "[ ]";
    }
    
    public final String toString(long paramLong)
    {
      AppMethodBeat.i(93952);
      String str = String.format("hashCode:%x time:[init:%d,start:%d,stop:%d][delay:%d,timeout:%d][scene:%d,action:%d,callerTid:%d][cpu:%d,io:%d,gpu:%d] bindTids:%s [TAG:%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.eBS - paramLong), Long.valueOf(this.startTime - paramLong), Long.valueOf(this.eBT - paramLong), Integer.valueOf(this.delay), Integer.valueOf(this.eBM), Integer.valueOf(this.scene), Long.valueOf(this.eBR), Integer.valueOf(this.eBU), Integer.valueOf(this.eBN), Integer.valueOf(this.eBP), Integer.valueOf(this.eBO), PD(), this.tag });
      AppMethodBeat.o(93952);
      return str;
    }
  }
  
  static final class c
  {
    public int axc = 0;
    public long eBL = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.a
 * JD-Core Version:    0.7.0.1
 */