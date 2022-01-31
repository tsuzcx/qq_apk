package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import java.util.HashSet;

final class AASelectContactUI$4
  implements MenuItem.OnMenuItemClickListener
{
  AASelectContactUI$4(AASelectContactUI paramAASelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40754);
    if ((AASelectContactUI.b(this.gpV) != null) && (AASelectContactUI.b(this.gpV).size() > 0) && (AASelectContactUI.b(this.gpV).size() <= AASelectContactUI.d(this.gpV)) && ((AASelectContactUI.b(this.gpV).size() != 1) || (!AASelectContactUI.b(this.gpV).contains(r.Zn())))) {
      com.tencent.mm.ui.base.h.a(this.gpV, this.gpV.getString(2131296384), null, this.gpV.getString(2131296388), this.gpV.getString(2131296387), false, new AASelectContactUI.4.1(this), new AASelectContactUI.4.2(this));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(7) });
      AppMethodBeat.o(40754);
      return true;
      this.gpV.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.4
 * JD-Core Version:    0.7.0.1
 */