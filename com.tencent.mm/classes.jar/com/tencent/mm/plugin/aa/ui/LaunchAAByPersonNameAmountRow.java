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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.ad;

public class LaunchAAByPersonNameAmountRow
  extends LinearLayout
{
  private TextView kMa;
  private TextView mMc;
  private View mND;
  
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
    ad.kS(paramContext).inflate(a.g.launch_aa_by_person_name_amount_row, this, true);
    this.kMa = ((TextView)findViewById(a.f.username));
    this.mMc = ((TextView)findViewById(a.f.amount));
    this.mND = findViewById(a.f.divider);
    AppMethodBeat.o(63618);
  }
  
  public final void a(String paramString1, String paramString2, double paramDouble)
  {
    AppMethodBeat.i(63619);
    this.kMa.setText(l.b(getContext(), ((b)h.ae(b.class)).aL(paramString1, paramString2), this.kMa.getTextSize()));
    this.mMc.setText(getContext().getString(a.i.aa_amount_format_row, new Object[] { Double.valueOf(paramDouble) }));
    AppMethodBeat.o(63619);
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(63620);
    View localView = this.mND;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(63620);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonNameAmountRow
 * JD-Core Version:    0.7.0.1
 */