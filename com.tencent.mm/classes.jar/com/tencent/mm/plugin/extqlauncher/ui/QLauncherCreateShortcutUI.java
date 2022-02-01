package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.extqlauncher.SubCoreExtQLauncher;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.w;
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
    if (!bh.baz())
    {
      Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
      Toast.makeText(this, R.l.gHl, 0).show();
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
        String str1 = z.bAM();
        try
        {
          ContentValues[] arrayOfContentValues = new ContentValues[paramIntent.size()];
          paramInt1 = 0;
          while (paramInt1 < paramIntent.size())
          {
            bh.bCz();
            Object localObject = com.tencent.mm.model.c.bzA().JE((String)paramIntent.get(paramInt1));
            if ((localObject == null) || ((int)((d)localObject).maN <= 0))
            {
              Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
              finish();
              AppMethodBeat.o(24568);
              return;
            }
            String str2 = b.aib((String)paramIntent.get(paramInt1));
            if (Util.isNullOrNil(str2))
            {
              Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
              finish();
              AppMethodBeat.o(24568);
              return;
            }
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("source_key", b.vqV);
            localContentValues.put("owner_id", b.aib(str1));
            localContentValues.put("unique_id", str2);
            localContentValues.put("container", Integer.valueOf(1));
            localContentValues.put("item_type", Integer.valueOf(b.aa((au)localObject)));
            localContentValues.put("name", aa.b((au)localObject, (String)paramIntent.get(paramInt1)));
            q.bFp();
            localContentValues.put("icon_path", AvatarStorage.R((String)paramIntent.get(paramInt1), false));
            localObject = new Intent("com.tencent.mm.action.BIZSHORTCUT");
            ((Intent)localObject).putExtra("LauncherUI.Shortcut.Username", str2);
            ((Intent)localObject).putExtra("LauncherUI.From.Biz.Shortcut", true);
            ((Intent)localObject).addFlags(67108864);
            localContentValues.put("intent", ((Intent)localObject).toUri(0));
            arrayOfContentValues[paramInt1] = localContentValues;
            paramInt1 += 1;
          }
          getContentResolver().bulkInsert(a.zQW, arrayOfContentValues);
          Toast.makeText(this, R.l.gHm, 0).show();
          SubCoreExtQLauncher.dOu().dOw();
        }
        catch (Exception paramIntent)
        {
          Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[] { paramIntent.getMessage() });
          Log.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", paramIntent, "", new Object[0]);
          Toast.makeText(this, R.l.gHl, 0).show();
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
    setContentView(R.i.giN);
    paramBundle = new Intent();
    int i = w.R(new int[] { w.affn, 64, 16384 });
    w.ow(i, 1);
    paramBundle.putExtra("list_attr", i);
    paramBundle.putExtra("list_type", 12);
    paramBundle.putExtra("stay_in_wechat", false);
    paramBundle.putExtra("titile", getString(R.l.address_title_select_contact));
    paramBundle.putExtra("block_contact", z.bAM());
    com.tencent.mm.br.c.d(this, ".ui.contact.SelectContactUI", paramBundle, 1);
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