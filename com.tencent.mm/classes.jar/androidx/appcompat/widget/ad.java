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
import androidx.core.g.af;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
  implements n
{
  CharSequence cZ;
  private CharSequence da;
  private Drawable fM;
  Window.Callback is;
  private ActionMenuPresenter oF;
  private View oW;
  Toolbar yi;
  private int yj;
  private View yk;
  private Drawable yl;
  private Drawable ym;
  private boolean yn;
  private CharSequence yo;
  boolean yp;
  private int yq;
  private int yr;
  private Drawable ys;
  
  public ad(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, a.h.abc_action_bar_up_description);
  }
  
  private ad(Toolbar paramToolbar, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(199601);
    this.yq = 0;
    this.yr = 0;
    this.yi = paramToolbar;
    this.cZ = paramToolbar.getTitle();
    this.da = paramToolbar.getSubtitle();
    boolean bool;
    int i;
    if (this.cZ != null)
    {
      bool = true;
      this.yn = bool;
      this.ym = paramToolbar.getNavigationIcon();
      paramToolbar = ac.a(paramToolbar.getContext(), null, a.j.ActionBar, a.a.actionBarStyle, 0);
      this.ys = paramToolbar.getDrawable(a.j.ActionBar_homeAsUpIndicator);
      if (!paramBoolean) {
        break label631;
      }
      Object localObject = paramToolbar.getText(a.j.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.yn = true;
        i((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(a.j.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.da = ((CharSequence)localObject);
        if ((this.yj & 0x8) != 0) {
          this.yi.setSubtitle((CharSequence)localObject);
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
      if ((this.ym == null) && (this.ys != null))
      {
        this.ym = this.ys;
        fz();
      }
      M(paramToolbar.getInt(a.j.ActionBar_displayOptions, 0));
      i = paramToolbar.w(a.j.ActionBar_customNavigationLayout, 0);
      if (i != 0)
      {
        setCustomView(LayoutInflater.from(this.yi.getContext()).inflate(i, this.yi, false));
        M(this.yj | 0x10);
      }
      i = paramToolbar.v(a.j.ActionBar_height, 0);
      if (i > 0)
      {
        localObject = this.yi.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i;
        this.yi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int j = paramToolbar.t(a.j.ActionBar_contentInsetStart, -1);
      i = paramToolbar.t(a.j.ActionBar_contentInsetEnd, -1);
      if ((j >= 0) || (i >= 0))
      {
        localObject = this.yi;
        j = Math.max(j, 0);
        i = Math.max(i, 0);
        ((Toolbar)localObject).fx();
        ((Toolbar)localObject).xM.p(j, i);
      }
      i = paramToolbar.w(a.j.ActionBar_titleTextStyle, 0);
      Context localContext;
      if (i != 0)
      {
        localObject = this.yi;
        localContext = this.yi.getContext();
        ((Toolbar)localObject).xE = i;
        if (((Toolbar)localObject).xw != null) {
          ((Toolbar)localObject).xw.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.w(a.j.ActionBar_subtitleTextStyle, 0);
      if (i != 0)
      {
        localObject = this.yi;
        localContext = this.yi.getContext();
        ((Toolbar)localObject).xF = i;
        if (((Toolbar)localObject).xx != null) {
          ((Toolbar)localObject).xx.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.w(a.j.ActionBar_popupTheme, 0);
      if (i != 0) {
        this.yi.setPopupTheme(i);
      }
      label540:
      paramToolbar.xv.recycle();
      if (paramInt != this.yr)
      {
        this.yr = paramInt;
        if (TextUtils.isEmpty(this.yi.getNavigationContentDescription()))
        {
          paramInt = this.yr;
          if (paramInt != 0) {
            break label669;
          }
        }
      }
    }
    label669:
    for (paramToolbar = null;; paramToolbar = this.yi.getContext().getString(paramInt))
    {
      this.yo = paramToolbar;
      fA();
      this.yo = this.yi.getNavigationContentDescription();
      this.yi.setNavigationOnClickListener(new View.OnClickListener()
      {
        final androidx.appcompat.view.menu.a yt;
        
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199472);
          if ((ad.this.is != null) && (ad.this.yp)) {
            ad.this.is.onMenuItemSelected(0, this.yt);
          }
          AppMethodBeat.o(199472);
        }
      });
      AppMethodBeat.o(199601);
      return;
      bool = false;
      break;
      label631:
      i = 11;
      if (this.yi.getNavigationIcon() != null)
      {
        i = 15;
        this.ys = this.yi.getNavigationIcon();
      }
      this.yj = i;
      break label540;
    }
  }
  
  private void fA()
  {
    AppMethodBeat.i(199643);
    if ((this.yj & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.yo))
      {
        this.yi.setNavigationContentDescription(this.yr);
        AppMethodBeat.o(199643);
        return;
      }
      this.yi.setNavigationContentDescription(this.yo);
    }
    AppMethodBeat.o(199643);
  }
  
  private void fy()
  {
    AppMethodBeat.i(199626);
    Drawable localDrawable = null;
    if ((this.yj & 0x2) != 0)
    {
      if ((this.yj & 0x1) == 0) {
        break label61;
      }
      if (this.yl == null) {
        break label53;
      }
      localDrawable = this.yl;
    }
    for (;;)
    {
      this.yi.setLogo(localDrawable);
      AppMethodBeat.o(199626);
      return;
      label53:
      localDrawable = this.fM;
      continue;
      label61:
      localDrawable = this.fM;
    }
  }
  
  private void fz()
  {
    AppMethodBeat.i(199633);
    if ((this.yj & 0x4) != 0)
    {
      Toolbar localToolbar = this.yi;
      if (this.ym != null) {}
      for (Drawable localDrawable = this.ym;; localDrawable = this.ys)
      {
        localToolbar.setNavigationIcon(localDrawable);
        AppMethodBeat.o(199633);
        return;
      }
    }
    this.yi.setNavigationIcon(null);
    AppMethodBeat.o(199633);
  }
  
  private void i(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199612);
    this.cZ = paramCharSequence;
    if ((this.yj & 0x8) != 0) {
      this.yi.setTitle(paramCharSequence);
    }
    AppMethodBeat.o(199612);
  }
  
  public final void M(int paramInt)
  {
    AppMethodBeat.i(199805);
    int i = this.yj ^ paramInt;
    this.yj = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          fA();
        }
        fz();
      }
      if ((i & 0x3) != 0) {
        fy();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label127;
        }
        this.yi.setTitle(this.cZ);
        this.yi.setSubtitle(this.da);
      }
      while (((i & 0x10) != 0) && (this.oW != null)) {
        if ((paramInt & 0x10) != 0)
        {
          this.yi.addView(this.oW);
          AppMethodBeat.o(199805);
          return;
          label127:
          this.yi.setTitle(null);
          this.yi.setSubtitle(null);
        }
        else
        {
          this.yi.removeView(this.oW);
        }
      }
    }
    AppMethodBeat.o(199805);
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    AppMethodBeat.i(199778);
    if (this.oF == null)
    {
      this.oF = new ActionMenuPresenter(this.yi.getContext());
      this.oF.mId = a.f.action_menu_presenter;
    }
    this.oF.ml = parama;
    this.yi.a((h)paramMenu, this.oF);
    AppMethodBeat.o(199778);
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    AppMethodBeat.i(199904);
    Toolbar localToolbar = this.yi;
    localToolbar.qj = parama;
    localToolbar.qk = parama1;
    if (localToolbar.oE != null) {
      localToolbar.oE.a(parama, parama1);
    }
    AppMethodBeat.o(199904);
  }
  
  public final void a(w paramw)
  {
    AppMethodBeat.i(199814);
    if ((this.yk != null) && (this.yk.getParent() == this.yi)) {
      this.yi.removeView(this.yk);
    }
    this.yk = paramw;
    if ((paramw != null) && (this.yq == 2))
    {
      this.yi.addView(this.yk, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.yk.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.fl = 8388691;
      paramw.setAllowCollapse(true);
    }
    AppMethodBeat.o(199814);
  }
  
  public final androidx.core.g.ad b(final int paramInt, long paramLong)
  {
    AppMethodBeat.i(199864);
    androidx.core.g.ad localad = z.ac(this.yi);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      localad = localad.ao(f).bu(paramLong).b(new af()
      {
        private boolean mCanceled = false;
        
        public final void e(View paramAnonymousView)
        {
          AppMethodBeat.i(199439);
          ad.this.yi.setVisibility(0);
          AppMethodBeat.o(199439);
        }
        
        public final void f(View paramAnonymousView)
        {
          AppMethodBeat.i(199448);
          if (!this.mCanceled) {
            ad.this.yi.setVisibility(paramInt);
          }
          AppMethodBeat.o(199448);
        }
        
        public final void k(View paramAnonymousView)
        {
          this.mCanceled = true;
        }
      });
      AppMethodBeat.o(199864);
      return localad;
    }
  }
  
  public final int bZ()
  {
    return this.yq;
  }
  
  public final int bu()
  {
    return this.yj;
  }
  
  public final boolean dB()
  {
    AppMethodBeat.i(199735);
    Toolbar localToolbar = this.yi;
    if ((localToolbar.getVisibility() == 0) && (localToolbar.oE != null) && (localToolbar.oE.pJ))
    {
      AppMethodBeat.o(199735);
      return true;
    }
    AppMethodBeat.o(199735);
    return false;
  }
  
  public final boolean dC()
  {
    AppMethodBeat.i(199738);
    boolean bool = this.yi.dC();
    AppMethodBeat.o(199738);
    return bool;
  }
  
  public final boolean dD()
  {
    AppMethodBeat.i(199749);
    Object localObject = this.yi;
    if (((Toolbar)localObject).oE != null)
    {
      localObject = ((Toolbar)localObject).oE;
      if (((ActionMenuView)localObject).qi != null)
      {
        localObject = ((ActionMenuView)localObject).qi;
        if ((((ActionMenuPresenter)localObject).pX != null) || (((ActionMenuPresenter)localObject).dC()))
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
        AppMethodBeat.o(199749);
        return true;
        i = 0;
        break;
      }
    }
    label79:
    AppMethodBeat.o(199749);
    return false;
  }
  
  public final boolean dE()
  {
    AppMethodBeat.i(199762);
    Object localObject = this.yi;
    if (((Toolbar)localObject).oE != null)
    {
      localObject = ((Toolbar)localObject).oE;
      if ((((ActionMenuView)localObject).qi != null) && (((ActionMenuView)localObject).qi.dE())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(199762);
        return true;
      }
    }
    AppMethodBeat.o(199762);
    return false;
  }
  
  public final void dF()
  {
    this.yp = true;
  }
  
  public final void dN()
  {
    AppMethodBeat.i(199785);
    Toolbar localToolbar = this.yi;
    if (localToolbar.oE != null) {
      localToolbar.oE.dN();
    }
    AppMethodBeat.o(199785);
  }
  
  public final boolean dv()
  {
    AppMethodBeat.i(199754);
    boolean bool = this.yi.dv();
    AppMethodBeat.o(199754);
    return bool;
  }
  
  public final ViewGroup eD()
  {
    return this.yi;
  }
  
  public final boolean eE()
  {
    Toolbar localToolbar = this.yi;
    return (localToolbar.ya != null) && (localToolbar.ya.ye != null);
  }
  
  public final void eF()
  {
    AppMethodBeat.i(199676);
    this.yi.eF();
    AppMethodBeat.o(199676);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(369508);
    Context localContext = this.yi.getContext();
    AppMethodBeat.o(369508);
    return localContext;
  }
  
  public final View getCustomView()
  {
    return this.oW;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(199881);
    int i = this.yi.getHeight();
    AppMethodBeat.o(199881);
    return i;
  }
  
  public final Menu getMenu()
  {
    AppMethodBeat.i(199912);
    Menu localMenu = this.yi.getMenu();
    AppMethodBeat.o(199912);
    return localMenu;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(199703);
    CharSequence localCharSequence = this.yi.getTitle();
    AppMethodBeat.o(199703);
    return localCharSequence;
  }
  
  public final int getVisibility()
  {
    AppMethodBeat.i(199897);
    int i = this.yi.getVisibility();
    AppMethodBeat.o(199897);
    return i;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199875);
    z.a(this.yi, paramDrawable);
    AppMethodBeat.o(199875);
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    AppMethodBeat.i(199824);
    this.yi.setCollapsible(paramBoolean);
    AppMethodBeat.o(199824);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(199842);
    if ((this.oW != null) && ((this.yj & 0x10) != 0)) {
      this.yi.removeView(this.oW);
    }
    this.oW = paramView;
    if ((paramView != null) && ((this.yj & 0x10) != 0)) {
      this.yi.addView(this.oW);
    }
    AppMethodBeat.o(199842);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(199711);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.appcompat.a.a.a.m(this.yi.getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      AppMethodBeat.o(199711);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(199716);
    this.fM = paramDrawable;
    fy();
    AppMethodBeat.o(199716);
  }
  
  public final void setLogo(int paramInt)
  {
    AppMethodBeat.i(199724);
    if (paramInt != 0) {}
    for (Drawable localDrawable = androidx.appcompat.a.a.a.m(this.yi.getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      AppMethodBeat.o(199724);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(199729);
    this.yl = paramDrawable;
    fy();
    AppMethodBeat.o(199729);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(199888);
    this.yi.setVisibility(paramInt);
    AppMethodBeat.o(199888);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    this.is = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199695);
    if (!this.yn) {
      i(paramCharSequence);
    }
    AppMethodBeat.o(199695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ad
 * JD-Core Version:    0.7.0.1
 */