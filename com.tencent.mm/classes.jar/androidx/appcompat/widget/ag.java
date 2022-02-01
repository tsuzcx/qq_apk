package androidx.appcompat.widget;

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
import androidx.appcompat.a.d;
import androidx.appcompat.a.f;
import androidx.appcompat.a.g;
import androidx.appcompat.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ag
{
  private final TextView fP;
  private final View mContentView;
  private final Context mContext;
  private final WindowManager.LayoutParams yG;
  private final Rect yH;
  private final int[] yI;
  private final int[] yJ;
  
  ag(Context paramContext)
  {
    AppMethodBeat.i(199636);
    this.yG = new WindowManager.LayoutParams();
    this.yH = new Rect();
    this.yI = new int[2];
    this.yJ = new int[2];
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(a.g.abc_tooltip, null);
    this.fP = ((TextView)this.mContentView.findViewById(a.f.message));
    this.yG.setTitle(getClass().getSimpleName());
    this.yG.packageName = this.mContext.getPackageName();
    this.yG.type = 1002;
    this.yG.width = -2;
    this.yG.height = -2;
    this.yG.format = -3;
    this.yG.windowAnimations = a.i.Animation_AppCompat_Tooltip;
    this.yG.flags = 24;
    AppMethodBeat.o(199636);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(199664);
    paramLayoutParams.token = paramView.getApplicationWindowToken();
    int i = this.mContext.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_threshold);
    if (paramView.getWidth() < i) {
      paramInt1 = paramView.getWidth() / 2;
    }
    Object localObject1;
    if (paramView.getHeight() >= i)
    {
      i = this.mContext.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_extra_offset);
      j = paramInt2 + i;
      i = paramInt2 - i;
      paramInt2 = j;
      paramLayoutParams.gravity = 49;
      localObject1 = this.mContext.getResources();
      if (!paramBoolean) {
        break label147;
      }
    }
    int k;
    label147:
    for (int j = a.d.tooltip_y_offset_touch;; j = a.d.tooltip_y_offset_non_touch)
    {
      k = ((Resources)localObject1).getDimensionPixelOffset(j);
      localObject1 = r(paramView);
      if (localObject1 != null) {
        break label155;
      }
      AppMethodBeat.o(199664);
      return;
      paramInt2 = paramView.getHeight();
      i = 0;
      break;
    }
    label155:
    ((View)localObject1).getWindowVisibleDisplayFrame(this.yH);
    Object localObject2;
    if ((this.yH.left < 0) && (this.yH.top < 0))
    {
      localObject2 = this.mContext.getResources();
      j = ((Resources)localObject2).getIdentifier("status_bar_height", "dimen", "android");
      if (j == 0) {
        break label394;
      }
    }
    label394:
    for (j = ((Resources)localObject2).getDimensionPixelSize(j);; j = 0)
    {
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      this.yH.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      ((View)localObject1).getLocationOnScreen(this.yJ);
      paramView.getLocationOnScreen(this.yI);
      paramView = this.yI;
      paramView[0] -= this.yJ[0];
      paramView = this.yI;
      paramView[1] -= this.yJ[1];
      paramLayoutParams.x = (this.yI[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mContentView.measure(paramInt1, paramInt1);
      paramInt1 = this.mContentView.getMeasuredHeight();
      i = i + this.yI[1] - k - paramInt1;
      paramInt2 = paramInt2 + this.yI[1] + k;
      if (!paramBoolean) {
        break;
      }
      if (i >= 0) {
        break label425;
      }
      paramLayoutParams.y = paramInt2;
      AppMethodBeat.o(199664);
      return;
    }
    if (paramInt1 + paramInt2 <= this.yH.height())
    {
      paramLayoutParams.y = paramInt2;
      AppMethodBeat.o(199664);
      return;
    }
    label425:
    paramLayoutParams.y = i;
    AppMethodBeat.o(199664);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(199648);
    if (this.mContentView.getParent() != null)
    {
      AppMethodBeat.o(199648);
      return true;
    }
    AppMethodBeat.o(199648);
    return false;
  }
  
  private static View r(View paramView)
  {
    AppMethodBeat.i(199670);
    View localView = paramView.getRootView();
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (((localLayoutParams instanceof WindowManager.LayoutParams)) && (((WindowManager.LayoutParams)localLayoutParams).type == 2))
    {
      AppMethodBeat.o(199670);
      return localView;
    }
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity))
      {
        paramView = ((Activity)paramView).getWindow().getDecorView();
        AppMethodBeat.o(199670);
        return paramView;
      }
    }
    AppMethodBeat.o(199670);
    return localView;
  }
  
  final void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199680);
    if (isShowing()) {
      hide();
    }
    this.fP.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.yG);
    ((WindowManager)this.mContext.getSystemService("window")).addView(this.mContentView, this.yG);
    AppMethodBeat.o(199680);
  }
  
  final void hide()
  {
    AppMethodBeat.i(199686);
    if (!isShowing())
    {
      AppMethodBeat.o(199686);
      return;
    }
    ((WindowManager)this.mContext.getSystemService("window")).removeView(this.mContentView);
    AppMethodBeat.o(199686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ag
 * JD-Core Version:    0.7.0.1
 */