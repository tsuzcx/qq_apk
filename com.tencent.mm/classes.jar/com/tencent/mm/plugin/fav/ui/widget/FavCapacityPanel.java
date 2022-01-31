package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.i;

public class FavCapacityPanel
  extends LinearLayout
{
  private View.OnClickListener kdc = new FavCapacityPanel.1(this);
  private LinearLayout kjd = this;
  public long kje;
  public TextView kjf;
  public int kjg = 0;
  public long kjh;
  
  public FavCapacityPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = View.inflate(getContext(), n.f.fav_tag_panel_footview, null);
    paramContext.measure(-2, -2);
    paramAttributeSet = paramContext.findViewById(n.e.fav_capacity_foot_line);
    View localView = paramContext.findViewById(n.e.fav_capacity_foot_linear);
    this.kjf = ((TextView)paramContext.findViewById(n.e.fav_capacity_foot_desc));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAttributeSet.getLayoutParams();
    localLayoutParams.width = paramContext.getMeasuredWidth();
    paramAttributeSet.setLayoutParams(localLayoutParams);
    localView.setOnClickListener(this.kdc);
    paramAttributeSet = new LinearLayout.LayoutParams(0, -2);
    paramAttributeSet.weight = 1.0F;
    this.kjd.addView(paramContext, paramAttributeSet);
    this.kje = (b.aPL() / 1048576L);
    this.kjh = (b.aPM() / 1048576L);
    paramContext = this.kjf;
    paramAttributeSet = this.kjf.getContext();
    int i = n.i.fav_capacity_info;
    if (this.kjh - this.kje > 0L) {}
    for (long l = this.kjh - this.kje;; l = 0L)
    {
      paramContext.setText(paramAttributeSet.getString(i, new Object[] { Long.valueOf(l), Long.valueOf(this.kje) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel
 * JD-Core Version:    0.7.0.1
 */