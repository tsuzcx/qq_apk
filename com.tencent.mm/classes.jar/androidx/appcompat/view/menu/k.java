package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class k
  extends c<androidx.core.a.a.b>
  implements MenuItem
{
  public Method nk;
  
  k(Context paramContext, androidx.core.a.a.b paramb)
  {
    super(paramContext, paramb);
  }
  
  a a(ActionProvider paramActionProvider)
  {
    AppMethodBeat.i(239719);
    paramActionProvider = new a(this.mContext, paramActionProvider);
    AppMethodBeat.o(239719);
    return paramActionProvider;
  }
  
  public boolean collapseActionView()
  {
    AppMethodBeat.i(239703);
    boolean bool = ((androidx.core.a.a.b)this.lv).collapseActionView();
    AppMethodBeat.o(239703);
    return bool;
  }
  
  public boolean expandActionView()
  {
    AppMethodBeat.i(239702);
    boolean bool = ((androidx.core.a.a.b)this.lv).expandActionView();
    AppMethodBeat.o(239702);
    return bool;
  }
  
  public ActionProvider getActionProvider()
  {
    AppMethodBeat.i(239701);
    Object localObject = ((androidx.core.a.a.b)this.lv).bI();
    if ((localObject instanceof a))
    {
      localObject = ((a)localObject).nl;
      AppMethodBeat.o(239701);
      return localObject;
    }
    AppMethodBeat.o(239701);
    return null;
  }
  
  public View getActionView()
  {
    AppMethodBeat.i(239699);
    View localView = ((androidx.core.a.a.b)this.lv).getActionView();
    if ((localView instanceof b))
    {
      localView = (View)((b)localView).nn;
      AppMethodBeat.o(239699);
      return localView;
    }
    AppMethodBeat.o(239699);
    return localView;
  }
  
  public int getAlphabeticModifiers()
  {
    AppMethodBeat.i(239672);
    int i = ((androidx.core.a.a.b)this.lv).getAlphabeticModifiers();
    AppMethodBeat.o(239672);
    return i;
  }
  
  public char getAlphabeticShortcut()
  {
    AppMethodBeat.i(239671);
    char c = ((androidx.core.a.a.b)this.lv).getAlphabeticShortcut();
    AppMethodBeat.o(239671);
    return c;
  }
  
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(239707);
    CharSequence localCharSequence = ((androidx.core.a.a.b)this.lv).getContentDescription();
    AppMethodBeat.o(239707);
    return localCharSequence;
  }
  
  public int getGroupId()
  {
    AppMethodBeat.i(239624);
    int i = ((androidx.core.a.a.b)this.lv).getGroupId();
    AppMethodBeat.o(239624);
    return i;
  }
  
  public Drawable getIcon()
  {
    AppMethodBeat.i(239647);
    Drawable localDrawable = ((androidx.core.a.a.b)this.lv).getIcon();
    AppMethodBeat.o(239647);
    return localDrawable;
  }
  
  public ColorStateList getIconTintList()
  {
    AppMethodBeat.i(239712);
    ColorStateList localColorStateList = ((androidx.core.a.a.b)this.lv).getIconTintList();
    AppMethodBeat.o(239712);
    return localColorStateList;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    AppMethodBeat.i(239716);
    PorterDuff.Mode localMode = ((androidx.core.a.a.b)this.lv).getIconTintMode();
    AppMethodBeat.o(239716);
    return localMode;
  }
  
  public Intent getIntent()
  {
    AppMethodBeat.i(239653);
    Intent localIntent = ((androidx.core.a.a.b)this.lv).getIntent();
    AppMethodBeat.o(239653);
    return localIntent;
  }
  
  public int getItemId()
  {
    AppMethodBeat.i(239622);
    int i = ((androidx.core.a.a.b)this.lv).getItemId();
    AppMethodBeat.o(239622);
    return i;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    AppMethodBeat.i(239694);
    ContextMenu.ContextMenuInfo localContextMenuInfo = ((androidx.core.a.a.b)this.lv).getMenuInfo();
    AppMethodBeat.o(239694);
    return localContextMenuInfo;
  }
  
  public int getNumericModifiers()
  {
    AppMethodBeat.i(239664);
    int i = ((androidx.core.a.a.b)this.lv).getNumericModifiers();
    AppMethodBeat.o(239664);
    return i;
  }
  
  public char getNumericShortcut()
  {
    AppMethodBeat.i(239663);
    char c = ((androidx.core.a.a.b)this.lv).getNumericShortcut();
    AppMethodBeat.o(239663);
    return c;
  }
  
  public int getOrder()
  {
    AppMethodBeat.i(239625);
    int i = ((androidx.core.a.a.b)this.lv).getOrder();
    AppMethodBeat.o(239625);
    return i;
  }
  
  public SubMenu getSubMenu()
  {
    AppMethodBeat.i(239692);
    SubMenu localSubMenu = a(((androidx.core.a.a.b)this.lv).getSubMenu());
    AppMethodBeat.o(239692);
    return localSubMenu;
  }
  
  public CharSequence getTitle()
  {
    AppMethodBeat.i(239636);
    CharSequence localCharSequence = ((androidx.core.a.a.b)this.lv).getTitle();
    AppMethodBeat.o(239636);
    return localCharSequence;
  }
  
  public CharSequence getTitleCondensed()
  {
    AppMethodBeat.i(239642);
    CharSequence localCharSequence = ((androidx.core.a.a.b)this.lv).getTitleCondensed();
    AppMethodBeat.o(239642);
    return localCharSequence;
  }
  
  public CharSequence getTooltipText()
  {
    AppMethodBeat.i(239709);
    CharSequence localCharSequence = ((androidx.core.a.a.b)this.lv).getTooltipText();
    AppMethodBeat.o(239709);
    return localCharSequence;
  }
  
  public boolean hasSubMenu()
  {
    AppMethodBeat.i(239691);
    boolean bool = ((androidx.core.a.a.b)this.lv).hasSubMenu();
    AppMethodBeat.o(239691);
    return bool;
  }
  
  public boolean isActionViewExpanded()
  {
    AppMethodBeat.i(239704);
    boolean bool = ((androidx.core.a.a.b)this.lv).isActionViewExpanded();
    AppMethodBeat.o(239704);
    return bool;
  }
  
  public boolean isCheckable()
  {
    AppMethodBeat.i(239676);
    boolean bool = ((androidx.core.a.a.b)this.lv).isCheckable();
    AppMethodBeat.o(239676);
    return bool;
  }
  
  public boolean isChecked()
  {
    AppMethodBeat.i(239681);
    boolean bool = ((androidx.core.a.a.b)this.lv).isChecked();
    AppMethodBeat.o(239681);
    return bool;
  }
  
  public boolean isEnabled()
  {
    AppMethodBeat.i(239689);
    boolean bool = ((androidx.core.a.a.b)this.lv).isEnabled();
    AppMethodBeat.o(239689);
    return bool;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(239686);
    boolean bool = ((androidx.core.a.a.b)this.lv).isVisible();
    AppMethodBeat.o(239686);
    return bool;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    AppMethodBeat.i(239700);
    androidx.core.a.a.b localb = (androidx.core.a.a.b)this.lv;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localb.a(paramActionProvider);
      AppMethodBeat.o(239700);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    AppMethodBeat.i(239698);
    ((androidx.core.a.a.b)this.lv).setActionView(paramInt);
    View localView = ((androidx.core.a.a.b)this.lv).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((androidx.core.a.a.b)this.lv).setActionView(new b(localView));
    }
    AppMethodBeat.o(239698);
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    AppMethodBeat.i(239697);
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((androidx.core.a.a.b)this.lv).setActionView((View)localObject);
    AppMethodBeat.o(239697);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    AppMethodBeat.i(239666);
    ((androidx.core.a.a.b)this.lv).setAlphabeticShortcut(paramChar);
    AppMethodBeat.o(239666);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(239668);
    ((androidx.core.a.a.b)this.lv).setAlphabeticShortcut(paramChar, paramInt);
    AppMethodBeat.o(239668);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(239674);
    ((androidx.core.a.a.b)this.lv).setCheckable(paramBoolean);
    AppMethodBeat.o(239674);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(239679);
    ((androidx.core.a.a.b)this.lv).setChecked(paramBoolean);
    AppMethodBeat.o(239679);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239706);
    ((androidx.core.a.a.b)this.lv).b(paramCharSequence);
    AppMethodBeat.o(239706);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(239688);
    ((androidx.core.a.a.b)this.lv).setEnabled(paramBoolean);
    AppMethodBeat.o(239688);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    AppMethodBeat.i(239646);
    ((androidx.core.a.a.b)this.lv).setIcon(paramInt);
    AppMethodBeat.o(239646);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239644);
    ((androidx.core.a.a.b)this.lv).setIcon(paramDrawable);
    AppMethodBeat.o(239644);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(239710);
    ((androidx.core.a.a.b)this.lv).setIconTintList(paramColorStateList);
    AppMethodBeat.o(239710);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(239714);
    ((androidx.core.a.a.b)this.lv).setIconTintMode(paramMode);
    AppMethodBeat.o(239714);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    AppMethodBeat.i(239650);
    ((androidx.core.a.a.b)this.lv).setIntent(paramIntent);
    AppMethodBeat.o(239650);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    AppMethodBeat.i(239660);
    ((androidx.core.a.a.b)this.lv).setNumericShortcut(paramChar);
    AppMethodBeat.o(239660);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(239662);
    ((androidx.core.a.a.b)this.lv).setNumericShortcut(paramChar, paramInt);
    AppMethodBeat.o(239662);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    AppMethodBeat.i(239705);
    androidx.core.a.a.b localb = (androidx.core.a.a.b)this.lv;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new c(paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localb.setOnActionExpandListener(paramOnActionExpandListener);
      AppMethodBeat.o(239705);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(239693);
    androidx.core.a.a.b localb = (androidx.core.a.a.b)this.lv;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      AppMethodBeat.o(239693);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(239655);
    ((androidx.core.a.a.b)this.lv).setShortcut(paramChar1, paramChar2);
    AppMethodBeat.o(239655);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239659);
    ((androidx.core.a.a.b)this.lv).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    AppMethodBeat.o(239659);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    AppMethodBeat.i(239695);
    ((androidx.core.a.a.b)this.lv).setShowAsAction(paramInt);
    AppMethodBeat.o(239695);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    AppMethodBeat.i(239696);
    ((androidx.core.a.a.b)this.lv).setShowAsActionFlags(paramInt);
    AppMethodBeat.o(239696);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    AppMethodBeat.i(239632);
    ((androidx.core.a.a.b)this.lv).setTitle(paramInt);
    AppMethodBeat.o(239632);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239629);
    ((androidx.core.a.a.b)this.lv).setTitle(paramCharSequence);
    AppMethodBeat.o(239629);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239640);
    ((androidx.core.a.a.b)this.lv).setTitleCondensed(paramCharSequence);
    AppMethodBeat.o(239640);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239708);
    ((androidx.core.a.a.b)this.lv).c(paramCharSequence);
    AppMethodBeat.o(239708);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(239685);
    MenuItem localMenuItem = ((androidx.core.a.a.b)this.lv).setVisible(paramBoolean);
    AppMethodBeat.o(239685);
    return localMenuItem;
  }
  
  class a
    extends androidx.core.g.b
  {
    final ActionProvider nl;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      this.nl = paramActionProvider;
    }
    
    public final void b(SubMenu paramSubMenu)
    {
      AppMethodBeat.i(239605);
      this.nl.onPrepareSubMenu(k.this.a(paramSubMenu));
      AppMethodBeat.o(239605);
    }
    
    public final View cw()
    {
      AppMethodBeat.i(239600);
      View localView = this.nl.onCreateActionView();
      AppMethodBeat.o(239600);
      return localView;
    }
    
    public final boolean cx()
    {
      AppMethodBeat.i(239601);
      boolean bool = this.nl.onPerformDefaultAction();
      AppMethodBeat.o(239601);
      return bool;
    }
    
    public final boolean hasSubMenu()
    {
      AppMethodBeat.i(239603);
      boolean bool = this.nl.hasSubMenu();
      AppMethodBeat.o(239603);
      return bool;
    }
  }
  
  static final class b
    extends FrameLayout
    implements androidx.appcompat.view.c
  {
    final CollapsibleActionView nn;
    
    b(View paramView)
    {
      super();
      AppMethodBeat.i(239610);
      this.nn = ((CollapsibleActionView)paramView);
      addView(paramView);
      AppMethodBeat.o(239610);
    }
    
    public final void bB()
    {
      AppMethodBeat.i(239611);
      this.nn.onActionViewExpanded();
      AppMethodBeat.o(239611);
    }
    
    public final void bC()
    {
      AppMethodBeat.i(239612);
      this.nn.onActionViewCollapsed();
      AppMethodBeat.o(239612);
    }
  }
  
  final class c
    extends d<MenuItem.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    c(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(239614);
      boolean bool = ((MenuItem.OnActionExpandListener)this.lv).onMenuItemActionCollapse(k.this.b(paramMenuItem));
      AppMethodBeat.o(239614);
      return bool;
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(239613);
      boolean bool = ((MenuItem.OnActionExpandListener)this.lv).onMenuItemActionExpand(k.this.b(paramMenuItem));
      AppMethodBeat.o(239613);
      return bool;
    }
  }
  
  final class d
    extends d<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    d(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(239616);
      boolean bool = ((MenuItem.OnMenuItemClickListener)this.lv).onMenuItemClick(k.this.b(paramMenuItem));
      AppMethodBeat.o(239616);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.k
 * JD-Core Version:    0.7.0.1
 */