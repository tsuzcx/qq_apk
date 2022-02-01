package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.appcompat.a.a;
import androidx.appcompat.a.g;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ActionMenuItemView.b;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.p.a;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.view.menu.u;
import androidx.core.g.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class ActionMenuPresenter
  extends androidx.appcompat.view.menu.b
  implements b.a
{
  d pG;
  Drawable pH;
  boolean pI;
  private boolean pJ;
  private boolean pK;
  private int pL;
  private int pM;
  private int pN;
  private boolean pO;
  private boolean pP;
  private boolean pQ;
  boolean pR;
  private int pS;
  private final SparseBooleanArray pT;
  private View pU;
  e pV;
  a pW;
  c pX;
  private b pY;
  final f pZ;
  int qa;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
    AppMethodBeat.i(200272);
    this.pT = new SparseBooleanArray();
    this.pZ = new f();
    AppMethodBeat.o(200272);
  }
  
  public final void J(boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(200368);
    super.J(paramBoolean);
    ((View)this.mo).requestLayout();
    Object localObject;
    int i;
    if (this.jo != null)
    {
      localObject = this.jo;
      ((h)localObject).dc();
      localObject = ((h)localObject).nC;
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        androidx.core.g.b localb = ((j)((ArrayList)localObject).get(i)).ob;
        if (localb != null) {
          localb.a(this);
        }
        i += 1;
      }
    }
    if (this.jo != null)
    {
      localObject = this.jo.dd();
      i = k;
      if (this.pJ)
      {
        i = k;
        if (localObject != null)
        {
          i = ((ArrayList)localObject).size();
          if (i != 1) {
            break label269;
          }
          if (((j)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label264;
          }
          i = 1;
        }
      }
      label159:
      if (i == 0) {
        break label283;
      }
      if (this.pG == null) {
        this.pG = new d(this.mj);
      }
      localObject = (ViewGroup)this.pG.getParent();
      if (localObject != this.mo)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.pG);
        }
        ((ActionMenuView)this.mo).addView(this.pG, ActionMenuView.dM());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.mo).setOverflowReserved(this.pJ);
      AppMethodBeat.o(200368);
      return;
      localObject = null;
      break;
      label264:
      i = 0;
      break label159;
      label269:
      if (i > 0) {}
      for (i = j;; i = 0) {
        break;
      }
      label283:
      if ((this.pG != null) && (this.pG.getParent() == this.mo)) {
        ((ViewGroup)this.mo).removeView(this.pG);
      }
    }
  }
  
  public final void R(boolean paramBoolean)
  {
    AppMethodBeat.i(200472);
    if (paramBoolean)
    {
      super.a(null);
      AppMethodBeat.o(200472);
      return;
    }
    if (this.jo != null) {
      this.jo.K(false);
    }
    AppMethodBeat.o(200472);
  }
  
  public final View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200341);
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.dn())) {
      localView = super.a(paramj, paramView, paramViewGroup);
    }
    if (paramj.isActionViewExpanded()) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      paramj = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramj.checkLayoutParams(paramView)) {
        localView.setLayoutParams(ActionMenuView.a(paramView));
      }
      AppMethodBeat.o(200341);
      return localView;
    }
  }
  
  public final p a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200332);
    p localp = this.mo;
    paramViewGroup = super.a(paramViewGroup);
    if (localp != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    AppMethodBeat.o(200332);
    return paramViewGroup;
  }
  
  public final void a(Context paramContext, h paramh)
  {
    boolean bool = true;
    AppMethodBeat.i(200317);
    super.a(paramContext, paramh);
    paramh = paramContext.getResources();
    paramContext = androidx.appcompat.view.a.I(paramContext);
    int i;
    if (!this.pK)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        this.pJ = bool;
      }
    }
    else
    {
      if (!this.pQ) {
        this.pL = (paramContext.mContext.getResources().getDisplayMetrics().widthPixels / 2);
      }
      if (!this.pO) {
        this.pN = paramContext.cr();
      }
      i = this.pL;
      if (!this.pJ) {
        break label228;
      }
      if (this.pG == null)
      {
        this.pG = new d(this.mj);
        if (this.pI)
        {
          this.pG.setImageDrawable(this.pH);
          this.pH = null;
          this.pI = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.pG.measure(j, j);
      }
      i -= this.pG.getMeasuredWidth();
    }
    for (;;)
    {
      this.pM = i;
      this.pS = ((int)(56.0F * paramh.getDisplayMetrics().density));
      this.pU = null;
      AppMethodBeat.o(200317);
      return;
      if (!ViewConfiguration.get(paramContext.mContext).hasPermanentMenuKey()) {
        break;
      }
      bool = false;
      break;
      label228:
      this.pG = null;
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(200448);
    dI();
    super.a(paramh, paramBoolean);
    AppMethodBeat.o(200448);
  }
  
  public final void a(j paramj, p.a parama)
  {
    AppMethodBeat.i(200349);
    parama.a(paramj);
    paramj = (ActionMenuView)this.mo;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramj);
    if (this.pY == null) {
      this.pY = new b();
    }
    parama.setPopupCallback(this.pY);
    AppMethodBeat.o(200349);
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    this.mo = paramActionMenuView;
    paramActionMenuView.jo = this.jo;
  }
  
  public final boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(200374);
    if (paramViewGroup.getChildAt(paramInt) == this.pG)
    {
      AppMethodBeat.o(200374);
      return false;
    }
    boolean bool = super.a(paramViewGroup, paramInt);
    AppMethodBeat.o(200374);
    return bool;
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(200386);
    if (!paramu.hasVisibleItems())
    {
      AppMethodBeat.o(200386);
      return false;
    }
    for (Object localObject = paramu; ((u)localObject).oA != this.jo; localObject = (u)((u)localObject).oA) {}
    MenuItem localMenuItem = ((u)localObject).getItem();
    ViewGroup localViewGroup = (ViewGroup)this.mo;
    if (localViewGroup != null)
    {
      j = localViewGroup.getChildCount();
      i = 0;
      if (i < j)
      {
        localObject = localViewGroup.getChildAt(i);
        if ((!(localObject instanceof p.a)) || (((p.a)localObject).getItemData() != localMenuItem)) {}
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label140;
      }
      AppMethodBeat.o(200386);
      return false;
      i += 1;
      break;
      localObject = null;
    }
    label140:
    this.qa = paramu.getItem().getItemId();
    int j = paramu.size();
    int i = 0;
    if (i < j)
    {
      localMenuItem = paramu.getItem(i);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.pW = new a(this.mContext, paramu, (View)localObject);
      this.pW.setForceShowIcon(bool);
      if (!this.pW.du())
      {
        paramu = new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        AppMethodBeat.o(200386);
        throw paramu;
        i += 1;
        break;
      }
      super.a(paramu);
      AppMethodBeat.o(200386);
      return true;
    }
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(200357);
    boolean bool = paramj.dj();
    AppMethodBeat.o(200357);
    return bool;
  }
  
  public final boolean cL()
  {
    AppMethodBeat.i(200442);
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
    label66:
    Object localObject1;
    if (this.jo != null)
    {
      localArrayList = this.jo.db();
      i1 = localArrayList.size();
      i = this.pN;
      i4 = this.pM;
      i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.mo;
      k = 0;
      m = 0;
      n = 0;
      j = 0;
      if (j >= i1) {
        break label151;
      }
      localObject1 = (j)localArrayList.get(j);
      if (!((j)localObject1).dl()) {
        break label128;
      }
      k += 1;
      label95:
      if ((!this.pR) || (!((j)localObject1).isActionViewExpanded())) {
        break label768;
      }
      i = 0;
    }
    label768:
    for (;;)
    {
      j += 1;
      break label66;
      i1 = 0;
      localArrayList = null;
      break;
      label128:
      if (((j)localObject1).dk())
      {
        m += 1;
        break label95;
      }
      n = 1;
      break label95;
      label151:
      j = i;
      if (this.pJ) {
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
      localObject1 = this.pT;
      ((SparseBooleanArray)localObject1).clear();
      i = 0;
      if (this.pP)
      {
        i = i4 / this.pS;
        k = this.pS;
        m = this.pS;
      }
      label548:
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
          if (localj.dl())
          {
            localObject2 = a(localj, this.pU, localViewGroup);
            if (this.pU == null) {
              this.pU = ((View)localObject2);
            }
            if (this.pP)
            {
              i -= ActionMenuView.a((View)localObject2, i2, i, i5, 0);
              label317:
              n = ((View)localObject2).getMeasuredWidth();
              if (k != 0) {
                break label759;
              }
              k = n;
            }
          }
        }
        label437:
        label607:
        label619:
        label624:
        label756:
        label759:
        for (;;)
        {
          i4 = localj.getGroupId();
          if (i4 != 0) {
            ((SparseBooleanArray)localObject1).put(i4, true);
          }
          localj.P(true);
          m -= n;
          i3 += 1;
          break;
          ((View)localObject2).measure(i5, i5);
          break label317;
          int i6;
          boolean bool;
          int i7;
          if (localj.dk())
          {
            i6 = localj.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i6);
            if (((j > 0) || (bool)) && (m > 0) && ((!this.pP) || (i > 0)))
            {
              i7 = 1;
              if (i7 == 0) {
                break label756;
              }
              localObject2 = a(localj, this.pU, localViewGroup);
              if (this.pU == null) {
                this.pU = ((View)localObject2);
              }
              if (!this.pP) {
                break label607;
              }
              i4 = ActionMenuView.a((View)localObject2, i2, i, i5, 0);
              n = i - i4;
              i = n;
              if (i4 == 0)
              {
                i7 = 0;
                i = n;
              }
              label509:
              i4 = ((View)localObject2).getMeasuredWidth();
              m -= i4;
              n = k;
              if (k == 0) {
                n = i4;
              }
              if (!this.pP) {
                break label624;
              }
              if (m < 0) {
                break label619;
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
              localj.P(i7);
              j = n;
              break;
              int i8 = 0;
              break label437;
              ((View)localObject2).measure(i5, i5);
              break label509;
              k = 0;
              break label548;
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
                      if (((j)localObject2).dj()) {
                        n = j + 1;
                      }
                      ((j)localObject2).P(false);
                    }
                    i4 += 1;
                    j = n;
                    continue;
                    localj.P(false);
                    break;
                    AppMethodBeat.o(200442);
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
  
  public final boolean dC()
  {
    AppMethodBeat.i(200427);
    if ((this.pV != null) && (this.pV.isShowing()))
    {
      AppMethodBeat.o(200427);
      return true;
    }
    AppMethodBeat.o(200427);
    return false;
  }
  
  public final boolean dE()
  {
    AppMethodBeat.i(200404);
    if ((this.pX != null) && (this.mo != null))
    {
      ((View)this.mo).removeCallbacks(this.pX);
      this.pX = null;
      AppMethodBeat.o(200404);
      return true;
    }
    e locale = this.pV;
    if (locale != null)
    {
      locale.dismiss();
      AppMethodBeat.o(200404);
      return true;
    }
    AppMethodBeat.o(200404);
    return false;
  }
  
  public final void dG()
  {
    AppMethodBeat.i(200321);
    if (!this.pO) {
      this.pN = androidx.appcompat.view.a.I(this.mContext).cr();
    }
    if (this.jo != null) {
      this.jo.L(true);
    }
    AppMethodBeat.o(200321);
  }
  
  public final void dH()
  {
    this.pJ = true;
    this.pK = true;
  }
  
  public final boolean dI()
  {
    AppMethodBeat.i(200414);
    boolean bool1 = dE();
    boolean bool2 = dJ();
    AppMethodBeat.o(200414);
    return bool1 | bool2;
  }
  
  public final boolean dJ()
  {
    AppMethodBeat.i(200421);
    if (this.pW != null)
    {
      this.pW.dismiss();
      AppMethodBeat.o(200421);
      return true;
    }
    AppMethodBeat.o(200421);
    return false;
  }
  
  public final boolean dv()
  {
    AppMethodBeat.i(200394);
    if ((this.pJ) && (!dC()) && (this.jo != null) && (this.mo != null) && (this.pX == null) && (!this.jo.dd().isEmpty()))
    {
      this.pX = new c(new e(this.mContext, this.jo, this.pG));
      ((View)this.mo).post(this.pX);
      super.a(null);
      AppMethodBeat.o(200394);
      return true;
    }
    AppMethodBeat.o(200394);
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(200465);
    if (!(paramParcelable instanceof SavedState))
    {
      AppMethodBeat.o(200465);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    if (paramParcelable.qg > 0)
    {
      paramParcelable = this.jo.findItem(paramParcelable.qg);
      if (paramParcelable != null) {
        a((u)paramParcelable.getSubMenu());
      }
    }
    AppMethodBeat.o(200465);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(200457);
    SavedState localSavedState = new SavedState();
    localSavedState.qg = this.qa;
    AppMethodBeat.o(200457);
    return localSavedState;
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    public int qg;
    
    static
    {
      AppMethodBeat.i(199495);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(199495);
    }
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(199475);
      this.qg = paramParcel.readInt();
      AppMethodBeat.o(199475);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(199515);
      paramParcel.writeInt(this.qg);
      AppMethodBeat.o(199515);
    }
  }
  
  final class a
    extends n
  {
    public a(Context paramContext, u paramu, View paramView)
    {
      super(paramu, paramView, false, a.a.actionOverflowMenuStyle);
      AppMethodBeat.i(200279);
      if (!((j)paramu.getItem()).dj()) {
        if (ActionMenuPresenter.this.pG != null) {
          break label69;
        }
      }
      label69:
      for (paramContext = (View)ActionMenuPresenter.c(ActionMenuPresenter.this);; paramContext = ActionMenuPresenter.this.pG)
      {
        this.mF = paramContext;
        c(ActionMenuPresenter.this.pZ);
        AppMethodBeat.o(200279);
        return;
      }
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(200285);
      ActionMenuPresenter.this.pW = null;
      ActionMenuPresenter.this.qa = 0;
      super.onDismiss();
      AppMethodBeat.o(200285);
    }
  }
  
  final class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public final s cJ()
    {
      AppMethodBeat.i(200286);
      if (ActionMenuPresenter.this.pW != null)
      {
        m localm = ActionMenuPresenter.this.pW.dt();
        AppMethodBeat.o(200286);
        return localm;
      }
      AppMethodBeat.o(200286);
      return null;
    }
  }
  
  final class c
    implements Runnable
  {
    private ActionMenuPresenter.e qc;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.qc = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(200284);
      if (ActionMenuPresenter.d(ActionMenuPresenter.this) != null)
      {
        localObject = ActionMenuPresenter.e(ActionMenuPresenter.this);
        if (((h)localObject).nz != null) {
          ((h)localObject).nz.a((h)localObject);
        }
      }
      Object localObject = (View)ActionMenuPresenter.f(ActionMenuPresenter.this);
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (this.qc.du())) {
        ActionMenuPresenter.this.pV = this.qc;
      }
      ActionMenuPresenter.this.pX = null;
      AppMethodBeat.o(200284);
    }
  }
  
  final class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    private final float[] qd;
    
    public d(Context paramContext)
    {
      super(null, a.a.actionOverflowButtonStyle);
      AppMethodBeat.i(200289);
      this.qd = new float[2];
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      ae.a(this, getContentDescription());
      setOnTouchListener(new r(this)
      {
        public final s cJ()
        {
          AppMethodBeat.i(199379);
          if (ActionMenuPresenter.this.pV == null)
          {
            AppMethodBeat.o(199379);
            return null;
          }
          m localm = ActionMenuPresenter.this.pV.dt();
          AppMethodBeat.o(199379);
          return localm;
        }
        
        public final boolean cK()
        {
          AppMethodBeat.i(199388);
          ActionMenuPresenter.this.dv();
          AppMethodBeat.o(199388);
          return true;
        }
        
        public final boolean dK()
        {
          AppMethodBeat.i(199396);
          if (ActionMenuPresenter.this.pX != null)
          {
            AppMethodBeat.o(199396);
            return false;
          }
          ActionMenuPresenter.this.dE();
          AppMethodBeat.o(199396);
          return true;
        }
      });
      AppMethodBeat.o(200289);
    }
    
    public final boolean cH()
    {
      return false;
    }
    
    public final boolean cI()
    {
      return false;
    }
    
    public final boolean performClick()
    {
      AppMethodBeat.i(200294);
      if (super.performClick())
      {
        AppMethodBeat.o(200294);
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.dv();
      AppMethodBeat.o(200294);
      return true;
    }
    
    protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(200322);
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
        androidx.core.graphics.drawable.a.a(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      AppMethodBeat.o(200322);
      return bool;
    }
  }
  
  final class e
    extends n
  {
    public e(Context paramContext, h paramh, View paramView)
    {
      super(paramh, paramView, true, a.a.actionOverflowMenuStyle);
      AppMethodBeat.i(200280);
      ds();
      c(ActionMenuPresenter.this.pZ);
      AppMethodBeat.o(200280);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(200290);
      if (ActionMenuPresenter.a(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.b(ActionMenuPresenter.this).close();
      }
      ActionMenuPresenter.this.pV = null;
      super.onDismiss();
      AppMethodBeat.o(200290);
    }
  }
  
  final class f
    implements o.a
  {
    f() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(200283);
      if ((paramh instanceof u)) {
        paramh.de().K(false);
      }
      o.a locala = ActionMenuPresenter.this.ml;
      if (locala != null) {
        locala.a(paramh, paramBoolean);
      }
      AppMethodBeat.o(200283);
    }
    
    public final boolean c(h paramh)
    {
      AppMethodBeat.i(200274);
      if (paramh == null)
      {
        AppMethodBeat.o(200274);
        return false;
      }
      ActionMenuPresenter.this.qa = ((u)paramh).getItem().getItemId();
      o.a locala = ActionMenuPresenter.this.ml;
      if (locala != null)
      {
        boolean bool = locala.c(paramh);
        AppMethodBeat.o(200274);
        return bool;
      }
      AppMethodBeat.o(200274);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */