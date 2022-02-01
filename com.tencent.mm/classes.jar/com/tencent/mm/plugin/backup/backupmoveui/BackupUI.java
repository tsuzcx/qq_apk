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
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.a.1;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI
  extends MMWizardActivity
{
  private static boolean mWJ = false;
  private au mVF;
  private Button mWI;
  private TextView mWu;
  
  public BackupUI()
  {
    AppMethodBeat.i(21490);
    this.mVF = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21489);
        if (bs.isNullOrNil(g.eh(BackupUI.this))) {
          if (BackupUI.mWJ)
          {
            BackupUI.a(BackupUI.this).setText(2131756267);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131099991));
            BackupUI.b(BackupUI.this).setEnabled(false);
            BackupUI.access$002(false);
            com.tencent.mm.plugin.report.service.h.wUl.f(11788, new Object[] { Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(21489);
          return true;
          if (!BackupUI.mWJ)
          {
            BackupUI.a(BackupUI.this).setText(2131756268);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131099992));
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
    return 2131493133;
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
    setMMTitle(2131756098);
    com.tencent.mm.plugin.report.service.h.wUl.f(11788, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.backup.g.b.bEx();
    this.mWu = ((TextView)findViewById(2131297059));
    this.mWI = ((Button)findViewById(2131297055));
    com.tencent.mm.plugin.backup.d.b.bDy();
    paramBundle = com.tencent.mm.plugin.backup.d.b.bCU().edit();
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    paramBundle.commit();
    if (!com.tencent.mm.plugin.backup.d.b.bDy().bDC().mUr)
    {
      paramBundle = com.tencent.mm.plugin.backup.d.b.bDy().bDC();
      d.bEP().bES();
      com.tencent.mm.sdk.g.b.c(new a.1(paramBundle), "BakMoveChooseServer.calculateToChoose");
      if (!bs.isNullOrNil(g.eh(this))) {
        break label300;
      }
      this.mWu.setText(2131756267);
      this.mWu.setTextColor(getResources().getColor(2131099991));
      this.mWI.setEnabled(false);
      mWJ = false;
      com.tencent.mm.plugin.report.service.h.wUl.f(11788, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      this.mWI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21487);
          az.ayM();
          if (((Boolean)c.agA().get(ah.a.GKO, Boolean.FALSE)).booleanValue())
          {
            if (com.tencent.mm.plugin.backup.d.b.bDy().bCP().mSk == -100)
            {
              az.ayM();
              c.agA().set(ah.a.GKO, Boolean.FALSE);
            }
          }
          else
          {
            az.ayM();
            if (!((Boolean)c.agA().get(ah.a.GKK, Boolean.FALSE)).booleanValue())
            {
              az.ayM();
              if (!((Boolean)c.agA().get(ah.a.GKL, Boolean.FALSE)).booleanValue()) {}
            }
            else
            {
              if (com.tencent.mm.plugin.backup.backuppcmodel.b.bEa().bCP().mSk != -100) {
                break label340;
              }
              az.ayM();
              c.agA().set(ah.a.GKK, Boolean.FALSE);
              az.ayM();
              c.agA().set(ah.a.GKL, Boolean.FALSE);
            }
            int i = g.bDf();
            if (i >= 50) {
              break label443;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 7L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.f(11787, new Object[] { Integer.valueOf(4) });
            com.tencent.mm.ui.base.h.a(BackupUI.this, 2131756120, 2131756119, 2131756270, 2131756090, false, new BackupUI.1.1(this, i), null, 2131099990);
            AppMethodBeat.o(21487);
            return;
          }
          Object localObject = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
          ((Intent)localObject).addFlags(335544320);
          ((Intent)localObject).putExtra("nofification_type", "backup_move_notification");
          paramAnonymousView = ai.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(21487);
          return;
          label340:
          localObject = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
          ((Intent)localObject).addFlags(335544320);
          ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
          paramAnonymousView = ai.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(21487);
          return;
          label443:
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 21L, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.f(11788, new Object[] { Integer.valueOf(3) });
          paramAnonymousView = new Intent(BackupUI.this, BackupMoveChooseUI.class);
          MMWizardActivity.aj(BackupUI.this, paramAnonymousView);
          AppMethodBeat.o(21487);
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
      com.tencent.mm.plugin.backup.d.b.bDy().bDC().bDw();
      break;
      label300:
      this.mWu.setText(2131756268);
      this.mWu.setTextColor(getResources().getColor(2131099992));
      this.mWI.setEnabled(true);
      mWJ = true;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21494);
    ac.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
    super.onDestroy();
    com.tencent.mm.plugin.backup.d.b.bDy().bDC().cancel();
    com.tencent.mm.plugin.backup.d.a locala = com.tencent.mm.plugin.backup.d.b.bDy().bDC();
    ac.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
    locala.mUo = null;
    locala.mUq = null;
    locala.mUp = null;
    locala.mUs = false;
    locala.mUr = false;
    AppMethodBeat.o(21494);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21492);
    super.onStart();
    this.mVF.au(5000L, 5000L);
    AppMethodBeat.o(21492);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21493);
    super.onStop();
    this.mVF.stopTimer();
    AppMethodBeat.o(21493);
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