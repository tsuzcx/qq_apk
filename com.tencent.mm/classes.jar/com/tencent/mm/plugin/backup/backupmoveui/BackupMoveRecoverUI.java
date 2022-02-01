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
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveRecoverUI
  extends MMWizardActivity
{
  private static boolean jbR = false;
  private static boolean nCp = false;
  public TextView gVA;
  public TextView nCj;
  public TextView nCk;
  public TextView nCl;
  public TextView nCm;
  public ImageView nCn;
  private RoundProgressBtn nCo;
  private b.d nzH;
  
  public BackupMoveRecoverUI()
  {
    AppMethodBeat.i(21448);
    this.nzH = new b.d()
    {
      public final void bHU() {}
      
      public final void xu(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21443);
        Object localObject1 = com.tencent.mm.plugin.backup.d.b.bIE().bHV();
        ae.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BackupMoveRecoverUI.nCp), Integer.valueOf(((e)localObject1).nyf), Integer.valueOf(((e)localObject1).nyg), Integer.valueOf(((e)localObject1).nyh) });
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
          BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nCl.setText(2131756106);
          BackupMoveRecoverUI.this.nCm.setText(2131756139);
          BackupMoveRecoverUI.this.nCm.setVisibility(0);
          BackupMoveRecoverUI.this.nCj.setVisibility(4);
          BackupMoveRecoverUI.this.nCk.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nCl.setText(2131756155);
          BackupMoveRecoverUI.this.nCm.setText(2131756139);
          BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.nCm.setVisibility(0);
          BackupMoveRecoverUI.this.nCj.setVisibility(4);
          BackupMoveRecoverUI.this.nCk.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nCl.setText(2131756136);
          BackupMoveRecoverUI.this.nCj.setText(2131756138);
          BackupMoveRecoverUI.this.nCk.setText(2131756137);
          BackupMoveRecoverUI.this.nCm.setVisibility(4);
          BackupMoveRecoverUI.this.nCj.setVisibility(0);
          BackupMoveRecoverUI.this.nCk.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.nCj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21417);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.plugin.backup.d.b.bIE().bIH().iz(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21417);
            }
          });
          BackupMoveRecoverUI.this.nCk.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21431);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.plugin.backup.d.b.bIE().bIH().iz(true);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21431);
            }
          });
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
          Object localObject2 = BackupMoveRecoverUI.this.nCl;
          Object localObject3 = BackupMoveRecoverUI.this;
          paramAnonymousInt = ((e)localObject1).nyf;
          int i = ((e)localObject1).nyg;
          com.tencent.mm.plugin.backup.d.b.bIE().bIH();
          ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(2131756160, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), c.bIN() }));
          BackupMoveRecoverUI.this.nCm.setText(2131756139);
          BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.nCm.setVisibility(0);
          BackupMoveRecoverUI.this.nCj.setVisibility(8);
          BackupMoveRecoverUI.this.nCk.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).bIe());
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21435);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
              com.tencent.mm.plugin.backup.d.b.bIE().bIH().bIM();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21435);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nCl.setText(2131756143);
          BackupMoveRecoverUI.this.nCm.setText(2131756145);
          BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.nCm.setVisibility(0);
          BackupMoveRecoverUI.this.nCj.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.nCj.setText(2131756144);
          BackupMoveRecoverUI.this.nCj.setOnClickListener(new BackupMoveRecoverUI.1.16(this));
          BackupMoveRecoverUI.this.nCk.setVisibility(0);
          BackupMoveRecoverUI.this.nCk.setText(2131756159);
          BackupMoveRecoverUI.this.nCk.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21437);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
              ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
              com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = 29;
              BackupMoveRecoverUI.1.this.xu(29);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21437);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
          BackupMoveRecoverUI.this.nCl.setText(2131756170);
          BackupMoveRecoverUI.this.nCm.setText(2131756172);
          BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.nCm.setVisibility(0);
          BackupMoveRecoverUI.this.nCj.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.nCj.setText(2131756169);
          BackupMoveRecoverUI.this.nCj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21438);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
              com.tencent.mm.plugin.backup.d.b.bIE().bIH();
              if (!c.bIJ())
              {
                ae.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = -22;
                BackupMoveRecoverUI.1.this.xu(-22);
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 6L, 1L, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21438);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.bIE().bIH().iy(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21438);
            }
          });
          BackupMoveRecoverUI.this.nCk.setVisibility(0);
          BackupMoveRecoverUI.this.nCk.setText(2131756107);
          BackupMoveRecoverUI.this.nCk.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21440);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
              h.a(BackupMoveRecoverUI.this, 2131756109, 2131756108, 2131756158, 2131756090, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(21439);
                  ae.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.19.this.nBb) });
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 48L, 1L, false);
                  com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
                  com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(true, true, -100);
                  AppMethodBeat.o(21439);
                }
              }, null, 2131099991);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21440);
            }
          });
          BackupMoveRecoverUI.this.gVA.setText(2131756253);
          BackupMoveRecoverUI.this.gVA.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21441);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = 25;
              BackupMoveRecoverUI.e(BackupMoveRecoverUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21441);
            }
          });
          AppMethodBeat.o(21443);
          return;
          if (BackupMoveRecoverUI.nCp)
          {
            com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = 24;
            paramAnonymousInt = 24;
            break;
            ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[] { Boolean.valueOf(BackupMoveRecoverUI.bJb()) });
            if (BackupMoveRecoverUI.bJb())
            {
              BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
              BackupMoveRecoverUI.this.nCl.setText(2131756161);
              BackupMoveRecoverUI.this.nCm.setText(2131756163);
              BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nCj.setText(2131756157);
              BackupMoveRecoverUI.this.nCk.setText(2131756158);
              BackupMoveRecoverUI.this.gVA.setText(2131756253);
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(0);
              BackupMoveRecoverUI.this.nCk.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.nCj.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21442);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                  com.tencent.mm.plugin.backup.d.b.bIE().bIH();
                  if (!c.bIJ())
                  {
                    ae.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                    com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = -22;
                    BackupMoveRecoverUI.1.this.xu(-22);
                    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 6L, 1L, false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21442);
                    return;
                  }
                  com.tencent.mm.plugin.backup.d.b.bIE().bIH().iy(false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21442);
                }
              });
              BackupMoveRecoverUI.this.nCk.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21419);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                  h.a(BackupMoveRecoverUI.this, 2131756109, 2131756108, 2131756158, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21418);
                      ae.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.2.this.nBb) });
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 48L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
                      com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(true, true, -100);
                      AppMethodBeat.o(21418);
                    }
                  }, null, 2131099991);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21419);
                }
              });
              BackupMoveRecoverUI.this.gVA.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21420);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = 25;
                  BackupMoveRecoverUI.f(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21420);
                }
              });
              AppMethodBeat.o(21443);
              return;
            }
            if (BackupMoveRecoverUI.nCp)
            {
              com.tencent.mm.plugin.backup.d.b.bIE().bIH();
              if (!c.bIJ())
              {
                ae.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = -22;
                xu(-22);
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 6L, 1L, false);
                AppMethodBeat.o(21443);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.bIE().bIH().iy(false);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689735);
              BackupMoveRecoverUI.this.nCl.setText(BackupMoveRecoverUI.this.getString(2131756152, new Object[] { Integer.valueOf(((e)localObject1).nyh) }));
              BackupMoveRecoverUI.this.nCm.setText(2131756153);
              BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(4);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689735);
              BackupMoveRecoverUI.this.nCl.setText(2131756252);
              BackupMoveRecoverUI.this.nCm.setText(2131756153);
              BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(4);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689737);
              BackupMoveRecoverUI.this.nCl.setText(2131756150);
              BackupMoveRecoverUI.this.nCm.setText(BackupMoveRecoverUI.this.getString(2131756151, new Object[] { Integer.valueOf(((e)localObject1).nyf), Integer.valueOf(((e)localObject1).nyg) }));
              BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nCj.setText(2131756096);
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(0);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.nCj.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21421);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
                  com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = -100;
                  BackupMoveRecoverUI.g(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21421);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
              localObject2 = BackupMoveRecoverUI.this.nCl;
              localObject3 = BackupMoveRecoverUI.this;
              paramAnonymousInt = ((e)localObject1).nyf;
              i = ((e)localObject1).nyg;
              com.tencent.mm.plugin.backup.d.b.bIE().bIH();
              ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(2131756160, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), c.bIN() }));
              BackupMoveRecoverUI.this.nCm.setText(2131756175);
              BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(8);
              BackupMoveRecoverUI.this.nCk.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).bIe());
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21422);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                  com.tencent.mm.plugin.backup.d.b.bIE().bIH().bIM();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21422);
                }
              });
              BackupMoveRecoverUI.this.nCk.setText(2131756176);
              BackupMoveRecoverUI.this.nCk.setOnClickListener(new BackupMoveRecoverUI.1.6(this));
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nCl.setText(BackupMoveRecoverUI.this.getString(2131756140, new Object[] { Integer.valueOf(((e)localObject1).nyf), Integer.valueOf(((e)localObject1).nyg), "0M" }));
              BackupMoveRecoverUI.this.nCm.setText(2131756124);
              BackupMoveRecoverUI.this.nCj.setText(2131756156);
              BackupMoveRecoverUI.this.nCk.setText(2131756159);
              BackupMoveRecoverUI.this.nCj.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21424);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  com.tencent.mm.plugin.backup.d.b.bIE().bIH().xy(7);
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  d.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21424);
                }
              });
              BackupMoveRecoverUI.this.nCk.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21426);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21425);
                      ae.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.8.this.nBb) });
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.bIE().bIH().xy(6);
                      com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
                      com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(true, true, -100);
                      AppMethodBeat.o(21425);
                    }
                  }, null, 2131099991);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21426);
                }
              });
              BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(0);
              BackupMoveRecoverUI.this.nCk.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nCl.setText(2131756127);
              localObject2 = com.tencent.mm.plugin.backup.b.g.el(BackupMoveRecoverUI.this);
              localObject3 = com.tencent.mm.plugin.backup.d.b.bIE().bIH().nAP;
              localObject1 = localObject2;
              if (bu.isNullOrNil((String)localObject2)) {
                localObject1 = "移动网络";
              }
              localObject2 = localObject3;
              if (bu.isNullOrNil((String)localObject3)) {
                localObject2 = "移动网络";
              }
              if ((!((String)localObject1).equals("wifi")) && (!((String)localObject2).equals("wifi"))) {
                BackupMoveRecoverUI.this.nCm.setText(BackupMoveRecoverUI.this.getString(2131756128, new Object[] { localObject1, localObject2 }));
              }
              BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(4);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nCl.setText(2131756113);
              BackupMoveRecoverUI.this.nCm.setText(2131756114);
              BackupMoveRecoverUI.this.nCj.setText(2131756154);
              BackupMoveRecoverUI.this.nCk.setText(2131756159);
              BackupMoveRecoverUI.this.nCm.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(0);
              BackupMoveRecoverUI.this.nCk.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.nCj.setOnClickListener(new BackupMoveRecoverUI.1.9(this));
              BackupMoveRecoverUI.this.nCk.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21429);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21428);
                      ae.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.10.this.nBb) });
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.bIE().bIH().xy(5);
                      com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
                      com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(true, true, -100);
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
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nCl.setText(2131756115);
              BackupMoveRecoverUI.this.nCj.setText(2131756156);
              BackupMoveRecoverUI.this.nCk.setText(2131756159);
              BackupMoveRecoverUI.this.nCm.setVisibility(4);
              BackupMoveRecoverUI.this.nCj.setVisibility(0);
              BackupMoveRecoverUI.this.nCk.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.nCj.setOnClickListener(new BackupMoveRecoverUI.1.11(this));
              BackupMoveRecoverUI.this.nCk.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21433);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21432);
                      ae.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.13.this.nBb) });
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.bIE().bIH().xy(5);
                      com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
                      com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(true, true, -100);
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
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nCl.setText(2131756132);
              BackupMoveRecoverUI.this.nCm.setVisibility(4);
              BackupMoveRecoverUI.this.nCj.setVisibility(4);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131231103);
              BackupMoveRecoverUI.this.nCl.setText(2131756106);
              BackupMoveRecoverUI.this.nCm.setText(2131756139);
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(4);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              h.a(BackupMoveRecoverUI.this, 2131756123, 0, 2131756270, 0, false, new BackupMoveRecoverUI.1.14(this), null, 2131099990);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nCl.setText(2131756125);
              BackupMoveRecoverUI.this.nCm.setText(BackupMoveRecoverUI.this.getString(2131756126, new Object[] { bu.sL(com.tencent.mm.plugin.backup.d.b.bIE().bIH().nAW) }));
              BackupMoveRecoverUI.this.nCm.setVisibility(0);
              BackupMoveRecoverUI.this.nCj.setVisibility(4);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nCl.setText(2131756116);
              BackupMoveRecoverUI.this.nCm.setVisibility(4);
              BackupMoveRecoverUI.this.nCj.setVisibility(4);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.nCn.setImageResource(2131689731);
              BackupMoveRecoverUI.this.nCl.setText(2131756121);
              com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
              BackupMoveRecoverUI.this.nCm.setVisibility(4);
              BackupMoveRecoverUI.this.nCj.setVisibility(4);
              BackupMoveRecoverUI.this.nCk.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
            }
          }
        }
      }
    };
    AppMethodBeat.o(21448);
  }
  
  private void bJa()
  {
    AppMethodBeat.i(21455);
    final int i = com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye;
    ae.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
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
        acs(1);
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(false, false, -100);
        AppMethodBeat.o(21455);
        return;
        ae.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(true, false, -100);
        com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = 25;
      }
    case 52: 
      h.a(this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21445);
          ae.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 44L, 1L, false);
          com.tencent.mm.plugin.backup.d.b.bIE().bIH().xy(5);
          com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
          com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(true, true, -100);
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
        ae.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 48L, 1L, false);
        com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
        com.tencent.mm.plugin.backup.d.b.bIE().bIH().b(true, true, -100);
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
    this.gVA = ((TextView)findViewById(2131297053));
    this.nCn = ((ImageView)findViewById(2131297054));
    this.nCl = ((TextView)findViewById(2131297063));
    this.nCm = ((TextView)findViewById(2131297062));
    this.nCj = ((TextView)findViewById(2131297034));
    this.nCk = ((TextView)findViewById(2131297033));
    this.nCo = ((RoundProgressBtn)findViewById(2131297061));
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
    ae.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.iUz.MP();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.bIE().bIH().nAJ = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ae.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.bIE().bIH().nAJ) });
      AppMethodBeat.o(21449);
      return;
    }
    catch (Exception paramBundle)
    {
      ae.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bu.fpN() });
      AppMethodBeat.o(21449);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21453);
    ae.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
    super.onDestroy();
    AppMethodBeat.o(21453);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21454);
    if (paramInt == 4)
    {
      bJa();
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
    ae.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
    nCp = false;
    AppMethodBeat.o(21452);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21451);
    super.onResume();
    ae.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
    nCp = true;
    com.tencent.mm.plugin.backup.d.b.bIE().bIH().nzH = this.nzH;
    jbR = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    this.nzH.xu(com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye);
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