package android.support.v7.view;

import android.content.Context;
import android.support.v4.a.a.a;
import android.support.v4.e.n;
import android.support.v7.view.menu.q;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public final class f
  extends ActionMode
{
  final b adv;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.adv = paramb;
  }
  
  public final void finish()
  {
    this.adv.finish();
  }
  
  public final View getCustomView()
  {
    return this.adv.getCustomView();
  }
  
  public final Menu getMenu()
  {
    return q.a(this.mContext, (a)this.adv.getMenu());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.adv.getMenuInflater();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.adv.getSubtitle();
  }
  
  public final Object getTag()
  {
    return this.adv.mTag;
  }
  
  public final CharSequence getTitle()
  {
    return this.adv.getTitle();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.adv.adr;
  }
  
  public final void invalidate()
  {
    this.adv.invalidate();
  }
  
  public final boolean isTitleOptional()
  {
    return this.adv.isTitleOptional();
  }
  
  public final void setCustomView(View paramView)
  {
    this.adv.setCustomView(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.adv.setSubtitle(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.adv.setSubtitle(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.adv.mTag = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.adv.setTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.adv.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.adv.setTitleOptionalHint(paramBoolean);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback adw;
    final ArrayList<f> adx;
    final n<Menu, Menu> ady;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.mContext = paramContext;
      this.adw = paramCallback;
      this.adx = new ArrayList();
      this.ady = new n();
    }
    
    private Menu b(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.ady.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = q.a(this.mContext, (a)paramMenu);
        this.ady.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      this.adw.onDestroyActionMode(b(paramb));
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.adw.onCreateActionMode(b(paramb), b(paramMenu));
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.adw.onActionItemClicked(b(paramb), q.a(this.mContext, (android.support.v4.a.a.b)paramMenuItem));
    }
    
    public final ActionMode b(b paramb)
    {
      int j = this.adx.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.adx.get(i);
        if ((localf != null) && (localf.adv == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.adx.add(paramb);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.adw.onPrepareActionMode(b(paramb), b(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.f
 * JD-Core Version:    0.7.0.1
 */