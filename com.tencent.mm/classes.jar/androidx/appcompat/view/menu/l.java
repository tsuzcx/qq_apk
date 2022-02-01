package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;
import androidx.core.a.a.b;
import androidx.core.g.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
  extends k
{
  l(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  final k.a a(ActionProvider paramActionProvider)
  {
    AppMethodBeat.i(239740);
    paramActionProvider = new a(this.mContext, paramActionProvider);
    AppMethodBeat.o(239740);
    return paramActionProvider;
  }
  
  final class a
    extends k.a
    implements ActionProvider.VisibilityListener
  {
    b.b no;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public final void a(b.b paramb)
    {
      AppMethodBeat.i(239734);
      this.no = paramb;
      this.nl.setVisibilityListener(this);
      AppMethodBeat.o(239734);
    }
    
    public final View c(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(239726);
      paramMenuItem = this.nl.onCreateActionView(paramMenuItem);
      AppMethodBeat.o(239726);
      return paramMenuItem;
    }
    
    public final boolean cy()
    {
      AppMethodBeat.i(239729);
      boolean bool = this.nl.overridesItemVisibility();
      AppMethodBeat.o(239729);
      return bool;
    }
    
    public final boolean isVisible()
    {
      AppMethodBeat.i(239732);
      boolean bool = this.nl.isVisible();
      AppMethodBeat.o(239732);
      return bool;
    }
    
    public final void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(239735);
      if (this.no != null) {
        this.no.cv();
      }
      AppMethodBeat.o(239735);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.l
 * JD-Core Version:    0.7.0.1
 */