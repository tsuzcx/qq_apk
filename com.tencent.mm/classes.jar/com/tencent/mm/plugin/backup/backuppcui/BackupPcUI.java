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
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
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
  private static boolean jZU = false;
  private TextView hOu;
  private TextView oNi;
  private TextView oNj;
  private TextView oNk;
  private TextView oNl;
  private ImageView oNm;
  public b.c oOY;
  
  public BackupPcUI()
  {
    AppMethodBeat.i(21676);
    this.oOY = new b.c()
    {
      private void Bl(int paramAnonymousInt)
      {
        AppMethodBeat.i(21673);
        if ((2 == paramAnonymousInt) || (4 == paramAnonymousInt))
        {
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231143);
          AppMethodBeat.o(21673);
          return;
        }
        BackupPcUI.b(BackupPcUI.this).setImageResource(2131231140);
        AppMethodBeat.o(21673);
      }
      
      private void cgo()
      {
        AppMethodBeat.i(21674);
        BackupPcUI.h(BackupPcUI.this).setText(2131756229);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21659);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            BackupPcUI.n(BackupPcUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21659);
          }
        });
        AppMethodBeat.o(21674);
      }
      
      private void cgp()
      {
        AppMethodBeat.i(21675);
        BackupPcUI.h(BackupPcUI.this).setText(2131756231);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21660);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            BackupPcUI.o(BackupPcUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21660);
          }
        });
        AppMethodBeat.o(21675);
      }
      
      public final void Ba(int paramAnonymousInt)
      {
        AppMethodBeat.i(21672);
        int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk;
        Log.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        Object localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM();
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
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231142);
          BackupPcUI.c(BackupPcUI.this).setText(2131756323);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cgo();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231142);
          BackupPcUI.c(BackupPcUI.this).setText(2131756378);
          BackupPcUI.d(BackupPcUI.this).setText(2131756377);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
          BackupPcUI.e(BackupPcUI.this).setText(2131756375);
          BackupPcUI.f(BackupPcUI.this).setText(2131756376);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(0);
          cgo();
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21650);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              bg.aVF();
              boolean bool = ((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NZI, Boolean.FALSE)).booleanValue();
              Log.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756350, 0, 2131756404, 0, false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(21649);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(2);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
                    BackupPcUI.3.this.Ba(12);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfZ();
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().jD(true);
                    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 7L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
                    AppMethodBeat.o(21649);
                  }
                }, null, 2131100014);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21650);
                return;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(2);
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
                BackupPcUI.3.this.Ba(12);
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cancel();
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfZ();
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().jD(true);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 7L, 1L, false);
                com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
              }
            }
          });
          BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21661);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              paramAnonymous2View = new Intent(BackupPcUI.this, BackupPcChooseUI.class);
              MMWizardActivity.ay(BackupPcUI.this, paramAnonymous2View);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cancel();
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfZ();
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().jD(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21661);
            }
          });
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231142);
          BackupPcUI.c(BackupPcUI.this).setText(2131756354);
          BackupPcUI.d(BackupPcUI.this).setText(2131756355);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cgp();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231142);
          TextView localTextView = BackupPcUI.c(BackupPcUI.this);
          BackupPcUI localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).oJd;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).oJe;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
          localTextView.setText(localBackupPcUI.getString(2131756383, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
          BackupPcUI.d(BackupPcUI.this).setText(2131756355);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cgp();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231141);
          BackupPcUI.c(BackupPcUI.this).setText(2131756314);
          BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756315, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe) }));
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
          BackupPcUI.e(BackupPcUI.this).setText(2131756230);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21662);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(true);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
              BackupPcUI.g(BackupPcUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21662);
            }
          });
          cgo();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231145);
          BackupPcUI.c(BackupPcUI.this).setText(2131756364);
          BackupPcUI.e(BackupPcUI.this).setText(2131756363);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21663);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(23), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(4);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 22;
              BackupPcUI.3.this.Ba(22);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 16L, 1L, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21663);
            }
          });
          cgo();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231145);
          BackupPcUI.c(BackupPcUI.this).setText(2131756354);
          BackupPcUI.d(BackupPcUI.this).setText(2131756355);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cgp();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231145);
          localTextView = BackupPcUI.c(BackupPcUI.this);
          localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).oJd;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).oJe;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
          localTextView.setText(localBackupPcUI.getString(2131756366, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
          BackupPcUI.d(BackupPcUI.this).setText(2131756355);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          cgp();
          AppMethodBeat.o(21672);
          return;
          if (Util.isTopActivity(BackupPcUI.this))
          {
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 24;
            paramAnonymousInt = 24;
            break;
            if (BackupPcUI.cgn())
            {
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231145);
              BackupPcUI.c(BackupPcUI.this).setText(2131756367);
              BackupPcUI.d(BackupPcUI.this).setText(2131756369);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
              BackupPcUI.e(BackupPcUI.this).setText(2131756362);
              BackupPcUI.f(BackupPcUI.this).setText(2131756365);
              BackupPcUI.h(BackupPcUI.this).setText(2131756387);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21664);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
                  if (!d.cfA())
                  {
                    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
                    if (!d.cfA())
                    {
                      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -22;
                      BackupPcUI.3.this.Ba(-22);
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 64L, 1L, false);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(21664);
                      return;
                    }
                  }
                  com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(27), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().cgk();
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
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756329, 2131756328, 2131756380, 2131756224, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21665);
                      Log.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 26L, 1L, false);
                      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
                      AppMethodBeat.o(21665);
                    }
                  }, null, 2131100015);
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
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 25;
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
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
              if (!d.cfA())
              {
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -22;
                Ba(-22);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 64L, 1L, false);
                AppMethodBeat.o(21672);
                return;
              }
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().cgk();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231145);
              BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756361, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJf) }));
              BackupPcUI.d(BackupPcUI.this).setText(2131756360);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
              BackupPcUI.h(BackupPcUI.this).setText(2131756365);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cgo();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131689744);
              BackupPcUI.c(BackupPcUI.this).setText(2131756386);
              BackupPcUI.d(BackupPcUI.this).setText(2131756287);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cgo();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231144);
              BackupPcUI.c(BackupPcUI.this).setText(2131756358);
              BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756359, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe) }));
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100016));
              BackupPcUI.e(BackupPcUI.this).setText(2131756230);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21668);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                  com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                  BackupPcUI.j(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21668);
                }
              });
              cgo();
              AppMethodBeat.o(21672);
              return;
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(2131756385);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100015));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(4);
                cgp();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231142);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).oJd;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).oJe;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                localTextView.setText(localBackupPcUI.getString(2131756383, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231145);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).oJd;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).oJe;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                localTextView.setText(localBackupPcUI.getString(2131756366, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
              }
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(2131756384);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100015));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                cgp();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231142);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).oJd;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).oJe;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                localTextView.setText(localBackupPcUI.getString(2131756383, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
                BackupPcUI.f(BackupPcUI.this).setText(2131756379);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21670);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756327, 2131756326, 2131756379, 2131756224, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21669);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(true);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 52L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().Bk(4);
                        BackupPcUI.k(BackupPcUI.this);
                        AppMethodBeat.o(21669);
                      }
                    }, null, 2131100015);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21670);
                  }
                });
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231145);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).oJd;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).oJe;
                com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb();
                localTextView.setText(localBackupPcUI.getString(2131756366, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.cgg() }));
                BackupPcUI.f(BackupPcUI.this).setText(2131756381);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21652);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756329, 2131756328, 2131756380, 2131756224, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21651);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
                        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 52L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().Bk(4);
                        AppMethodBeat.o(21651);
                      }
                    }, null, 2131100015);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21652);
                  }
                });
              }
              if ((1 == i) || (3 == i))
              {
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231140);
                BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756383, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe), "0M" }));
                BackupPcUI.d(BackupPcUI.this).setText(2131756338);
                BackupPcUI.f(BackupPcUI.this).setText(2131756379);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21654);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756327, 2131756326, 2131756379, 2131756224, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21653);
                        Log.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 10L, 1L, false);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().Bk(4);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(true);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
                        BackupPcUI.l(BackupPcUI.this);
                        AppMethodBeat.o(21653);
                      }
                    }, null, 2131100015);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21654);
                  }
                });
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100015));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                cgp();
                AppMethodBeat.o(21672);
                return;
                if ((2 == i) || (4 == i))
                {
                  BackupPcUI.b(BackupPcUI.this).setImageResource(2131231143);
                  BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756366, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe), "0M" }));
                  BackupPcUI.d(BackupPcUI.this).setText(2131756346);
                  BackupPcUI.f(BackupPcUI.this).setText(2131756381);
                  BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(21656);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bm(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                      com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756329, 2131756328, 2131756380, 2131756224, false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(21655);
                          Log.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 18L, 1L, false);
                          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().Bk(4);
                          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
                          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
                          AppMethodBeat.o(21655);
                        }
                      }, null, 2131100015);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(21656);
                    }
                  });
                }
              }
              Bl(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756343);
              localObject = com.tencent.mm.plugin.backup.b.g.eE(BackupPcUI.this);
              if ((localObject == null) || (((String)localObject).equals(""))) {
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756344, new Object[] { com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOl, "移动网络" }));
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131100015));
                BackupPcUI.f(BackupPcUI.this).setText(2131756348);
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21657);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    BackupPcUI.m(BackupPcUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21657);
                  }
                });
                cgo();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756344, new Object[] { com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOl, localObject }));
              }
              Bl(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756332);
              BackupPcUI.f(BackupPcUI.this).setText(2131756348);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21658);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  BackupPcUI.m(BackupPcUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcUI$3$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21658);
                }
              });
              cgo();
              AppMethodBeat.o(21672);
              return;
              Bl(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756333);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cgo();
              AppMethodBeat.o(21672);
              return;
              Bl(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756345);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cgo();
              AppMethodBeat.o(21672);
              return;
              Bl(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756342);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cgo();
              AppMethodBeat.o(21672);
              return;
              Bl(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756337);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cgo();
              AppMethodBeat.o(21672);
              return;
              Bl(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756334);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              cgo();
            }
          }
        }
      }
      
      public final void ceK()
      {
        AppMethodBeat.i(21671);
        int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk;
        Log.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 11;
          Ba(11);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 21;
          Ba(21);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
          Ba(12);
          AppMethodBeat.o(21671);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 22;
          Ba(22);
        }
      }
      
      public final void ceL() {}
    };
    AppMethodBeat.o(21676);
  }
  
  private void cfT()
  {
    AppMethodBeat.i(21684);
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc;
    int j = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk;
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
        ala(1);
        AppMethodBeat.o(21684);
        return;
        Log.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
        cgm();
        AppMethodBeat.o(21684);
        return;
        if ((1 == j) || (3 == j))
        {
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(false);
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
        }
        else
        {
          if ((2 == j) || (4 == j))
          {
            com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(false, false, -100);
            AppMethodBeat.o(21684);
            return;
          }
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
          continue;
          Log.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
          cgm();
          AppMethodBeat.o(21684);
          return;
          com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 25;
        }
      }
    }
    com.tencent.mm.ui.base.h.a(this, 2131756329, 2131756328, 2131756380, 2131756224, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21648);
        Log.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 26L, 1L, false);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
        AppMethodBeat.o(21648);
      }
    }, null, 2131100015);
    AppMethodBeat.o(21684);
  }
  
  private void cgm()
  {
    AppMethodBeat.i(21685);
    Log.i("MicroMsg.BackupPcUI", "exitBackupPc.");
    if ((1 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) || (3 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk))
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cancel();
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfZ();
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().cancel(true);
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = -100;
      ala(1);
      AppMethodBeat.o(21685);
      return;
    }
    if ((2 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk) || (4 == com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOk))
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd().a(true, true, -100);
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cfw().stop();
    }
    AppMethodBeat.o(21685);
  }
  
  public int getLayoutId()
  {
    return 2131493174;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21681);
    this.hOu = ((TextView)findViewById(2131297199));
    this.oNm = ((ImageView)findViewById(2131297200));
    this.oNk = ((TextView)findViewById(2131297209));
    this.oNl = ((TextView)findViewById(2131297208));
    this.oNi = ((TextView)findViewById(2131297180));
    this.oNj = ((TextView)findViewById(2131297179));
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
    com.tencent.mm.plugin.backup.a.jRt.Xc();
    initView();
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOr)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOr = false;
      final int i = com.tencent.mm.plugin.backup.b.g.cfc();
      if (i < 50)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.h.CyF.a(13736, new Object[] { Integer.valueOf(4), com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOl, com.tencent.mm.plugin.backup.b.g.eE(this), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
        com.tencent.mm.ui.base.h.a(this, 2131756336, 2131756335, 2131756404, 0, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(21647);
            Log.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(21647);
          }
        }, null, 2131100014);
      }
    }
    if (((l)com.tencent.mm.kernel.g.af(l.class)).aTq().eiC()) {
      bp.aVQ();
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
      cfT();
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
    Object localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc();
    b.c localc = this.oOY;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).oOw)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).oOw.remove(localc);
      localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
      localc = this.oOY;
    }
    synchronized (((d)localObject1).oOw)
    {
      ((d)localObject1).oOw.remove(localc);
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
    Object localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc();
    b.c localc = this.oOY;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).oOw)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).oOw.add(localc);
      localObject1 = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgd();
      localc = this.oOY;
    }
    synchronized (((d)localObject1).oOw)
    {
      ((d)localObject1).oOw.add(localc);
      int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc;
      this.oOY.Ba(i);
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
    jZU = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    AppMethodBeat.o(21678);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI
 * JD-Core Version:    0.7.0.1
 */