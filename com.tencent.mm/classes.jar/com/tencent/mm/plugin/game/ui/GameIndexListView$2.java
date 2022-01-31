package com.tencent.mm.plugin.game.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.x;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class GameIndexListView$2
  implements w.a
{
  GameIndexListView$2(GameIndexListView paramGameIndexListView) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      GameIndexListView.a(this.lbU, (bb)paramb.ecF.ecN);
      paramb = GameIndexListView.b(this.lbU);
      bool = GameIndexListView.c(this.lbU);
      if ((paramb != null) && (!bk.dk(paramb.kUA))) {
        break label167;
      }
      paramString = null;
    }
    for (;;)
    {
      GameIndexListView.d(this.lbU);
      ae.a(GameIndexListView.b(this.lbU));
      if (!GameIndexListView.b(this.lbU).kUC) {
        this.lbU.dZ(false);
      }
      if (!bk.dk(paramString))
      {
        paramb = GameIndexListView.e(this.lbU);
        paramb.lbV.addAll(paramString);
        paramb.agL.notifyChanged();
      }
      return 0;
      label167:
      paramString = new LinkedList();
      if ((bool) && (!bk.bl(paramb.kSt)))
      {
        paramm = new e();
        paramm.type = 2000;
        paramm.kOt = paramb.kSt;
        paramString.add(paramm);
      }
      paramb = paramb.kUA.iterator();
      while (paramb.hasNext())
      {
        paramm = (ac)paramb.next();
        Object localObject;
        if (paramm.kSx == 7)
        {
          if ((paramm.kTo != null) && (!bk.dk(paramm.kTo.kSr)))
          {
            if (!bk.bl(paramm.kTo.bGw))
            {
              localObject = new e();
              ((e)localObject).kOu = paramm;
              ((e)localObject).type = 1000;
              paramString.add(localObject);
            }
            localObject = paramm.kTo.kSr.iterator();
            while (((Iterator)localObject).hasNext())
            {
              x localx = (x)((Iterator)localObject).next();
              e locale = new e();
              locale.kOu = paramm;
              locale.type = 1001;
              locale.kOv = paramm.kTo.kSr.indexOf(localx);
              paramString.add(locale);
            }
            localObject = new e();
            ((e)localObject).kOu = paramm;
            ((e)localObject).type = 1002;
            paramString.add(localObject);
          }
        }
        else
        {
          localObject = new e();
          ((e)localObject).type = paramm.kSx;
          ((e)localObject).position = paramm.kSu;
          ((e)localObject).kOu = paramm;
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