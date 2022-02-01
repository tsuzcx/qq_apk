package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.map.a.c;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.List;

final class j$10$1
  implements View.OnClickListener
{
  j$10$1(j.10 param10) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(56159);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    a.c("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    if (1 == this.ErQ.ErP.size())
    {
      Log.i("MicroMsg.TrackMapUI", "pennqin, only one taxi weapp.");
      Object localObject2 = (rx)this.ErQ.ErP.get(0);
      Log.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((rx)localObject2).appid, ((rx)localObject2).SaZ, ((rx)localObject2).username, Integer.valueOf(((rx)localObject2).version), Integer.valueOf(((rx)localObject2).RYL) });
      com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((rx)localObject2).appid) });
      if (com.tencent.mm.kernel.h.ae(r.class) != null)
      {
        paramView = (r)com.tencent.mm.kernel.h.ae(r.class);
        localObject1 = new g();
        ((g)localObject1).appId = ((rx)localObject2).appid;
        ((g)localObject1).username = ((rx)localObject2).username;
        ((g)localObject1).cBU = ((rx)localObject2).RYL;
        ((g)localObject1).version = ((rx)localObject2).version;
        ((g)localObject1).nBq = ((rx)localObject2).SaZ;
        ((g)localObject1).scene = 1146;
        localObject2 = new com.tencent.mm.plugin.appbrand.api.h();
        ((com.tencent.mm.plugin.appbrand.api.h)localObject2).latitude = ((float)this.ErQ.ErM.oUV.Ejn);
        ((com.tencent.mm.plugin.appbrand.api.h)localObject2).longitude = ((float)this.ErQ.ErM.oUV.Ejo);
        ((com.tencent.mm.plugin.appbrand.api.h)localObject2).poiName = this.ErQ.ErM.oUV.fPN;
        Log.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.h)localObject2).bFa() });
        ((g)localObject1).nBr = ((d)localObject2);
        paramView.a(this.ErQ.ErM.activity, (g)localObject1);
        j.d(this.ErQ.ErM).bYF();
      }
      a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(56159);
      return;
    }
    paramView = new e(this.ErQ.ErM.activity, 1, true);
    paramView.Ynd = true;
    paramView.OEc = true;
    paramView.ODT = new q.f()
    {
      public final void onCreateMMMenu(final o paramAnonymouso)
      {
        AppMethodBeat.i(56157);
        paramView.Z(View.inflate(j.10.1.this.ErQ.ErM.activity, a.f.taxi_weapp_list_title, null), false);
        int i = 0;
        rx localrx;
        if (i < j.10.1.this.ErQ.ErP.size())
        {
          localrx = (rx)j.10.1.this.ErQ.ErP.get(i);
          localObject = u.a(new i(localrx.EtG));
          u.a(new u.a()
          {
            public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(56156);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(56155);
                  if ((j.e(j.10.1.this.ErQ.ErM).containsKey(paramAnonymous2String)) && (paramAnonymous2Bitmap != null) && (!paramAnonymous2Bitmap.isRecycled()))
                  {
                    int i = ((Integer)j.e(j.10.1.this.ErQ.ErM).remove(paramAnonymous2String)).intValue();
                    if (j.10.1.1.1.this.ErT.getItem(i) != null)
                    {
                      j.10.1.1.1.this.ErT.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(BitmapUtil.getRoundedCornerBitmap(paramAnonymous2Bitmap, false, paramAnonymous2Bitmap.getWidth() / 2.0F, false), j.10.1.this.ErQ.ErM.activity.getResources().getDimensionPixelOffset(a.c.bottomsheet_list_icon_width), j.10.1.this.ErQ.ErM.activity.getResources().getDimensionPixelOffset(a.c.bottomsheet_list_icon_width), true, false)));
                      j.10.1.1.this.ErR.gIa();
                    }
                  }
                  AppMethodBeat.o(56155);
                }
              });
              AppMethodBeat.o(56156);
            }
          });
          if (localObject == null) {
            break label234;
          }
        }
        label234:
        for (Object localObject = new BitmapDrawable(BitmapUtil.extractThumbNail(BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() / 2.0F, false), j.10.1.this.ErQ.ErM.activity.getResources().getDimensionPixelOffset(a.c.bottomsheet_list_icon_width), j.10.1.this.ErQ.ErM.activity.getResources().getDimensionPixelOffset(a.c.bottomsheet_list_icon_width), true, false));; localObject = null)
        {
          if (localObject == null) {
            j.e(j.10.1.this.ErQ.ErM).put(localrx.EtG, Integer.valueOf(i));
          }
          paramAnonymouso.a(i, localrx.nickname, (Drawable)localObject, 0);
          i += 1;
          break;
          AppMethodBeat.o(56157);
          return;
        }
      }
    };
    paramView.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(56158);
        Log.i("MicroMsg.TrackMapUI", "taxi weapp, index: %s, itemId: %s.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
        Object localObject = (rx)j.10.1.this.ErQ.ErP.get(paramAnonymousInt);
        Log.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((rx)localObject).appid, ((rx)localObject).SaZ, ((rx)localObject).username, Integer.valueOf(((rx)localObject).version), Integer.valueOf(((rx)localObject).RYL) });
        com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((rx)localObject).appid) });
        if (com.tencent.mm.kernel.h.ae(r.class) != null)
        {
          paramAnonymousMenuItem = (r)com.tencent.mm.kernel.h.ae(r.class);
          g localg = new g();
          localg.appId = ((rx)localObject).appid;
          localg.username = ((rx)localObject).username;
          localg.cBU = ((rx)localObject).RYL;
          localg.version = ((rx)localObject).version;
          localg.nBq = ((rx)localObject).SaZ;
          localg.scene = 1146;
          localObject = new com.tencent.mm.plugin.appbrand.api.h();
          ((com.tencent.mm.plugin.appbrand.api.h)localObject).latitude = ((float)j.10.1.this.ErQ.ErM.oUV.Ejn);
          ((com.tencent.mm.plugin.appbrand.api.h)localObject).longitude = ((float)j.10.1.this.ErQ.ErM.oUV.Ejo);
          ((com.tencent.mm.plugin.appbrand.api.h)localObject).poiName = j.10.1.this.ErQ.ErM.oUV.fPN;
          Log.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.h)localObject).bFa() });
          localg.nBr = ((d)localObject);
          paramAnonymousMenuItem.a(j.10.1.this.ErQ.ErM.activity, localg);
        }
        AppMethodBeat.o(56158);
      }
    };
    j.d(this.ErQ.ErM).bYF();
    paramView.eik();
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(56159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.10.1
 * JD-Core Version:    0.7.0.1
 */