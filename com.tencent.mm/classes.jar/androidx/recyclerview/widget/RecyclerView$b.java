package androidx.recyclerview.widget;

import android.database.Observable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class RecyclerView$b
  extends Observable<RecyclerView.c>
{
  public final void aE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262097);
    e(paramInt1, paramInt2, null);
    AppMethodBeat.o(262097);
  }
  
  public final void aF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262109);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
      i -= 1;
    }
    AppMethodBeat.o(262109);
  }
  
  public final void aG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262103);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
      i -= 1;
    }
    AppMethodBeat.o(262103);
  }
  
  public final void aH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262106);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
      i -= 1;
    }
    AppMethodBeat.o(262106);
  }
  
  public final void e(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(262101);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
      i -= 1;
    }
    AppMethodBeat.o(262101);
  }
  
  public final boolean hasObservers()
  {
    AppMethodBeat.i(262091);
    if (!this.mObservers.isEmpty())
    {
      AppMethodBeat.o(262091);
      return true;
    }
    AppMethodBeat.o(262091);
    return false;
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(262095);
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.c)this.mObservers.get(i)).onChanged();
      i -= 1;
    }
    AppMethodBeat.o(262095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.b
 * JD-Core Version:    0.7.0.1
 */