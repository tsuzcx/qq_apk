package com.tencent.mm.plugin.extqlauncher.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.p;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.List;

public class QLauncherCreateShortcutUI
  extends MMBaseActivity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24568);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[] { Integer.valueOf(paramInt2) });
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
    if (!az.afw())
    {
      ad.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
      Toast.makeText(this, 2131758673, 0).show();
      finish();
      AppMethodBeat.o(24568);
      return;
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (!bt.isNullOrNil(paramIntent)) {}
    for (paramIntent = bt.S(paramIntent.split(","));; paramIntent = null)
    {
      for (;;)
      {
        if ((paramIntent == null) || (paramIntent.size() <= 0))
        {
          ad.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
          break;
        }
        ad.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + paramIntent.size());
        String str1 = com.tencent.mm.model.u.aqG();
        try
        {
          ContentValues[] arrayOfContentValues = new ContentValues[paramIntent.size()];
          paramInt1 = 0;
          while (paramInt1 < paramIntent.size())
          {
            az.arV();
            Object localObject = c.apM().aHY((String)paramIntent.get(paramInt1));
            if ((localObject == null) || ((int)((com.tencent.mm.n.b)localObject).fId <= 0))
            {
              ad.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
              finish();
              AppMethodBeat.o(24568);
              return;
            }
            String str2 = com.tencent.mm.plugin.base.model.b.OM((String)paramIntent.get(paramInt1));
            if (bt.isNullOrNil(str2))
            {
              ad.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
              finish();
              AppMethodBeat.o(24568);
              return;
            }
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("source_key", com.tencent.mm.plugin.base.model.b.SOURCE_KEY);
            localContentValues.put("owner_id", com.tencent.mm.plugin.base.model.b.OM(str1));
            localContentValues.put("unique_id", str2);
            localContentValues.put("container", Integer.valueOf(1));
            localContentValues.put("item_type", Integer.valueOf(com.tencent.mm.plugin.base.model.b.I((af)localObject)));
            localContentValues.put("name", v.b((af)localObject, (String)paramIntent.get(paramInt1)));
            p.auq();
            localContentValues.put("icon_path", e.J((String)paramIntent.get(paramInt1), false));
            localObject = new Intent("com.tencent.mm.action.BIZSHORTCUT");
            ((Intent)localObject).putExtra("LauncherUI.Shortcut.Username", str2);
            ((Intent)localObject).putExtra("LauncherUI.From.Biz.Shortcut", true);
            ((Intent)localObject).addFlags(67108864);
            localContentValues.put("intent", ((Intent)localObject).toUri(0));
            arrayOfContentValues[paramInt1] = localContentValues;
            paramInt1 += 1;
          }
          getContentResolver().bulkInsert(a.pMU, arrayOfContentValues);
          Toast.makeText(this, 2131758674, 0).show();
          com.tencent.mm.plugin.extqlauncher.b.cfm().cfo();
        }
        catch (Exception paramIntent)
        {
          ad.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[] { paramIntent.getMessage() });
          ad.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", paramIntent, "", new Object[0]);
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
    ad.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
    requestWindowFeature(1);
    setContentView(2131493674);
    paramBundle = new Intent();
    int i = com.tencent.mm.ui.contact.u.I(new int[] { com.tencent.mm.ui.contact.u.GWA, 64, 16384 });
    com.tencent.mm.ui.contact.u.jw(i, 1);
    paramBundle.putExtra("list_attr", i);
    paramBundle.putExtra("list_type", 12);
    paramBundle.putExtra("stay_in_wechat", false);
    paramBundle.putExtra("titile", getString(2131755234));
    paramBundle.putExtra("block_contact", com.tencent.mm.model.u.aqG());
    d.c(this, ".ui.contact.SelectContactUI", paramBundle, 1);
    AppMethodBeat.o(24567);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.ui.QLauncherCreateShortcutUI
 * JD-Core Version:    0.7.0.1
 */