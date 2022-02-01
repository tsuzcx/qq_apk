package androidx.i;

import androidx.a.a.a.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class e<Key, Value>
{
  private Key adq;
  private h.d adr;
  private d.a<Key, Value> ads;
  private h.a adt;
  private Executor adu;
  
  public e(d.a<Key, Value> parama, h.d paramd)
  {
    AppMethodBeat.i(216654);
    this.adu = a.eL();
    if (paramd == null)
    {
      parama = new IllegalArgumentException("PagedList.Config must be provided");
      AppMethodBeat.o(216654);
      throw parama;
    }
    this.ads = parama;
    this.adr = paramd;
    AppMethodBeat.o(216654);
  }
  
  public final e<Key, Value> a(h.a<Value> parama)
  {
    this.adt = parama;
    return this;
  }
  
  public final e<Key, Value> a(Executor paramExecutor)
  {
    this.adu = paramExecutor;
    return this;
  }
  
  public final LiveData<h<Value>> jC()
  {
    AppMethodBeat.i(216656);
    final Object localObject = this.adq;
    final h.d locald = this.adr;
    final h.a locala = this.adt;
    final d.a locala1 = this.ads;
    final Executor localExecutor1 = a.eK();
    final Executor localExecutor2 = this.adu;
    localObject = new c(localExecutor2).
    {
      private d<Key, Value> adm;
      private h<Value> adv;
      private final d.b adw;
    };
    AppMethodBeat.o(216656);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.i.e
 * JD-Core Version:    0.7.0.1
 */