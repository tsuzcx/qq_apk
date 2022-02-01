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
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
    Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[] { Integer.valueOf(paramInt2) });
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
    if (!bg.aAc())
    {
      Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
      Toast.makeText(this, 2131758979, 0).show();
      finish();
      AppMethodBeat.o(24568);
      return;
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (!Util.isNullOrNil(paramIntent)) {}
    for (paramIntent = Util.stringsToList(paramIntent.split(","));; paramIntent = null)
    {
      for (;;)
      {
        if ((paramIntent == null) || (paramIntent.size() <= 0))
        {
          Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
          break;
        }
        Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + paramIntent.size());
        String str1 = z.aTY();
        try
        {
          ContentValues[] arrayOfContentValues = new ContentValues[paramIntent.size()];
          paramInt1 = 0;
          while (paramInt1 < paramIntent.size())
          {
            bg.aVF();
            Object localObject = com.tencent.mm.model.c.aSN().Kn((String)paramIntent.get(paramInt1));
            if ((localObject == null) || ((int)((com.tencent.mm.contact.c)localObject).gMZ <= 0))
            {
              Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
              finish();
              AppMethodBeat.o(24568);
              return;
            }
            String str2 = com.tencent.mm.plugin.base.model.b.agZ((String)paramIntent.get(paramInt1));
            if (Util.isNullOrNil(str2))
            {
              Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
              finish();
              AppMethodBeat.o(24568);
              return;
            }
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("source_key", com.tencent.mm.plugin.base.model.b.SOURCE_KEY);
            localContentValues.put("owner_id", com.tencent.mm.plugin.base.model.b.agZ(str1));
            localContentValues.put("unique_id", str2);
            localContentValues.put("container", Integer.valueOf(1));
            localContentValues.put("item_type", Integer.valueOf(com.tencent.mm.plugin.base.model.b.Q((as)localObject)));
            localContentValues.put("name", aa.b((as)localObject, (String)paramIntent.get(paramInt1)));
            p.aYn();
            localContentValues.put("icon_path", e.M((String)paramIntent.get(paramInt1), false));
            localObject = new Intent("com.tencent.mm.action.BIZSHORTCUT");
            ((Intent)localObject).putExtra("LauncherUI.Shortcut.Username", str2);
            ((Intent)localObject).putExtra("LauncherUI.From.Biz.Shortcut", true);
            ((Intent)localObject).addFlags(67108864);
            localContentValues.put("intent", ((Intent)localObject).toUri(0));
            arrayOfContentValues[paramInt1] = localContentValues;
            paramInt1 += 1;
          }
          getContentResolver().bulkInsert(a.sPa, arrayOfContentValues);
          Toast.makeText(this, 2131758980, 0).show();
          com.tencent.mm.plugin.extqlauncher.b.cSI().cSJ();
        }
        catch (Exception paramIntent)
        {
          Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[] { paramIntent.getMessage() });
          Log.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", paramIntent, "", new Object[0]);
          Toast.makeText(this, 2131758979, 0).show();
        }
      }
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24567);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
    requestWindowFeature(1);
    setContentView(2131493805);
    paramBundle = new Intent();
    int i = u.Q(new int[] { u.PWR, 64, 16384 });
    u.ll(i, 1);
    paramBundle.putExtra("list_attr", i);
    paramBundle.putExtra("list_type", 12);
    paramBundle.putExtra("stay_in_wechat", false);
    paramBundle.putExtra("titile", getString(2131755268));
    paramBundle.putExtra("block_contact", z.aTY());
    com.tencent.mm.br.c.c(this, ".ui.contact.SelectContactUI", paramBundle, 1);
    AppMethodBeat.o(24567);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.ui.QLauncherCreateShortcutUI
 * JD-Core Version:    0.7.0.1
 */