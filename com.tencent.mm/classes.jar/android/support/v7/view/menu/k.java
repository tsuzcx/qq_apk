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
  public Method WT;
  
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
    return ((android.support.v4.a.a.b)this.Vj).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((android.support.v4.a.a.b)this.Vj).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    android.support.v4.view.b localb = ((android.support.v4.a.a.b)this.Vj).cY();
    if ((localb instanceof a)) {
      return ((a)localb).WV;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = ((android.support.v4.a.a.b)this.Vj).getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof b)) {
      localView1 = (View)((b)localView2).WX;
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((android.support.v4.a.a.b)this.Vj).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((android.support.v4.a.a.b)this.Vj).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((android.support.v4.a.a.b)this.Vj).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((android.support.v4.a.a.b)this.Vj).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((android.support.v4.a.a.b)this.Vj).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((android.support.v4.a.a.b)this.Vj).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((android.support.v4.a.a.b)this.Vj).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((android.support.v4.a.a.b)this.Vj).getIntent();
  }
  
  public int getItemId()
  {
    return ((android.support.v4.a.a.b)this.Vj).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((android.support.v4.a.a.b)this.Vj).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((android.support.v4.a.a.b)this.Vj).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((android.support.v4.a.a.b)this.Vj).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((android.support.v4.a.a.b)this.Vj).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((android.support.v4.a.a.b)this.Vj).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((android.support.v4.a.a.b)this.Vj).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((android.support.v4.a.a.b)this.Vj).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((android.support.v4.a.a.b)this.Vj).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((android.support.v4.a.a.b)this.Vj).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((android.support.v4.a.a.b)this.Vj).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((android.support.v4.a.a.b)this.Vj).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((android.support.v4.a.a.b)this.Vj).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((android.support.v4.a.a.b)this.Vj).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((android.support.v4.a.a.b)this.Vj).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.Vj;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localb.a(paramActionProvider);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((android.support.v4.a.a.b)this.Vj).setActionView(paramInt);
    View localView = ((android.support.v4.a.a.b)this.Vj).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((android.support.v4.a.a.b)this.Vj).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((android.support.v4.a.a.b)this.Vj).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((android.support.v4.a.a.b)this.Vj).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((android.support.v4.a.a.b)this.Vj).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.Vj).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.Vj).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.Vj).j(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((android.support.v4.a.a.b)this.Vj).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((android.support.v4.a.a.b)this.Vj).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((android.support.v4.a.a.b)this.Vj).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((android.support.v4.a.a.b)this.Vj).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((android.support.v4.a.a.b)this.Vj).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((android.support.v4.a.a.b)this.Vj).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((android.support.v4.a.a.b)this.Vj).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((android.support.v4.a.a.b)this.Vj).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.Vj;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new c(paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localb.setOnActionExpandListener(paramOnActionExpandListener);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    android.support.v4.a.a.b localb = (android.support.v4.a.a.b)this.Vj;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((android.support.v4.a.a.b)this.Vj).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((android.support.v4.a.a.b)this.Vj).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((android.support.v4.a.a.b)this.Vj).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((android.support.v4.a.a.b)this.Vj).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((android.support.v4.a.a.b)this.Vj).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.Vj).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.Vj).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((android.support.v4.a.a.b)this.Vj).k(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((android.support.v4.a.a.b)this.Vj).setVisible(paramBoolean);
  }
  
  class a
    extends android.support.v4.view.b
  {
    final ActionProvider WV;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      this.WV = paramActionProvider;
    }
    
    public final boolean hasSubMenu()
    {
      return this.WV.hasSubMenu();
    }
    
    public final View onCreateActionView()
    {
      return this.WV.onCreateActionView();
    }
    
    public final boolean onPerformDefaultAction()
    {
      return this.WV.onPerformDefaultAction();
    }
    
    public final void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      this.WV.onPrepareSubMenu(k.this.a(paramSubMenu));
    }
  }
  
  static final class b
    extends FrameLayout
    implements android.support.v7.view.c
  {
    final CollapsibleActionView WX;
    
    b(View paramView)
    {
      super();
      this.WX = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    public final void onActionViewCollapsed()
    {
      this.WX.onActionViewCollapsed();
    }
    
    public final void onActionViewExpanded()
    {
      this.WX.onActionViewExpanded();
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
      return ((MenuItem.OnActionExpandListener)this.Vj).onMenuItemActionCollapse(k.this.b(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.Vj).onMenuItemActionExpand(k.this.b(paramMenuItem));
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
      return ((MenuItem.OnMenuItemClickListener)this.Vj).onMenuItemClick(k.this.b(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.k
 * JD-Core Version:    0.7.0.1
 */