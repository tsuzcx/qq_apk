package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCustomSheetDialog;", "Lcom/tencent/mm/ui/widget/dialog/CustomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "shouldWindowCloseOnTouchOutside", "", "show", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends b
{
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(344606);
    AppMethodBeat.o(344606);
  }
  
  public final boolean fku()
  {
    return true;
  }
  
  public final void show()
  {
    AppMethodBeat.i(344614);
    if (isLandscape())
    {
      localObject = getWindow();
      if (localObject != null) {
        ((Window)localObject).setFlags(1024, 1024);
      }
      localObject = getWindow();
      if (localObject != null) {
        break label62;
      }
    }
    label62:
    for (Object localObject = null;; localObject = ((Window)localObject).getDecorView())
    {
      if (localObject != null) {
        ((View)localObject).setSystemUiVisibility(6);
      }
      super.show();
      AppMethodBeat.o(344614);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.g
 * JD-Core Version:    0.7.0.1
 */