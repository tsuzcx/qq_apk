package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;

public class VerifyPwdUI
  extends MMActivity
  implements i, c.a
{
  private Button jbJ;
  private ScrollView jbL;
  private InputPanelLinearLayout jbM;
  private View nkg;
  private TextView nkh;
  private EditText nki;
  private int scene;
  private s tipDialog;
  
  private void Kz(String paramString)
  {
    AppMethodBeat.i(213918);
    if (Util.isNullOrNil(paramString))
    {
      this.nkh.setVisibility(8);
      AppMethodBeat.o(213918);
      return;
    }
    this.nkh.setVisibility(0);
    this.nkh.setText(paramString);
    AppMethodBeat.o(213918);
  }
  
  public int getLayoutId()
  {
    return r.g.verify_pwd_ui;
  }
  
  public final void h(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(213922);
    Log.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jbJ.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(r.d.Edge_2A);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(r.d.Edge_2A);
      this.jbJ.setLayoutParams(localLayoutParams);
      this.jbM.setPadding(this.jbM.getPaddingLeft(), this.jbM.getPaddingTop(), this.jbM.getPaddingRight(), paramInt);
      paramInt = this.jbL.getHeight();
      this.jbM.requestLayout();
      this.jbM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216442);
          Log.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(VerifyPwdUI.c(VerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (VerifyPwdUI.c(VerifyPwdUI.this).getHeight() > paramInt) {
            VerifyPwdUI.d(VerifyPwdUI.this).scrollBy(0, VerifyPwdUI.c(VerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(216442);
        }
      });
      AppMethodBeat.o(213922);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jbJ.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(r.d.Edge_12A);
    localLayoutParams.topMargin = 0;
    this.jbJ.setLayoutParams(localLayoutParams);
    this.jbM.setPadding(this.jbM.getPaddingLeft(), this.jbM.getPaddingTop(), this.jbM.getPaddingRight(), 0);
    this.jbL.scrollBy(0, 0);
    AppMethodBeat.o(213922);
  }
  
  public void initView()
  {
    AppMethodBeat.i(213917);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(r.c.white));
    this.jbL = ((ScrollView)findViewById(r.f.scroll_view));
    this.jbM = ((InputPanelLinearLayout)findViewById(r.f.input_container));
    this.jbM.setExternalListener(this);
    this.nkh = ((TextView)findViewById(r.f.error_tip));
    this.nkg = findViewById(r.f.forget_pwd_btn);
    this.nki = ((EditText)findViewById(r.f.pwd_edit));
    this.nki.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(218119);
        if (!Util.isNullOrNil(paramAnonymousEditable.toString()))
        {
          VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(218119);
          return;
        }
        VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(false);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        AppMethodBeat.o(218119);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.jbJ = ((Button)findViewById(r.f.next_btn));
    this.jbJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(217282);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        VerifyPwdUI.b(VerifyPwdUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(217282);
      }
    });
    this.nkg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(217111);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        VerifyPwdUI.this.hideVKB();
        c.ad(VerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(217111);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(215976);
        VerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(215976);
        return true;
      }
    });
    AppMethodBeat.o(213917);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(213920);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(213920);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213916);
    super.onCreate(paramBundle);
    h.aGY().a(384, this);
    this.scene = getIntent().getIntExtra("key_scenen", 0);
    initView();
    AppMethodBeat.o(213916);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(213919);
    super.onDestroy();
    h.aGY().b(384, this);
    hideVKB();
    AppMethodBeat.o(213919);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(213924);
    Log.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_ticket", ((ad)paramq).bkW());
      setResult(-1, paramString);
      w.cR(this, getString(r.j.verify_password_success));
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(218465);
          VerifyPwdUI.this.hideVKB();
          VerifyPwdUI.this.finish();
          AppMethodBeat.o(218465);
        }
      }, 500L);
      AppMethodBeat.o(213924);
      return;
    }
    if (paramInt1 == 4)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramq = com.tencent.mm.h.a.Kb(paramString);
        if (paramq != null)
        {
          Kz(paramq.desc);
          AppMethodBeat.o(213924);
          return;
        }
        Kz(paramString);
        AppMethodBeat.o(213924);
        return;
      }
      Kz(getString(r.j.app_err_system_busy_tip));
      AppMethodBeat.o(213924);
      return;
    }
    Kz(getString(r.j.app_err_system_busy_tip));
    AppMethodBeat.o(213924);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VerifyPwdUI
 * JD-Core Version:    0.7.0.1
 */