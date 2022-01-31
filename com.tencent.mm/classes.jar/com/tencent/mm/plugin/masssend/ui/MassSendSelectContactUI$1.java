package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.List;

final class MassSendSelectContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MassSendSelectContactUI$1(MassSendSelectContactUI paramMassSendSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22874);
    ab.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
    paramMenuItem = bo.P((String[])MassSendSelectContactUI.a(this.oCt).toArray(new String[0]));
    if (paramMenuItem == null)
    {
      ab.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
      AppMethodBeat.o(22874);
      return false;
    }
    paramMenuItem.remove(r.Zn());
    paramMenuItem = bo.d(paramMenuItem, ";");
    Intent localIntent = new Intent(this.oCt, MassSendMsgUI.class);
    localIntent.putExtra("mass_send_contact_list", paramMenuItem);
    this.oCt.startActivity(localIntent);
    AppMethodBeat.o(22874);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */