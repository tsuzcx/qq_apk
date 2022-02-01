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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
{
  public TextView gSR;
  private b.d num;
  public TextView nwO;
  public TextView nwP;
  public TextView nwQ;
  public TextView nwR;
  public ImageView nwS;
  
  public BackupMoveUI()
  {
    AppMethodBeat.i(21470);
    this.num = new b.d()
    {
      public final void bGW() {}
      
      public final void xp(int paramAnonymousInt)
      {
        AppMethodBeat.i(21466);
        Object localObject = com.tencent.mm.plugin.backup.d.b.bHG().bGX();
        ad.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL) });
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
          BackupMoveUI.this.nwS.setImageResource(2131231103);
          BackupMoveUI.this.nwQ.setText(2131756106);
          BackupMoveUI.this.nwR.setText(2131756139);
          BackupMoveUI.this.nwR.setVisibility(0);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131231103);
          BackupMoveUI.this.nwQ.setText(BackupMoveUI.this.getString(2131756099, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL) }));
          BackupMoveUI.this.nwR.setText(2131756139);
          BackupMoveUI.this.nwR.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nwR.setVisibility(0);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131231103);
          BackupMoveUI.this.nwQ.setText(2131756146);
          BackupMoveUI.this.nwR.setText(2131756139);
          BackupMoveUI.this.nwR.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nwR.setVisibility(0);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131231103);
          TextView localTextView = BackupMoveUI.this.nwQ;
          BackupMoveUI localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nsK;
          int i = ((com.tencent.mm.plugin.backup.b.e)localObject).nsL;
          com.tencent.mm.plugin.backup.d.b.bHG().bHI();
          localTextView.setText(localBackupMoveUI.getString(2131756174, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.bHX() }));
          BackupMoveUI.this.nwR.setText(2131756139);
          BackupMoveUI.this.nwR.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nwR.setVisibility(0);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131231104);
          BackupMoveUI.this.nwQ.setText(2131756134);
          BackupMoveUI.this.nwR.setText(BackupMoveUI.this.getString(2131756135, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL) }));
          BackupMoveUI.this.nwR.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nwO.setText(2131756096);
          BackupMoveUI.this.nwR.setVisibility(0);
          BackupMoveUI.this.nwO.setVisibility(0);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.this.nwO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21465);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
              com.tencent.mm.plugin.backup.d.b.bHG().bHI().cancel(true);
              com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = -100;
              BackupMoveUI.c(BackupMoveUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21465);
            }
          });
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.bHG().bHI().bitmapData;
          BackupMoveUI.this.nwS.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveUI.this.nwQ.setText(2131756149);
          BackupMoveUI.this.nwQ.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100711));
          BackupMoveUI.this.nwR.setVisibility(4);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131231103);
          localTextView = BackupMoveUI.this.nwQ;
          localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).nsK;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).nsL;
          com.tencent.mm.plugin.backup.d.b.bHG().bHI();
          localTextView.setText(localBackupMoveUI.getString(2131756174, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.bHX() }));
          BackupMoveUI.this.nwR.setText(2131756175);
          BackupMoveUI.this.nwR.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.nwR.setVisibility(0);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131689733);
          com.tencent.mm.plugin.backup.d.b.bHG().bHI().nvU.start();
          BackupMoveUI.this.nwQ.setText(BackupMoveUI.this.getString(2131756140, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL), "0M" }));
          BackupMoveUI.this.nwR.setText(2131756124);
          BackupMoveUI.this.nwR.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveUI.this.nwR.setVisibility(0);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.d(BackupMoveUI.this);
          com.tencent.mm.plugin.backup.d.b.bHG().bHI().nvO = c.nsv;
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131689733);
          BackupMoveUI.this.nwQ.setText(BackupMoveUI.this.getString(2131756140, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsK), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).nsL), "0M" }));
          BackupMoveUI.this.nwR.setText(2131756122);
          BackupMoveUI.this.nwR.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveUI.this.nwR.setVisibility(0);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131689731);
          BackupMoveUI.this.nwQ.setText(2131756132);
          BackupMoveUI.this.nwR.setVisibility(4);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.nwS.setImageResource(2131689731);
          BackupMoveUI.this.nwQ.setText(2131756117);
          BackupMoveUI.this.nwR.setVisibility(4);
          BackupMoveUI.this.nwO.setVisibility(4);
          BackupMoveUI.this.nwP.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
        }
      }
    };
    AppMethodBeat.o(21470);
  }
  
  private void bIc()
  {
    AppMethodBeat.i(21477);
    int i = com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ;
    ad.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      abK(1);
      AppMethodBeat.o(21477);
      return;
    case 15: 
      ad.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      bIe();
      AppMethodBeat.o(21477);
      return;
    }
    h.a(this, 2131756148, 2131756147, 2131756171, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21468);
        ad.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        g.yhR.idkeyStat(485L, 25L, 1L, false);
        com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
        com.tencent.mm.plugin.backup.d.b.bHG().bHI().cancel(false);
        com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = -100;
        BackupMoveUI.f(BackupMoveUI.this);
        AppMethodBeat.o(21468);
      }
    }, null, 2131099991);
    AppMethodBeat.o(21477);
  }
  
  private void bIe()
  {
    AppMethodBeat.i(21478);
    com.tencent.mm.plugin.backup.d.b.bHG().bHK().cancel();
    com.tencent.mm.plugin.backup.d.b.bHG().bHI().cancel(true);
    com.tencent.mm.plugin.backup.d.b.bHG().bHH().stop();
    com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ = -100;
    abK(1);
    AppMethodBeat.o(21478);
  }
  
  public int getLayoutId()
  {
    return 2131493131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21472);
    this.gSR = ((TextView)findViewById(2131297053));
    this.nwS = ((ImageView)findViewById(2131297054));
    this.nwQ = ((TextView)findViewById(2131297063));
    this.nwR = ((TextView)findViewById(2131297062));
    this.nwO = ((TextView)findViewById(2131297034));
    this.nwP = ((TextView)findViewById(2131297033));
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
    ad.i("MicroMsg.BackupMoveUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.iRG.MU();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.bHG().bHI().nvo = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ad.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.bHG().bHI().nvo) });
      AppMethodBeat.o(21471);
      return;
    }
    catch (Exception paramBundle)
    {
      ad.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bt.flS() });
      AppMethodBeat.o(21471);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21475);
    ad.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
    if (com.tencent.mm.plugin.backup.d.b.bHG().bHI().nvU != null) {
      com.tencent.mm.plugin.backup.d.b.bHG().bHI().nvU.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(21475);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21476);
    if (paramInt == 4)
    {
      bIc();
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
    com.tencent.mm.plugin.backup.d.b.bHG().bHI().a(this.num);
    AppMethodBeat.o(21474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21473);
    super.onResume();
    com.tencent.mm.plugin.backup.d.b.bHG().bHI().num = this.num;
    this.num.xp(com.tencent.mm.plugin.backup.d.b.bHG().bGX().nsJ);
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