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
  private CharSequence Cv;
  private final int UD;
  private final int UE;
  private final int UF;
  private CharSequence UG;
  private char UH;
  private int UI = 4096;
  private char UJ;
  private int UK = 4096;
  private Drawable UL;
  private int UM = 0;
  private MenuItem.OnMenuItemClickListener UN;
  private CharSequence UO;
  private CharSequence UQ;
  private PorterDuff.Mode UR = null;
  private boolean US = false;
  private boolean UT = false;
  private ColorStateList eG = null;
  private Context mContext;
  private final int mId;
  private Intent mIntent;
  private int wy = 16;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = 16908332;
    this.UD = 0;
    this.UE = 0;
    this.UF = 0;
    this.Cv = paramCharSequence;
  }
  
  private void fG()
  {
    if ((this.UL != null) && ((this.US) || (this.UT)))
    {
      this.UL = android.support.v4.graphics.drawable.a.e(this.UL);
      this.UL = this.UL.mutate();
      if (this.US) {
        android.support.v4.graphics.drawable.a.a(this.UL, this.eG);
      }
      if (this.UT) {
        android.support.v4.graphics.drawable.a.a(this.UL, this.UR);
      }
    }
  }
  
  public final android.support.v4.a.a.b a(android.support.v4.view.b paramb)
  {
    throw new UnsupportedOperationException();
  }
  
  public final android.support.v4.view.b cY()
  {
    return null;
  }
  
  public final boolean collapseActionView()
  {
    return false;
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
    return this.UL;
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
    return this.UI;
  }
  
  public final char getNumericShortcut()
  {
    return this.UH;
  }
  
  public final int getOrder()
  {
    return this.UF;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.Cv;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.UG != null) {
      return this.UG;
    }
    return this.Cv;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.UQ;
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
    return (this.wy & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.wy & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.wy & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.wy & 0x8) == 0;
  }
  
  public final android.support.v4.a.a.b j(CharSequence paramCharSequence)
  {
    this.UO = paramCharSequence;
    return this;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.UQ = paramCharSequence;
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.UJ = Character.toLowerCase(paramChar);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.UJ = Character.toLowerCase(paramChar);
    this.UK = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.wy;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.wy = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.wy;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.wy = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.wy;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.wy = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.UM = paramInt;
    this.UL = android.support.v4.content.b.k(this.mContext, paramInt);
    fG();
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.UL = paramDrawable;
    this.UM = 0;
    fG();
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.eG = paramColorStateList;
    this.US = true;
    fG();
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.UR = paramMode;
    this.UT = true;
    fG();
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.UH = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.UH = paramChar;
    this.UI = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
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
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.UH = paramChar1;
    this.UI = KeyEvent.normalizeMetaState(paramInt1);
    this.UJ = Character.toLowerCase(paramChar2);
    this.UK = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    this.Cv = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Cv = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.UG = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = this.wy;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.wy = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.a
 * JD-Core Version:    0.7.0.1
 */