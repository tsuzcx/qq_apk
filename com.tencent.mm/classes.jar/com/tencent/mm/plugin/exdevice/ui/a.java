package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.f.a.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.List;

final class a
  extends BaseAdapter
{
  String hcm;
  c jDL;
  private boolean jDM;
  boolean jDN;
  int jDO;
  int jDP;
  ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> jDQ;
  List<kz> jDR;
  private View jDS;
  private String mAppName;
  private Context mContext;
  
  public a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.hcm = paramString2;
    this.jDM = paramBoolean;
    this.mAppName = paramString1;
  }
  
  public final int getCount()
  {
    if (this.jDM) {
      return this.jDO + 5 + this.jDP;
    }
    return 2;
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (!this.jDM) {
      if (paramInt != 0) {}
    }
    while (paramInt == 0)
    {
      return 0;
      return 4;
    }
    if (paramInt == 1) {
      return 6;
    }
    if ((paramInt > 1) && (paramInt <= this.jDO + 1)) {
      return 1;
    }
    if (paramInt == this.jDO + 2) {
      return 2;
    }
    if (paramInt == this.jDO + 3) {
      return 5;
    }
    if ((paramInt > this.jDO + 3) && (paramInt <= this.jDO + 3 + this.jDP)) {
      return 3;
    }
    if (paramInt == this.jDO + this.jDP + 4) {
      return 7;
    }
    return 5;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    a.c localc;
    d locald;
    a.e locale;
    a.f localf;
    if (paramView == null) {
      switch (i)
      {
      default: 
        paramViewGroup = null;
        localObject1 = null;
        localc = null;
        localObject2 = null;
        locald = null;
        locale = null;
        localf = null;
        switch (i)
        {
        }
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramView;
            if (this.jDS == null) {
              this.jDS = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_item, paramViewGroup, false);
            }
            paramView = this.jDS;
            localf = new a.f(this);
            localf.iIS = ((ImageView)paramView.findViewById(R.h.exdevice_my_avatar));
            paramView.setTag(localf);
            paramViewGroup = null;
            localObject1 = null;
            localc = null;
            localObject2 = null;
            locald = null;
            locale = null;
            break;
            paramView = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_followers_view, paramViewGroup, false);
            locale = new a.e(this);
            locale.jDY = ((NoMeasuredTextView)paramView.findViewById(R.h.exdevice_profile_followers_user_name));
            locale.jDZ = ((TextView)paramView.findViewById(R.h.exdevice_profile_followers_user_score));
            locale.iIS = ((ImageView)paramView.findViewById(R.h.exdevice_profile_followers_avatar));
            locale.jDU = paramView.findViewById(R.h.exdevice_profile_followers_item_content);
            locale.jDY.setTextSize(0, this.mContext.getResources().getDimension(R.f.ExdeviceRankInfoUserName));
            locale.jDY.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_user_name));
            locale.jDY.setSingleLine(true);
            locale.jDY.setShouldEllipsize(true);
            paramView.setTag(locale);
            paramViewGroup = null;
            localObject1 = null;
            localc = null;
            localObject2 = null;
            locald = null;
            localf = null;
            break;
            paramView = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_add_donate_item, paramViewGroup, false);
            localObject2 = new a.a(this);
            ((a.a)localObject2).hrg = ((TextView)paramView.findViewById(R.h.exdevice_profile_add_donate_title));
            ((a.a)localObject2).jDU = paramView.findViewById(R.h.exdevice_profile_add_donate_item_content);
            ((a.a)localObject2).jAT = ((ImageView)paramView.findViewById(R.h.exdevice_profile_add_donate_logo));
            paramView.setTag(localObject2);
            paramViewGroup = null;
            localObject1 = null;
            localc = null;
            locald = null;
            locale = null;
            localf = null;
            break;
            paramView = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_add_donate_item, paramViewGroup, false);
            localc = new a.c(this);
            localc.hrg = ((TextView)paramView.findViewById(R.h.exdevice_profile_add_donate_title));
            localc.jDU = paramView.findViewById(R.h.exdevice_profile_add_donate_item_content);
            localc.jAT = ((ImageView)paramView.findViewById(R.h.exdevice_profile_add_donate_logo));
            localc.jDW = paramView.findViewById(R.h.exdevice_profile_add_donate_dividerV);
            paramView.setTag(localc);
            paramViewGroup = null;
            localObject1 = null;
            localObject2 = null;
            locald = null;
            locale = null;
            localf = null;
            break;
            paramView = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_follow_btn, paramViewGroup, false);
            locald = new d();
            locald.jDX = ((Button)paramView.findViewById(R.h.exdevice_profile_follow_btn));
            paramView.setTag(locald);
            paramViewGroup = null;
            localObject1 = null;
            localc = null;
            localObject2 = null;
            locale = null;
            localf = null;
            break;
            paramView = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_divider_item, paramViewGroup, false);
            paramView.setTag(new b());
            paramViewGroup = null;
            localObject1 = null;
            localc = null;
            localObject2 = null;
            locald = null;
            locale = null;
            localf = null;
            break;
            paramView = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_divider_item, paramViewGroup, false);
            localObject1 = new b();
            ((b)localObject1).hrg = ((TextView)paramView.findViewById(R.h.exdevice_profile_divider_title));
            paramView.setTag(localObject1);
            paramViewGroup = null;
            localc = null;
            localObject2 = null;
            locald = null;
            locale = null;
            localf = null;
            break;
            paramView = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_divider_item, paramViewGroup, false);
            paramViewGroup = new b();
            paramViewGroup.jDV = paramView.findViewById(R.h.exdevice_profile_divider_size);
            paramView.setTag(paramViewGroup);
            localObject1 = null;
            localc = null;
            localObject2 = null;
            locald = null;
            locale = null;
            localf = null;
            break;
            switch (i)
            {
            default: 
              paramViewGroup = null;
              localObject1 = null;
              localc = null;
              localObject2 = null;
              locald = null;
              locale = null;
              localf = null;
              break;
            case 0: 
              localf = (a.f)paramView.getTag();
              paramViewGroup = null;
              localObject1 = null;
              localc = null;
              localObject2 = null;
              locald = null;
              locale = null;
              break;
            case 1: 
              locale = (a.e)paramView.getTag();
              paramViewGroup = null;
              localObject1 = null;
              localc = null;
              localObject2 = null;
              locald = null;
              localf = null;
              break;
            case 2: 
              localObject2 = (a.a)paramView.getTag();
              paramViewGroup = null;
              localObject1 = null;
              localc = null;
              locald = null;
              locale = null;
              localf = null;
              break;
            case 3: 
              localc = (a.c)paramView.getTag();
              paramViewGroup = null;
              localObject1 = null;
              localObject2 = null;
              locald = null;
              locale = null;
              localf = null;
              break;
            case 4: 
              locald = (d)paramView.getTag();
              paramViewGroup = null;
              localObject1 = null;
              localc = null;
              localObject2 = null;
              locale = null;
              localf = null;
              break;
            case 5: 
              paramView.getTag();
              paramViewGroup = null;
              localObject1 = null;
              localc = null;
              localObject2 = null;
              locald = null;
              locale = null;
              localf = null;
              break;
            case 6: 
              localObject1 = (b)paramView.getTag();
              paramViewGroup = null;
              localc = null;
              localObject2 = null;
              locald = null;
              locale = null;
              localf = null;
              break;
            case 7: 
              paramViewGroup = (b)paramView.getTag();
              localObject1 = null;
              localc = null;
              localObject2 = null;
              locald = null;
              locale = null;
              localf = null;
              break;
              com.tencent.mm.pluginsdk.ui.a.b.o(localf.iIS, this.hcm);
              localf.iIS.setOnClickListener(new a.1(this));
              return paramView;
            }
          } while ((paramInt - 2 < 0) || (bk.dk(this.jDQ)));
          paramViewGroup = (com.tencent.mm.plugin.exdevice.f.b.a.c)this.jDQ.get(paramInt - 2);
        } while (paramViewGroup == null);
        paramInt = paramViewGroup.field_step;
        localObject1 = paramViewGroup.field_username;
        if (paramViewGroup.field_step >= 10000) {
          locale.jDZ.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_up_step));
        }
        for (;;)
        {
          locale.jDY.setText(j.a(this.mContext, r.gV((String)localObject1), locale.jDY.getTextSize()));
          locale.jDZ.setText(String.valueOf(paramInt));
          com.tencent.mm.pluginsdk.ui.a.b.n(locale.iIS, (String)localObject1);
          locale.jDU.setOnClickListener(new a.2(this, (String)localObject1));
          return paramView;
          locale.jDZ.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_step));
        }
        ((a.a)localObject2).hrg.setText(this.mContext.getResources().getText(R.l.exdevice_profile_add));
        ((a.a)localObject2).jAT.setImageResource(R.k.device_profile_ui_add_followers_logo);
        ((a.a)localObject2).jDU.setOnClickListener(new a.3(this));
        return paramView;
      } while ((paramInt - this.jDO - 4 < 0) || (bk.dk(this.jDR)));
      localObject2 = (kz)this.jDR.get(paramInt - this.jDO - 4);
    } while (localObject2 == null);
    paramViewGroup = ((kz)localObject2).title;
    Object localObject1 = ((kz)localObject2).bVO;
    Object localObject2 = ((kz)localObject2).url;
    localc.hrg.setText(paramViewGroup);
    if (paramInt - this.jDO - 4 != this.jDP - 1) {
      localc.jDW.setVisibility(0);
    }
    e.a(this.mContext, localc.jAT, (String)localObject1, R.e.darkgrey);
    localc.jDU.setOnClickListener(new a.4(this, (String)localObject2));
    return paramView;
    if (!this.jDN)
    {
      au.Hx();
      if (com.tencent.mm.model.c.Fw().abg(this.hcm))
      {
        locald.jDX.setVisibility(0);
        locald.jDX.setOnClickListener(new a.5(this));
        return paramView;
      }
    }
    locald.jDX.setVisibility(4);
    return paramView;
    ((b)localObject1).hrg.setText(this.mContext.getString(R.l.exdevice_profile_followers));
    return paramView;
    paramViewGroup.jDV.setVisibility(0);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 8;
  }
  
  final class b
  {
    TextView hrg;
    View jDV;
    
    b() {}
  }
  
  final class d
  {
    Button jDX;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a
 * JD-Core Version:    0.7.0.1
 */