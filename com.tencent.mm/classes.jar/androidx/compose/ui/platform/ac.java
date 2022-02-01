package androidx.compose.ui.platform;

import androidx.compose.runtime.as;
import androidx.compose.runtime.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"LocalInspectionMode", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalInspectionMode", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ac
{
  private static final as<Boolean> aUp;
  
  static
  {
    AppMethodBeat.i(206750);
    aUp = q.e((a)a.aUq);
    AppMethodBeat.o(206750);
  }
  
  public static final as<Boolean> zj()
  {
    return aUp;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Boolean>
  {
    public static final a aUq;
    
    static
    {
      AppMethodBeat.i(206542);
      aUq = new a();
      AppMethodBeat.o(206542);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.platform.ac
 * JD-Core Version:    0.7.0.1
 */