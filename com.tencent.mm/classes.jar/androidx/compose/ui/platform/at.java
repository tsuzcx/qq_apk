package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy;", "", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "Companion", "DisposeOnDetachedFromWindow", "DisposeOnLifecycleDestroyed", "DisposeOnViewTreeLifecycleDestroyed", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface at
{
  public static final a aVl = a.aVm;
  
  public abstract a<ah> a(AbstractComposeView paramAbstractComposeView);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy$Companion;", "", "()V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(206576);
      aVm = new a();
      AppMethodBeat.o(206576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.platform.at
 * JD-Core Version:    0.7.0.1
 */