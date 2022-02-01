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
  private int FL = 16;
  private CharSequence Hd;
  h aaD;
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
  final int aet;
  private CharSequence aeu;
  private char aev;
  int aew = 4096;
  private char aex;
  int aey = 4096;
  private Drawable aez;
  private u agA;
  private Runnable agB;
  private boolean agC = false;
  private int agD = 0;
  private View agE;
  public android.support.v4.view.b agF;
  private MenuItem.OnActionExpandListener agG;
  private boolean agH = false;
  ContextMenu.ContextMenuInfo agI;
  private final int mId;
  private Intent mIntent;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.aaD = paramh;
    this.mId = paramInt2;
    this.aer = paramInt1;
    this.aes = paramInt3;
    this.aet = paramInt4;
    this.Hd = paramCharSequence;
    this.agD = paramInt5;
  }
  
  static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private void ad(boolean paramBoolean)
  {
    int j = this.FL;
    int k = this.FL;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.FL = (i | k & 0xFFFFFFFD);
      if (j != this.FL) {
        this.aaD.r(false);
      }
      return;
    }
  }
  
  private android.support.v4.a.a.b bb(View paramView)
  {
    this.agE = paramView;
    this.agF = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.aaD.hU();
    return this;
  }
  
  private Drawable o(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.agC) {
        if (!this.aeG)
        {
          localDrawable = paramDrawable;
          if (!this.aeH) {}
        }
        else
        {
          localDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();
          if (this.aeG) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.aeE);
          }
          if (this.aeH) {
            android.support.v4.graphics.drawable.a.a(localDrawable, this.aeF);
          }
          this.agC = false;
        }
      }
    }
    return localDrawable;
  }
  
  public final android.support.v4.a.a.b a(android.support.v4.view.b paramb)
  {
    if (this.agF != null)
    {
      android.support.v4.view.b localb = this.agF;
      localb.Pd = null;
      localb.Pc = null;
    }
    this.agE = null;
    this.agF = paramb;
    this.aaD.r(true);
    if (this.agF != null) {
      this.agF.a(new b.b()
      {
        public final void ft()
        {
          j.this.aaD.hT();
        }
      });
    }
    return this;
  }
  
  final CharSequence a(p.a parama)
  {
    if (parama.bA()) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public final void ac(boolean paramBoolean)
  {
    int j = this.FL;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.FL = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean ae(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.FL;
    int k = this.FL;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.FL = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.FL) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void af(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.FL |= 0x20;
      return;
    }
    this.FL &= 0xFFFFFFDF;
  }
  
  public final void ag(boolean paramBoolean)
  {
    this.agH = paramBoolean;
    this.aaD.r(false);
  }
  
  public final void b(u paramu)
  {
    this.agA = paramu;
    paramu.setHeaderTitle(getTitle());
  }
  
  public final boolean collapseActionView()
  {
    if ((this.agD & 0x8) == 0) {}
    do
    {
      return false;
      if (this.agE == null) {
        return true;
      }
    } while ((this.agG != null) && (!this.agG.onMenuItemActionCollapse(this)));
    return this.aaD.h(this);
  }
  
  public final android.support.v4.view.b eF()
  {
    return this.agF;
  }
  
  public final boolean expandActionView()
  {
    if (!ij()) {}
    while ((this.agG != null) && (!this.agG.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.aaD.g(this);
  }
  
  public final ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public final View getActionView()
  {
    if (this.agE != null) {
      return this.agE;
    }
    if (this.agF != null)
    {
      this.agE = this.agF.onCreateActionView(this);
      return this.agE;
    }
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
    if (this.aez != null) {
      return o(this.aez);
    }
    if (this.aeA != 0)
    {
      Drawable localDrawable = android.support.v7.c.a.a.l(this.aaD.mContext, this.aeA);
      this.aeA = 0;
      this.aez = localDrawable;
      return o(localDrawable);
    }
    return null;
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
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.agI;
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
    return this.aes;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.agA;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.Hd;
  }
  
  public final CharSequence getTitleCondensed()
  {
    if (this.aeu != null) {}
    for (CharSequence localCharSequence = this.aeu;; localCharSequence = this.Hd)
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
    return this.aeD;
  }
  
  public final boolean hZ()
  {
    if ((this.aeB != null) && (this.aeB.onMenuItemClick(this))) {
      return true;
    }
    if (this.aaD.d(this.aaD, this)) {
      return true;
    }
    if (this.agB != null)
    {
      this.agB.run();
      return true;
    }
    if (this.mIntent != null) {
      try
      {
        Context localContext = this.aaD.mContext;
        Object localObject = this.mIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
    return (this.agF != null) && (this.agF.onPerformDefaultAction());
  }
  
  public final boolean hasSubMenu()
  {
    return this.agA != null;
  }
  
  final char ia()
  {
    if (this.aaD.hP()) {
      return this.aex;
    }
    return this.aev;
  }
  
  final String ib()
  {
    char c = ia();
    if (c == 0) {
      return "";
    }
    Resources localResources = this.aaD.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.aaD.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131755102));
    }
    int i;
    if (this.aaD.hP())
    {
      i = this.aey;
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
      i = this.aew;
      break;
      localStringBuilder.append(localResources.getString(2131755096));
      continue;
      localStringBuilder.append(localResources.getString(2131755095));
      continue;
      localStringBuilder.append(localResources.getString(2131755100));
    }
  }
  
  final boolean ic()
  {
    return (this.aaD.hQ()) && (ia() != 0);
  }
  
  public final boolean ie()
  {
    return (this.FL & 0x4) != 0;
  }
  
  public final boolean jdMethod_if()
  {
    return (this.FL & 0x20) == 32;
  }
  
  public final boolean ig()
  {
    return (this.agD & 0x1) == 1;
  }
  
  public final boolean ih()
  {
    return (this.agD & 0x2) == 2;
  }
  
  public final boolean ii()
  {
    return (this.agD & 0x4) == 4;
  }
  
  public final boolean ij()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.agD & 0x8) != 0)
    {
      if ((this.agE == null) && (this.agF != null)) {
        this.agE = this.agF.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.agE != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.agH;
  }
  
  public final boolean isCheckable()
  {
    return (this.FL & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.FL & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.FL & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    if ((this.agF != null) && (this.agF.overridesItemVisibility())) {
      if (((this.FL & 0x8) != 0) || (!this.agF.isVisible())) {}
    }
    while ((this.FL & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final android.support.v4.a.a.b k(CharSequence paramCharSequence)
  {
    this.aeC = paramCharSequence;
    this.aaD.r(false);
    return this;
  }
  
  public final android.support.v4.a.a.b l(CharSequence paramCharSequence)
  {
    this.aeD = paramCharSequence;
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.aex == paramChar) {
      return this;
    }
    this.aex = Character.toLowerCase(paramChar);
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.aex == paramChar) && (this.aey == paramInt)) {
      return this;
    }
    this.aex = Character.toLowerCase(paramChar);
    this.aey = KeyEvent.normalizeMetaState(paramInt);
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    int j = this.FL;
    int k = this.FL;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.FL = (i | k & 0xFFFFFFFE);
      if (j != this.FL) {
        this.aaD.r(false);
      }
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.FL & 0x4) != 0)
    {
      h localh = this.aaD;
      int j = getGroupId();
      int k = localh.mItems.size();
      localh.hR();
      int i = 0;
      if (i < k)
      {
        j localj = (j)localh.mItems.get(i);
        if ((localj.getGroupId() == j) && (localj.ie()) && (localj.isCheckable())) {
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
      localh.hS();
      return this;
    }
    ad(paramBoolean);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.FL |= 0x10;; this.FL &= 0xFFFFFFEF)
    {
      this.aaD.r(false);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    this.aez = null;
    this.aeA = paramInt;
    this.agC = true;
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.aeA = 0;
    this.aez = paramDrawable;
    this.agC = true;
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.aeE = paramColorStateList;
    this.aeG = true;
    this.agC = true;
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.aeF = paramMode;
    this.aeH = true;
    this.agC = true;
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    if (this.aev == paramChar) {
      return this;
    }
    this.aev = paramChar;
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.aev == paramChar) && (this.aew == paramInt)) {
      return this;
    }
    this.aev = paramChar;
    this.aew = KeyEvent.normalizeMetaState(paramInt);
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.agG = paramOnActionExpandListener;
    return this;
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
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.aev = paramChar1;
    this.aew = KeyEvent.normalizeMetaState(paramInt1);
    this.aex = Character.toLowerCase(paramChar2);
    this.aey = KeyEvent.normalizeMetaState(paramInt2);
    this.aaD.r(false);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.agD = paramInt;
    this.aaD.hU();
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    return setTitle(this.aaD.mContext.getString(paramInt));
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.Hd = paramCharSequence;
    this.aaD.r(false);
    if (this.agA != null) {
      this.agA.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.aeu = paramCharSequence;
    this.aaD.r(false);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    if (ae(paramBoolean)) {
      this.aaD.hT();
    }
    return this;
  }
  
  public final String toString()
  {
    if (this.Hd != null) {
      return this.Hd.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.j
 * JD-Core Version:    0.7.0.1
 */