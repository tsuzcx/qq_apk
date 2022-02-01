package com.tencent.mm.plugin.account.bind.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.a.a;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class BindMobilePolicyUI
  extends BindMContactIntroUI
  implements com.tencent.mm.am.h
{
  private Map<String, String> pPl;
  
  protected final void bWj()
  {
    AppMethodBeat.i(304882);
    hideVKB();
    if ((this.pOK == 9) && (this.pOG != i.a.pSQ))
    {
      g.a locala = new g.a(getContext());
      locala.bDE((String)this.pPl.get(".sysmsg.BindPhoneGuidance.doublecheck_content")).bDJ((String)this.pPl.get(".sysmsg.BindPhoneGuidance.doublecheck_cancel")).bDI((String)this.pPl.get(".sysmsg.BindPhoneGuidance.doublecheck_ok")).NF(true);
      locala.c(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(304891);
          if (!paramAnonymousBoolean)
          {
            paramAnonymousString = new com.tencent.mm.plugin.account.bind.a.c(3, (String)com.tencent.mm.kernel.h.baE().ban().d(274436, null));
            com.tencent.mm.kernel.h.aZW().a(paramAnonymousString, 0);
            BindMobilePolicyUI.b(BindMobilePolicyUI.this);
          }
          AppMethodBeat.o(304891);
        }
      }).show();
      AppMethodBeat.o(304882);
      return;
    }
    super.bWj();
    AppMethodBeat.o(304882);
  }
  
  public void finish()
  {
    AppMethodBeat.i(304878);
    super.finish();
    overridePendingTransition(a.a.anim_not_change, a.a.push_down_out);
    com.tencent.mm.plugin.account.friend.model.w.pTm = 0;
    AppMethodBeat.o(304878);
  }
  
  public int getLayoutId()
  {
    return a.f.bindmcontact_intro;
  }
  
  public void initView()
  {
    AppMethodBeat.i(304880);
    this.pPl = XmlParser.parseXml(getIntent().getStringExtra("key_wording_cfg"), "sysmsg", null);
    Log.i("MicroMsg.BindMobilePolicyUI", "wording:%s", new Object[] { this.pPl });
    Object localObject = i.bWW();
    if ((localObject == i.a.pSO) || (localObject == i.a.pSP)) {
      i.bWX();
    }
    super.initView();
    if ((this.pPl != null) && ("yes".equals(this.pPl.get(".sysmsg.BindPhoneGuidance.canUseBankAuthInstead"))))
    {
      localObject = (TextView)findViewById(a.e.setting_bind_mobile_help_tips);
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(304895);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobilePolicyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new g.a(BindMobilePolicyUI.this.getContext());
          paramAnonymousView.bDE(BindMobilePolicyUI.this.getString(a.i.bind_mcontact_goto_realname_process_alert_msg)).aEX(a.i.bind_mcontact_goto_realname_process_alert_ok).NF(true);
          paramAnonymousView.c(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(304874);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2String = BindMobilePolicyUI.this.getContext().getComponentName().getClassName();
                String str = MMApplicationContext.getSourcePackageName() + ".plugin.account";
                if (!paramAnonymous2String.startsWith(str)) {
                  break label97;
                }
                paramAnonymous2String = paramAnonymous2String.substring(str.length());
              }
              label97:
              for (;;)
              {
                ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wxpaysdk.api.c.class)).f(BindMobilePolicyUI.this.getContext(), paramAnonymous2String, "account");
                AppMethodBeat.o(304874);
                return;
              }
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobilePolicyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(304895);
        }
      });
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      if ((this.pPl != null) && (this.pOB != null) && ("yes".equalsIgnoreCase((String)this.pPl.get(".sysmsg.BindPhoneGuidance.guidanceHideIcon")))) {
        this.pOB.setVisibility(8);
      }
      AppMethodBeat.o(304880);
      return;
      if ((this.pPl != null) && (this.pPl.get(".sysmsg.BindPhoneGuidance.guidanceHelp") != null))
      {
        localObject = (TextView)findViewById(a.e.setting_bind_mobile_help_tips);
        ((TextView)localObject).setText((CharSequence)this.pPl.get(".sysmsg.BindPhoneGuidance.guidanceHelp.tips"));
        ((TextView)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(304894);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobilePolicyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", (String)BindMobilePolicyUI.a(BindMobilePolicyUI.this).get(".sysmsg.BindPhoneGuidance.guidanceHelp.jumpUrl"));
            paramAnonymousView.putExtra("showShare", false);
            paramAnonymousView.putExtra("show_bottom", false);
            paramAnonymousView.putExtra("needRedirect", false);
            paramAnonymousView.putExtra("neverGetA8Key", true);
            paramAnonymousView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
            paramAnonymousView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
            com.tencent.mm.br.c.b(BindMobilePolicyUI.this.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView, 100);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobilePolicyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(304894);
          }
        });
        ((TextView)localObject).setVisibility(0);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(304883);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramIntent != null))
    {
      paramIntent = (Map)paramIntent.getBundleExtra("result_data").getSerializable("next_params");
      if ((paramIntent != null) && ("continue_bind_mobile".equalsIgnoreCase((String)paramIntent.get("next_step")))) {
        bWk();
      }
    }
    AppMethodBeat.o(304883);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(304877);
    super.onCreate(paramBundle);
    setMMTitle("");
    overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    com.tencent.mm.plugin.account.friend.model.w.pTm = 1;
    AppMethodBeat.o(304877);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(304879);
    overridePendingTransition(a.a.anim_not_change, a.a.push_down_out);
    com.tencent.mm.plugin.account.friend.model.w.pTm = 0;
    super.onDestroy();
    AppMethodBeat.o(304879);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateView()
  {
    AppMethodBeat.i(304881);
    if (this.pOG == i.a.pSO)
    {
      showOptionMenu(1, false);
      this.pOB.setImageResource(a.h.mobile_unbind_icon);
      this.pOD.setVisibility(0);
      this.pOF.setVisibility(8);
      TextView localTextView = this.pOC;
      if (this.pPl != null)
      {
        localObject = (CharSequence)this.pPl.get(".sysmsg.BindPhoneGuidance.guidanceTitle");
        localTextView.setText((CharSequence)localObject);
        localTextView = this.pOD;
        if (this.pPl == null) {
          break label143;
        }
      }
      label143:
      for (Object localObject = (CharSequence)this.pPl.get(".sysmsg.BindPhoneGuidance.guidanceTip");; localObject = getString(a.i.bind_mcontact_hint))
      {
        localTextView.setText((CharSequence)localObject);
        this.pOE.setText(a.i.bind_mcontact_bind_btn_text);
        AppMethodBeat.o(304881);
        return;
        localObject = getString(a.i.bind_mcontact_hint_title);
        break;
      }
    }
    super.updateView();
    AppMethodBeat.o(304881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobilePolicyUI
 * JD-Core Version:    0.7.0.1
 */