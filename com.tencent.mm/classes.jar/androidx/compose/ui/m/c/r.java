package androidx.compose.ui.m.c;

import androidx.compose.runtime.e.i;
import androidx.compose.runtime.e.j;
import androidx.compose.runtime.e.k;
import androidx.compose.ui.m.a;
import androidx.compose.ui.m.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/TextFieldValue;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/String;", "copy", "copy-3r_uNRQ", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  private static final i<r, Object> ZG;
  public static final r.a bdf;
  public final a aYS;
  public final long bdg;
  private final androidx.compose.ui.m.s bdh;
  
  static
  {
    AppMethodBeat.i(205305);
    bdf = new r.a((byte)0);
    ZG = j.b((m)b.bdi, (b)c.bdj);
    AppMethodBeat.o(205305);
  }
  
  private r(a parama, long paramLong, androidx.compose.ui.m.s params)
  {
    AppMethodBeat.i(205282);
    this.aYS = parama;
    this.bdg = t.f(paramLong, this.aYS.text.length());
    if (params == null) {}
    for (parama = null;; parama = androidx.compose.ui.m.s.aS(t.f(params.avp, this.aYS.text.length())))
    {
      this.bdh = parama;
      AppMethodBeat.o(205282);
      return;
    }
  }
  
  private r(String paramString, long paramLong, androidx.compose.ui.m.s params)
  {
    this(new a(paramString, null, null, 6), paramLong, null, (byte)0);
    AppMethodBeat.i(205292);
    AppMethodBeat.o(205292);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205308);
    if (this == paramObject)
    {
      AppMethodBeat.o(205308);
      return true;
    }
    if (!(paramObject instanceof r))
    {
      AppMethodBeat.o(205308);
      return false;
    }
    if ((androidx.compose.ui.m.s.e(this.bdg, ((r)paramObject).bdg)) && (kotlin.g.b.s.p(this.bdh, ((r)paramObject).bdh)) && (kotlin.g.b.s.p(this.aYS, ((r)paramObject).aYS)))
    {
      AppMethodBeat.o(205308);
      return true;
    }
    AppMethodBeat.o(205308);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205312);
    int j = this.aYS.hashCode();
    int k = androidx.compose.ui.m.s.I(this.bdg);
    androidx.compose.ui.m.s locals = this.bdh;
    if (locals == null) {}
    for (int i = 0;; i = androidx.compose.ui.m.s.I(locals.avp))
    {
      AppMethodBeat.o(205312);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205318);
    String str = "TextFieldValue(text='" + this.aYS + "', selection=" + androidx.compose.ui.m.s.H(this.bdg) + ", composition=" + this.bdh + ')';
    AppMethodBeat.o(205318);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<k, r, Object>
  {
    public static final b bdi;
    
    static
    {
      AppMethodBeat.i(205271);
      bdi = new b();
      AppMethodBeat.o(205271);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/text/input/TextFieldValue;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Object, r>
  {
    public static final c bdj;
    
    static
    {
      AppMethodBeat.i(205263);
      bdj = new c();
      AppMethodBeat.o(205263);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.c.r
 * JD-Core Version:    0.7.0.1
 */