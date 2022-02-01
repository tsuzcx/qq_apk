package androidx.recyclerview.widget;

import android.database.Observable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class RecyclerView$b
  extends Observable<RecyclerView.c>
{
  public final void bA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195048);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
      i -= 1;
    }
    AppMethodBeat.o(195048);
  }
  
  public final void bB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195053);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
      i -= 1;
    }
    AppMethodBeat.o(195053);
  }
  
  public final void by(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195037);
    e(paramInt1, paramInt2, null);
    AppMethodBeat.o(195037);
  }
  
  public final void bz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195058);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
      i -= 1;
    }
    AppMethodBeat.o(195058);
  }
  
  public final void e(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(195043);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
      i -= 1;
    }
    AppMethodBeat.o(195043);
  }
  
  public final boolean hasObservers()
  {
    AppMethodBeat.i(195024);
    if (!this.mObservers.isEmpty())
    {
      AppMethodBeat.o(195024);
      return true;
    }
    AppMethodBeat.o(195024);
    return false;
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(195029);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onChanged();
      i -= 1;
    }
    AppMethodBeat.o(195029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.b
 * JD-Core Version:    0.7.0.1
 */