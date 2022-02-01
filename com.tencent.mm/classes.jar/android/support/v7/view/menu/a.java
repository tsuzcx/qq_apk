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
  private int CW = 16;
  private CharSequence Eo;
  private final int abG;
  private final int abH;
  private final int abI;
  private CharSequence abJ;
  private char abK;
  private int abL = 4096;
  private char abM;
  private int abN = 4096;
  private Drawable abO;
  private int abP = 0;
  private MenuItem.OnMenuItemClickListener abQ;
  private CharSequence abR;
  private CharSequence abS;
  private ColorStateList abT = null;
  private PorterDuff.Mode abU = null;
  private boolean abV = false;
  private boolean abW = false;
  private Context mContext;
  private final int mId;
  private Intent mIntent;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = 16908332;
    this.abG = 0;
    this.abH = 0;
    this.abI = 0;
    this.Eo = paramCharSequence;
  }
  
  private void hc()
  {
    if ((this.abO != null) && ((this.abV) || (this.abW)))
    {
      this.abO = android.support.v4.graphics.drawable.a.i(this.abO);
      this.abO = this.abO.mutate();
      if (this.abV) {
        android.support.v4.graphics.drawable.a.a(this.abO, this.abT);
      }
      if (this.abW) {
        android.support.v4.graphics.drawable.a.a(this.abO, this.abU);
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
  
  public final android.support.v4.view.b eg()
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
    return this.abN;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.abM;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.abR;
  }
  
  public final int getGroupId()
  {
    return this.abG;
  }
  
  public final Drawable getIcon()
  {
    return this.abO;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.abT;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.abU;
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
    return this.abL;
  }
  
  public final char getNumericShortcut()
  {
    return this.abK;
  }
  
  public final int getOrder()
  {
    return this.abI;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.Eo;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.abJ != null) {
      return this.abJ;
    }
    return this.Eo;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.abS;
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
    return (this.CW & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.CW & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.CW & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.CW & 0x8) == 0;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.abR = paramCharSequence;
    return this;
  }
  
  public final android.support.v4.a.a.b l(CharSequence paramCharSequence)
  {
    this.abS = paramCharSequence;
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.abM = Character.toLowerCase(paramChar);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.abM = Character.toLowerCase(paramChar);
    this.abN = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.CW;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.CW = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.CW;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.CW = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.CW;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.CW = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.abP = paramInt;
    this.abO = android.support.v4.content.b.l(this.mContext, paramInt);
    hc();
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.abO = paramDrawable;
    this.abP = 0;
    hc();
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.abT = paramColorStateList;
    this.abV = true;
    hc();
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.abU = paramMode;
    this.abW = true;
    hc();
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.abK = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.abK = paramChar;
    this.abL = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.abQ = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.abK = paramChar1;
    this.abM = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.abK = paramChar1;
    this.abL = KeyEvent.normalizeMetaState(paramInt1);
    this.abM = Character.toLowerCase(paramChar2);
    this.abN = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.Eo = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Eo = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.abJ = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = this.CW;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.CW = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.a
 * JD-Core Version:    0.7.0.1
 */