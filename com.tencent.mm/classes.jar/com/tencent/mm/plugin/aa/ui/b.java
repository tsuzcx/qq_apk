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
import com.tencent.mm.sdk.platformtools.bu;
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
  
  public final void aRQ()
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
      localView = z.jV(this.context).inflate(2131492885, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    a locala = (a)localView.getTag();
    com.tencent.mm.protocal.protobuf.k localk = (com.tencent.mm.protocal.protobuf.k)getItem(paramInt);
    locala.fTj.setImageResource(2131689473);
    a.b.a(locala.fTj, localk.FIf, 2131689473, null);
    locala.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localk.title, locala.titleTv.getTextSize()));
    paramViewGroup = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(localk.FIf);
    if (!bu.isNullOrNil(paramViewGroup))
    {
      paramView = paramViewGroup;
      if (!paramViewGroup.endsWith("@chatroom")) {}
    }
    else
    {
      paramView = this.context.getString(2131755024);
    }
    locala.iXO.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramView, locala.iXO.getTextSize()));
    if (this.mode == 2)
    {
      locala.iXP.setText(localk.FIu);
      locala.iXQ.setText(String.format("%s%s", new Object[] { Float.valueOf((float)localk.dPq / 100.0F), this.context.getString(2131755072) }));
      locala.fWX.setVisibility(0);
      if (this.mode != 2) {
        break label395;
      }
      switch (localk.state)
      {
      default: 
        locala.fWX.setVisibility(4);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(63497);
      return localView;
      locala.iXP.setText(localk.FIs);
      break;
      locala.fWX.setText(2131755045);
      locala.fWX.setTextColor(this.context.getResources().getColor(2131099844));
      continue;
      locala.fWX.setText(2131755043);
      locala.fWX.setTextColor(this.context.getResources().getColor(2131099844));
      continue;
      label395:
      switch (localk.state)
      {
      default: 
        locala.fWX.setVisibility(4);
        break;
      case 1: 
        locala.fWX.setText(2131755044);
        locala.fWX.setTextColor(this.context.getResources().getColor(2131099844));
        break;
      case 2: 
        locala.fWX.setText(2131755042);
        locala.fWX.setTextColor(this.context.getResources().getColor(2131099844));
        break;
      case 3: 
        locala.fWX.setText(2131755040);
        locala.fWX.setTextColor(this.context.getResources().getColor(2131099804));
        break;
      case 4: 
        locala.fWX.setText(2131755041);
        locala.fWX.setTextColor(this.context.getResources().getColor(2131099804));
      }
    }
  }
  
  final class a
  {
    public ImageView fTj;
    public TextView fWX;
    public TextView iXO;
    public TextView iXP;
    public TextView iXQ;
    public TextView titleTv;
    
    public a(View paramView)
    {
      AppMethodBeat.i(63493);
      this.fTj = ((ImageView)paramView.findViewById(2131296292));
      this.iXO = ((TextView)paramView.findViewById(2131296293));
      this.titleTv = ((TextView)paramView.findViewById(2131296297));
      this.iXP = ((TextView)paramView.findViewById(2131296294));
      this.iXQ = ((TextView)paramView.findViewById(2131296291));
      this.fWX = ((TextView)paramView.findViewById(2131296296));
      AppMethodBeat.o(63493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.b
 * JD-Core Version:    0.7.0.1
 */