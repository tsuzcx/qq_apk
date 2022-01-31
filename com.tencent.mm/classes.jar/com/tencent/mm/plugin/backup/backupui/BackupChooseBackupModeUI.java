package com.tencent.mm.plugin.backup.backupui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.backup.backupmoveui.BackupUI;
import com.tencent.mm.sdk.platformtools.aa;
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
    return 2131165195;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17723);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setMMTitle(2131297395);
    setBackBtn(new BackupChooseBackupModeUI.1(this));
    AppMethodBeat.o(17723);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(17724);
    if (paramPreference.mKey.equals("backup_move_to_device"))
    {
      MMWizardActivity.J(this, new Intent(getContext(), BackupUI.class));
      AppMethodBeat.o(17724);
      return true;
    }
    if (paramPreference.mKey.equals("backup_to_pc"))
    {
      paramf = new Intent();
      paramf.putExtra("title", getString(2131297316));
      paramf.putExtra("rawUrl", getString(2131306131, new Object[] { aa.dsG() }));
      paramf.putExtra("showShare", false);
      paramf.putExtra("neverGetA8Key", true);
      d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
      AppMethodBeat.o(17724);
      return true;
    }
    AppMethodBeat.o(17724);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI
 * JD-Core Version:    0.7.0.1
 */