package com.tencent.mm.ba;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements h
{
  SparseArray<LinkedList<h.a>> jfY;
  
  public a()
  {
    AppMethodBeat.i(116837);
    this.jfY = new SparseArray();
    AppMethodBeat.o(116837);
  }
  
  public final void a(int paramInt, h.a parama)
  {
    AppMethodBeat.i(116839);
    if (this.jfY.indexOfKey(paramInt) < 0) {
      this.jfY.put(paramInt, new LinkedList());
    }
    ((LinkedList)this.jfY.get(paramInt)).add(parama);
    AppMethodBeat.o(116839);
  }
  
  public final void b(int paramInt, h.a parama)
  {
    AppMethodBeat.i(116840);
    if (this.jfY.indexOfKey(paramInt) >= 0) {
      ((LinkedList)this.jfY.get(paramInt)).remove(parama);
    }
    AppMethodBeat.o(116840);
  }
  
  public final void b(final k.b paramb)
  {
    AppMethodBeat.i(116838);
    if ((g.aAg().hqi == null) || (g.aAg().hqi.iMw == null))
    {
      AppMethodBeat.o(116838);
      return;
    }
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramb);
    localObject = new b((List)localObject);
    g.aAi();
    ((b)localObject).doScene(g.aAg().hqi.iMw, new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        paramAnonymousInt1 = -1;
        AppMethodBeat.i(116836);
        if (paramAnonymousq.getType() != 681)
        {
          AppMethodBeat.o(116836);
          return;
        }
        if (((b)paramAnonymousq).jgb == null)
        {
          AppMethodBeat.o(116836);
          return;
        }
        ((b)paramAnonymousq).jgb.getReqObjImp();
        paramAnonymousString = ((b.c)((b)paramAnonymousq).jgb.getRespObj()).jgg;
        paramAnonymousInt2 = ((abn)((b.b)((b)paramAnonymousq).jgb.getReqObj()).jgf.MyZ.oTA.getLast()).Lms;
        if ((paramAnonymousString == null) || (paramAnonymousString.MBY == null) || (paramAnonymousString.MBY.LRr == null))
        {
          paramAnonymousString = (List)a.this.jfY.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext()) {
              ((h.a)paramAnonymousString.next()).a(-1, new cxl(), paramb);
            }
          }
          AppMethodBeat.o(116836);
          return;
        }
        if (paramAnonymousString.MBY.LRr.size() > 0) {
          paramAnonymousInt1 = ((Integer)paramAnonymousString.MBY.LRr.getLast()).intValue();
        }
        if (paramAnonymousString.MBY.MBZ.size() > 0) {}
        for (paramAnonymousString = (cxl)paramAnonymousString.MBY.MBZ.getLast();; paramAnonymousString = new cxl())
        {
          paramAnonymousq = (List)a.this.jfY.get(paramAnonymousInt2);
          if (paramAnonymousq == null) {
            break;
          }
          paramAnonymousq = paramAnonymousq.iterator();
          while (paramAnonymousq.hasNext()) {
            ((h.a)paramAnonymousq.next()).a(paramAnonymousInt1, paramAnonymousString, paramb);
          }
        }
        AppMethodBeat.o(116836);
      }
    });
    AppMethodBeat.o(116838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.a
 * JD-Core Version:    0.7.0.1
 */