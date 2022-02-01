package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String kan;
  private String kao;
  private String name;
  private ProgressDialog osY;
  private boolean pOc = false;
  private String pOd;
  private boolean pOe = false;
  private boolean pOf = false;
  private boolean pOg = false;
  private Bundle pOh;
  private boolean pOi = false;
  private boolean pOj = false;
  private TextView pOk;
  private TextView pOl;
  private View pOm;
  private MMSwitchBtn pOn;
  private TextView pOo;
  private TextView pOp;
  private TextView pOq;
  private String pOr;
  private String pOs;
  private String pOt;
  private String pOu;
  private int status;
  
  private boolean A(Intent paramIntent)
  {
    AppMethodBeat.i(109842);
    Object localObject = paramIntent.getBundleExtra("result_data");
    paramIntent = ((Bundle)localObject).getString("ret");
    String str1 = ((Bundle)localObject).getString("limid");
    String str2 = ((Bundle)localObject).getString("liname");
    String str3 = ((Bundle)localObject).getString("liurl");
    localObject = ((Bundle)localObject).getString("liswitch");
    if (Util.isNullOrNil(paramIntent))
    {
      Log.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
      AppMethodBeat.o(109842);
      return false;
    }
    int i = Util.safeParseInt(paramIntent);
    if (i != 0)
    {
      Log.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[] { Integer.valueOf(i) });
      if (i == 1) {}
      for (i = a.i.contact_info_linkedin_err_bound;; i = a.i.contact_info_linkedin_err_bind_failed)
      {
        k.c(this, getString(i), null, true);
        AppMethodBeat.o(109842);
        return false;
      }
    }
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
      AppMethodBeat.o(109842);
      return false;
    }
    Log.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[] { str1, str2, str3, localObject });
    com.tencent.mm.kernel.h.baE().ban().B(286722, str2);
    com.tencent.mm.kernel.h.baE().ban().B(286721, str1);
    com.tencent.mm.kernel.h.baE().ban().B(286723, str3);
    if (!Util.isNullOrNil((String)localObject)) {
      if (Util.safeParseInt((String)localObject) != 1) {
        break label295;
      }
    }
    label295:
    for (boolean bool = true;; bool = false)
    {
      x(bool, false);
      aNi();
      updateView();
      paramIntent = getString(a.i.contact_info_linkedin_bind_ok);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      k.cZ(this, paramIntent);
      AppMethodBeat.o(109842);
      return true;
    }
  }
  
  private void SK(String paramString)
  {
    AppMethodBeat.i(109837);
    int i = getString(a.i.contact_info_linkedin_account_info_binded).indexOf("%s");
    Object localObject = getString(a.i.contact_info_linkedin_account_info_binded, new Object[] { paramString });
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    ((Spannable)localObject).setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView) {}
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        AppMethodBeat.i(109827);
        paramAnonymousTextPaint.setColor(BindLinkedInUI.this.getResources().getColor(a.b.link_color));
        paramAnonymousTextPaint.setUnderlineText(false);
        AppMethodBeat.o(109827);
      }
    }, i, paramString.length() + i, 33);
    this.pOk.setText((CharSequence)localObject);
    AppMethodBeat.o(109837);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(109839);
    this.pOq.setVisibility(8);
    if (paramBoolean1)
    {
      this.pOl.setVisibility(8);
      this.pOk.setVisibility(0);
      SK(paramString);
      this.pOm.setVisibility(0);
      this.pOo.setVisibility(8);
      if (paramBoolean2) {
        this.pOp.setVisibility(0);
      }
      this.pOn.setCheck(paramBoolean3);
      this.pOn.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(109817);
          BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, true);
          AppMethodBeat.o(109817);
        }
      });
      AppMethodBeat.o(109839);
      return;
    }
    this.pOk.setVisibility(8);
    this.pOk.setText(getString(a.i.contact_info_linkedin_account_info_unbind));
    this.pOl.setVisibility(0);
    this.pOm.setVisibility(8);
    this.pOo.setVisibility(0);
    this.pOp.setVisibility(8);
    AppMethodBeat.o(109839);
  }
  
  private void aNi()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109833);
    this.pOd = ((String)com.tencent.mm.kernel.h.baE().ban().d(286721, null));
    if (!Util.isNullOrNil(this.pOd))
    {
      bool1 = true;
      this.pOc = bool1;
      this.name = ((String)com.tencent.mm.kernel.h.baE().ban().d(286722, null));
      this.status = z.bAQ();
      if ((this.status & 0x400000) == 0) {
        break label100;
      }
    }
    label100:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.pOe = bool1;
      AppMethodBeat.o(109833);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void d(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(109838);
    this.pOk.setVisibility(0);
    SK(paramString);
    this.pOm.setVisibility(0);
    this.pOp.setVisibility(8);
    if (paramBoolean1)
    {
      this.pOl.setVisibility(8);
      this.pOo.setVisibility(8);
      this.pOq.setVisibility(8);
      this.pOn.setCheck(paramBoolean2);
      this.pOn.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(109828);
          BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, true);
          AppMethodBeat.o(109828);
        }
      });
      AppMethodBeat.o(109838);
      return;
    }
    this.pOl.setVisibility(0);
    this.pOo.setVisibility(0);
    this.pOq.setVisibility(0);
    this.pOn.setCheck(paramBoolean2);
    this.pOn.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109816);
        BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, false);
        AppMethodBeat.o(109816);
      }
    });
    AppMethodBeat.o(109838);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(109835);
    if (this.pOf)
    {
      if (this.pOj)
      {
        Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
        ((Intent)localObject).addFlags(603979776);
        ((Intent)localObject).putExtra("preferred_tab", 2);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109835);
        return;
      }
      setResult(-1);
      finish();
      AppMethodBeat.o(109835);
      return;
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(109835);
  }
  
  private void hJ(boolean paramBoolean)
  {
    AppMethodBeat.i(109836);
    if (this.pOh == null)
    {
      Log.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      AppMethodBeat.o(109836);
      return;
    }
    if (this.pOn.afTT) {}
    for (int i = 1;; i = 2)
    {
      final com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.kan, this.kao, "", this.pOr, this.pOs, this.pOt, this.pOu);
      if (!paramBoolean) {
        this.osY = k.a(this, getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109826);
            com.tencent.mm.kernel.h.aZW().a(locala);
            AppMethodBeat.o(109826);
          }
        });
      }
      com.tencent.mm.kernel.h.aZW().a(locala, 0);
      AppMethodBeat.o(109836);
      return;
    }
  }
  
  private void updateView()
  {
    boolean bool = true;
    AppMethodBeat.i(109840);
    if ((this.pOf) && (this.pOh == null))
    {
      Log.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      AppMethodBeat.o(109840);
      return;
    }
    if (this.pOg)
    {
      a(this.pOc, false, this.name, this.pOe);
      AppMethodBeat.o(109840);
      return;
    }
    if (this.pOf)
    {
      if ((this.pOc) && (this.pOd.equals(this.kan))) {}
      for (;;)
      {
        d(bool, this.kao, this.pOe);
        AppMethodBeat.o(109840);
        return;
        bool = false;
      }
    }
    a(this.pOc, true, this.name, this.pOe);
    AppMethodBeat.o(109840);
  }
  
  private void x(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109841);
    if (paramBoolean1)
    {
      this.status |= 0x400000;
      if (!paramBoolean1) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.kernel.h.baE().ban().B(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        cas localcas = new cas();
        localcas.aajJ = 33;
        localcas.NkL = i;
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, localcas));
        com.tencent.mm.plugin.account.sdk.a.pFo.aDx();
      }
      AppMethodBeat.o(109841);
      return;
      this.status &= 0xFFBFFFFF;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return a.f.bindlinkedin;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109834);
    if (this.pOf) {
      setMMTitle(a.i.contact_info_linkedin_qrcode_title);
    }
    for (;;)
    {
      this.pOk = ((TextView)findViewById(a.e.setting_bind_linkedin_account));
      this.pOl = ((TextView)findViewById(a.e.setting_bind_linkedin_brief));
      this.pOm = findViewById(a.e.show_name_option);
      this.pOn = ((MMSwitchBtn)findViewById(a.e.show_name_checkbox));
      this.pOo = ((TextView)findViewById(a.e.bind_linkedin_btn));
      this.pOp = ((TextView)findViewById(a.e.unbind_linkedin_btn));
      this.pOq = ((TextView)findViewById(a.e.cancel_bind_linkedin_btn));
      this.pOk.setOnClickListener(new BindLinkedInUI.6(this));
      this.pOo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109820);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!BindLinkedInUI.b(BindLinkedInUI.this)) {
            BindLinkedInUI.c(BindLinkedInUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109820);
            return;
            if (!BindLinkedInUI.d(BindLinkedInUI.this)) {
              BindLinkedInUI.e(BindLinkedInUI.this);
            } else {
              k.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(a.i.contact_info_linkedin_account_overwrite_binded_account), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(109819);
                  BindLinkedInUI.e(BindLinkedInUI.this);
                  AppMethodBeat.o(109819);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
          }
        }
      });
      this.pOp.setOnClickListener(new BindLinkedInUI.8(this));
      this.pOq.setOnClickListener(new BindLinkedInUI.9(this));
      setBackBtn(new BindLinkedInUI.10(this));
      updateView();
      AppMethodBeat.o(109834);
      return;
      if (this.pOg) {
        setMMTitle(a.i.contact_info_linkedin_title);
      } else {
        setMMTitle(a.i.contact_info_linkedin_bind_info);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109843);
    Log.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if (paramIntent == null)
    {
      AppMethodBeat.o(109843);
      return;
    }
    switch (paramInt1)
    {
    default: 
      Log.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
      AppMethodBeat.o(109843);
      return;
    }
    A(paramIntent);
    AppMethodBeat.o(109843);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109829);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(549, this);
    com.tencent.mm.kernel.h.aZW().a(550, this);
    this.pOh = getIntent().getBundleExtra("qrcode_bundle");
    if (this.pOh != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.pOf = bool;
      if (this.pOh != null)
      {
        this.kan = this.pOh.getString("i");
        this.kao = this.pOh.getString("n");
        this.pOr = this.pOh.getString("t");
        this.pOs = this.pOh.getString("o");
        this.pOt = this.pOh.getString("s");
        this.pOu = this.pOh.getString("r");
        if ((this.kan == null) || (this.kao == null) || (this.pOr == null) || (this.pOt == null) || (this.pOu == null)) {
          k.a(this, getString(a.i.contact_info_linkedin_account_params_error), null, false, new BindLinkedInUI.1(this));
        }
      }
      this.pOg = getIntent().getBooleanExtra("oversea_entry", false);
      aNi();
      if (this.pOf) {
        this.pOe = true;
      }
      initView();
      if ((this.pOh != null) && (this.pOc) && (this.pOd.equals(this.kan)))
      {
        this.pOi = true;
        hJ(true);
      }
      AppMethodBeat.o(109829);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109830);
    com.tencent.mm.kernel.h.aZW().b(550, this);
    com.tencent.mm.kernel.h.aZW().b(549, this);
    super.onDestroy();
    AppMethodBeat.o(109830);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109845);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(109845);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109845);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109832);
    super.onPause();
    AppMethodBeat.o(109832);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109831);
    super.onResume();
    AppMethodBeat.o(109831);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(109844);
    if (this.osY != null)
    {
      this.osY.dismiss();
      this.osY = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramp.getType() == 549) {
        if (paramInt2 == 1) {
          paramInt1 = a.i.contact_info_linkedin_err_bound;
        }
      }
      for (;;)
      {
        k.c(this, getString(paramInt1), null, true);
        AppMethodBeat.o(109844);
        return;
        paramInt1 = a.i.contact_info_linkedin_err_bind_failed;
        continue;
        if (paramp.getType() != 550) {
          break;
        }
        paramInt1 = a.i.contact_info_linkedin_err_unbind_failed;
      }
      AppMethodBeat.o(109844);
      return;
    }
    if (paramp.getType() == 549)
    {
      this.pOj = true;
      if (!this.pOi) {
        paramInt1 = a.i.contact_info_linkedin_bind_ok;
      }
    }
    for (;;)
    {
      paramString = getString(paramInt1);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      k.cZ(this, paramString);
      aNi();
      this.pOe = this.pOn.afTT;
      updateView();
      AppMethodBeat.o(109844);
      return;
      paramInt1 = a.i.contact_info_linkedin_bind_update_ok;
      continue;
      if (paramp.getType() != 550) {
        break;
      }
      paramInt1 = a.i.contact_info_linkedin_unbind_ok;
    }
    AppMethodBeat.o(109844);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI
 * JD-Core Version:    0.7.0.1
 */