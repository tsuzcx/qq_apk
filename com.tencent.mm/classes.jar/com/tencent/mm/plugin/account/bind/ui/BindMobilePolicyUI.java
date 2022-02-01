package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.bind.a.a;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.wxpaysdk.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class BindMobilePolicyUI
  extends BindMContactIntroUI
  implements i
{
  private Map<String, String> mSE;
  
  protected final void bxv()
  {
    AppMethodBeat.i(241450);
    hideVKB();
    if ((this.mSd == 9) && (this.mRZ != l.a.mWk))
    {
      f.a locala = new f.a(getContext());
      locala.bBl((String)this.mSE.get(".sysmsg.BindPhoneGuidance.doublecheck_content")).bBq((String)this.mSE.get(".sysmsg.BindPhoneGuidance.doublecheck_cancel")).bBp((String)this.mSE.get(".sysmsg.BindPhoneGuidance.doublecheck_ok")).HL(true);
      locala.c(new BindMobilePolicyUI.2(this)).show();
      AppMethodBeat.o(241450);
      return;
    }
    super.bxv();
    AppMethodBeat.o(241450);
  }
  
  public void finish()
  {
    AppMethodBeat.i(241441);
    super.finish();
    overridePendingTransition(a.a.anim_not_change, a.a.push_down_out);
    AppMethodBeat.o(241441);
  }
  
  public int getLayoutId()
  {
    return a.f.bindmcontact_intro;
  }
  
  public void initView()
  {
    AppMethodBeat.i(241445);
    this.mSE = XmlParser.parseXml(getIntent().getStringExtra("key_wording_cfg"), "sysmsg", null);
    Log.i("MicroMsg.BindMobilePolicyUI", "wording:%s", new Object[] { this.mSE });
    super.initView();
    if ((this.mSE != null) && ("yes".equals(this.mSE.get(".sysmsg.BindPhoneGuidance.canUseBankAuthInstead"))))
    {
      TextView localTextView = (TextView)findViewById(a.e.goto_realname_process);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(241656);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobilePolicyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new f.a(BindMobilePolicyUI.this.getContext());
          paramAnonymousView.bBl(BindMobilePolicyUI.this.getString(a.i.bind_mcontact_goto_realname_process_alert_msg)).ayp(a.i.bind_mcontact_goto_realname_process_alert_ok).HL(true);
          paramAnonymousView.c(new f.c()
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(241662);
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
                ((c)h.ae(c.class)).g(BindMobilePolicyUI.this.getContext(), paramAnonymous2String, "account");
                AppMethodBeat.o(241662);
                return;
              }
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobilePolicyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(241656);
        }
      });
      localTextView.setVisibility(0);
    }
    AppMethodBeat.o(241445);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(241440);
    super.onCreate(paramBundle);
    overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    AppMethodBeat.o(241440);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(241442);
    overridePendingTransition(a.a.anim_not_change, a.a.push_down_out);
    super.onDestroy();
    AppMethodBeat.o(241442);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateView()
  {
    AppMethodBeat.i(241447);
    if (this.mRZ == l.a.mWi)
    {
      showOptionMenu(1, false);
      this.mRU.setImageResource(a.h.mobile_unbind_icon);
      this.mRW.setVisibility(0);
      this.mRY.setVisibility(8);
      TextView localTextView = this.mRV;
      if (this.mSE != null)
      {
        str = (String)this.mSE.get(".sysmsg.BindPhoneGuidance.guidanceTitle");
        localTextView.setText(str);
        localTextView = this.mRW;
        if (this.mSE == null) {
          break label140;
        }
      }
      label140:
      for (String str = (String)this.mSE.get(".sysmsg.BindPhoneGuidance.guidanceTip");; str = getString(a.i.bind_mcontact_hint))
      {
        localTextView.setText(str);
        this.mRX.setText(a.i.bind_mcontact_bind_btn_text);
        AppMethodBeat.o(241447);
        return;
        str = getString(a.i.bind_mcontact_hint_title);
        break;
      }
    }
    super.updateView();
    AppMethodBeat.o(241447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobilePolicyUI
 * JD-Core Version:    0.7.0.1
 */