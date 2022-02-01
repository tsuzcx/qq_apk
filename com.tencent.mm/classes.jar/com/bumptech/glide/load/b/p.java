package com.bumptech.glide.load.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p<Z>
  implements v<Z>
{
  private a aFB;
  private g aFH;
  final boolean aFI;
  final v<Z> aFJ;
  private final boolean aHL;
  private int aHM;
  private boolean aHN;
  
  p(v<Z> paramv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(77006);
    this.aFJ = ((v)j.checkNotNull(paramv, "Argument must not be null"));
    this.aFI = paramBoolean1;
    this.aHL = paramBoolean2;
    AppMethodBeat.o(77006);
  }
  
  final void a(g paramg, a parama)
  {
    try
    {
      this.aFH = paramg;
      this.aFB = parama;
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  final void acquire()
  {
    try
    {
      AppMethodBeat.i(77011);
      if (this.aHN)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Cannot acquire a recycled resource");
        AppMethodBeat.o(77011);
        throw localIllegalStateException;
      }
    }
    finally {}
    this.aHM += 1;
    AppMethodBeat.o(77011);
  }
  
  public final Z get()
  {
    AppMethodBeat.i(77008);
    Object localObject = this.aFJ.get();
    AppMethodBeat.o(77008);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77009);
    int i = this.aFJ.getSize();
    AppMethodBeat.o(77009);
    return i;
  }
  
  public final Class<Z> oV()
  {
    AppMethodBeat.i(77007);
    Class localClass = this.aFJ.oV();
    AppMethodBeat.o(77007);
    return localClass;
  }
  
  public final void recycle()
  {
    try
    {
      AppMethodBeat.i(77010);
      if (this.aHM > 0)
      {
        IllegalStateException localIllegalStateException1 = new IllegalStateException("Cannot recycle a resource while it is still acquired");
        AppMethodBeat.o(77010);
        throw localIllegalStateException1;
      }
    }
    finally {}
    if (this.aHN)
    {
      IllegalStateException localIllegalStateException2 = new IllegalStateException("Cannot recycle a resource that has already been recycled");
      AppMethodBeat.o(77010);
      throw localIllegalStateException2;
    }
    this.aHN = true;
    if (this.aHL) {
      this.aFJ.recycle();
    }
    AppMethodBeat.o(77010);
  }
  
  final void release()
  {
    AppMethodBeat.i(77012);
    synchronized (this.aFB)
    {
      try
      {
        if (this.aHM <= 0)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("Cannot release a recycled or not yet acquired resource");
          AppMethodBeat.o(77012);
          throw localIllegalStateException;
        }
      }
      finally
      {
        AppMethodBeat.o(77012);
      }
    }
    int i = this.aHM - 1;
    this.aHM = i;
    if (i == 0) {
      this.aFB.b(this.aFH, this);
    }
    AppMethodBeat.o(77012);
  }
  
  public final String toString()
  {
    try
    {
      AppMethodBeat.i(77013);
      String str = "EngineResource{isCacheable=" + this.aFI + ", listener=" + this.aFB + ", key=" + this.aFH + ", acquired=" + this.aHM + ", isRecycled=" + this.aHN + ", resource=" + this.aFJ + '}';
      AppMethodBeat.o(77013);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static abstract interface a
  {
    public abstract void b(g paramg, p<?> paramp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.p
 * JD-Core Version:    0.7.0.1
 */