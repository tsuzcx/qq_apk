package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  private final ListView bwx;
  
  public f(ListView paramListView)
  {
    super(paramListView);
    this.bwx = paramListView;
  }
  
  public final boolean Fd()
  {
    return false;
  }
  
  public final void eC(int paramInt)
  {
    AppMethodBeat.i(195376);
    ListView localListView = this.bwx;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localListView.scrollListBy(paramInt);
      AppMethodBeat.o(195376);
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
    AppMethodBeat.o(195376);
  }
  
  public final boolean eD(int paramInt)
  {
    AppMethodBeat.i(195397);
    ListView localListView = this.bwx;
    int i = localListView.getCount();
    if (i == 0)
    {
      AppMethodBeat.o(195397);
      return false;
    }
    int j = localListView.getChildCount();
    int k = localListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      if ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight()))
      {
        AppMethodBeat.o(195397);
        return false;
      }
    }
    else if (paramInt < 0)
    {
      if ((k <= 0) && (localListView.getChildAt(0).getTop() >= 0))
      {
        AppMethodBeat.o(195397);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(195397);
      return false;
    }
    AppMethodBeat.o(195397);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.widget.f
 * JD-Core Version:    0.7.0.1
 */