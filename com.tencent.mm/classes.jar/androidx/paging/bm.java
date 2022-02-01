package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.d.a.a;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.h;
import kotlinx.coroutines.a.k;
import kotlinx.coroutines.a.p;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/TemporaryDownstream;", "T", "", "()V", "historyChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "close", "", "consumeHistory", "Lkotlinx/coroutines/flow/Flow;", "send", "", "event", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
final class bm<T>
{
  final h<ae<ag<T>>> bRA;
  
  public bm()
  {
    AppMethodBeat.i(196998);
    this.bRA = k.a(2147483647, null, 6);
    AppMethodBeat.o(196998);
  }
  
  public final Object b(ae<? extends ag<T>> paramae, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(197001);
    Object localObject1;
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new a(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramae = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(197001);
        throw paramae;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    try
    {
      localObject2 = this.bRA;
      paramd.label = 1;
      paramae = ((h)localObject2).b(paramae, paramd);
      if (paramae == localObject1)
      {
        AppMethodBeat.o(197001);
        return localObject1;
        ResultKt.throwOnFailure(localObject2);
      }
      i = 1;
    }
    catch (p paramae)
    {
      for (;;)
      {
        int i = 0;
        continue;
        boolean bool = false;
      }
    }
    if (i != 0)
    {
      bool = true;
      AppMethodBeat.o(197001);
      return Boolean.valueOf(bool);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(197008);
    ((ab)this.bRA).k(null);
    AppMethodBeat.o(197008);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"send", "", "T", "event", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
  static final class a
    extends kotlin.d.b.a.d
  {
    int label;
    
    a(bm parambm, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196898);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.bRB.b(null, this);
      AppMethodBeat.o(196898);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.bm
 * JD-Core Version:    0.7.0.1
 */