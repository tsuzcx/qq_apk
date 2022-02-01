package androidx.i;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.c.a;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class a<T>
{
  final s acM;
  final c<T> acN;
  Executor acO;
  a<T> acP;
  boolean acQ;
  h<T> acR;
  h<T> acS;
  int acT;
  h.c acU;
  
  public a(RecyclerView.a parama, androidx.recyclerview.widget.h.c<T> paramc)
  {
    AppMethodBeat.i(216646);
    this.acO = androidx.a.a.a.a.eK();
    this.acU = new h.c()
    {
      public final void W(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(216639);
        a.this.acM.W(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(216639);
      }
      
      public final void X(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(216640);
        a.this.acM.c(paramAnonymousInt1, paramAnonymousInt2, null);
        AppMethodBeat.o(216640);
      }
    };
    this.acM = new b(parama);
    this.acN = new c.a(paramc).kh();
    AppMethodBeat.o(216646);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(216647);
    if (this.acR != null)
    {
      i = this.acR.size();
      AppMethodBeat.o(216647);
      return i;
    }
    if (this.acS == null)
    {
      AppMethodBeat.o(216647);
      return 0;
    }
    int i = this.acS.size();
    AppMethodBeat.o(216647);
    return i;
  }
  
  static abstract interface a<T> {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.i.a
 * JD-Core Version:    0.7.0.1
 */