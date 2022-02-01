package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.p;

public final class q
{
  public static p a(Context paramContext, View paramView, String[] paramArrayOfString, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(128472);
    View localView = View.inflate(paramContext, 2131495943, null);
    HorizontalListView localHorizontalListView = (HorizontalListView)localView.findViewById(2131308759);
    paramArrayOfString = new b(paramContext, paramArrayOfString);
    localHorizontalListView.setAdapter(paramArrayOfString);
    localHorizontalListView.setOnItemClickListener(paramOnItemClickListener);
    localHorizontalListView.setBackgroundResource(2131234904);
    paramOnItemClickListener = new p(localView);
    paramOnItemClickListener.setHeight(a.fromDPToPix(paramContext, 120));
    int i = 0;
    int j = 0;
    while (i < paramArrayOfString.getCount())
    {
      localView = paramArrayOfString.getView(i, null, localHorizontalListView);
      localView.measure(0, 0);
      j += localView.getMeasuredWidth();
      i += 1;
    }
    paramOnItemClickListener.setWidth(a.fromDPToPix(paramContext, 20) + j);
    paramOnItemClickListener.showAsDropDown(paramView, (paramView.getWidth() - (a.fromDPToPix(paramContext, 20) + j)) / 2, 0);
    AppMethodBeat.o(128472);
    return paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.q
 * JD-Core Version:    0.7.0.1
 */