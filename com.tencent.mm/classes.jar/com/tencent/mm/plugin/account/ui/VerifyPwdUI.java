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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.h.a;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class VerifyPwdUI
  extends MMActivity
  implements com.tencent.mm.al.g, b.a
{
  private Button ftn;
  private ScrollView ftp;
  private InputPanelLinearLayout ftq;
  private View iyd;
  private TextView iye;
  private EditText iyf;
  private int scene;
  private p tipDialog;
  
  private void oU(String paramString)
  {
    AppMethodBeat.i(193665);
    if (bt.isNullOrNil(paramString))
    {
      this.iye.setVisibility(8);
      AppMethodBeat.o(193665);
      return;
    }
    this.iye.setVisibility(0);
    this.iye.setText(paramString);
    AppMethodBeat.o(193665);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(193668);
    ad.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.ftn.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.ftn.setLayoutParams(localLayoutParams);
      this.ftq.setPadding(this.ftq.getPaddingLeft(), this.ftq.getPaddingTop(), this.ftq.getPaddingRight(), paramInt);
      paramInt = this.ftp.getHeight();
      this.ftq.requestLayout();
      this.ftq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193661);
          ad.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(VerifyPwdUI.c(VerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (VerifyPwdUI.c(VerifyPwdUI.this).getHeight() > paramInt) {
            VerifyPwdUI.d(VerifyPwdUI.this).scrollBy(0, VerifyPwdUI.c(VerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(193661);
        }
      });
      AppMethodBeat.o(193668);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ftn.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.ftn.setLayoutParams(localLayoutParams);
    this.ftq.setPadding(this.ftq.getPaddingLeft(), this.ftq.getPaddingTop(), this.ftq.getPaddingRight(), 0);
    this.ftp.scrollBy(0, 0);
    AppMethodBeat.o(193668);
  }
  
  public int getLayoutId()
  {
    return 2131495824;
  }
  
  public void initView()
  {
    AppMethodBeat.i(193664);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.ftp = ((ScrollView)findViewById(2131304376));
    this.ftq = ((InputPanelLinearLayout)findViewById(2131301024));
    this.ftq.setExternalListener(this);
    this.iye = ((TextView)findViewById(2131299523));
    this.iyd = findViewById(2131300220);
    this.iyf = ((EditText)findViewById(2131303548));
    this.iyf.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(193657);
        if (!bt.isNullOrNil(paramAnonymousEditable.toString()))
        {
          VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(193657);
          return;
        }
        VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(false);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        AppMethodBeat.o(193657);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.ftn = ((Button)findViewById(2131302852));
    this.ftn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193658);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        VerifyPwdUI.b(VerifyPwdUI.this);
        AppMethodBeat.o(193658);
      }
    });
    this.iyd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193659);
        VerifyPwdUI.this.hideVKB();
        d.O(VerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        AppMethodBeat.o(193659);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(193660);
        VerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(193660);
        return true;
      }
    });
    AppMethodBeat.o(193664);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(193667);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(193667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193663);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(384, this);
    this.scene = getIntent().getIntExtra("key_scenen", 0);
    initView();
    AppMethodBeat.o(193663);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193666);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(384, this);
    hideVKB();
    AppMethodBeat.o(193666);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(193669);
    ad.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_ticket", ((ac)paramn).axz());
      setResult(-1, paramString);
      t.cg(this, getString(2131764659));
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193662);
          VerifyPwdUI.this.hideVKB();
          VerifyPwdUI.this.finish();
          AppMethodBeat.o(193662);
        }
      }, 500L);
      AppMethodBeat.o(193669);
      return;
    }
    if (paramInt1 == 4)
    {
      if (!bt.isNullOrNil(paramString))
      {
        paramn = a.oG(paramString);
        if (paramn != null)
        {
          oU(paramn.desc);
          AppMethodBeat.o(193669);
          return;
        }
        oU(paramString);
        AppMethodBeat.o(193669);
        return;
      }
      oU(getString(2131755733));
      AppMethodBeat.o(193669);
      return;
    }
    oU(getString(2131755733));
    AppMethodBeat.o(193669);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VerifyPwdUI
 * JD-Core Version:    0.7.0.1
 */