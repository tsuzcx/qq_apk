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
  public Method agK;
  
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
    return ((android.support.v4.a.a.b)this.aeZ).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((android.support.v4.a.a.b)this.aeZ).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    android.support.v4.view.b localb = ((android.support.v4.a.a.b)this.aeZ).eF();
    if ((localb instanceof a)) {
      return ((a)localb).agL;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((android.support.v4.a.a.b)this.aeZ).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof b)) {
      localView1 = (View)((b)localView2).agN;
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getIntent();
  }
  
  public int getItemId()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((android.support.v4.a.a.b)this.aeZ).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((android.support.v4.a.a.b)this.aeZ).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((android.support.v4.a.a.b)this.aeZ).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((android.support.v4.a.a.b)this.aeZ).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((android.support.v4.a.a.b)this.aeZ).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((android.support.v4.a.a.b)this.aeZ).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((android.support.v4.a.a.b)this.aeZ).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((android.support.v4.a.a.b)this.aeZ).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.aeZ;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localb.a(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((android.support.v4.a.a.b)this.aeZ).setActionView(paramInt);
    View localView = ((android.support.v4.a.a.b)this.aeZ).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((android.support.v4.a.a.b)this.aeZ).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((android.support.v4.a.a.b)this.aeZ).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((android.support.v4.a.a.b)this.aeZ).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((android.support.v4.a.a.b)this.aeZ).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.aeZ).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.aeZ).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.aeZ).k(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.aeZ).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((android.support.v4.a.a.b)this.aeZ).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((android.support.v4.a.a.b)this.aeZ).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((android.support.v4.a.a.b)this.aeZ).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((android.support.v4.a.a.b)this.aeZ).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((android.support.v4.a.a.b)this.aeZ).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((android.support.v4.a.a.b)this.aeZ).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((android.support.v4.a.a.b)this.aeZ).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.aeZ;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new c(paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localb.setOnActionExpandListener(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.aeZ;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((android.support.v4.a.a.b)this.aeZ).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((android.support.v4.a.a.b)this.aeZ).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((android.support.v4.a.a.b)this.aeZ).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((android.support.v4.a.a.b)this.aeZ).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((android.support.v4.a.a.b)this.aeZ).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.aeZ).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.aeZ).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.aeZ).l(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((android.support.v4.a.a.b)this.aeZ).setVisible(paramBoolean);
  }
  
  class a
    extends android.support.v4.view.b
  {
    final ActionProvider agL;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      this.agL = paramActionProvider;
    }
    
    public final boolean hasSubMenu()
    {
      return this.agL.hasSubMenu();
    }
    
    public final View onCreateActionView()
    {
      return this.agL.onCreateActionView();
    }
    
    public final boolean onPerformDefaultAction()
    {
      return this.agL.onPerformDefaultAction();
    }
    
    public final void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      this.agL.onPrepareSubMenu(k.this.a(paramSubMenu));
    }
  }
  
  static final class b
    extends FrameLayout
    implements android.support.v7.view.c
  {
    final CollapsibleActionView agN;
    
    b(View paramView)
    {
      super();
      this.agN = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    public final void onActionViewCollapsed()
    {
      this.agN.onActionViewCollapsed();
    }
    
    public final void onActionViewExpanded()
    {
      this.agN.onActionViewExpanded();
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
      return ((MenuItem.OnActionExpandListener)this.aeZ).onMenuItemActionCollapse(k.this.b(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.aeZ).onMenuItemActionExpand(k.this.b(paramMenuItem));
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
      return ((MenuItem.OnMenuItemClickListener)this.aeZ).onMenuItemClick(k.this.b(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.k
 * JD-Core Version:    0.7.0.1
 */