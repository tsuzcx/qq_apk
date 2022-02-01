package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.model.c.d;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class IPCallTalkUI
  extends MMActivity
  implements j.a
{
  private String krY;
  private String mCountryCode;
  private String yvn;
  private String yvo;
  private String yvp;
  private int yvq;
  private int yvr;
  private j yyW;
  private com.tencent.mm.plugin.voip.a.b yyX;
  
  private void bsw()
  {
    AppMethodBeat.i(185748);
    this.yyX = new com.tencent.mm.plugin.voip.a.b(new e(this));
    this.yyX.G(9, "VOIPFloatBall");
    AppMethodBeat.o(185748);
  }
  
  private void init()
  {
    AppMethodBeat.i(25985);
    i.eaq().ear();
    this.yyW = new j(this);
    this.yyW.yzI = this;
    this.yyW.b(this.krY, this.yvn, this.yvo, this.mCountryCode, this.yvp, this.yvq, this.yvr);
    bsw();
    AppMethodBeat.o(25985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25991);
    if (this.yyW != null) {
      this.yyW.yzR = true;
    }
    super.finish();
    AppMethodBeat.o(25991);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495100;
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25984);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.krY = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.yvn = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.yvo = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.yvp = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.yvq = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.yvr = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    Log.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.krY, this.yvn, this.yvo, this.mCountryCode, this.yvp, Integer.valueOf(this.yvq), Integer.valueOf(this.yvr) });
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    Log.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(25984);
      return;
    }
    init();
    AppMethodBeat.o(25984);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25987);
    super.onDestroy();
    setScreenEnable(true);
    if (this.yyW != null)
    {
      j localj = this.yyW;
      Log.i("MicroMsg.TalkUIController", "onDestroy");
      localj.yzH.yof = null;
      i.eav().gte = null;
      i.eav().a(null);
      i.eav().a(null);
      Object localObject = i.eav();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).yqr.yqC = null;
      localObject = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).yqr;
      ((d)localObject).qUq.removeSensorCallBack();
      ((d)localObject).qUp.stopShake();
      localj.yzG = null;
      localj.yzI = null;
    }
    if (this.yyX != null) {
      this.yyX.onDestroy();
    }
    AppMethodBeat.o(25987);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25989);
    if (this.yyW != null)
    {
      int i;
      if (i.eaw().eam()) {
        if (paramInt == 25)
        {
          i = i.eav().eaL();
          if (i == -1) {
            break label85;
          }
          com.tencent.mm.plugin.audio.c.a.AX(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(25989);
        return true;
        if (paramInt == 24)
        {
          i = i.eav().eaL();
          if (i != -1)
          {
            com.tencent.mm.plugin.audio.c.a.AW(i);
            i = 1;
            continue;
          }
        }
        label85:
        i = 0;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(25989);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25990);
    Log.d("MicroMsg.IPCallTalkUI", "onPause");
    super.onPause();
    j localj;
    if (this.yyW != null)
    {
      localj = this.yyW;
      bool1 = hasWindowFocus();
      Log.d("MicroMsg.TalkUIController", "onPause");
      KeyguardManager localKeyguardManager = (KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard");
      PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
      boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
      boolean bool3 = localPowerManager.isScreenOn();
      if (((!bool1) && (bool2)) || (!bool3)) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      localj.yzS = bool1;
      if (this.yyX != null)
      {
        this.yyX.aGj();
        com.tencent.mm.plugin.ball.f.f.e(false, true, true);
      }
      AppMethodBeat.o(25990);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25993);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25993);
      return;
    }
    Log.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25993);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(25993);
        return;
      }
      h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131756929), false, new IPCallTalkUI.2(this), new IPCallTalkUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25992);
    Log.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.yyW != null)
    {
      Log.d("MicroMsg.TalkUIController", "onResume");
      bg.getNotification().cancel(42);
    }
    if (this.yyX != null)
    {
      this.yyX.aGf();
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    AppMethodBeat.o(25992);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(25986);
    super.onStop();
    Log.i("MicroMsg.IPCallTalkUI", "onStop");
    if (this.yyW != null)
    {
      j localj = this.yyW;
      if ((localj.yzS) && (!localj.yzR)) {
        i.eax().dZS();
      }
    }
    AppMethodBeat.o(25986);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qC(boolean paramBoolean)
  {
    AppMethodBeat.i(25988);
    if (!paramBoolean)
    {
      AppMethodBeat.o(25988);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new IPCallTalkUI.1(this), 3000L);
    AppMethodBeat.o(25988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI
 * JD-Core Version:    0.7.0.1
 */