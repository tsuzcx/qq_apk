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
  private final h YO;
  private boolean adC;
  private o.a adD;
  PopupWindow.OnDismissListener adF;
  private final int adl;
  private final int adm;
  private final boolean adn;
  protected int adv = 8388611;
  private m afa;
  private final PopupWindow.OnDismissListener afb = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      n.this.onDismiss();
    }
  };
  private final Context mContext;
  protected View oP;
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean)
  {
    this(paramContext, paramh, paramView, paramBoolean, 2130968627, 0);
  }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.YO = paramh;
    this.oP = paramView;
    this.adn = paramBoolean;
    this.adl = paramInt1;
    this.adm = paramInt2;
  }
  
  final void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = hT();
    localm.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((d.getAbsoluteGravity(this.adv, android.support.v4.view.t.Y(this.oP)) & 0x7) == 5) {
        i = paramInt1 - this.oP.getWidth();
      }
      localm.setHorizontalOffset(i);
      localm.setVerticalOffset(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localm.aeZ = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2);
    }
    localm.show();
  }
  
  public final void c(o.a parama)
  {
    this.adD = parama;
    if (this.afa != null) {
      this.afa.a(parama);
    }
  }
  
  public final void dismiss()
  {
    if (isShowing()) {
      this.afa.dismiss();
    }
  }
  
  public final m hT()
  {
    Point localPoint;
    int i;
    if (this.afa == null)
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
    for (Object localObject = new e(this.mContext, this.oP, this.adl, this.adm, this.adn);; localObject = new t(this.mContext, this.YO, this.oP, this.adl, this.adm, this.adn))
    {
      ((m)localObject).f(this.YO);
      ((m)localObject).setOnDismissListener(this.afb);
      ((m)localObject).setAnchorView(this.oP);
      ((m)localObject).a(this.adD);
      ((m)localObject).setForceShowIcon(this.adC);
      ((m)localObject).setGravity(this.adv);
      this.afa = ((m)localObject);
      return this.afa;
      ((Display)localObject).getSize(localPoint);
      break;
      i = 0;
      break label74;
    }
  }
  
  public final boolean hU()
  {
    if (isShowing()) {
      return true;
    }
    if (this.oP == null) {
      return false;
    }
    b(0, 0, false, false);
    return true;
  }
  
  public final boolean isShowing()
  {
    return (this.afa != null) && (this.afa.isShowing());
  }
  
  protected void onDismiss()
  {
    this.afa = null;
    if (this.adF != null) {
      this.adF.onDismiss();
    }
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.adC = paramBoolean;
    if (this.afa != null) {
      this.afa.setForceShowIcon(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.n
 * JD-Core Version:    0.7.0.1
 */