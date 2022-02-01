package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.ui.z;

public class LaunchAAByPersonNameAmountRow
  extends LinearLayout
{
  private TextView heI;
  private TextView iXQ;
  private View iYM;
  
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
    z.jV(paramContext).inflate(2131494548, this, true);
    this.heI = ((TextView)findViewById(2131306252));
    this.iXQ = ((TextView)findViewById(2131296655));
    this.iYM = findViewById(2131299154);
    AppMethodBeat.o(63618);
  }
  
  public final void a(String paramString1, String paramString2, double paramDouble)
  {
    AppMethodBeat.i(63619);
    this.heI.setText(k.b(getContext(), ((b)g.ab(b.class)).getDisplayName(paramString1, paramString2), this.heI.getTextSize()));
    this.iXQ.setText(getContext().getString(2131755021, new Object[] { Double.valueOf(paramDouble) }));
    AppMethodBeat.o(63619);
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(63620);
    View localView = this.iYM;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(63620);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonNameAmountRow
 * JD-Core Version:    0.7.0.1
 */