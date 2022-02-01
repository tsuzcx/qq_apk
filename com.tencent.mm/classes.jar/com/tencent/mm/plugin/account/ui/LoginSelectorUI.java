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
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;

@Deprecated
public class LoginSelectorUI
  extends MMActivity
  implements View.OnClickListener
{
  private TextView isu;
  private View isv;
  
  public int getLayoutId()
  {
    return 2131495349;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128188);
    Button localButton1 = (Button)findViewById(2131304521);
    Button localButton2 = (Button)findViewById(2131304531);
    this.isu = ((TextView)findViewById(2131304512));
    this.isv = findViewById(2131304513);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    this.isu.setText(ac.is(getContext()));
    this.isv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128185);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        com.tencent.mm.plugin.account.a.a.hYt.o(paramAnonymousView, LoginSelectorUI.this.getContext());
        AppMethodBeat.o(128185);
      }
    });
    if (i.ETy)
    {
      com.tencent.mm.plugin.account.a.a.hYu.t(this);
      AppMethodBeat.o(128188);
      return;
    }
    com.tencent.mm.plugin.account.a.a.hYu.bv(this);
    AppMethodBeat.o(128188);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(128190);
    if (2131304521 == paramView.getId())
    {
      paramView = new Intent(this, MobileInputUI.class);
      paramView.putExtra("mobile_input_purpose", 1);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.adn(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128190);
      return;
    }
    if (2131304531 == paramView.getId())
    {
      if (d.CpN)
      {
        paramView = getString(2131757964, new Object[] { "0x" + Integer.toHexString(d.CpK), ac.eFu() });
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramView);
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("needRedirect", false);
        localIntent.putExtra("neverGetA8Key", true);
        localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
        localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
        com.tencent.mm.plugin.account.a.a.hYt.i(localIntent, this);
        AppMethodBeat.o(128190);
        return;
      }
      paramView = new Intent(this, RegByMobileRegAIOUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.adn(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(128190);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128186);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    com.tencent.mm.plugin.account.a.a.hYu.Lo();
    g.afz();
    com.tencent.mm.kernel.a.aeN();
    initView();
    AppMethodBeat.o(128186);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128189);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectorUI", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      b.jI(this);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128189);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128187);
    super.onResume();
    g.afz();
    com.tencent.mm.kernel.a.aeN();
    AppMethodBeat.o(128187);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSelectorUI
 * JD-Core Version:    0.7.0.1
 */