package com.bumptech.glide.c.b;

import android.os.Looper;
import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o<Z>
  implements u<Z>
{
  private a aDb;
  private h aDh;
  final boolean aDi;
  final u<Z> aDj;
  private final boolean aFk;
  private int aFl;
  private boolean aFm;
  
  o(u<Z> paramu, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(77006);
    this.aDj = ((u)i.checkNotNull(paramu, "Argument must not be null"));
    this.aDi = paramBoolean1;
    this.aFk = paramBoolean2;
    AppMethodBeat.o(77006);
  }
  
  final void a(h paramh, a parama)
  {
    this.aDh = paramh;
    this.aDb = parama;
  }
  
  final void acquire()
  {
    AppMethodBeat.i(77011);
    Object localObject;
    if (this.aFm)
    {
      localObject = new IllegalStateException("Cannot acquire a recycled resource");
      AppMethodBeat.o(77011);
      throw ((Throwable)localObject);
    }
    if (!Looper.getMainLooper().equals(Looper.myLooper()))
    {
      localObject = new IllegalThreadStateException("Must call acquire on the main thread");
      AppMethodBeat.o(77011);
      throw ((Throwable)localObject);
    }
    this.aFl += 1;
    AppMethodBeat.o(77011);
  }
  
  public final Z get()
  {
    AppMethodBeat.i(77008);
    Object localObject = this.aDj.get();
    AppMethodBeat.o(77008);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77009);
    int i = this.aDj.getSize();
    AppMethodBeat.o(77009);
    return i;
  }
  
  public final Class<Z> oo()
  {
    AppMethodBeat.i(77007);
    Class localClass = this.aDj.oo();
    AppMethodBeat.o(77007);
    return localClass;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77010);
    IllegalStateException localIllegalStateException;
    if (this.aFl > 0)
    {
      localIllegalStateException = new IllegalStateException("Cannot recycle a resource while it is still acquired");
      AppMethodBeat.o(77010);
      throw localIllegalStateException;
    }
    if (this.aFm)
    {
      localIllegalStateException = new IllegalStateException("Cannot recycle a resource that has already been recycled");
      AppMethodBeat.o(77010);
      throw localIllegalStateException;
    }
    this.aFm = true;
    if (this.aFk) {
      this.aDj.recycle();
    }
    AppMethodBeat.o(77010);
  }
  
  final void release()
  {
    AppMethodBeat.i(77012);
    Object localObject;
    if (this.aFl <= 0)
    {
      localObject = new IllegalStateException("Cannot release a recycled or not yet acquired resource");
      AppMethodBeat.o(77012);
      throw ((Throwable)localObject);
    }
    if (!Looper.getMainLooper().equals(Looper.myLooper()))
    {
      localObject = new IllegalThreadStateException("Must call release on the main thread");
      AppMethodBeat.o(77012);
      throw ((Throwable)localObject);
    }
    int i = this.aFl - 1;
    this.aFl = i;
    if (i == 0) {
      this.aDb.b(this.aDh, this);
    }
    AppMethodBeat.o(77012);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77013);
    String str = "EngineResource{isCacheable=" + this.aDi + ", listener=" + this.aDb + ", key=" + this.aDh + ", acquired=" + this.aFl + ", isRecycled=" + this.aFm + ", resource=" + this.aDj + '}';
    AppMethodBeat.o(77013);
    return str;
  }
  
  static abstract interface a
  {
    public abstract void b(h paramh, o<?> paramo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.o
 * JD-Core Version:    0.7.0.1
 */