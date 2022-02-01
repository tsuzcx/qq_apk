package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

final class MassSendSelectContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MassSendSelectContactUI$1(MassSendSelectContactUI paramMassSendSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26498);
    Log.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
    paramMenuItem = Util.stringsToList((String[])MassSendSelectContactUI.a(this.zoz).toArray(new String[0]));
    if (paramMenuItem == null)
    {
      Log.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
      AppMethodBeat.o(26498);
      return false;
    }
    paramMenuItem.remove(z.aTY());
    Object localObject = Util.listToString(paramMenuItem, ";");
    paramMenuItem = new Intent(this.zoz, MassSendMsgUI.class);
    paramMenuItem.putExtra("mass_send_contact_list", (String)localObject);
    localObject = this.zoz;
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMenuItem.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MassSendSelectContactUI)localObject).startActivity((Intent)paramMenuItem.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26498);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */