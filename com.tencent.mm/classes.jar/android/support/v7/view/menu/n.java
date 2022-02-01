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
  private final h aaD;
  private final int afc;
  private final int afd;
  private final boolean afe;
  protected int afm = 8388611;
  private boolean aft;
  private o.a afu;
  PopupWindow.OnDismissListener afw;
  private m agR;
  private final PopupWindow.OnDismissListener agS = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      n.this.onDismiss();
    }
  };
  private final Context mContext;
  protected View qI;
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean)
  {
    this(paramContext, paramh, paramView, paramBoolean, 2130968627, 0);
  }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.aaD = paramh;
    this.qI = paramView;
    this.afe = paramBoolean;
    this.afc = paramInt1;
    this.afd = paramInt2;
  }
  
  final void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = ik();
    localm.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((d.getAbsoluteGravity(this.afm, android.support.v4.view.t.Y(this.qI)) & 0x7) == 5) {
        i = paramInt1 - this.qI.getWidth();
      }
      localm.setHorizontalOffset(i);
      localm.setVerticalOffset(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localm.agQ = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2);
    }
    localm.show();
  }
  
  public final void c(o.a parama)
  {
    this.afu = parama;
    if (this.agR != null) {
      this.agR.a(parama);
    }
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.agR.dismiss();
    }
  }
  
  public final m ik()
  {
    Point localPoint;
    int i;
    if (this.agR == null)
    {
      localObject = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label164;
      }
      ((Display)localObject).getRealSize(localPoint);
      if (Math.min(localPoint.x, localPoint.y) < this.mContext.getResources().getDimensionPixelSize(2131165654)) {
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
    for (Object localObject = new e(this.mContext, this.qI, this.afc, this.afd, this.afe);; localObject = new t(this.mContext, this.aaD, this.qI, this.afc, this.afd, this.afe))
    {
      ((m)localObject).f(this.aaD);
      ((m)localObject).setOnDismissListener(this.agS);
      ((m)localObject).setAnchorView(this.qI);
      ((m)localObject).a(this.afu);
      ((m)localObject).setForceShowIcon(this.aft);
      ((m)localObject).setGravity(this.afm);
      this.agR = ((m)localObject);
      return this.agR;
      ((Display)localObject).getSize(localPoint);
      break;
      i = 0;
      break label74;
    }
  }
  
  public final boolean il()
  {
    if (isShowing()) {
      return true;
    }
    if (this.qI == null) {
      return false;
    }
    b(0, 0, false, false);
    return true;
  }
  
  public final boolean isShowing()
  {
    return (this.agR != null) && (this.agR.isShowing());
  }
  
  protected void onDismiss()
  {
    this.agR = null;
    if (this.afw != null) {
      this.afw.onDismiss();
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.aft = paramBoolean;
    if (this.agR != null) {
      this.agR.setForceShowIcon(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.n
 * JD-Core Version:    0.7.0.1
 */