package com.tencent.mm.plugin.exdevice.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.plugin.exdevice.model.f.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

final class ExdeviceProfileAffectedUserView$a
  extends BaseAdapter
{
  private Runnable peo;
  
  private ExdeviceProfileAffectedUserView$a(ExdeviceProfileAffectedUserView paramExdeviceProfileAffectedUserView)
  {
    AppMethodBeat.i(24083);
    this.peo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24082);
        ExdeviceProfileAffectedUserView.a.this.notifyDataSetChanged();
        AppMethodBeat.o(24082);
      }
    };
    AppMethodBeat.o(24083);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(24085);
    String str = (String)ExdeviceProfileAffectedUserView.d(this.pen).get(paramInt);
    AppMethodBeat.o(24085);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(24084);
    if (ExdeviceProfileAffectedUserView.d(this.pen) == null)
    {
      AppMethodBeat.o(24084);
      return 0;
    }
    int i = ExdeviceProfileAffectedUserView.d(this.pen).size();
    AppMethodBeat.o(24084);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24086);
    String str = getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.pen.getContext()).inflate(2131493879, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.ikp = ((ImageView)paramView.findViewById(2131296996));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Runnable localRunnable = this.peo;
      Object localObject = p.auF();
      if (localObject != null)
      {
        localObject = ((j)localObject).we(str);
        if ((localObject == null) || (bt.isNullOrNil(((i)localObject).auy())))
        {
          long l = bt.eGO();
          ar.a.gMW.a(str, "", new f.1(l, localRunnable));
        }
      }
      a.b.v(paramViewGroup.ikp, str);
      AppMethodBeat.o(24086);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  final class a
  {
    ImageView ikp;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.a
 * JD-Core Version:    0.7.0.1
 */