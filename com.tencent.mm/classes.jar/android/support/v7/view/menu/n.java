package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.d;
import android.support.v4.view.q;
import android.support.v7.a.a.d;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class n
{
  private final int UA;
  private final boolean UB;
  public int UJ = 8388611;
  private boolean UQ;
  private o.a UR;
  PopupWindow.OnDismissListener UT;
  private final int Uz;
  private m Wo;
  private final PopupWindow.OnDismissListener Wp = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      n.this.onDismiss();
    }
  };
  private final h dm;
  public View hX;
  private final Context mContext;
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramh, paramView, paramBoolean, paramInt, 0);
  }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.dm = paramh;
    this.hX = paramView;
    this.UB = paramBoolean;
    this.Uz = paramInt1;
    this.UA = paramInt2;
  }
  
  final void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = fx();
    localm.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((d.getAbsoluteGravity(this.UJ, q.Q(this.hX)) & 0x7) == 5) {
        i = paramInt1 + this.hX.getWidth();
      }
      localm.setHorizontalOffset(i);
      localm.setVerticalOffset(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localm.Wn = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2);
    }
    localm.show();
  }
  
  public final void b(o.a parama)
  {
    this.UR = parama;
    if (this.Wo != null) {
      this.Wo.a(parama);
    }
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.Wo.dismiss();
    }
  }
  
  public final m fx()
  {
    Point localPoint;
    int i;
    if (this.Wo == null)
    {
      localObject = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label165;
      }
      ((Display)localObject).getRealSize(localPoint);
      if (Math.min(localPoint.x, localPoint.y) < this.mContext.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width)) {
        break label173;
      }
      i = 1;
      label75:
      if (i == 0) {
        break label178;
      }
    }
    label165:
    label173:
    label178:
    for (Object localObject = new e(this.mContext, this.hX, this.Uz, this.UA, this.UB);; localObject = new t(this.mContext, this.dm, this.hX, this.Uz, this.UA, this.UB))
    {
      ((m)localObject).f(this.dm);
      ((m)localObject).setOnDismissListener(this.Wp);
      ((m)localObject).setAnchorView(this.hX);
      ((m)localObject).a(this.UR);
      ((m)localObject).setForceShowIcon(this.UQ);
      ((m)localObject).setGravity(this.UJ);
      this.Wo = ((m)localObject);
      return this.Wo;
      ((Display)localObject).getSize(localPoint);
      break;
      i = 0;
      break label75;
    }
  }
  
  public final boolean fy()
  {
    if (isShowing()) {
      return true;
    }
    if (this.hX == null) {
      return false;
    }
    b(0, 0, false, false);
    return true;
  }
  
  public final boolean isShowing()
  {
    return (this.Wo != null) && (this.Wo.isShowing());
  }
  
  public void onDismiss()
  {
    this.Wo = null;
    if (this.UT != null) {
      this.UT.onDismiss();
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.UQ = paramBoolean;
    if (this.Wo != null) {
      this.Wo.setForceShowIcon(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.n
 * JD-Core Version:    0.7.0.1
 */