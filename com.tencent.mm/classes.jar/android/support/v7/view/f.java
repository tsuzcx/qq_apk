package android.support.v7.view;

import android.content.Context;
import android.support.v4.a.a.a;
import android.support.v4.e.m;
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
  final b TG;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.TG = paramb;
  }
  
  public final void finish()
  {
    this.TG.finish();
  }
  
  public final View getCustomView()
  {
    return this.TG.getCustomView();
  }
  
  public final Menu getMenu()
  {
    return q.a(this.mContext, (a)this.TG.getMenu());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.TG.getMenuInflater();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.TG.getSubtitle();
  }
  
  public final Object getTag()
  {
    return this.TG.lV;
  }
  
  public final CharSequence getTitle()
  {
    return this.TG.getTitle();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.TG.TC;
  }
  
  public final void invalidate()
  {
    this.TG.invalidate();
  }
  
  public final boolean isTitleOptional()
  {
    return this.TG.isTitleOptional();
  }
  
  public final void setCustomView(View paramView)
  {
    this.TG.setCustomView(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.TG.setSubtitle(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.TG.setSubtitle(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.TG.lV = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.TG.setTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.TG.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.TG.setTitleOptionalHint(paramBoolean);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback TH;
    final ArrayList<f> TI;
    final m<Menu, Menu> TJ;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.mContext = paramContext;
      this.TH = paramCallback;
      this.TI = new ArrayList();
      this.TJ = new m();
    }
    
    private Menu b(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.TJ.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = q.a(this.mContext, (a)paramMenu);
        this.TJ.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      this.TH.onDestroyActionMode(b(paramb));
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.TH.onCreateActionMode(b(paramb), b(paramMenu));
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.TH.onActionItemClicked(b(paramb), q.a(this.mContext, (android.support.v4.a.a.b)paramMenuItem));
    }
    
    public final ActionMode b(b paramb)
    {
      int j = this.TI.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.TI.get(i);
        if ((localf != null) && (localf.TG == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.TI.add(paramb);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.TH.onPrepareActionMode(b(paramb), b(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.f
 * JD-Core Version:    0.7.0.1
 */