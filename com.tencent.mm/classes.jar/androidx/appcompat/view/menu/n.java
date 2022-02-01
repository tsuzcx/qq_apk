package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.a.d;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n
{
  private final h is;
  private final boolean lA;
  private int lI;
  protected View lJ;
  private boolean lQ;
  private o.a lR;
  PopupWindow.OnDismissListener lT;
  private final int ly;
  private final int lz;
  private final Context mContext;
  private m nr;
  private final PopupWindow.OnDismissListener ns;
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramh, paramView, paramBoolean, paramInt, 0);
  }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239752);
    this.lI = 8388611;
    this.ns = new PopupWindow.OnDismissListener()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(239748);
        n.this.onDismiss();
        AppMethodBeat.o(239748);
      }
    };
    this.mContext = paramContext;
    this.is = paramh;
    this.lJ = paramView;
    this.lA = paramBoolean;
    this.ly = paramInt1;
    this.lz = paramInt2;
    AppMethodBeat.o(239752);
  }
  
  final void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(239766);
    m localm = cA();
    localm.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((androidx.core.g.e.D(this.lI, w.I(this.lJ)) & 0x7) == 5) {
        i = paramInt1 - this.lJ.getWidth();
      }
      localm.ag(i);
      localm.ah(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localm.nq = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2);
    }
    localm.show();
    AppMethodBeat.o(239766);
  }
  
  public final void c(o.a parama)
  {
    AppMethodBeat.i(239772);
    this.lR = parama;
    if (this.nr != null) {
      this.nr.b(parama);
    }
    AppMethodBeat.o(239772);
  }
  
  public final m cA()
  {
    AppMethodBeat.i(239760);
    Point localPoint;
    int i;
    if (this.nr == null)
    {
      localObject = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label177;
      }
      ((Display)localObject).getRealSize(localPoint);
      if (Math.min(localPoint.x, localPoint.y) < this.mContext.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width)) {
        break label185;
      }
      i = 1;
      label80:
      if (i == 0) {
        break label190;
      }
    }
    label177:
    label185:
    label190:
    for (Object localObject = new e(this.mContext, this.lJ, this.ly, this.lz, this.lA);; localObject = new t(this.mContext, this.is, this.lJ, this.ly, this.lz, this.lA))
    {
      ((m)localObject).e(this.is);
      ((m)localObject).setOnDismissListener(this.ns);
      ((m)localObject).setAnchorView(this.lJ);
      ((m)localObject).b(this.lR);
      ((m)localObject).setForceShowIcon(this.lQ);
      ((m)localObject).setGravity(this.lI);
      this.nr = ((m)localObject);
      localObject = this.nr;
      AppMethodBeat.o(239760);
      return localObject;
      ((Display)localObject).getSize(localPoint);
      break;
      i = 0;
      break label80;
    }
  }
  
  public final boolean cB()
  {
    AppMethodBeat.i(239763);
    if (isShowing())
    {
      AppMethodBeat.o(239763);
      return true;
    }
    if (this.lJ == null)
    {
      AppMethodBeat.o(239763);
      return false;
    }
    b(0, 0, false, false);
    AppMethodBeat.o(239763);
    return true;
  }
  
  public final void cz()
  {
    this.lI = 8388613;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(239768);
    if (isShowing()) {
      this.nr.dismiss();
    }
    AppMethodBeat.o(239768);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(239770);
    if ((this.nr != null) && (this.nr.isShowing()))
    {
      AppMethodBeat.o(239770);
      return true;
    }
    AppMethodBeat.o(239770);
    return false;
  }
  
  protected void onDismiss()
  {
    AppMethodBeat.i(239769);
    this.nr = null;
    if (this.lT != null) {
      this.lT.onDismiss();
    }
    AppMethodBeat.o(239769);
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(239755);
    this.lQ = paramBoolean;
    if (this.nr != null) {
      this.nr.setForceShowIcon(paramBoolean);
    }
    AppMethodBeat.o(239755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.n
 * JD-Core Version:    0.7.0.1
 */