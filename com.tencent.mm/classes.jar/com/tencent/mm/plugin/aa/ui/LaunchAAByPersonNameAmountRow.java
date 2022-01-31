package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.w;

public class LaunchAAByPersonNameAmountRow
  extends LinearLayout
{
  TextView gpq;
  TextView gqe;
  private View gqg;
  
  public LaunchAAByPersonNameAmountRow(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(40814);
    init(paramContext);
    AppMethodBeat.o(40814);
  }
  
  public LaunchAAByPersonNameAmountRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40815);
    init(paramContext);
    AppMethodBeat.o(40815);
  }
  
  public LaunchAAByPersonNameAmountRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40816);
    init(paramContext);
    AppMethodBeat.o(40816);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(40817);
    w.hM(paramContext).inflate(2130969966, this, true);
    this.gqe = ((TextView)findViewById(2131821594));
    this.gpq = ((TextView)findViewById(2131825373));
    this.gqg = findViewById(2131821148);
    AppMethodBeat.o(40817);
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(40818);
    View localView = this.gqg;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(40818);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonNameAmountRow
 * JD-Core Version:    0.7.0.1
 */