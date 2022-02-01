package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.q;
import androidx.b.g;
import androidx.core.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class f
  extends ActionMode
{
  final b jP;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.jP = paramb;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(238957);
    this.jP.finish();
    AppMethodBeat.o(238957);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(238965);
    View localView = this.jP.getCustomView();
    AppMethodBeat.o(238965);
    return localView;
  }
  
  public final Menu getMenu()
  {
    AppMethodBeat.i(238958);
    Menu localMenu = q.a(this.mContext, (a)this.jP.getMenu());
    AppMethodBeat.o(238958);
    return localMenu;
  }
  
  public final MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(238967);
    MenuInflater localMenuInflater = this.jP.getMenuInflater();
    AppMethodBeat.o(238967);
    return localMenuInflater;
  }
  
  public final CharSequence getSubtitle()
  {
    AppMethodBeat.i(238962);
    CharSequence localCharSequence = this.jP.getSubtitle();
    AppMethodBeat.o(238962);
    return localCharSequence;
  }
  
  public final Object getTag()
  {
    return this.jP.mTag;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(238959);
    CharSequence localCharSequence = this.jP.getTitle();
    AppMethodBeat.o(238959);
    return localCharSequence;
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.jP.jL;
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(238955);
    this.jP.invalidate();
    AppMethodBeat.o(238955);
  }
  
  public final boolean isTitleOptional()
  {
    AppMethodBeat.i(238969);
    boolean bool = this.jP.isTitleOptional();
    AppMethodBeat.o(238969);
    return bool;
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(238966);
    this.jP.setCustomView(paramView);
    AppMethodBeat.o(238966);
  }
  
  public final void setSubtitle(int paramInt)
  {
    AppMethodBeat.i(238963);
    this.jP.setSubtitle(paramInt);
    AppMethodBeat.o(238963);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238954);
    this.jP.setSubtitle(paramCharSequence);
    AppMethodBeat.o(238954);
  }
  
  public final void setTag(Object paramObject)
  {
    this.jP.mTag = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(238961);
    this.jP.setTitle(paramInt);
    AppMethodBeat.o(238961);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238951);
    this.jP.setTitle(paramCharSequence);
    AppMethodBeat.o(238951);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    AppMethodBeat.i(238968);
    this.jP.setTitleOptionalHint(paramBoolean);
    AppMethodBeat.o(238968);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback jQ;
    final ArrayList<f> jR;
    final g<Menu, Menu> jS;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      AppMethodBeat.i(238939);
      this.mContext = paramContext;
      this.jQ = paramCallback;
      this.jR = new ArrayList();
      this.jS = new g();
      AppMethodBeat.o(238939);
    }
    
    private Menu b(Menu paramMenu)
    {
      AppMethodBeat.i(238946);
      Menu localMenu2 = (Menu)this.jS.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = q.a(this.mContext, (a)paramMenu);
        this.jS.put(paramMenu, localMenu1);
      }
      AppMethodBeat.o(238946);
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(238944);
      this.jQ.onDestroyActionMode(b(paramb));
      AppMethodBeat.o(238944);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(238941);
      boolean bool = this.jQ.onCreateActionMode(b(paramb), b(paramMenu));
      AppMethodBeat.o(238941);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(238943);
      boolean bool = this.jQ.onActionItemClicked(b(paramb), q.a(this.mContext, (androidx.core.a.a.b)paramMenuItem));
      AppMethodBeat.o(238943);
      return bool;
    }
    
    public final ActionMode b(b paramb)
    {
      AppMethodBeat.i(238947);
      int j = this.jR.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.jR.get(i);
        if ((localf != null) && (localf.jP == paramb))
        {
          AppMethodBeat.o(238947);
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.jR.add(paramb);
      AppMethodBeat.o(238947);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(238942);
      boolean bool = this.jQ.onPrepareActionMode(b(paramb), b(paramMenu));
      AppMethodBeat.o(238942);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.f
 * JD-Core Version:    0.7.0.1
 */