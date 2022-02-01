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
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayModifyQuotaUI
  extends HoneyPayBaseUI
{
  private long DKP;
  private long DKQ;
  private String DKa;
  private WalletFormView DLG;
  private TextView DLm;
  private Button qCl;
  
  private void th(boolean paramBoolean)
  {
    AppMethodBeat.i(64809);
    if ((paramBoolean) && (!this.DLm.isShown()))
    {
      String str = ah.ijb() + g.b(new StringBuilder().append(this.DKQ).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.DLm.setText(getString(a.i.honey_pay_min_quota_alert_text, new Object[] { str }));
      this.DLm.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.DLm.setVisibility(0);
      AppMethodBeat.o(64809);
      return;
    }
    if ((!paramBoolean) && (this.DLm.isShown()))
    {
      this.DLm.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.DLm.setVisibility(8);
    }
    AppMethodBeat.o(64809);
  }
  
  private void ti(boolean paramBoolean)
  {
    AppMethodBeat.i(64810);
    if ((paramBoolean) && (!this.DLm.isShown()))
    {
      String str = ah.ijb() + g.b(new StringBuilder().append(this.DKP).toString(), "100", 2, RoundingMode.HALF_UP);
      this.DLm.setText(getString(a.i.honey_pay_max_quota_alert_text, new Object[] { str }));
      this.DLm.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.DLm.setVisibility(0);
      AppMethodBeat.o(64810);
      return;
    }
    if ((!paramBoolean) && (this.DLm.isShown()))
    {
      this.DLm.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.DLm.setVisibility(8);
    }
    AppMethodBeat.o(64810);
  }
  
  private void tj(boolean paramBoolean)
  {
    AppMethodBeat.i(64811);
    this.qCl.setEnabled(paramBoolean);
    AppMethodBeat.o(64811);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_modify_quota_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64806);
    this.DLG = ((WalletFormView)findViewById(a.f.hpmq_quota_et));
    this.qCl = ((Button)findViewById(a.f.hpmq_finish_btn));
    this.DLm = ((TextView)findViewById(a.f.hpmq_top_alert_tv));
    this.DLG.azN(0);
    this.DLG.getTitleTv().setText(ah.ijb());
    setEditFocusListener(this.DLG, 2, false);
    this.DLG.a(new TextWatcher()
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
    this.qCl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64803);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/honey_pay/ui/HoneyPayModifyQuotaUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this))
        {
          HoneyPayModifyQuotaUI.b(HoneyPayModifyQuotaUI.this);
          HoneyPayModifyQuotaUI.this.hideTenpayKB();
        }
        a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayModifyQuotaUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64803);
      }
    });
    this.DLG.postDelayed(new Runnable()
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
    this.DKP = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.DKQ = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.DKa = getIntent().getStringExtra("key_card_no");
    initView();
    setMMTitle(a.i.honey_pay_modify_quota_title);
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