package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow
  extends LinearLayout
{
  private ImageView jWS;
  private TextView jWT;
  private TextView jWU;
  private WalletFormView jWV;
  private TextView jWW;
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
    inflate(getContext(), 2131495158, this);
    this.jWS = ((ImageView)findViewById(2131296289));
    this.jWT = ((TextView)findViewById(2131296315));
    this.jWV = ((WalletFormView)findViewById(2131303021));
    this.jWU = ((TextView)findViewById(2131303022));
    this.jWW = ((TextView)findViewById(2131305206));
    AppMethodBeat.o(63624);
  }
  
  public WalletFormView getAmountEditView()
  {
    return this.jWV;
  }
  
  public double getMoneyAmount()
  {
    AppMethodBeat.i(63625);
    String str = this.jWV.getText().toString();
    if ((Util.isNullOrNil(str)) || ("".equals(str)))
    {
      AppMethodBeat.o(63625);
      return 0.0D;
    }
    double d = Util.getDouble(str, 0.0D);
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
      this.jWV.a(paramTextWatcher);
    }
    AppMethodBeat.o(63626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonRow
 * JD-Core Version:    0.7.0.1
 */