package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

public final class k
  extends a
{
  private final ListView KT;
  
  public k(ListView paramListView)
  {
    super(paramListView);
    this.KT = paramListView;
  }
  
  public final void aC(int paramInt)
  {
    ListView localListView = this.KT;
    if (Build.VERSION.SDK_INT >= 19) {
      localListView.scrollListBy(paramInt);
    }
    int i;
    View localView;
    do
    {
      do
      {
        return;
        i = localListView.getFirstVisiblePosition();
      } while (i == -1);
      localView = localListView.getChildAt(0);
    } while (localView == null);
    localListView.setSelectionFromTop(i, localView.getTop() - paramInt);
  }
  
  public final boolean aD(int paramInt)
  {
    ListView localListView = this.KT;
    int i = localListView.getCount();
    if (i == 0) {}
    int j;
    int k;
    do
    {
      return false;
      j = localListView.getChildCount();
      k = localListView.getFirstVisiblePosition();
      if (paramInt <= 0) {
        break;
      }
    } while ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight()));
    do
    {
      return true;
      if (paramInt >= 0) {
        break;
      }
    } while ((k > 0) || (localListView.getChildAt(0).getTop() < 0));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.k
 * JD-Core Version:    0.7.0.1
 */