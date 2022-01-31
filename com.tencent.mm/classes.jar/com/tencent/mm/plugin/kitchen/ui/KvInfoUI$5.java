package com.tencent.mm.plugin.kitchen.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.d;

final class KvInfoUI$5
  extends ArrayAdapter
{
  KvInfoUI$5(KvInfoUI paramKvInfoUI, Context paramContext)
  {
    super(paramContext, 2130969961, 2131825347);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(114445);
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (d)KvInfoUI.b(this.nXL).getItem(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131825347);
    if ((paramViewGroup != null) && (paramViewGroup.qsA)) {
      localTextView.setBackgroundResource(2131690701);
    }
    for (;;)
    {
      AppMethodBeat.o(114445);
      return paramView;
      localTextView.setBackgroundResource(2131690605);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.5
 * JD-Core Version:    0.7.0.1
 */