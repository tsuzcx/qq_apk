package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context context;
  List<k> dataList = new ArrayList();
  int mode;
  
  public b(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    this.mode = paramInt;
  }
  
  public final void Vy()
  {
    this.dataList.clear();
  }
  
  public final int getCount()
  {
    return this.dataList.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.dataList.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = y.gt(this.context).inflate(a.g.aa_query_list_item, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    a locala = (a)localView.getTag();
    k localk = (k)getItem(paramInt);
    locala.dpY.setImageResource(a.h.aa_record_default_icon);
    a.b.g(locala.dpY, localk.srr, a.h.aa_record_default_icon);
    locala.eXr.setText(j.a(this.context, localk.title, locala.eXr.getTextSize()));
    paramViewGroup = ((com.tencent.mm.plugin.messenger.a.b)g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(localk.srr);
    if (!bk.bl(paramViewGroup))
    {
      paramView = paramViewGroup;
      if (!paramViewGroup.endsWith("@chatroom")) {}
    }
    else
    {
      paramView = this.context.getString(a.i.aa_chatting_roominfo_noname);
    }
    locala.eXq.setText(j.a(this.context, paramView, locala.eXq.getTextSize()));
    if (this.mode == 2) {
      locala.eXs.setText(localk.srD);
    }
    for (;;)
    {
      locala.eXt.setText(String.format("%s%s", new Object[] { Float.valueOf((float)localk.ceq / 100.0F), this.context.getString(a.i.aa_yuan) }));
      locala.eXu.setVisibility(0);
      if (this.mode != 2) {
        break;
      }
      switch (localk.state)
      {
      default: 
        locala.eXu.setVisibility(4);
        return localView;
        locala.eXs.setText(localk.srA);
      }
    }
    locala.eXu.setText(a.i.aa_list_record_status_unpaied);
    locala.eXu.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
    return localView;
    locala.eXu.setText(a.i.aa_list_record_status_paied);
    locala.eXu.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
    return localView;
    switch (localk.state)
    {
    default: 
      locala.eXu.setVisibility(4);
      return localView;
    case 1: 
      locala.eXu.setText(a.i.aa_list_record_status_part);
      locala.eXu.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
      return localView;
    case 2: 
      locala.eXu.setText(a.i.aa_list_record_status_finish);
      locala.eXu.setTextColor(this.context.getResources().getColor(a.c.aa_query_list_hint_color));
      return localView;
    case 3: 
      locala.eXu.setText(a.i.aa_list_record_status_close);
      locala.eXu.setTextColor(this.context.getResources().getColor(a.c.red));
      return localView;
    }
    locala.eXu.setText(a.i.aa_list_record_status_expire);
    locala.eXu.setTextColor(this.context.getResources().getColor(a.c.red));
    return localView;
  }
  
  private final class a
  {
    public ImageView dpY;
    public TextView eXq;
    public TextView eXr;
    public TextView eXs;
    public TextView eXt;
    public TextView eXu;
    
    public a(View paramView)
    {
      this.dpY = ((ImageView)paramView.findViewById(a.f.aa_query_list_item_avatar));
      this.eXq = ((TextView)paramView.findViewById(a.f.aa_query_list_item_chatroom));
      this.eXr = ((TextView)paramView.findViewById(a.f.aa_query_list_item_title));
      this.eXs = ((TextView)paramView.findViewById(a.f.aa_query_list_item_date));
      this.eXt = ((TextView)paramView.findViewById(a.f.aa_query_list_item_amount));
      this.eXu = ((TextView)paramView.findViewById(a.f.aa_query_list_item_status));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.b
 * JD-Core Version:    0.7.0.1
 */