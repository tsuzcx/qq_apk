package androidx.appcompat.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$c
  extends d<MenuItem.OnActionExpandListener>
  implements MenuItem.OnActionExpandListener
{
  k$c(k paramk, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200835);
    boolean bool = ((MenuItem.OnActionExpandListener)this.mr).onMenuItemActionCollapse(this.oi.b(paramMenuItem));
    AppMethodBeat.o(200835);
    return bool;
  }
  
  public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200825);
    boolean bool = ((MenuItem.OnActionExpandListener)this.mr).onMenuItemActionExpand(this.oi.b(paramMenuItem));
    AppMethodBeat.o(200825);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.k.c
 * JD-Core Version:    0.7.0.1
 */