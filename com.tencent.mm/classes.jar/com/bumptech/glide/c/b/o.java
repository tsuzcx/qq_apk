package com.bumptech.glide.c.b;

import android.os.Looper;
import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o<Z>
  implements u<Z>
{
  private a aDS;
  private h aDY;
  final boolean aDZ;
  final u<Z> aEa;
  private final boolean aGa;
  private int aGb;
  private boolean aGc;
  
  o(u<Z> paramu, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(77006);
    this.aEa = ((u)i.checkNotNull(paramu, "Argument must not be null"));
    this.aDZ = paramBoolean1;
    this.aGa = paramBoolean2;
    AppMethodBeat.o(77006);
  }
  
  final void a(h paramh, a parama)
  {
    this.aDY = paramh;
    this.aDS = parama;
  }
  
  final void acquire()
  {
    AppMethodBeat.i(77011);
    Object localObject;
    if (this.aGc)
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
    this.aGb += 1;
    AppMethodBeat.o(77011);
  }
  
  public final Z get()
  {
    AppMethodBeat.i(77008);
    Object localObject = this.aEa.get();
    AppMethodBeat.o(77008);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77009);
    int i = this.aEa.getSize();
    AppMethodBeat.o(77009);
    return i;
  }
  
  public final Class<Z> oy()
  {
    AppMethodBeat.i(77007);
    Class localClass = this.aEa.oy();
    AppMethodBeat.o(77007);
    return localClass;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77010);
    IllegalStateException localIllegalStateException;
    if (this.aGb > 0)
    {
      localIllegalStateException = new IllegalStateException("Cannot recycle a resource while it is still acquired");
      AppMethodBeat.o(77010);
      throw localIllegalStateException;
    }
    if (this.aGc)
    {
      localIllegalStateException = new IllegalStateException("Cannot recycle a resource that has already been recycled");
      AppMethodBeat.o(77010);
      throw localIllegalStateException;
    }
    this.aGc = true;
    if (this.aGa) {
      this.aEa.recycle();
    }
    AppMethodBeat.o(77010);
  }
  
  final void release()
  {
    AppMethodBeat.i(77012);
    Object localObject;
    if (this.aGb <= 0)
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
    int i = this.aGb - 1;
    this.aGb = i;
    if (i == 0) {
      this.aDS.b(this.aDY, this);
    }
    AppMethodBeat.o(77012);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77013);
    String str = "EngineResource{isCacheable=" + this.aDZ + ", listener=" + this.aDS + ", key=" + this.aDY + ", acquired=" + this.aGb + ", isRecycled=" + this.aGc + ", resource=" + this.aEa + '}';
    AppMethodBeat.o(77013);
    return str;
  }
  
  static abstract interface a
  {
    public abstract void b(h paramh, o<?> paramo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.o
 * JD-Core Version:    0.7.0.1
 */