package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow
  extends LinearLayout
{
  private ImageView fTj;
  private TextView heI;
  private WalletFormView iYL;
  private View iYM;
  private TextWatcher iYN;
  private String username;
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63580);
    this.iYN = null;
    init(paramContext);
    AppMethodBeat.o(63580);
  }
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63581);
    this.iYN = null;
    init(paramContext);
    AppMethodBeat.o(63581);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(63582);
    z.jV(paramContext).inflate(2131494546, this, true);
    this.fTj = ((ImageView)findViewById(2131296996));
    this.heI = ((TextView)findViewById(2131306252));
    this.iYL = ((WalletFormView)findViewById(2131302444));
    this.iYM = findViewById(2131299154);
    AppMethodBeat.o(63582);
  }
  
  public double getAmount()
  {
    AppMethodBeat.i(63584);
    String str = this.iYL.getText().toString();
    if ((bu.isNullOrNil(str)) || ("".equals(str)))
    {
      AppMethodBeat.o(63584);
      return 0.0D;
    }
    double d = bu.getDouble(str, 0.0D);
    AppMethodBeat.o(63584);
    return d;
  }
  
  public WalletFormView getMoneyEdit()
  {
    return this.iYL;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(63585);
    View localView = this.iYM;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(63585);
      return;
    }
  }
  
  public void setTextWatcher(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(63583);
    this.iYN = paramTextWatcher;
    this.iYL.a(paramTextWatcher);
    AppMethodBeat.o(63583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectRow
 * JD-Core Version:    0.7.0.1
 */