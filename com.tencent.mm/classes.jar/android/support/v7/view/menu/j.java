package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.b.b;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import java.util.ArrayList;

public final class j
  implements android.support.v4.a.a.b
{
  private CharSequence Cv;
  private final int UD;
  private final int UE;
  final int UF;
  private CharSequence UG;
  private char UH;
  int UI = 4096;
  private char UJ;
  int UK = 4096;
  private Drawable UL;
  private int UM = 0;
  private MenuItem.OnMenuItemClickListener UN;
  private CharSequence UO;
  private CharSequence UQ;
  private PorterDuff.Mode UR = null;
  private boolean US = false;
  private boolean UT = false;
  private u WJ;
  private Runnable WK;
  private boolean WL = false;
  private int WM = 0;
  private View WN;
  public android.support.v4.view.b WO;
  private MenuItem.OnActionExpandListener WP;
  private boolean WQ = false;
  ContextMenu.ContextMenuInfo WR;
  private ColorStateList eG = null;
  h eq;
  private final int mId;
  private Intent mIntent;
  private int wy = 16;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.eq = paramh;
    this.mId = paramInt2;
    this.UD = paramInt1;
    this.UE = paramInt3;
    this.UF = paramInt4;
    this.Cv = paramCharSequence;
    this.WM = paramInt5;
  }
  
  private void X(boolean paramBoolean)
  {
    int j = this.wy;
    int k = this.wy;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.wy = (i | k & 0xFFFFFFFD);
      if (j != this.wy) {
        this.eq.p(false);
      }
      return;
    }
  }
  
  static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private android.support.v4.a.a.b aV(View paramView)
  {
    this.WN = paramView;
    this.WO = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.eq.ga();
    return this;
  }
  
  private Drawable j(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.WL) {
        if (!this.US)
        {
          localDrawable = paramDrawable;
          if (!this.UT) {}
        }
        else
        {
          localDrawable = android.support.v4.graphics.drawable.a.e(paramDrawable).mutate();
          if (this.US) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.eG);
          }
          if (this.UT) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.UR);
          }
          this.WL = false;
        }
      }
    }
    return localDrawable;
  }
  
  public final void W(boolean paramBoolean)
  {
    int j = this.wy;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.wy = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean Y(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.wy;
    int k = this.wy;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.wy = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.wy) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void Z(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.wy |= 0x20;
      return;
    }
    this.wy &= 0xFFFFFFDF;
  }
  
  public final android.support.v4.a.a.b a(android.support.v4.view.b paramb)
  {
    if (this.WO != null)
    {
      android.support.v4.view.b localb = this.WO;
      localb.Fr = null;
      localb.Fq = null;
    }
    this.WN = null;
    this.WO = paramb;
    this.eq.p(true);
    if (this.WO != null) {
      this.WO.a(new b.b()
      {
        public final void dC()
        {
          j.this.eq.fZ();
        }
      });
    }
    return this;
  }
  
  final CharSequence a(p.a parama)
  {
    if (parama.aE()) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final void aa(boolean paramBoolean)
  {
    this.WQ = paramBoolean;
    this.eq.p(false);
  }
  
  public final void b(u paramu)
  {
    this.WJ = paramu;
    paramu.setHeaderTitle(getTitle());
  }
  
  public final android.support.v4.view.b cY()
  {
    return this.WO;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.WM & 0x8) == 0) {}
    do
    {
      return false;
      if (this.WN == null) {
        return true;
      }
    } while ((this.WP != null) && (!this.WP.onMenuItemActionCollapse(this)));
    return this.eq.h(this);
  }
  
  public final boolean expandActionView()
  {
    if (!gp()) {}
    while ((this.WP != null) && (!this.WP.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.eq.g(this);
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (this.WN != null) {
      return this.WN;
    }
    if (this.WO != null)
    {
      this.WN = this.WO.onCreateActionView(this);
      return this.WN;
    }
    return null;
  }
  
  public final int getAlphabeticModifiers()
  {
    return this.UK;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.UJ;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.UO;
  }
  
  public final int getGroupId()
  {
    return this.UD;
  }
  
  public final Drawable getIcon()
  {
    if (this.UL != null) {
      return j(this.UL);
    }
    if (this.UM != 0)
    {
      Drawable localDrawable = android.support.v7.c.a.a.k(this.eq.mContext, this.UM);
      this.UM = 0;
      this.UL = localDrawable;
      return j(localDrawable);
    }
    return null;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.eG;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.UR;
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
    return this.WR;
  }
  
  public final int getNumericModifiers()
  {
    return this.UI;
  }
  
  public final char getNumericShortcut()
  {
    return this.UH;
  }
  
  public final int getOrder()
  {
    return this.UE;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.WJ;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.Cv;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.UG != null) {}
    for (CharSequence localCharSequence = this.UG;; localCharSequence = this.Cv)
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
    return this.UQ;
  }
  
  public final boolean gg()
  {
    if ((this.UN != null) && (this.UN.onMenuItemClick(this))) {}
    do
    {
      do
      {
        return true;
      } while (this.eq.d(this.eq, this));
      if (this.WK != null)
      {
        this.WK.run();
        return true;
      }
      if (this.mIntent != null) {
        try
        {
          this.eq.mContext.startActivity(this.mIntent);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException) {}
      }
    } while ((this.WO != null) && (this.WO.onPerformDefaultAction()));
    return false;
  }
  
  final char gh()
  {
    if (this.eq.fV()) {
      return this.UJ;
    }
    return this.UH;
  }
  
  final String gi()
  {
    char c = gh();
    if (c == 0) {
      return "";
    }
    Resources localResources = this.eq.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.eq.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131296273));
    }
    int i;
    if (this.eq.fV())
    {
      i = this.UK;
      a(localStringBuilder, i, 65536, localResources.getString(2131296269));
      a(localStringBuilder, i, 4096, localResources.getString(2131296265));
      a(localStringBuilder, i, 2, localResources.getString(2131296264));
      a(localStringBuilder, i, 1, localResources.getString(2131296270));
      a(localStringBuilder, i, 4, localResources.getString(2131296272));
      a(localStringBuilder, i, 8, localResources.getString(2131296268));
      switch (c)
      {
      default: 
        localStringBuilder.append(c);
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      i = this.UI;
      break;
      localStringBuilder.append(localResources.getString(2131296267));
      continue;
      localStringBuilder.append(localResources.getString(2131296266));
      continue;
      localStringBuilder.append(localResources.getString(2131296271));
    }
  }
  
  final boolean gj()
  {
    return (this.eq.fW()) && (gh() != 0);
  }
  
  public final boolean gk()
  {
    return (this.wy & 0x4) != 0;
  }
  
  public final boolean gl()
  {
    return (this.wy & 0x20) == 32;
  }
  
  public final boolean gm()
  {
    return (this.WM & 0x1) == 1;
  }
  
  public final boolean gn()
  {
    return (this.WM & 0x2) == 2;
  }
  
  public final boolean go()
  {
    return (this.WM & 0x4) == 4;
  }
  
  public final boolean gp()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.WM & 0x8) != 0)
    {
      if ((this.WN == null) && (this.WO != null)) {
        this.WN = this.WO.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.WN != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean hasSubMenu()
  {
    return this.WJ != null;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.WQ;
  }
  
  public final boolean isCheckable()
  {
    return (this.wy & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.wy & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.wy & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((this.WO != null) && (this.WO.overridesItemVisibility())) {
      if (((this.wy & 0x8) != 0) || (!this.WO.isVisible())) {}
    }
    while ((this.wy & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final android.support.v4.a.a.b j(CharSequence paramCharSequence)
  {
    this.UO = paramCharSequence;
    this.eq.p(false);
    return this;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.UQ = paramCharSequence;
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.UJ == paramChar) {
      return this;
    }
    this.UJ = Character.toLowerCase(paramChar);
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.UJ == paramChar) && (this.UK == paramInt)) {
      return this;
    }
    this.UJ = Character.toLowerCase(paramChar);
    this.UK = KeyEvent.normalizeMetaState(paramInt);
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.wy;
    int k = this.wy;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.wy = (i | k & 0xFFFFFFFE);
      if (j != this.wy) {
        this.eq.p(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.wy & 0x4) != 0)
    {
      h localh = this.eq;
      int j = getGroupId();
      int k = localh.mItems.size();
      localh.fX();
      int i = 0;
      if (i < k)
      {
        j localj = (j)localh.mItems.get(i);
        if ((localj.getGroupId() == j) && (localj.gk()) && (localj.isCheckable())) {
          if (localj != this) {
            break label105;
          }
        }
        label105:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localj.X(paramBoolean);
          i += 1;
          break;
        }
      }
      localh.fY();
      return this;
    }
    X(paramBoolean);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.wy |= 0x10;; this.wy &= 0xFFFFFFEF)
    {
      this.eq.p(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.UL = null;
    this.UM = paramInt;
    this.WL = true;
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.UM = 0;
    this.UL = paramDrawable;
    this.WL = true;
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.eG = paramColorStateList;
    this.US = true;
    this.WL = true;
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.UR = paramMode;
    this.UT = true;
    this.WL = true;
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.UH == paramChar) {
      return this;
    }
    this.UH = paramChar;
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.UH == paramChar) && (this.UI == paramInt)) {
      return this;
    }
    this.UH = paramChar;
    this.UI = KeyEvent.normalizeMetaState(paramInt);
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.WP = paramOnActionExpandListener;
    return this;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.UN = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.UH = paramChar1;
    this.UJ = Character.toLowerCase(paramChar2);
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.UH = paramChar1;
    this.UI = KeyEvent.normalizeMetaState(paramInt1);
    this.UJ = Character.toLowerCase(paramChar2);
    this.UK = KeyEvent.normalizeMetaState(paramInt2);
    this.eq.p(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.WM = paramInt;
    this.eq.ga();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.eq.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Cv = paramCharSequence;
    this.eq.p(false);
    if (this.WJ != null) {
      this.WJ.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.UG = paramCharSequence;
    this.eq.p(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (Y(paramBoolean)) {
      this.eq.fZ();
    }
    return this;
  }
  
  public final String toString()
  {
    if (this.Cv != null) {
      return this.Cv.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.j
 * JD-Core Version:    0.7.0.1
 */