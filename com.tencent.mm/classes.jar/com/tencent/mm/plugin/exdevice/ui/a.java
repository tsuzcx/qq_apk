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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.f.a.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.List;

final class a
  extends BaseAdapter
{
  String ikj;
  c lNj;
  private boolean lNk;
  boolean lNl;
  int lNm;
  int lNn;
  ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> lNo;
  List<nl> lNp;
  private View lNq;
  private String mAppName;
  private Context mContext;
  
  public a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mContext = paramContext;
    this.ikj = paramString2;
    this.lNk = paramBoolean;
    this.mAppName = paramString1;
  }
  
  public final int getCount()
  {
    if (this.lNk) {
      return this.lNm + 5 + this.lNn;
    }
    return 2;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(20007);
    AppMethodBeat.o(20007);
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (!this.lNk) {
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
    if ((paramInt > 1) && (paramInt <= this.lNm + 1)) {
      return 1;
    }
    if (paramInt == this.lNm + 2) {
      return 2;
    }
    if (paramInt == this.lNm + 3) {
      return 5;
    }
    if ((paramInt > this.lNm + 3) && (paramInt <= this.lNm + 3 + this.lNn)) {
      return 3;
    }
    if (paramInt == this.lNm + this.lNn + 4) {
      return 7;
    }
    return 5;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(20008);
    int i = getItemViewType(paramInt);
    Object localObject;
    a.c localc;
    a.a locala;
    a.d locald;
    a.e locale;
    a.f localf;
    if (paramView == null) {
      switch (i)
      {
      default: 
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(20008);
      return paramView;
      if (this.lNq == null) {
        this.lNq = LayoutInflater.from(this.mContext).inflate(2130969465, paramViewGroup, false);
      }
      paramView = this.lNq;
      localf = new a.f(this);
      localf.kPy = ((ImageView)paramView.findViewById(2131823814));
      paramView.setTag(localf);
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locala = null;
      locald = null;
      locale = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2130969464, paramViewGroup, false);
      locale = new a.e(this);
      locale.lNw = ((NoMeasuredTextView)paramView.findViewById(2131823805));
      locale.lNx = ((TextView)paramView.findViewById(2131823806));
      locale.kPy = ((ImageView)paramView.findViewById(2131823802));
      locale.lNs = paramView.findViewById(2131823801);
      locale.lNw.setTextSize(0, this.mContext.getResources().getDimension(2131427627));
      locale.lNw.setTextColor(this.mContext.getResources().getColor(2131690010));
      locale.lNw.setSingleLine(true);
      locale.lNw.setShouldEllipsize(true);
      paramView.setTag(locale);
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locala = null;
      locald = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2130969460, paramViewGroup, false);
      locala = new a.a(this);
      locala.jhF = ((TextView)paramView.findViewById(2131823788));
      locala.lNs = paramView.findViewById(2131823784);
      locala.lKs = ((ImageView)paramView.findViewById(2131823785));
      paramView.setTag(locala);
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2130969460, paramViewGroup, false);
      localc = new a.c(this);
      localc.jhF = ((TextView)paramView.findViewById(2131823788));
      localc.lNs = paramView.findViewById(2131823784);
      localc.lKs = ((ImageView)paramView.findViewById(2131823785));
      localc.lNu = paramView.findViewById(2131823790);
      paramView.setTag(localc);
      paramViewGroup = null;
      localObject = null;
      locala = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2130969463, paramViewGroup, false);
      locald = new a.d(this);
      locald.lNv = ((Button)paramView.findViewById(2131823799));
      paramView.setTag(locald);
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locala = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2130969462, paramViewGroup, false);
      paramView.setTag(new a.b(this));
      paramViewGroup = null;
      localObject = null;
      localc = null;
      locala = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2130969462, paramViewGroup, false);
      localObject = new a.b(this);
      ((a.b)localObject).jhF = ((TextView)paramView.findViewById(2131823796));
      paramView.setTag(localObject);
      paramViewGroup = null;
      localc = null;
      locala = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      paramView = LayoutInflater.from(this.mContext).inflate(2130969462, paramViewGroup, false);
      paramViewGroup = new a.b(this);
      paramViewGroup.lNt = paramView.findViewById(2131823794);
      paramView.setTag(paramViewGroup);
      localObject = null;
      localc = null;
      locala = null;
      locald = null;
      locale = null;
      localf = null;
      break;
      switch (i)
      {
      default: 
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 0: 
        localf = (a.f)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        break;
      case 1: 
        locale = (a.e)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        localf = null;
        break;
      case 2: 
        locala = (a.a)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 3: 
        localc = (a.c)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 4: 
        locald = (a.d)paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locale = null;
        localf = null;
        break;
      case 5: 
        paramView.getTag();
        paramViewGroup = null;
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 6: 
        localObject = (a.b)paramView.getTag();
        paramViewGroup = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
      case 7: 
        paramViewGroup = (a.b)paramView.getTag();
        localObject = null;
        localc = null;
        locala = null;
        locald = null;
        locale = null;
        localf = null;
        break;
        com.tencent.mm.pluginsdk.ui.a.b.t(localf.kPy, this.ikj);
        localf.kPy.setOnClickListener(new a.1(this));
        continue;
        if ((paramInt - 2 >= 0) && (!bo.es(this.lNo)))
        {
          paramViewGroup = (com.tencent.mm.plugin.exdevice.f.b.a.c)this.lNo.get(paramInt - 2);
          if (paramViewGroup != null)
          {
            paramInt = paramViewGroup.field_step;
            localObject = paramViewGroup.field_username;
            if (paramViewGroup.field_step >= 10000) {
              locale.lNx.setTextColor(this.mContext.getResources().getColor(2131690009));
            }
            for (;;)
            {
              locale.lNw.setText(j.b(this.mContext, s.nE((String)localObject), locale.lNw.getTextSize()));
              locale.lNx.setText(String.valueOf(paramInt));
              com.tencent.mm.pluginsdk.ui.a.b.s(locale.kPy, (String)localObject);
              locale.lNs.setOnClickListener(new a.2(this, (String)localObject));
              break;
              locale.lNx.setTextColor(this.mContext.getResources().getColor(2131690008));
            }
            locala.jhF.setText(this.mContext.getResources().getText(2131299439));
            locala.lKs.setImageResource(2131231245);
            locala.lNs.setOnClickListener(new a.3(this));
            continue;
            if ((paramInt - this.lNm - 4 >= 0) && (!bo.es(this.lNp)))
            {
              localObject = (nl)this.lNp.get(paramInt - this.lNm - 4);
              if (localObject != null)
              {
                paramViewGroup = ((nl)localObject).title;
                localObject = ((nl)localObject).cDz;
                localc.jhF.setText(paramViewGroup);
                if (paramInt - this.lNm - 4 != this.lNn - 1) {
                  localc.lNu.setVisibility(0);
                }
                e.a(this.mContext, localc.lKs, (String)localObject);
                localc.lNs.setOnClickListener(new a.4(this));
                continue;
                if (!this.lNl)
                {
                  aw.aaz();
                  if (com.tencent.mm.model.c.YA().arr(this.ikj))
                  {
                    locald.lNv.setVisibility(0);
                    locald.lNv.setOnClickListener(new a.5(this));
                    continue;
                  }
                }
                locald.lNv.setVisibility(4);
                continue;
                ((a.b)localObject).jhF.setText(this.mContext.getString(2131299448));
                continue;
                paramViewGroup.lNt.setVisibility(0);
              }
            }
          }
        }
        break;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a
 * JD-Core Version:    0.7.0.1
 */