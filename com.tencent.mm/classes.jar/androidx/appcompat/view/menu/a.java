package androidx.appcompat.view.menu;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements androidx.core.a.a.b
{
  private int cN = 16;
  private CharSequence cZ;
  private final int lI;
  private final int lJ;
  private final int lK;
  private CharSequence lL;
  private char lM;
  private int lN = 4096;
  private char lO;
  private int lP = 4096;
  private Drawable lQ;
  private int lR = 0;
  private MenuItem.OnMenuItemClickListener lS;
  private CharSequence lT;
  private CharSequence lU;
  private ColorStateList lV = null;
  private PorterDuff.Mode lW = null;
  private boolean lX = false;
  private boolean lY = false;
  private Context mContext;
  private final int mId;
  private Intent mIntent;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = 16908332;
    this.lI = 0;
    this.lJ = 0;
    this.lK = 0;
    this.cZ = paramCharSequence;
  }
  
  private void cC()
  {
    AppMethodBeat.i(201062);
    if ((this.lQ != null) && ((this.lX) || (this.lY)))
    {
      this.lQ = androidx.core.graphics.drawable.a.s(this.lQ);
      this.lQ = this.lQ.mutate();
      if (this.lX) {
        androidx.core.graphics.drawable.a.a(this.lQ, this.lV);
      }
      if (this.lY) {
        androidx.core.graphics.drawable.a.a(this.lQ, this.lW);
      }
    }
    AppMethodBeat.o(201062);
  }
  
  public final androidx.core.a.a.b a(androidx.core.g.b paramb)
  {
    AppMethodBeat.i(201366);
    paramb = new UnsupportedOperationException();
    AppMethodBeat.o(201366);
    throw paramb;
  }
  
  public final androidx.core.a.a.b b(CharSequence paramCharSequence)
  {
    this.lT = paramCharSequence;
    return this;
  }
  
  public final androidx.core.a.a.b c(CharSequence paramCharSequence)
  {
    this.lU = paramCharSequence;
    return this;
  }
  
  public final androidx.core.g.b cB()
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
    AppMethodBeat.i(201351);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(201351);
    throw localUnsupportedOperationException;
  }
  
  public final View getActionView()
  {
    return null;
  }
  
  public final int getAlphabeticModifiers()
  {
    return this.lP;
  }
  
  public final char getAlphabeticShortcut()
  {
    return this.lO;
  }
  
  public final CharSequence getContentDescription()
  {
    return this.lT;
  }
  
  public final int getGroupId()
  {
    return this.lI;
  }
  
  public final Drawable getIcon()
  {
    return this.lQ;
  }
  
  public final ColorStateList getIconTintList()
  {
    return this.lV;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.lW;
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
    return this.lN;
  }
  
  public final char getNumericShortcut()
  {
    return this.lM;
  }
  
  public final int getOrder()
  {
    return this.lK;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.cZ;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.lL != null) {
      return this.lL;
    }
    return this.cZ;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.lU;
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
    return (this.cN & 0x1) != 0;
  }
  
  public final boolean isChecked()
  {
    return (this.cN & 0x2) != 0;
  }
  
  public final boolean isEnabled()
  {
    return (this.cN & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    return (this.cN & 0x8) == 0;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    AppMethodBeat.i(201342);
    paramActionProvider = new UnsupportedOperationException();
    AppMethodBeat.o(201342);
    throw paramActionProvider;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    AppMethodBeat.i(201185);
    this.lO = Character.toLowerCase(paramChar);
    AppMethodBeat.o(201185);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(201195);
    this.lO = Character.toLowerCase(paramChar);
    this.lP = KeyEvent.normalizeMetaState(paramInt);
    AppMethodBeat.o(201195);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.cN;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.cN = (i | j & 0xFFFFFFFE);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    int j = this.cN;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.cN = (i | j & 0xFFFFFFFD);
      return this;
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    int j = this.cN;
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      this.cN = (i | j & 0xFFFFFFEF);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    AppMethodBeat.i(201238);
    this.lR = paramInt;
    this.lQ = androidx.core.content.a.m(this.mContext, paramInt);
    cC();
    AppMethodBeat.o(201238);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(201227);
    this.lQ = paramDrawable;
    this.lR = 0;
    cC();
    AppMethodBeat.o(201227);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(201421);
    this.lV = paramColorStateList;
    this.lX = true;
    cC();
    AppMethodBeat.o(201421);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(201431);
    this.lW = paramMode;
    this.lY = true;
    cC();
    AppMethodBeat.o(201431);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.lM = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(201261);
    this.lM = paramChar;
    this.lN = KeyEvent.normalizeMetaState(paramInt);
    AppMethodBeat.o(201261);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    AppMethodBeat.i(201390);
    paramOnActionExpandListener = new UnsupportedOperationException();
    AppMethodBeat.o(201390);
    throw paramOnActionExpandListener;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.lS = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(201278);
    this.lM = paramChar1;
    this.lO = Character.toLowerCase(paramChar2);
    AppMethodBeat.o(201278);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201292);
    this.lM = paramChar1;
    this.lN = KeyEvent.normalizeMetaState(paramInt1);
    this.lO = Character.toLowerCase(paramChar2);
    this.lP = KeyEvent.normalizeMetaState(paramInt2);
    AppMethodBeat.o(201292);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    AppMethodBeat.i(201306);
    this.cZ = this.mContext.getResources().getString(paramInt);
    AppMethodBeat.o(201306);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.cZ = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.lL = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    int j = this.cN;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.cN = (i | j & 0x8);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.a
 * JD-Core Version:    0.7.0.1
 */