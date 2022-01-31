package com.tencent.mm.plugin.game.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

final class GameIndexListView$2
  implements w.a
{
  GameIndexListView$2(GameIndexListView paramGameIndexListView) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(111970);
    ab.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      GameIndexListView.a(this.nzP, (bc)paramb.fsW.fta);
      paramb = GameIndexListView.b(this.nzP);
      bool = GameIndexListView.c(this.nzP);
      if ((paramb != null) && (!bo.es(paramb.nsC))) {
        break label177;
      }
      paramString = null;
    }
    for (;;)
    {
      GameIndexListView.d(this.nzP);
      com.tencent.mm.plugin.game.model.ad.a(GameIndexListView.b(this.nzP));
      if (!GameIndexListView.b(this.nzP).nsE) {
        this.nzP.fv(false);
      }
      if (!bo.es(paramString))
      {
        paramb = GameIndexListView.e(this.nzP);
        paramb.nzQ.addAll(paramString);
        paramb.ajb.notifyChanged();
      }
      AppMethodBeat.o(111970);
      return 0;
      label177:
      paramString = new LinkedList();
      if ((bool) && (!bo.isNullOrNil(paramb.nqu)))
      {
        paramm = new d();
        paramm.type = 2000;
        paramm.nmq = paramb.nqu;
        paramString.add(paramm);
      }
      paramb = paramb.nsC.iterator();
      while (paramb.hasNext())
      {
        paramm = (com.tencent.mm.plugin.game.d.ad)paramb.next();
        Object localObject;
        if (paramm.nqy == 7)
        {
          if ((paramm.nro != null) && (!bo.es(paramm.nro.nqs)))
          {
            if (!bo.isNullOrNil(paramm.nro.Title))
            {
              localObject = new d();
              ((d)localObject).nmr = paramm;
              ((d)localObject).type = 1000;
              paramString.add(localObject);
            }
            localObject = paramm.nro.nqs.iterator();
            while (((Iterator)localObject).hasNext())
            {
              y localy = (y)((Iterator)localObject).next();
              d locald = new d();
              locald.nmr = paramm;
              locald.type = 1001;
              locald.nms = paramm.nro.nqs.indexOf(localy);
              paramString.add(locald);
            }
            localObject = new d();
            ((d)localObject).nmr = paramm;
            ((d)localObject).type = 1002;
            paramString.add(localObject);
          }
        }
        else
        {
          localObject = new d();
          ((d)localObject).type = paramm.nqy;
          ((d)localObject).position = paramm.nqv;
          ((d)localObject).nmr = paramm;
          paramString.add(localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView.2
 * JD-Core Version:    0.7.0.1
 */