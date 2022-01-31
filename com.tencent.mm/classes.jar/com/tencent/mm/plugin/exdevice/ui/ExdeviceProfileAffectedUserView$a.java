package com.tencent.mm.plugin.exdevice.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.exdevice.model.f.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class ExdeviceProfileAffectedUserView$a
  extends BaseAdapter
{
  private Runnable lND;
  
  private ExdeviceProfileAffectedUserView$a(ExdeviceProfileAffectedUserView paramExdeviceProfileAffectedUserView)
  {
    AppMethodBeat.i(20013);
    this.lND = new ExdeviceProfileAffectedUserView.a.1(this);
    AppMethodBeat.o(20013);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(20015);
    String str = (String)ExdeviceProfileAffectedUserView.d(this.lNC).get(paramInt);
    AppMethodBeat.o(20015);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(20014);
    if (ExdeviceProfileAffectedUserView.d(this.lNC) == null)
    {
      AppMethodBeat.o(20014);
      return 0;
    }
    int i = ExdeviceProfileAffectedUserView.d(this.lNC).size();
    AppMethodBeat.o(20014);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(20016);
    String str = getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.lNC.getContext()).inflate(2130969467, paramViewGroup, false);
      paramViewGroup = new ExdeviceProfileAffectedUserView.a.a(this);
      paramViewGroup.gxs = ((ImageView)paramView.findViewById(2131823820));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Runnable localRunnable = this.lND;
      Object localObject = o.adg();
      if (localObject != null)
      {
        localObject = ((i)localObject).rj(str);
        if ((localObject == null) || (bo.isNullOrNil(((h)localObject).acY())))
        {
          long l = bo.aoy();
          ao.a.flI.a(str, "", new f.1(l, localRunnable));
        }
      }
      a.b.t(paramViewGroup.gxs, str);
      AppMethodBeat.o(20016);
      return paramView;
      paramViewGroup = (ExdeviceProfileAffectedUserView.a.a)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.a
 * JD-Core Version:    0.7.0.1
 */