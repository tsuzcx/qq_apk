package androidx.compose.ui.platform;

import androidx.compose.ui.i.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/node/RootForTest;", "hasPendingMeasureOrLayout", "", "getHasPendingMeasureOrLayout", "()Z", "isLifecycleInResumedState", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "invalidateDescendants", "", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface az
  extends ae
{
  public static final a aVF = a.aVG;
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewRootForTest$Companion;", "", "()V", "onViewCreatedCallback", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/ViewRootForTest;", "", "getOnViewCreatedCallback$annotations", "getOnViewCreatedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnViewCreatedCallback", "(Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static b<? super az, ah> aVH;
    
    static
    {
      AppMethodBeat.i(206551);
      aVG = new a();
      AppMethodBeat.o(206551);
    }
    
    public static b<az, ah> zw()
    {
      return aVH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.platform.az
 * JD-Core Version:    0.7.0.1
 */