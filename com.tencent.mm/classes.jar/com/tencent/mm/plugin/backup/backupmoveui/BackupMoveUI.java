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
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
{
  public TextView gzg;
  private b.d mTO;
  public TextView mWr;
  public TextView mWs;
  public TextView mWt;
  public TextView mWu;
  public ImageView mWv;
  
  public BackupMoveUI()
  {
    AppMethodBeat.i(21470);
    this.mTO = new b.d()
    {
      public final void bCO() {}
      
      public final void wJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(21466);
        Object localObject = b.bDy().bCP();
        ac.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm) });
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
          BackupMoveUI.this.mWv.setImageResource(2131231103);
          BackupMoveUI.this.mWt.setText(2131756106);
          BackupMoveUI.this.mWu.setText(2131756139);
          BackupMoveUI.this.mWu.setVisibility(0);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131231103);
          BackupMoveUI.this.mWt.setText(BackupMoveUI.this.getString(2131756099, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm) }));
          BackupMoveUI.this.mWu.setText(2131756139);
          BackupMoveUI.this.mWu.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mWu.setVisibility(0);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131231103);
          BackupMoveUI.this.mWt.setText(2131756146);
          BackupMoveUI.this.mWu.setText(2131756139);
          BackupMoveUI.this.mWu.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mWu.setVisibility(0);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131231103);
          TextView localTextView = BackupMoveUI.this.mWt;
          BackupMoveUI localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mSl;
          int i = ((com.tencent.mm.plugin.backup.b.e)localObject).mSm;
          b.bDy().bDA();
          localTextView.setText(localBackupMoveUI.getString(2131756174, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.bDO() }));
          BackupMoveUI.this.mWu.setText(2131756139);
          BackupMoveUI.this.mWu.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mWu.setVisibility(0);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131231104);
          BackupMoveUI.this.mWt.setText(2131756134);
          BackupMoveUI.this.mWu.setText(BackupMoveUI.this.getString(2131756135, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm) }));
          BackupMoveUI.this.mWu.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mWr.setText(2131756096);
          BackupMoveUI.this.mWu.setVisibility(0);
          BackupMoveUI.this.mWr.setVisibility(0);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.this.mWr.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21465);
              b.bDy().bDz().stop();
              b.bDy().bDA().cancel(true);
              b.bDy().bCP().mSk = -100;
              BackupMoveUI.c(BackupMoveUI.this);
              AppMethodBeat.o(21465);
            }
          });
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          localObject = b.bDy().bDA().bitmapData;
          BackupMoveUI.this.mWv.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveUI.this.mWt.setText(2131756149);
          BackupMoveUI.this.mWt.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100711));
          BackupMoveUI.this.mWu.setVisibility(4);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131231103);
          localTextView = BackupMoveUI.this.mWt;
          localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mSl;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).mSm;
          b.bDy().bDA();
          localTextView.setText(localBackupMoveUI.getString(2131756174, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.bDO() }));
          BackupMoveUI.this.mWu.setText(2131756175);
          BackupMoveUI.this.mWu.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mWu.setVisibility(0);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131689733);
          b.bDy().bDA().mVx.start();
          BackupMoveUI.this.mWt.setText(BackupMoveUI.this.getString(2131756140, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm), "0M" }));
          BackupMoveUI.this.mWu.setText(2131756124);
          BackupMoveUI.this.mWu.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveUI.this.mWu.setVisibility(0);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.d(BackupMoveUI.this);
          b.bDy().bDA().mVr = c.mRW;
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131689733);
          BackupMoveUI.this.mWt.setText(BackupMoveUI.this.getString(2131756140, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm), "0M" }));
          BackupMoveUI.this.mWu.setText(2131756122);
          BackupMoveUI.this.mWu.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveUI.this.mWu.setVisibility(0);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131689731);
          BackupMoveUI.this.mWt.setText(2131756132);
          BackupMoveUI.this.mWu.setVisibility(4);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.mWv.setImageResource(2131689731);
          BackupMoveUI.this.mWt.setText(2131756117);
          BackupMoveUI.this.mWu.setVisibility(4);
          BackupMoveUI.this.mWr.setVisibility(4);
          BackupMoveUI.this.mWs.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
        }
      }
    };
    AppMethodBeat.o(21470);
  }
  
  private void bDT()
  {
    AppMethodBeat.i(21477);
    int i = b.bDy().bCP().mSk;
    ac.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      ZA(1);
      AppMethodBeat.o(21477);
      return;
    case 15: 
      ac.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      bDV();
      AppMethodBeat.o(21477);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131756148, 2131756147, 2131756171, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21468);
        ac.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(485L, 25L, 1L, false);
        b.bDy().bDz().stop();
        b.bDy().bDA().cancel(false);
        b.bDy().bCP().mSk = -100;
        BackupMoveUI.f(BackupMoveUI.this);
        AppMethodBeat.o(21468);
      }
    }, null, 2131099991);
    AppMethodBeat.o(21477);
  }
  
  private void bDV()
  {
    AppMethodBeat.i(21478);
    b.bDy().bDC().cancel();
    b.bDy().bDA().cancel(true);
    b.bDy().bDz().stop();
    b.bDy().bCP().mSk = -100;
    ZA(1);
    AppMethodBeat.o(21478);
  }
  
  public int getLayoutId()
  {
    return 2131493131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21472);
    this.gzg = ((TextView)findViewById(2131297053));
    this.mWv = ((ImageView)findViewById(2131297054));
    this.mWt = ((TextView)findViewById(2131297063));
    this.mWu = ((TextView)findViewById(2131297062));
    this.mWr = ((TextView)findViewById(2131297034));
    this.mWs = ((TextView)findViewById(2131297033));
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
    ac.i("MicroMsg.BackupMoveUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.iyx.Lm();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      b.bDy().bDA().mUR = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ac.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(b.bDy().bDA().mUR) });
      AppMethodBeat.o(21471);
      return;
    }
    catch (Exception paramBundle)
    {
      ac.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bs.eWi() });
      AppMethodBeat.o(21471);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21475);
    ac.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
    if (b.bDy().bDA().mVx != null) {
      b.bDy().bDA().mVx.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(21475);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21476);
    if (paramInt == 4)
    {
      bDT();
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
    b.bDy().bDA().a(this.mTO);
    AppMethodBeat.o(21474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21473);
    super.onResume();
    b.bDy().bDA().mTO = this.mTO;
    this.mTO.wJ(b.bDy().bCP().mSk);
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