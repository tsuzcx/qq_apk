package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.aa;
import android.support.v4.view.y;
import android.support.v7.a.a.a;
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

public final class ba
  implements u
{
  CharSequence Hn;
  private CharSequence Md;
  private Drawable Xw;
  Window.Callback ZW;
  private View ahJ;
  private ActionMenuPresenter aht;
  Toolbar azk;
  private int azl;
  private View azm;
  private Drawable azn;
  private Drawable azo;
  private boolean azp;
  private CharSequence azq;
  boolean azr;
  private int azs = 0;
  private int azt = 0;
  private Drawable azu;
  
  public ba(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, (byte)0);
  }
  
  private ba(Toolbar paramToolbar, boolean paramBoolean, byte paramByte)
  {
    this.azk = paramToolbar;
    this.Hn = paramToolbar.getTitle();
    this.Md = paramToolbar.getSubtitle();
    boolean bool;
    if (this.Hn != null)
    {
      bool = true;
      this.azp = bool;
      this.azo = paramToolbar.getNavigationIcon();
      paramToolbar = az.a(paramToolbar.getContext(), null, a.a.ActionBar, 2130968603, 0);
      this.azu = paramToolbar.getDrawable(15);
      if (!paramBoolean) {
        break label569;
      }
      Object localObject = paramToolbar.getText(27);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setTitle((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(25);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.Md = ((CharSequence)localObject);
        if ((this.azl & 0x8) != 0) {
          this.azk.setSubtitle((CharSequence)localObject);
        }
      }
      localObject = paramToolbar.getDrawable(20);
      if (localObject != null) {
        setLogo((Drawable)localObject);
      }
      localObject = paramToolbar.getDrawable(17);
      if (localObject != null) {
        setIcon((Drawable)localObject);
      }
      if ((this.azo == null) && (this.azu != null))
      {
        this.azo = this.azu;
        nf();
      }
      setDisplayOptions(paramToolbar.getInt(10, 0));
      paramByte = paramToolbar.getResourceId(9, 0);
      if (paramByte != 0)
      {
        setCustomView(LayoutInflater.from(this.azk.getContext()).inflate(paramByte, this.azk, false));
        setDisplayOptions(this.azl | 0x10);
      }
      paramByte = paramToolbar.getLayoutDimension(13, 0);
      if (paramByte > 0)
      {
        localObject = this.azk.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramByte;
        this.azk.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int i = paramToolbar.getDimensionPixelOffset(7, -1);
      paramByte = paramToolbar.getDimensionPixelOffset(3, -1);
      if ((i >= 0) || (paramByte >= 0))
      {
        localObject = this.azk;
        i = Math.max(i, 0);
        paramByte = Math.max(paramByte, 0);
        ((Toolbar)localObject).nd();
        ((Toolbar)localObject).ayP.aA(i, paramByte);
      }
      paramByte = paramToolbar.getResourceId(28, 0);
      Context localContext;
      if (paramByte != 0)
      {
        localObject = this.azk;
        localContext = this.azk.getContext();
        ((Toolbar)localObject).ayH = paramByte;
        if (((Toolbar)localObject).ayz != null) {
          ((Toolbar)localObject).ayz.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(26, 0);
      if (paramByte != 0)
      {
        localObject = this.azk;
        localContext = this.azk.getContext();
        ((Toolbar)localObject).ayI = paramByte;
        if (((Toolbar)localObject).ayA != null) {
          ((Toolbar)localObject).ayA.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(22, 0);
      if (paramByte != 0) {
        this.azk.setPopupTheme(paramByte);
      }
    }
    for (;;)
    {
      paramToolbar.ayy.recycle();
      if (2131755087 != this.azt)
      {
        this.azt = 2131755087;
        if (TextUtils.isEmpty(this.azk.getNavigationContentDescription())) {
          setNavigationContentDescription(this.azt);
        }
      }
      this.azq = this.azk.getNavigationContentDescription();
      this.azk.setNavigationOnClickListener(new View.OnClickListener()
      {
        final android.support.v7.view.menu.a azv = new android.support.v7.view.menu.a(ba.this.azk.getContext(), ba.this.Hn);
        
        public final void onClick(View paramAnonymousView)
        {
          if ((ba.this.ZW != null) && (ba.this.azr)) {
            ba.this.ZW.onMenuItemSelected(0, this.azv);
          }
        }
      });
      return;
      bool = false;
      break;
      label569:
      paramByte = 11;
      if (this.azk.getNavigationIcon() != null)
      {
        this.azu = this.azk.getNavigationIcon();
        paramByte = 15;
      }
      this.azl = paramByte;
    }
  }
  
  private void ne()
  {
    Drawable localDrawable = null;
    if ((this.azl & 0x2) != 0)
    {
      if ((this.azl & 0x1) == 0) {
        break label49;
      }
      if (this.azn == null) {
        break label41;
      }
      localDrawable = this.azn;
    }
    for (;;)
    {
      this.azk.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.Xw;
      continue;
      label49:
      localDrawable = this.Xw;
    }
  }
  
  private void nf()
  {
    if ((this.azl & 0x4) != 0)
    {
      Toolbar localToolbar = this.azk;
      if (this.azo != null) {}
      for (Drawable localDrawable = this.azo;; localDrawable = this.azu)
      {
        localToolbar.setNavigationIcon(localDrawable);
        return;
      }
    }
    this.azk.setNavigationIcon(null);
  }
  
  private void ng()
  {
    if ((this.azl & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.azq)) {
        this.azk.setNavigationContentDescription(this.azt);
      }
    }
    else {
      return;
    }
    this.azk.setNavigationContentDescription(this.azq);
  }
  
  private void r(CharSequence paramCharSequence)
  {
    this.Hn = paramCharSequence;
    if ((this.azl & 0x8) != 0) {
      this.azk.setTitle(paramCharSequence);
    }
  }
  
  private void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    this.azq = paramCharSequence;
    ng();
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    Toolbar localToolbar = this.azk;
    localToolbar.aiU = parama;
    localToolbar.aiV = parama1;
    if (localToolbar.ahs != null) {
      localToolbar.ahs.a(parama, parama1);
    }
  }
  
  public final void a(ar paramar)
  {
    if ((this.azm != null) && (this.azm.getParent() == this.azk)) {
      this.azk.removeView(this.azm);
    }
    this.azm = paramar;
    if ((paramar != null) && (this.azs == 2))
    {
      this.azk.addView(this.azm, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.azm.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 8388691;
      paramar.setAllowCollapse(true);
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    if (this.aht == null)
    {
      this.aht = new ActionMenuPresenter(this.azk.getContext());
      this.aht.mId = 2131296395;
    }
    this.aht.afg = parama;
    this.azk.a((h)paramMenu, this.aht);
  }
  
  public final y c(final int paramInt, long paramLong)
  {
    y localy = android.support.v4.view.u.ah(this.azk);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F) {
      localy.y(f).j(paramLong).a(new aa()
      {
        private boolean mCanceled = false;
        
        public final void aI(View paramAnonymousView)
        {
          ba.this.azk.setVisibility(0);
        }
        
        public final void aJ(View paramAnonymousView)
        {
          if (!this.mCanceled) {
            ba.this.azk.setVisibility(paramInt);
          }
        }
        
        public final void aK(View paramAnonymousView)
        {
          this.mCanceled = true;
        }
      });
    }
  }
  
  public final void collapseActionView()
  {
    this.azk.collapseActionView();
  }
  
  public final void dismissPopupMenus()
  {
    Toolbar localToolbar = this.azk;
    if (localToolbar.ahs != null) {
      localToolbar.ahs.dismissPopupMenus();
    }
  }
  
  public final Context getContext()
  {
    return this.azk.getContext();
  }
  
  public final View getCustomView()
  {
    return this.ahJ;
  }
  
  public final int getDisplayOptions()
  {
    return this.azl;
  }
  
  public final int getHeight()
  {
    return this.azk.getHeight();
  }
  
  public final Menu getMenu()
  {
    return this.azk.getMenu();
  }
  
  public final int getNavigationMode()
  {
    return this.azs;
  }
  
  public final CharSequence getTitle()
  {
    return this.azk.getTitle();
  }
  
  public final int getVisibility()
  {
    return this.azk.getVisibility();
  }
  
  public final boolean hasExpandedActionView()
  {
    Toolbar localToolbar = this.azk;
    return (localToolbar.azc != null) && (localToolbar.azc.azg != null);
  }
  
  public final boolean hideOverflowMenu()
  {
    Object localObject = this.azk;
    if (((Toolbar)localObject).ahs != null)
    {
      localObject = ((Toolbar)localObject).ahs;
      if ((((ActionMenuView)localObject).aiT != null) && (((ActionMenuView)localObject).aiT.hideOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean iB()
  {
    Toolbar localToolbar = this.azk;
    return (localToolbar.getVisibility() == 0) && (localToolbar.ahs != null) && (localToolbar.ahs.aiu);
  }
  
  public final boolean iC()
  {
    Object localObject = this.azk;
    if (((Toolbar)localObject).ahs != null)
    {
      localObject = ((Toolbar)localObject).ahs;
      if (((ActionMenuView)localObject).aiT != null)
      {
        localObject = ((ActionMenuView)localObject).aiT;
        if ((((ActionMenuPresenter)localObject).aiI != null) || (((ActionMenuPresenter)localObject).isOverflowMenuShowing()))
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
  
  public final void iD()
  {
    this.azr = true;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return this.azk.isOverflowMenuShowing();
  }
  
  public final ViewGroup jC()
  {
    return this.azk;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    android.support.v4.view.u.a(this.azk, paramDrawable);
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    this.azk.setCollapsible(paramBoolean);
  }
  
  public final void setCustomView(View paramView)
  {
    if ((this.ahJ != null) && ((this.azl & 0x10) != 0)) {
      this.azk.removeView(this.ahJ);
    }
    this.ahJ = paramView;
    if ((paramView != null) && ((this.azl & 0x10) != 0)) {
      this.azk.addView(this.ahJ);
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    int i = this.azl ^ paramInt;
    this.azl = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          ng();
        }
        nf();
      }
      if ((i & 0x3) != 0) {
        ne();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label115;
        }
        this.azk.setTitle(this.Hn);
        this.azk.setSubtitle(this.Md);
      }
    }
    for (;;)
    {
      if (((i & 0x10) != 0) && (this.ahJ != null))
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        this.azk.addView(this.ahJ);
      }
      return;
      label115:
      this.azk.setTitle(null);
      this.azk.setSubtitle(null);
    }
    this.azk.removeView(this.ahJ);
  }
  
  public final void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(this.azk.getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    this.Xw = paramDrawable;
    ne();
  }
  
  public final void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(this.azk.getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.azn = paramDrawable;
    ne();
  }
  
  public final void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = this.azk.getContext().getString(paramInt))
    {
      setNavigationContentDescription((CharSequence)localObject);
      return;
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.azp = true;
    r(paramCharSequence);
  }
  
  public final void setVisibility(int paramInt)
  {
    this.azk.setVisibility(paramInt);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    this.ZW = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.azp) {
      r(paramCharSequence);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    return this.azk.showOverflowMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ba
 * JD-Core Version:    0.7.0.1
 */