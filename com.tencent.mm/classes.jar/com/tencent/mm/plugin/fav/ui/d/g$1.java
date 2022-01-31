package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.j;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74628);
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      t.ii(this.mDf.mvC.context);
      AppMethodBeat.o(74628);
      return;
    }
    Object localObject;
    acw localacw;
    aca localaca;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.fav.a.g))
    {
      localObject = (com.tencent.mm.plugin.fav.a.g)paramView.getTag();
      localacw = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.wVa;
      localaca = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
      if (localaca == null)
      {
        ab.w("MicroMsg.FavBaseListItem", "data item is null");
        AppMethodBeat.o(74628);
        return;
      }
      if (com.tencent.mm.plugin.fav.a.b.e(localaca))
      {
        ab.i("MicroMsg.FavBaseListItem", "same song, do release");
        a.aiu();
        g.a(this.mDf, null);
        AppMethodBeat.o(74628);
        return;
      }
      localObject = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(localaca));
      if (((com.tencent.mm.vfs.b)localObject).exists()) {
        break label271;
      }
      if (localaca.cpH != null) {
        break label209;
      }
      localObject = "";
    }
    for (;;)
    {
      a.b(com.tencent.mm.aw.f.a(6, null, localaca.title, localaca.desc, localaca.wSJ, localaca.wSN, localaca.wSL, localaca.mBq, com.tencent.mm.plugin.fav.a.b.bwd(), (String)localObject, "", localacw.appId));
      g.a(this.mDf, (ImageView)paramView);
      AppMethodBeat.o(74628);
      return;
      label209:
      localObject = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.bvW() + com.tencent.mm.a.g.w(localaca.cpH.getBytes()));
      if (((com.tencent.mm.vfs.b)localObject).exists()) {}
      for (localObject = j.p(((com.tencent.mm.vfs.b)localObject).dQJ());; localObject = "") {
        break;
      }
      label271:
      localObject = j.p(((com.tencent.mm.vfs.b)localObject).dQJ());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.g.1
 * JD-Core Version:    0.7.0.1
 */