package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class h$3
  implements f.b
{
  h$3(h paramh) {}
  
  public final void a(boolean paramBoolean, f.c paramc, int paramInt)
  {
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if ((paramBoolean) && (e.a.aRT().khB.size() >= 9))
    {
      Toast.makeText(this.kij.mContext, this.kij.mContext.getResources().getString(n.i.fav_filter_gallery_select_limit, new Object[] { Integer.valueOf(9) }), 1).show();
      this.kij.kie.bL(paramInt);
      return;
    }
    e locale;
    if (paramBoolean)
    {
      locale = e.a.aRT();
      paramc = paramc.khL;
      if (paramc != null)
      {
        y.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramc });
        locale.khB.remove(paramc);
        locale.khB.remove(locale.Dc(paramc.bNH.kgC));
        locale.khB.add(paramc);
        locale.aRS();
      }
    }
    for (;;)
    {
      this.kij.kid.re(e.a.aRT().khB.size());
      return;
      locale = e.a.aRT();
      paramc = paramc.khL;
      if (paramc != null)
      {
        y.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramc.bNH.kgC });
        locale.khB.remove(paramc);
        locale.khB.remove(locale.Dc(paramc.bNH.kgC));
        locale.aRS();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h.3
 * JD-Core Version:    0.7.0.1
 */