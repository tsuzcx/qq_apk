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
  final b adI;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.adI = paramb;
  }
  
  public final void finish()
  {
    this.adI.finish();
  }
  
  public final View getCustomView()
  {
    return this.adI.getCustomView();
  }
  
  public final Menu getMenu()
  {
    return q.a(this.mContext, (a)this.adI.getMenu());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.adI.getMenuInflater();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.adI.getSubtitle();
  }
  
  public final Object getTag()
  {
    return this.adI.mTag;
  }
  
  public final CharSequence getTitle()
  {
    return this.adI.getTitle();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.adI.adE;
  }
  
  public final void invalidate()
  {
    this.adI.invalidate();
  }
  
  public final boolean isTitleOptional()
  {
    return this.adI.isTitleOptional();
  }
  
  public final void setCustomView(View paramView)
  {
    this.adI.setCustomView(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.adI.setSubtitle(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.adI.setSubtitle(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.adI.mTag = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.adI.setTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.adI.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.adI.setTitleOptionalHint(paramBoolean);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback adJ;
    final ArrayList<f> adK;
    final n<Menu, Menu> adL;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.mContext = paramContext;
      this.adJ = paramCallback;
      this.adK = new ArrayList();
      this.adL = new n();
    }
    
    private Menu b(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.adL.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = q.a(this.mContext, (a)paramMenu);
        this.adL.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      this.adJ.onDestroyActionMode(b(paramb));
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.adJ.onCreateActionMode(b(paramb), b(paramMenu));
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.adJ.onActionItemClicked(b(paramb), q.a(this.mContext, (android.support.v4.a.a.b)paramMenuItem));
    }
    
    public final ActionMode b(b paramb)
    {
      int j = this.adK.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.adK.get(i);
        if ((localf != null) && (localf.adI == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.adK.add(paramb);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.adJ.onPrepareActionMode(b(paramb), b(paramMenu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.f
 * JD-Core Version:    0.7.0.1
 */