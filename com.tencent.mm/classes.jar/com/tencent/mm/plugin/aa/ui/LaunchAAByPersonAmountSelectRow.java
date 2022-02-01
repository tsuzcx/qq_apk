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
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow
  extends LinearLayout
{
  private ImageView fRd;
  private TextView hbU;
  private WalletFormView iVS;
  private View iVT;
  private TextWatcher iVU;
  private String username;
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63580);
    this.iVU = null;
    init(paramContext);
    AppMethodBeat.o(63580);
  }
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63581);
    this.iVU = null;
    init(paramContext);
    AppMethodBeat.o(63581);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(63582);
    z.jO(paramContext).inflate(2131494546, this, true);
    this.fRd = ((ImageView)findViewById(2131296996));
    this.hbU = ((TextView)findViewById(2131306252));
    this.iVS = ((WalletFormView)findViewById(2131302444));
    this.iVT = findViewById(2131299154);
    AppMethodBeat.o(63582);
  }
  
  public double getAmount()
  {
    AppMethodBeat.i(63584);
    String str = this.iVS.getText().toString();
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
    return this.iVS;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(63585);
    View localView = this.iVT;
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
    this.iVU = paramTextWatcher;
    this.iVS.a(paramTextWatcher);
    AppMethodBeat.o(63583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectRow
 * JD-Core Version:    0.7.0.1
 */