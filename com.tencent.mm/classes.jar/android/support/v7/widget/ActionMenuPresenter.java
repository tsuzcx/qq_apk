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
  private boolean aiA;
  private boolean aiB;
  boolean aiC;
  private int aiD;
  private final SparseBooleanArray aiE = new SparseBooleanArray();
  private View aiF;
  e aiG;
  a aiH;
  c aiI;
  private b aiJ;
  final f aiK = new f();
  int aiL;
  d air;
  Drawable ais;
  boolean ait;
  private boolean aiu;
  private boolean aiv;
  private int aiw;
  private int aix;
  private int aiy;
  private boolean aiz;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void K(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.a(null);
    }
    while (this.aaQ == null) {
      return;
    }
    this.aaQ.aa(false);
  }
  
  public final View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.it())) {
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
    paramContext = android.support.v7.view.a.ab(paramContext);
    int i;
    if (!this.aiv)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        this.aiu = bool;
      }
    }
    else
    {
      if (!this.aiB) {
        this.aiw = (paramContext.mContext.getResources().getDisplayMetrics().widthPixels / 2);
      }
      if (!this.aiz) {
        this.aiy = paramContext.hB();
      }
      i = this.aiw;
      if (!this.aiu) {
        break label217;
      }
      if (this.air == null)
      {
        this.air = new d(this.afe);
        if (this.ait)
        {
          this.air.setImageDrawable(this.ais);
          this.ais = null;
          this.ait = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.air.measure(j, j);
      }
      i -= this.air.getMeasuredWidth();
    }
    for (;;)
    {
      this.aix = i;
      this.aiD = ((int)(56.0F * paramh.getDisplayMetrics().density));
      this.aiF = null;
      return;
      if (!ViewConfiguration.get(paramContext.mContext).hasPermanentMenuKey()) {
        break;
      }
      bool = false;
      break;
      label217:
      this.air = null;
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    iG();
    super.a(paramh, paramBoolean);
  }
  
  public final void a(j paramj, p.a parama)
  {
    parama.a(paramj);
    paramj = (ActionMenuView)this.afj;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramj);
    if (this.aiJ == null) {
      this.aiJ = new b();
    }
    parama.setPopupCallback(this.aiJ);
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    this.afj = paramActionMenuView;
    paramActionMenuView.aaQ = this.aaQ;
  }
  
  public final boolean a(u paramu)
  {
    if (!paramu.hasVisibleItems()) {
      return false;
    }
    for (Object localObject = paramu; ((u)localObject).aho != this.aaQ; localObject = (u)((u)localObject).aho) {}
    MenuItem localMenuItem = ((u)localObject).getItem();
    ViewGroup localViewGroup = (ViewGroup)this.afj;
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
          this.aiL = paramu.getItem().getItemId();
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
      this.aiH = new a(this.mContext, paramu, (View)localObject);
      this.aiH.setForceShowIcon(bool);
      if (!this.aiH.iv())
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
  
  public final boolean bF()
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
    if (this.aaQ != null)
    {
      localArrayList = this.aaQ.jdMethod_if();
      i1 = localArrayList.size();
      i = this.aiy;
      i4 = this.aix;
      i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.afj;
      k = 0;
      m = 0;
      n = 0;
      j = 0;
      if (j >= i1) {
        break label145;
      }
      localObject1 = (j)localArrayList.get(j);
      if (!((j)localObject1).ir()) {
        break label122;
      }
      k += 1;
      label89:
      if ((!this.aiC) || (!((j)localObject1).isActionViewExpanded())) {
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
      if (((j)localObject1).iq())
      {
        m += 1;
        break label89;
      }
      n = 1;
      break label89;
      j = i;
      if (this.aiu) {
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
      localObject1 = this.aiE;
      ((SparseBooleanArray)localObject1).clear();
      i = 0;
      if (this.aiA)
      {
        i = i4 / this.aiD;
        k = this.aiD;
        m = this.aiD;
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
          if (localj.ir())
          {
            localObject2 = a(localj, this.aiF, localViewGroup);
            if (this.aiF == null) {
              this.aiF = ((View)localObject2);
            }
            if (this.aiA)
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
          localj.ae(true);
          m -= n;
          i3 += 1;
          break;
          ((View)localObject2).measure(i5, i5);
          break label311;
          int i6;
          boolean bool;
          int i7;
          if (localj.iq())
          {
            i6 = localj.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i6);
            if (((j > 0) || (bool)) && (m > 0) && ((!this.aiA) || (i > 0)))
            {
              i7 = 1;
              if (i7 == 0) {
                break label744;
              }
              localObject2 = a(localj, this.aiF, localViewGroup);
              if (this.aiF == null) {
                this.aiF = ((View)localObject2);
              }
              if (!this.aiA) {
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
              if (!this.aiA) {
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
              localj.ae(i7);
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
                      if (((j)localObject2).ip()) {
                        n = j + 1;
                      }
                      ((j)localObject2).ae(false);
                    }
                    i4 += 1;
                    j = n;
                    continue;
                    localj.ae(false);
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
    p localp = this.afj;
    paramViewGroup = super.c(paramViewGroup);
    if (localp != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public final boolean c(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.air) {
      return false;
    }
    return super.c(paramViewGroup, paramInt);
  }
  
  public final boolean e(j paramj)
  {
    return paramj.ip();
  }
  
  public final boolean hideOverflowMenu()
  {
    if ((this.aiI != null) && (this.afj != null))
    {
      ((View)this.afj).removeCallbacks(this.aiI);
      this.aiI = null;
      return true;
    }
    e locale = this.aiG;
    if (locale != null)
    {
      locale.dismiss();
      return true;
    }
    return false;
  }
  
  public final void iE()
  {
    if (!this.aiz) {
      this.aiy = android.support.v7.view.a.ab(this.mContext).hB();
    }
    if (this.aaQ != null) {
      this.aaQ.r(true);
    }
  }
  
  public final void iF()
  {
    this.aiu = true;
    this.aiv = true;
  }
  
  public final boolean iG()
  {
    return hideOverflowMenu() | iH();
  }
  
  public final boolean iH()
  {
    if (this.aiH != null)
    {
      this.aiH.dismiss();
      return true;
    }
    return false;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return (this.aiG != null) && (this.aiG.isShowing());
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
      } while (paramParcelable.aiR <= 0);
      paramParcelable = this.aaQ.findItem(paramParcelable.aiR);
    } while (paramParcelable == null);
    a((u)paramParcelable.getSubMenu());
  }
  
  public final Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.aiR = this.aiL;
    return localSavedState;
  }
  
  public final void p(boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    super.p(paramBoolean);
    ((View)this.afj).requestLayout();
    Object localObject;
    int i;
    if (this.aaQ != null)
    {
      localObject = this.aaQ;
      ((h)localObject).ig();
      localObject = ((h)localObject).agt;
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        android.support.v4.view.b localb = ((j)((ArrayList)localObject).get(i)).agS;
        if (localb != null) {
          localb.Po = this;
        }
        i += 1;
      }
    }
    if (this.aaQ != null)
    {
      localObject = this.aaQ.ih();
      i = k;
      if (this.aiu)
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
      if (this.air == null) {
        this.air = new d(this.afe);
      }
      localObject = (ViewGroup)this.air.getParent();
      if (localObject != this.afj)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.air);
        }
        ((ActionMenuView)this.afj).addView(this.air, ActionMenuView.iK());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.afj).setOverflowReserved(this.aiu);
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
      if ((this.air != null) && (this.air.getParent() == this.afj)) {
        ((ViewGroup)this.afj).removeView(this.air);
      }
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if ((this.aiu) && (!isOverflowMenuShowing()) && (this.aaQ != null) && (this.afj != null) && (this.aiI == null) && (!this.aaQ.ih().isEmpty()))
    {
      this.aiI = new c(new e(this.mContext, this.aaQ, this.air));
      ((View)this.afj).post(this.aiI);
      super.a(null);
      return true;
    }
    return false;
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int aiR;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.aiR = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.aiR);
    }
  }
  
  final class a
    extends n
  {
    public a(Context paramContext, u paramu, View paramView)
    {
      super(paramu, paramView, false);
      if (!((j)paramu.getItem()).ip()) {
        if (ActionMenuPresenter.this.air != null) {
          break label56;
        }
      }
      label56:
      for (paramContext = (View)ActionMenuPresenter.this.afj;; paramContext = ActionMenuPresenter.this.air)
      {
        this.qK = paramContext;
        c(ActionMenuPresenter.this.aiK);
        return;
      }
    }
    
    public final void onDismiss()
    {
      ActionMenuPresenter.this.aiH = null;
      ActionMenuPresenter.this.aiL = 0;
      super.onDismiss();
    }
  }
  
  final class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public final s hO()
    {
      if (ActionMenuPresenter.this.aiH != null) {
        return ActionMenuPresenter.this.aiH.iu();
      }
      return null;
    }
  }
  
  final class c
    implements Runnable
  {
    private ActionMenuPresenter.e aiN;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.aiN = parame;
    }
    
    public final void run()
    {
      if (ActionMenuPresenter.this.aaQ != null)
      {
        localObject = ActionMenuPresenter.this.aaQ;
        if (((h)localObject).agq != null) {
          ((h)localObject).agq.b((h)localObject);
        }
      }
      Object localObject = (View)ActionMenuPresenter.this.afj;
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (this.aiN.iv())) {
        ActionMenuPresenter.this.aiG = this.aiN;
      }
      ActionMenuPresenter.this.aiI = null;
    }
  }
  
  final class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    private final float[] aiO = new float[2];
    
    public d(Context paramContext)
    {
      super(null, 2130968627);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      bb.a(this, getContentDescription());
      setOnTouchListener(new ab(this)
      {
        public final s hO()
        {
          if (ActionMenuPresenter.this.aiG == null) {
            return null;
          }
          return ActionMenuPresenter.this.aiG.iu();
        }
        
        public final boolean hP()
        {
          ActionMenuPresenter.this.showOverflowMenu();
          return true;
        }
        
        public final boolean iI()
        {
          if (ActionMenuPresenter.this.aiI != null) {
            return false;
          }
          ActionMenuPresenter.this.hideOverflowMenu();
          return true;
        }
      });
    }
    
    public final boolean hM()
    {
      return false;
    }
    
    public final boolean hN()
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
      this.afz = 8388613;
      c(ActionMenuPresenter.this.aiK);
    }
    
    public final void onDismiss()
    {
      if (ActionMenuPresenter.this.aaQ != null) {
        ActionMenuPresenter.this.aaQ.close();
      }
      ActionMenuPresenter.this.aiG = null;
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
        paramh.ii().aa(false);
      }
      o.a locala = ActionMenuPresenter.this.afg;
      if (locala != null) {
        locala.a(paramh, paramBoolean);
      }
    }
    
    public final boolean d(h paramh)
    {
      if (paramh == null) {
        return false;
      }
      ActionMenuPresenter.this.aiL = ((u)paramh).getItem().getItemId();
      o.a locala = ActionMenuPresenter.this.afg;
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