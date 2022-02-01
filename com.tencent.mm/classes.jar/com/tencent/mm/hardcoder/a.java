package com.tencent.mm.hardcoder;

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

public final class a
{
  private static final int[] gyg = { 0, 1, 2, 3 };
  private static final int[] gyh = { 0, 1, 2, 3 };
  private b gyi;
  private Thread gyj;
  private HardCoderJNI.HCPerfManagerThread gyk;
  LinkedBlockingQueue<Object> gyl;
  
  public a(HardCoderJNI.HCPerfManagerThread paramHCPerfManagerThread)
  {
    AppMethodBeat.i(62445);
    this.gyl = new LinkedBlockingQueue();
    this.gyi = new b();
    this.gyi.start();
    this.gyk = paramHCPerfManagerThread;
    this.gyj = this.gyk.newThread(new a((byte)0), "HCPerfManager", 10);
    this.gyj.start();
    d.i("Hardcoder.HCPerfManager", String.format("HCPerfManager new thread[%s]", new Object[] { this.gyj }));
    AppMethodBeat.o(62445);
  }
  
  private static void wV(String paramString)
  {
    AppMethodBeat.i(62447);
    if (paramString == null)
    {
      paramString = new AssertionError();
      AppMethodBeat.o(62447);
      throw paramString;
    }
    paramString = new AssertionError(paramString);
    AppMethodBeat.o(62447);
    throw paramString;
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    AppMethodBeat.i(62446);
    int i;
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt4 < 0) || (paramInt3 < 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length <= 0) || (paramInt5 <= 0))
    {
      i = 0;
      if ((i != 0) && ((paramInt2 != 0) || (paramInt3 != 0) || (paramInt4 != 0) || (paramArrayOfInt.length != 1) || (paramArrayOfInt[0] != 0))) {
        break label162;
      }
      if (paramArrayOfInt != null) {
        break label154;
      }
    }
    label154:
    for (paramInt6 = 0;; paramInt6 = paramArrayOfInt.length)
    {
      d.e("Hardcoder.HCPerfManager", String.format("start error params, ignore this task! delay:%d, [cpu:%d, io:%d, gpu:%d], bindTids:%d, timeout:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt6), Integer.valueOf(paramInt5) }));
      AppMethodBeat.o(62446);
      return 0;
      i = 1;
      break;
    }
    label162:
    b localb = new b();
    localb.delay = paramInt1;
    localb.gyo = paramInt2;
    localb.gyq = paramInt3;
    localb.gyr = ((int[])paramArrayOfInt.clone());
    localb.gyp = paramInt4;
    localb.timeout = paramInt5;
    localb.scene = paramInt6;
    localb.gys = paramLong;
    localb.gyv = paramInt7;
    localb.gyt = System.currentTimeMillis();
    localb.startTime = (localb.gyt + paramInt1);
    localb.gyu = (localb.gyt + paramInt1 + paramInt5);
    localb.tag = paramString;
    localb.lastUpdateTime = localb.startTime;
    boolean bool = this.gyl.offer(localb);
    d.d("Hardcoder.HCPerfManager", String.format("start ret:%b ,task:%s", new Object[] { Boolean.valueOf(bool), localb.toString(localb.gyt) }));
    if (bool)
    {
      paramInt1 = localb.hashCode();
      AppMethodBeat.o(62446);
      return paramInt1;
    }
    AppMethodBeat.o(62446);
    return 0;
  }
  
  final class a
    implements Runnable
  {
    private boolean running = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(62441);
      if (Thread.currentThread() == null) {
        l1 = -1L;
      }
      Object localObject10;
      ArrayList localArrayList;
      HashMap localHashMap;
      HashSet localHashSet2;
      Object localObject9;
      Object localObject8;
      Object localObject7;
      long l5;
      for (;;)
      {
        d.i("Hardcoder.HCPerfManager", String.format("HCPerfManager thread run start, id:%d, name:%s", new Object[] { Long.valueOf(l1), Thread.currentThread().getName() }));
        this.running = true;
        localObject10 = new HashSet();
        l1 = 30000L;
        localArrayList = new ArrayList();
        localObject3 = f.ahC();
        Object localObject1;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (localObject3.length >= 2) {}
        }
        else
        {
          localObject1 = new long[2];
          Object tmp103_101 = localObject1;
          tmp103_101[0] = 0L;
          Object tmp107_103 = tmp103_101;
          tmp107_103[1] = 0L;
          tmp107_103;
          d.d("Hardcoder.HardCoderReporter", "process jiffies info is invalid");
        }
        d.d("Hardcoder.HardCoderReporter", "process:[" + localObject1[0] + "," + localObject1[1] + "]");
        localHashMap = new HashMap();
        localHashSet2 = new HashSet();
        localObject9 = null;
        localObject8 = null;
        localObject7 = null;
        if (!this.running) {
          break label3453;
        }
        l5 = System.currentTimeMillis();
        k = a.a(a.this).size();
        d.d("Hardcoder.HCPerfManager", "startLoop queue:" + k + " startTask:" + tmp103_101.size() + " nextWakeInterval:" + l1);
        i = 0;
        label256:
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
                tmp103_101.add((a.b)localObject1);
                localHashSet2.add(Integer.valueOf(((a.b)localObject1).hashCode()));
                i += 1;
                break label256;
                l1 = Thread.currentThread().getId();
                continue;
                j = k;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              d.e("Hardcoder.HCPerfManager", "taskQueue poll: " + localException.getMessage());
              localObject2 = null;
              continue;
              if ((localObject2 instanceof a.c))
              {
                j = ((a.c)localObject2).aHQ;
                if (localHashSet2.contains(Integer.valueOf(j))) {
                  localHashMap.put(Integer.valueOf(j), (a.c)localObject2);
                }
              }
              else
              {
                if (!HardCoderJNI.isCheckEnv()) {
                  break;
                }
                a.fj("taskQueue poll invalid object");
              }
            }
            this.running = false;
          }
        }
      }
      long l1 = 30000L;
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      HashSet localHashSet1 = new HashSet();
      long l3 = System.currentTimeMillis();
      d.d("Hardcoder.HCPerfManager", "InLoop startSize:" + tmp103_101.size());
      int i = 0;
      if (i < tmp103_101.size())
      {
        localObject5 = (a.b)tmp103_101.get(i);
        l4 = System.currentTimeMillis();
        j = i;
        l2 = l1;
        localObject11 = localObject2;
        Object localObject12 = localObject3;
        Object localObject13 = localObject4;
        if (localObject5 != null)
        {
          if (localHashMap.containsKey(Integer.valueOf(localObject5.hashCode())))
          {
            ((a.b)localObject5).gyu = l4;
            ((a.b)localObject5).gyn = ((a.c)localHashMap.get(Integer.valueOf(localObject5.hashCode()))).gyn;
            localHashMap.remove(Integer.valueOf(localObject5.hashCode()));
            a.a(a.this, l4, tmp103_101, -2, -2, -2, null);
            a.a(a.this, (a.b)localObject5);
          }
          l2 = ((a.b)localObject5).gyu - l4;
          if (l2 > 0L) {
            break label769;
          }
          d.d("Hardcoder.HCPerfManager", "InLoop STOP:" + i + "/" + tmp103_101.size() + " task:" + ((a.b)localObject5).toString(l4));
          tmp103_101.remove(localObject5);
          localHashSet2.remove(Integer.valueOf(localObject5.hashCode()));
          j = i - 1;
          localObject13 = localObject4;
          localObject12 = localObject3;
          localObject11 = localObject2;
          l2 = l1;
        }
        for (;;)
        {
          i = j + 1;
          l1 = l2;
          localObject2 = localObject11;
          localObject3 = localObject12;
          localObject4 = localObject13;
          break;
          label769:
          l1 = Math.min(l1, l2);
          l2 = ((a.b)localObject5).startTime - l4;
          if (l2 <= 0L) {
            break label870;
          }
          d.d("Hardcoder.HCPerfManager", "InLoop WAIT:" + i + "/" + tmp103_101.size() + " task:" + ((a.b)localObject5).toString(l4));
          l2 = Math.min(l1, l2);
          j = i;
          localObject11 = localObject2;
          localObject12 = localObject3;
          localObject13 = localObject4;
        }
        label870:
        d.d("Hardcoder.HCPerfManager", "InLoop RUN:" + i + "/" + tmp103_101.size() + " task:" + ((a.b)localObject5).toString(l4));
        localObject6 = localObject4;
        if (((a.b)localObject5).gyo > 0) {
          if ((localObject4 != null) && (localObject4.gyo <= ((a.b)localObject5).gyo))
          {
            localObject6 = localObject4;
            if (localObject4.gyo == ((a.b)localObject5).gyo)
            {
              localObject6 = localObject4;
              if (localObject4.gyu >= ((a.b)localObject5).gyu) {}
            }
          }
          else
          {
            localObject6 = localObject5;
          }
        }
        localObject4 = localObject3;
        if (((a.b)localObject5).gyp > 0) {
          if ((localObject3 != null) && (((a.b)localObject3).gyp <= ((a.b)localObject5).gyp))
          {
            localObject4 = localObject3;
            if (((a.b)localObject3).gyp == ((a.b)localObject5).gyp)
            {
              localObject4 = localObject3;
              if (((a.b)localObject3).gyu >= ((a.b)localObject5).gyu) {}
            }
          }
          else
          {
            localObject4 = localObject5;
          }
        }
        localObject3 = localObject2;
        if (((a.b)localObject5).gyq > 0) {
          if ((localObject2 != null) && (((a.b)localObject2).gyq <= ((a.b)localObject5).gyq))
          {
            localObject3 = localObject2;
            if (((a.b)localObject2).gyq == ((a.b)localObject5).gyq)
            {
              localObject3 = localObject2;
              if (((a.b)localObject2).gyu >= ((a.b)localObject5).gyu) {}
            }
          }
          else
          {
            localObject3 = localObject5;
          }
        }
        localObject2 = ((a.b)localObject5).gyr;
        m = localObject2.length;
        k = 0;
        for (;;)
        {
          j = i;
          l2 = l1;
          localObject11 = localObject3;
          localObject12 = localObject4;
          localObject13 = localObject6;
          if (k >= m) {
            break;
          }
          if (localObject2[k] > 0)
          {
            localHashSet1.add(localObject5);
            j = i;
            l2 = l1;
            localObject11 = localObject3;
            localObject12 = localObject4;
            localObject13 = localObject6;
            break;
          }
          k += 1;
        }
      }
      long l4 = System.currentTimeMillis();
      d.d("Hardcoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[] { Long.valueOf(l4 - l3), Long.valueOf(l4 - l5), Integer.valueOf(tmp103_101.size()), Integer.valueOf(localHashMap.size()), Integer.valueOf(((HashSet)localObject10).size()), Integer.valueOf(localHashSet1.size()) }));
      Object localObject6 = new StringBuilder("EndLoop CurrCpu:");
      if (localObject7 == null)
      {
        localObject5 = "null";
        label1316:
        localObject6 = ((StringBuilder)localObject6).append((String)localObject5).append(" -> MaxCpu:");
        if (localObject4 != null) {
          break label1607;
        }
        localObject5 = "null";
        label1341:
        d.d("Hardcoder.HCPerfManager", (String)localObject5);
        localObject6 = new StringBuilder("EndLoop CurrGpu:");
        if (localObject8 != null) {
          break label1619;
        }
        localObject5 = "null";
        label1378:
        localObject6 = ((StringBuilder)localObject6).append((String)localObject5).append(" -> MaxGpu:");
        if (localObject8 != null) {
          break label1631;
        }
        localObject5 = "null";
        label1403:
        d.d("Hardcoder.HCPerfManager", (String)localObject5);
        localObject6 = new StringBuilder("EndLoop CurrIO:");
        if (localObject9 != null) {
          break label1643;
        }
        localObject5 = "null";
        label1440:
        localObject6 = ((StringBuilder)localObject6).append((String)localObject5).append(" -> MaxIO:");
        if (localObject2 != null) {
          break label1655;
        }
      }
      label1607:
      label1619:
      label1631:
      label1643:
      label1655:
      for (Object localObject5 = "null";; localObject5 = ((a.b)localObject2).toString(l3))
      {
        d.d("Hardcoder.HCPerfManager", (String)localObject5);
        d.d("Hardcoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[] { Integer.valueOf(((HashSet)localObject10).size()), Integer.valueOf(localHashSet1.size()) }));
        localObject5 = new HashSet();
        ((HashSet)localObject5).addAll((Collection)localObject10);
        ((HashSet)localObject5).removeAll(localHashSet1);
        if ((localObject4 != localObject7) || (localObject3 != localObject8) || (localObject2 != localObject9) || (((HashSet)localObject10).size() != localHashSet1.size()) || (!((HashSet)localObject5).isEmpty())) {
          break label1667;
        }
        d.d("Hardcoder.HCPerfManager", "EndLoop Nothing Changed, Continue.");
        break;
        localObject5 = ((a.b)localObject7).toString(l3);
        break label1316;
        localObject5 = localObject4.toString(l3);
        break label1341;
        localObject5 = ((a.b)localObject8).toString(l3);
        break label1378;
        localObject5 = ((a.b)localObject8).toString(l3);
        break label1403;
        localObject5 = ((a.b)localObject9).toString(l3);
        break label1440;
      }
      label1667:
      localObject6 = ((HashSet)localObject5).iterator();
      i = 0;
      while (((Iterator)localObject6).hasNext())
      {
        localObject10 = (a.b)((Iterator)localObject6).next();
        if (((a.b)localObject10).gyr != null) {
          i = ((a.b)localObject10).gyr.length + i;
        }
      }
      if (i > 0)
      {
        localObject6 = new int[i];
        localObject5 = ((HashSet)localObject5).iterator();
        i = 0;
      }
      for (;;)
      {
        if (((Iterator)localObject5).hasNext())
        {
          localObject10 = (a.b)((Iterator)localObject5).next();
          l2 = System.currentTimeMillis();
          d.i("Hardcoder.HCPerfManager", "!cancelBindCore task:" + ((a.b)localObject10).toString(l2));
          if (((a.b)localObject10).gyu > l2)
          {
            d.e("Hardcoder.HCPerfManager", "stopTime:" + (((a.b)localObject10).gyu - l2) + ". Error !");
          }
          else
          {
            if (!((a.b)localObject10).ahA())
            {
              if (HardCoderJNI.isCheckEnv()) {
                a.fj("bindTids:" + ((a.b)localObject10).ahB());
              }
            }
            else
            {
              localObject10 = ((a.b)localObject10).gyr;
              k = localObject10.length;
              j = 0;
              while (j < k)
              {
                localObject6[i] = localObject10[j];
                i += 1;
                j += 1;
              }
            }
            this.running = false;
          }
        }
        else
        {
          if (HardCoderJNI.isCheckEnv()) {
            HardCoderJNI.cancelCpuCoreForThread((int[])localObject6, Process.myTid(), SystemClock.elapsedRealtimeNanos());
          }
          a.a(a.this, l3, tmp103_101, -2, -2, -2, null);
          localObject5 = localHashSet1.iterator();
          i = 0;
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (a.b)((Iterator)localObject5).next();
            if (((a.b)localObject6).gyr != null) {
              i = ((a.b)localObject6).gyr.length + i;
            }
          }
        }
      }
      Object localObject11 = new int[i];
      localObject5 = localHashSet1.iterator();
      long l2 = 0L;
      int j = 0;
      int m = 0;
      i = 2147483647;
      int k = 0;
      label2036:
      int n;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (a.b)((Iterator)localObject5).next();
        d.i("Hardcoder.HCPerfManager", "requestBindCore task:" + ((a.b)localObject6).toString(l3));
        l5 = System.currentTimeMillis();
        if (((a.b)localObject6).gyu <= l5)
        {
          d.e("Hardcoder.HCPerfManager", "stopTime:" + (((a.b)localObject6).gyu - l5) + ". Error !");
        }
        else
        {
          if (!((a.b)localObject6).ahA())
          {
            if (HardCoderJNI.isCheckEnv()) {
              a.fj("bindTids:" + ((a.b)localObject6).ahB());
            }
          }
          else
          {
            localObject10 = ((a.b)localObject6).gyr;
            n = localObject10.length;
            j = 0;
            k = m;
            while (j < n)
            {
              localObject11[k] = localObject10[j];
              k += 1;
              j += 1;
            }
          }
          this.running = false;
        }
      }
      if (localObject2 == null)
      {
        if (localObject9 != null)
        {
          d.i("Hardcoder.HCPerfManager", "!cancelHighIOFreq task:" + ((a.b)localObject9).toString(l3));
          if (HardCoderJNI.isCheckEnv()) {
            HardCoderJNI.cancelHighIOFreq(((a.b)localObject9).gyv, SystemClock.elapsedRealtimeNanos());
          }
          a.a(a.this, l3, tmp103_101, -2, -2, -1, null);
        }
        label2298:
        if (localObject2 == null) {
          break label3487;
        }
        m = ((a.b)localObject2).gyq;
        k = ((a.b)localObject2).scene;
        l2 = ((a.b)localObject2).gys;
        j = ((a.b)localObject2).gyv;
        i = Math.min((int)(((a.b)localObject2).gyu - l3), i);
      }
      for (;;)
      {
        if (localObject3 == null)
        {
          if (localObject8 != null)
          {
            d.i("Hardcoder.HCPerfManager", "!cancelGpuHighFreq task:" + ((a.b)localObject8).toString(l3));
            if (HardCoderJNI.isCheckEnv()) {
              HardCoderJNI.cancelGpuHighFreq(((a.b)localObject8).gyv, SystemClock.elapsedRealtimeNanos());
            }
            a.a(a.this, l3, tmp103_101, -2, -1, -2, null);
          }
          label2416:
          if (localObject3 == null) {
            break label3481;
          }
          n = ((a.b)localObject3).gyp;
          k = ((a.b)localObject3).scene;
          l2 = ((a.b)localObject3).gys;
          j = ((a.b)localObject3).gyv;
          i = Math.min((int)(((a.b)localObject3).gyu - l3), i);
        }
        for (;;)
        {
          label2534:
          int i1;
          if (localObject4 == null)
          {
            if (localObject7 != null)
            {
              d.i("Hardcoder.HCPerfManager", "!cancelCpuHighFreq task:" + ((a.b)localObject7).toString(l3));
              if (HardCoderJNI.isCheckEnv()) {
                HardCoderJNI.cancelCpuHighFreq(((a.b)localObject7).gyv, SystemClock.elapsedRealtimeNanos());
              }
              a.a(a.this, l3, tmp103_101, -1, -2, -2, null);
            }
            if (localObject4 == null) {
              break label3467;
            }
            k = localObject4.gyo;
            j = localObject4.scene;
            l2 = localObject4.gys;
            i1 = localObject4.gyv;
            i = Math.min((int)(localObject4.gyu - l3), i);
          }
          for (;;)
          {
            if (i < 2147483647)
            {
              i2 = localObject11.length;
              if (localObject4 != null) {
                break label3351;
              }
              localObject5 = "null";
              label2601:
              if (localObject3 != null) {
                break label3363;
              }
              localObject6 = "null";
              label2611:
              if (localObject2 != null) {
                break label3375;
              }
              localObject7 = "null";
              label2621:
              if (localObject4 != null) {
                break label3387;
              }
              localObject8 = "null";
              label2631:
              if (localObject3 != null) {
                break label3399;
              }
              localObject9 = "null";
              label2641:
              if (localObject2 != null) {
                break label3411;
              }
              localObject10 = "null";
              label2651:
              d.i("Hardcoder.HCPerfManager", String.format("!UnifyRequest [%d,%d,%d] [%d,%d,%d,%d] TO:%d max CPU:%s GPU:%s IO:%s cur CPU:%s GPU:%s IO:%s", new Object[] { Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i2), Integer.valueOf(i), localObject5, localObject6, localObject7, localObject8, localObject9, localObject10 }));
              if (i <= 0) {
                break label3423;
              }
              bool = true;
              label2773:
              a.dv(bool);
              if ((j <= 0) && (l2 <= 0L)) {
                break label3429;
              }
              bool = true;
              label2792:
              a.dv(bool);
              if (i1 <= 0) {
                break label3435;
              }
              bool = true;
              label2805:
              a.dv(bool);
              if ((k <= 0) && (n <= 0) && (m <= 0) && (localObject11.length <= 0)) {
                break label3441;
              }
              bool = true;
              label2833:
              a.dv(bool);
              if (HardCoderJNI.isCheckEnv())
              {
                l4 = HardCoderJNI.requestUnifyCpuIOThreadCoreGpu(j, l2, k, n, m, (int[])localObject11, i, i1, SystemClock.elapsedRealtimeNanos());
                HardCoderJNI.putRequestStatusHashMap(l4, new c.c(j, l2, k, n, m, (int[])localObject11));
                localObject5 = new StringBuilder("hardcoder requestUnifyCpuIOThreadCoreGpu requestId:").append(l4).append("reqScene[").append(j).append(", ").append(l2).append("] running[enable:").append(HardCoderJNI.isHcEnable()).append(", env:");
                if ((!HardCoderJNI.isCheckEnv()) || (HardCoderJNI.isRunning() <= 0)) {
                  break label3447;
                }
              }
            }
            label3351:
            label3363:
            label3375:
            label3387:
            label3399:
            label3411:
            label3423:
            label3429:
            label3435:
            label3441:
            label3447:
            for (boolean bool = true;; bool = false)
            {
              d.i("Hardcoder.HCPerfManager", bool + "]");
              if (HardCoderJNI.sceneReportCallback != null) {
                HardCoderJNI.sceneReportCallback.sceneReport(j, l2);
              }
              a.a(a.this, l3, tmp103_101, k, n, m, (int[])localObject11);
              localObject10 = localHashSet1;
              localObject9 = localObject2;
              localObject8 = localObject3;
              localObject7 = localObject4;
              break;
              j = ((a.b)localObject6).scene;
              l2 = ((a.b)localObject6).gys;
              n = ((a.b)localObject6).gyv;
              i = Math.min((int)(((a.b)localObject6).gyu - l3), i);
              m = k;
              k = n;
              break label2036;
              if (localObject9 == localObject2) {
                break label2298;
              }
              localObject6 = new StringBuilder("IOReq:");
              if (localObject9 == null) {}
              for (localObject5 = "null";; localObject5 = ((a.b)localObject9).toString(l3))
              {
                d.d("Hardcoder.HCPerfManager", (String)localObject5 + " -> " + ((a.b)localObject2).toString(l3) + " delay:" + (l4 - ((a.b)localObject2).startTime));
                break;
              }
              if (localObject8 == localObject3) {
                break label2416;
              }
              localObject6 = new StringBuilder("GPUReq:");
              if (localObject8 == null) {}
              for (localObject5 = "null";; localObject5 = ((a.b)localObject8).toString(l3))
              {
                d.d("Hardcoder.HCPerfManager", (String)localObject5 + " -> " + ((a.b)localObject3).toString(l3) + " delay:" + (l4 - ((a.b)localObject3).startTime));
                break;
              }
              if (localObject7 == localObject4) {
                break label2534;
              }
              localObject6 = new StringBuilder("CPUReq:");
              if (localObject7 == null) {}
              for (localObject5 = "null";; localObject5 = ((a.b)localObject7).toString(l3))
              {
                d.d("Hardcoder.HCPerfManager", (String)localObject5 + " -> " + localObject4.toString(l3) + " delay:" + (l4 - localObject4.startTime));
                break;
              }
              localObject5 = localObject4.toString(l3);
              break label2601;
              localObject6 = ((a.b)localObject3).toString(l3);
              break label2611;
              localObject7 = ((a.b)localObject2).toString(l3);
              break label2621;
              localObject8 = localObject4.toString(l3);
              break label2631;
              localObject9 = ((a.b)localObject3).toString(l3);
              break label2641;
              localObject10 = ((a.b)localObject2).toString(l3);
              break label2651;
              bool = false;
              break label2773;
              bool = false;
              break label2792;
              bool = false;
              break label2805;
              bool = false;
              break label2833;
            }
            label3453:
            d.i("Hardcoder.HCPerfManager", "HCPerfManager thread run end.");
            AppMethodBeat.o(62441);
            return;
            label3467:
            int i2 = 0;
            i1 = j;
            j = k;
            k = i2;
          }
          label3481:
          n = 0;
        }
        label3487:
        n = 0;
        m = k;
        k = j;
        j = m;
        m = n;
      }
    }
  }
  
  public static final class b
  {
    public int delay;
    public int[] gyA;
    public long gyB;
    public long gyn;
    public int gyo;
    public int gyp;
    public int gyq;
    public int[] gyr;
    public long gys;
    public long gyt;
    public long gyu;
    public int gyv;
    public int gyw;
    public int gyx;
    public int[] gyy;
    public int[] gyz;
    public long lastUpdateTime;
    public int scene;
    public long startTime;
    public String tag;
    public int timeout;
    
    public b()
    {
      AppMethodBeat.i(62442);
      this.gyn = 0L;
      this.delay = 0;
      this.timeout = 0;
      this.gyo = 0;
      this.gyp = 0;
      this.gyq = 0;
      this.gyr = null;
      this.scene = 0;
      this.gys = 0L;
      this.startTime = 0L;
      this.gyt = 0L;
      this.gyu = 0L;
      this.gyv = 0;
      this.gyw = 0;
      this.gyx = 0;
      this.lastUpdateTime = 0L;
      this.gyy = new int[a.ahz().length];
      this.gyz = new int[a.gyh.length];
      this.gyA = null;
      this.gyB = 0L;
      AppMethodBeat.o(62442);
    }
    
    public final boolean ahA()
    {
      boolean bool2 = true;
      boolean bool1;
      if ((this.gyr != null) && (this.gyr.length > 0))
      {
        bool1 = bool2;
        if (this.gyr.length == 1)
        {
          bool1 = bool2;
          if (this.gyr[0] > 0) {}
        }
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    
    public final String ahB()
    {
      AppMethodBeat.i(62443);
      if (ahA())
      {
        Object localObject = new StringBuilder("[");
        int[] arrayOfInt = this.gyr;
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
        AppMethodBeat.o(62443);
        return localObject;
      }
      AppMethodBeat.o(62443);
      return "[ ]";
    }
    
    public final String toString(long paramLong)
    {
      AppMethodBeat.i(62444);
      String str = String.format("hashCode:%x time:[init:%d, start:%d, stop:%d][delay:%d, timeout:%d][scene:%d, action:%d, callerTid:%d][cpu:%d, io:%d, gpu:%d] bindTids:%s [TAG:%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.gyt - paramLong), Long.valueOf(this.startTime - paramLong), Long.valueOf(this.gyu - paramLong), Integer.valueOf(this.delay), Integer.valueOf(this.timeout), Integer.valueOf(this.scene), Long.valueOf(this.gys), Integer.valueOf(this.gyv), Integer.valueOf(this.gyo), Integer.valueOf(this.gyq), Integer.valueOf(this.gyp), ahB(), this.tag });
      AppMethodBeat.o(62444);
      return str;
    }
  }
  
  public static final class c
  {
    public int aHQ = 0;
    public long gyn = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.a
 * JD-Core Version:    0.7.0.1
 */