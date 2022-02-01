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
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveRecoverUI
  extends MMWizardActivity
{
  private static boolean jZU = false;
  private static boolean oNo = false;
  public TextView hOu;
  private b.d oKF;
  public TextView oNi;
  public TextView oNj;
  public TextView oNk;
  public TextView oNl;
  public ImageView oNm;
  private RoundProgressBtn oNn;
  
  public BackupMoveRecoverUI()
  {
    AppMethodBeat.i(21448);
    this.oKF = new b.d()
    {
      public final void Ba(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21443);
        Object localObject1 = com.tencent.mm.plugin.backup.d.b.cfv().ceM();
        Log.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BackupMoveRecoverUI.oNo), Integer.valueOf(((e)localObject1).oJd), Integer.valueOf(((e)localObject1).oJe), Integer.valueOf(((e)localObject1).oJf) });
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
          BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
          BackupMoveRecoverUI.this.oNk.setText(2131756240);
          BackupMoveRecoverUI.this.oNl.setText(2131756273);
          BackupMoveRecoverUI.this.oNl.setVisibility(0);
          BackupMoveRecoverUI.this.oNi.setVisibility(4);
          BackupMoveRecoverUI.this.oNj.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
          BackupMoveRecoverUI.this.oNk.setText(2131756289);
          BackupMoveRecoverUI.this.oNl.setText(2131756273);
          BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
          BackupMoveRecoverUI.this.oNl.setVisibility(0);
          BackupMoveRecoverUI.this.oNi.setVisibility(4);
          BackupMoveRecoverUI.this.oNj.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
          BackupMoveRecoverUI.this.oNk.setText(2131756270);
          BackupMoveRecoverUI.this.oNi.setText(2131756272);
          BackupMoveRecoverUI.this.oNj.setText(2131756271);
          BackupMoveRecoverUI.this.oNl.setVisibility(4);
          BackupMoveRecoverUI.this.oNi.setVisibility(0);
          BackupMoveRecoverUI.this.oNj.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21417);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.plugin.backup.d.b.cfv().cfy().jA(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21417);
            }
          });
          BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21431);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.plugin.backup.d.b.cfv().cfy().jA(true);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21431);
            }
          });
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
          Object localObject2 = BackupMoveRecoverUI.this.oNk;
          Object localObject3 = BackupMoveRecoverUI.this;
          paramAnonymousInt = ((e)localObject1).oJd;
          int i = ((e)localObject1).oJe;
          com.tencent.mm.plugin.backup.d.b.cfv().cfy();
          ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(2131756294, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.d.c.cfE() }));
          BackupMoveRecoverUI.this.oNl.setText(2131756273);
          BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
          BackupMoveRecoverUI.this.oNl.setVisibility(0);
          BackupMoveRecoverUI.this.oNi.setVisibility(8);
          BackupMoveRecoverUI.this.oNj.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).ceV());
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21435);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
              com.tencent.mm.plugin.backup.d.b.cfv().cfy().cfD();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21435);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
          BackupMoveRecoverUI.this.oNk.setText(2131756277);
          BackupMoveRecoverUI.this.oNl.setText(2131756279);
          BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
          BackupMoveRecoverUI.this.oNl.setVisibility(0);
          BackupMoveRecoverUI.this.oNi.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.oNi.setText(2131756278);
          BackupMoveRecoverUI.this.oNi.setOnClickListener(new BackupMoveRecoverUI.1.16(this));
          BackupMoveRecoverUI.this.oNj.setVisibility(0);
          BackupMoveRecoverUI.this.oNj.setText(2131756293);
          BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21437);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
              com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 29;
              BackupMoveRecoverUI.1.this.Ba(29);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21437);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
          BackupMoveRecoverUI.this.oNk.setText(2131756304);
          BackupMoveRecoverUI.this.oNl.setText(2131756306);
          BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
          BackupMoveRecoverUI.this.oNl.setVisibility(0);
          BackupMoveRecoverUI.this.oNi.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.oNi.setText(2131756303);
          BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21438);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
              com.tencent.mm.plugin.backup.d.b.cfv().cfy();
              if (!com.tencent.mm.plugin.backup.d.c.cfA())
              {
                Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -22;
                BackupMoveRecoverUI.1.this.Ba(-22);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 6L, 1L, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21438);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.cfv().cfy().jz(false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21438);
            }
          });
          BackupMoveRecoverUI.this.oNj.setVisibility(0);
          BackupMoveRecoverUI.this.oNj.setText(2131756241);
          BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21440);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
              com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756243, 2131756242, 2131756292, 2131756224, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(21439);
                  Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.19.this.oMa) });
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 48L, 1L, false);
                  com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                  com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                  AppMethodBeat.o(21439);
                }
              }, null, 2131100015);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21440);
            }
          });
          BackupMoveRecoverUI.this.hOu.setText(2131756387);
          BackupMoveRecoverUI.this.hOu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21441);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 25;
              BackupMoveRecoverUI.e(BackupMoveRecoverUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21441);
            }
          });
          AppMethodBeat.o(21443);
          return;
          if (BackupMoveRecoverUI.oNo)
          {
            com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 24;
            paramAnonymousInt = 24;
            break;
            Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[] { Boolean.valueOf(BackupMoveRecoverUI.cfU()) });
            if (BackupMoveRecoverUI.cfU())
            {
              BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
              BackupMoveRecoverUI.this.oNk.setText(2131756295);
              BackupMoveRecoverUI.this.oNl.setText(2131756297);
              BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
              BackupMoveRecoverUI.this.oNi.setText(2131756291);
              BackupMoveRecoverUI.this.oNj.setText(2131756292);
              BackupMoveRecoverUI.this.hOu.setText(2131756387);
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(0);
              BackupMoveRecoverUI.this.oNj.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21442);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                  com.tencent.mm.plugin.backup.d.b.cfv().cfy();
                  if (!com.tencent.mm.plugin.backup.d.c.cfA())
                  {
                    Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                    com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -22;
                    BackupMoveRecoverUI.1.this.Ba(-22);
                    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 6L, 1L, false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21442);
                    return;
                  }
                  com.tencent.mm.plugin.backup.d.b.cfv().cfy().jz(false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21442);
                }
              });
              BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21419);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756243, 2131756242, 2131756292, 2131756224, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21418);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.2.this.oMa) });
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 48L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                      com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                      AppMethodBeat.o(21418);
                    }
                  }, null, 2131100015);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21419);
                }
              });
              BackupMoveRecoverUI.this.hOu.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21420);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 25;
                  BackupMoveRecoverUI.f(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21420);
                }
              });
              AppMethodBeat.o(21443);
              return;
            }
            if (BackupMoveRecoverUI.oNo)
            {
              com.tencent.mm.plugin.backup.d.b.cfv().cfy();
              if (!com.tencent.mm.plugin.backup.d.c.cfA())
              {
                Log.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -22;
                Ba(-22);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 6L, 1L, false);
                AppMethodBeat.o(21443);
                return;
              }
              com.tencent.mm.plugin.backup.d.b.cfv().cfy().jz(false);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689744);
              BackupMoveRecoverUI.this.oNk.setText(BackupMoveRecoverUI.this.getString(2131756286, new Object[] { Integer.valueOf(((e)localObject1).oJf) }));
              BackupMoveRecoverUI.this.oNl.setText(2131756287);
              BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(4);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689744);
              BackupMoveRecoverUI.this.oNk.setText(2131756386);
              BackupMoveRecoverUI.this.oNl.setText(2131756287);
              BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(4);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689746);
              BackupMoveRecoverUI.this.oNk.setText(2131756284);
              BackupMoveRecoverUI.this.oNl.setText(BackupMoveRecoverUI.this.getString(2131756285, new Object[] { Integer.valueOf(((e)localObject1).oJd), Integer.valueOf(((e)localObject1).oJe) }));
              BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
              BackupMoveRecoverUI.this.oNi.setText(2131756230);
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(0);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21421);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                  com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
                  BackupMoveRecoverUI.g(BackupMoveRecoverUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21421);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
              localObject2 = BackupMoveRecoverUI.this.oNk;
              localObject3 = BackupMoveRecoverUI.this;
              paramAnonymousInt = ((e)localObject1).oJd;
              i = ((e)localObject1).oJe;
              com.tencent.mm.plugin.backup.d.b.cfv().cfy();
              ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(2131756294, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.d.c.cfE() }));
              BackupMoveRecoverUI.this.oNl.setText(2131756309);
              BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100016));
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(8);
              BackupMoveRecoverUI.this.oNj.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).ceV());
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21422);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                  com.tencent.mm.plugin.backup.d.b.cfv().cfy().cfD();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21422);
                }
              });
              BackupMoveRecoverUI.this.oNj.setText(2131756310);
              BackupMoveRecoverUI.this.oNj.setOnClickListener(new BackupMoveRecoverUI.1.6(this));
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689740);
              BackupMoveRecoverUI.this.oNk.setText(BackupMoveRecoverUI.this.getString(2131756274, new Object[] { Integer.valueOf(((e)localObject1).oJd), Integer.valueOf(((e)localObject1).oJe), "0M" }));
              BackupMoveRecoverUI.this.oNl.setText(2131756258);
              BackupMoveRecoverUI.this.oNi.setText(2131756290);
              BackupMoveRecoverUI.this.oNj.setText(2131756293);
              BackupMoveRecoverUI.this.oNi.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21424);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(7);
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  com.tencent.mm.br.c.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21424);
                }
              });
              BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21426);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756245, 2131756244, 2131756293, 2131756224, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21425);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.8.this.oMa) });
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(6);
                      com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                      com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                      AppMethodBeat.o(21425);
                    }
                  }, null, 2131100015);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21426);
                }
              });
              BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100015));
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(0);
              BackupMoveRecoverUI.this.oNj.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689740);
              BackupMoveRecoverUI.this.oNk.setText(2131756261);
              localObject2 = g.eE(BackupMoveRecoverUI.this);
              localObject3 = com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLO;
              localObject1 = localObject2;
              if (Util.isNullOrNil((String)localObject2)) {
                localObject1 = "移动网络";
              }
              localObject2 = localObject3;
              if (Util.isNullOrNil((String)localObject3)) {
                localObject2 = "移动网络";
              }
              if ((!((String)localObject1).equals("wifi")) && (!((String)localObject2).equals("wifi"))) {
                BackupMoveRecoverUI.this.oNl.setText(BackupMoveRecoverUI.this.getString(2131756262, new Object[] { localObject1, localObject2 }));
              }
              BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100015));
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(4);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689740);
              BackupMoveRecoverUI.this.oNk.setText(2131756247);
              BackupMoveRecoverUI.this.oNl.setText(2131756248);
              BackupMoveRecoverUI.this.oNi.setText(2131756288);
              BackupMoveRecoverUI.this.oNj.setText(2131756293);
              BackupMoveRecoverUI.this.oNl.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131100015));
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(0);
              BackupMoveRecoverUI.this.oNj.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.oNi.setOnClickListener(new BackupMoveRecoverUI.1.9(this));
              BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21429);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756245, 2131756244, 2131756293, 2131756224, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21428);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.10.this.oMa) });
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(5);
                      com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                      com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                      AppMethodBeat.o(21428);
                    }
                  }, null, 2131100015);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21429);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689740);
              BackupMoveRecoverUI.this.oNk.setText(2131756249);
              BackupMoveRecoverUI.this.oNi.setText(2131756290);
              BackupMoveRecoverUI.this.oNj.setText(2131756293);
              BackupMoveRecoverUI.this.oNl.setVisibility(4);
              BackupMoveRecoverUI.this.oNi.setVisibility(0);
              BackupMoveRecoverUI.this.oNj.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.oNi.setOnClickListener(new BackupMoveRecoverUI.1.11(this));
              BackupMoveRecoverUI.this.oNj.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21433);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756245, 2131756244, 2131756293, 2131756224, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21432);
                      Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.13.this.oMa) });
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 44L, 1L, false);
                      com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(5);
                      com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
                      com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
                      AppMethodBeat.o(21432);
                    }
                  }, null, 2131100015);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(21433);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689740);
              BackupMoveRecoverUI.this.oNk.setText(2131756266);
              BackupMoveRecoverUI.this.oNl.setVisibility(4);
              BackupMoveRecoverUI.this.oNi.setVisibility(4);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131231138);
              BackupMoveRecoverUI.this.oNk.setText(2131756240);
              BackupMoveRecoverUI.this.oNl.setText(2131756273);
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(4);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756257, 0, 2131756404, 0, false, new BackupMoveRecoverUI.1.14(this), null, 2131100014);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689740);
              BackupMoveRecoverUI.this.oNk.setText(2131756259);
              BackupMoveRecoverUI.this.oNl.setText(BackupMoveRecoverUI.this.getString(2131756260, new Object[] { Util.getSizeKB(com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLV) }));
              BackupMoveRecoverUI.this.oNl.setVisibility(0);
              BackupMoveRecoverUI.this.oNi.setVisibility(4);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689740);
              BackupMoveRecoverUI.this.oNk.setText(2131756250);
              BackupMoveRecoverUI.this.oNl.setVisibility(4);
              BackupMoveRecoverUI.this.oNi.setVisibility(4);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.oNm.setImageResource(2131689740);
              BackupMoveRecoverUI.this.oNk.setText(2131756255);
              com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
              BackupMoveRecoverUI.this.oNl.setVisibility(4);
              BackupMoveRecoverUI.this.oNi.setVisibility(4);
              BackupMoveRecoverUI.this.oNj.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
            }
          }
        }
      }
      
      public final void ceL() {}
    };
    AppMethodBeat.o(21448);
  }
  
  private void cfT()
  {
    AppMethodBeat.i(21455);
    final int i = com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc;
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
        ala(1);
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(false, false, -100);
        AppMethodBeat.o(21455);
        return;
        Log.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, false, -100);
        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
        AppMethodBeat.o(21455);
        return;
        com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = 25;
      }
    case 52: 
      com.tencent.mm.ui.base.h.a(this, 2131756245, 2131756244, 2131756293, 2131756224, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21445);
          Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 44L, 1L, false);
          com.tencent.mm.plugin.backup.d.b.cfv().cfy().Be(5);
          com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
          com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
          AppMethodBeat.o(21445);
        }
      }, null, 2131100015);
      AppMethodBeat.o(21455);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131756329, 2131756328, 2131756380, 2131756224, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21446);
        Log.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 48L, 1L, false);
        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
        com.tencent.mm.plugin.backup.d.b.cfv().cfy().a(true, true, -100);
        AppMethodBeat.o(21446);
      }
    }, null, 2131100015);
    AppMethodBeat.o(21455);
  }
  
  public int getLayoutId()
  {
    return 2131493174;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21450);
    this.hOu = ((TextView)findViewById(2131297199));
    this.oNm = ((ImageView)findViewById(2131297200));
    this.oNk = ((TextView)findViewById(2131297209));
    this.oNl = ((TextView)findViewById(2131297208));
    this.oNi = ((TextView)findViewById(2131297180));
    this.oNj = ((TextView)findViewById(2131297179));
    this.oNn = ((RoundProgressBtn)findViewById(2131297207));
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
    com.tencent.mm.plugin.backup.a.jRt.Xc();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLH = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      Log.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.cfv().cfy().oLH) });
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
      cfT();
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
    oNo = false;
    AppMethodBeat.o(21452);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21451);
    super.onResume();
    Log.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
    oNo = true;
    com.tencent.mm.plugin.backup.d.b.cfv().cfy().oKF = this.oKF;
    jZU = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    this.oKF.Ba(com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc);
    AppMethodBeat.o(21451);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI
 * JD-Core Version:    0.7.0.1
 */