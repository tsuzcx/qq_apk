package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
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
  private String DVr;
  private String DVs;
  private String DVt;
  private int DVu;
  private int DVv;
  private j DYO;
  private com.tencent.mm.plugin.voip.a.b DYP;
  private String mCountryCode;
  private String njH;
  
  private void bDs()
  {
    AppMethodBeat.i(185748);
    this.DYP = new com.tencent.mm.plugin.voip.a.b(new e(this));
    this.DYP.I(9, "VOIPFloatBall");
    AppMethodBeat.o(185748);
  }
  
  private void init()
  {
    AppMethodBeat.i(25985);
    i.eJo().eJp();
    this.DYO = new j(this);
    this.DYO.DZA = this;
    this.DYO.b(this.njH, this.DVr, this.DVs, this.mCountryCode, this.DVt, this.DVu, this.DVv);
    bDs();
    AppMethodBeat.o(25985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25991);
    if (this.DYO != null) {
      this.DYO.DZJ = true;
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
    return R.i.ehT;
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25984);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.njH = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.DVr = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.DVs = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.DVt = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.DVu = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.DVv = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    Log.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.njH, this.DVr, this.DVs, this.mCountryCode, this.DVt, Integer.valueOf(this.DVu), Integer.valueOf(this.DVv) });
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
    if (this.DYO != null)
    {
      j localj = this.DYO;
      Log.i("MicroMsg.TalkUIController", "onDestroy");
      localj.DZz.DOh = null;
      i.eJt().iXq = null;
      i.eJt().a(null);
      i.eJt().a(null);
      Object localObject = i.eJt();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).DQt.DQE = null;
      localObject = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).DQt;
      ((d)localObject).uww.removeSensorCallBack();
      ((d)localObject).uwv.stopShake();
      localj.DZy = null;
      localj.DZA = null;
    }
    if (this.DYP != null) {
      this.DYP.onDestroy();
    }
    AppMethodBeat.o(25987);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25989);
    if (this.DYO != null)
    {
      int i;
      if (i.eJu().eJk()) {
        if (paramInt == 25)
        {
          i = i.eJt().eJJ();
          if (i == -1) {
            break label85;
          }
          com.tencent.mm.plugin.audio.c.a.Ey(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(25989);
        return true;
        if (paramInt == 24)
        {
          i = i.eJt().eJJ();
          if (i != -1)
          {
            com.tencent.mm.plugin.audio.c.a.Ex(i);
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
    if (this.DYO != null)
    {
      localj = this.DYO;
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
      localj.DZK = bool1;
      if (this.DYP != null)
      {
        this.DYP.aOj();
        com.tencent.mm.plugin.ball.f.f.d(false, true, true);
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
      h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new IPCallTalkUI.2(this), new IPCallTalkUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25992);
    Log.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.DYO != null)
    {
      Log.d("MicroMsg.TalkUIController", "onResume");
      bh.getNotification().cancel(42);
    }
    if (this.DYP != null)
    {
      this.DYP.aOf();
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    AppMethodBeat.o(25992);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(25986);
    super.onStop();
    Log.i("MicroMsg.IPCallTalkUI", "onStop");
    if (this.DYO != null)
    {
      j localj = this.DYO;
      if ((localj.DZK) && (!localj.DZJ)) {
        i.eJv().eIQ();
      }
    }
    AppMethodBeat.o(25986);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tE(boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI
 * JD-Core Version:    0.7.0.1
 */