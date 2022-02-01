package android.arch.b;

import android.arch.a.a.a;
import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import java.util.concurrent.Executor;

public final class e<Key, Value>
{
  private Key ed;
  private h.d ee;
  private d.a<Key, Value> ef;
  private h.a eg;
  private Executor eh = a.R();
  
  public e(d.a<Key, Value> parama, h.d paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("PagedList.Config must be provided");
    }
    this.ef = parama;
    this.ee = paramd;
  }
  
  public final e<Key, Value> a(h.a<Value> parama)
  {
    this.eg = parama;
    return this;
  }
  
  public final e<Key, Value> a(Executor paramExecutor)
  {
    this.eh = paramExecutor;
    return this;
  }
  
  public final LiveData<h<Value>> aq()
  {
    final Object localObject = this.ed;
    final h.d locald = this.ee;
    final h.a locala = this.eg;
    final d.a locala1 = this.ef;
    final Executor localExecutor1 = a.Q();
    final Executor localExecutor2 = this.eh;
    new ComputableLiveData(localExecutor2)
    {
      private d<Key, Value> dZ;
      private h<Value> ei;
      private final d.b ej = new d.b() {};
    }.getLiveData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.b.e
 * JD-Core Version:    0.7.0.1
 */