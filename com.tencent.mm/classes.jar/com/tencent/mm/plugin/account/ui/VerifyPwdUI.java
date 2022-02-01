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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class VerifyPwdUI
  extends MMActivity
  implements f, b.a
{
  private Button fSn;
  private ScrollView fSp;
  private InputPanelLinearLayout fSq;
  private View jui;
  private TextView juj;
  private EditText juk;
  private int scene;
  private p tipDialog;
  
  private void vr(String paramString)
  {
    AppMethodBeat.i(188446);
    if (bu.isNullOrNil(paramString))
    {
      this.juj.setVisibility(8);
      AppMethodBeat.o(188446);
      return;
    }
    this.juj.setVisibility(0);
    this.juj.setText(paramString);
    AppMethodBeat.o(188446);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(188449);
    ae.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.fSn.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.fSn.setLayoutParams(localLayoutParams);
      this.fSq.setPadding(this.fSq.getPaddingLeft(), this.fSq.getPaddingTop(), this.fSq.getPaddingRight(), paramInt);
      paramInt = this.fSp.getHeight();
      this.fSq.requestLayout();
      this.fSq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188442);
          ae.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(VerifyPwdUI.c(VerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (VerifyPwdUI.c(VerifyPwdUI.this).getHeight() > paramInt) {
            VerifyPwdUI.d(VerifyPwdUI.this).scrollBy(0, VerifyPwdUI.c(VerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(188442);
        }
      });
      AppMethodBeat.o(188449);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.fSn.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.fSn.setLayoutParams(localLayoutParams);
    this.fSq.setPadding(this.fSq.getPaddingLeft(), this.fSq.getPaddingTop(), this.fSq.getPaddingRight(), 0);
    this.fSp.scrollBy(0, 0);
    AppMethodBeat.o(188449);
  }
  
  public int getLayoutId()
  {
    return 2131495824;
  }
  
  public void initView()
  {
    AppMethodBeat.i(188445);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fSp = ((ScrollView)findViewById(2131304376));
    this.fSq = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fSq.setExternalListener(this);
    this.juj = ((TextView)findViewById(2131299523));
    this.jui = findViewById(2131300220);
    this.juk = ((EditText)findViewById(2131303548));
    this.juk.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(188438);
        if (!bu.isNullOrNil(paramAnonymousEditable.toString()))
        {
          VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(188438);
          return;
        }
        VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(false);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        AppMethodBeat.o(188438);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.fSn = ((Button)findViewById(2131302852));
    this.fSn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188439);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        VerifyPwdUI.b(VerifyPwdUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188439);
      }
    });
    this.jui.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188440);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        VerifyPwdUI.this.hideVKB();
        d.Q(VerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188440);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(188441);
        VerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(188441);
        return true;
      }
    });
    AppMethodBeat.o(188445);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(188448);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(188448);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(188444);
    super.onCreate(paramBundle);
    g.ajj().a(384, this);
    this.scene = getIntent().getIntExtra("key_scenen", 0);
    initView();
    AppMethodBeat.o(188444);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(188447);
    super.onDestroy();
    g.ajj().b(384, this);
    hideVKB();
    AppMethodBeat.o(188447);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(188450);
    ae.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_ticket", ((ad)paramn).aHN());
      setResult(-1, paramString);
      t.cn(this, getString(2131764659));
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188443);
          VerifyPwdUI.this.hideVKB();
          VerifyPwdUI.this.finish();
          AppMethodBeat.o(188443);
        }
      }, 500L);
      AppMethodBeat.o(188450);
      return;
    }
    if (paramInt1 == 4)
    {
      if (!bu.isNullOrNil(paramString))
      {
        paramn = com.tencent.mm.h.a.uU(paramString);
        if (paramn != null)
        {
          vr(paramn.desc);
          AppMethodBeat.o(188450);
          return;
        }
        vr(paramString);
        AppMethodBeat.o(188450);
        return;
      }
      vr(getString(2131755733));
      AppMethodBeat.o(188450);
      return;
    }
    vr(getString(2131755733));
    AppMethodBeat.o(188450);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VerifyPwdUI
 * JD-Core Version:    0.7.0.1
 */