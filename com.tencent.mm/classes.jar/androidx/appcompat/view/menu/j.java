package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import androidx.core.g.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class j
  implements androidx.core.a.a.b
{
  private int cN = 16;
  private CharSequence cZ;
  h is;
  private final int kM;
  private final int kN;
  final int kO;
  private CharSequence kP;
  private char kQ;
  int kR = 4096;
  private char kS;
  int kT = 4096;
  private Drawable kU;
  private int kV = 0;
  private MenuItem.OnMenuItemClickListener kW;
  private CharSequence kX;
  private CharSequence kY;
  private ColorStateList kZ = null;
  private PorterDuff.Mode la = null;
  private boolean lb = false;
  private boolean lc = false;
  private final int mId;
  private Intent mIntent;
  private u na;
  private Runnable nb;
  private boolean nc = false;
  private int nd = 0;
  private View ne;
  public androidx.core.g.b nf;
  private MenuItem.OnActionExpandListener ng;
  private boolean nh = false;
  ContextMenu.ContextMenuInfo ni;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.is = paramh;
    this.mId = paramInt2;
    this.kM = paramInt1;
    this.kN = paramInt3;
    this.kO = paramInt4;
    this.cZ = paramCharSequence;
    this.nd = paramInt5;
  }
  
  private void J(boolean paramBoolean)
  {
    AppMethodBeat.i(239533);
    int j = this.cN;
    int k = this.cN;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.cN = (i | k & 0xFFFFFFFD);
      if (j != this.cN) {
        this.is.H(false);
      }
      AppMethodBeat.o(239533);
      return;
    }
  }
  
  static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(239482);
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
    AppMethodBeat.o(239482);
  }
  
  private Drawable e(Drawable paramDrawable)
  {
    AppMethodBeat.i(239521);
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.nc) {
        if (!this.lb)
        {
          localDrawable = paramDrawable;
          if (!this.lc) {}
        }
        else
        {
          localDrawable = androidx.core.graphics.drawable.a.p(paramDrawable).mutate();
          if (this.lb) {
            androidx.core.graphics.drawable.a.a(localDrawable, this.kZ);
          }
          if (this.lc) {
            androidx.core.graphics.drawable.a.a(localDrawable, this.la);
          }
          this.nc = false;
        }
      }
    }
    AppMethodBeat.o(239521);
    return localDrawable;
  }
  
  private androidx.core.a.a.b j(View paramView)
  {
    AppMethodBeat.i(239556);
    this.ne = paramView;
    this.nf = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.is.ch();
    AppMethodBeat.o(239556);
    return this;
  }
  
  public final void I(boolean paramBoolean)
  {
    int j = this.cN;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.cN = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean K(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.cN;
    int k = this.cN;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.cN = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.cN) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void L(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.cN |= 0x20;
      return;
    }
    this.cN &= 0xFFFFFFDF;
  }
  
  public final void M(boolean paramBoolean)
  {
    AppMethodBeat.i(239580);
    this.nh = paramBoolean;
    this.is.H(false);
    AppMethodBeat.o(239580);
  }
  
  public final androidx.core.a.a.b a(androidx.core.g.b paramb)
  {
    AppMethodBeat.i(239571);
    if (this.nf != null)
    {
      androidx.core.g.b localb = this.nf;
      localb.MF = null;
      localb.MD = null;
    }
    this.ne = null;
    this.nf = paramb;
    this.is.H(true);
    if (this.nf != null) {
      this.nf.a(new b.b()
      {
        public final void cv()
        {
          AppMethodBeat.i(239458);
          j.this.is.cg();
          AppMethodBeat.o(239458);
        }
      });
    }
    AppMethodBeat.o(239571);
    return this;
  }
  
  final CharSequence a(p.a parama)
  {
    AppMethodBeat.i(239489);
    if (parama.bL())
    {
      parama = getTitleCondensed();
      AppMethodBeat.o(239489);
      return parama;
    }
    parama = getTitle();
    AppMethodBeat.o(239489);
    return parama;
  }
  
  public final androidx.core.a.a.b b(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239583);
    this.kX = paramCharSequence;
    this.is.H(false);
    AppMethodBeat.o(239583);
    return this;
  }
  
  public final void b(u paramu)
  {
    AppMethodBeat.i(239486);
    this.na = paramu;
    paramu.setHeaderTitle(getTitle());
    AppMethodBeat.o(239486);
  }
  
  public final androidx.core.g.b bI()
  {
    return this.nf;
  }
  
  public final androidx.core.a.a.b c(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239585);
    this.kY = paramCharSequence;
    this.is.H(false);
    AppMethodBeat.o(239585);
    return this;
  }
  
  public final boolean cm()
  {
    AppMethodBeat.i(239468);
    if ((this.kW != null) && (this.kW.onMenuItemClick(this)))
    {
      AppMethodBeat.o(239468);
      return true;
    }
    if (this.is.d(this.is, this))
    {
      AppMethodBeat.o(239468);
      return true;
    }
    if (this.nb != null)
    {
      this.nb.run();
      AppMethodBeat.o(239468);
      return true;
    }
    if (this.mIntent != null) {
      try
      {
        Context localContext = this.is.mContext;
        Object localObject = this.mIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "androidx/appcompat/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "androidx/appcompat/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(239468);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
    if ((this.nf != null) && (this.nf.cx()))
    {
      AppMethodBeat.o(239468);
      return true;
    }
    AppMethodBeat.o(239468);
    return false;
  }
  
  final char cn()
  {
    AppMethodBeat.i(239481);
    if (this.is.cc())
    {
      c = this.kS;
      AppMethodBeat.o(239481);
      return c;
    }
    char c = this.kQ;
    AppMethodBeat.o(239481);
    return c;
  }
  
  final boolean co()
  {
    AppMethodBeat.i(239483);
    if ((this.is.cd()) && (cn() != 0))
    {
      AppMethodBeat.o(239483);
      return true;
    }
    AppMethodBeat.o(239483);
    return false;
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(239575);
    if ((this.nd & 0x8) == 0)
    {
      AppMethodBeat.o(239575);
      return false;
    }
    if (this.ne == null)
    {
      AppMethodBeat.o(239575);
      return true;
    }
    if ((this.ng == null) || (this.ng.onMenuItemActionCollapse(this)))
    {
      boolean bool = this.is.g(this);
      AppMethodBeat.o(239575);
      return bool;
    }
    AppMethodBeat.o(239575);
    return false;
  }
  
  public final boolean cp()
  {
    return (this.cN & 0x4) != 0;
  }
  
  public final boolean cq()
  {
    return (this.cN & 0x20) == 32;
  }
  
  public final boolean cr()
  {
    return (this.nd & 0x1) == 1;
  }
  
  public final boolean cs()
  {
    return (this.nd & 0x2) == 2;
  }
  
  public final boolean ct()
  {
    return (this.nd & 0x4) == 4;
  }
  
  public final boolean cu()
  {
    AppMethodBeat.i(239579);
    if ((this.nd & 0x8) != 0)
    {
      if ((this.ne == null) && (this.nf != null)) {
        this.ne = this.nf.c(this);
      }
      if (this.ne != null)
      {
        AppMethodBeat.o(239579);
        return true;
      }
      AppMethodBeat.o(239579);
      return false;
    }
    AppMethodBeat.o(239579);
    return false;
  }
  
  public final boolean expandActionView()
  {
    AppMethodBeat.i(239573);
    if (!cu())
    {
      AppMethodBeat.o(239573);
      return false;
    }
    if ((this.ng == null) || (this.ng.onMenuItemActionExpand(this)))
    {
      boolean bool = this.is.f(this);
      AppMethodBeat.o(239573);
      return bool;
    }
    AppMethodBeat.o(239573);
    return false;
  }
  
  public final ActionProvider getActionProvider()
  {
    AppMethodBeat.i(239565);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    AppMethodBeat.o(239565);
    throw localUnsupportedOperationException;
  }
  
  public final View getActionView()
  {
    AppMethodBeat.i(239559);
    View localView;
    if (this.ne != null)
    {
      localView = this.ne;
      AppMethodBeat.o(239559);
      return localView;
    }
    if (this.nf != null)
    {
      this.ne = this.nf.c(this);
      localView = this.ne;
      AppMethodBeat.o(239559);
      return localView;
    }
    AppMethodBeat.o(239559);
    return null;
  }
  
  public final int getAlphabeticModifiers()
  {
    return this.kT;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.kS;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.kX;
  }
  
  public final int getGroupId()
  {
    return this.kM;
  }
  
  public final Drawable getIcon()
  {
    AppMethodBeat.i(239504);
    Drawable localDrawable;
    if (this.kU != null)
    {
      localDrawable = e(this.kU);
      AppMethodBeat.o(239504);
      return localDrawable;
    }
    if (this.kV != 0)
    {
      localDrawable = androidx.appcompat.a.a.a.m(this.is.mContext, this.kV);
      this.kV = 0;
      this.kU = localDrawable;
      localDrawable = e(localDrawable);
      AppMethodBeat.o(239504);
      return localDrawable;
    }
    AppMethodBeat.o(239504);
    return null;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.kZ;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.la;
  }
  
  public final Intent getIntent()
  {
    return this.mIntent;
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.ni;
  }
  
  public final int getNumericModifiers()
  {
    return this.kR;
  }
  
  public final char getNumericShortcut()
  {
    return this.kQ;
  }
  
  public final int getOrder()
  {
    return this.kN;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.na;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.cZ;
  }
  
  public final CharSequence getTitleCondensed()
  {
    AppMethodBeat.i(239499);
    if (this.kP != null) {}
    for (Object localObject = this.kP; (Build.VERSION.SDK_INT < 18) && (localObject != null) && (!(localObject instanceof String)); localObject = this.cZ)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(239499);
      return localObject;
    }
    AppMethodBeat.o(239499);
    return localObject;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.kY;
  }
  
  public final boolean hasSubMenu()
  {
    return this.na != null;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.nh;
  }
  
  public final boolean isCheckable()
  {
    return (this.cN & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.cN & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.cN & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(239535);
    if ((this.nf != null) && (this.nf.cy()))
    {
      if (((this.cN & 0x8) == 0) && (this.nf.isVisible()))
      {
        AppMethodBeat.o(239535);
        return true;
      }
      AppMethodBeat.o(239535);
      return false;
    }
    if ((this.cN & 0x8) == 0)
    {
      AppMethodBeat.o(239535);
      return true;
    }
    AppMethodBeat.o(239535);
    return false;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    AppMethodBeat.i(239562);
    paramActionProvider = new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    AppMethodBeat.o(239562);
    throw paramActionProvider;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    AppMethodBeat.i(239470);
    if (this.kS == paramChar)
    {
      AppMethodBeat.o(239470);
      return this;
    }
    this.kS = Character.toLowerCase(paramChar);
    this.is.H(false);
    AppMethodBeat.o(239470);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(239471);
    if ((this.kS == paramChar) && (this.kT == paramInt))
    {
      AppMethodBeat.o(239471);
      return this;
    }
    this.kS = Character.toLowerCase(paramChar);
    this.kT = KeyEvent.normalizeMetaState(paramInt);
    this.is.H(false);
    AppMethodBeat.o(239471);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(239525);
    int j = this.cN;
    int k = this.cN;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.cN = (i | k & 0xFFFFFFFE);
      if (j != this.cN) {
        this.is.H(false);
      }
      AppMethodBeat.o(239525);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(239531);
    if ((this.cN & 0x4) != 0)
    {
      h localh = this.is;
      int j = getGroupId();
      int k = localh.mItems.size();
      localh.ce();
      int i = 0;
      if (i < k)
      {
        j localj = (j)localh.mItems.get(i);
        if ((localj.getGroupId() == j) && (localj.cp()) && (localj.isCheckable())) {
          if (localj != this) {
            break label111;
          }
        }
        label111:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localj.J(paramBoolean);
          i += 1;
          break;
        }
      }
      localh.cf();
    }
    for (;;)
    {
      AppMethodBeat.o(239531);
      return this;
      J(paramBoolean);
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(239469);
    if (paramBoolean) {}
    for (this.cN |= 0x10;; this.cN &= 0xFFFFFFEF)
    {
      this.is.H(false);
      AppMethodBeat.o(239469);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    AppMethodBeat.i(239511);
    this.kU = null;
    this.kV = paramInt;
    this.nc = true;
    this.is.H(false);
    AppMethodBeat.o(239511);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239507);
    this.kV = 0;
    this.kU = paramDrawable;
    this.nc = true;
    this.is.H(false);
    AppMethodBeat.o(239507);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(239512);
    this.kZ = paramColorStateList;
    this.lb = true;
    this.nc = true;
    this.is.H(false);
    AppMethodBeat.o(239512);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(239518);
    this.la = paramMode;
    this.lc = true;
    this.nc = true;
    this.is.H(false);
    AppMethodBeat.o(239518);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    AppMethodBeat.i(239474);
    if (this.kQ == paramChar)
    {
      AppMethodBeat.o(239474);
      return this;
    }
    this.kQ = paramChar;
    this.is.H(false);
    AppMethodBeat.o(239474);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(239476);
    if ((this.kQ == paramChar) && (this.kR == paramInt))
    {
      AppMethodBeat.o(239476);
      return this;
    }
    this.kQ = paramChar;
    this.kR = KeyEvent.normalizeMetaState(paramInt);
    this.is.H(false);
    AppMethodBeat.o(239476);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.ng = paramOnActionExpandListener;
    return this;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.kW = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(239478);
    this.kQ = paramChar1;
    this.kS = Character.toLowerCase(paramChar2);
    this.is.H(false);
    AppMethodBeat.o(239478);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239479);
    this.kQ = paramChar1;
    this.kR = KeyEvent.normalizeMetaState(paramInt1);
    this.kS = Character.toLowerCase(paramChar2);
    this.kT = KeyEvent.normalizeMetaState(paramInt2);
    this.is.H(false);
    AppMethodBeat.o(239479);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    AppMethodBeat.i(239553);
    switch (paramInt & 0x3)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
      AppMethodBeat.o(239553);
      throw localIllegalArgumentException;
    }
    this.nd = paramInt;
    this.is.ch();
    AppMethodBeat.o(239553);
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    AppMethodBeat.i(239495);
    MenuItem localMenuItem = setTitle(this.is.mContext.getString(paramInt));
    AppMethodBeat.o(239495);
    return localMenuItem;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239493);
    this.cZ = paramCharSequence;
    this.is.H(false);
    if (this.na != null) {
      this.na.setHeaderTitle(paramCharSequence);
    }
    AppMethodBeat.o(239493);
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239502);
    this.kP = paramCharSequence;
    this.is.H(false);
    AppMethodBeat.o(239502);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(239538);
    if (K(paramBoolean)) {
      this.is.cg();
    }
    AppMethodBeat.o(239538);
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239540);
    if (this.cZ != null)
    {
      String str = this.cZ.toString();
      AppMethodBeat.o(239540);
      return str;
    }
    AppMethodBeat.o(239540);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.j
 * JD-Core Version:    0.7.0.1
 */