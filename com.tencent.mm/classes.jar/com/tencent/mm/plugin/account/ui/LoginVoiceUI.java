package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public class LoginVoiceUI
  extends LoginHistoryUI
{
  protected final void bpf()
  {
    int j = -1;
    AppMethodBeat.i(128253);
    super.bpf();
    bpg();
    final com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.klt.account, this.kly, "", 0);
    localt.PA(this.kly);
    int i;
    String str;
    if (this.kly == null)
    {
      i = -1;
      str = Util.secPrint(this.kly);
      if (this.klt.kdq != null) {
        break label173;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Util.secPrint(this.klt.kdq) });
      getString(2131755998);
      this.gtM = h.a(this, getString(2131762532), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128251);
          com.tencent.mm.kernel.g.azz().a(localt);
          LoginVoiceUI.this.bph();
          AppMethodBeat.o(128251);
        }
      });
      com.tencent.mm.kernel.g.azz().a(localt, 0);
      AppMethodBeat.o(128253);
      return;
      i = this.kly.length();
      break;
      label173:
      j = this.klt.kdq.length();
    }
  }
  
  public final boolean bpi()
  {
    return false;
  }
  
  public void initView()
  {
    AppMethodBeat.i(196875);
    super.initView();
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_errType", 0);
      int j = getIntent().getIntExtra("key_errCode", 0);
      Object localObject = getIntent().getStringExtra("key_errMsg");
      Log.i("MicroMsg.LoginVoiceUI", "initView,errType %d,errCode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (a.dK(i, j))
      {
        localObject = com.tencent.mm.h.a.Dk((String)localObject);
        if (localObject != null) {
          ((com.tencent.mm.h.a)localObject).a(this, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
          });
        }
      }
    }
    AppMethodBeat.o(196875);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128252);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    if (this.kmm)
    {
      AppMethodBeat.o(128252);
      return;
    }
    this.loginType = 1;
    this.kmg.setVisibility(0);
    this.klP.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.klO.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.klO.setLayoutParams(paramBundle);
    findViewById(2131309943).setEnabled(false);
    ((TextView)findViewById(2131309951)).setTextColor(getResources().getColorStateList(2131101430));
    ((TextView)findViewById(2131309951)).setBackgroundResource(getResources().getColor(2131101287));
    this.klP.setOnClickListener(new LoginVoiceUI.1(this));
    AppMethodBeat.o(128252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginVoiceUI
 * JD-Core Version:    0.7.0.1
 */