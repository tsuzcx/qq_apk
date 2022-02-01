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
  private final TextView Xm;
  private final WindowManager.LayoutParams azK = new WindowManager.LayoutParams();
  private final Rect azL = new Rect();
  private final int[] azM = new int[2];
  private final int[] azN = new int[2];
  private final View mContentView;
  private final Context mContext;
  
  bd(Context paramContext)
  {
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131492918, null);
    this.Xm = ((TextView)this.mContentView.findViewById(2131302253));
    this.azK.setTitle(getClass().getSimpleName());
    this.azK.packageName = this.mContext.getPackageName();
    this.azK.type = 1002;
    this.azK.width = -2;
    this.azK.height = -2;
    this.azK.format = -3;
    this.azK.windowAnimations = 2131820554;
    this.azK.flags = 24;
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
    ((View)localObject1).getWindowVisibleDisplayFrame(this.azL);
    Object localObject2;
    if ((this.azL.left < 0) && (this.azL.top < 0))
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
      this.azL.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      ((View)localObject1).getLocationOnScreen(this.azN);
      paramView.getLocationOnScreen(this.azM);
      paramView = this.azM;
      paramView[0] -= this.azN[0];
      paramView = this.azM;
      paramView[1] -= this.azN[1];
      paramLayoutParams.x = (this.azM[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mContentView.measure(paramInt1, paramInt1);
      paramInt1 = this.mContentView.getMeasuredHeight();
      i = i + this.azM[1] - k - paramInt1;
      paramInt2 = paramInt2 + this.azM[1] + k;
      if (!paramBoolean) {
        break;
      }
      if (i >= 0) {
        break label401;
      }
      paramLayoutParams.y = paramInt2;
      return;
    }
    if (paramInt1 + paramInt2 <= this.azL.height())
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
    this.Xm.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.azK);
    ((WindowManager)this.mContext.getSystemService("window")).addView(this.mContentView, this.azK);
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