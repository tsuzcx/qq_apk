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
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.lang.reflect.Method;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveUI
  extends MMWizardActivity
{
  private b.d jAq;
  public TextView jCU;
  public TextView jCV;
  public TextView jCW;
  public TextView jCX;
  public TextView jCY;
  public ImageView jCZ;
  
  public BackupMoveUI()
  {
    AppMethodBeat.i(17412);
    this.jAq = new BackupMoveUI.1(this);
    AppMethodBeat.o(17412);
  }
  
  private void aTQ()
  {
    AppMethodBeat.i(17418);
    int i = b.aTr().aSL().jyN;
    ab.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      Oi(1);
      AppMethodBeat.o(17418);
      return;
    case 15: 
      ab.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
      aTS();
      AppMethodBeat.o(17418);
      return;
    }
    h.a(this, 2131297275, 2131297274, 2131297298, 2131297220, false, new BackupMoveUI.3(this), null, 2131689740);
    AppMethodBeat.o(17418);
  }
  
  private void aTS()
  {
    AppMethodBeat.i(17419);
    b.aTr().aTv().cancel();
    b.aTr().aTt().cancel(true);
    b.aTr().aTs().stop();
    b.aTr().aSL().jyN = -100;
    Oi(1);
    AppMethodBeat.o(17419);
  }
  
  public int getLayoutId()
  {
    return 2130968802;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17414);
    this.jCY = ((TextView)findViewById(2131821623));
    this.jCZ = ((ImageView)findViewById(2131821624));
    this.jCW = ((TextView)findViewById(2131821625));
    this.jCX = ((TextView)findViewById(2131821626));
    this.jCU = ((TextView)findViewById(2131821628));
    this.jCV = ((TextView)findViewById(2131821627));
    AppMethodBeat.o(17414);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17413);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17413);
      return;
    }
    ab.i("MicroMsg.BackupMoveUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.gmO.BR();
    initView();
    try
    {
      paramBundle = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
      WifiManager localWifiManager = (WifiManager)getSystemService("wifi");
      b.aTr().aTt().jBt = ((Boolean)paramBundle.invoke(localWifiManager, new Object[0])).booleanValue();
      ab.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[] { Boolean.valueOf(b.aTr().aTt().jBt) });
      AppMethodBeat.o(17413);
      return;
    }
    catch (Exception paramBundle)
    {
      ab.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[] { bo.dtY() });
      AppMethodBeat.o(17413);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(17416);
    ab.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
    if (b.aTr().aTt().jCa != null) {
      b.aTr().aTt().jCa.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(17416);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(17417);
    if (paramInt == 4)
    {
      aTQ();
      AppMethodBeat.o(17417);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(17417);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(17415);
    super.onResume();
    b.aTr().aTt().jAq = this.jAq;
    this.jAq.rf(b.aTr().aSL().jyN);
    AppMethodBeat.o(17415);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI
 * JD-Core Version:    0.7.0.1
 */