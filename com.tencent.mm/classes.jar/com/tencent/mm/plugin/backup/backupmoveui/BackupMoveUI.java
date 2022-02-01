package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
{
  public TextView gVA;
  public TextView nCj;
  public TextView nCk;
  public TextView nCl;
  public TextView nCm;
  public ImageView nCn;
  private b.d nzH;
  
  public BackupMoveUI()
  {
    AppMethodBeat.i(21470);
    this.nzH = new b.d()
    {
      public final void bHU() {}
      
      public final void xu(int paramAnonymousInt)
      {
        AppMethodBeat.i(21466);
        Object localObject = com.tencent.mm.plugin.backup.d.b.bIE().bHV();
        ae.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyf), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyg) });
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
          BackupMoveUI.this.nCn.setImageResource(2131231103);
          BackupMoveUI.this.nCl.setText(2131756106);
          BackupMoveUI.this.nCm.setText(2131756139);
          BackupMoveUI.this.nCm.setVisibility(0);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131231103);
          BackupMoveUI.this.nCl.setText(BackupMoveUI.this.getString(2131756099, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyf), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyg) }));
          BackupMoveUI.this.nCm.setText(2131756139);
          BackupMoveUI.this.nCm.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nCm.setVisibility(0);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131231103);
          BackupMoveUI.this.nCl.setText(2131756146);
          BackupMoveUI.this.nCm.setText(2131756139);
          BackupMoveUI.this.nCm.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nCm.setVisibility(0);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131231103);
          TextView localTextView = BackupMoveUI.this.nCl;
          BackupMoveUI localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nyf;
          int i = ((com.tencent.mm.plugin.backup.b.e)localObject).nyg;
          com.tencent.mm.plugin.backup.d.b.bIE().bIG();
          localTextView.setText(localBackupMoveUI.getString(2131756174, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.bIV() }));
          BackupMoveUI.this.nCm.setText(2131756139);
          BackupMoveUI.this.nCm.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nCm.setVisibility(0);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131231104);
          BackupMoveUI.this.nCl.setText(2131756134);
          BackupMoveUI.this.nCm.setText(BackupMoveUI.this.getString(2131756135, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyf), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyg) }));
          BackupMoveUI.this.nCm.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nCj.setText(2131756096);
          BackupMoveUI.this.nCm.setVisibility(0);
          BackupMoveUI.this.nCj.setVisibility(0);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.this.nCj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21465);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
              com.tencent.mm.plugin.backup.d.b.bIE().bIG().cancel(true);
              com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = -100;
              BackupMoveUI.c(BackupMoveUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21465);
            }
          });
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.bIE().bIG().bitmapData;
          BackupMoveUI.this.nCn.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveUI.this.nCl.setText(2131756149);
          BackupMoveUI.this.nCl.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100711));
          BackupMoveUI.this.nCm.setVisibility(4);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131231103);
          localTextView = BackupMoveUI.this.nCl;
          localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nyf;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).nyg;
          com.tencent.mm.plugin.backup.d.b.bIE().bIG();
          localTextView.setText(localBackupMoveUI.getString(2131756174, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.bIV() }));
          BackupMoveUI.this.nCm.setText(2131756175);
          BackupMoveUI.this.nCm.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nCm.setVisibility(0);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131689733);
          com.tencent.mm.plugin.backup.d.b.bIE().bIG().nBp.start();
          BackupMoveUI.this.nCl.setText(BackupMoveUI.this.getString(2131756140, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyf), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyg), "0M" }));
          BackupMoveUI.this.nCm.setText(2131756124);
          BackupMoveUI.this.nCm.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveUI.this.nCm.setVisibility(0);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.d(BackupMoveUI.this);
          com.tencent.mm.plugin.backup.d.b.bIE().bIG().nBj = c.nxQ;
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131689733);
          BackupMoveUI.this.nCl.setText(BackupMoveUI.this.getString(2131756140, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyf), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nyg), "0M" }));
          BackupMoveUI.this.nCm.setText(2131756122);
          BackupMoveUI.this.nCm.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveUI.this.nCm.setVisibility(0);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131689731);
          BackupMoveUI.this.nCl.setText(2131756132);
          BackupMoveUI.this.nCm.setVisibility(4);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nCn.setImageResource(2131689731);
          BackupMoveUI.this.nCl.setText(2131756117);
          BackupMoveUI.this.nCm.setVisibility(4);
          BackupMoveUI.this.nCj.setVisibility(4);
          BackupMoveUI.this.nCk.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
        }
      }
    };
    AppMethodBeat.o(21470);
  }
  
  private void bJa()
  {
    AppMethodBeat.i(21477);
    int i = com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye;
    ae.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      acs(1);
      AppMethodBeat.o(21477);
      return;
    case 15: 
      ae.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      bJc();
      AppMethodBeat.o(21477);
      return;
    }
    h.a(this, 2131756148, 2131756147, 2131756171, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21468);
        ae.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        g.yxI.idkeyStat(485L, 25L, 1L, false);
        com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
        com.tencent.mm.plugin.backup.d.b.bIE().bIG().cancel(false);
        com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = -100;
        BackupMoveUI.f(BackupMoveUI.this);
        AppMethodBeat.o(21468);
      }
    }, null, 2131099991);
    AppMethodBeat.o(21477);
  }
  
  private void bJc()
  {
    AppMethodBeat.i(21478);
    com.tencent.mm.plugin.backup.d.b.bIE().bII().cancel();
    com.tencent.mm.plugin.backup.d.b.bIE().bIG().cancel(true);
    com.tencent.mm.plugin.backup.d.b.bIE().bIF().stop();
    com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye = -100;
    acs(1);
    AppMethodBeat.o(21478);
  }
  
  public int getLayoutId()
  {
    return 2131493131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21472);
    this.gVA = ((TextView)findViewById(2131297053));
    this.nCn = ((ImageView)findViewById(2131297054));
    this.nCl = ((TextView)findViewById(2131297063));
    this.nCm = ((TextView)findViewById(2131297062));
    this.nCj = ((TextView)findViewById(2131297034));
    this.nCk = ((TextView)findViewById(2131297033));
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
    ae.i("MicroMsg.BackupMoveUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.iUz.MP();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.bIE().bIG().nAJ = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ae.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.bIE().bIG().nAJ) });
      AppMethodBeat.o(21471);
      return;
    }
    catch (Exception paramBundle)
    {
      ae.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bu.fpN() });
      AppMethodBeat.o(21471);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21475);
    ae.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
    if (com.tencent.mm.plugin.backup.d.b.bIE().bIG().nBp != null) {
      com.tencent.mm.plugin.backup.d.b.bIE().bIG().nBp.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(21475);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21476);
    if (paramInt == 4)
    {
      bJa();
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
    com.tencent.mm.plugin.backup.d.b.bIE().bIG().a(this.nzH);
    AppMethodBeat.o(21474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21473);
    super.onResume();
    com.tencent.mm.plugin.backup.d.b.bIE().bIG().nzH = this.nzH;
    this.nzH.xu(com.tencent.mm.plugin.backup.d.b.bIE().bHV().nye);
    AppMethodBeat.o(21473);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI
 * JD-Core Version:    0.7.0.1
 */