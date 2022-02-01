package androidx.compose.ui.platform;

import androidx.compose.runtime.e.f;
import androidx.compose.runtime.e.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/DisposableSaveableStateRegistry;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "saveableStateRegistry", "onDispose", "Lkotlin/Function0;", "", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Lkotlin/jvm/functions/Function0;)V", "canBeSaved", "", "value", "", "consumeRestored", "key", "", "dispose", "performSave", "", "", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  implements f
{
  final a<ah> aUb;
  
  public w(f paramf, a<ah> parama)
  {
    AppMethodBeat.i(206792);
    this.aUb = parama;
    this.aUc = paramf;
    AppMethodBeat.o(206792);
  }
  
  public final f.a a(String paramString, a<? extends Object> parama)
  {
    AppMethodBeat.i(206842);
    s.u(paramString, "key");
    s.u(parama, "valueProvider");
    paramString = this.aUc.a(paramString, parama);
    AppMethodBeat.o(206842);
    return paramString;
  }
  
  public final boolean ah(Object paramObject)
  {
    AppMethodBeat.i(206807);
    s.u(paramObject, "value");
    boolean bool = this.aUc.ah(paramObject);
    AppMethodBeat.o(206807);
    return bool;
  }
  
  public final Object aj(String paramString)
  {
    AppMethodBeat.i(206818);
    s.u(paramString, "key");
    paramString = this.aUc.aj(paramString);
    AppMethodBeat.o(206818);
    return paramString;
  }
  
  public final Map<String, List<Object>> rc()
  {
    AppMethodBeat.i(206833);
    Map localMap = this.aUc.rc();
    AppMethodBeat.o(206833);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.w
 * JD-Core Version:    0.7.0.1
 */