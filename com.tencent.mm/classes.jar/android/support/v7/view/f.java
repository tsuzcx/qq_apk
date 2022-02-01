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
  final b abE;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.abE = paramb;
  }
  
  public final void finish()
  {
    this.abE.finish();
  }
  
  public final View getCustomView()
  {
    return this.abE.getCustomView();
  }
  
  public final Menu getMenu()
  {
    return q.a(this.mContext, (a)this.abE.getMenu());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.abE.getMenuInflater();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.abE.getSubtitle();
  }
  
  public final Object getTag()
  {
    return this.abE.mTag;
  }
  
  public final CharSequence getTitle()
  {
    return this.abE.getTitle();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.abE.abA;
  }
  
  public final void invalidate()
  {
    this.abE.invalidate();
  }
  
  public final boolean isTitleOptional()
  {
    return this.abE.isTitleOptional();
  }
  
  public final void setCustomView(View paramView)
  {
    this.abE.setCustomView(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.abE.setSubtitle(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.abE.setSubtitle(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.abE.mTag = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.abE.setTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.abE.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.abE.setTitleOptionalHint(paramBoolean);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback abF;
    final ArrayList<f> abG;
    final n<Menu, Menu> abH;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.mContext = paramContext;
      this.abF = paramCallback;
      this.abG = new ArrayList();
      this.abH = new n();
    }
    
    private Menu b(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.abH.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = q.a(this.mContext, (a)paramMenu);
        this.abH.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      this.abF.onDestroyActionMode(b(paramb));
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.abF.onCreateActionMode(b(paramb), b(paramMenu));
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.abF.onActionItemClicked(b(paramb), q.a(this.mContext, (android.support.v4.a.a.b)paramMenuItem));
    }
    
    public final ActionMode b(b paramb)
    {
      int j = this.abG.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.abG.get(i);
        if ((localf != null) && (localf.abE == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.abG.add(paramb);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.abF.onPrepareActionMode(b(paramb), b(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.f
 * JD-Core Version:    0.7.0.1
 */