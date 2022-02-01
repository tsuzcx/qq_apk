package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;

public class HoneyPayModifyQuotaUI
  extends HoneyPayBaseUI
{
  private String JAW;
  private long JBN;
  private long JBO;
  private WalletFormView JCQ;
  private TextView JCo;
  private Button tHj;
  
  private void xs(boolean paramBoolean)
  {
    AppMethodBeat.i(64809);
    if ((paramBoolean) && (!this.JCo.isShown()))
    {
      String str = ai.jOX() + i.b(new StringBuilder().append(this.JBO).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.JCo.setText(getString(a.i.honey_pay_min_quota_alert_text, new Object[] { str }));
      this.JCo.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.JCo.setVisibility(0);
      AppMethodBeat.o(64809);
      return;
    }
    if ((!paramBoolean) && (this.JCo.isShown()))
    {
      this.JCo.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.JCo.setVisibility(8);
    }
    AppMethodBeat.o(64809);
  }
  
  private void xt(boolean paramBoolean)
  {
    AppMethodBeat.i(64810);
    if ((paramBoolean) && (!this.JCo.isShown()))
    {
      String str = ai.jOX() + i.b(new StringBuilder().append(this.JBN).toString(), "100", 2, RoundingMode.HALF_UP);
      this.JCo.setText(getString(a.i.honey_pay_max_quota_alert_text, new Object[] { str }));
      this.JCo.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
      this.JCo.setVisibility(0);
      AppMethodBeat.o(64810);
      return;
    }
    if ((!paramBoolean) && (this.JCo.isShown()))
    {
      this.JCo.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.JCo.setVisibility(8);
    }
    AppMethodBeat.o(64810);
  }
  
  private void xu(boolean paramBoolean)
  {
    AppMethodBeat.i(64811);
    this.tHj.setEnabled(paramBoolean);
    AppMethodBeat.o(64811);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_modify_quota_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64806);
    this.JCQ = ((WalletFormView)findViewById(a.f.hpmq_quota_et));
    this.tHj = ((Button)findViewById(a.f.hpmq_finish_btn));
    this.JCo = ((TextView)findViewById(a.f.hpmq_top_alert_tv));
    this.JCQ.aGD(0);
    this.JCQ.getTitleTv().setText(ai.jOX());
    setEditFocusListener(this.JCQ, 2, false);
    this.JCQ.a(new TextWatcher()
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
    this.tHj.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267329);
        if (HoneyPayModifyQuotaUI.a(HoneyPayModifyQuotaUI.this))
        {
          HoneyPayModifyQuotaUI.b(HoneyPayModifyQuotaUI.this);
          HoneyPayModifyQuotaUI.this.hideTenpayKB();
        }
        AppMethodBeat.o(267329);
      }
    });
    this.JCQ.postDelayed(new Runnable()
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
    this.JBN = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.JBO = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.JAW = getIntent().getStringExtra("key_card_no");
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(267332);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(HoneyPayModifyQuotaUI.a.class);
    AppMethodBeat.o(267332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI
 * JD-Core Version:    0.7.0.1
 */