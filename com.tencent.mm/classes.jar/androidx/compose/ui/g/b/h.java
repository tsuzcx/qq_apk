package androidx.compose.ui.g.b;

import androidx.compose.ui.d.e;
import androidx.compose.ui.n.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.d<-Landroidx.compose.ui.n.r;>;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/nestedscroll/ParentWrapperNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "parent", "self", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getParent", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setParent", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getSelf", "setSelf", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h
  implements a
{
  a aKB;
  a aKP;
  
  public h(a parama1, a parama2)
  {
    AppMethodBeat.i(205732);
    this.aKB = parama1;
    this.aKP = parama2;
    AppMethodBeat.o(205732);
  }
  
  public final long a(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(205744);
    long l = this.aKP.a(paramLong1, paramLong2, paramInt);
    paramLong1 = e.g(l, this.aKB.a(e.g(paramLong1, l), e.f(paramLong2, l), paramInt));
    AppMethodBeat.o(205744);
    return paramLong1;
  }
  
  public final Object a(long paramLong1, long paramLong2, kotlin.d.d<? super r> paramd)
  {
    AppMethodBeat.i(205762);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super r>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205762);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = this.aKP;
    paramd.L$0 = this;
    paramd.Yx = paramLong1;
    paramd.aKQ = paramLong2;
    paramd.label = 1;
    Object localObject2 = ((a)localObject1).a(paramLong1, paramLong2, paramd);
    localObject1 = localObject2;
    h localh = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(205762);
      return locala;
      paramLong2 = paramd.aKQ;
      paramLong1 = paramd.Yx;
      localh = (h)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    long l = ((r)localObject1).avp;
    localObject1 = localh.aKB;
    paramLong1 = r.u(paramLong1, l);
    paramLong2 = r.t(paramLong2, l);
    paramd.L$0 = null;
    paramd.Yx = l;
    paramd.label = 2;
    localObject1 = ((a)localObject1).a(paramLong1, paramLong2, paramd);
    if (localObject1 == locala)
    {
      AppMethodBeat.o(205762);
      return locala;
      paramLong1 = paramd.Yx;
      ResultKt.throwOnFailure(localObject1);
    }
    for (;;)
    {
      paramd = r.bs(r.u(paramLong1, ((r)localObject1).avp));
      AppMethodBeat.o(205762);
      return paramd;
      paramLong1 = l;
    }
  }
  
  public final Object a(long paramLong, kotlin.d.d<? super r> paramd)
  {
    AppMethodBeat.i(205756);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super r>)localObject1;; paramd = new b(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205756);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = this.aKB;
    paramd.L$0 = this;
    paramd.Yx = paramLong;
    paramd.label = 1;
    Object localObject2 = ((a)localObject1).a(paramLong, paramd);
    localObject1 = localObject2;
    h localh = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(205756);
      return locala;
      paramLong = paramd.Yx;
      localh = (h)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    long l = ((r)localObject1).avp;
    localObject1 = localh.aKP;
    paramLong = r.t(paramLong, l);
    paramd.L$0 = null;
    paramd.Yx = l;
    paramd.label = 2;
    localObject1 = ((a)localObject1).a(paramLong, paramd);
    if (localObject1 == locala)
    {
      AppMethodBeat.o(205756);
      return locala;
      paramLong = paramd.Yx;
      ResultKt.throwOnFailure(localObject1);
    }
    for (;;)
    {
      paramd = r.bs(r.u(paramLong, ((r)localObject1).avp));
      AppMethodBeat.o(205756);
      return paramd;
      paramLong = l;
    }
  }
  
  public final long b(long paramLong, int paramInt)
  {
    AppMethodBeat.i(205741);
    long l = this.aKB.b(paramLong, paramInt);
    paramLong = e.g(l, this.aKP.b(e.f(paramLong, l), paramInt));
    AppMethodBeat.o(205741);
    return paramLong;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    long Yx;
    long aKQ;
    int label;
    
    a(h paramh, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(205737);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aKR.a(0L, 0L, (kotlin.d.d)this);
      AppMethodBeat.o(205737);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    long Yx;
    int label;
    
    b(h paramh, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(205740);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aKR.a(0L, (kotlin.d.d)this);
      AppMethodBeat.o(205740);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.b.h
 * JD-Core Version:    0.7.0.1
 */