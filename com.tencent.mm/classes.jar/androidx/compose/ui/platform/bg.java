package androidx.compose.ui.platform;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/WrapperVerificationHelperMethods;", "", "()V", "attributeSourceResourceMap", "", "", "view", "Landroid/view/View;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
{
  public static final bg aWd;
  
  static
  {
    AppMethodBeat.i(206789);
    aWd = new bg();
    AppMethodBeat.o(206789);
  }
  
  public final Map<Integer, Integer> B(View paramView)
  {
    AppMethodBeat.i(206801);
    s.u(paramView, "view");
    paramView = paramView.getAttributeSourceResourceMap();
    s.s(paramView, "view.attributeSourceResourceMap");
    AppMethodBeat.o(206801);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.platform.bg
 * JD-Core Version:    0.7.0.1
 */