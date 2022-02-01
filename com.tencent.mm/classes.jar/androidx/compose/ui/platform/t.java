package androidx.compose.ui.platform;

import androidx.compose.runtime.c.c;
import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t aTq;
  public static m<h, Integer, ah> agS;
  
  static
  {
    AppMethodBeat.i(206763);
    aTq = new t();
    agS = (m)c.a(-985537952, false, a.aTr);
    AppMethodBeat.o(206763);
  }
  
  public static m<h, Integer, ah> wE()
  {
    return agS;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<h, Integer, ah>
  {
    public static final a aTr;
    
    static
    {
      AppMethodBeat.i(206541);
      aTr = new a();
      AppMethodBeat.o(206541);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.t
 * JD-Core Version:    0.7.0.1
 */