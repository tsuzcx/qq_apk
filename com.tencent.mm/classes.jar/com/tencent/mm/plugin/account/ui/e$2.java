package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.n.d;

final class e$2
  implements n.d
{
  e$2(Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(128019);
    switch (paramMenuItem.getItemId())
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(128019);
      return;
    case 1: 
      com.tencent.mm.plugin.b.a.aUz("F100_100_QQ");
      paramMenuItem = new StringBuilder();
      g.afz();
      paramMenuItem = paramMenuItem.append(com.tencent.mm.kernel.a.aeM()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_QQ,");
      g.afz();
      com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F100_100_QQ") + ",1");
      e.P(this.val$context, this.val$context.getString(2131764602));
      AppMethodBeat.o(128019);
      return;
    case 4: 
      Context localContext = this.val$context;
      String str2 = this.iqN;
      String str1 = this.iqO;
      String str3 = this.iqP;
      com.tencent.mm.plugin.b.a.aUz("F100_100_phone");
      paramMenuItem = new StringBuilder();
      g.afz();
      paramMenuItem = paramMenuItem.append(com.tencent.mm.kernel.a.aeM()).append(",").append(localContext.getClass().getName()).append(",F100_100_phone,");
      g.afz();
      com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F100_100_phone") + ",1");
      if (d.CpN)
      {
        Toast.makeText(localContext, localContext.getString(2131755265), 0).show();
        AppMethodBeat.o(128019);
        return;
      }
      Intent localIntent = new Intent(localContext, MobileInputUI.class);
      if (str1 != null)
      {
        paramInt = str1.indexOf("+");
        paramMenuItem = str1;
        if (paramInt != -1)
        {
          paramMenuItem = str1;
          if (str1.length() > 0) {
            paramMenuItem = str1.substring(paramInt + 1);
          }
        }
        localIntent.putExtra("couttry_code", paramMenuItem);
      }
      if (str2 != null) {
        localIntent.putExtra("country_name", str2);
      }
      if (str3 != null) {
        localIntent.putExtra("bindmcontact_shortmobile", str3);
      }
      localIntent.putExtra("mobile_input_purpose", 1);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, paramMenuItem.adn(), "com/tencent/mm/plugin/account/ui/ForgotPwdMenu", "loginBySMS", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)paramMenuItem.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/account/ui/ForgotPwdMenu", "loginBySMS", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128019);
      return;
    case 2: 
      com.tencent.mm.plugin.b.a.aUz("F100_100_Email");
      paramMenuItem = new StringBuilder();
      g.afz();
      paramMenuItem = paramMenuItem.append(com.tencent.mm.kernel.a.aeM()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_Email,");
      g.afz();
      com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F100_100_Email") + ",1");
      e.P(this.val$context, this.val$context.getString(2131760769) + ac.eFu());
      AppMethodBeat.o(128019);
      return;
    }
    paramMenuItem = this.val$context.getString(2131766193);
    if (ac.eFu().equals("zh_CN")) {}
    for (paramMenuItem = paramMenuItem + "zh_CN";; paramMenuItem = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=")
    {
      e.P(this.val$context, paramMenuItem);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.e.2
 * JD-Core Version:    0.7.0.1
 */