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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.aa;

public class LaunchAAByPersonNameAmountRow
  extends LinearLayout
{
  private TextView hXv;
  private TextView jUP;
  private View jWr;
  
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
    aa.jQ(paramContext).inflate(2131495157, this, true);
    this.hXv = ((TextView)findViewById(2131309651));
    this.jUP = ((TextView)findViewById(2131296732));
    this.jWr = findViewById(2131299682);
    AppMethodBeat.o(63618);
  }
  
  public final void a(String paramString1, String paramString2, double paramDouble)
  {
    AppMethodBeat.i(63619);
    this.hXv.setText(l.b(getContext(), ((b)g.af(b.class)).getDisplayName(paramString1, paramString2), this.hXv.getTextSize()));
    this.jUP.setText(getContext().getString(2131755023, new Object[] { Double.valueOf(paramDouble) }));
    AppMethodBeat.o(63619);
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(63620);
    View localView = this.jWr;
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