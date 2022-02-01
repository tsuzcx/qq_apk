package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.model.c.d;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class IPCallTalkUI
  extends MMActivity
  implements j.a
{
  private String ixE;
  private String mCountryCode;
  private String sGH;
  private String sGI;
  private String sGJ;
  private int sGK;
  private int sGL;
  private j sKr;
  private com.tencent.mm.plugin.voip.a.b sKs;
  
  private void cIm()
  {
    AppMethodBeat.i(185748);
    this.sKs = new com.tencent.mm.plugin.voip.a.b(new e(this));
    this.sKs.Z(9, "VOIPFloatBall");
    AppMethodBeat.o(185748);
  }
  
  private void init()
  {
    AppMethodBeat.i(25985);
    i.cHi().cHj();
    this.sKr = new j(this);
    this.sKr.sLe = this;
    this.sKr.b(this.ixE, this.sGH, this.sGI, this.mCountryCode, this.sGJ, this.sGK, this.sGL);
    cIm();
    AppMethodBeat.o(25985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(25991);
    if (this.sKr != null) {
      this.sKr.sLn = true;
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
  
  public final void mC(boolean paramBoolean)
  {
    AppMethodBeat.i(25988);
    if (!paramBoolean)
    {
      AppMethodBeat.o(25988);
      return;
    }
    com.tencent.mm.sdk.platformtools.aq.n(new Runnable()
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
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25984);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.ixE = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.sGH = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.sGI = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.sGJ = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.sGK = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.sGL = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    ad.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.ixE, this.sGH, this.sGI, this.mCountryCode, this.sGJ, Integer.valueOf(this.sGK), Integer.valueOf(this.sGL) });
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ad.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN() });
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
    if (this.sKr != null)
    {
      j localj = this.sKr;
      ad.i("MicroMsg.TalkUIController", "onDestroy");
      localj.sLd.szu = null;
      i.cHn().imP = null;
      i.cHn().a(null);
      i.cHn().a(null);
      Object localObject = i.cHn();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).sBJ.sBU = null;
      localObject = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).sBJ;
      ((d)localObject).orl.eGx();
      ((d)localObject).ork.eGy();
      localj.sLb = null;
      localj.sLe = null;
    }
    if (this.sKs != null) {
      this.sKs.onDestroy();
    }
    AppMethodBeat.o(25987);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(25989);
    if (this.sKr != null)
    {
      int i;
      if (i.cHo().cHe()) {
        if (paramInt == 25)
        {
          i = i.cHn().cHD();
          if (i == -1) {
            break label85;
          }
          com.tencent.mm.plugin.audio.c.a.vP(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(25989);
        return true;
        if (paramInt == 24)
        {
          i = i.cHn().cHD();
          if (i != -1)
          {
            com.tencent.mm.plugin.audio.c.a.vO(i);
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
    if (this.sKr != null)
    {
      localj = this.sKr;
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
      localj.sLo = bool1;
      if (this.sKs != null)
      {
        this.sKs.aWa();
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
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(25982);
          paramAnonymousDialogInterface.dismiss();
          IPCallTalkUI.this.finish();
          paramAnonymousDialogInterface = IPCallTalkUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallTalkUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/ipcall/ui/IPCallTalkUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    ad.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.sKr != null)
    {
      ad.d("MicroMsg.TalkUIController", "onResume");
      az.getNotification().cancel(42);
    }
    if (this.sKs != null)
    {
      this.sKs.bzl();
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    AppMethodBeat.o(25992);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(25986);
    super.onStop();
    ad.i("MicroMsg.IPCallTalkUI", "onStop");
    if (this.sKr != null)
    {
      j localj = this.sKr;
      if ((localj.sLo) && (!localj.sLn)) {
        i.cHp().cGK();
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