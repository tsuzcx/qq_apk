package androidx.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

final class c<K, V>
  extends h<V>
{
  private final b<K, V> adc;
  private boolean ade;
  private boolean adf;
  private int adg;
  private int adh;
  private g.a<V> adi;
  
  c(b<K, V> paramb, Executor paramExecutor1, Executor paramExecutor2, h.a<V> parama, h.d paramd, K paramK, int paramInt)
  {
    super(new j(), paramExecutor1, paramExecutor2, parama, paramd);
    AppMethodBeat.i(219454);
    this.ade = false;
    this.adf = false;
    this.adg = 0;
    this.adh = 0;
    this.adi = new g.a() {};
    this.adc = paramb;
    this.adU = -1;
    if (this.adc.ZF.get())
    {
      detach();
      AppMethodBeat.o(219454);
      return;
    }
    this.adc.a(this.adr.aeg, this.adr.aef, this.acO, this.adi);
    AppMethodBeat.o(219454);
  }
  
  final void a(h<V> paramh, h.c paramc)
  {
    AppMethodBeat.i(219465);
    paramh = paramh.adT;
    int m = this.adT.aeu - paramh.aeu;
    int j = this.adT.aet - paramh.aet;
    int k = paramh.aeq;
    int i = paramh.aeo;
    if ((paramh.isEmpty()) || (m < 0) || (j < 0) || (this.adT.aeq != Math.max(k - m, 0)) || (this.adT.aeo != Math.max(i - j, 0)) || (this.adT.aes != paramh.aes + m + j))
    {
      paramh = new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
      AppMethodBeat.o(219465);
      throw paramh;
    }
    if (m != 0)
    {
      k = Math.min(k, m);
      m -= k;
      int n = paramh.aeo;
      n = paramh.aes + n;
      if (k != 0) {
        paramc.X(n, k);
      }
      if (m != 0) {
        paramc.W(n + k, m);
      }
    }
    if (j != 0)
    {
      k = Math.min(i, j);
      j -= k;
      if (k != 0) {
        paramc.X(i, k);
      }
      if (j != 0) {
        paramc.W(0, j);
      }
    }
    AppMethodBeat.o(219465);
  }
  
  public final Object jA()
  {
    return null;
  }
  
  final boolean jy()
  {
    return true;
  }
  
  public final d<?, V> jz()
  {
    return this.adc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.i.c
 * JD-Core Version:    0.7.0.1
 */