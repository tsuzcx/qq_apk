package androidx.camera.core;

import android.graphics.Rect;
import java.util.HashSet;
import java.util.Set;

abstract class aa
  implements ag
{
  protected final ag Hp;
  private final Set<a> Hq = new HashSet();
  
  protected aa(ag paramag)
  {
    this.Hp = paramag;
  }
  
  final void a(a parama)
  {
    try
    {
      this.Hq.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	androidx/camera/core/aa:Hp	Landroidx/camera/core/ag;
    //   6: invokeinterface 37 1 0
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: monitorenter
    //   15: new 21	java/util/HashSet
    //   18: dup
    //   19: aload_0
    //   20: getfield 24	androidx/camera/core/aa:Hq	Ljava/util/Set;
    //   23: invokespecial 40	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: invokeinterface 44 1 0
    //   35: astore_1
    //   36: aload_1
    //   37: invokeinterface 50 1 0
    //   42: ifeq +31 -> 73
    //   45: aload_1
    //   46: invokeinterface 54 1 0
    //   51: checkcast 8	androidx/camera/core/aa$a
    //   54: aload_0
    //   55: invokeinterface 57 2 0
    //   60: goto -24 -> 36
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	aa
    //   26	20	1	localObject1	Object
    //   63	4	1	localObject2	Object
    //   68	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	63	finally
    //   15	29	68	finally
  }
  
  public final int getFormat()
  {
    try
    {
      int i = this.Hp.getFormat();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getHeight()
  {
    try
    {
      int i = this.Hp.getHeight();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getWidth()
  {
    try
    {
      int i = this.Hp.getWidth();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ag.a[] is()
  {
    try
    {
      ag.a[] arrayOfa = this.Hp.is();
      return arrayOfa;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public af it()
  {
    try
    {
      af localaf = this.Hp.it();
      return localaf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCropRect(Rect paramRect)
  {
    try
    {
      this.Hp.setCropRect(paramRect);
      return;
    }
    finally
    {
      paramRect = finally;
      throw paramRect;
    }
  }
  
  static abstract interface a
  {
    public abstract void onImageClose(ag paramag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.aa
 * JD-Core Version:    0.7.0.1
 */