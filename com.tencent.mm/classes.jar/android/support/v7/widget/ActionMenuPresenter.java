package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.b.a;
import android.support.v7.a.a.a;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.p.a;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;

final class ActionMenuPresenter
  extends android.support.v7.view.menu.b
  implements b.a
{
  d XC;
  Drawable XD;
  boolean XE;
  private boolean XF;
  private boolean XG;
  private int XH;
  private int XI;
  int XJ;
  boolean XK;
  private boolean XL;
  private boolean XM;
  boolean XN;
  private int XO;
  private final SparseBooleanArray XP = new SparseBooleanArray();
  private View XQ;
  e XR;
  a XS;
  c XT;
  private b XU;
  final f XV = new f();
  int XW;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
  }
  
  public final void F(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.a(null);
    }
    while (this.dm == null) {
      return;
    }
    this.dm.T(false);
  }
  
  public final boolean V()
  {
    ArrayList localArrayList;
    int i1;
    int i;
    int i4;
    int i5;
    ViewGroup localViewGroup;
    int k;
    int m;
    int n;
    int j;
    label60:
    Object localObject1;
    if (this.dm != null)
    {
      localArrayList = this.dm.fl();
      i1 = localArrayList.size();
      i = this.XJ;
      i4 = this.XI;
      i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.Uv;
      k = 0;
      m = 0;
      n = 0;
      j = 0;
      if (j >= i1) {
        break label145;
      }
      localObject1 = (j)localArrayList.get(j);
      if (!((j)localObject1).fv()) {
        break label122;
      }
      k += 1;
      label89:
      if ((!this.XN) || (!((j)localObject1).isActionViewExpanded())) {
        break label756;
      }
      i = 0;
    }
    label145:
    label311:
    label601:
    label613:
    label618:
    label747:
    label756:
    for (;;)
    {
      j += 1;
      break label60;
      i1 = 0;
      localArrayList = null;
      break;
      label122:
      if (((j)localObject1).fu())
      {
        m += 1;
        break label89;
      }
      n = 1;
      break label89;
      j = i;
      if (this.XF) {
        if (n == 0)
        {
          j = i;
          if (k + m <= i) {}
        }
        else
        {
          j = i - 1;
        }
      }
      j -= k;
      localObject1 = this.XP;
      ((SparseBooleanArray)localObject1).clear();
      i = 0;
      if (this.XL)
      {
        i = i4 / this.XO;
        k = this.XO;
        m = this.XO;
      }
      for (int i2 = i4 % k / i + m;; i2 = 0)
      {
        k = 0;
        int i3 = 0;
        m = i4;
        j localj;
        Object localObject2;
        if (i3 < i1)
        {
          localj = (j)localArrayList.get(i3);
          if (localj.fv())
          {
            localObject2 = a(localj, this.XQ, localViewGroup);
            if (this.XQ == null) {
              this.XQ = ((View)localObject2);
            }
            if (this.XL)
            {
              i -= ActionMenuView.e((View)localObject2, i2, i, i5, 0);
              n = ((View)localObject2).getMeasuredWidth();
              if (k != 0) {
                break label747;
              }
              k = n;
            }
          }
        }
        for (;;)
        {
          i4 = localj.getGroupId();
          if (i4 != 0) {
            ((SparseBooleanArray)localObject1).put(i4, true);
          }
          localj.X(true);
          m -= n;
          i3 += 1;
          break;
          ((View)localObject2).measure(i5, i5);
          break label311;
          int i6;
          boolean bool;
          int i7;
          if (localj.fu())
          {
            i6 = localj.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i6);
            if (((j > 0) || (bool)) && (m > 0) && ((!this.XL) || (i > 0)))
            {
              i7 = 1;
              if (i7 == 0) {
                break label744;
              }
              localObject2 = a(localj, this.XQ, localViewGroup);
              if (this.XQ == null) {
                this.XQ = ((View)localObject2);
              }
              if (!this.XL) {
                break label601;
              }
              i4 = ActionMenuView.e((View)localObject2, i2, i, i5, 0);
              n = i - i4;
              i = n;
              if (i4 == 0)
              {
                i7 = 0;
                i = n;
              }
              label503:
              i4 = ((View)localObject2).getMeasuredWidth();
              m -= i4;
              n = k;
              if (k == 0) {
                n = i4;
              }
              if (!this.XL) {
                break label618;
              }
              if (m < 0) {
                break label613;
              }
              k = 1;
              i7 &= k;
              k = n;
            }
          }
          for (;;)
          {
            if ((i7 != 0) && (i6 != 0)) {
              ((SparseBooleanArray)localObject1).put(i6, true);
            }
            for (;;)
            {
              n = j;
              if (i7 != 0) {
                n = j - 1;
              }
              localj.X(i7);
              j = n;
              break;
              int i8 = 0;
              break label431;
              ((View)localObject2).measure(i5, i5);
              break label503;
              k = 0;
              break label542;
              if (m + n > 0) {}
              for (k = 1;; k = 0)
              {
                i8 &= k;
                k = n;
                break;
              }
              if (bool)
              {
                ((SparseBooleanArray)localObject1).put(i6, false);
                i4 = 0;
                for (;;)
                {
                  if (i4 < i3)
                  {
                    localObject2 = (j)localArrayList.get(i4);
                    n = j;
                    if (((j)localObject2).getGroupId() == i6)
                    {
                      n = j;
                      if (((j)localObject2).ft()) {
                        n = j + 1;
                      }
                      ((j)localObject2).X(false);
                    }
                    i4 += 1;
                    j = n;
                    continue;
                    localj.X(false);
                    break;
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.fw())) {
      localView = super.a(paramj, paramView, paramViewGroup);
    }
    if (paramj.isActionViewExpanded()) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      paramj = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramj.checkLayoutParams(paramView)) {
        localView.setLayoutParams(ActionMenuView.b(paramView));
      }
      return localView;
    }
  }
  
  public final void a(Context paramContext, h paramh)
  {
    boolean bool = true;
    super.a(paramContext, paramh);
    paramh = paramContext.getResources();
    paramContext = android.support.v7.view.a.T(paramContext);
    int i;
    if (!this.XG)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        this.XF = bool;
      }
    }
    else
    {
      if (!this.XM) {
        this.XH = (paramContext.mContext.getResources().getDisplayMetrics().widthPixels / 2);
      }
      if (!this.XK) {
        this.XJ = paramContext.eL();
      }
      i = this.XH;
      if (!this.XF) {
        break label218;
      }
      if (this.XC == null)
      {
        this.XC = new d(this.Ur);
        if (this.XE)
        {
          this.XC.setImageDrawable(this.XD);
          this.XD = null;
          this.XE = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.XC.measure(j, j);
      }
      i -= this.XC.getMeasuredWidth();
    }
    for (;;)
    {
      this.XI = i;
      this.XO = ((int)(56.0F * paramh.getDisplayMetrics().density));
      this.XQ = null;
      return;
      if (!ViewConfiguration.get(paramContext.mContext).hasPermanentMenuKey()) {
        break;
      }
      bool = false;
      break;
      label218:
      this.XC = null;
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    fI();
    super.a(paramh, paramBoolean);
  }
  
  public final void a(j paramj, p.a parama)
  {
    parama.a(paramj);
    paramj = (ActionMenuView)this.Uv;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramj);
    if (this.XU == null) {
      this.XU = new b();
    }
    parama.setPopupCallback(this.XU);
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    this.Uv = paramActionMenuView;
    paramActionMenuView.dm = this.dm;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    for (Object localObject = paramu; ((u)localObject).Wy != this.dm; localObject = (u)((u)localObject).Wy) {}
    MenuItem localMenuItem = ((u)localObject).getItem();
    ViewGroup localViewGroup = (ViewGroup)this.Uv;
    int i;
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      i = 0;
      label66:
      if (i < j)
      {
        localObject = localViewGroup.getChildAt(i);
        if (((localObject instanceof p.a)) && (((p.a)localObject).getItemData() == localMenuItem))
        {
          label102:
          if (localObject == null) {
            break label222;
          }
          this.XW = paramu.getItem().getItemId();
          j = paramu.size();
          i = 0;
          label127:
          if (i >= j) {
            break label239;
          }
          localMenuItem = paramu.getItem(i);
          if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {
            break label224;
          }
        }
      }
    }
    label222:
    label224:
    label239:
    for (boolean bool = true;; bool = false)
    {
      this.XS = new a(this.mContext, paramu, (View)localObject);
      this.XS.setForceShowIcon(bool);
      if (!this.XS.fy())
      {
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        i += 1;
        break label66;
        localObject = null;
        break label102;
        break;
        i += 1;
        break label127;
      }
      super.a(paramu);
      return true;
    }
  }
  
  public final boolean c(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.XC) {
      return false;
    }
    return super.c(paramViewGroup, paramInt);
  }
  
  public final boolean e(j paramj)
  {
    return paramj.ft();
  }
  
  public final void fH()
  {
    this.XF = true;
    this.XG = true;
  }
  
  public final boolean fI()
  {
    return hideOverflowMenu() | fJ();
  }
  
  public final boolean fJ()
  {
    if (this.XS != null)
    {
      this.XS.dismiss();
      return true;
    }
    return false;
  }
  
  public final p g(ViewGroup paramViewGroup)
  {
    p localp = this.Uv;
    paramViewGroup = super.g(paramViewGroup);
    if (localp != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public final boolean hideOverflowMenu()
  {
    if ((this.XT != null) && (this.Uv != null))
    {
      ((View)this.Uv).removeCallbacks(this.XT);
      this.XT = null;
      return true;
    }
    e locale = this.XR;
    if (locale != null)
    {
      locale.dismiss();
      return true;
    }
    return false;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return (this.XR != null) && (this.XR.isShowing());
  }
  
  public final void o(boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    super.o(paramBoolean);
    ((View)this.Uv).requestLayout();
    Object localObject;
    int i;
    if (this.dm != null)
    {
      localObject = this.dm;
      ((h)localObject).fm();
      localObject = ((h)localObject).VA;
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        android.support.v4.view.b localb = ((j)((ArrayList)localObject).get(i)).VY;
        if (localb != null) {
          localb.EH = this;
        }
        i += 1;
      }
    }
    if (this.dm != null)
    {
      localObject = this.dm.fn();
      i = k;
      if (this.XF)
      {
        i = k;
        if (localObject != null)
        {
          i = ((ArrayList)localObject).size();
          if (i != 1) {
            break label259;
          }
          if (((j)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label254;
          }
          i = 1;
        }
      }
      label154:
      if (i == 0) {
        break label273;
      }
      if (this.XC == null) {
        this.XC = new d(this.Ur);
      }
      localObject = (ViewGroup)this.XC.getParent();
      if (localObject != this.Uv)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.XC);
        }
        ((ActionMenuView)this.Uv).addView(this.XC, ActionMenuView.fM());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.Uv).setOverflowReserved(this.XF);
      return;
      localObject = null;
      break;
      label254:
      i = 0;
      break label154;
      label259:
      if (i > 0) {}
      for (i = j;; i = 0) {
        break;
      }
      label273:
      if ((this.XC != null) && (this.XC.getParent() == this.Uv)) {
        ((ViewGroup)this.Uv).removeView(this.XC);
      }
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {}
    do
    {
      do
      {
        return;
        paramParcelable = (SavedState)paramParcelable;
      } while (paramParcelable.Yc <= 0);
      paramParcelable = this.dm.findItem(paramParcelable.Yc);
    } while (paramParcelable == null);
    a((u)paramParcelable.getSubMenu());
  }
  
  public final Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.Yc = this.XW;
    return localSavedState;
  }
  
  public final boolean showOverflowMenu()
  {
    if ((this.XF) && (!isOverflowMenuShowing()) && (this.dm != null) && (this.Uv != null) && (this.XT == null) && (!this.dm.fn().isEmpty()))
    {
      this.XT = new c(new e(this.mContext, this.dm, this.XC));
      ((View)this.Uv).post(this.XT);
      super.a(null);
      return true;
    }
    return false;
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int Yc;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.Yc = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.Yc);
    }
  }
  
  private final class a
    extends n
  {
    public a(Context paramContext, u paramu, View paramView)
    {
      super(paramu, paramView, false, a.a.actionOverflowMenuStyle);
      if (!((j)paramu.getItem()).ft()) {
        if (ActionMenuPresenter.this.XC != null) {
          break label59;
        }
      }
      label59:
      for (paramContext = (View)ActionMenuPresenter.this.Uv;; paramContext = ActionMenuPresenter.this.XC)
      {
        this.hX = paramContext;
        b(ActionMenuPresenter.this.XV);
        return;
      }
    }
    
    protected final void onDismiss()
    {
      ActionMenuPresenter.this.XS = null;
      ActionMenuPresenter.this.XW = 0;
      super.onDismiss();
    }
  }
  
  private final class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public final s eX()
    {
      if (ActionMenuPresenter.this.XS != null) {
        return ActionMenuPresenter.this.XS.fx();
      }
      return null;
    }
  }
  
  private final class c
    implements Runnable
  {
    private ActionMenuPresenter.e XY;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.XY = parame;
    }
    
    public final void run()
    {
      if (ActionMenuPresenter.this.dm != null)
      {
        localObject = ActionMenuPresenter.this.dm;
        if (((h)localObject).Vx != null) {
          ((h)localObject).Vx.b((h)localObject);
        }
      }
      Object localObject = (View)ActionMenuPresenter.this.Uv;
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (this.XY.fy())) {
        ActionMenuPresenter.this.XR = this.XY;
      }
      ActionMenuPresenter.this.XT = null;
    }
  }
  
  private final class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    private final float[] XZ = new float[2];
    
    public d(Context paramContext)
    {
      super(null, a.a.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      az.a(this, getContentDescription());
      setOnTouchListener(new ac(this)
      {
        public final s eX()
        {
          if (ActionMenuPresenter.this.XR == null) {
            return null;
          }
          return ActionMenuPresenter.this.XR.fx();
        }
        
        public final boolean eY()
        {
          ActionMenuPresenter.this.showOverflowMenu();
          return true;
        }
        
        public final boolean fK()
        {
          if (ActionMenuPresenter.this.XT != null) {
            return false;
          }
          ActionMenuPresenter.this.hideOverflowMenu();
          return true;
        }
      });
    }
    
    public final boolean eV()
    {
      return false;
    }
    
    public final boolean eW()
    {
      return false;
    }
    
    public final boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }
    
    protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt2 = getHeight();
        paramInt1 = Math.max(i, paramInt2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
        android.support.v4.a.a.a.a(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
  }
  
  private final class e
    extends n
  {
    public e(Context paramContext, h paramh, View paramView)
    {
      super(paramh, paramView, true, a.a.actionOverflowMenuStyle);
      this.UJ = 8388613;
      b(ActionMenuPresenter.this.XV);
    }
    
    protected final void onDismiss()
    {
      if (ActionMenuPresenter.this.dm != null) {
        ActionMenuPresenter.this.dm.close();
      }
      ActionMenuPresenter.this.XR = null;
      super.onDismiss();
    }
  }
  
  private final class f
    implements o.a
  {
    f() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      if ((paramh instanceof u)) {
        paramh.fo().T(false);
      }
      o.a locala = ActionMenuPresenter.this.dL;
      if (locala != null) {
        locala.a(paramh, paramBoolean);
      }
    }
    
    public final boolean d(h paramh)
    {
      if (paramh == null) {
        return false;
      }
      ActionMenuPresenter.this.XW = ((u)paramh).getItem().getItemId();
      o.a locala = ActionMenuPresenter.this.dL;
      if (locala != null) {
        return locala.d(paramh);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */