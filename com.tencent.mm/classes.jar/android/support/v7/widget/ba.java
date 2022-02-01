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
  CharSequence Hd;
  private CharSequence LT;
  private Drawable Xj;
  Window.Callback ZJ;
  private ActionMenuPresenter ahg;
  private View ahw;
  Toolbar azm;
  private int azn;
  private View azo;
  private Drawable azp;
  private Drawable azq;
  private boolean azr;
  private CharSequence azs;
  boolean azt;
  private int azu = 0;
  private int azv = 0;
  private Drawable azw;
  
  public ba(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, (byte)0);
  }
  
  private ba(Toolbar paramToolbar, boolean paramBoolean, byte paramByte)
  {
    this.azm = paramToolbar;
    this.Hd = paramToolbar.getTitle();
    this.LT = paramToolbar.getSubtitle();
    boolean bool;
    if (this.Hd != null)
    {
      bool = true;
      this.azr = bool;
      this.azq = paramToolbar.getNavigationIcon();
      paramToolbar = az.a(paramToolbar.getContext(), null, a.a.ActionBar, 2130968602, 0);
      this.azw = paramToolbar.getDrawable(15);
      if (!paramBoolean) {
        break label574;
      }
      Object localObject = paramToolbar.getText(27);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.azr = true;
        r((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(25);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.LT = ((CharSequence)localObject);
        if ((this.azn & 0x8) != 0) {
          this.azm.setSubtitle((CharSequence)localObject);
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
      if ((this.azq == null) && (this.azw != null))
      {
        this.azq = this.azw;
        nd();
      }
      setDisplayOptions(paramToolbar.getInt(10, 0));
      paramByte = paramToolbar.getResourceId(9, 0);
      if (paramByte != 0)
      {
        setCustomView(LayoutInflater.from(this.azm.getContext()).inflate(paramByte, this.azm, false));
        setDisplayOptions(this.azn | 0x10);
      }
      paramByte = paramToolbar.getLayoutDimension(13, 0);
      if (paramByte > 0)
      {
        localObject = this.azm.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramByte;
        this.azm.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int i = paramToolbar.getDimensionPixelOffset(7, -1);
      paramByte = paramToolbar.getDimensionPixelOffset(3, -1);
      if ((i >= 0) || (paramByte >= 0))
      {
        localObject = this.azm;
        i = Math.max(i, 0);
        paramByte = Math.max(paramByte, 0);
        ((Toolbar)localObject).nb();
        ((Toolbar)localObject).ayR.aG(i, paramByte);
      }
      paramByte = paramToolbar.getResourceId(28, 0);
      Context localContext;
      if (paramByte != 0)
      {
        localObject = this.azm;
        localContext = this.azm.getContext();
        ((Toolbar)localObject).ayJ = paramByte;
        if (((Toolbar)localObject).ayB != null) {
          ((Toolbar)localObject).ayB.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(26, 0);
      if (paramByte != 0)
      {
        localObject = this.azm;
        localContext = this.azm.getContext();
        ((Toolbar)localObject).ayK = paramByte;
        if (((Toolbar)localObject).ayC != null) {
          ((Toolbar)localObject).ayC.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(22, 0);
      if (paramByte != 0) {
        this.azm.setPopupTheme(paramByte);
      }
    }
    for (;;)
    {
      paramToolbar.ayA.recycle();
      if (2131755074 != this.azv)
      {
        this.azv = 2131755074;
        if (TextUtils.isEmpty(this.azm.getNavigationContentDescription())) {
          setNavigationContentDescription(this.azv);
        }
      }
      this.azs = this.azm.getNavigationContentDescription();
      this.azm.setNavigationOnClickListener(new View.OnClickListener()
      {
        final android.support.v7.view.menu.a azx = new android.support.v7.view.menu.a(ba.this.azm.getContext(), ba.this.Hd);
        
        public final void onClick(View paramAnonymousView)
        {
          if ((ba.this.ZJ != null) && (ba.this.azt)) {
            ba.this.ZJ.onMenuItemSelected(0, this.azx);
          }
        }
      });
      return;
      bool = false;
      break;
      label574:
      paramByte = 11;
      if (this.azm.getNavigationIcon() != null)
      {
        this.azw = this.azm.getNavigationIcon();
        paramByte = 15;
      }
      this.azn = paramByte;
    }
  }
  
  private void nc()
  {
    Drawable localDrawable = null;
    if ((this.azn & 0x2) != 0)
    {
      if ((this.azn & 0x1) == 0) {
        break label49;
      }
      if (this.azp == null) {
        break label41;
      }
      localDrawable = this.azp;
    }
    for (;;)
    {
      this.azm.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.Xj;
      continue;
      label49:
      localDrawable = this.Xj;
    }
  }
  
  private void nd()
  {
    if ((this.azn & 0x4) != 0)
    {
      Toolbar localToolbar = this.azm;
      if (this.azq != null) {}
      for (Drawable localDrawable = this.azq;; localDrawable = this.azw)
      {
        localToolbar.setNavigationIcon(localDrawable);
        return;
      }
    }
    this.azm.setNavigationIcon(null);
  }
  
  private void ne()
  {
    if ((this.azn & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.azs)) {
        this.azm.setNavigationContentDescription(this.azv);
      }
    }
    else {
      return;
    }
    this.azm.setNavigationContentDescription(this.azs);
  }
  
  private void r(CharSequence paramCharSequence)
  {
    this.Hd = paramCharSequence;
    if ((this.azn & 0x8) != 0) {
      this.azm.setTitle(paramCharSequence);
    }
  }
  
  private void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    this.azs = paramCharSequence;
    ne();
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    Toolbar localToolbar = this.azm;
    localToolbar.aiH = parama;
    localToolbar.aiI = parama1;
    if (localToolbar.ahf != null) {
      localToolbar.ahf.a(parama, parama1);
    }
  }
  
  public final void a(ar paramar)
  {
    if ((this.azo != null) && (this.azo.getParent() == this.azm)) {
      this.azm.removeView(this.azo);
    }
    this.azo = paramar;
    if ((paramar != null) && (this.azu == 2))
    {
      this.azm.addView(this.azo, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.azo.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 8388691;
      paramar.setAllowCollapse(true);
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    if (this.ahg == null)
    {
      this.ahg = new ActionMenuPresenter(this.azm.getContext());
      this.ahg.mId = 2131296370;
    }
    this.ahg.aeT = parama;
    this.azm.a((h)paramMenu, this.ahg);
  }
  
  public final x c(final int paramInt, long paramLong)
  {
    x localx = t.ag(this.azm);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F) {
      localx.y(f).j(paramLong).a(new z()
      {
        private boolean mCanceled = false;
        
        public final void aH(View paramAnonymousView)
        {
          ba.this.azm.setVisibility(0);
        }
        
        public final void aI(View paramAnonymousView)
        {
          if (!this.mCanceled) {
            ba.this.azm.setVisibility(paramInt);
          }
        }
        
        public final void aJ(View paramAnonymousView)
        {
          this.mCanceled = true;
        }
      });
    }
  }
  
  public final void collapseActionView()
  {
    this.azm.collapseActionView();
  }
  
  public final void dismissPopupMenus()
  {
    Toolbar localToolbar = this.azm;
    if (localToolbar.ahf != null) {
      localToolbar.ahf.dismissPopupMenus();
    }
  }
  
  public final Context getContext()
  {
    return this.azm.getContext();
  }
  
  public final View getCustomView()
  {
    return this.ahw;
  }
  
  public final int getDisplayOptions()
  {
    return this.azn;
  }
  
  public final int getHeight()
  {
    return this.azm.getHeight();
  }
  
  public final Menu getMenu()
  {
    return this.azm.getMenu();
  }
  
  public final int getNavigationMode()
  {
    return this.azu;
  }
  
  public final CharSequence getTitle()
  {
    return this.azm.getTitle();
  }
  
  public final int getVisibility()
  {
    return this.azm.getVisibility();
  }
  
  public final boolean hasExpandedActionView()
  {
    Toolbar localToolbar = this.azm;
    return (localToolbar.aze != null) && (localToolbar.aze.azi != null);
  }
  
  public final boolean hideOverflowMenu()
  {
    Object localObject = this.azm;
    if (((Toolbar)localObject).ahf != null)
    {
      localObject = ((Toolbar)localObject).ahf;
      if ((((ActionMenuView)localObject).aiG != null) && (((ActionMenuView)localObject).aiG.hideOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean is()
  {
    Toolbar localToolbar = this.azm;
    return (localToolbar.getVisibility() == 0) && (localToolbar.ahf != null) && (localToolbar.ahf.aih);
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return this.azm.isOverflowMenuShowing();
  }
  
  public final boolean it()
  {
    Object localObject = this.azm;
    if (((Toolbar)localObject).ahf != null)
    {
      localObject = ((Toolbar)localObject).ahf;
      if (((ActionMenuView)localObject).aiG != null)
      {
        localObject = ((ActionMenuView)localObject).aiG;
        if ((((ActionMenuPresenter)localObject).aiv != null) || (((ActionMenuPresenter)localObject).isOverflowMenuShowing()))
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
  
  public final void iu()
  {
    this.azt = true;
  }
  
  public final ViewGroup jt()
  {
    return this.azm;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    t.a(this.azm, paramDrawable);
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    this.azm.setCollapsible(paramBoolean);
  }
  
  public final void setCustomView(View paramView)
  {
    if ((this.ahw != null) && ((this.azn & 0x10) != 0)) {
      this.azm.removeView(this.ahw);
    }
    this.ahw = paramView;
    if ((paramView != null) && ((this.azn & 0x10) != 0)) {
      this.azm.addView(this.ahw);
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    int i = this.azn ^ paramInt;
    this.azn = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          ne();
        }
        nd();
      }
      if ((i & 0x3) != 0) {
        nc();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label115;
        }
        this.azm.setTitle(this.Hd);
        this.azm.setSubtitle(this.LT);
      }
    }
    for (;;)
    {
      if (((i & 0x10) != 0) && (this.ahw != null))
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        this.azm.addView(this.ahw);
      }
      return;
      label115:
      this.azm.setTitle(null);
      this.azm.setSubtitle(null);
    }
    this.azm.removeView(this.ahw);
  }
  
  public final void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(this.azm.getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    this.Xj = paramDrawable;
    nc();
  }
  
  public final void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(this.azm.getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.azp = paramDrawable;
    nc();
  }
  
  public final void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = this.azm.getContext().getString(paramInt))
    {
      setNavigationContentDescription((CharSequence)localObject);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    this.azm.setVisibility(paramInt);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    this.ZJ = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.azr) {
      r(paramCharSequence);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    return this.azm.showOverflowMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ba
 * JD-Core Version:    0.7.0.1
 */