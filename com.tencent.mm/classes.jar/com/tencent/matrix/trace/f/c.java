package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mrs.b.a.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends f
{
  private final com.tencent.matrix.trace.a.a bRa;
  private final long bSh;
  long bSi;
  private boolean bSj;
  long bSk;
  long bSl;
  long bSm;
  long bSn;
  private HashSet<com.tencent.matrix.trace.e.b> listeners = new HashSet();
  
  public c(com.tencent.matrix.trace.a.a parama)
  {
    this.bRa = parama;
    this.bSh = (TimeUnit.MILLISECONDS.convert(com.tencent.matrix.trace.core.b.zt().bLF, TimeUnit.NANOSECONDS) + 1L);
    if (parama.bNO == null)
    {
      i = 10000;
      this.bSi = i;
      this.bSj = parama.bQT;
      if (parama.bNO != null) {
        break label203;
      }
      i = 42;
      label76:
      this.bSk = i;
      if (parama.bNO != null) {
        break label224;
      }
      i = 24;
      label92:
      this.bSl = i;
      if (parama.bNO != null) {
        break label245;
      }
      i = 3;
      label107:
      this.bSn = i;
      if (parama.bNO != null) {
        break label265;
      }
    }
    label265:
    for (int i = 9;; i = parama.bNO.get(a.a.Bar.name(), 9))
    {
      this.bSm = i;
      com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[init] frameIntervalMs:%s isFPSEnable:%s", new Object[] { Long.valueOf(this.bSh), Boolean.valueOf(this.bSj) });
      if (this.bSj) {
        a(new b((byte)0));
      }
      return;
      i = parama.bNO.get(a.a.Bao.name(), 10000);
      break;
      label203:
      i = parama.bNO.get(a.a.Bat.name(), 42);
      break label76;
      label224:
      i = parama.bNO.get(a.a.Bas.name(), 24);
      break label92;
      label245:
      i = parama.bNO.get(a.a.Baq.name(), 3);
      break label107;
    }
  }
  
  public final void a(com.tencent.matrix.trace.e.b paramb)
  {
    synchronized (this.listeners)
    {
      this.listeners.add(paramb);
      return;
    }
  }
  
  public final void a(final String paramString, final long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (com.tencent.matrix.a.bLP.bLR)
    {
      paramLong2 = System.currentTimeMillis();
      try
      {
        synchronized (this.listeners)
        {
          Iterator localIterator = this.listeners.iterator();
          while (localIterator.hasNext())
          {
            final com.tencent.matrix.trace.e.b localb = (com.tencent.matrix.trace.e.b)localIterator.next();
            if (this.bRa.bQX) {
              localb.time = SystemClock.uptimeMillis();
            }
            int i = (int)(paramLong1 / this.bSh);
            if (localb.getHandler() != null) {
              localb.getHandler().post(new Runnable()
              {
                public final void run()
                {
                  localb.a(paramString, paramLong1, this.bSr);
                }
              });
            }
            if (this.bRa.bQX)
            {
              localb.time = (SystemClock.uptimeMillis() - localb.time);
              com.tencent.matrix.g.c.d("Matrix.FrameTracer", "[notifyListener] cost:%sms listener:%s", new Object[] { Long.valueOf(localb.time), localb });
            }
          }
        }
      }
      finally
      {
        paramLong1 = System.currentTimeMillis() - paramLong2;
        if ((this.bRa.isDebug) && (paramLong1 > this.bSh)) {
          com.tencent.matrix.g.c.w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync! size:%s cost:%sms", new Object[] { Integer.valueOf(this.listeners.size()), Long.valueOf(paramLong1) });
        }
      }
      paramLong1 = System.currentTimeMillis() - paramLong2;
      if ((this.bRa.isDebug) && (paramLong1 > this.bSh)) {
        com.tencent.matrix.g.c.w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync! size:%s cost:%sms", new Object[] { Integer.valueOf(this.listeners.size()), Long.valueOf(paramLong1) });
      }
    }
  }
  
  public final void b(com.tencent.matrix.trace.e.b paramb)
  {
    synchronized (this.listeners)
    {
      this.listeners.remove(paramb);
      return;
    }
  }
  
  public final void zy()
  {
    super.zy();
    com.tencent.matrix.trace.core.b.zt().a(this);
  }
  
  public final void zz()
  {
    super.zz();
    com.tencent.matrix.trace.core.b.zt().b(this);
  }
  
  static enum a
  {
    int index;
    
    private a(int paramInt)
    {
      this.index = paramInt;
    }
  }
  
  final class b
    extends com.tencent.matrix.trace.e.b
  {
    private HashMap<String, c.c> bSA = new HashMap();
    private Handler bSz = new Handler(com.tencent.matrix.g.b.zI().getLooper());
    
    private b() {}
    
    public final void a(String paramString, long paramLong, int paramInt)
    {
      super.a(paramString, paramLong, paramInt);
      if ((paramString == null) || (paramString.equals(""))) {}
      for (int i = 1; i != 0; i = 0) {
        return;
      }
      c.c localc = (c.c)this.bSA.get(paramString);
      if (localc == null)
      {
        localc = new c.c(c.this, paramString);
        this.bSA.put(paramString, localc);
      }
      for (;;)
      {
        paramLong = com.tencent.matrix.trace.core.b.zt().bLF;
        long l = localc.bSB;
        localc.bSB = (paramLong * (paramInt + 1) / 1000000L + l);
        localc.bSD += paramInt;
        localc.bSC += 1;
        Object localObject1;
        int j;
        int k;
        if (paramInt >= localc.bSs.bSk)
        {
          localObject1 = localc.bSE;
          i = c.a.bSt.index;
          localObject1[i] += 1;
          localObject1 = localc.bSF;
          j = c.a.bSt.index;
          i = localObject1[j];
          k = paramInt;
        }
        for (;;)
        {
          localObject1[j] = (i + k);
          if (localc.bSB < c.this.bSi) {
            break;
          }
          this.bSA.remove(paramString);
          float f = Math.min(60.0F, 1000.0F * localc.bSC / (float)localc.bSB);
          com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[report] FPS:%s %s", new Object[] { Float.valueOf(f), localc.toString() });
          try
          {
            paramString = (com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class);
            Object localObject2;
            if (paramString == null)
            {
              return;
              if (paramInt >= localc.bSs.bSl)
              {
                localObject1 = localc.bSE;
                i = c.a.bSu.index;
                localObject1[i] += 1;
                localObject1 = localc.bSF;
                j = c.a.bSu.index;
                i = localObject1[j];
                k = paramInt;
              }
              else if (paramInt >= localc.bSs.bSm)
              {
                localObject1 = localc.bSE;
                i = c.a.bSv.index;
                localObject1[i] += 1;
                localObject1 = localc.bSF;
                j = c.a.bSv.index;
                i = localObject1[j];
                k = paramInt;
              }
              else if (paramInt >= localc.bSs.bSn)
              {
                localObject1 = localc.bSE;
                i = c.a.bSw.index;
                localObject1[i] += 1;
                localObject1 = localc.bSF;
                j = c.a.bSw.index;
                i = localObject1[j];
                k = paramInt;
              }
              else
              {
                localObject1 = localc.bSE;
                i = c.a.bSx.index;
                localObject1[i] += 1;
                localObject2 = localc.bSF;
                int m = c.a.bSx.index;
                int n = localObject2[m];
                i = n;
                j = m;
                localObject1 = localObject2;
                k = paramInt;
                if (paramInt < 0)
                {
                  k = 0;
                  i = n;
                  j = m;
                  localObject1 = localObject2;
                }
              }
            }
            else
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put(c.a.bSt.name(), localc.bSE[c.a.bSt.index]);
              ((JSONObject)localObject2).put(c.a.bSu.name(), localc.bSE[c.a.bSu.index]);
              ((JSONObject)localObject2).put(c.a.bSv.name(), localc.bSE[c.a.bSv.index]);
              ((JSONObject)localObject2).put(c.a.bSw.name(), localc.bSE[c.a.bSw.index]);
              ((JSONObject)localObject2).put(c.a.bSx.name(), localc.bSE[c.a.bSx.index]);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put(c.a.bSt.name(), localc.bSF[c.a.bSt.index]);
              localJSONObject.put(c.a.bSu.name(), localc.bSF[c.a.bSu.index]);
              localJSONObject.put(c.a.bSv.name(), localc.bSF[c.a.bSv.index]);
              localJSONObject.put(c.a.bSw.name(), localc.bSF[c.a.bSw.index]);
              localJSONObject.put(c.a.bSx.name(), localc.bSF[c.a.bSx.index]);
              localObject1 = com.tencent.matrix.g.a.a(new JSONObject(), paramString.getApplication());
              ((JSONObject)localObject1).put("scene", localc.bLS);
              ((JSONObject)localObject1).put("dropLevel", localObject2);
              ((JSONObject)localObject1).put("dropSum", localJSONObject);
              ((JSONObject)localObject1).put("fps", f);
              localObject2 = new com.tencent.matrix.e.b();
              ((com.tencent.matrix.e.b)localObject2).tag = "Trace_FPS";
              ((com.tencent.matrix.e.b)localObject2).bOx = ((JSONObject)localObject1);
              paramString.onDetectIssue((com.tencent.matrix.e.b)localObject2);
              return;
            }
          }
          catch (JSONException paramString)
          {
            com.tencent.matrix.g.c.e("Matrix.FrameTracer", "json error", new Object[] { paramString });
            return;
          }
          finally
          {
            localc.bSC = 0;
            localc.bSD = 0;
            localc.bSB = 0L;
          }
        }
      }
    }
    
    public final Handler getHandler()
    {
      return this.bSz;
    }
  }
  
  final class c
  {
    String bLS;
    long bSB;
    int bSC = 0;
    int bSD;
    int[] bSE = new int[c.a.values().length];
    int[] bSF = new int[c.a.values().length];
    
    c(String paramString)
    {
      this.bLS = paramString;
    }
    
    public final String toString()
    {
      return "visibleScene=" + this.bLS + ", sumFrame=" + this.bSC + ", sumDroppedFrames=" + this.bSD + ", sumFrameCost=" + this.bSB + ", dropLevel=" + Arrays.toString(this.bSE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.f.c
 * JD-Core Version:    0.7.0.1
 */