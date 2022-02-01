package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;
import androidx.core.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

class k$a
  extends b
{
  final ActionProvider oh;
  
  public k$a(k paramk, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramContext);
    this.oh = paramActionProvider;
  }
  
  public final void b(SubMenu paramSubMenu)
  {
    AppMethodBeat.i(200854);
    this.oh.onPrepareSubMenu(this.oi.a(paramSubMenu));
    AppMethodBeat.o(200854);
  }
  
  public final View dp()
  {
    AppMethodBeat.i(200829);
    View localView = this.oh.onCreateActionView();
    AppMethodBeat.o(200829);
    return localView;
  }
  
  public final boolean dq()
  {
    AppMethodBeat.i(200838);
    boolean bool = this.oh.onPerformDefaultAction();
    AppMethodBeat.o(200838);
    return bool;
  }
  
  public final boolean hasSubMenu()
  {
    AppMethodBeat.i(200846);
    boolean bool = this.oh.hasSubMenu();
    AppMethodBeat.o(200846);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.k.a
 * JD-Core Version:    0.7.0.1
 */