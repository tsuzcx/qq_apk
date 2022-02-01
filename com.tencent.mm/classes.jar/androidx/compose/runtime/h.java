package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Composer;", "", "applier", "Landroidx/compose/runtime/Applier;", "getApplier$annotations", "()V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData$annotations", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compoundKeyHash", "", "getCompoundKeyHash$annotations", "getCompoundKeyHash", "()I", "defaultsInvalid", "", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "()Z", "inserting", "getInserting$annotations", "getInserting", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope$annotations", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "skipping", "getSkipping$annotations", "getSkipping", "apply", "", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "Landroidx/compose/runtime/CompositionContext;", "changed", "", "", "", "", "", "", "collectParameterInformation", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "Lkotlin/Function0;", "disableReusing", "enableReusing", "endDefaults", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "joinKey", "left", "right", "recordSideEffect", "effect", "recordUsed", "scope", "rememberedValue", "skipCurrentGroup", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "startDefaults", "startMovableGroup", "dataKey", "startNode", "startProviders", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "updateRememberedValue", "useNode", "Companion", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
{
  public static final a alD = a.alE;
  
  public abstract void E(Object paramObject);
  
  public abstract void F(Object paramObject);
  
  public abstract boolean G(Object paramObject);
  
  public abstract boolean H(float paramFloat);
  
  public abstract <T> T a(p<T> paramp);
  
  public abstract void a(au paramau);
  
  public abstract <T> void a(kotlin.g.a.a<? extends T> parama);
  
  public abstract void a(at<?>[] paramArrayOfat);
  
  public abstract boolean am(boolean paramBoolean);
  
  public abstract void b(kotlin.g.a.a<ah> parama);
  
  public abstract void bx(int paramInt);
  
  public abstract h by(int paramInt);
  
  public abstract boolean bz(int paramInt);
  
  public abstract <V, T> void c(V paramV, m<? super T, ? super V, ah> paramm);
  
  public abstract void i(int paramInt, Object paramObject);
  
  public abstract d<?> nX();
  
  public abstract boolean nY();
  
  public abstract boolean nZ();
  
  public abstract boolean oa();
  
  public abstract au ob();
  
  public abstract int oc();
  
  public abstract void od();
  
  public abstract void oe();
  
  public abstract void of();
  
  public abstract void og();
  
  public abstract ba oh();
  
  public abstract void oi();
  
  public abstract void oj();
  
  public abstract void ok();
  
  public abstract void ol();
  
  public abstract void om();
  
  public abstract void on();
  
  public abstract void oo();
  
  public abstract void op();
  
  public abstract void oq();
  
  public abstract Object or();
  
  public abstract void os();
  
  public abstract androidx.compose.runtime.g.a ot();
  
  public abstract void ou();
  
  public abstract l ov();
  
  public abstract f ow();
  
  public abstract boolean y(long paramLong);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/Composer$Companion;", "", "()V", "Empty", "getEmpty", "()Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final Object alF;
    
    static
    {
      AppMethodBeat.i(202385);
      alE = new a();
      alF = new a();
      AppMethodBeat.o(202385);
    }
    
    public static Object ox()
    {
      return alF;
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/Composer$Companion$Empty$1", "", "toString", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public final String toString()
      {
        return "Empty";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.h
 * JD-Core Version:    0.7.0.1
 */