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
import com.tencent.mm.ak.q;
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
  private Button nAa;
  private String yjY;
  private long ykN;
  private long ykO;
  private WalletFormView ylE;
  private TextView ylk;
  
  private void qf(boolean paramBoolean)
  {
    AppMethodBeat.i(64809);
    if ((paramBoolean) && (!this.ylk.isShown()))
    {
      String str = ah.hhz() + f.b(new StringBuilder().append(this.ykO).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.ylk.setText(getString(2131761672, new Object[] { str }));
      this.ylk.startAnimation(AnimationUtils.loadAnimation(this, 2130772081));
      this.ylk.setVisibility(0);
      AppMethodBeat.o(64809);
      return;
    }
    if ((!paramBoolean) && (this.ylk.isShown()))
    {
      this.ylk.startAnimation(AnimationUtils.loadAnimation(this, 2130772110));
      this.ylk.setVisibility(8);
    }
    AppMethodBeat.o(64809);
  }
  
  private void qg(boolean paramBoolean)
  {
    AppMethodBeat.i(64810);
    if ((paramBoolean) && (!this.ylk.isShown()))
    {
      String str = ah.hhz() + f.b(new StringBuilder().append(this.ykN).toString(), "100", 2, RoundingMode.HALF_UP);
      this.ylk.setText(getString(2131761668, new Object[] { str }));
      this.ylk.startAnimation(AnimationUtils.loadAnimation(this, 2130772081));
      this.ylk.setVisibility(0);
      AppMethodBeat.o(64810);
      return;
    }
    if ((!paramBoolean) && (this.ylk.isShown()))
    {
      this.ylk.startAnimation(AnimationUtils.loadAnimation(this, 2130772110));
      this.ylk.setVisibility(8);
    }
    AppMethodBeat.o(64810);
  }
  
  private void qh(boolean paramBoolean)
  {
    AppMethodBeat.i(64811);
    this.nAa.setEnabled(paramBoolean);
    AppMethodBeat.o(64811);
  }
  
  public int getLayoutId()
  {
    return 2131495028;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64806);
    this.ylE = ((WalletFormView)findViewById(2131302428));
    this.nAa = ((Button)findViewById(2131302427));
    this.ylk = ((TextView)findViewById(2131302429));
    this.ylE.setContentPadding$3b4dfe4b(0);
    this.ylE.getTitleTv().setText(ah.hhz());
    setEditFocusListener(this.ylE, 2, false);
    this.ylE.a(new TextWatcher()
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
    this.nAa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64803);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayModifyQuotaUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this))
        {
          HoneyPayModifyQuotaUI.b(HoneyPayModifyQuotaUI.this);
          HoneyPayModifyQuotaUI.this.hideTenpayKB();
        }
        a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayModifyQuotaUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64803);
      }
    });
    this.ylE.postDelayed(new Runnable()
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
    this.ykN = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.ykO = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.yjY = getIntent().getStringExtra("key_card_no");
    initView();
    setMMTitle(2131761673);
    AppMethodBeat.o(64805);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64807);
    super.onDestroy();
    AppMethodBeat.o(64807);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI
 * JD-Core Version:    0.7.0.1
 */