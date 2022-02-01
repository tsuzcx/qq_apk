package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.a.d;
import androidx.appcompat.a.g;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t
  extends m
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static final int ms = a.g.abc_popup_menu_item_layout;
  private boolean fZ;
  private final h jo;
  final ViewTreeObserver.OnGlobalLayoutListener mA;
  private final View.OnAttachStateChangeListener mB;
  private final Context mContext;
  private int mE;
  private View mF;
  View mG;
  private o.a mO;
  ViewTreeObserver mP;
  private PopupWindow.OnDismissListener mQ;
  private final int mu;
  private final int mv;
  private final boolean mw;
  private final g ot;
  private final int ou;
  final androidx.appcompat.widget.t ov;
  private boolean ow;
  private boolean ox;
  private int oy;
  
  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(200888);
    this.mA = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(201052);
        if ((t.this.isShowing()) && (!t.this.ov.uw))
        {
          View localView = t.this.mG;
          if ((localView == null) || (!localView.isShown()))
          {
            t.this.dismiss();
            AppMethodBeat.o(201052);
            return;
          }
          t.this.ov.show();
        }
        AppMethodBeat.o(201052);
      }
    };
    this.mB = new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(201021);
        if (t.this.mP != null)
        {
          if (!t.this.mP.isAlive()) {
            t.this.mP = paramAnonymousView.getViewTreeObserver();
          }
          t.this.mP.removeGlobalOnLayoutListener(t.this.mA);
        }
        paramAnonymousView.removeOnAttachStateChangeListener(this);
        AppMethodBeat.o(201021);
      }
    };
    this.mE = 0;
    this.mContext = paramContext;
    this.jo = paramh;
    this.mw = paramBoolean;
    this.ot = new g(paramh, LayoutInflater.from(paramContext), this.mw, ms);
    this.mu = paramInt1;
    this.mv = paramInt2;
    Resources localResources = paramContext.getResources();
    this.ou = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.mF = paramView;
    this.ov = new androidx.appcompat.widget.t(this.mContext, this.mu, this.mv);
    paramh.a(this, paramContext);
    AppMethodBeat.o(200888);
  }
  
  public final void J(boolean paramBoolean)
  {
    AppMethodBeat.i(200984);
    this.ox = false;
    if (this.ot != null) {
      this.ot.notifyDataSetChanged();
    }
    AppMethodBeat.o(200984);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(201022);
    if (paramh != this.jo)
    {
      AppMethodBeat.o(201022);
      return;
    }
    dismiss();
    if (this.mO != null) {
      this.mO.a(paramh, paramBoolean);
    }
    AppMethodBeat.o(201022);
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(201011);
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.mContext, paramu, this.mG, this.mw, this.mu, this.mv);
      localn.c(this.mO);
      localn.setForceShowIcon(m.h(paramu));
      localn.mQ = this.mQ;
      this.mQ = null;
      this.jo.K(false);
      int j = this.ov.tZ;
      int k = this.ov.eL();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.mE, z.U(this.mF)) & 0x7) == 5) {
        i = j + this.mF.getWidth();
      }
      if (localn.isShowing()) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.mO != null) {
          this.mO.c(paramu);
        }
        AppMethodBeat.o(201011);
        return true;
        if (localn.mF == null)
        {
          i = 0;
        }
        else
        {
          localn.b(i, k, true, true);
          i = 1;
        }
      }
    }
    AppMethodBeat.o(201011);
    return false;
  }
  
  public final void ac(int paramInt)
  {
    this.ov.tZ = paramInt;
  }
  
  public final void ad(int paramInt)
  {
    AppMethodBeat.i(201079);
    this.ov.ad(paramInt);
    AppMethodBeat.o(201079);
  }
  
  public final void b(o.a parama)
  {
    this.mO = parama;
  }
  
  public final boolean cL()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(200940);
    if (isShowing()) {
      this.ov.dismiss();
    }
    AppMethodBeat.o(200940);
  }
  
  public final void e(h paramh) {}
  
  public final ListView getListView()
  {
    return this.ov.tX;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(200957);
    if ((!this.ow) && (this.ov.ux.isShowing()))
    {
      AppMethodBeat.o(200957);
      return true;
    }
    AppMethodBeat.o(200957);
    return false;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(200968);
    this.ow = true;
    this.jo.close();
    if (this.mP != null)
    {
      if (!this.mP.isAlive()) {
        this.mP = this.mG.getViewTreeObserver();
      }
      this.mP.removeGlobalOnLayoutListener(this.mA);
      this.mP = null;
    }
    this.mG.removeOnAttachStateChangeListener(this.mB);
    if (this.mQ != null) {
      this.mQ.onDismiss();
    }
    AppMethodBeat.o(200968);
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201055);
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      AppMethodBeat.o(201055);
      return true;
    }
    AppMethodBeat.o(201055);
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public final Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final void setAnchorView(View paramView)
  {
    this.mF = paramView;
  }
  
  public final void setForceShowIcon(boolean paramBoolean)
  {
    this.ot.mN = paramBoolean;
  }
  
  public final void setGravity(int paramInt)
  {
    this.mE = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mQ = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.fZ = paramBoolean;
  }
  
  public final void show()
  {
    int j = 1;
    AppMethodBeat.i(200931);
    int i;
    if (isShowing()) {
      i = j;
    }
    while (i == 0)
    {
      Object localObject = new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
      AppMethodBeat.o(200931);
      throw ((Throwable)localObject);
      if ((this.ow) || (this.mF == null))
      {
        i = 0;
      }
      else
      {
        this.mG = this.mF;
        this.ov.setOnDismissListener(this);
        this.ov.un = this;
        this.ov.eK();
        localObject = this.mG;
        if (this.mP == null) {}
        for (i = 1;; i = 0)
        {
          this.mP = ((View)localObject).getViewTreeObserver();
          if (i != 0) {
            this.mP.addOnGlobalLayoutListener(this.mA);
          }
          ((View)localObject).addOnAttachStateChangeListener(this.mB);
          this.ov.ul = ((View)localObject);
          this.ov.mE = this.mE;
          if (!this.ox)
          {
            this.oy = a(this.ot, null, this.mContext, this.ou);
            this.ox = true;
          }
          this.ov.setContentWidth(this.oy);
          this.ov.eN();
          this.ov.om = this.om;
          this.ov.show();
          localObject = this.ov.tX;
          ((ListView)localObject).setOnKeyListener(this);
          if ((this.fZ) && (this.jo.nH != null))
          {
            FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup)localObject, false);
            TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.jo.nH);
            }
            localFrameLayout.setEnabled(false);
            ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
          }
          this.ov.setAdapter(this.ot);
          this.ov.show();
          i = j;
          break;
        }
      }
    }
    AppMethodBeat.o(200931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.t
 * JD-Core Version:    0.7.0.1
 */