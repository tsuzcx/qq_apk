package com.tencent.mm.bb;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements h
{
  SparseArray<LinkedList<h.a>> iig;
  
  public a()
  {
    AppMethodBeat.i(116837);
    this.iig = new SparseArray();
    AppMethodBeat.o(116837);
  }
  
  public final void a(int paramInt, h.a parama)
  {
    AppMethodBeat.i(116839);
    if (this.iig.indexOfKey(paramInt) < 0) {
      this.iig.put(paramInt, new LinkedList());
    }
    ((LinkedList)this.iig.get(paramInt)).add(parama);
    AppMethodBeat.o(116839);
  }
  
  public final void a(final k.b paramb)
  {
    AppMethodBeat.i(116838);
    if ((g.ajB().gAO == null) || (g.ajB().gAO.hOv == null))
    {
      AppMethodBeat.o(116838);
      return;
    }
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramb);
    localObject = new b((List)localObject);
    g.ajD();
    ((b)localObject).doScene(g.ajB().gAO.hOv, new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        paramAnonymousInt1 = -1;
        AppMethodBeat.i(116836);
        if (paramAnonymousn.getType() != 681)
        {
          AppMethodBeat.o(116836);
          return;
        }
        if (((b)paramAnonymousn).iij == null)
        {
          AppMethodBeat.o(116836);
          return;
        }
        ((b)paramAnonymousn).iij.getReqObjImp();
        paramAnonymousString = ((b.c)((b)paramAnonymousn).iij.getRespObj()).iio;
        paramAnonymousInt2 = ((zu)((b.b)((b)paramAnonymousn).iij.getReqObj()).iin.GWT.nDj.getLast()).FYU;
        if ((paramAnonymousString == null) || (paramAnonymousString.GZB == null) || (paramAnonymousString.GZB.GtN == null))
        {
          paramAnonymousString = (List)a.this.iig.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext()) {
              ((h.a)paramAnonymousString.next()).a(-1, new cgk(), paramb);
            }
          }
          AppMethodBeat.o(116836);
          return;
        }
        if (paramAnonymousString.GZB.GtN.size() > 0) {
          paramAnonymousInt1 = ((Integer)paramAnonymousString.GZB.GtN.getLast()).intValue();
        }
        if (paramAnonymousString.GZB.GZC.size() > 0) {}
        for (paramAnonymousString = (cgk)paramAnonymousString.GZB.GZC.getLast();; paramAnonymousString = new cgk())
        {
          paramAnonymousn = (List)a.this.iig.get(paramAnonymousInt2);
          if (paramAnonymousn == null) {
            break;
          }
          paramAnonymousn = paramAnonymousn.iterator();
          while (paramAnonymousn.hasNext()) {
            ((h.a)paramAnonymousn.next()).a(paramAnonymousInt1, paramAnonymousString, paramb);
          }
        }
        AppMethodBeat.o(116836);
      }
    });
    AppMethodBeat.o(116838);
  }
  
  public final void b(int paramInt, h.a parama)
  {
    AppMethodBeat.i(116840);
    if (this.iig.indexOfKey(paramInt) >= 0) {
      ((LinkedList)this.iig.get(paramInt)).remove(parama);
    }
    AppMethodBeat.o(116840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.a
 * JD-Core Version:    0.7.0.1
 */