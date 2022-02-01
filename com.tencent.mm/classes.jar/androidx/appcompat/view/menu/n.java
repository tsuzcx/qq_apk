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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n
{
  private final h jo;
  private final Context mContext;
  private int mE;
  protected View mF;
  private boolean mN;
  private o.a mO;
  PopupWindow.OnDismissListener mQ;
  private final int mu;
  private final int mv;
  private final boolean mw;
  private m oo;
  private final PopupWindow.OnDismissListener oq;
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramh, paramView, paramBoolean, paramInt, 0);
  }
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200883);
    this.mE = 8388611;
    this.oq = new PopupWindow.OnDismissListener()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(201051);
        n.this.onDismiss();
        AppMethodBeat.o(201051);
      }
    };
    this.mContext = paramContext;
    this.jo = paramh;
    this.mF = paramView;
    this.mw = paramBoolean;
    this.mu = paramInt1;
    this.mv = paramInt2;
    AppMethodBeat.o(200883);
  }
  
  final void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(200936);
    m localm = dt();
    localm.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((androidx.core.g.e.ay(this.mE, z.U(this.mF)) & 0x7) == 5) {
        i = paramInt1 - this.mF.getWidth();
      }
      localm.ac(i);
      localm.ad(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localm.om = new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt1 + paramInt2);
    }
    localm.show();
    AppMethodBeat.o(200936);
  }
  
  public final void c(o.a parama)
  {
    AppMethodBeat.i(200975);
    this.mO = parama;
    if (this.oo != null) {
      this.oo.b(parama);
    }
    AppMethodBeat.o(200975);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(200948);
    if (isShowing()) {
      this.oo.dismiss();
    }
    AppMethodBeat.o(200948);
  }
  
  public final void ds()
  {
    this.mE = 8388613;
  }
  
  public final m dt()
  {
    AppMethodBeat.i(200913);
    Point localPoint;
    int i;
    if (this.oo == null)
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
    for (Object localObject = new e(this.mContext, this.mF, this.mu, this.mv, this.mw);; localObject = new t(this.mContext, this.jo, this.mF, this.mu, this.mv, this.mw))
    {
      ((m)localObject).e(this.jo);
      ((m)localObject).setOnDismissListener(this.oq);
      ((m)localObject).setAnchorView(this.mF);
      ((m)localObject).b(this.mO);
      ((m)localObject).setForceShowIcon(this.mN);
      ((m)localObject).setGravity(this.mE);
      this.oo = ((m)localObject);
      localObject = this.oo;
      AppMethodBeat.o(200913);
      return localObject;
      ((Display)localObject).getSize(localPoint);
      break;
      i = 0;
      break label80;
    }
  }
  
  public final boolean du()
  {
    AppMethodBeat.i(200925);
    if (isShowing())
    {
      AppMethodBeat.o(200925);
      return true;
    }
    if (this.mF == null)
    {
      AppMethodBeat.o(200925);
      return false;
    }
    b(0, 0, false, false);
    AppMethodBeat.o(200925);
    return true;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(200964);
    if ((this.oo != null) && (this.oo.isShowing()))
    {
      AppMethodBeat.o(200964);
      return true;
    }
    AppMethodBeat.o(200964);
    return false;
  }
  
  protected void onDismiss()
  {
    AppMethodBeat.i(200954);
    this.oo = null;
    if (this.mQ != null) {
      this.mQ.onDismiss();
    }
    AppMethodBeat.o(200954);
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(200890);
    this.mN = paramBoolean;
    if (this.oo != null) {
      this.oo.setForceShowIcon(paramBoolean);
    }
    AppMethodBeat.o(200890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.n
 * JD-Core Version:    0.7.0.1
 */