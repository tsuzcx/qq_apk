package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements i
{
  private String hDs;
  private String hDt;
  private ProgressDialog lBo;
  private Bundle mRA;
  private boolean mRB = false;
  private boolean mRC = false;
  private TextView mRD;
  private TextView mRE;
  private View mRF;
  private MMSwitchBtn mRG;
  private TextView mRH;
  private TextView mRI;
  private TextView mRJ;
  private String mRK;
  private String mRL;
  private String mRM;
  private String mRN;
  private boolean mRv = false;
  private String mRw;
  private boolean mRx = false;
  private boolean mRy = false;
  private boolean mRz = false;
  private String name;
  private int status;
  
  private void aaq(String paramString)
  {
    AppMethodBeat.i(109837);
    int i = getString(a.i.contact_info_linkedin_account_info_binded).indexOf("%s");
    Object localObject = getString(a.i.contact_info_linkedin_account_info_binded, new Object[] { paramString });
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    ((Spannable)localObject).setSpan(new BindLinkedInUI.12(this), i, paramString.length() + i, 33);
    this.mRD.setText((CharSequence)localObject);
    AppMethodBeat.o(109837);
  }
  
  private void ata()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109833);
    this.mRw = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(286721, null));
    if (!Util.isNullOrNil(this.mRw))
    {
      bool1 = true;
      this.mRv = bool1;
      this.name = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(286722, null));
      this.status = z.bdd();
      if ((this.status & 0x400000) == 0) {
        break label97;
      }
    }
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mRx = bool1;
      AppMethodBeat.o(109833);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(109839);
    this.mRJ.setVisibility(8);
    if (paramBoolean1)
    {
      this.mRE.setVisibility(8);
      this.mRD.setVisibility(0);
      aaq(paramString);
      this.mRF.setVisibility(0);
      this.mRH.setVisibility(8);
      if (paramBoolean2) {
        this.mRI.setVisibility(0);
      }
      this.mRG.setCheck(paramBoolean3);
      this.mRG.setSwitchListener(new MMSwitchBtn.a()
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
    this.mRD.setVisibility(8);
    this.mRD.setText(getString(a.i.contact_info_linkedin_account_info_unbind));
    this.mRE.setVisibility(0);
    this.mRF.setVisibility(8);
    this.mRH.setVisibility(0);
    this.mRI.setVisibility(8);
    AppMethodBeat.o(109839);
  }
  
  private void d(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(109838);
    this.mRD.setVisibility(0);
    aaq(paramString);
    this.mRF.setVisibility(0);
    this.mRI.setVisibility(8);
    if (paramBoolean1)
    {
      this.mRE.setVisibility(8);
      this.mRH.setVisibility(8);
      this.mRJ.setVisibility(8);
      this.mRG.setCheck(paramBoolean2);
      this.mRG.setSwitchListener(new MMSwitchBtn.a()
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
    this.mRE.setVisibility(0);
    this.mRH.setVisibility(0);
    this.mRJ.setVisibility(0);
    this.mRG.setCheck(paramBoolean2);
    this.mRG.setSwitchListener(new MMSwitchBtn.a()
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
  
  private void gT(boolean paramBoolean)
  {
    AppMethodBeat.i(109836);
    if (this.mRA == null)
    {
      Log.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      AppMethodBeat.o(109836);
      return;
    }
    if (this.mRG.YbZ) {}
    for (int i = 1;; i = 2)
    {
      final com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.hDs, this.hDt, "", this.mRK, this.mRL, this.mRM, this.mRN);
      if (!paramBoolean) {
        this.lBo = com.tencent.mm.ui.base.h.a(this, getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(109826);
            com.tencent.mm.kernel.h.aGY().a(locala);
            AppMethodBeat.o(109826);
          }
        });
      }
      com.tencent.mm.kernel.h.aGY().a(locala, 0);
      AppMethodBeat.o(109836);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(109835);
    if (this.mRy)
    {
      if (this.mRC)
      {
        Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
        ((Intent)localObject).addFlags(603979776);
        ((Intent)localObject).putExtra("preferred_tab", 2);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
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
  
  private void s(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109841);
    if (paramBoolean1)
    {
      this.status |= 0x400000;
      if (!paramBoolean1) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.kernel.h.aHG().aHp().i(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        bmy localbmy = new bmy();
        localbmy.SXP = 33;
        localbmy.HmX = i;
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(23, localbmy));
        com.tencent.mm.plugin.account.sdk.a.mIH.abC();
      }
      AppMethodBeat.o(109841);
      return;
      this.status &= 0xFFBFFFFF;
      break;
    }
  }
  
  private void updateView()
  {
    boolean bool = true;
    AppMethodBeat.i(109840);
    if ((this.mRy) && (this.mRA == null))
    {
      Log.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      AppMethodBeat.o(109840);
      return;
    }
    if (this.mRz)
    {
      b(this.mRv, false, this.name, this.mRx);
      AppMethodBeat.o(109840);
      return;
    }
    if (this.mRy)
    {
      if ((this.mRv) && (this.mRw.equals(this.hDs))) {}
      for (;;)
      {
        d(bool, this.hDt, this.mRx);
        AppMethodBeat.o(109840);
        return;
        bool = false;
      }
    }
    b(this.mRv, true, this.name, this.mRx);
    AppMethodBeat.o(109840);
  }
  
  private boolean y(Intent paramIntent)
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
        com.tencent.mm.ui.base.h.c(this, getString(i), null, true);
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
    com.tencent.mm.kernel.h.aHG().aHp().i(286722, str2);
    com.tencent.mm.kernel.h.aHG().aHp().i(286721, str1);
    com.tencent.mm.kernel.h.aHG().aHp().i(286723, str3);
    if (!Util.isNullOrNil((String)localObject)) {
      if (Util.safeParseInt((String)localObject) != 1) {
        break label315;
      }
    }
    label315:
    for (boolean bool = true;; bool = false)
    {
      s(bool, false);
      ata();
      updateView();
      paramIntent = getString(a.i.contact_info_linkedin_bind_ok);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      com.tencent.mm.ui.base.h.cO(this, paramIntent);
      AppMethodBeat.o(109842);
      return true;
    }
  }
  
  public int getLayoutId()
  {
    return a.f.bindlinkedin;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109834);
    if (this.mRy) {
      setMMTitle(a.i.contact_info_linkedin_qrcode_title);
    }
    for (;;)
    {
      this.mRD = ((TextView)findViewById(a.e.setting_bind_linkedin_account));
      this.mRE = ((TextView)findViewById(a.e.setting_bind_linkedin_brief));
      this.mRF = findViewById(a.e.show_name_option);
      this.mRG = ((MMSwitchBtn)findViewById(a.e.show_name_checkbox));
      this.mRH = ((TextView)findViewById(a.e.bind_linkedin_btn));
      this.mRI = ((TextView)findViewById(a.e.unbind_linkedin_btn));
      this.mRJ = ((TextView)findViewById(a.e.cancel_bind_linkedin_btn));
      this.mRD.setOnClickListener(new BindLinkedInUI.6(this));
      this.mRH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109820);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindLinkedInUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
              com.tencent.mm.ui.base.h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(a.i.contact_info_linkedin_account_overwrite_binded_account), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      this.mRI.setOnClickListener(new BindLinkedInUI.8(this));
      this.mRJ.setOnClickListener(new BindLinkedInUI.9(this));
      setBackBtn(new BindLinkedInUI.10(this));
      updateView();
      AppMethodBeat.o(109834);
      return;
      if (this.mRz) {
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
    y(paramIntent);
    AppMethodBeat.o(109843);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109829);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(549, this);
    com.tencent.mm.kernel.h.aGY().a(550, this);
    this.mRA = getIntent().getBundleExtra("qrcode_bundle");
    if (this.mRA != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mRy = bool;
      if (this.mRA != null)
      {
        this.hDs = this.mRA.getString("i");
        this.hDt = this.mRA.getString("n");
        this.mRK = this.mRA.getString("t");
        this.mRL = this.mRA.getString("o");
        this.mRM = this.mRA.getString("s");
        this.mRN = this.mRA.getString("r");
        if ((this.hDs == null) || (this.hDt == null) || (this.mRK == null) || (this.mRM == null) || (this.mRN == null)) {
          com.tencent.mm.ui.base.h.a(this, getString(a.i.contact_info_linkedin_account_params_error), null, false, new BindLinkedInUI.1(this));
        }
      }
      this.mRz = getIntent().getBooleanExtra("oversea_entry", false);
      ata();
      if (this.mRy) {
        this.mRx = true;
      }
      initView();
      if ((this.mRA != null) && (this.mRv) && (this.mRw.equals(this.hDs)))
      {
        this.mRB = true;
        gT(true);
      }
      AppMethodBeat.o(109829);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109830);
    com.tencent.mm.kernel.h.aGY().b(550, this);
    com.tencent.mm.kernel.h.aGY().b(549, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(109844);
    if (this.lBo != null)
    {
      this.lBo.dismiss();
      this.lBo = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramq.getType() == 549) {
        if (paramInt2 == 1) {
          paramInt1 = a.i.contact_info_linkedin_err_bound;
        }
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.c(this, getString(paramInt1), null, true);
        AppMethodBeat.o(109844);
        return;
        paramInt1 = a.i.contact_info_linkedin_err_bind_failed;
        continue;
        if (paramq.getType() != 550) {
          break;
        }
        paramInt1 = a.i.contact_info_linkedin_err_unbind_failed;
      }
      AppMethodBeat.o(109844);
      return;
    }
    if (paramq.getType() == 549)
    {
      this.mRC = true;
      if (!this.mRB) {
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
      com.tencent.mm.ui.base.h.cO(this, paramString);
      ata();
      this.mRx = this.mRG.YbZ;
      updateView();
      AppMethodBeat.o(109844);
      return;
      paramInt1 = a.i.contact_info_linkedin_bind_update_ok;
      continue;
      if (paramq.getType() != 550) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI
 * JD-Core Version:    0.7.0.1
 */