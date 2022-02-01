package androidx.appcompat.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$d
  extends d<MenuItem.OnMenuItemClickListener>
  implements MenuItem.OnMenuItemClickListener
{
  k$d(k paramk, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200826);
    boolean bool = ((MenuItem.OnMenuItemClickListener)this.mr).onMenuItemClick(this.oi.b(paramMenuItem));
    AppMethodBeat.o(200826);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.k.d
 * JD-Core Version:    0.7.0.1
 */