package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  private final ListView Qg;
  
  public f(ListView paramListView)
  {
    super(paramListView);
    this.Qg = paramListView;
  }
  
  public final void bH(int paramInt)
  {
    AppMethodBeat.i(252572);
    ListView localListView = this.Qg;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localListView.scrollListBy(paramInt);
      AppMethodBeat.o(252572);
      return;
    }
    int i = localListView.getFirstVisiblePosition();
    if (i != -1)
    {
      View localView = localListView.getChildAt(0);
      if (localView != null) {
        localListView.setSelectionFromTop(i, localView.getTop() - paramInt);
      }
    }
    AppMethodBeat.o(252572);
  }
  
  public final boolean bI(int paramInt)
  {
    AppMethodBeat.i(252574);
    ListView localListView = this.Qg;
    int i = localListView.getCount();
    if (i == 0)
    {
      AppMethodBeat.o(252574);
      return false;
    }
    int j = localListView.getChildCount();
    int k = localListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      if ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight()))
      {
        AppMethodBeat.o(252574);
        return false;
      }
    }
    else if (paramInt < 0)
    {
      if ((k <= 0) && (localListView.getChildAt(0).getTop() >= 0))
      {
        AppMethodBeat.o(252574);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(252574);
      return false;
    }
    AppMethodBeat.o(252574);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     androidx.core.widget.f
 * JD-Core Version:    0.7.0.1
 */