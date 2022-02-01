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
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.model.c.d;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class IPCallTalkUI
  extends MMActivity
  implements j.a
{
  private String iXH;
  private String mCountryCode;
  private String tOo;
  private String tOp;
  private String tOq;
  private int tOr;
  private int tOs;
  private j tRX;
  private com.tencent.mm.plugin.voip.a.b tRY;
  
  private void cVx()
  {
    AppMethodBeat.i(185748);
    this.tRY = new com.tencent.mm.plugin.voip.a.b(new e(this));
    this.tRY.aa(9, "VOIPFloatBall");
    AppMethodBeat.o(185748);
  }
  
  private void init()
  {
    AppMethodBeat.i(25985);
    i.cUt().cUu();
    this.tRX = new j(this);
    this.tRX.tSJ = this;
    this.tRX.b(this.iXH, this.tOo, this.tOp, this.mCountryCode, this.tOq, this.tOr, this.tOs);
    cVx();
    AppMethodBeat.o(25985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25991);
    if (this.tRX != null) {
      this.tRX.tSS = true;
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
  
  public final void nv(boolean paramBoolean)
  {
    AppMethodBeat.i(25988);
    if (!paramBoolean)
    {
      AppMethodBeat.o(25988);
      return;
    }
    ap.n(new IPCallTalkUI.1(this), 3000L);
    AppMethodBeat.o(25988);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25984);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.iXH = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.tOo = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.tOp = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.tOq = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.tOr = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.tOs = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    ac.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.iXH, this.tOo, this.tOp, this.mCountryCode, this.tOq, Integer.valueOf(this.tOr), Integer.valueOf(this.tOs) });
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ac.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
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
    if (this.tRX != null)
    {
      j localj = this.tRX;
      ac.i("MicroMsg.TalkUIController", "onDestroy");
      localj.tSI.tHe = null;
      i.cUy().iMV = null;
      i.cUy().a(null);
      i.cUy().a(null);
      Object localObject = i.cUy();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).tJr.tJC = null;
      localObject = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).tJr;
      ((d)localObject).oUL.eVS();
      ((d)localObject).oUK.eVT();
      localj.tSH = null;
      localj.tSJ = null;
    }
    if (this.tRY != null) {
      this.tRY.onDestroy();
    }
    AppMethodBeat.o(25987);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25989);
    if (this.tRX != null)
    {
      int i;
      if (i.cUz().cUp()) {
        if (paramInt == 25)
        {
          i = i.cUy().cUO();
          if (i == -1) {
            break label85;
          }
          com.tencent.mm.plugin.audio.c.a.wG(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(25989);
        return true;
        if (paramInt == 24)
        {
          i = i.cUy().cUO();
          if (i != -1)
          {
            com.tencent.mm.plugin.audio.c.a.wF(i);
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
    ac.d("MicroMsg.IPCallTalkUI", "onPause");
    super.onPause();
    j localj;
    if (this.tRX != null)
    {
      localj = this.tRX;
      bool1 = hasWindowFocus();
      ac.d("MicroMsg.TalkUIController", "onPause");
      KeyguardManager localKeyguardManager = (KeyguardManager)ai.getContext().getSystemService("keyguard");
      PowerManager localPowerManager = (PowerManager)ai.getContext().getSystemService("power");
      boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
      boolean bool3 = localPowerManager.isScreenOn();
      if (((!bool1) && (bool2)) || (!bool3)) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      localj.tST = bool1;
      if (this.tRY != null)
      {
        this.tRY.bcY();
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
      ac.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25993);
      return;
    }
    ac.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    ac.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.tRX != null)
    {
      ac.d("MicroMsg.TalkUIController", "onResume");
      az.getNotification().cancel(42);
    }
    if (this.tRY != null)
    {
      this.tRY.bGh();
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    AppMethodBeat.o(25992);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(25986);
    super.onStop();
    ac.i("MicroMsg.IPCallTalkUI", "onStop");
    if (this.tRX != null)
    {
      j localj = this.tRX;
      if ((localj.tST) && (!localj.tSS)) {
        i.cUA().cTV();
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