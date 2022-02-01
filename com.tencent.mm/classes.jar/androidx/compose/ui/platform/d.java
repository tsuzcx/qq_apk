package androidx.compose.ui.platform;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "Landroidx/compose/ui/platform/AccessibilityManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "calculateRecommendedTimeoutMillis", "", "originalTimeoutMillis", "containsIcons", "", "containsText", "containsControls", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements b
{
  private static final a aQQ;
  private final AccessibilityManager accessibilityManager;
  
  static
  {
    AppMethodBeat.i(206811);
    aQQ = new a((byte)0);
    AppMethodBeat.o(206811);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(206802);
    paramContext = paramContext.getSystemService("accessibility");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
      AppMethodBeat.o(206802);
      throw paramContext;
    }
    this.accessibilityManager = ((AccessibilityManager)paramContext);
    AppMethodBeat.o(206802);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidAccessibilityManager$Companion;", "", "()V", "FlagContentControls", "", "FlagContentIcons", "FlagContentText", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.platform.d
 * JD-Core Version:    0.7.0.1
 */