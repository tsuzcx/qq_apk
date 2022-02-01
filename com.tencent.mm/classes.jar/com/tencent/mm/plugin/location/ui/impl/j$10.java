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
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class j$10
  implements q.f
{
  j$10(j paramj, List paramList) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(56160);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2;
    int j;
    Object localObject3;
    if (!Util.isNullOrNil(this.ErP))
    {
      localObject1 = LayoutInflater.from(this.ErM.activity).inflate(a.f.taxi_weapp_item_layout, new FrameLayout(this.ErM.activity), false);
      localObject2 = (LinearLayout)((View)localObject1).findViewById(a.e.weapp_icon_container);
      i = aw.fromDPToPix(this.ErM.activity, 24);
      j = aw.fromDPToPix(this.ErM.activity, 2);
      localObject3 = new c.a();
      ((c.a)localObject3).kPz = true;
      ((c.a)localObject3).kOf = i;
      ((c.a)localObject3).kOg = i;
      localObject3 = ((c.a)localObject3).bmL();
      Object localObject4 = this.ErP.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        rx localrx = (rx)((Iterator)localObject4).next();
        ImageView localImageView = new ImageView(this.ErM.activity);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
        localLayoutParams.leftMargin = j;
        localLayoutParams.rightMargin = j;
        ((LinearLayout)localObject2).addView(localImageView, localLayoutParams);
        q.bml().a(localrx.EtG, localImageView, (c)localObject3);
        localStringBuilder.append("weapp_id_").append(localrx.appid).append("|");
      }
      if (1 == this.ErP.size())
      {
        localObject3 = new TextView(this.ErM.activity);
        ((TextView)localObject3).setTextColor(this.ErM.activity.getResources().getColor(a.b.normal_text_color));
        ((TextView)localObject3).setTextSize(17.0F);
        ((TextView)localObject3).setGravity(17);
        ((TextView)localObject3).setText(((rx)this.ErP.get(0)).nickname);
        localObject4 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject4).leftMargin = (j * 3);
        ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      }
      ((View)localObject1).setOnClickListener(new j.10.1(this));
      j.d(this.ErM).setFooterView((View)localObject1);
    }
    Object localObject1 = new StringBuilder();
    j.a(this.ErM, this.ErM.oUX.b(this.ErM.oUV));
    if (!ChannelUtil.isGPVersion())
    {
      i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vFf, 99);
      if (j.f(this.ErM) >= i) {}
    }
    for (int i = 1;; i = 0)
    {
      j = i;
      if (i == 0)
      {
        j = i;
        if (j.g(this.ErM)) {
          j = 1;
        }
      }
      if (j != 0)
      {
        ((StringBuilder)localObject1).append("com.tencent.map|");
        paramo.aW(2, a.i.tencent_map_label, 0);
      }
      localObject2 = j.h(this.ErM).entrySet().iterator();
      i = 3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!((String)((Map.Entry)localObject3).getKey()).equals("com.tencent.map"))
        {
          ((StringBuilder)localObject1).append((String)((Map.Entry)localObject3).getKey()).append("|");
          paramo.b(i, (CharSequence)((Map.Entry)localObject3).getValue(), 0);
        }
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(3), ((StringBuilder)localObject1).toString(), localStringBuilder.toString() });
      AppMethodBeat.o(56160);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.10
 * JD-Core Version:    0.7.0.1
 */