package androidx.compose.a.a;

import androidx.compose.runtime.am;
import androidx.compose.ui.platform.aa;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"withInfiniteAnimationFrameMillis", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeMillis", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withInfiniteAnimationFrameNanos", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class af
{
  public static final <R> Object a(b<? super Long, ? extends R> paramb, d<? super R> paramd)
  {
    AppMethodBeat.i(203366);
    aa localaa = (aa)paramd.getContext().get((f.c)aa.aUk);
    if (localaa == null)
    {
      paramb = am.b(paramb, paramd);
      AppMethodBeat.o(203366);
      return paramb;
    }
    new a(paramb, null);
    paramb = localaa.zg();
    AppMethodBeat.o(203366);
    return paramb;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "R"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements b<d<? super R>, Object>
  {
    int label;
    
    a(b<? super Long, ? extends R> paramb, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(d<?> paramd)
    {
      AppMethodBeat.i(203240);
      paramd = (d)new a(this.Vb, paramd);
      AppMethodBeat.o(203240);
      return paramd;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203228);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203228);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Vb;
        Object localObject = (d)this;
        this.label = 1;
        localObject = am.b(paramObject, (d)localObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(203228);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      AppMethodBeat.o(203228);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.af
 * JD-Core Version:    0.7.0.1
 */