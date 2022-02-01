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
import androidx.core.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class k
  extends c<b>
  implements MenuItem
{
  public Method og;
  
  k(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  k.a a(ActionProvider paramActionProvider)
  {
    AppMethodBeat.i(201393);
    paramActionProvider = new k.a(this, this.mContext, paramActionProvider);
    AppMethodBeat.o(201393);
    return paramActionProvider;
  }
  
  public boolean collapseActionView()
  {
    AppMethodBeat.i(201316);
    boolean bool = ((b)this.mr).collapseActionView();
    AppMethodBeat.o(201316);
    return bool;
  }
  
  public boolean expandActionView()
  {
    AppMethodBeat.i(201307);
    boolean bool = ((b)this.mr).expandActionView();
    AppMethodBeat.o(201307);
    return bool;
  }
  
  public ActionProvider getActionProvider()
  {
    AppMethodBeat.i(201297);
    Object localObject = ((b)this.mr).cB();
    if ((localObject instanceof k.a))
    {
      localObject = ((k.a)localObject).oh;
      AppMethodBeat.o(201297);
      return localObject;
    }
    AppMethodBeat.o(201297);
    return null;
  }
  
  public View getActionView()
  {
    AppMethodBeat.i(201281);
    View localView = ((b)this.mr).getActionView();
    if ((localView instanceof b))
    {
      localView = (View)((b)localView).oj;
      AppMethodBeat.o(201281);
      return localView;
    }
    AppMethodBeat.o(201281);
    return localView;
  }
  
  public int getAlphabeticModifiers()
  {
    AppMethodBeat.i(201143);
    int i = ((b)this.mr).getAlphabeticModifiers();
    AppMethodBeat.o(201143);
    return i;
  }
  
  public char getAlphabeticShortcut()
  {
    AppMethodBeat.i(201133);
    char c = ((b)this.mr).getAlphabeticShortcut();
    AppMethodBeat.o(201133);
    return c;
  }
  
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(201343);
    CharSequence localCharSequence = ((b)this.mr).getContentDescription();
    AppMethodBeat.o(201343);
    return localCharSequence;
  }
  
  public int getGroupId()
  {
    AppMethodBeat.i(200970);
    int i = ((b)this.mr).getGroupId();
    AppMethodBeat.o(200970);
    return i;
  }
  
  public Drawable getIcon()
  {
    AppMethodBeat.i(201047);
    Drawable localDrawable = ((b)this.mr).getIcon();
    AppMethodBeat.o(201047);
    return localDrawable;
  }
  
  public ColorStateList getIconTintList()
  {
    AppMethodBeat.i(201373);
    ColorStateList localColorStateList = ((b)this.mr).getIconTintList();
    AppMethodBeat.o(201373);
    return localColorStateList;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    AppMethodBeat.i(201384);
    PorterDuff.Mode localMode = ((b)this.mr).getIconTintMode();
    AppMethodBeat.o(201384);
    return localMode;
  }
  
  public Intent getIntent()
  {
    AppMethodBeat.i(201076);
    Intent localIntent = ((b)this.mr).getIntent();
    AppMethodBeat.o(201076);
    return localIntent;
  }
  
  public int getItemId()
  {
    AppMethodBeat.i(200956);
    int i = ((b)this.mr).getItemId();
    AppMethodBeat.o(200956);
    return i;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    AppMethodBeat.i(201237);
    ContextMenu.ContextMenuInfo localContextMenuInfo = ((b)this.mr).getMenuInfo();
    AppMethodBeat.o(201237);
    return localContextMenuInfo;
  }
  
  public int getNumericModifiers()
  {
    AppMethodBeat.i(201108);
    int i = ((b)this.mr).getNumericModifiers();
    AppMethodBeat.o(201108);
    return i;
  }
  
  public char getNumericShortcut()
  {
    AppMethodBeat.i(201104);
    char c = ((b)this.mr).getNumericShortcut();
    AppMethodBeat.o(201104);
    return c;
  }
  
  public int getOrder()
  {
    AppMethodBeat.i(200983);
    int i = ((b)this.mr).getOrder();
    AppMethodBeat.o(200983);
    return i;
  }
  
  public SubMenu getSubMenu()
  {
    AppMethodBeat.i(201215);
    SubMenu localSubMenu = a(((b)this.mr).getSubMenu());
    AppMethodBeat.o(201215);
    return localSubMenu;
  }
  
  public CharSequence getTitle()
  {
    AppMethodBeat.i(201014);
    CharSequence localCharSequence = ((b)this.mr).getTitle();
    AppMethodBeat.o(201014);
    return localCharSequence;
  }
  
  public CharSequence getTitleCondensed()
  {
    AppMethodBeat.i(201032);
    CharSequence localCharSequence = ((b)this.mr).getTitleCondensed();
    AppMethodBeat.o(201032);
    return localCharSequence;
  }
  
  public CharSequence getTooltipText()
  {
    AppMethodBeat.i(201359);
    CharSequence localCharSequence = ((b)this.mr).getTooltipText();
    AppMethodBeat.o(201359);
    return localCharSequence;
  }
  
  public boolean hasSubMenu()
  {
    AppMethodBeat.i(201208);
    boolean bool = ((b)this.mr).hasSubMenu();
    AppMethodBeat.o(201208);
    return bool;
  }
  
  public boolean isActionViewExpanded()
  {
    AppMethodBeat.i(201319);
    boolean bool = ((b)this.mr).isActionViewExpanded();
    AppMethodBeat.o(201319);
    return bool;
  }
  
  public boolean isCheckable()
  {
    AppMethodBeat.i(201157);
    boolean bool = ((b)this.mr).isCheckable();
    AppMethodBeat.o(201157);
    return bool;
  }
  
  public boolean isChecked()
  {
    AppMethodBeat.i(201174);
    boolean bool = ((b)this.mr).isChecked();
    AppMethodBeat.o(201174);
    return bool;
  }
  
  public boolean isEnabled()
  {
    AppMethodBeat.i(201200);
    boolean bool = ((b)this.mr).isEnabled();
    AppMethodBeat.o(201200);
    return bool;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(201190);
    boolean bool = ((b)this.mr).isVisible();
    AppMethodBeat.o(201190);
    return bool;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    AppMethodBeat.i(201290);
    b localb = (b)this.mr;
    if (paramActionProvider != null) {}
    for (paramActionProvider = a(paramActionProvider);; paramActionProvider = null)
    {
      localb.a(paramActionProvider);
      AppMethodBeat.o(201290);
      return this;
    }
  }
  
  public MenuItem setActionView(int paramInt)
  {
    AppMethodBeat.i(201273);
    ((b)this.mr).setActionView(paramInt);
    View localView = ((b)this.mr).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((b)this.mr).setActionView(new b(localView));
    }
    AppMethodBeat.o(201273);
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    AppMethodBeat.i(201262);
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((b)this.mr).setActionView((View)localObject);
    AppMethodBeat.o(201262);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    AppMethodBeat.i(201116);
    ((b)this.mr).setAlphabeticShortcut(paramChar);
    AppMethodBeat.o(201116);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(201123);
    ((b)this.mr).setAlphabeticShortcut(paramChar, paramInt);
    AppMethodBeat.o(201123);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(201149);
    ((b)this.mr).setCheckable(paramBoolean);
    AppMethodBeat.o(201149);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(201166);
    ((b)this.mr).setChecked(paramBoolean);
    AppMethodBeat.o(201166);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201335);
    ((b)this.mr).b(paramCharSequence);
    AppMethodBeat.o(201335);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(201194);
    ((b)this.mr).setEnabled(paramBoolean);
    AppMethodBeat.o(201194);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    AppMethodBeat.i(201042);
    ((b)this.mr).setIcon(paramInt);
    AppMethodBeat.o(201042);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(201036);
    ((b)this.mr).setIcon(paramDrawable);
    AppMethodBeat.o(201036);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(201368);
    ((b)this.mr).setIconTintList(paramColorStateList);
    AppMethodBeat.o(201368);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(201378);
    ((b)this.mr).setIconTintMode(paramMode);
    AppMethodBeat.o(201378);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    AppMethodBeat.i(201059);
    ((b)this.mr).setIntent(paramIntent);
    AppMethodBeat.o(201059);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    AppMethodBeat.i(201096);
    ((b)this.mr).setNumericShortcut(paramChar);
    AppMethodBeat.o(201096);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    AppMethodBeat.i(201098);
    ((b)this.mr).setNumericShortcut(paramChar, paramInt);
    AppMethodBeat.o(201098);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    AppMethodBeat.i(201328);
    b localb = (b)this.mr;
    if (paramOnActionExpandListener != null) {}
    for (paramOnActionExpandListener = new k.c(this, paramOnActionExpandListener);; paramOnActionExpandListener = null)
    {
      localb.setOnActionExpandListener(paramOnActionExpandListener);
      AppMethodBeat.o(201328);
      return this;
    }
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(201228);
    b localb = (b)this.mr;
    if (paramOnMenuItemClickListener != null) {}
    for (paramOnMenuItemClickListener = new k.d(this, paramOnMenuItemClickListener);; paramOnMenuItemClickListener = null)
    {
      localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
      AppMethodBeat.o(201228);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(201082);
    ((b)this.mr).setShortcut(paramChar1, paramChar2);
    AppMethodBeat.o(201082);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201089);
    ((b)this.mr).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    AppMethodBeat.o(201089);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    AppMethodBeat.i(201242);
    ((b)this.mr).setShowAsAction(paramInt);
    AppMethodBeat.o(201242);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    AppMethodBeat.i(201252);
    ((b)this.mr).setShowAsActionFlags(paramInt);
    AppMethodBeat.o(201252);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    AppMethodBeat.i(201003);
    ((b)this.mr).setTitle(paramInt);
    AppMethodBeat.o(201003);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200994);
    ((b)this.mr).setTitle(paramCharSequence);
    AppMethodBeat.o(200994);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201023);
    ((b)this.mr).setTitleCondensed(paramCharSequence);
    AppMethodBeat.o(201023);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201352);
    ((b)this.mr).c(paramCharSequence);
    AppMethodBeat.o(201352);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(201181);
    MenuItem localMenuItem = ((b)this.mr).setVisible(paramBoolean);
    AppMethodBeat.o(201181);
    return localMenuItem;
  }
  
  static final class b
    extends FrameLayout
    implements androidx.appcompat.view.c
  {
    final CollapsibleActionView oj;
    
    b(View paramView)
    {
      super();
      AppMethodBeat.i(200791);
      this.oj = ((CollapsibleActionView)paramView);
      addView(paramView);
      AppMethodBeat.o(200791);
    }
    
    public final void cu()
    {
      AppMethodBeat.i(200803);
      this.oj.onActionViewExpanded();
      AppMethodBeat.o(200803);
    }
    
    public final void cv()
    {
      AppMethodBeat.i(200812);
      this.oj.onActionViewCollapsed();
      AppMethodBeat.o(200812);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.k
 * JD-Core Version:    0.7.0.1
 */