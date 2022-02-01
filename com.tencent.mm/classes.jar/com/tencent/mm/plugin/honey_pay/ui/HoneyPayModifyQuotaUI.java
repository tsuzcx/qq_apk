package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayModifyQuotaUI
  extends HoneyPayBaseUI
{
  private Button mpo;
  private String uRv;
  private TextView uSJ;
  private long uSk;
  private long uSl;
  private WalletFormView uTd;
  
  private void nw(boolean paramBoolean)
  {
    AppMethodBeat.i(64809);
    if ((paramBoolean) && (!this.uSJ.isShown()))
    {
      String str = ah.fWc() + f.b(new StringBuilder().append(this.uSl).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.uSJ.setText(getString(2131760286, new Object[] { str }));
      this.uSJ.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.uSJ.setVisibility(0);
      AppMethodBeat.o(64809);
      return;
    }
    if ((!paramBoolean) && (this.uSJ.isShown()))
    {
      this.uSJ.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.uSJ.setVisibility(8);
    }
    AppMethodBeat.o(64809);
  }
  
  private void nx(boolean paramBoolean)
  {
    AppMethodBeat.i(64810);
    if ((paramBoolean) && (!this.uSJ.isShown()))
    {
      String str = ah.fWc() + f.b(new StringBuilder().append(this.uSk).toString(), "100", 2, RoundingMode.HALF_UP);
      this.uSJ.setText(getString(2131760282, new Object[] { str }));
      this.uSJ.startAnimation(AnimationUtils.loadAnimation(this, 2130772068));
      this.uSJ.setVisibility(0);
      AppMethodBeat.o(64810);
      return;
    }
    if ((!paramBoolean) && (this.uSJ.isShown()))
    {
      this.uSJ.startAnimation(AnimationUtils.loadAnimation(this, 2130772088));
      this.uSJ.setVisibility(8);
    }
    AppMethodBeat.o(64810);
  }
  
  private void ny(boolean paramBoolean)
  {
    AppMethodBeat.i(64811);
    this.mpo.setEnabled(paramBoolean);
    AppMethodBeat.o(64811);
  }
  
  public int getLayoutId()
  {
    return 2131494450;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64806);
    this.uTd = ((WalletFormView)findViewById(2131300834));
    this.mpo = ((Button)findViewById(2131300833));
    this.uSJ = ((TextView)findViewById(2131300835));
    this.uTd.setContentPadding$3b4dfe4b(0);
    this.uTd.getTitleTv().setText(ah.fWc());
    setEditFocusListener(this.uTd, 2, false);
    this.uTd.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(64802);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 2)) {
          paramAnonymousEditable.delete(i + 3, j);
        }
        HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this);
        AppMethodBeat.o(64802);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.mpo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64803);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayModifyQuotaUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this))
        {
          HoneyPayModifyQuotaUI.b(HoneyPayModifyQuotaUI.this);
          HoneyPayModifyQuotaUI.this.hideTenpayKB();
        }
        a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayModifyQuotaUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64803);
      }
    });
    this.uTd.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64804);
        HoneyPayModifyQuotaUI.c(HoneyPayModifyQuotaUI.this).d(HoneyPayModifyQuotaUI.this);
        AppMethodBeat.o(64804);
      }
    }, 100L);
    AppMethodBeat.o(64806);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64808);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
    {
      setResult(-1, paramIntent);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(64808);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64805);
    super.onCreate(paramBundle);
    this.uSk = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.uSl = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.uRv = getIntent().getStringExtra("key_card_no");
    initView();
    setMMTitle(2131760287);
    AppMethodBeat.o(64805);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64807);
    super.onDestroy();
    AppMethodBeat.o(64807);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI
 * JD-Core Version:    0.7.0.1
 */