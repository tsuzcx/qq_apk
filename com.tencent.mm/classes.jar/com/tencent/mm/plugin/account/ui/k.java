package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.s;

public final class k
  implements i, MobileInputUI.b
{
  protected String jaS = null;
  protected String mTn = "";
  protected int mTo = 2;
  private MobileInputUI nfd;
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128290);
    switch (2.nfi[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128290);
      return;
      this.nfd.nfG = PhoneFormater.countryCodeWithPlus(this.nfd.countryCode);
      this.nfd.nfH = this.nfd.nft.getText().toString();
      parama = this.nfd.nfG + this.nfd.nfH;
      if (this.nfd.mUN != null)
      {
        Log.d("MicroMsg.MobileInputRegLogic", "already checking ");
        AppMethodBeat.o(128290);
        return;
      }
      MobileInputUI localMobileInputUI1 = this.nfd;
      MobileInputUI localMobileInputUI2 = this.nfd;
      this.nfd.getString(r.j.app_tip);
      localMobileInputUI1.mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI2, this.nfd.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new z(parama, 1, "", 0, "");
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128287);
    this.nfd = paramMobileInputUI;
    paramMobileInputUI.nfu.requestFocus();
    paramMobileInputUI.showVKB();
    this.jaS = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.mTn = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.mTo = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    String str2 = paramMobileInputUI.getString(r.j.regbymoile_reg_title);
    String str1;
    if (!d.RAG)
    {
      str1 = str2;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      str1 = str2 + com.tencent.mm.cj.h.kv(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.mSs.setVisibility(0);
    paramMobileInputUI.nft.setVisibility(0);
    paramMobileInputUI.nfu.requestFocus();
    paramMobileInputUI.nfw.setVisibility(0);
    paramMobileInputUI.nfz.setVisibility(0);
    paramMobileInputUI.nfz.setText(r.j.loginby_new_mobile_reg_ok);
    AppMethodBeat.o(128287);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128291);
    Log.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.nfd.mUN != null)
    {
      this.nfd.mUN.dismiss();
      this.nfd.mUN = null;
    }
    if (paramq.getType() == 132)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((z)paramq).ZB() == 1)
        {
          paramq = new Intent();
          paramq.putExtra("bindmcontact_mobile", this.nfd.nfG + " " + this.nfd.nft.getText().toString());
          paramq.putExtra("bindmcontact_shortmobile", this.nfd.nft.getText().toString());
          paramq.putExtra("country_name", this.nfd.lSz);
          paramq.putExtra("couttry_code", this.nfd.countryCode);
          paramq.putExtra("mobile_verify_purpose", 4);
          paramq.putExtra("regsetinfo_ticket", this.jaS);
          paramq.putExtra("regsetinfo_NextStep", this.mTn);
          paramq.putExtra("regsetinfo_NextStyle", this.mTo);
          paramq.setClass(this.nfd, MobileVerifyUI.class);
          paramString = this.nfd;
          paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramq.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.nfd.finish();
        }
        AppMethodBeat.o(128291);
        return;
      }
      if (com.tencent.mm.plugin.account.sdk.a.mIH.a(this.nfd, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128291);
        return;
      }
      Toast.makeText(this.nfd, this.nfd.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128291);
      return;
    }
    AppMethodBeat.o(128291);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128288);
    com.tencent.mm.kernel.h.aGY().a(132, this);
    AppMethodBeat.o(128288);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128289);
    com.tencent.mm.kernel.h.aGY().b(132, this);
    AppMethodBeat.o(128289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */