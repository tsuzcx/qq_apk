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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends p<com.tencent.mm.plugin.ipcall.a.g.c>
  implements d.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> nQb = null;
  private boolean jTS;
  private d nRb;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> nRc;
  private HashSet<String> nRd;
  private boolean nRe;
  ArrayList<k> nUB;
  private View.OnClickListener nUC;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(22240);
    this.nRc = new HashMap();
    this.nRd = new HashSet();
    this.nRe = false;
    this.jTS = false;
    this.nUC = new h.1(this);
    qp(true);
    this.nRb = new d(paramContext);
    o.acQ().a(this);
    AppMethodBeat.o(22240);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(156903);
    this.nUB = m.bJX();
    AppMethodBeat.o(156903);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(156689);
    this.nUB = m.bJX();
    AppMethodBeat.o(156689);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22243);
    if (this.nUB == null) {
      this.nUB = m.bJX();
    }
    if (this.nUB != null)
    {
      int i = this.nUB.size();
      AppMethodBeat.o(22243);
      return i;
    }
    AppMethodBeat.o(22243);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(22246);
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(22246);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22245);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2130969934, paramViewGroup, false);
      paramView = new h.a(this, (byte)0);
      paramView.nRr = localView.findViewById(2131825263);
      paramView.nRs = localView.findViewById(2131825264);
      paramView.ehv = ((ImageView)localView.findViewById(2131821210));
      paramView.gvQ = ((TextView)localView.findViewById(2131823254));
      paramView.nRj = ((TextView)localView.findViewById(2131825211));
      paramView.nRk = ((LinearLayout)localView.findViewById(2131825267));
      paramView.nRl = ((TextView)localView.findViewById(2131825268));
      paramView.nRm = ((TextView)localView.findViewById(2131825269));
      paramView.nRn = ((TextView)localView.findViewById(2131825262));
      paramView.nRo = ((TextView)localView.findViewById(2131825261));
      paramView.nRp = ((ImageView)localView.findViewById(2131825270));
      paramView.nRq = localView.findViewById(2131825266);
      paramView.nRq.setClickable(true);
      paramView.nRt = ((ImageView)localView.findViewById(2131821148));
      localView.setTag(paramView);
    }
    h.a locala = (h.a)localView.getTag();
    locala.nRq.setClickable(true);
    locala.nRq.setTag(Integer.valueOf(paramInt));
    locala.nRt.setVisibility(8);
    if (xj(paramInt))
    {
      locala.gvQ.setVisibility(8);
      locala.nRj.setVisibility(8);
      locala.nRk.setVisibility(8);
      locala.ehv.setVisibility(8);
      locala.ehv.setTag(null);
      locala.nRo.setVisibility(8);
      locala.nRn.setVisibility(8);
      locala.nRp.setVisibility(8);
      AppMethodBeat.o(22245);
      return localView;
    }
    k localk = xS(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label808;
      }
      locala.nRo.setVisibility(0);
      locala.nRn.setVisibility(8);
      locala.nRo.setText(this.context.getString(2131300873));
      label415:
      locala.nRt.setVisibility(0);
      locala.gvQ.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.nRr.getLayoutParams();
      paramView.height = ((int)locala.nRj.getContext().getResources().getDimension(2131427404));
      locala.nRr.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.ehv.getLayoutParams();
      paramView.height = ((int)locala.ehv.getContext().getResources().getDimension(2131427490));
      paramView.width = ((int)locala.ehv.getContext().getResources().getDimension(2131427490));
      locala.ehv.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label846;
      }
      if (!this.nRc.containsKey(Long.valueOf(localk.field_addressId))) {
        break label831;
      }
      paramView = (com.tencent.mm.plugin.ipcall.a.g.c)this.nRc.get(Long.valueOf(localk.field_addressId));
      label588:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.nRc.put(Long.valueOf(localk.field_addressId), paramView);
        locala.gvQ.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label625:
      locala.nRj.setVisibility(8);
      locala.nRk.setVisibility(0);
      locala.nRm.setText(com.tencent.mm.plugin.ipcall.b.c.ku(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label867;
      }
      locala.nRl.setText(com.tencent.mm.plugin.ipcall.b.c.ky(localk.field_duration));
      label686:
      paramView = locala.ehv;
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.setTag(null);
        paramView.setImageResource(2130839181);
        if (paramViewGroup != null)
        {
          if ((bo.isNullOrNil(paramViewGroup.field_contactId)) || (bo.isNullOrNil(paramViewGroup.field_wechatUsername))) {
            break label886;
          }
          this.nRb.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.nRd.add(paramViewGroup.field_wechatUsername);
      }
      locala.nRq.setVisibility(0);
      locala.nRp.setVisibility(0);
      locala.nRq.setOnClickListener(this.nUC);
      break;
      label808:
      locala.nRo.setVisibility(8);
      locala.nRn.setVisibility(8);
      break label415;
      label831:
      paramView = i.bJt().kq(localk.field_addressId);
      break label588;
      label846:
      locala.gvQ.setText(a.RG(localk.field_phonenumber));
      paramViewGroup = null;
      break label625;
      label867:
      locala.nRl.setText(com.tencent.mm.plugin.ipcall.b.c.xX(localk.field_status));
      break label686;
      label886:
      if (!bo.isNullOrNil(paramViewGroup.field_contactId)) {
        this.nRb.c(paramViewGroup.field_contactId, paramView);
      } else if (!bo.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.nRb.e(paramViewGroup.field_wechatUsername, paramView);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(22247);
    int i = super.getViewTypeCount();
    AppMethodBeat.o(22247);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(22249);
    this.nUB = m.bJX();
    this.nRc.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(22249);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(22248);
    if (this.nRd.contains(paramString)) {
      al.d(new h.2(this));
    }
    AppMethodBeat.o(22248);
  }
  
  public final k xS(int paramInt)
  {
    AppMethodBeat.i(22244);
    k localk = (k)this.nUB.get(paramInt);
    AppMethodBeat.o(22244);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */