package android.arch.b;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

final class c<K, V>
  extends h<V>
{
  private final b<K, V> dP;
  private boolean dQ = false;
  private boolean dR = false;
  private int dS = 0;
  private int dT = 0;
  private g.a<V> dU = new g.a() {};
  
  c(b<K, V> paramb, Executor paramExecutor1, Executor paramExecutor2, h.a<V> parama, h.d paramd, K paramK, int paramInt)
  {
    super(new j(), paramExecutor1, paramExecutor2, parama, paramd);
    this.dP = paramb;
    this.eG = -1;
    if (this.dP.cj.get())
    {
      this.eM.set(true);
      return;
    }
    this.dP.a(this.ed.eS, this.ed.eR, this.dB, this.dU);
  }
  
  final void a(h<V> paramh, h.c paramc)
  {
    paramh = paramh.eF;
    int m = this.eF.fk - paramh.fk;
    int j = this.eF.fj - paramh.fj;
    int k = paramh.fg;
    int i = paramh.fe;
    if ((paramh.isEmpty()) || (m < 0) || (j < 0) || (this.eF.fg != Math.max(k - m, 0)) || (this.eF.fe != Math.max(i - j, 0)) || (this.eF.fi != paramh.fi + m + j)) {
      throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
    }
    if (m != 0)
    {
      k = Math.min(k, m);
      m -= k;
      int n = paramh.fe;
      n = paramh.fi + n;
      if (k != 0) {
        paramc.g(n, k);
      }
      if (m != 0) {
        paramc.f(n + k, m);
      }
    }
    if (j != 0)
    {
      k = Math.min(i, j);
      j -= k;
      if (k != 0) {
        paramc.g(i, k);
      }
      if (j != 0) {
        paramc.f(0, j);
      }
    }
  }
  
  final boolean ao()
  {
    return true;
  }
  
  public final d<?, V> ap()
  {
    return this.dP;
  }
  
  public final Object aq()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.c
 * JD-Core Version:    0.7.0.1
 */