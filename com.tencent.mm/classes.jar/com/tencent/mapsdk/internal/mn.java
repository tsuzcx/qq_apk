package com.tencent.mapsdk.internal;

import android.content.Context;
import android.util.SparseArray;

public abstract class mn<T extends mo>
{
  protected sc a;
  protected SparseArray<mm<T>> b;
  protected SparseArray<mm<T>> c;
  protected SparseArray<mm<T>> d;
  protected SparseArray<mm<T>> e;
  protected SparseArray<mm<T>> f;
  protected SparseArray<mm<T>> g;
  protected SparseArray<mm<T>> h;
  private int i = 0;
  
  public mn(sc paramsc)
  {
    this.a = paramsc;
    this.b = new SparseArray();
    this.c = new SparseArray();
    this.d = new SparseArray();
    this.e = new SparseArray();
    this.f = new SparseArray();
    this.g = new SparseArray();
    this.h = new SparseArray();
  }
  
  private void i()
  {
    try
    {
      this.h.clear();
      this.d.clear();
      this.f.clear();
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Context a()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.z();
  }
  
  public mm<T> a(int paramInt)
  {
    try
    {
      mm localmm = (mm)this.b.get(paramInt);
      return localmm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract mm<T> a(T paramT);
  
  /* Error */
  public final void a(mm<T> parammm)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mapsdk/internal/mn:b	Landroid/util/SparseArray;
    //   6: aload_1
    //   7: getfield 67	com/tencent/mapsdk/internal/mm:a	I
    //   10: invokevirtual 59	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 40	com/tencent/mapsdk/internal/mn:f	Landroid/util/SparseArray;
    //   25: aload_1
    //   26: getfield 67	com/tencent/mapsdk/internal/mm:a	I
    //   29: aload_1
    //   30: invokevirtual 71	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 27	com/tencent/mapsdk/internal/mn:a	Lcom/tencent/mapsdk/internal/sc;
    //   37: iconst_1
    //   38: invokevirtual 74	com/tencent/mapsdk/internal/sc:g	(Z)V
    //   41: goto -23 -> 18
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	mn
    //   0	49	1	parammm	mm<T>
    //   13	2	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   21	41	44	finally
  }
  
  public mm<T> b(T paramT)
  {
    try
    {
      paramT = a(paramT);
      SparseArray localSparseArray;
      int j;
      do
      {
        localSparseArray = this.b;
        j = this.i + 1;
        this.i = j;
      } while (localSparseArray.get(j) != null);
      paramT.a = this.i;
      this.b.append(paramT.a, paramT);
      this.d.append(paramT.a, paramT);
      this.a.g(true);
      return paramT;
    }
    finally {}
  }
  
  public final void b()
  {
    try
    {
      i();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void b(mm<T> parammm)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mapsdk/internal/mn:b	Landroid/util/SparseArray;
    //   6: aload_1
    //   7: getfield 67	com/tencent/mapsdk/internal/mm:a	I
    //   10: invokevirtual 59	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 36	com/tencent/mapsdk/internal/mn:d	Landroid/util/SparseArray;
    //   25: aload_1
    //   26: getfield 67	com/tencent/mapsdk/internal/mm:a	I
    //   29: invokevirtual 59	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   32: ifnonnull +15 -> 47
    //   35: aload_0
    //   36: getfield 44	com/tencent/mapsdk/internal/mn:h	Landroid/util/SparseArray;
    //   39: aload_1
    //   40: getfield 67	com/tencent/mapsdk/internal/mm:a	I
    //   43: aload_1
    //   44: invokevirtual 71	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   47: aload_0
    //   48: getfield 32	com/tencent/mapsdk/internal/mn:b	Landroid/util/SparseArray;
    //   51: aload_1
    //   52: getfield 67	com/tencent/mapsdk/internal/mm:a	I
    //   55: invokevirtual 84	android/util/SparseArray:remove	(I)V
    //   58: aload_0
    //   59: getfield 36	com/tencent/mapsdk/internal/mn:d	Landroid/util/SparseArray;
    //   62: aload_1
    //   63: getfield 67	com/tencent/mapsdk/internal/mm:a	I
    //   66: invokevirtual 84	android/util/SparseArray:remove	(I)V
    //   69: aload_0
    //   70: getfield 40	com/tencent/mapsdk/internal/mn:f	Landroid/util/SparseArray;
    //   73: aload_1
    //   74: getfield 67	com/tencent/mapsdk/internal/mm:a	I
    //   77: invokevirtual 84	android/util/SparseArray:remove	(I)V
    //   80: aload_0
    //   81: getfield 27	com/tencent/mapsdk/internal/mn:a	Lcom/tencent/mapsdk/internal/sc;
    //   84: iconst_1
    //   85: invokevirtual 74	com/tencent/mapsdk/internal/sc:g	(Z)V
    //   88: goto -70 -> 18
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	mn
    //   0	96	1	parammm	mm<T>
    //   13	2	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	91	finally
    //   21	47	91	finally
    //   47	88	91	finally
  }
  
  protected void c() {}
  
  public final void d()
  {
    try
    {
      c();
      SparseArray localSparseArray = this.g;
      this.g = this.h;
      this.h = localSparseArray;
      localSparseArray = this.e;
      this.e = this.f;
      this.f = localSparseArray;
      localSparseArray = this.c;
      this.c = this.d;
      this.d = localSparseArray;
      this.d.clear();
      this.f.clear();
      this.h.clear();
      f();
      g();
      h();
      this.g.clear();
      this.e.clear();
      this.c.clear();
      e();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void e() {}
  
  protected abstract void f();
  
  protected abstract void g();
  
  protected abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mn
 * JD-Core Version:    0.7.0.1
 */