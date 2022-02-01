package com.tencent.mm.bb;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.a.g
{
  SparseArray<LinkedList<g.a>> hop;
  
  public a()
  {
    AppMethodBeat.i(116837);
    this.hop = new SparseArray();
    AppMethodBeat.o(116837);
  }
  
  public final void a(int paramInt, g.a parama)
  {
    AppMethodBeat.i(116839);
    if (this.hop.indexOfKey(paramInt) < 0) {
      this.hop.put(paramInt, new LinkedList());
    }
    ((LinkedList)this.hop.get(paramInt)).add(parama);
    AppMethodBeat.o(116839);
  }
  
  public final void a(final j.b paramb)
  {
    AppMethodBeat.i(116838);
    if ((com.tencent.mm.kernel.g.afA().gcy == null) || (com.tencent.mm.kernel.g.afA().gcy.gVH == null))
    {
      AppMethodBeat.o(116838);
      return;
    }
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramb);
    localObject = new b((List)localObject);
    com.tencent.mm.kernel.g.afC();
    ((b)localObject).doScene(com.tencent.mm.kernel.g.afA().gcy.gVH, new com.tencent.mm.al.g()
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
        if (((b)paramAnonymousn).hos == null)
        {
          AppMethodBeat.o(116836);
          return;
        }
        ((b)paramAnonymousn).hos.getReqObjImp();
        paramAnonymousString = ((b.c)((b)paramAnonymousn).hos.getRespObj()).hox;
        paramAnonymousInt2 = ((xd)((b.b)((b)paramAnonymousn).hos.getReqObj()).how.DQS.mAL.getLast()).CYY;
        if ((paramAnonymousString == null) || (paramAnonymousString.DTv == null) || (paramAnonymousString.DTv.DpH == null))
        {
          paramAnonymousString = (List)a.this.hop.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext()) {
              ((g.a)paramAnonymousString.next()).a(-1, paramb);
            }
          }
          AppMethodBeat.o(116836);
          return;
        }
        if (paramAnonymousString.DTv.DpH.size() > 0) {
          paramAnonymousInt1 = ((Integer)paramAnonymousString.DTv.DpH.getLast()).intValue();
        }
        if (paramAnonymousString.DTv.DTw.size() > 0) {
          paramAnonymousString.DTv.DTw.getLast();
        }
        if (paramAnonymousString.DTv.DTw.size() > 0) {
          paramAnonymousString.DTv.DTw.getLast();
        }
        paramAnonymousString = (List)a.this.hop.get(paramAnonymousInt2);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.iterator();
          while (paramAnonymousString.hasNext()) {
            ((g.a)paramAnonymousString.next()).a(paramAnonymousInt1, paramb);
          }
        }
        AppMethodBeat.o(116836);
      }
    });
    AppMethodBeat.o(116838);
  }
  
  public final void b(int paramInt, g.a parama)
  {
    AppMethodBeat.i(116840);
    if (this.hop.indexOfKey(paramInt) >= 0) {
      ((LinkedList)this.hop.get(paramInt)).remove(parama);
    }
    AppMethodBeat.o(116840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.a
 * JD-Core Version:    0.7.0.1
 */