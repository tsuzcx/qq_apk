package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoneyPayModifyQuotaUI
  extends HoneyPayBaseUI
{
  private String nHE;
  private TextView nIR;
  private long nIs;
  private long nIt;
  private WalletFormView nJl;
  private Button nJm;
  
  private void iq(boolean paramBoolean)
  {
    AppMethodBeat.i(41920);
    if ((paramBoolean) && (!this.nIR.isShown()))
    {
      String str = ae.dSz() + e.a(new StringBuilder().append(this.nIt).toString(), "100", 2, RoundingMode.HALF_UP).toString();
      this.nIR.setText(getString(2131300689, new Object[] { str }));
      this.nIR.startAnimation(AnimationUtils.loadAnimation(this, 2131034194));
      this.nIR.setVisibility(0);
      AppMethodBeat.o(41920);
      return;
    }
    if ((!paramBoolean) && (this.nIR.isShown()))
    {
      this.nIR.startAnimation(AnimationUtils.loadAnimation(this, 2131034214));
      this.nIR.setVisibility(8);
    }
    AppMethodBeat.o(41920);
  }
  
  private void ir(boolean paramBoolean)
  {
    AppMethodBeat.i(41921);
    if ((paramBoolean) && (!this.nIR.isShown()))
    {
      String str = ae.dSz() + e.a(new StringBuilder().append(this.nIs).toString(), "100", 2, RoundingMode.HALF_UP);
      this.nIR.setText(getString(2131300685, new Object[] { str }));
      this.nIR.startAnimation(AnimationUtils.loadAnimation(this, 2131034194));
      this.nIR.setVisibility(0);
      AppMethodBeat.o(41921);
      return;
    }
    if ((!paramBoolean) && (this.nIR.isShown()))
    {
      this.nIR.startAnimation(AnimationUtils.loadAnimation(this, 2131034214));
      this.nIR.setVisibility(8);
    }
    AppMethodBeat.o(41921);
  }
  
  private void is(boolean paramBoolean)
  {
    AppMethodBeat.i(41922);
    this.nJm.setEnabled(paramBoolean);
    AppMethodBeat.o(41922);
  }
  
  public int getLayoutId()
  {
    return 2130969873;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41917);
    this.nJl = ((WalletFormView)findViewById(2131825059));
    this.nJm = ((Button)findViewById(2131825060));
    this.nIR = ((TextView)findViewById(2131825061));
    this.nJl.dSY();
    this.nJl.getTitleTv().setText(ae.dSz());
    setEditFocusListener(this.nJl, 2, false);
    this.nJl.a(new HoneyPayModifyQuotaUI.1(this));
    this.nJm.setOnClickListener(new HoneyPayModifyQuotaUI.2(this));
    this.nJl.postDelayed(new HoneyPayModifyQuotaUI.3(this), 100L);
    AppMethodBeat.o(41917);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41919);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent.getBooleanExtra("key_modify_create_line_succ", false)))
    {
      setResult(-1, paramIntent);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(41919);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41916);
    super.onCreate(paramBundle);
    this.nIs = getIntent().getLongExtra("key_max_credit_line", 0L);
    this.nIt = getIntent().getLongExtra("key_min_credit_line", 0L);
    this.nHE = getIntent().getStringExtra("key_card_no");
    initView();
    setMMTitle(2131300690);
    AppMethodBeat.o(41916);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41918);
    super.onDestroy();
    AppMethodBeat.o(41918);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI
 * JD-Core Version:    0.7.0.1
 */