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
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context context;
  List<m> dataList;
  int mode;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63494);
    this.dataList = new ArrayList();
    this.context = paramContext;
    this.mode = paramInt;
    AppMethodBeat.o(63494);
  }
  
  public final void bmv()
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
      localView = aa.jQ(this.context).inflate(2131492901, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    a locala = (a)localView.getTag();
    m localm = (m)getItem(paramInt);
    if (!Util.isNullOrNil(localm.KBt))
    {
      a.b.a(locala.gyr, localm.KBt, 0.1F, false);
      locala.titleTv.setText(l.b(this.context, localm.title, locala.titleTv.getTextSize()));
      paramViewGroup = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localm.KBt);
      if (!Util.isNullOrNil(paramViewGroup))
      {
        paramView = paramViewGroup;
        if (!paramViewGroup.endsWith("@chatroom")) {}
      }
      else
      {
        paramView = this.context.getString(2131755028);
      }
      locala.jUN.setText(l.b(this.context, paramView, locala.jUN.getTextSize()));
      if (this.mode != 2) {
        break label354;
      }
      locala.jUO.setText(localm.KBI);
      label210:
      paramView = new BigDecimal(i.o(localm.eht)).setScale(2, 4).toString();
      locala.jUP.setText(String.format("%s%s", new Object[] { this.context.getString(2131755084), paramView }));
      ao.a(locala.jUP.getPaint(), 0.8F);
      locala.gCd.setVisibility(0);
      if (this.mode != 2) {
        break label436;
      }
      switch (localm.state)
      {
      default: 
        locala.gCd.setVisibility(4);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(63497);
      return localView;
      locala.gyr.setImageResource(2131689475);
      break;
      label354:
      locala.jUO.setText(localm.KBG);
      break label210;
      locala.gCd.setText(2131755049);
      locala.gCd.setTextColor(this.context.getResources().getColor(2131099862));
      continue;
      locala.gCd.setText(2131755047);
      locala.gCd.setTextColor(this.context.getResources().getColor(2131099862));
      continue;
      label436:
      switch (localm.state)
      {
      default: 
        locala.gCd.setVisibility(4);
        break;
      case 1: 
        locala.gCd.setText(2131755048);
        locala.gCd.setTextColor(this.context.getResources().getColor(2131099862));
        break;
      case 2: 
        locala.gCd.setText(2131755046);
        locala.gCd.setTextColor(this.context.getResources().getColor(2131099710));
        break;
      case 3: 
        locala.gCd.setText(2131755044);
        locala.gCd.setTextColor(this.context.getResources().getColor(2131099819));
        break;
      case 4: 
        locala.gCd.setText(2131755045);
        locala.gCd.setTextColor(this.context.getResources().getColor(2131099819));
      }
    }
  }
  
  final class a
  {
    public TextView gCd;
    public ImageView gyr;
    public TextView jUN;
    public TextView jUO;
    public TextView jUP;
    public TextView titleTv;
    
    public a(View paramView)
    {
      AppMethodBeat.i(63493);
      this.gyr = ((ImageView)paramView.findViewById(2131296296));
      this.jUN = ((TextView)paramView.findViewById(2131296297));
      this.titleTv = ((TextView)paramView.findViewById(2131296301));
      this.jUO = ((TextView)paramView.findViewById(2131296298));
      this.jUP = ((TextView)paramView.findViewById(2131296295));
      this.gCd = ((TextView)paramView.findViewById(2131296300));
      AppMethodBeat.o(63493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.b
 * JD-Core Version:    0.7.0.1
 */