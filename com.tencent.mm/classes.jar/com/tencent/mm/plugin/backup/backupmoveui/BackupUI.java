package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.a.1;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI
  extends MMWizardActivity
{
  private static boolean oNA = false;
  private MTimerHandler oMw;
  private TextView oNl;
  private Button oNz;
  
  public BackupUI()
  {
    AppMethodBeat.i(21490);
    this.oMw = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21489);
        if (Util.isNullOrNil(g.eE(BackupUI.this))) {
          if (BackupUI.oNA)
          {
            BackupUI.a(BackupUI.this).setText(2131756401);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131100015));
            BackupUI.b(BackupUI.this).setEnabled(false);
            BackupUI.access$002(false);
            com.tencent.mm.plugin.report.service.h.CyF.a(11788, new Object[] { Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(21489);
          return true;
          if (!BackupUI.oNA)
          {
            BackupUI.a(BackupUI.this).setText(2131756402);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131100016));
            BackupUI.b(BackupUI.this).setEnabled(true);
            BackupUI.access$002(true);
          }
        }
      }
    }, true);
    AppMethodBeat.o(21490);
  }
  
  public int getLayoutId()
  {
    return 2131493176;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21491);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21491);
      return;
    }
    setMMTitle(2131756232);
    com.tencent.mm.plugin.report.service.h.CyF.a(11788, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.backup.g.b.cgx();
    this.oNl = ((TextView)findViewById(2131297205));
    this.oNz = ((Button)findViewById(2131297201));
    com.tencent.mm.plugin.backup.d.b.cfv();
    paramBundle = com.tencent.mm.plugin.backup.d.b.ceR().edit();
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    paramBundle.commit();
    if (!com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLi)
    {
      paramBundle = com.tencent.mm.plugin.backup.d.b.cfv().cfz();
      d.cgP().cgS();
      ThreadPool.post(new a.1(paramBundle), "BakMoveChooseServer.calculateToChoose");
      if (!Util.isNullOrNil(g.eE(this))) {
        break label300;
      }
      this.oNl.setText(2131756401);
      this.oNl.setTextColor(getResources().getColor(2131100015));
      this.oNz.setEnabled(false);
      oNA = false;
      com.tencent.mm.plugin.report.service.h.CyF.a(11788, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      this.oNz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21487);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          bg.aVF();
          if (((Boolean)c.azQ().get(ar.a.NZG, Boolean.FALSE)).booleanValue())
          {
            if (com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc == -100)
            {
              bg.aVF();
              c.azQ().set(ar.a.NZG, Boolean.FALSE);
            }
          }
          else
          {
            bg.aVF();
            if (!((Boolean)c.azQ().get(ar.a.NZC, Boolean.FALSE)).booleanValue())
            {
              bg.aVF();
              if (!((Boolean)c.azQ().get(ar.a.NZD, Boolean.FALSE)).booleanValue()) {}
            }
            else
            {
              if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc != -100) {
                break label393;
              }
              bg.aVF();
              c.azQ().set(ar.a.NZC, Boolean.FALSE);
              bg.aVF();
              c.azQ().set(ar.a.NZD, Boolean.FALSE);
            }
            int i = g.cfc();
            if (i >= 50) {
              break label508;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 7L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(11787, new Object[] { Integer.valueOf(4) });
            com.tencent.mm.ui.base.h.a(BackupUI.this, 2131756254, 2131756253, 2131756404, 2131756224, false, new BackupUI.1.1(this, i), null, 2131100014);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
            ((Intent)localObject).addFlags(335544320);
            ((Intent)localObject).putExtra("nofification_type", "backup_move_notification");
            paramAnonymousView = MMApplicationContext.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            label393:
            localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
            ((Intent)localObject).addFlags(335544320);
            ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
            paramAnonymousView = MMApplicationContext.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            label508:
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 21L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(11788, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new Intent(BackupUI.this, BackupMoveChooseUI.class);
            MMWizardActivity.ay(BackupUI.this, paramAnonymousView);
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(21488);
          BackupUI.this.finish();
          AppMethodBeat.o(21488);
          return true;
        }
      });
      AppMethodBeat.o(21491);
      return;
      com.tencent.mm.plugin.backup.d.b.cfv().cfz().cft();
      break;
      label300:
      this.oNl.setText(2131756402);
      this.oNl.setTextColor(getResources().getColor(2131100016));
      this.oNz.setEnabled(true);
      oNA = true;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21494);
    Log.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
    super.onDestroy();
    com.tencent.mm.plugin.backup.d.b.cfv().cfz().cancel();
    com.tencent.mm.plugin.backup.d.a locala = com.tencent.mm.plugin.backup.d.b.cfv().cfz();
    Log.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
    locala.oLf = null;
    locala.oLh = null;
    locala.oLg = null;
    locala.oLj = false;
    locala.oLi = false;
    AppMethodBeat.o(21494);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21492);
    super.onStart();
    this.oMw.startTimer(5000L);
    AppMethodBeat.o(21492);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21493);
    super.onStop();
    this.oMw.stopTimer();
    AppMethodBeat.o(21493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupUI
 * JD-Core Version:    0.7.0.1
 */