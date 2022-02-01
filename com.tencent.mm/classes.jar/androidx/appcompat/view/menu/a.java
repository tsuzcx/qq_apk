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
  private final int kM;
  private final int kN;
  private final int kO;
  private CharSequence kP;
  private char kQ;
  private int kR = 4096;
  private char kS;
  private int kT = 4096;
  private Drawable kU;
  private int kV = 0;
  private MenuItem.OnMenuItemClickListener kW;
  private CharSequence kX;
  private CharSequence kY;
  private ColorStateList kZ = null;
  private PorterDuff.Mode la = null;
  private boolean lb = false;
  private boolean lc = false;
  private Context mContext;
  private final int mId;
  private Intent mIntent;
  
  public a(Context paramContext, CharSequence paramCharSequence)
  {
    this.mContext = paramContext;
    this.mId = 16908332;
    this.kM = 0;
    this.kN = 0;
    this.kO = 0;
    this.cZ = paramCharSequence;
  }
  
  private void bJ()
  {
    AppMethodBeat.i(239080);
    if ((this.kU != null) && ((this.lb) || (this.lc)))
    {
      this.kU = androidx.core.graphics.drawable.a.p(this.kU);
      this.kU = this.kU.mutate();
      if (this.lb) {
        androidx.core.graphics.drawable.a.a(this.kU, this.kZ);
      }
      if (this.lc) {
        androidx.core.graphics.drawable.a.a(this.kU, this.la);
      }
    }
    AppMethodBeat.o(239080);
  }
  
  public final androidx.core.a.a.b a(androidx.core.g.b paramb)
  {
    AppMethodBeat.i(239068);
    paramb = new UnsupportedOperationException();
    AppMethodBeat.o(239068);
    throw paramb;
  }
  
  public final androidx.core.a.a.b b(CharSequence paramCharSequence)
  {
    this.kX = paramCharSequence;
    return this;
  }
  
  public final androidx.core.g.b bI()
  {
    return null;
  }
  
  public final androidx.core.a.a.b c(CharSequence paramCharSequence)
  {
    this.kY = paramCharSequence;
    return this;
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
    AppMethodBeat.i(239064);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(239064);
    throw localUnsupportedOperationException;
  }
  
  public final View getActionView()
  {
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
    return this.kU;
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
    return this.kR;
  }
  
  public final char getNumericShortcut()
  {
    return this.kQ;
  }
  
  public final int getOrder()
  {
    return this.kO;
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
    if (this.kP != null) {
      return this.kP;
    }
    return this.cZ;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.kY;
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
    AppMethodBeat.i(239063);
    paramActionProvider = new UnsupportedOperationException();
    AppMethodBeat.o(239063);
    throw paramActionProvider;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    AppMethodBeat.i(239049);
    this.kS = Character.toLowerCase(paramChar);
    AppMethodBeat.o(239049);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(239051);
    this.kS = Character.toLowerCase(paramChar);
    this.kT = KeyEvent.normalizeMetaState(paramInt);
    AppMethodBeat.o(239051);
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
    AppMethodBeat.i(239056);
    this.kV = paramInt;
    this.kU = androidx.core.content.a.m(this.mContext, paramInt);
    bJ();
    AppMethodBeat.o(239056);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239054);
    this.kU = paramDrawable;
    this.kV = 0;
    bJ();
    AppMethodBeat.o(239054);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(239076);
    this.kZ = paramColorStateList;
    this.lb = true;
    bJ();
    AppMethodBeat.o(239076);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(239077);
    this.la = paramMode;
    this.lc = true;
    bJ();
    AppMethodBeat.o(239077);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    this.kQ = paramChar;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(239059);
    this.kQ = paramChar;
    this.kR = KeyEvent.normalizeMetaState(paramInt);
    AppMethodBeat.o(239059);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    AppMethodBeat.i(239072);
    paramOnActionExpandListener = new UnsupportedOperationException();
    AppMethodBeat.o(239072);
    throw paramOnActionExpandListener;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.kW = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(239060);
    this.kQ = paramChar1;
    this.kS = Character.toLowerCase(paramChar2);
    AppMethodBeat.o(239060);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239061);
    this.kQ = paramChar1;
    this.kR = KeyEvent.normalizeMetaState(paramInt1);
    this.kS = Character.toLowerCase(paramChar2);
    this.kT = KeyEvent.normalizeMetaState(paramInt2);
    AppMethodBeat.o(239061);
    return this;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setTitle(int paramInt)
  {
    AppMethodBeat.i(239062);
    this.cZ = this.mContext.getResources().getString(paramInt);
    AppMethodBeat.o(239062);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.cZ = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.kP = paramCharSequence;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.a
 * JD-Core Version:    0.7.0.1
 */