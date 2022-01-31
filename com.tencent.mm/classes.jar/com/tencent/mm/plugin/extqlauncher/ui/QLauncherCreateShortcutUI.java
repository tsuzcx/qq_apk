package com.tencent.mm.plugin.extqlauncher.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.t;
import java.util.List;

public class QLauncherCreateShortcutUI
  extends MMBaseActivity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20495);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      finish();
      AppMethodBeat.o(20495);
      return;
    }
    switch (paramInt1)
    {
    }
    do
    {
      finish();
      AppMethodBeat.o(20495);
      return;
    } while (paramIntent == null);
    if (!aw.RG())
    {
      ab.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
      Toast.makeText(this, 2131299518, 0).show();
      finish();
      AppMethodBeat.o(20495);
      return;
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (!bo.isNullOrNil(paramIntent)) {}
    for (paramIntent = bo.P(paramIntent.split(","));; paramIntent = null)
    {
      for (;;)
      {
        if ((paramIntent == null) || (paramIntent.size() <= 0))
        {
          ab.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
          break;
        }
        ab.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + paramIntent.size());
        String str1 = r.Zn();
        try
        {
          ContentValues[] arrayOfContentValues = new ContentValues[paramIntent.size()];
          paramInt1 = 0;
          while (paramInt1 < paramIntent.size())
          {
            aw.aaz();
            Object localObject = c.YA().arw((String)paramIntent.get(paramInt1));
            if ((localObject == null) || ((int)((com.tencent.mm.n.a)localObject).euF <= 0))
            {
              ab.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
              finish();
              AppMethodBeat.o(20495);
              return;
            }
            String str2 = com.tencent.mm.plugin.base.model.b.GA((String)paramIntent.get(paramInt1));
            if (bo.isNullOrNil(str2))
            {
              ab.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
              finish();
              AppMethodBeat.o(20495);
              return;
            }
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("source_key", com.tencent.mm.plugin.base.model.b.SOURCE_KEY);
            localContentValues.put("owner_id", com.tencent.mm.plugin.base.model.b.GA(str1));
            localContentValues.put("unique_id", str2);
            localContentValues.put("container", Integer.valueOf(1));
            localContentValues.put("item_type", Integer.valueOf(com.tencent.mm.plugin.base.model.b.C((ad)localObject)));
            localContentValues.put("name", s.a((ad)localObject, (String)paramIntent.get(paramInt1)));
            o.acQ();
            localContentValues.put("icon_path", com.tencent.mm.ah.d.E((String)paramIntent.get(paramInt1), false));
            localObject = new Intent("com.tencent.mm.action.BIZSHORTCUT");
            ((Intent)localObject).putExtra("LauncherUI.Shortcut.Username", str2);
            ((Intent)localObject).putExtra("LauncherUI.From.Biz.Shortcut", true);
            ((Intent)localObject).addFlags(67108864);
            localContentValues.put("intent", ((Intent)localObject).toUri(0));
            arrayOfContentValues[paramInt1] = localContentValues;
            paramInt1 += 1;
          }
          getContentResolver().bulkInsert(a.mgi, arrayOfContentValues);
          Toast.makeText(this, 2131299519, 0).show();
          com.tencent.mm.plugin.extqlauncher.b.btS().btU();
        }
        catch (Exception paramIntent)
        {
          ab.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[] { paramIntent.getMessage() });
          ab.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", paramIntent, "", new Object[0]);
          Toast.makeText(this, 2131299518, 0).show();
        }
      }
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20494);
    super.onCreate(paramBundle);
    ab.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
    requestWindowFeature(1);
    setContentView(2130969286);
    paramBundle = new Intent();
    int i = t.F(new int[] { t.AdS, 64, 16384 });
    t.hJ(i, 1);
    paramBundle.putExtra("list_attr", i);
    paramBundle.putExtra("list_type", 12);
    paramBundle.putExtra("stay_in_wechat", false);
    paramBundle.putExtra("titile", getString(2131296502));
    paramBundle.putExtra("block_contact", r.Zn());
    com.tencent.mm.bq.d.b(this, ".ui.contact.SelectContactUI", paramBundle, 1);
    AppMethodBeat.o(20494);
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