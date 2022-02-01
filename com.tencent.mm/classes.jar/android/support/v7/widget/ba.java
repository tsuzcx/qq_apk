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
  CharSequence Fm;
  private CharSequence Kd;
  private Drawable Vu;
  Window.Callback XU;
  private View afF;
  private ActionMenuPresenter afp;
  private boolean axA;
  private CharSequence axB;
  boolean axC;
  private int axD = 0;
  private int axE = 0;
  private Drawable axF;
  Toolbar axv;
  private int axw;
  private View axx;
  private Drawable axy;
  private Drawable axz;
  
  public ba(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, (byte)0);
  }
  
  private ba(Toolbar paramToolbar, boolean paramBoolean, byte paramByte)
  {
    this.axv = paramToolbar;
    this.Fm = paramToolbar.getTitle();
    this.Kd = paramToolbar.getSubtitle();
    boolean bool;
    if (this.Fm != null)
    {
      bool = true;
      this.axA = bool;
      this.axz = paramToolbar.getNavigationIcon();
      paramToolbar = az.a(paramToolbar.getContext(), null, a.a.ActionBar, 2130968602, 0);
      this.axF = paramToolbar.getDrawable(15);
      if (!paramBoolean) {
        break label574;
      }
      Object localObject = paramToolbar.getText(27);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.axA = true;
        r((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(25);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.Kd = ((CharSequence)localObject);
        if ((this.axw & 0x8) != 0) {
          this.axv.setSubtitle((CharSequence)localObject);
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
      if ((this.axz == null) && (this.axF != null))
      {
        this.axz = this.axF;
        mL();
      }
      setDisplayOptions(paramToolbar.getInt(10, 0));
      paramByte = paramToolbar.getResourceId(9, 0);
      if (paramByte != 0)
      {
        setCustomView(LayoutInflater.from(this.axv.getContext()).inflate(paramByte, this.axv, false));
        setDisplayOptions(this.axw | 0x10);
      }
      paramByte = paramToolbar.getLayoutDimension(13, 0);
      if (paramByte > 0)
      {
        localObject = this.axv.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramByte;
        this.axv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int i = paramToolbar.getDimensionPixelOffset(7, -1);
      paramByte = paramToolbar.getDimensionPixelOffset(3, -1);
      if ((i >= 0) || (paramByte >= 0))
      {
        localObject = this.axv;
        i = Math.max(i, 0);
        paramByte = Math.max(paramByte, 0);
        ((Toolbar)localObject).mJ();
        ((Toolbar)localObject).axa.aF(i, paramByte);
      }
      paramByte = paramToolbar.getResourceId(28, 0);
      Context localContext;
      if (paramByte != 0)
      {
        localObject = this.axv;
        localContext = this.axv.getContext();
        ((Toolbar)localObject).awS = paramByte;
        if (((Toolbar)localObject).awK != null) {
          ((Toolbar)localObject).awK.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(26, 0);
      if (paramByte != 0)
      {
        localObject = this.axv;
        localContext = this.axv.getContext();
        ((Toolbar)localObject).awT = paramByte;
        if (((Toolbar)localObject).awL != null) {
          ((Toolbar)localObject).awL.setTextAppearance(localContext, paramByte);
        }
      }
      paramByte = paramToolbar.getResourceId(22, 0);
      if (paramByte != 0) {
        this.axv.setPopupTheme(paramByte);
      }
    }
    for (;;)
    {
      paramToolbar.awJ.recycle();
      if (2131755074 != this.axE)
      {
        this.axE = 2131755074;
        if (TextUtils.isEmpty(this.axv.getNavigationContentDescription())) {
          setNavigationContentDescription(this.axE);
        }
      }
      this.axB = this.axv.getNavigationContentDescription();
      this.axv.setNavigationOnClickListener(new View.OnClickListener()
      {
        final android.support.v7.view.menu.a axG = new android.support.v7.view.menu.a(ba.this.axv.getContext(), ba.this.Fm);
        
        public final void onClick(View paramAnonymousView)
        {
          if ((ba.this.XU != null) && (ba.this.axC)) {
            ba.this.XU.onMenuItemSelected(0, this.axG);
          }
        }
      });
      return;
      bool = false;
      break;
      label574:
      paramByte = 11;
      if (this.axv.getNavigationIcon() != null)
      {
        this.axF = this.axv.getNavigationIcon();
        paramByte = 15;
      }
      this.axw = paramByte;
    }
  }
  
  private void mK()
  {
    Drawable localDrawable = null;
    if ((this.axw & 0x2) != 0)
    {
      if ((this.axw & 0x1) == 0) {
        break label49;
      }
      if (this.axy == null) {
        break label41;
      }
      localDrawable = this.axy;
    }
    for (;;)
    {
      this.axv.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.Vu;
      continue;
      label49:
      localDrawable = this.Vu;
    }
  }
  
  private void mL()
  {
    if ((this.axw & 0x4) != 0)
    {
      Toolbar localToolbar = this.axv;
      if (this.axz != null) {}
      for (Drawable localDrawable = this.axz;; localDrawable = this.axF)
      {
        localToolbar.setNavigationIcon(localDrawable);
        return;
      }
    }
    this.axv.setNavigationIcon(null);
  }
  
  private void mM()
  {
    if ((this.axw & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.axB)) {
        this.axv.setNavigationContentDescription(this.axE);
      }
    }
    else {
      return;
    }
    this.axv.setNavigationContentDescription(this.axB);
  }
  
  private void r(CharSequence paramCharSequence)
  {
    this.Fm = paramCharSequence;
    if ((this.axw & 0x8) != 0) {
      this.axv.setTitle(paramCharSequence);
    }
  }
  
  private void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    this.axB = paramCharSequence;
    mM();
  }
  
  public final void a(o.a parama, h.a parama1)
  {
    Toolbar localToolbar = this.axv;
    localToolbar.agQ = parama;
    localToolbar.agR = parama1;
    if (localToolbar.afo != null) {
      localToolbar.afo.a(parama, parama1);
    }
  }
  
  public final void a(ar paramar)
  {
    if ((this.axx != null) && (this.axx.getParent() == this.axv)) {
      this.axv.removeView(this.axx);
    }
    this.axx = paramar;
    if ((paramar != null) && (this.axD == 2))
    {
      this.axv.addView(this.axx, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.axx.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 8388691;
      paramar.setAllowCollapse(true);
    }
  }
  
  public final void a(Menu paramMenu, o.a parama)
  {
    if (this.afp == null)
    {
      this.afp = new ActionMenuPresenter(this.axv.getContext());
      this.afp.mId = 2131296370;
    }
    this.afp.adc = parama;
    this.axv.a((h)paramMenu, this.afp);
  }
  
  public final x c(final int paramInt, long paramLong)
  {
    x localx = t.ag(this.axv);
    if (paramInt == 0) {}
    for (float f = 1.0F;; f = 0.0F) {
      localx.A(f).j(paramLong).a(new z()
      {
        private boolean mCanceled = false;
        
        public final void aH(View paramAnonymousView)
        {
          ba.this.axv.setVisibility(0);
        }
        
        public final void aI(View paramAnonymousView)
        {
          if (!this.mCanceled) {
            ba.this.axv.setVisibility(paramInt);
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
    this.axv.collapseActionView();
  }
  
  public final void dismissPopupMenus()
  {
    Toolbar localToolbar = this.axv;
    if (localToolbar.afo != null) {
      localToolbar.afo.dismissPopupMenus();
    }
  }
  
  public final Context getContext()
  {
    return this.axv.getContext();
  }
  
  public final View getCustomView()
  {
    return this.afF;
  }
  
  public final int getDisplayOptions()
  {
    return this.axw;
  }
  
  public final int getHeight()
  {
    return this.axv.getHeight();
  }
  
  public final Menu getMenu()
  {
    return this.axv.getMenu();
  }
  
  public final int getNavigationMode()
  {
    return this.axD;
  }
  
  public final CharSequence getTitle()
  {
    return this.axv.getTitle();
  }
  
  public final int getVisibility()
  {
    return this.axv.getVisibility();
  }
  
  public final boolean hasExpandedActionView()
  {
    Toolbar localToolbar = this.axv;
    return (localToolbar.axn != null) && (localToolbar.axn.axr != null);
  }
  
  public final boolean hideOverflowMenu()
  {
    Object localObject = this.axv;
    if (((Toolbar)localObject).afo != null)
    {
      localObject = ((Toolbar)localObject).afo;
      if ((((ActionMenuView)localObject).agP != null) && (((ActionMenuView)localObject).agP.hideOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean ia()
  {
    Toolbar localToolbar = this.axv;
    return (localToolbar.getVisibility() == 0) && (localToolbar.afo != null) && (localToolbar.afo.agq);
  }
  
  public final boolean ib()
  {
    Object localObject = this.axv;
    if (((Toolbar)localObject).afo != null)
    {
      localObject = ((Toolbar)localObject).afo;
      if (((ActionMenuView)localObject).agP != null)
      {
        localObject = ((ActionMenuView)localObject).agP;
        if ((((ActionMenuPresenter)localObject).agE != null) || (((ActionMenuPresenter)localObject).isOverflowMenuShowing()))
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
  
  public final void ic()
  {
    this.axC = true;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    return this.axv.isOverflowMenuShowing();
  }
  
  public final ViewGroup jd()
  {
    return this.axv;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    t.a(this.axv, paramDrawable);
  }
  
  public final void setCollapsible(boolean paramBoolean)
  {
    this.axv.setCollapsible(paramBoolean);
  }
  
  public final void setCustomView(View paramView)
  {
    if ((this.afF != null) && ((this.axw & 0x10) != 0)) {
      this.axv.removeView(this.afF);
    }
    this.afF = paramView;
    if ((paramView != null) && ((this.axw & 0x10) != 0)) {
      this.axv.addView(this.afF);
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    int i = this.axw ^ paramInt;
    this.axw = paramInt;
    if (i != 0)
    {
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          mM();
        }
        mL();
      }
      if ((i & 0x3) != 0) {
        mK();
      }
      if ((i & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label115;
        }
        this.axv.setTitle(this.Fm);
        this.axv.setSubtitle(this.Kd);
      }
    }
    for (;;)
    {
      if (((i & 0x10) != 0) && (this.afF != null))
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        this.axv.addView(this.afF);
      }
      return;
      label115:
      this.axv.setTitle(null);
      this.axv.setSubtitle(null);
    }
    this.axv.removeView(this.afF);
  }
  
  public final void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(this.axv.getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    this.Vu = paramDrawable;
    mK();
  }
  
  public final void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.c.a.a.l(this.axv.getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.axy = paramDrawable;
    mK();
  }
  
  public final void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = this.axv.getContext().getString(paramInt))
    {
      setNavigationContentDescription((CharSequence)localObject);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    this.axv.setVisibility(paramInt);
  }
  
  public final void setWindowCallback(Window.Callback paramCallback)
  {
    this.XU = paramCallback;
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.axA) {
      r(paramCharSequence);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    return this.axv.showOverflowMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ba
 * JD-Core Version:    0.7.0.1
 */