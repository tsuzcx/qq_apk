package com.tencent.mm.plugin.ipcall.ui;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

@com.tencent.mm.ui.base.a(3)
public class IPCallTalkUI
  extends MMActivity
  implements i.a
{
  private String JMA;
  private String JMB;
  private String JMC;
  private int JMD;
  private int JME;
  private i JPX;
  private com.tencent.mm.plugin.voip.c.b JPY;
  private String mCountryCode;
  private String qgV;
  
  private void ccH()
  {
    AppMethodBeat.i(185748);
    this.JPY = new com.tencent.mm.plugin.voip.c.b(new e(this));
    this.JPY.J(9, "VOIPFloatBall");
    AppMethodBeat.o(185748);
  }
  
  private void init()
  {
    AppMethodBeat.i(25985);
    h.fRo().fRp();
    this.JPX = new i(this);
    this.JPX.JQI = this;
    this.JPX.b(this.qgV, this.JMA, this.JMB, this.mCountryCode, this.JMC, this.JMD, this.JME);
    ccH();
    AppMethodBeat.o(25985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25991);
    if (this.JPX != null) {
      this.JPX.JQR = true;
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
    return R.i.gkO;
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25984);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.qgV = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.JMA = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.JMB = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.JMC = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.JMD = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.JME = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    Log.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.qgV, this.JMA, this.JMB, this.mCountryCode, this.JMC, Integer.valueOf(this.JMD), Integer.valueOf(this.JME) });
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null);
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
    if (this.JPX != null)
    {
      i locali = this.JPX;
      Log.i("MicroMsg.TalkUIController", "onDestroy");
      locali.JQH.JFw = null;
      h.fRt().lzt = null;
      h.fRt().a(null);
      h.fRt().a(null);
      Object localObject = h.fRt();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).JHE.JHO = null;
      localObject = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).JHE;
      ((d)localObject).xCV.removeSensorCallBack();
      ((d)localObject).xCU.stopShake();
      locali.JQG = null;
      locali.JQI = null;
    }
    if (this.JPY != null) {
      this.JPY.onDestroy();
    }
    AppMethodBeat.o(25987);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25989);
    if (this.JPX != null)
    {
      int i;
      if (h.fRu().fRk()) {
        if (paramInt == 25)
        {
          i = h.fRt().fwf();
          if (i == -1) {
            break label85;
          }
          com.tencent.mm.plugin.audio.c.a.EZ(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(25989);
        return true;
        if (paramInt == 24)
        {
          i = h.fRt().fwf();
          if (i != -1)
          {
            com.tencent.mm.plugin.audio.c.a.EY(i);
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
    i locali;
    if (this.JPX != null)
    {
      locali = this.JPX;
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
      locali.JQS = bool1;
      if (this.JPY != null)
      {
        this.JPY.bhW();
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
      k.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(25982);
          paramAnonymousDialogInterface.dismiss();
          IPCallTalkUI.this.finish();
          com.tencent.mm.pluginsdk.permission.b.lx(IPCallTalkUI.this.getContext());
          AppMethodBeat.o(25982);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(25983);
          paramAnonymousDialogInterface.dismiss();
          IPCallTalkUI.this.finish();
          AppMethodBeat.o(25983);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25992);
    Log.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.JPX != null)
    {
      Log.d("MicroMsg.TalkUIController", "onResume");
      bh.getNotification().cancel(42);
    }
    if (this.JPY != null)
    {
      this.JPY.bhT();
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    AppMethodBeat.o(25992);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(25986);
    super.onStop();
    Log.i("MicroMsg.IPCallTalkUI", "onStop");
    if (this.JPX != null)
    {
      i locali = this.JPX;
      if ((locali.JQS) && (!locali.JQR)) {
        h.fRv().fQP();
      }
    }
    AppMethodBeat.o(25986);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void xN(boolean paramBoolean)
  {
    AppMethodBeat.i(25988);
    if (!paramBoolean)
    {
      AppMethodBeat.o(25988);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25981);
        Intent localIntent = new Intent();
        IPCallTalkUI.this.setResult(-1, localIntent);
        IPCallTalkUI.this.finish();
        AppMethodBeat.o(25981);
      }
    }, 3000L);
    AppMethodBeat.o(25988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI
 * JD-Core Version:    0.7.0.1
 */