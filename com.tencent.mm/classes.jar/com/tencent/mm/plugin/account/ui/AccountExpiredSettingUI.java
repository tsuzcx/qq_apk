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
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/account/ui/AccountExpiredSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-account_release"})
public final class AccountExpiredSettingUI
  extends MMActivity
{
  final String TAG = "MicroMsg.AccountExpiredSettingUI";
  
  public final int getLayoutId()
  {
    return 2131492936;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196834);
    super.onCreate(paramBundle);
    setMMTitle(2131755136);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(2131305592).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(196834);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(AccountExpiredSettingUI paramAccountExpiredSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(196831);
      this.kjL.finish();
      AppMethodBeat.o(196831);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(AccountExpiredSettingUI paramAccountExpiredSettingUI) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(196833);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/AccountExpiredSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = new z.f();
      localObject = this.kjL.findViewById(2131296347);
      p.g(localObject, "findViewById<MMEditText>…_expired_setting_errcode)");
      paramView.SYG = ((MMEditText)localObject).getText().toString();
      localObject = new z.f();
      View localView = this.kjL.findViewById(2131296348);
      p.g(localView, "findViewById<MMEditText>…t_expired_setting_errmsg)");
      ((z.f)localObject).SYG = ((MMEditText)localView).getText().toString();
      d.a(10000L, (kotlin.g.a.a)new q((z.f)localObject) {});
      localObject = (CharSequence)((z.f)localObject).SYG;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0)
        {
          paramView = (CharSequence)paramView.SYG;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label231;
          }
        }
      }
      label231:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          Toast.makeText((Context)this.kjL, 2131755898, 0).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/AccountExpiredSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196833);
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.AccountExpiredSettingUI
 * JD-Core Version:    0.7.0.1
 */