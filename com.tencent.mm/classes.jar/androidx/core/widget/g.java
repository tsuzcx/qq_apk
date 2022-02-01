package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public static boolean a(ListView paramListView)
  {
    AppMethodBeat.i(195358);
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool = paramListView.canScrollList(-1);
      AppMethodBeat.o(195358);
      return bool;
    }
    if (paramListView.getChildCount() == 0)
    {
      AppMethodBeat.o(195358);
      return false;
    }
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getChildAt(0).getTop();
    if ((i > 0) || (j < paramListView.getListPaddingTop()))
    {
      AppMethodBeat.o(195358);
      return true;
    }
    AppMethodBeat.o(195358);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     androidx.core.widget.g
 * JD-Core Version:    0.7.0.1
 */