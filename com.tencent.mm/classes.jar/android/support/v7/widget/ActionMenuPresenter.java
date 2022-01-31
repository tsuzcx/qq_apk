package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.b.a;
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
  private final SparseBooleanArray YA = new SparseBooleanArray();
  private View YB;
  e YC;
  a YD;
  c YE;
  private b YF;
  final f YG = new f();
  int YH;
  d Yn;
  Drawable Yo;
  boolean Yp;
  private boolean Yq;
  private boolean Yr;
  private int Ys;
  private int Yt;
  private int Yu;
  private boolean Yv;
  private boolean Yw;
  private boolean Yx;
  boolean Yy;
  private int Yz;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void F(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.a(null);
    }
    while (this.eq == null) {
      return;
    }
    this.eq.V(false);
  }
  
  public final View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.gp())) {
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
    paramContext = android.support.v7.view.a.W(paramContext);
    int i;
    if (!this.Yr)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        this.Yq = bool;
      }
    }
    else
    {
      if (!this.Yx) {
        this.Ys = (paramContext.mContext.getResources().getDisplayMetrics().widthPixels / 2);
      }
      if (!this.Yv) {
        this.Yu = paramContext.fy();
      }
      i = this.Ys;
      if (!this.Yq) {
        break label217;
      }
      if (this.Yn == null)
      {
        this.Yn = new d(this.Vc);
        if (this.Yp)
        {
          this.Yn.setImageDrawable(this.Yo);
          this.Yo = null;
          this.Yp = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.Yn.measure(j, j);
      }
      i -= this.Yn.getMeasuredWidth();
    }
    for (;;)
    {
      this.Yt = i;
      this.Yz = ((int)(56.0F * paramh.getDisplayMetrics().density));
      this.YB = null;
      return;
      if (!ViewConfiguration.get(paramContext.mContext).hasPermanentMenuKey()) {
        break;
      }
      bool = false;
      break;
      label217:
      this.Yn = null;
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    gC();
    super.a(paramh, paramBoolean);
  }
  
  public final void a(j paramj, p.a parama)
  {
    parama.a(paramj);
    paramj = (ActionMenuView)this.Vg;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramj);
    if (this.YF == null) {
      this.YF = new b();
    }
    parama.setPopupCallback(this.YF);
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    this.Vg = paramActionMenuView;
    paramActionMenuView.eq = this.eq;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    for (Object localObject = paramu; ((u)localObject).Xl != this.eq; localObject = (u)((u)localObject).Xl) {}
    MenuItem localMenuItem = ((u)localObject).getItem();
    ViewGroup localViewGroup = (ViewGroup)this.Vg;
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
          this.YH = paramu.getItem().getItemId();
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
      this.YD = new a(this.mContext, paramu, (View)localObject);
      this.YD.setForceShowIcon(bool);
      if (!this.YD.gr())
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
  
  public final boolean aG()
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
    if (this.eq != null)
    {
      localArrayList = this.eq.gb();
      i1 = localArrayList.size();
      i = this.Yu;
      i4 = this.Yt;
      i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.Vg;
      k = 0;
      m = 0;
      n = 0;
      j = 0;
      if (j >= i1) {
        break label145;
      }
      localObject1 = (j)localArrayList.get(j);
      if (!((j)localObject1).gn()) {
        break label122;
      }
      k += 1;
      label89:
      if ((!this.Yy) || (!((j)localObject1).isActionViewExpanded())) {
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
      if (((j)localObject1).gm())
      {
        m += 1;
        break label89;
      }
      n = 1;
      break label89;
      j = i;
      if (this.Yq) {
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
      localObject1 = this.YA;
      ((SparseBooleanArray)localObject1).clear();
      i = 0;
      if (this.Yw)
      {
        i = i4 / this.Yz;
        k = this.Yz;
        m = this.Yz;
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
          if (localj.gn())
          {
            localObject2 = a(localj, this.YB, localViewGroup);
            if (this.YB == null) {
              this.YB = ((View)localObject2);
            }
            if (this.Yw)
            {
              i -= ActionMenuView.f((View)localObject2, i2, i, i5, 0);
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
          localj.Z(true);
          m -= n;
          i3 += 1;
          break;
          ((View)localObject2).measure(i5, i5);
          break label311;
          int i6;
          boolean bool;
          int i7;
          if (localj.gm())
          {
            i6 = localj.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i6);
            if (((j > 0) || (bool)) && (m > 0) && ((!this.Yw) || (i > 0)))
            {
              i7 = 1;
              if (i7 == 0) {
                break label744;
              }
              localObject2 = a(localj, this.YB, localViewGroup);
              if (this.YB == null) {
                this.YB = ((View)localObject2);
              }
              if (!this.Yw) {
                break label601;
              }
              i4 = ActionMenuView.f((View)localObject2, i2, i, i5, 0);
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
              if (!this.Yw) {
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
              localj.Z(i7);
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
                      if (((j)localObject2).gl()) {
                        n = j + 1;
                      }
                      ((j)localObject2).Z(false);
                    }
                    i4 += 1;
                    j = n;
                    continue;
                    localj.Z(false);
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
  
  public final boolean b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.Yn) {
      return false;
    }
    return super.b(paramViewGroup, paramInt);
  }
  
  public final p e(ViewGroup paramViewGroup)
  {
    p localp = this.Vg;
    paramViewGroup = super.e(paramViewGroup);
    if (localp != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public final boolean e(j paramj)
  {
    return paramj.gl();
  }
  
  public final void gA()
  {
    if (!this.Yv) {
      this.Yu = android.support.v7.view.a.W(this.mContext).fy();
    }
    if (this.eq != null) {
      this.eq.p(true);
    }
  }
  
  public final void gB()
  {
    this.Yq = true;
    this.Yr = true;
  }
  
  public final boolean gC()
  {
    return hideOverflowMenu() | gD();
  }
  
  public final boolean gD()
  {
    if (this.YD != null)
    {
      this.YD.dismiss();
      return true;
    }
    return false;
  }
  
  public final boolean hideOverflowMenu()
  {
    if ((this.YE != null) && (this.Vg != null))
    {
      ((View)this.Vg).removeCallbacks(this.YE);
      this.YE = null;
      return true;
    }
    e locale = this.YC;
    if (locale != null)
    {
      locale.dismiss();
      return true;
    }
    return false;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return (this.YC != null) && (this.YC.isShowing());
  }
  
  public final void n(boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    super.n(paramBoolean);
    ((View)this.Vg).requestLayout();
    Object localObject;
    int i;
    if (this.eq != null)
    {
      localObject = this.eq;
      ((h)localObject).gd();
      localObject = ((h)localObject).Wp;
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        android.support.v4.view.b localb = ((j)((ArrayList)localObject).get(i)).WO;
        if (localb != null) {
          localb.Fq = this;
        }
        i += 1;
      }
    }
    if (this.eq != null)
    {
      localObject = this.eq.ge();
      i = k;
      if (this.Yq)
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
      if (this.Yn == null) {
        this.Yn = new d(this.Vc);
      }
      localObject = (ViewGroup)this.Yn.getParent();
      if (localObject != this.Vg)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.Yn);
        }
        ((ActionMenuView)this.Vg).addView(this.Yn, ActionMenuView.gG());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.Vg).setOverflowReserved(this.Yq);
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
      if ((this.Yn != null) && (this.Yn.getParent() == this.Vg)) {
        ((ViewGroup)this.Vg).removeView(this.Yn);
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
      } while (paramParcelable.YN <= 0);
      paramParcelable = this.eq.findItem(paramParcelable.YN);
    } while (paramParcelable == null);
    a((u)paramParcelable.getSubMenu());
  }
  
  public final Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.YN = this.YH;
    return localSavedState;
  }
  
  public final boolean showOverflowMenu()
  {
    if ((this.Yq) && (!isOverflowMenuShowing()) && (this.eq != null) && (this.Vg != null) && (this.YE == null) && (!this.eq.ge().isEmpty()))
    {
      this.YE = new c(new e(this.mContext, this.eq, this.Yn));
      ((View)this.Vg).post(this.YE);
      super.a(null);
      return true;
    }
    return false;
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int YN;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.YN = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.YN);
    }
  }
  
  final class a
    extends n
  {
    public a(Context paramContext, u paramu, View paramView)
    {
      super(paramu, paramView, false);
      if (!((j)paramu.getItem()).gl()) {
        if (ActionMenuPresenter.this.Yn != null) {
          break label56;
        }
      }
      label56:
      for (paramContext = (View)ActionMenuPresenter.this.Vg;; paramContext = ActionMenuPresenter.this.Yn)
      {
        this.iU = paramContext;
        c(ActionMenuPresenter.this.YG);
        return;
      }
    }
    
    public final void onDismiss()
    {
      ActionMenuPresenter.this.YD = null;
      ActionMenuPresenter.this.YH = 0;
      super.onDismiss();
    }
  }
  
  final class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public final s fL()
    {
      if (ActionMenuPresenter.this.YD != null) {
        return ActionMenuPresenter.this.YD.gq();
      }
      return null;
    }
  }
  
  final class c
    implements Runnable
  {
    private ActionMenuPresenter.e YJ;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.YJ = parame;
    }
    
    public final void run()
    {
      if (ActionMenuPresenter.this.eq != null)
      {
        localObject = ActionMenuPresenter.this.eq;
        if (((h)localObject).Wm != null) {
          ((h)localObject).Wm.b((h)localObject);
        }
      }
      Object localObject = (View)ActionMenuPresenter.this.Vg;
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (this.YJ.gr())) {
        ActionMenuPresenter.this.YC = this.YJ;
      }
      ActionMenuPresenter.this.YE = null;
    }
  }
  
  final class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    private final float[] YK = new float[2];
    
    public d(Context paramContext)
    {
      super(null, 2130772136);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      bb.a(this, getContentDescription());
      setOnTouchListener(new ab(this)
      {
        public final s fL()
        {
          if (ActionMenuPresenter.this.YC == null) {
            return null;
          }
          return ActionMenuPresenter.this.YC.gq();
        }
        
        public final boolean fM()
        {
          ActionMenuPresenter.this.showOverflowMenu();
          return true;
        }
        
        public final boolean gE()
        {
          if (ActionMenuPresenter.this.YE != null) {
            return false;
          }
          ActionMenuPresenter.this.hideOverflowMenu();
          return true;
        }
      });
    }
    
    public final boolean fJ()
    {
      return false;
    }
    
    public final boolean fK()
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
        android.support.v4.graphics.drawable.a.a(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
  }
  
  final class e
    extends n
  {
    public e(Context paramContext, h paramh, View paramView)
    {
      super(paramh, paramView, true);
      this.Vw = 8388613;
      c(ActionMenuPresenter.this.YG);
    }
    
    public final void onDismiss()
    {
      if (ActionMenuPresenter.this.eq != null) {
        ActionMenuPresenter.this.eq.close();
      }
      ActionMenuPresenter.this.YC = null;
      super.onDismiss();
    }
  }
  
  final class f
    implements o.a
  {
    f() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      if ((paramh instanceof u)) {
        paramh.gf().V(false);
      }
      o.a locala = ActionMenuPresenter.this.eN;
      if (locala != null) {
        locala.a(paramh, paramBoolean);
      }
    }
    
    public final boolean d(h paramh)
    {
      if (paramh == null) {
        return false;
      }
      ActionMenuPresenter.this.YH = ((u)paramh).getItem().getItemId();
      o.a locala = ActionMenuPresenter.this.eN;
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