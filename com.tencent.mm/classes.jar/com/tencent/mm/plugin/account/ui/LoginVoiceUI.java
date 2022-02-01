package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public class LoginVoiceUI
  extends BaseLoginVoiceUI
{
  protected final void bXX()
  {
    int j = -1;
    AppMethodBeat.i(128253);
    super.bXX();
    bXW();
    u localu = new u(this.pZh.account, this.pZt, "", 0);
    localu.OY(this.pZt);
    int i;
    String str;
    if (this.pZt == null)
    {
      i = -1;
      str = Util.secPrint(this.pZt);
      if (this.pZh.pRx != null) {
        break label175;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Util.secPrint(this.pZh.pRx) });
      getString(r.j.app_tip);
      this.lzP = k.a(this, getString(r.j.login_logining), true, new LoginVoiceUI.2(this, localu));
      h.aZW().a(localu, 0);
      AppMethodBeat.o(128253);
      return;
      i = this.pZt.length();
      break;
      label175:
      j = this.pZh.pRx.length();
    }
  }
  
  public final boolean bXY()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return r.g.login_voice_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(305017);
    super.initView();
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_errType", 0);
      int j = getIntent().getIntExtra("key_errCode", 0);
      Object localObject = getIntent().getStringExtra("key_errMsg");
      Log.i("MicroMsg.LoginVoiceUI", "initView,errType %d,errCode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (a.fc(i, j))
      {
        localObject = com.tencent.mm.broadcast.a.CH((String)localObject);
        if (localObject != null) {
          ((com.tencent.mm.broadcast.a)localObject).a(this, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
          });
        }
      }
    }
    AppMethodBeat.o(305017);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128252);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    if (this.pZu)
    {
      AppMethodBeat.o(128252);
      return;
    }
    this.loginType = 1;
    this.pZc.setVisibility(0);
    findViewById(r.f.voice_btn_icon).setEnabled(false);
    ((TextView)findViewById(r.f.voice_login_btn)).setTextColor(getResources().getColorStateList(r.c.white_text_color_selector));
    ((TextView)findViewById(r.f.voice_login_btn)).setBackgroundResource(getResources().getColor(r.c.transparent));
    this.pZc.setOnClickListener(new LoginVoiceUI.1(this));
    AppMethodBeat.o(128252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI
 * JD-Core Version:    0.7.0.1
 */