package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.d;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class n
{
  private final h aaQ;
  private boolean afG;
  private o.a afH;
  PopupWindow.OnDismissListener afJ;
  private final int afp;
  private final int afq;
  private final boolean afr;
  protected int afz = 8388611;
  private m ahe;
  private final PopupWindow.OnDismissListener ahf = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      n.this.onDismiss();
    }
  };
  private final Context mContext;
  protected View qK;
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean)
  {
    this(paramContext, paramh, paramView, paramBoolean, 2130968628, 0);
  }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.aaQ = paramh;
    this.qK = paramView;
    this.afr = paramBoolean;
    this.afp = paramInt1;
    this.afq = paramInt2;
  }
  
  final void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = iu();
    localm.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((d.getAbsoluteGravity(this.afz, u.Z(this.qK)) & 0x7) == 5) {
        i = paramInt1 - this.qK.getWidth();
      }
      localm.setHorizontalOffset(i);
      localm.setVerticalOffset(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localm.ahd = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2);
    }
    localm.show();
  }
  
  public final void c(o.a parama)
  {
    this.afH = parama;
    if (this.ahe != null) {
      this.ahe.a(parama);
    }
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.ahe.dismiss();
    }
  }
  
  public final boolean isShowing()
  {
    return (this.ahe != null) && (this.ahe.isShowing());
  }
  
  public final m iu()
  {
    Point localPoint;
    int i;
    if (this.ahe == null)
    {
      localObject = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label164;
      }
      ((Display)localObject).getRealSize(localPoint);
      if (Math.min(localPoint.x, localPoint.y) < this.mContext.getResources().getDimensionPixelSize(2131165672)) {
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
    for (Object localObject = new e(this.mContext, this.qK, this.afp, this.afq, this.afr);; localObject = new t(this.mContext, this.aaQ, this.qK, this.afp, this.afq, this.afr))
    {
      ((m)localObject).f(this.aaQ);
      ((m)localObject).setOnDismissListener(this.ahf);
      ((m)localObject).setAnchorView(this.qK);
      ((m)localObject).a(this.afH);
      ((m)localObject).setForceShowIcon(this.afG);
      ((m)localObject).setGravity(this.afz);
      this.ahe = ((m)localObject);
      return this.ahe;
      ((Display)localObject).getSize(localPoint);
      break;
      i = 0;
      break label74;
    }
  }
  
  public final boolean iv()
  {
    if (isShowing()) {
      return true;
    }
    if (this.qK == null) {
      return false;
    }
    b(0, 0, false, false);
    return true;
  }
  
  protected void onDismiss()
  {
    this.ahe = null;
    if (this.afJ != null) {
      this.afJ.onDismiss();
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.afG = paramBoolean;
    if (this.ahe != null) {
      this.ahe.setForceShowIcon(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.n
 * JD-Core Version:    0.7.0.1
 */