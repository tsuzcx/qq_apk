package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.ComponentName;
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
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveRecoverUI
  extends MMWizardActivity
{
  private static boolean iFP = false;
  private static boolean mWx = false;
  public TextView gzg;
  private b.d mTO;
  public TextView mWr;
  public TextView mWs;
  public TextView mWt;
  public TextView mWu;
  public ImageView mWv;
  private RoundProgressBtn mWw;
  
  public BackupMoveRecoverUI()
  {
    AppMethodBeat.i(21448);
    this.mTO = new b.d()
    {
      public final void bCO() {}
      
      public final void wJ(final int paramAnonymousInt)
      {
        AppMethodBeat.i(21443);
        Object localObject1 = b.bDy().bCP();
        ac.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(BackupMoveRecoverUI.mWx), Integer.valueOf(((e)localObject1).mSl), Integer.valueOf(((e)localObject1).mSm), Integer.valueOf(((e)localObject1).mSn) });
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
          BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
          BackupMoveRecoverUI.this.mWt.setText(2131756106);
          BackupMoveRecoverUI.this.mWu.setText(2131756139);
          BackupMoveRecoverUI.this.mWu.setVisibility(0);
          BackupMoveRecoverUI.this.mWr.setVisibility(4);
          BackupMoveRecoverUI.this.mWs.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
          BackupMoveRecoverUI.this.mWt.setText(2131756155);
          BackupMoveRecoverUI.this.mWu.setText(2131756139);
          BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.mWu.setVisibility(0);
          BackupMoveRecoverUI.this.mWr.setVisibility(4);
          BackupMoveRecoverUI.this.mWs.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
          BackupMoveRecoverUI.this.mWt.setText(2131756136);
          BackupMoveRecoverUI.this.mWr.setText(2131756138);
          BackupMoveRecoverUI.this.mWs.setText(2131756137);
          BackupMoveRecoverUI.this.mWu.setVisibility(4);
          BackupMoveRecoverUI.this.mWr.setVisibility(0);
          BackupMoveRecoverUI.this.mWs.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.mWr.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21417);
              b.bDy().bDB().is(false);
              AppMethodBeat.o(21417);
            }
          });
          BackupMoveRecoverUI.this.mWs.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21431);
              b.bDy().bDB().is(true);
              AppMethodBeat.o(21431);
            }
          });
          BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
          Object localObject2 = BackupMoveRecoverUI.this.mWt;
          Object localObject3 = BackupMoveRecoverUI.this;
          paramAnonymousInt = ((e)localObject1).mSl;
          int i = ((e)localObject1).mSm;
          b.bDy().bDB();
          ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(2131756160, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), c.bDH() }));
          BackupMoveRecoverUI.this.mWu.setText(2131756139);
          BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.mWu.setVisibility(0);
          BackupMoveRecoverUI.this.mWr.setVisibility(8);
          BackupMoveRecoverUI.this.mWs.setVisibility(4);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).bCY());
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21435);
              ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
              b.bDy().bDB().bDG();
              AppMethodBeat.o(21435);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
          BackupMoveRecoverUI.this.mWt.setText(2131756143);
          BackupMoveRecoverUI.this.mWu.setText(2131756145);
          BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.mWu.setVisibility(0);
          BackupMoveRecoverUI.this.mWr.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.mWr.setText(2131756144);
          BackupMoveRecoverUI.this.mWr.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21436);
              ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click scan qrcode.");
              paramAnonymous2View = new Intent();
              paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
              paramAnonymous2View.setFlags(268435456);
              d.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
              AppMethodBeat.o(21436);
            }
          });
          BackupMoveRecoverUI.this.mWs.setVisibility(0);
          BackupMoveRecoverUI.this.mWs.setText(2131756159);
          BackupMoveRecoverUI.this.mWs.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21437);
              ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
              ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
              b.bDy().bCP().mSk = 29;
              BackupMoveRecoverUI.1.this.wJ(29);
              AppMethodBeat.o(21437);
            }
          });
          BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
          AppMethodBeat.o(21443);
          return;
          BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
          BackupMoveRecoverUI.this.mWt.setText(2131756170);
          BackupMoveRecoverUI.this.mWu.setText(2131756172);
          BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
          BackupMoveRecoverUI.this.mWu.setVisibility(0);
          BackupMoveRecoverUI.this.mWr.setVisibility(0);
          BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
          BackupMoveRecoverUI.this.mWr.setText(2131756169);
          BackupMoveRecoverUI.this.mWr.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21438);
              ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
              b.bDy().bDB();
              if (!c.bDD())
              {
                ac.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                b.bDy().bCP().mSk = -22;
                BackupMoveRecoverUI.1.this.wJ(-22);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 6L, 1L, false);
                AppMethodBeat.o(21438);
                return;
              }
              b.bDy().bDB().ir(false);
              AppMethodBeat.o(21438);
            }
          });
          BackupMoveRecoverUI.this.mWs.setVisibility(0);
          BackupMoveRecoverUI.this.mWs.setText(2131756107);
          BackupMoveRecoverUI.this.mWs.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21440);
              ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
              com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756109, 2131756108, 2131756158, 2131756090, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(21439);
                  ac.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.19.this.mVj) });
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 48L, 1L, false);
                  b.bDy().bDz().stop();
                  b.bDy().bDB().b(true, true, -100);
                  AppMethodBeat.o(21439);
                }
              }, null, 2131099991);
              AppMethodBeat.o(21440);
            }
          });
          BackupMoveRecoverUI.this.gzg.setText(2131756253);
          BackupMoveRecoverUI.this.gzg.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21441);
              b.bDy().bCP().mSk = 25;
              BackupMoveRecoverUI.e(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21441);
            }
          });
          AppMethodBeat.o(21443);
          return;
          if (BackupMoveRecoverUI.mWx)
          {
            b.bDy().bCP().mSk = 24;
            paramAnonymousInt = 24;
            break;
            ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[] { Boolean.valueOf(BackupMoveRecoverUI.bDU()) });
            if (BackupMoveRecoverUI.bDU())
            {
              BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
              BackupMoveRecoverUI.this.mWt.setText(2131756161);
              BackupMoveRecoverUI.this.mWu.setText(2131756163);
              BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.mWr.setText(2131756157);
              BackupMoveRecoverUI.this.mWs.setText(2131756158);
              BackupMoveRecoverUI.this.gzg.setText(2131756253);
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(0);
              BackupMoveRecoverUI.this.mWs.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.mWr.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21442);
                  ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                  b.bDy().bDB();
                  if (!c.bDD())
                  {
                    ac.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                    b.bDy().bCP().mSk = -22;
                    BackupMoveRecoverUI.1.this.wJ(-22);
                    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 6L, 1L, false);
                    AppMethodBeat.o(21442);
                    return;
                  }
                  b.bDy().bDB().ir(false);
                  AppMethodBeat.o(21442);
                }
              });
              BackupMoveRecoverUI.this.mWs.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21419);
                  ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756109, 2131756108, 2131756158, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21418);
                      ac.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.2.this.mVj) });
                      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 48L, 1L, false);
                      b.bDy().bDz().stop();
                      b.bDy().bDB().b(true, true, -100);
                      AppMethodBeat.o(21418);
                    }
                  }, null, 2131099991);
                  AppMethodBeat.o(21419);
                }
              });
              BackupMoveRecoverUI.this.gzg.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21420);
                  b.bDy().bCP().mSk = 25;
                  BackupMoveRecoverUI.f(BackupMoveRecoverUI.this);
                  AppMethodBeat.o(21420);
                }
              });
              AppMethodBeat.o(21443);
              return;
            }
            if (BackupMoveRecoverUI.mWx)
            {
              b.bDy().bDB();
              if (!c.bDD())
              {
                ac.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                b.bDy().bCP().mSk = -22;
                wJ(-22);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 6L, 1L, false);
                AppMethodBeat.o(21443);
                return;
              }
              b.bDy().bDB().ir(false);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689735);
              BackupMoveRecoverUI.this.mWt.setText(BackupMoveRecoverUI.this.getString(2131756152, new Object[] { Integer.valueOf(((e)localObject1).mSn) }));
              BackupMoveRecoverUI.this.mWu.setText(2131756153);
              BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(4);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689735);
              BackupMoveRecoverUI.this.mWt.setText(2131756252);
              BackupMoveRecoverUI.this.mWu.setText(2131756153);
              BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(4);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689737);
              BackupMoveRecoverUI.this.mWt.setText(2131756150);
              BackupMoveRecoverUI.this.mWu.setText(BackupMoveRecoverUI.this.getString(2131756151, new Object[] { Integer.valueOf(((e)localObject1).mSl), Integer.valueOf(((e)localObject1).mSm) }));
              BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.mWr.setText(2131756096);
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(0);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.mWr.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21421);
                  b.bDy().bDz().stop();
                  b.bDy().bCP().mSk = -100;
                  BackupMoveRecoverUI.g(BackupMoveRecoverUI.this);
                  AppMethodBeat.o(21421);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
              localObject2 = BackupMoveRecoverUI.this.mWt;
              localObject3 = BackupMoveRecoverUI.this;
              paramAnonymousInt = ((e)localObject1).mSl;
              i = ((e)localObject1).mSm;
              b.bDy().bDB();
              ((TextView)localObject2).setText(((BackupMoveRecoverUI)localObject3).getString(2131756160, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), c.bDH() }));
              BackupMoveRecoverUI.this.mWu.setText(2131756175);
              BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099992));
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(8);
              BackupMoveRecoverUI.this.mWs.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setProgress(((e)localObject1).bCY());
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21422);
                  ac.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                  b.bDy().bDB().bDG();
                  AppMethodBeat.o(21422);
                }
              });
              BackupMoveRecoverUI.this.mWs.setText(2131756176);
              BackupMoveRecoverUI.this.mWs.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21423);
                  try
                  {
                    localObject = new Intent();
                    ((Intent)localObject).setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
                    paramAnonymous2View = BackupMoveRecoverUI.this;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymous2View.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(21423);
                    return;
                  }
                  catch (Exception paramAnonymous2View)
                  {
                    ac.e("MicroMsg.BackupMoveRecoverUI", "jump to Settings$TetherSettingsActivity failed");
                    paramAnonymous2View = BackupMoveRecoverUI.this;
                    Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymous2View.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(21423);
                  }
                }
              });
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689731);
              BackupMoveRecoverUI.this.mWt.setText(BackupMoveRecoverUI.this.getString(2131756140, new Object[] { Integer.valueOf(((e)localObject1).mSl), Integer.valueOf(((e)localObject1).mSm), "0M" }));
              BackupMoveRecoverUI.this.mWu.setText(2131756124);
              BackupMoveRecoverUI.this.mWr.setText(2131756156);
              BackupMoveRecoverUI.this.mWs.setText(2131756159);
              BackupMoveRecoverUI.this.mWr.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21424);
                  b.bDy().bDB().wN(7);
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  d.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  AppMethodBeat.o(21424);
                }
              });
              BackupMoveRecoverUI.this.mWs.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21426);
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21425);
                      ac.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.8.this.mVj) });
                      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 44L, 1L, false);
                      b.bDy().bDB().wN(6);
                      b.bDy().bDz().stop();
                      b.bDy().bDB().b(true, true, -100);
                      AppMethodBeat.o(21425);
                    }
                  }, null, 2131099991);
                  AppMethodBeat.o(21426);
                }
              });
              BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(0);
              BackupMoveRecoverUI.this.mWs.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689731);
              BackupMoveRecoverUI.this.mWt.setText(2131756127);
              localObject2 = g.eh(BackupMoveRecoverUI.this);
              localObject3 = b.bDy().bDB().mUX;
              localObject1 = localObject2;
              if (bs.isNullOrNil((String)localObject2)) {
                localObject1 = "移动网络";
              }
              localObject2 = localObject3;
              if (bs.isNullOrNil((String)localObject3)) {
                localObject2 = "移动网络";
              }
              if ((!((String)localObject1).equals("wifi")) && (!((String)localObject2).equals("wifi"))) {
                BackupMoveRecoverUI.this.mWu.setText(BackupMoveRecoverUI.this.getString(2131756128, new Object[] { localObject1, localObject2 }));
              }
              BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(4);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689731);
              BackupMoveRecoverUI.this.mWt.setText(2131756113);
              BackupMoveRecoverUI.this.mWu.setText(2131756114);
              BackupMoveRecoverUI.this.mWr.setText(2131756154);
              BackupMoveRecoverUI.this.mWs.setText(2131756159);
              BackupMoveRecoverUI.this.mWu.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(2131099991));
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(0);
              BackupMoveRecoverUI.this.mWs.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.mWr.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21427);
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("title", BackupMoveRecoverUI.this.getString(2131756142));
                  paramAnonymous2View.putExtra("rawUrl", BackupMoveRecoverUI.this.getString(2131756141, new Object[] { ab.eUO() }));
                  paramAnonymous2View.putExtra("showShare", false);
                  paramAnonymous2View.putExtra("neverGetA8Key", true);
                  d.b(BackupMoveRecoverUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous2View);
                  AppMethodBeat.o(21427);
                }
              });
              BackupMoveRecoverUI.this.mWs.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21429);
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21428);
                      ac.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.10.this.mVj) });
                      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 44L, 1L, false);
                      b.bDy().bDB().wN(5);
                      b.bDy().bDz().stop();
                      b.bDy().bDB().b(true, true, -100);
                      AppMethodBeat.o(21428);
                    }
                  }, null, 2131099991);
                  AppMethodBeat.o(21429);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689731);
              BackupMoveRecoverUI.this.mWt.setText(2131756115);
              BackupMoveRecoverUI.this.mWr.setText(2131756156);
              BackupMoveRecoverUI.this.mWs.setText(2131756159);
              BackupMoveRecoverUI.this.mWu.setVisibility(4);
              BackupMoveRecoverUI.this.mWr.setVisibility(0);
              BackupMoveRecoverUI.this.mWs.setVisibility(0);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.this.mWr.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21430);
                  com.tencent.mm.plugin.report.service.h.wUl.f(11788, new Object[] { Integer.valueOf(9) });
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("BaseScanUI_select_scan_mode", 1);
                  paramAnonymous2View.setFlags(268435456);
                  d.b(BackupMoveRecoverUI.this.getContext(), "scanner", ".ui.BaseScanUI", paramAnonymous2View);
                  AppMethodBeat.o(21430);
                }
              });
              BackupMoveRecoverUI.this.mWs.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21433);
                  com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21432);
                      ac.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[] { Integer.valueOf(BackupMoveRecoverUI.1.13.this.mVj) });
                      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 44L, 1L, false);
                      b.bDy().bDB().wN(5);
                      b.bDy().bDz().stop();
                      b.bDy().bDB().b(true, true, -100);
                      AppMethodBeat.o(21432);
                    }
                  }, null, 2131099991);
                  AppMethodBeat.o(21433);
                }
              });
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689731);
              BackupMoveRecoverUI.this.mWt.setText(2131756132);
              BackupMoveRecoverUI.this.mWu.setVisibility(4);
              BackupMoveRecoverUI.this.mWr.setVisibility(4);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131231103);
              BackupMoveRecoverUI.this.mWt.setText(2131756106);
              BackupMoveRecoverUI.this.mWu.setText(2131756139);
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(4);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              com.tencent.mm.ui.base.h.a(BackupMoveRecoverUI.this, 2131756123, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(21434);
                  ac.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
                  BackupMoveRecoverUI.h(BackupMoveRecoverUI.this);
                  AppMethodBeat.o(21434);
                }
              }, null, 2131099990);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689731);
              BackupMoveRecoverUI.this.mWt.setText(2131756125);
              BackupMoveRecoverUI.this.mWu.setText(BackupMoveRecoverUI.this.getString(2131756126, new Object[] { bs.qz(b.bDy().bDB().mVe) }));
              BackupMoveRecoverUI.this.mWu.setVisibility(0);
              BackupMoveRecoverUI.this.mWr.setVisibility(4);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689731);
              BackupMoveRecoverUI.this.mWt.setText(2131756116);
              BackupMoveRecoverUI.this.mWu.setVisibility(4);
              BackupMoveRecoverUI.this.mWr.setVisibility(4);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
              AppMethodBeat.o(21443);
              return;
              BackupMoveRecoverUI.this.mWv.setImageResource(2131689731);
              BackupMoveRecoverUI.this.mWt.setText(2131756121);
              b.bDy().bDz().stop();
              BackupMoveRecoverUI.this.mWu.setVisibility(4);
              BackupMoveRecoverUI.this.mWr.setVisibility(4);
              BackupMoveRecoverUI.this.mWs.setVisibility(4);
              BackupMoveRecoverUI.b(BackupMoveRecoverUI.this).setVisibility(8);
              BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
            }
          }
        }
      }
    };
    AppMethodBeat.o(21448);
  }
  
  private void bDT()
  {
    AppMethodBeat.i(21455);
    final int i = b.bDy().bCP().mSk;
    ac.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
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
        ZA(1);
        AppMethodBeat.o(21455);
        return;
        b.bDy().bDB().b(false, false, -100);
        AppMethodBeat.o(21455);
        return;
        ac.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[] { Integer.valueOf(i) });
        b.bDy().bDB().b(true, false, -100);
        b.bDy().bDz().stop();
        AppMethodBeat.o(21455);
        return;
        b.bDy().bCP().mSk = 25;
      }
    case 52: 
      com.tencent.mm.ui.base.h.a(this, 2131756111, 2131756110, 2131756159, 2131756090, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(21445);
          ac.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 44L, 1L, false);
          b.bDy().bDB().wN(5);
          b.bDy().bDz().stop();
          b.bDy().bDB().b(true, true, -100);
          AppMethodBeat.o(21445);
        }
      }, null, 2131099991);
      AppMethodBeat.o(21455);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21446);
        ac.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 48L, 1L, false);
        b.bDy().bDz().stop();
        b.bDy().bDB().b(true, true, -100);
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
    this.gzg = ((TextView)findViewById(2131297053));
    this.mWv = ((ImageView)findViewById(2131297054));
    this.mWt = ((TextView)findViewById(2131297063));
    this.mWu = ((TextView)findViewById(2131297062));
    this.mWr = ((TextView)findViewById(2131297034));
    this.mWs = ((TextView)findViewById(2131297033));
    this.mWw = ((RoundProgressBtn)findViewById(2131297061));
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
    ac.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.iyx.Lm();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      b.bDy().bDB().mUR = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ac.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[] { Boolean.valueOf(b.bDy().bDB().mUR) });
      AppMethodBeat.o(21449);
      return;
    }
    catch (Exception paramBundle)
    {
      ac.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bs.eWi() });
      AppMethodBeat.o(21449);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21453);
    ac.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
    super.onDestroy();
    AppMethodBeat.o(21453);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21454);
    if (paramInt == 4)
    {
      bDT();
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
    ac.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
    mWx = false;
    AppMethodBeat.o(21452);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21451);
    super.onResume();
    ac.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
    mWx = true;
    b.bDy().bDB().mTO = this.mTO;
    iFP = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    this.mTO.wJ(b.bDy().bCP().mSk);
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