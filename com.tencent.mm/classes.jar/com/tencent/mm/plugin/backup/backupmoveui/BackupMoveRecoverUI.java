package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveRecoverUI
  extends MMWizardActivity
{
  private static boolean iYY = false;
  private static boolean nwU = false;
  public TextView gSR;
  private b.d num;
  public TextView nwO;
  public TextView nwP;
  public TextView nwQ;
  public TextView nwR;
  public ImageView nwS;
  private RoundProgressBtn nwT;
  
  public BackupMoveRecoverUI()
  {
    AppMethodBeat.i(21448);
    this.num = new b.d()
    {
      public final void bGW() {}
      
      public final void xp(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21443);
        Object localObject1 = com.tencent.mm.plugin.backup.d.b.bHG().bGX();
        ad.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BackupMoveRecoverUI.nwU), Integer.valueOf(((e)localObject1).nsK), Integer.valueOf(((e)localObject1).nsL), Integer.valueOf(((e)localObject1).nsM) });
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
          BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nwQ.setText(2131756106);
          BackupMoveRecoverUI.this.nwR.setText(2131756139);
          BackupMoveRecoverUI.this.nwR.setVisibility(0);
          BackupMoveRecoverUI.this.nwO.setVisibility(4);
          BackupMoveRecoverUI.this.nwP.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nwQ.setText(2131756155);
          BackupMoveRecoverUI.this.nwR.setText(2131756139);
          BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.nwR.setVisibility(0);
          BackupMoveRecoverUI.this.nwO.setVisibility(4);
          BackupMoveRecoverUI.this.nwP.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nwQ.setText(2131756136);
          BackupMoveRecoverUI.this.nwO.setText(2131756138);
          BackupMoveRecoverUI.this.nwP.setText(2131756137);
          BackupMoveRecoverUI.this.nwR.setVisibility(4);
          BackupMoveRecoverUI.this.nwO.setVisibility(0);
          BackupMoveRecoverUI.this.nwP.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.nwO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21417);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.backup.d.b.bHG().bHJ().iB(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21417);
            }
          });
          BackupMoveRecoverUI.this.nwP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21431);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.backup.d.b.bHG().bHJ().iB(true);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21431);
            }
          });
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
          Object localObject2 = BackupMoveRecoverUI.this.nwQ;
          Object localObject3 = BackupMoveRecoverUI.this;
          paramAnonymousInt = ((e)localObject1).nsK;
          int i = ((e)localObject1).nsL;
          com.tencent.mm.plugin.backup.d.b.bHG().bHJ();
          ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(2131756160, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), c.bHP() }));
          BackupMoveRecoverUI.this.nwR.setText(2131756139);
          BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.nwR.setVisibility(0);
          BackupMoveRecoverUI.this.nwO.setVisibility(8);
          BackupMoveRecoverUI.this.nwP.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).bHg());
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21435);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
              com.tencent.mm.plugin.backup.d.b.bHG().bHJ().bHO();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21435);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nwQ.setText(2131756143);
          BackupMoveRecoverUI.this.nwR.setText(2131756145);
          BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.nwR.setVisibility(0);
          BackupMoveRecoverUI.this.nwO.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.nwO.setText(2131756144);
          BackupMoveRecoverUI.this.nwO.setOnClickListener(new BackupMoveRecoverUI.1.16(this));
          BackupMoveRecoverUI.this.nwP.setVisibility(0);
          BackupMoveRecoverUI.this.nwP.setText(2131756159);
          BackupMoveRecoverUI.this.nwP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21437);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
              ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
              com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = 29;
              BackupMoveRecoverUI.1.this.xp(29);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21437);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nwQ.setText(2131756170);
          BackupMoveRecoverUI.this.nwR.setText(2131756172);
          BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.nwR.setVisibility(0);
          BackupMoveRecoverUI.this.nwO.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.nwO.setText(2131756169);
          BackupMoveRecoverUI.this.nwO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21438);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
              com.tencent.mm.plugin.backup.d.b.bHG().bHJ();
              if (!c.bHL())
              {
                ad.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = -22;
                BackupMoveRecoverUI.1.this.xp(-22);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 6L, 1L, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21438);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.bHG().bHJ().iA(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21438);
            }
          });
          BackupMoveRecoverUI.this.nwP.setVisibility(0);
          BackupMoveRecoverUI.this.nwP.setText(2131756107);
          BackupMoveRecoverUI.this.nwP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21440);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
              h.a(BackupMoveRecoverUI.this, 2131756109, 2131756108, 2131756158, 2131756090, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(21439);
                  ad.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.19.this.nvG) });
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 48L, 1L, false);
                  com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
                  com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(true, true, -100);
                  AppMethodBeat.o(21439);
                }
              }, null, 2131099991);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21440);
            }
          });
          BackupMoveRecoverUI.this.gSR.setText(2131756253);
          BackupMoveRecoverUI.this.gSR.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21441);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = 25;
              BackupMoveRecoverUI.e(BackupMoveRecoverUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21441);
            }
          });
          AppMethodBeat.o(21443);
          return;
          if (BackupMoveRecoverUI.nwU)
          {
            com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = 24;
            paramAnonymousInt = 24;
            break;
            ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[] { Boolean.valueOf(BackupMoveRecoverUI.bId()) });
            if (BackupMoveRecoverUI.bId())
            {
              BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
              BackupMoveRecoverUI.this.nwQ.setText(2131756161);
              BackupMoveRecoverUI.this.nwR.setText(2131756163);
              BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nwO.setText(2131756157);
              BackupMoveRecoverUI.this.nwP.setText(2131756158);
              BackupMoveRecoverUI.this.gSR.setText(2131756253);
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(0);
              BackupMoveRecoverUI.this.nwP.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.nwO.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21442);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                  com.tencent.mm.plugin.backup.d.b.bHG().bHJ();
                  if (!c.bHL())
                  {
                    ad.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                    com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = -22;
                    BackupMoveRecoverUI.1.this.xp(-22);
                    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 6L, 1L, false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21442);
                    return;
                  }
                  com.tencent.mm.plugin.backup.d.b.bHG().bHJ().iA(false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21442);
                }
              });
              BackupMoveRecoverUI.this.nwP.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21419);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                  h.a(BackupMoveRecoverUI.this, 2131756109, 2131756108, 2131756158, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21418);
                      ad.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.2.this.nvG) });
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 48L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
                      com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(true, true, -100);
                      AppMethodBeat.o(21418);
                    }
                  }, null, 2131099991);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21419);
                }
              });
              BackupMoveRecoverUI.this.gSR.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21420);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = 25;
                  BackupMoveRecoverUI.f(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21420);
                }
              });
              AppMethodBeat.o(21443);
              return;
            }
            if (BackupMoveRecoverUI.nwU)
            {
              com.tencent.mm.plugin.backup.d.b.bHG().bHJ();
              if (!c.bHL())
              {
                ad.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = -22;
                xp(-22);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 6L, 1L, false);
                AppMethodBeat.o(21443);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.bHG().bHJ().iA(false);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689735);
              BackupMoveRecoverUI.this.nwQ.setText(BackupMoveRecoverUI.this.getString(2131756152, new Object[] { Integer.valueOf(((e)localObject1).nsM) }));
              BackupMoveRecoverUI.this.nwR.setText(2131756153);
              BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(4);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689735);
              BackupMoveRecoverUI.this.nwQ.setText(2131756252);
              BackupMoveRecoverUI.this.nwR.setText(2131756153);
              BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(4);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689737);
              BackupMoveRecoverUI.this.nwQ.setText(2131756150);
              BackupMoveRecoverUI.this.nwR.setText(BackupMoveRecoverUI.this.getString(2131756151, new Object[] { Integer.valueOf(((e)localObject1).nsK), Integer.valueOf(((e)localObject1).nsL) }));
              BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nwO.setText(2131756096);
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(0);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.nwO.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21421);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
                  com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = -100;
                  BackupMoveRecoverUI.g(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21421);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
              localObject2 = BackupMoveRecoverUI.this.nwQ;
              localObject3 = BackupMoveRecoverUI.this;
              paramAnonymousInt = ((e)localObject1).nsK;
              i = ((e)localObject1).nsL;
              com.tencent.mm.plugin.backup.d.b.bHG().bHJ();
              ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(2131756160, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), c.bHP() }));
              BackupMoveRecoverUI.this.nwR.setText(2131756175);
              BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(8);
              BackupMoveRecoverUI.this.nwP.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).bHg());
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21422);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  ad.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                  com.tencent.mm.plugin.backup.d.b.bHG().bHJ().bHO();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21422);
                }
              });
              BackupMoveRecoverUI.this.nwP.setText(2131756176);
              BackupMoveRecoverUI.this.nwP.setOnClickListener(new BackupMoveRecoverUI.1.6(this));
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nwQ.setText(BackupMoveRecoverUI.this.getString(2131756140, new Object[] { Integer.valueOf(((e)localObject1).nsK), Integer.valueOf(((e)localObject1).nsL), "0M" }));
              BackupMoveRecoverUI.this.nwR.setText(2131756124);
              BackupMoveRecoverUI.this.nwO.setText(2131756156);
              BackupMoveRecoverUI.this.nwP.setText(2131756159);
              BackupMoveRecoverUI.this.nwO.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21424);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  com.tencent.mm.plugin.backup.d.b.bHG().bHJ().xt(7);
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  d.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21424);
                }
              });
              BackupMoveRecoverUI.this.nwP.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21426);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21425);
                      ad.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.8.this.nvG) });
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.bHG().bHJ().xt(6);
                      com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
                      com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(true, true, -100);
                      AppMethodBeat.o(21425);
                    }
                  }, null, 2131099991);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21426);
                }
              });
              BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(0);
              BackupMoveRecoverUI.this.nwP.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nwQ.setText(2131756127);
              localObject2 = com.tencent.mm.plugin.backup.b.g.eh(BackupMoveRecoverUI.this);
              localObject3 = com.tencent.mm.plugin.backup.d.b.bHG().bHJ().nvu;
              localObject1 = localObject2;
              if (bt.isNullOrNil((String)localObject2)) {
                localObject1 = "移动网络";
              }
              localObject2 = localObject3;
              if (bt.isNullOrNil((String)localObject3)) {
                localObject2 = "移动网络";
              }
              if ((!((String)localObject1).equals("wifi")) && (!((String)localObject2).equals("wifi"))) {
                BackupMoveRecoverUI.this.nwR.setText(BackupMoveRecoverUI.this.getString(2131756128, new Object[] { localObject1, localObject2 }));
              }
              BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(4);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nwQ.setText(2131756113);
              BackupMoveRecoverUI.this.nwR.setText(2131756114);
              BackupMoveRecoverUI.this.nwO.setText(2131756154);
              BackupMoveRecoverUI.this.nwP.setText(2131756159);
              BackupMoveRecoverUI.this.nwR.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(0);
              BackupMoveRecoverUI.this.nwP.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.nwO.setOnClickListener(new BackupMoveRecoverUI.1.9(this));
              BackupMoveRecoverUI.this.nwP.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21429);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21428);
                      ad.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.10.this.nvG) });
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.bHG().bHJ().xt(5);
                      com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
                      com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(true, true, -100);
                      AppMethodBeat.o(21428);
                    }
                  }, null, 2131099991);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21429);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nwQ.setText(2131756115);
              BackupMoveRecoverUI.this.nwO.setText(2131756156);
              BackupMoveRecoverUI.this.nwP.setText(2131756159);
              BackupMoveRecoverUI.this.nwR.setVisibility(4);
              BackupMoveRecoverUI.this.nwO.setVisibility(0);
              BackupMoveRecoverUI.this.nwP.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.nwO.setOnClickListener(new BackupMoveRecoverUI.1.11(this));
              BackupMoveRecoverUI.this.nwP.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21433);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21432);
                      ad.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.13.this.nvG) });
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.bHG().bHJ().xt(5);
                      com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
                      com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(true, true, -100);
                      AppMethodBeat.o(21432);
                    }
                  }, null, 2131099991);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21433);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nwQ.setText(2131756132);
              BackupMoveRecoverUI.this.nwR.setVisibility(4);
              BackupMoveRecoverUI.this.nwO.setVisibility(4);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131231103);
              BackupMoveRecoverUI.this.nwQ.setText(2131756106);
              BackupMoveRecoverUI.this.nwR.setText(2131756139);
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(4);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              h.a(BackupMoveRecoverUI.this, 2131756123, 0, 2131756270, 0, false, new BackupMoveRecoverUI.1.14(this), null, 2131099990);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nwQ.setText(2131756125);
              BackupMoveRecoverUI.this.nwR.setText(BackupMoveRecoverUI.this.getString(2131756126, new Object[] { bt.sy(com.tencent.mm.plugin.backup.d.b.bHG().bHJ().nvB) }));
              BackupMoveRecoverUI.this.nwR.setVisibility(0);
              BackupMoveRecoverUI.this.nwO.setVisibility(4);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nwQ.setText(2131756116);
              BackupMoveRecoverUI.this.nwR.setVisibility(4);
              BackupMoveRecoverUI.this.nwO.setVisibility(4);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nwS.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nwQ.setText(2131756121);
              com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
              BackupMoveRecoverUI.this.nwR.setVisibility(4);
              BackupMoveRecoverUI.this.nwO.setVisibility(4);
              BackupMoveRecoverUI.this.nwP.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
            }
          }
        }
      }
    };
    AppMethodBeat.o(21448);
  }
  
  private void bIc()
  {
    AppMethodBeat.i(21455);
    final int i = com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ;
    ad.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
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
        abK(1);
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(false, false, -100);
        AppMethodBeat.o(21455);
        return;
        ad.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(true, false, -100);
        com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = 25;
      }
    case 52: 
      h.a(this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21445);
          ad.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 44L, 1L, false);
          com.tencent.mm.plugin.backup.d.b.bHG().bHJ().xt(5);
          com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
          com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(true, true, -100);
          AppMethodBeat.o(21445);
        }
      }, null, 2131099991);
      AppMethodBeat.o(21455);
      return;
    }
    h.a(this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21446);
        ad.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 48L, 1L, false);
        com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
        com.tencent.mm.plugin.backup.d.b.bHG().bHJ().b(true, true, -100);
        AppMethodBeat.o(21446);
      }
    }, null, 2131099991);
    AppMethodBeat.o(21455);
  }
  
  public int getLayoutId()
  {
    return 2131493131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21450);
    this.gSR = ((TextView)findViewById(2131297053));
    this.nwS = ((ImageView)findViewById(2131297054));
    this.nwQ = ((TextView)findViewById(2131297063));
    this.nwR = ((TextView)findViewById(2131297062));
    this.nwO = ((TextView)findViewById(2131297034));
    this.nwP = ((TextView)findViewById(2131297033));
    this.nwT = ((RoundProgressBtn)findViewById(2131297061));
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
    ad.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.iRG.MU();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.bHG().bHJ().nvo = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ad.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.bHG().bHJ().nvo) });
      AppMethodBeat.o(21449);
      return;
    }
    catch (Exception paramBundle)
    {
      ad.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bt.flS() });
      AppMethodBeat.o(21449);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21453);
    ad.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
    super.onDestroy();
    AppMethodBeat.o(21453);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21454);
    if (paramInt == 4)
    {
      bIc();
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
    ad.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
    nwU = false;
    AppMethodBeat.o(21452);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21451);
    super.onResume();
    ad.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
    nwU = true;
    com.tencent.mm.plugin.backup.d.b.bHG().bHJ().num = this.num;
    iYY = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    this.num.xp(com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ);
    AppMethodBeat.o(21451);
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