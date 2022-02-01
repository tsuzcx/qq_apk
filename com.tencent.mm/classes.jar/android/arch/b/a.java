package android.arch.b;

import android.support.v7.h.c;
import android.support.v7.h.c.b;
import android.support.v7.h.c.c;
import android.support.v7.h.d;
import android.support.v7.widget.RecyclerView.a;
import java.util.concurrent.Executor;

public final class a<T>
{
  final android.support.v7.f.a.a<T> dA;
  Executor dB = android.arch.a.a.a.T();
  a<T> dC;
  boolean dD;
  h<T> dE;
  h<T> dF;
  int dG;
  h.c dH = new h.c()
  {
    public final void f(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      a.this.dz.f(paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public final void g(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      a.this.dz.c(paramAnonymousInt1, paramAnonymousInt2, null);
    }
  };
  final d dz;
  
  public a(RecyclerView.a parama, c.c<T> paramc)
  {
    this.dz = new android.support.v7.h.a(parama);
    this.dA = new android.support.v7.f.a.a.a(paramc).hy();
  }
  
  public final int getItemCount()
  {
    if (this.dE != null) {
      return this.dE.size();
    }
    if (this.dF == null) {
      return 0;
    }
    return this.dF.size();
  }
  
  static abstract interface a<T> {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.a
 * JD-Core Version:    0.7.0.1
 */