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
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow
  extends LinearLayout
{
  private ImageView ehv;
  private TextView gqe;
  private WalletFormView gqf;
  private View gqg;
  private TextWatcher gqh;
  private String username;
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40780);
    this.gqh = null;
    init(paramContext);
    AppMethodBeat.o(40780);
  }
  
  public LaunchAAByPersonAmountSelectRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40781);
    this.gqh = null;
    init(paramContext);
    AppMethodBeat.o(40781);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(40782);
    w.hM(paramContext).inflate(2130969964, this, true);
    this.ehv = ((ImageView)findViewById(2131823820));
    this.gqe = ((TextView)findViewById(2131821594));
    this.gqf = ((WalletFormView)findViewById(2131825366));
    this.gqg = findViewById(2131821148);
    AppMethodBeat.o(40782);
  }
  
  public double getAmount()
  {
    AppMethodBeat.i(40784);
    String str = this.gqf.getText().toString();
    if ((bo.isNullOrNil(str)) || ("".equals(str)))
    {
      AppMethodBeat.o(40784);
      return 0.0D;
    }
    double d = bo.getDouble(str, 0.0D);
    AppMethodBeat.o(40784);
    return d;
  }
  
  public WalletFormView getMoneyEdit()
  {
    return this.gqf;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(40785);
    View localView = this.gqg;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(40785);
      return;
    }
  }
  
  public void setTextWatcher(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(40783);
    this.gqh = paramTextWatcher;
    this.gqf.a(paramTextWatcher);
    AppMethodBeat.o(40783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectRow
 * JD-Core Version:    0.7.0.1
 */