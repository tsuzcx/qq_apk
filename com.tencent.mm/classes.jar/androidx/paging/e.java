package androidx.paging;

import androidx.a.a.a.a;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.c.a;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.g.c;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class e<T>
{
  public final q bKL;
  public final c<T> bKM;
  Executor bKN;
  a<T> bKO;
  public boolean bKP;
  public ap<T> bKQ;
  public ap<T> bKR;
  public int bKS;
  public ap.c bKT;
  
  public e(RecyclerView.a parama, g.c<T> paramc)
  {
    AppMethodBeat.i(197067);
    this.bKN = a.fH();
    this.bKT = new ap.c()
    {
      public final void aR(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(196699);
        e.this.bKL.aR(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(196699);
      }
      
      public final void aS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(196705);
        e.this.bKL.aS(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(196705);
      }
      
      public final void fc(int paramAnonymousInt)
      {
        AppMethodBeat.i(196709);
        e.this.bKL.c(0, paramAnonymousInt, null);
        AppMethodBeat.o(196709);
      }
    };
    this.bKL = new b(parama);
    this.bKM = new c.a(paramc).IS();
    AppMethodBeat.o(197067);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(197075);
    if (this.bKQ != null)
    {
      i = this.bKQ.size();
      AppMethodBeat.o(197075);
      return i;
    }
    if (this.bKR == null)
    {
      AppMethodBeat.o(197075);
      return 0;
    }
    int i = this.bKR.size();
    AppMethodBeat.o(197075);
    return i;
  }
  
  static abstract interface a<T> {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.e
 * JD-Core Version:    0.7.0.1
 */