package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow
  extends LinearLayout
{
  private ImageView gqF;
  private TextView gqG;
  private TextView gqH;
  private WalletFormView gqI;
  private TextView gqJ;
  private String username;
  
  public LaunchAAByPersonRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40819);
    init();
    AppMethodBeat.o(40819);
  }
  
  public LaunchAAByPersonRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40820);
    init();
    AppMethodBeat.o(40820);
  }
  
  private void init()
  {
    AppMethodBeat.i(40821);
    inflate(getContext(), 2130969967, this);
    this.gqF = ((ImageView)findViewById(2131825374));
    this.gqG = ((TextView)findViewById(2131825375));
    this.gqI = ((WalletFormView)findViewById(2131825377));
    this.gqH = ((TextView)findViewById(2131825367));
    this.gqJ = ((TextView)findViewById(2131825376));
    AppMethodBeat.o(40821);
  }
  
  public WalletFormView getAmountEditView()
  {
    return this.gqI;
  }
  
  public double getMoneyAmount()
  {
    AppMethodBeat.i(40822);
    String str = this.gqI.getText().toString();
    if ((bo.isNullOrNil(str)) || ("".equals(str)))
    {
      AppMethodBeat.o(40822);
      return 0.0D;
    }
    double d = bo.getDouble(str, 0.0D);
    AppMethodBeat.o(40822);
    return d;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setAmountTextChangeWatcher(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(40823);
    if (paramTextWatcher != null) {
      this.gqI.a(paramTextWatcher);
    }
    AppMethodBeat.o(40823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonRow
 * JD-Core Version:    0.7.0.1
 */