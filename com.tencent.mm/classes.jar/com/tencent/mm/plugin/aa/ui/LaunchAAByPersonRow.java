package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow
  extends LinearLayout
{
  private ImageView eYO;
  private TextView eYP;
  private TextView eYQ;
  private WalletFormView eYR;
  private TextView eYS;
  private String username;
  
  public LaunchAAByPersonRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LaunchAAByPersonRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    inflate(getContext(), a.g.launch_aa_by_person_row, this);
    this.eYO = ((ImageView)findViewById(a.f.aa_avatar));
    this.eYP = ((TextView)findViewById(a.f.aa_username));
    this.eYR = ((WalletFormView)findViewById(a.f.launch_aa_by_person_money_edit));
    this.eYQ = ((TextView)findViewById(a.f.launch_aa_by_person_money_unit));
    this.eYS = ((TextView)findViewById(a.f.my_self_note));
  }
  
  public WalletFormView getAmountEditView()
  {
    return this.eYR;
  }
  
  public double getMoneyAmount()
  {
    String str = this.eYR.getText().toString();
    if ((bk.bl(str)) || ("".equals(str))) {
      return 0.0D;
    }
    return bk.getDouble(str, 0.0D);
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setAmountTextChangeWatcher(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null) {
      this.eYR.a(paramTextWatcher);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonRow
 * JD-Core Version:    0.7.0.1
 */