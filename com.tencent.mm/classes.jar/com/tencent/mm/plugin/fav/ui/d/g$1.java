package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.av.a;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vfs.j;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    if (!com.tencent.mm.compatible.util.f.zF()) {
      s.gM(this.kiA.kbg.context);
    }
    while (!(paramView.getTag() instanceof com.tencent.mm.plugin.fav.a.g)) {
      return;
    }
    Object localObject = (com.tencent.mm.plugin.fav.a.g)paramView.getTag();
    yp localyp = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.sXa;
    xv localxv = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
    if (localxv == null)
    {
      y.w("MicroMsg.FavBaseListItem", "data item is null");
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.e(localxv))
    {
      y.i("MicroMsg.FavBaseListItem", "same song, do release");
      a.Ps();
      g.a(this.kiA, null);
      return;
    }
    localObject = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localxv));
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      if (localxv.bIm == null) {
        localObject = "";
      }
    }
    for (;;)
    {
      a.b(com.tencent.mm.av.f.a(6, null, localxv.title, localxv.desc, localxv.sUN, localxv.sUR, localxv.sUP, localxv.kgC, com.tencent.mm.plugin.fav.a.b.aPP(), (String)localObject, "", localyp.appId));
      g.a(this.kiA, (ImageView)paramView);
      return;
      localObject = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aPI() + com.tencent.mm.a.g.o(localxv.bIm.getBytes()));
      if (((com.tencent.mm.vfs.b)localObject).exists()) {}
      for (localObject = j.n(((com.tencent.mm.vfs.b)localObject).cLr());; localObject = "") {
        break;
      }
      localObject = j.n(((com.tencent.mm.vfs.b)localObject).cLr());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.g.1
 * JD-Core Version:    0.7.0.1
 */