package com.tencent.d.e.a.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
{
  private static final int[] wNw = { 1, 4, 9 };
  private final SensorManager aVT;
  private final HashSet<Sensor> wNu = new HashSet();
  public final SparseArray<i> wNv = new SparseArray();
  public g.a wNx = new g.a(this);
  
  public g(Context paramContext)
  {
    this.aVT = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  private static boolean e(SparseArray<i> paramSparseArray)
  {
    if (paramSparseArray.size() == 0) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramSparseArray.size()) {
        break label154;
      }
      Object localObject = (i)paramSparseArray.valueAt(i);
      if (localObject != null)
      {
        Object[] arrayOfObject = ((i)localObject).cOY();
        if ((arrayOfObject != null) && (arrayOfObject.length != 0))
        {
          int j = 0;
          int m;
          for (int k = 0; j < ((i)localObject).Eh.length; k = m)
          {
            m = k;
            if ((List)localObject.Eh[j] != null) {
              m = k + 1;
            }
            j += 1;
          }
          if (k < 3) {
            break;
          }
          j = 0;
          for (;;)
          {
            if (j >= arrayOfObject.length) {
              break label147;
            }
            localObject = (List)arrayOfObject[j];
            if ((localObject != null) && (((List)localObject).size() < f.wNs / 2)) {
              break;
            }
            j += 1;
          }
        }
      }
      label147:
      i += 1;
    }
    label154:
    return true;
  }
  
  public final void cOS()
  {
    for (;;)
    {
      try
      {
        ??? = this.aVT;
        if (??? == null) {
          return;
        }
        synchronized (this.wNu)
        {
          Iterator localIterator = this.wNu.iterator();
          if (localIterator.hasNext())
          {
            Sensor localSensor = (Sensor)localIterator.next();
            this.aVT.unregisterListener(this.wNx, localSensor);
          }
        }
        this.wNu.clear();
      }
      finally {}
      g.a locala = this.wNx;
      synchronized (locala.wNy)
      {
        if (locala.wNy.get()) {}
      }
      localObject4.wNy.set(false);
      localObject4.wNA = (System.currentTimeMillis() - localObject4.wNn);
      if (localObject4.wNA < 0L) {
        localObject4.wNA = 0L;
      }
      localObject4.wNn = 0L;
    }
  }
  
  public final SparseArray<i> cOT()
  {
    synchronized (this.wNv)
    {
      SparseArray localSparseArray2 = new SparseArray();
      int i = 0;
      while (i < this.wNv.size())
      {
        localSparseArray2.append(this.wNv.keyAt(i), (i)this.wNv.valueAt(i));
        i += 1;
      }
      if (e(localSparseArray2)) {
        return localSparseArray2;
      }
      localSparseArray2 = new SparseArray();
      return localSparseArray2;
    }
  }
  
  /* Error */
  public final boolean il(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/d/e/a/a/g:aVT	Landroid/hardware/SensorManager;
    //   6: astore 8
    //   8: aload 8
    //   10: ifnonnull +11 -> 21
    //   13: iconst_0
    //   14: istore 7
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 7
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 42	com/tencent/d/e/a/a/g:wNx	Lcom/tencent/d/e/a/a/g$a;
    //   25: astore 9
    //   27: aload 9
    //   29: getfield 115	com/tencent/d/e/a/a/g$a:wNy	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   32: astore 8
    //   34: aload 8
    //   36: monitorenter
    //   37: aload 9
    //   39: getfield 115	com/tencent/d/e/a/a/g$a:wNy	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   42: invokevirtual 120	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   45: ifeq +126 -> 171
    //   48: aload 8
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 32	com/tencent/d/e/a/a/g:wNu	Ljava/util/HashSet;
    //   55: astore 8
    //   57: aload 8
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 32	com/tencent/d/e/a/a/g:wNu	Ljava/util/HashSet;
    //   64: invokevirtual 111	java/util/HashSet:clear	()V
    //   67: aload 8
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield 32	com/tencent/d/e/a/a/g:wNu	Ljava/util/HashSet;
    //   74: astore 8
    //   76: aload 8
    //   78: monitorenter
    //   79: getstatic 22	com/tencent/d/e/a/a/g:wNw	[I
    //   82: astore 9
    //   84: aload 9
    //   86: arraylength
    //   87: istore 4
    //   89: iconst_0
    //   90: istore_3
    //   91: iconst_0
    //   92: istore 6
    //   94: iload_3
    //   95: iload 4
    //   97: if_icmpge +136 -> 233
    //   100: aload 9
    //   102: iload_3
    //   103: iaload
    //   104: istore 5
    //   106: aload_0
    //   107: getfield 54	com/tencent/d/e/a/a/g:aVT	Landroid/hardware/SensorManager;
    //   110: iload 5
    //   112: invokevirtual 156	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   115: astore 10
    //   117: iload 6
    //   119: istore 7
    //   121: aload 10
    //   123: ifnull +37 -> 160
    //   126: iload 6
    //   128: istore 7
    //   130: aload_0
    //   131: getfield 54	com/tencent/d/e/a/a/g:aVT	Landroid/hardware/SensorManager;
    //   134: aload_0
    //   135: getfield 42	com/tencent/d/e/a/a/g:wNx	Lcom/tencent/d/e/a/a/g$a;
    //   138: aload 10
    //   140: iconst_0
    //   141: invokevirtual 160	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   144: ifeq +16 -> 160
    //   147: aload_0
    //   148: getfield 32	com/tencent/d/e/a/a/g:wNu	Ljava/util/HashSet;
    //   151: aload 10
    //   153: invokevirtual 164	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   156: pop
    //   157: iconst_1
    //   158: istore 7
    //   160: iload_3
    //   161: iconst_1
    //   162: iadd
    //   163: istore_3
    //   164: iload 7
    //   166: istore 6
    //   168: goto -74 -> 94
    //   171: aload 9
    //   173: getfield 115	com/tencent/d/e/a/a/g$a:wNy	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   176: iconst_1
    //   177: invokevirtual 124	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   180: aload 9
    //   182: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   185: putfield 134	com/tencent/d/e/a/a/g$a:wNn	J
    //   188: aload 9
    //   190: lload_1
    //   191: l2d
    //   192: getstatic 167	com/tencent/d/e/a/a/f:wNr	J
    //   195: l2d
    //   196: ddiv
    //   197: invokestatic 173	java/lang/Math:ceil	(D)D
    //   200: d2i
    //   201: putfield 176	com/tencent/d/e/a/a/g$a:wNz	I
    //   204: aload 8
    //   206: monitorexit
    //   207: goto -156 -> 51
    //   210: astore 9
    //   212: aload 8
    //   214: monitorexit
    //   215: aload 9
    //   217: athrow
    //   218: astore 8
    //   220: aload_0
    //   221: monitorexit
    //   222: aload 8
    //   224: athrow
    //   225: astore 9
    //   227: aload 8
    //   229: monitorexit
    //   230: aload 9
    //   232: athrow
    //   233: aload 8
    //   235: monitorexit
    //   236: iload 6
    //   238: istore 7
    //   240: iload 6
    //   242: ifne -226 -> 16
    //   245: aload_0
    //   246: invokevirtual 178	com/tencent/d/e/a/a/g:cOS	()V
    //   249: iload 6
    //   251: istore 7
    //   253: goto -237 -> 16
    //   256: astore 9
    //   258: aload 8
    //   260: monitorexit
    //   261: aload 9
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	g
    //   0	264	1	paramLong	long
    //   90	74	3	i	int
    //   87	11	4	j	int
    //   104	7	5	k	int
    //   92	158	6	bool1	boolean
    //   14	238	7	bool2	boolean
    //   218	41	8	localObject2	Object
    //   25	164	9	localObject3	Object
    //   210	6	9	localObject4	Object
    //   225	6	9	localObject5	Object
    //   256	6	9	localObject6	Object
    //   115	37	10	localSensor	Sensor
    // Exception table:
    //   from	to	target	type
    //   37	51	210	finally
    //   171	207	210	finally
    //   212	215	210	finally
    //   2	8	218	finally
    //   21	37	218	finally
    //   51	60	218	finally
    //   70	79	218	finally
    //   215	218	218	finally
    //   230	233	218	finally
    //   245	249	218	finally
    //   261	264	218	finally
    //   60	70	225	finally
    //   227	230	225	finally
    //   79	89	256	finally
    //   106	117	256	finally
    //   130	157	256	finally
    //   233	236	256	finally
    //   258	261	256	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.d.e.a.a.g
 * JD-Core Version:    0.7.0.1
 */