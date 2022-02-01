package androidx.lifecycle;

import androidx.a.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public final class p<T>
  extends r<T>
{
  private b<LiveData<?>, a<?>> aav;
  
  public p()
  {
    AppMethodBeat.i(247963);
    this.aav = new b();
    AppMethodBeat.o(247963);
  }
  
  public final <S> void a(LiveData<S> paramLiveData)
  {
    AppMethodBeat.i(247968);
    paramLiveData = (a)this.aav.remove(paramLiveData);
    if (paramLiveData != null) {
      paramLiveData.jk();
    }
    AppMethodBeat.o(247968);
  }
  
  public final <S> void a(LiveData<S> paramLiveData, s<? super S> params)
  {
    AppMethodBeat.i(247966);
    a locala = new a(paramLiveData, params);
    paramLiveData = (a)this.aav.putIfAbsent(paramLiveData, locala);
    if ((paramLiveData != null) && (paramLiveData.aat != params))
    {
      paramLiveData = new IllegalArgumentException("This source was already added with the different observer");
      AppMethodBeat.o(247966);
      throw paramLiveData;
    }
    if (paramLiveData != null)
    {
      AppMethodBeat.o(247966);
      return;
    }
    if (ji()) {
      locala.jj();
    }
    AppMethodBeat.o(247966);
  }
  
  protected final void jb()
  {
    AppMethodBeat.i(247969);
    Iterator localIterator = this.aav.iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).jj();
    }
    AppMethodBeat.o(247969);
  }
  
  protected final void jh()
  {
    AppMethodBeat.i(247971);
    Iterator localIterator = this.aav.iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).jk();
    }
    AppMethodBeat.o(247971);
  }
  
  static final class a<V>
    implements s<V>
  {
    final LiveData<V> ZE;
    int aan = -1;
    final s<? super V> aat;
    
    a(LiveData<V> paramLiveData, s<? super V> params)
    {
      this.ZE = paramLiveData;
      this.aat = params;
    }
    
    final void jj()
    {
      AppMethodBeat.i(247957);
      this.ZE.a(this);
      AppMethodBeat.o(247957);
    }
    
    final void jk()
    {
      AppMethodBeat.i(247958);
      this.ZE.b(this);
      AppMethodBeat.o(247958);
    }
    
    public final void onChanged(V paramV)
    {
      AppMethodBeat.i(247959);
      if (this.aan != this.ZE.aan)
      {
        this.aan = this.ZE.aan;
        this.aat.onChanged(paramV);
      }
      AppMethodBeat.o(247959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.lifecycle.p
 * JD-Core Version:    0.7.0.1
 */