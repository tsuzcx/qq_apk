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
  private final View Qz;
  private final int[] apA = new int[2];
  private final WindowManager.LayoutParams apx = new WindowManager.LayoutParams();
  private final Rect apy = new Rect();
  private final int[] apz = new int[2];
  private final TextView fc;
  private final Context mContext;
  
  bd(Context paramContext)
  {
    this.mContext = paramContext;
    this.Qz = LayoutInflater.from(this.mContext).inflate(2130968611, null);
    this.fc = ((TextView)this.Qz.findViewById(2131820972));
    this.apx.setTitle(getClass().getSimpleName());
    this.apx.packageName = this.mContext.getPackageName();
    this.apx.type = 1002;
    this.apx.width = -2;
    this.apx.height = -2;
    this.apx.format = -3;
    this.apx.windowAnimations = 2131493038;
    this.apx.flags = 24;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.token = paramView.getApplicationWindowToken();
    int i = this.mContext.getResources().getDimensionPixelOffset(2131428758);
    if (paramView.getWidth() < i) {
      paramInt1 = paramView.getWidth() / 2;
    }
    Object localObject1;
    if (paramView.getHeight() >= i)
    {
      i = this.mContext.getResources().getDimensionPixelOffset(2131428757);
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
    for (int j = 2131428761;; j = 2131428760)
    {
      k = ((Resources)localObject1).getDimensionPixelOffset(j);
      localObject1 = bW(paramView);
      if (localObject1 != null) {
        break label141;
      }
      return;
      paramInt2 = paramView.getHeight();
      i = 0;
      break;
    }
    label141:
    ((View)localObject1).getWindowVisibleDisplayFrame(this.apy);
    Object localObject2;
    if ((this.apy.left < 0) && (this.apy.top < 0))
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
      this.apy.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      ((View)localObject1).getLocationOnScreen(this.apA);
      paramView.getLocationOnScreen(this.apz);
      paramView = this.apz;
      paramView[0] -= this.apA[0];
      paramView = this.apz;
      paramView[1] -= this.apA[1];
      paramLayoutParams.x = (this.apz[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.Qz.measure(paramInt1, paramInt1);
      paramInt1 = this.Qz.getMeasuredHeight();
      i = i + this.apz[1] - k - paramInt1;
      paramInt2 = paramInt2 + this.apz[1] + k;
      if (!paramBoolean) {
        break;
      }
      if (i >= 0) {
        break label401;
      }
      paramLayoutParams.y = paramInt2;
      return;
    }
    if (paramInt1 + paramInt2 <= this.apy.height())
    {
      paramLayoutParams.y = paramInt2;
      return;
    }
    label401:
    paramLayoutParams.y = i;
  }
  
  private static View bW(View paramView)
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
    return this.Qz.getParent() != null;
  }
  
  final void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (isShowing()) {
      hide();
    }
    this.fc.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.apx);
    ((WindowManager)this.mContext.getSystemService("window")).addView(this.Qz, this.apx);
  }
  
  final void hide()
  {
    if (!isShowing()) {
      return;
    }
    ((WindowManager)this.mContext.getSystemService("window")).removeView(this.Qz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bd
 * JD-Core Version:    0.7.0.1
 */