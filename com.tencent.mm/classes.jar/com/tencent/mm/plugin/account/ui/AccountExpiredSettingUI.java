package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/account/ui/AccountExpiredSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-account_release"})
public final class AccountExpiredSettingUI
  extends MMActivity
{
  final String TAG = "MicroMsg.AccountExpiredSettingUI";
  
  public final int getLayoutId()
  {
    return r.g.account_expired_setting_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(219534);
    super.onCreate(paramBundle);
    setMMTitle(r.j.account_expired_hint);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(r.f.ok_btn).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(219534);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(AccountExpiredSettingUI paramAccountExpiredSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(213980);
      this.nbB.finish();
      AppMethodBeat.o(213980);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(AccountExpiredSettingUI paramAccountExpiredSettingUI) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(218982);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/AccountExpiredSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = new aa.f();
      localObject = this.nbB.findViewById(r.f.account_expired_setting_errcode);
      p.j(localObject, "findViewById<MMEditText>…_expired_setting_errcode)");
      paramView.aaBC = ((MMEditText)localObject).getText().toString();
      localObject = new aa.f();
      View localView = this.nbB.findViewById(r.f.account_expired_setting_errmsg);
      p.j(localView, "findViewById<MMEditText>…t_expired_setting_errmsg)");
      ((aa.f)localObject).aaBC = ((MMEditText)localView).getText().toString();
      d.a(10000L, (kotlin.g.a.a)new q((aa.f)localObject) {});
      localObject = (CharSequence)((aa.f)localObject).aaBC;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0)
        {
          paramView = (CharSequence)paramView.aaBC;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label234;
          }
        }
      }
      label234:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          Toast.makeText((Context)this.nbB, r.j.app_modify_success, 0).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/AccountExpiredSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(218982);
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.AccountExpiredSettingUI
 * JD-Core Version:    0.7.0.1
 */