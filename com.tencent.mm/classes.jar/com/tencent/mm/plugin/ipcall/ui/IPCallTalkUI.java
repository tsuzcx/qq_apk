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
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.model.c.d;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class IPCallTalkUI
  extends MMActivity
  implements j.a
{
  private String jqQ;
  private String mCountryCode;
  private String uRb;
  private String uRc;
  private String uRd;
  private int uRe;
  private int uRf;
  private j uUK;
  private com.tencent.mm.plugin.voip.a.b uUL;
  
  private void deI()
  {
    AppMethodBeat.i(185748);
    this.uUL = new com.tencent.mm.plugin.voip.a.b(new e(this));
    this.uUL.ac(9, "VOIPFloatBall");
    AppMethodBeat.o(185748);
  }
  
  private void init()
  {
    AppMethodBeat.i(25985);
    i.ddE().ddF();
    this.uUK = new j(this);
    this.uUK.uVw = this;
    this.uUK.b(this.jqQ, this.uRb, this.uRc, this.mCountryCode, this.uRd, this.uRe, this.uRf);
    deI();
    AppMethodBeat.o(25985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25991);
    if (this.uUK != null) {
      this.uUK.uVF = true;
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
  
  public final void nP(boolean paramBoolean)
  {
    AppMethodBeat.i(25988);
    if (!paramBoolean)
    {
      AppMethodBeat.o(25988);
      return;
    }
    aq.o(new IPCallTalkUI.1(this), 3000L);
    AppMethodBeat.o(25988);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25984);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.jqQ = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.uRb = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.uRc = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.uRd = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.uRe = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.uRf = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    ad.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.jqQ, this.uRb, this.uRc, this.mCountryCode, this.uRd, Integer.valueOf(this.uRe), Integer.valueOf(this.uRf) });
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ad.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
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
    if (this.uUK != null)
    {
      j localj = this.uUK;
      ad.i("MicroMsg.TalkUIController", "onDestroy");
      localj.uVv.uJR = null;
      i.ddJ().fLP = null;
      i.ddJ().a(null);
      i.ddJ().a(null);
      Object localObject = i.ddJ();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).uMe.uMp = null;
      localObject = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).uMe;
      ((d)localObject).pyv.flC();
      ((d)localObject).pyu.flD();
      localj.uVu = null;
      localj.uVw = null;
    }
    if (this.uUL != null) {
      this.uUL.onDestroy();
    }
    AppMethodBeat.o(25987);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25989);
    if (this.uUK != null)
    {
      int i;
      if (i.ddK().ddA()) {
        if (paramInt == 25)
        {
          i = i.ddJ().ddZ();
          if (i == -1) {
            break label85;
          }
          com.tencent.mm.plugin.audio.c.a.xm(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(25989);
        return true;
        if (paramInt == 24)
        {
          i = i.ddJ().ddZ();
          if (i != -1)
          {
            com.tencent.mm.plugin.audio.c.a.xl(i);
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
    ad.d("MicroMsg.IPCallTalkUI", "onPause");
    super.onPause();
    j localj;
    if (this.uUK != null)
    {
      localj = this.uUK;
      bool1 = hasWindowFocus();
      ad.d("MicroMsg.TalkUIController", "onPause");
      KeyguardManager localKeyguardManager = (KeyguardManager)aj.getContext().getSystemService("keyguard");
      PowerManager localPowerManager = (PowerManager)aj.getContext().getSystemService("power");
      boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
      boolean bool3 = localPowerManager.isScreenOn();
      if (((!bool1) && (bool2)) || (!bool3)) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      localj.uVG = bool1;
      if (this.uUL != null)
      {
        this.uUL.bgC();
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
      ad.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25993);
      return;
    }
    ad.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    ad.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.uUK != null)
    {
      ad.d("MicroMsg.TalkUIController", "onResume");
      ba.getNotification().cancel(42);
    }
    if (this.uUL != null)
    {
      this.uUL.bKs();
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    AppMethodBeat.o(25992);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(25986);
    super.onStop();
    ad.i("MicroMsg.IPCallTalkUI", "onStop");
    if (this.uUK != null)
    {
      j localj = this.uUK;
      if ((localj.uVG) && (!localj.uVF)) {
        i.ddL().ddg();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI
 * JD-Core Version:    0.7.0.1
 */