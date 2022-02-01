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
  d oJ;
  Drawable oK;
  boolean oL;
  private boolean oM;
  private boolean oN;
  private int oO;
  private int oP;
  private int oQ;
  private boolean oR;
  private boolean oS;
  private boolean oT;
  boolean oU;
  private int oV;
  private final SparseBooleanArray oW;
  private View oX;
  e oY;
  a oZ;
  c pa;
  private b pb;
  final f pc;
  int pd;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
    AppMethodBeat.i(240353);
    this.oW = new SparseBooleanArray();
    this.pc = new f();
    AppMethodBeat.o(240353);
  }
  
  public final void F(boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(240377);
    super.F(paramBoolean);
    ((View)this.ls).requestLayout();
    Object localObject;
    int i;
    if (this.is != null)
    {
      localObject = this.is;
      ((h)localObject).cj();
      localObject = ((h)localObject).mD;
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        androidx.core.g.b localb = ((j)((ArrayList)localObject).get(i)).nf;
        if (localb != null) {
          localb.MD = this;
        }
        i += 1;
      }
    }
    if (this.is != null)
    {
      localObject = this.is.ck();
      i = k;
      if (this.oM)
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
      if (this.oJ == null) {
        this.oJ = new d(this.ln);
      }
      localObject = (ViewGroup)this.oJ.getParent();
      if (localObject != this.ls)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.oJ);
        }
        ((ActionMenuView)this.ls).addView(this.oJ, ActionMenuView.cT());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.ls).setOverflowReserved(this.oM);
      AppMethodBeat.o(240377);
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
      if ((this.oJ != null) && (this.oJ.getParent() == this.ls)) {
        ((ViewGroup)this.ls).removeView(this.oJ);
      }
    }
  }
  
  public final void N(boolean paramBoolean)
  {
    AppMethodBeat.i(240399);
    if (paramBoolean)
    {
      super.a(null);
      AppMethodBeat.o(240399);
      return;
    }
    if (this.is != null) {
      this.is.G(false);
    }
    AppMethodBeat.o(240399);
  }
  
  public final View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(240370);
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.cu())) {
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
      AppMethodBeat.o(240370);
      return localView;
    }
  }
  
  public final p a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(240367);
    p localp = this.ls;
    paramViewGroup = super.a(paramViewGroup);
    if (localp != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    AppMethodBeat.o(240367);
    return paramViewGroup;
  }
  
  public final void a(Context paramContext, h paramh)
  {
    boolean bool = true;
    AppMethodBeat.i(240357);
    super.a(paramContext, paramh);
    paramh = paramContext.getResources();
    paramContext = androidx.appcompat.view.a.I(paramContext);
    int i;
    if (!this.oN)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        this.oM = bool;
      }
    }
    else
    {
      if (!this.oT) {
        this.oO = (paramContext.mContext.getResources().getDisplayMetrics().widthPixels / 2);
      }
      if (!this.oR) {
        this.oQ = paramContext.by();
      }
      i = this.oO;
      if (!this.oM) {
        break label228;
      }
      if (this.oJ == null)
      {
        this.oJ = new d(this.ln);
        if (this.oL)
        {
          this.oJ.setImageDrawable(this.oK);
          this.oK = null;
          this.oL = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.oJ.measure(j, j);
      }
      i -= this.oJ.getMeasuredWidth();
    }
    for (;;)
    {
      this.oP = i;
      this.oV = ((int)(56.0F * paramh.getDisplayMetrics().density));
      this.oX = null;
      AppMethodBeat.o(240357);
      return;
      if (!ViewConfiguration.get(paramContext.mContext).hasPermanentMenuKey()) {
        break;
      }
      bool = false;
      break;
      label228:
      this.oJ = null;
    }
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(240395);
    cP();
    super.a(paramh, paramBoolean);
    AppMethodBeat.o(240395);
  }
  
  public final void a(j paramj, p.a parama)
  {
    AppMethodBeat.i(240372);
    parama.a(paramj);
    paramj = (ActionMenuView)this.ls;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramj);
    if (this.pb == null) {
      this.pb = new b();
    }
    parama.setPopupCallback(this.pb);
    AppMethodBeat.o(240372);
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    this.ls = paramActionMenuView;
    paramActionMenuView.is = this.is;
  }
  
  public final boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(240379);
    if (paramViewGroup.getChildAt(paramInt) == this.oJ)
    {
      AppMethodBeat.o(240379);
      return false;
    }
    boolean bool = super.a(paramViewGroup, paramInt);
    AppMethodBeat.o(240379);
    return bool;
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(240381);
    if (!paramu.hasVisibleItems())
    {
      AppMethodBeat.o(240381);
      return false;
    }
    for (Object localObject = paramu; ((u)localObject).nB != this.is; localObject = (u)((u)localObject).nB) {}
    MenuItem localMenuItem = ((u)localObject).getItem();
    ViewGroup localViewGroup = (ViewGroup)this.ls;
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
      AppMethodBeat.o(240381);
      return false;
      i += 1;
      break;
      localObject = null;
    }
    label140:
    this.pd = paramu.getItem().getItemId();
    int j = paramu.size();
    int i = 0;
    if (i < j)
    {
      localMenuItem = paramu.getItem(i);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.oZ = new a(this.mContext, paramu, (View)localObject);
      this.oZ.setForceShowIcon(bool);
      if (!this.oZ.cB())
      {
        paramu = new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        AppMethodBeat.o(240381);
        throw paramu;
        i += 1;
        break;
      }
      super.a(paramu);
      AppMethodBeat.o(240381);
      return true;
    }
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(240374);
    boolean bool = paramj.cq();
    AppMethodBeat.o(240374);
    return bool;
  }
  
  public final boolean bS()
  {
    AppMethodBeat.i(240394);
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
    if (this.is != null)
    {
      localArrayList = this.is.ci();
      i1 = localArrayList.size();
      i = this.oQ;
      i4 = this.oP;
      i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.ls;
      k = 0;
      m = 0;
      n = 0;
      j = 0;
      if (j >= i1) {
        break label151;
      }
      localObject1 = (j)localArrayList.get(j);
      if (!((j)localObject1).cs()) {
        break label128;
      }
      k += 1;
      label95:
      if ((!this.oU) || (!((j)localObject1).isActionViewExpanded())) {
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
      if (((j)localObject1).cr())
      {
        m += 1;
        break label95;
      }
      n = 1;
      break label95;
      label151:
      j = i;
      if (this.oM) {
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
      localObject1 = this.oW;
      ((SparseBooleanArray)localObject1).clear();
      i = 0;
      if (this.oS)
      {
        i = i4 / this.oV;
        k = this.oV;
        m = this.oV;
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
          if (localj.cs())
          {
            localObject2 = a(localj, this.oX, localViewGroup);
            if (this.oX == null) {
              this.oX = ((View)localObject2);
            }
            if (this.oS)
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
          localj.L(true);
          m -= n;
          i3 += 1;
          break;
          ((View)localObject2).measure(i5, i5);
          break label317;
          int i6;
          boolean bool;
          int i7;
          if (localj.cr())
          {
            i6 = localj.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i6);
            if (((j > 0) || (bool)) && (m > 0) && ((!this.oS) || (i > 0)))
            {
              i7 = 1;
              if (i7 == 0) {
                break label756;
              }
              localObject2 = a(localj, this.oX, localViewGroup);
              if (this.oX == null) {
                this.oX = ((View)localObject2);
              }
              if (!this.oS) {
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
              if (!this.oS) {
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
              localj.L(i7);
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
                      if (((j)localObject2).cq()) {
                        n = j + 1;
                      }
                      ((j)localObject2).L(false);
                    }
                    i4 += 1;
                    j = n;
                    continue;
                    localj.L(false);
                    break;
                    AppMethodBeat.o(240394);
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
  
  public final boolean cC()
  {
    AppMethodBeat.i(240384);
    if ((this.oM) && (!cJ()) && (this.is != null) && (this.ls != null) && (this.pa == null) && (!this.is.ck().isEmpty()))
    {
      this.pa = new c(new e(this.mContext, this.is, this.oJ));
      ((View)this.ls).post(this.pa);
      super.a(null);
      AppMethodBeat.o(240384);
      return true;
    }
    AppMethodBeat.o(240384);
    return false;
  }
  
  public final boolean cJ()
  {
    AppMethodBeat.i(240391);
    if ((this.oY != null) && (this.oY.isShowing()))
    {
      AppMethodBeat.o(240391);
      return true;
    }
    AppMethodBeat.o(240391);
    return false;
  }
  
  public final boolean cL()
  {
    AppMethodBeat.i(240386);
    if ((this.pa != null) && (this.ls != null))
    {
      ((View)this.ls).removeCallbacks(this.pa);
      this.pa = null;
      AppMethodBeat.o(240386);
      return true;
    }
    e locale = this.oY;
    if (locale != null)
    {
      locale.dismiss();
      AppMethodBeat.o(240386);
      return true;
    }
    AppMethodBeat.o(240386);
    return false;
  }
  
  public final void cN()
  {
    AppMethodBeat.i(240360);
    if (!this.oR) {
      this.oQ = androidx.appcompat.view.a.I(this.mContext).by();
    }
    if (this.is != null) {
      this.is.H(true);
    }
    AppMethodBeat.o(240360);
  }
  
  public final void cO()
  {
    this.oM = true;
    this.oN = true;
  }
  
  public final boolean cP()
  {
    AppMethodBeat.i(240387);
    boolean bool1 = cL();
    boolean bool2 = cQ();
    AppMethodBeat.o(240387);
    return bool1 | bool2;
  }
  
  public final boolean cQ()
  {
    AppMethodBeat.i(240389);
    if (this.oZ != null)
    {
      this.oZ.dismiss();
      AppMethodBeat.o(240389);
      return true;
    }
    AppMethodBeat.o(240389);
    return false;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(240398);
    if (!(paramParcelable instanceof SavedState))
    {
      AppMethodBeat.o(240398);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    if (paramParcelable.pk > 0)
    {
      paramParcelable = this.is.findItem(paramParcelable.pk);
      if (paramParcelable != null) {
        a((u)paramParcelable.getSubMenu());
      }
    }
    AppMethodBeat.o(240398);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(240397);
    SavedState localSavedState = new SavedState();
    localSavedState.pk = this.pd;
    AppMethodBeat.o(240397);
    return localSavedState;
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    public int pk;
    
    static
    {
      AppMethodBeat.i(240342);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(240342);
    }
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(240336);
      this.pk = paramParcel.readInt();
      AppMethodBeat.o(240336);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(240341);
      paramParcel.writeInt(this.pk);
      AppMethodBeat.o(240341);
    }
  }
  
  final class a
    extends n
  {
    public a(Context paramContext, u paramu, View paramView)
    {
      super(paramu, paramView, false, a.a.actionOverflowMenuStyle);
      AppMethodBeat.i(240288);
      if (!((j)paramu.getItem()).cq()) {
        if (ActionMenuPresenter.this.oJ != null) {
          break label69;
        }
      }
      label69:
      for (paramContext = (View)ActionMenuPresenter.c(ActionMenuPresenter.this);; paramContext = ActionMenuPresenter.this.oJ)
      {
        this.lJ = paramContext;
        c(ActionMenuPresenter.this.pc);
        AppMethodBeat.o(240288);
        return;
      }
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(240289);
      ActionMenuPresenter.this.oZ = null;
      ActionMenuPresenter.this.pd = 0;
      super.onDismiss();
      AppMethodBeat.o(240289);
    }
  }
  
  final class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public final s bQ()
    {
      AppMethodBeat.i(240292);
      if (ActionMenuPresenter.this.oZ != null)
      {
        m localm = ActionMenuPresenter.this.oZ.cA();
        AppMethodBeat.o(240292);
        return localm;
      }
      AppMethodBeat.o(240292);
      return null;
    }
  }
  
  final class c
    implements Runnable
  {
    private ActionMenuPresenter.e pg;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.pg = parame;
    }
    
    public final void run()
    {
      AppMethodBeat.i(240295);
      if (ActionMenuPresenter.d(ActionMenuPresenter.this) != null)
      {
        localObject = ActionMenuPresenter.e(ActionMenuPresenter.this);
        if (((h)localObject).mA != null) {
          ((h)localObject).mA.a((h)localObject);
        }
      }
      Object localObject = (View)ActionMenuPresenter.f(ActionMenuPresenter.this);
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (this.pg.cB())) {
        ActionMenuPresenter.this.oY = this.pg;
      }
      ActionMenuPresenter.this.pa = null;
      AppMethodBeat.o(240295);
    }
  }
  
  final class d
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    private final float[] ph;
    
    public d(Context paramContext)
    {
      super(null, a.a.actionOverflowButtonStyle);
      AppMethodBeat.i(240303);
      this.ph = new float[2];
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      ae.a(this, getContentDescription());
      setOnTouchListener(new r(this)
      {
        public final s bQ()
        {
          AppMethodBeat.i(240298);
          if (ActionMenuPresenter.this.oY == null)
          {
            AppMethodBeat.o(240298);
            return null;
          }
          m localm = ActionMenuPresenter.this.oY.cA();
          AppMethodBeat.o(240298);
          return localm;
        }
        
        public final boolean bR()
        {
          AppMethodBeat.i(240300);
          ActionMenuPresenter.this.cC();
          AppMethodBeat.o(240300);
          return true;
        }
        
        public final boolean cR()
        {
          AppMethodBeat.i(240301);
          if (ActionMenuPresenter.this.pa != null)
          {
            AppMethodBeat.o(240301);
            return false;
          }
          ActionMenuPresenter.this.cL();
          AppMethodBeat.o(240301);
          return true;
        }
      });
      AppMethodBeat.o(240303);
    }
    
    public final boolean bO()
    {
      return false;
    }
    
    public final boolean bP()
    {
      return false;
    }
    
    public final boolean performClick()
    {
      AppMethodBeat.i(240304);
      if (super.performClick())
      {
        AppMethodBeat.o(240304);
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.cC();
      AppMethodBeat.o(240304);
      return true;
    }
    
    protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(240308);
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
      AppMethodBeat.o(240308);
      return bool;
    }
  }
  
  final class e
    extends n
  {
    public e(Context paramContext, h paramh, View paramView)
    {
      super(paramh, paramView, true, a.a.actionOverflowMenuStyle);
      AppMethodBeat.i(240313);
      cz();
      c(ActionMenuPresenter.this.pc);
      AppMethodBeat.o(240313);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(240316);
      if (ActionMenuPresenter.a(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.b(ActionMenuPresenter.this).close();
      }
      ActionMenuPresenter.this.oY = null;
      super.onDismiss();
      AppMethodBeat.o(240316);
    }
  }
  
  final class f
    implements o.a
  {
    f() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(240323);
      if ((paramh instanceof u)) {
        paramh.cl().G(false);
      }
      o.a locala = ActionMenuPresenter.this.lp;
      if (locala != null) {
        locala.a(paramh, paramBoolean);
      }
      AppMethodBeat.o(240323);
    }
    
    public final boolean c(h paramh)
    {
      AppMethodBeat.i(240321);
      if (paramh == null)
      {
        AppMethodBeat.o(240321);
        return false;
      }
      ActionMenuPresenter.this.pd = ((u)paramh).getItem().getItemId();
      o.a locala = ActionMenuPresenter.this.lp;
      if (locala != null)
      {
        boolean bool = locala.c(paramh);
        AppMethodBeat.o(240321);
        return bool;
      }
      AppMethodBeat.o(240321);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */