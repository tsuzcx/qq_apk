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
  private final SparseBooleanArray agA = new SparseBooleanArray();
  private View agB;
  e agC;
  a agD;
  c agE;
  private b agF;
  final f agG = new f();
  int agH;
  d agn;
  Drawable ago;
  boolean agp;
  private boolean agq;
  private boolean agr;
  private int ags;
  private int agt;
  private int agu;
  private boolean agv;
  private boolean agw;
  private boolean agx;
  boolean agy;
  private int agz;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void L(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.a(null);
    }
    while (this.YO == null) {
      return;
    }
    this.YO.ab(false);
  }
  
  public final View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.hS())) {
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
    paramContext = android.support.v7.view.a.Z(paramContext);
    int i;
    if (!this.agr)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        this.agq = bool;
      }
    }
    else
    {
      if (!this.agx) {
        this.ags = (paramContext.mContext.getResources().getDisplayMetrics().widthPixels / 2);
      }
      if (!this.agv) {
        this.agu = paramContext.hc();
      }
      i = this.ags;
      if (!this.agq) {
        break label217;
      }
      if (this.agn == null)
      {
        this.agn = new d(this.ada);
        if (this.agp)
        {
          this.agn.setImageDrawable(this.ago);
          this.ago = null;
          this.agp = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.agn.measure(j, j);
      }
      i -= this.agn.getMeasuredWidth();
    }
    for (;;)
    {
      this.agt = i;
      this.agz = ((int)(56.0F * paramh.getDisplayMetrics().density));
      this.agB = null;
      return;
      if (!ViewConfiguration.get(paramContext.mContext).hasPermanentMenuKey()) {
        break;
      }
      bool = false;
      break;
      label217:
      this.agn = null;
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    ig();
    super.a(paramh, paramBoolean);
  }
  
  public final void a(j paramj, p.a parama)
  {
    parama.a(paramj);
    paramj = (ActionMenuView)this.adf;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramj);
    if (this.agF == null) {
      this.agF = new b();
    }
    parama.setPopupCallback(this.agF);
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    this.adf = paramActionMenuView;
    paramActionMenuView.YO = this.YO;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    for (Object localObject = paramu; ((u)localObject).afk != this.YO; localObject = (u)((u)localObject).afk) {}
    MenuItem localMenuItem = ((u)localObject).getItem();
    ViewGroup localViewGroup = (ViewGroup)this.adf;
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
          this.agH = paramu.getItem().getItemId();
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
      this.agD = new a(this.mContext, paramu, (View)localObject);
      this.agD.setForceShowIcon(bool);
      if (!this.agD.hU())
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
  
  public final boolean bo()
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
    if (this.YO != null)
    {
      localArrayList = this.YO.hF();
      i1 = localArrayList.size();
      i = this.agu;
      i4 = this.agt;
      i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.adf;
      k = 0;
      m = 0;
      n = 0;
      j = 0;
      if (j >= i1) {
        break label145;
      }
      localObject1 = (j)localArrayList.get(j);
      if (!((j)localObject1).hQ()) {
        break label122;
      }
      k += 1;
      label89:
      if ((!this.agy) || (!((j)localObject1).isActionViewExpanded())) {
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
      if (((j)localObject1).hP())
      {
        m += 1;
        break label89;
      }
      n = 1;
      break label89;
      j = i;
      if (this.agq) {
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
      localObject1 = this.agA;
      ((SparseBooleanArray)localObject1).clear();
      i = 0;
      if (this.agw)
      {
        i = i4 / this.agz;
        k = this.agz;
        m = this.agz;
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
          if (localj.hQ())
          {
            localObject2 = a(localj, this.agB, localViewGroup);
            if (this.agB == null) {
              this.agB = ((View)localObject2);
            }
            if (this.agw)
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
          localj.af(true);
          m -= n;
          i3 += 1;
          break;
          ((View)localObject2).measure(i5, i5);
          break label311;
          int i6;
          boolean bool;
          int i7;
          if (localj.hP())
          {
            i6 = localj.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i6);
            if (((j > 0) || (bool)) && (m > 0) && ((!this.agw) || (i > 0)))
            {
              i7 = 1;
              if (i7 == 0) {
                break label744;
              }
              localObject2 = a(localj, this.agB, localViewGroup);
              if (this.agB == null) {
                this.agB = ((View)localObject2);
              }
              if (!this.agw) {
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
              if (!this.agw) {
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
              localj.af(i7);
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
                      if (((j)localObject2).hO()) {
                        n = j + 1;
                      }
                      ((j)localObject2).af(false);
                    }
                    i4 += 1;
                    j = n;
                    continue;
                    localj.af(false);
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
  
  public final p c(ViewGroup paramViewGroup)
  {
    p localp = this.adf;
    paramViewGroup = super.c(paramViewGroup);
    if (localp != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public final boolean c(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.agn) {
      return false;
    }
    return super.c(paramViewGroup, paramInt);
  }
  
  public final boolean e(j paramj)
  {
    return paramj.hO();
  }
  
  public final boolean hideOverflowMenu()
  {
    if ((this.agE != null) && (this.adf != null))
    {
      ((View)this.adf).removeCallbacks(this.agE);
      this.agE = null;
      return true;
    }
    e locale = this.agC;
    if (locale != null)
    {
      locale.dismiss();
      return true;
    }
    return false;
  }
  
  public final void ie()
  {
    if (!this.agv) {
      this.agu = android.support.v7.view.a.Z(this.mContext).hc();
    }
    if (this.YO != null) {
      this.YO.r(true);
    }
  }
  
  public final void jdMethod_if()
  {
    this.agq = true;
    this.agr = true;
  }
  
  public final boolean ig()
  {
    return hideOverflowMenu() | ih();
  }
  
  public final boolean ih()
  {
    if (this.agD != null)
    {
      this.agD.dismiss();
      return true;
    }
    return false;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return (this.agC != null) && (this.agC.isShowing());
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
      } while (paramParcelable.agN <= 0);
      paramParcelable = this.YO.findItem(paramParcelable.agN);
    } while (paramParcelable == null);
    a((u)paramParcelable.getSubMenu());
  }
  
  public final Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.agN = this.agH;
    return localSavedState;
  }
  
  public final void p(boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    super.p(paramBoolean);
    ((View)this.adf).requestLayout();
    Object localObject;
    int i;
    if (this.YO != null)
    {
      localObject = this.YO;
      ((h)localObject).hG();
      localObject = ((h)localObject).aep;
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        android.support.v4.view.b localb = ((j)((ArrayList)localObject).get(i)).aeO;
        if (localb != null) {
          localb.Nl = this;
        }
        i += 1;
      }
    }
    if (this.YO != null)
    {
      localObject = this.YO.hH();
      i = k;
      if (this.agq)
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
      if (this.agn == null) {
        this.agn = new d(this.ada);
      }
      localObject = (ViewGroup)this.agn.getParent();
      if (localObject != this.adf)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.agn);
        }
        ((ActionMenuView)this.adf).addView(this.agn, ActionMenuView.ik());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.adf).setOverflowReserved(this.agq);
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
      if ((this.agn != null) && (this.agn.getParent() == this.adf)) {
        ((ViewGroup)this.adf).removeView(this.agn);
      }
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if ((this.agq) && (!isOverflowMenuShowing()) && (this.YO != null) && (this.adf != null) && (this.agE == null) && (!this.YO.hH().isEmpty()))
    {
      this.agE = new c(new e(this.mContext, this.YO, this.agn));
      ((View)this.adf).post(this.agE);
      super.a(null);
      return true;
    }
    return false;
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int agN;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.agN = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.agN);
    }
  }
  
  final class a
    extends n
  {
    public a(Context paramContext, u paramu, View paramView)
    {
      super(paramu, paramView, false);
      if (!((j)paramu.getItem()).hO()) {
        if (ActionMenuPresenter.this.agn != null) {
          break label56;
        }
      }
      label56:
      for (paramContext = (View)ActionMenuPresenter.this.adf;; paramContext = ActionMenuPresenter.this.agn)
      {
        this.oP = paramContext;
        c(ActionMenuPresenter.this.agG);
        return;
      }
    }
    
    public final void onDismiss()
    {
      ActionMenuPresenter.this.agD = null;
      ActionMenuPresenter.this.agH = 0;
      super.onDismiss();
    }
  }
  
  final class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public final s hp()
    {
      if (ActionMenuPresenter.this.agD != null) {
        return ActionMenuPresenter.this.agD.hT();
      }
      return null;
    }
  }
  
  final class c
    implements Runnable
  {
    private ActionMenuPresenter.e agJ;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.agJ = parame;
    }
    
    public final void run()
    {
      if (ActionMenuPresenter.this.YO != null)
      {
        localObject = ActionMenuPresenter.this.YO;
        if (((h)localObject).aem != null) {
          ((h)localObject).aem.b((h)localObject);
        }
      }
      Object localObject = (View)ActionMenuPresenter.this.adf;
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (this.agJ.hU())) {
        ActionMenuPresenter.this.agC = this.agJ;
      }
      ActionMenuPresenter.this.agE = null;
    }
  }
  
  final class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    private final float[] agK = new float[2];
    
    public d(Context paramContext)
    {
      super(null, 2130968626);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      bb.a(this, getContentDescription());
      setOnTouchListener(new ab(this)
      {
        public final s hp()
        {
          if (ActionMenuPresenter.this.agC == null) {
            return null;
          }
          return ActionMenuPresenter.this.agC.hT();
        }
        
        public final boolean hq()
        {
          ActionMenuPresenter.this.showOverflowMenu();
          return true;
        }
        
        public final boolean ii()
        {
          if (ActionMenuPresenter.this.agE != null) {
            return false;
          }
          ActionMenuPresenter.this.hideOverflowMenu();
          return true;
        }
      });
    }
    
    public final boolean hn()
    {
      return false;
    }
    
    public final boolean ho()
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
      this.adv = 8388613;
      c(ActionMenuPresenter.this.agG);
    }
    
    public final void onDismiss()
    {
      if (ActionMenuPresenter.this.YO != null) {
        ActionMenuPresenter.this.YO.close();
      }
      ActionMenuPresenter.this.agC = null;
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
        paramh.hI().ab(false);
      }
      o.a locala = ActionMenuPresenter.this.adc;
      if (locala != null) {
        locala.a(paramh, paramBoolean);
      }
    }
    
    public final boolean d(h paramh)
    {
      if (paramh == null) {
        return false;
      }
      ActionMenuPresenter.this.agH = ((u)paramh).getItem().getItemId();
      o.a locala = ActionMenuPresenter.this.adc;
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