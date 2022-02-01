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
    AppMethodBeat.i(200876);
    paramActionProvider = new a(this.mContext, paramActionProvider);
    AppMethodBeat.o(200876);
    return paramActionProvider;
  }
  
  final class a
    extends k.a
    implements ActionProvider.VisibilityListener
  {
    b.b ok;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public final void a(b.b paramb)
    {
      AppMethodBeat.i(201083);
      this.ok = paramb;
      this.oh.setVisibilityListener(this);
      AppMethodBeat.o(201083);
    }
    
    public final View c(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201060);
      paramMenuItem = this.oh.onCreateActionView(paramMenuItem);
      AppMethodBeat.o(201060);
      return paramMenuItem;
    }
    
    public final boolean dr()
    {
      AppMethodBeat.i(201069);
      boolean bool = this.oh.overridesItemVisibility();
      AppMethodBeat.o(201069);
      return bool;
    }
    
    public final boolean isVisible()
    {
      AppMethodBeat.i(201077);
      boolean bool = this.oh.isVisible();
      AppMethodBeat.o(201077);
      return bool;
    }
    
    public final void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(201091);
      if (this.ok != null) {
        this.ok.jdMethod_do();
      }
      AppMethodBeat.o(201091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.l
 * JD-Core Version:    0.7.0.1
 */