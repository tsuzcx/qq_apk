package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;

public final class e
{
  static void S(final Context paramContext, int paramInt)
  {
    AppMethodBeat.i(304998);
    l locall = new l(paramContext);
    locall.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(128018);
        if ((this.qal & 0x1) != 0) {
          paramAnonymouss.c(1, paramContext.getString(r.j.reg_forgetpwd_byqq));
        }
        if ((this.qal & 0x2) != 0) {
          paramAnonymouss.c(2, paramContext.getString(r.j.reg_forgetpwd_weixin));
        }
        if ((this.qal & 0x4) != 0) {
          paramAnonymouss.c(4, paramContext.getString(r.j.reg_forgetpwd_bymobile));
        }
        if ((this.qal & 0x8) > 0) {
          paramAnonymouss.c(8, paramContext.getString(r.j.wechat_safe_center));
        }
        AppMethodBeat.o(128018);
      }
    };
    locall.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(128019);
        switch (paramAnonymousMenuItem.getItemId())
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(128019);
          return;
        case 1: 
          com.tencent.mm.plugin.b.a.TA("F100_100_QQ");
          paramAnonymousMenuItem = new StringBuilder();
          h.baC();
          paramAnonymousMenuItem = paramAnonymousMenuItem.append(b.aZR()).append(",").append(e.this.getClass().getName()).append(",F100_100_QQ,");
          h.baC();
          com.tencent.mm.plugin.b.a.z(true, b.Fw("F100_100_QQ") + ",1");
          e.W(e.this, e.this.getString(r.j.url_getqqpassword));
          AppMethodBeat.o(128019);
          return;
        case 4: 
          Context localContext = e.this;
          String str2 = this.qam;
          String str1 = this.qan;
          String str3 = this.qao;
          com.tencent.mm.plugin.b.a.TA("F100_100_phone");
          paramAnonymousMenuItem = new StringBuilder();
          h.baC();
          paramAnonymousMenuItem = paramAnonymousMenuItem.append(b.aZR()).append(",").append(localContext.getClass().getName()).append(",F100_100_phone,");
          h.baC();
          com.tencent.mm.plugin.b.a.z(true, b.Fw("F100_100_phone") + ",1");
          if (d.Yxk)
          {
            Toast.makeText(localContext, localContext.getString(r.j.alpha_version_tip_login), 0).show();
            AppMethodBeat.o(128019);
            return;
          }
          Intent localIntent = new Intent(localContext, MobileInputUI.class);
          if (str1 != null)
          {
            paramAnonymousInt = str1.indexOf("+");
            paramAnonymousMenuItem = str1;
            if (paramAnonymousInt != -1)
            {
              paramAnonymousMenuItem = str1;
              if (str1.length() > 0) {
                paramAnonymousMenuItem = str1.substring(paramAnonymousInt + 1);
              }
            }
            localIntent.putExtra("couttry_code", paramAnonymousMenuItem);
          }
          if (str2 != null) {
            localIntent.putExtra("country_name", str2);
          }
          if (str3 != null) {
            localIntent.putExtra("bindmcontact_shortmobile", str3);
          }
          localIntent.putExtra("mobile_input_purpose", 1);
          paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramAnonymousMenuItem.aYi(), "com/tencent/mm/plugin/account/ui/ForgotPwdMenu", "loginBySMS", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramAnonymousMenuItem.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/account/ui/ForgotPwdMenu", "loginBySMS", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(128019);
          return;
        case 2: 
          com.tencent.mm.plugin.b.a.TA("F100_100_Email");
          paramAnonymousMenuItem = new StringBuilder();
          h.baC();
          paramAnonymousMenuItem = paramAnonymousMenuItem.append(b.aZR()).append(",").append(e.this.getClass().getName()).append(",F100_100_Email,");
          h.baC();
          com.tencent.mm.plugin.b.a.z(true, b.Fw("F100_100_Email") + ",1");
          e.W(e.this, e.this.getString(r.j.login_forget_password_help) + LocaleUtil.getApplicationLanguage());
          AppMethodBeat.o(128019);
          return;
        }
        paramAnonymousMenuItem = e.this.getString(r.j.wechat_securiy_center_path);
        if (LocaleUtil.getApplicationLanguage().equals("zh_CN")) {}
        for (paramAnonymousMenuItem = paramAnonymousMenuItem + "zh_CN";; paramAnonymousMenuItem = "https://" + WeChatHosts.domainString(r.j.host_help_wechat_com) + "/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=")
        {
          e.W(e.this, paramAnonymousMenuItem);
          break;
        }
      }
    };
    locall.jDd();
    AppMethodBeat.o(304998);
  }
  
  public static void W(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128020);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    localIntent.putExtra("KFromLoginHistory", false);
    c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.e
 * JD-Core Version:    0.7.0.1
 */