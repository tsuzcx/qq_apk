package androidx.camera.camera2.b;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$a<T>
  extends v<T>
{
  private LiveData<T> Bv;
  private T Bw;
  
  i$a(T paramT)
  {
    this.Bw = paramT;
  }
  
  final void a(LiveData<T> paramLiveData)
  {
    AppMethodBeat.i(197940);
    if (this.Bv != null) {
      super.b(this.Bv);
    }
    this.Bv = paramLiveData;
    super.a(paramLiveData, new i.a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(197940);
  }
  
  public final <S> void a(LiveData<S> paramLiveData, y<? super S> paramy)
  {
    AppMethodBeat.i(197949);
    paramLiveData = new UnsupportedOperationException();
    AppMethodBeat.o(197949);
    throw paramLiveData;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(197963);
    if (this.Bv == null)
    {
      localObject = this.Bw;
      AppMethodBeat.o(197963);
      return localObject;
    }
    Object localObject = this.Bv.getValue();
    AppMethodBeat.o(197963);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.camera.camera2.b.i.a
 * JD-Core Version:    0.7.0.1
 */