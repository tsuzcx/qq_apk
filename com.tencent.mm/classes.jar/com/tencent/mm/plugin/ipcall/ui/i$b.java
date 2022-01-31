package com.tencent.mm.plugin.ipcall.ui;

import android.support.v4.view.n;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i$b
  extends n
{
  View.OnClickListener lze;
  LinkedList<Integer> lzj;
  ArrayList<View> lzk = new ArrayList();
  int mCount = 0;
  
  public i$b(i parami) {}
  
  public final int F(Object paramObject)
  {
    return super.F(paramObject);
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    y.v("MicroMsg.IPCallShareDialog", "destroy item: %d", new Object[] { Integer.valueOf(paramInt) });
    paramViewGroup.removeView((View)paramObject);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.lzk.get(paramInt) != null) {}
    for (View localView = (View)this.lzk.get(paramInt);; localView = null)
    {
      if (localView != null)
      {
        if (localView.getParent() != null) {
          ((ViewGroup)localView.getParent()).removeView(localView);
        }
        if (paramViewGroup != null) {
          paramViewGroup.addView(localView, 0);
        }
      }
      return localView;
    }
  }
  
  public final int getCount()
  {
    return this.mCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i.b
 * JD-Core Version:    0.7.0.1
 */