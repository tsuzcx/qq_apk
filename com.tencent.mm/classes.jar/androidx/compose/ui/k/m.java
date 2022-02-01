package androidx.compose.ui.k;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/SemanticsModifierCore;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "id", "", "mergeDescendants", "", "clearAndSetSemantics", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "(IZZLkotlin/jvm/functions/Function1;)V", "getId", "()I", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "equals", "other", "", "hashCode", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements l
{
  public static final m.a aXg;
  private static AtomicInteger aXi;
  private final j aXh;
  private final int id;
  
  static
  {
    AppMethodBeat.i(205487);
    aXg = new m.a((byte)0);
    aXi = new AtomicInteger(0);
    AppMethodBeat.o(205487);
  }
  
  public m(int paramInt, boolean paramBoolean, b<? super u, ah> paramb)
  {
    AppMethodBeat.i(205479);
    this.id = paramInt;
    j localj = new j();
    localj.aXd = paramBoolean;
    localj.aXe = false;
    paramb.invoke(localj);
    paramb = ah.aiuX;
    this.aXh = localj;
    AppMethodBeat.o(205479);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(205532);
    l locall = (l)this;
    s.u(locall, "this");
    s.u(paramf, "other");
    paramf = f.c.a.a((f.c)locall, paramf);
    AppMethodBeat.o(205532);
    return paramf;
  }
  
  public final <R> R a(R paramR, kotlin.g.a.m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(205515);
    l locall = (l)this;
    s.u(locall, "this");
    s.u(paramm, "operation");
    paramR = f.c.a.a((f.c)locall, paramR, paramm);
    AppMethodBeat.o(205515);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(205525);
    l locall = (l)this;
    s.u(locall, "this");
    s.u(paramb, "predicate");
    boolean bool = f.c.a.a((f.c)locall, paramb);
    AppMethodBeat.o(205525);
    return bool;
  }
  
  public final <R> R b(R paramR, kotlin.g.a.m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(205519);
    l locall = (l)this;
    s.u(locall, "this");
    s.u(paramm, "operation");
    paramR = f.c.a.b((f.c)locall, paramR, paramm);
    AppMethodBeat.o(205519);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205505);
    if (this == paramObject)
    {
      AppMethodBeat.o(205505);
      return true;
    }
    if (!(paramObject instanceof m))
    {
      AppMethodBeat.o(205505);
      return false;
    }
    if (this.id != ((m)paramObject).id)
    {
      AppMethodBeat.o(205505);
      return false;
    }
    if (!s.p(this.aXh, ((m)paramObject).aXh))
    {
      AppMethodBeat.o(205505);
      return false;
    }
    AppMethodBeat.o(205505);
    return true;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205511);
    int i = this.aXh.hashCode();
    int j = this.id;
    AppMethodBeat.o(205511);
    return i * 31 + j;
  }
  
  public final j zV()
  {
    return this.aXh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.m
 * JD-Core Version:    0.7.0.1
 */