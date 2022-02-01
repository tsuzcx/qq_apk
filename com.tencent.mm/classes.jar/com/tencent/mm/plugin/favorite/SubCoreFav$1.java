package com.tencent.mm.plugin.favorite;

import android.content.Context;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hp;
import com.tencent.mm.autogen.a.hp.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

class SubCoreFav$1
  extends IListener<hp>
{
  SubCoreFav$1(f paramf, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(261352);
    this.__eventId = hp.class.getName().hashCode();
    AppMethodBeat.o(261352);
  }
  
  private static boolean a(hp paramhp)
  {
    AppMethodBeat.i(24611);
    Object localObject1;
    Object localObject2;
    if ((paramhp.hIF.hII != null) && ((paramhp.hIF.hII instanceof o.a)) && (paramhp.hIF.hAh != null) && ((paramhp.hIF.hAh instanceof Context)))
    {
      localObject1 = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(paramhp.hIF.hDn);
      localObject2 = paramhp.hIF.hIG;
      if ((Util.isNullOrNil((String)localObject2)) || (((localObject1 == null) || (((g)localObject1).field_type != 18)) && (((g)localObject1).field_type != 14))) {
        break label485;
      }
    }
    for (;;)
    {
      try
      {
        LinkedList localLinkedList = ((g)localObject1).field_favProto.vEn;
        if (((g)localObject1).field_type != 18) {
          break label501;
        }
        i = 1;
        if (i >= localLinkedList.size()) {
          break label495;
        }
        Object localObject3 = (arf)localLinkedList.get(i);
        if (((String)localObject2).startsWith(((arf)localObject3).hIQ))
        {
          localObject2 = ((g)localObject1).dQt();
          ((g)localObject2).field_type = paramhp.hIF.hIH;
          ((g)localObject2).Acq = true;
          ((g)localObject2).Acr = ((g)localObject1);
          ((g)localObject2).hIG = (((g)localObject1).field_localId + "_" + ((arf)localObject3).hIQ);
          ((g)localObject2).field_favProto = c.c(((g)localObject1).field_favProto);
          ((g)localObject2).field_favProto.vEn = new LinkedList();
          ((g)localObject2).field_favProto.vEn.add(localObject3);
          ((g)localObject2).field_favProto.btm(((arf)localObject3).title);
          if (((arf)localObject3).Zzy != null)
          {
            if (paramhp.hIF.hIH == 6) {
              ((g)localObject2).field_favProto.d(((arf)localObject3).Zzy.ZAh);
            }
          }
          else
          {
            localObject1 = localObject2;
            if ((localObject1 != null) || (Util.isNullOrNil(paramhp.hIF.hIJ))) {
              break label498;
            }
            localObject1 = b.atV(paramhp.hIF.hIJ);
            localObject2 = (o.a)paramhp.hIF.hII;
            localObject3 = (Context)paramhp.hIF.hAh;
            d.a((o.a)localObject2, (Context)localObject3, (g)localObject1);
            d.b((o.a)localObject2, (Context)localObject3, (g)localObject1);
            paramhp.hIF.hDn = 0L;
            paramhp.hIF.hIG = "";
            paramhp.hIF.hII = null;
            paramhp.hIF.hAh = null;
            AppMethodBeat.o(24611);
            return false;
          }
          if (paramhp.hIF.hIH != 5) {
            continue;
          }
          ((g)localObject2).field_favProto.c(((arf)localObject3).Zzy.ZAj);
          continue;
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Fav.SubCoreFav", "FavInitConfirmDialogContentEvent callback : %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
      label485:
      i += 1;
      continue;
      label495:
      continue;
      label498:
      continue;
      label501:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.SubCoreFav.1
 * JD-Core Version:    0.7.0.1
 */