package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class ah
  extends ListPopupWindow
  implements ag
{
  private static Method ahv;
  public ag ahw;
  
  static
  {
    try
    {
      ahv = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public ah(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, null, paramInt1, paramInt2);
  }
  
  public final void b(h paramh, MenuItem paramMenuItem)
  {
    if (this.ahw != null) {
      this.ahw.b(paramh, paramMenuItem);
    }
  }
  
  public final void c(h paramh, MenuItem paramMenuItem)
  {
    if (this.ahw != null) {
      this.ahw.c(paramh, paramMenuItem);
    }
  }
  
  final y h(Context paramContext, boolean paramBoolean)
  {
    paramContext = new a(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    return paramContext;
  }
  
  public final void iF()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.aht.setEnterTransition(null);
    }
  }
  
  public final void iG()
  {
    if (ahv != null) {}
    try
    {
      ahv.invoke(this.aht, new Object[] { Boolean.FALSE });
      return;
    }
    catch (Exception localException) {}
  }
  
  public static final class a
    extends y
  {
    private ag ahw;
    final int ahx;
    final int ahy;
    private MenuItem ahz;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
      paramContext = paramContext.getResources().getConfiguration();
      if ((Build.VERSION.SDK_INT >= 17) && (1 == paramContext.getLayoutDirection()))
      {
        this.ahx = 21;
        this.ahy = 22;
        return;
      }
      this.ahx = 22;
      this.ahy = 21;
    }
    
    public final boolean onHoverEvent(MotionEvent paramMotionEvent)
    {
      Object localObject;
      int i;
      if (this.ahw != null)
      {
        localObject = getAdapter();
        if (!(localObject instanceof HeaderViewListAdapter)) {
          break label166;
        }
        localObject = (HeaderViewListAdapter)localObject;
        i = ((HeaderViewListAdapter)localObject).getHeadersCount();
        localObject = (g)((HeaderViewListAdapter)localObject).getWrappedAdapter();
        if (paramMotionEvent.getAction() == 10) {
          break label178;
        }
        int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (j == -1) {
          break label178;
        }
        i = j - i;
        if ((i < 0) || (i >= ((g)localObject).getCount())) {
          break label178;
        }
      }
      label166:
      label178:
      for (j localj = ((g)localObject).bb(i);; localj = null)
      {
        MenuItem localMenuItem = this.ahz;
        if (localMenuItem != localj)
        {
          localObject = ((g)localObject).Wi;
          if (localMenuItem != null) {
            this.ahw.b((h)localObject, localMenuItem);
          }
          this.ahz = localj;
          if (localj != null) {
            this.ahw.c((h)localObject, localj);
          }
        }
        return super.onHoverEvent(paramMotionEvent);
        i = 0;
        localObject = (g)localObject;
        break;
      }
    }
    
    public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
      ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
      if ((localListMenuItemView != null) && (paramInt == this.ahx))
      {
        if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
          performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
        }
        return true;
      }
      if ((localListMenuItemView != null) && (paramInt == this.ahy))
      {
        setSelection(-1);
        ((g)getAdapter()).Wi.V(false);
        return true;
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    
    public final void setHoverListener(ag paramag)
    {
      this.ahw = paramag;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ah
 * JD-Core Version:    0.7.0.1
 */