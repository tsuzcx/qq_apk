package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveRecoverUI
  extends MMWizardActivity
{
  private static boolean gsE = false;
  private static boolean jDb = false;
  private b.d jAq;
  public TextView jCU;
  public TextView jCV;
  public TextView jCW;
  public TextView jCX;
  public TextView jCY;
  public ImageView jCZ;
  private RoundProgressBtn jDa;
  
  public BackupMoveRecoverUI()
  {
    AppMethodBeat.i(17390);
    this.jAq = new BackupMoveRecoverUI.1(this);
    AppMethodBeat.o(17390);
  }
  
  private void aTQ()
  {
    AppMethodBeat.i(17397);
    int i = b.aTr().aSL().jyN;
    ab.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
    switch (i)
    {
    default: 
    case -22: 
    case -21: 
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
        Oi(1);
        AppMethodBeat.o(17397);
        return;
        b.aTr().aTu().c(false, false, -100);
        AppMethodBeat.o(17397);
        return;
        ab.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[] { Integer.valueOf(i) });
        b.aTr().aTu().c(true, false, -100);
        b.aTr().aTs().stop();
        AppMethodBeat.o(17397);
        return;
        b.aTr().aSL().jyN = 25;
      }
    case 52: 
      h.a(this, 2131297241, 2131297240, 2131297286, 2131297220, false, new BackupMoveRecoverUI.3(this, i), null, 2131689740);
      AppMethodBeat.o(17397);
      return;
    }
    h.a(this, 2131297321, 2131297320, 2131297371, 2131297220, false, new BackupMoveRecoverUI.4(this, i), null, 2131689740);
    AppMethodBeat.o(17397);
  }
  
  public int getLayoutId()
  {
    return 2130968802;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17392);
    this.jCY = ((TextView)findViewById(2131821623));
    this.jCZ = ((ImageView)findViewById(2131821624));
    this.jCW = ((TextView)findViewById(2131821625));
    this.jCX = ((TextView)findViewById(2131821626));
    this.jCU = ((TextView)findViewById(2131821628));
    this.jCV = ((TextView)findViewById(2131821627));
    this.jDa = ((RoundProgressBtn)findViewById(2131821629));
    AppMethodBeat.o(17392);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17391);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17391);
      return;
    }
    ab.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.gmO.BR();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      b.aTr().aTu().jBt = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ab.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[] { Boolean.valueOf(b.aTr().aTu().jBt) });
      AppMethodBeat.o(17391);
      return;
    }
    catch (Exception paramBundle)
    {
      ab.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bo.dtY() });
      AppMethodBeat.o(17391);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(17395);
    ab.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
    super.onDestroy();
    AppMethodBeat.o(17395);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(17396);
    if (paramInt == 4)
    {
      aTQ();
      AppMethodBeat.o(17396);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(17396);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(17394);
    super.onPause();
    ab.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
    jDb = false;
    AppMethodBeat.o(17394);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(17393);
    super.onResume();
    ab.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
    jDb = true;
    b.aTr().aTu().jAq = this.jAq;
    gsE = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    this.jAq.rf(b.aTr().aSL().jyN);
    AppMethodBeat.o(17393);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI
 * JD-Core Version:    0.7.0.1
 */