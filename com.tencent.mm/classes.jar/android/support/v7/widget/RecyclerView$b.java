package android.support.v7.widget;

import android.database.Observable;
import java.util.ArrayList;

public final class RecyclerView$b
  extends Observable<RecyclerView.c>
{
  public final void an(int paramInt1, int paramInt2)
  {
    e(paramInt1, paramInt2, null);
  }
  
  public final void ao(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).au(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void ap(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).as(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void aq(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).at(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void e(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).f(paramInt1, paramInt2, paramObject);
      i -= 1;
    }
  }
  
  public final boolean hasObservers()
  {
    return !this.mObservers.isEmpty();
  }
  
  public final void notifyChanged()
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onChanged();
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.b
 * JD-Core Version:    0.7.0.1
 */