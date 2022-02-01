package androidx.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class l<T>
  extends h<T>
{
  private final d<?, T> adm;
  private final boolean aeC;
  private final Object aeD;
  
  l(h<T> paramh)
  {
    super(new j(paramh.adT), paramh.acO, paramh.adS, null, paramh.adr);
    AppMethodBeat.i(219582);
    this.adm = paramh.jz();
    this.aeC = paramh.jy();
    this.adU = paramh.adU;
    this.aeD = paramh.jA();
    AppMethodBeat.o(219582);
  }
  
  final void a(h<T> paramh, h.c paramc) {}
  
  public final boolean isDetached()
  {
    return true;
  }
  
  public final boolean isImmutable()
  {
    return true;
  }
  
  public final Object jA()
  {
    return this.aeD;
  }
  
  final boolean jy()
  {
    return this.aeC;
  }
  
  public final d<?, T> jz()
  {
    return this.adm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.i.l
 * JD-Core Version:    0.7.0.1
 */