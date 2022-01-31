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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import junit.framework.Assert;

public final class i$a
  extends BaseAdapter
{
  private Context mContext;
  View.OnClickListener nWq;
  List<Integer> nxh;
  
  public i$a(Context paramContext)
  {
    AppMethodBeat.i(22345);
    this.nxh = null;
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mContext = paramContext;
      AppMethodBeat.o(22345);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22346);
    if (this.nxh == null)
    {
      AppMethodBeat.o(22346);
      return 0;
    }
    int i = this.nxh.size();
    AppMethodBeat.o(22346);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(22347);
    if (this.nxh != null)
    {
      Object localObject = this.nxh.get(paramInt);
      AppMethodBeat.o(22347);
      return localObject;
    }
    AppMethodBeat.o(22347);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22348);
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130969949, paramViewGroup, false);
      paramViewGroup = new i.a.a(this);
      paramViewGroup.nWs = ((RelativeLayout)paramView.findViewById(2131824370));
      paramViewGroup.nWt = ((TextView)paramView.findViewById(2131825328));
      paramViewGroup.nWu = ((ImageView)paramView.findViewById(2131825327));
      paramView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localObject = getItem(paramInt);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(22348);
      return paramView;
      paramViewGroup = (i.a.a)paramView.getTag();
    }
    paramViewGroup.id = ((Integer)localObject).intValue();
    IPCallShareCouponCardUI.a(this.mContext, paramViewGroup.id, paramViewGroup.nWt, paramViewGroup.nWu);
    paramViewGroup.nWs.setOnClickListener(new i.a.1(this));
    AppMethodBeat.o(22348);
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