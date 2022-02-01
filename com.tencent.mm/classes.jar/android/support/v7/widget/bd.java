package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

final class bd
{
  private final TextView Vx;
  private final WindowManager.LayoutParams axT = new WindowManager.LayoutParams();
  private final Rect axU = new Rect();
  private final int[] axV = new int[2];
  private final int[] axW = new int[2];
  private final View mContentView;
  private final Context mContext;
  
  bd(Context paramContext)
  {
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131492918, null);
    this.Vx = ((TextView)this.mContentView.findViewById(2131302253));
    this.axT.setTitle(getClass().getSimpleName());
    this.axT.packageName = this.mContext.getPackageName();
    this.axT.type = 1002;
    this.axT.width = -2;
    this.axT.height = -2;
    this.axT.format = -3;
    this.axT.windowAnimations = 2131820554;
    this.axT.flags = 24;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.token = paramView.getApplicationWindowToken();
    int i = this.mContext.getResources().getDimensionPixelOffset(2131166924);
    if (paramView.getWidth() < i) {
      paramInt1 = paramView.getWidth() / 2;
    }
    Object localObject1;
    if (paramView.getHeight() >= i)
    {
      i = this.mContext.getResources().getDimensionPixelOffset(2131166923);
      j = paramInt2 + i;
      i = paramInt2 - i;
      paramInt2 = j;
      paramLayoutParams.gravity = 49;
      localObject1 = this.mContext.getResources();
      if (!paramBoolean) {
        break label134;
      }
    }
    int k;
    label134:
    for (int j = 2131166927;; j = 2131166926)
    {
      k = ((Resources)localObject1).getDimensionPixelOffset(j);
      localObject1 = ce(paramView);
      if (localObject1 != null) {
        break label141;
      }
      return;
      paramInt2 = paramView.getHeight();
      i = 0;
      break;
    }
    label141:
    ((View)localObject1).getWindowVisibleDisplayFrame(this.axU);
    Object localObject2;
    if ((this.axU.left < 0) && (this.axU.top < 0))
    {
      localObject2 = this.mContext.getResources();
      j = ((Resources)localObject2).getIdentifier("status_bar_height", "dimen", "android");
      if (j == 0) {
        break label375;
      }
    }
    label375:
    for (j = ((Resources)localObject2).getDimensionPixelSize(j);; j = 0)
    {
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      this.axU.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      ((View)localObject1).getLocationOnScreen(this.axW);
      paramView.getLocationOnScreen(this.axV);
      paramView = this.axV;
      paramView[0] -= this.axW[0];
      paramView = this.axV;
      paramView[1] -= this.axW[1];
      paramLayoutParams.x = (this.axV[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mContentView.measure(paramInt1, paramInt1);
      paramInt1 = this.mContentView.getMeasuredHeight();
      i = i + this.axV[1] - k - paramInt1;
      paramInt2 = paramInt2 + this.axV[1] + k;
      if (!paramBoolean) {
        break;
      }
      if (i >= 0) {
        break label401;
      }
      paramLayoutParams.y = paramInt2;
      return;
    }
    if (paramInt1 + paramInt2 <= this.axU.height())
    {
      paramLayoutParams.y = paramInt2;
      return;
    }
    label401:
    paramLayoutParams.y = i;
  }
  
  private static View ce(View paramView)
  {
    View localView = paramView.getRootView();
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (((localLayoutParams instanceof WindowManager.LayoutParams)) && (((WindowManager.LayoutParams)localLayoutParams).type == 2)) {
      return localView;
    }
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity)) {
        return ((Activity)paramView).getWindow().getDecorView();
      }
    }
    return localView;
  }
  
  private boolean isShowing()
  {
    return this.mContentView.getParent() != null;
  }
  
  final void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (isShowing()) {
      hide();
    }
    this.Vx.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.axT);
    ((WindowManager)this.mContext.getSystemService("window")).addView(this.mContentView, this.axT);
  }
  
  final void hide()
  {
    if (!isShowing()) {
      return;
    }
    ((WindowManager)this.mContext.getSystemService("window")).removeView(this.mContentView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bd
 * JD-Core Version:    0.7.0.1
 */