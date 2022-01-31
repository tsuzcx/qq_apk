package com.tencent.mm.plugin.exdevice.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.exdevice.model.f.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;

final class ExdeviceProfileAffectedUserView$a
  extends BaseAdapter
{
  private Runnable jEf = new Runnable()
  {
    public final void run()
    {
      ExdeviceProfileAffectedUserView.a.this.notifyDataSetChanged();
    }
  };
  
  private ExdeviceProfileAffectedUserView$a(ExdeviceProfileAffectedUserView paramExdeviceProfileAffectedUserView) {}
  
  private String ke(int paramInt)
  {
    return (String)ExdeviceProfileAffectedUserView.d(this.jEe).get(paramInt);
  }
  
  public final int getCount()
  {
    if (ExdeviceProfileAffectedUserView.d(this.jEe) == null) {
      return 0;
    }
    return ExdeviceProfileAffectedUserView.d(this.jEe).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = ke(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jEe.getContext()).inflate(R.i.exdevice_profile_view_item, paramViewGroup, false);
      paramViewGroup = new ExdeviceProfileAffectedUserView.a.a(this);
      paramViewGroup.ffK = ((ImageView)paramView.findViewById(R.h.avatar));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Runnable localRunnable = this.jEf;
      Object localObject = o.Kh();
      if (localObject != null)
      {
        localObject = ((i)localObject).kp(str);
        if ((localObject == null) || (bk.bl(((h)localObject).JY())))
        {
          long l = bk.UY();
          am.a.dVy.a(str, "", new f.1(l, localRunnable));
        }
      }
      a.b.o(paramViewGroup.ffK, str);
      return paramView;
      paramViewGroup = (ExdeviceProfileAffectedUserView.a.a)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.a
 * JD-Core Version:    0.7.0.1
 */