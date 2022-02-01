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
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
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
    ((b)localObject1).bm(paramView);
    a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    if (1 == this.yNS.yNR.size())
    {
      Log.i("MicroMsg.TrackMapUI", "pennqin, only one taxi weapp.");
      Object localObject2 = (se)this.yNS.yNR.get(0);
      Log.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((se)localObject2).dNI, ((se)localObject2).KZQ, ((se)localObject2).username, Integer.valueOf(((se)localObject2).version), Integer.valueOf(((se)localObject2).KXC) });
      com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((se)localObject2).dNI) });
      if (com.tencent.mm.kernel.g.af(r.class) != null)
      {
        paramView = (r)com.tencent.mm.kernel.g.af(r.class);
        localObject1 = new com.tencent.mm.plugin.appbrand.api.g();
        ((com.tencent.mm.plugin.appbrand.api.g)localObject1).appId = ((se)localObject2).dNI;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject1).username = ((se)localObject2).username;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject1).iOo = ((se)localObject2).KXC;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject1).version = ((se)localObject2).version;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject1).kHw = ((se)localObject2).KZQ;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject1).scene = 1146;
        localObject2 = new com.tencent.mm.plugin.appbrand.api.h();
        ((com.tencent.mm.plugin.appbrand.api.h)localObject2).latitude = ((float)this.yNS.yNO.lXk.yFu);
        ((com.tencent.mm.plugin.appbrand.api.h)localObject2).dTj = ((float)this.yNS.yNO.lXk.yFv);
        ((com.tencent.mm.plugin.appbrand.api.h)localObject2).kHV = this.yNS.yNO.lXk.dWi;
        Log.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.h)localObject2).bua() });
        ((com.tencent.mm.plugin.appbrand.api.g)localObject1).kHx = ((d)localObject2);
        paramView.a(this.yNS.yNO.activity, (com.tencent.mm.plugin.appbrand.api.g)localObject1);
        j.d(this.yNS.yNO).bMo();
      }
      a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(56159);
      return;
    }
    paramView = new e(this.yNS.yNO.activity, 1, true);
    paramView.QOr = true;
    paramView.HMg = true;
    paramView.HLX = new o.f()
    {
      public final void onCreateMMMenu(final m paramAnonymousm)
      {
        AppMethodBeat.i(56157);
        paramView.V(View.inflate(j.10.1.this.yNS.yNO.activity, 2131496665, null), false);
        int i = 0;
        Object localObject2;
        if (i < j.10.1.this.yNS.yNR.size())
        {
          localObject2 = (se)j.10.1.this.yNS.yNR.get(i);
          localObject1 = u.a(new i(((se)localObject2).yPH));
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
                  if ((j.e(j.10.1.this.yNS.yNO).containsKey(paramAnonymous2String)) && (paramAnonymous2Bitmap != null) && (!paramAnonymous2Bitmap.isRecycled()))
                  {
                    int i = ((Integer)j.e(j.10.1.this.yNS.yNO).remove(paramAnonymous2String)).intValue();
                    if (j.10.1.1.1.this.yNV.getItem(i) != null)
                    {
                      j.10.1.1.1.this.yNV.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(BitmapUtil.getRoundedCornerBitmap(paramAnonymous2Bitmap, false, paramAnonymous2Bitmap.getWidth() / 2.0F, false), j.10.1.this.yNS.yNO.activity.getResources().getDimensionPixelOffset(2131165956), j.10.1.this.yNS.yNO.activity.getResources().getDimensionPixelOffset(2131165956), true, false)));
                      j.10.1.1.this.yNT.fPw();
                    }
                  }
                  AppMethodBeat.o(56155);
                }
              });
              AppMethodBeat.o(56156);
            }
          });
          if (localObject1 == null) {
            break label275;
          }
        }
        label275:
        for (Object localObject1 = new BitmapDrawable(BitmapUtil.extractThumbNail(BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() / 2.0F, false), j.10.1.this.yNS.yNO.activity.getResources().getDimensionPixelOffset(2131165956), j.10.1.this.yNS.yNO.activity.getResources().getDimensionPixelOffset(2131165956), true, false));; localObject1 = null)
        {
          if (localObject1 == null) {
            j.e(j.10.1.this.yNS.yNO).put(((se)localObject2).yPH, Integer.valueOf(i));
          }
          localObject2 = ((se)localObject2).nickname;
          n localn = new n(paramAnonymousm.mContext, i, 0);
          localn.setTitle((CharSequence)localObject2);
          localn.setIcon((Drawable)localObject1);
          localn.f((Drawable)localObject1, 0);
          paramAnonymousm.ORD.add(localn);
          i += 1;
          break;
          AppMethodBeat.o(56157);
          return;
        }
      }
    };
    paramView.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(56158);
        Log.i("MicroMsg.TrackMapUI", "taxi weapp, index: %s, itemId: %s.", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
        Object localObject = (se)j.10.1.this.yNS.yNR.get(paramAnonymousInt);
        Log.i("MicroMsg.TrackMapUI", "taxi weapp info: appid %s, page_url %s, username %s, version %s, version_type %s.", new Object[] { ((se)localObject).dNI, ((se)localObject).KZQ, ((se)localObject).username, Integer.valueOf(((se)localObject).version), Integer.valueOf(((se)localObject).KXC) });
        com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(4), "weapp_id_".concat(((se)localObject).dNI) });
        if (com.tencent.mm.kernel.g.af(r.class) != null)
        {
          paramAnonymousMenuItem = (r)com.tencent.mm.kernel.g.af(r.class);
          com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
          localg.appId = ((se)localObject).dNI;
          localg.username = ((se)localObject).username;
          localg.iOo = ((se)localObject).KXC;
          localg.version = ((se)localObject).version;
          localg.kHw = ((se)localObject).KZQ;
          localg.scene = 1146;
          localObject = new com.tencent.mm.plugin.appbrand.api.h();
          ((com.tencent.mm.plugin.appbrand.api.h)localObject).latitude = ((float)j.10.1.this.yNS.yNO.lXk.yFu);
          ((com.tencent.mm.plugin.appbrand.api.h)localObject).dTj = ((float)j.10.1.this.yNS.yNO.lXk.yFv);
          ((com.tencent.mm.plugin.appbrand.api.h)localObject).kHV = j.10.1.this.yNS.yNO.lXk.dWi;
          Log.i("MicroMsg.TrackMapUI", "pennqin, extra data: %s.", new Object[] { ((com.tencent.mm.plugin.appbrand.api.h)localObject).bua() });
          localg.kHx = ((d)localObject);
          paramAnonymousMenuItem.a(j.10.1.this.yNS.yNO.activity, localg);
        }
        AppMethodBeat.o(56158);
      }
    };
    j.d(this.yNS.yNO).bMo();
    paramView.dGm();
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(56159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.10.1
 * JD-Core Version:    0.7.0.1
 */