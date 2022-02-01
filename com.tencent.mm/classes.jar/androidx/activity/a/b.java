package androidx.activity.a;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.c;
import androidx.compose.runtime.as;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.h;
import androidx.compose.runtime.p;
import androidx.compose.runtime.q;
import androidx.compose.ui.platform.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/activity/compose/LocalOnBackPressedDispatcherOwner;", "", "()V", "LocalOnBackPressedDispatcherOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/OnBackPressedDispatcherOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "dispatcherOwner", "activity-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b eL;
  private static final as<c> eM;
  
  static
  {
    AppMethodBeat.i(199216);
    eL = new b();
    a locala = (a)b.a.eN;
    eM = q.a(bj.qi(), locala);
    AppMethodBeat.o(199216);
  }
  
  public static c a(h paramh)
  {
    AppMethodBeat.i(199210);
    paramh.bx(1680121376);
    Object localObject = (c)paramh.a((p)eM);
    if (localObject == null)
    {
      paramh.bx(1680121441);
      localObject = (Context)paramh.a((p)j.yJ());
      if ((localObject instanceof ContextWrapper)) {
        if ((localObject instanceof c))
        {
          label71:
          localObject = (c)localObject;
          paramh.od();
        }
      }
    }
    for (;;)
    {
      paramh.od();
      AppMethodBeat.o(199210);
      return localObject;
      localObject = ((ContextWrapper)localObject).getBaseContext();
      s.s(localObject, "innerContext.baseContext");
      break;
      localObject = null;
      break label71;
      paramh.bx(1680121384);
      paramh.od();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.activity.a.b
 * JD-Core Version:    0.7.0.1
 */