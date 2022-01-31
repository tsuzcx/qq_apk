package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a
  implements android.support.v4.b.a.b
{
  private CharSequence BM;
  private final int TS;
  private final int TT;
  private final int TU;
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
  private ColorStateList dE = null;
  private Context mContext;
  private final int mId;
  private Intent mIntent;
  private int wg = 16;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = 16908332;
    this.TS = 0;
    this.TT = 0;
    this.TU = 0;
    this.BM = paramCharSequence;
  }
  
  private void eS()
  {
    if ((this.Ua != null) && ((this.Ug) || (this.Uh)))
    {
      this.Ua = android.support.v4.a.a.a.f(this.Ua);
      this.Ua = this.Ua.mutate();
      if (this.Ug) {
        android.support.v4.a.a.a.a(this.Ua, this.dE);
      }
      if (this.Uh) {
        android.support.v4.a.a.a.a(this.Ua, this.Uf);
      }
    }
  }
  
  public final android.support.v4.b.a.b a(android.support.v4.view.b paramb)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final android.support.v4.view.b cv()
  {
    return null;
  }
  
  public final boolean expandActionView()
  {
    return false;
  }
  
  public final android.support.v4.b.a.b g(CharSequence paramCharSequence)
  {
    this.Ud = paramCharSequence;
    return this;
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public final View getActionView()
  {
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
    return this.Ua;
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
  
  public final int getItemId()
  {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
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
    return this.TU;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.BM;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.TV != null) {
      return this.TV;
    }
    return this.BM;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.Ue;
  }
  
  public final android.support.v4.b.a.b h(CharSequence paramCharSequence)
  {
    this.Ue = paramCharSequence;
    return this;
  }
  
  public final boolean hasSubMenu()
  {
    return false;
  }
  
  public final boolean isActionViewExpanded()
  {
    return false;
  }
  
  public final boolean isCheckable()
  {
    return (this.wg & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.wg & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.wg & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.wg & 0x8) == 0;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.TY = Character.toLowerCase(paramChar);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.TY = Character.toLowerCase(paramChar);
    this.TZ = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.wg;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.wg = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.wg;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.wg = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.wg;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.wg = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.Ub = paramInt;
    this.Ua = android.support.v4.content.b.g(this.mContext, paramInt);
    eS();
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.Ua = paramDrawable;
    this.Ub = 0;
    eS();
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.dE = paramColorStateList;
    this.Ug = true;
    eS();
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.Uf = paramMode;
    this.Uh = true;
    eS();
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.TW = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.TW = paramChar;
    this.TX = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
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
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.TW = paramChar1;
    this.TX = KeyEvent.normalizeMetaState(paramInt1);
    this.TY = Character.toLowerCase(paramChar2);
    this.TZ = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.BM = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.BM = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.TV = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = this.wg;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.wg = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.a
 * JD-Core Version:    0.7.0.1
 */