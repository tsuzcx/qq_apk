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
  private final h XT;
  protected int acB = 8388611;
  private boolean acI;
  private o.a acJ;
  PopupWindow.OnDismissListener acL;
  private final int acr;
  private final int acs;
  private final boolean act;
  private m aeg;
  private final PopupWindow.OnDismissListener aeh = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      n.this.onDismiss();
    }
  };
  private final Context mContext;
  protected View nO;
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean)
  {
    this(paramContext, paramh, paramView, paramBoolean, 2130968627, 0);
  }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.XT = paramh;
    this.nO = paramView;
    this.act = paramBoolean;
    this.acr = paramInt1;
    this.acs = paramInt2;
  }
  
  final void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = hL();
    localm.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((d.getAbsoluteGravity(this.acB, android.support.v4.view.t.Y(this.nO)) & 0x7) == 5) {
        i = paramInt1 - this.nO.getWidth();
      }
      localm.setHorizontalOffset(i);
      localm.setVerticalOffset(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localm.aef = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2);
    }
    localm.show();
  }
  
  public final void c(o.a parama)
  {
    this.acJ = parama;
    if (this.aeg != null) {
      this.aeg.a(parama);
    }
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.aeg.dismiss();
    }
  }
  
  public final m hL()
  {
    Point localPoint;
    int i;
    if (this.aeg == null)
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
    for (Object localObject = new e(this.mContext, this.nO, this.acr, this.acs, this.act);; localObject = new t(this.mContext, this.XT, this.nO, this.acr, this.acs, this.act))
    {
      ((m)localObject).f(this.XT);
      ((m)localObject).setOnDismissListener(this.aeh);
      ((m)localObject).setAnchorView(this.nO);
      ((m)localObject).a(this.acJ);
      ((m)localObject).setForceShowIcon(this.acI);
      ((m)localObject).setGravity(this.acB);
      this.aeg = ((m)localObject);
      return this.aeg;
      ((Display)localObject).getSize(localPoint);
      break;
      i = 0;
      break label74;
    }
  }
  
  public final boolean hM()
  {
    if (isShowing()) {
      return true;
    }
    if (this.nO == null) {
      return false;
    }
    b(0, 0, false, false);
    return true;
  }
  
  public final boolean isShowing()
  {
    return (this.aeg != null) && (this.aeg.isShowing());
  }
  
  protected void onDismiss()
  {
    this.aeg = null;
    if (this.acL != null) {
      this.acL.onDismiss();
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.acI = paramBoolean;
    if (this.aeg != null) {
      this.aeg.setForceShowIcon(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.n
 * JD-Core Version:    0.7.0.1
 */