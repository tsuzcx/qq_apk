package com.tencent.mm.ba;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements h
{
  SparseArray<LinkedList<h.a>> ikZ;
  
  public a()
  {
    AppMethodBeat.i(116837);
    this.ikZ = new SparseArray();
    AppMethodBeat.o(116837);
  }
  
  public final void a(int paramInt, h.a parama)
  {
    AppMethodBeat.i(116839);
    if (this.ikZ.indexOfKey(paramInt) < 0) {
      this.ikZ.put(paramInt, new LinkedList());
    }
    ((LinkedList)this.ikZ.get(paramInt)).add(parama);
    AppMethodBeat.o(116839);
  }
  
  public final void b(int paramInt, h.a parama)
  {
    AppMethodBeat.i(116840);
    if (this.ikZ.indexOfKey(paramInt) >= 0) {
      ((LinkedList)this.ikZ.get(paramInt)).remove(parama);
    }
    AppMethodBeat.o(116840);
  }
  
  public final void b(final k.b paramb)
  {
    AppMethodBeat.i(116838);
    if ((g.ajQ().gDv == null) || (g.ajQ().gDv.hRo == null))
    {
      AppMethodBeat.o(116838);
      return;
    }
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramb);
    localObject = new b((List)localObject);
    g.ajS();
    ((b)localObject).doScene(g.ajQ().gDv.hRo, new f()
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
        if (((b)paramAnonymousn).ilc == null)
        {
          AppMethodBeat.o(116836);
          return;
        }
        ((b)paramAnonymousn).ilc.getReqObjImp();
        paramAnonymousString = ((b.c)((b)paramAnonymousn).ilc.getRespObj()).ilh;
        paramAnonymousInt2 = ((zx)((b.b)((b)paramAnonymousn).ilc.getReqObj()).ilg.Hqt.nIE.getLast()).Gru;
        if ((paramAnonymousString == null) || (paramAnonymousString.Htc == null) || (paramAnonymousString.Htc.GNm == null))
        {
          paramAnonymousString = (List)a.this.ikZ.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext()) {
              ((h.a)paramAnonymousString.next()).a(-1, new che(), paramb);
            }
          }
          AppMethodBeat.o(116836);
          return;
        }
        if (paramAnonymousString.Htc.GNm.size() > 0) {
          paramAnonymousInt1 = ((Integer)paramAnonymousString.Htc.GNm.getLast()).intValue();
        }
        if (paramAnonymousString.Htc.Htd.size() > 0) {}
        for (paramAnonymousString = (che)paramAnonymousString.Htc.Htd.getLast();; paramAnonymousString = new che())
        {
          paramAnonymousn = (List)a.this.ikZ.get(paramAnonymousInt2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.a
 * JD-Core Version:    0.7.0.1
 */