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
  CharSequence Eo;
  private CharSequence Ji;
  private Drawable Uy;
  Window.Callback WZ;
  private View aeL;
  private ActionMenuPresenter aev;
  Toolbar awB;
  private int awC;
  private View awD;
  private Drawable awE;
  private Drawable awF;
  private boolean awG;
  private CharSequence awH;
  boolean awI;
  private int awJ = 0;
  private int awK = 0;
  private Drawable awL;
  
  public ba(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, (byte)0);
  }
  
  private ba(Toolbar paramToolbar, boolean paramBoolean, byte paramByte)
  {
    this.awB = paramToolbar;
    this.Eo = paramToolbar.getTitle();
    this.Ji = paramToolbar.getSubtitle();
    boolean bool;
    if (this.Eo != null)
    {
      bool = true;
      this.awG = bool;
      this.awF = paramToolbar.getNavigationIcon();
      paramToolbar = az.a(paramToolbar.getContext(), null, a.a.ActionBar, 2130968602, 0);
      this.awL = paramToolbar.getDrawable(15);
      if (!paramBoolean) {
        break label574;
      }
      Object localObject = paramToolbar.getText(27);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.awG = true;
        r((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(25);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.Ji = ((CharSequence)localObject);
        if ((this.awC & 0x8) != 0) {
          this.awB.setSubtitle((CharSequence)localObject);
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
      if ((this.awF == null) && (this.awL != null))
      {
        this.awF = this.awL;
        mB();
      }
      setDisplayOptions(paramToolbar.getInt(10, 0));
      paramByte = paramToolbar.getResourceId(9, 0);
      if (paramByte != 0)
      {
        setCustomView(LayoutInflater.from(this.awB.getContext()).inflate(paramByte, this.awB, false));
        setDisplayOptions(this.awC | 0x10);
      }
      paramByte = paramToolbar.getLayoutDimension(13, 0);
      if (paramByte > 0)
      {
        localObject = this.awB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramByte;
        this.awB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int i = paramToolbar.getDimensionPixelOffset(7, -1);
      paramByte = paramToolbar.getDimensionPixelOffset(3, -1);
      if ((i >= 0) || (paramByte >= 0))
      {
        localObject = this.awB;
        i = Math.max(i, 0);
        paramByte = Math.max(paramByte, 0);
        ((Toolbar)localObject).mz();
        ((Toolbar)localObject).awg.aF(i, paramByte);
      }
      paramByte = paramToolbar.getResourceId(28, 0);
      Context localContext;
      if (paramByte != 0)
      {
        localObject = this.awB;
        localContext = this.awB.getContext();
        ((Toolbar)localObject).avY = paramByte;
        if (((Toolbar)localObject).avQ != null) {
          ((Toolbar)localObject).avQ.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(26, 0);
      if (paramByte != 0)
      {
        localObject = this.awB;
        localContext = this.awB.getContext();
        ((Toolbar)localObject).avZ = paramByte;
        if (((Toolbar)localObject).avR != null) {
          ((Toolbar)localObject).avR.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(22, 0);
      if (paramByte != 0) {
        this.awB.setPopupTheme(paramByte);
      }
    }
    for (;;)
    {
      paramToolbar.avP.recycle();
      if (2131755074 != this.awK)
      {
        this.awK = 2131755074;
        if (TextUtils.isEmpty(this.awB.getNavigationContentDescription())) {
          setNavigationContentDescription(this.awK);
        }
      }
      this.awH = this.awB.getNavigationContentDescription();
      this.awB.setNavigationOnClickListener(new View.OnClickListener()
      {
        final android.support.v7.view.menu.a awM = new android.support.v7.view.menu.a(ba.this.awB.getContext(), ba.this.Eo);
        
        public final void onClick(View paramAnonymousView)
        {
          if ((ba.this.WZ != null) && (ba.this.awI)) {
            ba.this.WZ.onMenuItemSelected(0, this.awM);
          }
        }
      });
      return;
      bool = false;
      break;
      label574:
      paramByte = 11;
      if (this.awB.getNavigationIcon() != null)
      {
        this.awL = this.awB.getNavigationIcon();
        paramByte = 15;
      }
      this.awC = paramByte;
    }
  }
  
  private void mA()
  {
    Drawable localDrawable = null;
    if ((this.awC & 0x2) != 0)
    {
      if ((this.awC & 0x1) == 0) {
        break label49;
      }
      if (this.awE == null) {
        break label41;
      }
      localDrawable = this.awE;
    }
    for (;;)
    {
      this.awB.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.Uy;
      continue;
      label49:
      localDrawable = this.Uy;
    }
  }
  
  private void mB()
  {
    if ((this.awC & 0x4) != 0)
    {
      Toolbar localToolbar = this.awB;
      if (this.awF != null) {}
      for (Drawable localDrawable = this.awF;; localDrawable = this.awL)
      {
        localToolbar.setNavigationIcon(localDrawable);
        return;
      }
    }
    this.awB.setNavigationIcon(null);
  }
  
  private void mC()
  {
    if ((this.awC & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.awH)) {
        this.awB.setNavigationContentDescription(this.awK);
      }
    }
    else {
      return;
    }
    this.awB.setNavigationContentDescription(this.awH);
  }
  
  private void r(CharSequence paramCharSequence)
  {
    this.Eo = paramCharSequence;
    if ((this.awC & 0x8) != 0) {
      this.awB.setTitle(paramCharSequence);
    }
  }
  
  private void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    this.awH = paramCharSequence;
    mC();
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    Toolbar localToolbar = this.awB;
    localToolbar.afW = parama;
    localToolbar.afX = parama1;
    if (localToolbar.aeu != null) {
      localToolbar.aeu.a(parama, parama1);
    }
  }
  
  public final void a(ar paramar)
  {
    if ((this.awD != null) && (this.awD.getParent() == this.awB)) {
      this.awB.removeView(this.awD);
    }
    this.awD = paramar;
    if ((paramar != null) && (this.awJ == 2))
    {
      this.awB.addView(this.awD, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.awD.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 8388691;
      paramar.setAllowCollapse(true);
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    if (this.aev == null)
    {
      this.aev = new ActionMenuPresenter(this.awB.getContext());
      this.aev.mId = 2131296370;
    }
    this.aev.aci = parama;
    this.awB.a((h)paramMenu, this.aev);
  }
  
  public final x c(final int paramInt, long paramLong)
  {
    x localx = t.ag(this.awB);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F) {
      localx.w(f).h(paramLong).a(new z()
      {
        private boolean mCanceled = false;
        
        public final void aH(View paramAnonymousView)
        {
          ba.this.awB.setVisibility(0);
        }
        
        public final void aI(View paramAnonymousView)
        {
          if (!this.mCanceled) {
            ba.this.awB.setVisibility(paramInt);
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
    this.awB.collapseActionView();
  }
  
  public final void dismissPopupMenus()
  {
    Toolbar localToolbar = this.awB;
    if (localToolbar.aeu != null) {
      localToolbar.aeu.dismissPopupMenus();
    }
  }
  
  public final Context getContext()
  {
    return this.awB.getContext();
  }
  
  public final View getCustomView()
  {
    return this.aeL;
  }
  
  public final int getDisplayOptions()
  {
    return this.awC;
  }
  
  public final int getHeight()
  {
    return this.awB.getHeight();
  }
  
  public final Menu getMenu()
  {
    return this.awB.getMenu();
  }
  
  public final int getNavigationMode()
  {
    return this.awJ;
  }
  
  public final CharSequence getTitle()
  {
    return this.awB.getTitle();
  }
  
  public final int getVisibility()
  {
    return this.awB.getVisibility();
  }
  
  public final boolean hS()
  {
    Toolbar localToolbar = this.awB;
    return (localToolbar.getVisibility() == 0) && (localToolbar.aeu != null) && (localToolbar.aeu.afw);
  }
  
  public final boolean hT()
  {
    Object localObject = this.awB;
    if (((Toolbar)localObject).aeu != null)
    {
      localObject = ((Toolbar)localObject).aeu;
      if (((ActionMenuView)localObject).afV != null)
      {
        localObject = ((ActionMenuView)localObject).afV;
        if ((((ActionMenuPresenter)localObject).afK != null) || (((ActionMenuPresenter)localObject).isOverflowMenuShowing()))
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
  
  public final void hU()
  {
    this.awI = true;
  }
  
  public final boolean hasExpandedActionView()
  {
    Toolbar localToolbar = this.awB;
    return (localToolbar.awt != null) && (localToolbar.awt.awx != null);
  }
  
  public final boolean hideOverflowMenu()
  {
    Object localObject = this.awB;
    if (((Toolbar)localObject).aeu != null)
    {
      localObject = ((Toolbar)localObject).aeu;
      if ((((ActionMenuView)localObject).afV != null) && (((ActionMenuView)localObject).afV.hideOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final ViewGroup iV()
  {
    return this.awB;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return this.awB.isOverflowMenuShowing();
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    t.a(this.awB, paramDrawable);
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    this.awB.setCollapsible(paramBoolean);
  }
  
  public final void setCustomView(View paramView)
  {
    if ((this.aeL != null) && ((this.awC & 0x10) != 0)) {
      this.awB.removeView(this.aeL);
    }
    this.aeL = paramView;
    if ((paramView != null) && ((this.awC & 0x10) != 0)) {
      this.awB.addView(this.aeL);
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    int i = this.awC ^ paramInt;
    this.awC = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          mC();
        }
        mB();
      }
      if ((i & 0x3) != 0) {
        mA();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label115;
        }
        this.awB.setTitle(this.Eo);
        this.awB.setSubtitle(this.Ji);
      }
    }
    for (;;)
    {
      if (((i & 0x10) != 0) && (this.aeL != null))
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        this.awB.addView(this.aeL);
      }
      return;
      label115:
      this.awB.setTitle(null);
      this.awB.setSubtitle(null);
    }
    this.awB.removeView(this.aeL);
  }
  
  public final void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(this.awB.getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    this.Uy = paramDrawable;
    mA();
  }
  
  public final void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(this.awB.getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.awE = paramDrawable;
    mA();
  }
  
  public final void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = this.awB.getContext().getString(paramInt))
    {
      setNavigationContentDescription((CharSequence)localObject);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    this.awB.setVisibility(paramInt);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    this.WZ = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.awG) {
      r(paramCharSequence);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    return this.awB.showOverflowMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ba
 * JD-Core Version:    0.7.0.1
 */