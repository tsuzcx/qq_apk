package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.b.d;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class IPCallTalkUI
  extends MMActivity
  implements j.a
{
  private String gJX;
  private String mCountryCode;
  private String nSM;
  private String nSN;
  private String nSO;
  private int nSP;
  private int nSQ;
  private j nWy;
  
  private void init()
  {
    AppMethodBeat.i(22364);
    this.nWy = new j(this);
    this.nWy.nXj = this;
    this.nWy.b(this.gJX, this.nSM, this.nSN, this.mCountryCode, this.nSO, this.nSP, this.nSQ);
    AppMethodBeat.o(22364);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969930;
  }
  
  public final void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(22366);
    if (!paramBoolean)
    {
      AppMethodBeat.o(22366);
      return;
    }
    al.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22360);
        Intent localIntent = new Intent();
        IPCallTalkUI.this.setResult(-1, localIntent);
        IPCallTalkUI.this.finish();
        AppMethodBeat.o(22360);
      }
    }, 3000L);
    AppMethodBeat.o(22366);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22363);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.gJX = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.nSM = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.nSN = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.mCountryCode = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.nSO = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.nSP = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.nSQ = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    ab.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.gJX, this.nSM, this.nSN, this.mCountryCode, this.nSO, Integer.valueOf(this.nSP), Integer.valueOf(this.nSQ) });
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    ab.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
    if (!bool)
    {
      AppMethodBeat.o(22363);
      return;
    }
    init();
    AppMethodBeat.o(22363);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22365);
    super.onDestroy();
    setScreenEnable(true);
    if (this.nWy != null)
    {
      j localj = this.nWy;
      ab.i("MicroMsg.TalkUIController", "onDestroy");
      localj.nXi.nLC = null;
      i.bJq().cmc = null;
      i.bJq().nNP = null;
      i.bJq().a(null);
      Object localObject = i.bJq();
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).nNM.nNZ = null;
      localObject = ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).nNM;
      ((d)localObject).mub.dtJ();
      ((d)localObject).mtY.dtK();
      localj.nXh = null;
      localj.nXj = null;
    }
    AppMethodBeat.o(22365);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22367);
    if (this.nWy != null)
    {
      int i;
      if (i.bJr().bJi()) {
        if (paramInt == 25)
        {
          i = i.bJq().bJG();
          if (i == -1) {
            break label91;
          }
          aw.aaA().iG(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(22367);
        return true;
        if (paramInt == 24)
        {
          i = i.bJq().bJG();
          if (i != -1)
          {
            aw.aaA().iF(i);
            i = 1;
            continue;
          }
        }
        label91:
        i = 0;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(22367);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22368);
    ab.d("MicroMsg.IPCallTalkUI", "onPause");
    super.onPause();
    if (this.nWy != null) {
      ab.d("MicroMsg.TalkUIController", "onPause");
    }
    AppMethodBeat.o(22368);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(22370);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(22370);
      return;
    }
    ab.i("MicroMsg.IPCallTalkUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22370);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(22370);
        return;
      }
      h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131297837), false, new IPCallTalkUI.2(this), new IPCallTalkUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22369);
    ab.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.nWy != null)
    {
      ab.d("MicroMsg.TalkUIController", "onResume");
      aw.getNotification().cancel(42);
    }
    AppMethodBeat.o(22369);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI
 * JD-Core Version:    0.7.0.1
 */