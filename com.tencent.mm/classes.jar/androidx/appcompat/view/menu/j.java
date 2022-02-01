package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import androidx.core.g.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class j
  implements androidx.core.a.a.b
{
  private int cN = 16;
  private CharSequence cZ;
  h jo;
  private final int lI;
  private final int lJ;
  final int lK;
  private CharSequence lL;
  private char lM;
  int lN = 4096;
  private char lO;
  int lP = 4096;
  private Drawable lQ;
  private int lR = 0;
  private MenuItem.OnMenuItemClickListener lS;
  private CharSequence lT;
  private CharSequence lU;
  private ColorStateList lV = null;
  private PorterDuff.Mode lW = null;
  private boolean lX = false;
  private boolean lY = false;
  private final int mId;
  private Intent mIntent;
  private u nW;
  private Runnable nX;
  private boolean nY = false;
  private int nZ = 0;
  private View oa;
  public androidx.core.g.b ob;
  private MenuItem.OnActionExpandListener oc;
  private boolean od = false;
  ContextMenu.ContextMenuInfo oe;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.jo = paramh;
    this.mId = paramInt2;
    this.lI = paramInt1;
    this.lJ = paramInt3;
    this.lK = paramInt4;
    this.cZ = paramCharSequence;
    this.nZ = paramInt5;
  }
  
  private void N(boolean paramBoolean)
  {
    AppMethodBeat.i(201001);
    int j = this.cN;
    int k = this.cN;
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      this.cN = (i | k & 0xFFFFFFFD);
      if (j != this.cN) {
        this.jo.L(false);
      }
      AppMethodBeat.o(201001);
      return;
    }
  }
  
  static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(200980);
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
    AppMethodBeat.o(200980);
  }
  
  private Drawable f(Drawable paramDrawable)
  {
    AppMethodBeat.i(200989);
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.nY) {
        if (!this.lX)
        {
          localDrawable = paramDrawable;
          if (!this.lY) {}
        }
        else
        {
          localDrawable = androidx.core.graphics.drawable.a.s(paramDrawable).mutate();
          if (this.lX) {
            androidx.core.graphics.drawable.a.a(localDrawable, this.lV);
          }
          if (this.lY) {
            androidx.core.graphics.drawable.a.a(localDrawable, this.lW);
          }
          this.nY = false;
        }
      }
    }
    AppMethodBeat.o(200989);
    return localDrawable;
  }
  
  private androidx.core.a.a.b j(View paramView)
  {
    AppMethodBeat.i(201012);
    this.oa = paramView;
    this.ob = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.mId > 0)) {
      paramView.setId(this.mId);
    }
    this.jo.da();
    AppMethodBeat.o(201012);
    return this;
  }
  
  public final void M(boolean paramBoolean)
  {
    int j = this.cN;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      this.cN = (i | j & 0xFFFFFFFB);
      return;
    }
  }
  
  final boolean O(boolean paramBoolean)
  {
    boolean bool = false;
    int j = this.cN;
    int k = this.cN;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.cN = (i | k & 0xFFFFFFF7);
      paramBoolean = bool;
      if (j != this.cN) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public final void P(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.cN |= 0x20;
      return;
    }
    this.cN &= 0xFFFFFFDF;
  }
  
  public final void Q(boolean paramBoolean)
  {
    AppMethodBeat.i(201493);
    this.od = paramBoolean;
    this.jo.L(false);
    AppMethodBeat.o(201493);
  }
  
  public final androidx.core.a.a.b a(androidx.core.g.b paramb)
  {
    AppMethodBeat.i(201463);
    if (this.ob != null) {
      this.ob.reset();
    }
    this.oa = null;
    this.ob = paramb;
    this.jo.L(true);
    if (this.ob != null) {
      this.ob.a(new b.b()
      {
        public final void jdMethod_do()
        {
          AppMethodBeat.i(200796);
          j.this.jo.cZ();
          AppMethodBeat.o(200796);
        }
      });
    }
    AppMethodBeat.o(201463);
    return this;
  }
  
  final CharSequence a(p.a parama)
  {
    AppMethodBeat.i(201205);
    if (parama.cE())
    {
      parama = getTitleCondensed();
      AppMethodBeat.o(201205);
      return parama;
    }
    parama = getTitle();
    AppMethodBeat.o(201205);
    return parama;
  }
  
  public final androidx.core.a.a.b b(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201517);
    this.lT = paramCharSequence;
    this.jo.L(false);
    AppMethodBeat.o(201517);
    return this;
  }
  
  public final void b(u paramu)
  {
    AppMethodBeat.i(201189);
    this.nW = paramu;
    paramu.setHeaderTitle(getTitle());
    AppMethodBeat.o(201189);
  }
  
  public final androidx.core.a.a.b c(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201532);
    this.lU = paramCharSequence;
    this.jo.L(false);
    AppMethodBeat.o(201532);
    return this;
  }
  
  public final androidx.core.g.b cB()
  {
    return this.ob;
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(201480);
    if ((this.nZ & 0x8) == 0)
    {
      AppMethodBeat.o(201480);
      return false;
    }
    if (this.oa == null)
    {
      AppMethodBeat.o(201480);
      return true;
    }
    if ((this.oc == null) || (this.oc.onMenuItemActionCollapse(this)))
    {
      boolean bool = this.jo.g(this);
      AppMethodBeat.o(201480);
      return bool;
    }
    AppMethodBeat.o(201480);
    return false;
  }
  
  public final boolean df()
  {
    AppMethodBeat.i(201028);
    if ((this.lS != null) && (this.lS.onMenuItemClick(this)))
    {
      AppMethodBeat.o(201028);
      return true;
    }
    if (this.jo.d(this.jo, this))
    {
      AppMethodBeat.o(201028);
      return true;
    }
    if (this.nX != null)
    {
      this.nX.run();
      AppMethodBeat.o(201028);
      return true;
    }
    if (this.mIntent != null) {
      try
      {
        Context localContext = this.jo.mContext;
        Object localObject = this.mIntent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "androidx/appcompat/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "androidx/appcompat/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(201028);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
    if ((this.ob != null) && (this.ob.dq()))
    {
      AppMethodBeat.o(201028);
      return true;
    }
    AppMethodBeat.o(201028);
    return false;
  }
  
  final char dg()
  {
    AppMethodBeat.i(201155);
    if (this.jo.cV())
    {
      c = this.lO;
      AppMethodBeat.o(201155);
      return c;
    }
    char c = this.lM;
    AppMethodBeat.o(201155);
    return c;
  }
  
  final boolean dh()
  {
    AppMethodBeat.i(201163);
    if ((this.jo.cW()) && (dg() != 0))
    {
      AppMethodBeat.o(201163);
      return true;
    }
    AppMethodBeat.o(201163);
    return false;
  }
  
  public final boolean di()
  {
    return (this.cN & 0x4) != 0;
  }
  
  public final boolean dj()
  {
    return (this.cN & 0x20) == 32;
  }
  
  public final boolean dk()
  {
    return (this.nZ & 0x1) == 1;
  }
  
  public final boolean dl()
  {
    return (this.nZ & 0x2) == 2;
  }
  
  public final boolean dm()
  {
    return (this.nZ & 0x4) == 4;
  }
  
  public final boolean dn()
  {
    AppMethodBeat.i(201487);
    if ((this.nZ & 0x8) != 0)
    {
      if ((this.oa == null) && (this.ob != null)) {
        this.oa = this.ob.c(this);
      }
      if (this.oa != null)
      {
        AppMethodBeat.o(201487);
        return true;
      }
      AppMethodBeat.o(201487);
      return false;
    }
    AppMethodBeat.o(201487);
    return false;
  }
  
  public final boolean expandActionView()
  {
    AppMethodBeat.i(201468);
    if (!dn())
    {
      AppMethodBeat.o(201468);
      return false;
    }
    if ((this.oc == null) || (this.oc.onMenuItemActionExpand(this)))
    {
      boolean bool = this.jo.f(this);
      AppMethodBeat.o(201468);
      return bool;
    }
    AppMethodBeat.o(201468);
    return false;
  }
  
  public final ActionProvider getActionProvider()
  {
    AppMethodBeat.i(201447);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    AppMethodBeat.o(201447);
    throw localUnsupportedOperationException;
  }
  
  public final View getActionView()
  {
    AppMethodBeat.i(201433);
    View localView;
    if (this.oa != null)
    {
      localView = this.oa;
      AppMethodBeat.o(201433);
      return localView;
    }
    if (this.ob != null)
    {
      this.oa = this.ob.c(this);
      localView = this.oa;
      AppMethodBeat.o(201433);
      return localView;
    }
    AppMethodBeat.o(201433);
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
    AppMethodBeat.i(201245);
    Drawable localDrawable;
    if (this.lQ != null)
    {
      localDrawable = f(this.lQ);
      AppMethodBeat.o(201245);
      return localDrawable;
    }
    if (this.lR != 0)
    {
      localDrawable = androidx.appcompat.a.a.a.m(this.jo.mContext, this.lR);
      this.lR = 0;
      this.lQ = localDrawable;
      localDrawable = f(localDrawable);
      AppMethodBeat.o(201245);
      return localDrawable;
    }
    AppMethodBeat.o(201245);
    return null;
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
  
  @ViewDebug.CapturedViewProperty
  public final int getItemId()
  {
    return this.mId;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.oe;
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
    return this.lJ;
  }
  
  public final SubMenu getSubMenu()
  {
    return this.nW;
  }
  
  @ViewDebug.CapturedViewProperty
  public final CharSequence getTitle()
  {
    return this.cZ;
  }
  
  public final CharSequence getTitleCondensed()
  {
    AppMethodBeat.i(201230);
    if (this.lL != null) {}
    for (Object localObject = this.lL; (Build.VERSION.SDK_INT < 18) && (localObject != null) && (!(localObject instanceof String)); localObject = this.cZ)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(201230);
      return localObject;
    }
    AppMethodBeat.o(201230);
    return localObject;
  }
  
  public final CharSequence getTooltipText()
  {
    return this.lU;
  }
  
  public final boolean hasSubMenu()
  {
    return this.nW != null;
  }
  
  public final boolean isActionViewExpanded()
  {
    return this.od;
  }
  
  public final boolean isCheckable()
  {
    return (this.cN & 0x1) == 1;
  }
  
  public final boolean isChecked()
  {
    return (this.cN & 0x2) == 2;
  }
  
  public final boolean isEnabled()
  {
    return (this.cN & 0x10) != 0;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(201353);
    if ((this.ob != null) && (this.ob.dr()))
    {
      if (((this.cN & 0x8) == 0) && (this.ob.isVisible()))
      {
        AppMethodBeat.o(201353);
        return true;
      }
      AppMethodBeat.o(201353);
      return false;
    }
    if ((this.cN & 0x8) == 0)
    {
      AppMethodBeat.o(201353);
      return true;
    }
    AppMethodBeat.o(201353);
    return false;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    AppMethodBeat.i(201441);
    paramActionProvider = new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    AppMethodBeat.o(201441);
    throw paramActionProvider;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    AppMethodBeat.i(201086);
    if (this.lO == paramChar)
    {
      AppMethodBeat.o(201086);
      return this;
    }
    this.lO = Character.toLowerCase(paramChar);
    this.jo.L(false);
    AppMethodBeat.o(201086);
    return this;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(201095);
    if ((this.lO == paramChar) && (this.lP == paramInt))
    {
      AppMethodBeat.o(201095);
      return this;
    }
    this.lO = Character.toLowerCase(paramChar);
    this.lP = KeyEvent.normalizeMetaState(paramInt);
    this.jo.L(false);
    AppMethodBeat.o(201095);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(201310);
    int j = this.cN;
    int k = this.cN;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.cN = (i | k & 0xFFFFFFFE);
      if (j != this.cN) {
        this.jo.L(false);
      }
      AppMethodBeat.o(201310);
      return this;
    }
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(201344);
    if ((this.cN & 0x4) != 0)
    {
      h localh = this.jo;
      int j = getGroupId();
      int k = localh.mItems.size();
      localh.cX();
      int i = 0;
      if (i < k)
      {
        j localj = (j)localh.mItems.get(i);
        if ((localj.getGroupId() == j) && (localj.di()) && (localj.isCheckable())) {
          if (localj != this) {
            break label111;
          }
        }
        label111:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localj.N(paramBoolean);
          i += 1;
          break;
        }
      }
      localh.cY();
    }
    for (;;)
    {
      AppMethodBeat.o(201344);
      return this;
      N(paramBoolean);
    }
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(201039);
    if (paramBoolean) {}
    for (this.cN |= 0x10;; this.cN &= 0xFFFFFFEF)
    {
      this.jo.L(false);
      AppMethodBeat.o(201039);
      return this;
    }
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    AppMethodBeat.i(201260);
    this.lQ = null;
    this.lR = paramInt;
    this.nY = true;
    this.jo.L(false);
    AppMethodBeat.o(201260);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(201253);
    this.lR = 0;
    this.lQ = paramDrawable;
    this.nY = true;
    this.jo.L(false);
    AppMethodBeat.o(201253);
    return this;
  }
  
  public final MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(201271);
    this.lV = paramColorStateList;
    this.lX = true;
    this.nY = true;
    this.jo.L(false);
    AppMethodBeat.o(201271);
    return this;
  }
  
  public final MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(201287);
    this.lW = paramMode;
    this.lY = true;
    this.nY = true;
    this.jo.L(false);
    AppMethodBeat.o(201287);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    AppMethodBeat.i(201120);
    if (this.lM == paramChar)
    {
      AppMethodBeat.o(201120);
      return this;
    }
    this.lM = paramChar;
    this.jo.L(false);
    AppMethodBeat.o(201120);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(201131);
    if ((this.lM == paramChar) && (this.lN == paramInt))
    {
      AppMethodBeat.o(201131);
      return this;
    }
    this.lM = paramChar;
    this.lN = KeyEvent.normalizeMetaState(paramInt);
    this.jo.L(false);
    AppMethodBeat.o(201131);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.oc = paramOnActionExpandListener;
    return this;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.lS = paramOnMenuItemClickListener;
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(201140);
    this.lM = paramChar1;
    this.lO = Character.toLowerCase(paramChar2);
    this.jo.L(false);
    AppMethodBeat.o(201140);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201146);
    this.lM = paramChar1;
    this.lN = KeyEvent.normalizeMetaState(paramInt1);
    this.lO = Character.toLowerCase(paramChar2);
    this.lP = KeyEvent.normalizeMetaState(paramInt2);
    this.jo.L(false);
    AppMethodBeat.o(201146);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    AppMethodBeat.i(201426);
    switch (paramInt & 0x3)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
      AppMethodBeat.o(201426);
      throw localIllegalArgumentException;
    }
    this.nZ = paramInt;
    this.jo.da();
    AppMethodBeat.o(201426);
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    AppMethodBeat.i(201220);
    MenuItem localMenuItem = setTitle(this.jo.mContext.getString(paramInt));
    AppMethodBeat.o(201220);
    return localMenuItem;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201212);
    this.cZ = paramCharSequence;
    this.jo.L(false);
    if (this.nW != null) {
      this.nW.setHeaderTitle(paramCharSequence);
    }
    AppMethodBeat.o(201212);
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201240);
    this.lL = paramCharSequence;
    this.jo.L(false);
    AppMethodBeat.o(201240);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(201369);
    if (O(paramBoolean)) {
      this.jo.cZ();
    }
    AppMethodBeat.o(201369);
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201382);
    if (this.cZ != null)
    {
      String str = this.cZ.toString();
      AppMethodBeat.o(201382);
      return str;
    }
    AppMethodBeat.o(201382);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.j
 * JD-Core Version:    0.7.0.1
 */