package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import java.util.List;
import junit.framework.Assert;

public final class i$a
  extends BaseAdapter
{
  List<Integer> kZk = null;
  View.OnClickListener lze;
  private Context mContext;
  
  public i$a(Context paramContext)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mContext = paramContext;
      return;
    }
  }
  
  public final int getCount()
  {
    if (this.kZk == null) {
      return 0;
    }
    return this.kZk.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.kZk != null) {
      return this.kZk.get(paramInt);
    }
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R.i.ipcall_share_grid_view_item, paramViewGroup, false);
      paramViewGroup = new i.a.a(this);
      paramViewGroup.lzg = ((RelativeLayout)paramView.findViewById(R.h.layout));
      paramViewGroup.lzh = ((TextView)paramView.findViewById(R.h.ipcall_share_item_title));
      paramViewGroup.lzi = ((ImageView)paramView.findViewById(R.h.ipcall_share_item_icon));
      paramView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localObject = getItem(paramInt);
      if (localObject != null) {
        break;
      }
      return paramView;
      paramViewGroup = (i.a.a)paramView.getTag();
    }
    paramViewGroup.id = ((Integer)localObject).intValue();
    IPCallShareCouponCardUI.a(this.mContext, paramViewGroup.id, paramViewGroup.lzh, paramViewGroup.lzi);
    paramViewGroup.lzg.setOnClickListener(new i.a.1(this));
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i.a
 * JD-Core Version:    0.7.0.1
 */