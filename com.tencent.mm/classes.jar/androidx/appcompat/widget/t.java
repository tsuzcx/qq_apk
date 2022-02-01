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
  private static Method tA;
  public s tB;
  
  static
  {
    AppMethodBeat.i(241451);
    try
    {
      tA = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
      AppMethodBeat.o(241451);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(241451);
    }
  }
  
  public t(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, null, paramInt1, paramInt2);
  }
  
  public final void b(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(241449);
    if (this.tB != null) {
      this.tB.b(paramh, paramMenuItem);
    }
    AppMethodBeat.o(241449);
  }
  
  public final void c(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(241448);
    if (this.tB != null) {
      this.tB.c(paramh, paramMenuItem);
    }
    AppMethodBeat.o(241448);
  }
  
  public final void dR()
  {
    AppMethodBeat.i(241444);
    if (Build.VERSION.SDK_INT >= 23) {
      this.ty.setEnterTransition(null);
    }
    AppMethodBeat.o(241444);
  }
  
  public final void dS()
  {
    AppMethodBeat.i(241446);
    if (tA != null) {
      try
      {
        tA.invoke(this.ty, new Object[] { Boolean.FALSE });
        AppMethodBeat.o(241446);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(241446);
  }
  
  final p h(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(241443);
    paramContext = new a(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    AppMethodBeat.o(241443);
    return paramContext;
  }
  
  public static final class a
    extends p
  {
    private s tB;
    final int tC;
    final int tD;
    private MenuItem tE;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
      AppMethodBeat.i(241428);
      paramContext = paramContext.getResources().getConfiguration();
      if ((Build.VERSION.SDK_INT >= 17) && (1 == paramContext.getLayoutDirection()))
      {
        this.tC = 21;
        this.tD = 22;
        AppMethodBeat.o(241428);
        return;
      }
      this.tC = 22;
      this.tD = 21;
      AppMethodBeat.o(241428);
    }
    
    public final boolean onHoverEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(241430);
      Object localObject;
      int i;
      if (this.tB != null)
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
      for (j localj = ((g)localObject).ai(i);; localj = null)
      {
        MenuItem localMenuItem = this.tE;
        if (localMenuItem != localj)
        {
          localObject = ((g)localObject).mw;
          if (localMenuItem != null) {
            this.tB.b((h)localObject, localMenuItem);
          }
          this.tE = localj;
          if (localj != null) {
            this.tB.c((h)localObject, localj);
          }
        }
        boolean bool = super.onHoverEvent(paramMotionEvent);
        AppMethodBeat.o(241430);
        return bool;
        i = 0;
        localObject = (g)localObject;
        break;
      }
    }
    
    public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(241429);
      ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
      if ((localListMenuItemView != null) && (paramInt == this.tC))
      {
        if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
          performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
        }
        AppMethodBeat.o(241429);
        return true;
      }
      if ((localListMenuItemView != null) && (paramInt == this.tD))
      {
        setSelection(-1);
        ((g)getAdapter()).mw.G(false);
        AppMethodBeat.o(241429);
        return true;
      }
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(241429);
      return bool;
    }
    
    public final void setHoverListener(s params)
    {
      this.tB = params;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.t
 * JD-Core Version:    0.7.0.1
 */