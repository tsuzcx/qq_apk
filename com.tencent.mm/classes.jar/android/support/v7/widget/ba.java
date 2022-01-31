package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.z;
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
  CharSequence Cv;
  private CharSequence Cw;
  Window.Callback Qa;
  private ActionMenuPresenter Xq;
  private int aoZ;
  private View apa;
  private Drawable apb;
  private Drawable apc;
  private boolean apd;
  private CharSequence ape;
  boolean apf;
  private int apg = 0;
  private int aph = 0;
  private Drawable api;
  Toolbar hO;
  private View lX;
  private Drawable la;
  
  public ba(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, (byte)0);
  }
  
  private ba(Toolbar paramToolbar, boolean paramBoolean, byte paramByte)
  {
    this.hO = paramToolbar;
    this.Cv = paramToolbar.getTitle();
    this.Cw = paramToolbar.getSubtitle();
    boolean bool;
    if (this.Cv != null)
    {
      bool = true;
      this.apd = bool;
      this.apc = paramToolbar.getNavigationIcon();
      paramToolbar = az.a(paramToolbar.getContext(), null, a.a.ActionBar, 2130772139, 0);
      this.api = paramToolbar.getDrawable(28);
      if (!paramBoolean) {
        break label570;
      }
      Object localObject = paramToolbar.getText(1);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.apd = true;
        o((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(4);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.Cw = ((CharSequence)localObject);
        if ((this.aoZ & 0x8) != 0) {
          this.hO.setSubtitle((CharSequence)localObject);
        }
      }
      localObject = paramToolbar.getDrawable(8);
      if (localObject != null) {
        setLogo((Drawable)localObject);
      }
      localObject = paramToolbar.getDrawable(7);
      if (localObject != null) {
        setIcon((Drawable)localObject);
      }
      if ((this.apc == null) && (this.api != null))
      {
        this.apc = this.api;
        kU();
      }
      setDisplayOptions(paramToolbar.getInt(3, 0));
      paramByte = paramToolbar.getResourceId(13, 0);
      if (paramByte != 0)
      {
        setCustomView(LayoutInflater.from(this.hO.getContext()).inflate(paramByte, this.hO, false));
        setDisplayOptions(this.aoZ | 0x10);
      }
      paramByte = paramToolbar.getLayoutDimension(0, 0);
      if (paramByte > 0)
      {
        localObject = this.hO.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramByte;
        this.hO.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int i = paramToolbar.getDimensionPixelOffset(20, -1);
      paramByte = paramToolbar.getDimensionPixelOffset(21, -1);
      if ((i >= 0) || (paramByte >= 0))
      {
        localObject = this.hO;
        i = Math.max(i, 0);
        paramByte = Math.max(paramByte, 0);
        ((Toolbar)localObject).kS();
        ((Toolbar)localObject).aoF.aE(i, paramByte);
      }
      paramByte = paramToolbar.getResourceId(5, 0);
      Context localContext;
      if (paramByte != 0)
      {
        localObject = this.hO;
        localContext = this.hO.getContext();
        ((Toolbar)localObject).aox = paramByte;
        if (((Toolbar)localObject).aop != null) {
          ((Toolbar)localObject).aop.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(6, 0);
      if (paramByte != 0)
      {
        localObject = this.hO;
        localContext = this.hO.getContext();
        ((Toolbar)localObject).aoy = paramByte;
        if (((Toolbar)localObject).aoq != null) {
          ((Toolbar)localObject).aoq.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(27, 0);
      if (paramByte != 0) {
        this.hO.setPopupTheme(paramByte);
      }
    }
    for (;;)
    {
      paramToolbar.aoo.recycle();
      if (2131296257 != this.aph)
      {
        this.aph = 2131296257;
        if (TextUtils.isEmpty(this.hO.getNavigationContentDescription())) {
          setNavigationContentDescription(this.aph);
        }
      }
      this.ape = this.hO.getNavigationContentDescription();
      this.hO.setNavigationOnClickListener(new View.OnClickListener()
      {
        final android.support.v7.view.menu.a apj = new android.support.v7.view.menu.a(ba.this.hO.getContext(), ba.this.Cv);
        
        public final void onClick(View paramAnonymousView)
        {
          if ((ba.this.Qa != null) && (ba.this.apf)) {
            ba.this.Qa.onMenuItemSelected(0, this.apj);
          }
        }
      });
      return;
      bool = false;
      break;
      label570:
      paramByte = 11;
      if (this.hO.getNavigationIcon() != null)
      {
        paramByte = 15;
        this.api = this.hO.getNavigationIcon();
      }
      this.aoZ = paramByte;
    }
  }
  
  private void kT()
  {
    Drawable localDrawable = null;
    if ((this.aoZ & 0x2) != 0)
    {
      if ((this.aoZ & 0x1) == 0) {
        break label49;
      }
      if (this.apb == null) {
        break label41;
      }
      localDrawable = this.apb;
    }
    for (;;)
    {
      this.hO.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.la;
      continue;
      label49:
      localDrawable = this.la;
    }
  }
  
  private void kU()
  {
    if ((this.aoZ & 0x4) != 0)
    {
      Toolbar localToolbar = this.hO;
      if (this.apc != null) {}
      for (Drawable localDrawable = this.apc;; localDrawable = this.api)
      {
        localToolbar.setNavigationIcon(localDrawable);
        return;
      }
    }
    this.hO.setNavigationIcon(null);
  }
  
  private void kV()
  {
    if ((this.aoZ & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.ape)) {
        this.hO.setNavigationContentDescription(this.aph);
      }
    }
    else {
      return;
    }
    this.hO.setNavigationContentDescription(this.ape);
  }
  
  private void o(CharSequence paramCharSequence)
  {
    this.Cv = paramCharSequence;
    if ((this.aoZ & 0x8) != 0) {
      this.hO.setTitle(paramCharSequence);
    }
  }
  
  private void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    this.ape = paramCharSequence;
    kV();
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    Toolbar localToolbar = this.hO;
    localToolbar.YQ = parama;
    localToolbar.YR = parama1;
    if (localToolbar.Xp != null) {
      localToolbar.Xp.a(parama, parama1);
    }
  }
  
  public final void a(ar paramar)
  {
    if ((this.apa != null) && (this.apa.getParent() == this.hO)) {
      this.hO.removeView(this.apa);
    }
    this.apa = paramar;
    if ((paramar != null) && (this.apg == 2))
    {
      this.hO.addView(this.apa, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.apa.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 8388691;
      paramar.setAllowCollapse(true);
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    if (this.Xq == null)
    {
      this.Xq = new ActionMenuPresenter(this.hO.getContext());
      this.Xq.mId = 2131820547;
    }
    this.Xq.eN = parama;
    this.hO.a((h)paramMenu, this.Xq);
  }
  
  public final x c(final int paramInt, long paramLong)
  {
    x localx = t.ab(this.hO);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F) {
      localx.s(f).h(paramLong).a(new z()
      {
        private boolean qM = false;
        
        public final void aB(View paramAnonymousView)
        {
          ba.this.hO.setVisibility(0);
        }
        
        public final void aC(View paramAnonymousView)
        {
          if (!this.qM) {
            ba.this.hO.setVisibility(paramInt);
          }
        }
        
        public final void aD(View paramAnonymousView)
        {
          this.qM = true;
        }
      });
    }
  }
  
  public final void collapseActionView()
  {
    this.hO.collapseActionView();
  }
  
  public final void dismissPopupMenus()
  {
    Toolbar localToolbar = this.hO;
    if (localToolbar.Xp != null) {
      localToolbar.Xp.dismissPopupMenus();
    }
  }
  
  public final Context getContext()
  {
    return this.hO.getContext();
  }
  
  public final View getCustomView()
  {
    return this.lX;
  }
  
  public final int getDisplayOptions()
  {
    return this.aoZ;
  }
  
  public final int getHeight()
  {
    return this.hO.getHeight();
  }
  
  public final Menu getMenu()
  {
    return this.hO.getMenu();
  }
  
  public final int getNavigationMode()
  {
    return this.apg;
  }
  
  public final CharSequence getTitle()
  {
    return this.hO.getTitle();
  }
  
  public final int getVisibility()
  {
    return this.hO.getVisibility();
  }
  
  public final boolean gx()
  {
    Toolbar localToolbar = this.hO;
    return (localToolbar.getVisibility() == 0) && (localToolbar.Xp != null) && (localToolbar.Xp.Yq);
  }
  
  public final boolean gy()
  {
    Object localObject = this.hO;
    if (((Toolbar)localObject).Xp != null)
    {
      localObject = ((Toolbar)localObject).Xp;
      if (((ActionMenuView)localObject).YP != null)
      {
        localObject = ((ActionMenuView)localObject).YP;
        if ((((ActionMenuPresenter)localObject).YE != null) || (((ActionMenuPresenter)localObject).isOverflowMenuShowing()))
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
  
  public final void gz()
  {
    this.apf = true;
  }
  
  public final boolean hasExpandedActionView()
  {
    Toolbar localToolbar = this.hO;
    return (localToolbar.aoS != null) && (localToolbar.aoS.aoV != null);
  }
  
  public final boolean hideOverflowMenu()
  {
    Object localObject = this.hO;
    if (((Toolbar)localObject).Xp != null)
    {
      localObject = ((Toolbar)localObject).Xp;
      if ((((ActionMenuView)localObject).YP != null) && (((ActionMenuView)localObject).YP.hideOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final ViewGroup hz()
  {
    return this.hO;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return this.hO.isOverflowMenuShowing();
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    t.a(this.hO, paramDrawable);
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    this.hO.setCollapsible(paramBoolean);
  }
  
  public final void setCustomView(View paramView)
  {
    if ((this.lX != null) && ((this.aoZ & 0x10) != 0)) {
      this.hO.removeView(this.lX);
    }
    this.lX = paramView;
    if ((paramView != null) && ((this.aoZ & 0x10) != 0)) {
      this.hO.addView(this.lX);
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    int i = this.aoZ ^ paramInt;
    this.aoZ = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          kV();
        }
        kU();
      }
      if ((i & 0x3) != 0) {
        kT();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label115;
        }
        this.hO.setTitle(this.Cv);
        this.hO.setSubtitle(this.Cw);
      }
    }
    for (;;)
    {
      if (((i & 0x10) != 0) && (this.lX != null))
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        this.hO.addView(this.lX);
      }
      return;
      label115:
      this.hO.setTitle(null);
      this.hO.setSubtitle(null);
    }
    this.hO.removeView(this.lX);
  }
  
  public final void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.k(this.hO.getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    this.la = paramDrawable;
    kT();
  }
  
  public final void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.k(this.hO.getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.apb = paramDrawable;
    kT();
  }
  
  public final void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = this.hO.getContext().getString(paramInt))
    {
      setNavigationContentDescription((CharSequence)localObject);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    this.hO.setVisibility(paramInt);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    this.Qa = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.apd) {
      o(paramCharSequence);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    return this.hO.showOverflowMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ba
 * JD-Core Version:    0.7.0.1
 */