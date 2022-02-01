package com.tencent.mm.plugin.backup.backuppcui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupPcUI
  extends MMWizardActivity
{
  private static boolean iYY = false;
  private TextView gSR;
  private TextView nwO;
  private TextView nwP;
  private TextView nwQ;
  private TextView nwR;
  private ImageView nwS;
  public b.c nyG;
  
  public BackupPcUI()
  {
    AppMethodBeat.i(21676);
    this.nyG = new b.c()
    {
      private void bIx()
      {
        AppMethodBeat.i(21674);
        BackupPcUI.h(BackupPcUI.this).setText(2131756095);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21659);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            BackupPcUI.n(BackupPcUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21659);
          }
        });
        AppMethodBeat.o(21674);
      }
      
      private void bIy()
      {
        AppMethodBeat.i(21675);
        BackupPcUI.h(BackupPcUI.this).setText(2131756097);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21660);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            BackupPcUI.o(BackupPcUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21660);
          }
        });
        AppMethodBeat.o(21675);
      }
      
      private void xB(int paramAnonymousInt)
      {
        AppMethodBeat.i(21673);
        if ((2 == paramAnonymousInt) || (4 == paramAnonymousInt))
        {
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231108);
          AppMethodBeat.o(21673);
          return;
        }
        BackupPcUI.b(BackupPcUI.this).setImageResource(2131231105);
        AppMethodBeat.o(21673);
      }
      
      public final void bGV()
      {
        AppMethodBeat.i(21671);
        int i = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS;
        ad.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 11;
          xp(11);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 21;
          xp(21);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 12;
          xp(12);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 22;
          xp(22);
        }
      }
      
      public final void bGW() {}
      
      public final void xp(int paramAnonymousInt)
      {
        AppMethodBeat.i(21672);
        int i = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS;
        ad.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        Object localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX();
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
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          BackupPcUI.c(BackupPcUI.this).setText(2131756189);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bIx();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          BackupPcUI.c(BackupPcUI.this).setText(2131756244);
          BackupPcUI.d(BackupPcUI.this).setText(2131756243);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.e(BackupPcUI.this).setText(2131756241);
          BackupPcUI.f(BackupPcUI.this).setText(2131756242);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(0);
          bIx();
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21650);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ba.aBQ();
              boolean bool = ((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Ixi, Boolean.FALSE)).booleanValue();
              ad.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                h.a(BackupPcUI.this, 2131756216, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(21649);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().xz(2);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 12;
                    BackupPcUI.3.this.xp(12);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bIi();
                    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().iE(true);
                    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 7L, 1L, false);
                    com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
                    AppMethodBeat.o(21649);
                  }
                }, null, 2131099990);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21650);
                return;
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().xz(2);
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 12;
                BackupPcUI.3.this.xp(12);
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().cancel();
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bIi();
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().iE(true);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 7L, 1L, false);
                com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
              }
            }
          });
          BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21661);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              paramAnonymous2View = new Intent(BackupPcUI.this, BackupPcChooseUI.class);
              MMWizardActivity.al(BackupPcUI.this, paramAnonymous2View);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().cancel();
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bIi();
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().iE(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21661);
            }
          });
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          BackupPcUI.c(BackupPcUI.this).setText(2131756220);
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bIy();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          TextView localTextView = BackupPcUI.c(BackupPcUI.this);
          BackupPcUI localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nsK;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).nsL;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
          localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bIy();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231106);
          BackupPcUI.c(BackupPcUI.this).setText(2131756180);
          BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756181, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL) }));
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.e(BackupPcUI.this).setText(2131756096);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21662);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().cancel(true);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -100;
              BackupPcUI.g(BackupPcUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21662);
            }
          });
          bIx();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
          BackupPcUI.c(BackupPcUI.this).setText(2131756230);
          BackupPcUI.e(BackupPcUI.this).setText(2131756229);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21663);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(23), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().xz(4);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 22;
              BackupPcUI.3.this.xp(22);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 16L, 1L, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21663);
            }
          });
          bIx();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
          BackupPcUI.c(BackupPcUI.this).setText(2131756220);
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bIy();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
          localTextView = BackupPcUI.c(BackupPcUI.this);
          localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nsK;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).nsL;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
          localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bIy();
          AppMethodBeat.o(21672);
          return;
          if (bt.jh(BackupPcUI.this))
          {
            com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 24;
            paramAnonymousInt = 24;
            break;
            if (BackupPcUI.bIw())
            {
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
              BackupPcUI.c(BackupPcUI.this).setText(2131756233);
              BackupPcUI.d(BackupPcUI.this).setText(2131756235);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.e(BackupPcUI.this).setText(2131756228);
              BackupPcUI.f(BackupPcUI.this).setText(2131756231);
              BackupPcUI.h(BackupPcUI.this).setText(2131756253);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21664);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  ad.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                  com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm();
                  if (!d.bHL())
                  {
                    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm();
                    if (!d.bHL())
                    {
                      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -22;
                      BackupPcUI.3.this.xp(-22);
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 64L, 1L, false);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(21664);
                      return;
                    }
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(27), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
                  com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().bIt();
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
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  h.a(BackupPcUI.this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21665);
                      ad.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 26L, 1L, false);
                      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
                      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().b(true, true, -100);
                      AppMethodBeat.o(21665);
                    }
                  }, null, 2131099991);
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
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 25;
                  BackupPcUI.i(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21667);
                }
              });
              AppMethodBeat.o(21672);
              return;
            }
            if (bt.jh(BackupPcUI.this))
            {
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm();
              if (!d.bHL())
              {
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -22;
                xp(-22);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 64L, 1L, false);
                AppMethodBeat.o(21672);
                return;
              }
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().bIt();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
              BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756227, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsM) }));
              BackupPcUI.d(BackupPcUI.this).setText(2131756226);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.h(BackupPcUI.this).setText(2131756231);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bIx();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131689735);
              BackupPcUI.c(BackupPcUI.this).setText(2131756252);
              BackupPcUI.d(BackupPcUI.this).setText(2131756153);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bIx();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231109);
              BackupPcUI.c(BackupPcUI.this).setText(2131756224);
              BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756225, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL) }));
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.e(BackupPcUI.this).setText(2131756096);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21668);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
                  com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -100;
                  BackupPcUI.j(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21668);
                }
              });
              bIx();
              AppMethodBeat.o(21672);
              return;
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(2131756251);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099991));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(4);
                bIy();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nsK;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).nsL;
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
                localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nsK;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).nsL;
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
                localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
              }
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(2131756250);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099991));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                bIy();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nsK;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).nsL;
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
                localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
                BackupPcUI.f(BackupPcUI.this).setText(2131756245);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21670);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    h.a(BackupPcUI.this, 2131756193, 2131756192, 2131756245, 2131756090, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21669);
                        ad.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().cancel(true);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -100;
                        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 52L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().xA(4);
                        BackupPcUI.k(BackupPcUI.this);
                        AppMethodBeat.o(21669);
                      }
                    }, null, 2131099991);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21670);
                  }
                });
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nsK;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).nsL;
                com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk();
                localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bIp() }));
                BackupPcUI.f(BackupPcUI.this).setText(2131756247);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21652);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    h.a(BackupPcUI.this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21651);
                        ad.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().b(true, true, -100);
                        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 52L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().xA(4);
                        AppMethodBeat.o(21651);
                      }
                    }, null, 2131099991);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21652);
                  }
                });
              }
              if ((1 == i) || (3 == i))
              {
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231105);
                BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756249, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL), "0M" }));
                BackupPcUI.d(BackupPcUI.this).setText(2131756204);
                BackupPcUI.f(BackupPcUI.this).setText(2131756245);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21654);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    h.a(BackupPcUI.this, 2131756193, 2131756192, 2131756245, 2131756090, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21653);
                        ad.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 10L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().xA(4);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().cancel(true);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -100;
                        BackupPcUI.l(BackupPcUI.this);
                        AppMethodBeat.o(21653);
                      }
                    }, null, 2131099991);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21654);
                  }
                });
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099991));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                bIy();
                AppMethodBeat.o(21672);
                return;
                if ((2 == i) || (4 == i))
                {
                  BackupPcUI.b(BackupPcUI.this).setImageResource(2131231108);
                  BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756232, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL), "0M" }));
                  BackupPcUI.d(BackupPcUI.this).setText(2131756212);
                  BackupPcUI.f(BackupPcUI.this).setText(2131756247);
                  BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(21656);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bd(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                      h.a(BackupPcUI.this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(21655);
                          ad.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 18L, 1L, false);
                          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().xA(4);
                          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
                          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().b(true, true, -100);
                          AppMethodBeat.o(21655);
                        }
                      }, null, 2131099991);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(21656);
                    }
                  });
                }
              }
              xB(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756209);
              localObject = com.tencent.mm.plugin.backup.b.g.eh(BackupPcUI.this);
              if ((localObject == null) || (((String)localObject).equals(""))) {
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756210, new Object[] { com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxT, "移动网络" }));
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099991));
                BackupPcUI.f(BackupPcUI.this).setText(2131756214);
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21657);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    BackupPcUI.m(BackupPcUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21657);
                  }
                });
                bIx();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756210, new Object[] { com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxT, localObject }));
              }
              xB(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756198);
              BackupPcUI.f(BackupPcUI.this).setText(2131756214);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21658);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  BackupPcUI.m(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21658);
                }
              });
              bIx();
              AppMethodBeat.o(21672);
              return;
              xB(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756199);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bIx();
              AppMethodBeat.o(21672);
              return;
              xB(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756211);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bIx();
              AppMethodBeat.o(21672);
              return;
              xB(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756208);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bIx();
              AppMethodBeat.o(21672);
              return;
              xB(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756203);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bIx();
              AppMethodBeat.o(21672);
              return;
              xB(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756200);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bIx();
            }
          }
        }
      }
    };
    AppMethodBeat.o(21676);
  }
  
  private void bIc()
  {
    AppMethodBeat.i(21684);
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ;
    int j = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS;
    ad.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
        abK(1);
        AppMethodBeat.o(21684);
        return;
        ad.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
        bIv();
        AppMethodBeat.o(21684);
        return;
        if ((1 == j) || (3 == j))
        {
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().cancel(false);
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -100;
        }
        else
        {
          if ((2 == j) || (4 == j))
          {
            com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().b(false, false, -100);
            AppMethodBeat.o(21684);
            return;
          }
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -100;
          continue;
          ad.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
          bIv();
          AppMethodBeat.o(21684);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 25;
        }
      }
    }
    h.a(this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21648);
        ad.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 26L, 1L, false);
        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().b(true, true, -100);
        AppMethodBeat.o(21648);
      }
    }, null, 2131099991);
    AppMethodBeat.o(21684);
  }
  
  private void bIv()
  {
    AppMethodBeat.i(21685);
    ad.i("MicroMsg.BackupPcUI", "exitBackupPc.");
    if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS))
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().cancel();
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bIi();
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().cancel(true);
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = -100;
      abK(1);
      AppMethodBeat.o(21685);
      return;
    }
    if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxS))
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm().b(true, true, -100);
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bHH().stop();
    }
    AppMethodBeat.o(21685);
  }
  
  public int getLayoutId()
  {
    return 2131493131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21681);
    this.gSR = ((TextView)findViewById(2131297053));
    this.nwS = ((ImageView)findViewById(2131297054));
    this.nwQ = ((TextView)findViewById(2131297063));
    this.nwR = ((TextView)findViewById(2131297062));
    this.nwO = ((TextView)findViewById(2131297034));
    this.nwP = ((TextView)findViewById(2131297033));
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
    ad.i("MicroMsg.BackupPcUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.iRG.MU();
    initView();
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxZ)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxZ = false;
      final int i = com.tencent.mm.plugin.backup.b.g.bHn();
      if (i < 50)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(13736, new Object[] { Integer.valueOf(4), com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxT, com.tencent.mm.plugin.backup.b.g.eh(this), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
        h.a(this, 2131756202, 2131756201, 2131756270, 0, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(21647);
            ad.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(21647);
          }
        }, null, 2131099990);
      }
    }
    if (((l)com.tencent.mm.kernel.g.ab(l.class)).azS().dlO()) {
      bj.aCc();
    }
    AppMethodBeat.o(21677);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21682);
    ad.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", new Object[] { bt.flS() });
    super.onDestroy();
    AppMethodBeat.o(21682);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21683);
    if (paramInt == 4)
    {
      bIc();
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
    ad.i("MicroMsg.BackupPcUI", "onPause.");
    Object localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl();
    b.c localc = this.nyG;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).nye)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).nye.remove(localc);
      localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm();
      localc = this.nyG;
    }
    synchronized (((d)localObject1).nye)
    {
      ((d)localObject1).nye.remove(localc);
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
    ad.i("MicroMsg.BackupPcUI", "onResume.");
    Object localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl();
    b.c localc = this.nyG;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).nye)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).nye.add(localc);
      localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIm();
      localc = this.nyG;
    }
    synchronized (((d)localObject1).nye)
    {
      ((d)localObject1).nye.add(localc);
      int i = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ;
      this.nyG.xp(i);
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
    ad.i("MicroMsg.BackupPcUI", "onStart.");
    iYY = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    AppMethodBeat.o(21678);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI
 * JD-Core Version:    0.7.0.1
 */