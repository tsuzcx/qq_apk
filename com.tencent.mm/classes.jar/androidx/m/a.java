package androidx.m;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static <T extends View> T L(View paramView, int paramInt)
  {
    AppMethodBeat.i(192429);
    if (!(paramView instanceof ViewGroup))
    {
      AppMethodBeat.o(192429);
      return null;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramView.getChildAt(i).findViewById(paramInt);
      if (localView != null)
      {
        AppMethodBeat.o(192429);
        return localView;
      }
      i += 1;
    }
    AppMethodBeat.o(192429);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.m.a
 * JD-Core Version:    0.7.0.1
 */