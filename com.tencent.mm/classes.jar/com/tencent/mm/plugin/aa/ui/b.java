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
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
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
  
  public final void bwD()
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
      localView = ad.kS(this.context).inflate(a.g.aa_query_list_item, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    a locala = (a)localView.getTag();
    n localn = (n)getItem(paramInt);
    if (!Util.isNullOrNil(localn.RDj))
    {
      a.b.a(locala.jiu, localn.RDj, 0.1F, false);
      locala.titleTv.setText(l.b(this.context, localn.title, locala.titleTv.getTextSize()));
      paramViewGroup = ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(localn.RDj);
      if (!Util.isNullOrNil(paramViewGroup))
      {
        paramView = paramViewGroup;
        if (!paramViewGroup.endsWith("@chatroom")) {}
      }
      else
      {
        paramView = this.context.getString(a.i.aa_chatting_roominfo_noname);
      }
      locala.mMa.setText(l.b(this.context, paramView, locala.mMa.getTextSize()));
      if (this.mode != 2) {
        break label359;
      }
      locala.mMb.setText(localn.RDz);
      label212:
      paramView = new BigDecimal(i.o(localn.gbJ)).setScale(2, 4).toString();
      locala.mMc.setText(String.format("%s%s", new Object[] { this.context.getString(a.i.aa_yuan_new), paramView }));
      ar.a(locala.mMc.getPaint(), 0.8F);
      locala.jmj.setVisibility(0);
      if (this.mode != 2) {
        break label445;
      }
      switch (localn.state)
      {
      default: 
        locala.jmj.setVisibility(4);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(63497);
      return localView;
      locala.jiu.setImageResource(a.h.aa_record_default_icon);
      break;
      label359:
      locala.mMb.setText(localn.RDx);
      break label212;
      locala.jmj.setText(a.i.aa_list_record_status_unpaied);
      locala.jmj.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
      continue;
      locala.jmj.setText(a.i.aa_list_record_status_paied);
      locala.jmj.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
      continue;
      label445:
      switch (localn.state)
      {
      default: 
        locala.jmj.setVisibility(4);
        break;
      case 1: 
        locala.jmj.setText(a.i.aa_list_record_status_part);
        locala.jmj.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
        break;
      case 2: 
        locala.jmj.setText(a.i.aa_list_record_status_finish);
        locala.jmj.setTextColor(this.context.getResources().getColor(a.c.Brand));
        break;
      case 3: 
        locala.jmj.setText(a.i.aa_list_record_status_close);
        locala.jmj.setTextColor(this.context.getResources().getColor(a.c.Red_100));
        break;
      case 4: 
        locala.jmj.setText(a.i.aa_list_record_status_expire);
        locala.jmj.setTextColor(this.context.getResources().getColor(a.c.Red_100));
      }
    }
  }
  
  final class a
  {
    public ImageView jiu;
    public TextView jmj;
    public TextView mMa;
    public TextView mMb;
    public TextView mMc;
    public TextView titleTv;
    
    public a(View paramView)
    {
      AppMethodBeat.i(63493);
      this.jiu = ((ImageView)paramView.findViewById(a.f.aa_query_list_item_avatar));
      this.mMa = ((TextView)paramView.findViewById(a.f.aa_query_list_item_chatroom));
      this.titleTv = ((TextView)paramView.findViewById(a.f.aa_query_list_item_title));
      this.mMb = ((TextView)paramView.findViewById(a.f.aa_query_list_item_date));
      this.mMc = ((TextView)paramView.findViewById(a.f.aa_query_list_item_amount));
      this.jmj = ((TextView)paramView.findViewById(a.f.aa_query_list_item_status));
      AppMethodBeat.o(63493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.b
 * JD-Core Version:    0.7.0.1
 */