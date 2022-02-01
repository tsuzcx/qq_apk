package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/ui/AccountExpiredSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-account_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AccountExpiredSettingUI
  extends MMActivity
{
  final String TAG = "MicroMsg.AccountExpiredSettingUI";
  
  private static final void a(final AccountExpiredSettingUI paramAccountExpiredSettingUI, final View paramView)
  {
    AppMethodBeat.i(305071);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramAccountExpiredSettingUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/AccountExpiredSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramAccountExpiredSettingUI, "this$0");
    paramView = new ah.f();
    paramView.aqH = ((MMEditText)paramAccountExpiredSettingUI.findViewById(r.f.account_expired_setting_errcode)).getText().toString();
    localObject = new ah.f();
    ((ah.f)localObject).aqH = ((MMEditText)paramAccountExpiredSettingUI.findViewById(r.f.account_expired_setting_errmsg)).getText().toString();
    d.a(10000L, (kotlin.g.a.a)new a((ah.f)localObject, paramView, paramAccountExpiredSettingUI));
    localObject = (CharSequence)((ah.f)localObject).aqH;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramView = (CharSequence)paramView.aqH;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label229;
        }
      }
    }
    label229:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        Toast.makeText((Context)paramAccountExpiredSettingUI, r.j.app_modify_success, 0).show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/account/ui/AccountExpiredSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(305071);
      return;
      i = 0;
      break;
    }
  }
  
  private static final boolean a(AccountExpiredSettingUI paramAccountExpiredSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(305067);
    s.u(paramAccountExpiredSettingUI, "this$0");
    paramAccountExpiredSettingUI.finish();
    AppMethodBeat.o(305067);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return r.g.account_expired_setting_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305078);
    super.onCreate(paramBundle);
    setMMTitle(r.j.account_expired_hint);
    setBackBtn(new AccountExpiredSettingUI..ExternalSyntheticLambda0(this));
    findViewById(r.f.ok_btn).setOnClickListener(new AccountExpiredSettingUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(305078);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(ah.f<String> paramf1, ah.f<String> paramf2, AccountExpiredSettingUI paramAccountExpiredSettingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.AccountExpiredSettingUI
 * JD-Core Version:    0.7.0.1
 */