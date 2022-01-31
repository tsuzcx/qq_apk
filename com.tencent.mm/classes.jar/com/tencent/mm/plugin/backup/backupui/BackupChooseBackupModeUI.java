package com.tencent.mm.plugin.backup.backupui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.backup.backupmoveui.BackupUI;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class BackupChooseBackupModeUI
  extends MMPreference
{
  private f dnn;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.equals("backup_move_to_device"))
    {
      MMWizardActivity.C(this, new Intent(this.mController.uMN, BackupUI.class));
      return true;
    }
    if (paramPreference.mKey.equals("backup_to_pc"))
    {
      paramf = new Intent();
      paramf.putExtra("title", getString(R.l.backup_pc_doc_title));
      paramf.putExtra("rawUrl", getString(R.l.backup_pc_tip_doc, new Object[] { x.cqJ() }));
      paramf.putExtra("showShare", false);
      paramf.putExtra("neverGetA8Key", true);
      d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    setMMTitle(R.l.backup_title);
    setBackBtn(new BackupChooseBackupModeUI.1(this));
  }
  
  public void onDestroy()
  {
    y.d("MicroMsg.BackupChooseBackupModeUI", "BackupChooseBackupModeUI onDestroy.");
    super.onDestroy();
    b.atS().atW().cancel();
    com.tencent.mm.plugin.backup.d.a locala = b.atS().atW();
    y.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
    locala.hHu = null;
    locala.hHw = null;
    locala.hHv = null;
    locala.hHy = false;
    locala.hHx = false;
  }
  
  public final int xj()
  {
    return R.o.backup_choose_backup_mode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI
 * JD-Core Version:    0.7.0.1
 */