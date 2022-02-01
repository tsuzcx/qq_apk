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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class VerifyPwdUI
  extends MMActivity
  implements i, b.a
{
  private Button gxv;
  private ScrollView gxx;
  private InputPanelLinearLayout gxy;
  private View ksx;
  private TextView ksy;
  private EditText ksz;
  private int scene;
  private com.tencent.mm.ui.base.q tipDialog;
  
  private void DI(String paramString)
  {
    AppMethodBeat.i(196945);
    if (Util.isNullOrNil(paramString))
    {
      this.ksy.setVisibility(8);
      AppMethodBeat.o(196945);
      return;
    }
    this.ksy.setVisibility(0);
    this.ksy.setText(paramString);
    AppMethodBeat.o(196945);
  }
  
  public final void f(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(196948);
    Log.i("MicroMsg.VerifyPwdUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.gxv.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165296);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165296);
      this.gxv.setLayoutParams(localLayoutParams);
      this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), paramInt);
      paramInt = this.gxx.getHeight();
      this.gxy.requestLayout();
      this.gxy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196941);
          Log.i("MicroMsg.VerifyPwdUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(VerifyPwdUI.c(VerifyPwdUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (VerifyPwdUI.c(VerifyPwdUI.this).getHeight() > paramInt) {
            VerifyPwdUI.d(VerifyPwdUI.this).scrollBy(0, VerifyPwdUI.c(VerifyPwdUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(196941);
        }
      });
      AppMethodBeat.o(196948);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.gxv.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165281);
    localLayoutParams.topMargin = 0;
    this.gxv.setLayoutParams(localLayoutParams);
    this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
    this.gxx.scrollBy(0, 0);
    AppMethodBeat.o(196948);
  }
  
  public int getLayoutId()
  {
    return 2131496787;
  }
  
  public void initView()
  {
    AppMethodBeat.i(196944);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    this.gxx = ((ScrollView)findViewById(2131307339));
    this.gxy = ((InputPanelLinearLayout)findViewById(2131302671));
    this.gxy.setExternalListener(this);
    this.ksy = ((TextView)findViewById(2131300161));
    this.ksx = findViewById(2131301694);
    this.ksz = ((EditText)findViewById(2131306323));
    this.ksz.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(196937);
        if (!Util.isNullOrNil(paramAnonymousEditable.toString()))
        {
          VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(true);
          AppMethodBeat.o(196937);
          return;
        }
        VerifyPwdUI.a(VerifyPwdUI.this).setEnabled(false);
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        AppMethodBeat.o(196937);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.gxv = ((Button)findViewById(2131305423));
    this.gxv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196938);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        VerifyPwdUI.a(VerifyPwdUI.this, "");
        VerifyPwdUI.b(VerifyPwdUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196938);
      }
    });
    this.ksx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196939);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        VerifyPwdUI.this.hideVKB();
        c.V(VerifyPwdUI.this, "setting", ".ui.setting.SettingsForgetPwdUI");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/VerifyPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196939);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196940);
        VerifyPwdUI.this.onBackPressed();
        AppMethodBeat.o(196940);
        return true;
      }
    });
    AppMethodBeat.o(196944);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(196947);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(196947);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196943);
    super.onCreate(paramBundle);
    g.azz().a(384, this);
    this.scene = getIntent().getIntExtra("key_scenen", 0);
    initView();
    AppMethodBeat.o(196943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(196946);
    super.onDestroy();
    g.azz().b(384, this);
    hideVKB();
    AppMethodBeat.o(196946);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(196949);
    Log.i("MicroMsg.VerifyPwdUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_ticket", ((ad)paramq).bbG());
      setResult(-1, paramString);
      u.cG(this, getString(2131767030));
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196942);
          VerifyPwdUI.this.hideVKB();
          VerifyPwdUI.this.finish();
          AppMethodBeat.o(196942);
        }
      }, 500L);
      AppMethodBeat.o(196949);
      return;
    }
    if (paramInt1 == 4)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramq = com.tencent.mm.h.a.Dk(paramString);
        if (paramq != null)
        {
          DI(paramq.desc);
          AppMethodBeat.o(196949);
          return;
        }
        DI(paramString);
        AppMethodBeat.o(196949);
        return;
      }
      DI(getString(2131755804));
      AppMethodBeat.o(196949);
      return;
    }
    DI(getString(2131755804));
    AppMethodBeat.o(196949);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VerifyPwdUI
 * JD-Core Version:    0.7.0.1
 */