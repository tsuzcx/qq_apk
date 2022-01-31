package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;

public class LaunchAAByPersonNameAmountRow
  extends LinearLayout
{
  TextView eXt;
  TextView eYn;
  private View eYp;
  
  public LaunchAAByPersonNameAmountRow(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public LaunchAAByPersonNameAmountRow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public LaunchAAByPersonNameAmountRow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    y.gt(paramContext).inflate(a.g.launch_aa_by_person_name_amount_row, this, true);
    this.eYn = ((TextView)findViewById(a.f.username));
    this.eXt = ((TextView)findViewById(a.f.amount));
    this.eYp = findViewById(a.f.divider);
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    View localView = this.eYp;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonNameAmountRow
 * JD-Core Version:    0.7.0.1
 */