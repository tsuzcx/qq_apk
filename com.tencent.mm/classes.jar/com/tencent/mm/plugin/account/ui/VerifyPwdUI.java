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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
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
  implements f, b.a
{
  private Button fQh;
  private ScrollView fQj;
  private InputPanelLinearLayout fQk;
  private View jrp;
  private TextView jrq;
  private EditText jrr;
  private int scene;
  private p tipDialog;
  
  private void uV(String paramString)
  {
    AppMethodBeat.i(207155);
    if (bt.isNullOrNil(paramString))
    {
      this.jrq.setVisibility(8);
      AppMethodBeat.o(207155);
      return;
    }
    this.jrq.setVisibility(0);
    this.jrq.setText(paramString);
    AppMethodBeat.o(207155);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(207158);
    ad.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.fQh.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.fQh.setLayoutParams(localLayoutParams);
      this.fQk.setPadding(this.fQk.getPaddingLeft(), this.fQk.getPaddingTop(), this.fQk.getPaddingRight(), paramInt);
      paramInt = this.fQj.getHeight();
      this.fQk.requestLayout();
      this.fQk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207151);
          ad.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(VerifyPwdUI.c(VerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (VerifyPwdUI.c(VerifyPwdUI.this).getHeight() > paramInt) {
            VerifyPwdUI.d(VerifyPwdUI.this).scrollBy(0, VerifyPwdUI.c(VerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(207151);
        }
      });
      AppMethodBeat.o(207158);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.fQh.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.fQh.setLayoutParams(localLayoutParams);
    this.fQk.setPadding(this.fQk.getPaddingLeft(), this.fQk.getPaddingTop(), this.fQk.getPaddingRight(), 0);
    this.fQj.scrollBy(0, 0);
    AppMethodBeat.o(207158);
  }
  
  public int getLayoutId()
  {
    return 2131495824;
  }
  
  public void initView()
  {
    AppMethodBeat.i(207154);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fQj = ((ScrollView)findViewById(2131304376));
    this.fQk = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fQk.setExternalListener(this);
    this.jrq = ((TextView)findViewById(2131299523));
    this.jrp = findViewById(2131300220);
    this.jrr = ((EditText)findViewById(2131303548));
    this.jrr.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(207147);
        if (!bt.isNullOrNil(paramAnonymousEditable.toString()))
        {
          VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(207147);
          return;
        }
        VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(false);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        AppMethodBeat.o(207147);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.fQh = ((Button)findViewById(2131302852));
    this.fQh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207148);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        VerifyPwdUI.b(VerifyPwdUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207148);
      }
    });
    this.jrp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207149);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        VerifyPwdUI.this.hideVKB();
        d.Q(VerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207149);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(207150);
        VerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(207150);
        return true;
      }
    });
    AppMethodBeat.o(207154);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(207157);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(207157);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(207153);
    super.onCreate(paramBundle);
    g.aiU().a(384, this);
    this.scene = getIntent().getIntExtra("key_scenen", 0);
    initView();
    AppMethodBeat.o(207153);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(207156);
    super.onDestroy();
    g.aiU().b(384, this);
    hideVKB();
    AppMethodBeat.o(207156);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(207159);
    ad.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_ticket", ((ac)paramn).aHw());
      setResult(-1, paramString);
      t.cm(this, getString(2131764659));
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207152);
          VerifyPwdUI.this.hideVKB();
          VerifyPwdUI.this.finish();
          AppMethodBeat.o(207152);
        }
      }, 500L);
      AppMethodBeat.o(207159);
      return;
    }
    if (paramInt1 == 4)
    {
      if (!bt.isNullOrNil(paramString))
      {
        paramn = com.tencent.mm.h.a.uz(paramString);
        if (paramn != null)
        {
          uV(paramn.desc);
          AppMethodBeat.o(207159);
          return;
        }
        uV(paramString);
        AppMethodBeat.o(207159);
        return;
      }
      uV(getString(2131755733));
      AppMethodBeat.o(207159);
      return;
    }
    uV(getString(2131755733));
    AppMethodBeat.o(207159);
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