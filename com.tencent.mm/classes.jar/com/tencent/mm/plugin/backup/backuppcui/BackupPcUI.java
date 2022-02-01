package com.tencent.mm.plugin.backup.backuppcui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupPcUI
  extends MMWizardActivity
{
  private static boolean mRn = false;
  private TextView kCQ;
  private TextView rPe;
  private TextView rPf;
  private TextView rPg;
  private TextView rPh;
  private ImageView rPi;
  public b.c rQV;
  
  public BackupPcUI()
  {
    AppMethodBeat.i(21676);
    this.rQV = new b.c()
    {
      private void EM(int paramAnonymousInt)
      {
        AppMethodBeat.i(21673);
        if ((2 == paramAnonymousInt) || (4 == paramAnonymousInt))
        {
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_error);
          AppMethodBeat.o(21673);
          return;
        }
        BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_error);
        AppMethodBeat.o(21673);
      }
      
      private void ctA()
      {
        AppMethodBeat.i(21674);
        BackupPcUI.h(BackupPcUI.this).setText(R.l.epo);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21659);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            BackupPcUI.n(BackupPcUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21659);
          }
        });
        AppMethodBeat.o(21674);
      }
      
      private void ctB()
      {
        AppMethodBeat.i(21675);
        BackupPcUI.h(BackupPcUI.this).setText(R.l.epq);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21660);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            BackupPcUI.o(BackupPcUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21660);
          }
        });
        AppMethodBeat.o(21675);
      }
      
      public final void EB(int paramAnonymousInt)
      {
        AppMethodBeat.i(21672);
        int i = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh;
        Log.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        Object localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ();
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.a(BackupPcUI.this);
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.eqR);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          ctA();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.erJ);
          BackupPcUI.d(BackupPcUI.this).setText(R.l.erI);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
          BackupPcUI.e(BackupPcUI.this).setText(R.l.erG);
          BackupPcUI.f(BackupPcUI.this).setText(R.l.erH);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(0);
          ctA();
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21650);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              bh.beI();
              boolean bool = ((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnI, Boolean.FALSE)).booleanValue();
              Log.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                com.tencent.mm.ui.base.h.a(BackupPcUI.this, R.l.erm, 0, R.l.erY, 0, false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(21649);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().EK(2);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 12;
                    BackupPcUI.3.this.EB(12);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().ctl();
                    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().kO(true);
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 7L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
                    AppMethodBeat.o(21649);
                  }
                }, null, R.e.dke);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21650);
                return;
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().EK(2);
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 12;
                BackupPcUI.3.this.EB(12);
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().cancel();
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().ctl();
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().kO(true);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 7L, 1L, false);
                com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
              }
            }
          });
          BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21661);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              paramAnonymous2View = new Intent(BackupPcUI.this, BackupPcChooseUI.class);
              MMWizardActivity.aH(BackupPcUI.this, paramAnonymous2View);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().cancel();
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().ctl();
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().kO(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21661);
            }
          });
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.erp);
          BackupPcUI.d(BackupPcUI.this).setText(R.l.erq);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          ctB();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
          TextView localTextView = BackupPcUI.c(BackupPcUI.this);
          BackupPcUI localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = R.l.erN;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).rKT;
          int j = ((com.tencent.mm.plugin.backup.b.e)localObject).rKU;
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
          localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
          BackupPcUI.d(BackupPcUI.this).setText(R.l.erq);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          ctB();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_finished);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.eqK);
          BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.eqL, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU) }));
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
          BackupPcUI.e(BackupPcUI.this).setText(R.l.epp);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21662);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().cancel(true);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -100;
              BackupPcUI.g(BackupPcUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21662);
            }
          });
          ctA();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.erx);
          BackupPcUI.e(BackupPcUI.this).setText(R.l.erw);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21663);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(23), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().EK(4);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 22;
              BackupPcUI.3.this.EB(22);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 16L, 1L, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21663);
            }
          });
          ctA();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.erp);
          BackupPcUI.d(BackupPcUI.this).setText(R.l.erq);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          ctB();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
          localTextView = BackupPcUI.c(BackupPcUI.this);
          localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = R.l.erz;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).rKT;
          j = ((com.tencent.mm.plugin.backup.b.e)localObject).rKU;
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
          localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
          BackupPcUI.d(BackupPcUI.this).setText(R.l.erq);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          ctB();
          AppMethodBeat.o(21672);
          return;
          if (Util.isTopActivity(BackupPcUI.this))
          {
            com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 24;
            paramAnonymousInt = 24;
            break;
            if (BackupPcUI.ctz())
            {
              BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.erA);
              BackupPcUI.d(BackupPcUI.this).setText(R.l.erC);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
              BackupPcUI.e(BackupPcUI.this).setText(R.l.erv);
              BackupPcUI.f(BackupPcUI.this).setText(R.l.ery);
              BackupPcUI.h(BackupPcUI.this).setText(R.l.erR);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21664);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                  com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp();
                  if (!d.csN())
                  {
                    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp();
                    if (!d.csN())
                    {
                      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -22;
                      BackupPcUI.3.this.EB(-22);
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 64L, 1L, false);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(21664);
                      return;
                    }
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(27), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
                  com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().ctw();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21664);
                }
              });
              BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21666);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.ui.base.h.a(BackupPcUI.this, R.l.eqW, R.l.eqV, R.l.erL, R.l.epl, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21665);
                      Log.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 26L, 1L, false);
                      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
                      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().a(true, true, -100);
                      AppMethodBeat.o(21665);
                    }
                  }, null, R.e.dkf);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21666);
                }
              });
              BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21667);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 25;
                  BackupPcUI.i(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21667);
                }
              });
              AppMethodBeat.o(21672);
              return;
            }
            if (Util.isTopActivity(BackupPcUI.this))
            {
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp();
              if (!d.csN())
              {
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -22;
                EB(-22);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 64L, 1L, false);
                AppMethodBeat.o(21672);
                return;
              }
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().ctw();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
              BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.eru, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKV) }));
              BackupPcUI.d(BackupPcUI.this).setText(R.l.ert);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
              BackupPcUI.h(BackupPcUI.this).setText(R.l.ery);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              ctA();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(R.k.backup_move_recover);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.erQ);
              BackupPcUI.d(BackupPcUI.this).setText(R.l.eqp);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              ctA();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_finished);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.err);
              BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.ers, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU) }));
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkg));
              BackupPcUI.e(BackupPcUI.this).setText(R.l.epp);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21668);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
                  com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -100;
                  BackupPcUI.j(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21668);
                }
              });
              ctA();
              AppMethodBeat.o(21672);
              return;
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(R.l.erP);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkf));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(4);
                ctB();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = R.l.erN;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).rKT;
                j = ((com.tencent.mm.plugin.backup.b.e)localObject).rKU;
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
                localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = R.l.erz;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).rKT;
                j = ((com.tencent.mm.plugin.backup.b.e)localObject).rKU;
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
                localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
              }
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(R.l.erO);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkf));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                ctB();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = R.l.erN;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).rKT;
                j = ((com.tencent.mm.plugin.backup.b.e)localObject).rKU;
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
                localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
                BackupPcUI.f(BackupPcUI.this).setText(R.l.erK);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21670);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bn(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, R.l.eqU, R.l.eqT, R.l.erK, R.l.epl, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21669);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().cancel(true);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -100;
                        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 52L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().EL(4);
                        BackupPcUI.k(BackupPcUI.this);
                        AppMethodBeat.o(21669);
                      }
                    }, null, R.e.dkf);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21670);
                  }
                });
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = R.l.erz;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).rKT;
                j = ((com.tencent.mm.plugin.backup.b.e)localObject).rKU;
                com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn();
                localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cts() }));
                BackupPcUI.f(BackupPcUI.this).setText(R.l.erM);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21652);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bn(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, R.l.eqW, R.l.eqV, R.l.erL, R.l.epl, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21651);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().a(true, true, -100);
                        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 52L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().EL(4);
                        AppMethodBeat.o(21651);
                      }
                    }, null, R.e.dkf);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21652);
                  }
                });
              }
              if ((1 == i) || (3 == i))
              {
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_error);
                BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.erN, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU), "0M" }));
                BackupPcUI.d(BackupPcUI.this).setText(R.l.erf);
                BackupPcUI.f(BackupPcUI.this).setText(R.l.erK);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21654);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bn(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, R.l.eqU, R.l.eqT, R.l.erK, R.l.epl, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21653);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 10L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().EL(4);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().cancel(true);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -100;
                        BackupPcUI.l(BackupPcUI.this);
                        AppMethodBeat.o(21653);
                      }
                    }, null, R.e.dkf);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21654);
                  }
                });
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkf));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                ctB();
                AppMethodBeat.o(21672);
                return;
                if ((2 == i) || (4 == i))
                {
                  BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_error);
                  BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.erz, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKT), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).rKU), "0M" }));
                  BackupPcUI.d(BackupPcUI.this).setText(R.l.erk);
                  BackupPcUI.f(BackupPcUI.this).setText(R.l.erM);
                  BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(21656);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bn(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                      com.tencent.mm.ui.base.h.a(BackupPcUI.this, R.l.eqW, R.l.eqV, R.l.erL, R.l.epl, false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(21655);
                          Log.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 18L, 1L, false);
                          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().EL(4);
                          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
                          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().a(true, true, -100);
                          AppMethodBeat.o(21655);
                        }
                      }, null, R.e.dkf);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(21656);
                    }
                  });
                }
              }
              EM(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.erh);
              localObject = g.eH(BackupPcUI.this);
              if ((localObject == null) || (((String)localObject).equals(""))) {
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.eri, new Object[] { com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQi, "移动网络" }));
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.dkf));
                BackupPcUI.f(BackupPcUI.this).setText(R.l.erl);
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21657);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bn(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                    BackupPcUI.m(BackupPcUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21657);
                  }
                });
                ctA();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.eri, new Object[] { com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQi, localObject }));
              }
              EM(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.eqZ);
              BackupPcUI.f(BackupPcUI.this).setText(R.l.erl);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21658);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  BackupPcUI.m(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21658);
                }
              });
              ctA();
              AppMethodBeat.o(21672);
              return;
              EM(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.era);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              ctA();
              AppMethodBeat.o(21672);
              return;
              EM(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.erj);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              ctA();
              AppMethodBeat.o(21672);
              return;
              EM(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.erg);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              ctA();
              AppMethodBeat.o(21672);
              return;
              EM(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.ere);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              ctA();
              AppMethodBeat.o(21672);
              return;
              EM(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.erb);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              ctA();
            }
          }
        }
      }
      
      public final void crX()
      {
        AppMethodBeat.i(21671);
        int i = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh;
        Log.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 11;
          EB(11);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 21;
          EB(21);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 12;
          EB(12);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 22;
          EB(22);
        }
      }
      
      public final void crY() {}
    };
    AppMethodBeat.o(21676);
  }
  
  private void ctg()
  {
    AppMethodBeat.i(21684);
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS;
    int j = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh;
    Log.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    switch (i)
    {
    default: 
    case 15: 
    case -22: 
    case -21: 
    case -13: 
    case -5: 
    case -3: 
    case -2: 
    case -1: 
    case 1: 
    case 11: 
    case 21: 
    case 27: 
    case 24: 
      for (;;)
      {
        atX(1);
        AppMethodBeat.o(21684);
        return;
        Log.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
        cty();
        AppMethodBeat.o(21684);
        return;
        if ((1 == j) || (3 == j))
        {
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().cancel(false);
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -100;
        }
        else
        {
          if ((2 == j) || (4 == j))
          {
            com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().a(false, false, -100);
            AppMethodBeat.o(21684);
            return;
          }
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -100;
          continue;
          Log.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
          cty();
          AppMethodBeat.o(21684);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 25;
        }
      }
    }
    com.tencent.mm.ui.base.h.a(this, R.l.eqW, R.l.eqV, R.l.erL, R.l.epl, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21648);
        Log.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 26L, 1L, false);
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.VnE, Boolean.FALSE);
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().a(true, true, -100);
        AppMethodBeat.o(21648);
      }
    }, null, R.e.dkf);
    AppMethodBeat.o(21684);
  }
  
  private void cty()
  {
    AppMethodBeat.i(21685);
    Log.i("MicroMsg.BackupPcUI", "exitBackupPc.");
    if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh))
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().cancel();
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().ctl();
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().cancel(true);
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = -100;
      atX(1);
      AppMethodBeat.o(21685);
      return;
    }
    if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQh))
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp().a(true, true, -100);
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().csJ().stop();
    }
    AppMethodBeat.o(21685);
  }
  
  public int getLayoutId()
  {
    return R.i.ebQ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21681);
    this.kCQ = ((TextView)findViewById(R.h.dsE));
    this.rPi = ((ImageView)findViewById(R.h.dsF));
    this.rPg = ((TextView)findViewById(R.h.dsM));
    this.rPh = ((TextView)findViewById(R.h.dkg));
    this.rPe = ((TextView)findViewById(R.h.dsk));
    this.rPf = ((TextView)findViewById(R.h.dsj));
    AppMethodBeat.o(21681);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21677);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21677);
      return;
    }
    Log.i("MicroMsg.BackupPcUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.mIG.abF();
    initView();
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQo)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQo = false;
      final int i = g.csp();
      if (i < 50)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.a(13736, new Object[] { Integer.valueOf(4), com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQi, g.eH(this), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
        com.tencent.mm.ui.base.h.a(this, R.l.erd, R.l.erc, R.l.erY, 0, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(21647);
            Log.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(21647);
          }
        }, null, R.e.dke);
      }
    }
    if (((n)com.tencent.mm.kernel.h.ae(n.class)).bco().eSi()) {
      bq.beT();
    }
    AppMethodBeat.o(21677);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21682);
    Log.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", new Object[] { Util.getStack() });
    super.onDestroy();
    AppMethodBeat.o(21682);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21683);
    if (paramInt == 4)
    {
      ctg();
      AppMethodBeat.o(21683);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21683);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(21679);
    super.onPause();
    Log.i("MicroMsg.BackupPcUI", "onPause.");
    Object localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto();
    b.c localc = this.rQV;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).rQu)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).rQu.remove(localc);
      localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp();
      localc = this.rQV;
    }
    synchronized (((d)localObject1).rQu)
    {
      ((d)localObject1).rQu.remove(localc);
      AppMethodBeat.o(21679);
      return;
      localObject2 = finally;
      AppMethodBeat.o(21679);
      throw localObject2;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21680);
    super.onResume();
    Log.i("MicroMsg.BackupPcUI", "onResume.");
    Object localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto();
    b.c localc = this.rQV;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).rQu)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).rQu.add(localc);
      localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctp();
      localc = this.rQV;
    }
    synchronized (((d)localObject1).rQu)
    {
      ((d)localObject1).rQu.add(localc);
      int i = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS;
      this.rQV.EB(i);
      AppMethodBeat.o(21680);
      return;
      localObject2 = finally;
      AppMethodBeat.o(21680);
      throw localObject2;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21678);
    super.onStart();
    Log.i("MicroMsg.BackupPcUI", "onStart.");
    mRn = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    AppMethodBeat.o(21678);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI
 * JD-Core Version:    0.7.0.1
 */