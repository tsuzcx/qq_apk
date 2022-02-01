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
  private int CW = 16;
  private CharSequence Eo;
  h XT;
  private final int abG;
  private final int abH;
  final int abI;
  private CharSequence abJ;
  private char abK;
  int abL = 4096;
  private char abM;
  int abN = 4096;
  private Drawable abO;
  private int abP = 0;
  private MenuItem.OnMenuItemClickListener abQ;
  private CharSequence abR;
  private CharSequence abS;
  private ColorStateList abT = null;
  private PorterDuff.Mode abU = null;
  private boolean abV = false;
  private boolean abW = false;
  private u adP;
  private Runnable adQ;
  private boolean adR = false;
  private int adS = 0;
  private View adT;
  public android.support.v4.view.b adU;
  private MenuItem.OnActionExpandListener adV;
  private boolean adW = false;
  ContextMenu.ContextMenuInfo adX;
  private final int mId;
  private Intent mIntent;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.XT = paramh;
    this.mId = paramInt2;
    this.abG = paramInt1;
    this.abH = paramInt3;
    this.abI = paramInt4;
    this.Eo = paramCharSequence;
    this.adS = paramInt5;
  }
  
  static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private void ad(boolean paramBoolean)
  {
    int j = this.CW;
    int k = this.CW;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.CW = (i | k & 0xFFFFFFFD);
      if (j != this.CW) {
        this.XT.r(false);
      }
      return;
    }
  }
  
  private android.support.v4.a.a.b bb(View paramView)
  {
    this.adT = paramView;
    this.adU = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.XT.hw();
    return this;
  }
  
  private Drawable o(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.adR) {
        if (!this.abV)
        {
          localDrawable = paramDrawable;
          if (!this.abW) {}
        }
        else
        {
          localDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();
          if (this.abV) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.abT);
          }
          if (this.abW) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.abU);
          }
          this.adR = false;
        }
      }
    }
    return localDrawable;
  }
  
  public final android.support.v4.a.a.b a(android.support.v4.view.b paramb)
  {
    if (this.adU != null)
    {
      android.support.v4.view.b localb = this.adU;
      localb.Mp = null;
      localb.Mo = null;
    }
    this.adT = null;
    this.adU = paramb;
    this.XT.r(true);
    if (this.adU != null) {
      this.adU.a(new b.b()
      {
        public final void eU()
        {
          j.this.XT.hv();
        }
      });
    }
    return this;
  }
  
  final CharSequence a(p.a parama)
  {
    if (parama.be()) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final void ac(boolean paramBoolean)
  {
    int j = this.CW;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.CW = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean ae(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.CW;
    int k = this.CW;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.CW = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.CW) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void af(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.CW |= 0x20;
      return;
    }
    this.CW &= 0xFFFFFFDF;
  }
  
  public final void ag(boolean paramBoolean)
  {
    this.adW = paramBoolean;
    this.XT.r(false);
  }
  
  public final void b(u paramu)
  {
    this.adP = paramu;
    paramu.setHeaderTitle(getTitle());
  }
  
  public final boolean collapseActionView()
  {
    if ((this.adS & 0x8) == 0) {}
    do
    {
      return false;
      if (this.adT == null) {
        return true;
      }
    } while ((this.adV != null) && (!this.adV.onMenuItemActionCollapse(this)));
    return this.XT.h(this);
  }
  
  public final android.support.v4.view.b eg()
  {
    return this.adU;
  }
  
  public final boolean expandActionView()
  {
    if (!hK()) {}
    while ((this.adV != null) && (!this.adV.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.XT.g(this);
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (this.adT != null) {
      return this.adT;
    }
    if (this.adU != null)
    {
      this.adT = this.adU.onCreateActionView(this);
      return this.adT;
    }
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
    if (this.abO != null) {
      return o(this.abO);
    }
    if (this.abP != 0)
    {
      Drawable localDrawable = android.support.v7.c.a.a.l(this.XT.mContext, this.abP);
      this.abP = 0;
      this.abO = localDrawable;
      return o(localDrawable);
    }
    return null;
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
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.adX;
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
    return this.abH;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.adP;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.Eo;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.abJ != null) {}
    for (CharSequence localCharSequence = this.abJ;; localCharSequence = this.Eo)
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
    return this.abS;
  }
  
  public final boolean hB()
  {
    if ((this.abQ != null) && (this.abQ.onMenuItemClick(this))) {
      return true;
    }
    if (this.XT.d(this.XT, this)) {
      return true;
    }
    if (this.adQ != null)
    {
      this.adQ.run();
      return true;
    }
    if (this.mIntent != null) {
      try
      {
        Context localContext = this.XT.mContext;
        Object localObject = this.mIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
    return (this.adU != null) && (this.adU.onPerformDefaultAction());
  }
  
  final char hC()
  {
    if (this.XT.hr()) {
      return this.abM;
    }
    return this.abK;
  }
  
  final String hD()
  {
    char c = hC();
    if (c == 0) {
      return "";
    }
    Resources localResources = this.XT.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.XT.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131755102));
    }
    int i;
    if (this.XT.hr())
    {
      i = this.abN;
      a(localStringBuilder, i, 65536, localResources.getString(2131755098));
      a(localStringBuilder, i, 4096, localResources.getString(2131755094));
      a(localStringBuilder, i, 2, localResources.getString(2131755093));
      a(localStringBuilder, i, 1, localResources.getString(2131755099));
      a(localStringBuilder, i, 4, localResources.getString(2131755101));
      a(localStringBuilder, i, 8, localResources.getString(2131755097));
      switch (c)
      {
      default: 
        localStringBuilder.append(c);
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      i = this.abL;
      break;
      localStringBuilder.append(localResources.getString(2131755096));
      continue;
      localStringBuilder.append(localResources.getString(2131755095));
      continue;
      localStringBuilder.append(localResources.getString(2131755100));
    }
  }
  
  final boolean hE()
  {
    return (this.XT.hs()) && (hC() != 0);
  }
  
  public final boolean hF()
  {
    return (this.CW & 0x4) != 0;
  }
  
  public final boolean hG()
  {
    return (this.CW & 0x20) == 32;
  }
  
  public final boolean hH()
  {
    return (this.adS & 0x1) == 1;
  }
  
  public final boolean hI()
  {
    return (this.adS & 0x2) == 2;
  }
  
  public final boolean hJ()
  {
    return (this.adS & 0x4) == 4;
  }
  
  public final boolean hK()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.adS & 0x8) != 0)
    {
      if ((this.adT == null) && (this.adU != null)) {
        this.adT = this.adU.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.adT != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean hasSubMenu()
  {
    return this.adP != null;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.adW;
  }
  
  public final boolean isCheckable()
  {
    return (this.CW & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.CW & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.CW & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((this.adU != null) && (this.adU.overridesItemVisibility())) {
      if (((this.CW & 0x8) != 0) || (!this.adU.isVisible())) {}
    }
    while ((this.CW & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.abR = paramCharSequence;
    this.XT.r(false);
    return this;
  }
  
  public final android.support.v4.a.a.b l(CharSequence paramCharSequence)
  {
    this.abS = paramCharSequence;
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.abM == paramChar) {
      return this;
    }
    this.abM = Character.toLowerCase(paramChar);
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.abM == paramChar) && (this.abN == paramInt)) {
      return this;
    }
    this.abM = Character.toLowerCase(paramChar);
    this.abN = KeyEvent.normalizeMetaState(paramInt);
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.CW;
    int k = this.CW;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.CW = (i | k & 0xFFFFFFFE);
      if (j != this.CW) {
        this.XT.r(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.CW & 0x4) != 0)
    {
      h localh = this.XT;
      int j = getGroupId();
      int k = localh.mItems.size();
      localh.ht();
      int i = 0;
      if (i < k)
      {
        j localj = (j)localh.mItems.get(i);
        if ((localj.getGroupId() == j) && (localj.hF()) && (localj.isCheckable())) {
          if (localj != this) {
            break label105;
          }
        }
        label105:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localj.ad(paramBoolean);
          i += 1;
          break;
        }
      }
      localh.hu();
      return this;
    }
    ad(paramBoolean);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.CW |= 0x10;; this.CW &= 0xFFFFFFEF)
    {
      this.XT.r(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.abO = null;
    this.abP = paramInt;
    this.adR = true;
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.abP = 0;
    this.abO = paramDrawable;
    this.adR = true;
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.abT = paramColorStateList;
    this.abV = true;
    this.adR = true;
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.abU = paramMode;
    this.abW = true;
    this.adR = true;
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.abK == paramChar) {
      return this;
    }
    this.abK = paramChar;
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.abK == paramChar) && (this.abL == paramInt)) {
      return this;
    }
    this.abK = paramChar;
    this.abL = KeyEvent.normalizeMetaState(paramInt);
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.adV = paramOnActionExpandListener;
    return this;
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
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.abK = paramChar1;
    this.abL = KeyEvent.normalizeMetaState(paramInt1);
    this.abM = Character.toLowerCase(paramChar2);
    this.abN = KeyEvent.normalizeMetaState(paramInt2);
    this.XT.r(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.adS = paramInt;
    this.XT.hw();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.XT.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Eo = paramCharSequence;
    this.XT.r(false);
    if (this.adP != null) {
      this.adP.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.abJ = paramCharSequence;
    this.XT.r(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (ae(paramBoolean)) {
      this.XT.hv();
    }
    return this;
  }
  
  public final String toString()
  {
    if (this.Eo != null) {
      return this.Eo.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.j
 * JD-Core Version:    0.7.0.1
 */