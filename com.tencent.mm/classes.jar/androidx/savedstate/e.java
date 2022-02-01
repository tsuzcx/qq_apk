package androidx.savedstate;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public static void b(View paramView, d paramd)
  {
    AppMethodBeat.i(193337);
    paramView.setTag(a.a.view_tree_saved_state_registry_owner, paramd);
    AppMethodBeat.o(193337);
  }
  
  public static d bP(View paramView)
  {
    AppMethodBeat.i(193343);
    d locald = (d)paramView.getTag(a.a.view_tree_saved_state_registry_owner);
    if (locald != null)
    {
      AppMethodBeat.o(193343);
      return locald;
    }
    for (;;)
    {
      paramView = paramView.getParent();
      if ((locald == null) && ((paramView instanceof View)))
      {
        paramView = (View)paramView;
        locald = (d)paramView.getTag(a.a.view_tree_saved_state_registry_owner);
      }
      else
      {
        AppMethodBeat.o(193343);
        return locald;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.savedstate.e
 * JD-Core Version:    0.7.0.1
 */