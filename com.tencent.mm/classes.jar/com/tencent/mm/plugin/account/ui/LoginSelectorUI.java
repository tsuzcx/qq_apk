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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class LoginSelectorUI
  extends MMActivity
  implements View.OnClickListener
{
  private TextView joB;
  private View joC;
  
  public int getLayoutId()
  {
    return 2131495349;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128188);
    Button localButton1 = (Button)findViewById(2131304521);
    Button localButton2 = (Button)findViewById(2131304531);
    this.joB = ((TextView)findViewById(2131304512));
    this.joC = findViewById(2131304513);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    this.joB.setText(ad.iS(getContext()));
    this.joC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        com.tencent.mm.plugin.account.a.a.iUz.o(paramAnonymousView, LoginSelectorUI.this.getContext());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128185);
      }
    });
    if (k.IwK)
    {
      com.tencent.mm.plugin.account.a.a.iUA.t(this);
      AppMethodBeat.o(128188);
      return;
    }
    com.tencent.mm.plugin.account.a.a.iUA.bz(this);
    AppMethodBeat.o(128188);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(128190);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (2131304521 == paramView.getId())
    {
      paramView = new Intent(this, MobileInputUI.class);
      paramView.putExtra("mobile_input_purpose", 1);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahE(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(128190);
      return;
      if (2131304531 == paramView.getId())
      {
        if (d.FFK)
        {
          paramView = getString(2131757964, new Object[] { "0x" + Integer.toHexString(d.FFH), ad.fom() });
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView);
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          ((Intent)localObject).putExtra("neverGetA8Key", true);
          ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
          ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
          com.tencent.mm.plugin.account.a.a.iUz.i((Intent)localObject, this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128190);
          return;
        }
        paramView = new Intent(this, RegByMobileRegAIOUI.class);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahE(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128186);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    com.tencent.mm.plugin.account.a.a.iUA.MP();
    g.ajP();
    com.tencent.mm.kernel.a.aje();
    initView();
    AppMethodBeat.o(128186);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128189);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.kl(this);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128189);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128187);
    super.onResume();
    g.ajP();
    com.tencent.mm.kernel.a.aje();
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