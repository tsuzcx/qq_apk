package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow
  extends LinearLayout
{
  private ImageView dpY;
  private TextView eYn;
  private WalletFormView eYo;
  private View eYp;
  private TextWatcher eYq = null;
  private String username;
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    y.gt(paramContext).inflate(a.g.launch_aa_by_person_amount_select_row, this, true);
    this.dpY = ((ImageView)findViewById(a.f.avatar));
    this.eYn = ((TextView)findViewById(a.f.username));
    this.eYo = ((WalletFormView)findViewById(a.f.money_edit));
    this.eYp = findViewById(a.f.divider);
  }
  
  public double getAmount()
  {
    String str = this.eYo.getText().toString();
    if ((bk.bl(str)) || ("".equals(str))) {
      return 0.0D;
    }
    return bk.getDouble(str, 0.0D);
  }
  
  public WalletFormView getMoneyEdit()
  {
    return this.eYo;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    View localView = this.eYp;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setTextWatcher(TextWatcher paramTextWatcher)
  {
    this.eYq = paramTextWatcher;
    this.eYo.a(paramTextWatcher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectRow
 * JD-Core Version:    0.7.0.1
 */