package android.support.v7.view;

import android.content.Context;
import android.support.v4.b.a.a;
import android.support.v4.f.m;
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
  final b SW;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.SW = paramb;
  }
  
  public final void finish()
  {
    this.SW.finish();
  }
  
  public final View getCustomView()
  {
    return this.SW.getCustomView();
  }
  
  public final Menu getMenu()
  {
    return q.a(this.mContext, (a)this.SW.getMenu());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.SW.getMenuInflater();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.SW.getSubtitle();
  }
  
  public final Object getTag()
  {
    return this.SW.kY;
  }
  
  public final CharSequence getTitle()
  {
    return this.SW.getTitle();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.SW.SS;
  }
  
  public final void invalidate()
  {
    this.SW.invalidate();
  }
  
  public final boolean isTitleOptional()
  {
    return this.SW.isTitleOptional();
  }
  
  public final void setCustomView(View paramView)
  {
    this.SW.setCustomView(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.SW.setSubtitle(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.SW.setSubtitle(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.SW.kY = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.SW.setTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.SW.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.SW.setTitleOptionalHint(paramBoolean);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback SX;
    final ArrayList<f> SY;
    final m<Menu, Menu> SZ;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.mContext = paramContext;
      this.SX = paramCallback;
      this.SY = new ArrayList();
      this.SZ = new m();
    }
    
    private Menu b(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.SZ.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = q.a(this.mContext, (a)paramMenu);
        this.SZ.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      this.SX.onDestroyActionMode(b(paramb));
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.SX.onCreateActionMode(b(paramb), b(paramMenu));
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.SX.onActionItemClicked(b(paramb), q.a(this.mContext, (android.support.v4.b.a.b)paramMenuItem));
    }
    
    public final ActionMode b(b paramb)
    {
      int j = this.SY.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.SY.get(i);
        if ((localf != null) && (localf.SW == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.SY.add(paramb);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.SX.onPrepareActionMode(b(paramb), b(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.f
 * JD-Core Version:    0.7.0.1
 */