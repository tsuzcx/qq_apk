package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.List;

final class MassSendSelectContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MassSendSelectContactUI$1(MassSendSelectContactUI paramMassSendSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
    paramMenuItem = bk.G((String[])MassSendSelectContactUI.a(this.mbS).toArray(new String[0]));
    if (paramMenuItem == null)
    {
      y.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
      return false;
    }
    paramMenuItem.remove(q.Gj());
    paramMenuItem = bk.c(paramMenuItem, ";");
    Intent localIntent = new Intent(this.mbS, MassSendMsgUI.class);
    localIntent.putExtra("mass_send_contact_list", paramMenuItem);
    this.mbS.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */