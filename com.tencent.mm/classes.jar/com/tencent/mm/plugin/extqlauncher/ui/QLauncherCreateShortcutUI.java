package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.s;
import java.util.List;

public class QLauncherCreateShortcutUI
  extends MMBaseActivity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      finish();
      return;
    }
    switch (paramInt1)
    {
    }
    do
    {
      finish();
      return;
    } while (paramIntent == null);
    if (!au.DK())
    {
      y.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
      Toast.makeText(this, R.l.extqlauncher_add_shortcut_failed, 0).show();
      finish();
      return;
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (!bk.bl(paramIntent)) {}
    for (paramIntent = bk.G(paramIntent.split(","));; paramIntent = null)
    {
      if ((paramIntent == null) || (paramIntent.size() <= 0))
      {
        y.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
        break;
      }
      y.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + paramIntent.size());
      String str1 = q.Gj();
      ContentValues[] arrayOfContentValues;
      for (;;)
      {
        try
        {
          arrayOfContentValues = new ContentValues[paramIntent.size()];
          paramInt1 = 0;
          if (paramInt1 >= paramIntent.size()) {
            break label502;
          }
          au.Hx();
          localObject = c.Fw().abl((String)paramIntent.get(paramInt1));
          if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).dBe > 0)) {
            break label290;
          }
          y.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
          finish();
          return;
        }
        catch (Exception paramIntent)
        {
          y.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[] { paramIntent.getMessage() });
          y.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", paramIntent, "", new Object[0]);
          Toast.makeText(this, R.l.extqlauncher_add_shortcut_failed, 0).show();
        }
        break;
        label290:
        String str2 = com.tencent.mm.plugin.base.model.b.xH((String)paramIntent.get(paramInt1));
        if (bk.bl(str2))
        {
          y.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
          finish();
          return;
        }
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("source_key", com.tencent.mm.plugin.base.model.b.hRJ);
        localContentValues.put("owner_id", com.tencent.mm.plugin.base.model.b.xH(str1));
        localContentValues.put("unique_id", str2);
        localContentValues.put("container", Integer.valueOf(1));
        localContentValues.put("item_type", Integer.valueOf(com.tencent.mm.plugin.base.model.b.B((ad)localObject)));
        localContentValues.put("name", r.a((ad)localObject, (String)paramIntent.get(paramInt1)));
        o.JQ();
        localContentValues.put("icon_path", com.tencent.mm.ag.d.A((String)paramIntent.get(paramInt1), false));
        Object localObject = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        ((Intent)localObject).putExtra("LauncherUI.Shortcut.Username", str2);
        ((Intent)localObject).putExtra("LauncherUI.From.Biz.Shortcut", true);
        ((Intent)localObject).addFlags(67108864);
        localContentValues.put("intent", ((Intent)localObject).toUri(0));
        arrayOfContentValues[paramInt1] = localContentValues;
        paramInt1 += 1;
      }
      label502:
      getContentResolver().bulkInsert(a.jMe, arrayOfContentValues);
      Toast.makeText(this, R.l.extqlauncher_add_shortcut_success, 0).show();
      com.tencent.mm.plugin.extqlauncher.b.aNP().aNR();
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
    requestWindowFeature(1);
    setContentView(R.i.create_shortcut);
    paramBundle = new Intent();
    int i = s.v(new int[] { s.vMq, 64, 16384 });
    s.fB(i, 1);
    paramBundle.putExtra("list_attr", i);
    paramBundle.putExtra("list_type", 12);
    paramBundle.putExtra("stay_in_wechat", false);
    paramBundle.putExtra("titile", getString(R.l.address_title_select_contact));
    paramBundle.putExtra("block_contact", q.Gj());
    com.tencent.mm.br.d.c(this, ".ui.contact.SelectContactUI", paramBundle, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.ui.QLauncherCreateShortcutUI
 * JD-Core Version:    0.7.0.1
 */