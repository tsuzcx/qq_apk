package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
{
  public TextView ngm;
  private b.d uXI;
  public TextView vat;
  public TextView vau;
  public TextView vav;
  public TextView vaw;
  public ImageView vax;
  
  public BackupMoveUI()
  {
    AppMethodBeat.i(21470);
    this.uXI = new b.d()
    {
      public final void Fc(int paramAnonymousInt)
      {
        AppMethodBeat.i(21466);
        Object localObject = com.tencent.mm.plugin.backup.d.b.cVs().cUJ();
        Log.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi) });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.a(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.finish();
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.g.backup_move);
          BackupMoveUI.this.vav.setText(R.l.gsy);
          BackupMoveUI.this.vaw.setText(R.l.gtd);
          BackupMoveUI.this.vaw.setVisibility(0);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.g.backup_move);
          BackupMoveUI.this.vav.setText(BackupMoveUI.this.getString(R.l.gss, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi) }));
          BackupMoveUI.this.vaw.setText(R.l.gtd);
          BackupMoveUI.this.vaw.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.fkh));
          BackupMoveUI.this.vaw.setVisibility(0);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.g.backup_move);
          BackupMoveUI.this.vav.setText(R.l.gtj);
          BackupMoveUI.this.vaw.setText(R.l.gtd);
          BackupMoveUI.this.vaw.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.fkh));
          BackupMoveUI.this.vaw.setVisibility(0);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.g.backup_move);
          TextView localTextView = BackupMoveUI.this.vav;
          BackupMoveUI localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = R.l.gtI;
          int i = ((com.tencent.mm.plugin.backup.b.e)localObject).uWh;
          int j = ((com.tencent.mm.plugin.backup.b.e)localObject).uWi;
          com.tencent.mm.plugin.backup.d.b.cVs().cVu();
          localTextView.setText(localBackupMoveUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), d.cVK() }));
          BackupMoveUI.this.vaw.setText(R.l.gtd);
          BackupMoveUI.this.vaw.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.fkh));
          BackupMoveUI.this.vaw.setVisibility(0);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.g.backup_move_finish);
          BackupMoveUI.this.vav.setText(R.l.backup_move_finish);
          BackupMoveUI.this.vaw.setText(BackupMoveUI.this.getString(R.l.gsZ, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi) }));
          BackupMoveUI.this.vaw.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.fkh));
          BackupMoveUI.this.vat.setText(R.l.gsq);
          BackupMoveUI.this.vaw.setVisibility(0);
          BackupMoveUI.this.vat.setVisibility(0);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.this.vat.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21465);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
              com.tencent.mm.plugin.backup.d.b.cVs().cVu().cancel(true);
              com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -100;
              BackupMoveUI.c(BackupMoveUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21465);
            }
          });
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.cVs().cVu().bitmapData;
          BackupMoveUI.this.vax.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveUI.this.vav.setText(R.l.gtm);
          BackupMoveUI.this.vav.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.e.normal_text_color));
          BackupMoveUI.this.vaw.setVisibility(4);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.g.backup_move);
          localTextView = BackupMoveUI.this.vav;
          localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = R.l.gtI;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).uWh;
          j = ((com.tencent.mm.plugin.backup.b.e)localObject).uWi;
          com.tencent.mm.plugin.backup.d.b.cVs().cVu();
          localTextView.setText(localBackupMoveUI.getString(paramAnonymousInt, new Object[] { Integer.valueOf(i), Integer.valueOf(j), d.cVK() }));
          BackupMoveUI.this.vaw.setText(R.l.gtJ);
          BackupMoveUI.this.vaw.setTextColor(BackupMoveUI.this.getResources().getColor(R.e.fkh));
          BackupMoveUI.this.vaw.setVisibility(0);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.k.backup_move_qrcode_dark);
          com.tencent.mm.plugin.backup.d.b.cVs().cVu().uZx.start();
          BackupMoveUI.this.vav.setText(BackupMoveUI.this.getString(R.l.gte, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi), "0M" }));
          BackupMoveUI.this.vaw.setText(R.l.gsP);
          BackupMoveUI.this.vaw.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.e.red));
          BackupMoveUI.this.vaw.setVisibility(0);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.d(BackupMoveUI.this);
          com.tencent.mm.plugin.backup.d.b.cVs().cVu().uZr = c.uVS;
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.k.backup_move_qrcode_dark);
          BackupMoveUI.this.vav.setText(BackupMoveUI.this.getString(R.l.gte, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWh), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).uWi), "0M" }));
          BackupMoveUI.this.vaw.setText(R.l.gsN);
          BackupMoveUI.this.vaw.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(R.e.red));
          BackupMoveUI.this.vaw.setVisibility(0);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.k.backup_move_error);
          BackupMoveUI.this.vav.setText(R.l.gsX);
          BackupMoveUI.this.vaw.setVisibility(4);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.vax.setImageResource(R.k.backup_move_error);
          BackupMoveUI.this.vav.setText(R.l.gsJ);
          BackupMoveUI.this.vaw.setVisibility(4);
          BackupMoveUI.this.vat.setVisibility(4);
          BackupMoveUI.this.vau.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
        }
      }
      
      public final void cUI() {}
    };
    AppMethodBeat.o(21470);
  }
  
  private void cVP()
  {
    AppMethodBeat.i(21477);
    int i = com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg;
    Log.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      aAp(1);
      AppMethodBeat.o(21477);
      return;
    case 15: 
      Log.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      cVR();
      AppMethodBeat.o(21477);
      return;
    }
    k.a(this, R.l.gtl, R.l.gtk, R.l.gtG, R.l.gsm, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21468);
        Log.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        h.OAn.idkeyStat(485L, 25L, 1L, false);
        com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
        com.tencent.mm.plugin.backup.d.b.cVs().cVu().cancel(false);
        com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -100;
        BackupMoveUI.f(BackupMoveUI.this);
        AppMethodBeat.o(21468);
      }
    }, null, R.e.fkg);
    AppMethodBeat.o(21477);
  }
  
  private void cVR()
  {
    AppMethodBeat.i(21478);
    com.tencent.mm.plugin.backup.d.b.cVs().cVw().cancel();
    com.tencent.mm.plugin.backup.d.b.cVs().cVu().cancel(true);
    com.tencent.mm.plugin.backup.d.b.cVs().cVt().stop();
    com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg = -100;
    aAp(1);
    AppMethodBeat.o(21478);
  }
  
  public int getLayoutId()
  {
    return R.i.gey;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21472);
    this.ngm = ((TextView)findViewById(R.h.fsV));
    this.vax = ((ImageView)findViewById(R.h.fsW));
    this.vav = ((TextView)findViewById(R.h.ftd));
    this.vaw = ((TextView)findViewById(R.h.fkh));
    this.vat = ((TextView)findViewById(R.h.fsC));
    this.vau = ((TextView)findViewById(R.h.fsB));
    AppMethodBeat.o(21472);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21471);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21471);
      return;
    }
    Log.i("MicroMsg.BackupMoveUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.pFn.aDA();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.cVs().cVu().uYK = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      Log.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.cVs().cVu().uYK) });
      AppMethodBeat.o(21471);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { Util.getStack() });
      AppMethodBeat.o(21471);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21476);
    if (paramInt == 4)
    {
      cVP();
      AppMethodBeat.o(21476);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21476);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(21474);
    super.onPause();
    com.tencent.mm.plugin.backup.d.b.cVs().cVu().b(this.uXI);
    if (com.tencent.mm.plugin.backup.d.b.cVs().cVu().uZx != null) {
      com.tencent.mm.plugin.backup.d.b.cVs().cVu().uZx.stop();
    }
    AppMethodBeat.o(21474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21473);
    super.onResume();
    com.tencent.mm.plugin.backup.d.b.cVs().cVu().a(this.uXI);
    this.uXI.Fc(com.tencent.mm.plugin.backup.d.b.cVs().cUJ().uWg);
    AppMethodBeat.o(21473);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI
 * JD-Core Version:    0.7.0.1
 */