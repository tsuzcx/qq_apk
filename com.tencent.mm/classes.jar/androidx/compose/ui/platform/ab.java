package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"NoInspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "getNoInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "isDebugInspectorInfoEnabled", "", "()Z", "setDebugInspectorInfoEnabled", "(Z)V", "debugInspectorInfo", "definitions", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ab
{
  private static final b<ad, ah> aUm = (b)a.aUo;
  static boolean aUn;
  
  public static final b<ad, ah> zh()
  {
    return aUm;
  }
  
  public static final boolean zi()
  {
    return aUn;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<ad, ah>
  {
    public static final a aUo;
    
    static
    {
      AppMethodBeat.i(206683);
      aUo = new a();
      AppMethodBeat.o(206683);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.platform.ab
 * JD-Core Version:    0.7.0.1
 */