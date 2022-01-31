package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends r<com.tencent.mm.plugin.ipcall.a.g.c>
  implements d.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> lsH = null;
  private boolean idd = false;
  private d ltI;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> ltJ = new HashMap();
  private HashSet<String> ltK = new HashSet();
  private boolean ltL = false;
  ArrayList<k> lxo;
  private View.OnClickListener lxp = new h.1(this);
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    mR(true);
    this.ltI = new d(paramContext);
    o.JQ().a(this);
  }
  
  public final int getCount()
  {
    if (this.lxo == null) {
      this.lxo = m.bcO();
    }
    if (this.lxo != null) {
      return this.lxo.size();
    }
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(R.i.ipcall_address_item, paramViewGroup, false);
      paramView = new h.a(this, (byte)0);
      paramView.ltY = localView.findViewById(R.h.item_header);
      paramView.ltZ = localView.findViewById(R.h.divider_bottom);
      paramView.dpY = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.feh = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramView.ltQ = ((TextView)localView.findViewById(R.h.phonenumber_tv));
      paramView.ltR = ((LinearLayout)localView.findViewById(R.h.recent_info_ll));
      paramView.ltS = ((TextView)localView.findViewById(R.h.recent_state_tv));
      paramView.ltT = ((TextView)localView.findViewById(R.h.recent_time_tv));
      paramView.ltU = ((TextView)localView.findViewById(R.h.address_spell_category_tv));
      paramView.ltV = ((TextView)localView.findViewById(R.h.address_item_category_tv));
      paramView.ltW = ((ImageView)localView.findViewById(R.h.address_item_info));
      paramView.ltX = localView.findViewById(R.h.item_info_ll);
      paramView.ltX.setClickable(true);
      paramView.lua = ((ImageView)localView.findViewById(R.h.divider));
      localView.setTag(paramView);
    }
    h.a locala = (h.a)localView.getTag();
    locala.ltX.setClickable(true);
    locala.ltX.setTag(Integer.valueOf(paramInt));
    locala.lua.setVisibility(8);
    if (sk(paramInt))
    {
      locala.feh.setVisibility(8);
      locala.ltQ.setVisibility(8);
      locala.ltR.setVisibility(8);
      locala.dpY.setVisibility(8);
      locala.dpY.setTag(null);
      locala.ltV.setVisibility(8);
      locala.ltU.setVisibility(8);
      locala.ltW.setVisibility(8);
      return localView;
    }
    k localk = sQ(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label811;
      }
      locala.ltV.setVisibility(0);
      locala.ltU.setVisibility(8);
      locala.ltV.setText(this.context.getString(R.l.ip_call_recently_contact));
      locala.lua.setVisibility(0);
      locala.feh.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.ltY.getLayoutParams();
      paramView.height = ((int)locala.ltQ.getContext().getResources().getDimension(R.f.address_item_height));
      locala.ltY.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.dpY.getLayoutParams();
      paramView.height = ((int)locala.dpY.getContext().getResources().getDimension(R.f.address_item_avatar_size_normal));
      paramView.width = ((int)locala.dpY.getContext().getResources().getDimension(R.f.address_item_avatar_size_normal));
      locala.dpY.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label849;
      }
      if (!this.ltJ.containsKey(Long.valueOf(localk.field_addressId))) {
        break label834;
      }
      paramView = (com.tencent.mm.plugin.ipcall.a.g.c)this.ltJ.get(Long.valueOf(localk.field_addressId));
      label591:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.ltJ.put(Long.valueOf(localk.field_addressId), paramView);
        locala.feh.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label628:
      locala.ltQ.setVisibility(8);
      locala.ltR.setVisibility(0);
      locala.ltT.setText(com.tencent.mm.plugin.ipcall.b.c.eY(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label870;
      }
      locala.ltS.setText(com.tencent.mm.plugin.ipcall.b.c.fa(localk.field_duration));
      label689:
      paramView = locala.dpY;
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.setTag(null);
        paramView.setImageResource(R.g.ipcall_default_avatar);
        if (paramViewGroup != null)
        {
          if ((bk.bl(paramViewGroup.field_contactId)) || (bk.bl(paramViewGroup.field_wechatUsername))) {
            break label889;
          }
          this.ltI.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!bk.bl(paramViewGroup.field_wechatUsername)) {
        this.ltK.add(paramViewGroup.field_wechatUsername);
      }
      locala.ltX.setVisibility(0);
      locala.ltW.setVisibility(0);
      locala.ltX.setOnClickListener(this.lxp);
      return localView;
      label811:
      locala.ltV.setVisibility(8);
      locala.ltU.setVisibility(8);
      break;
      label834:
      paramView = i.bcm().eU(localk.field_addressId);
      break label591;
      label849:
      locala.feh.setText(a.Ge(localk.field_phonenumber));
      paramViewGroup = null;
      break label628;
      label870:
      locala.ltS.setText(com.tencent.mm.plugin.ipcall.b.c.sV(localk.field_status));
      break label689;
      label889:
      if (!bk.bl(paramViewGroup.field_contactId)) {
        this.ltI.c(paramViewGroup.field_contactId, paramView);
      } else if (!bk.bl(paramViewGroup.field_wechatUsername)) {
        this.ltI.d(paramViewGroup.field_wechatUsername, paramView);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
  
  public final void kk(String paramString)
  {
    if (this.ltK.contains(paramString)) {
      ai.d(new h.2(this));
    }
  }
  
  public final void notifyDataSetChanged()
  {
    this.lxo = m.bcO();
    this.ltJ.clear();
    super.notifyDataSetChanged();
  }
  
  public final k sQ(int paramInt)
  {
    return (k)this.lxo.get(paramInt);
  }
  
  public final void yc()
  {
    this.lxo = m.bcO();
  }
  
  protected final void yd()
  {
    this.lxo = m.bcO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */