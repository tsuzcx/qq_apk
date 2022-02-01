package com.google.b.b.a;

import com.google.b.a.a.a;
import com.google.b.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class d$a<V>
  implements Runnable
{
  final Future<V> dBj;
  final c<? super V> dBk;
  
  public d$a(Future<V> paramFuture, c<? super V> paramc)
  {
    this.dBj = paramFuture;
    this.dBk = paramc;
  }
  
  public final void run()
  {
    AppMethodBeat.i(208717);
    try
    {
      Object localObject1 = this.dBj;
      if (!((Future)localObject1).isDone())
      {
        localObject1 = new IllegalStateException(com.google.b.a.c.h("Future was expected to be done: %s", new Object[] { localObject1 }));
        AppMethodBeat.o(208717);
        throw ((Throwable)localObject1);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      this.dBk.onFailure(localExecutionException.getCause());
      AppMethodBeat.o(208717);
      return;
      Object localObject2 = i.b(localExecutionException);
      this.dBk.onSuccess(localObject2);
      AppMethodBeat.o(208717);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.dBk.onFailure(localRuntimeException);
      AppMethodBeat.o(208717);
      return;
    }
    catch (Error localError)
    {
      label89:
      break label89;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208719);
    Object localObject = new a.a(getClass().getSimpleName(), (byte)0);
    c localc = this.dBk;
    a.a.a locala = new a.a.a((byte)0);
    ((a.a)localObject).dAO.dAQ = locala;
    ((a.a)localObject).dAO = locala;
    locala.value = localc;
    localObject = ((a.a)localObject).toString();
    AppMethodBeat.o(208719);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */