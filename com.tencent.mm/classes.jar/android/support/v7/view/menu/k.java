package android.support.v7.view.menu;

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
import java.lang.reflect.Method;

public class k
  extends c<android.support.v4.a.a.b>
  implements MenuItem
{
  public Method agX;
  
  k(Context paramContext, android.support.v4.a.a.b paramb)
  {
    super(paramContext, paramb);
  }
  
  a a(ActionProvider paramActionProvider)
  {
    return new a(this.mContext, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((android.support.v4.a.a.b)this.afm).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((android.support.v4.a.a.b)this.afm).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    android.support.v4.view.b localb = ((android.support.v4.a.a.b)this.afm).eJ();
    if ((localb instanceof a)) {
      return ((a)localb).agY;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((android.support.v4.a.a.b)this.afm).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof b)) {
      localView1 = (View)((b)localView2).aha;
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((android.support.v4.a.a.b)this.afm).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((android.support.v4.a.a.b)this.afm).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((android.support.v4.a.a.b)this.afm).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((android.support.v4.a.a.b)this.afm).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((android.support.v4.a.a.b)this.afm).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((android.support.v4.a.a.b)this.afm).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((android.support.v4.a.a.b)this.afm).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((android.support.v4.a.a.b)this.afm).getIntent();
  }
  
  public int getItemId()
  {
    return ((android.support.v4.a.a.b)this.afm).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((android.support.v4.a.a.b)this.afm).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((android.support.v4.a.a.b)this.afm).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((android.support.v4.a.a.b)this.afm).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((android.support.v4.a.a.b)this.afm).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((android.support.v4.a.a.b)this.afm).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((android.support.v4.a.a.b)this.afm).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((android.support.v4.a.a.b)this.afm).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((android.support.v4.a.a.b)this.afm).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((android.support.v4.a.a.b)this.afm).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((android.support.v4.a.a.b)this.afm).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((android.support.v4.a.a.b)this.afm).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((android.support.v4.a.a.b)this.afm).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((android.support.v4.a.a.b)this.afm).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((android.support.v4.a.a.b)this.afm).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.afm;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localb.a(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((android.support.v4.a.a.b)this.afm).setActionView(paramInt);
    View localView = ((android.support.v4.a.a.b)this.afm).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((android.support.v4.a.a.b)this.afm).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((android.support.v4.a.a.b)this.afm).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((android.support.v4.a.a.b)this.afm).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((android.support.v4.a.a.b)this.afm).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.afm).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.afm).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.afm).k(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.afm).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((android.support.v4.a.a.b)this.afm).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((android.support.v4.a.a.b)this.afm).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((android.support.v4.a.a.b)this.afm).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((android.support.v4.a.a.b)this.afm).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((android.support.v4.a.a.b)this.afm).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((android.support.v4.a.a.b)this.afm).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((android.support.v4.a.a.b)this.afm).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.afm;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new c(paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localb.setOnActionExpandListener(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.afm;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((android.support.v4.a.a.b)this.afm).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((android.support.v4.a.a.b)this.afm).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((android.support.v4.a.a.b)this.afm).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((android.support.v4.a.a.b)this.afm).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((android.support.v4.a.a.b)this.afm).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.afm).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.afm).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.afm).l(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((android.support.v4.a.a.b)this.afm).setVisible(paramBoolean);
  }
  
  class a
    extends android.support.v4.view.b
  {
    final ActionProvider agY;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      this.agY = paramActionProvider;
    }
    
    public final boolean hasSubMenu()
    {
      return this.agY.hasSubMenu();
    }
    
    public final View onCreateActionView()
    {
      return this.agY.onCreateActionView();
    }
    
    public final boolean onPerformDefaultAction()
    {
      return this.agY.onPerformDefaultAction();
    }
    
    public final void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      this.agY.onPrepareSubMenu(k.this.a(paramSubMenu));
    }
  }
  
  static final class b
    extends FrameLayout
    implements android.support.v7.view.c
  {
    final CollapsibleActionView aha;
    
    b(View paramView)
    {
      super();
      this.aha = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    public final void onActionViewCollapsed()
    {
      this.aha.onActionViewCollapsed();
    }
    
    public final void onActionViewExpanded()
    {
      this.aha.onActionViewExpanded();
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
      return ((MenuItem.OnActionExpandListener)this.afm).onMenuItemActionCollapse(k.this.b(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.afm).onMenuItemActionExpand(k.this.b(paramMenuItem));
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
      return ((MenuItem.OnMenuItemClickListener)this.afm).onMenuItemClick(k.this.b(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.k
 * JD-Core Version:    0.7.0.1
 */