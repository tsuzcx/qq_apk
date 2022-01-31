package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.a.a.a;
import android.support.v4.view.b.b;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import java.util.ArrayList;

public final class j
  implements android.support.v4.b.a.b
{
  static String Wc;
  static String Wd;
  static String We;
  static String Wf;
  private CharSequence BM;
  private final int TS;
  private final int TT;
  final int TU;
  private CharSequence TV;
  private char TW;
  private int TX = 4096;
  private char TY;
  private int TZ = 4096;
  private Drawable Ua;
  private int Ub = 0;
  private MenuItem.OnMenuItemClickListener Uc;
  private CharSequence Ud;
  private CharSequence Ue;
  private PorterDuff.Mode Uf = null;
  private boolean Ug = false;
  private boolean Uh = false;
  private u VT;
  private Runnable VU;
  private boolean VV = false;
  int VW = 0;
  private View VX;
  public android.support.v4.view.b VY;
  private MenuItem.OnActionExpandListener VZ;
  private boolean Wa = false;
  ContextMenu.ContextMenuInfo Wb;
  private ColorStateList dE = null;
  h dm;
  private final int mId;
  private Intent mIntent;
  private int wg = 16;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.dm = paramh;
    this.mId = paramInt2;
    this.TS = paramInt1;
    this.TT = paramInt3;
    this.TU = paramInt4;
    this.BM = paramCharSequence;
    this.VW = paramInt5;
  }
  
  private void V(boolean paramBoolean)
  {
    int j = this.wg;
    int k = this.wg;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.wg = (i | k & 0xFFFFFFFD);
      if (j != this.wg) {
        this.dm.q(false);
      }
      return;
    }
  }
  
  private android.support.v4.b.a.b aN(View paramView)
  {
    this.VX = paramView;
    this.VY = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.dm.fk();
    return this;
  }
  
  private Drawable i(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.VV) {
        if (!this.Ug)
        {
          localDrawable = paramDrawable;
          if (!this.Uh) {}
        }
        else
        {
          localDrawable = a.f(paramDrawable).mutate();
          if (this.Ug) {
            a.a(localDrawable, this.dE);
          }
          if (this.Uh) {
            a.a(localDrawable, this.Uf);
          }
          this.VV = false;
        }
      }
    }
    return localDrawable;
  }
  
  public final void U(boolean paramBoolean)
  {
    int j = this.wg;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.wg = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean W(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.wg;
    int k = this.wg;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.wg = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.wg) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void X(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.wg |= 0x20;
      return;
    }
    this.wg &= 0xFFFFFFDF;
  }
  
  public final void Y(boolean paramBoolean)
  {
    this.Wa = paramBoolean;
    this.dm.q(false);
  }
  
  public final android.support.v4.b.a.b a(android.support.v4.view.b paramb)
  {
    if (this.VY != null)
    {
      android.support.v4.view.b localb = this.VY;
      localb.EI = null;
      localb.EH = null;
    }
    this.VX = null;
    this.VY = paramb;
    this.dm.q(true);
    if (this.VY != null) {
      this.VY.a(new b.b()
      {
        public final void dg()
        {
          j.this.dm.fj();
        }
      });
    }
    return this;
  }
  
  final CharSequence a(p.a parama)
  {
    if ((parama != null) && (parama.T())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final void b(u paramu)
  {
    this.VT = paramu;
    paramu.setHeaderTitle(getTitle());
  }
  
  public final boolean collapseActionView()
  {
    if ((this.VW & 0x8) == 0) {}
    do
    {
      return false;
      if (this.VX == null) {
        return true;
      }
    } while ((this.VZ != null) && (!this.VZ.onMenuItemActionCollapse(this)));
    return this.dm.h(this);
  }
  
  public final android.support.v4.view.b cv()
  {
    return this.VY;
  }
  
  public final boolean expandActionView()
  {
    if (!fw()) {}
    while ((this.VZ != null) && (!this.VZ.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.dm.g(this);
  }
  
  public final boolean fp()
  {
    if ((this.Uc != null) && (this.Uc.onMenuItemClick(this))) {}
    do
    {
      do
      {
        return true;
      } while (this.dm.d(this.dm, this));
      if (this.VU != null)
      {
        this.VU.run();
        return true;
      }
      if (this.mIntent != null) {
        try
        {
          this.dm.mContext.startActivity(this.mIntent);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException) {}
      }
    } while ((this.VY != null) && (this.VY.onPerformDefaultAction()));
    return false;
  }
  
  final char fq()
  {
    if (this.dm.ff()) {
      return this.TY;
    }
    return this.TW;
  }
  
  final boolean fr()
  {
    return (this.dm.fg()) && (fq() != 0);
  }
  
  public final boolean fs()
  {
    return (this.wg & 0x4) != 0;
  }
  
  public final boolean ft()
  {
    return (this.wg & 0x20) == 32;
  }
  
  public final boolean fu()
  {
    return (this.VW & 0x1) == 1;
  }
  
  public final boolean fv()
  {
    return (this.VW & 0x2) == 2;
  }
  
  public final boolean fw()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.VW & 0x8) != 0)
    {
      if ((this.VX == null) && (this.VY != null)) {
        this.VX = this.VY.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.VX != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final android.support.v4.b.a.b g(CharSequence paramCharSequence)
  {
    this.Ud = paramCharSequence;
    this.dm.q(false);
    return this;
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (this.VX != null) {
      return this.VX;
    }
    if (this.VY != null)
    {
      this.VX = this.VY.onCreateActionView(this);
      return this.VX;
    }
    return null;
  }
  
  public final int getAlphabeticModifiers()
  {
    return this.TZ;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.TY;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.Ud;
  }
  
  public final int getGroupId()
  {
    return this.TS;
  }
  
  public final Drawable getIcon()
  {
    if (this.Ua != null) {
      return i(this.Ua);
    }
    if (this.Ub != 0)
    {
      Drawable localDrawable = android.support.v7.c.a.b.g(this.dm.mContext, this.Ub);
      this.Ub = 0;
      this.Ua = localDrawable;
      return i(localDrawable);
    }
    return null;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.dE;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.Uf;
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
    return this.Wb;
  }
  
  public final int getNumericModifiers()
  {
    return this.TX;
  }
  
  public final char getNumericShortcut()
  {
    return this.TW;
  }
  
  public final int getOrder()
  {
    return this.TT;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.VT;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.BM;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.TV != null) {}
    for (CharSequence localCharSequence = this.TV;; localCharSequence = this.BM)
    {
      Object localObject = localCharSequence;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = localCharSequence;
        if (localCharSequence != null)
        {
          localObject = localCharSequence;
          if (!(localCharSequence instanceof String)) {
            localObject = localCharSequence.toString();
          }
        }
      }
      return localObject;
    }
  }
  
  public final CharSequence getTooltipText()
  {
    return this.Ue;
  }
  
  public final android.support.v4.b.a.b h(CharSequence paramCharSequence)
  {
    this.Ue = paramCharSequence;
    this.dm.q(false);
    return this;
  }
  
  public final boolean hasSubMenu()
  {
    return this.VT != null;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.Wa;
  }
  
  public final boolean isCheckable()
  {
    return (this.wg & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.wg & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.wg & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((this.VY != null) && (this.VY.overridesItemVisibility())) {
      if (((this.wg & 0x8) != 0) || (!this.VY.isVisible())) {}
    }
    while ((this.wg & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.TY == paramChar) {
      return this;
    }
    this.TY = Character.toLowerCase(paramChar);
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.TY == paramChar) && (this.TZ == paramInt)) {
      return this;
    }
    this.TY = Character.toLowerCase(paramChar);
    this.TZ = KeyEvent.normalizeMetaState(paramInt);
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.wg;
    int k = this.wg;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.wg = (i | k & 0xFFFFFFFE);
      if (j != this.wg) {
        this.dm.q(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.wg & 0x4) != 0)
    {
      h localh = this.dm;
      int j = getGroupId();
      int k = localh.dU.size();
      localh.fh();
      int i = 0;
      if (i < k)
      {
        j localj = (j)localh.dU.get(i);
        if ((localj.getGroupId() == j) && (localj.fs()) && (localj.isCheckable())) {
          if (localj != this) {
            break label105;
          }
        }
        label105:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localj.V(paramBoolean);
          i += 1;
          break;
        }
      }
      localh.fi();
      return this;
    }
    V(paramBoolean);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.wg |= 0x10;; this.wg &= 0xFFFFFFEF)
    {
      this.dm.q(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.Ua = null;
    this.Ub = paramInt;
    this.VV = true;
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.Ub = 0;
    this.Ua = paramDrawable;
    this.VV = true;
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.dE = paramColorStateList;
    this.Ug = true;
    this.VV = true;
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.Uf = paramMode;
    this.Uh = true;
    this.VV = true;
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.TW == paramChar) {
      return this;
    }
    this.TW = paramChar;
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.TW == paramChar) && (this.TX == paramInt)) {
      return this;
    }
    this.TW = paramChar;
    this.TX = KeyEvent.normalizeMetaState(paramInt);
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.VZ = paramOnActionExpandListener;
    return this;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.Uc = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.TW = paramChar1;
    this.TY = Character.toLowerCase(paramChar2);
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.TW = paramChar1;
    this.TX = KeyEvent.normalizeMetaState(paramInt1);
    this.TY = Character.toLowerCase(paramChar2);
    this.TZ = KeyEvent.normalizeMetaState(paramInt2);
    this.dm.q(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.VW = paramInt;
    this.dm.fk();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.dm.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.BM = paramCharSequence;
    this.dm.q(false);
    if (this.VT != null) {
      this.VT.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.TV = paramCharSequence;
    this.dm.q(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (W(paramBoolean)) {
      this.dm.fj();
    }
    return this;
  }
  
  public final String toString()
  {
    if (this.BM != null) {
      return this.BM.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.j
 * JD-Core Version:    0.7.0.1
 */