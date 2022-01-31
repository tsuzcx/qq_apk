package android.support.v7.widget;

import android.database.Observable;
import java.util.ArrayList;

public final class RecyclerView$b
  extends Observable<RecyclerView.c>
{
  public final void ah(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2, null);
  }
  
  public final void ai(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).ao(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void aj(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).am(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void ak(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).an(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).d(paramInt1, paramInt2, paramObject);
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