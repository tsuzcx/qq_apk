package com.tencent.e.e.a.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
{
  private static final int[] BkV = { 1, 4, 9 };
  private final HashSet<Sensor> BkT;
  public final SparseArray<i> BkU;
  public g.a BkW;
  private final SensorManager bmB;
  
  public g()
  {
    AppMethodBeat.i(145987);
    this.BkT = new HashSet();
    this.BkU = new SparseArray();
    this.BkW = new g.a(this);
    this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
    AppMethodBeat.o(145987);
  }
  
  private static boolean f(SparseArray<i> paramSparseArray)
  {
    AppMethodBeat.i(114561);
    if (paramSparseArray.size() == 0)
    {
      AppMethodBeat.o(114561);
      return false;
    }
    int i = 0;
    while (i < paramSparseArray.size())
    {
      Object localObject = (i)paramSparseArray.valueAt(i);
      if (localObject != null)
      {
        Object[] arrayOfObject = ((i)localObject).dUO();
        if ((arrayOfObject != null) && (arrayOfObject.length != 0))
        {
          int j = 0;
          int m;
          for (int k = 0; j < ((i)localObject).EX.length; k = m)
          {
            m = k;
            if ((List)localObject.EX[j] != null) {
              m = k + 1;
            }
            j += 1;
          }
          if (k < 3)
          {
            AppMethodBeat.o(114561);
            return false;
          }
          j = 0;
          while (j < arrayOfObject.length)
          {
            localObject = (List)arrayOfObject[j];
            if ((localObject != null) && (((List)localObject).size() < f.BkR / 2))
            {
              AppMethodBeat.o(114561);
              return false;
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(114561);
    return true;
  }
  
  public final void dUI()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114559);
        if (this.bmB == null)
        {
          AppMethodBeat.o(114559);
          return;
        }
        synchronized (this.BkT)
        {
          Iterator localIterator = this.BkT.iterator();
          if (localIterator.hasNext())
          {
            Sensor localSensor = (Sensor)localIterator.next();
            this.bmB.unregisterListener(this.BkW, localSensor);
          }
        }
        this.BkT.clear();
      }
      finally {}
      g.a locala = this.BkW;
      synchronized (locala.BkX)
      {
        if (!locala.BkX.get())
        {
          AppMethodBeat.o(114559);
          continue;
        }
        locala.BkX.set(false);
        locala.BkZ = (System.currentTimeMillis() - locala.BkM);
        if (locala.BkZ < 0L) {
          locala.BkZ = 0L;
        }
        locala.BkM = 0L;
        AppMethodBeat.o(114559);
      }
    }
  }
  
  public final SparseArray<i> dUJ()
  {
    AppMethodBeat.i(114560);
    synchronized (this.BkU)
    {
      SparseArray localSparseArray2 = new SparseArray();
      int i = 0;
      while (i < this.BkU.size())
      {
        localSparseArray2.append(this.BkU.keyAt(i), (i)this.BkU.valueAt(i));
        i += 1;
      }
      if (f(localSparseArray2))
      {
        AppMethodBeat.o(114560);
        return localSparseArray2;
      }
      localSparseArray2 = new SparseArray();
      AppMethodBeat.o(114560);
      return localSparseArray2;
    }
  }
  
  /* Error */
  public final boolean oX(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 171
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 66	com/tencent/e/e/a/a/g:bmB	Landroid/hardware/SensorManager;
    //   11: ifnonnull +16 -> 27
    //   14: ldc 171
    //   16: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore 6
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 6
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 48	com/tencent/e/e/a/a/g:BkW	Lcom/tencent/e/e/a/a/g$a;
    //   31: astore 9
    //   33: aload 9
    //   35: getfield 132	com/tencent/e/e/a/a/g$a:BkX	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: astore 8
    //   40: aload 8
    //   42: monitorenter
    //   43: aload 9
    //   45: getfield 132	com/tencent/e/e/a/a/g$a:BkX	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   48: invokevirtual 137	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   51: ifeq +126 -> 177
    //   54: aload 8
    //   56: monitorexit
    //   57: aload_0
    //   58: getfield 38	com/tencent/e/e/a/a/g:BkT	Ljava/util/HashSet;
    //   61: astore 8
    //   63: aload 8
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 38	com/tencent/e/e/a/a/g:BkT	Ljava/util/HashSet;
    //   70: invokevirtual 128	java/util/HashSet:clear	()V
    //   73: aload 8
    //   75: monitorexit
    //   76: aload_0
    //   77: getfield 38	com/tencent/e/e/a/a/g:BkT	Ljava/util/HashSet;
    //   80: astore 8
    //   82: aload 8
    //   84: monitorenter
    //   85: getstatic 22	com/tencent/e/e/a/a/g:BkV	[I
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
    //   113: getfield 66	com/tencent/e/e/a/a/g:bmB	Landroid/hardware/SensorManager;
    //   116: iload 5
    //   118: invokevirtual 175	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   121: astore 10
    //   123: iload 6
    //   125: istore 7
    //   127: aload 10
    //   129: ifnull +37 -> 166
    //   132: iload 6
    //   134: istore 7
    //   136: aload_0
    //   137: getfield 66	com/tencent/e/e/a/a/g:bmB	Landroid/hardware/SensorManager;
    //   140: aload_0
    //   141: getfield 48	com/tencent/e/e/a/a/g:BkW	Lcom/tencent/e/e/a/a/g$a;
    //   144: aload 10
    //   146: iconst_0
    //   147: invokevirtual 179	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   150: ifeq +16 -> 166
    //   153: aload_0
    //   154: getfield 38	com/tencent/e/e/a/a/g:BkT	Ljava/util/HashSet;
    //   157: aload 10
    //   159: invokevirtual 183	java/util/HashSet:add	(Ljava/lang/Object;)Z
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
    //   179: getfield 132	com/tencent/e/e/a/a/g$a:BkX	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   182: iconst_1
    //   183: invokevirtual 141	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   186: aload 9
    //   188: invokestatic 147	java/lang/System:currentTimeMillis	()J
    //   191: putfield 151	com/tencent/e/e/a/a/g$a:BkM	J
    //   194: aload 9
    //   196: lload_1
    //   197: l2d
    //   198: getstatic 186	com/tencent/e/e/a/a/f:BkQ	J
    //   201: l2d
    //   202: ddiv
    //   203: invokestatic 192	java/lang/Math:ceil	(D)D
    //   206: d2i
    //   207: putfield 195	com/tencent/e/e/a/a/g$a:BkY	I
    //   210: aload 8
    //   212: monitorexit
    //   213: goto -156 -> 57
    //   216: astore 9
    //   218: aload 8
    //   220: monitorexit
    //   221: ldc 171
    //   223: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   241: ldc 171
    //   243: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload 9
    //   248: athrow
    //   249: aload 8
    //   251: monitorexit
    //   252: iload 6
    //   254: ifne +7 -> 261
    //   257: aload_0
    //   258: invokevirtual 197	com/tencent/e/e/a/a/g:dUI	()V
    //   261: ldc 171
    //   263: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: goto -244 -> 22
    //   269: astore 9
    //   271: aload 8
    //   273: monitorexit
    //   274: ldc 171
    //   276: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   218	221	216	finally
    //   2	19	229	finally
    //   27	43	229	finally
    //   57	66	229	finally
    //   76	85	229	finally
    //   221	229	229	finally
    //   241	249	229	finally
    //   257	261	229	finally
    //   261	266	229	finally
    //   274	282	229	finally
    //   66	76	236	finally
    //   238	241	236	finally
    //   85	95	269	finally
    //   112	123	269	finally
    //   136	163	269	finally
    //   249	252	269	finally
    //   271	274	269	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.a.g
 * JD-Core Version:    0.7.0.1
 */