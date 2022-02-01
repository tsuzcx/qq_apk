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
  public Method aeT;
  
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
    return ((android.support.v4.a.a.b)this.adi).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((android.support.v4.a.a.b)this.adi).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    android.support.v4.view.b localb = ((android.support.v4.a.a.b)this.adi).eo();
    if ((localb instanceof a)) {
      return ((a)localb).aeU;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((android.support.v4.a.a.b)this.adi).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof b)) {
      localView1 = (View)((b)localView2).aeW;
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((android.support.v4.a.a.b)this.adi).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((android.support.v4.a.a.b)this.adi).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((android.support.v4.a.a.b)this.adi).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((android.support.v4.a.a.b)this.adi).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((android.support.v4.a.a.b)this.adi).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((android.support.v4.a.a.b)this.adi).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((android.support.v4.a.a.b)this.adi).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((android.support.v4.a.a.b)this.adi).getIntent();
  }
  
  public int getItemId()
  {
    return ((android.support.v4.a.a.b)this.adi).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((android.support.v4.a.a.b)this.adi).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((android.support.v4.a.a.b)this.adi).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((android.support.v4.a.a.b)this.adi).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((android.support.v4.a.a.b)this.adi).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((android.support.v4.a.a.b)this.adi).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((android.support.v4.a.a.b)this.adi).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((android.support.v4.a.a.b)this.adi).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((android.support.v4.a.a.b)this.adi).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((android.support.v4.a.a.b)this.adi).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((android.support.v4.a.a.b)this.adi).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((android.support.v4.a.a.b)this.adi).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((android.support.v4.a.a.b)this.adi).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((android.support.v4.a.a.b)this.adi).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((android.support.v4.a.a.b)this.adi).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.adi;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localb.a(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((android.support.v4.a.a.b)this.adi).setActionView(paramInt);
    View localView = ((android.support.v4.a.a.b)this.adi).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((android.support.v4.a.a.b)this.adi).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((android.support.v4.a.a.b)this.adi).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((android.support.v4.a.a.b)this.adi).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((android.support.v4.a.a.b)this.adi).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.adi).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.adi).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.adi).k(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.adi).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((android.support.v4.a.a.b)this.adi).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((android.support.v4.a.a.b)this.adi).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((android.support.v4.a.a.b)this.adi).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((android.support.v4.a.a.b)this.adi).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((android.support.v4.a.a.b)this.adi).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((android.support.v4.a.a.b)this.adi).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((android.support.v4.a.a.b)this.adi).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.adi;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new c(paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localb.setOnActionExpandListener(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.adi;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((android.support.v4.a.a.b)this.adi).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((android.support.v4.a.a.b)this.adi).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((android.support.v4.a.a.b)this.adi).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((android.support.v4.a.a.b)this.adi).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((android.support.v4.a.a.b)this.adi).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.adi).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.adi).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.adi).l(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((android.support.v4.a.a.b)this.adi).setVisible(paramBoolean);
  }
  
  class a
    extends android.support.v4.view.b
  {
    final ActionProvider aeU;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      this.aeU = paramActionProvider;
    }
    
    public final boolean hasSubMenu()
    {
      return this.aeU.hasSubMenu();
    }
    
    public final View onCreateActionView()
    {
      return this.aeU.onCreateActionView();
    }
    
    public final boolean onPerformDefaultAction()
    {
      return this.aeU.onPerformDefaultAction();
    }
    
    public final void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      this.aeU.onPrepareSubMenu(k.this.a(paramSubMenu));
    }
  }
  
  static final class b
    extends FrameLayout
    implements android.support.v7.view.c
  {
    final CollapsibleActionView aeW;
    
    b(View paramView)
    {
      super();
      this.aeW = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    public final void onActionViewCollapsed()
    {
      this.aeW.onActionViewCollapsed();
    }
    
    public final void onActionViewExpanded()
    {
      this.aeW.onActionViewExpanded();
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
      return ((MenuItem.OnActionExpandListener)this.adi).onMenuItemActionCollapse(k.this.b(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.adi).onMenuItemActionExpand(k.this.b(paramMenuItem));
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
      return ((MenuItem.OnMenuItemClickListener)this.adi).onMenuItemClick(k.this.b(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.k
 * JD-Core Version:    0.7.0.1
 */