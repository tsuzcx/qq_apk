package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class LoginSelectorUI
  extends MMActivity
  implements View.OnClickListener
{
  private TextView kmL;
  private View kmM;
  
  public int getLayoutId()
  {
    return 2131496210;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128188);
    Button localButton1 = (Button)findViewById(2131307536);
    Button localButton2 = (Button)findViewById(2131307554);
    this.kmL = ((TextView)findViewById(2131307518));
    this.kmM = findViewById(2131307519);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    this.kmL.setText(LocaleUtil.getLanguageName(getContext(), 2130903056, 2131755881));
    this.kmM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        com.tencent.mm.plugin.account.a.a.jRt.n(paramAnonymousView, LoginSelectorUI.this.getContext());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128185);
      }
    });
    if (ChannelUtil.shouldShowGprsAlert)
    {
      com.tencent.mm.plugin.account.a.a.jRu.t(this);
      AppMethodBeat.o(128188);
      return;
    }
    com.tencent.mm.plugin.account.a.a.jRu.bU(this);
    AppMethodBeat.o(128188);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(128190);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (2131307536 == paramView.getId())
    {
      paramView = new Intent(this, MobileInputUI.class);
      paramView.putExtra("mobile_input_purpose", 1);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(128190);
      return;
      if (2131307554 == paramView.getId())
      {
        if (d.KyR)
        {
          paramView = getString(2131758213, new Object[] { "0x" + Integer.toHexString(d.KyO), LocaleUtil.getApplicationLanguage() });
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView);
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          ((Intent)localObject).putExtra("neverGetA8Key", true);
          ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
          ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
          com.tencent.mm.plugin.account.a.a.jRt.i((Intent)localObject, this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128190);
          return;
        }
        paramView = new Intent(this, RegByMobileRegAIOUI.class);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128186);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    g.aAf();
    com.tencent.mm.kernel.a.azu();
    initView();
    AppMethodBeat.o(128186);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128189);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.kd(this);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128189);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128187);
    super.onResume();
    g.aAf();
    com.tencent.mm.kernel.a.azu();
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