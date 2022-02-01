package androidx.compose.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlinx.coroutines.e.c;
import kotlinx.coroutines.e.e;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "(Landroidx/compose/ui/unit/Density;)V", "", "getDensity", "()F", "fontScale", "getFontScale", "isCanceled", "", "isReleased", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "release", "reset", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class m
  implements l
{
  final c VA;
  boolean isCanceled;
  boolean isReleased;
  
  public m(androidx.compose.ui.n.d paramd)
  {
    AppMethodBeat.i(204199);
    this.aaW = paramd;
    this.VA = e.kEL();
    AppMethodBeat.o(204199);
  }
  
  public final Object a(kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(204227);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new a(this, paramd))
    {
      localObject2 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204227);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject1 = this;
    if (!this.isReleased)
    {
      localObject1 = this;
      if (!this.isCanceled)
      {
        localObject2 = this.VA;
        paramd.L$0 = this;
        paramd.label = 1;
        localObject1 = this;
        if (((c)localObject2).aD(paramd) == locala)
        {
          AppMethodBeat.o(204227);
          return locala;
          localObject1 = (m)paramd.L$0;
          ResultKt.throwOnFailure(localObject2);
        }
      }
    }
    boolean bool = ((m)localObject1).isReleased;
    AppMethodBeat.o(204227);
    return Boolean.valueOf(bool);
  }
  
  public final float bs(int paramInt)
  {
    AppMethodBeat.i(204220);
    float f = this.aaW.bs(paramInt);
    AppMethodBeat.o(204220);
    return f;
  }
  
  public final float mn()
  {
    AppMethodBeat.i(204222);
    float f = this.aaW.mn();
    AppMethodBeat.o(204222);
    return f;
  }
  
  public final float mo()
  {
    AppMethodBeat.i(204223);
    float f = this.aaW.mo();
    AppMethodBeat.o(204223);
    return f;
  }
  
  public final float t(long paramLong)
  {
    AppMethodBeat.i(204218);
    float f = this.aaW.t(paramLong);
    AppMethodBeat.o(204218);
    return f;
  }
  
  public final int v(float paramFloat)
  {
    AppMethodBeat.i(204205);
    int i = this.aaW.v(paramFloat);
    AppMethodBeat.o(204205);
    return i;
  }
  
  public final float w(float paramFloat)
  {
    AppMethodBeat.i(204211);
    paramFloat = this.aaW.w(paramFloat);
    AppMethodBeat.o(204211);
    return paramFloat;
  }
  
  public final long x(float paramFloat)
  {
    AppMethodBeat.i(204213);
    long l = this.aaW.x(paramFloat);
    AppMethodBeat.o(204213);
    return l;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(m paramm, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204075);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aaX.a((kotlin.d.d)this);
      AppMethodBeat.o(204075);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.m
 * JD-Core Version:    0.7.0.1
 */