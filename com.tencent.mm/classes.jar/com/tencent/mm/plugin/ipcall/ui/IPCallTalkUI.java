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
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.model.c.d;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class IPCallTalkUI
  extends MMActivity
  implements j.a
{
  private String jtJ;
  private String mCountryCode;
  private String vcN;
  private String vcO;
  private String vcP;
  private int vcQ;
  private int vcR;
  private j vgx;
  private com.tencent.mm.plugin.voip.a.b vgy;
  
  private void dhA()
  {
    AppMethodBeat.i(185748);
    this.vgy = new com.tencent.mm.plugin.voip.a.b(new e(this));
    this.vgy.ac(9, "VOIPFloatBall");
    AppMethodBeat.o(185748);
  }
  
  private void init()
  {
    AppMethodBeat.i(25985);
    i.dgw().dgx();
    this.vgx = new j(this);
    this.vgx.vhj = this;
    this.vgx.b(this.jtJ, this.vcN, this.vcO, this.mCountryCode, this.vcP, this.vcQ, this.vcR);
    dhA();
    AppMethodBeat.o(25985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25991);
    if (this.vgx != null) {
      this.vgx.vhs = true;
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
    return 2131494508;
  }
  
  public final void nT(boolean paramBoolean)
  {
    AppMethodBeat.i(25988);
    if (!paramBoolean)
    {
      AppMethodBeat.o(25988);
      return;
    }
    ar.o(new IPCallTalkUI.1(this), 3000L);
    AppMethodBeat.o(25988);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25984);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.jtJ = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.vcN = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.vcO = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.vcP = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.vcQ = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.vcR = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    ae.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.jtJ, this.vcN, this.vcO, this.mCountryCode, this.vcP, Integer.valueOf(this.vcQ), Integer.valueOf(this.vcR) });
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ae.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
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
    if (this.vgx != null)
    {
      j localj = this.vgx;
      ae.i("MicroMsg.TalkUIController", "onDestroy");
      localj.vhi.uVE = null;
      i.dgB().fNT = null;
      i.dgB().a(null);
      i.dgB().a(null);
      Object localObject = i.dgB();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).uXR.uYc = null;
      localObject = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).uXR;
      ((d)localObject).pEZ.fpx();
      ((d)localObject).pEY.fpy();
      localj.vhh = null;
      localj.vhj = null;
    }
    if (this.vgy != null) {
      this.vgy.onDestroy();
    }
    AppMethodBeat.o(25987);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25989);
    if (this.vgx != null)
    {
      int i;
      if (i.dgC().dgs()) {
        if (paramInt == 25)
        {
          i = i.dgB().dgR();
          if (i == -1) {
            break label85;
          }
          com.tencent.mm.plugin.audio.c.a.xr(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(25989);
        return true;
        if (paramInt == 24)
        {
          i = i.dgB().dgR();
          if (i != -1)
          {
            com.tencent.mm.plugin.audio.c.a.xq(i);
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
    ae.d("MicroMsg.IPCallTalkUI", "onPause");
    super.onPause();
    j localj;
    if (this.vgx != null)
    {
      localj = this.vgx;
      bool1 = hasWindowFocus();
      ae.d("MicroMsg.TalkUIController", "onPause");
      KeyguardManager localKeyguardManager = (KeyguardManager)ak.getContext().getSystemService("keyguard");
      PowerManager localPowerManager = (PowerManager)ak.getContext().getSystemService("power");
      boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
      boolean bool3 = localPowerManager.isScreenOn();
      if (((!bool1) && (bool2)) || (!bool3)) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      localj.vht = bool1;
      if (this.vgy != null)
      {
        this.vgy.bhk();
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
      ae.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25993);
      return;
    }
    ae.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new IPCallTalkUI.2(this), new IPCallTalkUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25992);
    ae.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.vgx != null)
    {
      ae.d("MicroMsg.TalkUIController", "onResume");
      bc.getNotification().cancel(42);
    }
    if (this.vgy != null)
    {
      this.vgy.bLp();
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    AppMethodBeat.o(25992);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(25986);
    super.onStop();
    ae.i("MicroMsg.IPCallTalkUI", "onStop");
    if (this.vgx != null)
    {
      j localj = this.vgx;
      if ((localj.vht) && (!localj.vhs)) {
        i.dgD().dfY();
      }
    }
    AppMethodBeat.o(25986);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI
 * JD-Core Version:    0.7.0.1
 */