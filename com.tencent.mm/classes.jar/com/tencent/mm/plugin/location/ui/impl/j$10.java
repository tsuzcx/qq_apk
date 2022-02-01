package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class j$10
  implements o.f
{
  j$10(j paramj, List paramList) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(56160);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2;
    int j;
    Object localObject3;
    if (!Util.isNullOrNil(this.yNR))
    {
      localObject1 = LayoutInflater.from(this.yNO.activity).inflate(2131496664, new FrameLayout(this.yNO.activity), false);
      localObject2 = (LinearLayout)((View)localObject1).findViewById(2131310366);
      i = at.fromDPToPix(this.yNO.activity, 24);
      j = at.fromDPToPix(this.yNO.activity, 2);
      localObject3 = new c.a();
      ((c.a)localObject3).iaT = true;
      ((c.a)localObject3).hZz = i;
      ((c.a)localObject3).hZA = i;
      localObject3 = ((c.a)localObject3).bdv();
      Object localObject4 = this.yNR.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        se localse = (se)((Iterator)localObject4).next();
        ImageView localImageView = new ImageView(this.yNO.activity);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
        localLayoutParams.leftMargin = j;
        localLayoutParams.rightMargin = j;
        ((LinearLayout)localObject2).addView(localImageView, localLayoutParams);
        q.bcV().a(localse.yPH, localImageView, (c)localObject3);
        localStringBuilder.append("weapp_id_").append(localse.dNI).append("|");
      }
      if (1 == this.yNR.size())
      {
        localObject3 = new TextView(this.yNO.activity);
        ((TextView)localObject3).setTextColor(this.yNO.activity.getResources().getColor(2131100904));
        ((TextView)localObject3).setTextSize(17.0F);
        ((TextView)localObject3).setGravity(17);
        ((TextView)localObject3).setText(((se)this.yNR.get(0)).nickname);
        localObject4 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject4).leftMargin = (j * 3);
        ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      }
      ((View)localObject1).setOnClickListener(new j.10.1(this));
      j.d(this.yNO).setFooterView((View)localObject1);
    }
    Object localObject1 = new StringBuilder();
    j.a(this.yNO, this.yNO.lXm.b(this.yNO.lXk));
    if (!ChannelUtil.isGPVersion())
    {
      i = ((b)g.af(b.class)).a(b.a.rYm, 99);
      if (j.f(this.yNO) >= i) {}
    }
    for (int i = 1;; i = 0)
    {
      j = i;
      if (i == 0)
      {
        j = i;
        if (j.g(this.yNO)) {
          j = 1;
        }
      }
      if (j != 0)
      {
        ((StringBuilder)localObject1).append("com.tencent.map|");
        paramm.aS(2, 2131766704, 0);
      }
      localObject2 = j.h(this.yNO).entrySet().iterator();
      i = 3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!((String)((Map.Entry)localObject3).getKey()).equals("com.tencent.map"))
        {
          ((StringBuilder)localObject1).append((String)((Map.Entry)localObject3).getKey()).append("|");
          paramm.b(i, (CharSequence)((Map.Entry)localObject3).getValue(), 0);
        }
        i += 1;
      }
      h.CyF.a(12809, new Object[] { Integer.valueOf(3), ((StringBuilder)localObject1).toString(), localStringBuilder.toString() });
      AppMethodBeat.o(56160);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.10
 * JD-Core Version:    0.7.0.1
 */