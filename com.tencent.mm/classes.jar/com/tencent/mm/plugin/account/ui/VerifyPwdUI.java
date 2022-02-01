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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class VerifyPwdUI
  extends MMActivity
  implements com.tencent.mm.ak.g, b.a
{
  private Button fwU;
  private ScrollView fwW;
  private InputPanelLinearLayout fwX;
  private View iYg;
  private TextView iYh;
  private EditText iYi;
  private int scene;
  private p tipDialog;
  
  private void sg(String paramString)
  {
    AppMethodBeat.i(193253);
    if (bs.isNullOrNil(paramString))
    {
      this.iYh.setVisibility(8);
      AppMethodBeat.o(193253);
      return;
    }
    this.iYh.setVisibility(0);
    this.iYh.setText(paramString);
    AppMethodBeat.o(193253);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(193256);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.fwU.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.fwU.setLayoutParams(localLayoutParams);
      this.fwX.setPadding(this.fwX.getPaddingLeft(), this.fwX.getPaddingTop(), this.fwX.getPaddingRight(), paramInt);
      paramInt = this.fwW.getHeight();
      this.fwX.requestLayout();
      this.fwX.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193249);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(VerifyPwdUI.c(VerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (VerifyPwdUI.c(VerifyPwdUI.this).getHeight() > paramInt) {
            VerifyPwdUI.d(VerifyPwdUI.this).scrollBy(0, VerifyPwdUI.c(VerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(193249);
        }
      });
      AppMethodBeat.o(193256);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.fwU.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.fwU.setLayoutParams(localLayoutParams);
    this.fwX.setPadding(this.fwX.getPaddingLeft(), this.fwX.getPaddingTop(), this.fwX.getPaddingRight(), 0);
    this.fwW.scrollBy(0, 0);
    AppMethodBeat.o(193256);
  }
  
  public int getLayoutId()
  {
    return 2131495824;
  }
  
  public void initView()
  {
    AppMethodBeat.i(193252);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fwW = ((ScrollView)findViewById(2131304376));
    this.fwX = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fwX.setExternalListener(this);
    this.iYh = ((TextView)findViewById(2131299523));
    this.iYg = findViewById(2131300220);
    this.iYi = ((EditText)findViewById(2131303548));
    this.iYi.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(193245);
        if (!bs.isNullOrNil(paramAnonymousEditable.toString()))
        {
          VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(193245);
          return;
        }
        VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(false);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        AppMethodBeat.o(193245);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.fwU = ((Button)findViewById(2131302852));
    this.fwU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193246);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        VerifyPwdUI.b(VerifyPwdUI.this);
        AppMethodBeat.o(193246);
      }
    });
    this.iYg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193247);
        VerifyPwdUI.this.hideVKB();
        d.N(VerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        AppMethodBeat.o(193247);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(193248);
        VerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(193248);
        return true;
      }
    });
    AppMethodBeat.o(193252);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(193255);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(193255);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193251);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(384, this);
    this.scene = getIntent().getIntExtra("key_scenen", 0);
    initView();
    AppMethodBeat.o(193251);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193254);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(384, this);
    hideVKB();
    AppMethodBeat.o(193254);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(193257);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_ticket", ((com.tencent.mm.modelsimple.ac)paramn).aEr());
      setResult(-1, paramString);
      t.ch(this, getString(2131764659));
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193250);
          VerifyPwdUI.this.hideVKB();
          VerifyPwdUI.this.finish();
          AppMethodBeat.o(193250);
        }
      }, 500L);
      AppMethodBeat.o(193257);
      return;
    }
    if (paramInt1 == 4)
    {
      if (!bs.isNullOrNil(paramString))
      {
        paramn = a.rM(paramString);
        if (paramn != null)
        {
          sg(paramn.desc);
          AppMethodBeat.o(193257);
          return;
        }
        sg(paramString);
        AppMethodBeat.o(193257);
        return;
      }
      sg(getString(2131755733));
      AppMethodBeat.o(193257);
      return;
    }
    sg(getString(2131755733));
    AppMethodBeat.o(193257);
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