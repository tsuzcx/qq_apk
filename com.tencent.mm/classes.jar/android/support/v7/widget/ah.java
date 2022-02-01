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
  private static Method apy;
  public ag apz;
  
  static
  {
    try
    {
      apy = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
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
    if (this.apz != null) {
      this.apz.b(paramh, paramMenuItem);
    }
  }
  
  public final void c(h paramh, MenuItem paramMenuItem)
  {
    if (this.apz != null) {
      this.apz.c(paramh, paramMenuItem);
    }
  }
  
  final y i(Context paramContext, boolean paramBoolean)
  {
    paramContext = new a(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    return paramContext;
  }
  
  public final void ki()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.apw.setEnterTransition(null);
    }
  }
  
  public final void kj()
  {
    if (apy != null) {}
    try
    {
      apy.invoke(this.apw, new Object[] { Boolean.FALSE });
      return;
    }
    catch (Exception localException) {}
  }
  
  public static final class a
    extends y
  {
    final int apA;
    final int apB;
    private MenuItem apC;
    private ag apz;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
      paramContext = paramContext.getResources().getConfiguration();
      if ((Build.VERSION.SDK_INT >= 17) && (1 == paramContext.getLayoutDirection()))
      {
        this.apA = 21;
        this.apB = 22;
        return;
      }
      this.apA = 22;
      this.apB = 21;
    }
    
    public final boolean onHoverEvent(MotionEvent paramMotionEvent)
    {
      Object localObject;
      int i;
      if (this.apz != null)
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
      for (j localj = ((g)localObject).bu(i);; localj = null)
      {
        MenuItem localMenuItem = this.apC;
        if (localMenuItem != localj)
        {
          localObject = ((g)localObject).aei;
          if (localMenuItem != null) {
            this.apz.b((h)localObject, localMenuItem);
          }
          this.apC = localj;
          if (localj != null) {
            this.apz.c((h)localObject, localj);
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
      if ((localListMenuItemView != null) && (paramInt == this.apA))
      {
        if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
          performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
        }
        return true;
      }
      if ((localListMenuItemView != null) && (paramInt == this.apB))
      {
        setSelection(-1);
        ((g)getAdapter()).aei.ab(false);
        return true;
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    
    public final void setHoverListener(ag paramag)
    {
      this.apz = paramag;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ah
 * JD-Core Version:    0.7.0.1
 */