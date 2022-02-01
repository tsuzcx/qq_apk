package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.af;

public class LaunchAAByPersonNameAmountRow
  extends LinearLayout
{
  private TextView nnW;
  private TextView pIK;
  private View pKl;
  
  public LaunchAAByPersonNameAmountRow(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63615);
    init(paramContext);
    AppMethodBeat.o(63615);
  }
  
  public LaunchAAByPersonNameAmountRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63616);
    init(paramContext);
    AppMethodBeat.o(63616);
  }
  
  public LaunchAAByPersonNameAmountRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63617);
    init(paramContext);
    AppMethodBeat.o(63617);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(63618);
    af.mU(paramContext).inflate(a.g.launch_aa_by_person_name_amount_row, this, true);
    this.nnW = ((TextView)findViewById(a.f.username));
    this.pIK = ((TextView)findViewById(a.f.amount));
    this.pKl = findViewById(a.f.divider);
    AppMethodBeat.o(63618);
  }
  
  public final void a(String paramString1, String paramString2, double paramDouble)
  {
    AppMethodBeat.i(63619);
    this.nnW.setText(p.b(getContext(), ((b)h.ax(b.class)).aV(paramString1, paramString2), this.nnW.getTextSize()));
    this.pIK.setText(getContext().getString(a.i.aa_amount_format_row, new Object[] { Double.valueOf(paramDouble) }));
    AppMethodBeat.o(63619);
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(63620);
    View localView = this.pKl;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(63620);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonNameAmountRow
 * JD-Core Version:    0.7.0.1
 */