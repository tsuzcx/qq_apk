package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.d;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class n
{
  private boolean VD;
  private o.a VE;
  PopupWindow.OnDismissListener VG;
  private final int Vm;
  private final int Vn;
  private final boolean Vo;
  protected int Vw = 8388611;
  private m Xb;
  private final PopupWindow.OnDismissListener Xc = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      n.this.onDismiss();
    }
  };
  private final h eq;
  protected View iU;
  private final Context mContext;
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean)
  {
    this(paramContext, paramh, paramView, paramBoolean, 2130772137, 0);
  }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.eq = paramh;
    this.iU = paramView;
    this.Vo = paramBoolean;
    this.Vm = paramInt1;
    this.Vn = paramInt2;
  }
  
  final void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = gq();
    localm.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((d.getAbsoluteGravity(this.Vw, android.support.v4.view.t.T(this.iU)) & 0x7) == 5) {
        i = paramInt1 - this.iU.getWidth();
      }
      localm.setHorizontalOffset(i);
      localm.setVerticalOffset(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localm.Xa = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2);
    }
    localm.show();
  }
  
  public final void c(o.a parama)
  {
    this.VE = parama;
    if (this.Xb != null) {
      this.Xb.a(parama);
    }
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.Xb.dismiss();
    }
  }
  
  public final m gq()
  {
    Point localPoint;
    int i;
    if (this.Xb == null)
    {
      localObject = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label164;
      }
      ((Display)localObject).getRealSize(localPoint);
      if (Math.min(localPoint.x, localPoint.y) < this.mContext.getResources().getDimensionPixelSize(2131427934)) {
        break label172;
      }
      i = 1;
      label74:
      if (i == 0) {
        break label177;
      }
    }
    label164:
    label172:
    label177:
    for (Object localObject = new e(this.mContext, this.iU, this.Vm, this.Vn, this.Vo);; localObject = new t(this.mContext, this.eq, this.iU, this.Vm, this.Vn, this.Vo))
    {
      ((m)localObject).f(this.eq);
      ((m)localObject).setOnDismissListener(this.Xc);
      ((m)localObject).setAnchorView(this.iU);
      ((m)localObject).a(this.VE);
      ((m)localObject).setForceShowIcon(this.VD);
      ((m)localObject).setGravity(this.Vw);
      this.Xb = ((m)localObject);
      return this.Xb;
      ((Display)localObject).getSize(localPoint);
      break;
      i = 0;
      break label74;
    }
  }
  
  public final boolean gr()
  {
    if (isShowing()) {
      return true;
    }
    if (this.iU == null) {
      return false;
    }
    b(0, 0, false, false);
    return true;
  }
  
  public final boolean isShowing()
  {
    return (this.Xb != null) && (this.Xb.isShowing());
  }
  
  protected void onDismiss()
  {
    this.Xb = null;
    if (this.VG != null) {
      this.VG.onDismiss();
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.VD = paramBoolean;
    if (this.Xb != null) {
      this.Xb.setForceShowIcon(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.n
 * JD-Core Version:    0.7.0.1
 */