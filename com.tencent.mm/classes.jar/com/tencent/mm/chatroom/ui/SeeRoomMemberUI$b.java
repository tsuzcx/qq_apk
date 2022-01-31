package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class SeeRoomMemberUI$b
  extends BaseAdapter
{
  private List<SeeRoomMemberUI.a> bSN = new ArrayList();
  private String dmT;
  private u dnL;
  private List<String> dru;
  public String drv;
  private boolean drw = false;
  private String drx = null;
  private List<SeeRoomMemberUI.a> dry;
  private com.tencent.mm.plugin.messenger.foundation.a.j drz;
  private Context mContext;
  
  public SeeRoomMemberUI$b(Context paramContext, u paramu, String paramString1, List<String> paramList, String paramString2)
  {
    this.dnL = paramString1;
    this.dmT = paramList;
    this.dru = paramString2;
    Object localObject;
    this.drx = localObject;
    this.mContext = paramu;
    this.drz = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class));
    G(m.gK(paramList));
  }
  
  public final void G(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.bSN.clear();
    int i = 0;
    if (i < paramList.size())
    {
      ad localad = this.drz.Fw().abl((String)paramList.get(i));
      if (this.dnL.aaP(localad.field_username)) {
        this.bSN.add(new SeeRoomMemberUI.a(localad, 3));
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.dnL.aaM(localad.field_username)) {
          this.bSN.add(new SeeRoomMemberUI.a(localad, 2));
        } else {
          this.bSN.add(new SeeRoomMemberUI.a(localad, 1));
        }
      }
    }
    Collections.sort(this.bSN, new SeeRoomMemberUI.b.1(this));
    this.bSN.add(new SeeRoomMemberUI.a(2));
    if (this.dnL.xw()) {
      this.bSN.add(new SeeRoomMemberUI.a(3));
    }
    this.dry = this.bSN;
    notifyDataSetChanged();
  }
  
  public final void eT(String paramString)
  {
    this.drw = true;
    this.drv = paramString;
    ArrayList localArrayList = new ArrayList();
    if (!bk.bl(paramString))
    {
      Iterator localIterator = this.dry.iterator();
      while (localIterator.hasNext())
      {
        SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)localIterator.next();
        if ((locala != null) && (locala.dnp != null) && (locala.type == 1))
        {
          Object localObject = locala.dnp;
          if ((((ao)localObject).field_conRemark != null) && (((ao)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase())))
          {
            localArrayList.add(locala);
          }
          else if ((!bk.bl(SeeRoomMemberUI.a(this.dnL, ((ao)localObject).field_username))) && (SeeRoomMemberUI.a(this.dnL, ((ao)localObject).field_username).contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).Bp() != null) && (((ad)localObject).Bp().toUpperCase().contains(paramString.toUpperCase())))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).vn() != null) && (((ad)localObject).vn().toUpperCase().contains(paramString.toUpperCase())))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).vk() != null) && (((ad)localObject).vk().contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ao)localObject).field_username != null) && (((ao)localObject).field_username.contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if (!com.tencent.mm.n.a.gR(((ao)localObject).field_type))
          {
            localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fx().Id(((ao)localObject).field_username);
            if ((localObject != null) && (((bv)localObject).field_conRemark != null) && (((bv)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
              localArrayList.add(locala);
            }
          }
        }
      }
      y.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
    }
    for (this.bSN = localArrayList;; this.bSN = this.dry)
    {
      notifyDataSetChanged();
      return;
    }
  }
  
  public final int getCount()
  {
    return this.bSN.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    SeeRoomMemberUI.c localc;
    String str;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, a.f.see_roommember_item, null);
      localc = new SeeRoomMemberUI.c((byte)0);
      localc.doU = ((ImageView)localView.findViewById(a.e.see_roommember_avatar));
      localc.drB = ((TextView)localView.findViewById(a.e.see_roommember_name));
      paramView = (WindowManager)this.mContext.getSystemService("window");
      localc.drB.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
      localc.drC = ((TextView)localView.findViewById(a.e.see_roommember_name_sub_detail));
      localView.setTag(localc);
      if (localc.drC != null) {
        localc.drC.setVisibility(8);
      }
      paramView = (SeeRoomMemberUI.a)this.bSN.get(paramInt);
      if ((paramView == null) || (paramView.type != 1)) {
        break label398;
      }
      ad localad = paramView.dnp;
      a.b.a(localc.doU, localad.field_username);
      str = SeeRoomMemberUI.a(this.dnL, localad.field_username);
      if (bk.bl(localad.field_conRemark)) {
        break label371;
      }
      paramViewGroup = localad.field_conRemark;
      label211:
      paramView = paramViewGroup;
      if (bk.bl(paramViewGroup)) {
        paramView = localad.Bp();
      }
      paramViewGroup = paramView;
      if (str != null)
      {
        paramViewGroup = paramView;
        if (!str.equals(""))
        {
          paramViewGroup = paramView;
          if (!paramView.equals(str)) {
            paramViewGroup = str + "( " + paramView + " )";
          }
        }
      }
      localc.drB.setVisibility(0);
      localc.drB.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, paramViewGroup, localc.drB.getTextSize()));
      if (localc.drC != null)
      {
        paramView = com.tencent.mm.openim.room.a.a.z(localad);
        if (!TextUtils.isEmpty(paramView)) {
          break label377;
        }
        localc.drC.setVisibility(8);
      }
    }
    label371:
    label377:
    do
    {
      return localView;
      localc = (SeeRoomMemberUI.c)paramView.getTag();
      localView = paramView;
      break;
      paramViewGroup = str;
      break label211;
      localc.drC.setVisibility(0);
      localc.drC.setText(paramView);
      return localView;
      if ((paramView != null) && (paramView.type == 2))
      {
        localc.drB.setVisibility(4);
        localc.doU.setImageResource(a.d.big_add_selector);
        return localView;
      }
    } while ((paramView == null) || (paramView.type != 3));
    label398:
    localc.drB.setVisibility(4);
    localc.doU.setImageResource(a.d.big_del_selector);
    return localView;
  }
  
  public final SeeRoomMemberUI.a gn(int paramInt)
  {
    return (SeeRoomMemberUI.a)this.bSN.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.b
 * JD-Core Version:    0.7.0.1
 */