package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.kinda.gen.KOnePxLineView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMKOnePxLineView
  extends MMKView<LinearLayout>
  implements KOnePxLineView
{
  private static final String TAG = "MMKOnePxLineView";
  private View mOnePxView;
  private float mOnePxViewHeight;
  private float mOnePxViewWidth;
  
  private void updateOrientation()
  {
    AppMethodBeat.i(144936);
    ab.d("MMKOnePxLineView", "updateOrientation，更新分隔线方向前，本控件宽度：" + this.mOnePxViewWidth + "，高度：" + this.mOnePxViewHeight);
    if (this.mOnePxViewWidth >= this.mOnePxViewHeight) {
      ab.d("MMKOnePxLineView", "updateOrientation，分隔线为横向");
    }
    for (LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);; localLayoutParams = new LinearLayout.LayoutParams(1, -1))
    {
      this.mOnePxView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(144936);
      return;
      ab.d("MMKOnePxLineView", "updateOrientation，分隔线为纵向");
    }
  }
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(144933);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    this.mOnePxView = new View(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, 1);
    this.mOnePxViewWidth = -1.0F;
    this.mOnePxViewHeight = 1.0F;
    localLinearLayout.addView(this.mOnePxView, paramContext);
    AppMethodBeat.o(144933);
    return localLinearLayout;
  }
  
  public void setHeight(float paramFloat)
  {
    AppMethodBeat.i(144934);
    super.setHeight(paramFloat);
    this.mOnePxViewHeight = paramFloat;
    updateOrientation();
    AppMethodBeat.o(144934);
  }
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(144935);
    super.setWidth(paramFloat);
    this.mOnePxViewWidth = paramFloat;
    updateOrientation();
    AppMethodBeat.o(144935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKOnePxLineView
 * JD-Core Version:    0.7.0.1
 */