package com.tencent.mm.plugin.backup.backuppcui;

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
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupPcUI
  extends MMWizardActivity
{
  private static boolean pNU = false;
  private TextView ngm;
  private TextView vat;
  private TextView vau;
  private TextView vav;
  private TextView vaw;
  private ImageView vax;
  public b.c vck;
  
  public BackupPcUI()
  {
    AppMethodBeat.i(21676);
    this.vck = new b.c()
    {
      private void Fn(int paramAnonymousInt)
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
      
      private void cWk()
      {
        AppMethodBeat.i(21674);
        BackupPcUI.h(BackupPcUI.this).setText(R.l.gsp);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21659);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            BackupPcUI.n(BackupPcUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21659);
          }
        });
        AppMethodBeat.o(21674);
      }
      
      private void cWl()
      {
        AppMethodBeat.i(21675);
        BackupPcUI.h(BackupPcUI.this).setText(R.l.gsr);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21660);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            BackupPcUI.o(BackupPcUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21660);
          }
        });
        AppMethodBeat.o(21675);
      }
      
      public final void Fc(int paramAnonymousInt)
      {
        AppMethodBeat.i(21672);
        int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw;
        Log.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        Object localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ();
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
          BackupPcUI.c(BackupPcUI.this).setText(R.l.gtS);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cWk();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.guK);
          BackupPcUI.d(BackupPcUI.this).setText(R.l.guJ);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
          BackupPcUI.e(BackupPcUI.this).setText(R.l.guH);
          BackupPcUI.f(BackupPcUI.this).setText(R.l.guI);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(0);
          cWk();
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21650);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              bh.bCz();
              boolean bool = ((Boolean)com.tencent.mm.model.c.ban().get(at.a.acPd, Boolean.FALSE)).booleanValue();
              Log.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                k.a(BackupPcUI.this, R.l.gun, 0, R.l.guZ, 0, false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(21649);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().Fl(2);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 12;
                    BackupPcUI.3.this.Fc(12);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVV();
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().mb(true);
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 7L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.OAn.b(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
                    AppMethodBeat.o(21649);
                  }
                }, null, R.e.fkf);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21650);
                return;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().Fl(2);
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 12;
                BackupPcUI.3.this.Fc(12);
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cancel();
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVV();
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().mb(true);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 7L, 1L, false);
                com.tencent.mm.plugin.report.service.h.OAn.b(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
              }
            }
          });
          BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21661);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              paramAnonymous2View = new Intent(BackupPcUI.this, BackupPcChooseUI.class);
              MMWizardActivity.aQ(BackupPcUI.this, paramAnonymous2View);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cancel();
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVV();
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().mb(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21661);
            }
          });
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.guq);
          BackupPcUI.d(BackupPcUI.this).setText(R.l.gur);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cWl();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
          TextView localTextView = BackupPcUI.c(BackupPcUI.this);
          BackupPcUI localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = R.l.guO;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).uWh;
          int j = ((com.tencent.mm.plugin.backup.b.e)localObject).uWi;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
          localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
          BackupPcUI.d(BackupPcUI.this).setText(R.l.gur);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cWl();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_finished);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.gtL);
          BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.gtM, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi) }));
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
          BackupPcUI.e(BackupPcUI.this).setText(R.l.gsq);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21662);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().cancel(true);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -100;
              BackupPcUI.g(BackupPcUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21662);
            }
          });
          cWk();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.guy);
          BackupPcUI.e(BackupPcUI.this).setText(R.l.gux);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21663);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              com.tencent.mm.plugin.report.service.h.OAn.b(13735, new Object[] { Integer.valueOf(23), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().Fl(4);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 22;
              BackupPcUI.3.this.Fc(22);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 16L, 1L, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21663);
            }
          });
          cWk();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
          BackupPcUI.c(BackupPcUI.this).setText(R.l.guq);
          BackupPcUI.d(BackupPcUI.this).setText(R.l.gur);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cWl();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
          localTextView = BackupPcUI.c(BackupPcUI.this);
          localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = R.l.guA;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).uWh;
          j = ((com.tencent.mm.plugin.backup.b.e)localObject).uWi;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
          localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
          BackupPcUI.d(BackupPcUI.this).setText(R.l.gur);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cWl();
          AppMethodBeat.o(21672);
          return;
          if (Util.isTopActivity(BackupPcUI.this))
          {
            com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 24;
            paramAnonymousInt = 24;
            break;
            if (BackupPcUI.cWj())
            {
              BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.guB);
              BackupPcUI.d(BackupPcUI.this).setText(R.l.guD);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
              BackupPcUI.e(BackupPcUI.this).setText(R.l.guw);
              BackupPcUI.f(BackupPcUI.this).setText(R.l.guz);
              BackupPcUI.h(BackupPcUI.this).setText(R.l.guS);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21664);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  Log.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ();
                  if (!d.cVx())
                  {
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ();
                    if (!d.cVx())
                    {
                      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -22;
                      BackupPcUI.3.this.Fc(-22);
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 64L, 1L, false);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(21664);
                      return;
                    }
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.b(13735, new Object[] { Integer.valueOf(27), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().cWg();
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
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  k.a(BackupPcUI.this, R.l.gtX, R.l.gtW, R.l.guM, R.l.gsm, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21665);
                      Log.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 26L, 1L, false);
                      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
                      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().a(true, true, -100);
                      AppMethodBeat.o(21665);
                    }
                  }, null, R.e.fkg);
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
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 25;
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
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ();
              if (!d.cVx())
              {
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -22;
                Fc(-22);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 64L, 1L, false);
                AppMethodBeat.o(21672);
                return;
              }
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().cWg();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
              BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.guv, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWj) }));
              BackupPcUI.d(BackupPcUI.this).setText(R.l.guu);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
              BackupPcUI.h(BackupPcUI.this).setText(R.l.guz);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cWk();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(R.k.backup_move_recover);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.guR);
              BackupPcUI.d(BackupPcUI.this).setText(R.l.gtq);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cWk();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_finished);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.gus);
              BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.gut, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi) }));
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkh));
              BackupPcUI.e(BackupPcUI.this).setText(R.l.gsq);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21668);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -100;
                  BackupPcUI.j(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21668);
                }
              });
              cWk();
              AppMethodBeat.o(21672);
              return;
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(R.l.guQ);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkg));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(4);
                cWl();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = R.l.guO;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).uWh;
                j = ((com.tencent.mm.plugin.backup.b.e)localObject).uWi;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
                localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = R.l.guA;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).uWh;
                j = ((com.tencent.mm.plugin.backup.b.e)localObject).uWi;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
                localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
              }
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(R.l.guP);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkg));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                cWl();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_icon);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = R.l.guO;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).uWh;
                j = ((com.tencent.mm.plugin.backup.b.e)localObject).uWi;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
                localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
                BackupPcUI.f(BackupPcUI.this).setText(R.l.guL);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21670);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.cH(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                    k.a(BackupPcUI.this, R.l.gtV, R.l.gtU, R.l.guL, R.l.gsm, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21669);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().cancel(true);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -100;
                        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 52L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().Fm(4);
                        BackupPcUI.k(BackupPcUI.this);
                        AppMethodBeat.o(21669);
                      }
                    }, null, R.e.fkg);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21670);
                  }
                });
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_icon);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = R.l.guA;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).uWh;
                j = ((com.tencent.mm.plugin.backup.b.e)localObject).uWi;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX();
                localTextView.setText(localBackupPcUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.plugin.backup.backuppcmodel.c.cWc() }));
                BackupPcUI.f(BackupPcUI.this).setText(R.l.guN);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21652);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.cH(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                    k.a(BackupPcUI.this, R.l.gtX, R.l.gtW, R.l.guM, R.l.gsm, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21651);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().a(true, true, -100);
                        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 52L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().Fm(4);
                        AppMethodBeat.o(21651);
                      }
                    }, null, R.e.fkg);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21652);
                  }
                });
              }
              if ((1 == i) || (3 == i))
              {
                BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_error);
                BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.guO, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi), "0M" }));
                BackupPcUI.d(BackupPcUI.this).setText(R.l.gug);
                BackupPcUI.f(BackupPcUI.this).setText(R.l.guL);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21654);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.cH(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                    k.a(BackupPcUI.this, R.l.gtV, R.l.gtU, R.l.guL, R.l.gsm, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21653);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 10L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().Fm(4);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().cancel(true);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -100;
                        BackupPcUI.l(BackupPcUI.this);
                        AppMethodBeat.o(21653);
                      }
                    }, null, R.e.fkg);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21654);
                  }
                });
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkg));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                cWl();
                AppMethodBeat.o(21672);
                return;
                if ((2 == i) || (4 == i))
                {
                  BackupPcUI.b(BackupPcUI.this).setImageResource(R.g.backup_pc_recover_error);
                  BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.guA, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi), "0M" }));
                  BackupPcUI.d(BackupPcUI.this).setText(R.l.gul);
                  BackupPcUI.f(BackupPcUI.this).setText(R.l.guN);
                  BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(21656);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.cH(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                      k.a(BackupPcUI.this, R.l.gtX, R.l.gtW, R.l.guM, R.l.gsm, false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(21655);
                          Log.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 18L, 1L, false);
                          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().Fm(4);
                          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
                          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().a(true, true, -100);
                          AppMethodBeat.o(21655);
                        }
                      }, null, R.e.fkg);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(21656);
                    }
                  });
                }
              }
              Fn(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.gui);
              localObject = g.fC(BackupPcUI.this);
              if ((localObject == null) || (((String)localObject).equals(""))) {
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.guj, new Object[] { com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbx, "移动网络" }));
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(R.e.fkg));
                BackupPcUI.f(BackupPcUI.this).setText(R.l.gum);
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21657);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.cH(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                    BackupPcUI.m(BackupPcUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21657);
                  }
                });
                cWk();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(R.l.guj, new Object[] { com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbx, localObject }));
              }
              Fn(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.gua);
              BackupPcUI.f(BackupPcUI.this).setText(R.l.gum);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21658);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  BackupPcUI.m(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21658);
                }
              });
              cWk();
              AppMethodBeat.o(21672);
              return;
              Fn(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.gub);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cWk();
              AppMethodBeat.o(21672);
              return;
              Fn(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.guk);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cWk();
              AppMethodBeat.o(21672);
              return;
              Fn(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.guh);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cWk();
              AppMethodBeat.o(21672);
              return;
              Fn(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.guf);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cWk();
              AppMethodBeat.o(21672);
              return;
              Fn(i);
              BackupPcUI.c(BackupPcUI.this).setText(R.l.guc);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cWk();
            }
          }
        }
      }
      
      public final void cUH()
      {
        AppMethodBeat.i(21671);
        int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw;
        Log.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 11;
          Fc(11);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 21;
          Fc(21);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 12;
          Fc(12);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 22;
          Fc(22);
        }
      }
      
      public final void cUI() {}
    };
    AppMethodBeat.o(21676);
  }
  
  private void cVP()
  {
    AppMethodBeat.i(21684);
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg;
    int j = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw;
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
        aAp(1);
        AppMethodBeat.o(21684);
        return;
        Log.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
        cWi();
        AppMethodBeat.o(21684);
        return;
        if ((1 == j) || (3 == j))
        {
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().cancel(false);
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -100;
        }
        else
        {
          if ((2 == j) || (4 == j))
          {
            com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().a(false, false, -100);
            AppMethodBeat.o(21684);
            return;
          }
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -100;
          continue;
          Log.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
          cWi();
          AppMethodBeat.o(21684);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 25;
        }
      }
    }
    k.a(this, R.l.gtX, R.l.gtW, R.l.guM, R.l.gsm, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21648);
        Log.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 26L, 1L, false);
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acOZ, Boolean.FALSE);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().a(true, true, -100);
        AppMethodBeat.o(21648);
      }
    }, null, R.e.fkg);
    AppMethodBeat.o(21684);
  }
  
  private void cWi()
  {
    AppMethodBeat.i(21685);
    Log.i("MicroMsg.BackupPcUI", "exitBackupPc.");
    if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw))
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cancel();
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVV();
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().cancel(true);
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = -100;
      aAp(1);
      AppMethodBeat.o(21685);
      return;
    }
    if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbw))
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ().a(true, true, -100);
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVt().stop();
    }
    AppMethodBeat.o(21685);
  }
  
  public int getLayoutId()
  {
    return R.i.gey;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21681);
    this.ngm = ((TextView)findViewById(R.h.fsV));
    this.vax = ((ImageView)findViewById(R.h.fsW));
    this.vav = ((TextView)findViewById(R.h.ftd));
    this.vaw = ((TextView)findViewById(R.h.fkh));
    this.vat = ((TextView)findViewById(R.h.fsC));
    this.vau = ((TextView)findViewById(R.h.fsB));
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
    com.tencent.mm.plugin.backup.a.pFn.aDA();
    initView();
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbD)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbD = false;
      int i = g.cUZ();
      if (i < 50)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.b(13736, new Object[] { Integer.valueOf(4), com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbx, g.fC(this), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
        k.a(this, R.l.gue, R.l.gud, R.l.guZ, 0, false, new BackupPcUI.1(this, i), null, R.e.fkf);
      }
    }
    if (((n)com.tencent.mm.kernel.h.ax(n.class)).bAd().gbd()) {
      br.bCK();
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
      cVP();
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
    Object localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY();
    b.c localc = this.vck;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).vbJ)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).vbJ.remove(localc);
      localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ();
      localc = this.vck;
    }
    synchronized (((d)localObject1).vbJ)
    {
      ((d)localObject1).vbJ.remove(localc);
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
    Object localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY();
    b.c localc = this.vck;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).vbJ)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).vbJ.add(localc);
      localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVZ();
      localc = this.vck;
    }
    synchronized (((d)localObject1).vbJ)
    {
      ((d)localObject1).vbJ.add(localc);
      int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg;
      this.vck.Fc(i);
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
    pNU = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    AppMethodBeat.o(21678);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI
 * JD-Core Version:    0.7.0.1
 */