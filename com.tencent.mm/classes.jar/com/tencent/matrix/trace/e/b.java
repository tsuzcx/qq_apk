package com.tencent.matrix.trace.e;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.MethodBeat;
import com.tencent.matrix.trace.d.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends a
  implements a.a
{
  private final com.tencent.matrix.trace.a.a bqr;
  private final com.tencent.matrix.trace.d.a brv;
  private final HashMap<Integer, a> brw;
  private HandlerThread brx;
  private volatile boolean bry;
  private final LinkedList<d> brz = new LinkedList();
  private Handler mHandler;
  
  public b(com.tencent.matrix.trace.a parama, com.tencent.matrix.trace.a.a parama1)
  {
    super(parama);
    this.bqr = parama1;
    this.brv = new com.tencent.matrix.trace.d.a(com.tencent.matrix.d.a.rt(), 5000L);
    this.brw = new HashMap();
  }
  
  private int a(e parame)
  {
    int i = parame.brN.size();
    parame = parame.brN.iterator();
    while (parame.hasNext()) {
      i = a((e)parame.next()) + i;
    }
    return i;
  }
  
  private void a(e parame, b paramb)
  {
    if (paramb.brB == f.brR) {}
    label151:
    label153:
    label171:
    for (;;)
    {
      return;
      long l2 = paramb.brE;
      Iterator localIterator = parame.brN.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label171;
        }
        parame = (e)localIterator.next();
        if ((parame.brL.aOn != 0) && (parame.brM != null) && (parame.brM.brL != null)) {}
        for (long l1 = (parame.brM.brL.brK * 0.6F);; l1 = ((float)l2 * 0.3F))
        {
          if (parame.brL.brK < l1) {
            break label151;
          }
          if ((parame.brL == null) || (parame.brL.aOn <= 0)) {
            break label153;
          }
          this.brz.pop();
          this.brz.push(parame.brL);
          break;
        }
        continue;
        this.brz.push(parame.brL);
        a(parame, paramb);
      }
    }
  }
  
  private void a(e parame, LinkedList<d> paramLinkedList)
  {
    if ((parame == null) || (parame.brN.isEmpty())) {}
    for (;;)
    {
      return;
      parame = parame.brN;
      while (!parame.isEmpty())
      {
        e locale = (e)parame.pop();
        paramLinkedList.addLast(locale.brL);
        a(locale, paramLinkedList);
      }
    }
  }
  
  private void a(f paramf, int paramInt, long[] paramArrayOfLong, long paramLong)
  {
    a(paramf, 0, paramInt, paramArrayOfLong, null, paramLong, System.nanoTime() / 1000000L - a.brt.getLastDiffTime(), -1);
  }
  
  private boolean a(e parame, b paramb, long paramLong, float paramFloat)
  {
    long l;
    if (parame.brL == null)
    {
      l = paramb.brE;
      if ((parame.brL != null) || (paramb.brB != f.brP) || (l >= this.bqr.bqB)) {
        break label97;
      }
      com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "trimResultStack analyse enter type, max cost: %dms less than threshold: %dms, just ignore", new Object[] { Long.valueOf(l), Long.valueOf(this.bqr.bqB) });
      parame.brN.clear();
    }
    label97:
    while (l <= paramb.brE / 20L)
    {
      return true;
      l = parame.brL.brK;
      break;
    }
    if (l <= ((float)paramLong * paramFloat)) {
      parame.brN.clear();
    }
    parame = parame.brN.iterator();
    while (parame.hasNext()) {
      if (a((e)parame.next(), paramb, l, paramFloat)) {
        parame.remove();
      }
    }
    return false;
  }
  
  public final void a(Activity paramActivity, boolean paramBoolean, int paramInt, long[] paramArrayOfLong)
  {
    com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[onActivityEntered] activity:%s hashCode:%s isFocus:%s nowIndex:%s", new Object[] { paramActivity.getClass().getSimpleName(), Integer.valueOf(paramActivity.hashCode()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if ((paramBoolean) && (this.brw.containsKey(Integer.valueOf(paramActivity.hashCode()))))
    {
      long l = System.currentTimeMillis();
      a locala = (a)this.brw.get(Integer.valueOf(paramActivity.hashCode()));
      l -= locala.brA;
      com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[activity load time] activity name:%s cost:%sms", new Object[] { paramActivity.getClass(), Long.valueOf(l) });
      if (l >= this.bqr.bqB)
      {
        View localView = paramActivity.getWindow().getDecorView();
        com.tencent.matrix.trace.f.b.a locala1 = new com.tencent.matrix.trace.f.b.a();
        com.tencent.matrix.trace.f.b.a(locala1, 0, localView);
        locala1.mActivityName = paramActivity.getClass().getSimpleName();
        com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[onActivityEntered] type:%s cost:%sms index:[%s-%s] viewInfo:%s", new Object[] { locala1.mActivityName, Long.valueOf(l), Integer.valueOf(locala.index), Integer.valueOf(paramInt), locala1.toString() });
        a(f.brP, locala.index, paramInt, paramArrayOfLong, locala1, l, System.nanoTime() / 1000000L - a.brt.getLastDiffTime(), -1);
      }
      a.brt.lockBuffer(false);
    }
    this.brw.remove(Integer.valueOf(paramActivity.hashCode()));
  }
  
  final void a(f paramf, int paramInt1, int paramInt2, long[] paramArrayOfLong, com.tencent.matrix.trace.f.b.a parama, long paramLong1, long paramLong2, int paramInt3)
  {
    if ((paramLong1 < 0L) || (paramLong1 >= 6000L)) {
      com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[analyse] trace cost invalid:%d", new Object[] { Long.valueOf(paramLong1) });
    }
    long[] arrayOfLong;
    do
    {
      do
      {
        return;
        paramInt1 = Math.max(0, paramInt1);
        paramInt2 = Math.min(paramArrayOfLong.length - 1, paramInt2);
      } while (paramInt1 > paramInt2);
      arrayOfLong = new long[paramInt2 - paramInt1 + 1];
      System.arraycopy(paramArrayOfLong, paramInt1, arrayOfLong, 0, paramInt2 - paramInt1 + 1);
    } while (this.mHandler == null);
    paramf = new b(paramf, parama, paramLong1, paramLong2);
    paramf.brC = paramInt3;
    this.mHandler.post(new c(arrayOfLong, paramf, (byte)0));
  }
  
  public final void b(long[] paramArrayOfLong)
  {
    long l = System.nanoTime() / 1000000L - a.brt.getLastDiffTime();
    com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[pushFullBuffer] now:%s diffTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(a.brt.getLastDiffTime()) });
    this.bry = true;
    a.brt.lockBuffer(false);
    a(f.brR, 999999, paramArrayOfLong, l - (paramArrayOfLong[0] & 0xFFFFFFFF));
    this.brv.cancel();
  }
  
  protected final String getTag()
  {
    return "Trace_EvilMethod";
  }
  
  public final void k(long paramLong1, long paramLong2)
  {
    if (this.bry)
    {
      this.brw.clear();
      this.bry = false;
      a.brt.resetIndex();
      return;
    }
    int i = MethodBeat.getCurIndex();
    if (paramLong2 - paramLong1 > this.bqr.bqE)
    {
      com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[doFrame] dropped frame too much! lastIndex:%s index:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
      a(f.brO, i - 1, MethodBeat.getBuffer(), (paramLong2 - paramLong1) / 1000000L);
    }
    a.brt.resetIndex();
    this.brv.cancel();
    this.brv.a(this, false);
  }
  
  public void onActivityCreated(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[onActivityCreated] activity:%s hashCode:%s", new Object[] { paramActivity.getClass().getSimpleName(), Integer.valueOf(paramActivity.hashCode()) });
    super.onActivityCreated(paramActivity);
    a.brt.lockBuffer(true);
    this.brw.put(Integer.valueOf(paramActivity.hashCode()), new a(System.currentTimeMillis(), Math.max(0, MethodBeat.getCurIndex() - 1), (byte)0));
  }
  
  public void onActivityPause(Activity paramActivity)
  {
    super.onActivityPause(paramActivity);
    com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[onActivityPause] activity:%s hashCode:%s", new Object[] { paramActivity.getClass().getSimpleName(), Integer.valueOf(paramActivity.hashCode()) });
    this.brw.remove(Integer.valueOf(paramActivity.hashCode()));
  }
  
  public void onBackground(Activity paramActivity)
  {
    super.onBackground(paramActivity);
    this.brv.cancel();
  }
  
  public final void onCreate()
  {
    super.onCreate();
    if (!a.brt.isRealTrace())
    {
      com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "MethodBeat don't work, maybe it's wrong in trace Build!", new Object[0]);
      onDestroy();
      return;
    }
    if (this.brx == null)
    {
      this.brx = com.tencent.matrix.d.a.bA("matrix_trace_analyse_thread");
      this.mHandler = new Handler(this.brx.getLooper());
    }
    this.brv.cancel();
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (this.brx != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.brx.quit();
      this.mHandler = null;
      this.brx = null;
    }
    this.brv.cancel();
    this.brw.clear();
  }
  
  public final void rq()
  {
    long l1 = System.nanoTime() / 1000000L;
    long l2 = a.brt.getLastDiffTime();
    com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[onTimeExpire] maybe ANR!", new Object[0]);
    this.bry = true;
    a.brt.lockBuffer(false);
    a(f.brQ, 0, MethodBeat.getCurIndex() - 1, MethodBeat.getBuffer(), null, 5000L, l1 - l2, -1);
  }
  
  protected final boolean rr()
  {
    return true;
  }
  
  private static final class a
  {
    long brA;
    int index;
    
    private a(long paramLong, int paramInt)
    {
      this.brA = paramLong;
      this.index = paramInt;
    }
  }
  
  private static final class b
  {
    b.f brB;
    int brC;
    com.tencent.matrix.trace.f.b.a brD;
    long brE;
    long brF;
    
    b(b.f paramf, com.tencent.matrix.trace.f.b.a parama, long paramLong1, long paramLong2)
    {
      this.brB = paramf;
      this.brD = parama;
      this.brE = paramLong1;
      this.brF = paramLong2;
    }
  }
  
  private final class c
    implements Runnable
  {
    private final long[] brG;
    private final b.b brH;
    
    private c(long[] paramArrayOfLong, b.b paramb)
    {
      this.brG = paramArrayOfLong;
      this.brH = paramb;
    }
    
    public final void run()
    {
      Object localObject3 = this.brG;
      Object localObject4 = new LinkedList();
      Object localObject1 = new LinkedList();
      int k = localObject3.length;
      int i = 0;
      int j;
      label55:
      label81:
      long l1;
      if (i < k)
      {
        long l3 = localObject3[i];
        if ((l3 >> 63 & 1L) == 1L)
        {
          j = 1;
          if (j == 0) {
            break label81;
          }
          ((LinkedList)localObject4).push(Long.valueOf(l3));
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label55;
          j = (int)(l3 >> 43 & 0xFFFFF);
          if (!((LinkedList)localObject4).isEmpty())
          {
            for (l1 = ((Long)((LinkedList)localObject4).pop()).longValue();; l1 = ((Long)((LinkedList)localObject4).pop()).longValue())
            {
              l2 = l1;
              if ((l1 >> 43 & 0xFFFFF) == j) {
                break label277;
              }
              com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[analyse] method[%s] not match in! continue to find!", new Object[] { Integer.valueOf(j) });
              l2 = this.brH.brF - (0xFFFFFFFF & l1);
              if ((l2 < 0L) || (l2 >= 20L))
              {
                com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[analyse] trace during invalid:%d", new Object[] { Long.valueOf(l2) });
                return;
              }
              b.a((LinkedList)localObject1, new b.d((int)(l1 >> 43 & 0xFFFFF), (int)l2, ((LinkedList)localObject4).size()));
              if (((LinkedList)localObject4).isEmpty()) {
                break;
              }
            }
            com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[analyse] method[%s] not match in finally! ", new Object[] { Integer.valueOf(j) });
            long l2 = 0L;
            label277:
            l1 = (l3 & 0xFFFFFFFF) - (l2 & 0xFFFFFFFF);
            if ((l1 < 0L) || (l1 >= 20L))
            {
              com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[analyse] trace during invalid:%d", new Object[] { Long.valueOf(l1) });
              return;
            }
            b.a((LinkedList)localObject1, new b.d(j, (int)l1, ((LinkedList)localObject4).size()));
          }
          else
          {
            com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[analyse] method[%s] not found in! ", new Object[] { Integer.valueOf(j) });
          }
        }
      }
      while (!((LinkedList)localObject4).isEmpty())
      {
        l1 = ((Long)((LinkedList)localObject4).pop()).longValue();
        ((LinkedList)localObject1).push(new b.d((int)(l1 >> 43 & 0xFFFFF), (int)(this.brH.brF - (l1 & 0xFFFFFFFF)), ((LinkedList)localObject4).size()));
      }
      localObject3 = new LinkedList();
      localObject1 = b.a((LinkedList)localObject1);
      i = 1;
      do
      {
        if (b.a(b.this, (b.e)localObject1, this.brH, 0.1F * i))
        {
          com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "type:%s [stack result is empty after trim, just ignore]", new Object[] { this.brH.brB.name() });
          return;
        }
        if (b.a(b.this, (b.e)localObject1) <= 20) {
          break;
        }
        j = i + 1;
        i = j;
      } while (j <= 3);
      b.a(b.this, (b.e)localObject1, this.brH);
      b.a(b.this, (b.e)localObject1, (LinkedList)localObject3);
      if (((LinkedList)localObject3).isEmpty())
      {
        com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "type:%s [stack result is empty after trim, just ignore]", new Object[] { this.brH.brB.name() });
        return;
      }
      localObject3 = ((LinkedList)localObject3).listIterator();
      Object localObject5 = new StringBuilder("\n");
      localObject4 = new StringBuilder();
      Object localObject6;
      while (((ListIterator)localObject3).hasNext())
      {
        localObject6 = (b.d)((ListIterator)localObject3).next();
        ((StringBuilder)localObject5).append(((b.d)localObject6).print()).append('\n');
        ((StringBuilder)localObject4).append(((b.d)localObject6).toString()).append('\n');
      }
      com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[analyse result] %s", new Object[] { ((StringBuilder)localObject5).toString() });
      localObject3 = new StringBuilder();
      b.a(b.this, (b.e)localObject1, (StringBuilder)localObject3);
      localObject3 = ((StringBuilder)localObject3).toString();
      if (this.brH.brB == b.f.brR)
      {
        localObject1 = "TypeFull";
        com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[analyse key] %s", new Object[] { localObject1 });
      }
      for (;;)
      {
        try
        {
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("machine", b.a(b.this).ai(b.this.brr.application));
          ((JSONObject)localObject5).put("detail", this.brH.brB.name());
          ((JSONObject)localObject5).put("subType", this.brH.brC);
          ((JSONObject)localObject5).put("cost", this.brH.brE);
          if (this.brH.brB == b.f.brP)
          {
            localObject6 = new JSONObject();
            localObject3 = this.brH.brD;
            if (localObject3 != null) {
              break label1026;
            }
            i = 0;
            ((JSONObject)localObject6).put("viewDeep", i);
            if (localObject3 != null) {
              break label1035;
            }
            i = 0;
            ((JSONObject)localObject6).put("viewCount", i);
            if (localObject3 != null) {
              break label1044;
            }
            localObject3 = Integer.valueOf(0);
            ((JSONObject)localObject6).put("activity", localObject3);
            ((JSONObject)localObject5).put("viewInfo", localObject6);
          }
          ((JSONObject)localObject5).put("stack", ((StringBuilder)localObject4).toString());
          ((JSONObject)localObject5).put("stackKey", localObject1);
          b.this.d((JSONObject)localObject5);
          return;
        }
        catch (JSONException localJSONException)
        {
          com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[JSONException for stack %s, error: %s", new Object[] { ((StringBuilder)localObject4).toString(), localJSONException });
          return;
        }
        Object localObject2 = localObject3;
        if (((String)localObject3).length() != 0) {
          break;
        }
        com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "get key null, type:%s", new Object[] { this.brH.brB.name() });
        return;
        label1026:
        i = ((com.tencent.matrix.trace.f.b.a)localObject3).bsO;
        continue;
        label1035:
        i = ((com.tencent.matrix.trace.f.b.a)localObject3).bsN;
        continue;
        label1044:
        localObject3 = ((com.tencent.matrix.trace.f.b.a)localObject3).mActivityName;
      }
    }
  }
  
  private static final class d
  {
    int aOn;
    int brJ;
    int brK;
    int count = 1;
    
    d(int paramInt1, int paramInt2, int paramInt3)
    {
      this.brJ = paramInt1;
      this.brK = paramInt2;
      this.aOn = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((paramObject.brJ == this.brJ) && (paramObject.aOn == this.aOn)) {
          return true;
        }
      }
      return false;
    }
    
    public final int hashCode()
    {
      return super.hashCode();
    }
    
    public final String print()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < this.aOn)
      {
        localStringBuffer.append('.');
        i += 1;
      }
      return localStringBuffer.toString() + this.brJ + " " + this.count + " " + this.brK;
    }
    
    public final String toString()
    {
      return this.aOn + "," + this.brJ + "," + this.count + "," + this.brK;
    }
  }
  
  private static final class e
  {
    b.d brL;
    e brM;
    LinkedList<e> brN = new LinkedList();
    
    e(b.d paramd, e parame)
    {
      this.brL = paramd;
      this.brM = parame;
    }
  }
  
  public static enum f
  {
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.e.b
 * JD-Core Version:    0.7.0.1
 */