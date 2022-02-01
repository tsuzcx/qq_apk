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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.d.a.1;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BackupUI
  extends MMWizardActivity
{
  private static boolean nxg = false;
  private TextView nwR;
  private av nwc;
  private Button nxf;
  
  public BackupUI()
  {
    AppMethodBeat.i(21490);
    this.nwc = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21489);
        if (bt.isNullOrNil(com.tencent.mm.plugin.backup.b.g.eh(BackupUI.this))) {
          if (BackupUI.nxg)
          {
            BackupUI.a(BackupUI.this).setText(2131756267);
            BackupUI.a(BackupUI.this).setTextColor(BackupUI.this.getResources().getColor(2131099991));
            BackupUI.b(BackupUI.this).setEnabled(false);
            BackupUI.access$002(false);
            com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(21489);
          return true;
          if (!BackupUI.nxg)
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
    com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.plugin.backup.g.b.bIG();
    this.nwR = ((TextView)findViewById(2131297059));
    this.nxf = ((Button)findViewById(2131297055));
    com.tencent.mm.plugin.backup.d.b.bHG();
    paramBundle = com.tencent.mm.plugin.backup.d.b.bHc().edit();
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
    paramBundle.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
    paramBundle.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    paramBundle.commit();
    if (!com.tencent.mm.plugin.backup.d.b.bHG().bHK().nuP)
    {
      paramBundle = com.tencent.mm.plugin.backup.d.b.bHG().bHK();
      d.bIY().bJb();
      com.tencent.mm.sdk.g.b.c(new a.1(paramBundle), "BakMoveChooseServer.calculateToChoose");
      if (!bt.isNullOrNil(com.tencent.mm.plugin.backup.b.g.eh(this))) {
        break label300;
      }
      this.nwR.setText(2131756267);
      this.nwR.setTextColor(getResources().getColor(2131099991));
      this.nxf.setEnabled(false);
      nxg = false;
      com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      this.nxf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21487);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          ba.aBQ();
          if (((Boolean)c.ajl().get(al.a.Ixg, Boolean.FALSE)).booleanValue())
          {
            if (com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ == -100)
            {
              ba.aBQ();
              c.ajl().set(al.a.Ixg, Boolean.FALSE);
            }
          }
          else
          {
            ba.aBQ();
            if (!((Boolean)c.ajl().get(al.a.Ixc, Boolean.FALSE)).booleanValue())
            {
              ba.aBQ();
              if (!((Boolean)c.ajl().get(al.a.Ixd, Boolean.FALSE)).booleanValue()) {}
            }
            else
            {
              if (com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ != -100) {
                break label393;
              }
              ba.aBQ();
              c.ajl().set(al.a.Ixc, Boolean.FALSE);
              ba.aBQ();
              c.ajl().set(al.a.Ixd, Boolean.FALSE);
            }
            int i = com.tencent.mm.plugin.backup.b.g.bHn();
            if (i >= 50) {
              break label508;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 7L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(11787, new Object[] { Integer.valueOf(4) });
            h.a(BackupUI.this, 2131756120, 2131756119, 2131756270, 2131756090, false, new BackupUI.1.1(this, i), null, 2131099990);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            localObject = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
            ((Intent)localObject).addFlags(335544320);
            ((Intent)localObject).putExtra("nofification_type", "backup_move_notification");
            paramAnonymousView = aj.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            label393:
            localObject = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
            ((Intent)localObject).addFlags(335544320);
            ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
            paramAnonymousView = aj.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21487);
            return;
            label508:
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 21L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new Intent(BackupUI.this, BackupMoveChooseUI.class);
            MMWizardActivity.al(BackupUI.this, paramAnonymousView);
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
      com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHE();
      break;
      label300:
      this.nwR.setText(2131756268);
      this.nwR.setTextColor(getResources().getColor(2131099992));
      this.nxf.setEnabled(true);
      nxg = true;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21494);
    ad.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
    super.onDestroy();
    com.tencent.mm.plugin.backup.d.b.bHG().bHK().cancel();
    com.tencent.mm.plugin.backup.d.a locala = com.tencent.mm.plugin.backup.d.b.bHG().bHK();
    ad.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
    locala.nuM = null;
    locala.nuO = null;
    locala.nuN = null;
    locala.nuQ = false;
    locala.nuP = false;
    AppMethodBeat.o(21494);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21492);
    super.onStart();
    this.nwc.az(5000L, 5000L);
    AppMethodBeat.o(21492);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21493);
    super.onStop();
    this.nwc.stopTimer();
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