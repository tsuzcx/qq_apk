package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class LoginSelectorUI
  extends MMActivity
  implements View.OnClickListener
{
  private TextView qbr;
  private View qbs;
  
  public int getLayoutId()
  {
    return r.g.select_login_reg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128188);
    Button localButton1 = (Button)findViewById(r.f.select_login_btn);
    Button localButton2 = (Button)findViewById(r.f.select_register_btn);
    this.qbr = ((TextView)findViewById(r.f.select_country));
    this.qbs = findViewById(r.f.select_country_ly);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    this.qbr.setText(LocaleUtil.getLanguageName(getContext(), r.b.language_setting, r.j.app_lang_sys));
    this.qbs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        com.tencent.mm.plugin.account.sdk.a.pFn.m(paramAnonymousView, LoginSelectorUI.this.getContext());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128185);
      }
    });
    if (ChannelUtil.shouldShowGprsAlert)
    {
      com.tencent.mm.plugin.account.sdk.a.pFo.u(this);
      AppMethodBeat.o(128188);
      return;
    }
    com.tencent.mm.plugin.account.sdk.a.pFo.cE(this);
    AppMethodBeat.o(128188);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(128190);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (r.f.select_login_btn == paramView.getId())
    {
      paramView = new Intent(this, MobileInputUI.class);
      paramView.putExtra("mobile_input_purpose", 1);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aYi(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(128190);
      return;
      if (r.f.select_register_btn == paramView.getId())
      {
        paramView = new Intent(this, RegByMobileRegAIOUI.class);
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aYi(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128186);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    h.baC();
    com.tencent.mm.kernel.b.aZS();
    initView();
    AppMethodBeat.o(128186);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128189);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.nf(this);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128189);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128187);
    super.onResume();
    h.baC();
    com.tencent.mm.kernel.b.aZS();
    AppMethodBeat.o(128187);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSelectorUI
 * JD-Core Version:    0.7.0.1
 */