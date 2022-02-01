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
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
{
  public TextView hOu;
  private b.d oKF;
  public TextView oNi;
  public TextView oNj;
  public TextView oNk;
  public TextView oNl;
  public ImageView oNm;
  
  public BackupMoveUI()
  {
    AppMethodBeat.i(21470);
    this.oKF = new b.d()
    {
      public final void Ba(int paramAnonymousInt)
      {
        AppMethodBeat.i(21466);
        Object localObject = com.tencent.mm.plugin.backup.d.b.cfv().ceM();
        Log.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe) });
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
          BackupMoveUI.this.oNm.setImageResource(2131231138);
          BackupMoveUI.this.oNk.setText(2131756240);
          BackupMoveUI.this.oNl.setText(2131756273);
          BackupMoveUI.this.oNl.setVisibility(0);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131231138);
          BackupMoveUI.this.oNk.setText(BackupMoveUI.this.getString(2131756233, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe) }));
          BackupMoveUI.this.oNl.setText(2131756273);
          BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(2131100016));
          BackupMoveUI.this.oNl.setVisibility(0);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131231138);
          BackupMoveUI.this.oNk.setText(2131756280);
          BackupMoveUI.this.oNl.setText(2131756273);
          BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(2131100016));
          BackupMoveUI.this.oNl.setVisibility(0);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131231138);
          TextView localTextView = BackupMoveUI.this.oNk;
          BackupMoveUI localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).oJd;
          int i = ((com.tencent.mm.plugin.backup.b.e)localObject).oJe;
          com.tencent.mm.plugin.backup.d.b.cfv().cfx();
          localTextView.setText(localBackupMoveUI.getString(2131756308, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.cfN() }));
          BackupMoveUI.this.oNl.setText(2131756273);
          BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(2131100016));
          BackupMoveUI.this.oNl.setVisibility(0);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131231139);
          BackupMoveUI.this.oNk.setText(2131756268);
          BackupMoveUI.this.oNl.setText(BackupMoveUI.this.getString(2131756269, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe) }));
          BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(2131100016));
          BackupMoveUI.this.oNi.setText(2131756230);
          BackupMoveUI.this.oNl.setVisibility(0);
          BackupMoveUI.this.oNi.setVisibility(0);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.this.oNi.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21465);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
              com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(true);
              com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
              BackupMoveUI.c(BackupMoveUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21465);
            }
          });
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          localObject = com.tencent.mm.plugin.backup.d.b.cfv().cfx().bitmapData;
          BackupMoveUI.this.oNm.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveUI.this.oNk.setText(2131756283);
          BackupMoveUI.this.oNk.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100904));
          BackupMoveUI.this.oNl.setVisibility(4);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131231138);
          localTextView = BackupMoveUI.this.oNk;
          localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).oJd;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).oJe;
          com.tencent.mm.plugin.backup.d.b.cfv().cfx();
          localTextView.setText(localBackupMoveUI.getString(2131756308, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.cfN() }));
          BackupMoveUI.this.oNl.setText(2131756309);
          BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getResources().getColor(2131100016));
          BackupMoveUI.this.oNl.setVisibility(0);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131689742);
          com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo.start();
          BackupMoveUI.this.oNk.setText(BackupMoveUI.this.getString(2131756274, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe), "0M" }));
          BackupMoveUI.this.oNl.setText(2131756258);
          BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100994));
          BackupMoveUI.this.oNl.setVisibility(0);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.d(BackupMoveUI.this);
          com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMi = c.oIO;
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131689742);
          BackupMoveUI.this.oNk.setText(BackupMoveUI.this.getString(2131756274, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJd), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).oJe), "0M" }));
          BackupMoveUI.this.oNl.setText(2131756256);
          BackupMoveUI.this.oNl.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100994));
          BackupMoveUI.this.oNl.setVisibility(0);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131689740);
          BackupMoveUI.this.oNk.setText(2131756266);
          BackupMoveUI.this.oNl.setVisibility(4);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.oNm.setImageResource(2131689740);
          BackupMoveUI.this.oNk.setText(2131756251);
          BackupMoveUI.this.oNl.setVisibility(4);
          BackupMoveUI.this.oNi.setVisibility(4);
          BackupMoveUI.this.oNj.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
        }
      }
      
      public final void ceL() {}
    };
    AppMethodBeat.o(21470);
  }
  
  private void cfT()
  {
    AppMethodBeat.i(21477);
    int i = com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc;
    Log.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      ala(1);
      AppMethodBeat.o(21477);
      return;
    case 15: 
      Log.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      cfV();
      AppMethodBeat.o(21477);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131756282, 2131756281, 2131756305, 2131756224, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21468);
        Log.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(485L, 25L, 1L, false);
        com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
        com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(false);
        com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
        BackupMoveUI.f(BackupMoveUI.this);
        AppMethodBeat.o(21468);
      }
    }, null, 2131100015);
    AppMethodBeat.o(21477);
  }
  
  private void cfV()
  {
    AppMethodBeat.i(21478);
    com.tencent.mm.plugin.backup.d.b.cfv().cfz().cancel();
    com.tencent.mm.plugin.backup.d.b.cfv().cfx().cancel(true);
    com.tencent.mm.plugin.backup.d.b.cfv().cfw().stop();
    com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc = -100;
    ala(1);
    AppMethodBeat.o(21478);
  }
  
  public int getLayoutId()
  {
    return 2131493174;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21472);
    this.hOu = ((TextView)findViewById(2131297199));
    this.oNm = ((ImageView)findViewById(2131297200));
    this.oNk = ((TextView)findViewById(2131297209));
    this.oNl = ((TextView)findViewById(2131297208));
    this.oNi = ((TextView)findViewById(2131297180));
    this.oNj = ((TextView)findViewById(2131297179));
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
    com.tencent.mm.plugin.backup.a.jRt.Xc();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      com.tencent.mm.plugin.backup.d.b.cfv().cfx().oLH = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      Log.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.backup.d.b.cfv().cfx().oLH) });
      AppMethodBeat.o(21471);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { Util.getStack() });
      AppMethodBeat.o(21471);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21475);
    Log.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
    if (com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo != null) {
      com.tencent.mm.plugin.backup.d.b.cfv().cfx().oMo.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(21475);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21476);
    if (paramInt == 4)
    {
      cfT();
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
    com.tencent.mm.plugin.backup.d.b.cfv().cfx().a(this.oKF);
    AppMethodBeat.o(21474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21473);
    super.onResume();
    com.tencent.mm.plugin.backup.d.b.cfv().cfx().oKF = this.oKF;
    this.oKF.Ba(com.tencent.mm.plugin.backup.d.b.cfv().ceM().oJc);
    AppMethodBeat.o(21473);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI
 * JD-Core Version:    0.7.0.1
 */