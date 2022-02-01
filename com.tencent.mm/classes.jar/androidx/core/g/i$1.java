package androidx.core.g;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i$1
  implements MenuItem.OnActionExpandListener
{
  public i$1(i.a parama) {}
  
  public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(195866);
    boolean bool = this.btp.Ee();
    AppMethodBeat.o(195866);
    return bool;
  }
  
  public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(195855);
    boolean bool = this.btp.Ed();
    AppMethodBeat.o(195855);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.g.i.1
 * JD-Core Version:    0.7.0.1
 */