package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.map.a.c;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashMap;
import java.util.List;

final class j$10$1$1
  implements u.g
{
  j$10$1$1(j.10.1 param1, f paramf) {}
  
  public final void onCreateMMMenu(final s params)
  {
    AppMethodBeat.i(56157);
    this.Kkx.af(View.inflate(this.Kky.Kkw.Kks.activity, a.f.taxi_weapp_list_title, null), false);
    int i = 0;
    ti localti;
    if (i < this.Kky.Kkw.Kkv.size())
    {
      localti = (ti)this.Kky.Kkw.Kkv.get(i);
      localObject = r.a(new i(localti.Kmn));
      r.a(new r.a()
      {
        public final void k(final String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(56156);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(56155);
              if ((j.e(j.10.1.1.this.Kky.Kkw.Kks).containsKey(paramAnonymousString)) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
              {
                int i = ((Integer)j.e(j.10.1.1.this.Kky.Kkw.Kks).remove(paramAnonymousString)).intValue();
                if (j.10.1.1.1.this.Kkz.getItem(i) != null)
                {
                  j.10.1.1.1.this.Kkz.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() / 2.0F, false), j.10.1.1.this.Kky.Kkw.Kks.activity.getResources().getDimensionPixelOffset(a.c.bottomsheet_list_icon_width), j.10.1.1.this.Kky.Kkw.Kks.activity.getResources().getDimensionPixelOffset(a.c.bottomsheet_list_icon_width), true, false)));
                  j.10.1.1.this.Kkx.ihf();
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
    for (Object localObject = new BitmapDrawable(BitmapUtil.extractThumbNail(BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() / 2.0F, false), this.Kky.Kkw.Kks.activity.getResources().getDimensionPixelOffset(a.c.bottomsheet_list_icon_width), this.Kky.Kkw.Kks.activity.getResources().getDimensionPixelOffset(a.c.bottomsheet_list_icon_width), true, false));; localObject = null)
    {
      if (localObject == null) {
        j.e(this.Kky.Kkw.Kks).put(localti.Kmn, Integer.valueOf(i));
      }
      params.a(i, localti.nickname, (Drawable)localObject, 0);
      i += 1;
      break;
      AppMethodBeat.o(56157);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.10.1.1
 * JD-Core Version:    0.7.0.1
 */