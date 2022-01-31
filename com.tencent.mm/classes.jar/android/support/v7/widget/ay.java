package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.support.v4.view.u;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.j;
import android.support.v7.c.a.b;
import android.support.v7.view.menu.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.TextView;

public final class ay
  implements w
{
  CharSequence BM;
  private CharSequence BN;
  Window.Callback Qs;
  private ActionMenuPresenter WD;
  private int amK;
  private View amL;
  private Drawable amM;
  private Drawable amN;
  private boolean amO;
  private CharSequence amP;
  boolean amQ;
  private int amR = 0;
  private int amS = 0;
  private Drawable amT;
  Toolbar gV;
  private Drawable kc;
  private View la;
  
  public ay(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, a.h.abc_action_bar_up_description);
  }
  
  private ay(Toolbar paramToolbar, boolean paramBoolean, int paramInt)
  {
    this.gV = paramToolbar;
    this.BM = paramToolbar.getTitle();
    this.BN = paramToolbar.getSubtitle();
    boolean bool;
    int i;
    if (this.BM != null)
    {
      bool = true;
      this.amO = bool;
      this.amN = paramToolbar.getNavigationIcon();
      paramToolbar = ax.a(paramToolbar.getContext(), null, a.j.ActionBar, a.a.actionBarStyle, 0);
      this.amT = paramToolbar.getDrawable(a.j.ActionBar_homeAsUpIndicator);
      if (!paramBoolean) {
        break label609;
      }
      Object localObject = paramToolbar.getText(a.j.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.amO = true;
        l((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(a.j.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.BN = ((CharSequence)localObject);
        if ((this.amK & 0x8) != 0) {
          this.gV.setSubtitle((CharSequence)localObject);
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
      if ((this.amN == null) && (this.amT != null))
      {
        this.amN = this.amT;
        jc();
      }
      setDisplayOptions(paramToolbar.getInt(a.j.ActionBar_displayOptions, 0));
      i = paramToolbar.getResourceId(a.j.ActionBar_customNavigationLayout, 0);
      if (i != 0)
      {
        setCustomView(LayoutInflater.from(this.gV.getContext()).inflate(i, this.gV, false));
        setDisplayOptions(this.amK | 0x10);
      }
      i = paramToolbar.getLayoutDimension(a.j.ActionBar_height, 0);
      if (i > 0)
      {
        localObject = this.gV.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i;
        this.gV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int j = paramToolbar.getDimensionPixelOffset(a.j.ActionBar_contentInsetStart, -1);
      i = paramToolbar.getDimensionPixelOffset(a.j.ActionBar_contentInsetEnd, -1);
      if ((j >= 0) || (i >= 0))
      {
        localObject = this.gV;
        j = Math.max(j, 0);
        i = Math.max(i, 0);
        ((Toolbar)localObject).ja();
        ((Toolbar)localObject).amq.av(j, i);
      }
      i = paramToolbar.getResourceId(a.j.ActionBar_titleTextStyle, 0);
      Context localContext;
      if (i != 0)
      {
        localObject = this.gV;
        localContext = this.gV.getContext();
        ((Toolbar)localObject).ami = i;
        if (((Toolbar)localObject).ama != null) {
          ((Toolbar)localObject).ama.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.getResourceId(a.j.ActionBar_subtitleTextStyle, 0);
      if (i != 0)
      {
        localObject = this.gV;
        localContext = this.gV.getContext();
        ((Toolbar)localObject).amj = i;
        if (((Toolbar)localObject).amb != null) {
          ((Toolbar)localObject).amb.setTextAppearance(localContext, i);
        }
      }
      i = paramToolbar.getResourceId(a.j.ActionBar_popupTheme, 0);
      if (i != 0) {
        this.gV.setPopupTheme(i);
      }
    }
    for (;;)
    {
      paramToolbar.alZ.recycle();
      if (paramInt != this.amS)
      {
        this.amS = paramInt;
        if (TextUtils.isEmpty(this.gV.getNavigationContentDescription())) {
          setNavigationContentDescription(this.amS);
        }
      }
      this.amP = this.gV.getNavigationContentDescription();
      this.gV.setNavigationOnClickListener(new View.OnClickListener()
      {
        final a amU = new a(ay.this.gV.getContext(), ay.this.BM);
        
        public final void onClick(View paramAnonymousView)
        {
          if ((ay.this.Qs != null) && (ay.this.amQ)) {
            ay.this.Qs.onMenuItemSelected(0, this.amU);
          }
        }
      });
      return;
      bool = false;
      break;
      label609:
      i = 11;
      if (this.gV.getNavigationIcon() != null)
      {
        i = 15;
        this.amT = this.gV.getNavigationIcon();
      }
      this.amK = i;
    }
  }
  
  private void jb()
  {
    Drawable localDrawable = null;
    if ((this.amK & 0x2) != 0)
    {
      if ((this.amK & 0x1) == 0) {
        break label49;
      }
      if (this.amM == null) {
        break label41;
      }
      localDrawable = this.amM;
    }
    for (;;)
    {
      this.gV.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.kc;
      continue;
      label49:
      localDrawable = this.kc;
    }
  }
  
  private void jc()
  {
    if ((this.amK & 0x4) != 0)
    {
      Toolbar localToolbar = this.gV;
      if (this.amN != null) {}
      for (Drawable localDrawable = this.amN;; localDrawable = this.amT)
      {
        localToolbar.setNavigationIcon(localDrawable);
        return;
      }
    }
    this.gV.setNavigationIcon(null);
  }
  
  private void jd()
  {
    if ((this.amK & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.amP)) {
        this.gV.setNavigationContentDescription(this.amS);
      }
    }
    else {
      return;
    }
    this.gV.setNavigationContentDescription(this.amP);
  }
  
  private void l(CharSequence paramCharSequence)
  {
    this.BM = paramCharSequence;
    if ((this.amK & 0x8) != 0) {
      this.gV.setTitle(paramCharSequence);
    }
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    Toolbar localToolbar = this.gV;
    localToolbar.Yf = parama;
    localToolbar.Yg = parama1;
    if (localToolbar.WC != null) {
      localToolbar.WC.a(parama, parama1);
    }
  }
  
  public final void a(aq paramaq)
  {
    if ((this.amL != null) && (this.amL.getParent() == this.gV)) {
      this.gV.removeView(this.amL);
    }
    this.amL = paramaq;
    if ((paramaq != null) && (this.amR == 2))
    {
      this.gV.addView(this.amL, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.amL.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 8388691;
      paramaq.setAllowCollapse(true);
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    if (this.WD == null)
    {
      this.WD = new ActionMenuPresenter(this.gV.getContext());
      this.WD.mId = a.f.action_menu_presenter;
    }
    this.WD.dL = parama;
    parama = this.gV;
    paramMenu = (h)paramMenu;
    ActionMenuPresenter localActionMenuPresenter = this.WD;
    if ((paramMenu != null) || (parama.WC != null))
    {
      parama.iX();
      h localh = parama.WC.dm;
      if (localh != paramMenu)
      {
        if (localh != null)
        {
          localh.b(parama.amC);
          localh.b(parama.amD);
        }
        if (parama.amD == null) {
          parama.amD = new Toolbar.a(parama);
        }
        localActionMenuPresenter.XN = true;
        if (paramMenu == null) {
          break label185;
        }
        paramMenu.a(localActionMenuPresenter, parama.WB);
        paramMenu.a(parama.amD, parama.WB);
      }
    }
    for (;;)
    {
      parama.WC.setPopupTheme(parama.Yd);
      parama.WC.setPresenter(localActionMenuPresenter);
      parama.amC = localActionMenuPresenter;
      return;
      label185:
      localActionMenuPresenter.a(parama.WB, null);
      parama.amD.a(parama.WB, null);
      localActionMenuPresenter.o(true);
      parama.amD.o(true);
    }
  }
  
  public final u c(final int paramInt, long paramLong)
  {
    u localu = q.Y(this.gV);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F) {
      localu.s(f).k(paramLong).a(new android.support.v4.view.w()
      {
        private boolean pP = false;
        
        public final void au(View paramAnonymousView)
        {
          ay.this.gV.setVisibility(0);
        }
        
        public final void av(View paramAnonymousView)
        {
          if (!this.pP) {
            ay.this.gV.setVisibility(paramInt);
          }
        }
        
        public final void aw(View paramAnonymousView)
        {
          this.pP = true;
        }
      });
    }
  }
  
  public final void collapseActionView()
  {
    this.gV.collapseActionView();
  }
  
  public final void dismissPopupMenus()
  {
    Toolbar localToolbar = this.gV;
    if (localToolbar.WC != null) {
      localToolbar.WC.dismissPopupMenus();
    }
  }
  
  public final boolean fE()
  {
    Toolbar localToolbar = this.gV;
    return (localToolbar.getVisibility() == 0) && (localToolbar.WC != null) && (localToolbar.WC.XF);
  }
  
  public final boolean fF()
  {
    Object localObject = this.gV;
    if (((Toolbar)localObject).WC != null)
    {
      localObject = ((Toolbar)localObject).WC;
      if (((ActionMenuView)localObject).Ye != null)
      {
        localObject = ((ActionMenuView)localObject).Ye;
        if ((((ActionMenuPresenter)localObject).XT != null) || (((ActionMenuPresenter)localObject).isOverflowMenuShowing()))
        {
          i = 1;
          if (i == 0) {
            break label62;
          }
        }
      }
      label62:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label67;
        }
        return true;
        i = 0;
        break;
      }
    }
    label67:
    return false;
  }
  
  public final void fG()
  {
    this.amQ = true;
  }
  
  public final Context getContext()
  {
    return this.gV.getContext();
  }
  
  public final View getCustomView()
  {
    return this.la;
  }
  
  public final int getDisplayOptions()
  {
    return this.amK;
  }
  
  public final int getHeight()
  {
    return this.gV.getHeight();
  }
  
  public final Menu getMenu()
  {
    return this.gV.getMenu();
  }
  
  public final int getNavigationMode()
  {
    return this.amR;
  }
  
  public final CharSequence getTitle()
  {
    return this.gV.getTitle();
  }
  
  public final int getVisibility()
  {
    return this.gV.getVisibility();
  }
  
  public final ViewGroup gz()
  {
    return this.gV;
  }
  
  public final boolean hasExpandedActionView()
  {
    Toolbar localToolbar = this.gV;
    return (localToolbar.amD != null) && (localToolbar.amD.amG != null);
  }
  
  public final boolean hideOverflowMenu()
  {
    Object localObject = this.gV;
    if (((Toolbar)localObject).WC != null)
    {
      localObject = ((Toolbar)localObject).WC;
      if ((((ActionMenuView)localObject).Ye != null) && (((ActionMenuView)localObject).Ye.hideOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return this.gV.isOverflowMenuShowing();
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    q.a(this.gV, paramDrawable);
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    this.gV.setCollapsible(paramBoolean);
  }
  
  public final void setCustomView(View paramView)
  {
    if ((this.la != null) && ((this.amK & 0x10) != 0)) {
      this.gV.removeView(this.la);
    }
    this.la = paramView;
    if ((paramView != null) && ((this.amK & 0x10) != 0)) {
      this.gV.addView(this.la);
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    int i = this.amK ^ paramInt;
    this.amK = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          jd();
        }
        jc();
      }
      if ((i & 0x3) != 0) {
        jb();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label115;
        }
        this.gV.setTitle(this.BM);
        this.gV.setSubtitle(this.BN);
      }
    }
    for (;;)
    {
      if (((i & 0x10) != 0) && (this.la != null))
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        this.gV.addView(this.la);
      }
      return;
      label115:
      this.gV.setTitle(null);
      this.gV.setSubtitle(null);
    }
    this.gV.removeView(this.la);
  }
  
  public final void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = b.g(this.gV.getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    this.kc = paramDrawable;
    jb();
  }
  
  public final void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = b.g(this.gV.getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.amM = paramDrawable;
    jb();
  }
  
  public final void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = null;; str = this.gV.getContext().getString(paramInt))
    {
      this.amP = str;
      jd();
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    this.gV.setVisibility(paramInt);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    this.Qs = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.amO) {
      l(paramCharSequence);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    return this.gV.showOverflowMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ay
 * JD-Core Version:    0.7.0.1
 */