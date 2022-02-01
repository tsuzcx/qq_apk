package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI
  extends MMWizardActivity
{
  private static boolean muI = false;
  private av mtD;
  private Button muH;
  private TextView mus;
  
  public BackupUI()
  {
    AppMethodBeat.i(21490);
    this.mtD = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21489);
        if (bt.isNullOrNil(g.dZ(BackupUI.this))) {
          if (BackupUI.muI)
          {
            BackupUI.a(BackupUI.this).setText(2131756267);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131099991));
            BackupUI.b(BackupUI.this).setEnabled(false);
            BackupUI.cz(false);
            com.tencent.mm.plugin.report.service.h.vKh.f(11788, new Object[] { Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(21489);
          return true;
          if (!BackupUI.muI)
          {
            BackupUI.a(BackupUI.this).setText(2131756268);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131099992));
            BackupUI.b(BackupUI.this).setEnabled(true);
            BackupUI.cz(true);
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
    com.tencent.mm.plugin.report.service.h.vKh.f(11788, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.backup.g.b.bxB();
    this.mus = ((TextView)findViewById(2131297059));
    this.muH = ((Button)findViewById(2131297055));
    com.tencent.mm.plugin.backup.d.b.bwC();
    paramBundle = com.tencent.mm.plugin.backup.d.b.bvY().edit();
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    paramBundle.commit();
    if (!com.tencent.mm.plugin.backup.d.b.bwC().bwG().msq)
    {
      paramBundle = com.tencent.mm.plugin.backup.d.b.bwC().bwG();
      d.bxT().bxW();
      com.tencent.mm.sdk.g.b.c(new a.1(paramBundle), "BakMoveChooseServer.calculateToChoose");
      if (!bt.isNullOrNil(g.dZ(this))) {
        break label300;
      }
      this.mus.setText(2131756267);
      this.mus.setTextColor(getResources().getColor(2131099991));
      this.muH.setEnabled(false);
      muI = false;
      com.tencent.mm.plugin.report.service.h.vKh.f(11788, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      this.muH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21487);
          az.arV();
          if (((Boolean)c.afk().get(ae.a.FmZ, Boolean.FALSE)).booleanValue())
          {
            if (com.tencent.mm.plugin.backup.d.b.bwC().bvT().mqj == -100)
            {
              az.arV();
              c.afk().set(ae.a.FmZ, Boolean.FALSE);
            }
          }
          else
          {
            az.arV();
            if (!((Boolean)c.afk().get(ae.a.FmV, Boolean.FALSE)).booleanValue())
            {
              az.arV();
              if (!((Boolean)c.afk().get(ae.a.FmW, Boolean.FALSE)).booleanValue()) {}
            }
            else
            {
              if (com.tencent.mm.plugin.backup.backuppcmodel.b.bxe().bvT().mqj != -100) {
                break label340;
              }
              az.arV();
              c.afk().set(ae.a.FmV, Boolean.FALSE);
              az.arV();
              c.afk().set(ae.a.FmW, Boolean.FALSE);
            }
            final int i = g.bwj();
            if (i >= 50) {
              break label443;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 7L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.f(11787, new Object[] { Integer.valueOf(4) });
            com.tencent.mm.ui.base.h.a(BackupUI.this, 2131756120, 2131756119, 2131756270, 2131756090, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(21486);
                ad.i("MicroMsg.BackupUI", "low battery, user click sure. battery:%d", new Object[] { Integer.valueOf(i) });
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 21L, 1L, false);
                com.tencent.mm.plugin.report.service.h.vKh.f(11788, new Object[] { Integer.valueOf(3) });
                paramAnonymous2DialogInterface = new Intent(BackupUI.this, BackupMoveChooseUI.class);
                MMWizardActivity.V(BackupUI.this, paramAnonymous2DialogInterface);
                AppMethodBeat.o(21486);
              }
            }, null, 2131099990);
            AppMethodBeat.o(21487);
            return;
          }
          Object localObject = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
          ((Intent)localObject).addFlags(335544320);
          ((Intent)localObject).putExtra("nofification_type", "backup_move_notification");
          paramAnonymousView = aj.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(21487);
          return;
          label340:
          localObject = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
          ((Intent)localObject).addFlags(335544320);
          ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
          paramAnonymousView = aj.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(21487);
          return;
          label443:
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 21L, 1L, false);
          com.tencent.mm.plugin.report.service.h.vKh.f(11788, new Object[] { Integer.valueOf(3) });
          paramAnonymousView = new Intent(BackupUI.this, BackupMoveChooseUI.class);
          MMWizardActivity.V(BackupUI.this, paramAnonymousView);
          AppMethodBeat.o(21487);
        }
      });
      setBackBtn(new BackupUI.2(this));
      AppMethodBeat.o(21491);
      return;
      com.tencent.mm.plugin.backup.d.b.bwC().bwG().bwA();
      break;
      label300:
      this.mus.setText(2131756268);
      this.mus.setTextColor(getResources().getColor(2131099992));
      this.muH.setEnabled(true);
      muI = true;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21494);
    ad.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
    super.onDestroy();
    com.tencent.mm.plugin.backup.d.b.bwC().bwG().cancel();
    com.tencent.mm.plugin.backup.d.a locala = com.tencent.mm.plugin.backup.d.b.bwC().bwG();
    ad.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
    locala.msn = null;
    locala.msp = null;
    locala.mso = null;
    locala.msr = false;
    locala.msq = false;
    AppMethodBeat.o(21494);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21492);
    super.onStart();
    this.mtD.av(5000L, 5000L);
    AppMethodBeat.o(21492);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21493);
    super.onStop();
    this.mtD.stopTimer();
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