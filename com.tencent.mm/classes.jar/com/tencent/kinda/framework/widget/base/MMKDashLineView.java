package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.kinda.framework.R.drawable;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.layout;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KDashLineView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;

public class MMKDashLineView
  extends MMKView<LinearLayout>
  implements KDashLineView
{
  private LinearLayout contentView;
  private boolean isVertical;
  private DynamicColor mDashColor;
  private float mDashWidth;
  private View mLine;
  
  public MMKDashLineView()
  {
    AppMethodBeat.i(170120);
    this.isVertical = false;
    this.mDashColor = new DynamicColor(-1L, 0L);
    this.mDashWidth = aw.fromDPToPix(this.mContext, 2);
    AppMethodBeat.o(170120);
  }
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(19013);
    this.contentView = ((LinearLayout)View.inflate(paramContext, R.layout.kinda_dash_line_view, null));
    paramContext = this.contentView;
    AppMethodBeat.o(19013);
    return paramContext;
  }
  
  public DynamicColor getDashColor()
  {
    return this.mDashColor;
  }
  
  public float getDashWidth()
  {
    return this.mDashWidth;
  }
  
  public boolean getVertical()
  {
    return this.isVertical;
  }
  
  public void setDashColor(DynamicColor paramDynamicColor)
  {
    this.mDashColor = paramDynamicColor;
  }
  
  public void setDashWidth(float paramFloat)
  {
    this.mDashWidth = paramFloat;
  }
  
  public void setVertical(boolean paramBoolean)
  {
    AppMethodBeat.i(170121);
    this.isVertical = paramBoolean;
    if (this.isVertical)
    {
      Object localObject = new LinearLayout.LayoutParams(-2, -1);
      this.contentView.setGravity(17);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mLine = this.contentView.findViewById(R.id.order_info_tinyapp_splitter_1);
      localObject = this.mLine.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = aw.fromDPToPix(this.mContext, 60);
      ((ViewGroup.LayoutParams)localObject).height = aw.fromDPToPix(this.mContext, 60);
      this.mLine.setBackground(this.mContext.getResources().getDrawable(R.drawable.bank_remit_detail_state_line_succ));
      this.mLine.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(170121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKDashLineView
 * JD-Core Version:    0.7.0.1
 */