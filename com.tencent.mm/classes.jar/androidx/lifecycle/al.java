package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class al
{
  public static void a(View paramView, q paramq)
  {
    AppMethodBeat.i(194411);
    paramView.setTag(a.a.view_tree_lifecycle_owner, paramq);
    AppMethodBeat.o(194411);
  }
  
  public static q be(View paramView)
  {
    AppMethodBeat.i(194418);
    q localq = (q)paramView.getTag(a.a.view_tree_lifecycle_owner);
    if (localq != null)
    {
      AppMethodBeat.o(194418);
      return localq;
    }
    for (;;)
    {
      paramView = paramView.getParent();
      if ((localq == null) && ((paramView instanceof View)))
      {
        paramView = (View)paramView;
        localq = (q)paramView.getTag(a.a.view_tree_lifecycle_owner);
      }
      else
      {
        AppMethodBeat.o(194418);
        return localq;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.al
 * JD-Core Version:    0.7.0.1
 */