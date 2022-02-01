package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
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
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.lang.reflect.Method;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveRecoverUI
  extends MMWizardActivity
{
  private static boolean mRn = false;
  private static boolean rPk = false;
  public TextView kCQ;
  private b.d rMv;
  public TextView rPe;
  public TextView rPf;
  public TextView rPg;
  public TextView rPh;
  public ImageView rPi;
  private RoundProgressBtn rPj;
  
  public BackupMoveRecoverUI()
  {
    AppMethodBeat.i(21448);
    this.rMv = new b.d()
    {
      public final void EB(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21443);
        Object localObject1 = com.tencent.mm.plugin.backup.d.b.csI().crZ();
        Log.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BackupMoveRecoverUI.rPk), Integer.valueOf(((e)localObject1).rKT), Integer.valueOf(((e)localObject1).rKU), Integer.valueOf(((e)localObject1).rKV) });
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
          BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.rPg.setText(R.l.epx);
          BackupMoveRecoverUI.this.rPh.setText(R.l.eqc);
          BackupMoveRecoverUI.this.rPh.setVisibility(0);
          BackupMoveRecoverUI.this.rPe.setVisibility(4);
          BackupMoveRecoverUI.this.rPf.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.rPg.setText(R.l.eqr);
          BackupMoveRecoverUI.this.rPh.setText(R.l.eqc);
          BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
          BackupMoveRecoverUI.this.rPh.setVisibility(0);
          BackupMoveRecoverUI.this.rPe.setVisibility(4);
          BackupMoveRecoverUI.this.rPf.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.rPg.setText(R.l.epZ);
          BackupMoveRecoverUI.this.rPe.setText(R.l.eqb);
          BackupMoveRecoverUI.this.rPf.setText(R.l.eqa);
          BackupMoveRecoverUI.this.rPh.setVisibility(4);
          BackupMoveRecoverUI.this.rPe.setVisibility(0);
          BackupMoveRecoverUI.this.rPf.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.rPe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21417);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.BackupMoveRecoverUI", "click only move new msg.");
              com.tencent.mm.plugin.backup.d.b.csI().csL().kL(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21417);
            }
          });
          BackupMoveRecoverUI.this.rPf.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21431);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.BackupMoveRecoverUI", "click move all msg.");
              com.tencent.mm.plugin.backup.d.b.csI().csL().kL(true);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21431);
            }
          });
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
          Object localObject2 = BackupMoveRecoverUI.this.rPg;
          Object localObject3 = BackupMoveRecoverUI.this;
          paramAnonymousInt = R.l.eqw;
          int i = ((e)localObject1).rKT;
          int j = ((e)localObject1).rKU;
          com.tencent.mm.plugin.backup.d.b.csI().csL();
          ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.d.c.csR() }));
          BackupMoveRecoverUI.this.rPh.setText(R.l.eqc);
          BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
          BackupMoveRecoverUI.this.rPh.setVisibility(0);
          BackupMoveRecoverUI.this.rPe.setVisibility(8);
          BackupMoveRecoverUI.this.rPf.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).csi());
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21435);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
              com.tencent.mm.plugin.backup.d.b.csI().csL().csQ();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21435);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.rPg.setText(R.l.eqf);
          BackupMoveRecoverUI.this.rPh.setText(R.l.eqh);
          BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
          BackupMoveRecoverUI.this.rPh.setVisibility(0);
          BackupMoveRecoverUI.this.rPe.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.rPe.setText(R.l.eqg);
          BackupMoveRecoverUI.this.rPe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21436);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click scan qrcode.");
              paramAnonymous2View = new Intent();
              paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
              paramAnonymous2View.setFlags(268435456);
              com.tencent.mm.by.c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21436);
            }
          });
          BackupMoveRecoverUI.this.rPf.setVisibility(0);
          BackupMoveRecoverUI.this.rPf.setText(R.l.eqv);
          BackupMoveRecoverUI.this.rPf.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21437);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
              com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = 29;
              BackupMoveRecoverUI.1.this.EB(29);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21437);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
          BackupMoveRecoverUI.this.rPg.setText(R.l.eqE);
          BackupMoveRecoverUI.this.rPh.setText(R.l.eqG);
          BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
          BackupMoveRecoverUI.this.rPh.setVisibility(0);
          BackupMoveRecoverUI.this.rPe.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.rPe.setText(R.l.eqD);
          BackupMoveRecoverUI.this.rPe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21438);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
              com.tencent.mm.plugin.backup.d.b.csI().csL();
              if (!com.tencent.mm.plugin.backup.d.c.csN())
              {
                Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -22;
                BackupMoveRecoverUI.1.this.EB(-22);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 6L, 1L, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21438);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.csI().csL().kK(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21438);
            }
          });
          BackupMoveRecoverUI.this.rPf.setVisibility(0);
          BackupMoveRecoverUI.this.rPf.setText(R.l.epy);
          BackupMoveRecoverUI.this.rPf.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21440);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
              com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, R.l.epA, R.l.epz, R.l.equ, R.l.epl, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(21439);
                  Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.19.this.rNU) });
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 48L, 1L, false);
                  com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
                  com.tencent.mm.plugin.backup.d.b.csI().csL().a(true, true, -100);
                  AppMethodBeat.o(21439);
                }
              }, null, R.e.dkf);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21440);
            }
          });
          BackupMoveRecoverUI.this.kCQ.setText(R.l.erR);
          BackupMoveRecoverUI.this.kCQ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21441);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = 25;
              BackupMoveRecoverUI.e(BackupMoveRecoverUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21441);
            }
          });
          AppMethodBeat.o(21443);
          return;
          if (BackupMoveRecoverUI.rPk)
          {
            com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = 24;
            paramAnonymousInt = 24;
            break;
            Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[] { Boolean.valueOf(BackupMoveRecoverUI.aaV()) });
            if (BackupMoveRecoverUI.aaV())
            {
              BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
              BackupMoveRecoverUI.this.rPg.setText(R.l.eqx);
              BackupMoveRecoverUI.this.rPh.setText(R.l.eqz);
              BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
              BackupMoveRecoverUI.this.rPe.setText(R.l.eqt);
              BackupMoveRecoverUI.this.rPf.setText(R.l.equ);
              BackupMoveRecoverUI.this.kCQ.setText(R.l.erR);
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(0);
              BackupMoveRecoverUI.this.rPf.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.rPe.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21442);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                  com.tencent.mm.plugin.backup.d.b.csI().csL();
                  if (!com.tencent.mm.plugin.backup.d.c.csN())
                  {
                    Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                    com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -22;
                    BackupMoveRecoverUI.1.this.EB(-22);
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 6L, 1L, false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21442);
                    return;
                  }
                  com.tencent.mm.plugin.backup.d.b.csI().csL().kK(false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21442);
                }
              });
              BackupMoveRecoverUI.this.rPf.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21419);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, R.l.epA, R.l.epz, R.l.equ, R.l.epl, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21418);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.2.this.rNU) });
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 48L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
                      com.tencent.mm.plugin.backup.d.b.csI().csL().a(true, true, -100);
                      AppMethodBeat.o(21418);
                    }
                  }, null, R.e.dkf);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21419);
                }
              });
              BackupMoveRecoverUI.this.kCQ.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21420);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = 25;
                  BackupMoveRecoverUI.f(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21420);
                }
              });
              AppMethodBeat.o(21443);
              return;
            }
            if (BackupMoveRecoverUI.rPk)
            {
              com.tencent.mm.plugin.backup.d.b.csI().csL();
              if (!com.tencent.mm.plugin.backup.d.c.csN())
              {
                Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -22;
                EB(-22);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 6L, 1L, false);
                AppMethodBeat.o(21443);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.csI().csL().kK(false);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_recover);
              BackupMoveRecoverUI.this.rPg.setText(BackupMoveRecoverUI.this.getString(R.l.eqo, new Object[] { Integer.valueOf(((e)localObject1).rKV) }));
              BackupMoveRecoverUI.this.rPh.setText(R.l.eqp);
              BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(4);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_recover);
              BackupMoveRecoverUI.this.rPg.setText(R.l.erQ);
              BackupMoveRecoverUI.this.rPh.setText(R.l.eqp);
              BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(4);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_recover_finish);
              BackupMoveRecoverUI.this.rPg.setText(R.l.eqm);
              BackupMoveRecoverUI.this.rPh.setText(BackupMoveRecoverUI.this.getString(R.l.eqn, new Object[] { Integer.valueOf(((e)localObject1).rKT), Integer.valueOf(((e)localObject1).rKU) }));
              BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
              BackupMoveRecoverUI.this.rPe.setText(R.l.epp);
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(0);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.rPe.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21421);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
                  com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = -100;
                  BackupMoveRecoverUI.g(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21421);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
              localObject2 = BackupMoveRecoverUI.this.rPg;
              localObject3 = BackupMoveRecoverUI.this;
              paramAnonymousInt = R.l.eqw;
              i = ((e)localObject1).rKT;
              j = ((e)localObject1).rKU;
              com.tencent.mm.plugin.backup.d.b.csI().csL();
              ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.d.c.csR() }));
              BackupMoveRecoverUI.this.rPh.setText(R.l.eqI);
              BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkg));
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(8);
              BackupMoveRecoverUI.this.rPf.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).csi());
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21422);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                  com.tencent.mm.plugin.backup.d.b.csI().csL().csQ();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21422);
                }
              });
              BackupMoveRecoverUI.this.rPf.setText(R.l.eqJ);
              BackupMoveRecoverUI.this.rPf.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21423);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                  try
                  {
                    localObject = new Intent();
                    ((Intent)localObject).setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
                    paramAnonymous2View = BackupMoveRecoverUI.this;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                    com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2View, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymous2View.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
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
                      paramAnonymous2View = BackupMoveRecoverUI.this;
                      localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                      com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2View, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramAnonymous2View.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                      com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2View, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                  }
                }
              });
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.rPg.setText(BackupMoveRecoverUI.this.getString(R.l.eqd, new Object[] { Integer.valueOf(((e)localObject1).rKT), Integer.valueOf(((e)localObject1).rKU), "0M" }));
              BackupMoveRecoverUI.this.rPh.setText(R.l.epO);
              BackupMoveRecoverUI.this.rPe.setText(R.l.eqs);
              BackupMoveRecoverUI.this.rPf.setText(R.l.eqv);
              BackupMoveRecoverUI.this.rPe.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21424);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.plugin.backup.d.b.csI().csL().EF(7);
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  com.tencent.mm.by.c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21424);
                }
              });
              BackupMoveRecoverUI.this.rPf.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21426);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, R.l.epC, R.l.epB, R.l.eqv, R.l.epl, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21425);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.8.this.rNU) });
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.csI().csL().EF(6);
                      com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
                      com.tencent.mm.plugin.backup.d.b.csI().csL().a(true, true, -100);
                      AppMethodBeat.o(21425);
                    }
                  }, null, R.e.dkf);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21426);
                }
              });
              BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkf));
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(0);
              BackupMoveRecoverUI.this.rPf.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.rPg.setText(R.l.epR);
              localObject2 = g.eH(BackupMoveRecoverUI.this);
              localObject3 = com.tencent.mm.plugin.backup.d.b.csI().csL().rND;
              localObject1 = localObject2;
              if (Util.isNullOrNil((String)localObject2)) {
                localObject1 = "移动网络";
              }
              localObject2 = localObject3;
              if (Util.isNullOrNil((String)localObject3)) {
                localObject2 = "移动网络";
              }
              if ((!((String)localObject1).equals("wifi")) && (!((String)localObject2).equals("wifi"))) {
                BackupMoveRecoverUI.this.rPh.setText(BackupMoveRecoverUI.this.getString(R.l.epS, new Object[] { localObject1, localObject2 }));
              }
              BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkf));
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(4);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.rPg.setText(R.l.epE);
              BackupMoveRecoverUI.this.rPh.setText(R.l.epF);
              BackupMoveRecoverUI.this.rPe.setText(R.l.eqq);
              BackupMoveRecoverUI.this.rPf.setText(R.l.eqv);
              BackupMoveRecoverUI.this.rPh.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.e.dkf));
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(0);
              BackupMoveRecoverUI.this.rPf.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.rPe.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21427);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("title", BackupMoveRecoverUI.this.getString(R.l.eqe));
                  paramAnonymous2View.putExtra("rawUrl", BackupMoveRecoverUI.this.getString(R.l.backup_move_open_wifiap_doc, new Object[] { LocaleUtil.getApplicationLanguage() }));
                  paramAnonymous2View.putExtra("showShare", false);
                  paramAnonymous2View.putExtra("neverGetA8Key", true);
                  com.tencent.mm.by.c.b(BackupMoveRecoverUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21427);
                }
              });
              BackupMoveRecoverUI.this.rPf.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21429);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, R.l.epC, R.l.epB, R.l.eqv, R.l.epl, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21428);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.10.this.rNU) });
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.csI().csL().EF(5);
                      com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
                      com.tencent.mm.plugin.backup.d.b.csI().csL().a(true, true, -100);
                      AppMethodBeat.o(21428);
                    }
                  }, null, R.e.dkf);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21429);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.rPg.setText(R.l.epG);
              BackupMoveRecoverUI.this.rPe.setText(R.l.eqs);
              BackupMoveRecoverUI.this.rPf.setText(R.l.eqv);
              BackupMoveRecoverUI.this.rPh.setVisibility(4);
              BackupMoveRecoverUI.this.rPe.setVisibility(0);
              BackupMoveRecoverUI.this.rPf.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.rPe.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21430);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.plugin.report.service.h.IzE.a(11788, new Object[] { Integer.valueOf(9) });
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  com.tencent.mm.by.c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21430);
                }
              });
              BackupMoveRecoverUI.this.rPf.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21433);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, R.l.epC, R.l.epB, R.l.eqv, R.l.epl, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21432);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.13.this.rNU) });
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.csI().csL().EF(5);
                      com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
                      com.tencent.mm.plugin.backup.d.b.csI().csL().a(true, true, -100);
                      AppMethodBeat.o(21432);
                    }
                  }, null, R.e.dkf);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21433);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.rPg.setText(R.l.epW);
              BackupMoveRecoverUI.this.rPh.setVisibility(4);
              BackupMoveRecoverUI.this.rPe.setVisibility(4);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.g.backup_move);
              BackupMoveRecoverUI.this.rPg.setText(R.l.epx);
              BackupMoveRecoverUI.this.rPh.setText(R.l.eqc);
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(4);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, R.l.epN, 0, R.l.erY, 0, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(21434);
                  Log.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
                  BackupMoveRecoverUI.h(BackupMoveRecoverUI.this);
                  AppMethodBeat.o(21434);
                }
              }, null, R.e.dke);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.rPg.setText(R.l.epP);
              BackupMoveRecoverUI.this.rPh.setText(BackupMoveRecoverUI.this.getString(R.l.epQ, new Object[] { Util.getSizeKB(com.tencent.mm.plugin.backup.d.b.csI().csL().rNN) }));
              BackupMoveRecoverUI.this.rPh.setVisibility(0);
              BackupMoveRecoverUI.this.rPe.setVisibility(4);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.rPg.setText(R.l.epH);
              BackupMoveRecoverUI.this.rPh.setVisibility(4);
              BackupMoveRecoverUI.this.rPe.setVisibility(4);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.rPi.setImageResource(R.k.backup_move_error);
              BackupMoveRecoverUI.this.rPg.setText(R.l.epL);
              com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
              BackupMoveRecoverUI.this.rPh.setVisibility(4);
              BackupMoveRecoverUI.this.rPe.setVisibility(4);
              BackupMoveRecoverUI.this.rPf.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
            }
          }
        }
      }
      
      public final void crY() {}
    };
    AppMethodBeat.o(21448);
  }
  
  private void ctg()
  {
    AppMethodBeat.i(21455);
    final int i = com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS;
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
        atX(1);
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.csI().csL().a(false, false, -100);
        AppMethodBeat.o(21455);
        return;
        Log.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.backup.d.b.csI().csL().a(true, false, -100);
        com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS = 25;
      }
    case 52: 
      com.tencent.mm.ui.base.h.a(this, R.l.epC, R.l.epB, R.l.eqv, R.l.epl, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21445);
          Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 44L, 1L, false);
          com.tencent.mm.plugin.backup.d.b.csI().csL().EF(5);
          com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
          com.tencent.mm.plugin.backup.d.b.csI().csL().a(true, true, -100);
          AppMethodBeat.o(21445);
        }
      }, null, R.e.dkf);
      AppMethodBeat.o(21455);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, R.l.eqW, R.l.eqV, R.l.erL, R.l.epl, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21446);
        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(485L, 48L, 1L, false);
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.VnH, Boolean.FALSE);
        com.tencent.mm.plugin.backup.d.b.csI().csJ().stop();
        com.tencent.mm.plugin.backup.d.b.csI().csL().a(true, true, -100);
        BackupMoveRecoverUI.j(BackupMoveRecoverUI.this);
        AppMethodBeat.o(21446);
      }
    }, null, R.e.dkf);
    AppMethodBeat.o(21455);
  }
  
  public int getLayoutId()
  {
    return R.i.ebQ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21450);
    this.kCQ = ((TextView)findViewById(R.h.dsE));
    this.rPi = ((ImageView)findViewById(R.h.dsF));
    this.rPg = ((TextView)findViewById(R.h.dsM));
    this.rPh = ((TextView)findViewById(R.h.dkg));
    this.rPe = ((TextView)findViewById(R.h.dsk));
    this.rPf = ((TextView)findViewById(R.h.dsj));
    this.rPj = ((RoundProgressBtn)findViewById(R.h.dsL));
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
    com.tencent.mm.plugin.backup.a.mIG.abF();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.csI().csL().rNw = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      Log.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.csI().csL().rNw) });
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
      ctg();
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
    rPk = false;
    com.tencent.mm.plugin.backup.d.c localc = com.tencent.mm.plugin.backup.d.b.csI().csL();
    b.d locald = this.rMv;
    synchronized (localc.rNI)
    {
      localc.rNI.remove(locald);
      AppMethodBeat.o(21452);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21451);
    super.onResume();
    Log.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
    rPk = true;
    com.tencent.mm.plugin.backup.d.c localc = com.tencent.mm.plugin.backup.d.b.csI().csL();
    b.d locald = this.rMv;
    synchronized (localc.rNI)
    {
      localc.rNI.add(locald);
      mRn = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
      this.rMv.EB(com.tencent.mm.plugin.backup.d.b.csI().crZ().rKS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI
 * JD-Core Version:    0.7.0.1
 */