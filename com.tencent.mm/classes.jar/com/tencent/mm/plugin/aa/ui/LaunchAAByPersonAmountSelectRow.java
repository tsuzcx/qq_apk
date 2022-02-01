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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow
  extends LinearLayout
{
  private ImageView fuj;
  private WalletFormView icA;
  private View icB;
  private TextWatcher icC;
  private TextView icz;
  private String username;
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63580);
    this.icC = null;
    init(paramContext);
    AppMethodBeat.o(63580);
  }
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63581);
    this.icC = null;
    init(paramContext);
    AppMethodBeat.o(63581);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(63582);
    y.js(paramContext).inflate(2131494546, this, true);
    this.fuj = ((ImageView)findViewById(2131296996));
    this.icz = ((TextView)findViewById(2131306252));
    this.icA = ((WalletFormView)findViewById(2131302444));
    this.icB = findViewById(2131299154);
    AppMethodBeat.o(63582);
  }
  
  public double getAmount()
  {
    AppMethodBeat.i(63584);
    String str = this.icA.getText().toString();
    if ((bt.isNullOrNil(str)) || ("".equals(str)))
    {
      AppMethodBeat.o(63584);
      return 0.0D;
    }
    double d = bt.getDouble(str, 0.0D);
    AppMethodBeat.o(63584);
    return d;
  }
  
  public WalletFormView getMoneyEdit()
  {
    return this.icA;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(63585);
    View localView = this.icB;
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
    this.icC = paramTextWatcher;
    this.icA.a(paramTextWatcher);
    AppMethodBeat.o(63583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectRow
 * JD-Core Version:    0.7.0.1
 */