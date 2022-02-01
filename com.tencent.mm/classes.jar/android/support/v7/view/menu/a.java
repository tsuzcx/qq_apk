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
  private int FL = 16;
  private CharSequence Hd;
  private int aeA = 0;
  private MenuItem.OnMenuItemClickListener aeB;
  private CharSequence aeC;
  private CharSequence aeD;
  private ColorStateList aeE = null;
  private PorterDuff.Mode aeF = null;
  private boolean aeG = false;
  private boolean aeH = false;
  private final int aer;
  private final int aes;
  private final int aet;
  private CharSequence aeu;
  private char aev;
  private int aew = 4096;
  private char aex;
  private int aey = 4096;
  private Drawable aez;
  private Context mContext;
  private final int mId;
  private Intent mIntent;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = 16908332;
    this.aer = 0;
    this.aes = 0;
    this.aet = 0;
    this.Hd = paramCharSequence;
  }
  
  private void hA()
  {
    if ((this.aez != null) && ((this.aeG) || (this.aeH)))
    {
      this.aez = android.support.v4.graphics.drawable.a.i(this.aez);
      this.aez = this.aez.mutate();
      if (this.aeG) {
        android.support.v4.graphics.drawable.a.a(this.aez, this.aeE);
      }
      if (this.aeH) {
        android.support.v4.graphics.drawable.a.a(this.aez, this.aeF);
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
  
  public final android.support.v4.view.b eF()
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
    return this.aey;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.aex;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.aeC;
  }
  
  public final int getGroupId()
  {
    return this.aer;
  }
  
  public final Drawable getIcon()
  {
    return this.aez;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.aeE;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.aeF;
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
    return this.aew;
  }
  
  public final char getNumericShortcut()
  {
    return this.aev;
  }
  
  public final int getOrder()
  {
    return this.aet;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.Hd;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.aeu != null) {
      return this.aeu;
    }
    return this.Hd;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.aeD;
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
    return (this.FL & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.FL & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.FL & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.FL & 0x8) == 0;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.aeC = paramCharSequence;
    return this;
  }
  
  public final android.support.v4.a.a.b l(CharSequence paramCharSequence)
  {
    this.aeD = paramCharSequence;
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.aex = Character.toLowerCase(paramChar);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.aex = Character.toLowerCase(paramChar);
    this.aey = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.FL;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.FL = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.FL;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.FL = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.FL;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.FL = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.aeA = paramInt;
    this.aez = android.support.v4.content.b.l(this.mContext, paramInt);
    hA();
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.aez = paramDrawable;
    this.aeA = 0;
    hA();
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.aeE = paramColorStateList;
    this.aeG = true;
    hA();
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.aeF = paramMode;
    this.aeH = true;
    hA();
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.aev = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.aev = paramChar;
    this.aew = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.aeB = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.aev = paramChar1;
    this.aex = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.aev = paramChar1;
    this.aew = KeyEvent.normalizeMetaState(paramInt1);
    this.aex = Character.toLowerCase(paramChar2);
    this.aey = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.Hd = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Hd = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.aeu = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = this.FL;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.FL = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.a
 * JD-Core Version:    0.7.0.1
 */