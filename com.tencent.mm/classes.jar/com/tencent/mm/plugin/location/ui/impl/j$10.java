package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.a.f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class j$10
  implements u.g
{
  j$10(j paramj, List paramList) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(56160);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2;
    int j;
    Object localObject3;
    if (!Util.isNullOrNil(this.Kkv))
    {
      localObject1 = LayoutInflater.from(this.Kks.activity).inflate(a.f.taxi_weapp_item_layout, new FrameLayout(this.Kks.activity), false);
      localObject2 = (LinearLayout)((View)localObject1).findViewById(a.e.weapp_icon_container);
      i = bd.fromDPToPix(this.Kks.activity, 24);
      j = bd.fromDPToPix(this.Kks.activity, 2);
      localObject3 = new com.tencent.mm.modelimage.loader.a.c.a();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).nrc = true;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).npU = i;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).npV = i;
      localObject3 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).bKx();
      Object localObject4 = this.Kkv.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ti localti = (ti)((Iterator)localObject4).next();
        ImageView localImageView = new ImageView(this.Kks.activity);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
        localLayoutParams.leftMargin = j;
        localLayoutParams.rightMargin = j;
        ((LinearLayout)localObject2).addView(localImageView, localLayoutParams);
        r.bKe().a(localti.Kmn, localImageView, (com.tencent.mm.modelimage.loader.a.c)localObject3);
        localStringBuilder.append("weapp_id_").append(localti.appid).append("|");
      }
      if (1 == this.Kkv.size())
      {
        localObject3 = new TextView(this.Kks.activity);
        ((TextView)localObject3).setTextColor(this.Kks.activity.getResources().getColor(a.b.normal_text_color));
        ((TextView)localObject3).setTextSize(17.0F);
        ((TextView)localObject3).setGravity(17);
        ((TextView)localObject3).setText(((ti)this.Kkv.get(0)).nickname);
        localObject4 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject4).leftMargin = (j * 3);
        ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      }
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56159);
          Object localObject1 = new b();
          ((b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
          if (1 == j.10.this.Kkv.size())
          {
            Log.i("MicroMsg.TrackMapUI", "pennqin, only one taxi weapp.");
            Object localObject2 = (ti)j.10.this.Kkv.get(0);
            Log.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((ti)localObject2).appid, ((ti)localObject2).YYY, ((ti)localObject2).username, Integer.valueOf(((ti)localObject2).version), Integer.valueOf(((ti)localObject2).Tqb) });
            com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((ti)localObject2).appid) });
            if (com.tencent.mm.kernel.h.ax(t.class) != null)
            {
              paramAnonymousView = (t)com.tencent.mm.kernel.h.ax(t.class);
              localObject1 = new g();
              ((g)localObject1).appId = ((ti)localObject2).appid;
              ((g)localObject1).username = ((ti)localObject2).username;
              ((g)localObject1).euz = ((ti)localObject2).Tqb;
              ((g)localObject1).version = ((ti)localObject2).version;
              ((g)localObject1).qAF = ((ti)localObject2).YYY;
              ((g)localObject1).scene = 1146;
              localObject2 = new com.tencent.mm.plugin.appbrand.api.h();
              ((com.tencent.mm.plugin.appbrand.api.h)localObject2).latitude = ((float)j.10.this.Kks.sai.KbW);
              ((com.tencent.mm.plugin.appbrand.api.h)localObject2).longitude = ((float)j.10.this.Kks.sai.KbX);
              ((com.tencent.mm.plugin.appbrand.api.h)localObject2).poiName = j.10.this.Kks.sai.hVI;
              Log.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.h)localObject2).toJsonString() });
              ((g)localObject1).qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject2);
              paramAnonymousView.a(j.10.this.Kks.activity, (g)localObject1);
              j.d(j.10.this.Kks).cyW();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(56159);
            return;
          }
          paramAnonymousView = new f(j.10.this.Kks.activity, 1, true);
          paramAnonymousView.agfb = true;
          paramAnonymousView.Vto = true;
          paramAnonymousView.Vtg = new j.10.1.1(this, paramAnonymousView);
          paramAnonymousView.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(56158);
              Log.i("MicroMsg.TrackMapUI", "taxi weapp, index: %s, itemId: %s.", new Object[] { Integer.valueOf(paramAnonymous2Int), Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
              Object localObject = (ti)j.10.this.Kkv.get(paramAnonymous2Int);
              Log.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((ti)localObject).appid, ((ti)localObject).YYY, ((ti)localObject).username, Integer.valueOf(((ti)localObject).version), Integer.valueOf(((ti)localObject).Tqb) });
              com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((ti)localObject).appid) });
              if (com.tencent.mm.kernel.h.ax(t.class) != null)
              {
                paramAnonymous2MenuItem = (t)com.tencent.mm.kernel.h.ax(t.class);
                g localg = new g();
                localg.appId = ((ti)localObject).appid;
                localg.username = ((ti)localObject).username;
                localg.euz = ((ti)localObject).Tqb;
                localg.version = ((ti)localObject).version;
                localg.qAF = ((ti)localObject).YYY;
                localg.scene = 1146;
                localObject = new com.tencent.mm.plugin.appbrand.api.h();
                ((com.tencent.mm.plugin.appbrand.api.h)localObject).latitude = ((float)j.10.this.Kks.sai.KbW);
                ((com.tencent.mm.plugin.appbrand.api.h)localObject).longitude = ((float)j.10.this.Kks.sai.KbX);
                ((com.tencent.mm.plugin.appbrand.api.h)localObject).poiName = j.10.this.Kks.sai.hVI;
                Log.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.h)localObject).toJsonString() });
                localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject);
                paramAnonymous2MenuItem.a(j.10.this.Kks.activity, localg);
              }
              AppMethodBeat.o(56158);
            }
          };
          j.d(j.10.this.Kks).cyW();
          paramAnonymousView.dDn();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56159);
        }
      });
      j.d(this.Kks).setFooterView((View)localObject1);
    }
    Object localObject1 = new StringBuilder();
    j.a(this.Kks, this.Kks.sak.b(this.Kks.sai));
    if (!ChannelUtil.isGPVersion())
    {
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yUD, 99);
      if (j.f(this.Kks) >= i) {}
    }
    for (int i = 1;; i = 0)
    {
      j = i;
      if (i == 0)
      {
        j = i;
        if (j.g(this.Kks)) {
          j = 1;
        }
      }
      if (j != 0)
      {
        ((StringBuilder)localObject1).append("com.tencent.map|");
        params.bx(2, a.i.tencent_map_label, 0);
      }
      localObject2 = j.h(this.Kks).entrySet().iterator();
      i = 3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (!((String)((Map.Entry)localObject3).getKey()).equals("com.tencent.map"))
        {
          ((StringBuilder)localObject1).append((String)((Map.Entry)localObject3).getKey()).append("|");
          params.a(i, (CharSequence)((Map.Entry)localObject3).getValue(), 0);
        }
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(3), ((StringBuilder)localObject1).toString(), localStringBuilder.toString() });
      AppMethodBeat.o(56160);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.10
 * JD-Core Version:    0.7.0.1
 */