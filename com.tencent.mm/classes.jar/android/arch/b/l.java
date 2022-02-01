package android.arch.b;

final class l<T>
  extends h<T>
{
  private final d<?, T> dY;
  private final boolean fu;
  private final Object fv;
  
  l(h<T> paramh)
  {
    super(new j(paramh.eF), paramh.dB, paramh.eE, null, paramh.ed);
    this.dY = paramh.ap();
    this.fu = paramh.ao();
    this.fv = paramh.aq();
  }
  
  final void a(h<T> paramh, h.c paramc) {}
  
  final boolean ao()
  {
    return this.fu;
  }
  
  public final d<?, T> ap()
  {
    return this.dY;
  }
  
  public final Object aq()
  {
    return this.fv;
  }
  
  public final boolean isDetached()
  {
    return true;
  }
  
  public final boolean isImmutable()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.l
 * JD-Core Version:    0.7.0.1
 */