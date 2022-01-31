package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.s;
import java.util.HashSet;
import java.util.List;

final class AASelectContactUI$1
  implements View.OnClickListener
{
  AASelectContactUI$1(AASelectContactUI paramAASelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    if (AASelectContactUI.a(this.eXY).isChecked()) {
      if (AASelectContactUI.b(this.eXY) != null)
      {
        AASelectContactUI.b(this.eXY).clear();
        AASelectContactUI.a(this.eXY).setChecked(false);
        this.eXY.cHE().notifyDataSetChanged();
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
      return;
      AASelectContactUI.a(this.eXY, new HashSet());
      break;
      paramView = com.tencent.mm.plugin.aa.a.h.pr(AASelectContactUI.c(this.eXY));
      if (paramView.size() > AASelectContactUI.d(this.eXY)) {
        com.tencent.mm.ui.base.h.a(this.eXY.mController.uMN, this.eXY.getString(a.i.aa_select_contact_exceed_alert, new Object[] { Long.valueOf(AASelectContactUI.d(this.eXY)) }), "", new AASelectContactUI.1.1(this, paramView), new AASelectContactUI.1.2(this));
      } else {
        AASelectContactUI.a(this.eXY, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */