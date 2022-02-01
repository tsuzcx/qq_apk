package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.lang.reflect.Method;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveRecoverUI
  extends MMWizardActivity
{
  private static boolean pNU = false;
  private static boolean vaz = false;
  public TextView ngm;
  private b.d uXI;
  public TextView vat;
  public TextView vau;
  public TextView vav;
  public TextView vaw;
  public ImageView vax;
  private RoundProgressBtn vay;
  
  public BackupMoveRecoverUI()
  {
    AppMethodBeat.i(21448);
    this.uXI = new b.d()
    {
      public final void Fc(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21443);
        Object localObject1 = com.tencent.mm.plugin.backup.d.b.cVs().cUJ();
        Log.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BackupMoveRecoverUI.vaz), Integer.valueOf(((e)localObject1).uWh), Integer.valueOf(((e)localObject1).uWi), Integer.valueOf(((e)localObject1).uWj) });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.a(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.finish();
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.vav.setText(R.l.gsy);
          BackupMoveRecoverUI.this.vaw.setText(R.l.gtd);
          BackupMoveRecoverUI.this.vaw.setVisibility(0);
          BackupMoveRecoverUI.this.vat.setVisibility(4);
          BackupMoveRecoverUI.this.vau.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.vav.setText(R.l.gts);
          BackupMoveRecoverUI.this.vaw.setText(R.l.gtd);
          BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
          BackupMoveRecoverUI.this.vaw.setVisibility(0);
          BackupMoveRecoverUI.this.vat.setVisibility(4);
          BackupMoveRecoverUI.this.vau.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.vav.setText(R.l.gta);
          BackupMoveRecoverUI.this.vat.setText(R.l.gtc);
          BackupMoveRecoverUI.this.vau.setText(R.l.gtb);
          BackupMoveRecoverUI.this.vaw.setVisibility(4);
          BackupMoveRecoverUI.this.vat.setVisibility(0);
          BackupMoveRecoverUI.this.vau.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.vat.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21417);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.BackupMoveRecoverUI", "click only move new msg.");
              com.tencent.mm.plugin.backup.d.b.cVs().cVv().lY(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21417);
            }
          });
          BackupMoveRecoverUI.this.vau.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21431);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.BackupMoveRecoverUI", "click move all msg.");
              com.tencent.mm.plugin.backup.d.b.cVs().cVv().lY(true);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21431);
            }
          });
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
          Object localObject2 = BackupMoveRecoverUI.this.vav;
          Object localObject3 = BackupMoveRecoverUI.this;
          paramAnonymousInt = R.l.gtx;
          int i = ((e)localObject1).uWh;
          int j = ((e)localObject1).uWi;
          com.tencent.mm.plugin.backup.d.b.cVs().cVv();
          ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.d.c.cVB() }));
          BackupMoveRecoverUI.this.vaw.setText(R.l.gtd);
          BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
          BackupMoveRecoverUI.this.vaw.setVisibility(0);
          BackupMoveRecoverUI.this.vat.setVisibility(8);
          BackupMoveRecoverUI.this.vau.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).cUS());
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21435);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
              com.tencent.mm.plugin.backup.d.b.cVs().cVv().cVA();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21435);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.vav.setText(R.l.gtg);
          BackupMoveRecoverUI.this.vaw.setText(R.l.gti);
          BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
          BackupMoveRecoverUI.this.vaw.setVisibility(0);
          BackupMoveRecoverUI.this.vat.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.vat.setText(R.l.gth);
          BackupMoveRecoverUI.this.vat.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21436);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click scan qrcode.");
              paramAnonymous2View = new Intent();
              paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
              paramAnonymous2View.setFlags(268435456);
              com.tencent.mm.br.c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21436);
            }
          });
          BackupMoveRecoverUI.this.vau.setVisibility(0);
          BackupMoveRecoverUI.this.vau.setText(R.l.gtw);
          BackupMoveRecoverUI.this.vau.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21437);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
              com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = 29;
              BackupMoveRecoverUI.1.this.Fc(29);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21437);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.vav.setText(R.l.gtF);
          BackupMoveRecoverUI.this.vaw.setText(R.l.gtH);
          BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
          BackupMoveRecoverUI.this.vaw.setVisibility(0);
          BackupMoveRecoverUI.this.vat.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.vat.setText(R.l.gtE);
          BackupMoveRecoverUI.this.vat.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21438);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
              com.tencent.mm.plugin.backup.d.b.cVs().cVv();
              if (!com.tencent.mm.plugin.backup.d.c.cVx())
              {
                Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -22;
                BackupMoveRecoverUI.1.this.Fc(-22);
                h.OAn.idkeyStat(485L, 6L, 1L, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21438);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.cVs().cVv().lX(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21438);
            }
          });
          BackupMoveRecoverUI.this.vau.setVisibility(0);
          BackupMoveRecoverUI.this.vau.setText(R.l.gsz);
          BackupMoveRecoverUI.this.vau.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21440);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
              k.a(BackupMoveRecoverUI.this, R.l.gsB, R.l.gsA, R.l.gtv, R.l.gsm, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(21439);
                  Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.19.this.uZi) });
                  h.OAn.idkeyStat(485L, 48L, 1L, false);
                  com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
                  com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(true, true, -100);
                  AppMethodBeat.o(21439);
                }
              }, null, R.e.fkg);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21440);
            }
          });
          BackupMoveRecoverUI.this.ngm.setText(R.l.guS);
          BackupMoveRecoverUI.this.ngm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21441);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = 25;
              BackupMoveRecoverUI.e(BackupMoveRecoverUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21441);
            }
          });
          AppMethodBeat.o(21443);
          return;
          if (BackupMoveRecoverUI.vaz)
          {
            com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = 24;
            paramAnonymousInt = 24;
            break;
            Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[] { Boolean.valueOf(BackupMoveRecoverUI.cVQ()) });
            if (BackupMoveRecoverUI.cVQ())
            {
              BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
              BackupMoveRecoverUI.this.vav.setText(R.l.gty);
              BackupMoveRecoverUI.this.vaw.setText(R.l.gtA);
              BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
              BackupMoveRecoverUI.this.vat.setText(R.l.gtu);
              BackupMoveRecoverUI.this.vau.setText(R.l.gtv);
              BackupMoveRecoverUI.this.ngm.setText(R.l.guS);
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(0);
              BackupMoveRecoverUI.this.vau.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.vat.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21442);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                  com.tencent.mm.plugin.backup.d.b.cVs().cVv();
                  if (!com.tencent.mm.plugin.backup.d.c.cVx())
                  {
                    Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                    com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -22;
                    BackupMoveRecoverUI.1.this.Fc(-22);
                    h.OAn.idkeyStat(485L, 6L, 1L, false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21442);
                    return;
                  }
                  com.tencent.mm.plugin.backup.d.b.cVs().cVv().lX(false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21442);
                }
              });
              BackupMoveRecoverUI.this.vau.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21419);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                  k.a(BackupMoveRecoverUI.this, R.l.gsB, R.l.gsA, R.l.gtv, R.l.gsm, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21418);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.2.this.uZi) });
                      h.OAn.idkeyStat(485L, 48L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
                      com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(true, true, -100);
                      AppMethodBeat.o(21418);
                    }
                  }, null, R.e.fkg);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21419);
                }
              });
              BackupMoveRecoverUI.this.ngm.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21420);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = 25;
                  BackupMoveRecoverUI.f(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21420);
                }
              });
              AppMethodBeat.o(21443);
              return;
            }
            if (BackupMoveRecoverUI.vaz)
            {
              com.tencent.mm.plugin.backup.d.b.cVs().cVv();
              if (!com.tencent.mm.plugin.backup.d.c.cVx())
              {
                Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -22;
                Fc(-22);
                h.OAn.idkeyStat(485L, 6L, 1L, false);
                AppMethodBeat.o(21443);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.cVs().cVv().lX(false);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_recover);
              BackupMoveRecoverUI.this.vav.setText(BackupMoveRecoverUI.this.getString(R.l.gtp, new Object[] { Integer.valueOf(((e)localObject1).uWj) }));
              BackupMoveRecoverUI.this.vaw.setText(R.l.gtq);
              BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(4);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_recover);
              BackupMoveRecoverUI.this.vav.setText(R.l.guR);
              BackupMoveRecoverUI.this.vaw.setText(R.l.gtq);
              BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(4);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_recover_finish);
              BackupMoveRecoverUI.this.vav.setText(R.l.gtn);
              BackupMoveRecoverUI.this.vaw.setText(BackupMoveRecoverUI.this.getString(R.l.gto, new Object[] { Integer.valueOf(((e)localObject1).uWh), Integer.valueOf(((e)localObject1).uWi) }));
              BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
              BackupMoveRecoverUI.this.vat.setText(R.l.gsq);
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(0);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.vat.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21421);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
                  com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -100;
                  BackupMoveRecoverUI.g(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21421);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
              localObject2 = BackupMoveRecoverUI.this.vav;
              localObject3 = BackupMoveRecoverUI.this;
              paramAnonymousInt = R.l.gtx;
              i = ((e)localObject1).uWh;
              j = ((e)localObject1).uWi;
              com.tencent.mm.plugin.backup.d.b.cVs().cVv();
              ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.d.c.cVB() }));
              BackupMoveRecoverUI.this.vaw.setText(R.l.gtJ);
              BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkh));
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(8);
              BackupMoveRecoverUI.this.vau.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).cUS());
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21422);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                  com.tencent.mm.plugin.backup.d.b.cVs().cVv().cVA();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21422);
                }
              });
              BackupMoveRecoverUI.this.vau.setText(R.l.gtK);
              BackupMoveRecoverUI.this.vau.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21423);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                  try
                  {
                    localObject = new Intent();
                    ((Intent)localObject).setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
                    paramAnonymous2View = BackupMoveRecoverUI.this;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                    com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2View, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymous2View.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                    com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2View, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21423);
                    return;
                  }
                  catch (Exception paramAnonymous2View)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.BackupMoveRecoverUI", "jump to Settings$TetherSettingsActivity failed");
                      com.tencent.mm.pluginsdk.permission.b.lx(BackupMoveRecoverUI.this.getContext());
                    }
                  }
                }
              });
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.vav.setText(BackupMoveRecoverUI.this.getString(R.l.gte, new Object[] { Integer.valueOf(((e)localObject1).uWh), Integer.valueOf(((e)localObject1).uWi), "0M" }));
              BackupMoveRecoverUI.this.vaw.setText(R.l.gsP);
              BackupMoveRecoverUI.this.vat.setText(R.l.gtt);
              BackupMoveRecoverUI.this.vau.setText(R.l.gtw);
              BackupMoveRecoverUI.this.vat.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21424);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  com.tencent.mm.plugin.backup.d.b.cVs().cVv().Fg(7);
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  com.tencent.mm.br.c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21424);
                }
              });
              BackupMoveRecoverUI.this.vau.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21426);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  k.a(BackupMoveRecoverUI.this, R.l.gsD, R.l.gsC, R.l.gtw, R.l.gsm, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21425);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.8.this.uZi) });
                      h.OAn.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.cVs().cVv().Fg(6);
                      com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
                      com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(true, true, -100);
                      AppMethodBeat.o(21425);
                    }
                  }, null, R.e.fkg);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21426);
                }
              });
              BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkg));
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(0);
              BackupMoveRecoverUI.this.vau.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.vav.setText(R.l.gsS);
              localObject2 = g.fC(BackupMoveRecoverUI.this);
              localObject3 = com.tencent.mm.plugin.backup.d.b.cVs().cVv().uYR;
              localObject1 = localObject2;
              if (Util.isNullOrNil((String)localObject2)) {
                localObject1 = "移动网络";
              }
              localObject2 = localObject3;
              if (Util.isNullOrNil((String)localObject3)) {
                localObject2 = "移动网络";
              }
              if ((!((String)localObject1).equals("wifi")) && (!((String)localObject2).equals("wifi"))) {
                BackupMoveRecoverUI.this.vaw.setText(BackupMoveRecoverUI.this.getString(R.l.gsT, new Object[] { localObject1, localObject2 }));
              }
              BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkg));
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(4);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.vav.setText(R.l.gsF);
              BackupMoveRecoverUI.this.vaw.setText(R.l.gsG);
              BackupMoveRecoverUI.this.vat.setText(R.l.gtr);
              BackupMoveRecoverUI.this.vau.setText(R.l.gtw);
              BackupMoveRecoverUI.this.vaw.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.fkg));
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(0);
              BackupMoveRecoverUI.this.vau.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.vat.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21427);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("title", BackupMoveRecoverUI.this.getString(R.l.gtf));
                  paramAnonymous2View.putExtra("rawUrl", BackupMoveRecoverUI.this.getString(R.l.backup_move_open_wifiap_doc, new Object[] { LocaleUtil.getApplicationLanguage() }));
                  paramAnonymous2View.putExtra("showShare", false);
                  paramAnonymous2View.putExtra("neverGetA8Key", true);
                  com.tencent.mm.br.c.b(BackupMoveRecoverUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21427);
                }
              });
              BackupMoveRecoverUI.this.vau.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21429);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  k.a(BackupMoveRecoverUI.this, R.l.gsD, R.l.gsC, R.l.gtw, R.l.gsm, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21428);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.10.this.uZi) });
                      h.OAn.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.cVs().cVv().Fg(5);
                      com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
                      com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(true, true, -100);
                      AppMethodBeat.o(21428);
                    }
                  }, null, R.e.fkg);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21429);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.vav.setText(R.l.gsH);
              BackupMoveRecoverUI.this.vat.setText(R.l.gtt);
              BackupMoveRecoverUI.this.vau.setText(R.l.gtw);
              BackupMoveRecoverUI.this.vaw.setVisibility(4);
              BackupMoveRecoverUI.this.vat.setVisibility(0);
              BackupMoveRecoverUI.this.vau.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.vat.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21430);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  h.OAn.b(11788, new Object[] { Integer.valueOf(9) });
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  com.tencent.mm.br.c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21430);
                }
              });
              BackupMoveRecoverUI.this.vau.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21433);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  k.a(BackupMoveRecoverUI.this, R.l.gsD, R.l.gsC, R.l.gtw, R.l.gsm, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21432);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.13.this.uZi) });
                      h.OAn.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.cVs().cVv().Fg(5);
                      com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
                      com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(true, true, -100);
                      AppMethodBeat.o(21432);
                    }
                  }, null, R.e.fkg);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21433);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.vav.setText(R.l.gsX);
              BackupMoveRecoverUI.this.vaw.setVisibility(4);
              BackupMoveRecoverUI.this.vat.setVisibility(4);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.g.backup_move);
              BackupMoveRecoverUI.this.vav.setText(R.l.gsy);
              BackupMoveRecoverUI.this.vaw.setText(R.l.gtd);
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(4);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              k.a(BackupMoveRecoverUI.this, R.l.gsO, 0, R.l.guZ, 0, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(21434);
                  Log.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
                  BackupMoveRecoverUI.h(BackupMoveRecoverUI.this);
                  AppMethodBeat.o(21434);
                }
              }, null, R.e.fkf);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.vav.setText(R.l.gsQ);
              BackupMoveRecoverUI.this.vaw.setText(BackupMoveRecoverUI.this.getString(R.l.gsR, new Object[] { Util.getSizeKB(com.tencent.mm.plugin.backup.d.b.cVs().cVv().uZb) }));
              BackupMoveRecoverUI.this.vaw.setVisibility(0);
              BackupMoveRecoverUI.this.vat.setVisibility(4);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.vav.setText(R.l.gsI);
              BackupMoveRecoverUI.this.vaw.setVisibility(4);
              BackupMoveRecoverUI.this.vat.setVisibility(4);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.vax.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.vav.setText(R.l.gsM);
              com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
              BackupMoveRecoverUI.this.vaw.setVisibility(4);
              BackupMoveRecoverUI.this.vat.setVisibility(4);
              BackupMoveRecoverUI.this.vau.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.i(BackupMoveRecoverUI.this);
            }
          }
        }
      }
      
      public final void cUI() {}
    };
    AppMethodBeat.o(21448);
  }
  
  private void cVP()
  {
    AppMethodBeat.i(21455);
    final int i = com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg;
    Log.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
    switch (i)
    {
    default: 
    case -22: 
    case -21: 
    case -14: 
    case -13: 
    case -5: 
    case -3: 
    case -2: 
    case -1: 
    case 1: 
    case 27: 
    case 24: 
      for (;;)
      {
        aAp(1);
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(false, false, -100);
        AppMethodBeat.o(21455);
        return;
        Log.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(true, false, -100);
        com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = 25;
      }
    case 52: 
      k.a(this, R.l.gsD, R.l.gsC, R.l.gtw, R.l.gsm, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21445);
          Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[] { Integer.valueOf(i) });
          h.OAn.idkeyStat(485L, 44L, 1L, false);
          com.tencent.mm.plugin.backup.d.b.cVs().cVv().Fg(5);
          com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
          com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(true, true, -100);
          AppMethodBeat.o(21445);
        }
      }, null, R.e.fkg);
      AppMethodBeat.o(21455);
      return;
    }
    k.a(this, R.l.gtX, R.l.gtW, R.l.guM, R.l.gsm, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21446);
        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", new Object[] { Integer.valueOf(i) });
        h.OAn.idkeyStat(485L, 48L, 1L, false);
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acPc, Boolean.FALSE);
        com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
        com.tencent.mm.plugin.backup.d.b.cVs().cVv().a(true, true, -100);
        BackupMoveRecoverUI.k(BackupMoveRecoverUI.this);
        AppMethodBeat.o(21446);
      }
    }, null, R.e.fkg);
    AppMethodBeat.o(21455);
  }
  
  public int getLayoutId()
  {
    return R.i.gey;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21450);
    this.ngm = ((TextView)findViewById(R.h.fsV));
    this.vax = ((ImageView)findViewById(R.h.fsW));
    this.vav = ((TextView)findViewById(R.h.ftd));
    this.vaw = ((TextView)findViewById(R.h.fkh));
    this.vat = ((TextView)findViewById(R.h.fsC));
    this.vau = ((TextView)findViewById(R.h.fsB));
    this.vay = ((RoundProgressBtn)findViewById(R.h.ftc));
    AppMethodBeat.o(21450);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21449);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21449);
      return;
    }
    Log.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.pFn.aDA();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.cVs().cVv().uYK = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      Log.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.cVs().cVv().uYK) });
      AppMethodBeat.o(21449);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { Util.getStack() });
      AppMethodBeat.o(21449);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21453);
    Log.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
    super.onDestroy();
    AppMethodBeat.o(21453);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21454);
    if (paramInt == 4)
    {
      cVP();
      AppMethodBeat.o(21454);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21454);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(21452);
    super.onPause();
    Log.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
    vaz = false;
    com.tencent.mm.plugin.backup.d.c localc = com.tencent.mm.plugin.backup.d.b.cVs().cVv();
    b.d locald = this.uXI;
    synchronized (localc.uYW)
    {
      localc.uYW.remove(locald);
      AppMethodBeat.o(21452);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21451);
    super.onResume();
    Log.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
    vaz = true;
    com.tencent.mm.plugin.backup.d.c localc = com.tencent.mm.plugin.backup.d.b.cVs().cVv();
    b.d locald = this.uXI;
    synchronized (localc.uYW)
    {
      localc.uYW.add(locald);
      pNU = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
      this.uXI.Fc(com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg);
      AppMethodBeat.o(21451);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI
 * JD-Core Version:    0.7.0.1
 */