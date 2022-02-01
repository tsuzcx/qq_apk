package androidx.compose.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/Modifier;", "", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "Companion", "Element", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
{
  public static final a aud = a.aue;
  
  public abstract f a(f paramf);
  
  public abstract <R> R a(R paramR, m<? super R, ? super c, ? extends R> paramm);
  
  public abstract boolean a(b<? super c, Boolean> paramb);
  
  public abstract <R> R b(R paramR, m<? super c, ? super R, ? extends R> paramm);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/Modifier$Companion;", "Landroidx/compose/ui/Modifier;", "()V", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f
  {
    static
    {
      AppMethodBeat.i(204331);
      aue = new a();
      AppMethodBeat.o(204331);
    }
    
    public final f a(f paramf)
    {
      AppMethodBeat.i(204359);
      s.u(paramf, "other");
      AppMethodBeat.o(204359);
      return paramf;
    }
    
    public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
    {
      AppMethodBeat.i(204337);
      s.u(paramm, "operation");
      AppMethodBeat.o(204337);
      return paramR;
    }
    
    public final boolean a(b<? super f.c, Boolean> paramb)
    {
      AppMethodBeat.i(204354);
      s.u(paramb, "predicate");
      AppMethodBeat.o(204354);
      return true;
    }
    
    public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
    {
      AppMethodBeat.i(204347);
      s.u(paramm, "operation");
      AppMethodBeat.o(204347);
      return paramR;
    }
    
    public final String toString()
    {
      return "Modifier";
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static f a(f paramf1, f paramf2)
    {
      AppMethodBeat.i(204321);
      s.u(paramf1, "this");
      s.u(paramf2, "other");
      if (paramf2 == f.aud)
      {
        AppMethodBeat.o(204321);
        return paramf1;
      }
      paramf1 = (f)new c(paramf1, paramf2);
      AppMethodBeat.o(204321);
      return paramf1;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/Modifier;", "all", "", "predicate", "Lkotlin/Function1;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
    extends f
  {
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static f a(f.c paramc, f paramf)
      {
        AppMethodBeat.i(204324);
        s.u(paramc, "this");
        s.u(paramf, "other");
        paramc = f.b.a((f)paramc, paramf);
        AppMethodBeat.o(204324);
        return paramc;
      }
      
      public static <R> R a(f.c paramc, R paramR, m<? super R, ? super f.c, ? extends R> paramm)
      {
        AppMethodBeat.i(204306);
        s.u(paramc, "this");
        s.u(paramm, "operation");
        paramc = paramm.invoke(paramR, paramc);
        AppMethodBeat.o(204306);
        return paramc;
      }
      
      public static boolean a(f.c paramc, b<? super f.c, Boolean> paramb)
      {
        AppMethodBeat.i(204319);
        s.u(paramc, "this");
        s.u(paramb, "predicate");
        boolean bool = ((Boolean)paramb.invoke(paramc)).booleanValue();
        AppMethodBeat.o(204319);
        return bool;
      }
      
      public static <R> R b(f.c paramc, R paramR, m<? super f.c, ? super R, ? extends R> paramm)
      {
        AppMethodBeat.i(204311);
        s.u(paramc, "this");
        s.u(paramm, "operation");
        paramc = paramm.invoke(paramc, paramR);
        AppMethodBeat.o(204311);
        return paramc;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.f
 * JD-Core Version:    0.7.0.1
 */