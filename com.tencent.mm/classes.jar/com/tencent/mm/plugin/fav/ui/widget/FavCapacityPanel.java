package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;

public class FavCapacityPanel
  extends LinearLayout
{
  private View.OnClickListener bTw;
  private LinearLayout mDJ;
  public long mDK;
  public TextView mDL;
  public int mDM;
  public long mDN;
  
  public FavCapacityPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74664);
    this.mDM = 0;
    this.bTw = new FavCapacityPanel.1(this);
    this.mDJ = this;
    paramContext = View.inflate(getContext(), 2130969561, null);
    paramContext.measure(-2, -2);
    paramAttributeSet = paramContext.findViewById(2131824090);
    View localView = paramContext.findViewById(2131824091);
    this.mDL = ((TextView)paramContext.findViewById(2131824092));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAttributeSet.getLayoutParams();
    localLayoutParams.width = paramContext.getMeasuredWidth();
    paramAttributeSet.setLayoutParams(localLayoutParams);
    localView.setOnClickListener(this.bTw);
    paramAttributeSet = new LinearLayout.LayoutParams(0, -2);
    paramAttributeSet.weight = 1.0F;
    this.mDJ.addView(paramContext, paramAttributeSet);
    this.mDK = (b.bvZ() / 1048576L);
    this.mDN = (b.bwa() / 1048576L);
    paramContext = this.mDL;
    paramAttributeSet = this.mDL.getContext();
    if (this.mDN - this.mDK > 0L) {}
    for (long l = this.mDN - this.mDK;; l = 0L)
    {
      paramContext.setText(paramAttributeSet.getString(2131299661, new Object[] { Long.valueOf(l), Long.valueOf(this.mDK) }));
      AppMethodBeat.o(74664);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel
 * JD-Core Version:    0.7.0.1
 */