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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context context;
  List<n> dataList;
  int mode;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63494);
    this.dataList = new ArrayList();
    this.context = paramContext;
    this.mode = paramInt;
    AppMethodBeat.o(63494);
  }
  
  public final void bVt()
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
      localView = af.mU(this.context).inflate(a.g.aa_query_list_item, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    a locala = (a)localView.getTag();
    n localn = (n)getItem(paramInt);
    if (!Util.isNullOrNil(localn.YzM))
    {
      a.b.a(locala.lKK, localn.YzM, 0.1F, false);
      locala.titleTv.setText(p.b(this.context, localn.title, locala.titleTv.getTextSize()));
      paramViewGroup = ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localn.YzM);
      if (!Util.isNullOrNil(paramViewGroup))
      {
        paramView = paramViewGroup;
        if (!paramViewGroup.endsWith("@chatroom")) {}
      }
      else
      {
        paramView = this.context.getString(a.i.aa_chatting_roominfo_noname);
      }
      locala.pII.setText(p.b(this.context, paramView, locala.pII.getTextSize()));
      if (this.mode != 2) {
        break label359;
      }
      locala.pIJ.setText(localn.YAc);
      label212:
      paramView = new BigDecimal(j.E(localn.ihV)).setScale(2, 4).toString();
      locala.pIK.setText(String.format("%s%s", new Object[] { this.context.getString(a.i.aa_yuan_new), paramView }));
      aw.a(locala.pIK.getPaint(), 0.8F);
      locala.lPf.setVisibility(0);
      if (this.mode != 2) {
        break label445;
      }
      switch (localn.state)
      {
      default: 
        locala.lPf.setVisibility(4);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(63497);
      return localView;
      locala.lKK.setImageResource(a.h.aa_record_default_icon);
      break;
      label359:
      locala.pIJ.setText(localn.YAa);
      break label212;
      locala.lPf.setText(a.i.aa_list_record_status_unpaied);
      locala.lPf.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
      continue;
      locala.lPf.setText(a.i.aa_list_record_status_paied);
      locala.lPf.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
      continue;
      label445:
      switch (localn.state)
      {
      default: 
        locala.lPf.setVisibility(4);
        break;
      case 1: 
        locala.lPf.setText(a.i.aa_list_record_status_part);
        locala.lPf.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
        break;
      case 2: 
        locala.lPf.setText(a.i.aa_list_record_status_finish);
        locala.lPf.setTextColor(this.context.getResources().getColor(a.c.Brand));
        break;
      case 3: 
        locala.lPf.setText(a.i.aa_list_record_status_close);
        locala.lPf.setTextColor(this.context.getResources().getColor(a.c.Red_100));
        break;
      case 4: 
        locala.lPf.setText(a.i.aa_list_record_status_expire);
        locala.lPf.setTextColor(this.context.getResources().getColor(a.c.Red_100));
      }
    }
  }
  
  final class a
  {
    public ImageView lKK;
    public TextView lPf;
    public TextView pII;
    public TextView pIJ;
    public TextView pIK;
    public TextView titleTv;
    
    public a(View paramView)
    {
      AppMethodBeat.i(63493);
      this.lKK = ((ImageView)paramView.findViewById(a.f.aa_query_list_item_avatar));
      this.pII = ((TextView)paramView.findViewById(a.f.aa_query_list_item_chatroom));
      this.titleTv = ((TextView)paramView.findViewById(a.f.aa_query_list_item_title));
      this.pIJ = ((TextView)paramView.findViewById(a.f.aa_query_list_item_date));
      this.pIK = ((TextView)paramView.findViewById(a.f.aa_query_list_item_amount));
      this.lPf = ((TextView)paramView.findViewById(a.f.aa_query_list_item_status));
      AppMethodBeat.o(63493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.b
 * JD-Core Version:    0.7.0.1
 */