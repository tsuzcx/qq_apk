package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.TextView;
import androidx.appcompat.a.a;
import androidx.appcompat.a.f;
import androidx.appcompat.a.h;
import androidx.appcompat.a.j;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.o.a;
import androidx.core.g.aa;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
  implements n
{
  CharSequence cZ;
  private CharSequence da;
  private Drawable eK;
  Window.Callback hv;
  private ActionMenuPresenter nG;
  private View nX;
  Toolbar xn;
  private int xo;
  private View xp;
  private Drawable xq;
  private Drawable xr;
  private boolean xs;
  private CharSequence xt;
  boolean xu;
  private int xv;
  private int xw;
  private Drawable xx;
  
  public ad(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, a.h.abc_action_bar_up_description);
  }
  
  private ad(Toolbar paramToolbar, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(242358);
    this.xv = 0;
    this.xw = 0;
    this.xn = paramToolbar;
    this.cZ = paramToolbar.getTitle();
    this.da = paramToolbar.getSubtitle();
    boolean bool;
    int i;
    if (this.cZ != null)
    {
      bool = true;
      this.xs = bool;
      this.xr = paramToolbar.getNavigationIcon();
      paramToolbar = ac.a(paramToolbar.getContext(), null, a.j.ActionBar, a.a.actionBarStyle, 0);
      this.xx = paramToolbar.getDrawable(a.j.ActionBar_homeAsUpIndicator);
      if (!paramBoolean) {
        break label631;
      }
      Object localObject = paramToolbar.getText(a.j.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.xs = true;
        i((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(a.j.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.da = ((CharSequence)localObject);
        if ((this.xo & 0x8) != 0) {
          this.xn.setSubtitle((CharSequence)localObject);
        }
      }
      localObject = paramToolbar.getDrawable(a.j.ActionBar_logo);
      if (localObject != null) {
        setLogo((Drawable)localObject);
      }
      localObject = paramToolbar.getDrawable(a.j.ActionBar_icon);
      if (localObject != null) {
        setIcon((Drawable)localObject);
      }
      if ((this.xr == null) && (this.xx != null))
      {
        this.xr = this.xx;
        eC();
      }
      O(paramToolbar.getInt(a.j.ActionBar_displayOptions, 0));
      i = paramToolbar.r(a.j.ActionBar_customNavigationLayout, 0);
      if (i != 0)
      {
        setCustomView(LayoutInflater.from(this.xn.getContext()).inflate(i, this.xn, false));
        O(this.xo | 0x10);
      }
      i = paramToolbar.q(a.j.ActionBar_height, 0);
      if (i > 0)
      {
        localObject = this.xn.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i;
        this.xn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int j = paramToolbar.o(a.j.ActionBar_contentInsetStart, -1);
      i = paramToolbar.o(a.j.ActionBar_contentInsetEnd, -1);
      if ((j >= 0) || (i >= 0))
      {
        localObject = this.xn;
        j = Math.max(j, 0);
        i = Math.max(i, 0);
        ((Toolbar)localObject).eA();
        ((Toolbar)localObject).wR.k(j, i);
      }
      i = paramToolbar.r(a.j.ActionBar_titleTextStyle, 0);
      Context localContext;
      if (i != 0)
      {
        localObject = this.xn;
        localContext = this.xn.getContext();
        ((Toolbar)localObject).wJ = i;
        if (((Toolbar)localObject).wB != null) {
          ((Toolbar)localObject).wB.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.r(a.j.ActionBar_subtitleTextStyle, 0);
      if (i != 0)
      {
        localObject = this.xn;
        localContext = this.xn.getContext();
        ((Toolbar)localObject).wK = i;
        if (((Toolbar)localObject).wC != null) {
          ((Toolbar)localObject).wC.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.r(a.j.ActionBar_popupTheme, 0);
      if (i != 0) {
        this.xn.setPopupTheme(i);
      }
      label540:
      paramToolbar.wA.recycle();
      if (paramInt != this.xw)
      {
        this.xw = paramInt;
        if (TextUtils.isEmpty(this.xn.getNavigationContentDescription()))
        {
          paramInt = this.xw;
          if (paramInt != 0) {
            break label669;
          }
        }
      }
    }
    label669:
    for (paramToolbar = null;; paramToolbar = this.xn.getContext().getString(paramInt))
    {
      this.xt = paramToolbar;
      eD();
      this.xt = this.xn.getNavigationContentDescription();
      this.xn.setNavigationOnClickListener(new View.OnClickListener()
      {
        final androidx.appcompat.view.menu.a xy;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(242261);
          if ((ad.this.hv != null) && (ad.this.xu)) {
            ad.this.hv.onMenuItemSelected(0, this.xy);
          }
          AppMethodBeat.o(242261);
        }
      });
      AppMethodBeat.o(242358);
      return;
      bool = false;
      break;
      label631:
      i = 11;
      if (this.xn.getNavigationIcon() != null)
      {
        i = 15;
        this.xx = this.xn.getNavigationIcon();
      }
      this.xo = i;
      break label540;
    }
  }
  
  private void eB()
  {
    AppMethodBeat.i(242380);
    Drawable localDrawable = null;
    if ((this.xo & 0x2) != 0)
    {
      if ((this.xo & 0x1) == 0) {
        break label61;
      }
      if (this.xq == null) {
        break label53;
      }
      localDrawable = this.xq;
    }
    for (;;)
    {
      this.xn.setLogo(localDrawable);
      AppMethodBeat.o(242380);
      return;
      label53:
      localDrawable = this.eK;
      continue;
      label61:
      localDrawable = this.eK;
    }
  }
  
  private void eC()
  {
    AppMethodBeat.i(242409);
    if ((this.xo & 0x4) != 0)
    {
      Toolbar localToolbar = this.xn;
      if (this.xr != null) {}
      for (Drawable localDrawable = this.xr;; localDrawable = this.xx)
      {
        localToolbar.setNavigationIcon(localDrawable);
        AppMethodBeat.o(242409);
        return;
      }
    }
    this.xn.setNavigationIcon(null);
    AppMethodBeat.o(242409);
  }
  
  private void eD()
  {
    AppMethodBeat.i(242412);
    if ((this.xo & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.xt))
      {
        this.xn.setNavigationContentDescription(this.xw);
        AppMethodBeat.o(242412);
        return;
      }
      this.xn.setNavigationContentDescription(this.xt);
    }
    AppMethodBeat.o(242412);
  }
  
  private void i(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242369);
    this.cZ = paramCharSequence;
    if ((this.xo & 0x8) != 0) {
      this.xn.setTitle(paramCharSequence);
    }
    AppMethodBeat.o(242369);
  }
  
  public final void O(int paramInt)
  {
    AppMethodBeat.i(242396);
    int i = this.xo ^ paramInt;
    this.xo = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          eD();
        }
        eC();
      }
      if ((i & 0x3) != 0) {
        eB();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label127;
        }
        this.xn.setTitle(this.cZ);
        this.xn.setSubtitle(this.da);
      }
      while (((i & 0x10) != 0) && (this.nX != null)) {
        if ((paramInt & 0x10) != 0)
        {
          this.xn.addView(this.nX);
          AppMethodBeat.o(242396);
          return;
          label127:
          this.xn.setTitle(null);
          this.xn.setSubtitle(null);
        }
        else
        {
          this.xn.removeView(this.nX);
        }
      }
    }
    AppMethodBeat.o(242396);
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    AppMethodBeat.i(242391);
    if (this.nG == null)
    {
      this.nG = new ActionMenuPresenter(this.xn.getContext());
      this.nG.mId = a.f.action_menu_presenter;
    }
    this.nG.lp = parama;
    this.xn.a((h)paramMenu, this.nG);
    AppMethodBeat.o(242391);
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    AppMethodBeat.i(242424);
    Toolbar localToolbar = this.xn;
    localToolbar.pn = parama;
    localToolbar.po = parama1;
    if (localToolbar.nF != null) {
      localToolbar.nF.a(parama, parama1);
    }
    AppMethodBeat.o(242424);
  }
  
  public final void a(w paramw)
  {
    AppMethodBeat.i(242398);
    if ((this.xp != null) && (this.xp.getParent() == this.xn)) {
      this.xn.removeView(this.xp);
    }
    this.xp = paramw;
    if ((paramw != null) && (this.xv == 2))
    {
      this.xn.addView(this.xp, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.xp.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.ek = 8388691;
      paramw.setAllowCollapse(true);
    }
    AppMethodBeat.o(242398);
  }
  
  public final int aC()
  {
    return this.xo;
  }
  
  public final aa b(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(242406);
    aa localaa = androidx.core.g.w.Q(this.xn);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      localaa = localaa.i(f).f(paramLong).b(new androidx.core.g.ac()
      {
        private boolean mCanceled = false;
        
        public final void e(View paramAnonymousView)
        {
          AppMethodBeat.i(242276);
          ad.this.xn.setVisibility(0);
          AppMethodBeat.o(242276);
        }
        
        public final void f(View paramAnonymousView)
        {
          AppMethodBeat.i(242279);
          if (!this.mCanceled) {
            ad.this.xn.setVisibility(paramInt);
          }
          AppMethodBeat.o(242279);
        }
        
        public final void k(View paramAnonymousView)
        {
          this.mCanceled = true;
        }
      });
      AppMethodBeat.o(242406);
      return localaa;
    }
  }
  
  public final int bg()
  {
    return this.xv;
  }
  
  public final boolean cC()
  {
    AppMethodBeat.i(242387);
    boolean bool = this.xn.cC();
    AppMethodBeat.o(242387);
    return bool;
  }
  
  public final boolean cI()
  {
    AppMethodBeat.i(242381);
    Toolbar localToolbar = this.xn;
    if ((localToolbar.getVisibility() == 0) && (localToolbar.nF != null) && (localToolbar.nF.oM))
    {
      AppMethodBeat.o(242381);
      return true;
    }
    AppMethodBeat.o(242381);
    return false;
  }
  
  public final boolean cJ()
  {
    AppMethodBeat.i(242383);
    boolean bool = this.xn.cJ();
    AppMethodBeat.o(242383);
    return bool;
  }
  
  public final boolean cK()
  {
    AppMethodBeat.i(242385);
    Object localObject = this.xn;
    if (((Toolbar)localObject).nF != null)
    {
      localObject = ((Toolbar)localObject).nF;
      if (((ActionMenuView)localObject).pm != null)
      {
        localObject = ((ActionMenuView)localObject).pm;
        if ((((ActionMenuPresenter)localObject).pa != null) || (((ActionMenuPresenter)localObject).cJ()))
        {
          i = 1;
          if (i == 0) {
            break label74;
          }
        }
      }
      label74:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label79;
        }
        AppMethodBeat.o(242385);
        return true;
        i = 0;
        break;
      }
    }
    label79:
    AppMethodBeat.o(242385);
    return false;
  }
  
  public final boolean cL()
  {
    AppMethodBeat.i(242388);
    Object localObject = this.xn;
    if (((Toolbar)localObject).nF != null)
    {
      localObject = ((Toolbar)localObject).nF;
      if ((((ActionMenuView)localObject).pm != null) && (((ActionMenuView)localObject).pm.cL())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(242388);
        return true;
      }
    }
    AppMethodBeat.o(242388);
    return false;
  }
  
  public final void cM()
  {
    this.xu = true;
  }
  
  public final void cU()
  {
    AppMethodBeat.i(242393);
    Toolbar localToolbar = this.xn;
    if (localToolbar.nF != null) {
      localToolbar.nF.cU();
    }
    AppMethodBeat.o(242393);
  }
  
  public final ViewGroup dE()
  {
    return this.xn;
  }
  
  public final boolean dF()
  {
    Toolbar localToolbar = this.xn;
    return (localToolbar.xf != null) && (localToolbar.xf.xj != null);
  }
  
  public final void dG()
  {
    AppMethodBeat.i(242364);
    this.xn.dG();
    AppMethodBeat.o(242364);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(292991);
    Context localContext = this.xn.getContext();
    AppMethodBeat.o(292991);
    return localContext;
  }
  
  public final View getCustomView()
  {
    return this.nX;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(242417);
    int i = this.xn.getHeight();
    AppMethodBeat.o(242417);
    return i;
  }
  
  public final Menu getMenu()
  {
    AppMethodBeat.i(242427);
    Menu localMenu = this.xn.getMenu();
    AppMethodBeat.o(242427);
    return localMenu;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(242367);
    CharSequence localCharSequence = this.xn.getTitle();
    AppMethodBeat.o(242367);
    return localCharSequence;
  }
  
  public final int getVisibility()
  {
    AppMethodBeat.i(242421);
    int i = this.xn.getVisibility();
    AppMethodBeat.o(242421);
    return i;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(242414);
    androidx.core.g.w.a(this.xn, paramDrawable);
    AppMethodBeat.o(242414);
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    AppMethodBeat.i(242400);
    this.xn.setCollapsible(paramBoolean);
    AppMethodBeat.o(242400);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(242402);
    if ((this.nX != null) && ((this.xo & 0x10) != 0)) {
      this.xn.removeView(this.nX);
    }
    this.nX = paramView;
    if ((paramView != null) && ((this.xo & 0x10) != 0)) {
      this.xn.addView(this.nX);
    }
    AppMethodBeat.o(242402);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(242372);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.appcompat.a.a.a.m(this.xn.getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      AppMethodBeat.o(242372);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(242374);
    this.eK = paramDrawable;
    eB();
    AppMethodBeat.o(242374);
  }
  
  public final void setLogo(int paramInt)
  {
    AppMethodBeat.i(242376);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.appcompat.a.a.a.m(this.xn.getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      AppMethodBeat.o(242376);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(242378);
    this.xq = paramDrawable;
    eB();
    AppMethodBeat.o(242378);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(242420);
    this.xn.setVisibility(paramInt);
    AppMethodBeat.o(242420);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    this.hv = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242366);
    if (!this.xs) {
      i(paramCharSequence);
    }
    AppMethodBeat.o(242366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ad
 * JD-Core Version:    0.7.0.1
 */