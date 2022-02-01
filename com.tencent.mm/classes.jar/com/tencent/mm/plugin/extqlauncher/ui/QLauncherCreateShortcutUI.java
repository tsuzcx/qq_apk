package com.tencent.mm.plugin.extqlauncher.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.u;
import java.util.List;

public class QLauncherCreateShortcutUI
  extends MMBaseActivity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24568);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      finish();
      AppMethodBeat.o(24568);
      return;
    }
    switch (paramInt1)
    {
    }
    do
    {
      finish();
      AppMethodBeat.o(24568);
      return;
    } while (paramIntent == null);
    if (!bc.ajM())
    {
      ae.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
      Toast.makeText(this, 2131758673, 0).show();
      finish();
      AppMethodBeat.o(24568);
      return;
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (!bu.isNullOrNil(paramIntent)) {}
    for (paramIntent = bu.U(paramIntent.split(","));; paramIntent = null)
    {
      for (;;)
      {
        if ((paramIntent == null) || (paramIntent.size() <= 0))
        {
          ae.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
          break;
        }
        ae.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + paramIntent.size());
        String str1 = v.aAC();
        try
        {
          ContentValues[] arrayOfContentValues = new ContentValues[paramIntent.size()];
          paramInt1 = 0;
          while (paramInt1 < paramIntent.size())
          {
            bc.aCg();
            Object localObject = com.tencent.mm.model.c.azF().BH((String)paramIntent.get(paramInt1));
            if ((localObject == null) || ((int)((com.tencent.mm.contact.c)localObject).ght <= 0))
            {
              ae.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
              finish();
              AppMethodBeat.o(24568);
              return;
            }
            String str2 = com.tencent.mm.plugin.base.model.b.Xf((String)paramIntent.get(paramInt1));
            if (bu.isNullOrNil(str2))
            {
              ae.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
              finish();
              AppMethodBeat.o(24568);
              return;
            }
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("source_key", com.tencent.mm.plugin.base.model.b.SOURCE_KEY);
            localContentValues.put("owner_id", com.tencent.mm.plugin.base.model.b.Xf(str1));
            localContentValues.put("unique_id", str2);
            localContentValues.put("container", Integer.valueOf(1));
            localContentValues.put("item_type", Integer.valueOf(com.tencent.mm.plugin.base.model.b.Q((an)localObject)));
            localContentValues.put("name", w.b((an)localObject, (String)paramIntent.get(paramInt1)));
            p.aEA();
            localContentValues.put("icon_path", e.K((String)paramIntent.get(paramInt1), false));
            localObject = new Intent("com.tencent.mm.action.BIZSHORTCUT");
            ((Intent)localObject).putExtra("LauncherUI.Shortcut.Username", str2);
            ((Intent)localObject).putExtra("LauncherUI.From.Biz.Shortcut", true);
            ((Intent)localObject).addFlags(67108864);
            localContentValues.put("intent", ((Intent)localObject).toUri(0));
            arrayOfContentValues[paramInt1] = localContentValues;
            paramInt1 += 1;
          }
          getContentResolver().bulkInsert(a.rnv, arrayOfContentValues);
          Toast.makeText(this, 2131758674, 0).show();
          com.tencent.mm.plugin.extqlauncher.b.cua().cub();
        }
        catch (Exception paramIntent)
        {
          ae.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[] { paramIntent.getMessage() });
          ae.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", paramIntent, "", new Object[0]);
          Toast.makeText(this, 2131758673, 0).show();
        }
      }
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24567);
    super.onCreate(paramBundle);
    ae.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
    requestWindowFeature(1);
    setContentView(2131493674);
    paramBundle = new Intent();
    int i = u.J(new int[] { u.KJQ, 64, 16384 });
    u.kb(i, 1);
    paramBundle.putExtra("list_attr", i);
    paramBundle.putExtra("list_type", 12);
    paramBundle.putExtra("stay_in_wechat", false);
    paramBundle.putExtra("titile", getString(2131755234));
    paramBundle.putExtra("block_contact", v.aAC());
    d.c(this, ".ui.contact.SelectContactUI", paramBundle, 1);
    AppMethodBeat.o(24567);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.ui.QLauncherCreateShortcutUI
 * JD-Core Version:    0.7.0.1
 */