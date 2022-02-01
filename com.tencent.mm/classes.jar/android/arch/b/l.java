package android.arch.b;

final class l<T>
  extends h<T>
{
  private final d<?, T> dZ;
  private final boolean fs;
  private final Object ft;
  
  l(h<T> paramh)
  {
    super(new j(paramh.eG), paramh.dC, paramh.eF, null, paramh.ee);
    this.dZ = paramh.an();
    this.fs = paramh.am();
    this.ft = paramh.ao();
  }
  
  final void a(h<T> paramh, h.c paramc) {}
  
  final boolean am()
  {
    return this.fs;
  }
  
  public final d<?, T> an()
  {
    return this.dZ;
  }
  
  public final Object ao()
  {
    return this.ft;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.b.l
 * JD-Core Version:    0.7.0.1
 */