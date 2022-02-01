package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context context;
  List<com.tencent.mm.protocal.protobuf.k> dataList;
  int mode;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63494);
    this.dataList = new ArrayList();
    this.context = paramContext;
    this.mode = paramInt;
    AppMethodBeat.o(63494);
  }
  
  public final void aRr()
  {
    AppMethodBeat.i(63498);
    this.dataList.clear();
    AppMethodBeat.o(63498);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63495);
    int i = this.dataList.size();
    AppMethodBeat.o(63495);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(63496);
    Object localObject = this.dataList.get(paramInt);
    AppMethodBeat.o(63496);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(63497);
    View localView = paramView;
    if (paramView == null)
    {
      localView = z.jO(this.context).inflate(2131492885, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    a locala = (a)localView.getTag();
    com.tencent.mm.protocal.protobuf.k localk = (com.tencent.mm.protocal.protobuf.k)getItem(paramInt);
    locala.fRd.setImageResource(2131689473);
    a.b.a(locala.fRd, localk.FpH, 2131689473, null);
    locala.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localk.title, locala.titleTv.getTextSize()));
    paramViewGroup = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(localk.FpH);
    if (!bt.isNullOrNil(paramViewGroup))
    {
      paramView = paramViewGroup;
      if (!paramViewGroup.endsWith("@chatroom")) {}
    }
    else
    {
      paramView = this.context.getString(2131755024);
    }
    locala.iUV.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramView, locala.iUV.getTextSize()));
    if (this.mode == 2)
    {
      locala.iUW.setText(localk.FpW);
      locala.iUX.setText(String.format("%s%s", new Object[] { Float.valueOf((float)localk.dOa / 100.0F), this.context.getString(2131755072) }));
      locala.fUR.setVisibility(0);
      if (this.mode != 2) {
        break label395;
      }
      switch (localk.state)
      {
      default: 
        locala.fUR.setVisibility(4);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(63497);
      return localView;
      locala.iUW.setText(localk.FpU);
      break;
      locala.fUR.setText(2131755045);
      locala.fUR.setTextColor(this.context.getResources().getColor(2131099844));
      continue;
      locala.fUR.setText(2131755043);
      locala.fUR.setTextColor(this.context.getResources().getColor(2131099844));
      continue;
      label395:
      switch (localk.state)
      {
      default: 
        locala.fUR.setVisibility(4);
        break;
      case 1: 
        locala.fUR.setText(2131755044);
        locala.fUR.setTextColor(this.context.getResources().getColor(2131099844));
        break;
      case 2: 
        locala.fUR.setText(2131755042);
        locala.fUR.setTextColor(this.context.getResources().getColor(2131099844));
        break;
      case 3: 
        locala.fUR.setText(2131755040);
        locala.fUR.setTextColor(this.context.getResources().getColor(2131099804));
        break;
      case 4: 
        locala.fUR.setText(2131755041);
        locala.fUR.setTextColor(this.context.getResources().getColor(2131099804));
      }
    }
  }
  
  final class a
  {
    public ImageView fRd;
    public TextView fUR;
    public TextView iUV;
    public TextView iUW;
    public TextView iUX;
    public TextView titleTv;
    
    public a(View paramView)
    {
      AppMethodBeat.i(63493);
      this.fRd = ((ImageView)paramView.findViewById(2131296292));
      this.iUV = ((TextView)paramView.findViewById(2131296293));
      this.titleTv = ((TextView)paramView.findViewById(2131296297));
      this.iUW = ((TextView)paramView.findViewById(2131296294));
      this.iUX = ((TextView)paramView.findViewById(2131296291));
      this.fUR = ((TextView)paramView.findViewById(2131296296));
      AppMethodBeat.o(63493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.b
 * JD-Core Version:    0.7.0.1
 */