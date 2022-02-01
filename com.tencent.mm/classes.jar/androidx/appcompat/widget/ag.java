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
  private final TextView eN;
  private final View mContentView;
  private final Context mContext;
  private final WindowManager.LayoutParams xL;
  private final Rect xM;
  private final int[] xN;
  private final int[] xO;
  
  ag(Context paramContext)
  {
    AppMethodBeat.i(242474);
    this.xL = new WindowManager.LayoutParams();
    this.xM = new Rect();
    this.xN = new int[2];
    this.xO = new int[2];
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(a.g.abc_tooltip, null);
    this.eN = ((TextView)this.mContentView.findViewById(a.f.message));
    this.xL.setTitle(getClass().getSimpleName());
    this.xL.packageName = this.mContext.getPackageName();
    this.xL.type = 1002;
    this.xL.width = -2;
    this.xL.height = -2;
    this.xL.format = -3;
    this.xL.windowAnimations = a.i.Animation_AppCompat_Tooltip;
    this.xL.flags = 24;
    AppMethodBeat.o(242474);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(242480);
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
      AppMethodBeat.o(242480);
      return;
      paramInt2 = paramView.getHeight();
      i = 0;
      break;
    }
    label155:
    ((View)localObject1).getWindowVisibleDisplayFrame(this.xM);
    Object localObject2;
    if ((this.xM.left < 0) && (this.xM.top < 0))
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
      this.xM.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      ((View)localObject1).getLocationOnScreen(this.xO);
      paramView.getLocationOnScreen(this.xN);
      paramView = this.xN;
      paramView[0] -= this.xO[0];
      paramView = this.xN;
      paramView[1] -= this.xO[1];
      paramLayoutParams.x = (this.xN[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mContentView.measure(paramInt1, paramInt1);
      paramInt1 = this.mContentView.getMeasuredHeight();
      i = i + this.xN[1] - k - paramInt1;
      paramInt2 = paramInt2 + this.xN[1] + k;
      if (!paramBoolean) {
        break;
      }
      if (i >= 0) {
        break label425;
      }
      paramLayoutParams.y = paramInt2;
      AppMethodBeat.o(242480);
      return;
    }
    if (paramInt1 + paramInt2 <= this.xM.height())
    {
      paramLayoutParams.y = paramInt2;
      AppMethodBeat.o(242480);
      return;
    }
    label425:
    paramLayoutParams.y = i;
    AppMethodBeat.o(242480);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(242479);
    if (this.mContentView.getParent() != null)
    {
      AppMethodBeat.o(242479);
      return true;
    }
    AppMethodBeat.o(242479);
    return false;
  }
  
  private static View r(View paramView)
  {
    AppMethodBeat.i(242482);
    View localView = paramView.getRootView();
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (((localLayoutParams instanceof WindowManager.LayoutParams)) && (((WindowManager.LayoutParams)localLayoutParams).type == 2))
    {
      AppMethodBeat.o(242482);
      return localView;
    }
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity))
      {
        paramView = ((Activity)paramView).getWindow().getDecorView();
        AppMethodBeat.o(242482);
        return paramView;
      }
    }
    AppMethodBeat.o(242482);
    return localView;
  }
  
  final void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242477);
    if (isShowing()) {
      hide();
    }
    this.eN.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.xL);
    ((WindowManager)this.mContext.getSystemService("window")).addView(this.mContentView, this.xL);
    AppMethodBeat.o(242477);
  }
  
  final void hide()
  {
    AppMethodBeat.i(242478);
    if (!isShowing())
    {
      AppMethodBeat.o(242478);
      return;
    }
    ((WindowManager)this.mContext.getSystemService("window")).removeView(this.mContentView);
    AppMethodBeat.o(242478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.ag
 * JD-Core Version:    0.7.0.1
 */