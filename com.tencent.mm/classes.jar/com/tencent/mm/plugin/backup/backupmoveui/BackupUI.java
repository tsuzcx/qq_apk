package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.d.a.1;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI
  extends MMWizardActivity
{
  private static boolean hJJ = false;
  private am hII = new am(Looper.getMainLooper(), new BackupUI.3(this), true);
  private Button hJI;
  private TextView hJv;
  
  protected final int getLayoutId()
  {
    return R.i.backup_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    setMMTitle(R.l.backup_move);
    h.nFQ.f(11788, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.backup.g.b.auQ();
    this.hJv = ((TextView)findViewById(R.h.backup_move_status_content));
    this.hJI = ((Button)findViewById(R.h.backup_move_bt));
    com.tencent.mm.plugin.backup.d.b.atS();
    paramBundle = com.tencent.mm.plugin.backup.d.b.ats().edit();
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    paramBundle.commit();
    if (!com.tencent.mm.plugin.backup.d.b.atS().atW().hHx)
    {
      paramBundle = com.tencent.mm.plugin.backup.d.b.atS().atW();
      d.avi().avl();
      e.post(new a.1(paramBundle), "BakMoveChooseServer.calculateToChoose");
      if (!bk.bl(g.cM(this))) {
        break label287;
      }
      this.hJv.setText(R.l.backup_status_content_no_wifi);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_red));
      this.hJI.setEnabled(false);
      hJJ = false;
      h.nFQ.f(11788, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      this.hJI.setOnClickListener(new BackupUI.1(this));
      setBackBtn(new BackupUI.2(this));
      return;
      com.tencent.mm.plugin.backup.d.b.atS().atW().atR();
      break;
      label287:
      this.hJv.setText(R.l.backup_status_content_open_wifi);
      this.hJv.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hJI.setEnabled(true);
      hJJ = true;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.hII.S(5000L, 5000L);
  }
  
  public void onStop()
  {
    super.onStop();
    this.hII.stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI
 * JD-Core Version:    0.7.0.1
 */