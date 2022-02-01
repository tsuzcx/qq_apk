package android.arch.b;

import android.support.v7.h.c;
import android.support.v7.h.c.b;
import android.support.v7.h.c.c;
import android.support.v7.h.d;
import android.support.v7.widget.RecyclerView.a;
import java.util.concurrent.Executor;

public final class a<T>
{
  final d dA;
  final android.support.v7.f.a.a<T> dB;
  Executor dC = android.arch.a.a.a.Q();
  a<T> dD;
  boolean dE;
  h<T> dF;
  h<T> dG;
  int dH;
  h.c dI = new h.c()
  {
    public final void f(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      a.this.dA.f(paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public final void g(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      a.this.dA.c(paramAnonymousInt1, paramAnonymousInt2, null);
    }
  };
  
  public a(RecyclerView.a parama, c.c<T> paramc)
  {
    this.dA = new android.support.v7.h.a(parama);
    this.dB = new android.support.v7.f.a.a.a(paramc).hp();
  }
  
  public final int getItemCount()
  {
    if (this.dF != null) {
      return this.dF.size();
    }
    if (this.dG == null) {
      return 0;
    }
    return this.dG.size();
  }
  
  static abstract interface a<T> {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.b.a
 * JD-Core Version:    0.7.0.1
 */