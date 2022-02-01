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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
{
  private b.d mrM;
  public TextView mup;
  public TextView muq;
  public TextView mur;
  public TextView mus;
  public TextView mut;
  public ImageView muu;
  
  public BackupMoveUI()
  {
    AppMethodBeat.i(21470);
    this.mrM = new b.d()
    {
      public final void bvS() {}
      
      public final void vS(int paramAnonymousInt)
      {
        AppMethodBeat.i(21466);
        Object localObject = b.bwC().bvT();
        ad.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql) });
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
          BackupMoveUI.this.muu.setImageResource(2131231103);
          BackupMoveUI.this.mur.setText(2131756106);
          BackupMoveUI.this.mus.setText(2131756139);
          BackupMoveUI.this.mus.setVisibility(0);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131231103);
          BackupMoveUI.this.mur.setText(BackupMoveUI.this.getString(2131756099, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql) }));
          BackupMoveUI.this.mus.setText(2131756139);
          BackupMoveUI.this.mus.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mus.setVisibility(0);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131231103);
          BackupMoveUI.this.mur.setText(2131756146);
          BackupMoveUI.this.mus.setText(2131756139);
          BackupMoveUI.this.mus.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mus.setVisibility(0);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131231103);
          TextView localTextView = BackupMoveUI.this.mur;
          BackupMoveUI localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mqk;
          int i = ((com.tencent.mm.plugin.backup.b.e)localObject).mql;
          b.bwC().bwE();
          localTextView.setText(localBackupMoveUI.getString(2131756174, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.bwS() }));
          BackupMoveUI.this.mus.setText(2131756139);
          BackupMoveUI.this.mus.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mus.setVisibility(0);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131231104);
          BackupMoveUI.this.mur.setText(2131756134);
          BackupMoveUI.this.mus.setText(BackupMoveUI.this.getString(2131756135, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql) }));
          BackupMoveUI.this.mus.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mup.setText(2131756096);
          BackupMoveUI.this.mus.setVisibility(0);
          BackupMoveUI.this.mup.setVisibility(0);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.this.mup.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21465);
              b.bwC().bwD().stop();
              b.bwC().bwE().cancel(true);
              b.bwC().bvT().mqj = -100;
              BackupMoveUI.c(BackupMoveUI.this);
              AppMethodBeat.o(21465);
            }
          });
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          localObject = b.bwC().bwE().bitmapData;
          BackupMoveUI.this.muu.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
          BackupMoveUI.this.mur.setText(2131756149);
          BackupMoveUI.this.mur.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100711));
          BackupMoveUI.this.mus.setVisibility(4);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131231103);
          localTextView = BackupMoveUI.this.mur;
          localBackupMoveUI = BackupMoveUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mqk;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).mql;
          b.bwC().bwE();
          localTextView.setText(localBackupMoveUI.getString(2131756174, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), d.bwS() }));
          BackupMoveUI.this.mus.setText(2131756175);
          BackupMoveUI.this.mus.setTextColor(BackupMoveUI.this.getResources().getColor(2131099992));
          BackupMoveUI.this.mus.setVisibility(0);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131689733);
          b.bwC().bwE().mtv.start();
          BackupMoveUI.this.mur.setText(BackupMoveUI.this.getString(2131756140, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql), "0M" }));
          BackupMoveUI.this.mus.setText(2131756124);
          BackupMoveUI.this.mus.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveUI.this.mus.setVisibility(0);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.d(BackupMoveUI.this);
          b.bwC().bwE().mtp = c.mpV;
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131689733);
          BackupMoveUI.this.mur.setText(BackupMoveUI.this.getString(2131756140, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql), "0M" }));
          BackupMoveUI.this.mus.setText(2131756122);
          BackupMoveUI.this.mus.setTextColor(BackupMoveUI.this.getContext().getResources().getColor(2131100798));
          BackupMoveUI.this.mus.setVisibility(0);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131689731);
          BackupMoveUI.this.mur.setText(2131756132);
          BackupMoveUI.this.mus.setVisibility(4);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
          AppMethodBeat.o(21466);
          return;
          BackupMoveUI.this.muu.setImageResource(2131689731);
          BackupMoveUI.this.mur.setText(2131756117);
          BackupMoveUI.this.mus.setVisibility(4);
          BackupMoveUI.this.mup.setVisibility(4);
          BackupMoveUI.this.muq.setVisibility(4);
          BackupMoveUI.b(BackupMoveUI.this);
        }
      }
    };
    AppMethodBeat.o(21470);
  }
  
  private void bwX()
  {
    AppMethodBeat.i(21477);
    int i = b.bwC().bvT().mqj;
    ad.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      Xo(1);
      AppMethodBeat.o(21477);
      return;
    case 15: 
      ad.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      bwZ();
      AppMethodBeat.o(21477);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, 2131756148, 2131756147, 2131756171, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21468);
        ad.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(485L, 25L, 1L, false);
        b.bwC().bwD().stop();
        b.bwC().bwE().cancel(false);
        b.bwC().bvT().mqj = -100;
        BackupMoveUI.f(BackupMoveUI.this);
        AppMethodBeat.o(21468);
      }
    }, null, 2131099991);
    AppMethodBeat.o(21477);
  }
  
  private void bwZ()
  {
    AppMethodBeat.i(21478);
    b.bwC().bwG().cancel();
    b.bwC().bwE().cancel(true);
    b.bwC().bwD().stop();
    b.bwC().bvT().mqj = -100;
    Xo(1);
    AppMethodBeat.o(21478);
  }
  
  public int getLayoutId()
  {
    return 2131493131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21472);
    this.mut = ((TextView)findViewById(2131297053));
    this.muu = ((ImageView)findViewById(2131297054));
    this.mur = ((TextView)findViewById(2131297063));
    this.mus = ((TextView)findViewById(2131297062));
    this.mup = ((TextView)findViewById(2131297034));
    this.muq = ((TextView)findViewById(2131297033));
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
    com.tencent.mm.plugin.backup.a.hYt.Lo();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      b.bwC().bwE().msP = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ad.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(b.bwC().bwE().msP) });
      AppMethodBeat.o(21471);
      return;
    }
    catch (Exception paramBundle)
    {
      ad.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bt.eGN() });
      AppMethodBeat.o(21471);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21475);
    ad.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
    if (b.bwC().bwE().mtv != null) {
      b.bwC().bwE().mtv.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(21475);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21476);
    if (paramInt == 4)
    {
      bwX();
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
    b.bwC().bwE().a(this.mrM);
    AppMethodBeat.o(21474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21473);
    super.onResume();
    b.bwC().bwE().mrM = this.mrM;
    this.mrM.vS(b.bwC().bvT().mqj);
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