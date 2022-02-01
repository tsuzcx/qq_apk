package androidx.compose.runtime.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"AutoSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "Saver", "Original", "Saveable", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "autoSaver", "T", "runtime-saveable_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final i<Object, Object> asi;
  
  static
  {
    AppMethodBeat.i(202926);
    asi = b((m)a.asj, (b)b.ask);
    AppMethodBeat.o(202926);
  }
  
  public static final <Original, Saveable> i<Original, Saveable> b(m<? super k, ? super Original, ? extends Saveable> paramm, final b<? super Saveable, ? extends Original> paramb)
  {
    AppMethodBeat.i(202913);
    s.u(paramm, "save");
    s.u(paramb, "restore");
    paramm = (i)new c(paramm, paramb);
    AppMethodBeat.o(202913);
    return paramm;
  }
  
  public static final <T> i<T, Object> re()
  {
    return asi;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<k, Object, Object>
  {
    public static final a asj;
    
    static
    {
      AppMethodBeat.i(202948);
      asj = new a();
      AppMethodBeat.o(202948);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Object, Object>
  {
    public static final b ask;
    
    static
    {
      AppMethodBeat.i(202942);
      ask = new b();
      AppMethodBeat.o(202942);
    }
    
    b()
    {
      super();
    }
    
    public final Object invoke(Object paramObject)
    {
      AppMethodBeat.i(202950);
      s.u(paramObject, "it");
      AppMethodBeat.o(202950);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/runtime/saveable/SaverKt$Saver$1", "Landroidx/compose/runtime/saveable/Saver;", "restore", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "(Landroidx/compose/runtime/saveable/SaverScope;Ljava/lang/Object;)Ljava/lang/Object;", "runtime-saveable_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i<Original, Saveable>
  {
    c(m<? super k, ? super Original, ? extends Saveable> paramm, b<? super Saveable, ? extends Original> paramb) {}
    
    public final Saveable a(k paramk, Original paramOriginal)
    {
      AppMethodBeat.i(202945);
      s.u(paramk, "<this>");
      paramk = this.arI.invoke(paramk, paramOriginal);
      AppMethodBeat.o(202945);
      return paramk;
    }
    
    public final Original ai(Saveable paramSaveable)
    {
      AppMethodBeat.i(202953);
      s.u(paramSaveable, "value");
      paramSaveable = paramb.invoke(paramSaveable);
      AppMethodBeat.o(202953);
      return paramSaveable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.e.j
 * JD-Core Version:    0.7.0.1
 */