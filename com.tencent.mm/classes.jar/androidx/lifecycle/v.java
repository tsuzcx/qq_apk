package androidx.lifecycle;

import androidx.a.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public class v<T>
  extends x<T>
{
  private b<LiveData<?>, a<?>> bHP;
  
  public v()
  {
    AppMethodBeat.i(194350);
    this.bHP = new b();
    AppMethodBeat.o(194350);
  }
  
  protected final void Hf()
  {
    AppMethodBeat.i(194372);
    Iterator localIterator = this.bHP.iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).Hm();
    }
    AppMethodBeat.o(194372);
  }
  
  protected final void Hk()
  {
    AppMethodBeat.i(194375);
    Iterator localIterator = this.bHP.iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).Hn();
    }
    AppMethodBeat.o(194375);
  }
  
  public <S> void a(LiveData<S> paramLiveData, y<? super S> paramy)
  {
    AppMethodBeat.i(194357);
    a locala = new a(paramLiveData, paramy);
    paramLiveData = (a)this.bHP.putIfAbsent(paramLiveData, locala);
    if ((paramLiveData != null) && (paramLiveData.mObserver != paramy))
    {
      paramLiveData = new IllegalArgumentException("This source was already added with the different observer");
      AppMethodBeat.o(194357);
      throw paramLiveData;
    }
    if (paramLiveData != null)
    {
      AppMethodBeat.o(194357);
      return;
    }
    if (Hl()) {
      locala.Hm();
    }
    AppMethodBeat.o(194357);
  }
  
  public final <S> void b(LiveData<S> paramLiveData)
  {
    AppMethodBeat.i(194367);
    paramLiveData = (a)this.bHP.remove(paramLiveData);
    if (paramLiveData != null) {
      paramLiveData.Hn();
    }
    AppMethodBeat.o(194367);
  }
  
  static final class a<V>
    implements y<V>
  {
    final LiveData<V> bGX;
    int bHI = -1;
    final y<? super V> mObserver;
    
    a(LiveData<V> paramLiveData, y<? super V> paramy)
    {
      this.bGX = paramLiveData;
      this.mObserver = paramy;
    }
    
    final void Hm()
    {
      AppMethodBeat.i(194342);
      this.bGX.a(this);
      AppMethodBeat.o(194342);
    }
    
    final void Hn()
    {
      AppMethodBeat.i(194345);
      this.bGX.b(this);
      AppMethodBeat.o(194345);
    }
    
    public final void onChanged(V paramV)
    {
      AppMethodBeat.i(194351);
      if (this.bHI != this.bGX.bHI)
      {
        this.bHI = this.bGX.bHI;
        this.mObserver.onChanged(paramV);
      }
      AppMethodBeat.o(194351);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.v
 * JD-Core Version:    0.7.0.1
 */