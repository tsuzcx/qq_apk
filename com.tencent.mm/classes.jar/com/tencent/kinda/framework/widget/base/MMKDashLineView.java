package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.kinda.gen.KDashLineView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKDashLineView
  extends MMKView<LinearLayout>
  implements KDashLineView
{
  private LinearLayout contentView;
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(144861);
    this.contentView = ((LinearLayout)View.inflate(paramContext, 2130969953, null));
    paramContext = this.contentView;
    AppMethodBeat.o(144861);
    return paramContext;
  }
  
  public long getDashColor()
  {
    return 0L;
  }
  
  public float getDashWidth()
  {
    return 0.0F;
  }
  
  public void setDashColor(long paramLong) {}
  
  public void setDashWidth(float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKDashLineView
 * JD-Core Version:    0.7.0.1
 */