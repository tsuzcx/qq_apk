package androidx.compose.ui.g.b;

import androidx.compose.ui.d.e;
import androidx.compose.ui.n.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.d<-Landroidx.compose.ui.n.r;>;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "()V", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui_release", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "originNestedScrollScope", "getOriginNestedScrollScope$ui_release", "setOriginNestedScrollScope$ui_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setParent$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "dispatchPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPreScroll", "dispatchPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final int Ue = 8;
  aq aKA;
  a aKB;
  kotlin.g.a.a<? extends aq> aKz;
  
  public d()
  {
    AppMethodBeat.i(205736);
    this.aKz = ((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(205736);
  }
  
  public final long b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(205766);
    Object localObject = this.aKB;
    if (localObject == null)
    {
      localObject = e.avo;
      paramLong1 = e.su();
      AppMethodBeat.o(205766);
      return paramLong1;
    }
    paramLong1 = ((a)localObject).a(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(205766);
    return paramLong1;
  }
  
  public final Object b(long paramLong1, long paramLong2, kotlin.d.d<? super r> paramd)
  {
    AppMethodBeat.i(205786);
    if ((paramd instanceof b))
    {
      localObject = (b)paramd;
      if ((((b)localObject).label & 0x80000000) != 0) {
        ((b)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super r>)localObject;; paramd = new b(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205786);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = this.aKB;
    if (localObject == null) {
      paramd = r.beY;
    }
    for (paramLong1 = r.su();; paramLong1 = ((r)paramd).avp)
    {
      paramd = r.bs(paramLong1);
      AppMethodBeat.o(205786);
      return paramd;
      paramd.label = 1;
      localObject = ((a)localObject).a(paramLong1, paramLong2, paramd);
      paramd = (kotlin.d.d<? super r>)localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(205786);
        return locala;
        ResultKt.throwOnFailure(localObject);
        paramd = (kotlin.d.d<? super r>)localObject;
      }
    }
  }
  
  public final Object c(long paramLong, kotlin.d.d<? super r> paramd)
  {
    AppMethodBeat.i(205777);
    if ((paramd instanceof c))
    {
      localObject = (c)paramd;
      if ((((c)localObject).label & 0x80000000) != 0) {
        ((c)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super r>)localObject;; paramd = new c(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205777);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = this.aKB;
    if (localObject == null) {
      paramd = r.beY;
    }
    for (paramLong = r.su();; paramLong = ((r)paramd).avp)
    {
      paramd = r.bs(paramLong);
      AppMethodBeat.o(205777);
      return paramd;
      paramd.label = 1;
      localObject = ((a)localObject).a(paramLong, paramd);
      paramd = (kotlin.d.d<? super r>)localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(205777);
        return locala;
        ResultKt.throwOnFailure(localObject);
        paramd = (kotlin.d.d<? super r>)localObject;
      }
    }
  }
  
  public final long e(long paramLong, int paramInt)
  {
    AppMethodBeat.i(205761);
    Object localObject = this.aKB;
    if (localObject == null)
    {
      localObject = e.avo;
      paramLong = e.su();
      AppMethodBeat.o(205761);
      return paramLong;
    }
    paramLong = ((a)localObject).b(paramLong, paramInt);
    AppMethodBeat.o(205761);
    return paramLong;
  }
  
  public final aq wd()
  {
    AppMethodBeat.i(205754);
    Object localObject = (aq)this.aKz.invoke();
    if (localObject == null)
    {
      localObject = new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
      AppMethodBeat.o(205754);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(205754);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<aq>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    int label;
    
    b(d paramd, kotlin.d.d<? super b> paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(205715);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aKC.b(0L, 0L, (kotlin.d.d)this);
      AppMethodBeat.o(205715);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    int label;
    
    c(d paramd, kotlin.d.d<? super c> paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(205711);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aKC.c(0L, (kotlin.d.d)this);
      AppMethodBeat.o(205711);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.b.d
 * JD-Core Version:    0.7.0.1
 */