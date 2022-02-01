package com.tencent.mm.plugin.backup.backupui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.m;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.backup.backupmoveui.BackupUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class BackupChooseBackupModeUI
  extends MMPreference
{
  private f screen;
  
  public int getResourceId()
  {
    return 2131951628;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21780);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(2131756271);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21779);
        BackupChooseBackupModeUI.this.finish();
        AppMethodBeat.o(21779);
        return true;
      }
    });
    ((m)g.ab(m.class)).LX();
    AppMethodBeat.o(21780);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21782);
    super.onDestroy();
    ((m)g.ab(m.class)).LW();
    AppMethodBeat.o(21782);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(21781);
    if (paramPreference.mKey.equals("backup_move_to_device")) {
      try
      {
        if (((l)g.ab(l.class)).azS().dlO()) {
          bj.aCc();
        }
        MMWizardActivity.al(this, new Intent(getContext(), BackupUI.class));
        AppMethodBeat.o(21781);
        return true;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.BackupChooseBackupModeUI", paramf, "", new Object[0]);
        }
      }
    }
    if (paramPreference.mKey.equals("backup_to_pc"))
    {
      paramf = new Intent();
      paramf.putExtra("title", getString(2131756190));
      paramf.putExtra("rawUrl", getString(2131756248, new Object[] { ac.fks() }));
      paramf.putExtra("showShare", false);
      paramf.putExtra("neverGetA8Key", true);
      d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
      AppMethodBeat.o(21781);
      return true;
    }
    AppMethodBeat.o(21781);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI
 * JD-Core Version:    0.7.0.1
 */