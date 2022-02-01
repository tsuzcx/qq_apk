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
  private int FV = 16;
  private CharSequence Hn;
  h aaQ;
  private final int aeE;
  private final int aeF;
  final int aeG;
  private CharSequence aeH;
  private char aeI;
  int aeJ = 4096;
  private char aeK;
  int aeL = 4096;
  private Drawable aeM;
  private int aeN = 0;
  private MenuItem.OnMenuItemClickListener aeO;
  private CharSequence aeP;
  private CharSequence aeQ;
  private ColorStateList aeR = null;
  private PorterDuff.Mode aeS = null;
  private boolean aeT = false;
  private boolean aeU = false;
  private u agN;
  private Runnable agO;
  private boolean agP = false;
  private int agQ = 0;
  private View agR;
  public android.support.v4.view.b agS;
  private MenuItem.OnActionExpandListener agT;
  private boolean agU = false;
  ContextMenu.ContextMenuInfo agV;
  private final int mId;
  private Intent mIntent;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.aaQ = paramh;
    this.mId = paramInt2;
    this.aeE = paramInt1;
    this.aeF = paramInt3;
    this.aeG = paramInt4;
    this.Hn = paramCharSequence;
    this.agQ = paramInt5;
  }
  
  static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private void ac(boolean paramBoolean)
  {
    int j = this.FV;
    int k = this.FV;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.FV = (i | k & 0xFFFFFFFD);
      if (j != this.FV) {
        this.aaQ.r(false);
      }
      return;
    }
  }
  
  private android.support.v4.a.a.b bc(View paramView)
  {
    this.agR = paramView;
    this.agS = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.aaQ.ie();
    return this;
  }
  
  private Drawable o(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.agP) {
        if (!this.aeT)
        {
          localDrawable = paramDrawable;
          if (!this.aeU) {}
        }
        else
        {
          localDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();
          if (this.aeT) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.aeR);
          }
          if (this.aeU) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.aeS);
          }
          this.agP = false;
        }
      }
    }
    return localDrawable;
  }
  
  public final android.support.v4.a.a.b a(android.support.v4.view.b paramb)
  {
    if (this.agS != null)
    {
      android.support.v4.view.b localb = this.agS;
      localb.Pp = null;
      localb.Po = null;
    }
    this.agR = null;
    this.agS = paramb;
    this.aaQ.r(true);
    if (this.agS != null) {
      this.agS.a(new b.b()
      {
        public final void fz()
        {
          j.this.aaQ.ic();
        }
      });
    }
    return this;
  }
  
  final CharSequence a(p.a parama)
  {
    if (parama.bC()) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final void ab(boolean paramBoolean)
  {
    int j = this.FV;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.FV = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean ad(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.FV;
    int k = this.FV;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.FV = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.FV) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void ae(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.FV |= 0x20;
      return;
    }
    this.FV &= 0xFFFFFFDF;
  }
  
  public final void af(boolean paramBoolean)
  {
    this.agU = paramBoolean;
    this.aaQ.r(false);
  }
  
  public final void b(u paramu)
  {
    this.agN = paramu;
    paramu.setHeaderTitle(getTitle());
  }
  
  public final boolean collapseActionView()
  {
    if ((this.agQ & 0x8) == 0) {}
    do
    {
      return false;
      if (this.agR == null) {
        return true;
      }
    } while ((this.agT != null) && (!this.agT.onMenuItemActionCollapse(this)));
    return this.aaQ.h(this);
  }
  
  public final android.support.v4.view.b eJ()
  {
    return this.agS;
  }
  
  public final boolean expandActionView()
  {
    if (!it()) {}
    while ((this.agT != null) && (!this.agT.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.aaQ.g(this);
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (this.agR != null) {
      return this.agR;
    }
    if (this.agS != null)
    {
      this.agR = this.agS.onCreateActionView(this);
      return this.agR;
    }
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
    if (this.aeM != null) {
      return o(this.aeM);
    }
    if (this.aeN != 0)
    {
      Drawable localDrawable = android.support.v7.c.a.a.l(this.aaQ.mContext, this.aeN);
      this.aeN = 0;
      this.aeM = localDrawable;
      return o(localDrawable);
    }
    return null;
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
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.agV;
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
    return this.aeF;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.agN;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.Hn;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.aeH != null) {}
    for (CharSequence localCharSequence = this.aeH;; localCharSequence = this.Hn)
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
    return this.aeQ;
  }
  
  public final boolean hasSubMenu()
  {
    return this.agN != null;
  }
  
  public final boolean ij()
  {
    if ((this.aeO != null) && (this.aeO.onMenuItemClick(this))) {
      return true;
    }
    if (this.aaQ.d(this.aaQ, this)) {
      return true;
    }
    if (this.agO != null)
    {
      this.agO.run();
      return true;
    }
    if (this.mIntent != null) {
      try
      {
        Context localContext = this.aaQ.mContext;
        Object localObject = this.mIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
    return (this.agS != null) && (this.agS.onPerformDefaultAction());
  }
  
  final char ik()
  {
    if (this.aaQ.hY()) {
      return this.aeK;
    }
    return this.aeI;
  }
  
  final String il()
  {
    char c = ik();
    if (c == 0) {
      return "";
    }
    Resources localResources = this.aaQ.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.aaQ.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131755115));
    }
    int i;
    if (this.aaQ.hY())
    {
      i = this.aeL;
      a(localStringBuilder, i, 65536, localResources.getString(2131755111));
      a(localStringBuilder, i, 4096, localResources.getString(2131755107));
      a(localStringBuilder, i, 2, localResources.getString(2131755106));
      a(localStringBuilder, i, 1, localResources.getString(2131755112));
      a(localStringBuilder, i, 4, localResources.getString(2131755114));
      a(localStringBuilder, i, 8, localResources.getString(2131755110));
      switch (c)
      {
      default: 
        localStringBuilder.append(c);
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      i = this.aeJ;
      break;
      localStringBuilder.append(localResources.getString(2131755109));
      continue;
      localStringBuilder.append(localResources.getString(2131755108));
      continue;
      localStringBuilder.append(localResources.getString(2131755113));
    }
  }
  
  final boolean im()
  {
    return (this.aaQ.hZ()) && (ik() != 0);
  }
  
  public final boolean in()
  {
    return (this.FV & 0x4) != 0;
  }
  
  public final boolean ip()
  {
    return (this.FV & 0x20) == 32;
  }
  
  public final boolean iq()
  {
    return (this.agQ & 0x1) == 1;
  }
  
  public final boolean ir()
  {
    return (this.agQ & 0x2) == 2;
  }
  
  public final boolean is()
  {
    return (this.agQ & 0x4) == 4;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.agU;
  }
  
  public final boolean isCheckable()
  {
    return (this.FV & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.FV & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.FV & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((this.agS != null) && (this.agS.overridesItemVisibility())) {
      if (((this.FV & 0x8) != 0) || (!this.agS.isVisible())) {}
    }
    while ((this.FV & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean it()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.agQ & 0x8) != 0)
    {
      if ((this.agR == null) && (this.agS != null)) {
        this.agR = this.agS.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.agR != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.aeP = paramCharSequence;
    this.aaQ.r(false);
    return this;
  }
  
  public final android.support.v4.a.a.b l(CharSequence paramCharSequence)
  {
    this.aeQ = paramCharSequence;
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.aeK == paramChar) {
      return this;
    }
    this.aeK = Character.toLowerCase(paramChar);
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.aeK == paramChar) && (this.aeL == paramInt)) {
      return this;
    }
    this.aeK = Character.toLowerCase(paramChar);
    this.aeL = KeyEvent.normalizeMetaState(paramInt);
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.FV;
    int k = this.FV;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.FV = (i | k & 0xFFFFFFFE);
      if (j != this.FV) {
        this.aaQ.r(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.FV & 0x4) != 0)
    {
      h localh = this.aaQ;
      int j = getGroupId();
      int k = localh.mItems.size();
      localh.ia();
      int i = 0;
      if (i < k)
      {
        j localj = (j)localh.mItems.get(i);
        if ((localj.getGroupId() == j) && (localj.in()) && (localj.isCheckable())) {
          if (localj != this) {
            break label105;
          }
        }
        label105:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localj.ac(paramBoolean);
          i += 1;
          break;
        }
      }
      localh.ib();
      return this;
    }
    ac(paramBoolean);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.FV |= 0x10;; this.FV &= 0xFFFFFFEF)
    {
      this.aaQ.r(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.aeM = null;
    this.aeN = paramInt;
    this.agP = true;
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.aeN = 0;
    this.aeM = paramDrawable;
    this.agP = true;
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.aeR = paramColorStateList;
    this.aeT = true;
    this.agP = true;
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.aeS = paramMode;
    this.aeU = true;
    this.agP = true;
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.aeI == paramChar) {
      return this;
    }
    this.aeI = paramChar;
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.aeI == paramChar) && (this.aeJ == paramInt)) {
      return this;
    }
    this.aeI = paramChar;
    this.aeJ = KeyEvent.normalizeMetaState(paramInt);
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.agT = paramOnActionExpandListener;
    return this;
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
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.aeI = paramChar1;
    this.aeJ = KeyEvent.normalizeMetaState(paramInt1);
    this.aeK = Character.toLowerCase(paramChar2);
    this.aeL = KeyEvent.normalizeMetaState(paramInt2);
    this.aaQ.r(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.agQ = paramInt;
    this.aaQ.ie();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.aaQ.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Hn = paramCharSequence;
    this.aaQ.r(false);
    if (this.agN != null) {
      this.agN.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.aeH = paramCharSequence;
    this.aaQ.r(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (ad(paramBoolean)) {
      this.aaQ.ic();
    }
    return this;
  }
  
  public final String toString()
  {
    if (this.Hn != null) {
      return this.Hn.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.j
 * JD-Core Version:    0.7.0.1
 */