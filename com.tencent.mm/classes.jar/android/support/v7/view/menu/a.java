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
  implements android.support.v4.a.a.b
{
  private int DU = 16;
  private CharSequence Fm;
  private final int acA;
  private final int acB;
  private final int acC;
  private CharSequence acD;
  private char acE;
  private int acF = 4096;
  private char acG;
  private int acH = 4096;
  private Drawable acI;
  private int acJ = 0;
  private MenuItem.OnMenuItemClickListener acK;
  private CharSequence acL;
  private CharSequence acM;
  private ColorStateList acN = null;
  private PorterDuff.Mode acO = null;
  private boolean acP = false;
  private boolean acQ = false;
  private Context mContext;
  private final int mId;
  private Intent mIntent;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = 16908332;
    this.acA = 0;
    this.acB = 0;
    this.acC = 0;
    this.Fm = paramCharSequence;
  }
  
  private void hk()
  {
    if ((this.acI != null) && ((this.acP) || (this.acQ)))
    {
      this.acI = android.support.v4.graphics.drawable.a.i(this.acI);
      this.acI = this.acI.mutate();
      if (this.acP) {
        android.support.v4.graphics.drawable.a.a(this.acI, this.acN);
      }
      if (this.acQ) {
        android.support.v4.graphics.drawable.a.a(this.acI, this.acO);
      }
    }
  }
  
  public final android.support.v4.a.a.b a(android.support.v4.view.b paramb)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final android.support.v4.view.b eo()
  {
    return null;
  }
  
  public final boolean expandActionView()
  {
    return false;
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
    return this.acH;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.acG;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.acL;
  }
  
  public final int getGroupId()
  {
    return this.acA;
  }
  
  public final Drawable getIcon()
  {
    return this.acI;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.acN;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.acO;
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
    return this.acF;
  }
  
  public final char getNumericShortcut()
  {
    return this.acE;
  }
  
  public final int getOrder()
  {
    return this.acC;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.Fm;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.acD != null) {
      return this.acD;
    }
    return this.Fm;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.acM;
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
    return (this.DU & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.DU & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.DU & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.DU & 0x8) == 0;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.acL = paramCharSequence;
    return this;
  }
  
  public final android.support.v4.a.a.b l(CharSequence paramCharSequence)
  {
    this.acM = paramCharSequence;
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.acG = Character.toLowerCase(paramChar);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.acG = Character.toLowerCase(paramChar);
    this.acH = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.DU;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.DU = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.DU;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.DU = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.DU;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.DU = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.acJ = paramInt;
    this.acI = android.support.v4.content.b.l(this.mContext, paramInt);
    hk();
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.acI = paramDrawable;
    this.acJ = 0;
    hk();
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.acN = paramColorStateList;
    this.acP = true;
    hk();
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.acO = paramMode;
    this.acQ = true;
    hk();
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.acE = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.acE = paramChar;
    this.acF = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.acK = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.acE = paramChar1;
    this.acG = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.acE = paramChar1;
    this.acF = KeyEvent.normalizeMetaState(paramInt1);
    this.acG = Character.toLowerCase(paramChar2);
    this.acH = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.Fm = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Fm = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.acD = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = this.DU;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.DU = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.a
 * JD-Core Version:    0.7.0.1
 */