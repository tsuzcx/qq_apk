package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SeeRoomManagerUI$b
  extends BaseAdapter
{
  List<SeeRoomManagerUI.a> dataList;
  private com.tencent.mm.at.a.a.c eiK;
  Context mContext;
  
  public SeeRoomManagerUI$b(SeeRoomManagerUI paramSeeRoomManagerUI, Context paramContext)
  {
    AppMethodBeat.i(104289);
    this.dataList = new ArrayList();
    this.mContext = paramContext;
    Kg();
    notifyDataSetChanged();
    paramSeeRoomManagerUI = new c.a();
    paramSeeRoomManagerUI.eNM = true;
    paramSeeRoomManagerUI.eOe = true;
    paramSeeRoomManagerUI.eNY = 2131231207;
    this.eiK = paramSeeRoomManagerUI.ahY();
    AppMethodBeat.o(104289);
  }
  
  private void Kg()
  {
    AppMethodBeat.i(104291);
    this.dataList.clear();
    SeeRoomManagerUI.a(this.eiP, ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(bo.nullAsNil(SeeRoomManagerUI.c(this.eiP))));
    if (SeeRoomManagerUI.d(this.eiP) == null)
    {
      AppMethodBeat.o(104291);
      return;
    }
    Iterator localIterator = SeeRoomManagerUI.d(this.eiP).afx().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (SeeRoomManagerUI.d(this.eiP).aqW((String)localObject))
      {
        ab.i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", new Object[] { localObject });
        localObject = ((j)g.E(j.class)).YA().arw((String)localObject);
        this.dataList.add(new SeeRoomManagerUI.a(this.eiP, 1, (ad)localObject));
      }
    }
    if (r.Zn().equals(SeeRoomManagerUI.d(this.eiP).field_roomowner))
    {
      this.dataList.add(new SeeRoomManagerUI.a(this.eiP, 2, null));
      if (this.dataList.size() > 1) {
        this.dataList.add(new SeeRoomManagerUI.a(this.eiP, 3, null));
      }
    }
    AppMethodBeat.o(104291);
  }
  
  private SeeRoomManagerUI.a iB(int paramInt)
  {
    AppMethodBeat.i(104293);
    SeeRoomManagerUI.a locala = (SeeRoomManagerUI.a)this.dataList.get(paramInt);
    AppMethodBeat.o(104293);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(104292);
    int i = this.dataList.size();
    AppMethodBeat.o(104292);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104294);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, 2130970591, null);
      paramViewGroup = this.eiP.cj(localView);
    }
    for (;;)
    {
      paramView = iB(paramInt);
      if (paramView != null) {
        break;
      }
      ab.e("MicroMsg.SeeRoomManagerUI", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      AppMethodBeat.o(104294);
      return localView;
      SeeRoomManagerUI.c localc = (SeeRoomManagerUI.c)paramView.getTag();
      paramViewGroup = localc;
      localView = paramView;
      if (localc == null)
      {
        paramViewGroup = this.eiP.cj(paramView);
        localView = paramView;
      }
    }
    if (paramView.type == 1)
    {
      paramViewGroup.eiM.setVisibility(0);
      paramView = paramView.contact;
      paramViewGroup.eiM.setText(SeeRoomManagerUI.a(this.eiP, paramView.field_username, paramViewGroup.eiM));
      a.b.c(paramViewGroup.egq, paramView.field_username);
    }
    for (;;)
    {
      localView.setOnClickListener(new SeeRoomManagerUI.b.2(this, paramInt));
      AppMethodBeat.o(104294);
      return localView;
      if (paramView.type == 2)
      {
        paramViewGroup.eiM.setVisibility(4);
        paramViewGroup.egq.setImageResource(2130837890);
      }
      else if (paramView.type == 3)
      {
        paramViewGroup.eiM.setVisibility(4);
        paramViewGroup.egq.setImageResource(2130837891);
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(104290);
    super.notifyDataSetChanged();
    SeeRoomManagerUI.b(this.eiP).post(new SeeRoomManagerUI.b.1(this));
    AppMethodBeat.o(104290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI.b
 * JD-Core Version:    0.7.0.1
 */