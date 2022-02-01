package com.tencent.e.e.a.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
{
  private static final int[] ahul = { 1, 4, 9 };
  private final HashSet<Sensor> ahuj;
  public final SparseArray<i> ahuk;
  public a ahum;
  private final SensorManager mSensorManager;
  
  public g()
  {
    AppMethodBeat.i(138398);
    this.ahuj = new HashSet();
    this.ahuk = new SparseArray();
    this.ahum = new a();
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    AppMethodBeat.o(138398);
  }
  
  private static boolean h(SparseArray<i> paramSparseArray)
  {
    AppMethodBeat.i(138402);
    if (paramSparseArray.size() == 0)
    {
      AppMethodBeat.o(138402);
      return false;
    }
    int i = 0;
    while (i < paramSparseArray.size())
    {
      Object localObject = (i)paramSparseArray.valueAt(i);
      if (localObject != null)
      {
        Object[] arrayOfObject = ((i)localObject).jXv();
        if ((arrayOfObject != null) && (arrayOfObject.length != 0))
        {
          int j = 0;
          int m;
          for (int k = 0; j < ((i)localObject).RY.length; k = m)
          {
            m = k;
            if ((List)localObject.RY[j] != null) {
              m = k + 1;
            }
            j += 1;
          }
          if (k < 3)
          {
            AppMethodBeat.o(138402);
            return false;
          }
          j = 0;
          while (j < arrayOfObject.length)
          {
            localObject = (List)arrayOfObject[j];
            if ((localObject != null) && (((List)localObject).size() < f.ahuh / 2))
            {
              AppMethodBeat.o(138402);
              return false;
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(138402);
    return true;
  }
  
  /* Error */
  public final boolean Ba(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 106
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 67	com/tencent/e/e/a/a/g:mSensorManager	Landroid/hardware/SensorManager;
    //   11: ifnonnull +16 -> 27
    //   14: ldc 106
    //   16: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore 6
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 6
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 49	com/tencent/e/e/a/a/g:ahum	Lcom/tencent/e/e/a/a/g$a;
    //   31: astore 9
    //   33: aload 9
    //   35: getfield 110	com/tencent/e/e/a/a/g$a:ahun	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: astore 8
    //   40: aload 8
    //   42: monitorenter
    //   43: aload 9
    //   45: getfield 110	com/tencent/e/e/a/a/g$a:ahun	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   48: invokevirtual 116	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   51: ifeq +126 -> 177
    //   54: aload 8
    //   56: monitorexit
    //   57: aload_0
    //   58: getfield 39	com/tencent/e/e/a/a/g:ahuj	Ljava/util/HashSet;
    //   61: astore 8
    //   63: aload 8
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 39	com/tencent/e/e/a/a/g:ahuj	Ljava/util/HashSet;
    //   70: invokevirtual 119	java/util/HashSet:clear	()V
    //   73: aload 8
    //   75: monitorexit
    //   76: aload_0
    //   77: getfield 39	com/tencent/e/e/a/a/g:ahuj	Ljava/util/HashSet;
    //   80: astore 8
    //   82: aload 8
    //   84: monitorenter
    //   85: getstatic 23	com/tencent/e/e/a/a/g:ahul	[I
    //   88: astore 9
    //   90: aload 9
    //   92: arraylength
    //   93: istore 4
    //   95: iconst_0
    //   96: istore_3
    //   97: iconst_0
    //   98: istore 6
    //   100: iload_3
    //   101: iload 4
    //   103: if_icmpge +146 -> 249
    //   106: aload 9
    //   108: iload_3
    //   109: iaload
    //   110: istore 5
    //   112: aload_0
    //   113: getfield 67	com/tencent/e/e/a/a/g:mSensorManager	Landroid/hardware/SensorManager;
    //   116: iload 5
    //   118: invokevirtual 123	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   121: astore 10
    //   123: iload 6
    //   125: istore 7
    //   127: aload 10
    //   129: ifnull +37 -> 166
    //   132: iload 6
    //   134: istore 7
    //   136: aload_0
    //   137: getfield 67	com/tencent/e/e/a/a/g:mSensorManager	Landroid/hardware/SensorManager;
    //   140: aload_0
    //   141: getfield 49	com/tencent/e/e/a/a/g:ahum	Lcom/tencent/e/e/a/a/g$a;
    //   144: aload 10
    //   146: iconst_0
    //   147: invokevirtual 127	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   150: ifeq +16 -> 166
    //   153: aload_0
    //   154: getfield 39	com/tencent/e/e/a/a/g:ahuj	Ljava/util/HashSet;
    //   157: aload 10
    //   159: invokevirtual 131	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   162: pop
    //   163: iconst_1
    //   164: istore 7
    //   166: iload_3
    //   167: iconst_1
    //   168: iadd
    //   169: istore_3
    //   170: iload 7
    //   172: istore 6
    //   174: goto -74 -> 100
    //   177: aload 9
    //   179: getfield 110	com/tencent/e/e/a/a/g$a:ahun	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   182: iconst_1
    //   183: invokevirtual 135	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   186: aload 9
    //   188: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   191: putfield 145	com/tencent/e/e/a/a/g$a:ahuc	J
    //   194: aload 9
    //   196: lload_1
    //   197: l2d
    //   198: getstatic 148	com/tencent/e/e/a/a/f:ahug	J
    //   201: l2d
    //   202: ddiv
    //   203: invokestatic 154	java/lang/Math:ceil	(D)D
    //   206: d2i
    //   207: putfield 157	com/tencent/e/e/a/a/g$a:ahuo	I
    //   210: aload 8
    //   212: monitorexit
    //   213: goto -156 -> 57
    //   216: astore 9
    //   218: aload 8
    //   220: monitorexit
    //   221: ldc 106
    //   223: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload 9
    //   228: athrow
    //   229: astore 8
    //   231: aload_0
    //   232: monitorexit
    //   233: aload 8
    //   235: athrow
    //   236: astore 9
    //   238: aload 8
    //   240: monitorexit
    //   241: ldc 106
    //   243: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload 9
    //   248: athrow
    //   249: aload 8
    //   251: monitorexit
    //   252: iload 6
    //   254: ifne +7 -> 261
    //   257: aload_0
    //   258: invokevirtual 160	com/tencent/e/e/a/a/g:jXp	()V
    //   261: ldc 106
    //   263: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: goto -244 -> 22
    //   269: astore 9
    //   271: aload 8
    //   273: monitorexit
    //   274: ldc 106
    //   276: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload 9
    //   281: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	g
    //   0	282	1	paramLong	long
    //   96	74	3	i	int
    //   93	11	4	j	int
    //   110	7	5	k	int
    //   20	233	6	bool1	boolean
    //   125	46	7	bool2	boolean
    //   229	43	8	localObject2	Object
    //   31	164	9	localObject3	Object
    //   216	11	9	localObject4	Object
    //   236	11	9	localObject5	Object
    //   269	11	9	localObject6	Object
    //   121	37	10	localSensor	Sensor
    // Exception table:
    //   from	to	target	type
    //   43	57	216	finally
    //   177	213	216	finally
    //   2	19	229	finally
    //   27	43	229	finally
    //   57	66	229	finally
    //   76	85	229	finally
    //   218	229	229	finally
    //   238	249	229	finally
    //   257	261	229	finally
    //   261	266	229	finally
    //   271	282	229	finally
    //   66	76	236	finally
    //   85	95	269	finally
    //   112	123	269	finally
    //   136	163	269	finally
    //   249	252	269	finally
  }
  
  public final void jXp()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(138400);
        if (this.mSensorManager == null)
        {
          AppMethodBeat.o(138400);
          return;
        }
        synchronized (this.ahuj)
        {
          Iterator localIterator = this.ahuj.iterator();
          if (localIterator.hasNext())
          {
            Sensor localSensor = (Sensor)localIterator.next();
            this.mSensorManager.unregisterListener(this.ahum, localSensor);
          }
        }
        this.ahuj.clear();
      }
      finally {}
      a locala = this.ahum;
      synchronized (locala.ahun)
      {
        if (!locala.ahun.get())
        {
          AppMethodBeat.o(138400);
          continue;
        }
        locala.ahun.set(false);
        locala.ahup = (System.currentTimeMillis() - locala.ahuc);
        if (locala.ahup < 0L) {
          locala.ahup = 0L;
        }
        locala.ahuc = 0L;
        AppMethodBeat.o(138400);
      }
    }
  }
  
  public final SparseArray<i> jXq()
  {
    AppMethodBeat.i(138401);
    synchronized (this.ahuk)
    {
      SparseArray localSparseArray2 = new SparseArray();
      int i = 0;
      while (i < this.ahuk.size())
      {
        localSparseArray2.append(this.ahuk.keyAt(i), (i)this.ahuk.valueAt(i));
        i += 1;
      }
      if (h(localSparseArray2))
      {
        AppMethodBeat.o(138401);
        return localSparseArray2;
      }
      localSparseArray2 = new SparseArray();
      AppMethodBeat.o(138401);
      return localSparseArray2;
    }
  }
  
  public final class a
    implements SensorEventListener
  {
    long ahuc;
    final AtomicBoolean ahun;
    int ahuo;
    long ahup;
    
    a()
    {
      AppMethodBeat.i(138396);
      this.ahun = new AtomicBoolean(false);
      this.ahuc = 0L;
      this.ahuo = 0;
      this.ahup = 0L;
      AppMethodBeat.o(138396);
    }
    
    public final long jXr()
    {
      synchronized (this.ahun)
      {
        long l = this.ahuc;
        return l;
      }
    }
    
    public final long jXs()
    {
      synchronized (this.ahun)
      {
        long l = this.ahup;
        return l;
      }
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent arg1)
    {
      AppMethodBeat.i(138397);
      synchronized (this.ahun)
      {
        if (!this.ahun.get())
        {
          AppMethodBeat.o(138397);
          return;
        }
        if ((??? == null) || (???.sensor == null))
        {
          AppMethodBeat.o(138397);
          return;
        }
      }
      j localj = new j(???, System.currentTimeMillis());
      int j;
      int i;
      synchronized (this.ahun)
      {
        long l = localj.timestamp - this.ahuc;
        if (l < 0L)
        {
          AppMethodBeat.o(138397);
          return;
        }
        j = localj.ahuv;
        i = (int)(l / f.ahug);
      }
      for (;;)
      {
        synchronized (g.a(g.this))
        {
          ??? = (i)g.a(g.this).get(j);
          if (??? == null)
          {
            ??? = new i(j, f.ahuh, this.ahuo);
            g.a(g.this).put(j, ???);
            if ((i < ???.hmC) && (i > ???.jP))
            {
              j = i / ???.ahuu;
              List localList = (List)???.RY[j];
              ??? = localList;
              if (localList == null)
              {
                ??? = new ArrayList();
                ???.RY[j] = ???;
              }
              ((List)???).add(localj);
              ???.jP = i;
            }
            AppMethodBeat.o(138397);
            return;
            localObject2 = finally;
            AppMethodBeat.o(138397);
            throw localObject2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.a.g
 * JD-Core Version:    0.7.0.1
 */