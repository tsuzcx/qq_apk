package android.arch.b;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

final class c<K, V>
  extends h<V>
{
  private final b<K, V> dQ;
  private boolean dR = false;
  private boolean dS = false;
  private int dT = 0;
  private int dU = 0;
  private g.a<V> dV = new g.a() {};
  
  c(b<K, V> paramb, Executor paramExecutor1, Executor paramExecutor2, h.a<V> parama, h.d paramd)
  {
    super(new j(), paramExecutor1, paramExecutor2, parama, paramd);
    this.dQ = paramb;
    this.eH = -1;
    if (this.dQ.cj.get())
    {
      this.eN.set(true);
      return;
    }
    this.dQ.a(this.ee.eT, this.ee.eS, this.dC, this.dV);
  }
  
  final void a(h<V> paramh, h.c paramc)
  {
    paramh = paramh.eG;
    int m = this.eG.fi - paramh.fi;
    int j = this.eG.fh - paramh.fh;
    int k = paramh.fe;
    int i = paramh.fb;
    if ((paramh.isEmpty()) || (m < 0) || (j < 0) || (this.eG.fe != Math.max(k - m, 0)) || (this.eG.fb != Math.max(i - j, 0)) || (this.eG.fg != paramh.fg + m + j)) {
      throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
    }
    if (m != 0)
    {
      k = Math.min(k, m);
      m -= k;
      int n = paramh.fb;
      n = paramh.fg + n;
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
  
  final boolean am()
  {
    return true;
  }
  
  public final d<?, V> an()
  {
    return this.dQ;
  }
  
  public final Object ao()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.b.c
 * JD-Core Version:    0.7.0.1
 */