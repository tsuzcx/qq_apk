package com.tencent.mm.plugin.backup.backupui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.backup.backupmoveui.BackupUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
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
    return R.o.eXf;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21780);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(R.l.erZ);
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
    ((com.tencent.mm.app.n)h.ae(com.tencent.mm.app.n.class)).aaM();
    AppMethodBeat.o(21780);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21782);
    super.onDestroy();
    ((com.tencent.mm.app.n)h.ae(com.tencent.mm.app.n.class)).aaL();
    AppMethodBeat.o(21782);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(21781);
    if (paramPreference.mKey.equals("backup_move_to_device")) {
      try
      {
        if (((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bco().eSi()) {
          bq.beT();
        }
        MMWizardActivity.aH(this, new Intent(getContext(), BackupUI.class));
        AppMethodBeat.o(21781);
        return true;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.BackupChooseBackupModeUI", paramf, "", new Object[0]);
        }
      }
    }
    if (paramPreference.mKey.equals("backup_to_pc"))
    {
      paramf = new Intent();
      paramf.putExtra("title", getString(R.l.eqS));
      paramf.putExtra("rawUrl", getString(R.l.backup_pc_tip_doc, new Object[] { LocaleUtil.getApplicationLanguage() }));
      paramf.putExtra("showShare", false);
      paramf.putExtra("neverGetA8Key", true);
      com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI
 * JD-Core Version:    0.7.0.1
 */