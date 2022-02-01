package android.arch.b;

import android.arch.a.a.a;
import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import java.util.concurrent.Executor;

public final class e<Key, Value>
{
  private Key ec;
  private h.d ed;
  private d.a<Key, Value> ee;
  private h.a ef;
  private Executor eg = a.U();
  
  public e(d.a<Key, Value> parama, h.d paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("PagedList.Config must be provided");
    }
    this.ee = parama;
    this.ed = paramd;
  }
  
  public final e<Key, Value> a(h.a<Value> parama)
  {
    this.ef = parama;
    return this;
  }
  
  public final e<Key, Value> a(Executor paramExecutor)
  {
    this.eg = paramExecutor;
    return this;
  }
  
  public final LiveData<h<Value>> as()
  {
    final Object localObject = this.ec;
    final h.d locald = this.ed;
    final h.a locala = this.ef;
    final d.a locala1 = this.ee;
    final Executor localExecutor1 = a.T();
    final Executor localExecutor2 = this.eg;
    new ComputableLiveData(localExecutor2)
    {
      private d<Key, Value> dY;
      private h<Value> eh;
      private final d.b ei = new d.b() {};
    }.getLiveData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.e
 * JD-Core Version:    0.7.0.1
 */