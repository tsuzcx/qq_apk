package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow
  extends LinearLayout
{
  private ImageView pKM;
  private TextView pKN;
  private TextView pKO;
  private WalletFormView pKP;
  private TextView pKQ;
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
    inflate(getContext(), a.g.launch_aa_by_person_row, this);
    this.pKM = ((ImageView)findViewById(a.f.aa_avatar));
    this.pKN = ((TextView)findViewById(a.f.aa_username));
    this.pKP = ((WalletFormView)findViewById(a.f.launch_aa_by_person_money_edit));
    this.pKO = ((TextView)findViewById(a.f.launch_aa_by_person_money_unit));
    this.pKQ = ((TextView)findViewById(a.f.my_self_note));
    AppMethodBeat.o(63624);
  }
  
  public WalletFormView getAmountEditView()
  {
    return this.pKP;
  }
  
  public double getMoneyAmount()
  {
    AppMethodBeat.i(63625);
    String str = this.pKP.getText().toString();
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
      this.pKP.a(paramTextWatcher);
    }
    AppMethodBeat.o(63626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonRow
 * JD-Core Version:    0.7.0.1
 */