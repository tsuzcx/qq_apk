package androidx.compose.runtime.e;

import androidx.compose.runtime.aa;
import androidx.compose.runtime.as;
import androidx.compose.runtime.at;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.q;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "savedStates", "", "", "", "", "", "(Ljava/util/Map;)V", "parentSaveableStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getParentSaveableStateRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "setParentSaveableStateRegistry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "registryHolders", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$RegistryHolder;", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "removeState", "saveAll", "Companion", "RegistryHolder", "runtime-saveable_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c
{
  private static final i<d, ?> ZG;
  public static final d.a arN;
  private final Map<Object, Map<String, List<Object>>> arO;
  private final Map<Object, d> arP;
  public f arQ;
  
  static
  {
    AppMethodBeat.i(202977);
    arN = new d.a((byte)0);
    ZG = j.b((m)b.arR, (b)c.arS);
    AppMethodBeat.o(202977);
  }
  
  public d(Map<Object, Map<String, List<Object>>> paramMap)
  {
    AppMethodBeat.i(202938);
    this.arO = paramMap;
    this.arP = ((Map)new LinkedHashMap());
    AppMethodBeat.o(202938);
  }
  
  public final void a(final Object paramObject, final m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, final androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(202991);
    s.u(paramObject, "key");
    s.u(paramm, "content");
    androidx.compose.runtime.h localh = paramh.by(-111644091);
    localh.bx(-1530021272);
    localh.E(paramObject);
    localh.bx(1516495192);
    localh.bx(-3687241);
    Object localObject = localh.or();
    paramh = androidx.compose.runtime.h.alD;
    paramh = localObject;
    if (localObject == h.a.ox())
    {
      paramh = this.arQ;
      if (paramh == null) {}
      for (boolean bool = true; !bool; bool = paramh.ah(paramObject))
      {
        paramObject = (Throwable)new IllegalArgumentException(("Type of the key " + paramObject + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
        AppMethodBeat.o(202991);
        throw paramObject;
      }
      paramh = new d(paramObject);
      localh.F(paramh);
    }
    localh.od();
    paramh = (d)paramh;
    q.a(new at[] { h.rd().N(paramh.arU) }, paramm, localh, paramInt & 0x70 | 0x8);
    aa.a(ah.aiuX, (b)new e(this, paramObject, paramh), localh);
    localh.od();
    localh.oo();
    localh.od();
    paramh = localh.oh();
    if (paramh != null) {
      paramh.b((m)new f(this, paramObject, paramm, paramInt));
    }
    AppMethodBeat.o(202991);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "", "", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<k, d, Map<Object, Map<String, ? extends List<? extends Object>>>>
  {
    public static final b arR;
    
    static
    {
      AppMethodBeat.i(202954);
      arR = new b();
      AppMethodBeat.o(202954);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "it", "", "", "", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Map<Object, Map<String, ? extends List<? extends Object>>>, d>
  {
    public static final c arS;
    
    static
    {
      AppMethodBeat.i(202956);
      arS = new c();
      AppMethodBeat.o(202956);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$RegistryHolder;", "", "key", "(Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "registry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "shouldSave", "", "getShouldSave", "()Z", "setShouldSave", "(Z)V", "saveTo", "", "map", "", "", "", "", "runtime-saveable_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
  {
    private boolean arT;
    final f arU;
    private final Object key;
    
    public d()
    {
      AppMethodBeat.i(202974);
      this.key = localObject;
      this.arT = true;
      this.arU = h.a((Map)d.a(d.this).get(this.key), (b)new a(d.this));
      AppMethodBeat.o(202974);
    }
    
    public final void c(Map<Object, Map<String, List<Object>>> paramMap)
    {
      AppMethodBeat.i(202981);
      s.u(paramMap, "map");
      if (this.arT) {
        paramMap.put(this.key, this.arU.rc());
      }
      AppMethodBeat.o(202981);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<Object, Boolean>
    {
      a(d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<y, x>
  {
    e(d paramd, Object paramObject, d.d paramd1)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(d.d paramd, d paramd1, Object paramObject) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(202901);
        this.arX.c(d.a(this.arV));
        d.b(this.arV).remove(this.arY);
        AppMethodBeat.o(202901);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    f(d paramd, Object paramObject, m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.e.d
 * JD-Core Version:    0.7.0.1
 */