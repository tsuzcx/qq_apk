package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

final class AASelectContactUI$3
  implements MenuItem.OnMenuItemClickListener
{
  AASelectContactUI$3(AASelectContactUI paramAASelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40751);
    if (AASelectContactUI.b(this.gpV).size() > AASelectContactUI.d(this.gpV))
    {
      com.tencent.mm.ui.base.h.b(this.gpV.getContext(), this.gpV.getString(2131301037, new Object[] { Long.valueOf(AASelectContactUI.d(this.gpV)) }), "", true);
      com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
      com.tencent.mm.plugin.report.service.h.qsU.e(13722, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(40751);
      return true;
    }
    if (AASelectContactUI.b(this.gpV).size() <= 0)
    {
      com.tencent.mm.ui.base.h.b(this.gpV.getContext(), this.gpV.getString(2131296389, new Object[] { Integer.valueOf(1) }), "", true);
      com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(9) });
      AppMethodBeat.o(40751);
      return true;
    }
    paramMenuItem = new LinkedList();
    paramMenuItem.addAll(AASelectContactUI.b(this.gpV));
    paramMenuItem = bo.d(paramMenuItem, ",");
    this.gpV.setResult(-1, this.gpV.getIntent().putExtra("Select_Contact", paramMenuItem));
    this.gpV.finish();
    this.gpV.hideVKB();
    com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
    AppMethodBeat.o(40751);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */