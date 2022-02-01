package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class t
  extends ListPopupWindow
  implements s
{
  private static Method uz;
  public s uA;
  
  static
  {
    AppMethodBeat.i(199742);
    try
    {
      uz = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
      AppMethodBeat.o(199742);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(199742);
    }
  }
  
  public t(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, null, paramInt1, paramInt2);
  }
  
  public final void b(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(199809);
    if (this.uA != null) {
      this.uA.b(paramh, paramMenuItem);
    }
    AppMethodBeat.o(199809);
  }
  
  public final void c(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(199796);
    if (this.uA != null) {
      this.uA.c(paramh, paramMenuItem);
    }
    AppMethodBeat.o(199796);
  }
  
  public final void eR()
  {
    AppMethodBeat.i(199771);
    if (Build.VERSION.SDK_INT >= 23) {
      this.ux.setEnterTransition(null);
    }
    AppMethodBeat.o(199771);
  }
  
  public final void eS()
  {
    AppMethodBeat.i(199784);
    if (uz != null) {
      try
      {
        uz.invoke(this.ux, new Object[] { Boolean.FALSE });
        AppMethodBeat.o(199784);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(199784);
  }
  
  final p h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(199759);
    paramContext = new a(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    AppMethodBeat.o(199759);
    return paramContext;
  }
  
  public static final class a
    extends p
  {
    private s uA;
    final int uB;
    final int uC;
    private MenuItem uD;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
      AppMethodBeat.i(199422);
      paramContext = paramContext.getResources().getConfiguration();
      if ((Build.VERSION.SDK_INT >= 17) && (1 == paramContext.getLayoutDirection()))
      {
        this.uB = 21;
        this.uC = 22;
        AppMethodBeat.o(199422);
        return;
      }
      this.uB = 22;
      this.uC = 21;
      AppMethodBeat.o(199422);
    }
    
    public final boolean onHoverEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(199450);
      Object localObject;
      int i;
      if (this.uA != null)
      {
        localObject = getAdapter();
        if (!(localObject instanceof HeaderViewListAdapter)) {
          break label180;
        }
        localObject = (HeaderViewListAdapter)localObject;
        i = ((HeaderViewListAdapter)localObject).getHeadersCount();
        localObject = (g)((HeaderViewListAdapter)localObject).getWrappedAdapter();
        if (paramMotionEvent.getAction() == 10) {
          break label192;
        }
        int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (j == -1) {
          break label192;
        }
        i = j - i;
        if ((i < 0) || (i >= ((g)localObject).getCount())) {
          break label192;
        }
      }
      label180:
      label192:
      for (j localj = ((g)localObject).ag(i);; localj = null)
      {
        MenuItem localMenuItem = this.uD;
        if (localMenuItem != localj)
        {
          localObject = ((g)localObject).nv;
          if (localMenuItem != null) {
            this.uA.b((h)localObject, localMenuItem);
          }
          this.uD = localj;
          if (localj != null) {
            this.uA.c((h)localObject, localj);
          }
        }
        boolean bool = super.onHoverEvent(paramMotionEvent);
        AppMethodBeat.o(199450);
        return bool;
        i = 0;
        localObject = (g)localObject;
        break;
      }
    }
    
    public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(199438);
      ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
      if ((localListMenuItemView != null) && (paramInt == this.uB))
      {
        if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
          performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
        }
        AppMethodBeat.o(199438);
        return true;
      }
      if ((localListMenuItemView != null) && (paramInt == this.uC))
      {
        setSelection(-1);
        ((g)getAdapter()).nv.K(false);
        AppMethodBeat.o(199438);
        return true;
      }
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(199438);
      return bool;
    }
    
    public final void setHoverListener(s params)
    {
      this.uA = params;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.t
 * JD-Core Version:    0.7.0.1
 */