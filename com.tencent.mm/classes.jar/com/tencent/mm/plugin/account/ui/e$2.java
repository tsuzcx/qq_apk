package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

final class e$2
  implements n.d
{
  e$2(Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      com.tencent.mm.plugin.b.a.qj("F100_100_QQ");
      paramMenuItem = new StringBuilder();
      g.DN();
      paramMenuItem = paramMenuItem.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("F100_100_QQ") + ",1");
      e.M(this.val$context, this.val$context.getString(q.j.url_getqqpassword));
      return;
    case 4: 
      Context localContext = this.val$context;
      String str2 = this.flZ;
      String str1 = this.fma;
      String str3 = this.fmb;
      com.tencent.mm.plugin.b.a.qj("F100_100_phone");
      paramMenuItem = new StringBuilder();
      g.DN();
      paramMenuItem = paramMenuItem.append(com.tencent.mm.kernel.a.Df()).append(",").append(localContext.getClass().getName()).append(",F100_100_phone,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("F100_100_phone") + ",1");
      if (d.spd)
      {
        Toast.makeText(localContext, localContext.getString(q.j.alpha_version_tip_login), 0).show();
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
      localContext.startActivity(localIntent);
      return;
    case 2: 
      com.tencent.mm.plugin.b.a.qj("F100_100_Email");
      paramMenuItem = new StringBuilder();
      g.DN();
      paramMenuItem = paramMenuItem.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_Email,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("F100_100_Email") + ",1");
      e.M(this.val$context, this.val$context.getString(q.j.login_forget_password_help) + x.cqJ());
      return;
    }
    paramMenuItem = this.val$context.getString(q.j.wechat_securiy_center_path);
    if (x.cqJ().equals("zh_CN")) {}
    for (paramMenuItem = paramMenuItem + "zh_CN";; paramMenuItem = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=")
    {
      e.M(this.val$context, paramMenuItem);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.e.2
 * JD-Core Version:    0.7.0.1
 */