package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow
  extends LinearLayout
{
  private ImageView iWu;
  private TextView iWv;
  private TextView iWw;
  private WalletFormView iWx;
  private TextView iWy;
  private String username;
  
  public LaunchAAByPersonRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63622);
    init();
    AppMethodBeat.o(63622);
  }
  
  public LaunchAAByPersonRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63623);
    init();
    AppMethodBeat.o(63623);
  }
  
  private void init()
  {
    AppMethodBeat.i(63624);
    inflate(getContext(), 2131494549, this);
    this.iWu = ((ImageView)findViewById(2131296288));
    this.iWv = ((TextView)findViewById(2131296302));
    this.iWx = ((WalletFormView)findViewById(2131301321));
    this.iWw = ((TextView)findViewById(2131301322));
    this.iWy = ((TextView)findViewById(2131302652));
    AppMethodBeat.o(63624);
  }
  
  public WalletFormView getAmountEditView()
  {
    return this.iWx;
  }
  
  public double getMoneyAmount()
  {
    AppMethodBeat.i(63625);
    String str = this.iWx.getText().toString();
    if ((bt.isNullOrNil(str)) || ("".equals(str)))
    {
      AppMethodBeat.o(63625);
      return 0.0D;
    }
    double d = bt.getDouble(str, 0.0D);
    AppMethodBeat.o(63625);
    return d;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setAmountTextChangeWatcher(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(63626);
    if (paramTextWatcher != null) {
      this.iWx.a(paramTextWatcher);
    }
    AppMethodBeat.o(63626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonRow
 * JD-Core Version:    0.7.0.1
 */