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
  final b aaJ;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.aaJ = paramb;
  }
  
  public final void finish()
  {
    this.aaJ.finish();
  }
  
  public final View getCustomView()
  {
    return this.aaJ.getCustomView();
  }
  
  public final Menu getMenu()
  {
    return q.a(this.mContext, (a)this.aaJ.getMenu());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.aaJ.getMenuInflater();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.aaJ.getSubtitle();
  }
  
  public final Object getTag()
  {
    return this.aaJ.mTag;
  }
  
  public final CharSequence getTitle()
  {
    return this.aaJ.getTitle();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.aaJ.aaF;
  }
  
  public final void invalidate()
  {
    this.aaJ.invalidate();
  }
  
  public final boolean isTitleOptional()
  {
    return this.aaJ.isTitleOptional();
  }
  
  public final void setCustomView(View paramView)
  {
    this.aaJ.setCustomView(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.aaJ.setSubtitle(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.aaJ.setSubtitle(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.aaJ.mTag = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.aaJ.setTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.aaJ.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.aaJ.setTitleOptionalHint(paramBoolean);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback aaK;
    final ArrayList<f> aaL;
    final n<Menu, Menu> aaM;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.mContext = paramContext;
      this.aaK = paramCallback;
      this.aaL = new ArrayList();
      this.aaM = new n();
    }
    
    private Menu b(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.aaM.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = q.a(this.mContext, (a)paramMenu);
        this.aaM.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      this.aaK.onDestroyActionMode(b(paramb));
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.aaK.onCreateActionMode(b(paramb), b(paramMenu));
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.aaK.onActionItemClicked(b(paramb), q.a(this.mContext, (android.support.v4.a.a.b)paramMenuItem));
    }
    
    public final ActionMode b(b paramb)
    {
      int j = this.aaL.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.aaL.get(i);
        if ((localf != null) && (localf.aaJ == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.aaL.add(paramb);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.aaK.onPrepareActionMode(b(paramb), b(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.f
 * JD-Core Version:    0.7.0.1
 */