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
  final b kL;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.kL = paramb;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(200696);
    this.kL.finish();
    AppMethodBeat.o(200696);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(200755);
    View localView = this.kL.getCustomView();
    AppMethodBeat.o(200755);
    return localView;
  }
  
  public final Menu getMenu()
  {
    AppMethodBeat.i(200705);
    Menu localMenu = q.a(this.mContext, (a)this.kL.getMenu());
    AppMethodBeat.o(200705);
    return localMenu;
  }
  
  public final MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(200777);
    MenuInflater localMenuInflater = this.kL.getMenuInflater();
    AppMethodBeat.o(200777);
    return localMenuInflater;
  }
  
  public final CharSequence getSubtitle()
  {
    AppMethodBeat.i(200736);
    CharSequence localCharSequence = this.kL.getSubtitle();
    AppMethodBeat.o(200736);
    return localCharSequence;
  }
  
  public final Object getTag()
  {
    return this.kL.mTag;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(200715);
    CharSequence localCharSequence = this.kL.getTitle();
    AppMethodBeat.o(200715);
    return localCharSequence;
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.kL.kH;
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(200686);
    this.kL.invalidate();
    AppMethodBeat.o(200686);
  }
  
  public final boolean isTitleOptional()
  {
    AppMethodBeat.i(200804);
    boolean bool = this.kL.isTitleOptional();
    AppMethodBeat.o(200804);
    return bool;
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(200764);
    this.kL.setCustomView(paramView);
    AppMethodBeat.o(200764);
  }
  
  public final void setSubtitle(int paramInt)
  {
    AppMethodBeat.i(200747);
    this.kL.setSubtitle(paramInt);
    AppMethodBeat.o(200747);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200677);
    this.kL.setSubtitle(paramCharSequence);
    AppMethodBeat.o(200677);
  }
  
  public final void setTag(Object paramObject)
  {
    this.kL.mTag = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(200724);
    this.kL.setTitle(paramInt);
    AppMethodBeat.o(200724);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200668);
    this.kL.setTitle(paramCharSequence);
    AppMethodBeat.o(200668);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    AppMethodBeat.i(200795);
    this.kL.setTitleOptionalHint(paramBoolean);
    AppMethodBeat.o(200795);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback kM;
    final ArrayList<f> kN;
    final g<Menu, Menu> kO;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      AppMethodBeat.i(200711);
      this.mContext = paramContext;
      this.kM = paramCallback;
      this.kN = new ArrayList();
      this.kO = new g();
      AppMethodBeat.o(200711);
    }
    
    private Menu b(Menu paramMenu)
    {
      AppMethodBeat.i(200726);
      Menu localMenu2 = (Menu)this.kO.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = q.a(this.mContext, (a)paramMenu);
        this.kO.put(paramMenu, localMenu1);
      }
      AppMethodBeat.o(200726);
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(200773);
      this.kM.onDestroyActionMode(b(paramb));
      AppMethodBeat.o(200773);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(200737);
      boolean bool = this.kM.onCreateActionMode(b(paramb), b(paramMenu));
      AppMethodBeat.o(200737);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(200760);
      boolean bool = this.kM.onActionItemClicked(b(paramb), q.a(this.mContext, (androidx.core.a.a.b)paramMenuItem));
      AppMethodBeat.o(200760);
      return bool;
    }
    
    public final ActionMode b(b paramb)
    {
      AppMethodBeat.i(200786);
      int j = this.kN.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.kN.get(i);
        if ((localf != null) && (localf.kL == paramb))
        {
          AppMethodBeat.o(200786);
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.kN.add(paramb);
      AppMethodBeat.o(200786);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(200749);
      boolean bool = this.kM.onPrepareActionMode(b(paramb), b(paramMenu));
      AppMethodBeat.o(200749);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.f
 * JD-Core Version:    0.7.0.1
 */