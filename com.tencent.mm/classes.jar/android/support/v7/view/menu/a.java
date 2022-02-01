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
  private int FV = 16;
  private CharSequence Hn;
  private final int aeE;
  private final int aeF;
  private final int aeG;
  private CharSequence aeH;
  private char aeI;
  private int aeJ = 4096;
  private char aeK;
  private int aeL = 4096;
  private Drawable aeM;
  private int aeN = 0;
  private MenuItem.OnMenuItemClickListener aeO;
  private CharSequence aeP;
  private CharSequence aeQ;
  private ColorStateList aeR = null;
  private PorterDuff.Mode aeS = null;
  private boolean aeT = false;
  private boolean aeU = false;
  private Context mContext;
  private final int mId;
  private Intent mIntent;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = 16908332;
    this.aeE = 0;
    this.aeF = 0;
    this.aeG = 0;
    this.Hn = paramCharSequence;
  }
  
  private void hJ()
  {
    if ((this.aeM != null) && ((this.aeT) || (this.aeU)))
    {
      this.aeM = android.support.v4.graphics.drawable.a.i(this.aeM);
      this.aeM = this.aeM.mutate();
      if (this.aeT) {
        android.support.v4.graphics.drawable.a.a(this.aeM, this.aeR);
      }
      if (this.aeU) {
        android.support.v4.graphics.drawable.a.a(this.aeM, this.aeS);
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
  
  public final android.support.v4.view.b eJ()
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
    return this.aeL;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.aeK;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.aeP;
  }
  
  public final int getGroupId()
  {
    return this.aeE;
  }
  
  public final Drawable getIcon()
  {
    return this.aeM;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.aeR;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.aeS;
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
    return this.aeJ;
  }
  
  public final char getNumericShortcut()
  {
    return this.aeI;
  }
  
  public final int getOrder()
  {
    return this.aeG;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.Hn;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.aeH != null) {
      return this.aeH;
    }
    return this.Hn;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.aeQ;
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
    return (this.FV & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.FV & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.FV & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.FV & 0x8) == 0;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.aeP = paramCharSequence;
    return this;
  }
  
  public final android.support.v4.a.a.b l(CharSequence paramCharSequence)
  {
    this.aeQ = paramCharSequence;
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.aeK = Character.toLowerCase(paramChar);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.aeK = Character.toLowerCase(paramChar);
    this.aeL = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.FV;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.FV = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.FV;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.FV = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.FV;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.FV = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.aeN = paramInt;
    this.aeM = android.support.v4.content.b.l(this.mContext, paramInt);
    hJ();
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.aeM = paramDrawable;
    this.aeN = 0;
    hJ();
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.aeR = paramColorStateList;
    this.aeT = true;
    hJ();
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.aeS = paramMode;
    this.aeU = true;
    hJ();
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.aeI = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.aeI = paramChar;
    this.aeJ = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.aeO = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.aeI = paramChar1;
    this.aeK = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.aeI = paramChar1;
    this.aeJ = KeyEvent.normalizeMetaState(paramInt1);
    this.aeK = Character.toLowerCase(paramChar2);
    this.aeL = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.Hn = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Hn = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.aeH = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = this.FV;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.FV = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.a
 * JD-Core Version:    0.7.0.1
 */