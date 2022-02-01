package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.fav.a.an.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class l$2
  implements an.a
{
  public l$2(g paramg, Context paramContext, Runnable paramRunnable) {}
  
  public final void d(SparseArray<String> paramSparseArray)
  {
    AppMethodBeat.i(106888);
    String str1 = (String)paramSparseArray.get(this.qIa.field_id);
    ac.d("MicroMsg.FavSendLogic", "on finish, favid %d, url %s", new Object[] { Integer.valueOf(this.qIa.field_id), str1 });
    if (!bs.isNullOrNil(str1))
    {
      if (4 != this.qIa.field_type) {
        break label235;
      }
      Object localObject = b.c(this.qIa);
      String str2 = bs.bG(((agx)localObject).title, this.val$context.getString(2131759030));
      paramSparseArray = new Intent();
      paramSparseArray.putExtra("Ksnsupload_link", str1);
      paramSparseArray.putExtra("Ksnsupload_title", str2);
      paramSparseArray.putExtra("Ksnsupload_imgbuf", i.aU(b.a((agx)localObject), 0, -1));
      b.w(paramSparseArray, this.val$context);
      str1 = "fav_" + u.axw() + "_" + this.qIa.field_id;
      localObject = y.xJ(str1);
      y.ayq().F((String)localObject, true).l("prePublishId", str1);
      paramSparseArray.putExtra("reportSessionId", (String)localObject);
      h.i(this.qIa.field_localId, 0, 0);
    }
    for (;;)
    {
      if (this.val$callback != null) {
        ap.f(this.val$callback);
      }
      AppMethodBeat.o(106888);
      return;
      label235:
      ac.w("MicroMsg.FavSendLogic", "unknown type %d, fav id %d", new Object[] { Integer.valueOf(this.qIa.field_type), Integer.valueOf(this.qIa.field_id) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l.2
 * JD-Core Version:    0.7.0.1
 */