package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;

public class VerifyPwdUI
  extends MMActivity
  implements com.tencent.mm.am.h, c.a
{
  private Button lDJ;
  private ScrollView lDL;
  private InputPanelLinearLayout lDM;
  private View qho;
  private TextView qhp;
  private EditText qhq;
  private int scene;
  private w tipDialog;
  
  private void Df(String paramString)
  {
    AppMethodBeat.i(304940);
    if (Util.isNullOrNil(paramString))
    {
      this.qhp.setVisibility(8);
      AppMethodBeat.o(304940);
      return;
    }
    this.qhp.setVisibility(0);
    this.qhp.setText(paramString);
    AppMethodBeat.o(304940);
  }
  
  public int getLayoutId()
  {
    return r.g.verify_pwd_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(304961);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(r.c.white));
    this.lDL = ((ScrollView)findViewById(r.f.scroll_view));
    this.lDM = ((InputPanelLinearLayout)findViewById(r.f.input_container));
    this.lDM.setExternalListener(this);
    this.qhp = ((TextView)findViewById(r.f.error_tip));
    this.qho = findViewById(r.f.forget_pwd_btn);
    this.qhq = ((EditText)findViewById(r.f.pwd_edit));
    this.qhq.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(304969);
        if (!Util.isNullOrNil(paramAnonymousEditable.toString()))
        {
          VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(304969);
          return;
        }
        VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(false);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        AppMethodBeat.o(304969);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.lDJ = ((Button)findViewById(r.f.next_btn));
    this.lDJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305187);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        VerifyPwdUI.b(VerifyPwdUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(305187);
      }
    });
    this.qho.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305188);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        VerifyPwdUI.this.hideVKB();
        c.ai(VerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(305188);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(305191);
        VerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(305191);
        return true;
      }
    });
    AppMethodBeat.o(304961);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(304964);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(304964);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(304956);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(384, this);
    this.scene = getIntent().getIntExtra("key_scenen", 0);
    initView();
    AppMethodBeat.o(304956);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(304963);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(384, this);
    hideVKB();
    AppMethodBeat.o(304963);
  }
  
  public void onInputPanelChange(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(304968);
    Log.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.lDJ.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(r.d.Edge_2A);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(r.d.Edge_2A);
      this.lDJ.setLayoutParams(localLayoutParams);
      this.lDM.setPadding(this.lDM.getPaddingLeft(), this.lDM.getPaddingTop(), this.lDM.getPaddingRight(), paramInt);
      paramInt = this.lDL.getHeight();
      this.lDM.requestLayout();
      this.lDM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(305193);
          Log.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(VerifyPwdUI.c(VerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (VerifyPwdUI.c(VerifyPwdUI.this).getHeight() > paramInt) {
            VerifyPwdUI.d(VerifyPwdUI.this).scrollBy(0, VerifyPwdUI.c(VerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(305193);
        }
      });
      AppMethodBeat.o(304968);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.lDJ.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(r.d.Edge_12A);
    localLayoutParams.topMargin = 0;
    this.lDJ.setLayoutParams(localLayoutParams);
    this.lDM.setPadding(this.lDM.getPaddingLeft(), this.lDM.getPaddingTop(), this.lDM.getPaddingRight(), 0);
    this.lDL.scrollBy(0, 0);
    AppMethodBeat.o(304968);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(304971);
    Log.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_ticket", ((ae)paramp).bIQ());
      setResult(-1, paramString);
      aa.db(this, getString(r.j.verify_password_success));
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(305203);
          VerifyPwdUI.this.hideVKB();
          VerifyPwdUI.this.finish();
          AppMethodBeat.o(305203);
        }
      }, 500L);
      AppMethodBeat.o(304971);
      return;
    }
    if (paramInt1 == 4)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramp = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramp != null)
        {
          Df(paramp.desc);
          AppMethodBeat.o(304971);
          return;
        }
        Df(paramString);
        AppMethodBeat.o(304971);
        return;
      }
      Df(getString(r.j.app_err_system_busy_tip));
      AppMethodBeat.o(304971);
      return;
    }
    Df(getString(r.j.app_err_system_busy_tip));
    AppMethodBeat.o(304971);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VerifyPwdUI
 * JD-Core Version:    0.7.0.1
 */