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
  private int DU = 16;
  private CharSequence Fm;
  h YO;
  private final int acA;
  private final int acB;
  final int acC;
  private CharSequence acD;
  private char acE;
  int acF = 4096;
  private char acG;
  int acH = 4096;
  private Drawable acI;
  private int acJ = 0;
  private MenuItem.OnMenuItemClickListener acK;
  private CharSequence acL;
  private CharSequence acM;
  private ColorStateList acN = null;
  private PorterDuff.Mode acO = null;
  private boolean acP = false;
  private boolean acQ = false;
  private u aeJ;
  private Runnable aeK;
  private boolean aeL = false;
  private int aeM = 0;
  private View aeN;
  public android.support.v4.view.b aeO;
  private MenuItem.OnActionExpandListener aeP;
  private boolean aeQ = false;
  ContextMenu.ContextMenuInfo aeR;
  private final int mId;
  private Intent mIntent;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.YO = paramh;
    this.mId = paramInt2;
    this.acA = paramInt1;
    this.acB = paramInt3;
    this.acC = paramInt4;
    this.Fm = paramCharSequence;
    this.aeM = paramInt5;
  }
  
  static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private void ad(boolean paramBoolean)
  {
    int j = this.DU;
    int k = this.DU;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.DU = (i | k & 0xFFFFFFFD);
      if (j != this.DU) {
        this.YO.r(false);
      }
      return;
    }
  }
  
  private android.support.v4.a.a.b bb(View paramView)
  {
    this.aeN = paramView;
    this.aeO = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.YO.hE();
    return this;
  }
  
  private Drawable o(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.aeL) {
        if (!this.acP)
        {
          localDrawable = paramDrawable;
          if (!this.acQ) {}
        }
        else
        {
          localDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();
          if (this.acP) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.acN);
          }
          if (this.acQ) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.acO);
          }
          this.aeL = false;
        }
      }
    }
    return localDrawable;
  }
  
  public final android.support.v4.a.a.b a(android.support.v4.view.b paramb)
  {
    if (this.aeO != null)
    {
      android.support.v4.view.b localb = this.aeO;
      localb.Nm = null;
      localb.Nl = null;
    }
    this.aeN = null;
    this.aeO = paramb;
    this.YO.r(true);
    if (this.aeO != null) {
      this.aeO.a(new b.b()
      {
        public final void fc()
        {
          j.this.YO.hD();
        }
      });
    }
    return this;
  }
  
  final CharSequence a(p.a parama)
  {
    if (parama.bl()) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final void ac(boolean paramBoolean)
  {
    int j = this.DU;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.DU = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean ae(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.DU;
    int k = this.DU;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.DU = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.DU) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void af(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.DU |= 0x20;
      return;
    }
    this.DU &= 0xFFFFFFDF;
  }
  
  public final void ag(boolean paramBoolean)
  {
    this.aeQ = paramBoolean;
    this.YO.r(false);
  }
  
  public final void b(u paramu)
  {
    this.aeJ = paramu;
    paramu.setHeaderTitle(getTitle());
  }
  
  public final boolean collapseActionView()
  {
    if ((this.aeM & 0x8) == 0) {}
    do
    {
      return false;
      if (this.aeN == null) {
        return true;
      }
    } while ((this.aeP != null) && (!this.aeP.onMenuItemActionCollapse(this)));
    return this.YO.h(this);
  }
  
  public final android.support.v4.view.b eo()
  {
    return this.aeO;
  }
  
  public final boolean expandActionView()
  {
    if (!hS()) {}
    while ((this.aeP != null) && (!this.aeP.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.YO.g(this);
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (this.aeN != null) {
      return this.aeN;
    }
    if (this.aeO != null)
    {
      this.aeN = this.aeO.onCreateActionView(this);
      return this.aeN;
    }
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
    if (this.acI != null) {
      return o(this.acI);
    }
    if (this.acJ != 0)
    {
      Drawable localDrawable = android.support.v7.c.a.a.l(this.YO.mContext, this.acJ);
      this.acJ = 0;
      this.acI = localDrawable;
      return o(localDrawable);
    }
    return null;
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
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.aeR;
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
    return this.acB;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.aeJ;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.Fm;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.acD != null) {}
    for (CharSequence localCharSequence = this.acD;; localCharSequence = this.Fm)
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
    return this.acM;
  }
  
  public final boolean hJ()
  {
    if ((this.acK != null) && (this.acK.onMenuItemClick(this))) {
      return true;
    }
    if (this.YO.d(this.YO, this)) {
      return true;
    }
    if (this.aeK != null)
    {
      this.aeK.run();
      return true;
    }
    if (this.mIntent != null) {
      try
      {
        Context localContext = this.YO.mContext;
        Object localObject = this.mIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
    return (this.aeO != null) && (this.aeO.onPerformDefaultAction());
  }
  
  final char hK()
  {
    if (this.YO.hz()) {
      return this.acG;
    }
    return this.acE;
  }
  
  final String hL()
  {
    char c = hK();
    if (c == 0) {
      return "";
    }
    Resources localResources = this.YO.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.YO.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131755102));
    }
    int i;
    if (this.YO.hz())
    {
      i = this.acH;
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
      i = this.acF;
      break;
      localStringBuilder.append(localResources.getString(2131755096));
      continue;
      localStringBuilder.append(localResources.getString(2131755095));
      continue;
      localStringBuilder.append(localResources.getString(2131755100));
    }
  }
  
  final boolean hM()
  {
    return (this.YO.hA()) && (hK() != 0);
  }
  
  public final boolean hN()
  {
    return (this.DU & 0x4) != 0;
  }
  
  public final boolean hO()
  {
    return (this.DU & 0x20) == 32;
  }
  
  public final boolean hP()
  {
    return (this.aeM & 0x1) == 1;
  }
  
  public final boolean hQ()
  {
    return (this.aeM & 0x2) == 2;
  }
  
  public final boolean hR()
  {
    return (this.aeM & 0x4) == 4;
  }
  
  public final boolean hS()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.aeM & 0x8) != 0)
    {
      if ((this.aeN == null) && (this.aeO != null)) {
        this.aeN = this.aeO.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.aeN != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean hasSubMenu()
  {
    return this.aeJ != null;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.aeQ;
  }
  
  public final boolean isCheckable()
  {
    return (this.DU & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.DU & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.DU & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((this.aeO != null) && (this.aeO.overridesItemVisibility())) {
      if (((this.DU & 0x8) != 0) || (!this.aeO.isVisible())) {}
    }
    while ((this.DU & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.acL = paramCharSequence;
    this.YO.r(false);
    return this;
  }
  
  public final android.support.v4.a.a.b l(CharSequence paramCharSequence)
  {
    this.acM = paramCharSequence;
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.acG == paramChar) {
      return this;
    }
    this.acG = Character.toLowerCase(paramChar);
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.acG == paramChar) && (this.acH == paramInt)) {
      return this;
    }
    this.acG = Character.toLowerCase(paramChar);
    this.acH = KeyEvent.normalizeMetaState(paramInt);
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.DU;
    int k = this.DU;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.DU = (i | k & 0xFFFFFFFE);
      if (j != this.DU) {
        this.YO.r(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.DU & 0x4) != 0)
    {
      h localh = this.YO;
      int j = getGroupId();
      int k = localh.mItems.size();
      localh.hB();
      int i = 0;
      if (i < k)
      {
        j localj = (j)localh.mItems.get(i);
        if ((localj.getGroupId() == j) && (localj.hN()) && (localj.isCheckable())) {
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
      localh.hC();
      return this;
    }
    ad(paramBoolean);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.DU |= 0x10;; this.DU &= 0xFFFFFFEF)
    {
      this.YO.r(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.acI = null;
    this.acJ = paramInt;
    this.aeL = true;
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.acJ = 0;
    this.acI = paramDrawable;
    this.aeL = true;
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.acN = paramColorStateList;
    this.acP = true;
    this.aeL = true;
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.acO = paramMode;
    this.acQ = true;
    this.aeL = true;
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.acE == paramChar) {
      return this;
    }
    this.acE = paramChar;
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.acE == paramChar) && (this.acF == paramInt)) {
      return this;
    }
    this.acE = paramChar;
    this.acF = KeyEvent.normalizeMetaState(paramInt);
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.aeP = paramOnActionExpandListener;
    return this;
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
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.acE = paramChar1;
    this.acF = KeyEvent.normalizeMetaState(paramInt1);
    this.acG = Character.toLowerCase(paramChar2);
    this.acH = KeyEvent.normalizeMetaState(paramInt2);
    this.YO.r(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.aeM = paramInt;
    this.YO.hE();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.YO.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Fm = paramCharSequence;
    this.YO.r(false);
    if (this.aeJ != null) {
      this.aeJ.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.acD = paramCharSequence;
    this.YO.r(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (ae(paramBoolean)) {
      this.YO.hD();
    }
    return this;
  }
  
  public final String toString()
  {
    if (this.Fm != null) {
      return this.Fm.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.j
 * JD-Core Version:    0.7.0.1
 */