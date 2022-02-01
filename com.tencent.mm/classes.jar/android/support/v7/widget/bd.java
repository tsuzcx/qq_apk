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
  private final TextView UB;
  private final WindowManager.LayoutParams awZ = new WindowManager.LayoutParams();
  private final Rect axa = new Rect();
  private final int[] axb = new int[2];
  private final int[] axc = new int[2];
  private final View mContentView;
  private final Context mContext;
  
  bd(Context paramContext)
  {
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131492918, null);
    this.UB = ((TextView)this.mContentView.findViewById(2131302253));
    this.awZ.setTitle(getClass().getSimpleName());
    this.awZ.packageName = this.mContext.getPackageName();
    this.awZ.type = 1002;
    this.awZ.width = -2;
    this.awZ.height = -2;
    this.awZ.format = -3;
    this.awZ.windowAnimations = 2131820554;
    this.awZ.flags = 24;
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
    ((View)localObject1).getWindowVisibleDisplayFrame(this.axa);
    Object localObject2;
    if ((this.axa.left < 0) && (this.axa.top < 0))
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
      this.axa.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      ((View)localObject1).getLocationOnScreen(this.axc);
      paramView.getLocationOnScreen(this.axb);
      paramView = this.axb;
      paramView[0] -= this.axc[0];
      paramView = this.axb;
      paramView[1] -= this.axc[1];
      paramLayoutParams.x = (this.axb[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mContentView.measure(paramInt1, paramInt1);
      paramInt1 = this.mContentView.getMeasuredHeight();
      i = i + this.axb[1] - k - paramInt1;
      paramInt2 = paramInt2 + this.axb[1] + k;
      if (!paramBoolean) {
        break;
      }
      if (i >= 0) {
        break label401;
      }
      paramLayoutParams.y = paramInt2;
      return;
    }
    if (paramInt1 + paramInt2 <= this.axa.height())
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
    this.UB.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.awZ);
    ((WindowManager)this.mContext.getSystemService("window")).addView(this.mContentView, this.awZ);
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