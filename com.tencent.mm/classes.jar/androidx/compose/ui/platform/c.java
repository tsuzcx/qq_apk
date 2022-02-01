package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AccessibilityNodeInfoVerificationHelperMethods;", "", "()V", "setAvailableExtraData", "", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "data", "", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c aQP;
  
  static
  {
    AppMethodBeat.i(206823);
    aQP = new c();
    AppMethodBeat.o(206823);
  }
  
  public final void a(AccessibilityNodeInfo paramAccessibilityNodeInfo, List<String> paramList)
  {
    AppMethodBeat.i(206831);
    s.u(paramAccessibilityNodeInfo, "node");
    s.u(paramList, "data");
    paramAccessibilityNodeInfo.setAvailableExtraData(paramList);
    AppMethodBeat.o(206831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.c
 * JD-Core Version:    0.7.0.1
 */