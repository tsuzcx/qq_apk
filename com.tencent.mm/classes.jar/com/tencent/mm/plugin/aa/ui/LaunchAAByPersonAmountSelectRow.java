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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow
  extends LinearLayout
{
  private ImageView gyr;
  private TextView hXv;
  private WalletFormView jWq;
  private View jWr;
  private TextWatcher jWs;
  private String username;
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63580);
    this.jWs = null;
    init(paramContext);
    AppMethodBeat.o(63580);
  }
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63581);
    this.jWs = null;
    init(paramContext);
    AppMethodBeat.o(63581);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(63582);
    aa.jQ(paramContext).inflate(2131495155, this, true);
    this.gyr = ((ImageView)findViewById(2131297119));
    this.hXv = ((TextView)findViewById(2131309651));
    this.jWq = ((WalletFormView)findViewById(2131304845));
    this.jWr = findViewById(2131299682);
    AppMethodBeat.o(63582);
  }
  
  public double getAmount()
  {
    AppMethodBeat.i(63584);
    String str = this.jWq.getText().toString();
    if ((Util.isNullOrNil(str)) || ("".equals(str)))
    {
      AppMethodBeat.o(63584);
      return 0.0D;
    }
    double d = Util.getDouble(str, 0.0D);
    AppMethodBeat.o(63584);
    return d;
  }
  
  public WalletFormView getMoneyEdit()
  {
    return this.jWq;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(63585);
    View localView = this.jWr;
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
    this.jWs = paramTextWatcher;
    this.jWq.a(paramTextWatcher);
    AppMethodBeat.o(63583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectRow
 * JD-Core Version:    0.7.0.1
 */