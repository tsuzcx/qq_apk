package com.bumptech.glide.c.b;

import android.os.Looper;
import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o<Z>
  implements u<Z>
{
  private a aFJ;
  private h aFP;
  final boolean aFQ;
  final u<Z> aFR;
  private final boolean aHR;
  private int aHS;
  private boolean aHT;
  
  o(u<Z> paramu, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(77006);
    this.aFR = ((u)i.checkNotNull(paramu, "Argument must not be null"));
    this.aFQ = paramBoolean1;
    this.aHR = paramBoolean2;
    AppMethodBeat.o(77006);
  }
  
  final void a(h paramh, a parama)
  {
    this.aFP = paramh;
    this.aFJ = parama;
  }
  
  final void acquire()
  {
    AppMethodBeat.i(77011);
    Object localObject;
    if (this.aHT)
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
    this.aHS += 1;
    AppMethodBeat.o(77011);
  }
  
  public final Z get()
  {
    AppMethodBeat.i(77008);
    Object localObject = this.aFR.get();
    AppMethodBeat.o(77008);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77009);
    int i = this.aFR.getSize();
    AppMethodBeat.o(77009);
    return i;
  }
  
  public final Class<Z> oQ()
  {
    AppMethodBeat.i(77007);
    Class localClass = this.aFR.oQ();
    AppMethodBeat.o(77007);
    return localClass;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77010);
    IllegalStateException localIllegalStateException;
    if (this.aHS > 0)
    {
      localIllegalStateException = new IllegalStateException("Cannot recycle a resource while it is still acquired");
      AppMethodBeat.o(77010);
      throw localIllegalStateException;
    }
    if (this.aHT)
    {
      localIllegalStateException = new IllegalStateException("Cannot recycle a resource that has already been recycled");
      AppMethodBeat.o(77010);
      throw localIllegalStateException;
    }
    this.aHT = true;
    if (this.aHR) {
      this.aFR.recycle();
    }
    AppMethodBeat.o(77010);
  }
  
  final void release()
  {
    AppMethodBeat.i(77012);
    Object localObject;
    if (this.aHS <= 0)
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
    int i = this.aHS - 1;
    this.aHS = i;
    if (i == 0) {
      this.aFJ.b(this.aFP, this);
    }
    AppMethodBeat.o(77012);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77013);
    String str = "EngineResource{isCacheable=" + this.aFQ + ", listener=" + this.aFJ + ", key=" + this.aFP + ", acquired=" + this.aHS + ", isRecycled=" + this.aHT + ", resource=" + this.aFR + '}';
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