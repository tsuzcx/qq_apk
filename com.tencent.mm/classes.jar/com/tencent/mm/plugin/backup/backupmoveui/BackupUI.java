package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.d.a.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI
  extends MMWizardActivity
{
  private static boolean jDn = false;
  private TextView jCX;
  private ap jCi;
  private Button jDm;
  
  public BackupUI()
  {
    AppMethodBeat.i(17431);
    this.jCi = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(17430);
        if (bo.isNullOrNil(g.dx(BackupUI.this))) {
          if (BackupUI.jDn)
          {
            BackupUI.a(BackupUI.this).setText(2131297391);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131689740));
            BackupUI.b(BackupUI.this).setEnabled(false);
            BackupUI.access$002(false);
            h.qsU.e(11788, new Object[] { Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(17430);
          return true;
          if (!BackupUI.jDn)
          {
            BackupUI.a(BackupUI.this).setText(2131297392);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131689741));
            BackupUI.b(BackupUI.this).setEnabled(true);
            BackupUI.access$002(true);
          }
        }
      }
    }, true);
    AppMethodBeat.o(17431);
  }
  
  public int getLayoutId()
  {
    return 2130968804;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17432);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17432);
      return;
    }
    setMMTitle(2131297228);
    h.qsU.e(11788, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.backup.g.b.aUs();
    this.jCX = ((TextView)findViewById(2131821633));
    this.jDm = ((Button)findViewById(2131821634));
    com.tencent.mm.plugin.backup.d.b.aTr();
    paramBundle = com.tencent.mm.plugin.backup.d.b.aSQ().edit();
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    paramBundle.commit();
    if (!com.tencent.mm.plugin.backup.d.b.aTr().aTv().jAT)
    {
      paramBundle = com.tencent.mm.plugin.backup.d.b.aTr().aTv();
      com.tencent.mm.plugin.backup.h.d.aUK().aUN();
      com.tencent.mm.sdk.g.d.post(new a.1(paramBundle), "BakMoveChooseServer.calculateToChoose");
      if (!bo.isNullOrNil(g.dx(this))) {
        break label300;
      }
      this.jCX.setText(2131297391);
      this.jCX.setTextColor(getResources().getColor(2131689740));
      this.jDm.setEnabled(false);
      jDn = false;
      h.qsU.e(11788, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      this.jDm.setOnClickListener(new BackupUI.1(this));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(17429);
          BackupUI.this.finish();
          AppMethodBeat.o(17429);
          return true;
        }
      });
      AppMethodBeat.o(17432);
      return;
      com.tencent.mm.plugin.backup.d.b.aTr().aTv().aTp();
      break;
      label300:
      this.jCX.setText(2131297392);
      this.jCX.setTextColor(getResources().getColor(2131689741));
      this.jDm.setEnabled(true);
      jDn = true;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(156058);
    ab.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
    super.onDestroy();
    com.tencent.mm.plugin.backup.d.b.aTr().aTv().cancel();
    a locala = com.tencent.mm.plugin.backup.d.b.aTr().aTv();
    ab.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
    locala.jAQ = null;
    locala.jAS = null;
    locala.jAR = null;
    locala.jAU = false;
    locala.jAT = false;
    AppMethodBeat.o(156058);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(17433);
    super.onStart();
    this.jCi.ag(5000L, 5000L);
    AppMethodBeat.o(17433);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(17434);
    super.onStop();
    this.jCi.stopTimer();
    AppMethodBeat.o(17434);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI
 * JD-Core Version:    0.7.0.1
 */