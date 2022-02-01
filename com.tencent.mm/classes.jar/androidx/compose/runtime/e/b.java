package androidx.compose.runtime.e;

import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "", "inner", "rememberSaveable", "inputs", "", "saver", "key", "", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "stateSaver", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "requireCanBeSaved", "", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "value", "runtime-saveable_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final <T> T a(final Object[] paramArrayOfObject, final i<T, ? extends Object> parami, a<? extends T> parama, androidx.compose.runtime.h paramh, int paramInt)
  {
    AppMethodBeat.i(202946);
    s.u(paramArrayOfObject, "inputs");
    s.u(parama, "init");
    paramh.bx(1059366159);
    Object localObject = parami;
    if ((paramInt & 0x2) != 0) {
      localObject = j.re();
    }
    paramh.bx(1059366467);
    final String str = String.valueOf(paramh.oc());
    paramh.od();
    if (localObject == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
      AppMethodBeat.o(202946);
      throw paramArrayOfObject;
    }
    f localf = (f)paramh.a((p)h.rd());
    paramArrayOfObject = Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length);
    paramh.bx(-3685570);
    int j = paramArrayOfObject.length;
    paramInt = 0;
    int i = 0;
    while (i < j)
    {
      parami = paramArrayOfObject[i];
      i += 1;
      paramInt = paramh.G(parami) | paramInt;
    }
    paramArrayOfObject = paramh.or();
    if (paramInt == 0)
    {
      parami = androidx.compose.runtime.h.alD;
      parami = paramArrayOfObject;
      if (paramArrayOfObject != h.a.ox()) {}
    }
    else
    {
      if (localf != null) {
        break label337;
      }
      paramArrayOfObject = null;
      parami = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        parami = parama.invoke();
      }
      paramh.F(parami);
    }
    paramh.od();
    paramh.bx(-3687241);
    parama = paramh.or();
    paramArrayOfObject = androidx.compose.runtime.h.alD;
    paramArrayOfObject = parama;
    if (parama == h.a.ox())
    {
      paramArrayOfObject = bj.T(localObject);
      paramh.F(paramArrayOfObject);
    }
    paramh.od();
    paramArrayOfObject = (an)paramArrayOfObject;
    paramArrayOfObject.setValue(localObject);
    if (localf != null)
    {
      paramh.bx(1059367381);
      aa.a(localf, str, parami, (kotlin.g.a.b)new a(localf, str, paramArrayOfObject, parami), paramh);
      paramh.od();
    }
    for (;;)
    {
      paramh.od();
      AppMethodBeat.o(202946);
      return parami;
      label337:
      paramArrayOfObject = localf.aj(str);
      if (paramArrayOfObject == null)
      {
        paramArrayOfObject = null;
        break;
      }
      paramArrayOfObject = ((i)localObject).ai(paramArrayOfObject);
      break;
      paramh.bx(1059367799);
      paramh.od();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<y, x>
  {
    a(f paramf, String paramString, an<i<T, Object>> paraman, T paramT)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(f.a parama) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(202973);
        this.arM.unregister();
        AppMethodBeat.o(202973);
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<Object>
    {
      b(an<i<T, Object>> paraman, T paramT, f paramf)
      {
        super();
      }
      
      public final Object invoke()
      {
        AppMethodBeat.i(202958);
        Object localObject1 = this.arL.getValue();
        Object localObject2 = this.amI;
        f localf = this.arJ;
        localObject1 = ((i)localObject1).a((k)new a(localf), localObject2);
        AppMethodBeat.o(202958);
        return localObject1;
      }
      
      @Metadata(k=3, mv={1, 5, 1}, xi=48)
      static final class a
        implements k
      {
        a(f paramf) {}
        
        public final boolean ah(Object paramObject)
        {
          AppMethodBeat.i(202994);
          s.u(paramObject, "it");
          boolean bool = this.arJ.ah(paramObject);
          AppMethodBeat.o(202994);
          return bool;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.e.b
 * JD-Core Version:    0.7.0.1
 */